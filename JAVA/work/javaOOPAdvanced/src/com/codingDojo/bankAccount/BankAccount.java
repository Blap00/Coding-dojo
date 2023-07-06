package com.codingDojo.bankAccount;

import java.util.Random;

public class BankAccount {
    private String numeroCuenta; // Número de cuenta
    private double saldoCorriente; // Saldo de cuenta corriente
    private double saldoAhorros; // Saldo de cuenta de ahorros
    private static int cantidadCuentas; // Cantidad de cuentas creadas hasta el momento
    private static double dineroTotal; // Cantidad total de dinero almacenado en todas las cuentas

    public BankAccount() {
        this.numeroCuenta = generarNumeroCuenta();
        cantidadCuentas++;
    }

    private String generarNumeroCuenta() {
        Random random = new Random();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < 10; i++) {
            sb.append(random.nextInt(10));
        }
        return sb.toString();
    }

    public double getSaldoCorriente() {
        return saldoCorriente;
    }

    public double getSaldoAhorros() {
        return saldoAhorros;
    }
    
    
    
    public String getNumeroCuenta() {
		return numeroCuenta;
	}

	public void setNumeroCuenta(String numeroCuenta) {
		this.numeroCuenta = numeroCuenta;
	}

	@SuppressWarnings("static-access")
    public void depositarEnCorriente(double monto) {
        saldoCorriente += monto;
        dineroTotal += monto;
    }
    @SuppressWarnings("static-access")
    public void depositarEnAhorros(double monto) {
        saldoAhorros += monto;
        dineroTotal += monto;
    }
    @SuppressWarnings("static-access")
    public void retirarDeCorriente(double monto) {
        if (saldoCorriente >= monto) {
            saldoCorriente -= monto;
            dineroTotal -= monto;
        } else {
            System.out.println("Fondos insuficientes en la cuenta corriente.");
        }
    }

    @SuppressWarnings("static-access")
	public void retirarDeAhorros(double monto) {
        if (saldoAhorros >= monto) {
            saldoAhorros -= monto;
            dineroTotal -= monto;
        } else {
            System.out.println("Fondos insuficientes en la cuenta de ahorros.");
        }
    }

    public void mostrarSaldoTotal() {
        System.out.println("Saldo de la cuenta corriente: $" + saldoCorriente);
        System.out.println("Saldo de la cuenta de ahorros: $" + saldoAhorros);
        System.out.println("Dinero total almacenado: $" + dineroTotal);
    }

    public static int getCantidadCuentas() {
        return cantidadCuentas;
    }
    
    public void transferir(double monto, BankAccount cuentaDestino) {
        if (saldoCorriente >= monto) {
            saldoCorriente -= monto;
            cuentaDestino.depositarEnCorriente(monto);
            System.out.println("Transferencia exitosa. Se ha transferido $" + monto + " a la cuenta " + cuentaDestino.getNumeroCuenta());
        } else {
            System.out.println("Fondos insuficientes en la cuenta corriente.");
        }
    }
}
