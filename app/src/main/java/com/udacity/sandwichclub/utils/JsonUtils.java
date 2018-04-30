package com.udacity.sandwichclub.utils;

import com.udacity.sandwichclub.model.Sandwich;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class JsonUtils {
    private static final String NAME = "name";
    private static final String MAINNAME = "mainName";
    private static final String ALSOKNOWNAS = "alsoKnownAs";
    private static final String PLACEOFORIGIN = "placeOfOrigin";
    private static final String DESCRIPTION = "description";
    private static final String INGREDIENTS = "ingredients";
    private static final String IMAGE = "image";



    public static Sandwich parseSandwichJson(String json) {
        String description = "";
        String name = "";
        String origin = "";
        String imageSource = "";
        List<String> alsoKnownAs = new ArrayList<>();
        List<String> ingredients = new ArrayList<>();

        try {
            JSONObject sandwichObject = new JSONObject(json);
            JSONObject jName = sandwichObject.getJSONObject(NAME);
            name = jName.optString(MAINNAME);

            JSONArray jAlsoKnownAs = jName.getJSONArray(ALSOKNOWNAS);
            for (int g = 0; g < jAlsoKnownAs.length(); g++){
                alsoKnownAs.add(jAlsoKnownAs.getString(g));
            }

            origin = sandwichObject.getString(PLACEOFORIGIN);
            description = sandwichObject.getString(DESCRIPTION);
            imageSource  = sandwichObject.getString(IMAGE);

            JSONArray jIngredients = sandwichObject.getJSONArray(INGREDIENTS);
            for (int l = 0; l < jIngredients.length(); l++){
                ingredients.add(jIngredients.getString(l));
            }





        } catch (JSONException e) {
            e.printStackTrace();
        }


        return new Sandwich(name, alsoKnownAs , origin, description, imageSource, ingredients);
    }
}
