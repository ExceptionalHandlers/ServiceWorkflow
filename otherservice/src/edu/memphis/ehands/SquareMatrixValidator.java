package edu.memphis.ehands;

import javax.jws.WebMethod;
import javax.jws.WebService;

@WebService()
public class SquareMatrixValidator {

    private Matrix validate(double[][] matrix) {
        int rows = matrix.length;
        for (int i = 0; i < matrix.length; i++) {
            if (matrix[i].length != rows) {
                return null;
            }
        }

        Matrix m = new Matrix();
        m.setData(matrix);
        return m;
    }

    @WebMethod public Matrix validate(String matrix) {
        System.out.println("validating: " + matrix);
        if (matrix.isEmpty()) {
            System.out.println("NULL MATRIX INPUT");
            return null;
        }
        System.out.println(matrix);
        String[] rows = matrix.split("\\|");
        double[][] d;
        d = new double[rows.length][rows[0].split(",").length];
        for (int i = 0; i < rows.length; i++) {
            String[] row = rows[i].split(",");
            for (int j = 0; j < row.length; j++) {
                System.out.print(row[j] + "\t");
                d[i][j] = Double.valueOf(row[j]);
            }
            System.out.print("\n");
        }

        int rowCount = d.length;
        for (int i = 0; i < d.length; i++) {
            if (d[i].length != rowCount) {
                return null;
            }
        }

        Matrix matrix1 = new Matrix();
        matrix1.setData(d);
        return matrix1;
    }

}
