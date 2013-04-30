<%--
  Created by IntelliJ IDEA.
  User: roman
  Date: 4/15/13
  Time: 10:20 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>

    <%--<script type="text/javascript" src="js/jquery-1.9.1.js"></script>--%>
    <script type="text/javascript" src="js/jquery-2.0.0.js"></script>
    <script type="text/javascript" src="js/jquery-ui-1.10.2.custom.js"></script>
    <script type="text/javascript">
        $(function () {
            var ws = [
                {
                    name: "ws1",
                    input: null,
                    output: "matrix"
                },
                {
                    name: "ws2",
                    input: "matrix",
                    output: "matrix"
                },
                {
                    name: "ws3",
                    input: "matrix",
                    output: "double"
                }
            ];

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

            $(document).delegate('#textbox', 'keydown', function (e) {
                var keyCode = e.keyCode || e.which;

                if (keyCode == 9) {
                    e.preventDefault();
                    var start = $(this).get(0).selectionStart;
                    var end = $(this).get(0).selectionEnd;

                    // set textarea value to: text before caret + tab + text after caret
                    $(this).val($(this).val().substring(0, start)
                            + "\t"
                            + $(this).val().substring(end));

                    // put caret at right position again
                    $(this).get(0).selectionStart =
                            $(this).get(0).selectionEnd = start + 1;
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
                        visible = (dragging.input === null);
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
        });


    </script>
    <link rel="stylesheet" type="text/css" href="css/style.css">
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
    </div>

    <br>

    <form method="POST" action="/">

        <textarea id="textbox" rows="10" cols="50">

        </textarea>


        <input type="submit" name="submit" value="Register">

    </form>


</div>
</body>
</html>
