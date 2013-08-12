package com.dunglv.logic;

import java.util.ArrayList;
import java.util.List;

public class LogicUK {

	public static void main(String[] args) {
		String NYHAClass = "III";
		boolean echoAvailable = false;
		int lvef = 29;
		int qrsWidth = 140;
		boolean mechanicalDyssynchrony = true;
		boolean optimalMedical = true;
		boolean priorSCAorVF = false;
		boolean vf = false;
		boolean sustainedVT = true;
		boolean nonSustainedVT = true;
		boolean inducibleVTonEPTest = true;
		boolean expectationOfSurvival = true;
		boolean priorMI = true;
		boolean firstMIEvent = true;
		boolean syncope = true;
		boolean familial = true;
		boolean hf = true;

		List<String> listResult = LogicUK.UKCalculator(NYHAClass,
				echoAvailable, lvef, qrsWidth, mechanicalDyssynchrony,
				optimalMedical, priorSCAorVF, vf, sustainedVT, nonSustainedVT,
				inducibleVTonEPTest, expectationOfSurvival, priorMI,
				firstMIEvent, syncope, familial, hf);
		for (String string : listResult) {
			System.out.println(string);
		}
	}

	private static List<String> UKCalculator(String NYHAClass,
			boolean echoAvailable, int lvef, int qrsWidth,
			boolean mechanicalDyssynchrony, boolean optimalMedical,
			boolean priorSCAorVF, boolean vf, boolean sustainedVT,
			boolean nonSustainedVT, boolean inducibleVTonEPTest,
			boolean expectationOfSurvival, boolean priorMI,
			boolean firstMIEvent, boolean syncope, boolean familial, boolean hf) {
		List<String> listResult = new ArrayList<String>();

		/************************* CRT Indication *************************/
		// CRT1
		if (echoAvailable
				&& (NYHAClass.equals("III") || NYHAClass.equals("IV"))
				&& lvef <= 35 && qrsWidth >= 150 && optimalMedical) {
			listResult.add("CRT1");
		}
		if (echoAvailable
				&& (NYHAClass.equals("III") || NYHAClass.equals("IV"))
				&& lvef <= 35 && qrsWidth >= 120 && qrsWidth < 150
				&& mechanicalDyssynchrony && optimalMedical) {
			listResult.add("CRT1");
		}
		/************************* ICD Indication *************************/
		// ICD 2.1
		if (priorSCAorVF) {
			listResult.add("ICD2");
		}
		// ICD 2.2
		if (vf) {
			listResult.add("ICD2");
		}
		// ICD 2.3
		if (echoAvailable
				&& (NYHAClass.equals("I") || NYHAClass.equals("II") || NYHAClass
						.equals("III")) && lvef <= 35 && !priorSCAorVF && !vf
				&& sustainedVT) {
			listResult.add("ICD2");
		}
		// ICD 2 bis
		if ((NYHAClass.equals("I") || NYHAClass.equals("II") || NYHAClass
				.equals("III"))
				&& !priorSCAorVF
				&& !vf
				&& sustainedVT
				&& syncope) {
			listResult.add("ICD2bis");
		}

		// ICD 3
		if (echoAvailable
				&& (NYHAClass.equals("I") || NYHAClass.equals("II") || NYHAClass
						.equals("III")) && lvef <= 35 && nonSustainedVT
				&& inducibleVTonEPTest && priorMI && firstMIEvent) {
			listResult.add("ICD3");
		}
		// ICD 4
		if (echoAvailable
				&& (NYHAClass.equals("I") || NYHAClass.equals("II") || NYHAClass
						.equals("III")) && lvef <= 30 && priorMI
				&& firstMIEvent && qrsWidth >= 120) {
			listResult.add("ICD4");
		}
		// ICD 5
		if (familial) {
			listResult.add("ICD5");
		}
		/************************* ECHO *************************/
		if (hf && !echoAvailable) {
			listResult.add("ECHO6");
		}
		return listResult;
	}
}
