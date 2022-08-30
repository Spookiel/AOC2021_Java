

import java.util.*;
import java.io.*;
import java.lang.*;
import java.util.stream.Collectors;

public class Day4 {

    List<Integer> order;
    ArrayList<Board> boards = new ArrayList<Board>();

    public class Board {

        int[][] nums = new int[5][5];
        int[][] marked = new int[5][5];


        public Board(String [] init){

            String[] l = init[0].split(" ");
            //System.out.println(Arrays.deepToString(l));
            for(int i=0; i < 5; i++) for(int j=0; j < 5; j++){
                if(!Objects.equals(l[j], "") && !Objects.equals(l[j], " ")){
                    this.nums[i][j] = Integer.parseInt(l[j]);

                }




            }

            System.out.println(Arrays.deepToString(this.nums));



        }

        public boolean check_rows(){

            for(int i=0; i < 5; i++){
                boolean ok = true;
                for(int j=0; j < 5; j++){
                    if(this.marked[i][j] == 0) ok = false;


                }

                if(!ok) return false;


            }

            return true;
        }

        public boolean check_cols(){
            for(int i=0; i < 5; i++){
                boolean ok = true;
                for(int j=0; j < 5; j++){
                    if(marked[j][i] == 0) ok = false;

                }
                if(!ok) return false;
            }
            return true;

        }


        public boolean check_diags(){

            // Top left to bottom right first

            boolean ok = true;
            for(int i=0; i < 5; i++){
                if(marked[i][i] == 0) ok = false;

            }

            if(!ok) return false;

            boolean ok1 = true;
            for(int i=0; i < 5; i++){
                if(marked[4-i][i] == 0) ok1 = false;

            }
            return ok1;

        }

        public boolean check_won(){

            return this.check_cols() || this.check_rows() || this.check_diags();


        }

        public void play_num(int num){

            for(int i=0; i < 5; i++){
                for(int j=0; j < 5; j++){

                    if(this.nums[i][j] == num) marked[i][j] = 1;

                }

            }




        }


    }

    public void parseBoard(String[] lines){

        this.boards.add(new Board(lines));

    }
    public void run1() throws IOException{

        BufferedReader br = new BufferedReader(new FileReader("Day4.in"));


        List<String> fline = Arrays.asList(br.readLine().split(","));


        List<Integer> flinenums = fline.stream().map(s -> Integer.valueOf(s)).toList();
        //int[] lst = fline.stream().map()

        System.out.println(flinenums);

        this.order = flinenums;

        String curline;
        while((curline = br.readLine())!= null){
            br.readLine();
            String[] inp = new String[5];
            for(int i=0; i < 5; i++) inp[i] = br.readLine();

            this.parseBoard(inp);



        }


    }

    public static void main(String[] args) throws IOException{
        Day4 day = new Day4();

        day.run1();

    }
}
