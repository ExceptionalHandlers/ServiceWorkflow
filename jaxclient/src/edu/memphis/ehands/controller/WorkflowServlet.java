package edu.memphis.ehands.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import edu.memphis.ehands.DecomposedMatrix;
import edu.memphis.ehands.DeterminantCalcService;
import edu.memphis.ehands.Matrix;

@WebServlet(name = "Servlet")
public class WorkflowServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request,
            HttpServletResponse response)
            throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request,
            HttpServletResponse response)
            throws ServletException, IOException {

        DService ws[] = new DService[]{
                new DService("ws1", "null", "matrix"),
                new DService("ws2", "matrix", "decomposed")
        };

        RequestDispatcher requestDispatcher = request.getRequestDispatcher("workflow.jsp");
        requestDispatcher.forward(request, response);
    }

    // weak binding sort of
    public Object runService(Object input, DService service) {
        if (service.name.equals("ws1")) {
            return new edu.memphis.ehands.SquareMatrixValidatorService()
                    .getSquareMatrixValidatorPort().validate((String) input);
        } else if (service.name.equals("ws2")) {
            return new edu.memphis.ehands.LUDecomposerService()
                    .getLUDecomposerPort().decompose((Matrix) input);
        } else if (service.name.equals("ws3")) {
            return Double
                    .valueOf(new DeterminantCalcService().getDeterminantCalcPort().calculateDet(
                            (DecomposedMatrix) input));
        }
        return null;
    }

    class DService {
        String name;
        String input;
        String output;

        protected DService(String name, String input, String output) {
            this.name = name;
            this.input = input;
            this.output = output;
        }
    }
}
