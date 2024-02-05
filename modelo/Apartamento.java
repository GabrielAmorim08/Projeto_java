package modelo;

public class Apartamento extends Financiamento {

    private int numeroVagasGaragem;
    private int numeroAndar;

    public Apartamento(double valorI, int prazoF, double taxaJA, int numVagas, int numAndar) {
        super(valorI, prazoF, taxaJA);
        this.numeroAndar = numAndar;
        this.numeroVagasGaragem = numVagas;
    }

    public int getNumeroVagasGaragem() {
        return numeroVagasGaragem;
    }

    public int getNumeroAndar() {
        return numeroAndar;
    }

    @Override
    // calculo pagamento mensal referente a classe Apartamento
    public double calculoPagamentoMensal() {
        double taxaMensal = getTaxaJurosAnual() / getTotalAno();
        int meses = getPrazoFinanciamento() * getTotalAno();
        return (getValorImovel() * Math.pow(1 + taxaMensal, meses))
                / ((Math.pow(1 + taxaMensal, meses) - 1) / taxaMensal);
    }

    @Override
    // calculo pagamento total referente a classe Apartamento
    public double calculoPagamentoTotal() {
        return calculoPagamentoMensal() * (getPrazoFinanciamento() * getTotalAno());
    }

}
