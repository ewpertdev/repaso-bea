import java.io.*;


public class Ej1 {
    private static void leerVentas(String nombreFichero, String[][]datos){
        String linea;
        int numeroProductos=datos.length;

        try(BufferedReader bf= new BufferedReader(new FileReader(nombreFichero)))
        {
            while((linea = bf.readLine()) != null){
                String[] partesLinea= linea.split(",");
                //partesLinea[0] tiene el nombre del producto
                //partesLinea[1] tiene la cantidad en forma de String

                int indice=0;
                boolean encontrado=false;

                while(indice<numeroProductos && !encontrado){
                    if(datos[indice][0].equals(partesLinea[0])){
                        encontrado=true;
                    }else{
                        indice++;
                    }

                    // Si lo he encontrado
                    if(encontrado) {
                        // ya existe el producto porque indice apunta a su posicion
                        int cantidad = Integer.parseInt(datos[indice][1])+Integer.parseInt(partesLinea[0]);
                    }

                }
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }
    public static void main(String[] args) {
        String[][] datos = new String[100][2]; // Maximo 100 productos
        String nombreFichero = "ventasProductos.txt";

    }
}