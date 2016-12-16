package com.lits.kunderawrk;


import java.security.SecureRandom;
import java.math.BigInteger;


public final class IdGenerator {
  private SecureRandom random = new SecureRandom();

  public String nextSessionId() {
    return new BigInteger(130, random).toString(32).substring(0, 10);
  }
}