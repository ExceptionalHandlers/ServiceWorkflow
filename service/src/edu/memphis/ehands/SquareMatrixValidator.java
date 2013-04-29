package edu.memphis.ehands;

import javax.jws.WebMethod;
import javax.jws.WebService;

import edu.memphis.ehands.data.Matrix;

@WebService public class SquareMatrixValidator {

    @WebMethod public boolean validateMatrix(Matrix matrix) {
        int rows = matrix.data.length;

        for (int i = 0; i < rows; i++) {
            if (matrix.data[i].length != rows) {
                return false;
            }
        }

        return true;
    }

}
