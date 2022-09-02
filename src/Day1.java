import java.util.ArrayList;

import java.util.*;
import java.lang.*;
import java.io.*;

public class Day1 {

    ArrayList<Integer> nums = new ArrayList<>();

    public void parse() throws IOException{

        BufferedReader br = new BufferedReader(new FileReader("Day1.in"));

        String curline;

        while((curline = br.readLine()) != null){
            nums.add(Integer.parseInt(curline));



        }


    }

    public void run1() throws IOException{

        int t=0;
        for(int i=1; i < this.nums.size(); i++){
            if(this.nums.get(i) > this.nums.get(i-1))t++;

        }
        System.out.println(t);



    }

    public void run2(){

        int t=0;
        int fsum = 0;
        for(int i=0; i < 3; i++) fsum += this.nums.get(0);
        for(int i=3; i < this.nums.size(); i++){
            int nsum = fsum+this.nums.get(i)-this.nums.get(i-3);
            if(nsum > fsum) t++;

        }

        System.out.println(t);


    }

    public static void main(String[] args) throws IOException{
        Day1 day = new Day1();
        day.parse();
        day.run1();
        day.run2();


    }
}
