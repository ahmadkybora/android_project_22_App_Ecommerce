package com.example.android_project_22_app_ecommerce.activities;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import com.example.android_project_22_app_ecommerce.R;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import com.mobsandgeeks.saripaar.ValidationError;
import com.mobsandgeeks.saripaar.Validator;
import com.mobsandgeeks.saripaar.annotation.Email;
import com.mobsandgeeks.saripaar.annotation.Length;
import com.mobsandgeeks.saripaar.annotation.NotEmpty;
import com.mobsandgeeks.saripaar.annotation.Password;
import com.mobsandgeeks.saripaar.annotation.Pattern;

import java.util.List;

public class RegisterActivity extends AppCompatActivity implements Validator.ValidationListener, View.OnClickListener {
    @NotEmpty
    @Length(min = 2, max = 25)
    private EditText ed_first_name;

    @NotEmpty
    @Length(min = 2, max = 25)
    private EditText ed_last_name;

    @NotEmpty
    @Length(min = 2, max = 25)
    private EditText ed_username;

    @NotEmpty
    @Email
    private EditText ed_email;

    private EditText ed_mobile;

    private EditText ed_home_phone;

    @NotEmpty
    @Password
    @Pattern(regex = "((?=.*\\d)(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%]).{8,25})")
    private EditText ed_password;

    @NotEmpty
    @Password
    @Pattern(regex = "((?=.*\\d)(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%]).{8,25})")
    private EditText ed_confirmation_password;

    private EditText ed_home_address;

    private EditText ed_work_address;

    private Button btn_register;

    private Validator validator;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.register_activity);

        initViews();
        validator = new Validator(this);
        validator.setValidationListener(this);
    }

    private void initViews() {
        ed_first_name = findViewById(R.id.ed_first_name);
        ed_last_name = findViewById(R.id.ed_last_name);
        ed_username = findViewById(R.id.ed_username);
        ed_email = findViewById(R.id.ed_email);
        ed_mobile = findViewById(R.id.ed_mobile);
        ed_home_phone = findViewById(R.id.ed_home_phone);
        ed_home_address = findViewById(R.id.ed_home_address);
        ed_work_address = findViewById(R.id.ed_work_address);
        ed_password = findViewById(R.id.ed_password);
        ed_confirmation_password = findViewById(R.id.ed_confirmation_password);
        btn_register = findViewById(R.id.btn_register);

        btn_register.setOnClickListener(this);
    }

    @Override
    public void onValidationSucceeded() {
        Toast.makeText(this, "Validation Success", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onValidationFailed(List<ValidationError> errors) {
        for (ValidationError error : errors) {
            View view = error.getView();
            String message = error.getCollatedErrorMessage(this);
            if (view instanceof EditText) {
                ((EditText) view).setError(message);
            } else {
                Toast.makeText(this, message, Toast.LENGTH_LONG).show();
            }
        }
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.btn_back_to_home:
                finish();
                break;

            case R.id.btn_register:
                validator.validate();
                break;
        }
    }
}