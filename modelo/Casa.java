package modelo;

public class Casa extends Financiamento {
    private double Desconto = 100;
    private double valorAdicional = 80;
    private double tamanhoAreaConstruida;
    private double tamanhoTerreno;

    public Casa(double valorI, int prazoF, double taxaJA, double Area, double terreno) {
        super(valorI, prazoF, taxaJA);
        this.tamanhoAreaConstruida = Area;
        this.tamanhoTerreno = terreno;
    }

    public double getDesconto() {
        return Desconto;
    }

    public double getValorAdicional() {
        return valorAdicional;
    }

    public double getTamanhoAreaConstruida() {
        return tamanhoAreaConstruida;
    }

    public double getTamanhoTerreno() {
        return tamanhoTerreno;
    }

    @Override
    // calculo pagamento mensal referente da classe Casa
    public double calculoPagamentoMensal() {
        return (getValorImovel() / (getPrazoFinanciamento() * getTotalAno()))
                * (1 + (getTaxaJurosAnual() / getTotalAno())) + valorAdicional;
    }

    @Override
    // calculo pagamento total referente da classe Casa
    public double calculoPagamentoTotal() {
        return calculoPagamentoMensal() * (getPrazoFinanciamento() * getTotalAno());
    }

    // metodo que testa o desconto da Casa
    public double descontoCasa() throws ExceptionDesconto {
        if (getDesconto() > getTaxaJurosAnual()) {
            throw new ExceptionDesconto("Desconto maior que os juros mensais");
        }
        return calculoPagamentoMensal() - Desconto;
    }

}
