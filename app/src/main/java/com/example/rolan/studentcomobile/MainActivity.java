package com.example.rolan.studentcomobile;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import android.app.Activity;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.rolan.studentcomobile.util.RESTClient;


public class MainActivity extends AppCompatActivity {

    Button b1,b2;
    EditText ed1,ed2;

    TextView tx1;
    int counter = 3;

    public boolean authenticate()
    { // méthode supplémentaire pour authantification OK oou KO RESTClient papa = new RESTClient();
        RESTClient papa = new RESTClient();
        String urlLogin = "/studentCo_RN/login";
        String messageWebServiceLogin = papa.callWebservice(urlLogin);
        // Toast..
        if (messageWebServiceLogin.equals("null"))
            return false;

        else return true;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        b1 = (Button) findViewById(R.id.bouton1);
        ed1 = (EditText) findViewById(R.id.mainMenu_editText);
        ed2 = (EditText) findViewById(R.id.editText2);
        final String username = ed1.getText().toString();
        final String password = ed2.getText().toString();

        // tx1.setVisibility(View.GONE);

        b1.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v) {
                if (authenticate() == true)
                // ed1.getText().toString().equals(username) && ed2.getText().toString().equals(password)
                {
                    Toast.makeText(getApplicationContext(),
                            "Validation réussie, en attente de connexion...", Toast.LENGTH_SHORT).show();
                }

                else {
                    Toast.makeText(getApplicationContext(), "Mauvais login", Toast.LENGTH_SHORT).show();

                    //   tx1.setVisibility(View.VISIBLE);
                    //   tx1.setBackgroundColor(Color.RED);
                    //   tx1.setText(Integer.toString(counter));

                    counter--;

                    if (counter == 0) {
                        b1.setEnabled(false);
                    }
                }
            }
        });
    }




    // voici la méthode qui dit si authentifié ou pas => THE méthode !!

   // public boolean authenticate(String username, String password)
   // { // méthode supplémentaire pour authantification OK oou KO RESTClient papa = new RESTClient();
     //   RESTClient papa = new RESTClient();
     // String urlLogin = "/studentCo_RN/login";
      //  String messageWebServiceLogin = papa.callWebservice(urlLogin);
        // Toast..
      //  if (messageWebServiceLogin.equals("null"))
      //      return false;

      //  else return true;
    }






//    RESTClient papa = new RESTClient();
//
//    int cpt = 0;
//
//    String urlLogin = "/studentCo/login/" + username + "/" + password + "/"; //il faut créer les zones texte (2 edit text) qui portent les noms username et password

//        if (authenticate(username, password) && cpt > 2) {
//                // Toast ..
//                String messageWebServiceLogin = papa.callWebservice(urlLogin);
//                }