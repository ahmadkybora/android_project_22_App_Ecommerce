package com.example.android_project_22_app_ecommerce.activities;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import com.mobsandgeeks.saripaar.ValidationError;
import com.mobsandgeeks.saripaar.Validator;
import com.mobsandgeeks.saripaar.annotation.Length;
import com.mobsandgeeks.saripaar.annotation.NotEmpty;
import com.mobsandgeeks.saripaar.annotation.Password;
import com.mobsandgeeks.saripaar.annotation.Pattern;
import android.widget.Toast;
import java.util.List;
import com.example.android_project_22_app_ecommerce.R;

public class LoginActivity extends AppCompatActivity implements Validator.ValidationListener, View.OnClickListener {

    protected Validator validator;

    @NotEmpty
    @Length(min = 3, max = 25)
    private EditText ed_username;

    @NotEmpty
    @Password
    @Pattern(regex = "((?=.*\\d)(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%]).{8,25})")
    private EditText ed_password;

    private Button btn_login;
    private Button btn_back_to_home;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login_activity);

        initViews();
        validator = new Validator(this);
        validator.setValidationListener(this);
    }


    private void initViews() {
        ed_username = findViewById(R.id.ed_username);
        ed_password = findViewById(R.id.ed_password);
        btn_back_to_home = findViewById(R.id.btn_back_to_home);
        btn_login = findViewById(R.id.btn_login);

        btn_login.setOnClickListener(this);
        btn_back_to_home.setOnClickListener(this);
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
            case R.id.btn_login:
                validator.validate();
                break;

            case R.id.btn_back_to_home:
                finish();
                break;
        }
    }
}