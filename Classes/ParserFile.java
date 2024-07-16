package Classes;

import MyException.InvalidInputException;

import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

public class ParserFile {
    private ArrayList<String> linesArray = new ArrayList<>();
    private ArrayList<Integer> integersArray = new ArrayList<>();
    private ArrayList<Float> floatsArray = new ArrayList<>();

    public void parseFile(ParserArguments parser) throws IOException, InvalidInputException {
        File[] files = new File[3];
        FileReader[] readers = new FileReader[3];
        Scanner[] scanners = new Scanner[3];
        files[0] = new File((parser.getPath() + parser.getPrefix() + "integers.txt").trim());
        files[1] = new File((parser.getPath() + parser.getPrefix() + "floats.txt").trim());
        files[2] = new File((parser.getPath() + parser.getPrefix() + "strings.txt").trim());
        for(Object feather : files) {
            System.out.println(feather);
        }
        checkFile(parser.getFileList());
//        ArrayList<String> tmp = parser.getFileList();
    }

    private void checkFile(ArrayList<String> fileNames) throws InvalidInputException {
        for(String tmp: fileNames) {
            File file = new File(tmp);
            if (!file.exists())
                throw new InvalidInputException("File " + tmp + " is not exists");
        }

    }

}
