package com.example.ruapp.Controller;

import android.content.Context;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.example.ruapp.Model.Student;
import com.example.ruapp.Persistence.DataBase;

import java.util.HashMap;
import java.util.Map;

public class RegisterStudentController {

    Context context;

    public RegisterStudentController(Context context) {
        this.context = context;
    }

    public void resquestRegistration(final Student newStudent,
                                     String confirmPasswordInput) {

        boolean b1 = newStudent.getCPF().matches("[0-9]{11}");
        boolean b2 = newStudent.getnMatricula().matches("[0-9]{8}");
        boolean b3 = newStudent.getPassword().contentEquals(confirmPasswordInput);

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
                    params.put("name", newStudent.getName());
                    params.put("email", newStudent.getEmail());
                    params.put("cpf", newStudent.getCPF());
                    params.put("college_register", newStudent.getnMatricula());
                    params.put("password", newStudent.getPassword());

                    return params;
                }
            };

            RequestQueue requestQueue = Volley.newRequestQueue(context);
            requestQueue.add(postRequest);
        }
    }
}
