package gupta_lab.beithir.Models;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class InputValidation {
    public static Boolean textValidate(String str){
        String pattern = "[~`!@#$%'^&*)(;:\"}{=+?.><,-]";
        Pattern r = Pattern.compile(pattern);
        Matcher m = r.matcher(str);

        return !m.find();
    }

}
