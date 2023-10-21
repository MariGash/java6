import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

public class main {
public static void main(String[] args) {
    notebook notebook1 = new notebook("4Gb", "1000", "Windows", "silver");
    notebook notebook2 = new notebook("4Gb", "1000", "Linux", "white");
    notebook notebook3 = new notebook("4Gb", "2000", "Windows", "black");
    notebook notebook4 = new notebook("16Gb", "1000", "Windows", "silver");
    notebook notebook5 = new notebook("8Gb", "1000", "Windows", "black");

    Set<notebook> notebooks = new HashSet<>(List.of(notebook1, notebook2,
            notebook3, notebook4, notebook5));

    Map<String, String> sel = selectCriteria();
    sort(sel, notebooks);

}

public static String scanner() {
    Scanner scanner = new Scanner(System.in);
    String scan = scanner.nextLine();
    return scan;
}

public static Map<String, String> selectCriteria() {
    Map<String, String> resultCriterias = new HashMap<>();
    while (true) {
        System.out.println("Вы хотите выбрать критерий? \n Введите 1, если ДА \n Введите 2, если НЕТ");
        String question = scanner();
        if (question.equals("2")) {
            break;
        } else {

            System.out.println(
                "Введите цифру, соответствующую необходимому критерию: \n 1 - ОЗУ \n 2 - Объем ЖД \n 3 - Операционная система \n 4 - Цвет");
            String key = scanner();

            int point = 0;
            try {

                point = Integer.parseInt(key);
                switch (point) {
                    case 1:
                        System.out.println("Выберите минимальный объем оперативной памяти:");
                        System.out.println("4Gb");
                        System.out.println("8Gb");
                        System.out.println("16Gb");
                        break;

                    case 2:
                        System.out.println("Выберите минимальный объем жесткого диска:");
                        System.out.println("1000");
                        System.out.println("2000");
                        break;

                    case 3:
                        System.out.println("Выберите операционную систему");
                        System.out.println("Windows");
                        System.out.println("Linux");
                        break;

                    case 4:
                        System.out.println("Выберите цвет");
                        System.out.println("black");
                        System.out.println("silver");
                        System.out.println("white");
                        break;

                    default:
                        System.out.println("Вы ввели неверное значение. Попробуйте еще раз");
                }
            } catch (NumberFormatException ex) {
                System.out.println("Вы ввели не число.");
            }
            System.out.println("Введите значения для выбранного критерия: ");
            String value = scanner();

            resultCriterias.put(key, value);
        }
    }
    System.out.println(resultCriterias);
    return resultCriterias;
}

public static void sort(Map<String, String> criterias, Set<notebook> notebooks) {

    Set<notebook> temp = new HashSet<>(notebooks);
    for (notebook notebook : notebooks) {
        for (Object pair1 : criterias.keySet()) {
            if (pair1.equals("1") && !notebook.getMemory().equals(criterias.get(pair1))) {
                temp.remove(notebook);
            }
        }
        for (Object pair2 : criterias.keySet()) {
            if (pair2.equals("2") && !notebook.getHdd().equals(criterias.get(pair2))){
                temp.remove(notebook);
            }
        }
        for (Object pair3 : criterias.keySet()) {
            if (pair3.equals("3") && !notebook.getOs().equals(criterias.get(pair3))) {
                temp.remove(notebook);
            }
        }
        for (Object pair4 : criterias.keySet()) {
            if (pair4.equals("4") && !notebook.getColour().equals(criterias.get(pair4))) {
                temp.remove(notebook);
            }
        }
    }


    if (temp.isEmpty()) {
        System.out.println("По введенным критериям ничего не найдено");
    } else {
        System.out.println("По введенным критериям в наличии: \n" + temp.toString());
    }
}
}



