/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.uniritter.compiler;

/**
 *
 * @author Alexsander
 */
public enum Tipo {
    SOMA,                   //+
    SUBTRACAO,              //-
    MULTIPLICACAO,          //*
    DIVISAO,                ///
    IDENTIFICADOR,          ///x,y
    NUMERO,                 //1,15,35...
    ABRE_PARENTESIS,        //(
    FECHA_PARENTESIS,       //)
    ERRO,                   //tokens nao reconhecidos
    CODIGO                  //Token para codigo
}
