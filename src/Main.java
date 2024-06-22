import com.google.gson.Gson;
import com.google.gson.FieldNamingPolicy;
import com.google.gson.GsonBuilder;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class Main {
    public static void main(String[] args) throws IOException, InterruptedException {

        //recebe dados da API->json
        String url = "https://v6.exchangerate-api.com/v6/060f2bdae41c8f2920f09ead/latest/USD";
        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(url))
                .build();
        HttpResponse<String> response = client
                .send(request, HttpResponse.BodyHandlers.ofString());
        String json = response.body();

        //deserializer da api->exchangeRate
        Gson gsonExchangeRate = new GsonBuilder()
                .setFieldNamingPolicy(FieldNamingPolicy.LOWER_CASE_WITH_UNDERSCORES)
                .setPrettyPrinting()
                .create();
        CambioExchangeRateAPI exchangeRate = gsonExchangeRate.fromJson(json, CambioExchangeRateAPI.class);

        //deserializer das taxas->moedas
        Gson gsonMoedas = new GsonBuilder()
                .setPrettyPrinting()
                .create();
        CambioExchangeRateMoedas moedas = gsonMoedas.fromJson(exchangeRate.conversionRates(), CambioExchangeRateMoedas.class);

        //instancia a classe câmbio com as taxas
        Cambio cambio = new Cambio(moedas.USD(),
                moedas.BRL(),
                moedas.ARS(),
                moedas.BOB(),
                moedas.CLP(),
                moedas.COP(),
                moedas.CAD(),
                moedas.EUR(),
                moedas.AUD(),
                moedas.GBP());

        System.out.println(cambio.converte("BRL","BOB",70));

    }
}
