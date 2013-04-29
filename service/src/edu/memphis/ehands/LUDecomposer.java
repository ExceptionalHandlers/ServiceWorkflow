package edu.memphis.ehands;

import javax.jws.WebMethod;
import javax.jws.WebService;

@WebService public class LUDecomposer {

    @WebMethod public DecomposedMatrix decompose(Matrix A) {
        DecomposedMatrix m = new DecomposedMatrix();

        int[] piv;

        m.LU = copy(A);
        m.m = A.getData().length;
        m.n = A.getData()[0].length;

        piv = new int[m.m];
        for (int i = 0; i < m.m; i++) {
            piv[i] = i;
        }
        m.pivsign = 1;
        double[] LUrowi;
        double[] LUcolj = new double[m.m];

        System.out.println("outer enter");

        // Outer loop.

        for (int j = 0; j < m.n; j++) {

            // Make a copy of the j-th column to localize references.

            for (int i = 0; i < m.m; i++) {
                LUcolj[i] = m.LU[i][j];
            }

            // Apply previous transformations.

            for (int i = 0; i < m.m; i++) {
                LUrowi = m.LU[i];

                // Most of the time is spent in the following dot product.

                int kmax = Math.min(i, j);
                double s = 0.0;
                for (int k = 0; k < kmax; k++) {
                    s += LUrowi[k] * LUcolj[k];
                }

                LUrowi[j] = LUcolj[i] -= s;
            }

            // Find pivot and exchange if necessary.

            int p = j;
            for (int i = j + 1; i < m.m; i++) {
                if (Math.abs(LUcolj[i]) > Math.abs(LUcolj[p])) {
                    p = i;
                }
            }
            if (p != j) {
                for (int k = 0; k < m.n; k++) {
                    double t = m.LU[p][k];
                    m.LU[p][k] = m.LU[j][k];
                    m.LU[j][k] = t;
                }
                int k = piv[p];
                piv[p] = piv[j];
                piv[j] = k;
                m.pivsign = -m.pivsign;
            }

            // Compute multipliers.

            if (j < m.m & m.LU[j][j] != 0.0) {
                for (int i = j + 1; i < m.m; i++) {
                    m.LU[i][j] /= m.LU[j][j];
                }
            }
        }

        System.out.println("outer exit");



        return m;
    }

    private double[][] copy(Matrix a) {
        double[][] data = a.getData();
        double[][] cp = new double[data.length][data[0].length];
        for (int i = 0; i < data.length; i++) {
            for (int j = 0; j < data[i].length; j++) {
                cp[i][j] = data[i][j];
            }
        }
        return cp;
    }

}
