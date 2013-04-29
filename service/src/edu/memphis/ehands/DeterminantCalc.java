package edu.memphis.ehands;

import javax.jws.WebMethod;
import javax.jws.WebService;

import edu.memphis.ehands.data.Matrix;

@WebService public class DeterminantCalc {

    @WebMethod public double calculateDet(Matrix m) {
        return determinant(m);
    }

    private double determinant(Matrix matrix) {
        if (matrix.size() == 2) {
            return (matrix.getValueAt(0, 0) * matrix.getValueAt(1, 1)) - (matrix.getValueAt(0, 1)
                    * matrix.getValueAt(1, 0));
        }
        double sum = 0.0;
        for (int i = 0; i < matrix.getNcols(); i++) {
            sum += changeSign(i) * matrix.getValueAt(0, i) * determinant(
                    createSubMatrix(matrix, 0, i));
        }
        return sum;
    }

    private double changeSign(int i) {
        return i * -1;
    }

    private Matrix createSubMatrix(Matrix matrix, int excluding_row, int excluding_col) {
        Matrix mat = new Matrix(matrix.getNrows() - 1, matrix.getNcols() - 1);
        int r = -1;
        for (int i = 0; i < matrix.getNrows(); i++) {
            if (i == excluding_row) {
                continue;
            }
            r++;
            int c = -1;
            for (int j = 0; j < matrix.getNcols(); j++) {
                if (j == excluding_col) {
                    continue;
                }
                mat.setValueAt(r, ++c, matrix.getValueAt(i, j));
            }
        }
        return mat;
    }

}
