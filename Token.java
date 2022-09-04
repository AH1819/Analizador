package prueba_analizador;

public class Token {

    public Tipos getTipo() {
        return tipo;
    }

    public void setTipo(Tipos tipo) {
        this.tipo = tipo;
    }

    public String getValor() {
        return valor;
    }

    public void setValor(String valor) {
        this.valor = valor;
    }

    private Tipos tipo;
    private String valor;

    enum Tipos {
        NUMERO("[0-9]+"),
        IDENTIFICADOR("[a-zA-Z]+"),
        OPERADOR_INC_DEC("[++]+[--]"),
        OPERADOR_BOOLEANO("(cierto|falso)"),
        OPERADOR_LOGICO("[&&]+[||]+[!]+[&]+[|]"),
        OPERADOR_ATRIBUCION("[+=]+[-=]+[*=]+[/=]+[%=]"),
        OPERADOR_RELACIONAL("(>|<|==|!=|>=|<=|<<|>>)"),
        PALABRAS_RESERVADAS("(si|sino|mientras|hacer)"),
        TIPOS_DE_DATOS("(entero|decimal|caracter|Cadena|logica|unidad_logica|doble|entero_big)");
        

        public final String patron;

        Tipos(String s) {
            this.patron = s;
        }
    }

}
