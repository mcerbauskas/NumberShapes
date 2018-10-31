package com.mcerbauskas.numbershapes;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    class Number
    {
        int number; //skaicius kuris bus ivestas ir i ji bus lyginamasi

        public boolean isSquare()
        {
            double squareRoot = Math.sqrt(number);
            if (squareRoot == Math.floor(squareRoot))
            {
                return true;
            }
            else
            {
                return false;
            }
        }

        //check whether is it a triangular number
        public boolean isTriangular()
        {
            int x = 1; //counteris

            int triangularNumber = 1; // this will work the way up to the triangular numbers

            //this will create a series of triangular numbers and will keep on going till either triangular number is greater or equal to number inputed
            while (triangularNumber < number)
            {
                x++;

                triangularNumber = triangularNumber + x;
            }

            if (triangularNumber == number)
            {
                return true;
            }
            else
            {
                return false;
            }
        }
    }
    //not going to return anything, going to be called by a button which is a type of view
    public void checkNumber(View view) {
        //getting  the value from editText
        EditText numberField = findViewById(R.id.numberField); // converting view to edit text so we write (EditText)
        //Log.i("numberField", numberField.getText().toString()); //i EditText ivesta reiksme atvaizduosime loguose

        String message = ""; // tuscias message

        if (numberField.getText().toString().isEmpty()) //isEmpty() metodas tikrina ar EditText stringas nebus tuscias
        {
             message = "Iveskite skaiciu";
        } else {

            Number myNumber = new Number();
            myNumber.number = Integer.parseInt(numberField.getText().toString()); //number priskiriama vartotojo ivesta reiksme, taciau ja dar reikia konvertuoti i integer ( naudojame Integer.parseInt() )


            if (myNumber.isSquare() == true) //arba tiesiog be == true
            {
                if (myNumber.isTriangular() == true) {
                    message = myNumber.number + " yra ir trikampis ir kvadratinis ";
                } else {
                    message = myNumber.number + " yra kvadratinis bet ne trikampis ";
                }
            } else {
                if (myNumber.isTriangular() == true) {
                    message = myNumber.number + " yra trikampis bet ne kvadratinis ";
                } else {
                    message = myNumber.number + " nei kvadratinis nei trikampis ";
                }
            }

        }
            Toast.makeText(getApplicationContext(), message, Toast.LENGTH_LONG).show();
        }

        @Override
        protected void onCreate (Bundle savedInstanceState){
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_main);
        }
    }

