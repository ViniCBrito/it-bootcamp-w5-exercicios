package br.com.meli.codigomorse.utils;

import br.com.meli.codigomorse.models.MorseModel;

public enum MorseTranslation {
    A(new MorseModel("A", ".-")),
    B(new MorseModel("B", "-...")),
    C(new MorseModel("C", "-.-.")),
    D(new MorseModel("D", "-..")),
    E(new MorseModel("E", ".")),
    F(new MorseModel("F", "..-.")),
    G(new MorseModel("G", "--.")),
    H(new MorseModel("H", "....")),
    I(new MorseModel("I", "..")),
    J(new MorseModel("J", ".---")),
    K(new MorseModel("K", "-.-")),
    L(new MorseModel("L", ".-..")),
    M(new MorseModel("M", "--")),
    N(new MorseModel("N", "-.")),
    O(new MorseModel("O", "---")),
    P(new MorseModel("P", ".--.")),
    Q(new MorseModel("Q", "--.-")),
    R(new MorseModel("R", ".-.")),
    S(new MorseModel("S", "...")),
    T(new MorseModel("T", "-")),
    U(new MorseModel("U", "..-")),
    V(new MorseModel("V", "...-")),
    W(new MorseModel("W", ".--")),
    X(new MorseModel("X", "-..-")),
    Y(new MorseModel("Y", "-.--")),
    Z(new MorseModel("Z", "--..")),
    NUM1(new MorseModel("1", ".----")),
    NUM2(new MorseModel("2", "..---")),
    NUM3(new MorseModel("3", "...--")),
    NUM4(new MorseModel("4", "....-")),
    NUM5(new MorseModel("5", ".....")),
    NUM6(new MorseModel("6", "-....")),
    NUM7(new MorseModel("7", "--...")),
    NUM8(new MorseModel("8", "---..")),
    NUM9(new MorseModel("9", "----.")),
    NUM0(new MorseModel("0", "-----")),
    INTERROGACAO(new MorseModel("?", "..--..")),
    PONTO(new MorseModel(".", ".-.-.-")),
    EXCLAMACAO(new MorseModel("!", "-.-.--")),
    VIRGULA(new MorseModel(",", "--..--")),
    ;

    private MorseModel morse;

    MorseTranslation(MorseModel morse) {
        this.morse = morse;
    }

    public MorseModel getMorse() {
        return morse;
    }
}
