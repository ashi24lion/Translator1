package com.example.devendra.translator;

import android.content.Context;
import android.content.res.Resources;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;

import com.example.devendra.translator.Helper.LocaleHelper;

import org.w3c.dom.Text;

import java.util.Locale;

import io.paperdb.Paper;

public class MainActivity extends AppCompatActivity {

    TextView textView;
    @Override
    protected void attachBaseContext(Context newBase) {
        super.attachBaseContext(LocaleHelper.onAttach(newBase,"en"));
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textView=(TextView)findViewById(R.id.text_view);

        //init paper first
        Paper.init(this);
        //Default language is English

        String language= Paper.book().read("language");
        if(language==null)
        {
            Paper.book().write("language","en");
        }


        updateView((String)Paper.book().read("language"));

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
    }

    private void updateView(String lang) {
        Context context=LocaleHelper.setLocale(this,lang);

        Resources resources=context.getResources();
        textView.setText(resources.getString(R.string.hello));

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        int id = item.getItemId();

        if (id == R.id.language_en) {
            Paper.book().write("language","en");
            updateView((String)Paper.book().read("language"));

        }

        else if(id == R.id.language_hi) {
            Paper.book().write("language","hi");
            updateView((String)Paper.book().read("language"));

        }
        return true;
    }
}
