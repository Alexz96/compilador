package br.com.uniritter.compiler;

/**
 *
 * @author Alexsander Oliveira
 */
public enum TipoToken {
    SPROGRAMA,              //programa
    SVAR,                   //var
    SDOISPONTOS,            //:
    SINICIO,                //inicio
    SFIM,                   //fim
    SATRIBUICAO,            //:=
    STIPO,                  //:
    SVIRGULA,               //,
    SESCREVA,               //escreva
    SINTEIRO,               //inteiro
    SBOOLEANO,              //booleano
    SPONTO_E_VIRGULA,       //;
    SPONTO,                 //.
    SMAIS,                  //+
    SMENOS,                 //-
    SMULTIPLICACAO,         //*
    SDIVISAO,               // /
    SNUMERO,                //5
    SIDENTIFICADOR,         //x, teste
    SABRE_PARENTESIS,       //(
    SFECHA_PARENTESIS,      //)
    CODIGO,                 //Token para codigo
    SERRO                   //Usado para tokens nao reconhecidos
}
