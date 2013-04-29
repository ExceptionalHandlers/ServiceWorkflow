package edu.memphis.ehands;

public class Matrix {

    public Matrix() {

    }

    public Matrix(double[][] data) {
        setData(data);
    }

    public double[][] getData() {
        return data;
    }

    public void setData(double[][] data) {
        this.data = data;
    }

    private double[][] data;

}
