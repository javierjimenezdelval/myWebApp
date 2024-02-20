package org.example;

import beans.CentrosBean;
import beans.ServiciosBean;
import daos.UsuarioDao;
import beans.UsuarioBean;
import com.vaadin.flow.component.Unit;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.combobox.ComboBox;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.component.datepicker.DatePicker;
import com.vaadin.flow.component.formlayout.FormLayout;
import com.vaadin.flow.component.grid.Grid;
import com.vaadin.flow.component.grid.GridVariant;
import com.vaadin.flow.component.html.H1;
import com.vaadin.flow.data.binder.Binder;
import com.vaadin.flow.data.binder.ValidationException;
import com.vaadin.flow.router.Route;
import daos.CentroDao;
import daos.ServiciosDao;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.logging.Level;
import java.util.logging.Logger;
import utils.ConfiguraCampos;

@Route
public class MainView extends HorizontalLayout {

    /* definimos aquí los campos para poder usarlos en cualquier orden.
    Si los definimos dentro de MainView habría que definir button, por ejempo, 
    antes de poder usarlo en el evento click
     */
    private H1 cartel = new H1("PRACTICANDO CON VAADIN");
    private Button nuevo = new Button("Nuevo");
    private Button ok = new Button("Aceptar");
    private Button cancel = new Button("Cancelar");
    private TextField dni = new TextField("NIF");
    private TextField nombre = new TextField("Nombre");
    private TextField ape1 = new TextField("Apellido 1");
    private TextField ape2 = new TextField("Apellido 2");
    private TextField calle = new TextField("Calle");
    private TextField numero = new TextField("Número");
    private TextField piso = new TextField("Piso/Letra");
    private TextField cp = new TextField("Código Postal");
    private DatePicker fechaNac = new DatePicker("Fecha de nacimiento");
    private ComboBox<String> tipoVia = new ComboBox("Tipo de vía");
    private ComboBox<CentrosBean> comboCentro = new ComboBox("Centro");
    private ComboBox<ServiciosBean> comboServicio = new ComboBox("Servicio");
    private Grid<UsuarioBean> userGrid = new Grid<>(UsuarioBean.class, false);
    private Binder<UsuarioBean> binder = new Binder();
    private Binder<Direccion> binderD = new Binder();
    private HashSet<UsuarioBean> lista = new UsuarioDao().getLista();


