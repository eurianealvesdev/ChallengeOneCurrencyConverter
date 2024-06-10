package br.com.alura.currency.modelos;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class Conversor {
    Gson gson = new GsonBuilder().create();



    public String convert(double valor, String inputCurrency, String outputCurrency) throws IOException, InterruptedException {

        String convertedValue = String.valueOf(valor);
        String key = "6b630855aa6ff88f472001cb";
        String url = "https://v6.exchangerate-api.com/v6/" + key + "/pair/" + inputCurrency +"/" + outputCurrency +"/" + convertedValue;
        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder().uri(URI.create(url)).build();
        HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
        String json = response.body();

         Taxa convert = gson.fromJson(json, Taxa.class);
        String result = convert.conversion_result();


        return result;
    }
}