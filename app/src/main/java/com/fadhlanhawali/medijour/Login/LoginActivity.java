package com.fadhlanhawali.medijour.Login;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.fadhlanhawali.medijour.Database.AppDatabase;
import com.fadhlanhawali.medijour.Database.DAO.UserDao;
import com.fadhlanhawali.medijour.MainActivity;
import com.fadhlanhawali.medijour.R;
import com.fadhlanhawali.medijour.SignUp.SignUpActivity;

public class LoginActivity extends AppCompatActivity implements LoginContract.View {

    LoginContract.Presenter mPresenter;
    AppDatabase mDb;
    UserDao userDao;
    Button btLogin;
    TextView tvSignUp;
    EditText etUsername;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        mDb = AppDatabase.getDatabase(this);
        userDao = mDb.userDao();
        mPresenter = new LoginPresenter(this,this,userDao);
        mPresenter.initP();
    }

    @Override
    public void onCheckUsername(Boolean flag) {
        if (flag){
            Intent i = new Intent(this, MainActivity.class);
            startActivity(i);
        }else {
            Toast.makeText(this, "Username tidak ditemukan !", Toast.LENGTH_SHORT).show();
        }
    }

    @Override
    public void initV() {
        btLogin = findViewById(R.id.login);
        tvSignUp = findViewById(R.id.tvSignUp);
        etUsername = findViewById(R.id.etUsername);

        Intent i = new Intent(this, SignUpActivity.class);

        findViewById(R.id.tvSignUp).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getApplicationContext(), SignUpActivity.class);
                startActivity(i);
            }
        });
        btLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mPresenter.checkUsername(etUsername.getText().toString());
            }
        });
    }
}
