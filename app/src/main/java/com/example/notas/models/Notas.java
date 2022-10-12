package com.example.notas.models;

public class Notas {
    private int id;
    private String nombre;
    private Double nota_1;
    private Double nota_2;
    private Double nota_3;
    private Double nota_4;

    public int getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    public Double getNota_1() {
        return nota_1;
    }

    public void setNota_1(Double nota_1) {
        this.nota_1 = nota_1;
    }

    public Double getNota_2() {
        return nota_2;
    }

    public void setNota_2(Double nota_2) {
        this.nota_2 = nota_2;
    }

    public Double getNota_3() {
        return nota_3;
    }

    public void setNota_3(Double nota_3) {
        this.nota_3 = nota_3;
    }

    public Double getNota_4() {
        return nota_4;
    }

    public void setNota_4(Double nota_4) {
        this.nota_4 = nota_4;
    }
}
