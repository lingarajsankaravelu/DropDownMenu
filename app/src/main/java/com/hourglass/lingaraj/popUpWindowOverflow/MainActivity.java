package com.hourglass.lingaraj.popUpWindowOverflow;

import android.annotation.SuppressLint;
import android.annotation.TargetApi;
import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Build;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.PopupWindow;
import android.widget.RelativeLayout;

import com.hourglass.lingaraj.dropdownmenu.R;

public class MainActivity extends AppCompatActivity {

    ImageView overFlowMenuIcon;
    PopupWindow socialNetworkPopUpWindow;
    View view;
    RelativeLayout faceBook,googelPlus,instagram,twitter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //setPopUpWindow() method will set PopUpwindow when the MainActivity loads .
        setPopUpWindow();

        overFlowMenuIcon=(ImageView)findViewById(R.id.overflow_imageView);
        overFlowMenuIcon.setOnClickListener(new View.OnClickListener() {
            @SuppressLint("NewApi")
            @Override
            public void onClick(View v) {
                if(v.isSelected())
                {
                    socialNetworkPopUpWindow.dismiss();
                    v.setSelected(false);

                }
                else
                {
                    v.setSelected(true);
                    socialNetworkPopUpWindow.showAsDropDown(v,-153,0);
                    //showAsDropDown(below which view you want to show as dropdown,horizontal position, vertical position)
                }
            }
        });

    }

    @SuppressLint("NewApi")
    private void setPopUpWindow() {
        LayoutInflater inflater = (LayoutInflater)
                getApplicationContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        view = inflater.inflate(R.layout.overflowmenuicon, null);
        /* Layout Inflated with the view here is will be displayed below OverFlowIcon in
         *
         */

        faceBook=(RelativeLayout)view.findViewById(R.id.facebook_button);
        googelPlus=(RelativeLayout)view.findViewById(R.id.googlePlus_button);
        instagram=(RelativeLayout)view.findViewById(R.id.instagram_button);
        twitter=(RelativeLayout)view.findViewById(R.id.twitter_button);



        /*Create a New PopUp window and you have to pass the layout you want to dislay as 1stparameter,widh size as 2nd parametere,height as 3rd parameter,true or false as forth param)
         *
         */
        socialNetworkPopUpWindow = new PopupWindow(view,300, RelativeLayout.LayoutParams.WRAP_CONTENT, true);
        //new popupWindow(layout to be displayed as popup,width size of popupwindow, height size PopUpwindow,true/false(focusable or not
        // in touch mode))



        final Intent newIntent=new Intent();
        //creating a new Intent to start an Activity
        newIntent.setClass(getApplicationContext(), WebLoadingActivity.class);
        // setting upt the activity which is need to be displayed when the intent starts





         /*
          * Setting OnClickListener for all the Layout options, facebook,google etc.
          */
        faceBook.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                socialNetworkPopUpWindow.dismiss();
                newIntent.putExtra("loadingPage","https://www.facebook.com/");
                //Adding webpage url string to intent as extra which will be recieved at new end and the appropriate webPage will be loaded.
                startActivity(newIntent);
               }
        });

        googelPlus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                socialNetworkPopUpWindow.dismiss();
                newIntent.putExtra("loadingPage","https://plus.google.com/");
                //Adding webpage url string to intent as extra which will be recieved at new end and the appropriate webPage will be loaded.
                startActivity(newIntent);



            }
        });

        instagram.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                socialNetworkPopUpWindow.dismiss();
                newIntent.putExtra("loadingPage","https://instagram.com/");
                //Adding webpage url string to intent as extra which will be recieved at new end and the appropriate webPage will be loaded.
                startActivity(newIntent);




            }
        });
        twitter.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                socialNetworkPopUpWindow.dismiss();
                newIntent.putExtra("loadingPage","https://twitter.com/");
                //Adding webpage url string to intent as extra which will be recieved at new end and the appropriate webPage will be loaded.
                startActivity(newIntent);


            }
        });







    }
}
