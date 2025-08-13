import javax.swing.*;
import javax.swing.table.*;
import java.awt.Font;
import java.awt.event.*;
import java.awt.Color;
import java.util.*;
import net.sf.jasperreports.engine.*;
import net.sf.jasperreports.view.*;



public class ReporteCliente implements ActionListener
{
    JFrame ventana;
    JButton btn_generarReporte, btn_generarReporteNormal;
    JRadioButton rb_apellido,rb_cedula, rb_compraAnual, rb_normal;
    ButtonGroup grupo;
    DefaultTableModel modeloClientes;
    JTable tablaClientes;
    JScrollPane jsp_cliente;
    Cliente cliente;

    ReporteCliente(JFrame frame)
    {
        ventana = frame;
        ventana.getContentPane().removeAll();
        ventana.setTitle("REPORTE DE CLIENTES");
        ventana.repaint();

        cliente = new Cliente();

        modeloClientes = new DefaultTableModel();
        tablaClientes = new JTable(modeloClientes);
        jsp_cliente = new JScrollPane(tablaClientes);
        jsp_cliente.setBounds(480, 50, 650, 420);
        cliente.cargarTabla(modeloClientes);
        ventana.add(jsp_cliente);
        

 
        rb_apellido = new JRadioButton("POR APELLIDO");
        rb_apellido.setBounds(50, 50, 300, 30);
        rb_apellido.setFont(new Font("Arial", Font.BOLD, 24));
        rb_apellido.setForeground(new Color(255, 255, 255));
        rb_apellido.setBackground(new Color(70, 130, 180));
        rb_apellido.addActionListener(this);
        ventana.add(rb_apellido);

        rb_cedula = new JRadioButton("POR CÉDULA");
        rb_cedula.setBounds(50, 100, 300, 30);
        rb_cedula.setFont(new Font("Arial", Font.BOLD, 24));
        rb_cedula.setForeground(new Color(255, 255, 255));
        rb_cedula.setBackground(new Color(70, 130, 180));
        rb_cedula.addActionListener(this);
        ventana.add(rb_cedula);

        rb_compraAnual = new JRadioButton("POR COMPRA ANUAL");
        rb_compraAnual.setBounds(50, 150, 300, 30);
        rb_compraAnual.setFont(new Font("Arial", Font.BOLD, 24));
        rb_compraAnual.setForeground(new Color(255, 255, 255));
        rb_compraAnual.setBackground(new Color(70, 130, 180));
        rb_compraAnual.addActionListener(this);
        ventana.add(rb_compraAnual);

        rb_normal = new JRadioButton("REPORTE NORMAL");
        rb_normal.setBounds(50, 350, 300, 30);
        rb_normal.setFont(new Font("Arial", Font.BOLD, 24));
        rb_normal.setForeground(new Color(255, 255, 255));
        rb_normal.setBackground(new Color(70, 130, 180));
        rb_normal.addActionListener(this);
        ventana.add(rb_normal);


        grupo = new ButtonGroup();
        grupo.add(rb_apellido);
        grupo.add(rb_cedula);
        grupo.add(rb_compraAnual);
        grupo.add(rb_normal);

        btn_generarReporte = new JButton("GENERAR REPORTE");
        btn_generarReporte.setBounds(50, 200, 300, 50);
        btn_generarReporte.setFont(new Font("Arial", Font.BOLD, 24));
        btn_generarReporte.setForeground(new Color(0, 0, 0));
        btn_generarReporte.setBackground(new Color(211, 211, 211));
        btn_generarReporte.setEnabled(false);
        btn_generarReporte.addActionListener(this);
        ventana.add(btn_generarReporte);

        btn_generarReporteNormal = new JButton("GENERAR REPORTE");
        btn_generarReporteNormal.setBounds(50, 400, 300, 50);
        btn_generarReporteNormal.setFont(new Font("Arial", Font.BOLD, 24));
        btn_generarReporteNormal.setForeground(new Color(0, 0, 0));
        btn_generarReporteNormal.setBackground(new Color(211, 211, 211));
        btn_generarReporteNormal.setEnabled(false);
        btn_generarReporteNormal.addActionListener(this);
        ventana.add(btn_generarReporteNormal);

        ventana.repaint();
    }

    public void actionPerformed(ActionEvent e)
    {
        System.out.println("HOLAAA");
        verificarPresionado();

        if(e.getSource() == btn_generarReporteNormal)
            generarReporte();
        if(e.getSource() == btn_generarReporte)
            generarReporteOrden();
        
    }


    public void verificarPresionado()
    {
        if (rb_cedula.isSelected() || rb_apellido.isSelected() || rb_compraAnual.isSelected()) 
        {
            btn_generarReporteNormal.setEnabled(false);
            btn_generarReporte.setEnabled(true); 
        } 
        else if (rb_normal.isSelected()) 
        {
            btn_generarReporte.setEnabled(false); 
            btn_generarReporteNormal.setEnabled(true);
        }
    }

    public void generarReporte()
    {
        try 
        {
            DB db = new DB();
            db.abrir();

            Map<String,Object> parametro = new HashMap<String,Object>();
            JasperPrint jasperPrint = JasperFillManager.fillReport("Reporte_Cliente.jasper", parametro, db.connection());
            JasperViewer jasperViewer = new JasperViewer(jasperPrint, false);
            jasperViewer.setVisible(true);

        } 
        catch (Exception e)
        {
            System.out.println("Error al generar Reporte: " + e.toString());
        }
    }

    public void generarReporteOrden()
    {
        try 
        {
            String orden = "APELLIDO";
            if(rb_apellido.isSelected())
                orden = "APELLIDO";
            if(rb_cedula.isSelected())
                orden = "CEDULA";
            if(rb_compraAnual.isSelected())
                orden = "COMPRA_ANUAL";

            DB db = new DB();
            db.abrir();

            Map<String,Object> parametro = new HashMap<String,Object>();
            parametro.put("Orden", orden);
            
            JasperPrint jasperPrint = JasperFillManager.fillReport("Reporte_Cliente_Orden.jasper", parametro, db.connection());

            JasperViewer jasperViewer = new JasperViewer(jasperPrint, false);
            jasperViewer.setVisible(true);


        } 
        catch (Exception e) 
        {
            System.out.println("Error al generar Reporte: " + e.toString());
        }
    }
        
}
