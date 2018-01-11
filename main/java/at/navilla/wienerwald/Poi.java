package at.navilla.wienerwald;

/**
 * Created by andre on 06.01.2018.
 */

public class Poi {

    // Poi object name
    private String mPoiName;

    // Point object Type
    private String mPoiType;

    /** Image resource ID for the word */
    private int mImageResourceId = NO_IMAGE_PROVIDED;

    /** Constant value that represents no image was provided for this word */
    private static final int NO_IMAGE_PROVIDED = -1;



    /**
     * Create a new Word object.
     *
     * @param poiName is the word in a language that the user is already familiar with
     *                           (such as English)
     * @param poiType is the word in the Miwok language
     * @param imageResourceId is the drawable resource ID for the image associated with the word
     *
     */
    public Poi(String poiName, String poiType, int imageResourceId) {
        mPoiName = poiName;
        mPoiType = poiType;
        mImageResourceId = imageResourceId;
    }


    /**
     * Get the defaulttranslation of the word.
     *
     * @return current text in the TextView.
     */
    public String getPoiName() {
        return mPoiName;
    }

    /**
     * Get the miwoktranslation of the word.
     *
     * @return current text in the TextView.
     */
    public String getPoiType() {
        return mPoiType;
    }

    /**
     * Return the image resource ID of the word.
     */
    public int getImageResourceId() {
        return mImageResourceId;
    }

    /**
     * Returns whether or not there is an image for this word.
     */
    public boolean hasImage() {
        return mImageResourceId != NO_IMAGE_PROVIDED;
    }
}



