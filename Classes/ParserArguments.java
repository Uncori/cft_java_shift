package Classes;

import MyException.*;

import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class ParserArguments {
    private final ArrayList<String> inputFileList = new ArrayList<>();
    private String outputIntFile = "";
    private String outputFloatFile = "";
    private String outputStringFile = "";
    private String path = "";
    private String prefix = "";
    private boolean flag_a = false;
    private boolean flag_s = false;
    private boolean flag_f = false;

    public boolean isFlag_a() {
        return flag_a;
    }

    public boolean isFlag_s() {
        return flag_s;
    }

    public boolean isFlag_f() {
        return flag_f;
    }

    public ArrayList<String> getInputFileList() {
        return inputFileList;
    }

    public String getPath() {
        return path;
    }

    public String getPrefix() {
        return prefix;
    }

    public String getOutputIntFile() {
        return outputIntFile;
    }

    public String getOutputFloatFile() {
        return outputFloatFile;
    }

    public String getOutputStringFile() {
        return outputStringFile;
    }


    public void parseArgs(String[] args) throws InvalidInputException, IOException {
        if (args.length != 0) {
            System.out.println(args.length);
            for (int i = 0; i < args.length; ++i) {
                switch (args[i]) {
                    case "-a":
                        if (!this.flag_a)
                            this.flag_a = true;
                        else
                            throw new InvalidInputException("More than one parameter \"-a\"");
                        System.out.println("Find -a");
                        break;
                    case "-s":
                        if (!isFlag_s())
                            this.flag_s = true;
                        else
                            throw new InvalidInputException("More than one parameter \"-s\"");
                        System.out.println("Find -s");
                        break;
                    case "-f":
                        if (!isFlag_f())
                            this.flag_f = true;
                        else
                            throw new InvalidInputException("More than one parameter \"-f\"");
                        System.out.println("Find -f");
                        break;
                    case "-o":
                        System.out.println("Find -o");
                        try {
                            String tmp = args[++i];
                            if (!tmp.endsWith("/"))
                                tmp = tmp + "/";
                            if (!tmp.startsWith("-"))
                                this.path = tmp;
                            else
                                throw new InvalidInputException("Parameter -o can not be empty!");
                            System.out.printf("path  =  %s\n", this.getPath());
                        } catch (ArrayIndexOutOfBoundsException e) {
                            throw new InvalidInputException("After setting the -o parameter, its value is required\n"
                                    + e.getMessage());
                        }
                        break;
                    case "-p":
                        System.out.println("Find -p");
                        try {
                            String tmp = args[++i];
                            if (!tmp.startsWith("-"))
                                this.prefix = tmp;
                            else
                                throw new InvalidInputException("Parameter -p can not be empty!");
                            System.out.printf("prefix  =  %s\n", this.getPrefix());
                        } catch (ArrayIndexOutOfBoundsException e) {
                            throw new InvalidInputException("After setting the -o parameter, its value is required\n"
                                    + e.getMessage());
                        }
                        break;
                    default:
                        if (args[i].endsWith(".txt"))
                            this.inputFileList.add(args[i]);
                        else
                            throw new InvalidInputException("Unknown argument: " + args[i] + "\n");
                        break;
                }
            }
            if (this.inputFileList.size() == 0)
                throw new InvalidInputException("Files to read are not specified\n");
            System.out.println(" fileList size = " + this.getInputFileList().size());
            if (isFlag_s() && isFlag_f())
                throw new InvalidInputException("two parameters were introduced for statistics (-s and -f)\n");

            this.outputIntFile = (this.getPath() + this.getPrefix() + "integers.txt");
            this.outputFloatFile = (this.getPath() + this.getPrefix() + "floats.txt");
            this.outputStringFile = (this.getPath() + this.getPrefix() + "strings.txt");

            for (String filename : this.getInputFileList())
                System.out.println("fileName = " + filename);
        } else {
            throw new NullPointerException("\nEmpty parameters.\n" +
                    "About program:\n" +
                    "\tfilename.txt - file name to read\n" +
                    "\tflag \"-o\" - set path output file\n" +
                    "\tflag \"-p\" - set the prefix of the output file\n" +
                    "\tflag \"-a\" - add to the output file (without overwriting)\n" +
                    "\tflag \"-s\" - brief statistics\n" +
                    "\tflag \"-f\" - full statistics\n" +
                    "Example:\n" +
                    "\t-s -a -p prefix- example1.txt example2.txt");
        }

    }
}
