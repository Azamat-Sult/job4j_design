package find.by.criteria;

import java.io.BufferedOutputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.function.Predicate;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Find {
    private String findInRootDir;
    private String fileToSaveRsl;
    private Predicate<Path> findCondition;

    private void initArgs(String[] arguments) {
        if (arguments.length != 4) {
            throw new IllegalArgumentException("\n Correct usage: \n"
                    + " java -jar find.jar -d=FIND_IN_DIR -n=FILE_NAME/MASK/REGULAR"
                    + " -t=FIND_TYPE:mask/name/regex -o=SAVE_RESULT_TO_FILE"
                    + "\n Example: \n"
                    + " java -jar find.jar -d=c:/ -n=*.txt -t=mask -o=log.txt");
        }

        ArgsName findArgs = ArgsName.of(arguments);

        this.findInRootDir = findArgs.get("d");
        String findType = findArgs.get("t");
        String findThis = (findType.equals("mask")) ? findArgs.get("n")
                .replaceAll("\\.", "\\\\.")
                .replaceAll("\\*", "\\.*")
                .replaceAll("\\?", ".") : findArgs.get("n");
        this.fileToSaveRsl = findArgs.get("o");
        this.findCondition = getFindCondition(findType, findThis);
    }

    private Predicate<Path> getFindCondition(String findType, String findThis) {
        Predicate<Path> rsl = null;

        if (findType.equals("name")) {
            rsl = p -> p.toFile().getName().equals(findThis);
        }

        if (findType.equals("mask") || findType.equals("regex")) {
            rsl = p -> {
                Pattern pattern = Pattern.compile(findThis);
                Matcher matcher = pattern.matcher(p.toFile().getName());
                return matcher.find();
            };
        }
        return rsl;
    }

    private List<Path> find(String dirPath, Predicate<Path> predicate) {
        List<Path> rsl = null;
        try {
            rsl = Search.search(Paths.get(dirPath), predicate);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return rsl;
    }

    public void save(List<Path> files, String destFile) {
        try (PrintWriter out = new PrintWriter(
                new BufferedOutputStream(
                        new FileOutputStream(destFile)))) {
            for (Path file : files) {
                out.println(file);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        Find findFiles = new Find();
        findFiles.initArgs(args);
        List<Path> filesFound = findFiles.find(findFiles.findInRootDir, findFiles.findCondition);
        findFiles.save(filesFound, findFiles.fileToSaveRsl);
    }
}
