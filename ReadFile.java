import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class ReadFile {
  public static ArrayList<HashMap<String, String>> data(String fileName) {
    ArrayList<HashMap<String, String>> dadosFuncionarios = new ArrayList<HashMap<String, String>>();
    try {
      File myObj = new File(fileName);
      Scanner myReader = new Scanner(myObj);
      while (myReader.hasNextLine()) {
        String[] data = myReader.nextLine().split(",");
        HashMap<String, String> funcObj = new HashMap<String, String>();
        funcObj.put("nome", data[0]);
        funcObj.put("dataNasc", data[1]);
        funcObj.put("salario", data[2]);
        funcObj.put("funcao", data[3]);
        dadosFuncionarios.add(funcObj);
      }
      myReader.close();
    } catch (FileNotFoundException e) {
      System.out.println("Ocorreu um erro.");
      e.printStackTrace();
    }
    return dadosFuncionarios;
  }
}