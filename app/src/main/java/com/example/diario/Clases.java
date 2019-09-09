package com.example.diario;

public class Clases {


    private String claseid;
    private String seccion;
    private String asignatura;
    private String tema;


    public Clases(String claseid, String seccion, String asignatura, String tema) {
        this.claseid = claseid;
        this.seccion = seccion;
        this.asignatura = asignatura;
        this.tema = tema;
    }

    public String getClaseid() {
        return claseid;
    }

    public void setClaseid(String claseid) {
        this.claseid = claseid;
    }

    public String getSeccion() {
        return seccion;
    }

    public void setSeccion(String seccion) {
        this.seccion = seccion;
    }

    public String getAsignatura() {
        return asignatura;
    }

    public void setAsignatura(String asignatura) {
        this.asignatura = asignatura;
    }

    public String getTema() {
        return tema;
    }

    public void setTema(String tema) {
        this.tema = tema;
    }




}
