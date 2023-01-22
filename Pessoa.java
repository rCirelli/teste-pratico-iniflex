import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

class Pessoa {
  String nome;
  LocalDate dataNascimento;

  public Pessoa(String name, String date) {
    nome = name;
    dataNascimento = LocalDate.parse(date);
  }

  public String getFormattedDate() {
    DateTimeFormatter formatoData = DateTimeFormatter.ofPattern("dd/MM/yyyy");
    return this.dataNascimento.format(formatoData);
  }
}