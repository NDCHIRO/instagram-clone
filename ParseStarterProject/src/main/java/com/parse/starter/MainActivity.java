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


public class MainActivity extends AppCompatActivity {


  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);

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
    ParseQuery<ParseObject> query = ParseQuery.getQuery("Tweet");
    query.getInBackground("dBONlDnDE3", new GetCallback<ParseObject>() {
      @Override
      public void done(ParseObject object, ParseException e) {
        if(e == null && object != null) {
          //object.put("Tweet_username", "nico");
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
          //Log.i("username is: ", object.getString("Tweet_username"));
          Log.i("tweet is: ", object.getString("Tweets"));
        }
        else
          e.printStackTrace();
      }


    });
    ParseAnalytics.trackAppOpenedInBackground(getIntent());
  }

}