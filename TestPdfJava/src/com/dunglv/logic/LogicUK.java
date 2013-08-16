package com.dunglv.logic;

import java.util.ArrayList;
import java.util.List;
import java.util.TreeSet;

public class LogicUK {

	public static void main(String[] args) {
		String nyhaClass = "III";
		boolean echoAvailable = true;
		int lvef = 35;
		int qrsWidth = 160;
		boolean mechanicalDyssynchrony = true;
		boolean optimalMedical = true;
		boolean priorSCAorVF = true;
		boolean vf = true;
		boolean sustainedVT = false;
		boolean nonSustainedVT = true;
		boolean inducibleVTonEPTest = true;
		boolean expectationOfSurvival = true;
		boolean priorMI = true;
		boolean firstMIEvent = true;
		boolean syncope = true;
		boolean familial = true;

		List<String> listResult = LogicUK.UKCalculator(nyhaClass,
				echoAvailable, lvef, qrsWidth, mechanicalDyssynchrony,
				optimalMedical, priorSCAorVF, vf, sustainedVT, nonSustainedVT,
				inducibleVTonEPTest, expectationOfSurvival, priorMI,
				firstMIEvent, syncope, familial);
		for (String string : listResult) {
			System.out.println(string);
		}
	}

	private static List<String> UKCalculator(String nyhaClass,
			boolean echoAvailable, int lvef, int qrsWidth,
			boolean mechanicalDyssynchrony, boolean optimalMedical,
			boolean priorSCAorVF, boolean vf, boolean sustainedVT,
			boolean nonSustainedVT, boolean inducibleVTonEPTest,
			boolean expectationOfSurvival, boolean priorMI,
			boolean firstMIEvent, boolean syncope, boolean familial) {
		List<String> listResult = new ArrayList<String>();

		/************************* CRT Indication *************************/
		// CRT1
		if (echoAvailable
				&& (nyhaClass.equals("III") || nyhaClass.equals("IV"))
				&& lvef <= 35 && qrsWidth >= 150 && optimalMedical) {
			listResult.add("CRT1");
		}
		if (echoAvailable
				&& (nyhaClass.equals("III") || nyhaClass.equals("IV"))
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
				&& (nyhaClass.equals("I") || nyhaClass.equals("II") || nyhaClass
						.equals("III")) && lvef <= 35 && !priorSCAorVF && !vf
				&& sustainedVT) {
			listResult.add("ICD2");
		}
		// ICD 2 bis
		if ((nyhaClass.equals("I") || nyhaClass.equals("II") || nyhaClass
				.equals("III"))
				&& !priorSCAorVF
				&& !vf
				&& sustainedVT
				&& syncope) {
			listResult.add("ICD2bis");
		}

		// ICD 3
		if (echoAvailable
				&& (nyhaClass.equals("I") || nyhaClass.equals("II") || nyhaClass
						.equals("III")) && lvef <= 35 && nonSustainedVT
				&& inducibleVTonEPTest && priorMI && firstMIEvent) {
			listResult.add("ICD3");
		}
		// ICD 4
		if (echoAvailable
				&& (nyhaClass.equals("I") || nyhaClass.equals("II") || nyhaClass
						.equals("III")) && lvef <= 30 && priorMI
				&& firstMIEvent && qrsWidth >= 120) {
			listResult.add("ICD4");
		}
		// ICD 5
		if (familial) {
			listResult.add("ICD5");
		}
		/************************* ECHO *************************/
		if (!echoAvailable) {
			listResult.add("ECHO6");
		}
		List<String> newList = new ArrayList<String>(new TreeSet<String>(
				listResult));
		System.out.println("Unique values using List " + newList);
		return newList;
	}
}
