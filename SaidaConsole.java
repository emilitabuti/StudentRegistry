package SaidaDados;

/**
 * Escreva uma descrição da classe SaidaConsole aqui.
 * 
 * @author (seu nome) 
 * @version (um número da versão ou uma data)
 */
public class SaidaConsole implements ISaida
{
   public void mostrarStatusI(boolean confirma){
        if(confirma == false)
            System.out.println("Não foi possível inserir pois já há um aluno com este RA\n");
        else
            System.out.println("Aluno inserido\n");
    }
    
    public void mostrarStatusR(boolean confirma){
        if(confirma == false)
            System.out.println("Não foi possível remover pois não há nenhum aluno com este RA\n");
        else
            System.out.println("Aluno removido\n");
    }
    
    public void mostrarStatusL(String lista){
        if(lista.equals(""))
            System.out.println("A lista de alunos está vazia\n");
        else
            System.out.println( lista);
    }
    
    public void mostrarOpcInvalida(){
        System.out.println("Opção inválida\n");
    }
    
    public void mostrarSaiu(){
        System.out.println("Você saiu do menu\n");
    }
}
