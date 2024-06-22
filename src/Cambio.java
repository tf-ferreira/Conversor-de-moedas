import java.util.Hashtable;

public class Cambio {

    Hashtable<String, String> my_dict = new Hashtable<String, String>();

    public Cambio(String USD, String BRL, String ARS, String BOB, String CLP, String COP, String CAD, String EUR, String AUD, String GBP) {
        my_dict.put("USD", USD);//dolar americano
        my_dict.put("BRL", BRL);//real brasileiro
        my_dict.put("ARS", ARS);//peso argentino
        my_dict.put("BOB", BOB);//boliviano
        my_dict.put("CLP", CLP);//peso chileno
        my_dict.put("COP", COP);//pelo colombiano
        my_dict.put("CAD", CAD);//dolar canadense
        my_dict.put("EUR", EUR);//euro
        my_dict.put("AUD", AUD);//dolar australiano
        my_dict.put("GBP", GBP);//libra inglesa
    }

    public float converte(String moedaInicial, String moedaFinal, float montante){
        float taxaInicial = Float.valueOf(my_dict.get(moedaInicial));
        float taxaFinal = Float.valueOf(my_dict.get(moedaFinal));

        return (montante/taxaInicial)*taxaFinal;
    }
}
