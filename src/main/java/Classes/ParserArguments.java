package Classes;

import Classes.MyException.InvalidInputException;

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

    public void parseArgs(String[] args) throws InvalidInputException {
        if (args.length != 0) {
            for (int i = 0; i < args.length; ++i) {
                switch (args[i]) {
                    case "-a":
                        if (!this.flag_a) this.flag_a = true;
                        else throw new InvalidInputException("Больше одного параметра \"-a\"");
                        break;
                    case "-s":
                        if (!isFlag_s()) this.flag_s = true;
                        else throw new InvalidInputException("Больше одного параметра \"-s\"");
                        break;
                    case "-f":
                        if (!isFlag_f()) this.flag_f = true;
                        else throw new InvalidInputException("Больше одного параметра \"-f\"");
                        break;
                    case "-o":
                        try {
                            String tmp = args[++i];
                            if (!tmp.endsWith("/")) tmp = tmp + "/";
                            if (!tmp.startsWith("-") || tmp.endsWith(".txt")) this.path = tmp;
                            else throw new InvalidInputException("Параметр -o не может быть пустым");
                        } catch (ArrayIndexOutOfBoundsException e) {
                            throw new InvalidInputException("После параметра -o нет указания пути\n" + e.getMessage());
                        }
                        break;
                    case "-p":
                        try {
                            String tmp = args[++i];
                            if (!tmp.startsWith("-") || tmp.endsWith(".txt")) this.prefix = tmp;
                            else throw new InvalidInputException("Параметр -p не может быть пустым");
                        } catch (ArrayIndexOutOfBoundsException e) {
                            throw new InvalidInputException("После параметра -p нет указания префикса\n"
                                    + e.getMessage());
                        }
                        break;
                    default:
                        if (args[i].endsWith(".txt"))
                            this.inputFileList.add(args[i]);
                        else
                            throw new InvalidInputException("Неизвестный аргумент: " + args[i] + "\n");
                        break;
                }
            }
            if (this.inputFileList.size() == 0) throw new InvalidInputException("Укажите файлы для считывания\n");

            if (isFlag_s() && isFlag_f())
                throw new InvalidInputException("Указано два выбора вывода статистики (-s и -f)\n");

            this.outputIntFile = (this.getPath() + this.getPrefix() + "integers.txt");
            this.outputFloatFile = (this.getPath() + this.getPrefix() + "floats.txt");
            this.outputStringFile = (this.getPath() + this.getPrefix() + "strings.txt");

        } else {
            throw new InvalidInputException("\nПрограмма запущена без параметров\n"
                    + "О программе:\n"
                    + "\tfilename.txt - путь к файлу для считывания\n"
                    + "\tflag \"-o\" - установка пути к выходному файлу\n"
                    + "\tflag \"-p\" - установка префикса к выходным файлам\n"
                    + "\tflag \"-a\" - установка режима добавления в выходные файлы\n"
                    + "\tflag \"-s\" - краткая статистика\n"
                    + "\tflag \"-f\" - полная статистика\n"
                    + "Пример:\n"
                    + "\tjava -jar имя_программы -s -a -p prefix- example1.txt example2.txt");
        }

    }
}
