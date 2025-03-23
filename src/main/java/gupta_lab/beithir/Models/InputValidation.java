/**
 * Validation models for Beithir views
 * Package based on GitHub Gist (https://gist.github.com/jewelsea/6460130).
 * @author Dennis A. Simpson
 * @since March 2025
 * @version 0.1.1
 */

package gupta_lab.beithir.Models;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class InputValidation {
    public static Boolean numberValidate(String value){
        String pattern = ".[0-9]";
        //String pattern = "[-]?[0-9]+(\\.[0-9]+)?";
        Pattern r = Pattern.compile(pattern);
        Matcher m = r.matcher(value);
        //return !m.find();
        return value.matches("[-]?[0-9]+(\\\\.[0-9]+)?");
    }
    public static Boolean textValidate(String str){
        String pattern = "[~`!@#$%'^&*)(;:\"}{=+?.><,-]";
        Pattern r = Pattern.compile(pattern);
        Matcher m = r.matcher(str);

        return !m.find();
    }

}
