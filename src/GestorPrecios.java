import java.util.*;

public class Main{
    public static ArrayList<Double> precios=new ArrayList<>();
    public static Scanner datos=new Scanner(System.in);
    public static void menu(){
        do {
            try {
                System.out.print("===== MENÚ DE PRECIOS INMOBILIARIOS =====\n" +
                        "1. Ingresar precio\n" +
                        "2. Mostrar todos los precios\n" +
                        "3. Mostrar precio más alto\n" +
                        "4. Mostrar precio más bajo\n" +
                        "5. Mostrar precio iguales\n" +
                        "6. Buscar un precio específico\n" +
                        "7. Salir\n" +
                        "Seleccione una opción: ");
                int opcion=datos.nextInt();
                datos.nextLine();
                switch (opcion){
                    case 1:
                        registrarPrecio();
                        break;
                    case 2:
                        mostrarPrecio();
                        break;
                    case 3:
                        precioAlto();
                        break;
                    case 4:
                        precioBajo();
                        break;
                    case 5:
                        precioIguales();
                        break;
                    case 6:
                        buscarPrecio();
                        break;
                    case 7:
                        System.out.println("Saliendo...");
                        return;
                    default:
                        System.out.println("Opcion incorrecta");
                        break;
                }
            }catch (InputMismatchException e){
                System.err.println("Ingresaste una letra");
                datos.nextLine();
            }
        }while (true);
    }

    public static void registrarPrecio(){
        try {
            System.out.print("Ingresa el precio: $");
            double precio = datos.nextDouble();
            datos.nextLine();
            if (precio>0){
                precios.add(precio);
            }else{
                System.out.println("Precio invalido");
            }
        }catch (InputMismatchException e){
            System.err.println("Ingresaste un precio incorrecto");
            datos.nextLine();
        }
    }

    public static void mostrarPrecio(){
        if (precios.isEmpty()){
            System.out.println("No hay precios registrados");
        }else {
            for(int i=0;i<precios.size();i++){
                System.out.println((i+1)+".- $"+precios.get(i));
            }
        }
    }

    public static void precioAlto(){
        if (precios.isEmpty()){
            System.out.println("No hay precios registrados");
        }else {
            System.out.println("Precio mas alto: $"+Collections.max(precios));
        }
    }

    public static void precioBajo(){
        if (precios.isEmpty()){
            System.out.println("No hay precios registrados");
        }else {
            System.out.println("Precio mas bajo: $"+Collections.min(precios));
        }
    }

    public static void precioIguales(){
        if (precios.isEmpty()) {
            System.out.println("No hay precios registrados");
            return;
        }

        Set<Double> yaContados = new HashSet<>();

        for (int i = 0; i < precios.size(); i++) {

            Double precioActual = precios.get(i);

            if (yaContados.contains(precioActual)) {
                continue;
            }

            int contador = 0;

            for (int j = 0; j < precios.size(); j++) {
                if (precioActual.equals(precios.get(j))) {
                    contador++;
                }
            }

            System.out.println("Hay " + contador + " viviendas con el precio: $" + precioActual);

            yaContados.add(precioActual);
        }
    }

    public static void buscarPrecio(){
        try {
            if (precios.isEmpty()){
                System.out.println("No hay precios registrados");
                return;
            }
            System.out.print("Ingrese el precio a buscar: $");
            double precio = datos.nextDouble();
            if (precios.contains(precio)) {
                System.out.println("Precio encontrado");
            } else {
                System.out.println("El precio no esta en la lista");
            }
        }catch (InputMismatchException e){
            System.err.println("No ingresaste un precio");
        }
    }

    public static void main(String[] args){
        menu();
    }


}