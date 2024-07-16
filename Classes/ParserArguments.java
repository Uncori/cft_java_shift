package Classes;

import MyException.*;

import java.util.ArrayList;

public class ParserArguments {
    ArrayList<String> fileList = new ArrayList<>();
    private boolean defaultPath = true;
    private String path;
    private String prefix;
    private boolean flag_o = false;
    private boolean flag_p = false;
    private boolean flag_a = false;
    private boolean flag_s = false;
    private boolean flag_f = false;

    public ArrayList<String> getFileList() {
        return fileList;
    }

    public void setFileList(ArrayList<String> fileList) {
        this.fileList = fileList;
    }

    public boolean isDefaultPath() {
        return defaultPath;
    }

    public void setDefaultPath(boolean default_path) {
        this.defaultPath = default_path;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }


    public String getPrefix() {
        return prefix;
    }

    public void setPrefix(String prefix) {
        this.prefix = prefix;
    }

    public boolean isFlag_o() {
        return flag_o;
    }

    public void setFlag_o(boolean flag_o) {
        this.flag_o = flag_o;
    }

    public boolean isFlag_p() {
        return flag_p;
    }

    public void setFlag_p(boolean flag_p) {
        this.flag_p = flag_p;
    }

    public boolean isFlag_a() {
        return flag_a;
    }

    public void setFlag_a(boolean flag_a) {
        this.flag_a = flag_a;
    }

    public boolean isFlag_s() {
        return flag_s;
    }

    public void setFlag_s(boolean flag_s) {
        this.flag_s = flag_s;
    }

    public boolean isFlag_f() {
        return flag_f;
    }

    public void setFlag_f(boolean flag_f) {
        this.flag_f = flag_f;
    }

    public void parseArgs(String[] args) throws InvalidInputException {
        for(int i = 0; i < args.length; ++i) {
            switch (args[i]) {
                case "-a":
                    System.out.println("Find -a");
                    this.setFlag_a(true);
                    break;
                case "-s":
                    System.out.println("Find -s");
                    this.setFlag_s(true);
                    break;
                case "-f":
                    System.out.println("Find -f");
                    this.setFlag_f(true);
                    break;
                case "-o":
                    System.out.println("Find -o");
                    this.setFlag_o(true);
                    this.setDefaultPath(false);
                    try {
                        String tmp = args[++i];
                        if(!tmp.startsWith("-"))
                            this.setPath(tmp);
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
                    this.setFlag_p(true);
                    try {
                        String tmp = args[++i];
                        if(!tmp.startsWith("-"))
                            this.setPrefix(tmp);
                        else
                            throw new InvalidInputException("Parameter -p can not be empty!");
                        System.out.printf("prefix  =  %s\n", this.getPrefix());
                    } catch (ArrayIndexOutOfBoundsException e) {
                        throw new InvalidInputException("After setting the -o parameter, its value is required\n"
                                + e.getMessage());
                    }
                    break;
                default:
                    if(args[i].endsWith(".txt"))
                        this.fileList.add(args[i]);
                    for(Object feather : fileList) {
                        System.out.println(feather);
                    }
                        System.out.println(fileList.size());
                    break;
            }
        }
    }
}
