package br.unicamp.ft.h198760_r205548;

public class Divida {
    private double  value;
    private int     term;
    private String  name;
    private int type;

    public Divida(double value, int term, String name, int type) {
        this.value = value;
        this.term = term;
        this.name = name;
        this.type = type;
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

    public int getType() {
        return type;
    }

    public void setValue(double value) {
        this.value = value;
    }

    public void setTerm(int term) {
        this.term = term;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setType(int type) {
        this.type = type;
    }
}
