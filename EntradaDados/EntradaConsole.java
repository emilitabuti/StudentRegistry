package EntradaDados;
import java.util.Scanner;

/**
 * Escreva uma descrição da classe EntradaConsole aqui.
 * 
 * @author (seu nome) 
 * @version (um número da versão ou uma data)
 */
public class EntradaConsole implements IEntrada
{
    Scanner scan = new Scanner( System.in );
    
   public int lerQntdC() {
       System.out.println("Quantidade de cadastros: ");
       String tamanho = scan.nextLine();
       int qntdC = Integer.parseInt(tamanho);
       return qntdC;
   }
   
   public String lerOpcao() {
       System.out.println("\nMenu:\n" +
            "I - Inserir aluno\n" +
            "R - Remover aluno\n" +
            "L - Lista de alunos\n" +
            "S - Sair\n O que deseja fazer? ");
       String opcao = scan.nextLine();
        return opcao.toUpperCase();
   }
   
   public String lerNome(){
        System.out.println("Forneca o nome: ");
        String nome = scan.nextLine();
       return nome;
   }
   
   public int lerIdade() {
        System.out.println("\nForneça a idade:");
        String age = scan.nextLine();
        int idade = Integer.parseInt(age);
        return idade;
   }
   
   public String lerRG() {
       System.out.println("\nForneça o RG: ");
       String rg = scan.nextLine();
       return rg;
   }
   
   public String lerRA() {
       System.out.println("\nForneça o RA: "); 
       String ra = scan.nextLine();
       return ra;
   }
   
   public String lerCurso() {
       System.out.println("\nForneça o curso: ");
       String curso = scan.nextLine();
       return curso;
   }
   
   public int lerSemestre() {
       System.out.println("\nForneça o semestre: ");
       String periodo = scan.nextLine();
       int semestre = Integer.parseInt(periodo);
       return semestre;
   }
   
   public int lerQntd() {
       System.out.println("\nForneca a quantidade de disciplinas: ");
       String numero = scan.nextLine();
       int qntd = Integer.parseInt(numero);
       return qntd;
   }
   
    public String lerCodigo() {
       System.out.println("\nForneça o codigo da disciplina: ");
       String codigo = scan.nextLine();
       return codigo;
   }
   
   public String lerMateria() {
       System.out.println("\nForneça o nome da disciplina: ");
       String materia = scan.nextLine();
       return materia;
   }
  
   public float lerMedia() {
        System.out.println("\nForneça a media na disciplina: ");
        String mediaf = scan.nextLine();
        float media = Float.parseFloat(mediaf);
        return media;
   }
   
   public String lerRaRemover() {
       System.out.println("\nForneça o RA do aluno que deseja remover: ");
       String raRemover = scan.nextLine();
       return raRemover;
   }
}
