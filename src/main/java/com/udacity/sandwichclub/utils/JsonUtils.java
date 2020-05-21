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
    private static final String NAME = "name";
    private static final String MAIN_NAME = "mainName";
    private static final String IMAGE = "image";
    private static final String ALSO_KNOWN_AS = "alsoKnownAs";
    private static final String INGREDIENTS = "ingredients";
    private static final String ORIGIN = "placeOfOrigin";
    private static final String DESCRIPTION = "description";


    public static Sandwich parseSandwichJson(String json) {

        Sandwich sandwich = new Sandwich();

        try {
            JSONObject sandwichDetails = new JSONObject(json);

            JSONObject name = sandwichDetails.getJSONObject(NAME);
            String mainName = name.getString(MAIN_NAME);
            sandwich.setMainName(mainName);
            Log.i(TAG, sandwich.getMainName());

            String image = sandwichDetails.getString(IMAGE);
            sandwich.setImage(image);

            JSONArray jsonKnownAs = name.getJSONArray(ALSO_KNOWN_AS);
                List<String> alsoKnownAs = new ArrayList<>();
                for (int i = 0; i < jsonKnownAs.length(); i++) {
                    alsoKnownAs.add(jsonKnownAs.optString(i));
                    Log.i(TAG,jsonKnownAs.optString(i));
                }
                sandwich.setAlsoKnownAs(alsoKnownAs);

            JSONArray jsonIngredients = sandwichDetails.getJSONArray(INGREDIENTS);
                List<String> ingredients = new ArrayList<>();
                for (int i = 0; i < jsonIngredients.length(); i++) {
                    ingredients.add(jsonIngredients.optString(i));
                    Log.i(TAG,jsonIngredients.optString(i));
                }
                sandwich.setIngredients(ingredients);

            String placeOfOrigin = sandwichDetails.getString(ORIGIN);
            sandwich.setPlaceOfOrigin(placeOfOrigin);

            String description = sandwichDetails.getString(DESCRIPTION);
            sandwich.setDescription(description);

        } catch (JSONException e) {
            e.printStackTrace();
        }

        return sandwich;

    }
}
