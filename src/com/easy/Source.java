package com.easy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;

import android.content.Context;

public class Source {

    @SuppressWarnings({ "finally" })
   public static String getSource(Context context) {
        String str="";
        try {
            InputStream is=context.getAssets().open("out.txt");
          //  InputStream is = dd.getInputStream();
            StringBuffer sb = new StringBuffer();   
         try {   
             BufferedReader br = new BufferedReader(new InputStreamReader(is, "utf-8"));   
                char buffer[] = new char[4096];   
                int len;   
                while((len = br.read(buffer)) > 0)    
                 sb.append(new String(buffer, 0, len));   
         } catch (UnsupportedEncodingException e1) {   
             e1.printStackTrace();   
         } catch (IOException e) {   
             e.printStackTrace();   
         }   
       str = sb.toString(); 



        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            //System.out.println(str);
        return str;
        }
    }
}
