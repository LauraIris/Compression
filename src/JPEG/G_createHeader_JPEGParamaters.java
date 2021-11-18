package JPEG;

/**
 * Schritt 7: Hinzufügen von Header und JPEG Parameter
 * <p>
 *     Es werden die folgenden Angaben mitgeliefert (vgl. [4]):
 *
 *     Offset   Grösse Bytes    Beschreibung
 *     0        2               JPEG Start of Image (SOI) Marker (FFD8H)
 *     2        2               Bildbreite in Pixel
 *     4        2               Bildhöhe in Pixel
 *     6        1               Anzahl Komponenten (1: Graustufenbild;  3: RGB-Bild)
 *     7        1               Horizontale/vertikale Downsampling-Rate für Komponente 1
 *     8        1               Downsampling-Rate für Komponente 2 (bei RGB-Bildern)
 *     9        1               Downsampling-Rate für Komponente 3 (bei RGB-Bildern)
 *
 *     Die Komponente 1 entspricht der Luminanz, die Komponenten 2 und der Chrominanz Blau CB und Chrominanz Rot CR.
 * </p>
 *
 */
public class G_createHeader_JPEGParamaters {



}
