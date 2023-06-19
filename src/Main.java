import static javax.swing.JOptionPane.*;
public class Main {
    public static void main(String[] args) {
        TabelaEquipes tabelaEquipes = new TabelaEquipes();
        tabelaEquipes.exibeClassificacaoAntesFinais();
        tabelaEquipes.exibeClassificacaoFinais();
        showMessageDialog(null,"A equipe vencedora da competição é ".toUpperCase() + tabelaEquipes.getEquipeVencedora());      
    }
}
