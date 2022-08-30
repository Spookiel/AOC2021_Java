
import java.lang.reflect.Array;
import java.nio.Buffer;
import java.util.*;
import java.lang.*;
import java.io.*;
import utils.Point2D;
public class Day9 {

        int width;
        int height;
        int[][] grid;

        final int[] XDIF = {1,0,-1,0};
        final int[] YDIF = {0,1,0,-1};

        ArrayList<Point2D> lowpoints = new ArrayList<Point2D>();

        public Day9(){




        }

        public void parse(String fname) throws IOException{

            BufferedReader br = new BufferedReader(new FileReader(fname));

            ArrayList<String> arr = new ArrayList<String>();

            String curline;

            while((curline = br.readLine()) != null){
                this.width = curline.length();
                arr.add(curline);



            }

            this.height = arr.size();

            this.grid = new int[this.height][this.width];


            for(int i=0; i < this.height; i++) for(int j=0; j < this.width; j++){

                this.grid[i][j] = Integer.parseInt(String.valueOf(arr.get(i).charAt(j)));




            }




        }

        public void run1(){

            int lows = 0;



            for(int i=0; i < this.height; i++) for(int j=0; j < width; j++){

                //System.out.println(this.grid[i][j]);
                boolean lower = true;
                for(int k=0; k < 4; k++){
                    int nx,ny;
                    nx = j+this.XDIF[k];
                    ny = i+this.YDIF[k];
                    if(0 <= nx && nx < this.width && 0 <= ny && ny < this.height){
                        if(this.grid[ny][nx] <= this.grid[i][j]) lower=false;

                    }



                }
                if(lower){
                    lows += this.grid[i][j]+1;
                    this.lowpoints.add(new Point2D(j, i));
                }





            }



            System.out.println(lows);
        }


        public ArrayList<Point2D> get_adj(Point2D p ){

            ArrayList<Point2D> ans = new ArrayList<Point2D>();

            for(int k=0; k < 4; k++){

                int nx,ny;
                nx = p.x+this.XDIF[k];
                ny = p.y+this.YDIF[k];

                if(0 <= nx && nx < this.width && 0 <= ny && ny < this.height){
                    ans.add(new Point2D(nx, ny));

                }


            }

            return ans;

            
        }

        public void run2(){
            // BFS from the low points


            //System.out.println(this.lowpoints.size());

            int[][] groups = new int[this.height][this.width];
            int[] gsizes = new int[1000];

            int cgroup = 0;

            for(Point2D p: this.lowpoints){
                System.out.println(p);
                cgroup++;
                gsizes[cgroup] = 1;
                groups[p.y][p.x] = cgroup;

                LinkedList<Point2D> queue = new LinkedList<Point2D>();

                queue.add(p);

                while(queue.size() > 0){

                    Point2D ne = queue.peek();
                    System.out.println(ne+ "HERE "+cgroup);

                    queue.remove();

                    for(Point2D adj: this.get_adj(ne)){
                        //System.out.println(adj+ "ADJ " + groups[adj.y][adj.x] + " " + groups[ne.y][ne.x]);
                        if(groups[adj.y][adj.x] == 0 && this.grid[adj.y][adj.x] > this.grid[ne.y][ne.x] && this.grid[adj.y][adj.x] < 9){
                            groups[adj.y][adj.x] = cgroup;
                            gsizes[cgroup]++;
                            //System.out.println("HERE2");
                            queue.add(adj);


                        }


                    }




                }






            }

            Arrays.sort(gsizes);

            int ans=1;

            for(int i=997; i < 1000; i++){
                System.out.println(gsizes[i]);
                ans *= gsizes[i];

            }

            System.out.println(ans);

        }


    public static void main(String[] args) throws  IOException{
        Day9 day = new Day9();
        day.parse("Day9.in");
        day.run1();
        day.run2();



    }


}
