package com.fadhlanhawali.medijour.SignUp;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

import com.fadhlanhawali.medijour.Database.AppDatabase;
import com.fadhlanhawali.medijour.Database.DAO.UserDao;
import com.fadhlanhawali.medijour.Login.UserModel;
import com.fadhlanhawali.medijour.R;

public class SignUpActivity extends AppCompatActivity implements SignUpContract.View {

    SignUpContract.Presenter mPresenter;
    AppDatabase mDb;
    UserDao userDao;
    EditText etUsername;
    Button btSimpan, btBatal;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);
        mDb = AppDatabase.getDatabase(this);
        userDao = mDb.userDao();

        mPresenter = new SignUpPresenter(this,this,userDao);
        mPresenter.initP();
    }

    @Override
    public void onAddUser() {
        finish();
    }

    @Override
    public void initV() {
        btSimpan = findViewById(R.id.btSimpan);
        btBatal = findViewById(R.id.btCancel);
        etUsername = findViewById(R.id.etUsername);
        btSimpan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mPresenter.addUser(new UserModel(
                        etUsername.getText().toString()
                ));
            }
        });

        btBatal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
    }
}
