package edu.memphis.ehands;

import java.io.Serializable;

public class DecomposedMatrix implements Serializable {
    public double[][] LU;
    public int m;
    public int n;
    public int pivsign;
}
