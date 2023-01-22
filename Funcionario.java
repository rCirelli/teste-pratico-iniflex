import java.text.*;
import java.util.Locale;
import java.math.BigDecimal;
import java.math.RoundingMode;

class Funcionario extends Pessoa {
  BigDecimal salario;
  String funcao;
  String vezesSalarioMinimo = "";

  public Funcionario(String name, String date, String salary, String role) {
    super(name, date);
    salario = new BigDecimal(salary);
    funcao = role;
    vezesSalarioMinimo = this.getSalariosMinimos();
  }

  public static String getFormattedSalary(BigDecimal salario) {
    Locale brLocale = new Locale("pt", "BR");
    NumberFormat nf = NumberFormat.getNumberInstance(brLocale);
    DecimalFormat df = (DecimalFormat) nf;
    df.applyPattern("#,##0.00");
    return df.format(salario);
  }

  public String getSalario() {
    return Funcionario.getFormattedSalary(this.salario);
  }

  public String getSalariosMinimos() {
    BigDecimal salarioMinimo = new BigDecimal(1212);
    BigDecimal vezes = this.salario.divide(salarioMinimo, 2, RoundingMode.HALF_UP);
    this.vezesSalarioMinimo = Funcionario.getFormattedSalary(vezes);
    return this.vezesSalarioMinimo;
  }

  public void aumento(int percentual) {
    double indice = (double) percentual / 100 + 1;
    this.salario = salario.multiply(new BigDecimal(indice));
  }

  @Override
  public String toString() {
    return MessageFormat.format("{0}: {1} - {2} - {3}", super.nome, super.getFormattedDate(), this.getSalario(),
        this.funcao);
  }
}