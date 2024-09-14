
/**
 * Escreva uma descrição da classe Aluno aqui.
 * 
 * @author (seu nome) 
 * @version (um número da versão ou uma data)
 */
public class Aluno extends Pessoa implements java.io.Serializable
{
    // Atributos do aluno    
    String ra;
    String curso;
    IArmazenadorD disc;
    int semestre;

    //Construtor
    Aluno(String nome, int idade, String rg, String ra, String curso, IArmazenadorD disc, int semestre){
        // Aciona o construtor da classe pai (Pessoa)
        super(nome, idade, rg);
        this.ra = ra;
        this.curso = curso;
        this.disc = disc;
        this.semestre = semestre;
    }

    public String toString(){
        String s = "\n\nNome: " + nome +
            "\nIdade: " + idade +
            "\nRG: " + rg +
            "\nRA: " + this.ra +
            "\nCurso: " + this.curso +
            "\nSemestre: " + this.semestre +
            "\n\nMATÉRIAS:";
                s = s + disc;
        
        return s;
    }
}

