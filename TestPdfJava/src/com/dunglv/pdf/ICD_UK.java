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

import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Element;
import com.itextpdf.text.Font;
import com.itextpdf.text.Font.FontFamily;
import com.itextpdf.text.FontFactory;
import com.itextpdf.text.Image;
import com.itextpdf.text.ListItem;
import com.itextpdf.text.PageSize;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.Phrase;
import com.itextpdf.text.Rectangle;
import com.itextpdf.text.ZapfDingbatsList;
import com.itextpdf.text.pdf.BaseFont;
import com.itextpdf.text.pdf.PdfContentByte;
import com.itextpdf.text.pdf.PdfImportedPage;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfReader;
import com.itextpdf.text.pdf.PdfWriter;

public class ICD_UK {

	/** A resulting PDF file. */
	public static final String OUTPUT = "output.pdf";

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
		PdfReader reader = new PdfReader("ScreenLink report_ICD_UK.pdf");
		Document document = new Document(PageSize.A4, 0, 45, 0, 0);
		PdfWriter writer = PdfWriter.getInstance(document,
				new FileOutputStream(OUTPUT));
		document.open();

		PdfContentByte cb = writer.getDirectContent();

		// add footer
		HeaderFooter event = new HeaderFooter();
		writer.setBoxSize("art", new Rectangle(36, 54, 559, 788));
		writer.setPageEvent(event);

		// import page
		PdfImportedPage page1 = writer.getImportedPage(reader, 1);
		// Copy first page of existing PDF into output PDF
		cb.addTemplate(page1, 0, 0);

		new ICD_UK().createCRT_UK_Pdf(document);

		document.newPage();
		PdfImportedPage page3 = writer.getImportedPage(reader, 3);
		cb.addTemplate(page3, 0, 0);

