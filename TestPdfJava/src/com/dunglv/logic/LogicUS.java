package com.dunglv.logic;

import java.util.ArrayList;
import java.util.List;

public class LogicUS {

	public static void main(String[] args) {
		String etiology = "Caridac sarcoidosis, giant cell myocarditis, Chagas, or non-hospitalized patients awaiting heart transplantation";
		String NYHAClass = "I";
		int lvef = 30;
		int qrs = 150;
		String qrsMorphology = "non-LBBB";
		boolean optimalMedical = true;
		String atrialRythm = "Sinus";
		boolean classIPacemarker = true;
		boolean echoAvailable = false;
		boolean priorSCAOrVF = true;
		boolean VF = true;
		boolean sustainedVT = true;
		boolean nonSustainedVT = true;
		boolean lifeExpectative = true;
		boolean priorMI = true;
		boolean firstMI40days = true;
		boolean syncope = true;

		List<String> listResult = LogicUS.USCalculator(echoAvailable, etiology,
				NYHAClass, lvef, priorMI, firstMI40days, VF, sustainedVT,
				nonSustainedVT, priorSCAOrVF, syncope, lifeExpectative, qrs,
				qrsMorphology, optimalMedical, atrialRythm, classIPacemarker);
		for (String string : listResult) {
			System.out.println(string);
		}
	}

