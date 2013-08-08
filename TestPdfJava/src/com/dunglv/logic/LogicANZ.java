package com.dunglv.logic;

import java.util.ArrayList;
import java.util.List;

public class LogicANZ {

	public static void main(String[] args) {
		String NYHAClass = "II";
		int lvef = 30;
		int qrs = 150;
		boolean optimalMedical = true;
		boolean sinusRhythm = true;
		boolean priorSCA = true;
		boolean sustainedVT = true;
		boolean priorMI = true;
		boolean echoAvailable = false;

		List<String> listResult = LogicANZ.ANZCalculator(NYHAClass, lvef, qrs,
				optimalMedical, sinusRhythm, priorSCA, sustainedVT, priorMI,
				echoAvailable);
		for (String string : listResult) {
			System.out.println(string);
		}
	}

	private static List<String> ANZCalculator(String NYHAClass, int lvef,
			int qrs, boolean optimalMedical, boolean sinusRhythm,
			boolean priorSCA, boolean sustainedVT, boolean priorMI,
			boolean echoAvailable) {
		List<String> listResult = new ArrayList<String>();

		/************************* CRT Indication *************************/
		// CRT1
		if (echoAvailable
				&& (NYHAClass.equals("III") || NYHAClass.equals("IV"))
				&& lvef <= 35 && qrs >= 120 && optimalMedical && sinusRhythm) {
			listResult.add("CRT1");
		}
		// CRT2
		if (echoAvailable && NYHAClass.equals("II") && lvef <= 30 && qrs >= 150
				&& optimalMedical && sinusRhythm) {
			listResult.add("CRT2");
		}
		/************************* ICD Indication *************************/
		// ICD2
		if (priorSCA) {
			listResult.add("ICD2");
		}
		if (sustainedVT) {
			listResult.add("ICD2");
		}
		if (echoAvailable && lvef <= 30 && priorMI) {
			listResult.add("ICD2");
		}
		if (echoAvailable
				&& (NYHAClass.equals("II") || NYHAClass.equals("III"))
				&& lvef <= 35) {
			listResult.add("ICD2");
		}
		/************************* ECHO Indication *************************/
		if (!echoAvailable) {
			listResult.add("ECHO3");
		}
		return listResult;
	}
}
