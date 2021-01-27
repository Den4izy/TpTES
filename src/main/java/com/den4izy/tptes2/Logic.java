package com.den4izy.tptes2;

import android.util.Log;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Scanner;

public class Logic {

    static URL url2;
    static BufferedReader in2 ;
    static String[] arr = new String[7];
    static int k;

    public static void create (){
        try {
            url2 = new URL("http://80.91.174.205:17813/Blocks/auto_5m_blocks_bal15.jsp");
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e){
            e.printStackTrace();
        }
    }
    public static String search(String string, int one, int two){
        Log.d("hell",string);
        String text = string.substring(one, two);

        return text;
    }

    static String search2(String string){
        String a = "";
        String blocks = "";
        String[] isbnParts = string.split("class");
        String stroke = "";
        boolean b;
        boolean b2 = true;
        label: for(int i = 0; i < isbnParts.length; i++){
            b = isbnParts[i].contains("ТрТЕС");
            if ( b){
                for(int k = i;; k++){
                    stroke = stroke +isbnParts[k];

                    if(isbnParts[k].contains("КТЕЦ-5")){
                        //System.out.println(stroke);
                        break label;
                    }
                }

            //testing
            }
        }
        isbnParts = stroke.split("rowspan=2 =");
        for(int i = 0; i < isbnParts.length; i++){
            if(isbnParts[i].split(">")[0].equals("nn")){
                //System.out.println(isbnParts[i].split("<")[0].substring(3));
                //int number = i;
                blocks = blocks + "бл. " + i + " - "  + isbnParts[i].split("<")[0].substring(3) + "МВт." + "\n";



            }

        }
        for(int k = 0; k < isbnParts[4].split(">").length; k++){
            a = a + isbnParts[4].split(">")[k] + "\n";
            if(isbnParts[4].split(">")[k].equals("class=y")){

                blocks = blocks + "бл. " + 4 + " - "  + isbnParts[4].split(">")[k + 1] + "МВт." + "\n";
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

    public static String st()  {
        String str;
        System.setProperty("console.encoding","Cp866");
        {
            try {
                in2 = new BufferedReader(new InputStreamReader(url2.openStream(), "Cp1251"));
            } catch (IOException e) {
                e.printStackTrace();
            }
            Scanner scanner1 = new Scanner(in2);
            str = String.valueOf(scanner1.next());
            for(int i = 0; scanner1.hasNext(); i++){
               //Log.d("111", String.valueOf(scanner1.next()));
                if( String.valueOf(scanner1.next()).contains("ТрТЕС")){
                    for (int l = 0; l<2; l++){
                        str = scanner1.next();

                    }
                    break;
                }
            }

        }
        return str;
    }
}
