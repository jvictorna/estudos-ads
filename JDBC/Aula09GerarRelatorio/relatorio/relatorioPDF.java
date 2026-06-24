
package relatorio;

import com.itextpdf.text.Document;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfWriter;
import dao.DAO;
import java.io.FileOutputStream;
import java.util.ArrayList;
import model.JavaBeans;

public class relatorioPDF {

    public void gerarRelatorio() {

        Document documento = new Document();

        try {

            PdfWriter.getInstance(documento,
                    new FileOutputStream("RelatorioContatos.pdf"));

            documento.open();

            documento.add(new Paragraph("RELATORIO DE CONTATOS"));
            documento.add(new Paragraph(" "));
            
            DAO dao = new DAO();

            ArrayList<JavaBeans> contatos = dao.listarContato();

            for (JavaBeans contato : contatos) {

                documento.add(new Paragraph(
                        "ID: " + contato.getId()
                        + " | Nome: " + contato.getNome()
                        + " | Fone: " + contato.getFone()
                        + " | Endereco: " + contato.getEndereco()
                ));
            }

            documento.close();

            System.out.println("Relatório PDF gerado com sucesso!");

        } catch (Exception e) {
            System.out.println(e);
        }
    }
}
