/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package des;

import java.math.BigInteger;
/**
 *
 * @author Administrator
 */
import java.math.BigInteger;

public class DES {
    public static int[][] s1 = {
                {14, 4, 13, 1, 2, 15, 11, 8, 3, 10, 6, 12, 5, 9, 0, 7},
                {0, 15, 7, 4, 14, 2, 13, 1, 10, 6, 12, 11, 9, 5, 3, 8},
                {4, 1, 14, 8, 13, 6, 2, 11, 15, 12, 9, 7, 3, 10, 5, 0},
                {15, 12, 8, 2, 4, 9, 1, 7, 5, 11, 3, 14, 10, 0, 6, 13}
        };

        public static int[][] s2 = {
                {15, 1, 8, 14, 6, 11, 3, 4, 9, 7, 2, 13, 12, 0, 5, 10},
                {3, 13, 4, 7, 15, 2, 8, 14, 12, 0, 1, 10, 6, 9, 11, 5},
                {0, 14, 7, 11, 10, 4, 13, 1, 5, 8, 12, 6, 9, 3, 2, 15},
                {13, 8, 10, 1, 3, 15, 4, 2, 11, 6, 7, 12, 0, 5, 14, 9}
        };

        public static int[][] s3 = {
                {10, 0, 9, 14, 6, 3, 15, 5, 1, 13, 12, 7, 11, 4, 2, 8},
                {13, 7, 0, 9, 3, 4, 6, 10, 2, 8, 5, 14, 12, 11, 15, 1},
                {13, 6, 4, 9, 8, 15, 3, 0, 11, 1, 2, 12, 5, 10, 14, 7},
                {1, 10, 13, 0, 6, 9, 8, 7, 4, 15, 14, 3, 11, 5, 2, 12}
        };

        public static int[][] s4 = {
                {7, 13, 14, 3, 0, 6, 9, 10, 1, 2, 8, 5, 11, 12, 4, 15},
                {13, 8, 11, 5, 6, 15, 0, 3, 4, 7, 2, 12, 1, 10, 14, 9},
                {10, 6, 9, 0, 12, 11, 7, 13, 15, 1, 3, 14, 5, 2, 8, 4},
                {3, 15, 0, 6, 10, 1, 13, 8, 9, 4, 5, 11, 12, 7, 2, 14}
        };

        public static int[][] s5 = {
                {2, 12, 4, 1, 7, 10, 11, 6, 8, 5, 3, 15, 13, 0, 14, 9},
                {14, 11, 2, 12, 4, 7, 13, 1, 5, 0, 15, 10, 3, 9, 8, 6},
                {4, 2, 1, 11, 10, 13, 7, 8, 15, 9, 12, 5, 6, 3, 0, 14},
                {11, 8, 12, 7, 1, 14, 2, 13, 6, 15, 0, 9, 10, 4, 5, 3}
        };

        public static int[][] s6 = {
                {12, 1, 10, 15, 9, 2, 6, 8, 0, 13, 3, 4, 14, 7, 5, 11},
                {10, 15, 4, 2, 7, 12, 9, 5, 6, 1, 13, 14, 0, 11, 3, 8},
                {9, 14, 15, 5, 2, 8, 12, 3, 7, 0, 4, 10, 1, 13, 11, 6},
                {4, 3, 2, 12, 9, 5, 15, 10, 11, 14, 1, 7, 6, 0, 8, 13}
        };

        public static int[][] s7 = {
                {4, 11, 2, 14, 15, 0, 8, 13, 3, 12, 9, 7, 5, 10, 6, 1},
                {13, 0, 11, 7, 4, 9, 1, 10, 14, 3, 5, 12, 2, 15, 8, 6},
                {1, 4, 11, 13, 12, 3, 7, 14, 10, 15, 6, 8, 0, 5, 9, 2},
                {6, 11, 13, 8, 1, 4, 10, 7, 9, 5, 0, 15, 14, 2, 3, 12}
        };

        public static int[][] s8 = {
                {13, 2, 8, 4, 6, 15, 11, 1, 10, 9, 3, 14, 5, 0, 12, 7},
                {1, 15, 13, 8, 10, 3, 7, 4, 12, 5, 6, 11, 0, 14, 9, 2},
                {7, 11, 4, 1, 9, 12, 14, 2, 0, 6, 10, 13, 15, 3, 5, 8},
                {2, 1, 14, 7, 4, 10, 8, 13, 15, 12, 9, 0, 3, 5, 6, 11}
        };
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        

