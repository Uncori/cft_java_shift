import Classes.*;
import MyException.InvalidInputException;

import java.io.IOException;

public class Main {

    public static void main(String[] args) throws InvalidInputException, IOException {

        ParserArguments parserArgs = new ParserArguments();
        ParserFile parserFile = new ParserFile();
        parserArgs.parseArgs(args);
        parserFile.parseFile(parserArgs);


    }

}