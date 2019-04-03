package com.example.ruapp.Controller;

import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.example.ruapp.ADMPackage.AdminMainActivity;
import com.example.ruapp.MainActivity;
import com.example.ruapp.Model.LoggedAdmin;
import com.example.ruapp.Model.LoggedStudent;
import com.example.ruapp.Persistence.DataBase;
import com.example.ruapp.USERPackage.UserMainActivity;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.HashMap;
import java.util.Map;

public class MainActivityController {

    private Context context;

    public MainActivityController(Context context) {
        this.context = context;
    }

    public void tryLogin(final String loginInput, final String passwordInput) {
        if(loginInput.matches("[0-9]{11}")) {

            StringRequest postRequest = new StringRequest(Request.Method.POST, DataBase.getInstance().getHttpServer().concat("login.php"),
                    new Response.Listener<String>()
                    {
                        @Override
                        public void onResponse(String serverResponse) {
                            if(serverResponse == null) {
                                Toast.makeText(context, "Erro ao consultar banco de dados !", Toast.LENGTH_SHORT).show();
                            } else if(serverResponse.equals("null")){
                                Toast.makeText(context, "Dados não ativados/cadastrados !", Toast.LENGTH_SHORT).show();
                            } else {
                                String jsonEncoded = serverResponse.substring(4, serverResponse.length() - 1);
                                JSONObject jsonObject = null;
                                try {
                                    jsonObject = new JSONObject(jsonEncoded);
                                } catch (JSONException e) {
                                    e.printStackTrace();
                                }

                                Intent newIntent;

                                if(serverResponse.startsWith("ADM[")){
                                    String adminId = null, email = null, cpf = null;
                                    try {
                                        adminId = jsonObject.get("admin_id").toString();
                                        email = jsonObject.get("email").toString();
                                        cpf = jsonObject.get("cpf").toString();
                                    } catch (JSONException e) {
                                        e.printStackTrace();
                                    }

                                    LoggedAdmin.getInstance().setAdminId(adminId);
                                    LoggedAdmin.getInstance().setEmail(email);
                                    LoggedAdmin.getInstance().setCpf(cpf);

                                    newIntent = new Intent(context, AdminMainActivity.class);
                                } else {
                                    String userId = null, fullName = null, email = null, cpf = null, collegeRegister = null;
                                    try {
                                        userId = jsonObject.get("user_id").toString();
                                        fullName = jsonObject.get("name").toString();
                                        email = jsonObject.get("email").toString();
                                        cpf = jsonObject.get("cpf").toString();
                                        collegeRegister = jsonObject.get("college_register").toString();
                                    } catch (JSONException e) {
                                        e.printStackTrace();
                                    }

                                    LoggedStudent.getInstance().setUserId(userId);
                                    LoggedStudent.getInstance().setFullName(fullName);
                                    LoggedStudent.getInstance().setEmail(email);
                                    LoggedStudent.getInstance().setCpf(cpf);
                                    LoggedStudent.getInstance().setCollegeRegister(collegeRegister);

                                    newIntent = new Intent(context, UserMainActivity.class);
                                }
                                context.startActivity(newIntent);
                            }
                        }
                    },
                    new Response.ErrorListener()
                    {
                        @Override
                        public void onErrorResponse(VolleyError error) { }
                    }
            ) {
                @Override
                protected Map<String, String> getParams()
                {
                    Map<String, String>  params = new HashMap<String, String>();
                    params.put("cpf", loginInput);
                    params.put("password", passwordInput);

                    return params;
                }
            };

            RequestQueue requestQueue = Volley.newRequestQueue(context);
            requestQueue.add(postRequest);
        }
    }
}
