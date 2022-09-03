
import java.util.*;
import java.io.*;
import java.lang.*;
public class Day8 {


    ArrayList<ArrayList<String>> left = new ArrayList<ArrayList<String>>();
    ArrayList<ArrayList<String>> right = new ArrayList<ArrayList<String>>();



    public void parse() throws IOException{

        BufferedReader br = new BufferedReader(new FileReader("Day8.in"));

        String curline;

        int cline = 0;

        while( (curline = br.readLine()) != null){
            String[] args = curline.split(" [|] ");
            System.out.println(Arrays.deepToString(args));
            ArrayList<String> words = new ArrayList<>();
            for(String s: args[0].split(" ")) words.add(s);

            this.left.add(words);

            ArrayList<String> out = new ArrayList<>();
            for(String s: args[1].split(" ")) out.add(s);

            this.right.add(out);


        }

    }


    public void run1(){

        System.out.println(Arrays.deepToString(this.right.toArray()));


        int[] count = new int[10];
        for(int i=0; i < this.right.size(); i++){

            ArrayList<String> digs = this.right.get(i);

            for(String dig: digs){
                if(dig.length() == 2) count[1]++;
                if(dig.length() == 3) count[7]++;
                if(dig.length() == 4) count[4]++;
                if(dig.length() == 7) count[8]++;

            }


        }

        System.out.println(count[1]+count[4]+count[7]+count[8]);

    }


    public String dif(String l1, String s1){
        String ret = "";

        for(char c: l1.toCharArray()){
            if(!s1.contains(Character.toString(c))) ret += c;
        }
        //System.out.println(ret+ " HERE");
        return ret;

    }

    public void run2(){
        //System.out.println(this.dif("abcd", "ab"));


        // Difference between 0 and 8 gives 3

        //segs[3] = (char) dif()


        // Do String 4 - String 1 to get segs 1, 3
        // From each string which is 6 letters, find the one which doesn't contain both of these
        // This is segment zero
        // Whichever string is 6 letters long and contains segs, 2, 5 is DIGIT 9, so other 6 letter String is DIGIT 6
        // String zero - (String Six - Segment 3) = Segment 2
        // Do difference between 0 and 8 to get segment 3
        // Do String four - String One - Middle segment to get segment 1
        //Do String seven - String One to get Segment 0
        // Do String eight - String 7 - Segment 1, 3, 4 to get segment 6
        // After this have 0,1,3,4,6, need 2 and 5
        // Find String which is 5 long (Digit 2) and has segment 4

        int tot = 0;

        for(int i=0; i < this.left.size(); i++){

            ArrayList<String> line = this.left.get(i);

            char[] segs = new char[7];
            String four = "";
            String one = "";
            String seven = "";
            String eight = "";
            ArrayList<String> sixes = new ArrayList<>();
            ArrayList<String> fives = new ArrayList<>();
            for(String dig: line) {
                if (dig.length() == 2) one = dig;
                if (dig.length() == 3) seven = dig;
                if (dig.length() == 4) four = dig;
                if(dig.length() == 5){
                    if(!fives.contains(dig)) fives.add(dig);
                }
                if(dig.length() == 6){
                    if(!sixes.contains(dig)) sixes.add(dig);
                }
                if (dig.length() == 7) eight = dig;
            }
            System.out.println("--------------");
            System.out.println(line);
            System.out.println(four+ " "+ one);
            System.out.println(fives);
            System.out.println(sixes);
            String segs_one_three = dif(four, one);
            System.out.println(segs_one_three+ " HERE");

            String zero = "";
            String six = "";
            String nine = "";
            for(String dig: sixes){
                //System.out.println(dig);
                //System.out.println(segs_one_three.substring(0,1)+ " "+dig.contains(segs_one_three.substring(0,1)));
                //System.out.println(segs_one_three.substring(1,2)+ " "+ dig.contains(segs_one_three.substring(1,2)));
                if(!dig.contains(segs_one_three.substring(0,1)) || !dig.contains(segs_one_three.substring(1,2))){
                    zero = dig;
                }else if(dig.contains(one.substring(0,1)) && dig.contains(one.substring(1,2))){
                    nine = dig;
                }else{
                    six = dig;
                }


            }
            System.out.println(zero + " "+ six + " "+ nine);
            segs[3] = dif(eight, zero).charAt(0);
            segs[1] = dif(segs_one_three, dif(eight, zero)).charAt(0);
            segs[2] = dif(nine, six).charAt(0);
            segs[5] = dif(one, Character.toString(segs[2])).charAt(0);
            segs[0] = dif(seven, one).charAt(0);
            segs[4] = dif(six, nine).charAt(0);
            segs[6] = dif(six, ""+segs[0]+segs[1]+segs[3]+segs[4]+segs[5]).charAt(0);

            System.out.println(segs);
            System.out.println(this.right.get(i));
            String ans = "";
            String five = ""+segs[0]+segs[1]+segs[3]+segs[5]+segs[6];
            String two = ""+segs[0]+segs[2]+segs[3]+segs[4]+segs[6];
            String three = ""+segs[0]+segs[2]+segs[3]+segs[5]+segs[6];

            ArrayList<String> decoded = new ArrayList<>();
            decoded.add(zero);
            decoded.add(one);
            decoded.add(two);
            decoded.add(three);
            decoded.add(four);
            decoded.add(five);
            decoded.add(six);
            decoded.add(seven);
            decoded.add(eight);
            decoded.add(nine);


            for(String s: this.right.get(i)){
                for(String pos: decoded){
                    if(match(pos, s)){
                        System.out.println("MATCH "+pos+ " "+s);
                        ans += Integer.toString(decoded.indexOf(pos));

                    }
                }


            }
            System.out.println(ans+ " HERE");
            tot += Integer.valueOf(ans);


        }

        System.out.println(tot);




    }

    public boolean match(String s1, String s2){
        int c = 0;
        if(s1.length() != s2.length()) return false;
        for(char ch: s1.toCharArray()){
            if(s2.contains(""+ch)) c++;

        }
        return c == s2.length();

    }


    public static void main(String[] args) throws IOException{
        Day8 day = new Day8();
        day.parse();
        day.run1();
        day.run2();

    }
}
