import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        DBManager dbManager = new DBManager();
        ContactoDAO dao = new ContactoDAOMySQL(dbManager); // <-- cambiamos aquí
        int opcion;

        do {
            System.out.println("AGENDA DE CONTACTOS");
            System.out.println("1. Agregar Contacto");
            System.out.println("2. Modificar Contacto");
            System.out.println("3. Eliminar Contacto");
            System.out.println("4. Mostrar Contactos");
            System.out.println("5. Salir");
            System.out.print("Seleccione una opción: ");
            opcion = sc.nextInt();
            sc.nextLine();

            switch (opcion) {
                case 1:
                    System.out.print("Nombre: ");
                    String nombre = sc.nextLine();
                    System.out.print("Apellidos: ");
                    String apellidos = sc.nextLine();
                    System.out.print("Empresa: ");
                    String empresa = sc.nextLine();
                    System.out.print("Teléfono: ");
                    String telefono = sc.nextLine();
                    System.out.print("Correo: ");
                    String correo = sc.nextLine();
                    dao.agregarContacto(new Contacto(nombre, apellidos, empresa, telefono, correo));
                    break;

                case 2:
                    System.out.print("Ingrese el ID del contacto a modificar: ");
                    int idMod = sc.nextInt();
                    sc.nextLine();
                    System.out.print("Nuevo Nombre: ");
                    String nNombre = sc.nextLine();
                    System.out.print("Nuevos Apellidos: ");
                    String nApellidos = sc.nextLine();
                    System.out.print("Nueva Empresa: ");
                    String nEmpresa = sc.nextLine();
                    System.out.print("Nuevo Teléfono: ");
                    String nTelefono = sc.nextLine();
                    System.out.print("Nuevo Correo: ");
                    String nCorreo = sc.nextLine();
                    dao.modificarContacto(idMod, nNombre, nApellidos, nEmpresa, nTelefono, nCorreo);
                    break;

                case 3:
                    System.out.print("Ingrese el ID del contacto a eliminar: ");
                    int idDel = sc.nextInt();
                    dao.eliminarContacto(idDel);
                    break;

                case 4:
                    List<Contacto> contactos = dao.mostrarContactos();
                    System.out.println("\n--- LISTA DE CONTACTOS ---");
                    for (Contacto c : contactos) {
                        System.out.println("ID: " + c.getId());
                        System.out.println(c);
                        System.out.println("----------------------");
                    }
                    break;

                case 5:
                    System.out.println("Saliendo...");
                    break;

                default:
                    System.out.println("Opción inválida.");
            }

        } while (opcion != 5);

        sc.close();
    }
}