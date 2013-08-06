import java.util.ArrayList;
import java.util.List;

public class TestLogicEU {

	public static void main(String[] args) {
		List<String> listResult = TestLogicEU.EUCalculator("Non-Ischemic", "I",
				true, 30, true, true, "Non-sustained VT", true, true, true,
				false, 120, true, "Permanent AF", true, true);
		for (String string : listResult) {
			System.out.println(string);
		}
	}

	private static List<String> EUCalculator(String etiology, String NYHAClass,
			boolean echoAvailable, int lvef, boolean priorMI, boolean firstMI,
			String arrythmias, boolean priorSudden, boolean syncope,
			boolean lifeExpectative, boolean lbbb, int qrs,
			boolean optimalMedical, String atrialRythm,
			boolean ventricularPacing, boolean pacingExpected) {
		List<String> listResult = new ArrayList<String>();

		// CRT 1
		if ((NYHAClass.equals("II") || NYHAClass.equals("III") || NYHAClass
				.equals("IV"))
				&& lbbb
				&& lvef <= 35
				&& qrs >= 150
				&& atrialRythm.equals("Sinus rythm") && optimalMedical) {
			listResult.add("CRT1");
		}
		// CRT 2
		if ((NYHAClass.equals("II") || NYHAClass.equals("III") || NYHAClass
				.equals("IV"))
				&& lbbb
				&& lvef <= 35
				&& qrs >= 120
				&& qrs < 150
				&& atrialRythm.equals("Sinus rythm") && optimalMedical) {
			listResult.add("CRT2");
		}
		// CRT 3
		if ((NYHAClass.equals("II") || NYHAClass.equals("III") || NYHAClass
				.equals("IV"))
				&& !lbbb
				&& lvef <= 35
				&& qrs >= 150
				&& atrialRythm.equals("Sinus rythm") && optimalMedical) {
			listResult.add("CRT3");
		}
		// CRT 4
		if ((NYHAClass.equals("II") || NYHAClass.equals("III") || NYHAClass
				.equals("IV"))
				&& !lbbb
				&& lvef <= 35
				&& qrs >= 120
				&& qrs < 150
				&& atrialRythm.equals("Sinus rythm")
				&& optimalMedical) {
			listResult.add("CRT4");
		}
		// CRT 5
		if (qrs < 120 && atrialRythm.equals("Sinus rythm") && optimalMedical) {
			listResult.add("CRT5");
		}
		// CRT 6
		if ((NYHAClass.equals("III") || NYHAClass.equals("IV")) && lvef <= 35
				&& qrs >= 120 && atrialRythm.equals("Permanent AF")
				&& optimalMedical) {
			listResult.add("CRT6");
		}
		// CRT 7
		if ((NYHAClass.equals("III") || NYHAClass.equals("IV")) && lvef <= 35
				&& optimalMedical && ventricularPacing) {
			listResult.add("CRT7");
		}
		// CRT 8
		if (lvef <= 50 && optimalMedical && pacingExpected) {
			listResult.add("CRT8");
		}
		// ICD 1
		if (priorSudden) {
			listResult.add("ICD1");
		}
		// ICD 2
		if (arrythmias.equals("SCA or VF")) {
			listResult.add("ICD2");
		}
		// ICD 3
		if (lifeExpectative && arrythmias.equals("Sustained VT")) {
			listResult.add("ICD3");
		}

		// ICD 4
		if ((NYHAClass.equals("II") || NYHAClass.equals("III")) && lvef <= 35
				&& lifeExpectative && priorMI && firstMI
				&& etiology.equals("Ischemic") && optimalMedical) {
			listResult.add("ICD4");
		}
		// ICD 5
		if ((NYHAClass.equals("II") || NYHAClass.equals("III")) && lvef <= 35
				&& optimalMedical && lifeExpectative
				&& etiology.equals("Non-Ischemic")) {
			listResult.add("ICD5");
		}
		// ICD 6
		if ((NYHAClass.equals("I")) && lvef <= 35 && optimalMedical
				&& lifeExpectative && priorMI && firstMI) {
			listResult.add("ICD6");
		}
		// ICD 7
		if ((NYHAClass.equals("I")) && lvef <= 35 && optimalMedical
				&& lifeExpectative && !priorMI) {
			listResult.add("ICD7");
		}
		// ICD 8
		if (optimalMedical && lifeExpectative
				&& arrythmias.equals("Sustained VT")
				&& etiology.equals("Hypertrophic")) {
			listResult.add("ICD8");
		}
		// ICD 9
		if (lvef <= 35 && optimalMedical && lifeExpectative && !priorMI
				&& etiology.equals("Non-Ischemic") && syncope) {
			listResult.add("ICD9");
		}
		// ICD 10
		if (lvef <= 40 && arrythmias.equals("Non-sustained VT") && priorMI) {
			listResult.add("ICD10");
		}

		// Error 1
		if (priorMI && etiology.equals("Non-Ischemic")) {
			listResult.add("Error1");
		} else {
			listResult.add("No Probs");
		}
		// ECHO 1
		if (!echoAvailable) {
			listResult.add("ECHO1");
		} else {
			listResult.add("No Probs");
		}
		return listResult;
	}
}