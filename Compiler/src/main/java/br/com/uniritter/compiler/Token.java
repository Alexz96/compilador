package br.com.uniritter.compiler;

/**
 *
 * @author Alexsander Oliveira
 * @author Tailine Wornath
 * @author Teo Falleiro
 */
public class Token {
    
    TipoToken tipoToken;
    String lexema;
    int linha;
    int coluna;
    String nome;
    String codigo;
    
    public Token(TipoToken tipo, String lexema, int linha, int coluna) {
        this.tipoToken = tipo;
        this.lexema = lexema;
        this.linha = linha;
        this.coluna = coluna;
    }

    @Override
    public String toString() {
        return "Token{" + "tipo=" + tipoToken + ", lexema=" + lexema + ", linha=" + linha + ", coluna=" + coluna + '}';
    }
    
}
