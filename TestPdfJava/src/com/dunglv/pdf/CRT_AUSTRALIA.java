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

public class CRT_AUSTRALIA {

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
		PdfReader reader = new PdfReader("ScreenLink report_CRT_AUSTRALIA.pdf");
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

		new CRT_AUSTRALIA().createCRT_AUSTRALIA_Pdf(document);

		document.newPage();
		PdfImportedPage page3 = writer.getImportedPage(reader, 3);
		cb.addTemplate(page3, 0, 0);

		// reader.close();
		document.close();
	}

	public void createCRT_AUSTRALIA_Pdf(Document document)
			throws DocumentException, MalformedURLException, IOException {
		Font fontBold12 = FontFactory.getFont("Arial", 12, Font.BOLD);
		Font font10Italic = FontFactory.getFont("Arial", 10, Font.ITALIC);
		Font fontBold13 = FontFactory.getFont("Arial", 13, Font.BOLD);
		Font fontNormal9 = FontFactory.getFont("Arial", 9);

		document.newPage();
		// logo header
		Image imgHeader = Image.getInstance("header_pdf.jpg");
		imgHeader.scalePercent(45, 45);
		imgHeader.setAbsolutePosition(94, 780);
		document.add(imgHeader);

		// symbol
		Image symbol = Image.getInstance("symbol.png");
		symbol.scalePercent(30, 30);
		symbol.setAbsolutePosition(110, 750);
		document.add(symbol);

		// ScreenLink Report

		Paragraph line = new Paragraph("ScreenLink Report", fontBold12);
		line.setIndentationLeft(130);
		line.setSpacingBefore(70);
		document.add(line);

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

		// symbol
		symbol.scalePercent(30, 30);
		symbol.setAbsolutePosition(110, 560);
		document.add(symbol);

		// Guidelines results
		line = new Paragraph("Guidelines results:", fontBold12);
		line.setIndentationLeft(130);
		line.setSpacingBefore(10);
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
		table.addCell(new Phrase(
				"CRT (with or without ICD) is recommended according to NHF/CSANZ Guidelines for the prevention, detection and management of chronic heart failure in Australia, updated October 2011 (Grade of recommendation A):\n\nBiventricular pacing (cardiac resynchronisation therapy, with or without ICD) should be considered in patients with CHF who fulfill each of the following criteria:\n\n     -NYHA symptoms Class III/IV on treatmen\n\n     -Dilated heart failure with LVEF <= 35%\n\n     -QRS duration >= 120 ms\n\n     -Sinus rhythm\n\n",
				fontNormal9));
		document.add(table);

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
		table.addCell(new Phrase(
				"ICD is recommended according to NHF/CSANZ Guidelines for the prevention, detection and management of chronic heart failure in Australia, updated October 2011 (Grade of recommendation A):\n\nICD implantation should be considered in patients with CHF who fulfill any of the following criteria:\n\n       -Survived cardiac arrest resulting from ventricular fibrillation or ventricular tachycardia not due to a transient or reversible cause\n\n       -Spontaneous sustained ventricular tachycardia in association with structural CHD\n\n       -LVEF <= 30% measured at least 1 month after acute MI, or 3 months after coronary artery revascularisation surgery\n\n       -Symptomatic CHF (i.e. NYHA functional class II/III) and LVEF <= 35%\n\n",
				fontNormal9));
		document.add(table);
	}
}