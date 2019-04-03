package com.example.ruapp.Controller;

import android.app.DatePickerDialog;
import android.content.Context;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.example.ruapp.Model.LoggedStudent;
import com.example.ruapp.Persistence.DataBase;
import com.example.ruapp.USERPackage.BookActivity;

import java.util.Calendar;
import java.util.HashMap;
import java.util.Map;

public class BookController {

    private Context context;

    public BookController(Context context) {
        this.context = context;
    }

    public void showDatePickerDialog(final TextView selectedDateTextView, final Button scheduleThisDayButton, final Button unscheduleThisDayButton) {
        DatePickerDialog datePickerDialog = new DatePickerDialog(
                context,
                new DatePickerDialog.OnDateSetListener() {
                    @Override
                    public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
                        month = month + 1;
                        String date = dayOfMonth + "/" + month + "/" + year;
                        selectedDateTextView.setText(date);
                        scheduleThisDayButton.setVisibility(View.VISIBLE);
                        unscheduleThisDayButton.setVisibility(View.VISIBLE);
                    }
                },
                Calendar.getInstance().get(Calendar.YEAR),
                Calendar.getInstance().get(Calendar.MONTH),
                Calendar.getInstance().get(Calendar.DAY_OF_MONTH));
        datePickerDialog.show();
    }

    public void manageSchedule(String selectedDate, boolean lunchSelected, boolean dinnerSelected, boolean isInsert) {
        String userIdInput = LoggedStudent.getInstance().getUserId();

        if(lunchSelected) {
            makeSchedule(userIdInput, selectedDate, "lunch", isInsert);
        }
        if(dinnerSelected) {
            makeSchedule(userIdInput, selectedDate, "dinner", isInsert);
        }
        
        if(!lunchSelected && !dinnerSelected){
            Toast.makeText(context, "Selecione pelo menos um !", Toast.LENGTH_SHORT).show();
        }
    }

    private void makeSchedule(final String userIdInput, final String selectedDate, final String typeInput, boolean isInsert) {
        String finalHttpUrl;
        if(isInsert){
            finalHttpUrl = DataBase.getInstance().getHttpServer().concat("insert_schedule.php");
        } else {
            finalHttpUrl = DataBase.getInstance().getHttpServer().concat("delete_schedule.php");
        }

        StringRequest stringRequest = new StringRequest(Request.Method.POST, finalHttpUrl,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String serverResponse) {
                        if (!serverResponse.isEmpty()) {
                            Log.i("zap", serverResponse);
                            Toast.makeText(context, serverResponse, Toast.LENGTH_SHORT).show();
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
                params.put("user_id", userIdInput);
                params.put("date", selectedDate);
                params.put("type", typeInput);

                return params;
            }

        };

        RequestQueue requestQueue = Volley.newRequestQueue(context);
        requestQueue.add(stringRequest);
    }
}
