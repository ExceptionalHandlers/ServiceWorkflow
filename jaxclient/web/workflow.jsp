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
            $("#pipeline").css("width", (length) * 160);
        }

        function log(ob) {
            //$(".debug").text(ob);
        }

        function submitWorkflow() {
            var stringlist = "";

            for(var i = 0; i < pipe.length; i++) {
                stringlist += pipe[i].name + ",";
            }
            $.post("<%=baseURL%>/workflow", { workflowlist: stringlist });
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
        })
        ;
    </script>
    <title></title>
</head>
<body>
<div class="debug"></div>
<div id="container">
    <div id="left">
        <div id="services">
            <div class="webservice draggable" id="ws1">SquareMatrixValidator</div>
            <div class="webservice draggable" id="ws2">RowReducer</div>
            <div class="webservice draggable" id="ws3">DeterminantCalc</div>
        </div>
    </div>
    <div id="right">
        <div id='pipeline'>
            <div id="snap">&nbsp;</div>
        </div>

        <button onclick="submitWorkflow()">Submit workflow</button>
    </div>
</div>
</body>
</html>
