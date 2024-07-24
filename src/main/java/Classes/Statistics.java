package Classes;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class Statistics {
    public static void getStatistics(ParserArguments parserArguments, ParserFile parserFile) {

        if (parserArguments.isFlag_f() || parserArguments.isFlag_s()) {
            System.out.println("Количество записанных элементов в файл " + parserArguments.getOutputIntFile()
                    + " равняется: " + parserFile.getIntegersArray().size());
            System.out.println("Количество записанных элементов в файл " + parserArguments.getOutputFloatFile()
                    + " равняется: " + parserFile.getFloatsArray().size());
            System.out.println("Количество записанных элементов в файл " + parserArguments.getOutputStringFile()
                    + " равняется: " + parserFile.getLinesArray().size());

            if (parserArguments.isFlag_f()) {

                /* integer */
                System.out.println("Статистика по записи в файл " + parserArguments.getOutputIntFile());
                if (parserFile.getIntegersArray().size() >= 2) {
                    ArrayList<Integer> tmp = parserFile.getIntegersArray();
                    Collections.sort(tmp);
                    System.out.println("\tМинимальное значение: " + tmp.get(0));
                    System.out.println("\tМаксимальное значение: " + tmp.get(tmp.size() - 1));
                    int sum = tmp.stream().mapToInt(Integer::intValue).sum();
                    System.out.println("\tСумма всех значений: " + sum);
                    System.out.println("\tСреднее арифметическое: " + (double) sum / tmp.size());
                } else if (parserFile.getIntegersArray().size() == 1) {
                    System.out.println("\tЗаписана всего 1 строка со значением: " + parserFile.getIntegersArray());
                } else {
                    System.out.println("\tВ файл ничего записано не было");
                }

                /* float */
                System.out.println("Статистика по записи в файл " + parserArguments.getOutputFloatFile());
                if (parserFile.getFloatsArray().size() >= 2) {
                    ArrayList<Float> tmp = parserFile.getFloatsArray();
                    Collections.sort(tmp);
                    System.out.println("\tМинимальное значение: " + tmp.get(0));
                    System.out.println("\tМаксимальное значение: " + tmp.get(tmp.size() - 1));
                    double sum = tmp.stream().mapToDouble(Float::floatValue).sum();
                    System.out.println("\tСумма всех значений: " + sum);
                    System.out.println("\tСреднее арифметическое: " + sum / tmp.size());
                } else if (parserFile.getFloatsArray().size() == 1) {
                    System.out.println("\tЗаписана всего 1 строка со значением: " + parserFile.getFloatsArray());
                } else {
                    System.out.println("\tВ файл ничего записано не было");
                }

                /* string */
                System.out.println("Статистика по записи в файл " + parserArguments.getOutputStringFile());
                if (parserFile.getLinesArray().size() >= 2) {
                    ArrayList<String> tmp = parserFile.getLinesArray();
                    tmp.sort(Comparator.comparingInt(String::length));
                    System.out.println("\tСамая короткая строка: " + tmp.get(0));
                    System.out.println("\tСамая длинная строка: " + tmp.get(tmp.size() - 1));
                } else if (parserFile.getLinesArray().size() == 1) {
                    System.out.println("\tЗаписана всего 1 строка со значением: " + parserFile.getLinesArray());
                } else {
                    System.out.println("\tВ файл ничего записано не было");
                }
            }
        }
    }
}
