package edu.memphis.ehands;

public class ValidTester {
    public static void main(String[] argv) {
        try {
            SquareMatrixValidatorServiceLocator locator = new SquareMatrixValidatorServiceLocator();
            SquareMatrixValidator_PortType service = locator
                    .getSquareMatrixValidator();

            double[][] valid_matrix = new double[][]{
                    {1, 0, 1},
                    {1, 0, 1},
                    {1, 0, 1}
            };

            double[][] bad_matrix = new double[][]{
                    {1, 0},
                    {1}
            };

            System.out.println("checking: valid_matrix");
            if (service.validateMatrix(valid_matrix).isValidateMatrixReturn()) {
                System.out.println("valid matrix is good");
            } else {
                System.out.println("valid matrix is bad");
            }

            System.out.println("\nchecking: bad_matrix");
            if (service.validateMatrix(bad_matrix).isValidateMatrixReturn()) {
                System.out.println("bad matrix is good");
            } else {
                System.out.println("bad matrix is bad!");
            }

        } catch (javax.xml.rpc.ServiceException ex) {
            ex.printStackTrace();
        } catch (java.rmi.RemoteException ex) {
            ex.printStackTrace();
        }
    }
}
