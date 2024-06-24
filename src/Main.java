import com.google.gson.Gson;
import com.google.gson.FieldNamingPolicy;
import com.google.gson.GsonBuilder;

public class Main {
    public static void main(String[] args) {

        // Recebe dados da API->String json
        String url = "https://v6.exchangerate-api.com/v6/060f2bdae41c8f2920f09ead/latest/USD";
        LeitorDeApi api = new LeitorDeApi(url);

        //Deserializer da api->exchangeRate
        Gson gsonExchangeRate = new GsonBuilder()
                .setFieldNamingPolicy(FieldNamingPolicy.LOWER_CASE_WITH_UNDERSCORES)
                .setPrettyPrinting()
                .create();
        CambioExchangeRateAPI exchangeRate = gsonExchangeRate.fromJson(api.getJson(), CambioExchangeRateAPI.class);

        //Deserializer das taxas->moedas
        Gson gsonMoedas = new GsonBuilder()
                .setPrettyPrinting()
                .create();
        CambioMoedas moedas = gsonMoedas.fromJson(exchangeRate.conversionRates(), CambioMoedas.class);

        //Instancia a classe câmbio com as taxas
        Cambio cambio = new Cambio(moedas);

        //Instancia o menu e declara variáveis para o ciclo principal
        Menu menu = new Menu();
        int flag = 0; //Indica o fim do ciclo
        String moedaInicial = "";
        String moedaFinal = "";
        float montanteInicial = 0;
        float montanteFinal = 0;

        flag = menu.menuInicial();
        while (flag != 0){
            moedaInicial = menu.menuMoedas(1);
            if(moedaInicial != ""){
                moedaFinal = menu.menuMoedas(2);
                if(moedaFinal != ""){
                    montanteInicial = menu.menuMontante();
                    montanteFinal = cambio.converte(moedaInicial,moedaFinal, montanteInicial);
                    menu.menuResultado(montanteFinal);
                }
            }
            flag = menu.menuFinal();
        }
    }
}
