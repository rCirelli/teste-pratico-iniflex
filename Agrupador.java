import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.Collections;
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
            value.getSalario(),
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

  public static void printMaiorIdade(ArrayList<Funcionario> listaFuncionarios) {
    LocalDate hoje = LocalDate.now();
    int maiorIdade = 0;
    String nome = "";

    for (Funcionario f : listaFuncionarios) {
      int idade = (int) Math.floor(ChronoUnit.DAYS.between(f.dataNascimento, hoje) / 365);
      if (idade > maiorIdade) {
        maiorIdade = idade;
        nome = f.nome;
      }
    }
    System.out.printf("%n%n------------------------------------------------------------%n");
    System.out.printf("| %-25s | %-28s |%n", "NOME", "IDADE");
    System.out.printf("------------------------------------------------------------%n");
    System.out.printf("| %-25s | %-28s |%n", nome, maiorIdade);
    System.out.printf("------------------------------------------------------------%n%n");
  }

  public static void printSomaSalarios(ArrayList<Funcionario> listaFuncionarios) {
    BigDecimal soma = new BigDecimal(0);

    for (Funcionario f : listaFuncionarios) {
      BigDecimal salario = f.salario;
      soma = soma.add(salario);
    }

    System.out.printf("%n%n------------------------------------------------------------%n");
    System.out.printf("| %-56s |%n", "SOMA DOS SALARIOS");
    System.out.printf("------------------------------------------------------------%n");
    System.out.printf("| %-56s |%n", Funcionario.getFormattedSalary(soma));
    System.out.printf("------------------------------------------------------------%n%n");
  }

  public static void printSalarioMinimo(ArrayList<Funcionario> listaFuncionarios) {
    System.out.printf("%n%n------------------------------------------------------------%n");
    System.out.printf("| %-25s | %-28s |%n", "NOME", "VEZES O SALARIO MINIMO");
    System.out.printf("------------------------------------------------------------%n");
    for (Funcionario f : listaFuncionarios) {
      System.out.printf("| %-25s | %-28s |%n",
          f.nome,
          f.vezesSalarioMinimo);
    }
    System.out.printf("------------------------------------------------------------%n%n");
  }

  public static ArrayList<Funcionario> ordemAlfabetica(ArrayList<Funcionario> listaFuncionarios) {
    ArrayList<Funcionario> ordenado = listaFuncionarios;
    Collections.sort(ordenado, new OrdemAlfabetica());
    return ordenado;
  }
}