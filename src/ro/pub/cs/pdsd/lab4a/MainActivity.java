package ro.pub.cs.pdsd.lab4a;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

public class MainActivity extends Activity {

	String[] strmovies = new String[] { 
	        "The Shawshank Redemption", 
		"The Godfather", 
		"The Godfather: Part II", 
		"The Dark Knight", 
		"Pulp Fiction", 
		"The Good, the Bad and the Ugly", 
		"Schindler's List", 
		"12 Angry Men", 
		"The Lord of the Rings: The Return of the King", 
		"Fight Club" 
	    };
	
    List<String> movies; 
 
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
	setContentView(R.layout.activity_main);
 
	//movies = new ArrayList<String>(Arrays.asList(getResources().getStringArray(R.array.movies)));
	movies = new ArrayList<String>();
	for(int i=0; i < strmovies.length; i++)
		movies.add(strmovies[i]);	
	
	
	ListView listview = (ListView)findViewById(R.id.listView1);
	final ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, movies);
	listview.setAdapter(adapter);
    
	
    listview.setOnItemClickListener(new AdapterView.OnItemClickListener() {
        @Override
        public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
            Toast.makeText(MainActivity.this, "You have clicked on "+adapter.getItem(position)+" item", Toast.LENGTH_SHORT).show();
        }
    });
    listview.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
        @Override
        public boolean onItemLongClick(AdapterView<?> parent, View view, int position, long id) {
            Toast.makeText(MainActivity.this, "You have long clicked on "+adapter.getItem(position)+" item", Toast.LENGTH_SHORT).show();
            
           movies.remove(position); 
           
           //crapă adapter.remove(adapter.getItem(position));
           
           Log.println (Log.DEBUG, "lab4", "șterge " + adapter.getItem(position) + movies.size());
           //adapter.notifyDataSetInvalidated();
           adapter.notifyDataSetChanged();
    	return true;
        }
    });
    listview.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
        @Override
        public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
            Toast.makeText(MainActivity.this, "You have selected the "+adapter.getItem(position)+" item", Toast.LENGTH_SHORT).show();
        }
        @Override
        public void onNothingSelected(AdapterView<?> parent) {
            Toast.makeText(MainActivity.this, "Currently, the list has no item selected", Toast.LENGTH_SHORT).show();
        }
    });
    }

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}
	

}
