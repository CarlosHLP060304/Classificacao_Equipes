
import java.util.Scanner; 
public class Input {
	
	public static String input(String pergunta){
		Scanner sc = new Scanner(System.in);
		System.out.println(pergunta);
		String resposta =sc.nextLine();
		return resposta;
	}
}

