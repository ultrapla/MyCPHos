package cph.nakhundee.wannapa.mycphos;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

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
            if (userString.equals("") || passwordString.equals("")) {
                //have space
                MyAlert myAlert = new MyAlert(MainActivity.this);
                myAlert.myDialog("Have Space","Please Fill Every Blank");

            } else {
                //no space

            }


        }

    }
}   // Main Class นี่คือคลาสหลัก
