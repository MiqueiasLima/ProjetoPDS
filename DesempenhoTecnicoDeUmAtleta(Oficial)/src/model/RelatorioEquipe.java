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
public class RelatorioEquipe extends Relatorio {

    private Partida partida;

    public RelatorioEquipe(Time time, Partida partida) {

        super.setTime(time);
        this.partida = partida;
    }

    @Override
    public Document corpo(Document documento) {

        ArrayList<Desempenho> lista;
        PdfPTable tabelaPasses = new PdfPTable(3);
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

            PdfPCell cel1 = new PdfPCell(new Paragraph("Passes certos"));
            PdfPCell cel2 = new PdfPCell(new Paragraph("Passes errados"));
            PdfPCell cel3 = new PdfPCell(new Paragraph("Passes totais"));

            tabelaPasses.addCell(cel1);
            tabelaPasses.addCell(cel2);
            tabelaPasses.addCell(cel3);

            lista = (ArrayList) dao.relatorioPasse(super.getTime(), partida);
            int passesCertos = 0, passesErrados = 0, passesTotais;
            for (int i = 0; i < lista.size(); i++) {
                passesCertos = passesCertos + lista.get(i).getPassesCertos();
                passesErrados = passesErrados + lista.get(i).getPassesErrados();

            }
            passesTotais = passesErrados + passesCertos;
            cel1 = new PdfPCell(new Paragraph(passesCertos + ""));
            cel2 = new PdfPCell(new Paragraph(passesErrados + ""));
            cel3 = new PdfPCell(new Paragraph(passesTotais + ""));

            tabelaPasses.addCell(cel1);
            tabelaPasses.addCell(cel2);
            tabelaPasses.addCell(cel3);
            documento.add(tabelaPasses);

            p = new Paragraph("       ");
            documento.add(p);

            p = new Paragraph("Domínio");
            p.setAlignment(1);
            documento.add(p);

            p = new Paragraph("       ");

            documento.add(p);

            PdfPTable tabelaDominio = new PdfPTable(3);

            cel1 = new PdfPCell(new Paragraph("Dominio Certo"));
            cel2 = new PdfPCell(new Paragraph("Dominio Errado"));
            cel3 = new PdfPCell(new Paragraph("Dominio Total"));

            tabelaDominio.addCell(cel1);
            tabelaDominio.addCell(cel2);
            tabelaDominio.addCell(cel3);
            int dominioCerto = 0, dominioErrado = 0, dominioTotal;
            lista = (ArrayList<Desempenho>) dao.relatorioDominio(super.getTime(), partida);

            for (int i = 0; i < lista.size(); i++) {

                dominioCerto = dominioCerto + lista.get(i).getDominioCerto();
                dominioErrado = dominioErrado + lista.get(i).getDominioErrado();

            }
            dominioCerto = dominioCerto / 4;
            dominioErrado = dominioErrado / 4;
            dominioTotal = dominioCerto + dominioErrado;
            cel1 = new PdfPCell(new Paragraph(dominioCerto + ""));
            cel2 = new PdfPCell(new Paragraph(dominioErrado + ""));
            cel3 = new PdfPCell(new Paragraph(dominioTotal + ""));

            tabelaDominio.addCell(cel1);
            tabelaDominio.addCell(cel2);
            tabelaDominio.addCell(cel3);

            documento.add(tabelaDominio);
            p = new Paragraph("       ");

            documento.add(p);

            p = new Paragraph("Finalizações");
            p.setAlignment(1);

            documento.add(p);
            p = new Paragraph("      ");
            documento.add(p);

            PdfPTable tabelaFinalizacao = new PdfPTable(6);
            PdfPCell cel4;
            PdfPCell cel5;
            PdfPCell cel6;

            cel1 = new PdfPCell(new Paragraph("Drible"));
            cel2 = new PdfPCell(new Paragraph("Assistência"));
            cel3 = new PdfPCell(new Paragraph("Desarme"));
            cel4 = new PdfPCell(new Paragraph("Gol"));
            cel5 = new PdfPCell(new Paragraph("Finaliza Gols"));
            cel6 = new PdfPCell(new Paragraph("Finaliza totais"));

            tabelaFinalizacao.addCell(cel1);
            tabelaFinalizacao.addCell(cel2);
            tabelaFinalizacao.addCell(cel3);
            tabelaFinalizacao.addCell(cel4);
            tabelaFinalizacao.addCell(cel5);
            tabelaFinalizacao.addCell(cel6);

            lista = (ArrayList<Desempenho>) dao.relatorioFinalizacao(super.getTime(), partida);
            //nome      | drible | assistencia | desarme | gol  | finalizacoesGols | finalizacoesTotais |

            int drible = 0, desarme = 0, gol = 0, finalizacaoGols = 0, finalizacaoTotal = 0, assistencia = 0;

            for (int i = 0; i < lista.size(); i++) {

                drible = drible + lista.get(i).getDrible();
                desarme = desarme + lista.get(i).getDesarme();
                finalizacaoGols = finalizacaoGols + lista.get(i).getFinalizacoesGols();
                gol = gol + lista.get(i).getGol();
                finalizacaoTotal = finalizacaoTotal + lista.get(i).getFinalizacoesTotais();
                assistencia = assistencia + lista.get(i).getAssistencia();

            }
            cel1 = new PdfPCell(new Paragraph(drible + ""));
            cel2 = new PdfPCell(new Paragraph(assistencia + ""));
            cel3 = new PdfPCell(new Paragraph(desarme + ""));
            cel4 = new PdfPCell(new Paragraph(gol + ""));
            cel5 = new PdfPCell(new Paragraph(finalizacaoGols + ""));
            cel6 = new PdfPCell(new Paragraph(finalizacaoTotal + ""));

            tabelaFinalizacao.addCell(cel1);
            tabelaFinalizacao.addCell(cel2);
            tabelaFinalizacao.addCell(cel3);
            tabelaFinalizacao.addCell(cel4);
            tabelaFinalizacao.addCell(cel5);
            tabelaFinalizacao.addCell(cel6);

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

        Paragraph p = new Paragraph("D.T-Relatório Equipe");
        try {
            p.setAlignment(1);
            documento.add(p);
        } catch (DocumentException ex) {
            Logger.getLogger(RelatorioJogador.class.getName()).log(Level.SEVERE, null, ex);
        }
        return documento;
    }

}
