
import java.io.*;
import java.util.*;
import java.math.BigInteger;
import java.lang.*;

public class Day16 {

    ArrayList<String> inp = new ArrayList<>();
    int pointer = 0;
    int part1 = 0;
    public void parse() throws IOException{


        BufferedReader br = new BufferedReader(new FileReader("Day16.in"));

        String curline = br.readLine();
        String bin = new BigInteger(curline, 16).toString(2);
        System.out.println(bin);

        try{

            int fint = Integer.parseInt(Character.toString(curline.charAt(0)));
            System.out.println(fint);
            if(fint < 8) bin = "0"+bin;
            if(fint < 4) bin = "0"+bin;


        } catch(Exception e){
            System.out.println("FAILED");
        }

        System.out.println(bin);


        for(char c: bin.toCharArray()){
            this.inp.add(Character.toString(c));


        }


    }


    public String get_next(){
        String s = inp.get(pointer);
        pointer++;
        return s;
    }

    public String next_three(){

        return get_next()+get_next()+get_next();
    }

    public String next_five(){
        return next_three()+get_next()+get_next();
    }

    public long parse_next_packet(){
        String version = next_three();

        part1 += Integer.parseInt(version, 2);

        String TypeID = next_three();

        //System.out.println("FOUND PACKET "+Integer.parseInt(version, 2)+ " "+ Integer.parseInt(TypeID));

        if(TypeID.equals("100")){
            // Literal value
            // Return literal at the end
            String group = "";
            while(true){
                String ngroup = next_five();
                group += ngroup.substring(1);
                //System.out.println(ngroup);


                if(ngroup.charAt(0) == '0') break;


            }
            System.out.println(Long.parseLong(group, 2));

            return Long.parseLong(group, 2);

        }else{
            // Operator packet

            ArrayList<Long> subs = new ArrayList<>();
            char length_type = get_next().charAt(0);

            if(length_type == '0'){
                // Next 15 bits give total length in bits


                int tot_len = Integer.parseInt(next_five()+next_five()+next_five(), 2);

                //System.out.println(tot_len+ " FOUND LENGTH");

                int prev_pos = this.pointer;

                while(tot_len > 0){
                    subs.add(this.parse_next_packet());
                    tot_len -= (pointer-prev_pos);
                    prev_pos = pointer;

                }




            }else{
                // Next 11 bits
                String num_subpacks = next_five()+next_three()+next_three();
                int int_num_subpacks = Integer.parseInt(num_subpacks, 2);
                //System.out.println(int_num_subpacks+ " NUMBER OF SUBPACKETS");

                for(int i=0; i < int_num_subpacks; i++) subs.add(parse_next_packet());


            }



            int it = Integer.parseInt(TypeID);

            if(it == 0){
                long tot = 0;
                for(long add: subs) tot += add;
                return tot;

            }

            if(it == 1){
                long tot = 1;
                for(long add: subs) tot *= add;
                return tot;

            }

            if(it == 2){
                long tot = 0;
                for(long add: subs) tot = Math.min(add, tot);
                return tot;
            }

            if(it == 3){
                long tot = 0;
                for(long add: subs) tot = Math.max(add, tot);
                return tot;
            }

            if(it == 5){
                if(subs.get(0) > subs.get(1)){
                    return 1;
                }else{
                    return 0;
                }

            }

            if(it == 6){
                if(subs.get(0) < subs.get(1)){
                    return 1;
                }else{
                    return 0;
                }

            }

            if(it == 7){
                if(subs.get(0).equals(subs.get(1))){
                    return 1;
                }else{
                    return 0;
                }

            }






        }



    return 0;
    }

    public void run1(){

        //System.out.println(inp);

        parse_next_packet();

        System.out.println("PART 1: "+part1);

    }

    public void run2(){
        pointer = 0;
        System.out.println("PART 2: "+ parse_next_packet());

    }


    public static void main(String[] args) throws IOException{

        Day16 day = new Day16();
        day.parse();
        day.run1();
        day.run2();
        //System.out.println(Integer.parseInt("101", 2));


    }
}
