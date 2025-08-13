import javax.swing.*;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.*;


public class CARTER_227_PROY_FINAL implements ActionListener
{

    JFrame ventana;
    JMenuBar menuBar;
    JMenu menu_inicio, menu_mantenimiento,menu_reporte;
    JMenuItem menuItem_Presentacion, menuItem_salir;
    JMenuItem menuItem_Cliente, menuItem_Vendedor;
    JMenuItem menuItem_Cliente_reporte, menuItem_Vendedor_reporte;
    JLabel lbl_introduccion;
    
    

    public static void main(String[] args)
    {
        new CARTER_227_PROY_FINAL();
    }

    CARTER_227_PROY_FINAL()
    {
        ventana = new JFrame("PROYECTO FINAL");
        ventana.setBounds(100, 100, 1200, 600);
        ventana.setLayout(null);
        ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        ventana.getContentPane().setBackground(new Color(70, 130, 180));
        ventana.setVisible(true);  
        


        lbl_introduccion = new JLabel("Sistema de Registros y Reportes");
        lbl_introduccion.setBounds(270,250, 1400, 60);
        lbl_introduccion.setFont(new Font("Arial", Font.BOLD, 40));
        lbl_introduccion.setForeground(new Color(255, 255, 255));
        ventana.add(lbl_introduccion);


        menuBar = new JMenuBar();
       

        menu_inicio = new JMenu("Inicio");
        menu_inicio.setFont(new Font("Arial", Font.BOLD, 16));
        menuBar.add(menu_inicio);
        
        menuItem_Presentacion = new JMenuItem("Presentación");
        menuItem_Presentacion.setFont(new Font("Arial", Font.PLAIN, 16));
        menuItem_Presentacion.addActionListener(this);
        menu_inicio.add(menuItem_Presentacion);


        menuItem_salir = new JMenuItem("Salir");
        menuItem_salir.setFont(new Font("Arial", Font.PLAIN, 16));
        menuItem_salir.addActionListener(this);
        menu_inicio.add(menuItem_salir);



        menu_mantenimiento = new JMenu("Mantenimiento");
        menu_mantenimiento.setFont(new Font("Arial", Font.BOLD, 16));
        menuBar.add(menu_mantenimiento);

        menuItem_Cliente = new JMenuItem("Datos Cliente");
        menuItem_Cliente.setFont(new Font("Arial", Font.PLAIN, 16));
        menuItem_Cliente.addActionListener(this);
        menu_mantenimiento.add(menuItem_Cliente);

        menuItem_Vendedor = new JMenuItem("Datos Vendedor");
        menuItem_Vendedor.setFont(new Font("Arial", Font.PLAIN, 16));
        menuItem_Vendedor.addActionListener(this);
        menu_mantenimiento.add(menuItem_Vendedor);


        menu_reporte = new JMenu("Reporte");
        menu_reporte.setFont(new Font("Arial", Font.BOLD, 16));
        menu_reporte.addActionListener(this);
        menuBar.add(menu_reporte);

        menuItem_Cliente_reporte = new JMenuItem("Reporte Cliente");
        menuItem_Cliente_reporte.setFont(new Font("Arial", Font.PLAIN, 16));
        menuItem_Cliente_reporte.addActionListener(this);
        menu_reporte.add(menuItem_Cliente_reporte);

        menuItem_Vendedor_reporte = new JMenuItem("Reporte Vendedor");
        menuItem_Vendedor_reporte.setFont(new Font("Arial", Font.PLAIN, 16));
        menuItem_Vendedor_reporte.addActionListener(this);
        menu_reporte.add(menuItem_Vendedor_reporte);


        ventana.setJMenuBar(menuBar);

        ventana.setVisible(true);
        ventana.repaint();


    }

    public void actionPerformed(ActionEvent e)
    {
        System.out.println("Hola soy Kenneth");
        if(e.getSource() == menuItem_Presentacion)
            new Presentacion(ventana);
        else if(e.getSource() == menuItem_salir)
            System.exit(0);
        else if(e.getSource() == menuItem_Cliente)
            new pantallaCliente(ventana);
        else if(e.getSource() == menuItem_Vendedor)
            new pantallaVendedor(ventana);
        else if(e.getSource() == menuItem_Cliente_reporte)
            new ReporteCliente(ventana);
        else if(e.getSource() == menuItem_Vendedor_reporte)
            new ReporteVendedor(ventana);        
    }
}
