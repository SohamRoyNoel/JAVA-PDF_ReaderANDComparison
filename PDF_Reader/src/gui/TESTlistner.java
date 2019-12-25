package gui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import main.PDFComparison;

public class TESTlistner implements ActionListener {

	public void actionPerformed(ActionEvent e) {
        String command = e.getActionCommand();  
        
        if( command.equals("Execute"))  {
        	String src = "E:\\Jars\\PDFBox\\SourceTEST.pdf";
    		String tgt = "E:\\Jars\\PDFBox\\TGTPDF.pdf";
    		
    		PDFComparison.PDFComparater(src, tgt);
        }  	
     }
	
}
