import java.util.Random;

public class Video {
    public static int nEquipes = 10;
    public static Random rd = new Random();

    public static void main(String[] args) {

        int nEquipes = 10;
        Object indiceInferior[] = new Object[3];
        Object equipesAntesDasFinais[][] = TabelaEquipes.classificacaoAntesFinais();

        for (int i = 0; i < nEquipes; i++) {
            for (int j = 0; j < nEquipes - 1; j++) {
                if ((int) equipesAntesDasFinais[1][j] < (int) equipesAntesDasFinais[1][j + 1]) {
                    indiceInferior[0] = equipesAntesDasFinais[0][j];
                    indiceInferior[1] = equipesAntesDasFinais[1][j];
                    indiceInferior[2] = equipesAntesDasFinais[2][j];

                    equipesAntesDasFinais[0][j] = equipesAntesDasFinais[0][j + 1];
                    equipesAntesDasFinais[1][j] = equipesAntesDasFinais[1][j + 1];
                    equipesAntesDasFinais[2][j] = equipesAntesDasFinais[2][j + 1];

                    equipesAntesDasFinais[0][j + 1] = indiceInferior[0];
                    equipesAntesDasFinais[1][j + 1] = indiceInferior[1];
                    equipesAntesDasFinais[2][j + 1] = indiceInferior[2];
                }
            }
        }
        System.out.println(
                " -------------------------------TABELA EQUIPES ANTES DAS FINAIS-----------------------------------"
                        + "\n");
        int z = 1;
        for (int index = 0; index < nEquipes; index++) {
            System.out.println("\t                        " + z + "º LUGAR");
            System.out.println("EQUIPE: " + equipesAntesDasFinais[0][index] + "\n");
            System.out.println("PONTUAÇÃO ACUMULADA DAS PARTIDAS : " + equipesAntesDasFinais[1][index] + "\n");
            System.out.println("DESIGN: " + equipesAntesDasFinais[2][index] + "\n");
            System.out.println(" ------------------------------------------------------------------------------");
            z++;
        }
        System.out.println("As três melhores equipes da competição são :\t" + equipesAntesDasFinais[0][0] + ", "
                + equipesAntesDasFinais[0][1] + " e " + equipesAntesDasFinais[0][2]+ "\n");
        System.out.println(" --------------------------------------------------------------------------------------------------\n");
        
        System.out.println("BATALHAS FINAIS: \n");
        nEquipes = 3;
        Object indiceInferior2[] = new Object[3];
        Object equipesFinais[][] = new Object[3][nEquipes];
        int pontuacao[] = new int[nEquipes];
    
        for (int i = 0; i < nEquipes; i++) {
            equipesFinais[0][i] = equipesAntesDasFinais[0][i];
            equipesFinais[1][i] = 0;
            equipesFinais[2][i] = equipesAntesDasFinais[2][i];
        }
        int y =1;
        for (int i = 0; i < nEquipes; i++) {
            for (int j = 0; j <nEquipes; j++) {
                if(equipesFinais[0][i].equals(equipesFinais[0][j]) == false){
                    System.out.println("============================================================");
                    System.out.println("BATALHA "+ y++);
                    int pontuacaoBatalhaEquipeIndiceInferior = rd.nextInt(11);
                    int pontuacaoBatalhaEquipeIndiceSuperior = rd.nextInt(11);
                    System.out.println("EQUIPE " + equipesFinais[0][i] + " VS " + equipesFinais[0][j]);
                    if (pontuacaoBatalhaEquipeIndiceInferior > pontuacaoBatalhaEquipeIndiceSuperior) {
                        System.out.println("Equipe vencedora: " + equipesFinais[0][i] +"\n");
                        System.out.println("Pontuação equipe vencedora: " + pontuacaoBatalhaEquipeIndiceInferior);
                        System.out.println("Nota design equipe vencedora: " + equipesFinais[2][i]);
                        System.out.println("Pontuação equipe perdedora: " + pontuacaoBatalhaEquipeIndiceSuperior);
                        System.out.println("Nota design equipe perdedora: " + equipesFinais[2][j]+"\n");
                        pontuacao[i] += 2;
                    } else if (pontuacaoBatalhaEquipeIndiceInferior < pontuacaoBatalhaEquipeIndiceSuperior) {
                        System.out.println("Equipe vencedora: " + equipesFinais[0][j] +"\n");
                        System.out.println("Pontuação equipe vencedora: " + pontuacaoBatalhaEquipeIndiceSuperior);
                        System.out.println("Nota design equipe vencedora: " + equipesFinais[2][j]);
                        System.out.println("Pontuação equipe perdedora: " + pontuacaoBatalhaEquipeIndiceInferior);
                        System.out.println("Nota design equipe perdedora: " + equipesFinais[2][i]+"\n");
                        pontuacao[j] += 2;
                    } else if ((int) equipesFinais[2][i] > (int) equipesFinais[2][j]) {
                        System.out.println("Equipe vencedora: " + equipesFinais[0][i] +"\n");
                        System.out.println("Pontuação equipe vencedora: " + pontuacaoBatalhaEquipeIndiceInferior);
                        System.out.println("Nota design equipe vencedora: " + equipesFinais[2][i]);
                        System.out.println("Pontuação equipe perdedora: " + pontuacaoBatalhaEquipeIndiceSuperior);
                        System.out.println("Nota design equipe perdedora: " + equipesFinais[2][j]+"\n");
                        pontuacao[i] += 1;
                    } else if ((int) equipesFinais[2][i] < (int) equipesFinais[2][j]) {
                        System.out.println("Equipe vencedora: " + equipesFinais[0][j] +"\n");
                        System.out.println("Pontuação equipe vencedora: " + pontuacaoBatalhaEquipeIndiceSuperior);
                        System.out.println("Nota design equipe vencedora: " + equipesFinais[2][j]);
                        System.out.println("Pontuação equipe perdedora: " + pontuacaoBatalhaEquipeIndiceInferior);
                        System.out.println("Nota design equipe perdedora: " + equipesFinais[2][i]+"\n");
                        pontuacao[j] += 1;
                    }else if(equipesFinais[2][i]==equipesFinais[2][j]){
                        System.out.println("Essas equipes empataram tanto no design quanto na pontuação!\n");
                        System.out.println("Pontuação da equipe " +equipesFinais[0][i]+ " nessa partida: " + pontuacaoBatalhaEquipeIndiceInferior);
                        System.out.println("Nota design equipe " +equipesFinais[0][i] + ": " + equipesFinais[2][i]);
                        System.out.println("Pontuação da equipe " +equipesFinais[0][j]+ " nessa partida: " + pontuacaoBatalhaEquipeIndiceSuperior);
                        System.out.println("Nota design equipe " +equipesFinais[0][j] + ": " + equipesFinais[2][j]);
                    }
                }
            }                   
        }
        for (int index = 0; index < nEquipes; index++) {
            equipesFinais[1][index] = pontuacao[index];
        }

        System.out.println(
                "\n\n\n -------------------------------CLASSIFICAÇÃO EQUIPES NAS FINAIS-----------------------------------\n\n\n");

        for (int i = 0; i < nEquipes; i++) {
            for (int j = 0; j < nEquipes - 1; j++) {
                if ((int) equipesFinais[1][j] < (int) equipesFinais[1][j + 1]) {
                    indiceInferior2[0] = equipesFinais[0][j];
                    indiceInferior2[1] = equipesFinais[1][j];
                    indiceInferior2[2] = equipesFinais[2][j];

                    equipesFinais[0][j] = equipesFinais[0][j + 1];
                    equipesFinais[1][j] = equipesFinais[1][j + 1];
                    equipesFinais[2][j] = equipesFinais[2][j + 1];

                    equipesFinais[0][j + 1] = indiceInferior2[0];
                    equipesFinais[1][j + 1] = indiceInferior2[1];
                    equipesFinais[2][j + 1] = indiceInferior2[2];
                }
            }
        }
         z = 1;
            for (int index = 0; index < nEquipes; index++) {
                System.out.println("\t                        " + z + "º LUGAR");
                System.out.println("EQUIPE: " + equipesFinais[0][index] + "\n");
                System.out.println("PONTUAÇÃO ACUMULADA DAS PARTIDAS  : " + equipesFinais[1][index] + "\n");
                System.out.println("DESIGN: " + equipesFinais[2][index] + "\n");
                System.out.println(" ------------------------------------------------------------------------------");
                z++;
            }
        System.out.println("A equipe vencedora da competição é ".toUpperCase() + equipesFinais[0][0]);
    }
}
