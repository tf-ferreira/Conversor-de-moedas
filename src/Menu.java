import java.util.Hashtable;
import java.util.Scanner;

public class Menu {
    Hashtable<String, String> my_dict = new Hashtable<>();

    public Menu() {
        my_dict.put("1","BRL");//real brasileiro
        my_dict.put("2","USD");//dolar americano
        my_dict.put("3","ARS");//peso argentino
        my_dict.put("4","BOB");//boliviano
        my_dict.put("5","CLP");//peso chileno
        my_dict.put("6","COP");//pelo colombiano
        my_dict.put("7","CAD");//dolar canadense
        my_dict.put("8","EUR");//euro
        my_dict.put("9","GBP");//libra inglesa
        my_dict.put("0","");//libra inglesa
    }

    public int menuInicial(){
        Scanner leitura = new Scanner(System.in);
        int res = 0;

        System.out.println("\n\n\n");
        System.out.println("**********************************************************");
        System.out.println("            Bem-vind@ ao Conversor de Moedas!             ");
        System.out.println("**********************************************************");
        System.out.println("");
        System.out.println("Digite o número correspondente para selecionar uma opção: ");
        System.out.println("");
        System.out.println("            (1) Realizar uma conversão");
        System.out.println("            (0) Sair");
        System.out.println("");
        System.out.println("**********************************************************");
        try{
            res = leitura.nextInt();
        }catch (Exception e){
            System.out.println("Opção inválida");
        }

        while(res != 0 && res != 1){
            System.out.println("Opção inválida!");
            System.out.println("Entre com um novo valor:");
            res = leitura.nextInt();
        }

        return res;
    }

    public String menuMoedas(int tipo){
        Scanner leitura = new Scanner(System.in);
        int res = 0;
        String mensagem1 = "              Qual moeda deseja converter?                ";
        String mensagem2 = "            Para qual moeda será convertida?              ";


        System.out.println("\n\n\n");
        System.out.println("**********************************************************");
        if(tipo==1){
            System.out.println(mensagem1);
        }else{
            System.out.println(mensagem2);
        }
        System.out.println("**********************************************************");
        System.out.println("");
        System.out.println("Digite o número correspondente para selecionar uma opção:");
        System.out.println("");
        System.out.println("            (1) Real Brasileiro(BRL)");
        System.out.println("            (2) Dólar Americano(USD)");
        System.out.println("            (3) Peso Argentino(ARS)");
        System.out.println("            (4) Boliviano Boliviano(BOB)");
        System.out.println("            (5) Peso Chileno(CLP)");
        System.out.println("            (6) Peso Colombiano(COP)");
        System.out.println("            (7) Dólar Canadense(CAD)");
        System.out.println("            (8) Euro(EUR)");
        System.out.println("            (9) Libra Inglesa(GBP)");
        System.out.println("            (0) Sair");
        System.out.println("");
        System.out.println("**********************************************************");
        try{
            res = leitura.nextInt();
        }catch (Exception e){
            System.out.println("Opção inválida");
        }
        while(res < 0 || res > 9){
            System.out.println("Opção inválida!");
            System.out.println("Entre com um novo valor:");
            res = leitura.nextInt();
        }
        return my_dict.get(String.valueOf(res));
    }

    public float menuMontante(){
        Scanner leitura = new Scanner(System.in);
        float montante = 0;
        System.out.println("\n\n\n");
        System.out.println("**********************************************************");
        System.out.println("           Insira o montante a ser convertido:            ");
        System.out.println("**********************************************************");
        try{
            montante = leitura.nextFloat();
        }catch (Exception e){
            System.out.println("Entrada inválida");
        }
        return montante;
    }

    public void menuResultado(float resultado){
        System.out.println("\n\n\n");
        System.out.println("**********************************************************");
        System.out.println("           O valor convertido é: $"+String.format("%.02f", resultado));
        System.out.println("**********************************************************");
    }

    public int menuFinal(){
        Scanner leitura = new Scanner(System.in);
        int res = 0;

        System.out.println("\n\n\n");
        System.out.println("**********************************************************");
        System.out.println("           Deseja realizar uma nova conversão?            ");
        System.out.println("**********************************************************");
        System.out.println("");
        System.out.println("Digite o número correspondente para selecionar uma opção: ");
        System.out.println("");
        System.out.println("            (1) Sim");
        System.out.println("            (0) Sair");
        System.out.println("");
        System.out.println("**********************************************************");
        try{
            res = leitura.nextInt();
        }catch (Exception e){
            System.out.println("Opção inválida");
        }

        while(res != 0 && res != 1){
            System.out.println("Opção inválida!");
            System.out.println("Entre com um novo valor:");
            res = leitura.nextInt();
        }

        return res;
    }
}

