package br.unicamp.ft.h198760_r205548;

public class Financiamento {
    private double  value;
    private String  name;
    private String  type;
    private int     term;
    private String  date;

    public Financiamento(double value, String name, String type, int term, String date) {
        this.value = value;
        this.name = name;
        this.type = type;
        this.term = term;
        this.date = date;
    }

    public double getValue() {
        return value;
    }

    public void setValue(double value) {
        this.value = value;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public int getTerm() {
        return term;
    }

    public void setTerm(int term) {
        this.term = term;
    }


    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

}
