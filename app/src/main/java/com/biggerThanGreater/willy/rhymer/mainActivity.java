package com.biggerThanGreater.willy.rhymer;

import android.content.Intent;
import android.os.AsyncTask;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;

import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;
import com.google.android.gms.ads.MobileAds;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.net.HttpURLConnection;
import java.net.URL;

public class mainActivity extends AppCompatActivity {
    private AdView mAdView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        MobileAds.initialize(this, "ca-app-pub-4075622845853806~1953278295");

        mAdView = (AdView) findViewById(R.id.adView);
        AdRequest adRequest = new AdRequest.Builder().build();
        mAdView.loadAd(adRequest);

        Button insturctButton = (Button) findViewById(R.id.instructButton);
        Button button = (Button) findViewById(R.id.searchButton);

        insturctButton.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                Intent instructIntent = new Intent(mainActivity.this, instruct.class);
                startActivity(instructIntent);
            }
        });

        button.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {



                final EditText findText = (EditText) findViewById(R.id.searchText);

                final CheckBox option1 = (CheckBox) findViewById(R.id.choSung);
                final CheckBox option2 = (CheckBox) findViewById(R.id.jungSung);
                final CheckBox option3 = (CheckBox) findViewById(R.id.jhongSung);
                final CheckBox option4 = (CheckBox) findViewById(R.id.peopleName);
                final CheckBox option5 = (CheckBox) findViewById(R.id.placeName);
                final CheckBox option6 = (CheckBox) findViewById(R.id.brandName);
                final CheckBox option7 = (CheckBox) findViewById(R.id.choSungSimilar);
                final CheckBox option8 = (CheckBox) findViewById(R.id.jungSungSimilar);

                StringBuilder searchTextOption = new StringBuilder();
                StringBuilder wordClassify = new StringBuilder();
                StringBuilder unicodeTest = new StringBuilder();

                if (option1.isChecked()) { searchTextOption.append("t"); }
                else { searchTextOption.append("f"); }
                if (option2.isChecked()) { searchTextOption.append("t"); }
                else { searchTextOption.append("f"); }
                if (option3.isChecked()) { searchTextOption.append("t"); }
                else { searchTextOption.append("f"); }
                if (option4.isChecked()) { searchTextOption.append("t"); }
                else { searchTextOption.append("f"); }
                if (option5.isChecked()) { searchTextOption.append("t"); }
                else { searchTextOption.append("f"); }
                if (option6.isChecked()) { searchTextOption.append("t"); }
                else { searchTextOption.append("f"); }
                if (option7.isChecked()) { searchTextOption.append("t"); }
                else { searchTextOption.append("f"); }
                if (option8.isChecked()) { searchTextOption.append("t"); }
                else { searchTextOption.append("f"); }

                unicodeTest.append(findText.getText());

                //혹시나 append 하는 과정에서 공백 문자가 섞여있을경우 공백 걸러낼수 있도록 할것
                for (int i = 0; i < unicodeTest.length(); i++ ) {
                    if ( 4352 <= unicodeTest.codePointAt(i) && 4607 >= unicodeTest.codePointAt(i)) {
                        wordClassify.append("A");
                    }else if (43360 <= unicodeTest.codePointAt(i) && 43388 >= unicodeTest.codePointAt(i)) {
                        wordClassify.append("B");
                    }else if (55216 <= unicodeTest.codePointAt(i) && 55291 >= unicodeTest.codePointAt(i)) {
                        wordClassify.append("C");
                    }else if (65281 <= unicodeTest.codePointAt(i) && 65518 >= unicodeTest.codePointAt(i)) {
                        wordClassify.append("D");
                    }else if (12593 <= unicodeTest.codePointAt(i) && 12622 >= unicodeTest.codePointAt(i)) {
                        if (12595 == unicodeTest.codePointAt(i) || 12597 == unicodeTest.codePointAt(i)) {
                            wordClassify.append("Z");
                        }else if (12598 == unicodeTest.codePointAt(i) || 12612 == unicodeTest.codePointAt(i)) {
                            wordClassify.append("Z");
                        }else if (12602 <= unicodeTest.codePointAt(i) && 12608 >= unicodeTest.codePointAt(i)) {
                            wordClassify.append("Z");
                        }else {
                            wordClassify.append("I");
                        }
                    }else if (12623 <= unicodeTest.codePointAt(i) && 12643 >= unicodeTest.codePointAt(i)) {
                        wordClassify.append("I");
                    }else if (44032 <= unicodeTest.codePointAt(i) && 55215 >= unicodeTest.codePointAt(i)) {
                        wordClassify.append("U");
                    }else {
                        wordClassify.append("X");
                    }
                }

                if ( unicodeTest.length() >= 1 && unicodeTest.length() <= 5)
                {
                    int wordCount = 0;
                    int wordCheck = 0;
                    wordCount = wordClassify.length();

                    for (int i = 0; i < wordCount; i++ ) {
                        if ( wordClassify.substring(i,i+1).equals("X")) {
                            wordCheck++;
                            AlertDialog.Builder builder = new AlertDialog.Builder(mainActivity.this);
                            builder.setMessage("한글 이외의 문자는 지원하지 않습니다")
                                    .setNegativeButton("다시 시도", null)
                                    .create()
                                    .show();
                            break;
                        } else if (wordClassify.substring(i,i+1).equals("A") || wordClassify.substring(i,i+1).equals("B") || wordClassify.substring(i,i+1).equals("C") || wordClassify.substring(i,i+1).equals("D")) {
                            wordCheck++;
                            AlertDialog.Builder builder = new AlertDialog.Builder(mainActivity.this);
                            builder.setMessage("호환되지 않는 한글 입력입니다")
                                    .setNegativeButton("다시 시도", null)
                                    .create()
                                    .show();
                            break;
                        } else if (wordClassify.substring(i,i+1).equals("Z")) {
                            wordCheck++;
                            AlertDialog.Builder builder = new AlertDialog.Builder(mainActivity.this);
                            builder.setMessage("특수종성만 입력하실수는 없습니다")
                                    .setNegativeButton("다시 시도", null)
                                    .create()
                                    .show();
                            break;
                        }
                    }

                    if (wordCheck==0) {

                        StringBuilder codePoint = new StringBuilder();

                        for(int q = 0; q < wordClassify.length(); q++) {
                            codePoint.append(String.valueOf(unicodeTest.codePointAt(q)));
                        }

                        String[] bridge = {searchTextOption.toString(), wordClassify.toString(), findText.getText().toString(), String.valueOf(unicodeTest.length()), codePoint.toString()};

                        new BackgroundTask().execute(bridge);

                    }
                } else {
                    AlertDialog.Builder builder = new AlertDialog.Builder(mainActivity.this);
                    builder.setMessage("필요 입력 글자수는 최소 1글자에서 최대 5글자입니다")
                            .setNegativeButton("다시 시도", null)
                            .create()
                            .show();
                }

            }
        });


    }
    class BackgroundTask extends AsyncTask<Object , Void, String>
    {
        String target;

        @Override
        protected void onPreExecute() {
            target = "http://willypower.cafe24.com/search.php";
        }

        @Override
        protected String doInBackground(Object... searchText) {

            try {
                String option = (String) searchText[0];
                String classify = (String) searchText[1];
                String word = (String) searchText[2];
                String count = (String) searchText[3];
                String code = (String) searchText[4];

                URL url = new URL(target+"?option=" + option + "&classify=" + classify + "&word=" + word + "&count=" + count+ "&code=" + code);
                HttpURLConnection httpURLConnection = (HttpURLConnection) url.openConnection();

                httpURLConnection.setRequestMethod("GET");
                httpURLConnection.setConnectTimeout(5000);
                httpURLConnection.setReadTimeout(5000);

                InputStream inputStream = httpURLConnection.getInputStream();
                BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
                String temp;
                temp = bufferedReader.readLine();
                bufferedReader.close();
                inputStream.close();
                httpURLConnection.disconnect();
                return temp.toString();
            }   catch (Exception e) {

                StringWriter sw = new StringWriter();
                e.printStackTrace(new PrintWriter(sw));
                String exeptionAsString = sw.toString();

                return exeptionAsString;
            }
        }

        @Override
        public void onProgressUpdate(Void... values) {

            super.onProgressUpdate(values);
        }

        @Override
        public void onPostExecute(String result) {
            Intent intent = new Intent(mainActivity.this, resultActivity.class);
            intent.putExtra("wordList", result);
            mainActivity.this.startActivity(intent);
        }

        @Override
        public void onCancelled() {
            super.onCancelled();
        }
    }


}
