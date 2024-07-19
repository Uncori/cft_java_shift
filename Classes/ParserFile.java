package Classes;

import MyException.InvalidInputException;

import java.io.*;
import java.util.*;

public class ParserFile {
    private ArrayList<String> linesArray = new ArrayList<>();
    private ArrayList<Integer> integersArray = new ArrayList<>();
    private ArrayList<Float> floatsArray = new ArrayList<>();

    public void parseFile(ParserArguments parser) throws IOException, InvalidInputException {
        File[] outFiles = new File[3];
        outFiles[0] = new File((parser.getPath() + parser.getPrefix() + "integers.txt").trim());
        outFiles[1] = new File((parser.getPath() + parser.getPrefix() + "floats.txt").trim());
        outFiles[2] = new File((parser.getPath() + parser.getPrefix() + "strings.txt").trim());

        for(File feather : outFiles) {
            System.out.println("outFiles: " + feather);
        }

        checkFile(parser.getFileList());

        List<BufferedReader> readers = new ArrayList<>();

        try {
            for (String filePath : parser.getFileList()) {
                readers.add(new BufferedReader(new FileReader(filePath)));
            }

            boolean done = false;
            while (!done) {
                done = true;
                for (BufferedReader reader : readers) {
                    String line = reader.readLine();
                    if (line != null) {
                        done = false;
                        System.out.println("stroka = " + line);
                    }
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            // Закрываем все BufferedReader
            for (BufferedReader reader : readers) {
                try {
                    if (reader != null) {
                        reader.close();
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }

        ArrayList<String> tmp = parser.getFileList();
    }

    private void checkFile(ArrayList<String> fileNames) throws InvalidInputException {
        for(String tmp: fileNames) {
            File file = new File(tmp);
            if (!file.exists())
                throw new InvalidInputException("File " + tmp + " is not exists");
        }
    }

}
