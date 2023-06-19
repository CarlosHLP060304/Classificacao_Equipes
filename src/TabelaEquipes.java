import java.util.Random;
import static javax.swing.JOptionPane.*;

public class TabelaEquipes {

    private final static int QUANT_EQUIPES_ANTES_FINAL = 10;
    private final static int QUANT_EQUIPES_FINAL = 3;
    private Object equipes[][] = new Object[3][QUANT_EQUIPES_ANTES_FINAL];
    private Object equipesFinais[][] = new Object[3][QUANT_EQUIPES_FINAL];

    private void preencheTabelaEquipes(Object equipes[][]) {
        Random rd = new Random();
        int quantidadeDeElementos1Linha = equipes[0].length;
        String nomeEquipe[] = new String[quantidadeDeElementos1Linha];
        int design[] = new int[quantidadeDeElementos1Linha];
        int x = 0;
        for (int i = 0; i < quantidadeDeElementos1Linha; i++) {
            nomeEquipe[i] = showInputDialog("Digite o nome da equipe " + (x + 1));
            design[i] = rd.nextInt(11);
            equipes[0][i] = nomeEquipe[i];
            equipes[1][i] = 0;
            equipes[2][i] = design[i];
            x++;
        }
        showMessageDialog(null,"BATALHAS ANTES DAS FINAIS: \n");
        int pontuacao[] = comparaEquipes(equipes);

        for (int index = 0; index < QUANT_EQUIPES_ANTES_FINAL; index++) {
            equipes[1][index] = pontuacao[index];
        }

    }

    private void preencheTabelaEquipes(Object equipes[][], Object equipesFinais[][]) {
        for (int i = 0; i < QUANT_EQUIPES_FINAL; i++) {
            equipesFinais[0][i] = equipes[0][i];
            equipesFinais[1][i] = 0;
            equipesFinais[2][i] = equipes[2][i];
        }
        showMessageDialog(null,"BATALHAS FINAIS: \n");
        int pontuacao[] = comparaEquipes(equipesFinais);
        for (int index = 0; index < QUANT_EQUIPES_FINAL; index++) {
            equipesFinais[1][index] = pontuacao[index];
        }

    }

    private void exibeResultadoPartida(String nomeEquipe, int pontuacaoInferior, int pontuacaoSuperior,
            int pontuacaoInferiorDesignEquipe, int pontuacaoSuperiorDesignEquipe) {
        String aux = "Equipe vencedora: " + nomeEquipe +
                "\nPontuacao equipe vencedora: " + pontuacaoSuperior +
                "\nNota design equipe vencedora: " + pontuacaoSuperiorDesignEquipe +
                "\nPontuacao equipe perdedora: " + pontuacaoInferior +
                "\nNota design equipe perdedora: " + pontuacaoInferiorDesignEquipe + "\n";
        showMessageDialog(null,aux);

    }

    private static void exibeResultadoPartida(String nomeEquipe1, String nomeEquipe2,
            int pontuacaoBatalhaEquipeIndiceInferior, int pontuacaoBatalhaEquipeIndiceSuperior, 
            int designEquipe1, int designEquipe2) {
        String aux = "Essas equipes empataram tanto no design quanto na pontuacao!\n\n " +
                "\nPontuacao da equipe " + nomeEquipe1 + " nessa partida: " + pontuacaoBatalhaEquipeIndiceInferior +
                "\nNota design equipe " + nomeEquipe1 + ": " + designEquipe1 +
                "\nPontuacao da equipe " + nomeEquipe2 + " nessa partida: " + pontuacaoBatalhaEquipeIndiceSuperior +
                "\nNota design equipe " + nomeEquipe2 + ": " + designEquipe2;
        showMessageDialog(null,aux);
    }

