package com.dunglv.pdf;
import com.itextpdf.text.Document;
import com.itextpdf.text.Element;
import com.itextpdf.text.Font;
import com.itextpdf.text.FontFactory;
import com.itextpdf.text.Phrase;
import com.itextpdf.text.pdf.ColumnText;
import com.itextpdf.text.pdf.PdfPageEventHelper;
import com.itextpdf.text.pdf.PdfWriter;

public class HeaderFooter extends PdfPageEventHelper {
	@Override
	public void onEndPage(PdfWriter writer, Document document) {
		Font font10Italic = FontFactory.getFont("Arial", 10, Font.ITALIC);
		ColumnText.showTextAligned(writer.getDirectContent(),
				Element.ALIGN_CENTER, new Phrase("Evaluated by ScreenLinkTool",
						font10Italic), 300f, 62f, 0);
	}
}