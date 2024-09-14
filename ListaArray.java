import java.util.ArrayList;
/**
 * Escreva uma descrição da classe CadastroListaArray aqui.
 * 
 * @author (seu nome) 
 * @version (um número da versão ou uma data)
 */
public class ListaArray implements IArmazenador,java.io.Serializable
{
    private ArrayList <Object> lista;

    public ListaArray(){
        setLista(new <Object>ArrayList());
    }

    /**
     * getLista
     * 
     * @return the vet
     */
    private ArrayList <Object> getLista() {
        return lista;
    }

    /**
     * getQtd
     * 
     * @return the qtd
     */
    public int getQtd() {
        return lista.size();
    }

    /**
     * setLista
     * 
     * @param vet the vet to set
     */
    private void setLista(ArrayList <Object>lista) {
        this.lista = lista;
    }

    /**
     * Método listar
     *
     * @return string(Lista)
     */
    public String listar(){ //retornar uma string com todos os dados
        String s = "";

        if(estaVazia() == false){
            for(int i = 0; i < getQtd(); i++)
                s = s + buscar(i).toString();
        }

        return s;
    }

    /**
     * adicionar
     *
     * @param obj Um parÃ¢metro
     */
    public boolean adicionar(Object obj){
        if(estaVazia() == false){
            for(int i = 0; i < getQtd(); i++){
                if(buscar(i) instanceof Aluno && ((Aluno) buscar(i)).ra.equals(((Aluno) obj).ra))
                    return false;
            }
        }
        lista.add(obj);
        
        return true;
    }

    /**
     * remover
     *
     * @param i Um parÃ¢metro
     */
    public boolean remover(String ra){
        Object ret = null;

        if(estaVazia() == false){
            for(int i = 0; i < getQtd(); i++){
                if(buscar(i) instanceof Aluno && ((Aluno) buscar(i)).ra.equals(ra)){
                    ret = lista.get(i);
                    lista.remove(i);
                    return true;
                }
            }
        }

        return false;
    }

    public Object buscar (int i){
        Object ret = null;
        if(!lista.isEmpty()&& (i >= 0 && i < getQtd())){
            ret = lista.get(i);
        }
        return ret;
    }
    
    public boolean estaVazia(){
        return (lista.isEmpty());
    }

    /**
     * toString
     *
     * @return O valor de retorno
     */
    public String toString(){
        String s = "";
        for (int i = 0; i < lista.size(); i++){
            s += lista.get(i).toString() + " ";
        }
        s = s + "";
        return s;
    }
}