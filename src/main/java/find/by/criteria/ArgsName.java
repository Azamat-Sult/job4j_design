package find.by.criteria;

import java.util.HashMap;
import java.util.Map;

public class ArgsName {

    private final Map<String, String> values = new HashMap<>();

    public String get(String key) {
        return values.get(key);
    }

    private void parse(String[] args) {
        if (args.length == 0) {
            throw new IllegalArgumentException();
        }
        for (String argument : args) {
            String[] argSplit = argument.split("=");
            if (argSplit.length != 2 || (argSplit[0].isBlank()
                    || argSplit[1].isBlank())) {
                throw new IllegalArgumentException();
            }
            values.put(argSplit[0].substring(1), argSplit[1]);
        }
    }

    public static ArgsName of(String[] args) {
        ArgsName names = new ArgsName();
        names.parse(args);
        return names;
    }
}
