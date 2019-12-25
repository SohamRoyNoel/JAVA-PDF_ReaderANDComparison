package main;

public class PdfReader {

	public static void main(String[] args) {
		
		String src = "E:\\Jars\\PDFBox\\SourceTEST.pdf";
		String tgt = "E:\\Jars\\PDFBox\\TGTPDF.pdf";
		
		PDFComparison.PDFComparater(src, tgt);

	}

}
