package prueba_analizador;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.StringTokenizer;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.swing.JOptionPane;

import static prueba_analizador.Token.Tipos;

public class Prueba_analizador {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String input = sc.nextLine();
        ArrayList<Token> tokens = lex(input);
        tokens.forEach((token) -> {
            System.out.println("(" + token.getTipo() + ": " + token.getValor() + ")");
        });
    }

    private static ArrayList<Token> lex(String input) {
        final ArrayList<Token> tokens = new ArrayList<>();
        final StringTokenizer st = new StringTokenizer(input);

        while (st.hasMoreTokens()) {
            String palabra = st.nextToken();
            boolean matched = false;

            for (Tipos tokenTipo : Tipos.values()) {
                Pattern patron = Pattern.compile(tokenTipo.patron);
                Matcher matcher = patron.matcher(palabra);
                if (matcher.find()) {
                    Token tk = new Token();
                    tk.setTipo(tokenTipo);
                    tk.setValor(palabra);
                    tokens.add(tk);
                    matched = true;
                }
            }

            if (!matched) {
                JOptionPane.showMessageDialog(null, "Token invalido","Error",JOptionPane.INFORMATION_MESSAGE);
            }
        }
        return tokens;
    }

}
