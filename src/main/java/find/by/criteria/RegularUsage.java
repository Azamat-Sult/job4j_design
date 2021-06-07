package find.by.criteria;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegularUsage {
    public static void main(String[] args) {
        Pattern pattern = Pattern.compile(".*collection.*\\.txt");
        Matcher matcher = pattern.matcher("asd.collection.zxc.txt");
        System.out.println(matcher.find());
    }
}
