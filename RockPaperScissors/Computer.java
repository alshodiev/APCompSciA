//Computer

public class Computer
{
 //instance member variables
   private String choice;
   
 public Computer()
 {
  //call random set Choice method--
  //this is a new idea!
  randomSetChoice();
 }
 
 public String getChoice()
 {
  return choice;
 }
 
 public void randomSetChoice()
 {
  //use Math.random() to produce 3 random choices 
  //rock,paper,scissor
  //make sure to spell correctly!
  //use if else
  int rps= (int)(Math.random()*3+1);
  if( rps==3)
  choice = "rock";
  else if(rps==2)
  choice ="paper";
  else if (rps==1)
  choice="scissor";
 } 
  
 /*
  didIWin(Player p) will return the following values
   0 - both players have the same choice
   1 - the computer had the higher ranking choice
   -1 - the player had the higher ranking choice
  */ 
 public int didIWin(Player p)
 {
   String plch = p.getChoice();
  return -1;  
 }
  public String toString()
  {
    
  }
     
}