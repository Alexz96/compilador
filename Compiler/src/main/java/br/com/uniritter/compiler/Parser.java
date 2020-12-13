package br.com.uniritter.compiler;

/**
 *
 * @author Alexsander Oliveira
 *
 */
public class Parser {

    Lexico lexico;
    Token token;

    //Valor da express�o
    int valor;

    public Parser(Lexico lex) {
        lexico = lex;
    }

    public void Erro(String s) {
        System.out.print(s);
    }

    public Token bt() {
        Token t = lexico.buscaToken();
        System.out.println(t.toString());
        return t;
    }

    public void parse() {
        expressao();
    }

    public void expressao() {
        token = bt();
        if (token.tipoToken == TipoToken.SMAIS || token.tipoToken == TipoToken.SMENOS) {
            token = bt();
        }
        termo();
        while (token.tipoToken == TipoToken.SMAIS || token.tipoToken == TipoToken.SMENOS) {
            token = bt();
            termo();
        }
    }

    public void termo() {
        fator();
        token = bt();
        while (token.tipoToken == TipoToken.SMULTIPLICACAO || token.tipoToken == TipoToken.SDIVISAO) {
            token = bt();
            fator();
            token = bt();
        }
    }

    public void fator() {
        if (token.tipoToken == TipoToken.SIDENTIFICADOR || token.tipoToken == TipoToken.SNUMERO); else if (token.tipoToken == TipoToken.SABRE_PARENTESIS) {
            expressao();
            token = bt();
            if (token.tipoToken == TipoToken.SFECHA_PARENTESIS); else {
                System.out.println(") esperado");
            }
        }

    }
}
