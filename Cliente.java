import java.sql.*;
import javax.swing.*;
import javax.swing.table.*;

public class Cliente extends Persona 
{
    private String cedula;
    private String direccion;
    private String telefono;
    private String provincia;
    private Double compraAnual;
    private String sql;

    Provincia provincia2;


    public Cliente() {
        super();

    }

    public String getCedula() 
    { 
        return cedula; 
    }

    public void setCedula(String cedula) 
    { 
        this.cedula = cedula; 
    }

    public String getDireccion() 
    { 
        return direccion; 
    }

    public void setDireccion(String direccion) 
    { 
        this.direccion = direccion; 
    }

    public String getTelefono() 
    { 
        return telefono; 
    }

    public void setTelefono(String telefono) 
    { 
        this.telefono = telefono; 
    }

    public String getProvincia() 
    { 
        return provincia; 
    }

    public void setProvincia(String provincia) 
    { 
        this.provincia = provincia; 
    }

    public double getCompraAnual() 
    { 
        return compraAnual; 
    }

    public void setCompraAnual(double compraAnual) 
    { 
        this.compraAnual = compraAnual; 
    }

    public void cargarTabla(DefaultTableModel dtm_cliente)
    {
        DB db = new DB();
            
            dtm_cliente.setRowCount(0);
            dtm_cliente.setColumnCount(0);
 
            dtm_cliente.addColumn("Cedula");
            dtm_cliente.addColumn("Nombre");
            dtm_cliente.addColumn("Apellido");
            dtm_cliente.addColumn("Provincia");

            Object[] fila = new Object[4];
            

        try 
        {
            sql = "SELECT C.CEDULA, C.NOMBRE, C.APELLIDO, P.DESCRIPCION FROM CLIENTE C, PROVINCIA P WHERE C.PROVINCIA = P.CODIGO;";
            ResultSet rs = db.executeQuery(sql);
            while (rs.next())
            {
                fila[0] = rs.getString("CEDULA");
                fila[1] = rs.getString("NOMBRE");
                fila[2] = rs.getString("APELLIDO");
                fila[3] = rs.getString("DESCRIPCION");
                dtm_cliente.addRow(fila);
            }
            db.cerrar();
        } 
        catch (Exception e) 
        {
            System.out.println("Error al cargar la tabla de clientes: " + e.toString());
        }

    }

    public void eliminarDatos(String cedula)
    {
        DB db = new DB();
        sql = "DELETE FROM CLIENTE WHERE CEDULA = '" + cedula + "'";
        db.executeUpdate(sql);
    }

    public void almacenarProvincias(JComboBox<String> jcb_provincia)
    {
        provincia2 = new Provincia();
        provincia2.cargarProvincias(jcb_provincia);
    }
    
    public void buscarDatos(String cedula) 
    {
        DB db = new DB();
        try 
        {
            sql = "SELECT * FROM CLIENTE, PROVINCIA WHERE PROVINCIA = codigo AND CEDULA = '" + cedula + "'";
            ResultSet rs = db.executeQuery(sql);
            if (rs.next()) 
            {
                setCedula(rs.getString("CEDULA"));
                setNombre(rs.getString("NOMBRE"));
                setApellido(rs.getString("APELLIDO"));
                setDireccion(rs.getString("DIRECCION"));
                setTelefono(rs.getString("TELEFONO"));
                setProvincia(rs.getString("DESCRIPCION")); 
                setCompraAnual(rs.getInt("COMPRA_ANUAL"));
            }
            else 
            {
        
                setCedula("");
                setNombre("");
                setApellido("");
                setDireccion("");
                setTelefono("");
                setProvincia("");
                setCompraAnual(0);
            }
        db.cerrar();
        } 
            catch (Exception e) 
            {
                System.out.println("Error al buscar datos del cliente: " + e.toString());
            }
    }





    public void agregar()
    {
        DB db = new DB();
        sql = "INSERT INTO CLIENTE (CEDULA, NOMBRE, APELLIDO, DIRECCION, TELEFONO, PROVINCIA, COMPRA_ANUAL) VALUES ('" + getCedula() + "', '" + getNombre() + "', '" + getApellido() + "', '" + getDireccion() + "', '" + getTelefono() + "', '" + provincia2.buscarCodigo(getProvincia()) + "', " + getCompraAnual() + ")";
        db.executeUpdate(sql);
    }

    public void modificar()
    {
        DB db = new DB();
        sql = "UPDATE CLIENTE SET NOMBRE = '" + getNombre()  + "' , APELLIDO = '" + getApellido() + "', DIRECCION = '" + getDireccion() + "', TELEFONO = '" + getTelefono() + "', PROVINCIA = '" + provincia2.buscarCodigo(getProvincia()) + "', COMPRA_ANUAL = " + getCompraAnual() + " WHERE CEDULA = '" + getCedula() + "'";
        db.executeUpdate(sql);

    }

}
