package cph.nakhundee.wannapa.mycphos;

import android.content.Context;
import android.os.AsyncTask;
import android.util.Log;

import com.squareup.okhttp.OkHttpClient;
import com.squareup.okhttp.Request;
import com.squareup.okhttp.Response;

/**
 * Created by Meeting on 27/4/2560.
 */

public class GetData extends AsyncTask<String, Void, String>{  // void ไม่ให้หมุน  ถ้าแดง กด alt+enter สร้าง Imprement  String ตัวที่ 3 คือ ค่า

    private Context context;  //ประกาศตัวแปร ตัวที่ 3 กด ctrl+space

    public GetData(Context context) {   //การสร้างคอนสตะกเตอร์ กด alt+enter
        this.context = context;
    }

    @Override
    protected String doInBackground(String... params) {

        try {

            OkHttpClient okHttpClient = new OkHttpClient();  //OkHttpClient าดึงข้อทูลมาใช้
            Request.Builder builder = new Request.Builder();
            Request request = builder.url(params[0]).build();
            Response response = okHttpClient.newCall(request).execute();
            return response.body().string();


        } catch (Exception e) {
            Log.d("27AprilV1", "e doin ==>" + e.toString());
            return null;

        }

    }
} // main class คลาสหลัก