    /* Este método debería leer de la base de datos; 
para trabajar con esto hemos definido valores en el código (en UsuarioDao.java)
     */
    public MainView() {

        ok.setEnabled(false);
        ConfiguraCampos configuraCampos=new ConfiguraCampos();
        /* por defecto desactivado, hasta que haya algo en los campos */
nombre=configuraCampos.configuraNombre(nombre);
        nombre.addValueChangeListener(event->{
        nombre=configuraCampos.configuraNombre(nombre);
                
        });
        tipoVia.setAllowCustomValue(true);
        tipoVia.setItems("Calle", "Paseo", "Plaza", "Ctra.", "Parque");

        binder.forField(dni).asRequired("El NIF es oblgatorio").bind(UsuarioBean::getDni, UsuarioBean::setDni);
        binder.forField(nombre).asRequired("Es obligatorio el  nombre").bind(UsuarioBean::getNombre, UsuarioBean::setNombre);

        binder.forField(ape1).bind(UsuarioBean::getApe1, UsuarioBean::setApe1);
        binder.forField(ape2).bind(UsuarioBean::getApe2, UsuarioBean::setApe2);
        binder.forField(fechaNac).bind(UsuarioBean::getFechaNacimiento, UsuarioBean::setFechaNacimiento);

        binderD.forField(tipoVia).bind(Direccion::getTipovia, Direccion::setTipovia);
        binderD.forField(calle).bind(Direccion::getDireccion, Direccion::setDireccion);
        binderD.forField(numero).bind(Direccion::getNumero, Direccion::setNumero);
        binderD.forField(piso).bind(Direccion::getPiso, Direccion::setPiso);
        binderD.forField(cp).bind(Direccion::getCodigoPostal, Direccion::setCodigoPostal);

        /*click en nuevo usuario*/
        nuevo.addClickListener(e -> {

            try {
                Direccion dir = new Direccion();
                binderD.writeBean(dir);

                UsuarioBean usu = new UsuarioBean();
                binder.writeBean(usu);

                usu.setDireccion(dir);
                lista.add(usu);
                userGrid.setItems(lista);

                dni.clear();
                nombre.clear();
                ape1.clear();
                ape2.clear();
                calle.clear();
                numero.clear();
                piso.clear();
                cp.clear();
                ape1.clear();
                fechaNac.clear();
                tipoVia.clear();

            } catch (ValidationException ex) {
                Logger.getLogger(MainView.class.getName()).log(Level.SEVERE, null, ex);
            }
        });

        userGrid.addItemClickListener(e -> {

            binder.readBean(e.getItem());
            /* rellena los campos en pantalla*/
            binderD.readBean(e.getItem().getDireccion());
            ok.setEnabled(true);
        });
        userGrid.addThemeVariants(GridVariant.LUMO_COLUMN_BORDERS);
        userGrid.addColumn(UsuarioBean::getDni).setHeader("NIF")
                .setSortable(true)
                .setResizable(true);
        userGrid.addColumn(UsuarioBean::getNombre).setHeader("Nombre").setSortable(true)
                .setResizable(true);
        userGrid.addColumn(UsuarioBean::getApe1).setHeader("Apellido 1").setSortable(true)
                .setResizable(true);
        userGrid.addColumn(UsuarioBean::getApe2).setHeader("Apellido 2").setSortable(true)
                .setResizable(true);
        userGrid.addColumn(UsuarioBean::getFechaNacimiento).setHeader("Fecha de nacimiento").setSortable(true)
                .setResizable(true);
        userGrid.addColumn(UsuarioBean::getDireccion).setHeader("Dirección")
                .setResizable(true);
        userGrid.setItems(lista);

        VerticalLayout verticalGLOBAL = new VerticalLayout();
        HorizontalLayout horizontalUsuario = new HorizontalLayout();
        HorizontalLayout horizontalDomicilio = new HorizontalLayout();
        HorizontalLayout horizontalCentro = new HorizontalLayout();
        HorizontalLayout horizontalBotones = new HorizontalLayout();

        verticalGLOBAL.add("Usuario");

        add(verticalGLOBAL);

        dni.setClearButtonVisible(true);
        dni.setMinLength(9);
        dni.setMaxLength(9);

        comboCentro.setItems(new CentroDao().getLista());
        comboCentro.setItemLabelGenerator(CentrosBean::getDescripcion);
        comboCentro.addValueChangeListener(e -> {
            comboServicio.setItems(new ServiciosDao().getListaPorCentro(e.getValue().getCodigo()));
            comboServicio.setItemLabelGenerator(ServiciosBean::getDescripcion);
            comboServicio.setWidth(60, Unit.VMIN);
        });

        horizontalUsuario.add(dni);
        horizontalUsuario.add(nombre);
        horizontalUsuario.add(ape1);
        horizontalUsuario.add(ape2);
        horizontalUsuario.add(fechaNac);
        horizontalDomicilio.add(tipoVia);
        horizontalDomicilio.add(calle);
        horizontalDomicilio.add(numero);
        horizontalDomicilio.add(piso);
        horizontalDomicilio.add(cp);

        horizontalCentro.add(comboCentro);
        horizontalCentro.add(comboServicio);

        horizontalBotones.add(nuevo);
        horizontalBotones.add(ok);
        horizontalBotones.add(cancel);
        verticalGLOBAL.add(cartel);
        verticalGLOBAL.add(horizontalUsuario);
        verticalGLOBAL.add(horizontalDomicilio);
        verticalGLOBAL.add(horizontalCentro);
        verticalGLOBAL.add(horizontalBotones);
        verticalGLOBAL.add(userGrid);

    }

}
