import Classes.*;
import MyException.InvalidInputException;

public class Main {

    public static void main(String[] args) throws InvalidInputException {

        ParserArguments parser = new ParserArguments();
        parser.parseArgs(args);

    }

}