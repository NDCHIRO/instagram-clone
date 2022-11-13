/*
 * Copyright (c) 2015-present, Parse, LLC.
 * All rights reserved.
 *
 * This source code is licensed under the BSD-style license found in the
 * LICENSE file in the root directory of this source tree. An additional grant
 * of patent rights can be found in the PATENTS file in the same directory.
 */
package com.parse.starter;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Switch;

import com.parse.FindCallback;
import com.parse.GetCallback;
import com.parse.LogInCallback;
import com.parse.Parse;
import com.parse.ParseAnalytics;
import com.parse.ParseAnonymousUtils;
import com.parse.ParseException;
import com.parse.ParseObject;
import com.parse.ParseQuery;
import com.parse.ParseUser;
import com.parse.SaveCallback;

import java.util.List;
import java.util.Random;


public class MainActivity extends AppCompatActivity {
  Random rand = new Random();

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);
    /*ParseObject Score = new ParseObject("Score");
    Score.put("username","niro");
    Score.put("score1",95);
    Score.saveInBackground(new SaveCallback() {
      @Override
      public void done(ParseException e) {
        if(e==null)
          Log.i("username","successfully added");
        else
          e.printStackTrace();
      }
    });*/
    ParseQuery<ParseObject> parseQuery =  ParseQuery.getQuery("Score");
    parseQuery.findInBackground(new FindCallback<ParseObject>() {
      @Override
      public void done(List<ParseObject> objects, ParseException e) {
        if(e==null && objects.size()!=0) {
            for(ParseObject object:objects)
            {
              //object.put("score1",(int)Math.floor(Math.random()*(100-1+1)+1));
              object.saveInBackground(new SaveCallback() {
                @Override
                public void done(ParseException e) {

                }
              });
              Log.i("username is :",object.getString("username"));
              Log.i("score1 is :",Integer.toString(object.getInt("score1")));
            }
        }
      }
    });
    /*parseQuery.getInBackground("EBOYxUF2XO", new GetCallback<ParseObject>() {
      @Override
      public void done(ParseObject object, ParseException e) {
        if(e == null && object!= null)
        {
          //object.put("username","chiro");
          object.saveInBackground(new SaveCallback() {
            @Override
            public void done(ParseException e) {
            }
          });
          Log.i("username ",object.getString("username"));

        }
      }
    }); */


    /*ParseObject tweet = new ParseObject("Tweet");
    tweet.put("Tweet_username", "nico");
    tweet.put("Tweets","my fuckin name is nico fkin robin");
    tweet.saveInBackground(new SaveCallback() {
      @Override
      public void done(ParseException e) {
        if(e== null)
        {
          Log.i("username","success");
        }
      }
    });*/
    /*ParseQuery<ParseObject> query = ParseQuery.getQuery("Tweet");
    query.getInBackground("dBONlDnDE3", new GetCallback<ParseObject>() {
      @Override
      public void done(ParseObject object, ParseException e) {
        if(e == null && object != null) {
          //update data and save
          object.put("Tweets","hello");
          object.saveInBackground(new SaveCallback() {
            @Override
            public void done(ParseException e) {
              if(e== null)
              {
                Log.i("Tweets","hello");
              }
            }
          });
          Log.i("tweet is: ", object.getString("Tweets"));
        }
        else
          e.printStackTrace();

    });
      }*/



    ParseAnalytics.trackAppOpenedInBackground(getIntent());
  }

}