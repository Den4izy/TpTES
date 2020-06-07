package com.den4izy.tptes2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Scanner;

public class Logic {

    static URL url, url2;
    static BufferedReader in, in2 ;
    static String[] arr = new String[7];
    static int k;

    public static void create (){
        try {
            url = new URL("http://176.124.138.152/ot.cgi?t=&c=&s=Go&5=on");
            url2 = new URL("http://80.91.174.205:17813/Blocks/auto_5m_blocks_bal15.jsp");
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e){
            e.printStackTrace();
        }
    }
    public static String search(String string, int one, int two){
        String text = string.substring(one, two);
        return text;
    }

    static String search2(String string){

        String blocks = "";
        String[] isbnParts = string.split("class");
        String stroke = "";
        boolean b;
        boolean b2 = true;
        label: for(int i = 0; i < isbnParts.length; i++){
            b = isbnParts[i].contains("ТрТЭС");
            if ( b){
                for(int k = i;; k++){
                    stroke = stroke +isbnParts[k];

                    if(isbnParts[k].contains("КТЭЦ-5")){
                        //System.out.println(stroke);
                        break label;
                    }
                }


            }
        }
        isbnParts = stroke.split("rowspan=2 =");
        for(int i = 0; i < isbnParts.length; i++){
            if(isbnParts[i].split(">")[0].equals("nn")){
                //System.out.println(isbnParts[i].split("<")[0].substring(3));
                int number = i;
                blocks = blocks + "бл. " + i + " - "  + isbnParts[i].split("<")[0].substring(3) + "МВт." + "\n";

            }
        }
        return blocks ;
    }
    static String ht(){
        System.setProperty("console.encoding","Cp866");
        URL url;
        String inputLine;
        BufferedReader in;
        String result ="";
        {
            try {
                url = new URL("http://80.91.174.205:17813/Blocks/auto_5m_blocks_bal15.jsp");
                in = new BufferedReader(new InputStreamReader(url.openStream(), "Cp1251"));
                inputLine= in.readLine();

                while (inputLine!=null){

                    inputLine= in.readLine();
                    result = result + inputLine;
                }
            } catch (MalformedURLException e) {
                e.printStackTrace();
            } catch (IOException e){
                e.printStackTrace();
            }
        }
        return result;
    }
    public static String[] st()  {
        System.setProperty("console.encoding","Cp866");
        {
            try {
                in = new BufferedReader(new InputStreamReader(url.openStream(), "Cp1251"));
                in2 = new BufferedReader(new InputStreamReader(url2.openStream(), "Cp1251"));
            } catch (IOException e) {
                e.printStackTrace();
            }
            Scanner scanner = new Scanner(in);
                for(int i = 0; scanner.hasNext(); i++){
                    if( String.valueOf(scanner.next()).contains("миттєве")){
                        arr[0] = "rrr";
                        k = i;
                        if ( k != 0){
                            for (int l = 0; l<4; l++){
                                arr[0] = scanner.next();
                            }
                        }
                        if ( k != 0){
                            for (int l = 0; l<7; l++){
                                arr[1] = scanner.next();
                            }
                        }
                        break;
                    }
                }
            Scanner scanner1 = new Scanner(in2);
            arr[2] = String.valueOf(scanner1.next());
            for(int i = 0; scanner1.hasNext(); i++){
                if( String.valueOf(scanner1.next()).contains("ТрТЭС")){
                    for (int l = 0; l<2; l++){
                        arr[2] = scanner1.next();
                    }
                    break;
                }
            }

        }
        return arr;
    }
}