        int [] initialPermutationTable = {//Parity drop table
            57, 49, 41, 33, 25, 17, 9, 1, 58, 50, 42, 34, 26, 18, 10, 2,
            59, 51, 43, 35, 27, 19, 11, 3, 60, 52, 44, 36, 63, 55, 47,
            39, 31, 23, 15, 7, 62, 54, 46, 38, 30, 22, 14, 6, 61, 53,
            45, 37, 29, 21, 13, 5, 28, 20, 12, 4
        };
        int [] finalPermutationTable = {// compression D-box
            14, 17, 11, 24, 1, 5,
            3, 28, 15, 6, 21, 10,
            23, 19, 12, 4, 26, 8,
            16, 7, 27, 20, 13, 2,
            41, 52, 31, 37, 47, 55,
            30, 40, 51, 45, 33, 48,
            44, 49, 39, 56, 34, 53,
            46, 42, 50, 36, 29, 32  
        };
        int [] InitalPermutationTableForMessage = {
          58, 50, 42, 34, 26, 18, 10, 2,
          60, 52, 44, 36, 28, 20, 12, 4,
          62, 54, 46, 38, 30, 22, 14, 6,
          64, 56, 48, 40, 32, 24, 16, 8,
          57, 49, 41, 33, 25, 17, 9, 1,
          59, 51, 43, 35, 27, 19, 11, 3,
          61, 53, 45, 37, 29, 21, 13, 5,
          63, 55, 47, 39, 31, 23, 15, 7, 
        };
        int [] finalPermutationTableForMessage = {
            40, 8, 48, 16, 56, 24, 64, 32,
            39, 7, 47, 15, 55, 23, 63, 31,
            38, 6, 46, 14, 54, 22, 62, 30,
            37, 5, 45, 13, 53, 21, 61, 29,
            36, 4, 44, 12, 52, 20, 60, 28,
            35, 3, 43, 11, 51, 19, 59, 27,
            34, 2, 42, 10, 50, 18, 58, 26,
            33, 1, 41, 9, 49, 17, 57, 25  
        };
        int [] ExpansionD_boxTable = {
            32, 1, 2, 3, 4, 5,
            4, 5, 6, 7, 8, 9,
            8, 9, 10, 11, 12, 13,
            12, 13, 14, 15, 16, 17,
            16, 17, 18, 19, 20, 21,
            20, 21, 22, 23, 24, 25,
            24, 25, 26, 27, 28, 29,
            28, 29, 30, 31, 32, 1,
        };
        int [] StraightD_box = {
            16, 7, 20, 21,
            29, 12, 28, 17,
            1, 15, 23, 26,
            5, 18, 31, 10,
            2, 8, 24, 14,
            32, 27, 3, 9,
            19, 13, 30, 6,
            22, 11, 4, 25,
        };
//        String keyInHexa = "133457799BBCDFF1";
//        String plainTextInHexa = "0123456789ABCDEF";
        String keyInHexa = "0F1571C947D9E859";
        String plainTextInHexa = "02468ACEECA86420";
        String keyInBinary = checkLengthOfBinary(new BigInteger(keyInHexa, 16).toString(2));
        String plainTextInBinary = checkLengthOfBinary(new BigInteger(plainTextInHexa, 16).toString(2));
        String permutatedKey = permutation(keyInBinary, initialPermutationTable);
        
        String c0 = permutatedKey.substring(0, 28);
        String d0 = permutatedKey.substring(28, permutatedKey.length());
        
        String c1 = shiftingLeft(c0, 1);
        String d1 = shiftingLeft(d0, 1);
        
        String c2 = shiftingLeft(c1, 1);
        String d2 = shiftingLeft(d1, 1);
        
        String c3 = shiftingLeft(c2, 2);
        String d3 = shiftingLeft(d2, 2);
        
        String c4 = shiftingLeft(c3, 2);
        String d4 = shiftingLeft(d3, 2);

        String c5 = shiftingLeft(c4, 2);
        String d5 = shiftingLeft(d4, 2);

