
import java.util.*;
import java.io.*;

public class Day14 {

    public String start;
    public Map<String, String> rules = new HashMap<String, String>();
    public Map<Character, Integer> charCount = new HashMap<Character, Integer>();
    public Map<String, String> CACHE;

    public Day14(String fname) throws IOException{

        this.parseData(fname);

        this.run1();

    }

    public void run1(){


        Map<Character, Integer> scount = new HashMap<Character, Integer>();

        StringBuilder arr = new StringBuilder();

        for(char c: this.start.toCharArray()) scount.put(c, scount.getOrDefault(c, 0)+1);

        for(int step=0; step < 10; step++){

            arr.append(this.start.charAt(0));

            System.out.println(start.length());
            for(int i=1; i < this.start.length(); i++){
                String rule = Character.toString(arr.charAt(arr.length()-1)) + Character.toString(this.start.charAt(i));
                char nchar = this.rules.get(rule).charAt(0);
                arr.append(nchar);
                scount.put(nchar, scount.getOrDefault(nchar, 0)+1);
                arr.append(this.start.charAt(i));



            }

            this.start = arr.toString();

            arr.delete(0, arr.length());




        }

        System.out.println(scount);
        int maxVal = Collections.max(scount.values());
        int minVal = Collections.min(scount.values());
        System.out.println(maxVal+" "+minVal+" "+(maxVal-minVal));

    }

    public String encodeKey(char c1, char c2, int steps){

        return c1+c2+Integer.toString(steps);

    }

    public String encodeValue(Map<Character, Integer> charMap){


        for(char c: "ABCDEFGHIJKLMNOPQRSTUVWYXZ".toCharArray()){
            if(this.start.contains(Character.toString(c))){


            }


        }
        return "";
    }


    public void calc(char c1, char c2, int steps){
        if(steps==0){
            return;


        } else{
            return;
        }



    }


    public void run2(){

        for(int i=0; i < this.start.length(); i++){
            char c = this.start.charAt(i);




        }






    }


    public void parseData(String fname) throws IOException{

        BufferedReader br = new BufferedReader(new FileReader(fname));

        this.start = br.readLine();
        br.readLine();

        String curline;

        while( (curline = br.readLine())!=null){
            String left = curline.substring(0, 2);
            String right = Character.toString(curline.charAt(curline.length()-1));

            //System.out.println(left+":"+right);

            this.rules.put(left, right);




        }


    }




    public static void main(String[] args) throws IOException {


        Day14 day = new Day14("Day14.in");



    }
}
