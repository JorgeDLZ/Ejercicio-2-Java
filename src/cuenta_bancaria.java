public class cuenta_bancaria {
    private String titular;
    private double saldo;
    private String numerocuenta;
    private double topeRetiro = 100000;

    public cuenta_bancaria() {
    }

    public cuenta_bancaria(String titular, double saldo, String numerocuenta) {
        this.titular = titular;
        this.saldo = saldo;
        this.numerocuenta = numerocuenta;
    }

    public String getTitular() {
        return titular;
    }

    public void setTitular(String titular) {
        this.titular = titular;
    }

    public double getSaldo() {
        return saldo;
    }

    public void setSaldo(double saldo) {
        this.saldo = saldo;
    }

    public String getNumerocuenta() {
        return numerocuenta;
    }

    public void setNumerocuenta(String numerocuenta) {
        this.numerocuenta = numerocuenta;
    }

    @Override
    public String toString() {
        return "cuenta_bancaria{" +
                "titular='" + titular + '\'' +
                ", saldo=" + saldo +
                ", numerocuenta='" + numerocuenta + '\'' +
                '}';
    }

    public void depositarDinero(double monto) {
        if (monto > 0) {
            this.saldo += monto;
        } else {
            System.out.println("El monto a depositar debe ser mayor a 0.");
        }
    }

    public void retirarDinero(double monto) {
        if (monto <= 0) {
            System.out.println("El monto a retirar debe ser mayor a 0.");
        } else if (monto > topeRetiro) {
            System.out.println("El monto a retirar excede el tope permitido de: " + topeRetiro);
        } else if (monto > this.saldo) {
            System.out.println("Saldo insuficiente para retirar el monto solicitado.");
        } else {
            this.saldo -= monto;
        }
    }

    public void mostrarInfo() {
        System.out.println("EL NOMBRE DEL TITULAR ES: " + this.titular);
        System.out.println("EL SALDO DE LA CUENTA ES: " + this.saldo);
        System.out.println("EL NÚMERO DE LA CUENTA ES: " + this.numerocuenta);
    }
}
