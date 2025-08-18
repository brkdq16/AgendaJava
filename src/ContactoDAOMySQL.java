import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ContactoDAOMySQL implements ContactoDAO {

    private DBManager dbManager;

    public ContactoDAOMySQL(DBManager dbManager) {
        this.dbManager = dbManager;
    }

    @Override
    public void agregarContacto(Contacto contacto) {
        String sql = "INSERT INTO contactos (nombre, apellido, empresa, telefono, correo) VALUES (?, ?, ?, ?, ?)";
        try (Connection conn = dbManager.conectar();
                PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, contacto.getNombre());
            stmt.setString(2, contacto.getApellido());
            stmt.setString(3, contacto.getEmpresa());
            stmt.setString(4, contacto.getTelefono());
            stmt.setString(5, contacto.getCorreo());
            stmt.executeUpdate();

            System.out.println("Contacto agregado correctamente en la base de datos.");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void modificarContacto(int id, String nuevoNombre, String nuevoApellido, String nuevaEmpresa,
            String nuevoTelefono, String nuevoCorreo) {
        String sql = "UPDATE contactos SET nombre=?, apellido=?, empresa=?, telefono=?, correo=? WHERE id=?";
        try (Connection conn = dbManager.conectar();
                PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, nuevoNombre);
            stmt.setString(2, nuevoApellido);
            stmt.setString(3, nuevaEmpresa);
            stmt.setString(4, nuevoTelefono);
            stmt.setString(5, nuevoCorreo);
            stmt.setInt(6, id);

            int filas = stmt.executeUpdate();
            if (filas > 0) {
                System.out.println("Contacto modificado correctamente.");
            } else {
                System.out.println("No se encontró un contacto con ese ID.");
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void eliminarContacto(int id) {
        String sql = "DELETE FROM contactos WHERE id=?";
        try (Connection conn = dbManager.conectar();
                PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setInt(1, id);
            int filas = stmt.executeUpdate();
            if (filas > 0) {
                System.out.println("Contacto eliminado correctamente.");
            } else {
                System.out.println("No se encontró un contacto con ese ID.");
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public List<Contacto> mostrarContactos() {
        List<Contacto> contactos = new ArrayList<>();
        String sql = "SELECT * FROM contactos";

        try (Connection conn = dbManager.conectar();
                Statement stmt = conn.createStatement();
                ResultSet rs = stmt.executeQuery(sql)) {

            while (rs.next()) {
                Contacto c = new Contacto(
                        rs.getString("nombre"),
                        rs.getString("apellido"),
                        rs.getString("empresa"),
                        rs.getString("telefono"),
                        rs.getString("correo"));
                c.setId(rs.getInt("id")); // asignar el ID de la BD
                contactos.add(c);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return contactos;
    }
}
