package com.example.ruapp.Controller;

import android.content.Context;
import android.util.Log;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.example.ruapp.ADMPackage.RegisterRequestActivity;
import com.example.ruapp.ADMPackage.RegisterRequestPackage.MyRecViewAdapter;
import com.example.ruapp.Model.LoggedAdmin;
import com.example.ruapp.Model.Student;
import com.example.ruapp.Persistence.DataBase;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.ResourceBundle;

public class RegisterRequestController {
    Context context;

    public RegisterRequestController(Context context) {
        this.context = context;
    }


    public void fillStudentList(final List<Student> studentsList) {
        String finalHttpUrl = DataBase.getInstance().getHttpServer().concat("deactivated_users.php");

        StringRequest stringRequest = new StringRequest(Request.Method.POST, finalHttpUrl,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String serverResponse) {
                        if(!serverResponse.isEmpty()){
                            if(serverResponse.startsWith("1")){
                                String jsonEncoded = serverResponse.substring(1);
                                Toast.makeText(context, jsonEncoded, Toast.LENGTH_SHORT).show();
                                try
                                {
                                    JSONArray jsonArray = new JSONArray(jsonEncoded);

                                    for (int i = 0; i < jsonArray.length(); i++) {

                                        JSONObject jsonObject = jsonArray.getJSONObject(i);

                                        studentsList.add(new Student(jsonObject.get("name").toString(),
                                                jsonObject.get("cpf").toString(),
                                                jsonObject.get("college_register").toString()));
                                    }
                                }
                                catch (JSONException e)
                                {
                                    Toast.makeText(context, e.getMessage(), Toast.LENGTH_SHORT).show();
                                    e.printStackTrace();
                                }

                            } else {
                                Toast.makeText(context, serverResponse, Toast.LENGTH_SHORT).show();
                            }
                        } else {
                            Toast.makeText(context, "Resposta vazia !", Toast.LENGTH_SHORT).show();
                        }
                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError volleyError) {
                        Log.i("zap", volleyError.getMessage());
                        Toast.makeText(context, "Não foi possível requisitar o servidor !", Toast.LENGTH_SHORT).show();
                    }
                }) {
            @Override
            protected Map<String, String> getParams() {

                // Creating Map String Params.
                Map<String, String> params = new HashMap<String, String>();

                // Adding All values to Params.
                params.put("cpf", LoggedAdmin.getInstance().getCpf());

                return params;
            }

        };

        RequestQueue requestQueue = Volley.newRequestQueue(context);
        requestQueue.add(stringRequest);
    }

    public void deleteUser(final String getnMatricula) {
        String finalHttpUrl = DataBase.getInstance().getHttpServer().concat("delete_user.php");

        StringRequest stringRequest = new StringRequest(Request.Method.POST, finalHttpUrl,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String serverResponse) {

                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError volleyError) {
                        Log.i("zap", volleyError.getMessage());
                        Toast.makeText(context, "Não foi possível requisitar o servidor !", Toast.LENGTH_SHORT).show();
                    }
                }) {
            @Override
            protected Map<String, String> getParams() {

                // Creating Map String Params.
                Map<String, String> params = new HashMap<String, String>();

                // Adding All values to Params.
                params.put("cpf", LoggedAdmin.getInstance().getCpf());
                params.put("college_register", getnMatricula);

                return params;
            }

        };

        RequestQueue requestQueue = Volley.newRequestQueue(context);
        requestQueue.add(stringRequest);
    }

    public void updateUser(final String getnMatricula) {
        String finalHttpUrl = DataBase.getInstance().getHttpServer().concat("update_deactivated_users.php");

        StringRequest stringRequest = new StringRequest(Request.Method.POST, finalHttpUrl,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String serverResponse) {

                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError volleyError) {
                        Log.i("zap", volleyError.getMessage());
                        Toast.makeText(context, "Não foi possível requisitar o servidor !", Toast.LENGTH_SHORT).show();
                    }
                }) {
            @Override
            protected Map<String, String> getParams() {

                // Creating Map String Params.
                Map<String, String> params = new HashMap<String, String>();

                // Adding All values to Params.
                params.put("cpf", LoggedAdmin.getInstance().getCpf());
                params.put("college_register", getnMatricula);

                return params;
            }

        };

        RequestQueue requestQueue = Volley.newRequestQueue(context);
        requestQueue.add(stringRequest);
    }
}