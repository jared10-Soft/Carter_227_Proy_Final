import javax.swing.*;
import javax.swing.table.*;
import java.awt.Font;
import java.awt.Color;
import java.awt.event.*;

public class pantallaCliente implements ActionListener 
{
    JFrame ventana;
    JLabel lbl_nombre,lbl_apellido, lbl_cedula, lbl_direccion, lbl_telefono,lbl_provincia, lbl_compra_anual, lbl_grabado, lbl_modificado, lbl_eliminado, lbl_noEncontrado, lbl_cedulaVacia;
    JTextField tf_nombre, tf_apellido, tf_cedula, tf_direccion, tf_telefono, tf_compra_anual;
    JButton btn_buscar, btn_agregar, btn_modificar, btn_eliminar, btn_limpiar, btn_listar;

    JComboBox<String> jcb_provincia;
    DefaultTableModel modeloClientes;
    JTable tablaClientes;
    JScrollPane jsp_cliente;

    Cliente cliente;


    pantallaCliente(JFrame frame) {

        ventana = frame;
        ventana.getContentPane().removeAll();
        ventana.setTitle("CLIENTE");

        cliente = new Cliente();   
        
        modeloClientes = new DefaultTableModel();
        tablaClientes = new JTable(modeloClientes);
        jsp_cliente = new JScrollPane(tablaClientes);
        jsp_cliente.setBounds(500, 50, 650, 400);
        ventana.add(jsp_cliente);



        lbl_cedula = new JLabel("Cédula:");
        lbl_cedula.setBounds(50, 50, 150, 30);
        lbl_cedula.setFont(new Font("Arial", Font.BOLD, 24));
        lbl_cedula.setForeground(new Color(255, 255, 255));
        ventana.add(lbl_cedula);

        lbl_nombre = new JLabel("Nombre:");
        lbl_nombre.setBounds(50, 90, 150, 30);
        lbl_nombre.setFont(new Font("Arial", Font.BOLD, 24));
        lbl_nombre.setForeground(new Color(255, 255, 255));
        ventana.add(lbl_nombre);

        lbl_apellido = new JLabel("Apellido:");
        lbl_apellido.setBounds(50, 130, 150, 30);
        lbl_apellido.setFont(new Font("Arial", Font.BOLD, 24));
        lbl_apellido.setForeground(new Color(255, 255, 255));
        ventana.add(lbl_apellido);

        lbl_direccion = new JLabel("Dirección:");
        lbl_direccion.setBounds(50, 170, 150, 30);
        lbl_direccion.setFont(new Font("Arial", Font.BOLD, 24));
        lbl_direccion.setForeground(new Color(255, 255, 255));
        ventana.add(lbl_direccion);

        lbl_telefono = new JLabel("Teléfono:");
        lbl_telefono.setBounds(50, 210, 150, 30);
        lbl_telefono.setFont(new Font("Arial", Font.BOLD, 24));
        lbl_telefono.setForeground(new Color(255, 255, 255));
        ventana.add(lbl_telefono);

        lbl_provincia = new JLabel("Provincia:");
        lbl_provincia.setBounds(50, 250, 150, 30);
        lbl_provincia.setFont(new Font("Arial", Font.BOLD, 24));
        lbl_provincia.setForeground(new Color(255, 255, 255));
        ventana.add(lbl_provincia);

        lbl_compra_anual = new JLabel("Compra Anual:");
        lbl_compra_anual.setBounds(50, 290, 180, 30);
        lbl_compra_anual.setFont(new Font("Arial", Font.BOLD, 24));
        lbl_compra_anual.setForeground(new Color(255, 255, 255));
        ventana.add(lbl_compra_anual);

        tf_cedula = new JTextField();
        tf_cedula.setBounds(240, 50, 230, 30);
        tf_cedula.setFont(new Font("Arial", Font.PLAIN, 18));
        ventana.add(tf_cedula);

        tf_nombre = new JTextField();
        tf_nombre.setBounds(240, 90, 230, 30);
        tf_nombre.setFont(new Font("Arial", Font.PLAIN, 18));
        tf_nombre.setEnabled(false);
        ventana.add(tf_nombre);

        tf_apellido = new JTextField();
        tf_apellido.setBounds(240, 130, 230, 30);
        tf_apellido.setFont(new Font("Arial", Font.PLAIN, 18));
        tf_apellido.setEnabled(false);
        ventana.add(tf_apellido);

        tf_direccion = new JTextField();
        tf_direccion.setBounds(240, 170, 230, 30);
        tf_direccion.setFont(new Font("Arial", Font.PLAIN, 14));
        tf_direccion.setEnabled(false);
        ventana.add(tf_direccion);

        tf_telefono = new JTextField();
        tf_telefono.setBounds(240, 210, 230, 30);
        tf_telefono.setFont(new Font("Arial", Font.PLAIN, 18));
        tf_telefono.setEnabled(false);
        ventana.add(tf_telefono);

        jcb_provincia = new JComboBox<String>();
        cliente.almacenarProvincias(jcb_provincia);
        jcb_provincia.setBounds(240, 250, 230, 30);
        jcb_provincia.setFont(new Font("Arial", Font.PLAIN, 18));
        jcb_provincia.setEnabled(false);
        ventana.add(jcb_provincia);

        tf_compra_anual = new JTextField();
        tf_compra_anual.setBounds(240, 290, 230, 30);
        tf_compra_anual.setFont(new Font("Arial", Font.PLAIN, 18));
        tf_compra_anual.setEnabled(false);
        ventana.add(tf_compra_anual);

        btn_buscar = new JButton("BUSCAR");
        btn_buscar.setBounds(50, 350, 120, 40);
        btn_buscar.setFont(new Font("Arial", Font.BOLD, 18));
        btn_buscar.setBackground(new Color(211, 211, 211)); 
        btn_buscar.setForeground(new Color(0, 0, 0));   
        btn_buscar.addActionListener(this);
        ventana.add(btn_buscar);

        btn_agregar = new JButton("AGREGAR");
        btn_agregar.setBounds(200, 350, 120, 40);
        btn_agregar.setFont(new Font("Arial", Font.BOLD, 18));
        btn_agregar.setBackground(new Color(211, 211, 211));
        btn_agregar.setForeground(new Color(0, 0, 0));
        btn_agregar.addActionListener(this);
        btn_agregar.setEnabled(false);
        ventana.add(btn_agregar);

        btn_modificar = new JButton("MODIFICAR");
        btn_modificar.setBounds(350, 350, 120, 40);
        btn_modificar.setFont(new Font("Arial", Font.BOLD, 14));
        btn_modificar.setBackground(new Color(211, 211, 211));
        btn_modificar.setForeground(new Color(0, 0, 0));
        btn_modificar.addActionListener(this);
        btn_modificar.setEnabled(false);
        ventana.add(btn_modificar);

        btn_eliminar = new JButton("ELIMINAR"); 
        btn_eliminar.setBounds(50, 410, 120, 40);
        btn_eliminar.setFont(new Font("Arial", Font.BOLD, 16));
        btn_eliminar.setBackground(new Color(211, 211, 211));
        btn_eliminar.setForeground(new Color(0, 0, 0));
        btn_eliminar.addActionListener(this);
        btn_eliminar.setEnabled(false);
        ventana.add(btn_eliminar);

        btn_limpiar = new JButton("LIMPIAR");
        btn_limpiar.setBounds(200, 410, 120, 40);
        btn_limpiar.setFont(new Font("Arial", Font.BOLD, 18));
        btn_limpiar.setBackground(new Color(211, 211, 211));
        btn_limpiar.setForeground(new Color(0, 0, 0));
        btn_limpiar.addActionListener(this);
        ventana.add(btn_limpiar);

        btn_listar = new JButton("LISTAR");
        btn_listar.setBounds(350, 410, 120, 40);
        btn_listar.setFont(new Font("Arial", Font.BOLD, 18));
        btn_listar.setBackground(new Color(211, 211, 211));
        btn_listar.setForeground(new Color(0, 0, 0));
        btn_listar.addActionListener(this);
        ventana.add(btn_listar);


        lbl_grabado = new JLabel("Registro grabado correctamente.");
        lbl_grabado.setFont(new Font("Arial", Font.BOLD, 24));
        lbl_grabado.setForeground(new Color(255, 255, 255));
        lbl_grabado.setBounds(500, 460, 600, 40);
        lbl_grabado.setVisible(false);
        ventana.add(lbl_grabado);

        lbl_modificado = new JLabel("Registro modificado correctamente.");
        lbl_modificado.setFont(new Font("Arial", Font.BOLD, 24));
        lbl_modificado.setForeground(new Color(255, 255, 255));
        lbl_modificado.setBounds(500, 460, 600, 40);
        lbl_modificado.setVisible(false);
        ventana.add(lbl_modificado);

        lbl_eliminado = new JLabel("Registro eliminado correctamente.");
        lbl_eliminado.setFont(new Font("Arial", Font.BOLD, 24));
        lbl_eliminado.setForeground(new Color(255, 255, 255));
        lbl_eliminado.setBounds(500, 460, 600, 40);
        lbl_eliminado.setVisible(false);
        ventana.add(lbl_eliminado);

        lbl_noEncontrado = new JLabel("Cliente no encontrado.");
        lbl_noEncontrado.setFont(new Font("Arial", Font.BOLD, 24));
        lbl_noEncontrado.setForeground(new Color(255, 255, 255));
        lbl_noEncontrado.setBounds(500, 460, 600, 40);
        lbl_noEncontrado.setVisible(false);
        ventana.add(lbl_noEncontrado);

        ventana.setVisible(true);
        ventana.repaint();

    }

