package id.sch.smktelkom_mlg.project.xiirpl401112131.inventariskelas;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class MainActivity extends AppCompatActivity {

    private EditText memailField;
    private EditText mpasswordField;

    private Button mloginBtn;

    private FirebaseAuth mAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mAuth = FirebaseAuth.getInstance();

        memailField = (EditText) findViewById(R.id.emailField);
        mpasswordField = (EditText) findViewById(R.id.passwordField);

        mloginBtn = (Button) findViewById(R.id.loginBtn);


        mloginBtn.setOnClickListener(new View.OnClickListener() {

                                         @Override
                                         public void OnClick(View view) {

                                             startSignIn();
                                         }

                                     }
        );

    }

    private void startSignIn() {

        String email = memailField.getText().toString();
        String password = mpasswordField.getText().toString();

        mAuth.signInWithEmailAndPassword(email, password.addOnCompleteListener(new OnCompleteListener<AuthResult>() {

                                                                               }


        ))

    }
}
