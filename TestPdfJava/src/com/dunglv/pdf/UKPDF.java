package com.dunglv.pdf;

/*
 * This class is part of the book "iText in Action - 2nd Edition"
 * written by Bruno Lowagie (ISBN: 9781935182610)
 * For more info, go to: http://itextpdf.com/examples/
 * This example only works with the AGPL version of iText.
 */

import java.io.FileOutputStream;
import java.io.IOException;
import java.net.MalformedURLException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Element;
import com.itextpdf.text.Font;
import com.itextpdf.text.FontFactory;
import com.itextpdf.text.Image;
import com.itextpdf.text.ListItem;
import com.itextpdf.text.PageSize;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.Phrase;
import com.itextpdf.text.Rectangle;
import com.itextpdf.text.ZapfDingbatsList;
import com.itextpdf.text.pdf.PdfContentByte;
import com.itextpdf.text.pdf.PdfImportedPage;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfReader;
import com.itextpdf.text.pdf.PdfWriter;

public class UKPDF {

	/** A resulting PDF file. */
	public static final String OUTPUT = "output.pdf";
	private Font fontBold12 = FontFactory.getFont("Arial", 12, Font.BOLD);
	private Font fontBold11 = FontFactory.getFont("Arial", 11, Font.BOLD);
	private Font fontBold13 = FontFactory.getFont("Arial", 13, Font.BOLD);
	private Font fontNormal10 = FontFactory.getFont("Arial", 10);
	private Font fontNormal11 = FontFactory.getFont("Arial", 11);
	private Font fontNormal22 = FontFactory.getFont("Arial", 22);
	private Font fontItalic9 = FontFactory.getFont("Arial", 9, Font.ITALIC);
	private Font fontItalic10 = FontFactory.getFont("Arial", 10, Font.ITALIC);
	private Font fontItalic16 = FontFactory.getFont("Arial", 16, Font.ITALIC);
	private int indentationLeft = 110;
	private String xxx = "xxxxxxx";
	private int tablePercent = 83;
	private static boolean isContainCRT;
	private static boolean isContainICD;

	public class ResultUKDialogFragment {

		public static final String crt1 = "- CRT 1-\nCRT is recommended according to NICE technical appraisal guidance 120 (CRT-D if ICD criteria are fulfilled too). Cardiac Resynchronisation Therapy with a pacing device (CRT-P) is recommended as a treatment option for people with herat failure who fulfil all the following criteria: They are currently experiencing or have recently experienced NYHA class III–IV symptoms; They are in sinus rhythm, either with a QRS duration of 150ms or longer estimated by standard ECG or with a QRS duration of 120-149ms estimated by ECG and mechanical dyssynchrony that is confirmed by echocardiography; They have a left ventricular ejection fraction of 35% or less; They are receiving optimal pharmacological therapy. Cardiac resynchronisation therapy with a defibrillator device (CRT-D) may be considered for people who fulfil the criteria for implantation of a CRT-P device and who also separately fulfil the criteria for the use of an ICD device as recommended in NICE technology appraisal guidance 95.\n\n";
		public static final String icd2 = "- ICD 2-\nICD is recommended according to NICE technical appraisal guidance 95. ICDs are recommended for patients in secondary prevention, that is, for patients who present, in the absence of a treatable cause, with one of the following: Having survived a cardiac arrest due to either ventricular tachycardia (VT) or ventricular fibrillation (VF); Spontaneous sustained VT causing syncope or significant haemodynamic compromise; Sustained VT without syncope or cardiac arrest, who have an associated reduction in ejection fraction (LVEF of less than 35%) (no worse than class III of the NYHA functional classification of heart failure)\n\n";
		public static final String icd2bis = "- ICD 2bis-\nICD is recommended according to NICE technical appraisal guidance 95 [if sustained VT causing syncope or significant haemodynamic compronise]. ICDs are recommended for patients in secondary prevention, that is, for patients who present, in the absence of a treatable cause, with one of the following: Having survived a cardiac arrest due to either ventricular tachycardia (VT) or ventricular fibrillation (VF); Spontaneous sustained VT causing syncope or significant haemodynamic compromise; Sustained VT without syncope or cardiac arrest, who have an associated reduction in ejection fraction (LVEF of less than 35%) (no worse than class III of the NYHA functional classification of heart failure)\n\n";
		public static final String icd3 = "- ICD 3-\nICD is recommended according to NICE technical appraisal guidance 95 [if non-sustained VT on Holter]. ICDs are recommended for patients in primary prevention who have a history of previous (more than 4 weeks) myocardial infarction (MI) and left ventricular dysfunction with an LVEF of less than 35% (no worse than class III of the NYHA functional classification of heart failure) and non-sustained VT on Holter (24-hour ECG monitoring) and inducible VT on electrophysiological (EP) testing\n\n";
		public static final String icd4 = "- ICD 4-\nICD is recommended according to NICE technical appraisal guidance 95. ICDs are recommended for patients in primary prevention who have a history of previous (more than 4 weeks) myocardial infarction (MI) and left ventricular dysfunction with an LVEF of less than 30% (no worse than class III of the NYHA functional classification of heart failure) and QRS duration of equal to or more than 120ms\n\n";
		public static final String icd5 = "- ICD 5-\nICD is recommended according to NICE technical appraisal guidance 95. ICDs are recommended for patients in primary prevention who have a familial cardiac condition with a high risk of sudden death, including Long QT Syndrome, hypertrophic cardiomyopathy, Brugada syndrome or arrhythymogenic right ventricular dysplasia (ARVD), or have undergone surgical repair of congenital heart disease.\n\n";
		public static final String echo = "- ECHO -\nIn HF patients with an abnormal ECG or BNP test, echocardiography should be performed according to NICE Clinical Guideline 5. Healthcare professionals should seek to exclude a diagnosis of heart failure through the following investigations: 12-lead ECG and/or natriuretic peptides (BNP or NTproBNP, where available). If one or both are abnormal, a diagnosis of heart failure  cannot be excluded and transthoracic Doppler 2D echocardiography should be performed because it consolidates the diagnosis and provides information on the underlying functional abnormality of the heart.\n\n";
	}

