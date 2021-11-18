package JPEG;

/**
 * Schritt 6: Entropiecodierung der quantisierten Frequenzkomponenten
 * <p>
 *     Hier erfolgt eine Entropiecodierung der Werte, die erhalten bleiben.
 *     Dazu ist zu bemerken: Eine Entropiecodierung kann immer versucht werden.
 *     Sie ist dann aussichtsreich, falls die Werte nicht die gleiche Häufigkeit haben.
 *     Die Entropiecodierung ist immer verlustlos;
 *     dieser Teil in der ganzen Kette der Aktivitäten bewirkt also keinerlei Verlust von Information.
 *     Als sinnvolle Verfahren der Entropiecodierung innerhalb JPEG haben sich die Lauflängencodierung und
 *     die Huffmancodierung bewährt.
 *     Es wird eine Kombination beider Verfahren angewandt.
 * </p>
 */
public class F_entropyQuantisizedAmplitudes {
}
