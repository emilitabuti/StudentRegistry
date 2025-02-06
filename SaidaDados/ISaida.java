package SaidaDados;
/**
 * Escreva a descrição da interface ISaida aqui.
 * 
 * @author (seu nome aqui) 
 * @version (um número da versão ou data aqui)
 */

public interface ISaida
{
  public void mostrarStatusI(boolean confirma);
  public void mostrarStatusR(boolean confirma);
  public void mostrarStatusL(String lista);
  public void mostrarOpcInvalida();
  public void mostrarSaiu();
}
