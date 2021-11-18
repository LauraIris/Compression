package JPEG;

/**
 * Schritt 2: Downsampling der beiden Chrominanz-Komponenten
 * <p>
 * Bei diesem Schritt wird die Farbinformation komprimiert. Üblich sind Downsampling-Raten von:
 * - 2:1 horizontal  und vertikal (2h2v oder 4:2:0)
 * - 2:1 horizontal  und 1:1 vertikal (2h1v oder 4:2:2)
 * Ohne jegliche Kompression wird ein Bildausschnitt von 16 x 16 Bildpunkte betrachtet.
 * <p>
 * Y = Luminanz;
 * Cb = Chrominanz Blau
 * Cr = Chrominanz Rot
 * </p>
 */
public class B_downsamplingChromaData {
    //Bytes
    private double imagePixel;
    
    private String downsampingRateDescription;
    //Üblich sind zwei Downsampling-Raten:
    private int downsamplingModel;
    
    //Werte ohne Kompression
    private double woComp_brightness;
    private double woComp_chromaDataBlue;
    private double woComp_chromaDataRed;
    private double woComp_total;
    
    public void chooseDownsamplingModel(int downsamplingModel) {
        //TODO: Wähle downsampling variante
        this.downsamplingModel = downsamplingModel;
    }
    
    //Usually stays the same
    public void setImagePixel(double imagePixel) {
        //TODO: Wähle downsampling variante
        this.imagePixel = (imagePixel/2);
    }
    
    public void withoutAnyCompression() {
        woComp_brightness = (imagePixel * 2) * (imagePixel * 2); //(1/3)
        woComp_chromaDataBlue = (imagePixel * 2) * (imagePixel * 2); //(1/3)
        woComp_chromaDataRed = (imagePixel * 2) * (imagePixel * 2); //(1/3)
        
        woComp_total = woComp_brightness + woComp_chromaDataBlue + woComp_chromaDataRed; // = 758 Bytes -->(1/1)
    }
    
    //Variante 1: 2:1 horizontal und vertikal (2h2v oder 4:2:0)
    public void model1_2h2v_420() {
        String downsampingRateDescription = "2:1 horizontal und vertikal (2h2v oder 4:2:0)";
        
        double horizontal = 2 / 1;
        double vertical = 2 / 1;
        
        double imageSizeFactor = (1 / 3) + (2 / 3) * (1 / 4);
        
        // Y = Luminanz;
        // Cb = Chrominanz Blau
        // Cr = Chrominanz Rot
        
        double Y = (imagePixel * 2) * (imagePixel * 2); // (1/3)
        double Cb = (imagePixel * 1) * (imagePixel * 1); // (1/3) * (1/4)
        double Cr = (imagePixel * 1) * (imagePixel * 1); //(1/3) * (1/4)
        
        double total = Y + Cb + Cr; // = 383 Bytes -->(1/2)
        //Es werden 1/2 der Bytes vom Total ohne Kompression wird benötigt
        
        printDownsamplingChromaData(downsampingRateDescription, Y, imageSizeFactor, Cb, Cr, total);
    }
    
    public void model2_2h1v_422() {
        String downsampingRateDescription = "2:1 horizontal und 1:1 vertikal (2h1v oder 4:2:2)";
        
        double horizontal = 2 / 1;
        double vertical = 1 / 1;
        
        double imageSizeFactor = (1 / 3) + (2 / 3) * (1 / 2);
        
        double Y = (imagePixel * 2) * (imagePixel * 2); // (1/3)
        double Cb = (imagePixel * 1) * (imagePixel * 2); // (1/3) * (1/2)
        double Cr = (imagePixel * 1) * (imagePixel * 2); //(1/3) * (1/2)
        
        double total = Y + Cb + Cr; // = 512 Bytes -->(2/3)
        //Es werden 2/3 der Bytes vom Total ohne Kompression wird benötigt
        
        printDownsamplingChromaData(downsampingRateDescription, imageSizeFactor, Y, Cb, Cr, total);
    }
    
    public void printDownsamplingChromaData(String downsampingRateDescription, double imageSizeFactor, double Y, double Cb, double Cr, double total) {
        System.out.println("Bildgrösse ohne Kompression:    " + woComp_total + "  bytes\n");
        System.out.printf("%10s %6.3f\n", "Bildgrösse Faktor =", imageSizeFactor);
        System.out.println(downsampingRateDescription + ":");
        System.out.println("Colors converted to Y, Cb & Cr:");
        System.out.printf("%10s %6.3f\n", "Y =", Y);
        System.out.printf("%10s %6.3f\n", "Cb =", Cb);
        System.out.printf("%10s %6.3f\n", "Cr =", Cr);
        System.out.print("---------------------------------\n");
        System.out.printf("Bildgrösse mit Kompression: %6f  bytes\n", total);
        double factor = Math.round((total / woComp_total) * 100.00) / 100.00;
        System.out.printf(" --> %6.3f von %6.3f bytes\n", factor, woComp_total);
    }
    
    public void getDownsamplingChromaData() {
        System.out.println("Step 2: Downsampling der beiden Chrominanz-Komponenten\n");
        withoutAnyCompression();
        if (downsamplingModel == 1) {
            model1_2h2v_420();
        } else if (downsamplingModel == 2) {
            model2_2h1v_422();
        }
        System.out.println("_________________________________________________________________________________________________");
    }
    
}
