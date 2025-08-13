import javax.swing.*;
import javax.swing.table.*;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.Color;
import java.util.*;
import net.sf.jasperreports.engine.*;
import net.sf.jasperreports.view.*;


public class ReporteVendedor implements ActionListener{
    JFrame ventana;
    JButton btn_generarReporte, btn_generarReporteNormal;
    JRadioButton rb_apellido,rb_codigo, rb_departamento, rb_normal;
    ButtonGroup grupo;
    DefaultTableModel modeloVendedor;
    JTable tablaVendedor;
    JScrollPane jsp_vendedor;
    Vendedor vendedor;

    ReporteVendedor(JFrame frame)
    {
        ventana = frame;
        ventana.getContentPane().removeAll();
        ventana.setTitle("REPORTE DE VENDEDORES");
        ventana.repaint();

        vendedor = new Vendedor();

        modeloVendedor = new DefaultTableModel();
        tablaVendedor = new JTable(modeloVendedor);
        jsp_vendedor = new JScrollPane(tablaVendedor);
        jsp_vendedor.setBounds(480, 50, 650, 420);
        vendedor.cargarTabla(modeloVendedor);
        ventana.add(jsp_vendedor);
        

 
        rb_apellido = new JRadioButton("POR APELLIDO");
        rb_apellido.setBounds(50, 50, 300, 30);
        rb_apellido.setFont(new Font("Arial", Font.BOLD, 24));
        rb_apellido.setForeground(new Color(255, 255, 255));
        rb_apellido.setBackground(new Color(70, 130, 180));
        rb_apellido.addActionListener(this);
        ventana.add(rb_apellido);

        rb_codigo = new JRadioButton("POR CODIGO");
        rb_codigo.setBounds(50, 100, 300, 30);
        rb_codigo.setFont(new Font("Arial", Font.BOLD, 24));
        rb_codigo.setForeground(new Color(255, 255, 255));
        rb_codigo.setBackground(new Color(70, 130, 180));
        rb_codigo.addActionListener(this);
        ventana.add(rb_codigo);

        rb_departamento = new JRadioButton("POR DEPARTAMENTO");
        rb_departamento.setBounds(50, 150, 300, 30);
        rb_departamento.setFont(new Font("Arial", Font.BOLD, 24));
        rb_departamento.setForeground(new Color(255, 255, 255));
        rb_departamento.setBackground(new Color(70, 130, 180));
        rb_departamento.addActionListener(this);
        ventana.add(rb_departamento);

        rb_normal = new JRadioButton("REPORTE NORMAL");
        rb_normal.setBounds(50, 350, 300, 30);
        rb_normal.setFont(new Font("Arial", Font.BOLD, 24));
        rb_normal.setForeground(new Color(255, 255, 255));
        rb_normal.setBackground(new Color(70, 130, 180));
        rb_normal.addActionListener(this);
        ventana.add(rb_normal);


        grupo = new ButtonGroup();
        grupo.add(rb_apellido);
        grupo.add(rb_codigo);
        grupo.add(rb_departamento);
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
        if (rb_codigo.isSelected() || rb_apellido.isSelected() || rb_departamento.isSelected())
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
            JasperPrint jasperPrint = JasperFillManager.fillReport("Reporte_Vendedor.jasper",parametro,db.connection()); 
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
            String orden = "CODIGO";
            if(rb_codigo.isSelected())
                orden = "CODIGO";
            if(rb_apellido.isSelected())
                orden = "APELLIDO";
            if(rb_departamento.isSelected())
                orden = "DEPARTAMENTO";

            DB db = new DB();
            db.abrir();

            Map<String,Object> parametro = new HashMap<String,Object>();
            parametro.put("Orden", orden);
            JasperPrint jasperPrint = JasperFillManager.fillReport("Reporte_Vendedor_Orden.jasper",parametro,db.connection()); 
            JasperViewer jasperViewer = new JasperViewer(jasperPrint, false);
            jasperViewer.setVisible(true);


        } 
        catch (Exception e) 
        {
            System.out.println("Error al generar Reporte: " + e.toString());
        }
    }

}
