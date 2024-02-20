/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package beans;

/**
 *
 * @author 06553669A
 */
public class ServiciosBean {
    private Integer codigo;
    private String  descripcion;
    private Integer centro;

    public ServiciosBean(Integer codigo, String descripcion, Integer centro) {
        this.codigo = codigo;
        this.descripcion = descripcion;
        this.centro = centro;
    }

    public Integer getCodigo() {
        return codigo;
    }

    public void setCodigo(Integer codigo) {
        this.codigo = codigo;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public Integer getCentro() {
        return centro;
    }

    public void setCentro(Integer centro) {
        this.centro = centro;
    }
}
