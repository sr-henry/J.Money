package br.unicamp.ft.h198760_r205548;

public class Divida {
    private double  value;
    private int     term;
    private String  name;

    public Divida(double value, int term, String name) {
        this.value = value;
        this.term = term;
        this.name = name;
    }

    public double getValue() {
        return value;
    }

    public int getTerm() {
        return term;
    }

    public String getName() {
        return name;
    }
}
