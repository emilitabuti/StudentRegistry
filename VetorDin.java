
/**
 * Escreva uma descrição da classe CadastroVetorDin aqui.
 * 
 * @author (seu nome) 
 * @version (um número da versão ou uma data)
 */
public class VetorDin implements IArmazenador, java.io.Serializable
{
    // Atributos
    // array para armazenar qualquer objeto
    private Object array[]; //Object aceita qualquer tipo
    // quantidade de objetos no vetor
    private int qtd;

    /**
     * VetDin Construtor - inicia um array e seta a quantidade
     *
     */
    public VetorDin(){
        setArray(null);
        setQtd(0);
    }

    /**
     * retorna array de Object
     * 
     * @return vetor de Object
     */
    private Object[] getArray() {
        return array;
    }

    /**
     * Retorna a quntidade
     * 
     * @return int, quantidade de elementos no array
     */
    public int getQtd() {
        return qtd;
    }

    /**
     * @param vet the vet to set
     */
    private void setArray(Object[] array) {
        this.array = array;
    }

    /**
     * @param qtd the qtd to set
     */
    private void setQtd(int qtd) {
        this.qtd = qtd;
    }

    /**
     * Método listar
     * Metodo para 
     * @return string(Lista)
     */
    public String listar(){ //retornar uma string com todos os dados
        String s = "";

        if(estaVazia() == false){
            for(int i = 0; i < getQtd(); i++)
                s = s + array[i].toString();
        }

        return s;
    }

    /**
     * MÃ©todo adicionar
     *
     * @param obj Um parÃ¢metro
     */
    public boolean adicionar(Object obj){
        if(estaVazia() == false){
            for(int i = 0; i < getQtd(); i++){
                if(array[i] instanceof Aluno && ((Aluno) array[i]).ra.equals(((Aluno) obj).ra))
                    return false;
            }
        }

        if (estaVazia() == true){ // se for o primeiro elemento          
            setArray(new Object[1]);
            array[0] = obj; 
            setQtd(getQtd()+1);
        }
        else { // outros elementos
            // cria vetor auxiliar com mais um elemento
            Object aux[] = new Object[array.length+1];

            // copia todos elementos de vet para aux
            copiar(array, aux);

            // insere elemento novo
            aux[aux.length-1] = obj;

            // Transforma vetor auxiliar no atual
            setArray(aux);

            // incrementa contador de elementos    
            setQtd(getQtd()+1);
        }
        return true;
    }

    /**
     * MÃ©todo remover
     *
     * @param i Um parÃ¢metro
     */
    public boolean remover(String ra){
        if(estaVazia() == false){
            for(int i = 0; i < getQtd(); i++){
                if(array[i] instanceof Aluno && ((Aluno) array[i]).ra.equals(ra)){
                    array[i] = null;
                    if(getQtd() > 1){
                        // cria vetor auxiliar com menos um elemento
                        Object aux[] = new Object[array.length-1];

                        // copia todos elementos de vet para aux
                        copiar(array, aux);

                        // Transforma vetor auxiliar no atual
                        setArray(aux);
                        // decrementa contador de elementos    
                        setQtd(getQtd() - 1);
                    } else {
                        // acabou os elementos
                        setArray(null);
                        // decrementa contador de elementos    
                        setQtd(0);

                    }
                    return true;
                }
            }
        }

        return false;
    }
    
    /**
     * MÃ©todo copiar
     *
     * @param origem Um parÃ¢metro
     * @param destino Um parÃ¢metro
     */
    private void copiar(Object origem[], Object destino[]){
        // copia todos
        int i, k = 0;
        for (i = 0; i < origem.length; i++){
            if (origem[i] != null) {
                destino[k] = origem[i];
                k++;
            }
        }       
    }
    
    /**
     * MÃ©todo vazia
     *
     * @return O valor de retorno
     */
    public boolean estaVazia(){
        return (getQtd()==0 && getArray() == null);
    }

    /**
     * MÃ©todo toString
     *
     * @return O valor de retorno
     */
    public String toString(){
        String s = "";
        if(estaVazia() == false){
            for (int i = 0; i < getQtd(); i++){
                s += array[i].toString() + " ";
            }
        }
        s = s + "";
        return s;
    }
}
