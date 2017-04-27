package cph.nakhundee.wannapa.mycphos;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import org.json.JSONArray;
import org.json.JSONObject;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    // Explicit คือการประการศตัวแปร
    private EditText userEditText, passwordEditText;
    private TextView textView;
    private Button button;
    private String userString, passwordString;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //test wanapa

        // initial View การผู้ตัวแปร
        initialView();

        //Controller สามารถคลิ๊กได้ ปุ่ม
        controller();


    }   // นี Main Method ่คือ method หลัก

    private void controller() {
        textView.setOnClickListener(MainActivity.this);
        button.setOnClickListener(MainActivity.this);
    }

    private void initialView() {
        userEditText = (EditText) findViewById(R.id.edtUser);  //cart เปลี่ยนตัวแปร
        passwordEditText = (EditText) findViewById(R.id.edtPassword);
        textView = (TextView) findViewById(R.id.textNewRegis);
        button = (Button) findViewById(R.id.btnLogin);
    }


    @Override
    public void onClick(View v) {

        // for textview สำหรับ ปุ่ม login
        if (v == textView) {
            //Intent to signup
            Intent intent = new Intent(MainActivity.this, SignUpActivity.class);
            startActivity(intent);

        }

        // for buttom สำหัรบปุ่มสมัคร
        if (v == button) {
            // Get Value From Edittext
            userString = userEditText.getText().toString().trim();
            passwordString = passwordEditText.getText().toString().trim();

            //check space มีความว่างหรือเปล่า
            if (userString.equals("") || passwordString.equals("")) {  //passwordString.equals เช็คค่าว่างว่ามีค่าว่างไหม
                //have space
                MyAlert myAlert = new MyAlert(MainActivity.this);
                myAlert.myDialog("Have Space","Please Fill Every Blank");

            } else {
                //no space
                checkUserAnPass();

            }


        }

    }

    private void checkUserAnPass() {
        try {

    //        String urlJSON = "http://swiftcodingthai.com/cph/getDataWannapa.php";

            String urlJSON = "http://swiftcodingthai.com/cph/getDataMaster.php";
            boolean b = true;
            String[] columnStrings = new String[]{"id", "Name", "User", "Password"};
            String[] loginStrings = new String[columnStrings.length];


            GetData getData = new GetData(MainActivity.this);
            getData.execute(urlJSON);
            String strJSON = getData.get();
            Log.d("27AprilV1", "JSON ==> " + strJSON);

            JSONArray jsonArray = new JSONArray(strJSON);

            for (int i=0;i<jsonArray.length();i++) {
                JSONObject jsonObject = jsonArray.getJSONObject(i);
                if (userString.equals(jsonObject.getString(columnStrings[2]))) {
                    b = false;
                    for (int i1=0;i1<columnStrings.length;i1++) {
                        loginStrings[i1] = jsonObject.getString(columnStrings[i1]);
                        Log.d("27AprilV1", "loginString(" + i1 + ") ==> " + loginStrings[i1]);
                    }
                }
            }


            if (b) {
                //User False
                MyAlert myAlert = new MyAlert(MainActivity.this);
                myAlert.myDialog("User False", "No This User in My Database");

            } else if (passwordString.equals(loginStrings[3])) {
                Toast.makeText(MainActivity.this, "Welcome " + loginStrings[1],   //Toast คือ การแจ้งเตือน
                        Toast.LENGTH_SHORT).show(); // LENGTH_SHORT คือ โชว์ระยะสั้น

                Intent intent = new Intent(MainActivity.this, ServiceActivity.class);
                intent.putExtra("Login", loginStrings);
                startActivity(intent);
                finish();

            } else {
                MyAlert myAlert = new MyAlert(MainActivity.this);
                myAlert.myDialog("Password False", "Password False");
            }

        } catch (Exception e) {
            Log.d("27AprilV1", "e checkUser ==> " + e.toString());

        }
    }
}   // Main Class นี่คือคลาสหลัก
