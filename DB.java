import java.sql.*;

public class DB {
    String URL, USER,PASSWORD;
    Connection connection;
    Statement statement;
    ResultSet resultSet;

    DB()
    {
        URL = "jdbc:mysql://localhost:3306/CARTER_227_PROY_FINAL";
        USER = "root";
        PASSWORD = "root";
    }

    public void abrir()
    {
        try
        {
            connection = DriverManager.getConnection(URL, USER, PASSWORD);
            statement = connection.createStatement();  
        }
        catch (Exception e) 
        {
            System.out.println("Error al abrir la base de datos: " + e.toString());
        }

    }

    public void cerrar()
    {
        try
        {
            if (resultSet != null)
            {
                resultSet.close();
                statement.close();
                connection.close();
            }
        }
        catch (Exception e) 
        {
            System.out.println("Error al cerrar la base de datos: " + e.toString());
        }
    }

    public ResultSet executeQuery(String sql)
    {
        try
        {
            abrir();
            resultSet = statement.executeQuery(sql);
        }
        catch(Exception e)
        {
            System.out.println("error query " + e.toString());
        }
            return resultSet;
    }




    public void executeUpdate(String sql)
    {
        try
        {
            abrir();
            statement.executeUpdate(sql);
        }
        catch(Exception e)
        {
            System.out.println("error update " + e.toString());
        }
        finally
        {
            cerrar();
        }
        
    }

    public Connection connection()
    {
        return connection;
    }

}
