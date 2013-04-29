package edu.memphis.ehands.data;

public class Matrix {

    public int nrows;
    public int ncols;
    public double[][] data;

    public Matrix() {
        nrows = 0;
        ncols = 0;
    }

    public Matrix(double[][] dat) {
        this.data = dat;
        this.nrows = dat.length;
        this.ncols = dat[0].length;
    }

    public Matrix(int nrow, int ncol) {
        this.nrows = nrow;
        this.ncols = ncol;
        data = new double[nrow][ncol];
    }

    public int getNcols() {
        return ncols;
    }

    public int getNrows() {
        return nrows;
    }

    public void setValueAt(int i, int j, double newval) {
        data[i][j] = newval;
    }

    public double getValueAt(int i, int j) {
        return data[i][j];
    }

    public int size() {
        return data[0].length;
    }
}
