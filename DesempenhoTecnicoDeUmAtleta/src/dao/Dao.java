/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.util.List;



/**
 *
 * @author jose
 */
public interface Dao {
    public boolean inserir(Object object);
    public boolean excluir(Object object);
    public boolean atualizar(Object object);
    public List buscar();        
        
}
