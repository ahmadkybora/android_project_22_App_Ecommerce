package com.example.android_project_22_app_ecommerce.activities;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;
import com.example.android_project_22_app_ecommerce.HttpConnection.RetrofitClient;
import com.example.android_project_22_app_ecommerce.R;
import com.example.android_project_22_app_ecommerce.models.Product;
import java.util.List;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private Button btn_login;
    private Button btn_register;
    ListView superListView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        superListView = findViewById(R.id.superListView);
        getsuperProducts();
        initViews();
    }

    public void initViews() {
        btn_login = findViewById(R.id.btn_login);
        btn_register = findViewById(R.id.btn_register);

        btn_login.setOnClickListener(this);
        btn_register.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.btn_login:
                Toast.makeText(this, "hello", Toast.LENGTH_SHORT).show();
                startActivity(new Intent(this, LoginActivity.class));
                break;

            case R.id.btn_register:
                startActivity(new Intent(MainActivity.this, RegisterActivity.class));
                break;
        }
    }

    private void getsuperProducts() {
        Call<List<Product>> call = RetrofitClient.getInstance().getMyApi().getsuperProducts();
        call.enqueue(new Callback<List<Product>>() {
            @Override
            public void onResponse(Call<List<Product>> call, Response<List<Product>> response) {
                List<Product> myheroList = response.body();
                String[] oneHeroes = new String[myheroList.size()];

                for (int i = 0; i < myheroList.size(); i++) {
                    oneHeroes[i] = myheroList.get(i).getName();
                }

                superListView.setAdapter(new ArrayAdapter<String>(getApplicationContext(), android.R.layout.simple_list_item_1, oneHeroes));
            }

            @Override
            public void onFailure(Call<List<Product>> call, Throwable t) {
                Toast.makeText(getApplicationContext(), "An error has occured", Toast.LENGTH_LONG).show();
            }

        });
    }
}