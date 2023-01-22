import java.text.*;
import java.util.Locale;
import java.math.BigDecimal;

class Funcionario extends Pessoa {
  BigDecimal salario;
  String funcao;

  public Funcionario(String name, String date, String salary, String role) {
    super(name, date);
    salario = new BigDecimal(salary);
    funcao = role;
  }

  public String getFormattedSalary() {
    Locale brLocale = new Locale("pt", "BR");
    NumberFormat nf = NumberFormat.getNumberInstance(brLocale);
    DecimalFormat df = (DecimalFormat) nf;
    df.applyPattern("#,##0.00");
    return df.format(this.salario);
  }

  public void aumento(int percentual) {
    double indice = (double) percentual / 100 + 1;
    this.salario = salario.multiply(new BigDecimal(indice));
  }

  @Override
  public String toString() {
    return MessageFormat.format("{0}: {1} - {2} - {3}", super.nome, super.getFormattedDate(), this.getFormattedSalary(),
        this.funcao);
  }
}