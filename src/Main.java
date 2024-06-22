import com.google.gson.FieldNamingPolicy;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.FileWriter;
import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class Main {
    public static void main(String[] args) throws IOException, InterruptedException {
        var url = "https://v6.exchangerate-api.com/v6/060f2bdae41c8f2920f09ead/latest/USD";

        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(url))
                .build();
        HttpResponse<String> response = client
                .send(request, HttpResponse.BodyHandlers.ofString());
        String json = response.body();
        System.out.println(json);

        Gson gsonExchangeRate = new GsonBuilder()
                .setFieldNamingPolicy(FieldNamingPolicy.LOWER_CASE_WITH_UNDERSCORES)
                .setPrettyPrinting()
                .create();

        CambioExchangeRateAPI exchangeRate = gsonExchangeRate.fromJson(json, CambioExchangeRateAPI.class);
        System.out.println(exchangeRate.conversionRates());

        Gson gsonMoedas = new GsonBuilder()
                .setPrettyPrinting()
                .create();
        CambioExchangeRateMoedas moedas = gsonMoedas.fromJson(exchangeRate.conversionRates(), CambioExchangeRateMoedas.class);
        System.out.println(moedas);

        float taxaReal = Float.valueOf(moedas.BRL());
        float taxaDolar = Float.valueOf(moedas.USD());


        Cambio cambio = new Cambio(taxaDolar,taxaReal);
        System.out.println(cambio.converte(13));

    }
}
