import Classes.*;

public class FileFiltering {
    public static void main(String[] args) throws Exception {

        ParserArguments parserArgs = new ParserArguments();
        ParserFile parserFile = new ParserFile();
        WriteOutFile write = new WriteOutFile();

        parserArgs.parseArgs(args);
        parserFile.parseFile(parserArgs);
        write.writeOutFile(parserArgs, parserFile);
        Statistics.getStatistics(parserArgs, parserFile);
    }
}
