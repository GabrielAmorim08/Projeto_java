package main;

import util.InterfaceUsuario;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

import modelo.Apartamento;
import modelo.Casa;
import modelo.ExceptionDesconto;
import modelo.Financiamento;
import modelo.Terreno;

public class Main {

    public static void main(String[] args) {
        // Instanciando um ArrayList Financiamento
        ArrayList<Financiamento> Financiamento = new ArrayList<>();
        // Instanciando a classe InterfaceUsuario
        InterfaceUsuario dados = new InterfaceUsuario();
        // Iniciando variaveis para calculo dos imoveis e dos financiamentos
        int numero = 1;
        float valorTotalImoveis = 0;
        float valorTotalFinanciamentos = 0;

        // Chamando os metodos da classe InterfaceUsuario e armazenando o resultado nas
        // variaveis
        double valorImovel = dados.inputValorImovel();
        int prazoFinanciamento = dados.inputPrazoFinanciamento();
        double taxaJurosAnual = dados.inputTaxaJurosAnual();
        // Adicionando os financiamentos no ArrayList e instanciando os financiamentos
        // de exemplo na Semana 4
        Casa casa = new Casa(valorImovel, prazoFinanciamento, taxaJurosAnual, prazoFinanciamento, taxaJurosAnual);
        try {
            casa.descontoCasa();
        } catch (ExceptionDesconto e) {
            System.out.println(e.getMessage());
        }

        Financiamento.add(new Casa(valorImovel, prazoFinanciamento, taxaJurosAnual, 45, 100));
        Financiamento.add(new Apartamento(valorImovel, prazoFinanciamento, taxaJurosAnual, 10, 8));
        Financiamento.add(new Terreno(valorImovel, prazoFinanciamento, taxaJurosAnual, "residencial"));
        // Laço para mostrar os financiamentos um por um
        for (int i = 0; i < Financiamento.size(); i++) {
            System.out.printf(
                    "Financiamento %d - valor do imóvel: R$: %.2f, valor do financiamento: R$ %.2f valor da parcela: R$ %.2f%n",
                    numero,
                    Financiamento.get(i).getValorImovel(), Financiamento.get(i).calculoPagamentoTotal(),
                    Financiamento.get(i).calculoPagamentoMensal());
            numero++;
        }
        // calculo para somar o valor dos imoveis e dos financiamentos
        for (Financiamento f : Financiamento) {
            valorTotalImoveis += f.getValorImovel();
            valorTotalFinanciamentos += f.calculoPagamentoTotal();
        }
        // Mensagem para mostrar os valores totais do laço acima
        System.out.printf("Total de todos os imóveis: R$ %.2f, Total de todos os financiamentos: R$ %.2f",
                valorTotalImoveis, valorTotalFinanciamentos);

        // System.out.printf("Financiamento parcela mensal: %.2f %n",
        // financiamento.calculoPagamentoMensal());
        // System.out.printf("Financiamento total: %.2f",
        // financiamento.calculoPagamentoTotal());
        salvarDadosTxt(Financiamento);
        lerDadosDoTxt();
    }

    static public void salvarDadosTxt(List<Financiamento> Financiamento) {

        // tentativa para escrever os dados do Array no arquivo txt
        try {

            BufferedWriter writer = new BufferedWriter(new FileWriter("financiamentos.txt"));
            for (Financiamento financiamento : Financiamento) {
                writer.write("Tipo: " + financiamento.getClass().getSimpleName() + "\n");
                writer.write("Valor do Imóvel: " + financiamento.getValorImovel() + "\n");
                writer.write("Valor do Financiamento: " + financiamento.calculoPagamentoTotal() + "\n");
                writer.write("Valor das parcelas: " + financiamento.calculoPagamentoMensal() + "\n");
                writer.write("Taxa de Juros: " + financiamento.getTaxaJurosAnual() + "\n");
                writer.write("Prazo de Financiamento: " + financiamento.getPrazoFinanciamento() + " Anos\n");

                if (financiamento instanceof Casa) {
                    Casa casa = (Casa) financiamento;
                    writer.write("Área Construída: " + casa.getTamanhoAreaConstruida() + "\n");
                    writer.write("Tamanho do terreno: " + casa.getTamanhoTerreno() + "\n");
                } else if (financiamento instanceof Apartamento) {
                    Apartamento apartamento = (Apartamento) financiamento;
                    writer.write("Número do Andar: " + apartamento.getNumeroAndar() + "\n");
                    writer.write("Número da vaga: " + apartamento.getNumeroVagasGaragem() + "\n");
                } else if (financiamento instanceof Terreno) {
                    Terreno terreno = (Terreno) financiamento;
                    writer.write("Tipo de Zona: " + terreno.getZona() + "\n");
                }

                writer.write("\n");
            }
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void lerDadosDoTxt() {
        // leitura dos dados
        try {
            BufferedReader leitura = new BufferedReader(new FileReader("financiamentos.txt"));
            String texto;
            while ((texto = leitura.readLine()) != null) {
                System.out.println(texto);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
