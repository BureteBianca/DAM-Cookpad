package com.example.cookpad;

import android.util.Log;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

public class JSONReader {
    public void read(String urlpath, IResponse response){
        try {
            URL url=new URL(urlpath);
            HttpURLConnection connection= (HttpURLConnection) url.openConnection();
            InputStream input=connection.getInputStream();
            InputStreamReader inputReader=new InputStreamReader(input);
            BufferedReader reader=new BufferedReader(inputReader);

            StringBuilder result=new StringBuilder();
            String line="";
            String a="a"+"d";
            while((line=reader.readLine())!=null){
                result.append(line);
            }
            Log.v("resultat",result.toString());
            reader.close();
            inputReader.close();
            input.close();
            List<Model> list=parsare(result.toString());

            response.onSuccess(list);


        } catch (MalformedURLException e) {
            e.printStackTrace();
            response.onError(e.getMessage());
        } catch (IOException e) {
            e.printStackTrace();
            response.onError(e.getMessage());
        }



    }

    private List<Model> parsare(String jsonString)
    {
        List<Model> lst=new ArrayList<>();
        try
        {
            JSONObject jsonObject=new JSONObject(jsonString);
            JSONArray array=jsonObject.getJSONArray("Preparat");
            for(int i=0;i< array.length();i++)
            {
                JSONObject currentObject=array.getJSONObject(i);
                String num=currentObject.getString("nume");
                Model m1=new Model(num);
                lst.add(m1);
            }
        }
        catch (JSONException e)
        {
            e.printStackTrace();
        }
        return lst;
    }
}
