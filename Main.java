import java.util.ArrayList;
import java.util.HashMap;

class Main {
  static ArrayList<Funcionario> listaFuncionarios = new ArrayList<Funcionario>();

  public static void printFuncionarios() {
    System.out.printf("------------------------------------------------------------%n");
    System.out.printf("| %-8s | %-15s | %-10s | %-14s |%n", "NOME", "DATA NASCIMENTO", "SALARIO", "FUNÇÃO");
    System.out.printf("------------------------------------------------------------%n");
    for (Funcionario f : listaFuncionarios) {
      System.out.printf("| %-8s | %-15s | %-10s | %-14s |%n",
          f.nome,
          f.getFormattedDate(),
          f.getFormattedSalary(),
          f.funcao);
    }
    System.out.printf("------------------------------------------------------------%n%n");
  }

  public static void print() {
    // Object list = Agrupador.funcao(listaFuncionarios);
    System.out.printf("------------------------------------------------------------%n");
    System.out.printf("| %-8s | %-15s | %-10s | %-14s |%n", "NOME", "DATA NASCIMENTO", "SALARIO", "FUNÇÃO");
    System.out.printf("------------------------------------------------------------%n");
    // for (Map.Entry<String, Funcionario[]> entry : list.entrySet()) {
    // System.out.printf("| %-8s | %-15s | %-10s | %-14s |%n", f.nome,
    // f.getFormattedDate(), f.getFormattedSalary(),
    // f.funcao);
    // System.out.println(f.toString() + newline);
    // }
    System.out.printf("------------------------------------------------------------%n");
  }

  public static ArrayList<HashMap<String, String>> removerFuncionario(
      ArrayList<HashMap<String, String>> lista, String nome) {
    HashMap<String, String> toRemove = new HashMap<String, String>();
    for (HashMap<String, String> f : lista) {
      if (f.get("nome").equals(nome)) {
        toRemove = f;
      }
    }
    lista.remove(toRemove);

    return lista;
  }

  public static void main(String[] args) {
    ArrayList<HashMap<String, String>> dadosFuncionarios = ReadFile.data("lista-funcionarios.txt");

    dadosFuncionarios = removerFuncionario(dadosFuncionarios, "João");

    for (HashMap<String, String> f : dadosFuncionarios) {
      Funcionario novoFuncionario = new Funcionario(
          f.get("nome"),
          f.get("dataNasc"),
          f.get("salario"),
          f.get("funcao"));
      listaFuncionarios.add(novoFuncionario);
    }

    printFuncionarios();

    for (Funcionario f : listaFuncionarios) {
      f.aumento(10);
    }

    printFuncionarios();

    Agrupador.funcao(listaFuncionarios);
    Agrupador.print();

    Agrupador.mesAniversario(listaFuncionarios, 10);
    Agrupador.print();

    Agrupador.mesAniversario(listaFuncionarios, 12);
    Agrupador.print();
  }
}