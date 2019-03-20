package conexionBaseDatos;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import textocolor.Imprimir;

/**
 *
 * @author Fabian
 */
public class Conexion {

    private static Connection conexion = null;

    public static Connection Conectar(String Nombre, String password, String BaseDeDatos, String Driver) {
//            String BaseDeDatos = "jdbc:oracle:thin:@localhost:1521:XE";
//            String Driver = "oracle.jdbc.OracleDriver";
        try {
            Class.forName(Driver);
            conexion = DriverManager.getConnection(BaseDeDatos, Nombre, password);
            if (conexion != null) {
                Imprimir.info("Conexion exitosa a esquema " + Nombre);
            } else {
                Imprimir.err("Conexion fallida");
            }
        } catch (ClassNotFoundException | SQLException e) {
            Imprimir.adv("Error con la coneccion de la BD \n" + e);
        }

        return conexion;
    }

    public Connection getConexion() {
        return conexion;
    }

    public void setConexion(Connection conexion) {
        this.conexion = conexion;
    }
}
