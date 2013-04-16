package edu.memphis.ehands;

import com.sun.org.apache.bcel.internal.generic.LUSHR;

import javax.jws.WebMethod;
import javax.jws.WebService;

/**
 * Created with IntelliJ IDEA.
 * User: John
 * Date: 4/15/13
 * Time: 3:01 PM
 * Input: n x n matrix from WS 1
 * Output: Matrix L (lower) in echelon form, Matrix U (upper) in echelon form
 */
@WebService public class RowReduction extends SquareMatrixValidator{

        private double[][] LU;
    /**
     * Number of rows and columns
     */
        private int rowNumber, columnNumber;
        private int pivsign;
        private int[] pivot;
        public RowReduction()
        {

        }
         public RowReduction(boolean squareMatrix, double values[][])
         {
             LU = values;
             //gets number of rows
             int rowNumber = values.length;
             //gets number of columns
             int columnNumber = values[0].length;
             pivot = new int[rowNumber];
             for (int i = 0; i < rowNumber; i++)
             {
                 pivot[i]=i;
             }
             pivsign = 1;
             double[] LUrowi;
             double[] LUcolj = new double[rowNumber];

             // Outer loop.

             for (int j = 0; j < columnNumber; j++) {

                 // Make a copy of the j-th column to localize references.

                 for (int i = 0; i < rowNumber; i++) {
                     LUcolj[i] = LU[i][j];
                 }

                 // Apply previous transformations.

                 for (int i = 0; i < rowNumber; i++) {
                     LUrowi = LU[i];

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
                 for (int i = j + 1; i < rowNumber; i++) {
                     if (Math.abs(LUcolj[i]) > Math.abs(LUcolj[p])) {
                         p = i;
                     }
                 }
                 if (p != j) {
                     for (int k = 0; k < columnNumber; k++) {
                         double t = LU[p][k];
                         LU[p][k] = LU[j][k];
                         LU[j][k] = t;
                     }
                     int k = pivot[p];
                     pivot[p] = pivot[j];
                     pivot[j] = k;
                     pivsign = -pivsign;
                 }

                 // Compute multipliers.

                 if (j < rowNumber & LU[j][j] != 0.0) {
                     for (int i = j + 1; i < rowNumber; i++) {
                         LU[i][j] /= LU[j][j];
                     }
                 }
             }

         }

         public boolean InvertibleValidate()
         {
             for (int i = 0; i < rowNumber; i++)
             {
                 if (LU[i][i] == 0)
                 {
                     return false;
                 }

             }
             return true;
         }

    /**
     *     Get lower matrix
     * @return
     */
         public double[][] getL(double[][] matrix)
         {
              for (int i = 0; i < rowNumber; i++)
              {
                  for (int j = 0; j < columnNumber; j++)
                  {
                      if (i > j)
                      {
                          matrix[i][j] = LU[i][j];
                      } else if (i == j) {
                          matrix[i][j] = 1.0;
                      }  else {
                          matrix[i][j] = 0.0;
                      }
                  }
              }
             return matrix;
         }
}