        String c6 = shiftingLeft(c5, 2);
        String d6 = shiftingLeft(d5, 2);

        String c7 = shiftingLeft(c6, 2);
        String d7 = shiftingLeft(d6, 2);

        String c8 = shiftingLeft(c7, 2);
        String d8 = shiftingLeft(d7, 2);

        String c9 = shiftingLeft(c8, 1);
        String d9 = shiftingLeft(d8, 1);

        String c10 = shiftingLeft(c9, 2);
        String d10 = shiftingLeft(d9, 2);

        String c11 = shiftingLeft(c10, 2);
        String d11 = shiftingLeft(d10, 2);

        String c12 = shiftingLeft(c11, 2);
        String d12 = shiftingLeft(d11, 2);

        String c13 = shiftingLeft(c12, 2);
        String d13 = shiftingLeft(d12, 2);

        String c14 = shiftingLeft(c13, 2);
        String d14 = shiftingLeft(d13, 2);

        String c15 = shiftingLeft(c14, 2);
        String d15 = shiftingLeft(d14, 2);

        String c16 = shiftingLeft(c15, 1);
        String d16 = shiftingLeft(d15, 1);
        // the following after appling final permutation
        String k1 = permutation(c1+d1, finalPermutationTable);
        String k2 = permutation(c2+d2, finalPermutationTable);
        String k3 = permutation(c3+d3, finalPermutationTable);
        String k4 = permutation(c4+d4, finalPermutationTable);
        String k5 = permutation(c5+d5, finalPermutationTable);
        String k6 = permutation(c6+d6, finalPermutationTable);
        String k7 = permutation(c7+d7, finalPermutationTable);
        String k8 = permutation(c8+d8, finalPermutationTable);
        String k9 = permutation(c9+d9, finalPermutationTable);
        String k10 = permutation(c10+d10, finalPermutationTable);
        String k11 = permutation(c11+d11, finalPermutationTable);
        String k12 = permutation(c12+d12, finalPermutationTable);
        String k13 = permutation(c13+d13, finalPermutationTable);
        String k14 = permutation(c14+d14, finalPermutationTable);
        String k15 = permutation(c15+d15, finalPermutationTable);
        String k16 = permutation(c16+d16, finalPermutationTable);
        // the following part for printing the results
        System.out.println("key in hexa: "+keyInHexa);
        
        System.out.println("The following steps is applied on the key");
        System.out.println("key in binary: "+keyInBinary);
        System.out.println(
                "Key after inital permutation: "+ permutatedKey+", In Hexa: "+Long.toHexString(Long.parseLong(permutatedKey,2)));
        
        System.out.println("c0: "+c0+", In hexa: "+Long.toHexString(Long.parseLong(c0,2)));
        System.out.println("d0: "+d0+", In Hexa: "+Long.toHexString(Long.parseLong(d0,2)));
        
        System.out.println("c1: "+c1);
        System.out.println("d1: "+d1);
        
        System.out.println("c2: "+c2);
        System.out.println("d2: "+d2);
        
        System.out.println("c3: "+c3);
        System.out.println("d3: "+d3);
        
        System.out.println("c4: "+c4);
        System.out.println("d4: "+d4);
        
        System.out.println("c5: "+c5);
        System.out.println("d5: "+d5);
        
        System.out.println("c6: "+c6);
        System.out.println("d6: "+d6);
        
        System.out.println("c7: "+c7);
        System.out.println("d7: "+d7);
        
        System.out.println("c8: "+c8);
        System.out.println("d8: "+d8);
        
        System.out.println("c9: "+c9);
        System.out.println("d9: "+d9);
        
        System.out.println("c10: "+c10);
        System.out.println("d10: "+d10);
        
        System.out.println("c11: "+c11);
        System.out.println("d11: "+d11);
        
        System.out.println("c12: "+c12);
        System.out.println("d12: "+d12);
        
        System.out.println("c13: "+c13);
        System.out.println("d13: "+d13);
        
        System.out.println("c14: "+c14);
        System.out.println("d14: "+d14);
        
        System.out.println("c15: "+c15);
        System.out.println("d15: "+d15);
        
        System.out.println("c16: "+c16);
        System.out.println("d16: "+d16);
        
