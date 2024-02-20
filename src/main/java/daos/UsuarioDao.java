package daos;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */


import beans.UsuarioBean;
import java.time.LocalDate;
import java.util.HashSet;
import org.example.Direccion;

/**
 *
 * @author 06544740K
 */
public class UsuarioDao {
    
    
    public HashSet<UsuarioBean> getLista (){
        HashSet<UsuarioBean> lista = new HashSet<>();
        
        LocalDate fecha = LocalDate.of(2000, 12, 8);
        Direccion direccion = new Direccion ("Calle", "Arce","1","3º","05001");
        UsuarioBean usuario = new UsuarioBean ("111223Q", "Manolo","ape1", "ape2",fecha, direccion);
        lista.add(usuario);
        
        fecha = LocalDate.of(1980, 3, 1);
        direccion = new Direccion ("Calle", "Pino","2","1º","05001");
        usuario = new UsuarioBean ("66699966Z", "Pistón","ape1", "ape22",fecha, direccion);
        lista.add(usuario);
        
        return lista;
        
    };
    
    
}
