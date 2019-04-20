package br.unicamp.ft.h198760_r205548;

public class Divida {

    private double  value;
    private int     term;
    private String  name;
    private String  type;
    private String  date;

    public Divida(double value, int term, String name, String type, String date) {
        this.value = value;
        this.term = term;
        this.name = name;
        this.type = type;
        this.date = date;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
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

    public String getType() {
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

    public void setType(String type) {
        this.type = type;
    }
}
