import java.util.Scanner;

public class App {
    private static boolean systemON = true;
    private static boolean systemON2 = true;
    private static boolean systemON3 = true;
    private static boolean systemON4 = true;
    private static Scanner sc = new Scanner(System.in);
    private static String disenoA = "-----------------------------------------------------------------";
    private static int binario = -1;

    public static void main(String[] args) throws Exception {
        // Imprime el encabezado de la calculadora
        System.out.println("***********************************************************");
        System.out.println("*  __        _______ _     ____ ___  __  __ _____ _ _ _   *");
        System.out.println("*  \\ \\      / / ____| |   / ___/ _ \\|  \\/  | ____| | | |  *");
        System.out.println("*   \\ \\ /\\ / /|  _| | |  | |  | | | | |\\/| |  _| | | | |  *");
        System.out.println("*    \\ V  V / | |___| |__| |__| |_| | |  | | |___|_|_|_|  *");
        System.out.println("*     \\_/\\_/  |_____|_____\\____\\___/|_|  |_|_____(_|_|_)  *");
        System.out.println("***********************************************************");
        System.out.println("\nBuen día querido usuario ;)\n");

        while(systemON){
            System.out.println(disenoA);
            System.out.println("¿Qué deseas hacer el día de hoy?\n");
            System.out.println("1. Ingresar números enteros y obtener binarios.\n" + "2. Ingresar números binarios y obtener su complemento a dos.\n" + "3. Ingresar número hexadecimal y obtener el número en decimal.\n" + "4. Ingresar un número decimal y recibir el número en hexadecimal.\n" + "5. Salir del programa.\n");
            System.out.println(disenoA);
            String seleccion = sc.nextLine();
            switch(seleccion){
                case "1":
                    System.out.println("Por favor, toma en cuenta que solamente puedes colocar números que puedan ser representados por 8 bits.");
                    System.out.println("El máximo número que puedes colocar es 255.");
                    System.out.println("Coloca tu número: ");
                    int decAbinario = obtenerEnteroValido(sc);
                    if(decAbinario > 255){
                        System.out.println(disenoA);
                        System.out.println("Has ingresado un número que está por encima del permitido.\n" + "Por favor, vuelve a intentarlo.\n");
                        System.out.println(disenoA);
                    } else{
                        System.out.println(disenoA);
                        System.out.println(decimalABinario(decAbinario));
                        System.out.println(disenoA);
                        System.out.println();
                    }
                    break;
                
                case "2":
                    System.out.println("Ingrese un número binario de 8 bits.");

                    StringBuilder binario8bits = new StringBuilder();
                    for (int i = 7; i >= 0; i--) {
                        int bit;
                        do {
                            System.out.println("Ingrese el bit en la posición " + i + ": ");
                            bit = obtenerEnteroValido(sc);
                            if (bit != 0 && bit != 1) {
                                System.out.println("Por favor, ingrese un bit válido (0 o 1).");
                            }
                        } while (bit != 0 && bit != 1);
            
                        binario8bits.append(bit);
                    }
                        
                    System.out.println("Número binario ingresado: " + binario8bits);
            
                    String complementoA2 = obtenerComplementoA2(binario8bits.toString());
                    System.out.println("El complemento a 2 es: " + complementoA2);
                    break;
                
                case "3":
                    char[] valoresPermitidos = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'A', 'B', 'C', 'D', 'E', 'F'};
                    char[] hexadecimal = new char[3];
                    int resultadoDecimal = 0;
                    char digito = '1';
                    for(int i =2; i >= 0; i--){
                        systemON3 = true;
                        while(systemON3){
                            System.out.println("Ingrese el dígito que desea para la " + i + " posición del hexadecimal.");
                            digito = obtenerCharValido(sc);
                            if(estaEnArray(digito, valoresPermitidos)){
                                systemON3 = false;
                            } else{
                                System.out.println("El dígito ingresado es inválido");
                                System.out.println("Este debe ser un número entre 0-9 o una letra de A-F");
                            }
                        }
                        int posicion = i;
                        hexadecimal[posicion] = digito;
                    }

                    String hexadecimalDado = String.valueOf(hexadecimal);
                    resultadoDecimal = Integer.parseInt(hexadecimalDado, 16);
                    System.out.println("El número decimal es de " + resultadoDecimal);
                    System.out.println(disenoA);
                    break;

                case "4":
                    int decimalHexa = 0;
                    systemON4 = true;
                    while(systemON4){
                        System.out.println("Ahora, ingrese el número decimal que quiere convertir a hexadecimal.");
                        decimalHexa = obtenerEnteroValido(sc);
                        if(decimalHexa <= 4095){
                            systemON4 = false;
                        } else{
                            System.out.println("Error: por favor, ingresa un número que pueda ser representado por 3 dígitos del sistema Hexadecimal.");
                            System.out.println("Debe ser menor o igual a 4095");
                        }
                    }
                    String hexaResultado = Integer.toHexString(decimalHexa).toUpperCase();
                    System.out.println("El número decimal " + decimalHexa + " en hexadecimal es: 0x" + hexaResultado);
                    break;

                case "5":
                    System.out.println("Qué tenga un buen día!!!");
                    systemON = false;
                    break;
            }  
        }

    }

    // Método para verificar si un valor está presente en un array
    public static boolean estaEnArray(char valor, char[] array) {
        for (char elemento : array) {
            if (elemento == valor) {
                return true;
            }
        }
        return false;
    }

    //Método para asegurarse que se ingrese un entero en los campos necesarios
    public static int obtenerEnteroValido(Scanner scanner) {
        int[] numbin = new int[8];
        int numero = 0;
        boolean entradaValida = false;
        System.out.println("------------------------");
        do {
            try {
                System.out.print("Por favor, ingresa un número entero: ");
                String entrada = scanner.nextLine();
                numero = Integer.parseInt(entrada);
                entradaValida = true;
                System.out.println("");
            } catch (NumberFormatException e) {
                System.out.println("Entrada no válida. Debes ingresar un número entero.");
            }
        } while (!entradaValida);

        return numero;
    }

    public static char obtenerCharValido(Scanner scanner) {
        char caracter = '\0'; // Inicializamos el caracter con un valor por defecto
        boolean entradaValida = false;
        System.out.println("------------------------");
        do {
            System.out.print("Por favor, ingresa un carácter: ");
            String entrada = scanner.nextLine();
            if (entrada.length() == 1) { // Verificamos si la entrada tiene exactamente un carácter
                caracter = entrada.charAt(0); // Obtenemos el primer carácter de la entrada
                entradaValida = true; // Marcamos la entrada como válida
            } else {
                System.out.println("Entrada no válida. Debes ingresar solo un carácter.");
            }
        } while (!entradaValida);

        return caracter;
    }

    public static String decimalABinario(int numero){
        StringBuilder binario = new StringBuilder();
        if(numero == 0){
            for(int i=0; i<=7; i++){
                binario.append(0);
            }
        } else{
            while(numero > 0){
                int residuo = numero % 2;
                binario.insert(0, residuo);
                numero = numero / 2;
            }
            while(binario.length() < 8){
                binario.insert(0, "0");
            }
        }
        binario.insert(4, " ");
        return binario.toString();
    }

    public static String obtenerComplementoA2(String binario) {
        StringBuilder complemento = new StringBuilder();
        
        // Invertir todos los bits
        for (int i = 0; i < binario.length(); i++) {
            char bit = binario.charAt(i);
            complemento.append((bit == '0') ? '1' : '0');
        }
        
        // Sumar 1 al resultado
        int carry = 1;
        for (int i = complemento.length() - 1; i >= 0; i--) {
            char bit = complemento.charAt(i);
            if (bit == '0' && carry == 1) {
                complemento.setCharAt(i, '1');
                carry = 0;
            } else if (bit == '1' && carry == 1) {
                complemento.setCharAt(i, '0');
                carry = 1;
            }
        }
        
        return complemento.toString();
    }

}
