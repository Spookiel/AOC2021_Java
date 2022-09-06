
import java.sql.Array;
import java.util.*;
import java.lang.*;
import java.io.*;
import java.util.stream.*;

public class Day10 {

    ArrayList<String> lines = new ArrayList<>();
    ArrayList<String> valids = new ArrayList<>();
    ArrayList<Character> opens = new ArrayList<>();

    public void parse() throws IOException{

        BufferedReader br =  new BufferedReader(new FileReader("Day10.in"));

        String curline;
        while((curline = br.readLine()) != null){
            this.lines.add(curline);


        }



    }

    public void run1(){

        opens.add('(');
        opens.add('{');
        opens.add('[');
        opens.add('<');

        System.out.println((int) '}');
        System.out.println((int) '>');
        System.out.println((int) ')');
        System.out.println((int) ']');
        System.out.println((int) '{');
        System.out.println((int) '<');
        System.out.println((int) '(');
        System.out.println((int) '[');

        int t = 0;
        for(String line: lines){

            ArrayList<Character> q = new ArrayList<>();
            System.out.println(line);
            boolean flag = true;
            for(char c: line.toCharArray()){


                if(opens.contains(c)){
                    q.add(c);

                }else{

                    int conv = (int) c;
                    int check = (int) q.get(q.size()-1);

                    //System.out.println(c+ " "+ q.get(q.size()-1));
                    if(Math.abs(conv-check) > 2){
                        //System.out.println("INVALID ");

                        if(c == ')') t += 3;
                        if(c == '}') t += 1197;
                        if(c == ']') t += 57;
                        if(c == '>') t += 25137;
                        flag = false;
                    }

                    q.remove(q.size()-1);


                }


            }

            if(flag) valids.add(line);
        }

        System.out.println(t);



    }


    public void run2(){

        ArrayList<Long> scores = new ArrayList<>();

        for(String line: valids){

            System.out.println(line);

            long score = 0;
            ArrayList<Character> q = new ArrayList<>();

            for(char c: line.toCharArray()){

                if(opens.contains(c)){
                    q.add(c);
                }else{
                    q.remove(q.size()-1);


                }
            }

            System.out.println(q);
            Collections.reverse(q);
            for(char c2: q){
                if(c2 == '(') score = (score*5)+1;
                if(c2 == '[') score = (score*5)+2;
                if(c2 == '{') score = (score*5)+3;
                if(c2 == '<') score = (score*5)+4;

            }

            System.out.println(score);
            scores.add(score);





        }


        Collections.sort(scores);
        System.out.println(scores.get(scores.size()/2));


    }

    public static void main(String[] args) throws IOException{

        Day10 day = new Day10();
        day.parse();
        day.run1();
        day.run2();



    }
}
