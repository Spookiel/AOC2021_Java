
import java.util.*;
import java.lang.*;
import java.io.*;
public class Day7 {

    ArrayList<Integer> nums = new ArrayList<>();


    public void parse() throws IOException{

        BufferedReader br = new BufferedReader(new FileReader("Day7.in"));

        String fline = br.readLine();

        for(String s: fline.split(",")){
            nums.add(Integer.parseInt(s));

        }



    }

    public void run1(){
        System.out.println(nums.size());


        int bcost = 99999999;

        for(int position = 0; position < 1000; position++){

            int cost = 0;
            for(int num: this.nums) cost += Math.abs(num-position);

            if(cost < bcost) bcost = cost;

        }

        System.out.println(bcost);


    }


    public void run2(){
        int bcost = 99999999;

        for(int position = 0; position < 1000; position++){

            int cost = 0;
            for(int num: this.nums) cost += Math.abs(num-position)*0.5*(Math.abs(num-position)+1);

            if(cost < bcost) bcost = cost;

        }

        System.out.println(bcost);


    }





    public static void main(String[] args) throws IOException{

        Day7 day = new Day7();
        day.parse();
        day.run1();
        day.run2();


    }
}
