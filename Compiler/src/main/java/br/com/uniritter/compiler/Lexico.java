package br.com.uniritter.compiler;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PushbackReader;
import java.util.HashMap;

/**
 *
 * @author Alexsander Oliveira
 *
 */
public class Lexico {

    PushbackReader r;
    int intCh;
    char ch = ' ';
    int linha = 1;
    int coluna = 0;

    public Lexico(String arquivo) {
        try {
            r = new PushbackReader(
                    new BufferedReader(
                            new InputStreamReader(
                                    new FileInputStream(arquivo))));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public Token buscaToken() {

        //Lexema que esta sendo construido
        String lexema = "";

        //estado corrente da afd
        int state = 0;

        //coluna inicial do lexema sendo lido
        int coluna_inicial = 0;

        //Le o proximo caracter
        ch = leCh();

        while (ch != '@') {
            switch (state) {
                case 0:
                    if (ch == '+') {
                        return new Token(TipoToken.SMAIS, "+", linha, coluna);
                    } else if (ch == '-') {
                        return new Token(TipoToken.SMENOS, "-", linha, coluna);
                    } else if (ch == '*') {
                        return new Token(TipoToken.SMULTIPLICACAO, "*", linha, coluna);
                    } else if (ch == '/') {
                        return new Token(TipoToken.SDIVISAO, "/", linha, coluna);
                    } else if (ch == '(') {
                        return new Token(TipoToken.SABRE_PARENTESIS, "(", linha, coluna);
                    } else if (ch == ')') {
                        return new Token(TipoToken.SFECHA_PARENTESIS, ")", linha, coluna);
                    } else if (Character.isDigit(ch)) {
                        coluna_inicial = coluna;
                        lexema += ch;
                        state = 12;
                        break;
                    } else if (Character.isLetter(ch)) {
                        coluna_inicial = coluna;
                        lexema += ch;
                        state = 14;
                        break;
                    }
                    break;

                case 12:
                    if (Character.isDigit(ch)) {
                        lexema += ch;
                        state = 12;
                    } else {
                        devolve();
                        state = 0;
                        return new Token(TipoToken.SNUMERO, lexema, linha, coluna_inicial);
                    }
                    break;

                case 14:
                    if (Character.isLetter(ch)) {
                        lexema += ch;
                        state = 14;

                    } else {
                        devolve();
                        state = 0;
                        switch (lexema) {
                            case "aa":
                                return new Token(TipoToken.SMAIS, lexema, linha, coluna_inicial);
                            default:
                                return new Token(TipoToken.SIDENTIFICADOR, lexema, linha, coluna_inicial);
                        }
                    }
                    break;

            }   //Fim Switch
            char a = ch;
            //
            leCh();
            //
            if (ch == '@') {

                if (Character.isDigit(a)) {

                    return new Token(TipoToken.SNUMERO, lexema, linha, coluna_inicial);
                }

                if (Character.isLetter(a)) {
                    switch (lexema) {
                        case "aa":
                            return new Token(TipoToken.SMAIS, lexema, linha, coluna_inicial);
                        default:
                            return new Token(TipoToken.SIDENTIFICADOR, lexema, linha, coluna_inicial);
                    }
                }

            }

        }   //Fim While

        lexema += ch;
        return new Token(TipoToken.SERRO, Character.toString(ch), linha, coluna);
    }

    public char leCh() {
        try {
            intCh = r.read();
            //while ((char) intCh== ' ' && intCh != -1) intCh = r.read();
            ch = (char) intCh;
            if (ch == '\n') {
                linha++;
                coluna = 0;
            } else {
                coluna++;
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        if (intCh == -1) {
            ch = '@';
        }
        return ch;
    }

    //Devolve caracter para a stream e decrementa coluna e linha conforme necessario
    public void devolve() {
        try {
            r.unread(ch);
            if (ch == '\n') {
                linha--;
            } else {
                coluna--;
            }
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public HashMap<String, Token> listaTokens() {
        Token t;
        HashMap<String, Token> listaToken = new HashMap<>(); //Lista de tokens

        t = buscaToken();
        while (t.tipoToken != TipoToken.SERRO) {
            listaToken.put(t.lexema, t);
            //System.out.println("\n Adiciona "+ t);
            //System.out.println("Token: "+ t.toString());
            t = buscaToken();
        }

        //Imprimi numero de tokens
        System.out.println("Numero de tokens: " + listaToken.size());

        listaToken.entrySet().forEach(tok -> {
            System.out.println(tok.toString());
        });

        return listaToken;
    }

}
