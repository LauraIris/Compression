package JPEG;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class D_DCT_1D_3Pixel {
    final int N;
    private Map<String, Integer> frequencies;
    private Map<String, Double> samplingPositions;
    private Map<String,List<Double>> buildingBlocks;
    private Map<String,Double> greyscales;
    
    //TODO: Add frequencies
    public D_DCT_1D_3Pixel() {
        N = 3;
    }
    
    public void setFrequencies() {
        for (int i = 0; i <= (N-1); i++) {
            frequencies.put("u" + i, i);
        }
    }
    
    public void setSamplingPositions() {
        for (int i = 0; i <= (N-1); i++) {
            double xn=(2*i+1)*Math.PI/(2*N);
            samplingPositions.put("x" + i,xn);
        }
    }
    
    public void setBuildingBlocksPositions() {
        for (int i = 0; i <= (N-1); i++) {
            List<Double> Bn=new ArrayList<>();
            for (int j = 0; j <= (N-1); j++) {
                Bn.add(Math.cos(j*samplingPositions.get("x"+j)));
            }
            buildingBlocks.put("B" + i,Bn);
        }
    }
    
    public void setGreyscales(){
        //Amplitudes / coefficients
        List<Double> alpha=buildingBlocks.get("B0");
        List<Double> beta=buildingBlocks.get("B1");
        List<Double> gamma=buildingBlocks.get("B3");
        
        System.out.println("alpha = "+alpha+"\n" +
                "beta = "+beta+"\n" +
                "gamma = "+gamma);
        
        for (int scale = 0; scale <= (N-1); scale++) {
            Double bi=alpha.get(0)+beta.get(0)+gamma.get(0);
            greyscales.put("bi"+scale, bi);
        }
    }
    
    
    
    
    
    
}