    public void actionPerformed(ActionEvent e) 
    {
        System.out.println("YHola soy Kenneth");

        if (e.getSource() == btn_buscar) 
            buscarDatos();
        else if (e.getSource() == btn_agregar) 
            agregarDatos();
        else if (e.getSource() == btn_modificar) 
            modificarDatos();
        else if (e.getSource() == btn_eliminar) 
            eliminarDatos();
        else if (e.getSource() == btn_limpiar) 
            limpiarCampos();
        else if (e.getSource() == btn_listar) 
            listarDatos();
    }

    public void buscarDatos()
    {      
        cliente.buscarDatos(tf_cedula.getText());
        if(cliente.getCedula().isEmpty())
            usuarioNoEncontrado();
        else
            usuarioEncontrado();
    }

    
    public void agregarDatos() 
    {
        agregarClientes();
        cliente.agregar();
        limpiarCampos();
        
        botonesPrincipio();
        modoLbl(true, false, false, false);

    }
    
    public void modificarDatos() 
    {
        agregarClientes();
        cliente.modificar();
        limpiarCampos();
        botonesPrincipio();
        modoLbl(false, true, false, false);
    }

    public void eliminarDatos()
    {
        cliente.eliminarDatos(tf_cedula.getText()); 
        limpiarCampos();  
        botonesPrincipio();
        modoLbl(false, false, true, false);

    }

    
    

