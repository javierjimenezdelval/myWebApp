/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package utils;

import com.vaadin.flow.component.Text;
import com.vaadin.flow.component.html.H1;
import com.vaadin.flow.component.textfield.TextField;

/**
 *
 * @author ferna
 */
public class ConfiguraCampos {

    public ConfiguraCampos() {
    }
    public TextField configuraNombre(TextField nombre)
    {
          //TextField nombre = new TextField("Nombre");
          nombre.setPlaceholder("Introduce el nombre");
          nombre.setHelperText("Se transforma en MAY");
          nombre.setTitle("titulo");
          String aux=null;
          aux=nombre.getValue();
          nombre.setMaxLength(20);
          nombre.setValue(aux.toUpperCase());
          return nombre;
        
    }
    
    
}