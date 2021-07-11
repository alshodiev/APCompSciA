import java.util.*;

public class Main {
  
  private static TreeSet<Integer> set;
  
  public static void main(String[] args) {
    set = new TreeSet<Integer>();
    for(int x : sd)
      set.add(x);
      
    testIsSelfDivisor();
    System.out.println("Passed isSelfDivisor() tests!");
    
    for(int i = 0; i < 20; i++)
      testFirstNumSelfDivisors();
    System.out.println("Passed firstNumSelfDivisors() tests!");
    
    System.out.println("Passed All Tests!");
  }
  
  public static void testIsSelfDivisor() {
    
    int[] cases = {0, 5, 10, 104, (int)(Math.random()*1000), (int)(Math.random()*1000), (int)(Math.random()*1000), (int)(Math.random()*1000), (int)(Math.random()*1000), (int)(Math.random()*1000), (int)(Math.random()*1000), (int)(Math.random()*1000), (int)(Math.random()*1000), (int)(Math.random()*1000)};
    
    for(int n: cases) {
      try {
        
        boolean result = SelfDivisor.isSelfDivisor(n);
        if(result != set.contains(n)) {
          System.out.println("Result of calling isSelfDivisor(" + n + ") is wrong");
          System.exit(0);
        }
        
      }
      catch(Exception e) {
        System.out.println("Error calling isSelfDivisor(" + n + ")");
        System.exit(0);
      }
    }
    
  }
  
  public static void testFirstNumSelfDivisors() {
    int start = (int)(Math.random() * 100);
    int num = (int)(Math.random()*20) + 1;
    
    int[] goal = new int[num];
    
    int pos = 0;
    while(sd[pos] < start)
      pos++;
      
    int i = 0;
    while(i < num) {
      goal[i] = sd[pos];
      i++;
      pos++;
    }
    
    try {
      int[] result = SelfDivisor.firstNumSelfDivisors(start, num);
      
      if(goal.length != result.length) {
        System.out.println("Array returned by isSelfDivisor(" + start + ", " + num + ") is wrong length!");
        System.exit(0);
      }
      
      for(int k = 0; k < result.length; k++) {
        if(goal[k] != result[k]) {
          System.out.println("Array returned by isSelfDivisor(" + start + ", " + num + ") contains the wrong values!");
          System.exit(0);
        }
      }
      
    }
    catch(Exception e) {
      System.out.println("Error calling isSelfDivisor(" + start + ", " + num + ")");
      System.exit(0);
    }
  }
  
  //just test the self divisors less than 1000...
  private static int[] sd = {0,1,2,3,4,5,6,7,8,9,11,12,15,22,24,33,36,44,48,55,66,77,88,99,111,112,115,122,124,126,128,132,135,144,155,162,168,175,184,212,216,222,224,244,248,264,288,312,315,324,333,336,366,384,396,412,424,432,444,448,488,515,555,612,624,636,648,666,672,728,735,777,784,816,824,848,864,888,936,999};
}