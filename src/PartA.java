import java.io.FileWriter;
import java.io.IOException;
import java.util.LinkedHashSet;
import java.util.Random;
import java.util.Set;
import java.util.ArrayList;
public class PartA {

    static ArrayList<ArrayList> DNA = new ArrayList<ArrayList>();
    static ArrayList<Integer> Fitness = new ArrayList<Integer>();

    public PartA()
    {

    }

    private static Random rand = new Random();


    public static void binarray() {
        ArrayList<Integer> DNAcode = new ArrayList<Integer>();
        ArrayList<Integer> Fitness = new ArrayList<Integer>();

        for (int i = 0; i < 4; i++) {
            DNAcode.add(getRandom(0, 1));
        }
        boolean result = mutate();

        if (result == true) {
            for (int i = 0; i < 4; i++) {
                if (DNAcode.get(i) == 1) {
                    DNAcode.set(i, 0);
                } else {
                    DNAcode.set(i, 1);
                }
            }
        } else {
            DNA.add(DNAcode);
//
            }
            for (int i = 0; i < DNA.size(); i++)
            {
                for (int j = 0; j < DNA.get(i).size(); j++) {
//
             //       One point crossover
                    if(( DNA.size() > 2) && ( j == 0));
                    {
                        if ((DNAcode.get(0) == DNA.get(i).get(j)) && DNAcode.get(0) == 1)
                        {
                            DNAcode.set(1, 1);
                        } else
                            {
                            DNAcode.set(1, 0);
                        }
                    }
                }
            }

        }


    public static boolean mutate()
    {
        boolean mutate = false;

        if (getRandom(0, 10) == 3)
        {
        mutate = true;
        }
        else{ mutate = false; }

        return mutate;
    }

    public static void fitnesscalc()
    {
        for (int i = 0; i < DNA.size(); i++)
        {
            int score = 0 ;

            for (int j = 0; j < DNA.get(i).size(); j++)
            {

                if( (int) DNA.get(i).get(j) == 1)
                {
                    score++;
                }

            }
            Fitness.add(score);
        }
    }

    public static int getRandom(int min, int max) {
        //System.out.println(rand.nextInt((max - min) + 1) + min);
        return rand.nextInt((max - min) + 1) + min;

    }

    public static void main(String[] args)
    {
        for (int i = 0; i < 2; i++)
        {
            binarray();
        }
        fitnesscalc();
        System.out.println(DNA);
        System.out.println(Fitness);
        
        try {
            FileWriter myWriter = new FileWriter("initial_pop_data.txt");
            myWriter.write(String.valueOf(Fitness));
            myWriter.close();
            System.out.println("Successfully wrote to the file.");
        } catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
    }
}
