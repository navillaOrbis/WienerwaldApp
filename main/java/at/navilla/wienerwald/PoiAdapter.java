package at.navilla.wienerwald;
/**
 * Created by andre on 06.01.2018.
 */

import android.app.Activity;
import android.support.v4.content.ContextCompat;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by andre on 04.01.2018.
 *
 * {@link PoiAdapter} is an {@link ArrayAdapter} that can provide the layout for each list
 * based on a data source, which is a list of {@link Poi} objects.
 * **/

public class PoiAdapter extends ArrayAdapter<Poi> {
    //private static final String LOG_TAG = PoiAdapter.class.getSimpleName();

    /** Resource ID for the background color for this list of words */
    private int mColorResourceId;

    /**
     * This is our own custom constructor (it doesn't mirror a superclass constructor).
     * The context is used to inflate the layout file, and the list is the data we want
     * to populate into the lists.
     *
     * @param context        The current context. Used to inflate the layout file.
     * @param words A List of AndroidFlavor objects to display in a list
     * @param colorResourceId is the resource ID for the background color for this list of words
     */
    public PoiAdapter(Activity context, ArrayList<Poi> words, int colorResourceId) {
        // Here, we initialize the ArrayAdapter's internal storage for the context and the list.
        // the second argument is used when the ArrayAdapter is populating a single TextView.
        // Because this is a custom adapter for two TextViews and an ImageView, the adapter is not
        // going to use this second argument, so it can be any value. Here, we used 0.
        super(context, 0, words);
        mColorResourceId = colorResourceId;
    }

    /**
     * Provides a view for an AdapterView (ListView, GridView, etc.)
     *
     * @param position The position in the list of data that should be displayed in the
     *                 list item view.
     * @param convertView The recycled view to populate.
     * @param parent The parent ViewGroup that is used for inflation.
     * @return The View for the position in the AdapterView.
     */
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        // Check if the existing view is being reused, otherwise inflate the view
        View listItemView = convertView;
        if(listItemView == null) {
            listItemView = LayoutInflater.from(getContext()).inflate(
                    R.layout.list_item, parent, false);
        }

        // Get the {@link AndroidFlavor} object located at this position in the list
        Poi currentPoi = getItem(position);

        // Find the TextView in the list_item.xml layout with the ID version_name
        TextView poiNameTextView = (TextView) listItemView.findViewById(R.id.poi_name_text_view);
        // Get the version name from the current AndroidFlavor object and
        // set this text on the name TextView
        poiNameTextView.setText(currentPoi.getPoiName());

        // Find the TextView in the list_item.xml layout with the ID version_number
        TextView poiTypeTextView = (TextView) listItemView.findViewById(R.id.poi_type_text_view);
        // Get the version number from the current AndroidFlavor object and
        // set this text on the number TextView
        poiTypeTextView.setText(currentPoi.getPoiType());

        // Find the ImageView in the list_item.xml layout with the ID image.
        ImageView imageView = (ImageView) listItemView.findViewById(R.id.image);
        // Check if an image is provided for this word or not
        if (currentPoi.hasImage()) {
            // If an image is available, display the provided image based on the resource ID
            imageView.setImageResource(currentPoi.getImageResourceId());
            // Make sure the view is visible
            imageView.setVisibility(View.VISIBLE);
        } else {
            // Otherwise hide the ImageView (set visibility to GONE)
            imageView.setVisibility(View.GONE);
        }

        // Set the theme color for the list item
        View textContainer = listItemView.findViewById(R.id.text_container);
        // Find the color that the resource ID maps to
        int color = ContextCompat.getColor(getContext(), mColorResourceId);
        // Set the background color of the text container View
        textContainer.setBackgroundColor(color);

        // Return the whole list item layout (containing 2 TextViews) so that it can be shown in
        // the ListView.
        return listItemView;
    }

}
