package org.example;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author 06544740K
 */
public class Direccion {
    private String tipovia;
    private String direccion;
    private String numero;
    private String piso;
    private String codigoPostal;

    public Direccion(String tipovia, String direccion, String numero, String piso, String codigoPostal) {
        this.tipovia = tipovia;
        this.direccion = direccion;
        this.numero = numero;
        this.piso = piso;
        this.codigoPostal = codigoPostal;
    }
    



    Direccion() {
    /* constructor vacío obligatorio */    
    }

    @Override
    public String toString() {
        return tipovia + " " + direccion + ", Nº" + numero + ", " + piso + ", CP " + codigoPostal;
    }

    public String getTipovia() {
        return tipovia;
    }

    public String getDireccion() {
        return direccion;
    }

    public String getNumero() {
        return numero;
    }

    public String getPiso() {
        return piso;
    }

    public String getCodigoPostal() {
        return codigoPostal;
    }

    public void setTipovia(String tipovia) {
        this.tipovia = tipovia;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public void setPiso(String piso) {
        this.piso = piso;
    }

    public void setCodigoPostal(String codigoPostal) {
        this.codigoPostal = codigoPostal;
    }
  
}
