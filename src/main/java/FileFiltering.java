import Classes.*;

public class FileFiltering {
    public static void main(String[] args) throws Exception {

        ParserArguments parserArgs = new ParserArguments();
        ParserFile parserFile = new ParserFile();

        parserArgs.parseArgs(args);
        parserFile.parseFile(parserArgs);
        WriteOutFile.writeOutFile(parserArgs, parserFile);
        Statistics.getStatistics(parserArgs, parserFile);
    }
}
