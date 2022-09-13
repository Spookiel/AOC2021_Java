public class Day21 {



    int die = 1;
    int trolls = 0;


    long p1wins = 0;
    long p2wins = 0;
    public int roll(){
        trolls++;
        if(die == 100){
            die = 1;
            return 100;
        }
        die++;
        return die-1;


    }

    public int sim(int pos){

        pos += roll()+roll()+roll();
        while(pos > 10) pos -= 10;
        return pos;

    }



    public void rec(int score1, int score2, int pos1, int pos2, int turn){

        if(score1 >= 21){
            p1wins++;
            return;

        }
        if(score2 >= 21){
            p2wins++;
            return;
        }

        System.out.println(score1+" "+score2+" "+pos1+" "+ pos2);

        if(turn == 1){
            // Can roll either one two or three

            for(int pos = 1; pos <= 3; pos++){
                int npos = pos1+pos;
                if(npos > 10){
                    npos %= 10;
                }
                rec(score1+npos, score2, npos, pos2, 0);

            }



        }else{
            for(int pos = 1; pos <= 3; pos++){
                int npos = pos2+pos;
                if(npos > 10){
                    npos %= 10;
                }
                rec(score1, score2+npos, pos1, npos, 1);

            }


        }




    }



    public void run1(){

        //for(int i=0; i < 105; i++) System.out.println(roll());

        int p1 = 10;
        int p2 = 2;
        int s1 = 0;
        int s2 = 0;

        while(true){

            p1 = sim(p1);
            s1 += p1;

            if(s1 >= 1000) break;

            p2 = sim(p2);
            s2 += p2;
            //System.out.println(die);
            //System.out.println(p1+ " "+s1);
            //System.out.println(p2+ " "+s2);

            if(s2 >= 1000) break;

        }

        System.out.println(trolls*s1+ " "+ s1);
        System.out.println(trolls*s2+ " "+ s2);

    }


    public void run2(){

        rec(0,0, 4, 8, 1);
        System.out.println(p1wins+":"+p2wins);




    }

    public static void main(String[] args){

        Day21 day = new Day21();
        day.run1();
        day.run2();

    }
}
