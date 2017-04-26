package cph.nakhundee.wannapa.mycphos;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    // Explicit คือการประการศตัวแปร
    private EditText userEditText, passwordEditText;
    private TextView textView;
    private Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // initial View การผู้ตัวแปร
        initialView();

    }   // นี Main Method ่คือ method หลัก

    private void initialView() {
        userEditText = (EditText) findViewById(R.id.edtUser);  //cart เปลี่ยนตัวแปร
        passwordEditText = (EditText) findViewById(R.id.edtPassword);
        textView = (TextView) findViewById(R.id.textNewRegis);
        button = (Button) findViewById(R.id.btnLogin);
    }


}   // Main Class นี่คือคลาสหลัก
