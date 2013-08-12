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

public class CRT_EU {

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
		PdfReader reader = new PdfReader("ScreenLink report_CRT_EU.pdf");
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

		new CRT_EU().createCRT_AUSTRALIA_Pdf(document);

		document.newPage();
		PdfImportedPage page3 = writer.getImportedPage(reader, 3);
		cb.addTemplate(page3, 0, 0);

		// reader.close();
		document.close();
	}

	public void createCRT_AUSTRALIA_Pdf(Document document)
			throws DocumentException, MalformedURLException, IOException {
		Font fontBold12 = FontFactory.getFont("Arial", 12, Font.BOLD);
		Font fontBold10 = FontFactory.getFont("Arial", 10, Font.BOLD);
		Font font10Italic = FontFactory.getFont("Arial", 10, Font.ITALIC);
		Font fontBold14 = FontFactory.getFont("Arial", 14, Font.BOLD);
		Font fontNormal10 = FontFactory.getFont("Arial", 10);
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
				"CRT(-P or -D) is recommended according to ESC guidelines (Class I indication) because of the following reasons",
				fontBold10);
		line.setIndentationLeft(indentationLeft);
		line.setSpacingBefore(80);
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
		listItem1.add(new ListItem("QRS width >=120ms", fontNormal10));
		listItem1
				.add(new ListItem("Atrial Rhythm = Sinus Rhythm", fontNormal10));
		// for (int i = 30; i < 200; i++) {
		// ZapfDingbatsList listItem1 = new ZapfDingbatsList(i, 30);
		// listItem1.add(new ListItem("Item " + i));
		// document.add(listItem1);
		// }
		document.add(listItem1);

		// symbol
		Image symbol = Image.getInstance("symbol.png");
		symbol.scalePercent(30, 30);
		symbol.setAbsolutePosition(110, 750);
		// document.add(symbol);

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
		table.addCell(new Phrase("Etiology of Cardiomyopathy", fontNormal10));
		table.addCell(xxx);
		table.addCell(new Phrase("NYHA Class", fontNormal10));
		table.addCell(xxx);
		table.addCell(new Phrase("Echo Available", fontNormal10));
		table.addCell(xxx);
		table.addCell(new Phrase("LVEF % Last Echo", fontNormal10));
		table.addCell(xxx);
		table.addCell(new Phrase("Prior MI", fontNormal10));
		table.addCell(xxx);
		table.addCell(new Phrase("      40 days", fontNormal10));
		table.addCell(xxx);
		table.addCell(new Phrase("Arrhythmias History", fontNormal10));
		table.addCell(xxx);
		table.addCell(new Phrase("Prior Sudden Cardiac Arrest or VF",
				fontNormal10));
		table.addCell(xxx);
		table.addCell(new Phrase("Syncope", fontNormal10));
		table.addCell(xxx);
		table.addCell(new Phrase("Survival expectation more than 1 year",
				fontNormal10));
		table.addCell(xxx);
		table.addCell(new Phrase("QRS Width", fontNormal10));
		table.addCell(xxx);
		table.addCell(new Phrase("Optimal Medical Therapy", fontNormal10));
		table.addCell(xxx);
		table.addCell(new Phrase("Atrial Rhythm", fontNormal10));
		table.addCell(xxx);
		document.add(table);

		// symbol
		symbol.scalePercent(30, 30);
		symbol.setAbsolutePosition(110, 550);
		// document.add(symbol);

		// Guidelines results
		line = new Paragraph("Guidelines results:", fontBold12);
		line.setIndentationLeft(indentationLeft);
		line.setSpacingBefore(10);
		document.add(line);

		// CRT Therapy
		line = new Paragraph("CRT Therapy", fontBold14);
		line.setIndentationLeft(indentationLeft);
		line.setSpacingBefore(10);
		document.add(line);

		// CRT Therapy Table
		table = new PdfPTable(1);
		table.setSpacingBefore(20);
		table.setWidthPercentage(80);
		table.setHorizontalAlignment(Element.ALIGN_RIGHT);

		Phrase p = new Phrase("xxx", fontNormal10);
		PdfPCell cell = new PdfPCell(p);
		cell.setLeading(13f, 0f);
		table.addCell(cell);
		document.add(table);

	}
}