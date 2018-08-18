package com.biggerThanGreater.willy.rhymer;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;
import android.widget.TextView;

import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;
import com.google.android.gms.ads.MobileAds;

import org.json.JSONArray;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class resultActivity extends AppCompatActivity {
    private AdView mAdView;

    private ListView listView;
    private WordListAdapter adapter;
    private List<Word> wordList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);
        MobileAds.initialize(this, "ca-app-pub-4075622845853806~1953278295");

        mAdView = (AdView) findViewById(R.id.adView);
        AdRequest adRequest = new AdRequest.Builder().build();
        mAdView.loadAd(adRequest);

        TextView textView = (TextView) findViewById(R.id.textView);

        Intent intent = getIntent();
        boolean[] option = new boolean[8];

        listView = (ListView) findViewById(R.id.resultView);
        wordList = new ArrayList<Word>();


        adapter = new WordListAdapter(getApplicationContext(), wordList);
        listView.setAdapter(adapter);

        try {
            JSONObject jsonObject = new JSONObject(intent.getStringExtra("wordList"));
            JSONArray jsonArray = jsonObject.getJSONArray(("response"));
            int count = 0;
            String result, popular, mark, property;

            while(count < jsonArray.length())
            {
                JSONObject object = jsonArray.getJSONObject(count);
                result = object.getString("result");
                popular = object.getString("popular");
                mark = object.getString("mark");
                property = object.getString("property");
                Word word = new Word(result, popular, mark, property);
                wordList.add(word);
                count++;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
