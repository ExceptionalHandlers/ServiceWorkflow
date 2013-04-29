package edu.memphis.ehands;

import javax.jws.WebMethod;
import javax.jws.WebService;

@WebService public class SquareMatrixValidator {

    @WebMethod public Matrix validate(double[][] matrix) {
        Matrix m = new Matrix();
        m.setData(matrix);
        return m;
    }

    private Matrix validate(String matrix) {
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
            System.out.println(rows[i]);
            String[] row = rows[i].split(",");
            for (int j = 0; j < row.length; j++) {
                System.out.print(row[j] + "\t");
                d[i][j] = Double.valueOf(row[j]);
            }
            System.out.print("\n");
        }

        Matrix matrix1 = new Matrix();
        matrix1.setData(d);
        return matrix1;
    }

}
