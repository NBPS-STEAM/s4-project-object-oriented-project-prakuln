import java.util.*; // Import the java .util class to use the Scanner,
import java.util.concurrent.TimeUnit; //Import to be able to use the seconds.Sleep method
import java.io.*; // Import this class to handle errors

public class Questions{
  
  //Static variables of the class is made public so that it can be used from the test
    public static String questions[]; // Array of questions
    public static String answers[];  // Array of answers

  //This static method helps to read the QA file and put Q&A in static variables
    public static int ReadQA(String qafile)  throws IOException{
        int numberOfQA = 0; // Total number of questions

       //Reads the file 
        BufferedReader myfile = new BufferedReader(new FileReader(qafile));
        Scanner myReader = new Scanner(myfile);
        
       //Finds the number of questions
        numberOfQA = Integer.parseInt(myReader.nextLine());
       //allocate the array space based on number of questions
        questions = new String[numberOfQA];
        answers = new String[numberOfQA];
        
        int currentQA = 0;
        while (myReader.hasNextLine()) {
          //adds the question and answer in correct array
          questions[currentQA] = myReader.nextLine();
          answers[currentQA] = myReader.nextLine();
          currentQA++;
        }
      //closes the Scanner
      myReader.close();
      return numberOfQA;
   }
}