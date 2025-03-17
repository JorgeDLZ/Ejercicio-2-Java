import java.util.*;

public class Main {
    public static void main(String[] args) {

        //CAMBIOS DEL CÓDIGO
        //Validación de montos en las transacciones
        //Validación para evitar cuentas duplicadas
        //Validación en la entrada de montos
        //Tope de retiro de 100000
        //Opción de salida en el menú
        //Mensajes informativos y de error

        Scanner scanner = new Scanner(System.in);
        int op;
        double monto;
        boolean estado = true;

        List<cuenta_bancaria> lstBanco = new ArrayList<>();

        do {
            System.out.println("""
                    1. CREAR CLIENTE
                    2. MOSTRAR TODAS LAS CUENTAS
                    3. MOSTRAR INFORMACIÓN DE UNA CUENTA ESPECÍFICA
                    4. DEPOSITAR
                    5. RETIRAR
                    6. SALIR
                    """);
            op = scanner.nextInt();
            switch (op) {
                case 1 -> {
                    System.out.println("Ingrese el nombre del titular");
                    String titular = scanner.next();
                    System.out.println("Ingrese el saldo de la cuenta");
                    double saldo = scanner.nextDouble();
                    System.out.println("Ingrese el número de la cuenta");
                    String numeroCuenta = scanner.next();


                    boolean existe = false;
                    for (cuenta_bancaria cuenta : lstBanco) {
                        if (cuenta.getNumerocuenta().equalsIgnoreCase(numeroCuenta)) {
                            System.out.println("La cuenta ya existe. No se puede duplicar.");
                            existe = true;
                            break;
                        }
                    }
                    if (!existe) {
                        lstBanco.add(new cuenta_bancaria(titular, saldo, numeroCuenta));
                    }
                }
                case 2 -> {
                    for (cuenta_bancaria cu : lstBanco) {
                        System.out.println(cu);
                    }
                }
                case 3 -> {
                    System.out.println("INGRESE EL NÚMERO DE CUENTA");
                    String ncuenta = scanner.next();
                    boolean encontrado = false;
                    for (cuenta_bancaria cuenta : lstBanco) {
                        if (cuenta.getNumerocuenta().equalsIgnoreCase(ncuenta)) {
                            System.out.println(cuenta);
                            encontrado = true;
                        }
                    }
                    if (!encontrado) {
                        System.out.println("Cuenta no encontrada.");
                    }
                }
                case 4 -> {
                    System.out.println("DEPOSITAR");
                    System.out.println("INGRESE EL NÚMERO DE CUENTA");
                    String ncuenta = scanner.next();
                    boolean encontrado = false;
                    for (cuenta_bancaria cuenta : lstBanco) {
                        if (cuenta.getNumerocuenta().equalsIgnoreCase(ncuenta)) {
                            do {
                                System.out.println("Cuánto dinero desea depositar");
                                monto = scanner.nextDouble();
                            } while (monto <= 0);
                            cuenta.depositarDinero(monto);
                            System.out.println(cuenta);
                            encontrado = true;
                        }
                    }
                    if (!encontrado) {
                        System.out.println("Cuenta no encontrada.");
                    }
                }
                case 5 -> {
                    System.out.println("RETIRAR");
                    System.out.println("Ingrese el número de cuenta de la cual desea retirar");
                    String nCuenta = scanner.next();
                    boolean encontrado = false;
                    for (cuenta_bancaria cuenta : lstBanco) {
                        if (cuenta.getNumerocuenta().equalsIgnoreCase(nCuenta)) {
                            do {
                                System.out.println("Cuánto dinero desea retirar");
                                monto = scanner.nextDouble();
                            } while (monto <= 0);
                            cuenta.retirarDinero(monto);
                            System.out.println(cuenta);
                            encontrado = true;
                        }
                    }
                    if (!encontrado) {
                        System.out.println("Cuenta no encontrada.");
                    }
                }
                case 6 -> {
                    estado = false;
                    System.out.println("Saliendo del programa.");
                }
                default -> System.out.println("Opción inválida.");
            }
        } while (estado);
    }
}