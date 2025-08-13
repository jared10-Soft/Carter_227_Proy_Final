import javax.swing.*;
import java.sql.*;

public class Provincia 
{
    private String Codigo;
    private String Descripcion;
    private String Sql;

    public void setCodigo(String codigo)
    {
        Codigo = codigo;
    }

    public String getCodigo()
    {
        return Codigo;
    }

        public void setdescripcion(String descripcion)
    {
        Descripcion = descripcion;
    }

    public String getdescripcion()
    {
        return Descripcion;
    }

    public void cargarProvincias(JComboBox<String> jcb)
    {
        DB db = new DB();
        try 
        {
            Sql = "SELECT * FROM PROVINCIA ORDER BY DESCRIPCION";
            ResultSet rs = db.executeQuery(Sql);
            jcb.removeAllItems();
            jcb.addItem("Seleccione....");
            while (rs.next())   
            {
                Codigo = rs.getString("CODIGO");
                Descripcion = rs.getString("DESCRIPCION");
                jcb.addItem(Descripcion);
                
            }
            db.cerrar();

        } 
        catch (Exception e) 
        {
            System.out.println("Error al cargar provincias: " + e.toString());
        }
    }

    public String buscarCodigo(String codi)
    {
        DB db = new DB();
        try 
        {
            Sql = "SELECT * FROM PROVINCIA WHERE DESCRIPCION = '" + codi + "'";
            ResultSet rs = db.executeQuery(Sql);
            if (rs.next())
            {
                Codigo = rs.getString("CODIGO");
                Descripcion = rs.getString("DESCRIPCION");
            }
            else
            {
                Codigo = "";
                Descripcion = "";
            }
            db.cerrar();
        } 
        catch (Exception e) 
        {
            System.out.println("Error al buscar codigo de provincia: " + e.toString());
        }
        return Codigo;
        
    }

}
