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
                integerStatistics(parserArguments.getOutputIntFile(), parserFile.getIntegersArray());
                /* float */
                floatStatistics(parserArguments.getOutputFloatFile(), parserFile.getFloatsArray());
                /* string */
                stringStatistics(parserArguments.getOutputStringFile(), parserFile.getLinesArray());
            }
        }
    }
    private static void integerStatistics(String fileName, ArrayList<Integer> arrayList) {
        System.out.println("Статистика по записи в файл " + fileName);
        if (arrayList.size() >= 2) {
            Collections.sort(arrayList);
            System.out.println("\tМинимальное значение: " + arrayList.get(0));
            System.out.println("\tМаксимальное значение: " + arrayList.get(arrayList.size() - 1));
            int sum = arrayList.stream().mapToInt(Integer::intValue).sum();
            System.out.println("\tСумма всех значений: " + sum);
            System.out.println("\tСреднее арифметическое: " + (double) sum / arrayList.size());
        } else if (arrayList.size() == 1) {
            System.out.println("\tЗаписана всего 1 строка со значением: " + fileName);
        } else {
            System.out.println("\tВ файл ничего записано не было");
        }
    }
    private static void floatStatistics(String fileName, ArrayList<Float> arrayList) {
        System.out.println("Статистика по записи в файл " + fileName);
        if (arrayList.size() >= 2) {
            Collections.sort(arrayList);
            System.out.println("\tМинимальное значение: " + arrayList.get(0));
            System.out.println("\tМаксимальное значение: " + arrayList.get(arrayList.size() - 1));
            double sum = arrayList.stream().mapToDouble(Float::floatValue).sum();
            System.out.println("\tСумма всех значений: " + sum);
            System.out.println("\tСреднее арифметическое: " + sum / arrayList.size());
        } else if (arrayList.size() == 1) {
            System.out.println("\tЗаписана всего 1 строка со значением: " + arrayList);
        } else {
            System.out.println("\tВ файл ничего записано не было");
        }
    }
    private static void stringStatistics(String fileName, ArrayList<String> arrayList) {
        System.out.println("Статистика по записи в файл " + fileName);
        if (arrayList.size() >= 2) {
            arrayList.sort(Comparator.comparingInt(String::length));
            System.out.printf("\tСамая короткая строка с длинной %d : %s\n", arrayList.get(0).length(),
                    arrayList.get(0));
            System.out.printf("\tСамая длинная строка с длинной %d : %s\n", arrayList.get(arrayList.size() - 1).length(),
                    arrayList.get(arrayList.size() - 1));
        } else if (arrayList.size() == 1) {
            System.out.println("\tЗаписана всего 1 строка со значением: " + arrayList);
        } else {
            System.out.println("\tВ файл ничего записано не было");
        }
    }
}
