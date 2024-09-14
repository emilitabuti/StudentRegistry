/**
 * Armazena um texto e inverte o texto e limpa espacos extras
 * 
 * @author Julio Arakaki 
 * @version 1.0 2024/04/02
 */
public class Texto implements java.io.Serializable{
    // Atributo da classe ou varáveis de instancia
    private String txt; //so da para acessar essa variavel com get(metodo), isso protege os dados, se tiver um erro fica mais facil de achar
    /** 
     * Construtor: armazena o texto e limpa os espaços excedentes
     * 
     * @param txt String com o texto que será armazenado
     */
    Texto(String txt){
        setTxt(txt);
        limparEspacosExcedentes();
    }

    // setters e getters
    private void setTxt(String txt){
        this.txt = txt; //this: usado para diferenciar os txt, ele é o atributo
    }

    public String getTxt(){ //get: para acessar a variavel txt que é privada, é o unico jeito de acessa-la
        return this.txt;
    }

    /**
     * Retorna um texto invertido
     * @return txtInvertido String contendo o texto invertido
     */
    public String inverterTexto(){
        String txtInvertido = "";
        if(!(this.txt == null || this.txt.equals("") )){
            for (int i=this.txt.length()-1; i >= 0; i--){
                txtInvertido = txtInvertido + this.txt.charAt(i);
            }
        } else {
            return null;
        }
        return txtInvertido;
    }

    /**
     * Retorna quantidade de palavras do nome
     * @return int numero de palavras
     */
    public int getQtdePalavras(){
        return (getTxt().split(" ").length);
    }

    /**
     * Retira espacos excedentes de uma string
     */
    private void limparEspacosExcedentes(){
        // Elimina espacos do inicio e fim da string
        setTxt(this.txt.trim());

        // Elimina espacos excedentes do meio da string
        String s = "";
        for (int i=0; i < this.txt.length(); i++){
            s = s + this.txt.charAt(i); // pega o caractere da posicao
            if(this.txt.charAt(i) == ' '){
                while(this.txt.charAt(i+1) == ' '){ // avanca se tiver mais espacos
                    i++;
                }
            }
        }
        setTxt(s);
    }

    /**
     * Retorna os atributos como string
     * @return String texto armazenado
     */
    public String toString(){
        return(getTxt());
    }

    /**
     * Retorna um texto invertido
     * @return txtInvertido String contendo o texto invertido
     */
    public String formatoBibliografico(){
        StringBuilder nomeBiblio = new StringBuilder();
        String partesNome[] = getTxt().split(" ");

        if(partesNome.length > 1){
            nomeBiblio.append(Character.toUpperCase(partesNome[partesNome.length - 1].charAt(0)) + partesNome[partesNome.length - 1].substring(1)).append(", ");
            for(int i = 0; i < partesNome.length - 1; i++){
                if(!verificaStr(partesNome[i])){
                    nomeBiblio.append(Character.toUpperCase(partesNome[i].charAt(0))).append(". ");
                }
            }
        }
        else{
            nomeBiblio = nomeBiblio.append(Character.toUpperCase(partesNome[0].charAt(0)) + partesNome[0].substring(1));
        }
        return nomeBiblio.toString();
    }
    
    /**
     * Verifica se string eh uma String a ser retirada
     * @param s string a ser verificada
     * @return true eh preposicao false nao eh preposicao
     */
    private boolean verificaStr(String s){
        // Vetor de strings a serem retiradas
        final String sRet[]={"da", "de", "do", "di", "das", "dos", "e",};

        for (int i = 0; i < sRet.length; i++){
            if(sRet[i].equals(s)){
                return true;
            }
        }
        return false;
    }
}

