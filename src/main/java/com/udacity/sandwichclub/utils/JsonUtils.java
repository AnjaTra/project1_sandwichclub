package com.udacity.sandwichclub.utils;

import android.util.Log;

import com.udacity.sandwichclub.model.Sandwich;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class JsonUtils {

    private static final String TAG = JsonUtils.class.getSimpleName();

    public static Sandwich parseSandwichJson(String json) {

        Sandwich sandwich = new Sandwich();

        try {
            JSONObject sandwichDetails = new JSONObject(json);

            JSONObject name = sandwichDetails.getJSONObject("name");
            String mainName = name.getString("mainName");
            sandwich.setMainName(mainName);
            Log.i(TAG, sandwich.getMainName());

            String image = sandwichDetails.getString("image");
            sandwich.setImage(image);

            JSONArray jsonKnownAs = name.getJSONArray("alsoKnownAs");
                List<String> alsoKnownAs = new ArrayList<>();
                for (int i = 0; i < jsonKnownAs.length(); i++) {
                    alsoKnownAs.add(jsonKnownAs.optString(i));
                    Log.i(TAG,jsonKnownAs.optString(i));
                }
                sandwich.setAlsoKnownAs(alsoKnownAs);

            JSONArray jsonIngredients = sandwichDetails.getJSONArray("ingredients");
                List<String> ingredients = new ArrayList<>();
                for (int i = 0; i < jsonIngredients.length(); i++) {
                    ingredients.add(jsonIngredients.optString(i));
                    Log.i(TAG,jsonIngredients.optString(i));
                }
                sandwich.setIngredients(ingredients);

            String placeOfOrigin = sandwichDetails.getString("placeOfOrigin");
            sandwich.setPlaceOfOrigin(placeOfOrigin);

            String description = sandwichDetails.getString("description");
            sandwich.setDescription(description);

        } catch (JSONException e) {
            e.printStackTrace();
        }

        return sandwich;

    }
}