        System.out.println("k1: "+k1+", In Hexa: "+Long.toHexString(Long.parseLong(k1,2)));
        System.out.println("k2: "+k2+", In Hexa: "+Long.toHexString(Long.parseLong(k2,2)));
        System.out.println("k3: "+k3+", In Hexa: "+Long.toHexString(Long.parseLong(k3,2)));
        System.out.println("k4: "+k4+", In Hexa: "+Long.toHexString(Long.parseLong(k4,2)));
        System.out.println("k5: "+k5+", In Hexa: "+Long.toHexString(Long.parseLong(k5,2)));
        System.out.println("k6: "+k6+", In Hexa: "+Long.toHexString(Long.parseLong(k6,2)));
        System.out.println("k7: "+k7+", In Hexa: "+Long.toHexString(Long.parseLong(k7,2)));
        System.out.println("k8: "+k8+", In Hexa: "+Long.toHexString(Long.parseLong(k8,2)));
        System.out.println("k9: "+k9+", In Hexa: "+Long.toHexString(Long.parseLong(k9,2)));
        System.out.println("k10: "+k10+", In Hexa: "+Long.toHexString(Long.parseLong(k10,2)));
        System.out.println("k11: "+k11+", In Hexa: "+Long.toHexString(Long.parseLong(k11,2)));
        System.out.println("k12: "+k12+", In Hexa: "+Long.toHexString(Long.parseLong(k12,2)));
        System.out.println("k13: "+k13+", In Hexa: "+Long.toHexString(Long.parseLong(k13,2)));
        System.out.println("k14: "+k14+", In Hexa: "+Long.toHexString(Long.parseLong(k14,2)));
        System.out.println("k15: "+k15+", In Hexa: "+Long.toHexString(Long.parseLong(k15,2)));
        System.out.println("k16: "+k16+", In Hexa: "+Long.toHexString(Long.parseLong(k16,2)));
        System.out.println("Now the following part is related to the plaintext: ");
        //the following part is relaed to calculation of message
        String permutatedMessage = permutation(plainTextInBinary,InitalPermutationTableForMessage);
        String l0 = permutatedMessage.substring(0,permutatedMessage.length()/2);
        String r0 = permutatedMessage.substring(permutatedMessage.length()/2,permutatedMessage.length());
        
        String l1 = r0;
        String r1 = XorBinary(l0,DES_function(r0, k1, ExpansionD_boxTable,StraightD_box));
        
        String l2 = r1;
        String r2 = XorBinary(l1,DES_function(r1, k2, ExpansionD_boxTable,StraightD_box));
        
        String l3 = r2;
        String r3 = XorBinary(l2,DES_function(r2, k3, ExpansionD_boxTable,StraightD_box));
        
        String l4 = r3;
        String r4 = XorBinary(l3,DES_function(r3, k4, ExpansionD_boxTable,StraightD_box));
        
        String l5 = r4;
        String r5 = XorBinary(l4,DES_function(r4, k5, ExpansionD_boxTable,StraightD_box));
        
        String l6 = r5;
        String r6 = XorBinary(l5,DES_function(r5, k6, ExpansionD_boxTable,StraightD_box));
        
        String l7 = r6;
        String r7 = XorBinary(l6,DES_function(r6, k7, ExpansionD_boxTable,StraightD_box));
        
        String l8 = r7;
        String r8 = XorBinary(l7,DES_function(r7, k8, ExpansionD_boxTable,StraightD_box));
        
        String l9 = r8;
        String r9 = XorBinary(l8,DES_function(r8, k9, ExpansionD_boxTable,StraightD_box));
        
        String l10 = r9;
        String r10 = XorBinary(l9,DES_function(r9, k10, ExpansionD_boxTable,StraightD_box));
        
        String l11 = r10;
        String r11 = XorBinary(l10,DES_function(r10, k11, ExpansionD_boxTable,StraightD_box));
        
        String l12 = r11;
        String r12 = XorBinary(l11,DES_function(r11, k12, ExpansionD_boxTable,StraightD_box));
        
        String l13 = r12;
        String r13 = XorBinary(l12,DES_function(r12, k13, ExpansionD_boxTable,StraightD_box));
        
        String l14 = r13;
        String r14 = XorBinary(l13,DES_function(r13, k14, ExpansionD_boxTable,StraightD_box));
        
