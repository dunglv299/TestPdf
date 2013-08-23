import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class TestDay {
	public static void main(String[] args) {
		DateFormat dateFormat = new SimpleDateFormat("EEE dd/MM/yyyy");
		Date date = new Date();
		System.out.println(dateFormat.format(date));
		
		String s = "dunglv";
		List<String> list = new ArrayList<String>();
		if (list.contains("d")){
			System.out.println("true");
		}
		
		Pattern p = Pattern.compile("[\\p{Alpha}]*[\\p{Punct}][\\p{Alpha}]*");
        Matcher m = p.matcher("Afsff%esfsf098");
        boolean b = m.matches();

        if (b == true)
           System.out.println("There is a sp. character in my string");
        else
            System.out.println("There is no sp. char.");
	}
}
