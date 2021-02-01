import java.util.*; // Import the java .util class to use the Scanner,
import java.util.concurrent.TimeUnit; //Import to be able to use the seconds.Sleep method

public class RandomArray{

//This method helps to generate random number and puts it in the array. So, questions ca be called based on random sequence.
//This is static method returning array of random numbers
  public static int[] GenerateRandomArray(int numberOfQA){
        //Allocate array space based on number of question
        int[] randomNumbers = new int[numberOfQA];
        //learned about this method at this link: https://stackoverflow.com/questions/4040001/creating-random-numbers-with-no-duplicates
        ArrayList<Integer> list = new ArrayList<Integer>(numberOfQA);
        //After this the Array list will havr number from 0 to 6 
        for(int i = 0; i < numberOfQA; i++) {
            list.add(i);
        }
        Random rand = new Random();
        int currentRandom = 0;
        while(list.size() > 0) {
            //It gets the random number based on size of the ArrayList 
            //size keeps on reducing as we remove a number 
            int index = rand.nextInt(list.size());
            //The next random number is the index of ArrayList that will be removed
            randomNumbers[currentRandom]=list.remove(index);
            //System.out.println(randomNumbers[currentRandom]);
            currentRandom++;
        }
        return randomNumbers;
   }

}