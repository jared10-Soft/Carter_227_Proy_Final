import java.awt.Color;
import java.awt.Font;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.table.*;

public class pantallaVendedor implements ActionListener
{
    JFrame ventana;
    JLabel lbl_codigo, lbl_nombre, lbl_apellido, lbl_departamento, lbl_cargo, lbl_venta_mensual, lbl_venta_anual,lbl_grabado, lbl_modificado, lbl_eliminado, lbl_noEncontrado, lbl_cedulaVacia;
    JTextField tf_codigo, tf_nombre, tf_apellido, tf_cargo, tf_venta_mensual, tf_venta_anual;
    JButton btn_buscar, btn_agregar, btn_modificar, btn_eliminar, btn_limpiar, btn_listar;

    JComboBox<String> jcb_departamento;
    
    DefaultTableModel modeloClientes;
    JTable tablaClientes;
    JScrollPane jsp_cliente;

    Vendedor vendedor;


    pantallaVendedor(JFrame frame) {
        ventana = frame;
        ventana.getContentPane().removeAll();
        ventana.setTitle("VENDEDOR");

        vendedor = new Vendedor();
        
        modeloClientes = new DefaultTableModel();
        tablaClientes = new JTable(modeloClientes);
        jsp_cliente = new JScrollPane(tablaClientes);
        jsp_cliente.setBounds(500, 50, 650, 400);
        ventana.add(jsp_cliente);

        lbl_codigo = new JLabel("Código:");
        lbl_codigo.setBounds(50, 50, 150, 30);
        lbl_codigo.setFont(new Font("Arial", Font.BOLD, 24));
        lbl_codigo.setForeground(new Color(255, 255, 255));
        ventana.add(lbl_codigo);

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

        lbl_departamento = new JLabel("Departamento:");
        lbl_departamento.setBounds(50, 170, 200, 30);       
        lbl_departamento.setFont(new Font("Arial", Font.BOLD, 24));
        lbl_departamento.setForeground(new Color(255, 255, 255));
        ventana.add(lbl_departamento);

        lbl_cargo = new JLabel("Cargo:");
        lbl_cargo.setBounds(50, 210, 150, 30);
        lbl_cargo.setFont(new Font("Arial", Font.BOLD, 24));
        lbl_cargo.setForeground(new Color(255, 255, 255));
        ventana.add(lbl_cargo);

        lbl_venta_mensual = new JLabel("Venta Mensual:");
        lbl_venta_mensual.setBounds(50, 250, 200, 30);
        lbl_venta_mensual.setFont(new Font("Arial", Font.BOLD, 24));
        lbl_venta_mensual.setForeground(new Color(255, 255, 255));
        ventana.add(lbl_venta_mensual);

        lbl_venta_anual = new JLabel("Venta Anual:");
        lbl_venta_anual.setBounds(50, 290, 200, 30);
        lbl_venta_anual.setFont(new Font("Arial", Font.BOLD, 24));
        lbl_venta_anual.setForeground(new Color(255, 255, 255));
        ventana.add(lbl_venta_anual);

        tf_codigo = new JTextField();
        tf_codigo.setBounds(240, 50, 230, 30);
        tf_codigo.setFont(new Font("Arial", Font.PLAIN, 18));
        ventana.add(tf_codigo);
        
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

        jcb_departamento = new JComboBox<>();
        vendedor.alamcenarDepartamento(jcb_departamento);
        jcb_departamento.setBounds(240, 170, 230, 30);
        jcb_departamento.setFont(new Font("Arial", Font.PLAIN, 16));
        jcb_departamento.setEnabled(false);
        ventana.add(jcb_departamento);

        tf_cargo = new JTextField();
        tf_cargo.setBounds(240, 210, 230, 30);
        tf_cargo.setFont(new Font("Arial", Font.PLAIN, 18));
        tf_cargo.setEnabled(false);
        ventana.add(tf_cargo);

        tf_venta_mensual = new JTextField();
        tf_venta_mensual.setBounds(240, 250, 230, 30);
        tf_venta_mensual.setFont(new Font("Arial", Font.PLAIN, 18));
        tf_venta_mensual.setEnabled(false);
        ventana.add(tf_venta_mensual);

        tf_venta_anual = new JTextField();
        tf_venta_anual.setBounds(240, 290, 230, 30);
        tf_venta_anual.setFont(new Font("Arial", Font.PLAIN, 18));
        tf_venta_anual.setEnabled(false);
        ventana.add(tf_venta_anual);



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

        lbl_noEncontrado = new JLabel("Vendedor no encontrado.");
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
        System.out.println("Estoy hartooooo ");

        if(e.getSource() == btn_listar)
            mostrarDatos();
        else if(e.getSource() == btn_buscar)
            buscarDatos();
        else if(e.getSource() == btn_eliminar)
            eliminarDatos();
        else if(e.getSource() == btn_agregar)
            agregarDatos();
        else if(e.getSource() == btn_limpiar)
            limpiarDatos();
        else if(e.getSource() == btn_modificar)
            modificarDatos();
    }


