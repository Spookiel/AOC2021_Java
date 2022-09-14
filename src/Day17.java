import java.io.BufferedReader;
import java.io.IOException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Arrays;

public class Day17 {


    int x1,x2, y1, y2;



    public void parse() throws IOException {

        BufferedReader br = new BufferedReader(new FileReader("Day17.in"));

        String curline = br.readLine();

        ArrayList<String> spl = new ArrayList<>(Arrays.stream(curline.split("=")).toList());

        String x = spl.get(1).split("[,]")[0];
        String y = spl.get(2);
        System.out.println(x);
        System.out.println(y);
        System.out.println(spl+ " "+ spl.size());



        x1 = Integer.parseInt(x.split("[.][.]")[0]);
        x2 = Integer.parseInt(x.split("[.][.]")[1]);
        y1 = Integer.parseInt(y.split("[.][.]")[0]);
        y2 = Integer.parseInt(y.split("[.][.]")[1]);


    }



    public ArrayList<Integer> sim(int xvel, int yvel){
        ArrayList<Integer> ret = new ArrayList<>();
        ret.add(0);
        ret.add(0);

        int xpos = 0;
        int ypos = 0;

        int mheight = -10000;

        while(ypos > y1){
            xpos += xvel;
            ypos += yvel;


            mheight = Math.max(mheight, ypos);
            if(xvel > 0) xvel--;

            yvel -= 1;

            if(check_in(xpos, ypos)) ret.set(0, 1);




        }

        ret.set(1, mheight);
        return ret;




    }



    public void run1(){


        int bheight = -1;

        for(int xvel=0; xvel < 50; xvel++){
            for(int yvel = -100; yvel < 250; yvel++){
                ArrayList<Integer> ans = sim(xvel, yvel);
                if(ans.get(0) == 1 && ans.get(1) > bheight){
                    bheight = ans.get(1);


                }


            }
        }

        System.out.println(bheight);



    }

    public void run2(){
        int tot = 0;

        for(int xvel=0; xvel < 500; xvel++){
            for(int yvel = -200; yvel < 250; yvel++){
                ArrayList<Integer> ans = sim(xvel, yvel);
                if(ans.get(0) == 1){
                    tot++;


                }


            }
        }

        System.out.println(tot);

    }
    public boolean check_in(int x, int y){

        return x1 <= x && x <= x2 && y1 <= y && y <= y2;
    }


    public static void main(String[] args) throws IOException{

        Day17 day = new Day17();
        day.parse();
        day.run1();
        day.run2();

    }

}
