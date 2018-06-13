package com.akshay.crop_app;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.Toast;

import com.akshay.crop_app.services.Rates;
import com.akshay.crop_app.services.RatesList;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

public class MandiRates extends AppCompatActivity {


    EditText editTextName;
    Spinner spinnerGenre;
    ListView listViewArtists;

    //a list to store all the artist from firebase database
    List<Rates> rates;

    //our database reference object
    DatabaseReference databaseMandiRates;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mandi_rates);
        //getting the reference of artists node
        databaseMandiRates = FirebaseDatabase.getInstance().getReference("MandiRates");

        //getting views
        listViewArtists = (ListView) findViewById(R.id.listViewRates);



        //list to store artists
        rates = new ArrayList<>();


        //toast onClick on list view
        listViewArtists.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(MandiRates.this, "Complaint Clicked", Toast.LENGTH_SHORT).show();
            }
        });



        //attaching listener to listview------- onClick for list view
      /*  listViewArtists.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                //getting the selected artist
                Artist artist = artists.get(i);

                //creating an intent
                Intent intent = new Intent(getApplicationContext(), ArtistActivity.class);

                //putting artist name and id to intent
                intent.putExtra(ARTIST_ID, artist.getEmail());
                intent.putExtra(ARTIST_NAME, artist.getName());

                //starting the activity with intent
                startActivity(intent);
            }
        }); */



    }



    @Override
    protected void onStart() {
        super.onStart();
        //attaching value event listener
        databaseMandiRates.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {

                //clearing the previous artist list
                rates.clear();

                //iterating through all the nodes
                for (DataSnapshot postSnapshot : dataSnapshot.getChildren()) {
                    //getting artist
                    Rates artist = postSnapshot.getValue(Rates.class);
                    //adding artist to the list
                    rates.add(artist);
                }

                //creating adapter
                RatesList artistAdapter = new RatesList(MandiRates.this, rates);
                //attaching adapter to the listview
                listViewArtists.setAdapter(artistAdapter);
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });
    }
}
