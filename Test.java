import java.util.*; // Import the java .util class to use the Scanner,
import java.util.concurrent.TimeUnit; //Import to be able to use the seconds.Sleep method
import java.io.*; // Import this class to handle errors

public class Test{
  //This private variable is encapsulated and correct answers can not be changed from outside
  private int correctanswers; // Keeps track of number of correct answers

  //These private variables are encapsulated and can be changed in constructor
  private double maxsecperQ; // Maximum seconds allocated for the first question
  private double readtime;  // Time allocated for reading the questions
  private double timeReduction; // Time reduction after every correct asnwers


  //Default constructor
  public Test(){
    correctanswers = 0; // Keeps track of number of correct answers
    maxsecperQ = 20; // Maximum seconds allocated for the first question
    readtime = 2;  // Time allocated for reading the questions
    timeReduction = 0.95; // Time reduction after every correct asnwers
  }

  //Overloading constructor
  public Test(double maxTimePerQ, double QReadTime, double timeReduct){
    maxsecperQ = maxTimePerQ; // Maximum seconds allocated for the first question
    readtime = QReadTime;  // Time allocated for reading the questions
    timeReduction = timeReduct; // Time reduction after every correct asnwers
  }

  public void startTest(int randomNumbers[], int numberOfQA) throws IOException, InterruptedException{
        Scanner in = new Scanner(System.in);

        //Ask if participant is ready
        String placeholder = "";
        System.out.println("You will be taking a test, you will start out with 20 seconds per question and it will get shorter as it goes on, please type: ready, when you are ready");
        while(!(placeholder.toLowerCase().equals("ready"))){
            placeholder = in.nextLine();
            if(!(placeholder.toLowerCase().equals("ready"))){
                System.out.println("Invalid Input, please type: ready, when you are ready");
            }
        }

        //Give 3 seconds to prepare
        System.out.println("3...");
        TimeUnit.SECONDS.sleep(1);
        //i learned about the Timeunit.sleep library and method at this URL: https://stackoverflow.com/questions/24104313/how-do-i-make-a-delay-in-java
        System.out.println("2...");
        TimeUnit.SECONDS.sleep(1);
        System.out.println("1...");
        TimeUnit.SECONDS.sleep(1);
        System.out.println("GO!!!");
        
        //Ask all the question based on the random sequence array
        for(int cq=0;cq<randomNumbers.length; cq++){
          System.out.println(Questions.questions[randomNumbers[cq]]);
          
          //Give 3 seconds to prepare
          for(int rtime=0; rtime<readtime; rtime++){
            TimeUnit.SECONDS.sleep(1);
          }

          //Record the start time in nano sec
          long startTime = System.nanoTime();
          System.out.println("Total points: "+ correctanswers +".  Answer in " + String.format("%.2f", maxsecperQ) +" sec: ");   
          String ans = in.nextLine();

          //Find out the difference in time by substrating recorded starting time and dividing by a billion
          long timeTakenToAnswer = (System.nanoTime() - startTime)/1000000000;
          System.out.println("your answer:     " + ans);
          System.out.println("expected answer: " + Questions.answers[randomNumbers[cq]]);
          
          //If answer is correct and if the time taken to answer is withint the allocated time give point
          if(ans.toLowerCase().equals(Questions.answers[randomNumbers[cq]].toLowerCase()) && (timeTakenToAnswer <= maxsecperQ)){
            correctanswers++;
          }
          //If the answer is correct but the answered time is more than allocated time do not give point
          else if(ans.toLowerCase().equals(Questions.answers[randomNumbers[cq]].toLowerCase()) && timeTakenToAnswer > maxsecperQ)
          {
             System.out.println("Time taken to answer: " + timeTakenToAnswer +" is greater than Time allocated: " + String.format("%.2f", maxsecperQ));
             break;
          }
          else{
            break;
          }
          //reduce the time for the next round
          maxsecperQ = (timeReduction * maxsecperQ);
        }

       //Show correct message based on the number of points 
        if(correctanswers == numberOfQA){
          System.out.println("\n\nThe score you got is:\t"+correctanswers+" points! Execellent job!");
        }
        else if(correctanswers > numberOfQA/2){
          System.out.println("\n\nThe score you got is:\t"+correctanswers+" points! Nice attempt!");
        }
        else{
          System.out.println("\n\nThe score you got is:\t"+correctanswers+" points! Better luck next time!");
        }
     in.close();
  }
  
}