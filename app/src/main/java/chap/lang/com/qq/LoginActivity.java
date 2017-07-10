package chap.lang.com.qq;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import chap.lang.com.qq.utils.SPUtils;

/**
 * Created by Administrator on 2017/6/24.
 */
public class LoginActivity extends Activity implements View.OnClickListener {
    private static final String TAG = "LoginActivity";
    private EditText counntEdit,passwordEdit;
    private Button  logoBtn;
    private CheckBox cheBox;
    private TextView regTv;
    private Boolean  chFlag=false;
   private String ac,pw;
    private static  final String FILE_NAME="reg_data";
    private static  final String SFILE_NAME="share_data";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login_layout);
        initView();
        logoBtn.setOnClickListener(this);
        cheBox.setOnClickListener(this);
        regTv.setOnClickListener(this);
        String s=(String) SPUtils.get(LoginActivity.this,SFILE_NAME,"account");
        String s1=(String)SPUtils.get(LoginActivity.this,SFILE_NAME,"pword");
        counntEdit.setText(s);
        passwordEdit.setText(s1);
    }

    private void initView() {
        counntEdit= (EditText) findViewById(R.id.accountEdit);
        passwordEdit= (EditText) findViewById(R.id.passwordEdit);
        logoBtn= (Button) findViewById(R.id.logoBt);
        cheBox= (CheckBox) findViewById(R.id.rememBox);
        regTv= (TextView) findViewById(R.id.remeTv);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.rememBox:
                chFlag=true;
                break;
            case R.id.logoBt:

                String s=(String) SPUtils.get(LoginActivity.this,FILE_NAME,"account");
                String s1=(String)SPUtils.get(LoginActivity.this,FILE_NAME,"pword");
                String ac= counntEdit.getText().toString().trim();
                String pw=passwordEdit.getText().toString().trim();
                if(ac.equals(s)&&pw.equals(s1)){
                    if (chFlag){
                        SPUtils.put(LoginActivity.this,SFILE_NAME,"account",ac);
                        SPUtils.put(LoginActivity.this,SFILE_NAME,"pword",pw);
                    }
                    Intent intent=new Intent(LoginActivity.this,MainActivity.class);
                    intent.putExtra("flag",TAG);
                    startActivity(intent);
                }else {
                    Toast.makeText(LoginActivity.this,getResources().getString(R.string.error),Toast.LENGTH_SHORT).show();
                }
                break;
            case R.id.remeTv:
                Intent intent =new Intent(LoginActivity.this,RegisterActivity.class);
                startActivity(intent);
                break;
        }
    }
}
