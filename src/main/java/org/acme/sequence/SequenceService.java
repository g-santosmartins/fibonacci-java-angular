package org.acme.sequence;

import java.util.HashMap;

import io.quarkus.cache.CacheResult;

public class SequenceService {

  @CacheResult(cacheName = "sequence-cache") 
  public Long produceSequence(int param) {
    long[] alticci = new long[param + 3];
    long[] resultArray = generateSequenceArray(alticci);
    return resultArray[param];
  }

  public long[] generateSequenceArray(long[] alticci) {
    alticci[1] = alticci[2] = 1;
    for (int i = 3; i < alticci.length; i++)
      alticci[i] = alticci[i - 3] + alticci[i - 2];
    return alticci;
  }

  // usecase
  public HashMap<String, Long> renderResultHashMap(int param) {
    long success = 1;
    long error = 0;
    HashMap<String, Long> resultJson = new HashMap<>();

    // Put the content into the hashmap
    if (param == 0L) {
      resultJson.put("result", 0L);
      resultJson.put("success", success);
      resultJson.put("error", error);
    }

    long result = new SequenceService().produceSequence(param);
    resultJson.put("result", result);
    resultJson.put("success", success);
    resultJson.put("error", error);
    return resultJson;
  }
}
