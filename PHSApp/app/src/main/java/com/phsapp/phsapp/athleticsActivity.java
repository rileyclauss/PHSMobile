package com.phsapp.phsapp;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.customtabs.CustomTabsIntent;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;
import android.widget.Space;
import android.widget.TextView;
import android.widget.Toast;

import com.crazyhitty.chdev.ks.rssmanager.RSS;
import com.crazyhitty.chdev.ks.rssmanager.RssReader;
import com.squareup.picasso.Picasso;

import java.util.List;


public class athleticsActivity extends AppCompatActivity implements View.OnClickListener, RssReader.RssCallback {

    private RssReader rssReader = new RssReader(this);
    private AthleticsObj[][] athleticsObjs = new AthleticsObj[3][5];   //Holders for the textview and image views of articles, 1st dimension: 0 is boys, 1 is girls, 2 is misc. 2nd dimension: used for individual articles
    private TextView[] labels = new TextView[3];  //BoySports, GirlSports, and Misc labels
    private String[][] links = new String[3][5];  //links to articles
    public boolean[] entry = new boolean[2];      //Checks if there is an entry under girlsports/boysports
    public newsEntry[] athleticsEntries = new newsEntry[10];  //Objects for each article
    private TextView loadtext = null;   //Loading text
    private pl.droidsonroids.gif.GifTextView loadgif = null;  //Gif for loading


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_athletics);  //Sets layout to athletics
        loadtext = (TextView) findViewById(R.id.textView);   //assigns loadtext to the TextView
        loadgif = (pl.droidsonroids.gif.GifTextView) findViewById(R.id.load);  //assigns loadgif to the GifView
        declareStatic();    //Assigns each holder to its respective variable
        loadFeeds();        //Begins the RSS load method
    }


    private void declareStatic(){

        entry[0] = false;  //Assumes there are no articles
        entry[1] = false;  //for either girls or boys sports

        labels[0] = (TextView) findViewById(R.id.boysHeader);    //Assigns the label variables to
        labels[1] = (TextView) findViewById(R.id.girlsHeader);   //what they're labelling
        labels[2] = (TextView) findViewById(R.id.miscHeader);

        //Constructors for the article holders, see AthleticsObj.java
        athleticsObjs[0][0] = new AthleticsObj(((ImageView) findViewById(R.id.sportsImage0)), ((TextView) findViewById(R.id.sportsText0)), ((Space) findViewById(R.id.space0)));
        athleticsObjs[0][1] = new AthleticsObj(((ImageView) findViewById(R.id.sportsImage1)), ((TextView) findViewById(R.id.sportsText1)), ((Space) findViewById(R.id.space1)));
        athleticsObjs[0][2] = new AthleticsObj(((ImageView) findViewById(R.id.sportsImage2)), ((TextView) findViewById(R.id.sportsText2)), ((Space) findViewById(R.id.space2)));
        athleticsObjs[0][3] = new AthleticsObj(((ImageView) findViewById(R.id.sportsImage3)), ((TextView) findViewById(R.id.sportsText3)), ((Space) findViewById(R.id.space3)));
        athleticsObjs[0][4] = new AthleticsObj(((ImageView) findViewById(R.id.sportsImage4)), ((TextView) findViewById(R.id.sportsText4)), ((Space) findViewById(R.id.space4)));
        athleticsObjs[1][0] = new AthleticsObj(((ImageView) findViewById(R.id.sportsImage5)), ((TextView) findViewById(R.id.sportsText5)), ((Space) findViewById(R.id.space5)));
        athleticsObjs[1][1] = new AthleticsObj(((ImageView) findViewById(R.id.sportsImage6)), ((TextView) findViewById(R.id.sportsText6)), ((Space) findViewById(R.id.space6)));
        athleticsObjs[1][2] = new AthleticsObj(((ImageView) findViewById(R.id.sportsImage7)), ((TextView) findViewById(R.id.sportsText7)), ((Space) findViewById(R.id.space7)));
        athleticsObjs[1][3] = new AthleticsObj(((ImageView) findViewById(R.id.sportsImage8)), ((TextView) findViewById(R.id.sportsText8)), ((Space) findViewById(R.id.space8)));
        athleticsObjs[1][4] = new AthleticsObj(((ImageView) findViewById(R.id.sportsImage9)), ((TextView) findViewById(R.id.sportsText9)), ((Space) findViewById(R.id.space9)));
        athleticsObjs[2][0] = new AthleticsObj(((ImageView) findViewById(R.id.sportsImage10)), ((TextView) findViewById(R.id.sportsText10)), ((Space) findViewById(R.id.space10)));
        athleticsObjs[2][1] = new AthleticsObj(((ImageView) findViewById(R.id.sportsImage11)), ((TextView) findViewById(R.id.sportsText11)), ((Space) findViewById(R.id.space11)));
        athleticsObjs[2][2] = new AthleticsObj(((ImageView) findViewById(R.id.sportsImage12)), ((TextView) findViewById(R.id.sportsText12)), ((Space) findViewById(R.id.space12)));

    }


    private void loadFeeds() {
        String[] urls = {"http://pennant.phmschools.org/feed/"}; //Gives the RSS parser something to read
        rssReader.loadFeeds(urls);  //Begins RSS parser. Success -> onSuccess. Failure -> onFailure
    }

    public void rssFeedsLoaded(List<RSS> rssList) {
        boolean badCategories = false;
        int x, y;     //location of imgLink in description of article; x is beginning, y is ending
        for (int i = 0;i<10;i++) {
            if (rssList.get(0).getChannel().getItems().get(i).getDescription().contains("uploads")) {  //'uploads' is the guarantee of an imgLink in the description
                x = rssList.get(0).getChannel().getItems().get(i).getDescription().indexOf(" src");    //src is found before the imgLink
                x += 6;                                                 //used to bring x to the beginning of the link
                y = rssList.get(0).getChannel().getItems().get(i).getDescription().indexOf(" alt");   //alt is after
                y -= 1;                                                  //bring y to the end of the link
                //constructor for athleticsEntries, rssList is autogenerated by RSS reader,  substring divides the desc for the img link
                athleticsEntries[i] = new newsEntry(rssList.get(0).getChannel().getItems().get(i).getTitle(),
                        rssList.get(0).getChannel().getItems().get(i).getDescription().substring(x, y),
                        rssList.get(0).getChannel().getItems().get(i).getCategory(), rssList.get(0).getChannel().getItems().get(i).getLink());
            }
        }
        for (int i = 0; i < 10; i++) {
            if(athleticsEntries[i].getCategory() == null) {  //If no recognized category is passed,
                athleticsEntries[i].setCategory("Misc");     //Set the category to Misc
                badCategories = true;                        //sets the flag for bad categories
            }
            switch (athleticsEntries[i].getCategory()) { //switch case for the category
                case "Girls Sports": {                   //If it is a girl sport article,
                    if (athleticsObjs[1][4].getexists()){
                        break;
                    }
                    entry[1] = true;                     //Flag states there is an article in this section, used on line 175
                    int z = 0;                           //z is a counter for each article in the section
                    while (athleticsObjs[1][z].getexists()) {   //While there is an article in each spot and less than five
                        z++; //This counts until it finds an empty spot to put the next article
                    }
                    if (athleticsEntries[i].getImgLink() != null) //If the imagelink is not equal to null
                        Picasso.with(this).load(athleticsEntries[i].getImgLink()).into(athleticsObjs[1][z].getArtHolder());   //Load the image from getImgLink into the ArtHolder with Picasso
                    else { //If the image link IS equal to null
                        athleticsObjs[1][z].getArtHolder().setImageResource(R.drawable.noimage);  //set the image to a premade asset
                    }
                    athleticsObjs[1][z].setExists(true);  //Sets the flag that this article is in its holder
                    if (athleticsEntries[i].getLink() != null)   //if the link does not equal null, which is what the RSS Reader would pass if there was no link
                        links[1][z] = athleticsEntries[i].getLink();    //assign the link to the link array, used in OnClick
                    if (athleticsEntries[i].getTitle() != null) //If the title is not equal to null
                        athleticsObjs[1][z].getTitle().setText(athleticsEntries[i].getTitle()); //set the textview to the title of the article
                    else {
                        athleticsObjs[1][z].getTitle().setText(R.string.noTitle); //if it is null, set it to a 'no title available' string
                    }
                    athleticsObjs[1][z].getBelow().setVisibility(View.VISIBLE);   //Push space down below the article for aesthetic purposes
                    break;     //end protocol
                }
                case "Boys Sports":            //if the category is Boys Sports
                case "Photo Gallery": {        //OR Photo Gallery
                    if (athleticsObjs[0][4].getexists()){
                        break;
                    }
                    else{
                        entry[0] = true;                     //Flag states there is an article in this section, used on line 172
                        int z = 0;                           //z is a counter for each article in the section
                        while (athleticsObjs[0][z].getexists()) {   //While there is an article in each spot and less than five
                            z++;//This counts until it finds an empty spot to put the next article
                        }
                        if (athleticsEntries[i].getImgLink() != null)   //If the imagelink is not equal to null
                            Picasso.with(this).load(athleticsEntries[i].getImgLink()).into(athleticsObjs[0][z].getArtHolder());    //Load the image from getImgLink into the ArtHolder with Picasso
                        else {  //If the image link IS equal to null
                            athleticsObjs[0][z].getArtHolder().setImageResource(R.drawable.noimage);  //set the image to a premade asset
                        }
                        athleticsObjs[0][z].setExists(true);  //Sets the flag that this article is in its holder
                        if (athleticsEntries[i].getLink() != null)   //if the link does not equal null, which is what the RSS Reader would pass if there was no link
                            links[0][z] = athleticsEntries[i].getLink();    //assign the link to the link array, used in OnClick
                        if (athleticsEntries[i].getTitle() != null) //If the title is not equal to null
                         athleticsObjs[0][z].getTitle().setText(athleticsEntries[i].getTitle()); //set the textview to the title of the article
                        else {
                           athleticsObjs[0][z].getTitle().setText(R.string.noTitle); //if it is null, set it to a 'no title available' string
                        }
                        athleticsObjs[0][z].getBelow().setVisibility(View.VISIBLE);   //Push space down below the article for aesthetic purposes
                        break;
                    }
                }
                case "Misc": {
                    if (athleticsObjs[2][2].getexists()){
                        break;
                    }
                    labels[2].setVisibility(View.VISIBLE); //Makes the 'misc' label visible
                    int z = 0;//z is a counter for each article in the section
                    while (athleticsObjs[2][z].getexists()) {   //While there is an article in each spot and less than three
                        z++;//This counts until it finds an empty spot to put the next article
                    }
                    athleticsObjs[2][z].getTitle().setVisibility(View.VISIBLE);
                    athleticsObjs[2][z].getArtHolder().setVisibility(View.VISIBLE);
                    athleticsObjs[2][z].setExists(true);   //Sets the flag that this article is in its holder
                    if (athleticsEntries[i].getImgLink() != null)  //if the link does not equal null, which is what the RSS Reader would pass if there was no link
                        Picasso.with(this).load(athleticsEntries[i].getImgLink()).into(athleticsObjs[2][z].getArtHolder());    //Load the image from getImgLink into the ArtHolder with Picasso
                    else {
                        athleticsObjs[2][z].getArtHolder().setImageResource(R.drawable.noimage); //set the image to a premade asset
                    }
                    if (athleticsEntries[i].getLink() != null)   //if the link does not equal null, which is what the RSS Reader would pass if there was no link
                        links[2][z] = athleticsEntries[i].getLink();    //assign the link to the link array, used in OnClick
                    if (athleticsEntries[i].getTitle() != null){ //If the title is not equal to null
                        athleticsObjs[2][z].getTitle().setText(athleticsEntries[i].getTitle()); //set the textview to the title of the article
                        //Toast.makeText(this, athleticsEntries[i].getTitle(), Toast.LENGTH_LONG).show();
                        }
                    else {
                        athleticsObjs[2][z].getTitle().setText(R.string.noTitle); //if it is null, set it to a 'no title available' string
                    }
                    athleticsObjs[2][z].getBelow().setVisibility(View.VISIBLE);  //Push space down below the article for aesthetic purposes
                    break;
                }
            }

        }
        if (!entry[0]){   //If there are no articles in the BoysSports/PhotoGallery,
            athleticsObjs[0][1].getTitle().setText(R.string.noentries);  //Sets the text to a premade string
        }
        if (!entry[1]){  //If there are no articles in the GirlSports category,
            athleticsObjs[1][1].getTitle().setText(R.string.noentries); //Sets the text to a premade string
        }
        if (badCategories){
            Toast.makeText(this, "Some articles may be in the wrong category.", Toast.LENGTH_SHORT).show(); //and notify the user
        }
        visibilityFix(); //Calls the visibilityFix function, making the loading gif and text invisible, and the article pieces visible
    }


    public void unableToReadRssFeeds(String errorMessage) {   //When the RSS Reader fails,
        Toast.makeText(this, "An error occured, please check your internet connection." , Toast.LENGTH_LONG).show(); //Notify the user
        Intent intent = new Intent(this, MainActivity.class);//Make a new intent to return to the main screen
        startActivity(intent);   //Return to the main screen
    }

    private void visibilityFix(){  //called on line 176
        loadgif.setVisibility(View.INVISIBLE);   //Make the loadgif invisible
        loadtext.setVisibility(View.INVISIBLE);  //Make the loadtext invisible
        for (int z = 0; z < 2; z++) { //For each of the 3 categories
                for (int i=0;i<5;i++){ //For each article,
                    athleticsObjs[z][i].getTitle().setVisibility(View.VISIBLE); //Set the title and
                    athleticsObjs[z][i].getArtHolder().setVisibility(View.VISIBLE); //the image as visible
                }
            }

        }

    @Override
    public void onClick(View v) {       //When an article is clicked on
        String url = "http://pennant.phmschools.org/"; //create a string for the url
        int x = Integer.parseInt(v.getTag().toString()); //Get which article is clicked
        if (x!=99){
            if (x < 5) {
               url = links[0][x];
            }
            else if(x>=5 && x <10){
                x -=5;
                url = links[1][x];
            }
            else{
                x -= 10;
                url=links[2][x];
            }
        }
        CustomTabsIntent.Builder builder = new CustomTabsIntent.Builder(); //Starts a custom tabs builder
        CustomTabsIntent customTabsIntent = builder.build(); //Builds the tab
        customTabsIntent.launchUrl(this, Uri.parse(url));  //Loads the url into it
    }

}

