package vnpt.binhduong.day2;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class LoginActivity extends AppCompatActivity {

    EditText edUser, edPassword;
    Button btLogin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        initView();
    }


    private  void  initView(){
        edUser = findViewById(R.id.edUser);
        edPassword = findViewById(R.id.edPassword);
        btLogin = findViewById(R.id.btLogin);

        btLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String User = edUser.getText().toString();
                String Password = edPassword.getText().toString();

                if (User.equals("VNPT") && Password.equals("1")){
                    Intent intent = new Intent(LoginActivity.this, MainActivity.class);
                    String user = edUser.getText().toString();
                    Log.d("user", user);
                    intent.putExtra("KIENHANG",user);
                    startActivity(intent);
                } else {
                    Toast.makeText(LoginActivity.this, "sai username va password", Toast.LENGTH_SHORT).show();
                    open();





                }
            }
        });
    }



    public void open() {
        AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(this);
        alertDialogBuilder.setTitle("Thông báo");
        alertDialogBuilder.setMessage("test ");

        alertDialogBuilder.setPositiveButton("Đồng ý",
                new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface arg0, int arg1) {
                        Toast.makeText(LoginActivity.this, "Bấm đồng ý", Toast.LENGTH_LONG).show();
                    }
                });

        alertDialogBuilder.setNegativeButton("Không", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
//                finish();
            }
        });

        AlertDialog alertDialog = alertDialogBuilder.create();
        alertDialog.show();
    }


}
