package Classes;

import MyException.InvalidInputException;

import java.io.*;
import java.util.*;

public class ParserFile {
    private final ArrayList<String> linesArray = new ArrayList<>();
    private final ArrayList<Integer> integersArray = new ArrayList<>();
    private final ArrayList<Float> floatsArray = new ArrayList<>();

    public ArrayList<String> getLinesArray() {
        return linesArray;
    }

    public ArrayList<Integer> getIntegersArray() {
        return integersArray;
    }

    public ArrayList<Float> getFloatsArray() {
        return floatsArray;
    }


    public void parseFile(ParserArguments parser) throws Exception {

        checkFileExists(parser.getInputFileList());
        readLineFile(parser.getInputFileList());

        System.out.println("LINEARRAY");
        for (String str : linesArray) {
            System.out.println(str);
        }
        System.out.println("INTEGERSARRAY");
        for (Integer str : integersArray) {
            System.out.println(str);
        }
        System.out.println("FLOATARRAY");
        for (Float str : floatsArray) {
            System.out.println(str);
        }
    }

    private void readLineFile(ArrayList<String> fileNames) {
        List<BufferedReader> readers = new ArrayList<>();

        try {
            for (String filePath : fileNames) {
                readers.add(new BufferedReader(new FileReader(filePath)));
            }

            boolean done = false;
            int i = 0;
            while (!done) {
                done = true;
                for (BufferedReader reader : readers) {
                    String line = reader.readLine();
                    if (line != null) {
                        done = false;
                        System.out.println("stroka = " + line);
                        lineValidator(line);
                        ++i;
                        System.out.println("filename = " + fileNames.get(i - 1));
                    }
                }
                i = 0;
            }
        } catch (IOException e) {
            System.out.println(e.getMessage());
        } finally {
            for (BufferedReader reader : readers) {
                try {
                    if (reader != null) {
                        reader.close();
                    }
                } catch (IOException e) {
                    System.out.println(e.getMessage());
                }
            }
        }
    }

    private void lineValidator(String line) {
        if (isInteger(line)) {
            System.out.println("INT " + line);
            this.integersArray.add(Integer.parseInt(line));
        } else if (isFloat(line)) {
            System.out.println("FLOAT " + line);
            this.floatsArray.add(Float.parseFloat(line));
        } else {
            System.out.println("STRING " + line);
            this.linesArray.add(line);
        }
    }

    private static boolean isInteger(String str) {
        try {
            Integer.parseInt(str);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }

    private static boolean isFloat(String str) {
        try {
            Float.parseFloat(str);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }

    public void checkFileExists(ArrayList<String> fileNames) throws InvalidInputException {
        for (String tmp : fileNames) {
            File file = new File(tmp);
            if (!file.exists())
                throw new InvalidInputException("File " + tmp + " is not exists");
        }
    }

}
