package com.phsapp.phsapp;


import android.widget.ImageView;
import android.widget.Space;
import android.widget.TextView;

class AthleticsObj {

    private ImageView ArtHolder;
    private TextView Title;
    private Space below;
    private boolean exists = false;

    AthleticsObj(ImageView ArtHolder, TextView Title, Space below){
        this.ArtHolder = ArtHolder;
        this.Title = Title;
        this.below = below;
    }

    ImageView getArtHolder(){return ArtHolder;}
    TextView getTitle(){return Title;}
    Space getBelow(){return below;}
    boolean getexists(){return exists;}

    void setExists(boolean existance){exists = existance;}
    void setArtHolder(ImageView imgView){ArtHolder = imgView;}
    void setTitle(TextView titleView){Title = titleView;}
    void setBelow(Space spacer){below = spacer;}
}
