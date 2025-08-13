import java.sql.*;
import javax.swing.JComboBox;
import javax.swing.table.*;

public class Vendedor extends Persona
{
    private String codigo;
    private String departamento;
    private String cargo;
    private double ventaMensual;
    private double ventaAnual;
    private String sql;

    Departamento departamento2;
    

    public Vendedor() 
    {
        super();
    }
    
    public String getCodigo() 
    {
        return codigo;
    }

    public void setCodigo(String codigo) 
    {
        this.codigo = codigo;
    }

    public String getDepartamento() 
    {
        return departamento;
    }   

    public void setDepartamento(String departamento) 
    {
        this.departamento = departamento;
    }

    public String getCargo() 
    {
        return cargo;
    }

    public void setCargo(String cargo) 
    {
        this.cargo = cargo;
    }   

    public double getVentaMensual() 
    {
        return ventaMensual;
    }

    public void setVentaMensual(double ventaMensual) 
    {
        this.ventaMensual = ventaMensual;
    }

    public double getVentaAnual() {
        return ventaAnual;
    }

    public void setVentaAnual(double ventaAnual) 
    {
        this.ventaAnual = ventaAnual;
    }


    

    public void cargarTabla(DefaultTableModel modelo) 
    {
       DB db = new DB();

       modelo.setRowCount(0);
       modelo.setColumnCount(0);

        modelo.addColumn("Código");
        modelo.addColumn("Nombre");
        modelo.addColumn("Apellido");
        modelo.addColumn("Departamento");
        modelo.addColumn("Cargo");

        Object[] fila = new Object[5];

        try 
        {
            sql = "SELECT V.CODIGO, V.NOMBRE, V.APELLIDO, D.DESCRIPCION, V.CARGO FROM VENDEDOR V, DEPARTAMENTO D WHERE V.DEPARTAMENTO = D.CODIGO;";
            ResultSet rs = db.executeQuery(sql);
            while (rs.next())
            {
                fila[0] = rs.getString("CODIGO");
                fila[1] = rs.getString("NOMBRE");   
                fila[2] = rs.getString("APELLIDO");
                fila[3] = rs.getString("DESCRIPCION");
                fila[4] = rs.getString("CARGO");
                modelo.addRow(fila);
            }
            db.cerrar();
            
        } catch (Exception e) 
        {
            System.out.println("Error al cargar la tabla de vendedores: " + e.getMessage());
        }

    }

    public void eliminarDatos(String codigo)
    {
        DB db = new DB();
        sql = "DELETE FROM VENDEDOR WHERE CODIGO = '" + codigo + "'";
        db.executeUpdate(sql);
    }

    public void alamcenarDepartamento(JComboBox<String> jcb_departamento)
    {
        departamento2 = new Departamento();
        departamento2.cargarDepartamento(jcb_departamento);
    }

    public void buscarDatos(String codigo)
    {
        DB db = new DB();
        try
        {
            sql = "SELECT  * FROM VENDEDOR, DEPARTAMENTO WHERE VENDEDOR.CODIGO = '" + codigo + "' AND VENDEDOR.DEPARTAMENTO = DEPARTAMENTO.CODIGO;";
            ResultSet rs = db.executeQuery(sql);
            if(rs.next())
            {
                setCodigo(rs.getString("CODIGO"));
                setNombre(rs.getString("NOMBRE"));
                setApellido(rs.getString("APELLIDO"));
                setDepartamento(rs.getString("DESCRIPCION"));
                setCargo(rs.getString("CARGO"));
                setVentaMensual(rs.getDouble("VENTA_MENSUAL"));
                setVentaAnual(rs.getDouble("VENTA_ANUAL"));
            }
            else
            {
                setCodigo("");
                setNombre("");
                setApellido("");
                setDepartamento("");
                setCargo("");
                setVentaMensual(0);
                setVentaAnual(0);
            }
        }
        catch(Exception e)
        {
           System.out.println("Error al buscar datos del cliente: " + e.toString());
        }
    }

    public void agregar()
    {
        DB db = new DB();
        sql = "INSERT INTO VENDEDOR (CODIGO, NOMBRE, APELLIDO, DEPARTAMENTO, CARGO, VENTA_MENSUAL, VENTA_ANUAL) VALUES ('" + getCodigo() + "', '" + getNombre() + "', '" + getApellido() + "', '" + departamento2.buscarDepartamento(getDepartamento()) + "', '" + getCargo() + "', " + getVentaMensual() + ", " + getVentaAnual() + ")";
        db.executeUpdate(sql);
    }

    public void modificar()
    {
        DB db = new DB();
        sql = "UPDATE VENDEDOR SET NOMBRE = '" + getNombre() + "', APELLIDO = '" + getApellido() + "', CARGO = '" + getCargo() + "', VENTA_MENSUAL = " + getVentaMensual() + ", VENTA_ANUAL = " + getVentaAnual() + ", DEPARTAMENTO = '" + departamento2.buscarDepartamento(getDepartamento()) + "' WHERE CODIGO = '" + getCodigo() + "'";
        db.executeUpdate(sql);
    }

}