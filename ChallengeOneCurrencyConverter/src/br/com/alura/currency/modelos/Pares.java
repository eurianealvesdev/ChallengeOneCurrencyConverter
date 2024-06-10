package br.com.alura.currency.modelos;

public class Pares {
    private String inputCurrency;
    private String outputCurrency;

    public String getInputCurrency() {
        return inputCurrency;
    }

    public String getOutputCurrency() {
        return outputCurrency;
    }

    private void setInputCurrency(String inputCurrency) {
        this.inputCurrency = inputCurrency;
    }

    private void setOutputCurrency(String outputCurrency) {
        this.outputCurrency = outputCurrency;
    }

    public void convertOption(int option){

        switch(option){
            case 1:
                setInputCurrency("USD");
                setOutputCurrency("BRL");
                break;
            case 2:
                setInputCurrency("USD");
                setOutputCurrency("ARS");
                break;
            case 3:
                setInputCurrency("ARS");
                setOutputCurrency("USD");
                break;
            case 4:
                setInputCurrency("ARS");
                setOutputCurrency("BRL");
                break;
            case 5:
                setInputCurrency("BRL");
                setOutputCurrency("USD");
                break;
            case 6:
                setInputCurrency("BRL");
                setOutputCurrency("ARS");
                break;
            default:
                System.out.println("Opção Invalida.");
        }
    }
}

