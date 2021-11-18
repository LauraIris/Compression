package Quellencodierung;

import java.util.List;
import java.util.ArrayList;

public class LZ77 {
    final int searchBuffer;
    final int previewBuffer;
    final int randomVarBitValue;
    final String sequenceX;
    
    public LZ77(){
        //TODO: enter code (symbol) sequence X[.]
        sequenceX="CCACBCCCBBCCBCCBCCAB";
        
        //TODO: enter Info
        searchBuffer=15;
        previewBuffer=8;
        
        //if given
        randomVarBitValue=8;
    }
}