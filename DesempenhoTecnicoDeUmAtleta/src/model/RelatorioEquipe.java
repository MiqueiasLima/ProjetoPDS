/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import com.itextpdf.text.Document;

/**
 *
 * @author jose
 */
public class RelatorioEquipe extends Relatorio{

    @Override
    public Document corpo(Document documento) {
     return documento;   
    }

    @Override
    public Document rodaPe(Document documento) {
       return documento;
    }
    
   
    
    
    
}
