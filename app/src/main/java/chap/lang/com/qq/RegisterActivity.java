package chap.lang.com.qq;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import chap.lang.com.qq.utils.SPUtils;

/**
 * Created by Administrator on 2017/6/25.
 */
public class RegisterActivity extends Activity implements View.OnClickListener {
    private EditText accountEdit, passwordEdit;
    private Button registerBt;
    private static  final String FILE_NAME="reg_data";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.registerlayout);
        initView();
        registerBt.setOnClickListener(this);

    }

    private void initView() {
        accountEdit= (EditText) findViewById(R.id.accountEdit_reg);
        passwordEdit= (EditText) findViewById(R.id.passwordEdit_reg);
        registerBt= (Button) findViewById(R.id.registerBt_reg);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.registerBt_reg:
                String ac= accountEdit.getText().toString().trim();
                String pw=passwordEdit.getText().toString().toString();
                Toast.makeText(RegisterActivity.this,getResources().getString(R.string.ressucced),Toast.LENGTH_SHORT).show();

                SPUtils.put(RegisterActivity.this,FILE_NAME,"account",ac);
                SPUtils.put(RegisterActivity.this,FILE_NAME,"pword",pw);

                break;
        }
    }
}
