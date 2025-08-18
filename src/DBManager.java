import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class DBManager {

    private String URL;
    private String user;
    private String password;
    private Connection connection;

    // Constructor: carga la configuración
    public DBManager() {
        try (InputStream input = getClass().getClassLoader().getResourceAsStream("config.properties")) {
            Properties prop = new Properties();
            prop.load(input);

            URL = prop.getProperty("db.url");
            user = prop.getProperty("db.user");
            password = prop.getProperty("db.password");

        } catch (Exception e) {
            System.out.println("Error leyendo config.properties: " + e.getMessage());
        }
    }

    // Conecta a la base de datos y devuelve la conexión
    public Connection conectar() throws SQLException {
        if (URL == null || user == null || password == null) {
            throw new SQLException("Parámetros de conexión no inicializados");
        }
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            System.out.println("Driver MySQL no encontrado.");
        }
        connection = DriverManager.getConnection(URL, user, password);
        System.out.println("Conexión establecida con éxito.");
        return connection;
    }

    // Cierra la conexión
    public void desconectar() {
        try {
            if (connection != null && !connection.isClosed())
                connection.close();
            System.out.println("Conexión cerrada correctamente.");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
