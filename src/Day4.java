

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
        boolean won = false;

        public Board(String [] init){


            System.out.println(Arrays.toString(init) + " IN CLASS");
            //String[] l = init[0].split(" ");
            //System.out.println(Arrays.toString(init[1].split(" ")));
            //System.out.println(Arrays.deepToString(l));
            for(int i=0; i < 5; i++){
                String[] spl = init[i].replace("  ", " ").split(" ");
                System.out.println(Arrays.toString(spl));


                System.out.println(Arrays.toString(spl));
                int read = 0;
                int cur = 0;
                while(read < 5){

                    if(spl[cur].equals("")){
                        cur++;
                        continue;
                    }


                    this.nums[i][read] = Integer.parseInt(spl[cur]);



                    read++;
                    cur++;
                }

            }

            System.out.println(Arrays.deepToString(this.nums));



        }

        public Board(){}

        public boolean check_rows(){

            for(int i=0; i < 5; i++){
                boolean ok = true;
                for(int j=0; j < 5; j++){
                    if(this.marked[i][j] == 0) ok = false;


                }

                if(ok) return true;


            }

            return false;
        }

        public boolean check_cols(){
            for(int i=0; i < 5; i++){
                boolean ok = true;
                for(int j=0; j < 5; j++){
                    if(this.marked[j][i] == 0) ok = false;

                }
                if(ok) return true;
            }
            return false;

        }


        public boolean check_diags(){

            // Top left to bottom right first

            boolean ok = true;
            for(int i=0; i < 5; i++){
                if(this.marked[i][i] == 0) ok = false;

            }

            if(ok) return true;

            boolean ok1 = true;
            for(int i=0; i < 5; i++){
                if(this.marked[4-i][i] == 0) ok1 = false;

            }
            return ok1;

        }

        public boolean check_won(){

            return this.check_cols() || this.check_rows();// || this.check_diags();


        }

        public void play_num(int num){

            for(int i=0; i < 5; i++){
                for(int j=0; j < 5; j++){

                    if(this.nums[i][j] == num) this.marked[i][j] = 1;

                }

            }




        }


        public int sum_unmarked(){
            int tsum = 0;
            for(int i=0; i < 5; i++) for(int j=0; j < 5; j++){
                if(this.marked[i][j] == 0) tsum += this.nums[i][j];


            }
            return tsum;
        }


    }

    public void parseBoard(String[] lines){

        this.boards.add(new Board(lines));

    }


    public void parse() throws IOException{
        BufferedReader br = new BufferedReader(new FileReader("Day4.in"));


        List<String> fline = Arrays.asList(br.readLine().split(","));


        List<Integer> flinenums = fline.stream().map(s -> Integer.valueOf(s)).toList();
        //int[] lst = fline.stream().map()

        System.out.println(flinenums);

        this.order = flinenums;

        String curline;
        while((curline = br.readLine())!= null){
            String[] inp = new String[5];
            for(int i=0; i < 5; i++) inp[i] = br.readLine();
            //System.out.println(Arrays.toString(inp)+" HERE");
            this.parseBoard(inp);



        }


    }

    public void run1() throws IOException{



        Board winner = new Board();

        int wnum = 1;
        boolean won = false;
        for(int to_play: this.order){
            for(Board b: this.boards){
                b.play_num(to_play);
                if(b.check_won()){
                    winner = b;
                    won = true;
                    wnum = to_play;
                    break;
                }



            }
            if(won) break;


        }

        System.out.println(won);
        System.out.println(Arrays.deepToString(winner.marked));
        System.out.println(Arrays.deepToString(winner.nums));
        System.out.println(winner.sum_unmarked()*wnum);




    }

    public void run2(){
        Board winner = new Board();
        int wnum = 1;
        boolean won = false;
        for(int to_play: this.order){
            for(Board b: this.boards){
                if(!b.won){
                    b.play_num(to_play);
                    if(b.check_won()){
                        b.won = true;
                        winner = b;
                        wnum = to_play;
                }

                }



            }


        }


        System.out.println(winner.sum_unmarked()*wnum);



    }

    public static void main(String[] args) throws IOException{
        Day4 day = new Day4();
        day.parse();
        day.run1();
        day.run2();

    }
}
