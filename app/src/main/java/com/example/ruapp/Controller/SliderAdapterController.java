package com.example.ruapp.Controller;

import android.content.Context;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.example.ruapp.Persistence.DataBase;
import com.example.ruapp.R;
import com.example.ruapp.Model.ItemModel;
import com.example.ruapp.View.USERPackage.SeeMenuPackage.LargeViewModel;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SliderAdapterController {

    Context context;

    public SliderAdapterController(Context context) {
        this.context = context;
    }

    public void settingLargeVIewModel(final List<LargeViewModel> largeViewModelsLunch, final List<LargeViewModel> largeViewModelsDinner){
        final List<ItemModel> lunchFirst = new ArrayList<>();
        final List<ItemModel> lunchSecond = new ArrayList<>();
        final List<ItemModel> lunchThird = new ArrayList<>();
        final List<ItemModel> lunchFourth = new ArrayList<>();
        final List<ItemModel> lunchFifth = new ArrayList<>();

        final List<ItemModel> dinnerFirst = new ArrayList<>();
        final List<ItemModel> dinnerSecond = new ArrayList<>();
        final List<ItemModel> dinnerThird = new ArrayList<>();
        final List<ItemModel> dinnerFourth = new ArrayList<>();

        int day = Calendar.getInstance().get(Calendar.DAY_OF_MONTH);
        int month = Calendar.getInstance().get(Calendar.MONTH);
        int year = Calendar.getInstance().get(Calendar.YEAR);
        final String date = day + "/" + (month+1) + "/" + year;

        String finalHttpUrl = DataBase.getInstance().getHttpServer();

        RequestQueue requestQueue = Volley.newRequestQueue(context);

        StringRequest stringRequest = new StringRequest(Request.Method.POST, finalHttpUrl.concat("get_lunch_menu.php"),
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String serverResponse) {
                        if(serverResponse.isEmpty()){
                            Toast.makeText(context, "Erro ao consultar banco de dados !", Toast.LENGTH_SHORT).show();
                        }
                        if(serverResponse.startsWith("1")){
                            String jsonEncoded = serverResponse.substring(2, serverResponse.length() - 1);
                            JSONObject jsonObject = null;

                            try {
                                jsonObject = new JSONObject(jsonEncoded);
                                lunchFirst.add(new ItemModel(0, jsonObject.get("protein1").toString(), 0));
                                lunchFirst.add(new ItemModel(1, jsonObject.get("protein2").toString(), 0));
                                lunchSecond.add(new ItemModel(0, jsonObject.get("vegetarian").toString(), 0));
                                lunchThird.add(new ItemModel(0, jsonObject.get("rice").toString(), 0));
                                lunchThird.add(new ItemModel(1, jsonObject.get("bean").toString(), 0));
                                lunchThird.add(new ItemModel(2, jsonObject.get("food3").toString(), 0));
                                lunchThird.add(new ItemModel(3, "Farofa", 0));
                                lunchThird.add(new ItemModel(4, jsonObject.get("salad").toString(), 0));
                                lunchFourth.add(new ItemModel(0, jsonObject.get("juice").toString(), 0));
                                lunchFifth.add(new ItemModel(0, jsonObject.get("fruit").toString(), 0));

                                largeViewModelsLunch.add(new LargeViewModel(0,lunchFirst,R.drawable.meat_icon));
                                largeViewModelsLunch.add(new LargeViewModel(1,lunchSecond,R.drawable.vegetarian_icon));
                                largeViewModelsLunch.add(new LargeViewModel(2,lunchThird,R.drawable.food_icon));
                                largeViewModelsLunch.add(new LargeViewModel(3,lunchFourth,R.drawable.juice_icon));
                                largeViewModelsLunch.add(new LargeViewModel(4,lunchFifth,R.drawable.fruit_icon));

                            } catch (JSONException e) {
                                e.printStackTrace();
                            }

                        } else {
                            Toast.makeText(context, "Menu do almoço não encontrado para a data escolhida !", Toast.LENGTH_SHORT).show();
                        }
                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError volleyError) {
                        Toast.makeText(context, "Não foi possível requisitar o servidor !", Toast.LENGTH_SHORT).show();
                    }
                }) {
            @Override
            protected Map<String, String> getParams() {

                // Creating Map String Params.
                Map<String, String> params = new HashMap<String, String>();

                // Adding All values to Params.
                params.put("date", date);

                return params;
            }

        };

        StringRequest stringRequest2 = new StringRequest(Request.Method.POST, finalHttpUrl.concat("get_dinner_menu.php"),
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String serverResponse) {
                        if(serverResponse.isEmpty()){
                            Toast.makeText(context, "Erro ao consultar banco de dados !", Toast.LENGTH_SHORT).show();
                        }
                        if(serverResponse.startsWith("1")){
                            String jsonEncoded = serverResponse.substring(2, serverResponse.length() - 1);
                            JSONObject jsonObject = null;

                            try {
                                jsonObject = new JSONObject(jsonEncoded);
                                dinnerFirst.add(new ItemModel(0, jsonObject.get("soup").toString(), 0));
                                dinnerFirst.add(new ItemModel(1, jsonObject.get("maindish1").toString(), 0));
                                dinnerFirst.add(new ItemModel(2, jsonObject.get("maindish2").toString(), 0));
                                dinnerFirst.add(new ItemModel(3, jsonObject.get("maindish3").toString(), 0));
                                dinnerSecond.add(new ItemModel(0, jsonObject.get("veg1").toString(), 0));
                                dinnerSecond.add(new ItemModel(1, jsonObject.get("veg2").toString(), 0));
                                dinnerSecond.add(new ItemModel(2, jsonObject.get("veg3").toString(), 0));
                                dinnerThird.add(new ItemModel(0, jsonObject.get("pies").toString(), 0));
                                dinnerThird.add(new ItemModel(1, jsonObject.get("cakes").toString(), 0));
                                dinnerFourth.add(new ItemModel(0, jsonObject.get("drink").toString(), 0));

                                largeViewModelsDinner.add(new LargeViewModel(0,dinnerFirst,R.drawable.dinner_icon));
                                largeViewModelsDinner.add(new LargeViewModel(1,dinnerSecond,R.drawable.vegetarian_icon));
                                largeViewModelsDinner.add(new LargeViewModel(2,dinnerThird,R.drawable.pie_icon));
                                largeViewModelsDinner.add(new LargeViewModel(3,dinnerFourth,R.drawable.juice_icon));

                            } catch (JSONException e) {
                                e.printStackTrace();
                            }

                        } else {
                            Toast.makeText(context, "Menu do jantar não encontrado para a data escolhida !", Toast.LENGTH_SHORT).show();
                        }
                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError volleyError) {
                        Toast.makeText(context, "Não foi possível requisitar o servidor !", Toast.LENGTH_SHORT).show();
                    }
                }) {
            @Override
            protected Map<String, String> getParams() {

                // Creating Map String Params.
                Map<String, String> params = new HashMap<String, String>();

                // Adding All values to Params.
                params.put("date", date);

                return params;
            }

        };

        requestQueue.add(stringRequest);
        requestQueue.add(stringRequest2);
    }
}
