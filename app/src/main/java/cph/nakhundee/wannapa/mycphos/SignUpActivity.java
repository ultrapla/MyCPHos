package cph.nakhundee.wannapa.mycphos;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class SignUpActivity extends AppCompatActivity implements View.OnClickListener {

    private EditText nameEditText, userEditText, passwordEditText;
    private Button button;
    private String nameString, userString, passwordString;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);

        initialView();

        controller();
    } // main method เมทตอดหลัก

    private void controller() {
        button.setOnClickListener(SignUpActivity.this);
    }

    private void initialView() {
        nameEditText = (EditText) findViewById(R.id.edtname);
        userEditText = (EditText) findViewById(R.id.edtUser);
        passwordEditText = (EditText) findViewById(R.id.edtPassword);
        button = (Button) findViewById(R.id.btnRegis);


    } //


    @Override
    public void onClick(View v) {

        if (v == button) {

            //GET Value From Edit text ดึงค่ามาแก้ไข จาก Edit text

            nameString = nameEditText.getText().toString().trim();   //trim คือการตัดช่องว่าง    ให้สริงส่งค่าไปที่ edittext และตัดช่องว่าง
            userString = userEditText.getText().toString().trim();
            passwordString = passwordEditText.getText().toString().trim();

            //check space หาช่องว่าง

            if (nameString.equals("") || userString.equals("") || passwordString.equals("")) {      // ถ้าไม่มีการกรอก จะเป็น true เสมอ
                // Have space
                MyAlert myAlert = new MyAlert(SignUpActivity.this);   //MyAlert cass
                myAlert.myDialog("มีช่องว่าง","กรุณากรอกทุกช่อง คะ");

            } else {

                // NO space
                try {

                    PostData postData = new PostData(SignUpActivity.this);
                    postData.execute(userString, nameString, passwordString);

                    String result = postData.get();
                    Log.d("26AprilV1", "result ==> " + result);

                } catch (Exception e) {
                    Log.d("26AprilV1", "e SignUp ==>" + e.toString());
                }

            }
        }

    }
} // main class คลาสหลัก
