/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.uniritter.compiler;

import java.util.HashMap;

/**
 *
 * @author alexs
 */
public class TabelaDeSimbolos {
    
    HashMap<Chave, Token> ts = new HashMap<>();
    
    // Metodo que realiza o salvamento do Token no HashMap
    public void addTokenNaTS(Chave c, Token t) {
        ts.put(c, t);
    }
    
    // Metodo para que seja retornado o token da Tabela de Simbolos
    public Token getToken(Chave chave) {
        return ts.get(chave);
    }
    
    // Metodo para atualizacao do atributo de um token, note que se for necessario atualizar 
    // atributos inteiro (linha e coluna por exemplo, deve-se implementar um
    // reconhecimento
    public void setAttributeOfToken(Chave chave, String atributo, String valor) {
        
    }
    
    public String getAttributeOfToken(Chave chave, String atributo) {
        // neste metodo deve-se pegar a chave e buscar o token da TS, para entao
        // "descontruir" os atributos do token em variáveis para retornar unicamente uma string
        return "";
    }
    
}
