/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package daos;

import beans.CentrosBean;
import beans.ServiciosBean;
import java.time.LocalDate;
import java.util.HashSet;

/**
 *
 * @author 06553669A
 */
public class ServiciosDao {

    public HashSet<ServiciosBean> getLista() {
        HashSet<ServiciosBean> listaServicios = new HashSet<>();

        LocalDate fecha = LocalDate.of(2000, 12, 8);
        ServiciosBean servicio = new ServiciosBean(1, "HNSS.SERVICIO 1", 1);
        listaServicios.add(servicio);
        servicio = new ServiciosBean(2, "HNSS.SERVICIO 2", 1);
        listaServicios.add(servicio);
        servicio = new ServiciosBean(1, "HPROVINCIAL.SERVICIO 1", 2);
        listaServicios.add(servicio);
        servicio = new ServiciosBean(2, "HPROVINCIAL.SERVICIO 2", 2);
        listaServicios.add(servicio);

        return listaServicios;

    }
    
    public HashSet<ServiciosBean> getListaPorCentro(Integer centro)
    {
        HashSet<ServiciosBean> listaServiciosPorCentro=new HashSet<>();
        
        for (ServiciosBean unServiciosBean:getLista())
        {
            if (unServiciosBean.getCentro() == centro)
                listaServiciosPorCentro.add(unServiciosBean);
        }
        
        return listaServiciosPorCentro;               
    }

}
