package com.example.testpdfandroid;

import java.io.ByteArrayOutputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;

import android.content.Context;
import android.content.res.AssetManager;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.util.Log;

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
import com.itextpdf.text.ZapfDingbatsList;
import com.itextpdf.text.pdf.PdfContentByte;
import com.itextpdf.text.pdf.PdfImportedPage;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfReader;
import com.itextpdf.text.pdf.PdfWriter;

public class CRT_AUSTRALIA_Pdf {
	private PdfReader reader;

	// private PdfContentByte cb;
	// private PdfWriter writer;

	public CRT_AUSTRALIA_Pdf(Context context, String path) {
		// TODO Auto-generated constructor stub
		AssetManager assetManager = context.getAssets();
		InputStream istr = null;

		String str = null;
		try {
			istr = (InputStream) assetManager.open("test.pdf");
			reader = new PdfReader(istr);
			str = reader.getNumberOfPages() + "";
			Log.e("aa", str);
		} catch (Exception e) {
			e.printStackTrace();
		}
		Document document = new Document(PageSize.A4, 0, 45, 0, 0);
		try {
			PdfWriter writer = PdfWriter.getInstance(document,
					new FileOutputStream(path));
			document.open();

			// import page 1
			PdfContentByte cb = writer.getDirectContent();
			PdfImportedPage page1 = writer.getImportedPage(reader, 1);
			cb.addTemplate(page1, 0, 0);
			// create own page
			createCRT_AUSTRALIA_Pdf(context, document);

			// import page 3
			document.newPage();
			PdfImportedPage page3 = writer.getImportedPage(reader, 3);
			cb.addTemplate(page3, 0, 0);

			document.close();
			reader.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (DocumentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void createCRT_AUSTRALIA_Pdf(Context context, Document document)
			throws DocumentException, MalformedURLException, IOException {
		Font fontBold12 = FontFactory.getFont("Arial", 12, Font.BOLD);
		Font fontBold11 = FontFactory.getFont("Arial", 11, Font.BOLD);
		Font font10Italic = FontFactory.getFont("Arial", 10, Font.ITALIC);
		Font fontBold14 = FontFactory.getFont("Arial", 14, Font.BOLD);
		Font fontNormal11 = FontFactory.getFont("Arial", 11);
		Font fontNormal10 = FontFactory.getFont("Arial", 10);
		int indentationLeft = 110;
		String xxx = "xxxxxxx";

		document.newPage();
		// logo header
		// Image imgHeader = Image.getInstance("header_pdf.jpg");
		Image imgHeader = createImageFromResource(context,
				R.drawable.header_pdf);
		imgHeader.scalePercent(45, 45);
		imgHeader.setAbsolutePosition(94, 780);
		document.add(imgHeader);
		// CRT(-P or -D
		Paragraph line = new Paragraph(
				"CRT(-P or -D) is recommended according to ESC guidelines (Class I indication) because of the following reasons",
				fontBold11);
		line.setIndentationLeft(indentationLeft);
		line.setSpacingBefore(80);
		line.setSpacingAfter(10);
		document.add(line);

		// list bullet
		ZapfDingbatsList listItem1 = new ZapfDingbatsList(51, 30);
		listItem1.setIndentationLeft(120);
		listItem1.add(new ListItem(xxx, fontNormal11));
		listItem1.add(new ListItem(xxx, fontNormal11));
		listItem1.add(new ListItem(xxx, fontNormal11));
		listItem1.add(new ListItem(xxx, fontNormal11));
		listItem1.add(new ListItem(xxx, fontNormal11));
		// for (int i = 30; i < 200; i++) {
		// ZapfDingbatsList listItem1 = new ZapfDingbatsList(i, 30);
		// listItem1.add(new ListItem("Item " + i));
		// document.add(listItem1);
		// }
		document.add(listItem1);

		// symbol
		Image symbol = createImageFromResource(context, R.drawable.symbol);
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
		table.addCell(new Phrase("Etiology of Cardiomyopathy", fontNormal11));
		table.addCell(xxx);
		table.addCell(new Phrase("NYHA Class", fontNormal11));
		table.addCell(xxx);
		table.addCell(new Phrase("Echo Available", fontNormal11));
		table.addCell(xxx);
		table.addCell(new Phrase("LVEF % Last Echo", fontNormal11));
		table.addCell(xxx);
		table.addCell(new Phrase("Prior MI", fontNormal11));
		table.addCell(xxx);
		table.addCell(new Phrase("      40 days", fontNormal11));
		table.addCell(xxx);
		table.addCell(new Phrase("Arrhythmias History", fontNormal11));
		table.addCell(xxx);
		table.addCell(new Phrase("Prior Sudden Cardiac Arrest or VF",
				fontNormal11));
		table.addCell(xxx);
		table.addCell(new Phrase("Syncope", fontNormal11));
		table.addCell(xxx);
		table.addCell(new Phrase("Survival expectation more than 1 year",
				fontNormal11));
		table.addCell(xxx);
		table.addCell(new Phrase("QRS Width", fontNormal11));
		table.addCell(xxx);
		table.addCell(new Phrase("Optimal Medical Therapy", fontNormal11));
		table.addCell(xxx);
		table.addCell(new Phrase("Atrial Rhythm", fontNormal11));
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

		Phrase p = new Phrase(
				"CRT(-P or -D) is recommended according to ESC guidelines (Class I indication).\n\nCRT-P is recommended to reduce morbidity and mortality in patients in NYHA III andIV class who are symptomatic despite optimal medical therapy, and who have a reduced EF (LVEF<="
						+ xxx
						+ "%) and QRS prolongation  (QRS  width  =>"
						+ xxx
						+ "  ms):  CLASS  IA.  CRT  with  defibrillator  function  (CRT-D)  is recommended to reduce morbidity and mortality in patients in NYHA III‚IV class who are symptomatic despite optimal medical therapy, and who have a reduced EF (LVEF<="
						+ xxx
						+ "%) and QRS prolongation (QRS  width  =>"
						+ xxx
						+ "  ms):  CLASS  IA.  The  survival  advantage  of  CRT-D  vs.  CRT-P  has  not  been adequately  addressed.  Due  to  the  documented  effectiveness  of  ICD  therapy  in  the  prevention  of sudden cardiac death, the use of a CRT-D device is commonly preferred in clinical practice in patients satisfying  CRT  criteria  including  an  expectation  of  survival  with  good  functional  status  for  >1  year. (European Heart Journal 2008 29(19):2388-2442. European Heart Journal (2010) 31, 2677‚  2687, doi:10.1093/eurheartj/ehq337\n\n",
				fontNormal10);
		PdfPCell cell = new PdfPCell(p);
		cell.setLeading(13f, 0f);
		table.addCell(cell);
		document.add(table);

		// Evaluated by ScreenLinkTool
		line = new Paragraph("Evaluated by ScreenLinkTool", font10Italic);
		// line.setIndentationLeft(110);
		line.setAlignment(Element.ALIGN_CENTER);
		line.setSpacingBefore(10);
		document.add(line);
	}

	public Image createImageFromResource(Context context, int resource) {
		try {
			InputStream is = context.getResources().openRawResource(resource);
			Bitmap bmp = BitmapFactory.decodeStream(is);
			ByteArrayOutputStream stream = new ByteArrayOutputStream();
			bmp.compress(Bitmap.CompressFormat.PNG, 100, stream);
			Image img = Image.getInstance(stream.toByteArray());
			return img;
		} catch (Exception e) {
			return null;
		}
	}
}