    private int[] comparaEquipes(Object equipes[][]) {
        Random rd = new Random();
        int z = 1;
        int quantidadeDeElementos1Linha = equipes[0].length;
        int pontuacao[] = new int[quantidadeDeElementos1Linha];
        for (int i = 0; i < quantidadeDeElementos1Linha; i++) {
            String nomeEquipe1 = (String) equipes[0][i];
            int designEquipe1 = (int) equipes[2][i];
            for (int j = 0; j < quantidadeDeElementos1Linha; j++) {
                int pontuacaoBatalhaEquipeIndiceInferior = rd.nextInt(11);
                int pontuacaoBatalhaEquipeIndiceSuperior = rd.nextInt(11);
                String nomeEquipe2 = (String) equipes[0][j];
                int designEquipe2 = (int) equipes[2][j];
                if (!nomeEquipe1.equals(nomeEquipe2)) {
                    showMessageDialog(null,"BATALHA " + z++ + ":\n"+ "EQUIPE " + nomeEquipe1 + 
                    " VS " + nomeEquipe2);

                    if (pontuacaoBatalhaEquipeIndiceInferior > pontuacaoBatalhaEquipeIndiceSuperior) {
                        exibeResultadoPartida(nomeEquipe1, pontuacaoBatalhaEquipeIndiceSuperior,
                                pontuacaoBatalhaEquipeIndiceInferior, designEquipe2, designEquipe1);
                        pontuacao[i] += 1;

                    } else if (pontuacaoBatalhaEquipeIndiceInferior < pontuacaoBatalhaEquipeIndiceSuperior) {
                        exibeResultadoPartida(nomeEquipe2, pontuacaoBatalhaEquipeIndiceInferior,
                                pontuacaoBatalhaEquipeIndiceSuperior, designEquipe1, designEquipe2);
                        pontuacao[j] += 1;

                    } else if (designEquipe1 > designEquipe2) {
                        exibeResultadoPartida(nomeEquipe1, pontuacaoBatalhaEquipeIndiceSuperior,
                                pontuacaoBatalhaEquipeIndiceInferior, designEquipe2, designEquipe1);
                        pontuacao[i] += 1;

                    } else if (designEquipe1 < designEquipe2) {
                        exibeResultadoPartida(nomeEquipe2, pontuacaoBatalhaEquipeIndiceInferior,
                                pontuacaoBatalhaEquipeIndiceSuperior, designEquipe1, designEquipe2);
                        pontuacao[j] += 1;

                    } else if (designEquipe1 == designEquipe2) {
                        exibeResultadoPartida(nomeEquipe1, nomeEquipe2, pontuacaoBatalhaEquipeIndiceInferior,
                                pontuacaoBatalhaEquipeIndiceSuperior, designEquipe1, designEquipe2);
                    }
                }
            }
        }
        return pontuacao;
    }

    public void exibeClassificacaoAntesFinais() {
        preencheTabelaEquipes(equipes);
        ordenaEquipesTabela(equipes);
        showMessageDialog(null,
                " -------------------------------TABELA EQUIPES ANTES DAS FINAIS-----------------------------------"
                        + "\n");
        exibeClassificacao(equipes);
    }

    public void exibeClassificacaoFinais() {
        preencheTabelaEquipes(equipes, equipesFinais);
        ordenaEquipesTabela(equipesFinais);
        showMessageDialog(null,
                " -------------------------------TABELA EQUIPES NAS FINAIS-----------------------------------"
                        + "\n");
        exibeClassificacao(equipesFinais);
    }

    private void ordenaEquipesTabela(Object equipes[][]) {
        int quantidadeDeElementos1Linha = equipes[0].length;
        Object indiceInferior[] = new Object[3];
        for (int i = 0; i < quantidadeDeElementos1Linha; i++) {
            for (int j = 0; j < quantidadeDeElementos1Linha - 1; j++) {
                if (((int) equipes[1][j] < (int) equipes[1][j + 1])) {
                    indiceInferior[0] = equipes[0][j];
                    indiceInferior[1] = equipes[1][j];
                    indiceInferior[2] = equipes[2][j];

                    equipes[0][j] = equipes[0][j + 1];
                    equipes[1][j] = equipes[1][j + 1];
                    equipes[2][j] = equipes[2][j + 1];

                    equipes[0][j + 1] = indiceInferior[0];
                    equipes[1][j + 1] = indiceInferior[1];
                    equipes[2][j + 1] = indiceInferior[2];
                } else if ((int) equipes[1][j] == (int) equipes[1][j + 1]) {
                    if ((int) equipes[2][j] < (int) equipes[2][j + 1]) {
                        indiceInferior[0] = equipes[0][j];
                        indiceInferior[1] = equipes[1][j];
                        indiceInferior[2] = equipes[2][j];

                        equipes[0][j] = equipes[0][j + 1];
                        equipes[1][j] = equipes[1][j + 1];
                        equipes[2][j] = equipes[2][j + 1];

                        equipes[0][j + 1] = indiceInferior[0];
                        equipes[1][j + 1] = indiceInferior[1];
                        equipes[2][j + 1] = indiceInferior[2];
                    }
                }
            }
        }
    }

    private void exibeClassificacao(Object equipes[][]) {
        int z = 1;
        String aux = "";
        int quantidadeDeElementos1Linha = equipes[0]
        
        .length;
        for (int index = 0; index < quantidadeDeElementos1Linha; index++) {
            aux += "\t                        " + z + "º LUGAR "
                +"EQUIPE: " + equipes[0][index] + "\n"
                +"PONTUAÇÃO ACUMULADA DAS PARTIDAS : " + equipes[1][index] + "\n"
                +"DESIGN: " + equipes[2][index] + "\n";
            z++;
        }
        showMessageDialog(null,aux);
    }

    public String getEquipeVencedora() {
        return (String) equipesFinais[0][0];
    }

}