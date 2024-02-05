package modelo;

public abstract class Financiamento {
    // Atributos da classe Financiamento
    private double valorImovel;
    private int prazoFinanciamento;
    private double taxaJurosAnual;
    private int totalAno = 12;

    public abstract double calculoPagamentoMensal();

    public abstract double calculoPagamentoTotal();

    // Construtor recebendo 3 argumentos
    protected Financiamento(double valorI, int prazoF, double taxaJA) {
        this.valorImovel = valorI;
        this.prazoFinanciamento = prazoF;
        this.taxaJurosAnual = taxaJA;
    }

    public int getTotalAno() {
        return totalAno;
    }

    // get do valor Imovel
    public double getValorImovel() {
        return valorImovel;
    }

    // get do prazo de financiamento
    public int getPrazoFinanciamento() {
        return prazoFinanciamento;
    }

    // get da taxa de Juros
    public double getTaxaJurosAnual() {
        return taxaJurosAnual;
    }

    // Mensagem para mostrar o valor total do financiamento e o valor do imovel
    public void mensagemFinanciamento() {
        System.out.printf("Valor total do financiamento: %.2f %n valor do imovel: %.2f", calculoPagamentoTotal(),
                getValorImovel());
    }
}
