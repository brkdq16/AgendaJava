
public class Contacto {

    private int id;
    private String nombre;
    private String apellido;
    private String empresa;
    private String telefono;
    private String correo;

    public Contacto(String nombre, String apellido, String empresa, String telefono, String correo) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.empresa = empresa;
        this.telefono = telefono;
        this.correo = correo;
    }

    public int getId() {
        return id;
    }

    public String getNombre() {
        return nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public String getEmpresa() {
        return empresa;
    }

    public String getTelefono() {
        return telefono;
    }

    public String getCorreo() {
        return correo;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public void setEmpresa(String empresa) {
        this.empresa = empresa;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    @Override
    public String toString() {
        return "Nombre: " + nombre + "\n"
                + "Apellido: " + apellido + "\n"
                + "Empresa: " + empresa + "\n"
                + "Teléfono: " + telefono + "\n"
                + "Correo: " + correo;
    }
}
