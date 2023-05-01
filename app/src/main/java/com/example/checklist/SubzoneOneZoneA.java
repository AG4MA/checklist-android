package com.example.checklist;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.toolbox.Volley;
import com.example.checklist.apis.ReportCodeApi;
import com.example.checklist.controllers.ReportCodeController;
import com.example.checklist.model.entities.ReportCode;
import com.example.checklist.utils.RetrofitHelper;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;

import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class SubzoneOneZoneA extends AppCompatActivity {

    List<String> reportCode = new ArrayList<>();
    HashMap<String,String> reportCodeHash = new HashMap<String,String>();
    public String reportCodeS;
    public TextView date,time,dayTimePeriod;
    private EditText hbLevel,j2003Level,tkLevel;
    private EditText portataValue,phValue,tocValue,codValue,aromaValue,mtbValue,hplcTocValue,elioValue;
    private Switch j2003Status,comprStatus,sabbiaStatus,carboneStatus,controlavaggioStatus,selettoreStatus,schiumaStatus;
    private CheckBox nessunaSoluzione,soluzioneUno,soluzioneDue,soluzioneTre,soluzioneQuattro;
    private RadioGroup mainPumpChoosen,filterPumpChoosen,uscitaAcquaChoosen,tkChoosen;


    //bottoni test
    private Button reportCodeButton, httpButton;

    public String currentDate;
    public String currentTime;


    // Instantiate the RequestQueue.




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        //perché onCreate richiama classe padre?
        super.onCreate(savedInstanceState);
        setContentView(R.layout.question_list_items_subzoneonezonea);
        Context context = getApplicationContext();
        RequestQueue queue = Volley.newRequestQueue(this);

        date = findViewById(R.id.today_date);
        time = findViewById(R.id.now_time);
        dayTimePeriod = findViewById(R.id.day_time_periods);

        /*
        Calendar now = Calendar.getInstance();
        int year = now.get(Calendar.YEAR);
        int month = now.get(Calendar.MONTH) + 1; // Note: zero based!
        int day = now.get(Calendar.DAY_OF_MONTH);
        int hour = now.get(Calendar.HOUR_OF_DAY);
        int minute = now.get(Calendar.MINUTE);
        int second = now.get(Calendar.SECOND);
        int millis = now.get(Calendar.MILLISECOND);*/

        //data e ora
        Calendar now = Calendar.getInstance();
        int year = now.get(Calendar.YEAR);
        int month = now.get(Calendar.MONTH) + 1; // Note: zero based!
        int day = now.get(Calendar.DAY_OF_MONTH);
        int hour = now.get(Calendar.HOUR_OF_DAY);
        int minute = now.get(Calendar.MINUTE);
        currentDate = new SimpleDateFormat("MM/dd/yyyy", Locale.getDefault()).format(new Date());
        date.setText(currentDate);
        currentTime = new SimpleDateFormat("hh:mm", Locale.getDefault()).format(new Date());
        time.setText(currentTime);
        if (hour>12) {
            dayTimePeriod.setText("pomeriggio");
        } else dayTimePeriod.setText("mattino");

        hbLevel = findViewById(R.id.hb_level);
        j2003Status = findViewById(R.id.j2003);
        j2003Level = findViewById(R.id.j2003_level);
        mainPumpChoosen = findViewById(R.id.main_pump_choosen); //mi serve un valore tra i due
        filterPumpChoosen = findViewById(R.id.filter_pump_choosen); //mi serve un valore tra i due
        portataValue = findViewById(R.id.portata_value);
        comprStatus = findViewById(R.id.compressore_status);
        phValue = findViewById(R.id.ph_value);
        sabbiaStatus = findViewById(R.id.sabbia_status);
        carboneStatus = findViewById(R.id.carbone_status);
        controlavaggioStatus = findViewById(R.id.controlavaggio_status);
        uscitaAcquaChoosen = findViewById(R.id.uscita_acqua_choosen);
        selettoreStatus = findViewById(R.id.selettore_status);
        tocValue = findViewById(R.id.toc_value);
        codValue = findViewById(R.id.cod_value);
        nessunaSoluzione = findViewById(R.id.nessuna_soluzione);
        soluzioneUno = findViewById(R.id.soluzione_uno);
        soluzioneDue = findViewById(R.id.soluzione_due);
        soluzioneTre = findViewById(R.id.soluzione_tre);
        soluzioneQuattro = findViewById(R.id.soluzione_quattro);
        aromaValue = findViewById(R.id.aroma_value);
        mtbValue = findViewById(R.id.mtb_value);
        hplcTocValue = findViewById(R.id.hplc_toc_value);
        elioValue = findViewById(R.id.elio_value);
        tkChoosen = findViewById(R.id.tk_choosen);
        tkLevel = findViewById(R.id.tk_level);
        schiumaStatus = findViewById(R.id.schiuma_status);




        reportCodeButton = findViewById(R.id.report_code_button);
        reportCodeButton.setOnClickListener(new View.OnClickListener() {
            // The code in this method will be executed when the numbers View is clicked on.
            @Override
            public void onClick(View view) {

                //int myInt = myBoolean ? 1 : 0;

                reportCodeHash.put("day",String.valueOf(day));
                reportCodeHash.put("month",String.valueOf(month));
                reportCodeHash.put("year",String.valueOf(year));
                reportCodeHash.put("hour",String.valueOf(hour));
                reportCodeHash.put("minute",String.valueOf(minute));
                reportCodeHash.put("hbLevel",String.valueOf(hbLevel.getText()));
                reportCodeHash.put("j2003Status",String.valueOf(j2003Status.isChecked()));
                reportCodeHash.put("j2003Level",String.valueOf(j2003Level.getText()));
                RadioButton button = findViewById(mainPumpChoosen.getCheckedRadioButtonId());
                reportCodeHash.put("mainPumpChoosen",String.valueOf(button.getText()));
                RadioButton button1 = findViewById(filterPumpChoosen.getCheckedRadioButtonId());
                reportCodeHash.put("filterPumpChoosen",String.valueOf(button1.getText()));
                reportCodeHash.put("portataValue",String.valueOf(portataValue.getText()));
                reportCodeHash.put("comprStatus",String.valueOf(comprStatus.isChecked()));
                reportCodeHash.put("phValue",String.valueOf(phValue.getText()));
                reportCodeHash.put("sabbiaStatus",String.valueOf(sabbiaStatus.isChecked()));
                reportCodeHash.put("carboneStatus",String.valueOf(carboneStatus.isChecked()));
                reportCodeHash.put("controlavaggioStatus",String.valueOf(controlavaggioStatus.isChecked()));
                RadioButton button2 = findViewById(uscitaAcquaChoosen.getCheckedRadioButtonId());
                reportCodeHash.put("uscitaAcquaChoosen",String.valueOf(button2.getText()));
                reportCodeHash.put("selettoreStatus",String.valueOf(selettoreStatus.isChecked()));
                reportCodeHash.put("tocValue",String.valueOf(tocValue.getText()));
                reportCodeHash.put("codValue",String.valueOf(codValue.getText()));
                if (nessunaSoluzione.isChecked()) {reportCodeHash.put("nessunaSoluzione", "true");} else {reportCodeHash.put("nessunaSoluzione", "false");}
                if (soluzioneUno.isChecked()) {reportCodeHash.put("soluzioneUno", "true");} else {reportCodeHash.put("soluzioneUno", "false");}
                if (soluzioneDue.isChecked()) {reportCodeHash.put("soluzioneDue", "true");} else {reportCodeHash.put("soluzioneDue", "false");}
                if (soluzioneTre.isChecked()) {reportCodeHash.put("soluzioneTre", "true");} else {reportCodeHash.put("soluzioneTre", "false");}
                if (soluzioneQuattro.isChecked()) {reportCodeHash.put("soluzioneQuattro", "true");} else {reportCodeHash.put("soluzioneQuattro", "false");}
                reportCodeHash.put("aromaValue",String.valueOf(aromaValue.getText()));
                reportCodeHash.put("mtbValue",String.valueOf(mtbValue.getText()));
                reportCodeHash.put("hplcTocValue",String.valueOf(hplcTocValue.getText()));
                reportCodeHash.put("elioValue",String.valueOf(elioValue.getText()));
                RadioButton button3 = findViewById(tkChoosen.getCheckedRadioButtonId());
                reportCodeHash.put("tkChoosen",String.valueOf(button3.getText()));
                reportCodeHash.put("tkLevel",String.valueOf(tkLevel.getText()));
                reportCodeHash.put("schiumaStatus",String.valueOf(schiumaStatus.isChecked()));




                /*RadioButton button = findViewById(mainPumpChoosen.getCheckedRadioButtonId());
                RadioButton button1 = findViewById(filterPumpChoosen.getCheckedRadioButtonId());
                RadioButton button2 = findViewById(uscitaAcquaChoosen.getCheckedRadioButtonId());
                RadioButton button3 = findViewById(tkChoosen.getCheckedRadioButtonId());


                if (nessunaSoluzione.isChecked()) {nessunaSoluzione = 1;} else {nessunaSoluzione = 0;}
                if (nessunaSoluzione.isChecked()) {nessunaSoluzione = 1;} else {nessunaSoluzione = 0;}
                if (nessunaSoluzione.isChecked()) {nessunaSoluzione = 1;} else {nessunaSoluzione = 0;}
                if (nessunaSoluzione.isChecked()) {nessunaSoluzione = 1;} else {nessunaSoluzione = 0;}


                String reportCodeS=(new StringBuilder())
                        .append(day)
                        .append(month)
                        .append(year)
                        .append(hour)
                        .append(minute)
                        .append(hbLevel.getText())
                        .append(j2003Status.isChecked())
                        .append(j2003Level.getText())
                        .append(button.getText())
                        .append(filterPumpChoosen.getCheckedRadioButtonId())
                        .append(button1.getText())
                        .append(portataValue.getText())
                        .append(comprStatus.isChecked())
                        .append(phValue.getText())
                        .append(sabbiaStatus.isChecked())
                        .append(carboneStatus.isChecked())
                        .append(controlavaggioStatus.isChecked())
                        .append(button2.getText())
                        .append(selettoreStatus.isChecked())
                        .append(tocValue.getText())
                        .append(codValue.getText())
                        .append(day)
                        .append(day)
                        .append(day)
                        .append(day)
                        .append(day)
                        .append(aromaValue.getText())
                        .append(mtbValue.getText())
                        .append(hplcTocValue.getText())
                        .append(elioValue.getText())
                        .append(button3.getText())
                        .append(tkLevel.getText())
                        .append(schiumaStatus.isChecked())
                        .toString();*/


                /*reportCode.removeAll(reportCode);
                reportCode.add(String.valueOf(day));
                reportCode.add(String.valueOf(month));
                reportCode.add(String.valueOf(year));
                reportCode.add(String.valueOf(hour));
                reportCode.add(String.valueOf(minute));
                reportCode.add(String.valueOf(hbLevel.getText()));
                reportCode.add(String.valueOf(j2003Status.isChecked()));
                reportCode.add(String.valueOf(j2003Level.getText()));
                RadioButton button = findViewById(mainPumpChoosen.getCheckedRadioButtonId());
                reportCode.add(String.valueOf(button.getText()));
                RadioButton button1 = findViewById(filterPumpChoosen.getCheckedRadioButtonId());
                reportCode.add(String.valueOf(button1.getText()));
                reportCode.add(String.valueOf(portataValue.getText()));
                reportCode.add(String.valueOf(comprStatus.isChecked()));
                reportCode.add(String.valueOf(phValue.getText()));
                reportCode.add(String.valueOf(sabbiaStatus.isChecked()));
                reportCode.add(String.valueOf(carboneStatus.isChecked()));
                reportCode.add(String.valueOf(controlavaggioStatus.isChecked()));
                RadioButton button2 = findViewById(uscitaAcquaChoosen.getCheckedRadioButtonId());
                reportCode.add(String.valueOf(button2.getText()));
                reportCode.add(String.valueOf(selettoreStatus.isChecked()));
                reportCode.add(String.valueOf(tocValue.getText()));
                reportCode.add(String.valueOf(codValue.getText()));
                if (nessunaSoluzione.isChecked()) {reportCode.add("1");} else {reportCode.add("0");}
                if (soluzioneUno.isChecked()) {reportCode.add("1");} else {reportCode.add("0");}
                if (soluzioneDue.isChecked()) {reportCode.add("1");} else {reportCode.add("0");}
                if (soluzioneTre.isChecked()) {reportCode.add("1");} else {reportCode.add("0");}
                if (soluzioneQuattro.isChecked()) {reportCode.add("1");} else {reportCode.add("0");}
                reportCode.add(String.valueOf(aromaValue.getText()));
                reportCode.add(String.valueOf(mtbValue.getText()));
                reportCode.add(String.valueOf(hplcTocValue.getText()));
                reportCode.add(String.valueOf(elioValue.getText()));
                RadioButton button3 = findViewById(tkChoosen.getCheckedRadioButtonId());
                reportCode.add(String.valueOf(button3.getText()));
                reportCode.add(String.valueOf(tkLevel.getText()));
                reportCode.add(String.valueOf(schiumaStatus.isChecked()));*/


                Toast.makeText(context, String.valueOf(reportCodeHash), Toast.LENGTH_SHORT).show();
                System.out.println(reportCodeHash);

            }
        });

        //http test
        ReportCode reportCodeHttp = new ReportCode("Zone 1", reportCode){};
        httpButton = findViewById(R.id.http_button);
        ReportCodeController reportCodeController = new ReportCodeController();
        httpButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                reportCodeController.sendReportCode(reportCodeHttp, context);

            }
        });
    }

}
