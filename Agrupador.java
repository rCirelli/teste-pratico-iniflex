import java.util.ArrayList;
import java.util.HashMap;
import java.util.Set;
import java.util.Map.Entry;

class Agrupador {
  static HashMap<String, ArrayList<Funcionario>> mapaFuncionarios = new HashMap<String, ArrayList<Funcionario>>();

  public static HashMap<String, ArrayList<Funcionario>> print() {
    Set<Entry<String, ArrayList<Funcionario>>> set = mapaFuncionarios.entrySet();

    for (Entry<String, ArrayList<Funcionario>> entry : set) {
      System.out.printf("%n%n------------------------------------------------------------%n");
      System.out.printf("| %-56s |%n", entry.getKey());
      System.out.printf("------------------------------------------------------------%n");
      System.out.printf("| %-8s | %-15s | %-10s | %-14s |%n", "NOME", "DATA NASCIMENTO", "SALARIO", "FUNÇÃO");
      System.out.printf("------------------------------------------------------------%n");
      for (Funcionario value : entry.getValue()) {
        System.out.printf("| %-8s | %-15s | %-10s | %-14s |%n",
            value.nome,
            value.getFormattedDate(),
            value.getFormattedSalary(),
            value.funcao);
      }
      System.out.printf("------------------------------------------------------------%n%n");
    }
    return mapaFuncionarios;
  }

  public static HashMap<String, ArrayList<Funcionario>> funcao(ArrayList<Funcionario> listaFuncionarios) {
    for (Funcionario f : listaFuncionarios) {
      if (mapaFuncionarios.containsKey(f.funcao)) {
        mapaFuncionarios.get(f.funcao).add(f);
      } else {
        ArrayList<Funcionario> lista = new ArrayList<Funcionario>();
        lista.add(f);
        mapaFuncionarios.put(f.funcao, lista);
      }
    }
    return mapaFuncionarios;
  }

  public static HashMap<String, ArrayList<Funcionario>> mesAniversario(ArrayList<Funcionario> listaFuncionarios,
      int mes) {
    mapaFuncionarios = new HashMap<String, ArrayList<Funcionario>>();
    for (Funcionario f : listaFuncionarios) {
      if (f.dataNascimento.getMonthValue() != mes) {
        continue;
      }
      if (mapaFuncionarios.containsKey(String.valueOf(mes))) {
        mapaFuncionarios.get(String.valueOf(mes)).add(f);
      } else {
        ArrayList<Funcionario> lista = new ArrayList<Funcionario>();
        lista.add(f);
        mapaFuncionarios.put(String.valueOf(mes), lista);
      }
    }
    if (mapaFuncionarios.isEmpty()) {
      System.out.printf("%n%n------------------------------------------------------------%n");
      System.out.printf("| %-10s %-22s |%n", "Nenhum funcionario nascido no mês", mes);
      System.out.printf("------------------------------------------------------------%n%n");
    }
    return mapaFuncionarios;
  }

  public static HashMap<String, ArrayList<Funcionario>> idade(ArrayList<Funcionario> listaFuncionarios) {
    mapaFuncionarios = new HashMap<String, ArrayList<Funcionario>>();

    return mapaFuncionarios;
  }
}