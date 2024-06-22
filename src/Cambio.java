import java.util.Hashtable;

public class Cambio {

    Hashtable<String, String> my_dict = new Hashtable<String, String>();

    //public Cambio(String USD, String BRL, String ARS, String BOB, String CLP, String COP, String CAD, String EUR, String AUD, String GBP) {
    public Cambio(CambioMoedas moedas){
        my_dict.put("USD", moedas.USD());//dolar americano
        my_dict.put("BRL", moedas.BRL());//real brasileiro
        my_dict.put("ARS", moedas.ARS());//peso argentino
        my_dict.put("BOB", moedas.BOB());//boliviano
        my_dict.put("CLP", moedas.CLP());//peso chileno
        my_dict.put("COP", moedas.COP());//pelo colombiano
        my_dict.put("CAD", moedas.CAD());//dolar canadense
        my_dict.put("EUR", moedas.EUR());//euro
        my_dict.put("AUD", moedas.AUD());//dolar australiano
        my_dict.put("GBP", moedas.GBP());//libra inglesa
    }

    public float converte(String moedaInicial, String moedaFinal, float montante){
        float taxaInicial = Float.valueOf(my_dict.get(moedaInicial));
        float taxaFinal = Float.valueOf(my_dict.get(moedaFinal));

        return (montante/taxaInicial)*taxaFinal;
    }

}
