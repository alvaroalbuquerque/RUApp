package com.example.ruapp.Controller;

import android.content.Context;
import android.content.Intent;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.example.ruapp.ADMPackage.AdminMainActivity;
import com.example.ruapp.Model.LoggedAdmin;
import com.example.ruapp.Model.LoggedStudent;
import com.example.ruapp.Persistence.DataBase;
import com.example.ruapp.RegisterStudentActivity;
import com.example.ruapp.USERPackage.UserMainActivity;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.HashMap;
import java.util.Map;

public class RegisterStudentController {

    Context context;

    public RegisterStudentController(Context context) {
        this.context = context;
    }

    public void resquestRegistration(final String nameInput, final String emailInput, final String cpfInput,
                                     final String collegeRegisterInput, final String passwordInput,
                                     String confirmPasswordInput) {

        boolean b1 = cpfInput.matches("[0-9]{11}");
        boolean b2 = collegeRegisterInput.matches("[0-9]{8}");
        boolean b3 = passwordInput.contentEquals(confirmPasswordInput);

        if(b1 && b2 && b3){
            StringRequest postRequest = new StringRequest(Request.Method.POST, DataBase.getInstance().getHttpServer().concat("register_user.php"),
                    new Response.Listener<String>()
                    {
                        @Override
                        public void onResponse(String serverResponse) {
                            Toast.makeText(context, serverResponse, Toast.LENGTH_SHORT).show();
                        }
                    },
                    new Response.ErrorListener()
                    {
                        @Override
                        public void onErrorResponse(VolleyError error) {
                            Toast.makeText(context, "Erro ao acessar o servidor !", Toast.LENGTH_SHORT).show();
                        }
                    }
            ) {
                @Override
                protected Map<String, String> getParams()
                {
                    Map<String, String>  params = new HashMap<String, String>();
                    params.put("name", nameInput);
                    params.put("email", emailInput);
                    params.put("cpf", cpfInput);
                    params.put("college_register", collegeRegisterInput);
                    params.put("password", passwordInput);

                    return params;
                }
            };

            RequestQueue requestQueue = Volley.newRequestQueue(context);
            requestQueue.add(postRequest);
        }
    }
}
