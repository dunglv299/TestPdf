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
import com.itextpdf.text.PageSize;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.Phrase;
import com.itextpdf.text.Rectangle;
import com.itextpdf.text.pdf.PdfContentByte;
import com.itextpdf.text.pdf.PdfImportedPage;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfReader;
import com.itextpdf.text.pdf.PdfWriter;

public class ICD_AUSTRALIA {

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
		PdfReader reader = new PdfReader("ScreenLink report_ICD_AUSTRALIA.pdf");
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

		new ICD_AUSTRALIA().createICD_AUSTRALIA_Pdf(document);

		// reader.close();
		document.close();
	}

	public void createICD_AUSTRALIA_Pdf(Document document)
			throws DocumentException, MalformedURLException, IOException {
		Font fontBold12 = FontFactory.getFont("Arial", 12, Font.BOLD);
		Font fontBold13 = FontFactory.getFont("Arial", 13, Font.BOLD);
		Font fontNormal9 = FontFactory.getFont("Arial", 9);
		int indentationLeft = 110;

		document.newPage();
		// logo header
		Image imgHeader = Image.getInstance("header_pdf.jpg");
		imgHeader.scalePercent(45, 45);
		imgHeader.setAbsolutePosition(94, 780);
		document.add(imgHeader);

		// ScreenLink Report

		Paragraph line = new Paragraph("ScreenLink Report", fontBold12);
		line.setIndentationLeft(indentationLeft);
		line.setSpacingBefore(70);
		document.add(line);
		// symbol
		Image symbol = Image.getInstance("symbol.png");
		symbol.scalePercent(30, 30);
		symbol.setAbsolutePosition(indentationLeft - 20, 750);
		// symbol.setSpacingBefore(-10);
		// symbol.setIndentationLeft(indentationLeft);
		// document.add(symbol);

		// Table ScreenLink Report
		PdfPTable table = new PdfPTable(2); // Code 1
		table.setSpacingBefore(20);
		table.setWidths(new int[] { 6, 1 });
		table.setWidthPercentage(60); // Code 2
		table.addCell(new Phrase("NYHA Class", fontNormal9));
		table.addCell("xxx");
		table.addCell(new Phrase("Echo Available", fontNormal9));
		table.addCell("xxx");
		table.addCell(new Phrase("LVEF % Last Echo", fontNormal9));
		table.addCell("xxx");
		table.addCell(new Phrase("Prior MI", fontNormal9));
		table.addCell("xxx");
		table.addCell(new Phrase("Prior Sudden Cardiac Arrest or VF",
				fontNormal9));
		table.addCell("xxx");
		table.addCell(new Phrase("QRS Width", fontNormal9));
		table.addCell("xxx");
		table.addCell(new Phrase("Optimal Medical Therapy", fontNormal9));
		table.addCell("xxx");
		table.addCell(new Phrase("Sinus Rhythm", fontNormal9));
		table.addCell("xxx");
		table.addCell(new Phrase(
				"Spontaneous sustained VT in association with structural CHD",
				fontNormal9));
		table.addCell("xxx");
		document.add(table);

		// Guidelines results
		line = new Paragraph("Guidelines results:", fontBold12);
		line.setIndentationLeft(indentationLeft);
		line.setSpacingBefore(10);
		document.add(line);

		// ICD Therapy
		line = new Paragraph("ICD Therapy", fontBold13);
		line.setIndentationLeft(indentationLeft);
		line.setSpacingBefore(10);
		document.add(line);

		// ICD Therapy Table
		table = new PdfPTable(1);
		table.setSpacingBefore(20);
		table.setWidthPercentage(80);
		table.setHorizontalAlignment(Element.ALIGN_RIGHT);
		table.addCell(new Phrase("xxxx\n\n", fontNormal9));
		document.add(table);

		// Other relevant information :
		line = new Paragraph("Other relevant information :", fontBold12);
		line.setIndentationLeft(indentationLeft);
		line.setSpacingBefore(10);
		document.add(line);
		// (insert any other relevant information here)
		line = new Paragraph("(insert any other relevant information here)",
				fontNormal9);
		line.setIndentationLeft(indentationLeft);
		document.add(line);
	}
}