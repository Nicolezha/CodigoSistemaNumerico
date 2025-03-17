/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

/**
 *
 * @author Nicole Hernandez
 */
public enum BinaryHexadecimalEnum {
    ZERO("0000", "0"),
    ONE("0001", "1"),
    TWO("0010", "2"),
    THREE("0011", "3"),
    FOUR("0100", "4"),
    FIVE("0101", "5"),
    SIX("0110", "6"),
    SEVEN("0111", "7"),
    EIGHT("1000", "8"),
    NINE("1001", "9"),
    A("1010", "A"),
    B("1011", "B"),
    C("1100", "C"),
    D("1101", "D"),
    E("1110", "E"),
    F("1111", "F");

    private final String binary;
    private final String hexadecimal;

    BinaryHexadecimalEnum(String binary, String hexadecimal) {
        this.binary = binary;
        this.hexadecimal = hexadecimal;
    }

    public static String getBinary(String hexadecimal) {
        hexadecimal = hexadecimal.toUpperCase();
        for (BinaryHexadecimalEnum hc : BinaryHexadecimalEnum.values()) {
            if (hc.getHexadecimal().equals(hexadecimal)) {
                return hc.getBinary();
            }
        }
        throw new IllegalArgumentException("Hexadecimal no válido: " + hexadecimal);
    }

    public static String getHexadecimal(String binary) {
        for (BinaryHexadecimalEnum hc : BinaryHexadecimalEnum.values()) {
            if (hc.getBinary().equals(binary)) {
                return hc.getHexadecimal();
            }
        }
        throw new IllegalArgumentException("Binario no válido: " + binary);
    }

    public String getBinary() {
        return this.binary;
    }

    public String getHexadecimal() {
        return this.hexadecimal;
    }
}
