import java.io.*;


public class Ej1 {
    private static String[][] leerVentas(String nombreFichero, String[][] datos) {
        String linea;
        int numeroProductos = datos.length;

        try (BufferedReader bf = new BufferedReader(new FileReader(nombreFichero))) {
            while ((linea = bf.readLine()) != null) {
                String[] partesLinea = linea.split(",");
                // partesLinea[0] tiene el nombre del producto
                // partesLinea[1] tiene la cantidad en forma de String
                // System.out.println(partesLinea[0]+":"+partesLinea[1]);


                int indice = 0;
                boolean encontrado = false;

                while (indice < numeroProductos && !encontrado) {
                    if (datos[indice][0].equals(partesLinea[0])) {
                        encontrado = true;
                    } else {
                       indice++;
                    }
                    // Si lo he encontrado
                    if (encontrado) {
                        // 1. Es el primero
                        if(datos[indice][1]==null){
                            datos[numeroProductos][0] = partesLinea[0];
                            datos[numeroProductos][1] = partesLinea[1];

                        } else{
                            // 2. Ya existe el producto porque indice apunta a su posicion
                            int cantidad1= Integer.valueOf(datos[indice][1]);
                            int cantidad2 = Integer.valueOf(datos[indice][0]);
                            datos[indice][1] = String.valueOf(cantidad1);

                        }

                    } else {
                        // Añadir elemento
                        // En dinámico add
                        datos[numeroProductos][0] = partesLinea[0];
                        datos[numeroProductos][1] = partesLinea[1];
                    }
                }
                bf.close();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return datos;
    }

    public static void crearFichero(String nombreFichero) throws IOException {
        File Fichero = new File(nombreFichero);
        if (!Fichero.exists()) {
            if (Fichero.createNewFile()) {
                System.out.println("Crea el fichero");
            }
        }
    }

    public static void VisualizarDatos(String[][] datos) {
        int i=0;
        while(datos[i][0]!=null){
            System.out.println(datos[i][0] + ":");
            System.out.println(datos[i][1]);
            i++;
        }
    }

    public static void main(String[] args) {
        String[][] datos = new String[100][2]; // Maximo 100 productos
        String nombreFichero = "ventasProductos.txt";
        try {
            crearFichero(nombreFichero);
        } catch (IOException e) {
            e.printStackTrace();
        }
        VisualizarDatos(leerVentas(nombreFichero, datos));


    }
}