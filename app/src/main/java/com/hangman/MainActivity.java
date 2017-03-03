package com.hangman;

import android.app.AlertDialog;
import android.content.Context;
import android.graphics.drawable.Drawable;
import android.media.Image;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;
import java.util.Random;
import java.util.*;

public class MainActivity extends AppCompatActivity {

    int curr_image = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ImageView imageView = (ImageView) findViewById(R.id.imageView);
        imageView.setImageResource(R.drawable.dog);
    }

    public void tryGuess(View view){
        EditText editText = (EditText) findViewById(R.id.editText3);

        ImageView imageView = (ImageView) findViewById(R.id.imageView);
        int[] animals = {R.drawable.dog, R.drawable.cat, R.drawable.snake, R.drawable.rabbit};
        String[] animal_names = {"dog", "cat", "snake", "rabbit"};
        Random r = new Random();


        String message = editText.getText().toString();
        int duration = Toast.LENGTH_SHORT;
        CharSequence text;
        Context context = getApplicationContext();


        if (message.equals((animal_names[curr_image]))){
            text = "Good Guess!";
            int index = r.nextInt(animals.length);
            imageView.setImageResource(animals[index]);
            curr_image = index;
        }
        else{
            text = "Try again!";
        }
        Toast toast = Toast.makeText(context, text, duration);
        toast.show();

    }
}
