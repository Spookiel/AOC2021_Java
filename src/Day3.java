
import java.util.*;
import java.io.*;
import java.lang.*;

public class Day3 {

    ArrayList<String> nums = new ArrayList<String>();
    ArrayList<String> gamma = new ArrayList<String>();
    ArrayList<String> epsilon = new ArrayList<String>();
    ArrayList<String> nums2 = new ArrayList<String>();


    public int[] get_vals(int pos, ArrayList<String> locnums){

        int[] res = new int[2];

        int ones = 0;
        int zeroes = 0;
        for(String s: locnums){
            if(s.charAt(pos) == '1'){
                ones++;
            }else{
                zeroes++;
            }

        }
        res[0] = zeroes;
        res[1] = ones;
        return res;


    }

    public void run1(){

        String gamma = "";


        for(int i=0; i < this.nums.get(0).length(); i++){

            int zeroes = this.get_vals(i, this.nums)[0];
            int ones = this.get_vals(i, this.nums)[1];

            if(ones >= zeroes){
                gamma += "1";
            } else{
                gamma += '0';
            }


        }

        System.out.println(gamma);

        String ep = this.gen_ep(gamma);

        int gam_int = Integer.parseInt(gamma, 2);
        int ep_int = Integer.parseInt(ep, 2);
        System.out.println(gam_int*ep_int);




    }

    public void run2(){
        // Need to duplicate the numbers first

        for(String s: this.nums) this.nums2.add(s);


        String o2 = reduce_arr(this.nums, true);
        String co2 = reduce_arr(this.nums2, false);

        int o2_int = Integer.parseInt(o2, 2);
        int co2_int = Integer.parseInt(co2, 2);
        System.out.println(o2_int*co2_int);
        // Need to call the reduce functions



    }

    public String reduce_arr(ArrayList<String> locnums, boolean flag){

        int cpos = 0;

        while(locnums.size() > 1){
            // Find which bits to remove
            char looking = '1';
            int ones = this.get_vals(cpos, locnums)[1];
            int zeroes = this.get_vals(cpos, locnums)[0];

            if(flag){
                if(ones >= zeroes){
                    looking = '1';
                }else{
                    looking = '0';
                }

            }else{
                if(zeroes > ones){
                    looking = '1';
                }else{
                    looking = '0';
                }
            }


            System.out.println(cpos + " "+looking);


            int spos = 0;
            while(spos < locnums.size()){

                if(locnums.get(spos).charAt(cpos) != looking){
                    locnums.remove(spos);

                }else{
                    spos++;
                }

            }

            cpos++;




        }

        System.out.println(locnums.get(0));
        return locnums.get(0);



    }



    public String gen_ep(String gamma){
        String ep = "";
        for(int i=0; i < gamma.length(); i++){

            if(gamma.charAt(i) == '1'){
                ep += '0';

            }else{
                ep += '1';
            }

        }
        return ep;


    }

    public void parse() throws IOException{


        BufferedReader br = new BufferedReader(new FileReader("Day3.in"));

        String curline;

        while( (curline = br.readLine()) != null){
            nums.add(curline);

        }

    }

    public static void main(String[] args) throws IOException{
        Day3 day = new Day3();

        day.parse();
        day.run1();
        day.run2();


    }
}
