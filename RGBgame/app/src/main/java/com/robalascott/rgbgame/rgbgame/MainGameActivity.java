package com.robalascott.rgbgame.rgbgame;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 *
 */


public class MainGameActivity extends AppCompatActivity {
    private RecyclerView mainRecyclerView;
    private ColorAdapter mainColorAdapter;
    private List<ColorObject> colorList = new ArrayList<>();;
    private TextView mainTextView, scoreTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_game);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        colorList = randomColorGen(6);
        UI();
        FloatingActionButton fab = findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main_game, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    public boolean UI(){
        this.mainTextView = findViewById(R.id.mainTitle);
        this.mainTextView.setText(R.string.main_title);
        this.scoreTextView = findViewById(R.id.mainScore);
        /*Adapter and Listners */
        mainRecyclerView= findViewById(R.id.playareaView);
        mainColorAdapter = new ColorAdapter(colorList,this);
        LinearLayoutManager llm = new LinearLayoutManager(this);
        mainRecyclerView.setLayoutManager(llm);
        mainRecyclerView.setItemAnimator(new DefaultItemAnimator());
        mainRecyclerView.setAdapter( mainColorAdapter);
        mainColorAdapter.notifyDataSetChanged();
        mainColorAdapter.setOnClick(new ColorAdapter.ItemClickListener (){
            @Override
            public void onItemClick(View v, int pos,String style) {
                //This is dirty add new interface or enums
                Log.i("Main","main");
                checkresults(pos);

            }
        });

        return true;
    }

    public void checkresults(int pos){
           this.colorList.get(pos).setAlpha(0.1f);
           this.mainColorAdapter.notifyDataSetChanged();
    }

    public List<ColorObject> randomColorGen(int size){
        Random random = new Random();
        List<ColorObject> temp = new ArrayList<>();
        for(int x = 0; x<size;x++){
            temp.add(new ColorObject(random.nextInt(255)+1,random.nextInt(255)+1,random.nextInt(255)+1));
        }
        return temp;
    }

}