	/**
	 * Main method.
	 * 
	 * @param args
	 *            no arguments needed
	 * @throws DocumentException
	 * @throws IOException
	 */
	public static void main(String[] args) throws IOException,
			DocumentException {
		List<String> listResult = new ArrayList<String>();
		listResult.add("CRT1");
		isContainCRT = true;
		listResult.add("ICD2");
		listResult.add("ICD2bis");
		listResult.add("ICD3");
		listResult.add("ICD4");
		listResult.add("ICD5");
		listResult.add("ECHO6");
		isContainICD = true;

		PdfReader reader = new PdfReader("template.pdf");
		Document document = new Document(PageSize.A4, 0, 50, 50, 100);
		PdfWriter writer = PdfWriter.getInstance(document,
				new FileOutputStream(OUTPUT));
		document.open();
		PdfContentByte cb = writer.getDirectContent();

		// add footer
		HeaderFooter event = new HeaderFooter();
		writer.setBoxSize("art", new Rectangle(36, 54, 559, 788));
		writer.setPageEvent(event);
		new UKPDF().createFirstPage(document);
		new UKPDF().crt_UK_Pdf(document, listResult);
		new UKPDF().icd_UK_Pdf(document, listResult);
		new UKPDF().echo_UK_Pdf(document, listResult);
		document.newPage();

		// import page
		PdfImportedPage page1 = writer.getImportedPage(reader, 1);
		// Copy first page of existing PDF into output PDF
		cb.addTemplate(page1, 0, 0);

		// reader.close();
		document.close();
	}

