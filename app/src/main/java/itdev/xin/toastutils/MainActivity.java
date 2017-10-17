package itdev.xin.toastutils;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import itdev.xin.toastutil.ToastU;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ToastU.error(MainActivity.this,"测试").show();

    }
}
