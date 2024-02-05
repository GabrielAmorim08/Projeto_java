package modelo;

public class Terreno extends Financiamento {

    private double acrescimo = 0.02;
    private String zona;

    public Terreno(double valorI, int prazoF, double taxaJA, String tipoZona) {
        super(valorI, prazoF, taxaJA);
        this.zona = tipoZona;
    }

    public String getZona() {
        return zona;
    }

    public double getAcrescimo() {
        return acrescimo;
    }

    @Override
    // calculo pagamento mensal referente a classe terreno
    public double calculoPagamentoMensal() {
        return (getValorImovel() / (getPrazoFinanciamento() * getTotalAno()))
                * (1 + (getTaxaJurosAnual() / getTotalAno()))
                * (1 + acrescimo);
    }

    @Override
    // calculo pagamento total
    public double calculoPagamentoTotal() {
        return calculoPagamentoMensal() * (getPrazoFinanciamento() * getTotalAno());
    }

}