	public void createFirstPage(Document document)
			throws MalformedURLException, IOException, DocumentException {
		document.newPage();
		// logo header
		Image imgHeader = Image.getInstance("header_pdf.jpg");
		imgHeader.scalePercent(45, 45);
		imgHeader.setAbsolutePosition(94, 770);
		document.add(imgHeader);

		// ScreenLink Calculator
		Paragraph line = new Paragraph("ScreenLink Calculator", fontNormal22);
		line.setAlignment(Element.ALIGN_CENTER);
		line.setSpacingBefore(50);
		document.add(line);

		// ICD / CRT Referral
		line = new Paragraph("ICD / CRT Referral", fontItalic16);
		line.setAlignment(Element.ALIGN_CENTER);
		line.setSpacingBefore(5);
		document.add(line);

		// day
		DateFormat dateFormat = new SimpleDateFormat("EEE dd/MM/yyyy");
		Date date = new Date();
		line = new Paragraph(dateFormat.format(date), fontItalic9);
		line.setAlignment(Element.ALIGN_CENTER);
		line.setSpacingBefore(5);
		document.add(line);

		// The information Table
		PdfPTable table = new PdfPTable(1);
		table.setSpacingBefore(20);
		table.setWidthPercentage(tablePercent);
		table.setHorizontalAlignment(Element.ALIGN_RIGHT);
		PdfPCell cell = new PdfPCell(
				new Phrase(
						"The information generated by ScreenLink must not be considered as an exclusive diagnostic tool. The final decision about your patient's appropriate therapy indication must be based on clinical evidence, applicable clinical and professional practice protocol and not solely on the basis of the ScreenLink tool. Medtronic hereby expressly disclaims any responsibility and liability whatsoever arising out of such usage of ScreenLink, and the user shall be solely responsible.\n",
						fontItalic10));
		cell.setPaddingLeft(15);
		cell.setPaddingRight(10);
		cell.setPaddingBottom(5);
		table.addCell(cell);
		document.add(table);

		/* Patient details */
		// symbol
		Image symbol = Image.getInstance("symbol.png");
		symbol.scalePercent(30, 30);
		symbol.setAbsolutePosition(90, 540);
		document.add(symbol);

		// line
		line = new Paragraph("Patient details", fontBold13);
		line.setIndentationLeft(indentationLeft);
		line.setSpacingBefore(23);
		document.add(line);

		// Table
		table = new PdfPTable(2); // Code 1
		table.setSpacingBefore(20);
		table.setHorizontalAlignment(Element.ALIGN_RIGHT);
		table.setWidths(new int[] { 10, 25 });
		table.setWidthPercentage(tablePercent); // Code 2
		table.addCell(new Phrase("Name", fontNormal11));
		table.addCell("");
		table.addCell(new Phrase("Address", fontNormal11));
		table.addCell("");
		table.addCell(new Phrase("Postcode", fontNormal11));
		table.addCell("");
		table.addCell(new Phrase("Tel. No", fontNormal11));
		table.addCell("");
		table.addCell(new Phrase("DOB", fontNormal11));
		table.addCell("");
		table.addCell(new Phrase("Medicare No", fontNormal11));
		table.addCell("");
		table.addCell(new Phrase("Hospital No", fontNormal11));
		table.addCell("");
		document.add(table);

		/* Referring GP / Consultant / HF matron */
		// symbol
		symbol = Image.getInstance("symbol.png");
		symbol.scalePercent(30, 30);
		symbol.setAbsolutePosition(90, 370);
		document.add(symbol);

		// line
		line = new Paragraph("Referring GP / Consultant / HF matron",
				fontBold13);
		line.setIndentationLeft(indentationLeft);
		line.setSpacingBefore(26);
		document.add(line);

		// Table
		table = new PdfPTable(2); // Code 1
		table.setSpacingBefore(20);
		table.setHorizontalAlignment(Element.ALIGN_RIGHT);
		table.setWidths(new int[] { 10, 25 });
		table.setWidthPercentage(tablePercent); // Code 2
		table.addCell(new Phrase("Name", fontNormal11));
		table.addCell("");
		table.addCell(new Phrase("Address", fontNormal11));
		table.addCell("");
		table.addCell(new Phrase("Tel. No", fontNormal11));
		table.addCell("");
		table.addCell(new Phrase("Fax No", fontNormal11));
		table.addCell("");
		document.add(table);

		/* Patients GP (if not detailed above) */
		// symbol
		symbol = Image.getInstance("symbol.png");
		symbol.scalePercent(30, 30);
		symbol.setAbsolutePosition(90, 240);
		document.add(symbol);

		// line
		line = new Paragraph("Patients GP (if not detailed above)", fontBold13);
		line.setIndentationLeft(indentationLeft);
		line.setSpacingBefore(31);
		document.add(line);

		// Table
		table = new PdfPTable(2); // Code 1
		table.setSpacingBefore(20);
		table.setHorizontalAlignment(Element.ALIGN_RIGHT);
		table.setWidths(new int[] { 10, 25 });
		table.setWidthPercentage(tablePercent); // Code 2
		table.addCell(new Phrase("Name", fontNormal11));
		table.addCell("");
		table.addCell(new Phrase("Address", fontNormal11));
		table.addCell("");
		table.addCell(new Phrase("Tel. No", fontNormal11));
		table.addCell("");
		table.addCell(new Phrase("Fax No", fontNormal11));
		table.addCell("");
		table.addCell(new Phrase("Referral Date", fontNormal11));
		table.addCell("");
		document.add(table);
	}

