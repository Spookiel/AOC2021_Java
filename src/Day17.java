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

    public boolean check_in(int x, int y){


    }


    public static void main(String[] args) throws IOException{

        Day17 day = new Day17();
        day.parse();


    }

}
