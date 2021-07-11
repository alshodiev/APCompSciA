public class SelfDivisor {

  public static boolean isSelfDivisor(int number) { 
    int temp = 0;
    int original = number; 
    //you need to save the original number to test if
    //each digit divides the original
    while(number > 0) {
      temp = number % 10;
     
     // if(number % temp != 0 && temp == 0 )
     if (temp ==0 || original % temp !=0 ) {
       // you have to switch the order b/c
       //%0 is lile a division by 0
          return false;
        }
      else {
        number = number/10;
      }
    }
    return true;
  }

  public static int[] firstNumSelfDivisors(int start, int num) {
      int[] tempArray = new int[num];
      int number = start;
      int countSD = 0;

    //  while(tempArray.length < 3) 
    // length is fixed and 3 is from example
     while (countSD < num) {
          if (isSelfDivisor(number) == true ) {
              //temp[] = temp[number]
              // you need an index
              // you want to store number because it // is a self divisor,
              // not an element in position number
              tempArray[countSD] = number;
              countSD++;
          }
            number++;
            //this has to be outside of the if statement
            //no matter what you need to test the next number, 
            //if a value isn;t a self divisor, you still need to progress to the next one
     }
    return tempArray; //I think this was inside of your loop
   }
  }
