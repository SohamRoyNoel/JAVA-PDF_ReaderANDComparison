package main;

import java.io.File;
import java.util.List;

import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.util.PDFTextStripper;

public class PDFComparison {

	public static void PDFComparater(String srcFile, String tgtFile) {
		try {

			// Get PDFs
			File Src_pdfFile = new File(srcFile);
			File tgt_pdfFile1 = new File(tgtFile);

			// Load PDFs
			PDDocument pdDocument_SRC = PDDocument.load(Src_pdfFile);
			PDDocument pdDocument_TGT = PDDocument.load(tgt_pdfFile1);

			// Get the number of pages
			List allPages_SRC = pdDocument_SRC.getDocumentCatalog().getAllPages();
			List allPages_TGT = pdDocument_TGT.getDocumentCatalog().getAllPages();

			int i =1; int j =1;

			for (i = 1; i <= Math.min(allPages_SRC.size(), allPages_TGT.size()); i++) {
				PDFTextStripper stripper = new PDFTextStripper();
				stripper.setStartPage(i);
				stripper.setEndPage(i);
				String text_SRC = stripper.getText(pdDocument_SRC).replaceAll("visiblespace", " ");
				String text_TGT = stripper.getText(pdDocument_TGT).replaceAll("visiblespace", " ");

				String[] lines_SRC = text_SRC.split("\n");
				String[] lines_TGT = text_TGT.split("\n");

				for (j = 0; j < lines_SRC.length; j++) {
					System.out.println(lines_SRC[j] + System.lineSeparator());
					System.out.println(lines_TGT[j] + System.lineSeparator());
					System.out.println("---------------------------------------------------");
				}
			}

			if(allPages_SRC.size() > allPages_TGT.size()) {
				for (int x = i; x <= allPages_SRC.size(); x++) {
					PDFTextStripper stripper = new PDFTextStripper();
					stripper.setStartPage(x);
					stripper.setEndPage(x);
					String text_SRC = stripper.getText(pdDocument_SRC).replaceAll("visiblespace", " ");

					String[] lines_SRC = text_SRC.split("\n");

					for (int y = j; y < lines_SRC.length; y++) {
						System.out.println(lines_SRC[y] + System.lineSeparator());
						System.out.println("********************************************************");
					}
				}
			} else {
				for (int x = i; x <= allPages_TGT.size(); x++) {
					PDFTextStripper stripper = new PDFTextStripper();
					stripper.setStartPage(x);
					stripper.setEndPage(x);
					String text_TGT = stripper.getText(pdDocument_TGT).replaceAll("visiblespace", " ");

					String[] lines_TGT = text_TGT.split("\n");

					for ( int y = j; y < lines_TGT.length; y++) {
						System.out.println(lines_TGT[y] + System.lineSeparator());
						System.out.println("################################################################");
					}
				}
			}



		} catch(Exception e){
			System.out.print(e);
		}
	}

}
