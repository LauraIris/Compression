package JPEG;

/**
 * Schritt 1: Transformation der Farbbilder in eine Darstellung mit Luminanz und Chrominanz.
 * <p>
 * JPEG ist optimiert hinsichtlich der Bildkompression für den Menschen. Zahlreiche Tests haben ergeben,
 * dass das menschliche Auge empfindlicher auf Helligkeitsunterschiede reagiert als auf farbliche Differenzen.
 * Also bietet sich an, die Farbinformation höher zu komprimieren als die Hellig- keitsinformation.
 * Dieser Schritt, also die Aufteilung eines Farbbildes in einen Teil Luminanz und einen Teil Chrominanz,
 * ist eine Vorbereitung für die eigentliche Kompression.
 * <p>
 * Y = Luminanz;
 * Cb = Chrominanz Blau
 * Cr = Chrominanz Rot
 * </p>
 */

public class A_colorConversionRGB {
    
    public void convertColorsToYCbCr(double red, double green, double blue) {
        // Y = Luminanz;
        // Cb = Chrominanz Blau
        // Cr = Chrominanz Rot
        double Y = (0 + 0.299 * red + 0.587 * green + 0.114 * blue);
        double Cb = (128 - 0.169 * red - 0.331 * green + 0.500 * blue);
        double Cr = (128 + 0.500 * red - 0.419 * green - 0.081 * blue);
        
        printColorConversionRGB(Y, Cb, Cr, red, green, blue);
    }
    
    public void calculateRGBcolorComponents(double Y, double Cb, double Cr) {
        double red = (1 * Y + 0 * Y + 1.402 * Y);
        double green = (1 * (Cb - 128) - 0.34414 * (Cb - 128) - 0.71414 * (Cb - 128));
        double blue = (1 * (Cr - 128) + 1.772 * (Cr - 128) + 0 * (Cr - 128));
        
        printColorConversionRGB(red, green, blue, Y, Cb, Cr);
        
    }
    
    public void printColorConversionRGB(double red, double green, double blue, double Y, double Cb, double Cr) {
        System.out.println("Step 1: Transformation der Farbbilder RGB in eine Darstellung mit Luminanz und Chrominanz\n");
        
        System.out.println("RGB components:");
        System.out.printf("%10s %6.2f \n", "Red =", red);
        System.out.printf("%10s %6.2f\n", "Green =", green);
        System.out.printf("%10s %6.2f\n\n", "Blue =", blue);
        System.out.println("Colors converted to Y, Cb & Cr:");
        System.out.printf("%10s %6.3f\n", "Y =", Math.round(Y * 10000.000) / 10000.000);
        System.out.printf("%10s %6.3f\n", "Cb =", Math.round(Cb * 10000.000) / 10000.000);
        System.out.printf("%10s %6.3f\n", "Cr =", Math.round(Cr * 10000.000) / 10000.000);
        
        System.out.println("_________________________________________________________________________________________________");
    }
}
