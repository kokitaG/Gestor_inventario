import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        String producto = "";
        ArrayList<String> productos = new ArrayList<>();
        int cantidadProducto;
        ArrayList<Integer> cantidades = new ArrayList<>();
        int seleccion;
        Scanner scanner = new Scanner(System.in);
        System.out.println("MENU SISTEMA INVENTARIO");
        do {
            System.out.println("Selecciones la opcion que necesita:");
            System.out.println("1. Agregar Producto");
            System.out.println("2. Mostrar Producto");
            System.out.println("3. Actualizar Cantidad de Producto");
            System.out.println("4. Eliminar Producto");
            System.out.println("5. Salir");
            System.out.println("Ingrese una opcion");
            seleccion = scanner.nextInt();
            if (seleccion == 1) {
                System.out.println("Ingrese el producto que desea Agregar al Inventario: ");
                producto = scanner.next();
                productos.add(producto);
                System.out.println("Ingrese la cantidad del producto que agrego al Inventario: ");
                cantidadProducto = scanner.nextInt();
                cantidades.add(cantidadProducto);
            } else if (seleccion == 2) {
                System.out.println("Existencia de productos: " );
                for (int i = 0; i < productos.size(); i++) {
                    System.out.println("- " + productos.get(i) + " (Cantidad: " + cantidades.get(i) + ")");
                }
                /*for (String prod : productos) {
                    System.out.println("- " + prod + "  " + cantidades);
                }*/
            }
            if (seleccion == 3) {
                System.out.println("Lista inicial de productos:" );
                for (int i = 0; i < productos.size(); i++) {
                    System.out.println("- " + productos.get(i) + " (Cantidad: " + cantidades.get(i) + ")");                }
                System.out.println("Ingrese el nombre del producto que desea actualizar:");
                String productoActualizar = scanner.next();
                int indice = productos.indexOf(productoActualizar);
                if (indice != -1) {
                    System.out.println("Ingrese la nueva cantidad de existencias:");
                    int nuevaCantidad = scanner.nextInt();
                    cantidades.set(indice, nuevaCantidad);
                    System.out.println("Existencia de productos: ");
                    for (int i = 0; i < productos.size(); i++) {
                        System.out.println("- " + productos.get(i) + " (Cantidad: " + cantidades.get(i) + ")");}

                }
            }
            if (seleccion == 4) {
                System.out.println("Ingrese el nombre del producto que desea eliminar:" + productos);
                String productoEliminar = scanner.next();
                int indice = productos.indexOf(productoEliminar);
                if (indice != -1) {
                    productos.remove(indice);
                    cantidades.remove(indice);
                    System.out.println("Producto eliminado correctamente.");
                }
                System.out.println("Lista actualizada de productos:");
                for (int i = 0; i < productos.size(); i++) {
                    System.out.println("- " + productos.get(i) + " (Cantidad: " + cantidades.get(i) + ")");
                }
            }

        } while (seleccion<5);
        scanner.close();

    }
}