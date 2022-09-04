
import java.sql.Array;
import java.util.*;
import java.lang.*;
import java.io.*;
import java.util.stream.*;
public class Day6 {


    ArrayList<Integer> nums = new ArrayList<>();


    public void parse() throws IOException{

        BufferedReader br = new BufferedReader(new FileReader("Day6.in"));
        String curline = br.readLine();

        for(String s: curline.split(",")){
            nums.add(Integer.parseInt(s));


        }

        System.out.println(nums);


    }

    public void run1(){


        for(int step=0; step < 80; step++){
            ArrayList<Integer> to_add = new ArrayList<>();

            for(int i = 0; i < nums.size(); i++){

                if(nums.get(i) == 0){
                    nums.set(i, 7);
                    to_add.add(8);

                }

                nums.set(i, nums.get(i)-1);



            }
            for(int j: to_add) nums.add(j);
            //System.out.println(nums);



        }
        System.out.println(nums.size());




    }

    public void run2(){
        long[] fish = new long[9];
        Arrays.fill(fish, 0);
        for(int i: nums) fish[i]++;

        System.out.println(Arrays.toString(fish));

        for(int step=0; step < 256; step++){

            long nfish = fish[0];


            for(int i=0; i < 8; i++) fish[i] = fish[i+1];
            fish[8] = nfish;
            fish[6] += nfish;




        }

        System.out.println(Arrays.toString(fish));
        System.out.println(LongStream.of(fish).sum());




    }

    public static void main(String[] args) throws IOException{
        Day6 day = new Day6();
        day.parse();
        //day.run1();
        day.run2();





    }
}
