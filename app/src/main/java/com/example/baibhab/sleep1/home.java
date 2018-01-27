package com.example.baibhab.sleep1;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;

public class home extends AppCompatActivity {

    DatabaseHandler mydb;
    ListView listView_var;

    ArrayList<String> dateResult = new ArrayList<>();
    ArrayList<String> ratingResult = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        mydb = new DatabaseHandler(this);
        listView_var = (ListView)findViewById(R.id.listView);

        Cursor data = mydb.getAllData();

        while(data.moveToNext()) {
            dateResult.add(data.getString(20));
            ratingResult.add(String.valueOf(data.getFloat(21)));
        }

        CustomAdapter adapter = new CustomAdapter();
        listView_var.setAdapter(adapter);

        listView_var.setOnItemClickListener(
                new AdapterView.OnItemClickListener() {
                    @Override
                    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                        Intent i = new Intent(home.this,showData.class);
                        i.putExtra("requiredDate",((TextView) view.findViewById(R.id.displayDate)).getText().toString());
                        startActivity(i);
                    }
                }
        );
    }

    class CustomAdapter extends BaseAdapter {

        @Override
        public int getCount() {
            return dateResult.size();
        }

        @Override
        public Object getItem(int position) {
            return null;
        }

        @Override
        public long getItemId(int position) {
            return 0;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            convertView = getLayoutInflater().inflate(R.layout.item_template, null);

            TextView displayDate_var = (TextView) convertView.findViewById(R.id.displayDate);
            TextView displayRating_var = (TextView) convertView.findViewById(R.id.displayRating);

            displayDate_var.setText(dateResult.get(position));
            displayRating_var.setText(ratingResult.get(position));

            return convertView;
        }
    }

    public void addHomeButtonOnClick(View v) {
        Intent i = new Intent(this,date.class);
        startActivity(i);
    }
}