    public void limpiarCampos() 
    {
        tf_cedula.setText("");
        limpiarCampos2();

        tf_cedula.setEnabled(true); 
        tf_nombre.setEnabled(false);
        tf_apellido.setEnabled(false);
        tf_direccion.setEnabled(false);
        tf_telefono.setEnabled(false);
        tf_compra_anual.setEnabled(false);
        jcb_provincia.setEnabled(false);

        btn_buscar.setEnabled(true);
        btn_agregar.setEnabled(false);
        btn_modificar.setEnabled(false);
        btn_eliminar.setEnabled(false);
        btn_listar.setEnabled(true);
        btn_limpiar.setEnabled(true);

        modoLbl(false, false, false, false);

    }


    public void listarDatos()
    {
        cliente.cargarTabla(modeloClientes);
    }

    
    public void agregarClientes()
    {

        cliente.setCedula(tf_cedula.getText());
        cliente.setNombre(tf_nombre.getText());
        cliente.setApellido(tf_apellido.getText());
        cliente.setDireccion(tf_direccion.getText());
        cliente.setTelefono(tf_telefono.getText());
        cliente.setProvincia((String) jcb_provincia.getSelectedItem());
        cliente.setCompraAnual(Double.parseDouble(tf_compra_anual.getText()));
    }
   

    public void limpiarCampos2() 
    {
        tf_nombre.setText("");
        tf_apellido.setText("");
        tf_direccion.setText("");
        tf_telefono.setText("");
        if (jcb_provincia.getItemCount() > 0)
            jcb_provincia.setSelectedIndex(0);
        tf_compra_anual.setText("");
    }
    
    public void botonesPrincipio()
    {
        btn_buscar.setEnabled(true);
        btn_listar.setEnabled(true);
        btn_limpiar.setEnabled(true);

        btn_agregar.setEnabled(false);
        btn_modificar.setEnabled(false);
        btn_eliminar.setEnabled(false);
    }


    public void volverHabilitar()
    {
        
        tf_nombre.setEnabled(true);
        tf_apellido.setEnabled(true);
        tf_direccion.setEnabled(true);
        tf_telefono.setEnabled(true);
        jcb_provincia.setEnabled(true);
        tf_compra_anual.setEnabled(true);
    }


    public void usuarioNoEncontrado()
    {
        btn_agregar.setEnabled(true);
        btn_buscar.setEnabled(false);
        btn_modificar.setEnabled(false);
        btn_eliminar.setEnabled(false);

        modoLbl(false, false, false, true);


        volverHabilitar();
    }


    public void usuarioEncontrado()
    {

        tf_nombre.setText(cliente.getNombre());
        tf_apellido.setText(cliente.getApellido());
        tf_direccion.setText(cliente.getDireccion());
        tf_telefono.setText(cliente.getTelefono());
        jcb_provincia.setSelectedItem(cliente.getProvincia());
        tf_compra_anual.setText(String.valueOf(cliente.getCompraAnual()));
        tf_cedula.setEnabled(false);

        volverHabilitar();
        btn_agregar.setEnabled(false);
        btn_buscar.setEnabled(false);
        btn_modificar.setEnabled(true);
        btn_eliminar.setEnabled(true);
    }
    
    public void modoLbl(boolean grabado, boolean modificado, boolean eliminado, boolean noEncontrado)
    {
        lbl_grabado.setVisible(grabado);
        lbl_modificado.setVisible(modificado);
        lbl_eliminado.setVisible(eliminado);
        lbl_noEncontrado.setVisible(noEncontrado);
    }
}


