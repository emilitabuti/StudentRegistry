
/**
 * Escreva uma descrição da classe Disciplina aqui.
 * 
 * @author (seu nome) 
 * @version (um número da versão ou uma data)
 */
public class Disciplina implements java.io.Serializable
{
    //Variaveis de instancia
    String codigo;
    Texto nomeDisc;
    float media;
    
    //Construtor 
    Disciplina(String codigo, String nomeDisc, float media){
        this.codigo = codigo;
        this.nomeDisc = new Texto (nomeDisc);
        this.media = media;
    }
    
    public String toString(){
        String s = "\n\nCódigo: " + this.codigo +
                   "\nDisciplina: " + this.nomeDisc +
                   "\nMédia: " + this.media; 
        return s;
    }
}
