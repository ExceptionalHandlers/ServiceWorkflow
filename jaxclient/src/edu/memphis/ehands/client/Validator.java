package edu.memphis.ehands.client;

import edu.memphis.ehands.DecomposedMatrix;
import edu.memphis.ehands.DeterminantCalc;
import edu.memphis.ehands.DeterminantCalcService;
import edu.memphis.ehands.Matrix;

public class Validator {
    public static void main(String[] argv) {
        edu.memphis.ehands.SquareMatrixValidator service = new edu.memphis.ehands.SquareMatrixValidatorService()
                .getSquareMatrixValidatorPort();
        //      String m = "1,2,3|2,-4,6|3,-9,-3";

        String m = "3,8|4,6";
        Matrix validate = service.validate(m);

        if (validate == null) {
            System.out.println("Matrix invalid!");
            return;
        }

        edu.memphis.ehands.LUDecomposer luDecomposer = new edu.memphis.ehands.LUDecomposerService()
                .getLUDecomposerPort();

        DecomposedMatrix decomposedMatrix = luDecomposer.decompose(validate);

        DeterminantCalc calc = new DeterminantCalcService().getDeterminantCalcPort();

        double det = calc.calculateDet(decomposedMatrix);

        System.out.println("det: " + det);

    }
}
