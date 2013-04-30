package edu.memphis.ehands.model;

public class DService {
    public String name;
    public String input;
    public String output;

    public DService(String name, String input, String output) {
        this.name = name;
        this.input = input;
        this.output = output;
    }

    @Override public boolean equals(Object o) {
        DService other;
        if (o instanceof DService) {
            return name.equalsIgnoreCase(((DService) o).name);
        } else {
            return super.equals(o);
        }


    }
}
