

import java.io.*;
import java.util.*;
import java.lang.*;
public class Day18 {


    public class SnailFish{
        SnailFish lnum = null;
        SnailFish rnum = null;
        int lval;
        int rval;
        int depth;



        public SnailFish(ArrayList<Integer> lfish, ArrayList<Integer>  rfish, int recdepth){
            lnum = new SnailFish(lfish.get(0), lfish.get(1), recdepth+1);
            rnum = new SnailFish(rfish.get(0), rfish.get(1), recdepth+1);

            depth = recdepth;

        }

        public SnailFish( ArrayList<Integer> lfish, int rfish, int recdepth){

            rval = rfish;
            lnum = new SnailFish(lfish.get(0), lfish.get(1), recdepth+1);

            depth = recdepth;

        }
        public SnailFish(int lfish, ArrayList<Integer>  rfish, int recdepth){
            lval = lfish;
            rnum = new SnailFish(rfish.get(0), rfish.get(1), recdepth+1);

            depth = recdepth;
        }
        public SnailFish(int lfish, int rfish, int recdepth){
            lval = lfish;
            rval = rfish;


            depth = recdepth;


        }





    }





    public void parse() throws IOException{





    }





    public static void main(String[] args) throws IOException{

        List<Object> testsnail = Arrays.asList(Arrays.asList(1,2), 3, {1,2,3});

        System.out.println(testsnail);
        Day18 day = new Day18();



    }



}
