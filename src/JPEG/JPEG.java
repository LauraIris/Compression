package JPEG;

public class JPEG {
    
    
    public static void main(String[] args) {
        JPEG jpeg=new JPEG();
        
        jpeg.step2();
        
        
    }
    
    public void step1(){
        //TODO: enter data for each RGBComponent
        // z.B. 30% = 0.3
        double red = 0.3;
        double green = 0.59;
        double blue = 0.11;
        A_colorConversionRGB a_colorConversionRGB=new A_colorConversionRGB();
        a_colorConversionRGB.convertColorsToYCbCr(red, green, blue);
    }
    
    
    public void step2(){
        B_downsamplingChromaData b_downsamplingChromaData=new B_downsamplingChromaData();
        
        /*TODO: Wähle Downsampling Variante
          Downsampling Varianten:
          1.   2:1 horizontal  und vertikal (2h2v oder 4:2:0)
          2.    2:1 horizontal  und 1:1 vertikal (2h1v oder 4:2:2)
         */
        b_downsamplingChromaData.chooseDownsamplingModel(1);
    
        b_downsamplingChromaData.setImagePixel(320);
        b_downsamplingChromaData.getDownsamplingChromaData();
    }
    
    public void step3(){
        
        //TODO: class UNFINISHED!!
        C_splitIntoBlocks_8x8pixel c_splitIntoBlocks_8x8pixel=new C_splitIntoBlocks_8x8pixel();
        
        int bytes=8;
        /*TODO: Wähle Downsampling Variante
          Downsampling Varianten:
          1.   8x8
          2.   3x3
         */
        String chooseBlock="8x8";
        c_splitIntoBlocks_8x8pixel.getBlock(chooseBlock, bytes);
    }
}
