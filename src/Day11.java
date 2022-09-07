
import java.util.*;
import java.io.*;
import java.lang.*;

public class Day11 {


    int[][] grid;
    int width;
    int height;

    int[] ADJX = {0, 0,1, 1,1,-1,-1,-1};
    int[] ADJY = {1,-1,1,-1,0, 1,-1, 0};


    public void parse() throws IOException{

        BufferedReader br = new BufferedReader(new FileReader("Day11.in"));

        ArrayList<String> lines = new ArrayList<>(br.lines().toList());
        width = lines.get(0).length();
        height = lines.size();
        grid = new int[height][width];


        for(int i=0; i < lines.size(); i++){
            for(int j=0; j < width; j++){
                grid[i][j] = Integer.parseInt(Character.toString(lines.get(i).charAt(j)));

            }


        }

        System.out.println(Arrays.deepToString(grid));




    }


    public void run1(){

        int total = 0;
        for(int turn = 0; turn < 100; turn++){
            total += step();
            for(int row = 0; row < 10; row++) System.out.println(Arrays.toString(grid[row]));
            System.out.println("-----------");


        }

        System.out.println(total);

    }


    public int conv_to_int(int row, int col){
        return (row*10)+col;

    }
    public int[] conv_to_coords(int c){
        int[] ret = new int[2];
        ret[0]  = c%10;
        ret[1] = c/10;
        return ret;

    }
    public int step(){

        int[][] flashed = new int[10][10];

        int count = 0;
        //System.out.println(Arrays.deepToString(flashed));


        ArrayList<Integer> q = new ArrayList<>();

        for(int i=0; i < 10; i++)for(int j=0; j < 10; j++){
            grid[i][j]++;
            if(grid[i][j] > 9) q.add(conv_to_int(i,j));

        }

        while(!q.isEmpty()){
            int ne = q.remove(0);
            int nx = conv_to_coords(ne)[0];
            int ny = conv_to_coords(ne)[1];

            if(flashed[ny][nx] == 1) continue;
            count++;
            flashed[ny][nx] = 1;
            for(int adj=0; adj < 8; adj++){
                int dy = ADJY[adj];
                int dx = ADJX[adj];

                int nnx = nx+dx;
                int nny = ny+dy;

                if(0 <= nnx && nnx < width && 0 <= nny && nny < height){
                    grid[nny][nnx]++;
                    if(flashed[nny][nnx] == 0 && grid[nny][nnx] > 9) q.add(conv_to_int(nny, nnx));

                }


            }




        }



        for(int i=0; i <10; i++)for(int j=0; j < 10; j++){
            if(flashed[i][j] == 1) grid[i][j] = 0;


        }
        System.out.println(count);
        return count;



    }


    public void run2(){


        int turn = 0;

        while(true){
            int flashes = step();
            turn++;
            if(flashes == 100){
                System.out.println(turn);

                break;
            }

        }




    }


    public static void main(String[] args) throws IOException{

        Day11 day = new Day11();
        day.parse();
        //day.run1();
        day.run2();





    }
}
