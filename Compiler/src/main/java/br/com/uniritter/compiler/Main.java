package br.com.uniritter.compiler;

import java.util.HashMap;

/**
 *
 * @author Alexsander Oliveira
 * @author Tailine Wornath
 * @author Teo Falleiro
 *
 */
public class Main {

    public static void testaLexico() {
        //Cria lista de tokens
        HashMap<String, Token> lt = new HashMap<>();
        HashMap<String, Token> lt2 = new HashMap<>();


        //Cria analisador lexico
        Lexico lexico = new Lexico("teste1.lpd");
        Lexico lexico2 = new Lexico("teste2.lpd");

        //Realiza a analise lexica do codigo
        lt = lexico.listaTokens();
        lt2 = lexico.listaTokens();
    }

    public static void testaParser() {
        Lexico lexico = new Lexico("teste2.lpd");
        Parser parser = new Parser(lexico);
        parser.parse();

    }

//    public static void testaParserCodigo() {
//        Lexico lexico = new Lexico("teste2.lpd");
//        ParserCodigo parser = new ParserCodigo(lexico);
//        String codigo = parser.parse();
//        System.out.println("Codigo: \n" + codigo);
//    }

    public static void main(String[] args) {
        testaLexico();
        //testaParser();
        //testaParserCodigo();
    }

}
