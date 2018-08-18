package com.biggerThanGreater.willy.rhymer;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.List;

/**
 * Created by willy on 2017-07-30.
 */

public class WordListAdapter extends BaseAdapter {

    private Context context;
    private List<Word> wordList;

    public WordListAdapter(Context context, List<Word> wordList) {
        this.context = context;
        this.wordList = wordList;
    }

    @Override
    public int getCount() {
        return wordList.size();
    }

    @Override
    public Object getItem(int position) {
        return wordList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View v = View.inflate(context, R.layout.word, null);

        TextView result = (TextView) v.findViewById(R.id.result);
        TextView popular = (TextView) v.findViewById(R.id.popular);
        TextView mark = (TextView) v.findViewById(R.id.mark);
        TextView property = (TextView) v.findViewById(R.id.property);

        result.setText(wordList.get(position).getResult());
        popular.setText(wordList.get(position).getPopular());
        mark.setText(wordList.get(position).getMark());
        property.setText(wordList.get(position).getProperty());

        v.setTag(wordList.get(position).getResult());
        return v;
    }
}
