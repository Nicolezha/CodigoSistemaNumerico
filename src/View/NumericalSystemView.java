package View;

import Model.NumericalSystem;

public class NumericalSystemView {

    public static void main(String[] args) {
        NumericalSystem num = new NumericalSystem();
        System.out.println("SUMAS:");

        System.out.println(num.addBinaryNumbers("1101", "110"));
        System.out.println(num.addOctalNumbers("776", "72"));
        System.out.println(num.addHexadecimalNumbers("F12", "FFF") + "\n");

        System.out.println("RESTAS:");
        System.out.println(num.subtractBinaryNumbers("10110", "11001"));
        System.out.println(num.subtractOctalNumbers("125", "7776"));
        System.out.println(num.subtractHexadecimalNumbers("12", "FF3") + "\n");

        System.out.println("MULTIPLICACIONES");

        System.out.println(num.multiplyBinaryNumbers("101", "1010"));
        System.out.println(num.multiplyOctalNumbers("125", "7776"));
        System.out.println(num.multiplyHexadecimalNumbers("12", "FF3") + "\n");

        System.out.println("DIVISIONES");

        System.out.println(num.divideInBinaryNumbers("1010", "101"));
        System.out.println(num.divideInOctalNumbers("7776", "125"));
        System.out.println(num.divideInHexadecimalNumbers("12", "FF3") + "\n");
    
        
        System.out.println(num.divideByCero("1000", "000", "División"));
        
        System.out.println(num.hexadecimalToOctal("101"));
        System.out.println(num.octalToBinary("74"));
        System.out.println(num.binaryToDecimal("101"));
        System.out.println(num.binaryToOctal("10101"));
        System.out.println(num.octalToHexadecimal("231"));
    }
}
