package com.udacity.sandwichclub.model;

import java.util.Arrays;
import java.util.List;

import android.text.TextUtils;

public class Sandwich {

    private String mainName;
    private List<String> alsoKnownAs = null;
    private String placeOfOrigin;
    private String description;
    private String image;
    private List<String> ingredients = null;

    /**
     * No args constructor for use in serialization
     */
    public Sandwich() {
    }

    public Sandwich(String mainName, List<String> alsoKnownAs, String placeOfOrigin, String description, String image, List<String> ingredients) {
        this.mainName = mainName;
        this.alsoKnownAs = alsoKnownAs;
        this.placeOfOrigin = placeOfOrigin;
        this.description = description;
        this.image = image;
        this.ingredients = ingredients;
    }

    public String getMainName() {
        return mainName;
    }

    public void setMainName(String mainName) {
        this.mainName = mainName;
    }

    public List<String> getAlsoKnownAs() {
        return alsoKnownAs;
    }

    public void setAlsoKnownAs(List<String> alsoKnownAs) {
        this.alsoKnownAs = alsoKnownAs;
    }

    public String getPlaceOfOrigin() {
        if (placeOfOrigin.length()>1) {
            return placeOfOrigin;
        }
        return ("Unknown");
    }

    public void setPlaceOfOrigin(String placeOfOrigin) {
        this.placeOfOrigin = placeOfOrigin;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public List<String> getIngredients() {
        return ingredients;
    }

    public void setIngredients(List<String> ingredients) {
        this.ingredients = ingredients;
    }

    public String getIngredientsString() {

        if(ingredients.size()>0) {
            StringBuilder stringBuilder = new StringBuilder();
            int i = 0;
            for (String s : ingredients) {
                if(i<ingredients.size()-1) {
                    stringBuilder.append(s).append('\n');
                } else {
                    stringBuilder.append(s);
                } i=i+1;

            }
            return stringBuilder.toString();
            //return TextUtils.join(", ", ingredients);
        }
        return ("Ingredients unknown");
    }

    public String getKnownAsString() {

        if(alsoKnownAs.size()>0) {
            StringBuilder stringBuilder = new StringBuilder();
            for (String s : alsoKnownAs) {
                stringBuilder.append(s).append(", ");
            }
            return stringBuilder.deleteCharAt(stringBuilder.length() - 2).toString();
        }
        return ("No further known names");
    }

}