		// reader.close();
		document.close();
	}

	public void createCRT_UK_Pdf(Document document) throws DocumentException,
			MalformedURLException, IOException {
		Font fontBold12 = FontFactory.getFont("Arial", 12, Font.BOLD);
		Font fontBold10 = FontFactory.getFont("Arial", 10, Font.BOLD);
		Font fontBold9 = FontFactory.getFont("Arial", 9, Font.BOLD);
		Font fontNormal10 = FontFactory.getFont("Arial", 10);
		Font fontBold13 = FontFactory.getFont("Arial", 13, Font.BOLD);
		int indentationLeft = 110;
		String xxx = "xxxxxxx";

		document.newPage();
		// logo header
		Image imgHeader = Image.getInstance("header_pdf.jpg");
		imgHeader.scalePercent(45, 45);
		imgHeader.setAbsolutePosition(94, 780);
		document.add(imgHeader);
		// CRT(-P or -D
		Paragraph line = new Paragraph(
				"ICD is recommended according to NICE Technical appraisal guidance 95 because one (or more) of the following reasons :",
				fontBold10);
		line.setIndentationLeft(indentationLeft);
		line.setSpacingBefore(80);
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

		// symbol
		// symbol.scalePercent(30, 30);
		// symbol.setAbsolutePosition(110, 550);
		// document.add(symbol);

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
		table.addCell(new Phrase("xxx", fontNormal10));
		document.add(table);
		/*
		 * // SOURCE OF REFERRAL line = new Paragraph("SOURCE OF REFERRAL",
		 * fontBold13); line.setIndentationLeft(indentationLeft);
		 * line.setSpacingBefore(10); document.add(line);
		 * 
		 * // please tick line = new Paragraph("(please tick one)",
		 * fontNormal10); line.setIndentationLeft(indentationLeft);
		 * line.setSpacingBefore(10); document.add(line); // List 2
		 * ZapfDingbatsList listItem2 = new ZapfDingbatsList(111, 30);
		 * listItem2.setIndentationLeft(120); listItem2.add(new
		 * ListItem("Patient self presenting with symptoms", fontNormal10));
		 * listItem2.add(new ListItem("Recent hospital admission",
		 * fontNormal10)); listItem2 .add(new ListItem(
		 * "Routine 'NYHA score' in chronic disease clinic", fontNormal10));
		 * listItem2.add(new ListItem("Other (please specify) …………………………………….",
		 * fontNormal10)); document.add(listItem2);
		 * 
		 * // BRIEF PRESENTING HISTORY: line = new
		 * Paragraph("BRIEF PRESENTING HISTORY:", fontBold9);
		 * line.setIndentationLeft(indentationLeft); line.setSpacingBefore(30);
		 * document.add(line);
		 * 
		 * // (SOBAR, SOBOE, orthopnea, PND etc): line = new
		 * Paragraph("(SOBAR, SOBOE, orthopnea, PND etc)", fontNormal10);
		 * line.setIndentationLeft(indentationLeft); document.add(line);
		 * 
		 * // SELF ASSESSED NYHA SCORE CLASS:
		 * 
		 * line = new Paragraph(
		 * "SELF ASSESSED NYHA SCORE CLASS:        □i        □ii        □iii",
		 * fontBold9); line.setIndentationLeft(indentationLeft);
		 * line.setSpacingBefore(30); document.add(line);
		 * 
		 * // CLINICAL FINDINGS: line = new Paragraph("CLINICAL FINDINGS:",
		 * fontBold9); line.setIndentationLeft(indentationLeft);
		 * line.setSpacingBefore(30); document.add(line); // Peripheral
		 * /pulmonary oedema, murmur etc line = new
		 * Paragraph("(Peripheral /pulmonary oedema, murmur etc)",
		 * fontNormal10); line.setIndentationLeft(indentationLeft);
		 * document.add(line); // BP: line = new Paragraph("BP:", fontNormal10);
		 * line.setSpacingBefore(15); line.setIndentationLeft(indentationLeft);
		 * document.add(line); // ..... line = new Paragraph(
		 * "................................................................................................................................"
		 * , fontNormal10); line.setSpacingBefore(15);
		 * line.setIndentationLeft(indentationLeft); document.add(line);
		 * 
		 * document.newPage(); // logo header imgHeader =
		 * Image.getInstance("header_pdf.jpg"); imgHeader.scalePercent(45, 45);
		 * imgHeader.setAbsolutePosition(94, 780); document.add(imgHeader);
		 * 
		 * // MEDICATION : line = new Paragraph("MEDICATION :", fontBold9);
		 * line.setIndentationLeft(indentationLeft); line.setSpacingBefore(80);
		 * document.add(line); // (please tick if applicable) line = new
		 * Paragraph("(please tick if applicable)", fontNormal10);
		 * line.setIndentationLeft(indentationLeft); line.setSpacingAfter(15);
		 * document.add(line);
		 * 
		 * // List 2 listItem2 = new ZapfDingbatsList(111, 20);
		 * listItem2.setIndentationLeft(110); listItem2.add(new
		 * ListItem("PMH\n\n", fontNormal10)); listItem2 .add(new ListItem(
		 * "IHD \nDate of prev MI (if app.) ........................................................................................\n\n"
		 * , fontNormal10)); listItem2 .add(new ListItem(
		 * "HBP\nDate first diagnosed ..............................................................................................\n\n"
		 * , fontNormal10)); listItem2 .add(new ListItem(
		 * "Atrial fibrillation\nDate last known SR .............................................................................................\n\n"
		 * , fontNormal10)); listItem2.add(new
		 * ListItem("Known COAD/ asthma\n\n", fontNormal10)); listItem2 .add(new
		 * ListItem(
		 * "PFT? ....................................................................................................................\n\nDate ECG 1st reported broad QRS……………………………………………………\n\n"
		 * , fontNormal10)); listItem2.add(new
		 * ListItem("Date LV dysfunction confirmed\n\n", fontNormal10));
		 * listItem2.add(new ListItem("Hospital admission in last 12 month\n\n",
		 * fontNormal10)); document.add(listItem2);
		 */

	}
}