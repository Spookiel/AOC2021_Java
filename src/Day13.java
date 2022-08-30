
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;
import utils.Point2D;

public class Day13 {


    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new FileReader("Day13.in"));
        StringTokenizer st;
        boolean flag = false;
        String currline;

        ArrayList<String> dirs = new ArrayList<String>();
        ArrayList<Integer> coords = new ArrayList<Integer>();


        ArrayList<Point2D> pointarr = new ArrayList<Point2D>();

        while((currline = br.readLine()) != null){

            if(currline.equals("") || flag){
                if(!flag){
                    flag = true;
                    continue;
                }
                //System.out.println("------");
                st = new StringTokenizer(currline, " ");

                //System.out.println(st.nextToken());
                //System.out.println(st.nextToken());
                st.nextToken();
                st.nextToken();
                String imp = st.nextToken();
                //System.out.println(imp);
                StringTokenizer st1 = new StringTokenizer(imp, "=");
                String dir = st1.nextToken();
                int coord = Integer.parseInt(st1.nextToken());


                coords.add(coord);
                dirs.add(dir);

            }else{
                st = new StringTokenizer(currline, ",");

                int fc = Integer.parseInt(st.nextToken());
                int sc = Integer.parseInt(st.nextToken());

                Point2D mp = new Point2D(fc, sc);
                pointarr.add(mp);



            }

        }

        System.out.println(dirs.size());
        for(int i=0; i < dirs.size(); i++){

            if(dirs.get(i).equals("x")){
                for(Point2D p: pointarr){
                    p.foldalong_x(coords.get(i), true);

                }


            }else{
                for(Point2D p: pointarr){
                    p.foldalong_y(coords.get(i), true);

                }


            }



        }

        int tpoints = pointarr.size();



        for(int i=0; i < pointarr.size(); i++) for(int j=i+1; j < pointarr.size(); j++){
            if(pointarr.get(i).x == pointarr.get(j).x && pointarr.get(i).y == pointarr.get(j).y){

                System.out.println("DUPLICATE FOUND "+ i + " " + j);
                tpoints--;
            }



        }

        System.out.println(tpoints);
        System.out.println(pointarr);

        char[][] grid = new char[1000][50];

        for(int i=0;i < 1000;i++) for(int j=0;j <50; j++) grid[i][j] = ' ';

        for(Point2D p: pointarr){
            grid[p.y][p.x] = '|';


        }

        for(int i=0;i < 1000;i++){
            for(int j=0;j <50; j++){
                if(grid[i][j] != ' '){
                    System.out.print("*");
                }else{
                    System.out.print(" ");
                }

            }
            System.out.println();
        }


        //Collections.sort(pointarr);
        //System.out.print(pointarr);
        //System.out.print(Arrays.deepToString(grid));



    }

}
