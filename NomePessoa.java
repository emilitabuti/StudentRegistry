
/**
 * Escreva uma descrição da classe NomePessoa aqui.
 * 
 * @author (seu nome) 
 * @version (um número da versão ou uma data)
 */
public class NomePessoa implements java.io.Serializable
{
    //Atributo
    private Texto nome; //tipo Texto
    
    //Construtor
    public NomePessoa(String nome){
        setNome(nome); //o parametro passado e do tipo string
    }
    
    public String getNome(){
        return this.nome.getTxt();
    }
    
    /**
     * @param nome the nome to set
     */
    protected void setNome(String nome) {
        this.nome = new Texto(nome);
    }
    
    public String getNomeInvertido(){
        return this.nome.inverterTexto();
    }
    
    public int getQntdPalavras(){
        return this.nome.getQtdePalavras();
    }
    
    String getNomeBibliografico(){
        return this.nome.formatoBibliografico();
    }
    
    public String toString(){
        return(getNome());
    }
}
