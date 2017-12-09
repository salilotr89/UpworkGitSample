package com.adam.upwork.upwork.controller;

import com.adam.upwork.upwork.dto.GitCommitDTO;
import com.fasterxml.jackson.databind.ObjectMapper;
import jdk.nashorn.internal.parser.JSONParser;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.io.*;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.ProtocolException;
import java.net.URL;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by SadiqAli on 12/9/2017.
 */
@Controller
@RequestMapping
public class GithubController {


    @RequestMapping(method = RequestMethod.GET)
    public @ResponseBody
    List<GitCommitDTO> fetchCommitsFromGit(@RequestParam(value = "name", required = false, defaultValue = "Stranger") String name) {

        JSONArray json = null;
        try {
            json = readJsonFromUrl("https://api.github.com/repos/angular/angular/commits");
        } catch (IOException e) {
            e.printStackTrace();
        }
        List<GitCommitDTO> jsonObjects = new ArrayList<>();
        ObjectMapper mapper = new ObjectMapper();


        for (int i = 0; i < json.length(); i++) {
            try {
                jsonObjects.add(mapper.readValue(json.get(i).toString(), GitCommitDTO.class));
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        return jsonObjects;
    }

    private static String readAll(Reader rd) throws IOException {
        StringBuilder sb = new StringBuilder();
        int cp;
        while ((cp = rd.read()) != -1) {
            sb.append((char) cp);
        }
        return sb.toString();
    }

    public static JSONArray readJsonFromUrl(String url) throws IOException, JSONException {
        InputStream is = new URL(url).openStream();
        try {
            BufferedReader rd = new BufferedReader(new InputStreamReader(is, Charset.forName("UTF-8")));
            String jsonText = readAll(rd);
            JSONArray json = new JSONArray(jsonText);
            return json;
        } finally {
            is.close();
        }
    }

}
