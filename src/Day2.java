
import java.util.*;
import java.io.*;
public class Day2 {

    ArrayList<String> insts = new ArrayList<String>();



    public Day2(){}



    public void parse() throws IOException{

        BufferedReader br = new BufferedReader(new FileReader("Day2.in"));

        String curline;
        while( (curline = br.readLine()) != null){

            this.insts.add(curline);


        }



    }

    public void run1(){



        int x = 0;
        int y=0;

        for(String s: this.insts){

            String[] spl = s.split(" ");

            System.out.println(Arrays.deepToString(spl));

            if(spl[0].charAt(0) == 'f'){
                x += Integer.parseInt(spl[1]);

            }else if(spl[0].charAt(0) == 'd'){
                y += Integer.parseInt(spl[1]);
            }else{
                y -= Integer.parseInt(spl[1]);
            }



        }
        System.out.println(x*y);

    }

    public void run2(){



        int x = 0;
        int y=0;
        int aim =0;

        for(String s: this.insts){

            String[] spl = s.split(" ");

            System.out.println(Arrays.deepToString(spl));

            if(spl[0].charAt(0) == 'f'){
                x += Integer.parseInt(spl[1]);
                y += Integer.parseInt(spl[1])*aim;

            }else if(spl[0].charAt(0) == 'd'){
                aim += Integer.parseInt(spl[1]);
            }else{
                aim -= Integer.parseInt(spl[1]);
            }



        }
        System.out.println(x*y);

    }





    public static void main(String[] args) throws IOException{
        Day2 day = new Day2();
        day.parse();
        day.run1();
        day.run2();


    }
}
