package ru.karpenko.huawei.tasker.login;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import ru.karpenko.huawei.tasker.R;
import ru.karpenko.huawei.tasker.task_list.TaskListActivity;

public class LoginActivity extends AppCompatActivity implements LoginView {

    private static final String TAG = "login.LoginActivity";

    private EditText mLoginEditText;
    private EditText mPasswordEditText;
    private Button mLoginButton;
    private TextView forgotPasswordTextView;
    private TextView notRegisterTextView;

    private LoginPresenter mLoginPresenter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        init();
    }

    private void init() {

        mLoginPresenter = new LoginPresenter(this);

        mLoginEditText = (EditText) findViewById(R.id.loginEditText);
        mPasswordEditText = (EditText) findViewById(R.id.passwordEditText);
        mLoginButton = (Button) findViewById(R.id.loginButton);
        forgotPasswordTextView = (TextView) findViewById(R.id.forgotPasswordTextView);
        notRegisterTextView = (TextView) findViewById(R.id.notRegisterTextView);

        mLoginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openStartForm();
            }
        });


    }


    @Override
    public void openStartForm() {
        Intent intent = new Intent(this, TaskListActivity.class);
        startActivity(intent);
    }


    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {

        super.onActivityResult(requestCode, resultCode, data);



    }
}
