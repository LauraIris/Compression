package Quellencodierung;

import java.util.*;


public class LZW {
    private Map<String, Integer> dictionary = new HashMap<>();
    private List<String> output = new ArrayList<>();
    private int compressionSize= 0;
    //enter the number of symbols in base dictionary
    private int indexSize;
    final int dicBitSize;
    final int maxIndexSize;
    final String sequenceX;
    
    public LZW() {
        //TODO: enter Info
        //Code sequence X[.]
        sequenceX = "CCACBCCCBBCCBCCBCCAB";
        
        // current dictionnary size
        indexSize = 255;
        dicBitSize=8;
        
        // Dictionary (max) size
        maxIndexSize=511;
    }
    
    public static void main(String[] args) {
        LZW lzw=new LZW();
        lzw.printCompression();
    }
    
    public List<String> splitTextIntoSymbols() {
        List<String> sequenceList = new ArrayList<>();
        for (int i = 0; i < sequenceX.length(); i++) {
            char symbol = sequenceX.charAt(i);
            sequenceList.add(Character.toString(symbol));
        }
        System.out.println("sequence X[.] = " + sequenceList + "\n");
        return sequenceList;
    }
    
    public List<String> compressText() {
        List<String> sequenceList = new ArrayList<>(splitTextIntoSymbols());
        List<String> entryKeyList = new ArrayList<>();
        String w = "";
        
        for (String c : sequenceList) {
            String p = w + c;
            if (dictionary.containsKey(p) && indexSize <= maxIndexSize) {
                w = p;
            } else if (p.length() >= 2) {
                indexSize++;
                dictionary.put(p, indexSize);
                entryKeyList.add(p);
                if (dictionary.containsKey(w)) {
                    output.add(Integer.toString(dictionary.get(w)));
                } else {
                    output.add(w);
            
                }
                w = c;
            } else {
                w = c;
            }
        }
        if (!dictionary.containsKey(w)) {
            output.add(w);
        }
        return entryKeyList;
    }
    
    public int calcBitsPerToken(int index) {
        int bitSize = 0;
        int bit = 0;
        while (bitSize == 0 && bit<20){
            if (index < Math.pow(2,bit)) {
                bitSize = bit;
                compressionSize+=bitSize;
            }
        bit++;
    }
        return bitSize;
    }
    
    public void printCompression() {
        List<String> keyList = compressText();
        System.out.println("Encoded sequence:\n");
        
        //Table Header
        System.out.printf("%4s | %8s | %8s | %8s | %10s |\n", "Nr.", "Index","Eintrag", "Token", "[Bit]");
        System.out.printf("%4s | %8s | %8s | %8s | %10s |\n"," ", " "," ", "(Output)", " ");
        System.out.print("_____|__________|__________|__________|____________| \n");
        //Table body
        System.out.printf("%4s | %8s | %8s | %8c | %10s |\n"," ", "-","-", sequenceX.charAt(0), "-");
        for (int i = 0; i < keyList.size(); i++) {
            //I = Index, E= Dictionary Entry, T= Token (Output)
            System.out.printf("%4d.| %8s | %8s | %8s | %10d |\n",(i+1), dictionary.get(keyList.get(i)), keyList.get(i), output.get(i), calcBitsPerToken(dictionary.get(keyList.get(i))));
        }
        if (output.size() > keyList.size()) {
            System.out.printf("%4s | %8s | %8s | %8s | %10s |\n"," ", "-","-", output.get(keyList.size()), "-");
        }
        System.out.print("_____|__________|__________|__________|____________| \n");
       
       // Calculations
        System.out.println("\nNumber of Tokens = " + dictionary.size());
        System.out.println("Bit per Token = "+(compressionSize/ dictionary.size())+" [Bit]");
        System.out.println("Compression Size = " + compressionSize+ " [Bit]");
        double R=Math.round(((double) compressionSize/(dicBitSize*sequenceX.length()))*10000.0000)/10000.0000;
        System.out.println("Compression Rate R = "+(R*100)+"%");
        double spaceSaving=Math.round((1-R)*10000.0000)/10000.0000;
        System.out.println("Space Saving (1-R) = "+spaceSaving*100+"%");
    }
    
    
    
    
}