        String l15 = r14;
        String r15 = XorBinary(l14,DES_function(r14, k15, ExpansionD_boxTable,StraightD_box));
        
        String l16 = r15;
        String r16 = XorBinary(l15,DES_function(r15, k16, ExpansionD_boxTable,StraightD_box));
        
        String finalPermutation = permutation(r16+l16,finalPermutationTableForMessage);
        //the following part is for DES function
        
        //the following part is for printing message
        System.out.println("plain text in hexa: "+plainTextInHexa);
        System.out.println("plain text in binary: "+plainTextInBinary);
        //System.out.println("plain text after first permutation: "+permutatedMessage+", In hexa: "+Long.toHexString(Long.parseLong(permutatedMessage,2)));
        System.out.println("plain text after first permutation: "+permutatedMessage+", length: "+new BigInteger(permutatedMessage,2).toString(16));
        
        System.out.println("l0: "+l0+", In hexa: "+Long.toHexString(Long.parseLong(l0,2)));
        System.out.println("r0: "+r0+", In hexa: "+Long.toHexString(Long.parseLong(r0,2)));
        
        System.out.println("l1: "+l1+", In hexa: "+Long.toHexString(Long.parseLong(l1,2)));
        System.out.println("r1: "+r1+", In hexa: "+Long.toHexString(Long.parseLong(r1,2)));
        
        System.out.println("l2: "+l2+", In hexa: "+Long.toHexString(Long.parseLong(l2,2)));
        System.out.println("r2: "+r2+", In hexa: "+Long.toHexString(Long.parseLong(r2,2)));
        
        System.out.println("l3: "+l3+", In hexa: "+Long.toHexString(Long.parseLong(l3,2)));
        System.out.println("r3: "+r3+", In hexa: "+Long.toHexString(Long.parseLong(r3,2)));
        
        System.out.println("l4: "+l4+", In hexa: "+Long.toHexString(Long.parseLong(l4,2)));
        System.out.println("r4: "+r4+", In hexa: "+Long.toHexString(Long.parseLong(r4,2)));
        
        System.out.println("l5: "+l5+", In hexa: "+Long.toHexString(Long.parseLong(l5,2)));
        System.out.println("r5: "+r5+", In hexa: "+Long.toHexString(Long.parseLong(r5,2)));
        
        System.out.println("l6: "+l6+", In hexa: "+Long.toHexString(Long.parseLong(l6,2)));
        System.out.println("r6: "+r6+", In hexa: "+Long.toHexString(Long.parseLong(r6,2)));
        
        System.out.println("l7: "+l7+", In hexa: "+Long.toHexString(Long.parseLong(l7,2)));
        System.out.println("r7: "+r7+", In hexa: "+Long.toHexString(Long.parseLong(r7,2)));
        
        System.out.println("l8: "+l8+", In hexa: "+Long.toHexString(Long.parseLong(l8,2)));
        System.out.println("r8: "+r8+", In hexa: "+Long.toHexString(Long.parseLong(r8,2)));
        
        System.out.println("l9: "+l9+", In hexa: "+Long.toHexString(Long.parseLong(l9,2)));
        System.out.println("r9: "+r9+", In hexa: "+Long.toHexString(Long.parseLong(r9,2)));
        
        System.out.println("l10: "+l10+", In hexa: "+Long.toHexString(Long.parseLong(l10,2)));
        System.out.println("r10: "+r10+", In hexa: "+Long.toHexString(Long.parseLong(r10,2)));
        
        System.out.println("l11: "+l11+", In hexa: "+Long.toHexString(Long.parseLong(l11,2)));
        System.out.println("r11: "+r11+", In hexa: "+Long.toHexString(Long.parseLong(r11,2)));
        
        System.out.println("l12: "+l12+", In hexa: "+Long.toHexString(Long.parseLong(l12,2)));
        System.out.println("r12: "+r12+", In hexa: "+Long.toHexString(Long.parseLong(r12,2)));
        
        System.out.println("l13: "+l13+", In hexa: "+Long.toHexString(Long.parseLong(l13,2)));
        System.out.println("r13: "+r13+", In hexa: "+Long.toHexString(Long.parseLong(r13,2)));
        
