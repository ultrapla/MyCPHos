package cph.nakhundee.wannapa.mycphos;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import org.json.JSONArray;
import org.json.JSONObject;

public class DetailActivity extends AppCompatActivity implements View.OnClickListener {

    private ImageView imageView;
    private TextView nameTextView, dateTextView,
            detailTextView, receiveTextView;
    private String qrCodeString;
    private String tag = "28AprilV1";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        initialView();

        controller();

        //Get Value From Intent
        getValueFromIntent();


        // show View
        showView();

    } // main thodmod

    private void showView() {

        MyConstant myConstant = new MyConstant();   // สือบทอดคลาส เรียกใช้ได้เลย
        String[] columnProduct = myConstant.getColumnProduct();
        String urlPHP = myConstant.getUrlGetProductWhere();

        try {

            GetPorductWhereQR getPorductWhereQR = new GetPorductWhereQR(DetailActivity.this);
            getPorductWhereQR.execute(columnProduct[2], qrCodeString, urlPHP);

            String strJSON = getPorductWhereQR.get();
            Log.d(tag, "JSON ==> " + strJSON);

            //เปลี่ยน Json
            JSONArray jsonArray = new JSONArray(strJSON);
            String[] resultStrings = new String[columnProduct.length];
            JSONObject jsonObject = jsonArray.getJSONObject(0);
            for (int i=0; i<resultStrings.length; i++) {
                resultStrings[i] = jsonObject.getString(columnProduct[i]);
                Log.d(tag, "result(" + i + ") ==> " + resultStrings[i]);
            }

            nameTextView.setText(resultStrings[1]);
            dateTextView.setText(resultStrings[5]);
            detailTextView.setText(resultStrings[4]);

        } catch (Exception e) {
            Log.d(tag, "e showView ==>" + e.toString());
        }
    }

    private void getValueFromIntent() {
        qrCodeString = getIntent().getStringExtra("QRcode");
        Log.d(tag, "QRcode ==> " + qrCodeString);
    }

    private void controller() {
        imageView.setOnClickListener(DetailActivity.this);

    }

    private void initialView() {
        imageView = (ImageView) findViewById(R.id.imvBack);
        nameTextView = (TextView) findViewById(R.id.txtName);
        dateTextView = (TextView) findViewById(R.id.txtDate);
        detailTextView = (TextView) findViewById(R.id.texDetail);
        receiveTextView = (TextView) findViewById(R.id.textReceive);

    }

    @Override
    public void onClick(View v) {

        if (v == imageView) {
            finish();
        }
    }
} // main class
