package JPEG;

/**
 * Schritt 3: Pixel-Gruppierung der Farbkomponenten in 8x8 Blöcke
 * <p>
 * Hierbei wird die horizontale und vertikale Korrelation ausgenützt.
 * Die Blöcke werden separat komprimiert.
 * Dies stellt allerdings eine Schwachstelle des Verfahrens dar,
 * denn das Optimum liegt nicht zwingend bei einer Blockgrösse von 8x8 Pixels.
 * Diese Blockgrösse hat eher historischen Hintergrund und hat mit den Wortbreiten der Prozessoren zu tun,
 * die zur Zeit der Entwicklung von JPEG aktuell waren.
 * </p>
 */
public class C_splitIntoBlocks_8x8pixel {
    private double original_min;
    private double original_max;
    private double original_midpoint;
    
    public void setRange(int bytes){
        
        original_min=0;
        original_max=Math.pow(2,bytes)-1;
        original_midpoint=(original_max+1)/2;
        
    }
    
    public void set_8x8_Block(){
        double[][] blockValues = new double[8][8];
    
        //old Block
        double startingValue=52;
        System.out.println("(\n\nOriginal 8x8 Block) 2D-DCT:");
        for (int row = 0; row < blockValues.length; row++) {
            for (int col = 0; col < blockValues[row].length; col++) {
            blockValues[row][col]=Math.round(((startingValue)+1)); //idk how to do this
            }
        }
        printBlock(blockValues);
        System.out.printf("\nRange: %5.0f : %3.0f",original_min, original_max);
        
        //newBlock
        System.out.println("\n\n(Rekonstruierter Block) 2D-IDCT:");
        for (int row = 0; row < blockValues.length; row++) {
            for (int col = 0; col < blockValues[row].length; col++) {
                blockValues[row][col]=Math.round((blockValues[row][col]-original_midpoint));
            }
        }
        printBlock(blockValues);
        double new_min=original_min-original_midpoint+1;
        double new_max=new_min+original_midpoint;
        System.out.printf("\nRange: %5.0f : %3.0f",new_min, new_max);
    }
    
    
    public void printBlock(double [][] blockValues) {
        
  
        String line= "_____";
        //top
        System.out.print("_________________________________________________\n");
        for (int row = 0; row < blockValues.length; row++) {
            //middle
            System.out.printf("|%4s |%4s |%4s |%4s |%4s |%4s |%4s |%4s |\n", " "," ", " "," "," ", " "," "," ");
            System.out.print("|");
            for (int col = 0; col < blockValues[row].length; col++) {
                System.out.printf("%4.0f |", blockValues[row][col]);
            }
            //bottom
            System.out.printf("\n|%5s|%5s|%5s|%5s|%5s|%5s|%5s|%5s|\n", line, line, line, line,line, line,line,line);
        }
    }
    
    public void getBlock(String chooseBlock, int bytes){
        System.out.println("Step 3: Pixel-Gruppierung der Farbkomponenten in 8x8 Blöcke\n");
        setRange(bytes);
        if("8x8".equals(chooseBlock)){
            set_8x8_Block();
        }
        System.out.println("\n_________________________________________________________________________________________________");
    }
    
}
