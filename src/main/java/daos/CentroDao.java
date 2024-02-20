/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package daos;

import beans.CentrosBean;
import java.time.LocalDate;
import java.util.HashSet;

/**
 *
 * @author 06553669A
 */
public class CentroDao {
    
    public HashSet<CentrosBean> getLista (){
        HashSet<CentrosBean> listaCentros = new HashSet<>();
        
        LocalDate fecha = LocalDate.of(2000, 12, 8);
        CentrosBean centro = new CentrosBean (1, "HNSS");
        listaCentros.add(centro);
        centro = new CentrosBean (2, "H.PROVINCIAL");
        listaCentros.add(centro);
        
        
        
        return listaCentros;
    
}
}
