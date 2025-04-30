/**
 * Validation models for Beithir views
 * @author Dennis A. Simpson
 * @since March 2025
 * @version 0.9.0
 */

package gupta_lab.beithir.Models;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class InputValidation {
    public static Boolean numberValidate(String value){
        String pattern = "-?[0-9]+(\\.[0-9]+)?";
        Pattern r = Pattern.compile(pattern);
        Matcher m = r.matcher(value);
        return m.matches();
    }
    public static Boolean slotValidate(String value){
        String pattern = "([1-9]|1[0-1])";
        Pattern r = Pattern.compile(pattern);
        Matcher m = r.matcher(value);
        return m.matches();
    }
    public static Boolean wellValidate(String value){
        String pattern = "[ABCD]([1-6])";
        Pattern r = Pattern.compile(pattern);
        Matcher m = r.matcher(value);
        return m.matches();
    }
    public static Boolean firstTipLocationValidate(String value){
        String pattern = "-?[ABCDEFGH](1[0-2]|[1-9])?";
        Pattern r = Pattern.compile(pattern);
        Matcher m = r.matcher(value);
        return m.matches();
    }
    public static Boolean textValidate(String str){
        String pattern = "[~`!@#$%'^&*)(;:\"}{=+?.><,-]";
        Pattern r = Pattern.compile(pattern);
        Matcher m = r.matcher(str);
        return !m.find();
    }

}
