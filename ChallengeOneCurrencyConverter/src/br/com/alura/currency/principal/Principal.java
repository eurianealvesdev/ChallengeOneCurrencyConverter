package br.com.alura.currency.principal;

import br.com.alura.currency.modelos.Conversor;
import br.com.alura.currency.modelos.Moedas;
import br.com.alura.currency.modelos.Pares;
import br.com.alura.currency.modelos.Requisicao;
import com.google.gson.JsonSyntaxException;

import java.io.IOException;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class Principal {
    public static void main(String[] args) throws IOException, InterruptedException {
        try {
            Scanner reader = new Scanner(System.in);
            int opcao = 0;
            Moedas saveArchive = new Moedas();
            List<Requisicao> consult = new ArrayList<>();
            while(opcao != 7) {
                System.out.println("""
                    **********************************************************************************
                    Sejam bem vindes
                    
                    Selecione uma opção para converte sua Contação : 
                                    
                    1 -  USD para BRL.
                    2 -  USD para ARS.
                    3 -  ARS para USD.
                    4 -  ARS para BRL.
                    5 -  BRL para USD.
                    6 -  BRL para ARS.
                    7 - Sair.
                    *************************************************************************************
                    """);
                opcao = reader.nextInt();

                try {

                    while (opcao >= 8 || opcao <= 0) {
                        System.out.println("Escolha uma opção entre 1 e 6");
                        opcao = reader.nextInt();
                    }
                } catch (InputMismatchException e) {
                    System.out.println("Tente novamente, escolha uma opção entre 1 e 6");
                }

                Pares pares = new Pares();
                pares.convertOption(opcao);
                System.out.println("Insira o valor que deseja converter sem pontos, utilize apenas vírgula");
                double valor = reader.nextDouble();
                Conversor conversor = new Conversor();

                double resultado = Double.parseDouble(conversor.convert(valor, pares.getInputCurrency(), pares.getOutputCurrency()));
                System.out.println(String.format("Valor em %s $%.2f convertido para %s: $%.2f", pares.getInputCurrency(), valor, pares.getOutputCurrency(), resultado));

                Requisicao archive = new Requisicao(pares.getInputCurrency(), pares.getOutputCurrency(), String.valueOf(valor), String.valueOf(resultado));

                consult.add(archive);
                System.out.println(consult);


                System.out.println("Digite 1 para continuar ou 7 para sair.");
                opcao = reader.nextInt();
                if(opcao == 7){
                    break;
                }

            }
            saveArchive.saveList(consult);

        } catch (InputMismatchException e){
            System.out.println("Tente novamente, escolha uma opção entre 1 e 6 e em seguida insira o valor que deseja converter sem pontos, utilize apenas vírgula.");


        } catch (JsonSyntaxException e){
            System.out.println("Desculpe, o programa converte apenas números positivos.");

        }




    }
}