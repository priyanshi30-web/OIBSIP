package com.example.quizzapp;

import android.content.Context;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.io.InputStream;
import java.lang.reflect.Type;
import java.util.ArrayList;

public class JsonUtils {

    public static ArrayList<Question> loadQuestions(Context context, String fileName) {

        try {

            InputStream is = context.getAssets().open(fileName);

            int size = is.available();

            byte[] buffer = new byte[size];

            is.read(buffer);

            is.close();

            String json = new String(buffer);

            Gson gson = new Gson();

            Type type = new TypeToken<ArrayList<Question>>(){}.getType();

            return gson.fromJson(json, type);

        } catch (Exception e) {

            e.printStackTrace();

            return new ArrayList<>();
        }
    }
}