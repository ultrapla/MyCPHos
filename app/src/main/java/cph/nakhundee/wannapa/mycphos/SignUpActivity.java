package cph.nakhundee.wannapa.mycphos;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class SignUpActivity extends AppCompatActivity implements View.OnClickListener {

    private EditText nameEditText, userEditText, passwordEditText;
    private Button button;

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

    }
} // main class คลาสหลัก
