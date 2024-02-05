package util;

import java.util.InputMismatchException;
import java.util.Scanner;

public class InterfaceUsuario {
    // metodo para solicitar o valor do imovel para o usuario
    public double inputValorImovel() {
        Scanner scan = new Scanner(System.in);
        double imovel = 0.0;
        while (true) {
            try {
                System.out.println("Qual o valor do imóvel?");
                imovel = scan.nextDouble();
                if (imovel < 0) {
                    System.out.println("Utilize apenas numeros positivos");
                } else {
                    break;
                }
            } catch (InputMismatchException e) {
                System.out.println("Dado inserido é inválido");
                scan.nextLine();
            }

        }
        return imovel;
    }

    // metodo para solicitar o pazo em anos ao usuario
    public int inputPrazoFinanciamento() {
        Scanner scan = new Scanner(System.in);
        int prazo = 0;
        while (true) {
            try {
                System.out.println("Em quantos anos deseja financiar?");
                prazo = scan.nextInt();
                if (prazo < 0) {
                    System.out.println("Utilize apenas numeros posítivos");
                } else {
                    break;
                }
            } catch (InputMismatchException e) {
                System.out.println("Dado inserido é inválido");
                scan.nextLine();
            }

        }
        return prazo;
    }

    // metodo que solicita a taxa de juros para o usuario
    public double inputTaxaJurosAnual() {
        Scanner scan = new Scanner(System.in);
        Double taxa = 0.0;
        while (true) {
            try {
                System.out.println("Qual a taxa de juros anual?");
                taxa = scan.nextDouble();
                if (taxa < 0) {
                    System.out.println("Utilize apenas numeros posítivos");
                } else if (taxa > 1000) {
                    System.out.println("Valor de juros muito alta");
                } else {
                    break;
                }
            } catch (InputMismatchException e) {
                System.out.println("Dado inserido é inválido ou contém um ponto ao invés da virgula");
                scan.nextLine();
            }
        }
        return taxa;
    }
}
