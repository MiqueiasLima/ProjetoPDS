/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import dao.DaoDesempenho;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author jose
 */

/*  
   
Relatório jogador vai ter nome do jogadores e seus desempenho na partida.
 */
public class RelatorioJogador extends Relatorio {

    private Partida partida;

    public RelatorioJogador(Time time, Partida partida) {

        super.setTime(time);
        this.partida = partida;

    }

    @Override
    public Document corpo(Document documento) {
        ArrayList<Desempenho> lista;
        PdfPTable tabelaPasses = new PdfPTable(4);
        DaoDesempenho dao = new DaoDesempenho();
        Paragraph p10 = new Paragraph("Nome Time:" + super.getTime().getNome());
        Paragraph p1 = new Paragraph("Local:" + partida.getLocalDaPartida());

        Paragraph p2 = new Paragraph("Time Casa:" + partida.getTimeCasa());
        Paragraph p3 = new Paragraph("Time Fora:" + partida.getTimeFora());
        Paragraph p4 = new Paragraph("Data:" + partida.getData());

        Paragraph p5 = new Paragraph("Tipo de competição:" + partida.getTipoDeJogo());
        Paragraph p6 = new Paragraph("Hora:" + partida.getHorario());
        Paragraph p8 = new Paragraph("Resultado:" + partida.getResultado());

        Paragraph p = new Paragraph("Passes");

        try {
            Paragraph p7 = new Paragraph("          ");
            documento.add(p10);
            documento.add(p7);
            documento.add(p1);
            documento.add(p2);
            documento.add(p3);
            documento.add(p4);
            documento.add(p5);
            documento.add(p6);
            documento.add(p8);
            p.setAlignment(1);
            documento.add(p);
            p = new Paragraph("   ");

            documento.add(p);

            PdfPCell cel = new PdfPCell(new Paragraph("Nome"));
            PdfPCell cel1 = new PdfPCell(new Paragraph("Passes certos"));
            PdfPCell cel2 = new PdfPCell(new Paragraph("Passes errados"));
            PdfPCell cel3 = new PdfPCell(new Paragraph("Passes totais"));

            tabelaPasses.addCell(cel);
            tabelaPasses.addCell(cel1);
            tabelaPasses.addCell(cel2);
            tabelaPasses.addCell(cel3);

            lista = (ArrayList) dao.relatorioPasse(super.getTime(), partida);
            int total;
            for (int i = 0; i < lista.size(); i++) {

                cel = new PdfPCell(new Paragraph(lista.get(i).getJogador().getNome()));
                cel1 = new PdfPCell(new Paragraph(lista.get(i).getPassesCertos() + ""));
                cel2 = new PdfPCell(new Paragraph(lista.get(i).getPassesErrados() + ""));
                total = lista.get(i).getPassesCertos() + lista.get(i).getPassesErrados();
                cel3 = new PdfPCell(new Paragraph(total + ""));

                tabelaPasses.addCell(cel);
                tabelaPasses.addCell(cel1);
                tabelaPasses.addCell(cel2);
                tabelaPasses.addCell(cel3);

            }

            documento.add(tabelaPasses);

            p = new Paragraph("       ");
            documento.add(p);

            p = new Paragraph("Domínio");
            p.setAlignment(1);
            documento.add(p);

            p = new Paragraph("       ");

            documento.add(p);

            PdfPTable tabelaDominio = new PdfPTable(4);

            cel = new PdfPCell(new Paragraph("Nome"));
            cel1 = new PdfPCell(new Paragraph("Dominio Certo"));
            cel2 = new PdfPCell(new Paragraph("Dominio Errado"));
            cel3 = new PdfPCell(new Paragraph("Dominio Total"));

            tabelaDominio.addCell(cel);
            tabelaDominio.addCell(cel1);
            tabelaDominio.addCell(cel2);
            tabelaDominio.addCell(cel3);

            lista = (ArrayList<Desempenho>) dao.relatorioDominio(super.getTime(), partida);

            for (int i = 0; i < lista.size(); i++) {

                cel = new PdfPCell(new Paragraph(lista.get(i).getJogador().getNome()));
                cel1 = new PdfPCell(new Paragraph(lista.get(i).getDominioCerto() + ""));
                cel2 = new PdfPCell(new Paragraph(lista.get(i).getDominioErrado() + ""));

                cel3 = new PdfPCell(new Paragraph(lista.get(i).getDominioTotal() + ""));

                tabelaDominio.addCell(cel);
                tabelaDominio.addCell(cel1);
                tabelaDominio.addCell(cel2);
                tabelaDominio.addCell(cel3);

            }

            documento.add(tabelaDominio);
            p = new Paragraph("       ");

            documento.add(p);

            p = new Paragraph("Finalizações");
            p.setAlignment(1);

            documento.add(p);
            p = new Paragraph("      ");
            documento.add(p);

            PdfPTable tabelaFinalizacao = new PdfPTable(7);
            PdfPCell cel4;
            PdfPCell cel5;
            PdfPCell cel6;

            cel = new PdfPCell(new Paragraph("Nome"));
            cel1 = new PdfPCell(new Paragraph("Drible"));
            cel2 = new PdfPCell(new Paragraph("Assistência"));
            cel3 = new PdfPCell(new Paragraph("Desarme"));
            cel4 = new PdfPCell(new Paragraph("Gol"));
            cel5 = new PdfPCell(new Paragraph("Finaliza Gols"));
            cel6 = new PdfPCell(new Paragraph("Finaliza totais"));

            tabelaFinalizacao.addCell(cel);
            tabelaFinalizacao.addCell(cel1);
            tabelaFinalizacao.addCell(cel2);
            tabelaFinalizacao.addCell(cel3);
            tabelaFinalizacao.addCell(cel4);
            tabelaFinalizacao.addCell(cel5);
            tabelaFinalizacao.addCell(cel6);

            lista = (ArrayList<Desempenho>) dao.relatorioFinalizacao(super.getTime(), partida);
            //nome      | drible | assistencia | desarme | gol  | finalizacoesGols | finalizacoesTotais |
            for (int i = 0; i < lista.size(); i++) {

                cel = new PdfPCell(new Paragraph(lista.get(i).getJogador().getNome()));
                cel1 = new PdfPCell(new Paragraph(lista.get(i).getDrible() + ""));
                cel2 = new PdfPCell(new Paragraph(lista.get(i).getAssistencia() + ""));
                cel3 = new PdfPCell(new Paragraph(lista.get(i).getDesarme() + ""));
                cel4 = new PdfPCell(new Paragraph(lista.get(i).getGol() + ""));
                cel5 = new PdfPCell(new Paragraph(lista.get(i).getFinalizacoesGols() + ""));
                cel6 = new PdfPCell(new Paragraph(lista.get(i).getFinalizacoesTotais() + ""));

                tabelaFinalizacao.addCell(cel);
                tabelaFinalizacao.addCell(cel1);
                tabelaFinalizacao.addCell(cel2);
                tabelaFinalizacao.addCell(cel3);
                tabelaFinalizacao.addCell(cel4);
                tabelaFinalizacao.addCell(cel5);
                tabelaFinalizacao.addCell(cel6);

            }

            documento.add(tabelaFinalizacao);
            p = new Paragraph("   ");
            documento.add(p);

        } catch (DocumentException ex) {
            Logger.getLogger(RelatorioJogador.class.getName()).log(Level.SEVERE, null, ex);
        }

        return documento;
    }

    @Override
    public Document rodaPe(Document documento) {

        Paragraph p = new Paragraph("D.T-Relatório Jogador");
        try {
            p.setAlignment(1);
            documento.add(p);
        } catch (DocumentException ex) {
            Logger.getLogger(RelatorioJogador.class.getName()).log(Level.SEVERE, null, ex);
        }

        return documento;
    }

}
