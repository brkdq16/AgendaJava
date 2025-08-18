import java.util.List;

// Estructura para agregar, modificar, eliminar y mostrar contactos
public interface ContactoDAO {
    void agregarContacto(Contacto contacto);

    void modificarContacto(int id, String nuevoNombre, String nuevoApellido, String nuevaEmpresa, String nuevoTelefono,
            String nuevoCorreo);

    void eliminarContacto(int id);

    List<Contacto> mostrarContactos();

    static int contadorId = 1;
}