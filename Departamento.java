import javax.swing.*;
import java.sql.*;

public class Departamento {
    private String codigo;
    private String descripcion;
    private String sql;

    public String getCodigo()
    {
        return codigo;
    }

    public void setCodigo(String Codigo)
    {
        codigo = Codigo;
    }

    public String getdescripcion()
    {
        return descripcion;
    }

    public void setdescripcion(String Descripcion)
    {
        descripcion = Descripcion;
    }

    public void cargarDepartamento(JComboBox<String> jcb)
    {
        DB db = new DB();
        try 
        {
            sql = "SELECT * FROM DEPARTAMENTO ORDER BY DESCRIPCION";
            ResultSet rs = db.executeQuery(sql);
            jcb.removeAllItems();
            jcb.addItem("Seleccione....");
            while (rs.next())   
            {
                codigo = rs.getString("CODIGO");
                descripcion = rs.getString("DESCRIPCION");
                jcb.addItem(descripcion);
                
            }
            db.cerrar();

        } 
        catch (Exception e) 
        {
            System.out.println("Error al cargar provincias: " + e.toString());
        }
    }

    public String buscarDepartamento(String codigo1)
    {
        DB db = new DB();
        try 
        {
            sql = "SELECT * FROM DEPARTAMENTO WHERE DESCRIPCION = '" + codigo1 + "'";
            ResultSet rs = db.executeQuery(sql);
            if (rs.next()) 
            {
                codigo = rs.getString("CODIGO");
                descripcion = rs.getString("DESCRIPCION");  
            } 
            else 
            {
                codigo = "";
                descripcion = "";
            }
            db.cerrar();

        } 
        catch (Exception e) 
        {
            System.out.println("Error al buscar departamento: " + e.toString());
        }
        return codigo;


    }
}