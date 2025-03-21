import java.util.ArrayList;
import java.util.Scanner;

class Producto {
    private String nombre;
    private int cantidad;

    public Producto(String nombre, int cantidad) {
        this.nombre = nombre;
        this.cantidad = cantidad;
    }

    public String getNombre() {
        return nombre;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    @Override
    public String toString() {
        return nombre + ": " + cantidad + " unidades";
    }
}

class Inventario {
    private ArrayList<Producto> inventario;

    public Inventario() {
        inventario = new ArrayList<>();
    }

    public void agregarProducto(String nombre, int cantidad) {
        for (Producto producto : inventario) {
            if (producto.getNombre().equalsIgnoreCase(nombre)) {
                producto.setCantidad(producto.getCantidad() + cantidad);
                System.out.println(cantidad + " unidades de " + nombre + " han sido agregadas al inventario.");
                return;
            }
        }
        inventario.add(new Producto(nombre, cantidad));
        System.out.println(cantidad + " unidades de " + nombre + " han sido agregadas al inventario.");
    }

    public void eliminarProducto(String nombre) {
        for (Producto producto : inventario) {
            if (producto.getNombre().equalsIgnoreCase(nombre)) {
                inventario.remove(producto);
                System.out.println(nombre + " ha sido eliminado del inventario.");
                return;
            }
        }
        System.out.println(nombre + " no existe en el inventario.");
    }

    public void actualizarCantidad(String nombre, int nuevaCantidad) {
        for (Producto producto : inventario) {
            if (producto.getNombre().equalsIgnoreCase(nombre)) {
                producto.setCantidad(nuevaCantidad);
                System.out.println("La cantidad de " + nombre + " ha sido actualizada a " + nuevaCantidad + " unidades.");
                return;
            }
        }
        System.out.println(nombre + " no existe en el inventario.");
    }

    public void mostrarInventario() {
        if (inventario.isEmpty()) {
            System.out.println("El inventario está vacío.");
        } else {
            System.out.println("Inventario actual:");
            for (Producto producto : inventario) {
                System.out.println("- " + producto);
            }
        }
    }
}

public class Main {
    public static void main(String[] args) {
        Inventario inventario = new Inventario();
        Scanner scanner = new Scanner(System.in);
        boolean salir = false;

        while (!salir) {
            System.out.println("\nMenú de Inventario:");
            System.out.println("1. Agregar producto");
            System.out.println("2. Eliminar producto");
            System.out.println("3. Actualizar cantidad de un producto");
            System.out.println("4. Mostrar inventario");
            System.out.println("5. Salir");

            System.out.print("Selecciona una opción: ");
            String opcion = scanner.nextLine();

            if (opcion.equals("1")) {
                System.out.print("Nombre del producto: ");
                String nombre = scanner.nextLine();
                System.out.print("Cantidad: ");
                int cantidad = Integer.parseInt(scanner.nextLine());
                inventario.agregarProducto(nombre, cantidad);
            } else if (opcion.equals("2")) {
                System.out.print("Nombre del producto a eliminar: ");
                String productoEliminar = scanner.nextLine();
                inventario.eliminarProducto(productoEliminar);
            } else if (opcion.equals("3")) {
                System.out.print("Nombre del producto a actualizar: ");
                String productoActualizar = scanner.nextLine();
                System.out.print("Nueva cantidad: ");
                int nuevaCantidad = Integer.parseInt(scanner.nextLine());
                inventario.actualizarCantidad(productoActualizar, nuevaCantidad);
            } else if (opcion.equals("4")) {
                inventario.mostrarInventario();
            } else if (opcion.equals("5")) {
                System.out.println("Saliendo del programa...");
                salir = true;
            } else {
                System.out.println("Opción no válida. Intenta de nuevo.");
            }
        }
        scanner.close();
    }
}