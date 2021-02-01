import java.util.*; // Import the java .util class to use the Scanner,
import java.util.concurrent.TimeUnit; //Import to be able to use the seconds.Sleep method


/* guidlines:
 One main class (App) from which the program executes,
Two or more other classes,
Constructors with overloading,
Appropriate accessor & mutator methods,
Static variables & methods
Implement concepts of encapsulation and abstraction into the code
*/
public class App {
    
    //Main method that is called when the program starts
    public static void main(String[] args) throws java.io.IOException,InterruptedException {   
      //Calling static method of Questions class by passing Filename that contains questions and answers    
       int numberOfQuestion = Questions.ReadQA("qa.txt");

        //Calling RandomArray Class's static method GenerateRandomArray to generate static variables that can be used in Test class
        int[] randomNumbers = RandomArray.GenerateRandomArray(numberOfQuestion);

        //Test class has two constructors, I am calling default constructor as I would like to use the default values
        Test t= new Test();
        //Using mutator to set read time to 2 sec. Just for an example.
        t.setreadtime(2);
        //Using accesor to get read time and display.
        System.out.println("You are given " + t.getreadtime() + " seconds to read each question.");
        t.startTest(randomNumbers, numberOfQuestion);
        
    }
}
