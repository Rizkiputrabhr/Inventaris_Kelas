package id.sch.smktelkom_mlg.project.xiirpl401112131.inventariskelas;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class MainActivity extends AppCompatActivity {

    private EditText memailField;
    private EditText mpasswordField;

    private Button mloginBtn;

    private FirebaseAuth mAuth;
    private FirebaseAuth.AuthStateListener mAuthListener;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mAuth = FirebaseAuth.getInstance();

        memailField = (EditText) findViewById(R.id.emailField);
        mpasswordField = (EditText) findViewById(R.id.passwordField);

        mloginBtn = (Button) findViewById(R.id.loginBtn);

        mAuthListener = new FirebaseAuth.AuthStateListener() {
            @Override
            public void onAuthStateChanged(@NonNull FirebaseAuth firebaseAuth) {

                if (firebaseAuth.getCurrentUser() == null) {

                    startActivity(new Intent(MainActivity.this, Home.class));
                }
            }
        };


        mloginBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });

    }

    @Override
    protected void onStart() {
        super.onStart();
        mAuth.addAuthStateListener(mAuthListener);
    }

    private void startSignIn() {

        String email = memailField.getText().toString();
        String password = mpasswordField.getText().toString();

        if (TextUtils.isEmpty(email) || TextUtils.isEmpty(password)) {

            Toast.makeText(MainActivity.this, "Email atau Password Kosong! ", Toast.LENGTH_LONG).show();

        } else {

            mAuth.signInWithEmailAndPassword(email, password).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                @Override
                public void onComplete(@NonNull Task<AuthResult> task) {

                    if (!task.isSuccessful()) {

                        Toast.makeText(MainActivity.this, "Email atau Pasword Salah! ", Toast.LENGTH_LONG).show();
                    }
                }
            });
        }




    }
}
