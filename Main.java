import java.util.ArrayList;
import java.util.HashMap;

class Main {
  static ArrayList<Funcionario> listaFuncionarios = new ArrayList<Funcionario>();

  public static void printFuncionarios() {
    System.out.printf("%n%n------------------------------------------------------------%n");
    System.out.printf("| %-8s | %-15s | %-10s | %-14s |%n", "NOME", "DATA NASCIMENTO", "SALARIO", "FUNÇÃO");
    System.out.printf("------------------------------------------------------------%n");
    for (Funcionario f : listaFuncionarios) {
      System.out.printf("| %-8s | %-15s | %-10s | %-14s |%n",
          f.nome,
          f.getFormattedDate(),
          f.getSalario(),
          f.funcao);
    }
    System.out.printf("------------------------------------------------------------%n%n");
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
    // 3.1 - Inserir todos os funcionários, na mesma ordem e informações da tabela
    ArrayList<HashMap<String, String>> dadosFuncionarios = ReadFile.data("lista-funcionarios.txt");

    // 3.2 - Remover o funcionário “João” da lista
    dadosFuncionarios = removerFuncionario(dadosFuncionarios, "João");

    // 3.3 – Imprimir todos os funcionários com todas suas informações
    for (HashMap<String, String> f : dadosFuncionarios) {
      Funcionario novoFuncionario = new Funcionario(
          f.get("nome"),
          f.get("dataNasc"),
          f.get("salario"),
          f.get("funcao"));
      listaFuncionarios.add(novoFuncionario);
    }
    printFuncionarios();

    // 3.4 – Os funcionários receberam 10% de aumento de salário, atualizar a lista
    // de funcionários com novo valor
    for (Funcionario f : listaFuncionarios) {
      f.aumento(10);
    }

    printFuncionarios();

    // 3.5 – Agrupar os funcionários por função em um MAP, sendo a chave a “função”
    // e o valor a “lista de funcionários”
    Agrupador.funcao(listaFuncionarios);
    // 3.6 – Imprimir os funcionários, agrupados por função.
    Agrupador.print();

    // 3.8 – Imprimir os funcionários que fazem aniversário no mês 10 e 12.
    Agrupador.mesAniversario(listaFuncionarios, 10);
    Agrupador.print();
    Agrupador.mesAniversario(listaFuncionarios, 12);
    Agrupador.print();

    // 3.9 – Imprimir o funcionário com a maior idade, exibir os atributos: nome e
    // idade.
    Agrupador.printMaiorIdade(listaFuncionarios);

    // 3.10 – Imprimir a lista de funcionários por ordem alfabética.
    listaFuncionarios = Agrupador.ordemAlfabetica(listaFuncionarios);
    printFuncionarios();

    // 3.11 – Imprimir o total dos salários dos funcionários.
    Agrupador.printSomaSalarios(listaFuncionarios);

    // 3.12 – Imprimir quantos salários mínimos ganha cada funcionário, considerando
    // que o salário mínimo é R$1212.00.
    Agrupador.printSalarioMinimo(listaFuncionarios);
  }
}