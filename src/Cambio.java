public class Cambio {
    private float moedaInicial;
    private  float moedaFinal;

    public Cambio(float moedaInicial, float moedaFinal) {
        this.moedaInicial = moedaInicial;
        this.moedaFinal = moedaFinal;
    }

    public float converte(float montante){
        return (montante/this.moedaInicial)*this.moedaFinal;
    }
}