	private static List<String> USCalculator(boolean echoAvailable,
			String etiology, String NYHAClass, int lvef, boolean priorMI,
			boolean firstMI40days, boolean VF, boolean sustainedVT,
			boolean nonSustainedVT, boolean priorSCAOrVF, boolean syncope,
			boolean lifeExpectative, int qrs, String qrsMorphology,
			boolean optimalMedical, String atrialRythm, boolean classIPacemarker) {
		List<String> listResult = new ArrayList<String>();

		/************** CRT ********************/
		// CRT 1
		if (echoAvailable
				&& (NYHAClass.equals("II") || NYHAClass.equals("III") || NYHAClass
						.equals("IV")) && lvef <= 35 && qrs >= 150
				&& qrsMorphology.equals(ConstantLogic.QRS_MORPHOLOGY_LBBB)
				&& optimalMedical
				&& atrialRythm.equals(ConstantLogic.RHYTHM_SINUS)
				&& !classIPacemarker) {
			listResult.add("CRT1");
		}

		// CRT 2A
		if (echoAvailable
				&& (NYHAClass.equals("II") || NYHAClass.equals("III") || NYHAClass
						.equals("IV")) && lvef <= 35 && qrs >= 120 && qrs < 150
				&& qrsMorphology.equals(ConstantLogic.QRS_MORPHOLOGY_LBBB)
				&& optimalMedical
				&& atrialRythm.equals(ConstantLogic.RHYTHM_SINUS)
				&& !classIPacemarker) {
			listResult.add("CRT2A");
		}

		// CRT 3
		if (echoAvailable
				&& (NYHAClass.equals("II") || NYHAClass.equals("III") || NYHAClass
						.equals("IV")) && lvef <= 35 && qrs >= 150
				&& qrsMorphology.equals(ConstantLogic.QRS_MORPHOLOGY_NON_LBBB)
				&& optimalMedical
				&& atrialRythm.equals(ConstantLogic.RHYTHM_SINUS)
				&& !classIPacemarker) {
			listResult.add("CRT3");
		}

		// CRT 2B
		if (echoAvailable && lvef <= 35 && optimalMedical
				&& atrialRythm.equals(ConstantLogic.RHYTHM_AF_AVN_ABLATION)
				&& classIPacemarker) {
			listResult.add("CRT2B");
		}

		// CRT 4
		if (echoAvailable && lvef <= 35
				&& qrsMorphology.equals(ConstantLogic.QRS_MORPHOLOGY_RV_PACED)
				&& optimalMedical
				&& atrialRythm.equals(ConstantLogic.RHYTHM_RV_PACED)
				&& classIPacemarker) {
			listResult.add("CRT4");
		}

		// CRT 5
		if (echoAvailable && NYHAClass.equals("I") && lvef <= 30
				&& etiology.equals(ConstantLogic.ETIOLOGY_ISCHEMIC)
				&& qrs >= 150
				&& qrsMorphology.equals(ConstantLogic.QRS_MORPHOLOGY_LBBB)
				&& optimalMedical
				&& atrialRythm.equals(ConstantLogic.RHYTHM_SINUS)) {
			listResult.add("CRT5");
		}

		// CRT 6
		if (echoAvailable
				&& (NYHAClass.equals("III") || NYHAClass.equals("IV"))
				&& lvef <= 35 && qrs >= 120 && qrs < 150
				&& qrsMorphology.equals(ConstantLogic.QRS_MORPHOLOGY_NON_LBBB)
				&& optimalMedical
				&& atrialRythm.equals(ConstantLogic.RHYTHM_SINUS)) {
			listResult.add("CRT6");
		}
		// CRT 7
		if (echoAvailable && (NYHAClass.equals("II")) && lvef <= 35
				&& qrs >= 150
				&& qrsMorphology.equals(ConstantLogic.QRS_MORPHOLOGY_NON_LBBB)
				&& optimalMedical
				&& atrialRythm.equals(ConstantLogic.RHYTHM_SINUS)) {
			listResult.add("CRT7");
		}
		/************** ICD ********************/
		// ICD2
		if (priorSCAOrVF && sustainedVT) {
			listResult.add("ICD2");
		}
		// ICD2
		if (VF && sustainedVT) {
			listResult.add("ICD2");
		}
		// ICD 2bis
		if (echoAvailable && lvef < 40 && VF && nonSustainedVT
				&& lifeExpectative && priorMI) {
			listResult.add("ICD2bis");
		}

		// ICD3
		if (echoAvailable
				&& (NYHAClass.equals("II") || NYHAClass.equals("III"))
				&& lvef <= 35 && optimalMedical && lifeExpectative && priorMI
				&& firstMI40days
				&& etiology.equals(ConstantLogic.ETIOLOGY_ISCHEMIC)) {
			listResult.add("ICD3");
		}

		// ICD4
		if (echoAvailable
				&& (NYHAClass.equals("II") || NYHAClass.equals("III"))
				&& lvef <= 35 && optimalMedical && lifeExpectative && !priorMI
				&& etiology.equals(ConstantLogic.ETIOLOGY_NON_ISCHEMIC)) {
			listResult.add("ICD4");
		}

		// ICD5
		if (echoAvailable && NYHAClass.equals("I") && lvef <= 30
				&& optimalMedical && lifeExpectative && priorMI
				&& firstMI40days
				&& etiology.equals(ConstantLogic.ETIOLOGY_ISCHEMIC)) {
			listResult.add("ICD5");
		}
		// ICD6
		if (optimalMedical && sustainedVT && lifeExpectative
				&& etiology.equals(ConstantLogic.ETIOLOGY_STRUCTURAL)) {
			listResult.add("ICD6");
		}
		// ICD7
		if (optimalMedical && VF && sustainedVT && lifeExpectative
				&& etiology.equals(ConstantLogic.ETIOLOGY_UNKNOWN) && syncope) {
			listResult.add("ICD7");
		}
		// ICD8
		if (optimalMedical && lifeExpectative
				&& etiology.equals(ConstantLogic.ETIOLOGY_LONG_QT) && syncope) {
			listResult.add("ICD8");
		}
		// ICD9
		if (optimalMedical && lifeExpectative
				&& etiology.equals(ConstantLogic.ETIOLOGY_NON_ISCHEMIC_DCM)
				&& syncope) {
			listResult.add("ICD9");
		}
		// ICD10
		if (optimalMedical && lifeExpectative
				&& etiology.equals(ConstantLogic.ETIOLOGY_ARVD)) {
			listResult.add("ICD10");
		}
		// ICD11
		if (optimalMedical && lifeExpectative
				&& etiology.equals(ConstantLogic.ETIOLOGY_BRUGADA) && syncope) {
			listResult.add("ICD11");
		}
		// ICD12
		if (optimalMedical && sustainedVT && lifeExpectative
				&& etiology.equals(ConstantLogic.ETIOLOGY_CARIDAC)) {
			listResult.add("ICD12");
		}
		return listResult;
	}
}
