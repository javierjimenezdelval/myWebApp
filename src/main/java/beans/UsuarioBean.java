/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package beans;

import java.time.LocalDate;
import java.util.Objects;
import org.example.Direccion;

/**
 *
 * @author 06544740K
 */
public class UsuarioBean {
    private String dni;
    private String nombre;
    private String ape1;
    private String ape2;

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 53 * hash + Objects.hashCode(this.dni);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final UsuarioBean other = (UsuarioBean) obj;
        return Objects.equals(this.dni, other.dni);
    }
    private LocalDate fechaNacimiento;
    private Direccion direccion;
    
    public UsuarioBean() {
        
    }


    
    public UsuarioBean(String dni, String nombre, String ape1, String ape2, LocalDate fechaNacimiento, Direccion direccion) {
        this.dni = dni;
        this.nombre = nombre;
        this.ape1 = ape1;
        this.ape2 = ape2;
        this.fechaNacimiento = fechaNacimiento;
        this.direccion = direccion;
    }

    @Override
    public String toString() {
        return dni + " " + nombre + " " + ape1 + " " + ape2 + " " + fechaNacimiento + " " + direccion;
    }


    public void setDni(String dni) {
        this.dni = dni;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setApe1(String ape1) {
        this.ape1 = ape1;
    }

    public void setApe2(String ape2) {
        this.ape2 = ape2;
    }

    public void setFechaNacimiento(LocalDate fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

    public void setDireccion(Direccion direccion) {
        this.direccion = direccion;
    }

    public String getDni() {
        return dni;
    }
    public String getNombre() {
        return nombre;
    }

    public String getApe1() {
        return ape1;
    }

    public String getApe2() {
        return ape2;
    }

    public LocalDate getFechaNacimiento() {
        return fechaNacimiento;
    }

    public Direccion getDireccion() {
        return direccion;
    }
    
}
