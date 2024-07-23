package Classes;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class WriteOutFile {
    public void writeOutFile(ParserArguments parserArguments, ParserFile parserFile) throws IOException {
        if (parserFile.getIntegersArray().size() != 0) {
            writeToFile(parserArguments.getOutputIntFile(),
                    parserArguments.isFlag_a(),
                    parserFile.getIntegersArray());
        }
        if (parserFile.getFloatsArray().size() != 0) {
            writeToFile(parserArguments.getOutputFloatFile(),
                    parserArguments.isFlag_a(),
                    parserFile.getFloatsArray());

        }
        if (parserFile.getLinesArray().size() != 0) {
            writeToFile(parserArguments.getOutputStringFile(),
                    parserArguments.isFlag_a(),
                    parserFile.getLinesArray());
        }
    }

    private void createFile(File file) throws IOException {
        try {
            if (file.createNewFile()) {
                System.out.println("Файл уже создан");
            }
        } catch (IOException e) {
            throw new IOException("Ошибка при создании файла для записи " + file.getPath());
        }
    }

    private <T> void writeToFile(String fileName, Boolean append, ArrayList<T> arrayList) throws IOException {
        File file = new File(fileName);
        if (!file.exists()) {
            createFile(file);
        }
        try (BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(fileName, append))) {
            for (T str : arrayList)
                bufferedWriter.write(str.toString() + "\n");
        } catch (IOException e) {
            System.out.println("Произошла ошибка записи файла: " + file.getPath());
        }
    }

}
