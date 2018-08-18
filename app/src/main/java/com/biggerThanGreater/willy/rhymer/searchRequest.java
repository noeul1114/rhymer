package com.biggerThanGreater.willy.rhymer;

import com.android.volley.Response;
import com.android.volley.toolbox.StringRequest;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by willy on 2017-07-31.
 */

public class searchRequest extends StringRequest {

    final static private String URL = "http://127.0.0.1/search.php";
    private Map<String, String> parameters;

    public searchRequest(String searchText, Response.Listener<String> listener) {
        super(Method.POST, URL, listener, null);
        parameters = new HashMap<>();
        parameters.put("searchText", searchText);
    }

    @Override
    public Map<String, String> getParams() {
        return parameters;
    }
}
