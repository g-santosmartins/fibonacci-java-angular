package org.acme.sequence;

public class SequenceService {

  public Long produceSequence(int param) {
    long[] alticci = new long[param];
    long[] resultArray = arrayAlticitti(alticci);

    return  resultArray[param - 1];
    
}
public long[] arrayAlticitti (long[] alticci) {
        alticci[1] = alticci[2] = 1;
        for(int i = 3; i < alticci.length; i++)
           alticci[i] = alticci[i-3] + alticci[i-2];
        return alticci;
}
}