	public void crt_UK_Pdf(Document document, List<String> listResult)
			throws DocumentException, MalformedURLException, IOException {
		document.newPage();
		// logo header
		Image imgHeader = Image.getInstance("header_pdf.jpg");
		imgHeader.scalePercent(45, 45);
		imgHeader.setAbsolutePosition(94, 780);
		document.add(imgHeader);
		// CRT(-P or -D
		Paragraph line = new Paragraph(
				"CRT is recommended according to NICE technical appraisal guidance 120 (CRT-D if ICD criteria are fulfilled too) because of the following reasons:",
				fontBold11);
		line.setIndentationLeft(indentationLeft);
		line.setSpacingBefore(40);
		line.setSpacingAfter(10);
		document.add(line);

		// list bullet
		ZapfDingbatsList listItem1 = new ZapfDingbatsList(51, 30);
		listItem1.setIndentationLeft(120);
		listItem1.add(new ListItem("NYHA Class III or IV", fontNormal10));
		listItem1.add(new ListItem("ECHO is available and LVEF <= 35%",
				fontNormal10));
		listItem1.add(new ListItem("Optimal Medical Therapy = YES",
				fontNormal10));
		listItem1
				.add(new ListItem(
						"QRS width >=120ms and <150ms and MechancalDyssynchrony at Echo = YES",
						fontNormal10));
		listItem1.add(new ListItem("QRS width >= 150ms", fontNormal10));
		document.add(listItem1);
		// for (int i = 33; i < 200; i++) {
		// ZapfDingbatsList listItem1 = new ZapfDingbatsList(i, 30);
		// listItem1.add(new ListItem("Item " + i));
		// document.add(listItem1);
		// }

		// Cardiac Resynchronisation
		PdfPTable table = new PdfPTable(1);
		table.setSpacingBefore(20);
		table.setWidthPercentage(80);
		table.setHorizontalAlignment(Element.ALIGN_RIGHT);

		Phrase p = new Phrase(
				"Cardiac  Resynchronisation  Therapy  with  a  pacing  device  (CRT-P)  is  recommended  as  a treatment  option  for  people  with  heart  failure  who  fulfill  all  the  following  criteria:  They  are currenty experiencing or have recently experienced NYHA class III and IV symptoms; They are in sinus rhythm, either with a QRS duration of 150ms or longer estimated by standard ECG or with a QRS duration of 120-149ms estimated by ECG and mechanical dyssynchrony that is confirmed by echocardiography; They have a left ventricular ejection fraction of 35% or  less;  They  are  receiving  optimal pharmacological  therapy.  Cardiac  resynchronisation therapy  with  a  defibrillator  device  (CRT-D)  may  be  considered  for  people  who  fulfill  the criteria for implantation of a CRT-P device and who also separately fulfill the criteria for the use of an ICD device as recommended in NICE technology appraisal guidance 95.\n\n",
				fontNormal10);
		PdfPCell cell = new PdfPCell(p);
		cell.setLeading(13f, 0f);
		table.addCell(cell);
		document.add(table);
		// ScreenLink Report

		line = new Paragraph("ScreenLink Report", fontBold12);
		line.setIndentationLeft(indentationLeft);
		line.setSpacingBefore(20);
		document.add(line);

		// Table ScreenLink Report
		table = new PdfPTable(2); // Code 1
		table.setSpacingBefore(20);
		table.setHorizontalAlignment(Element.ALIGN_CENTER);
		table.setWidths(new int[] { 25, 10 });
		table.setWidthPercentage(60); // Code 2
		table.addCell(new Phrase("NYHA Class", fontNormal10));
		table.addCell(xxx);
		table.addCell(new Phrase("Echo Available", fontNormal10));
		table.addCell(xxx);
		table.addCell(new Phrase("LVEF % Last Echo", fontNormal10));
		table.addCell(xxx);
		table.addCell(new Phrase("Prior MI", fontNormal10));
		table.addCell(xxx);
		table.addCell(new Phrase("      4 weeks", fontNormal10));
		table.addCell(xxx);
		table.addCell(new Phrase("Arrhythmias History", fontNormal10));
		table.addCell(xxx);
		table.addCell(new Phrase("Prior Sudden Cardiac Arrest or VF",
				fontNormal10));
		table.addCell(xxx);
		table.addCell(new Phrase("Syncope", fontNormal10));
		table.addCell(xxx);
		table.addCell(new Phrase("QRS Width", fontNormal10));
		table.addCell(xxx);
		table.addCell(new Phrase("Mechanical Dyssynchrony at Echo",
				fontNormal10));
		table.addCell(xxx);
		table.addCell(new Phrase("Optimal Medical Therapy", fontNormal10));
		table.addCell(xxx);
		table.addCell(new Phrase("Familial or congenital heart disease",
				fontNormal10));
		table.addCell(xxx);
		table.addCell(new Phrase("Survival expectation more", fontNormal10));
		table.addCell(xxx);
		document.add(table);

		// symbol
		// symbol.scalePercent(30, 30);
		// symbol.setAbsolutePosition(110, 550);
		// document.add(symbol);

		document.newPage();
		// logo header
		imgHeader = Image.getInstance("header_pdf.jpg");
		imgHeader.scalePercent(45, 45);
		imgHeader.setAbsolutePosition(94, 780);
		document.add(imgHeader);

		// Guidelines results
		line = new Paragraph("Guidelines results:", fontBold12);
		line.setIndentationLeft(indentationLeft);
		line.setSpacingBefore(40);
		document.add(line);
		// CRT Therapy
		line = new Paragraph("CRT Therapy", fontBold13);
		line.setIndentationLeft(110);
		line.setSpacingBefore(10);
		document.add(line);

		// CRT Therapy Table
		table = new PdfPTable(1);
		table.setSpacingBefore(20);
		table.setWidthPercentage(80);
		table.setHorizontalAlignment(Element.ALIGN_RIGHT);
		StringBuilder resultCRTStringBuilder = new StringBuilder();
		if (listResult.contains("CRT1")) {
			resultCRTStringBuilder.append(ResultUKDialogFragment.crt1);
		}
		p = new Phrase(resultCRTStringBuilder.toString(), fontNormal10);
		cell = new PdfPCell(p);
		cell.setLeading(13f, 0f);
		table.addCell(cell);
		document.add(table);
	}

