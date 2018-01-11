package at.navilla.wienerwald;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;

/**
 * Created by andre on 06.01.2018.
 */

public class CompaniesActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.poi_list);




        ArrayList<Poi> pois = new ArrayList<Poi>();

        //words.add("zero");

        pois.add(new Poi("Billa","Lebensmittelhandel", R.mipmap.wienerwald_erb));




        // Create an {@link ArrayAdapter}, whose data source is a list of Strings. The
        // adapter knows how to create layouts for each item in the list, using the
        // simple_list_item_1.xml layout resource defined in the Android framework.
        // This list item layout contains a single {@link TextView}, which the adapter will set to
        // display a single word.
        PoiAdapter adapter =
                new PoiAdapter(this, pois, R.color.cat_companies);

        // Find the {@link ListView} object in the view hierarchy of the {@link Activity}.
        // There should be a {@link ListView} with the view ID called list, which is declared in the
        // activity_numbers.xml layout file.
        ListView listView = (ListView) findViewById(R.id.list);

        // Make the {@link ListView} use the {@link ArrayAdapter} we created above, so that the
        // {@link ListView} will display list items for each word in the list of words.
        // Do this by calling the setAdapter method on the {@link ListView} object and pass in
        // 1 argument, which is the {@link ArrayAdapter} with the variable name itemsAdapter.
        listView.setAdapter(adapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            // The code in this method will be executed when the family category is clicked on.
            @Override
            public void onItemClick(AdapterView adapterView, View view, int Position, long l) {
                // Create a new intent to open the {@link FamilyActivity}
                Intent sightIntent = new Intent(CompaniesActivity.this, MapsActivity.class);

                // Start the new activity
                startActivity(sightIntent);
            }
        });
    }

}