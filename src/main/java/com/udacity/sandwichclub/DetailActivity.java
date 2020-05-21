package com.udacity.sandwichclub;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.squareup.picasso.Picasso;
import com.udacity.sandwichclub.model.Sandwich;
import com.udacity.sandwichclub.utils.JsonUtils;

import org.json.JSONException;
import org.json.JSONObject;
import org.w3c.dom.Text;

public class DetailActivity extends AppCompatActivity {

    public static final String EXTRA_POSITION = "extra_position";
    private static final int DEFAULT_POSITION = -1;
    private String sandwichJSONString;
    private TextView mName;
    private TextView mKnownAs;
    private TextView mIngredients;
    private TextView mOrigin;
    private TextView mDescription;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        ImageView ingredientsIv = findViewById(R.id.image_iv);


        Intent intent = getIntent();
        if (intent == null) {
            closeOnError();
        }

        int position = intent.getIntExtra(EXTRA_POSITION, DEFAULT_POSITION);
        if (position == DEFAULT_POSITION) {
            // EXTRA_POSITION not found in intent
            closeOnError1();
            return;
        }

        String[] sandwiches = getResources().getStringArray(R.array.sandwich_details);
        String json = sandwiches[position];
        Sandwich sandwich = JsonUtils.parseSandwichJson(json);
        if (sandwich == null) {
            // Sandwich data unavailable
            closeOnError2();
            return;
        }

        populateUI(sandwich);
        Picasso.with(this)
                .load(sandwich.getImage())
                .into(ingredientsIv);

        setTitle(sandwich.getMainName());
    }

    private void closeOnError() {
        finish();
        Toast.makeText(this, "No intent", Toast.LENGTH_SHORT).show();
    }

    private void closeOnError1() {
        finish();
        Toast.makeText(this, "Position outside range", Toast.LENGTH_SHORT).show();
    }

    private void closeOnError2() {
        finish();
        Toast.makeText(this, "Sandwich data not available", Toast.LENGTH_SHORT).show();
    }

    private void populateUI(Sandwich sandwich) {

        TextView mKnownAs = (TextView) findViewById(R.id.also_known_as);
        mKnownAs.setText("Also known as: " + sandwich.getKnownAsString() + "");

        TextView mIngredients = (TextView) findViewById(R.id.ingredients);
        mIngredients.setText("Ingredients: " + "\n" + sandwich.getIngredientsString() + "");

        TextView mOrigin = (TextView) findViewById(R.id.origin);
        mOrigin.setText("Place of origin: " + sandwich.getPlaceOfOrigin() + "");

        TextView mDescription = (TextView) findViewById(R.id.description);
        mDescription.setText("Description: " + "\n" + sandwich.getDescription() + "");
    }

}
