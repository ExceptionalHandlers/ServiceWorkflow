<%@ page import="java.util.List" %>
<%@ page import="edu.memphis.ehands.model.DService" %>
<%--
  Created by IntelliJ IDEA.
  User: roman
  Date: 4/15/13
  Time: 10:20 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    String baseURL;
    //  = request.getRequestURI().substring(0,
    //  request.getRequestURI().lastIndexOf("/"));
    //    String[] split = request.getRequestURL().toString().split("/");
    //    baseURL = split[0] + "//" + split[2] + "/";
    //    if (split.length >= 4) {
    //        baseURL += split[3];
    //    }
    baseURL = "http://localhost:8080/client";
%>
<html>
<head>

    <link rel="stylesheet" type="text/css" href="<%=baseURL%>/style.css">
    <script type="text/javascript" src="<%=baseURL%>/js/jquery-2.0.0.js"></script>
    <script type="text/javascript" src="<%=baseURL%>/js/jquery-ui-1.10.2.custom.js"></script>
    <script type="text/javascript">
        $(function () {
            var ws = [];

            <%
            List<DService> ws = (List<DService>) request.getAttribute("ws_list");
            for (int i = 0; i < ws.size(); i++) {
                DService service = ws.get(i);
                %>
            ws[<%=i%>] = {
                name: "<%=service.name%>",
                input: "<%=service.input%>",
                output: "<%=service.output%>"
            };
            <%}%>

            var pipe = [];
            var dragging;
            var globalSnap = false;

            for (i = 0; i < ws.length; i++) {
                initDraggable(ws[i], "#snap");
            }

            $("#pipeline").droppable({
                drop: function () {
                    if (!globalSnap) {
                        globalSnap = true;
                    } else {
                        $("#" + dragging.name).draggable("option", "revert", false);
                        pipe.push(dragging);
                        resizepipe(pipe.length + 1);
                    }
                    refreshArrows();
                    updateHiddenVar();
                }
            });

            function refreshArrows() {
                if (pipe.length > 1) {
                    for (var i = 0; i < pipe.length - 1; i++) {
                        $("#" + pipe[i].name).addClass("arrow-right");
                    }
                }
            }

            function changeSnap(obj, snapTo) {
                $(obj).draggable("option", "snap", snapTo);
                $(obj).draggable("option", "revert", snapTo === false ? true : false);
            }

            function refreshSnapTarget() {
                var visible;

                if (dragging === null) {
                    visible = true;
                } else {
                    if (pipe.length === 0) {
                        visible = (dragging.input === null) || (dragging.input == "string");
                    } else {
                        visible = (pipe[pipe.length - 1].output == dragging.input);
                    }
                    changeSnap("#" + dragging.name, visible === true ? "#snap" : false);
                }
                globalSnap = visible;
                log("updating visibility to: " + visible);
                $("#snap").css("display", visible === true ? "inline" : "none");
            }

            function resizepipe(length) {
                if (pipe.length === ws.length) {
                    length = pipe.length;
                }
                $("#pipeline").css("width", (length) * 164);
            }

            function log(ob) {
                //$(".debug").text(ob);
            }

            function initDraggable(object, snap_to) {
                $("#" + object.name).draggable({
                    snap: snap_to,
                    snapMode: "inner",
                    snapTolerance: 40,
                    revert: true,
                    start: function () {
                        dragging = object;
                        refreshSnapTarget();
                    },
                    stop: function () {
                        dragging = null;
                        refreshSnapTarget();
                        globalSnap = true; // reset
                    }
                });
            }

            function updateHiddenVar() {
                var stringlist = "";

                for (var i = 0; i < pipe.length; i++) {
                    stringlist += pipe[i].name + ",";
                }
                stringslist = stringlist.substr(0, stringlist.length - 1);

                $("#hiddenelement").val(stringlist);
            }

        });
    </script>
    <title>Workflow</title>
</head>
<body>
<a href="<%=baseURL%>/workflow">Workflow</a>
<div class="debug"></div>

<div id="container">
    <div id="left">
        <div id="services">
            <%
                for (DService service : ws) {
            %>
            <div class="webservice draggable" id="<%=service.name%>"><%=service.name%>
            </div>
            <%
                }
            %>
        </div>
    </div>
    <div id="right">
        <div id='pipeline'>
            <div id="snap">&nbsp;</div>
        </div>

    </div>

    <br/>
    <br/>
    <br style="clear: both;"/>

    <form name="input" action="<%=baseURL%>/workflow" method="post">
        <input type="text" name="matrix" id="matrix" value="3,8|4,6" />
        <input type="hidden" name="workflowlist" id="hiddenelement"/>
        <input type="submit" id="submitgo" value="Submit">
    </form>

    <br/>

    <div id="result">
        <% String det = (String) request.getAttribute("determinant");
            if (det == null || det.isEmpty()) {
                det = "Submit a workflow to see a result here";
            }
        %>

        <%=det%></div>

</div>

</body>
</html>
