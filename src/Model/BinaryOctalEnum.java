/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

/**
 *
 * @author Nicole Hernandez
 */
public enum BinaryOctalEnum {
    ZERO("000", "0"),
    ONE("001", "1"),
    TWO("010", "2"),
    THREE("011", "3"),
    FOUR("100", "4"),
    FIVE("101", "5"),
    SIX("110", "6"),
    SEVEN("111", "7");
    
    private final String binary;
    private final String octal;
    
    BinaryOctalEnum(String binary, String octal) {
        this.binary = binary;
        this.octal = octal;
    }

    public static String getBinary(String octal) {
        for (BinaryOctalEnum hc : BinaryOctalEnum.values()) {
            if (hc.getOctal().equals(octal)) {
                return hc.getBinary();
            }
        }
        throw new IllegalArgumentException("Octal no válido: " + octal);
    }

    public static String getOctal(String binary) {
        for (BinaryOctalEnum hc : BinaryOctalEnum.values()) {
            if (hc.getBinary().equals(binary)) {
                return hc.getOctal();
            }
        }
        throw new IllegalArgumentException("Binario no válido: " + binary);
    }

    public String getBinary() {
        return this.binary;
    }

    public String getOctal() {
        return this.octal;
    }
}
