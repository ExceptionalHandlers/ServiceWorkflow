package edu.memphis.ehands.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import edu.memphis.ehands.DecomposedMatrix;
import edu.memphis.ehands.DeterminantCalcService;
import edu.memphis.ehands.Matrix;
import edu.memphis.ehands.model.DService;

@WebServlet(name = "Servlet")
public class WorkflowServlet extends HttpServlet {

    DService ws[] = new DService[]{
            new DService("SquareMatrixValidator", "string", "matrix"),
            new DService("LUDecomposer", "matrix", "decomposed"),
            new DService("DeterminantCalc", "decomposed", "double")
    };

    protected void doPost(HttpServletRequest request,
            HttpServletResponse response)
            throws ServletException, IOException {

        String workflowlist = request.getParameter("workflowlist");
        response.getWriter().println(workflowlist);
        String[] split = workflowlist.toString().split(",");

        Object foo = null;

        String matrix = request.getParameter("matrix");
        if (matrix != null && !matrix.isEmpty()) {
            System.out.println("using custom matrix: " + matrix);
            foo = matrix;
        } else {
            foo = (String) "3,8|4,6";
        }
        for (String service : split) {
            foo = runService(foo, service);
        }
        // if all goes well... this should be our determinant
        try {
            Double determinant = Math.abs((Double) foo);
            if (determinant == null) {
                response.getWriter().println("null det");
            } else {
                request.setAttribute("determinant",
                        Math.abs(Double.valueOf(determinant.toString())));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        doGet(request, response);
    }

    protected void doGet(HttpServletRequest request,
            HttpServletResponse response)
            throws ServletException, IOException {

        ArrayList<DService> wslist = new ArrayList<DService>();
        for (DService w : ws) {
            wslist.add(w);
        }

        request.setAttribute("ws_list", (List<DService>) wslist);
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("workflow.jsp");
        requestDispatcher.forward(request, response);
    }

    public Object runService(Object input, String service) {
        for (int i = 0; i < ws.length; i++) {
            if (ws[i].name.equalsIgnoreCase(service)) {
                return runService(input, ws[i]);
            }
        }
        return null;
    }

    // weak binding sort of
    public Object runService(Object input, DService service) {
        if (service.name.equals("SquareMatrixValidator")) {
            return new edu.memphis.ehands.SquareMatrixValidatorService()
                    .getSquareMatrixValidatorPort().validate((String) input);
        } else if (service.name.equals("LUDecomposer")) {
            return new edu.memphis.ehands.LUDecomposerService()
                    .getLUDecomposerPort().decompose((Matrix) input);
        } else if (service.name.equals("DeterminantCalc")) {
            return Double
                    .valueOf(new DeterminantCalcService().getDeterminantCalcPort().calculateDet(
                            (DecomposedMatrix) input));
        }
        return null;
    }

}
