package EntradaDados; 
import javax.swing.JOptionPane;
/**
 * Escreva uma descrição da classe Entrada aqui.
 * 
 * @author (seu nome) 
 * @version (um número da versão ou uma data)
 */
public class Entrada implements IEntrada{
    public int lerQntdC(){ 
        String qntd = JOptionPane.showInputDialog("Quantidade de cadastros: ");
        int qntdC = Integer.parseInt(qntd);
        return qntdC;
    }
    
    public String lerOpcao(){ 
        String opcao = JOptionPane.showInputDialog("Menu:\n" +
            "I - Inserir aluno\n" +
            "R - Remover aluno\n" +
            "L - Lista de alunos\n" +
            "S - Sair\n O que deseja fazer? ");
        return opcao.toUpperCase();
    }
      
    public String lerNome(){ 
        String nome = JOptionPane.showInputDialog("Forneca o nome: ");
        return nome;
    }

    public int lerIdade(){ 
        int idade = Integer.parseInt(JOptionPane.showInputDialog("Forneca a idade: "));
        return idade;
    }

    public String lerRG(){ 
        String rg = JOptionPane.showInputDialog("Forneca o RG: ");
        return rg;
    }
    
    public String lerRA(){ 
        String ra = JOptionPane.showInputDialog("Forneca o RA: ");
        return ra;
    }
    
    public String lerCurso(){ 
        String curso = JOptionPane.showInputDialog("Forneca o curso: ");
        return curso;
    }
    
    public int lerSemestre(){ 
        int semestre = Integer.parseInt(JOptionPane.showInputDialog("Forneca o semestre: "));
        return semestre;
    }
   
    public int lerQntd(){ 
        int qntd = Integer.parseInt(JOptionPane.showInputDialog("Forneca a quantidade de disciplinas: "));
        return qntd;
    }
    
    public String lerCodigo(){ 
        String codigo = JOptionPane.showInputDialog("Forneca o código da disciplina: ");
        return codigo;
    }
    
    public String lerMateria(){ 
        String materia = JOptionPane.showInputDialog("Forneça o nome da disciplina: ");
        return materia;
    }
    
    public float lerMedia(){ 
        float media = Float.parseFloat(JOptionPane.showInputDialog("Forneca a média na disciplina: "));
        return media;
    }
    
    public String lerRaRemover(){ 
        String raRemover = JOptionPane.showInputDialog("Forneça o RA do aluno que deseja remover: ");
        return raRemover;
    }
}
