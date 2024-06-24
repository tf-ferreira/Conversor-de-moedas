import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

//Classe utilizada para leitura da API

public class LeitorDeApi {
    private String json;

    public LeitorDeApi(String url) {
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(url))
                .build();
        HttpResponse<String> response = null;
        try {
            response = HttpClient
                    .newHttpClient()
                    .send(request, HttpResponse.BodyHandlers.ofString());
            this.json = response.body();
        } catch (IOException | InterruptedException e) {
            System.out.println("Erro ao capturar informações do site!");
            throw new RuntimeException(e);
        }
    }

    public String getJson() {
        return json;
    }
}