	/**
	 * Create ICD UK PDF
	 * 
	 * @param document
	 * @throws DocumentException
	 * @throws MalformedURLException
	 * @throws IOException
	 */
	public void icd_UK_Pdf(Document document, List<String> listResult)
			throws DocumentException, MalformedURLException, IOException {
		document.newPage();
		// logo header
		Image imgHeader = Image.getInstance("header_pdf.jpg");
		imgHeader.scalePercent(45, 45);
		imgHeader.setAbsolutePosition(94, 780);
		document.add(imgHeader);
		// CRT(-P or -D
		Paragraph line = new Paragraph(
				"ICD is recommended according to NICE Technical appraisal guidance 95 because one (or more) of the following reasons :",
				fontBold11);
		line.setIndentationLeft(indentationLeft);
		line.setSpacingBefore(40);
		line.setSpacingAfter(10);
		document.add(line);

		// list bullet
		ZapfDingbatsList listItem1 = new ZapfDingbatsList(51, 30);
		listItem1.setIndentationLeft(120);
		listItem1.add(new ListItem("Prior Sudden Cardiac Arrest or VF = YES",
				fontNormal10));
		listItem1.add(new ListItem("Arrhythmias History = VF", fontNormal10));
		listItem1.add(new ListItem("NYHA Class I, II or III", fontNormal10));
		listItem1.add(new ListItem(
				"ECHO is available and LVEF Last Echo <= 35%", fontNormal10));
		listItem1.add(new ListItem("Prior Sudden Cardiac Arrest or VF = NO",
				fontNormal10));
		listItem1
				.add(new ListItem(
						"Sustained VT and not VF in Arrhythmias History",
						fontNormal10));
		listItem1.add(new ListItem(
				"Survival expectation more than 1 year = YES", fontNormal10));
		document.add(listItem1);
		// for (int i = 33; i < 200; i++) {
		// ZapfDingbatsList listItem1 = new ZapfDingbatsList(i, 30);
		// listItem1.add(new ListItem("Item " + i));
		// document.add(listItem1);
		// }

		// ScreenLink Report

		line = new Paragraph("ScreenLink Report", fontBold12);
		line.setIndentationLeft(indentationLeft);
		line.setSpacingBefore(20);
		document.add(line);

		// Table ScreenLink Report
		PdfPTable table = new PdfPTable(2); // Code 1
		table.setSpacingBefore(20);
		table.setHorizontalAlignment(Element.ALIGN_CENTER);
		table.setWidths(new int[] { 25, 10 });
		table.setWidthPercentage(60); // Code 2
		table.addCell(new Phrase("NYHA Class", fontNormal10));
		table.addCell(xxx);
		table.addCell(new Phrase("Echo Available", fontNormal10));
		table.addCell(xxx);
		table.addCell(new Phrase("LVEF % Last Echo", fontNormal10));
		table.addCell(xxx);
		table.addCell(new Phrase("Prior MI", fontNormal10));
		table.addCell(xxx);
		table.addCell(new Phrase("      4 weeks", fontNormal10));
		table.addCell(xxx);
		table.addCell(new Phrase("Prior Sudden Cardiac Arrest or VF",
				fontNormal10));
		table.addCell(xxx);
		table.addCell(new Phrase("Syncope", fontNormal10));
		table.addCell(xxx);
		table.addCell(new Phrase("QRS Width", fontNormal10));
		table.addCell(xxx);
		table.addCell(new Phrase("Mechanical Dyssynchrony at Echo",
				fontNormal10));
		table.addCell(xxx);
		table.addCell(new Phrase("Optimal Medical Therapy", fontNormal10));
		table.addCell(xxx);
		table.addCell(new Phrase("Familial or congenital heart disease",
				fontNormal10));
		table.addCell(xxx);
		table.addCell(new Phrase("Survival expectation more", fontNormal10));
		table.addCell(xxx);
		document.add(table);

		// logo header
		imgHeader = Image.getInstance("header_pdf.jpg");
		imgHeader.scalePercent(45, 45);
		imgHeader.setAbsolutePosition(94, 780);
		document.add(imgHeader);

		// Guidelines results
		line = new Paragraph("Guidelines results:", fontBold12);
		line.setIndentationLeft(indentationLeft);
		line.setSpacingBefore(20);
		document.add(line);
		// ICD Therapy
		line = new Paragraph("ICD Therapy", fontBold13);
		line.setIndentationLeft(110);
		line.setSpacingBefore(10);
		document.add(line);

		// ICD Therapy Table
		table = new PdfPTable(1);
		table.setSpacingBefore(20);
		table.setWidthPercentage(80);
		table.setHorizontalAlignment(Element.ALIGN_RIGHT);
		StringBuilder resultCRTStringBuilder = new StringBuilder();
		if (listResult.contains("ICD2")) {
			resultCRTStringBuilder.append(ResultUKDialogFragment.icd2);
		}
		if (listResult.contains("ICD2bis")) {
			resultCRTStringBuilder.append(ResultUKDialogFragment.icd2bis);
		}
		if (listResult.contains("ICD3")) {
			resultCRTStringBuilder.append(ResultUKDialogFragment.icd3);
		}
		if (listResult.contains("ICD4")) {
			resultCRTStringBuilder.append(ResultUKDialogFragment.icd4);
		}
		if (listResult.contains("ICD5")) {
			resultCRTStringBuilder.append(ResultUKDialogFragment.icd5);
		}
		Phrase p = new Phrase(resultCRTStringBuilder.toString(), fontNormal10);
		PdfPCell cell = new PdfPCell(p);
		cell.setLeading(13f, 0f);
		table.addCell(cell);
		document.add(table);
	}

	public void echo_UK_Pdf(Document document, List<String> listResult)
			throws DocumentException, MalformedURLException, IOException {
		// ECHO Therapy
		Paragraph line = new Paragraph("Echo Therapy", fontBold13);
		line.setIndentationLeft(110);
		line.setSpacingBefore(10);
		document.add(line);
		// ECHO Therapy Table
		PdfPTable table = new PdfPTable(1);
		table.setSpacingBefore(20);
		table.setWidthPercentage(80);
		table.setHorizontalAlignment(Element.ALIGN_RIGHT);
		StringBuilder resultCRTStringBuilder = new StringBuilder();
		if (listResult.contains("ECHO6")) {
			resultCRTStringBuilder.append(ResultUKDialogFragment.echo);
		}
		Phrase p = new Phrase(resultCRTStringBuilder.toString(), fontNormal10);
		PdfPCell cell = new PdfPCell(p);
		cell.setLeading(13f, 0f);
		table.addCell(cell);
		document.add(table);
	}

}