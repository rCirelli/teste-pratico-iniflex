import java.util.Comparator;

class OrdemAlfabetica implements Comparator<Funcionario> {
  String ORDEM = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";

  public int compare(Funcionario a, Funcionario b) {
    return a.nome.compareTo(b.nome);
  }
}