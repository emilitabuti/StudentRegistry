package SaidaDados;
import javax.swing.JOptionPane;
/**
 * Escreva uma descrição da classe Saida aqui.
 * 
 * @author (seu nome) 
 * @version (um número da versão ou uma data)
 */
public class Saida implements ISaida
{
    public void mostrarStatusI(boolean confirma){
        if(confirma == false)
            JOptionPane.showMessageDialog(null, "Não foi possível inserir pois já há um aluno com este RA");
        else
            JOptionPane.showMessageDialog(null, "Aluno inserido");
    }
    
    public void mostrarStatusR(boolean confirma){
        if(confirma == false)
            JOptionPane.showMessageDialog(null, "Não foi possível remover pois não há nenhum aluno com este RA");
        else
            JOptionPane.showMessageDialog(null, "Aluno removido");
    }
    
    public void mostrarStatusL(String lista){
        if(lista.equals(""))
            JOptionPane.showMessageDialog(null, "A lista de alunos está vazia");
        else
            JOptionPane.showMessageDialog(null, lista);
    }
    
    public void mostrarOpcInvalida(){
        JOptionPane.showMessageDialog(null, "Opção inválida");
    }
    
    public void mostrarSaiu(){
        JOptionPane.showMessageDialog(null, "Você saiu do menu");
    }
    
}
