package edu.memphis.ehands;

import javax.jws.WebMethod;
import javax.jws.WebService;

@WebService()
public class DeterminantCalc {

     @WebMethod public double calculateDet(DecomposedMatrix m) {

        double d = (double) m.pivsign;
         System.out.println("piv sign: " + d);
        for (int j = 0; j < m.n; j++) {
            d *= m.LU[j][j];
        }
        return d;
    }


}
