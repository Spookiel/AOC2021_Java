
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

import utils.Point2D;
public class Day5 {


    public static void main(String [] args) throws IOException {

        BufferedReader br = new BufferedReader(new FileReader("Day5.in"));
        StringTokenizer st;

        String currline;

        String delim = " -> ";

        int[][] grid = new int[1000][1000];


        int lnum = 0;

        while((currline = br.readLine()) != null){
            st = new StringTokenizer(currline, delim);

            int[] nums = new int[4];

            int ind=0;
            while(st.hasMoreElements()){
                String tok = st.nextToken();
                String [] toklst = tok.split(",");
                nums[ind] = Integer.parseInt(toklst[0]);
                nums[ind+1] = Integer.parseInt(toklst[1]);
                ind += 2;



            }
            System.out.println(Arrays.toString(nums));

            if(nums[0]==nums[2]){
                for(int y = Math.min(nums[1], nums[3]); y <= Math.max(nums[1], nums[3]); y++){
                    grid[y][nums[0]]++;


                }

            }else if(nums[1]==nums[3]){
                for(int x = Math.min(nums[0], nums[2]); x <= Math.max(nums[0], nums[2]); x++){
                    grid[nums[1]][x]++;


                }


            }else{
                int xdif = nums[2]-nums[0];
                int ydif = nums[3]-nums[1];

                xdif /= Math.abs(xdif);
                ydif /= Math.abs(ydif);
                System.out.println(xdif);
                while(nums[0]!=nums[2]){
                    grid[nums[1]][nums[0]]++;
                    nums[0] += xdif;
                    nums[1] += ydif;
                    //System.out.println(nums[0]+ " "+nums[2]);






                }
                grid[nums[1]][nums[0]]++;




            }



        }
        int count =0;
        for(int row=0; row < 1000; row++) for(int col=0; col < 1000; col++){
            if(grid[row][col] >= 2) count++;


        }
        System.out.println(count);











    }

}
