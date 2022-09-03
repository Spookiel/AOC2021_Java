
import java.util.*;
import java.lang.*;
import java.io.*;
public class Day15 {


    int[][] grid;
    int[] XDIF = {0,1,0,-1};
    int[] YDIF = {1,0,-1,0};

    int width;
    int height;
    public void parse() throws IOException{

        BufferedReader br = new BufferedReader(new FileReader("Day15.in"));

        String curline;
        ArrayList<String> lines = new ArrayList<>();
        while( (curline = br.readLine()) != null){
            lines.add(curline);


        }

        height = lines.size();
        width = lines.get(0).length();
        grid = new int[height][width];

        for(int i=0; i < height; i++){
            for(int j = 0; j < width; j++) grid[i][j] = Integer.parseInt(lines.get(i).substring(j, j+1));



        }

        //print_grid();




    }
    public void print_grid(int[][] grid){

        for(int i=0; i < height; i++){
            for(int j=0; j < width; j++){
                System.out.print(grid[i][j]+ " ");
            }
            System.out.println();
        }

    }
    
    public void compute_grid(int[][] grid, int width, int height){
        // Target is height-1, width-1
        int[][] best = new int[height][width];


        for(int i=0; i < width; i++) for(int j=0; j < height; j++) best[j][i] = 999999;
        best[0][0] = 0;
        for(int i=1; i < width; i++)best[0][i] = best[0][i-1]+grid[0][i];
        for(int i=1; i < height; i++)best[i][0] = best[i-1][0]+grid[i][0];

        for(int m=0; m < 10; m++){
            for(int i=0; i < height; i++){
                for(int j=0; j < width; j++){
                    //System.out.println("----------");
                    //System.out.println(j+" "+i);
                    for(int k=0; k < 4; k++){
                        int nx = j+XDIF[k];
                        int ny = i+YDIF[k];
                        //System.out.println(nx+" "+ny);
                        if(0 < nx && nx < width && 0 < ny && ny < height){
                            best[ny][nx] = Math.min(best[ny][nx], best[i][j]+grid[ny][nx]);




                        }



                    }


                }
            }

        }




        //print_grid(best);
        System.out.println(best[height-1][width-1]);
        
    }
    public void run1(){

        this.compute_grid(grid, width, height);


    }

    public void run2(){

        // Try to duplicate the values ig
        int nwidth = width*5;
        int nheight = height*5;
        int[][] nums2 = new int[nheight][nwidth];
        int[][] best2 = new int[nheight][nwidth];

        for(int i=0; i < nheight; i++){
            for(int j=0; j < nwidth; j++){
                //System.out.println(height+ " "+ i+ " "+ i/height);
                int val =  (grid[i%height][j%width]+(i/height)+(j/width));
                if(val > 10){
                    val %= 10;
                    val++;
                }
                if(val == 10) val = 1;
                nums2[i][j] = val;

            }
        }

        //for(int[] arr: nums2) System.out.println(Arrays.toString(arr));

        this.compute_grid(nums2, nwidth, nheight);



    }

    public static void main(String[] args) throws IOException{
        Day15 day = new Day15();
        day.parse();
        day.run1();
        day.run2();


    }




}
