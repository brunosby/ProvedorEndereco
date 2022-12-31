import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
public class Endereco{
    public static void main(String[] args) {
        // String[] testeEntradas = {"Miritiba 339", "Babaçu 500", "Cambuí 804B", "Rio Branco 23", "Quirino dos Santos 23 b"};
        Scanner entrada = new Scanner(System.in);
        String endereco = entrada.nextLine();
        String saida[] = separarEndereco(endereco);
        for (int i = 0; i < saida.length; i++) {
            System.out.println(saida[i]);
        }
        entrada.close();
    }
    public static String[] separarEndereco(String endereco){
        String resultados[] = {"", ""};
        String separado[] = endereco.split(" ");
        Pattern pattern = Pattern.compile("\\d+\\w+");
        boolean resto = true;
        for (int i = 0; i < separado.length; i++) {
            Matcher matcher = pattern.matcher(separado[i]);
            if(!matcher.matches() && resto){
                resultados[0] += separado[i] + " ";
            } else {
                resultados[1] += separado[i] + " ";
                resto = false;
            }
        }
        return resultados;
    }
}