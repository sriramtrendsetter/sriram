
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;

import com.itextpdf.text.BaseColor;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Element;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
public class EmpTable {
       public static void main(String[] args) throws DocumentException, IOException {
	  Document document = new Document();
	  BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	  
	  
	  
	  
	  
	  PdfPTable table = new PdfPTable(new float[] { 2, 1, 2 ,2,1});
	  table.getDefaultCell().setHorizontalAlignment(Element.ALIGN_CENTER);
	  table.addCell("EmpName");
          table.addCell("Age");
          table.addCell("Location");
          table.addCell("Mobile Number");
          table.addCell("Empid");
	  table.setHeaderRows(1);
	  PdfPCell[] cells = table.getRow(0).getCells(); 
	  for (int j=0;j<cells.length;j++){
	     cells[j].setBackgroundColor(BaseColor.YELLOW);
	  }
	  String name=null,age=null,location=null,mobile=null,id=null;
          for (int i=1;i<5;i++){
        	  System.out.println("enter name :");
        	  name = br.readLine();
    	     table.addCell(name);
    	     System.out.println("enter age :");
    	     age = br.readLine();
             table.addCell(age);
             System.out.println("enter location :");
             location = br.readLine();
             table.addCell(location);
             System.out.println("enter mobile number :");
             mobile = br.readLine();
             table.addCell(mobile);
             System.out.println("enter employee id :");
             id = br.readLine();
             table.addCell(id);
          }
        try {
	  PdfWriter.getInstance(document, new FileOutputStream("Emp5.pdf"));
	 
        }catch(FileNotFoundException fe) {
        	System.out.println("invalid file name :");
        	System.out.println("file name must already be present");
        	System.out.println("or path does not exist");
        }
	  document.open();
	  document.add(new Paragraph("Employee Details:- \n"));
          document.add(table);
	  document.close();
	  System.out.println("Done");
      }
} //hi
