package com.example.kdotz.zoo.activities;

import android.os.Bundle;
import android.os.PersistableBundle;
import android.support.annotation.Nullable;
import android.support.v7.app.ActionBarActivity;
import android.support.v7.widget.Toolbar;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.kdotz.zoo.R;
import com.example.kdotz.zoo.models.Animal;
import com.google.android.gms.vision.text.Text;
import com.squareup.picasso.Picasso;

import static java.lang.System.load;

/**
 * Created by kdotz on 5/24/2017.
 */

public class ExhibitDetailActivity extends ActionBarActivity {

    public static final String EXTRA_ANIMAL = "extra_animal";

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_exhibit_detail);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        Animal animal = getIntent().getExtras().getParcelable(EXTRA_ANIMAL);

        TextView species = (TextView) findViewById(R.id.species);
        TextView description = (TextView) findViewById(R.id.description);
        ImageView image = (ImageView) findViewById(R.id.image);

        species.setText(animal.getSpecies());
        description.setText(animal.getDescription());

        Picasso.with(this).load(animal.getImage()).into(image);
    }


}
