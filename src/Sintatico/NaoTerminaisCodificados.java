
import java.util.HashMap;
import java.util.Map;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/*package Sintatico;

import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author WorkSpace
 
public class NaoTerminaisCodificados {
    
    private Map<Integer, String[]> nTerminais = new HashMap<Integer, String[]>();
    
     public NaoTerminaisCodificados() {
        //nTerminais.put(49 , new String[]{"var"});
        nTerminais.put(2 , new String[]{"7","52","38","53","37","54"});
        nTerminais.put(3 , new String[]{"15"});
        nTerminais.put(4 , new String[]{"15"});
        nTerminais.put(5 , new String[]{"40","7","52"});
        nTerminais.put(6 , new String[]{"12"});
        nTerminais.put(7 , new String[]{"17"});
        nTerminais.put(8 , new String[]{"3"});
        nTerminais.put(9 , new String[]{"23"});
        nTerminais.put(10, new String[]{"15"});
        nTerminais.put(11, new String[]{"55","38","53","37","54"});
        nTerminais.put(12, new String[]{"7","52"});
        nTerminais.put(13, new String[]{"56","7","57","36","49","50","51","4","43","58","42","35","50"});
        nTerminais.put(14, new String[]{"12"});
        nTerminais.put(15, new String[]{"2"});
        nTerminais.put(16, new String[]{"23"});
        nTerminais.put(17, new String[]{"17"});
        nTerminais.put(18, new String[]{"3"});
        nTerminais.put(19, new String[]{"15"});
        nTerminais.put(20, new String[]{"5"});
        nTerminais.put(21, new String[]{"6"});
        nTerminais.put(22, new String[]{"7"});
        nTerminais.put(23, new String[]{"8"});
        nTerminais.put(24, new String[]{"9"});
        nTerminais.put(25, new String[]{"15"});
        nTerminais.put(26, new String[]{"15"});
        nTerminais.put(27, new String[]{"43","59","42"});
        nTerminais.put(28, new String[]{"53","60"});
        nTerminais.put(29, new String[]{"37","53","60"});
        nTerminais.put(30, new String[]{"15"});
        nTerminais.put(31, new String[]{"15","61","37","62","18"});
        nTerminais.put(32, new String[]{"15"});
        nTerminais.put(33, new String[]{"61","37","62"});
        nTerminais.put(34, new String[]{"7","29","63"});
        nTerminais.put(35, new String[]{"9","29","63"});
        nTerminais.put(36, new String[]{"8","29","63"});
        nTerminais.put(37, new String[]{"63","29","63"});
        nTerminais.put(38, new String[]{"15"});
        nTerminais.put(39, new String[]{"24","7","64"});
        nTerminais.put(40, new String[]{"15"});
        nTerminais.put(41, new String[]{"43","65","66","42"});
        nTerminais.put(42, new String[]{"15"});
        nTerminais.put(43, new String[]{"40","65","66"});
        nTerminais.put(44, new String[]{"5"});
        nTerminais.put(45, new String[]{"9"});
        nTerminais.put(46, new String[]{"6"});
        nTerminais.put(47, new String[]{"8"});
        nTerminais.put(48, new String[]{"7"});
        nTerminais.put(49, new String[]{"14","43","7","102","67","42","36","61","37","62","35","68"});
        nTerminais.put(50, new String[]{"19","36","61","37","62","35"});
        nTerminais.put(51, new String[]{"15"});
        nTerminais.put(52, new String[]{"1","43","7","67","42","36","61","37","62","35"});
        nTerminais.put(53, new String[]{"28","69"});
        nTerminais.put(54, new String[]{"45","69"});
        nTerminais.put(55, new String[]{"27","69"});
        nTerminais.put(56, new String[]{"26","69"});
        nTerminais.put(57, new String[]{"32","69"});
        nTerminais.put(58, new String[]{"30","69"});
        nTerminais.put(59, new String[]{"5"});
        nTerminais.put(60, new String[]{"6"});
        nTerminais.put(61, new String[]{"9"});
        nTerminais.put(62, new String[]{"8"});
        nTerminais.put(63, new String[]{"7"});
        nTerminais.put(64, new String[]{"16","43","7","29","69","37","7","67","37","70","42","36","61","37","62","35"});
        nTerminais.put(65, new String[]{"33","5"});
        nTerminais.put(66, new String[]{"46","5"});
        nTerminais.put(67, new String[]{"20","36","61","37","62","35","1","43","7","67","42"});
        nTerminais.put(68, new String[]{"22","25","7"});
        nTerminais.put(69, new String[]{"21","31","11","71"});
        nTerminais.put(70, new String[]{"15"});
        nTerminais.put(71, new String[]{"31","7","72","71"});
        nTerminais.put(72, new String[]{"31","11","71"});
        nTerminais.put(73, new String[]{"15"});
        nTerminais.put(74, new String[]{"40","7","72"});
        nTerminais.put(75, new String[]{"73","74"});
        nTerminais.put(76, new String[]{"24","7","64"});
        nTerminais.put(77, new String[]{"34","73","74"});
        nTerminais.put(78, new String[]{"47","73","74"});
        nTerminais.put(79, new String[]{"15"});
        nTerminais.put(80, new String[]{"75","76"});
        nTerminais.put(81, new String[]{"15"});
        nTerminais.put(82, new String[]{"41","75","76"});
        nTerminais.put(83, new String[]{"39","75","76"});
        nTerminais.put(84, new String[]{"5"});
        nTerminais.put(85, new String[]{"6"});
        nTerminais.put(86, new String[]{"7"});
        nTerminais.put(87, new String[]{"9","110"});
        nTerminais.put(88, new String[]{"8"});
        nTerminais.put(89, new String[]{"43","63","42"});
    } 
    public String[] getGramatica(int regra){
         return nTerminais.get(regra);
    }
}
*/