package relatorio;

import com.itextpdf.text.Document;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfWriter;
import dao.DAO;
import java.io.FileOutputStream;
import java.util.ArrayList;
import model.QuartoBean;

public class RelatorioPDF {
    
   public void gerarRelatorioGerencial(ArrayList<QuartoBean> quartos) {
        Document documento = new Document();
        try {
            PdfWriter.getInstance(documento,
                    new FileOutputStream("RelatorioHGS.pdf"));
            documento.open();

            documento.add(new Paragraph("HOTEL GOVERNANCE SYSTEM"));
            documento.add(new Paragraph("RELATÓRIO GERENCIAL DE QUARTOS"));
            documento.add(new Paragraph(" "));

            for (QuartoBean quarto : quartos) {
                documento.add(new Paragraph(
                        "Quarto " + quarto.getNumero()
                        + " | Andar: " + quarto.getAndar()
                        + " | Status: " + quarto.getStatusDescricao()
                        + " | Tipo: " + quarto.getTipoDescricao()
                        + " | Modelo: " + quarto.getModeloDescricao()
                ));
            }

            documento.close();
            System.out.println("Relatório PDF gerado com sucesso!");

        } catch (Exception e) {
            System.out.println(e);
        }
    }
}