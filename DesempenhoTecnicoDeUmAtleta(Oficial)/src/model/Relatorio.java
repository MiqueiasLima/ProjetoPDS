
package model;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfWriter;
import java.awt.Desktop;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author jose
 */
public abstract class  Relatorio {
    
    private Time time;
    
    
    public final void templateMethod(){
        
        Document doc = new Document ();
         try {
             
        PdfWriter.getInstance(doc, new FileOutputStream ("relatorio.pdf"));
        
        doc.open();
        
        Paragraph p = new Paragraph("Relatório");
        p.setAlignment(1);
        doc.add(p);
        
         p = new Paragraph("       ");
        doc.add(p);
        
       doc= this.corpo(doc);
        doc=this.rodaPe(doc);
        doc.close();
        
       
            Desktop.getDesktop().open(new File("relatorio.pdf"));
            
        } catch (IOException | DocumentException ex) {
            
            Logger.getLogger(Relatorio.class.getName()).log(Level.SEVERE, null, ex);
        }
        
         
        
    }
    
    public abstract Document corpo(Document documento);
    
    public abstract Document rodaPe(Document documento);
    
    
    
    

    
    public Time getTime() {
        return time;
    }

    public void setTime(Time time) {
        this.time = time;
    }

   
    
    
}
