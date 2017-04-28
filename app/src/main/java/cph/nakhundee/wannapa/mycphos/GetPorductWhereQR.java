package cph.nakhundee.wannapa.mycphos;

import android.content.Context;
import android.os.AsyncTask;
import android.util.Log;

import com.squareup.okhttp.FormEncodingBuilder;
import com.squareup.okhttp.OkHttpClient;
import com.squareup.okhttp.Request;
import com.squareup.okhttp.RequestBody;
import com.squareup.okhttp.Response;

/**
 * Created by Meeting on 28/4/2560.
 */

public class GetPorductWhereQR extends AsyncTask<String, Void, String>{    //AsyncTask คือทำตลอด

    private Context context;  // การสื่อระหว่าง object กับ object


    public GetPorductWhereQR(Context context) {
        this.context = context;
    }


    @Override
    protected String doInBackground(String... params) {

        try {

            OkHttpClient okHttpClient = new OkHttpClient();
            RequestBody requestBody = new FormEncodingBuilder()
                    .add("isAdd", "true")
                    .add(params[0], params[1])
                    .build();
            Request.Builder builder = new Request.Builder();
            Request request = builder.url(params[2]).post(requestBody).build();
            Response response = okHttpClient.newCall(request).execute();
            return response.body().string();

        } catch (Exception e) {
            Log.d("28AprilV1", "e doin ==>" + e.toString());
            return null;
        }

    }
} // main class