    public void buscarDatos()
    {
        vendedor.buscarDatos(tf_codigo.getText());

        if(vendedor.getCodigo().isEmpty())
            vendedorNoEncontrado();
        else
            vendedorEncontrado();
    }


    public void agregarDatos()
    {
        agregarVendedor();
        vendedor.agregar();
        limpiarDatos();
        botonesPrincipio();
        modoLbl(true, false, false, false);
    }


    public void modificarDatos()
    {
        agregarVendedor();
        vendedor.modificar();
        limpiarDatos();
        botonesPrincipio();
        modoLbl(false, true, false, false);
    }


    public void eliminarDatos()
    {
        vendedor.eliminarDatos(tf_codigo.getText());
        limpiarDatos();
        botonesPrincipio(); 
        modoLbl(false, false, true, false);  
    }


    public void limpiarDatos()
    {
        tf_codigo.setText("");
        limpiarCampos2();

        tf_codigo.setEnabled(true);
        tf_nombre.setEnabled(false);
        tf_apellido.setEnabled(false);
        tf_cargo.setEnabled(false);
        jcb_departamento.setEnabled(false);
        tf_cargo.setEnabled(false);
        tf_venta_mensual.setEnabled(false);
        tf_venta_anual.setEnabled(false);

        btn_buscar.setEnabled(true);
        btn_agregar.setEnabled(false);
        btn_modificar.setEnabled(false);
        btn_eliminar.setEnabled(false);
        btn_listar.setEnabled(true);
        btn_limpiar.setEnabled(true);

        modoLbl(false, false, false, false);
    }


    public void mostrarDatos() 
    {
        vendedor.cargarTabla(modeloClientes);       
    }


    public void agregarVendedor()
    {
        vendedor.setCodigo(tf_codigo.getText());
        vendedor.setNombre(tf_nombre.getText());
        vendedor.setApellido(tf_apellido.getText());
        vendedor.setDepartamento((String) jcb_departamento.getSelectedItem());
        vendedor.setCargo(tf_cargo.getText());
        vendedor.setVentaMensual(Double.parseDouble(tf_venta_mensual.getText()));
        vendedor.setVentaAnual(Double.parseDouble(tf_venta_anual.getText()));
        limpiarDatos();
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
        tf_cargo.setEnabled(true);
        jcb_departamento.setEnabled(true);
        tf_venta_mensual.setEnabled(true);
        tf_venta_anual.setEnabled(true);
    }


    public void vendedorNoEncontrado()
    {
        btn_agregar.setEnabled(true);
        btn_buscar.setEnabled(false);
        btn_eliminar.setEnabled(false);
        btn_modificar.setEnabled(false);

        modoLbl(false, false, false, true);
        volverHabilitar();
    }

    public void vendedorEncontrado()
    {
        tf_nombre.setText(vendedor.getNombre());
        tf_apellido.setText(vendedor.getApellido());
        tf_cargo.setText(vendedor.getCargo());
        tf_venta_mensual.setText(String.valueOf(vendedor.getVentaMensual()));
        tf_venta_anual.setText(String.valueOf(vendedor.getVentaAnual()));
        jcb_departamento.setSelectedItem(vendedor.getDepartamento());

        tf_codigo.setEnabled(false);
        volverHabilitar();

        btn_agregar.setEnabled(false);
        btn_buscar.setEnabled(false);
        btn_modificar.setEnabled(true);
        btn_eliminar.setEnabled(true);
    }

    public void limpiarCampos2()
    {
        tf_nombre.setText("");
        tf_apellido.setText("");  
        tf_cargo.setText("");
        if(jcb_departamento.getItemCount() > 0)
            jcb_departamento.setSelectedIndex(0);
        tf_venta_mensual.setText("");
        tf_venta_anual.setText(""); 
    }

    public void modoLbl(boolean grabado, boolean modificado, boolean eliminado, boolean noEncontrado)
    {
        lbl_grabado.setVisible(grabado);
        lbl_modificado.setVisible(modificado);
        lbl_eliminado.setVisible(eliminado);
        lbl_noEncontrado.setVisible(noEncontrado);
    }

}