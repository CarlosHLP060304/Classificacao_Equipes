import java.util.Random;

public class TabelaEquipes {

    public static int nEquipes = 10;
    public static Object equipes[][] = new Object[3][nEquipes];
    public static Random rd = new Random();

    public static Object[][] classificacaoAntesFinais() {
        String nomeEquipe[] = new String[nEquipes];
        int pontuacao[] = new int[nEquipes];
        int design[] = new int[nEquipes];
        int x = 0;
        for (int i = 0; i < nEquipes; i++) {
            nomeEquipe[i] = Input.input("Digite o nome da equipe " + (x + 1));
            design[i] = rd.nextInt(11);
            equipes[0][i] = nomeEquipe[i];
            equipes[1][i] = 0;
            equipes[2][i] = design[i];
            x++;
        }
        System.out.println("BATALHAS ANTES DAS FINAIS: \n");
        int z=1;
        for (int i = 0; i < nEquipes; i++) {
            String equipe1 = (String) equipes[0][i];
            for (int j = 0; j < nEquipes; j++) {
                int pontuacaoBatalhaEquipeIndiceInferior = rd.nextInt(11);
                int pontuacaoBatalhaEquipeIndiceSuperior = rd.nextInt(11);
                String equipe2 = (String) equipes[0][j];
                if (equipe1.equals(equipe2) == false) {
                    System.out.println("========================================================");
                    System.out.println("BATALHA " + z++ + ":\n");
                    System.out.println("EQUIPE " + equipe1 + " VS " + equipe2);
                    
                    if (pontuacaoBatalhaEquipeIndiceInferior > pontuacaoBatalhaEquipeIndiceSuperior) {
                        System.out.println("Equipe vencedora: " + equipe1 + "\n");
                        System.out.println("Pontuação equipe vencedora: " + pontuacaoBatalhaEquipeIndiceInferior);
                        System.out.println("Nota design equipe vencedora: " + equipes[2][i]);
                        System.out.println("Pontuação equipe perdedora: " + pontuacaoBatalhaEquipeIndiceSuperior);
                        System.out.println("Nota design equipe perdedora: " + equipes[2][j]+"\n");
                        pontuacao[i] += 1;
                        
                    } else if (pontuacaoBatalhaEquipeIndiceInferior < pontuacaoBatalhaEquipeIndiceSuperior) {
                        System.out.println("Equipe vencedora: " + equipe2 + "\n");
                        System.out.println("Pontuação equipe vencedora: " + pontuacaoBatalhaEquipeIndiceSuperior);
                        System.out.println("Nota design equipe vencedora: " + equipes[2][j]);
                        System.out.println("Pontuação equipe perdedora: " + pontuacaoBatalhaEquipeIndiceInferior);
                        System.out.println("Nota design equipe perdedora: " + equipes[2][i]+"\n");
                        pontuacao[j] += 1;
                        
                    } else if (design[i] > design[j]) {
                        System.out.println("Equipe vencedora: " + equipe1 + "\n");
                        System.out.println("Pontuação equipe vencedora: " + pontuacaoBatalhaEquipeIndiceInferior);
                        System.out.println("Nota design equipe vencedora: " + equipes[2][i]);
                        System.out.println("Pontuação equipe perdedora: " + pontuacaoBatalhaEquipeIndiceSuperior);
                        System.out.println("Nota design equipe perdedora: " + equipes[2][j] +"\n");
                        pontuacao[i] += 1;
                        
                    } else if (design[i] < design[j]) {
                        System.out.println("Equipe vencedora: " + equipe2 + "\n");
                        System.out.println("Pontuação equipe vencedora: " + pontuacaoBatalhaEquipeIndiceSuperior);
                        System.out.println("Nota design equipe vencedora: " + equipes[2][j]);
                        System.out.println("Pontuação equipe perdedora: " + pontuacaoBatalhaEquipeIndiceInferior);
                        System.out.println("Nota design equipe perdedora: " + equipes[2][i]+"\n");
                        pontuacao[j] += 1;
                        
                    }else if(design[i]==design[j]){
                        System.out.println("Essas equipes empataram tanto no design quanto na pontuação!\n");
                        System.out.println("Pontuação da equipe " +equipes[0][i]+ " nessa partida: " + pontuacaoBatalhaEquipeIndiceInferior);
                        System.out.println("Nota design equipe " +equipes[0][i] + ": " +design[i]);
                        System.out.println("Pontuação da equipe " +equipes[0][j]+ " nessa partida: " + pontuacaoBatalhaEquipeIndiceSuperior);
                        System.out.println("Nota design equipe " +equipes[0][j] + ": " +design[j]);
                    }
                }
            }
        }
        for (int index = 0; index < nEquipes; index++) {
            equipes[1][index] = pontuacao[index];
        }

        return equipes;
    }

}