        System.out.println("l14: "+l14+", In hexa: "+Long.toHexString(Long.parseLong(l14,2)));
        System.out.println("r14: "+r14+", In hexa: "+Long.toHexString(Long.parseLong(r14,2)));
        
        System.out.println("l15: "+l15+", In hexa: "+Long.toHexString(Long.parseLong(l15,2)));
        System.out.println("r15: "+r15+", In hexa: "+Long.toHexString(Long.parseLong(r15,2)));
        
        System.out.println("l16: "+l16+", In hexa: "+Long.toHexString(Long.parseLong(l16,2)));
        System.out.println("r16: "+r16+", In hexa: "+Long.toHexString(Long.parseLong(r16,2)));
        
        System.out.println("Final permutation: "+finalPermutation+", in hexa: "+new BigInteger(finalPermutation,2).toString(16));
    }
    public static String DES_function (String bit32, String k, int [] ExpansionD_boxTable, int [] StraightD_box){
        String bit48 = permutation(bit32,ExpansionD_boxTable);
        String xor = XorBinary(bit48, k);
        String p1 = xor.substring(0,6), p2 = xor.substring(6,12);
        String p3 = xor.substring(12,18), p4 = xor.substring(18,24);
        String p5 = xor.substring(24,30), p6 = xor.substring(30,36);
        String p7 = xor.substring(36,42), p8 = xor.substring(42,48);
        
        String p1r = returnNumberFromS_box(p1,1);
        String p2r = returnNumberFromS_box(p2,2);
        String p3r = returnNumberFromS_box(p3,3);
        String p4r = returnNumberFromS_box(p4,4);
        String p5r = returnNumberFromS_box(p5,5);
        String p6r = returnNumberFromS_box(p6,6);
        String p7r = returnNumberFromS_box(p7,7);
        String p8r = returnNumberFromS_box(p8,8);
        String fin = p1r+p2r+p3r+p4r+p5r+p6r+p7r+p8r;
        return permutation(fin, StraightD_box);
    }
    public static String returnNumberFromS_box(String p, int s_boxNumber){
        int row = Integer.parseInt((char)p.charAt(0)+""+(char)p.charAt(5),2);
        int col = Integer.parseInt((char)p.charAt(1)+""+(char)p.charAt(2)+""+(char)p.charAt(3)+""+(char)p.charAt(4),2);
        
        int ans = 0;
        switch (s_boxNumber) {
            case 1:
                ans = s1[row][col];
                break;
            case 2:
                ans = s2[row][col];
                break;
            case 3:
                ans = s3[row][col];
                break;
            case 4:
                ans = s4[row][col];
                break;
            case 5:
                ans = s5[row][col];
                break;
            case 6:
                ans = s6[row][col];
                break;
            case 7:
                ans = s7[row][col];
                break;
            default:
                // Default case
                ans = s8[row][col];
                break;
        }
        String bin = Integer.toBinaryString(ans);
        //System.out.println("Row: "+row+", col: "+col+", index: "+s_boxNumber+", bin: "+bin+", ans: "+ans);
        while(bin.length()<4){
            bin = "0"+bin;
        }
        return bin;
    }
    public static String XorBinary(String x, String y){
        String result = "";
        while(x.length()<y.length()){
            x = "0"+x;
        }
        while(x.length()>y.length()){
            y = "0"+y;
        }
        for (int i = 0; i<x.length();i++){
            if (x.charAt(i) == y.charAt(i)){
                result+="0";
            }else{
                result+="1";
            }
            
        }
        return result;
    }
    public static String shiftingLeft (String binary, int shifts){
        if (shifts == 1){
            return binary.substring(1)+binary.charAt(0);
        }else {
            return binary.substring(2)+binary.charAt(0)+binary.charAt(1);
        }
            
    }
    public static String checkLengthOfBinary (String bin){
        while (bin.length()<64){
            bin = "0"+bin;
        }
        return bin;
    }
    public static String permutation (String binary, int [] s_box){
        char [] newString = new char [s_box.length];
        for (int i = 0; i < s_box.length;i++){
            newString[i] = binary.charAt(s_box[i]-1);
        }
        binary = "";
        for (int i = 0; i < newString.length; i++) {
            binary = binary+newString[i];
        }
        return binary;
    }
}
