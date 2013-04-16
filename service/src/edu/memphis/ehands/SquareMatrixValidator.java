package edu.memphis.ehands;

import javax.jws.WebMethod;
import javax.jws.WebService;

@WebService public class SquareMatrixValidator {


    @WebMethod public boolean validateMatrix(double[][] matrix) {
        int rows = matrix.length;

        for (int i = 0; i < rows; i++) {
            if (matrix[i].length != rows) {
                return false;
            }
        }

        return true;
    }

}
