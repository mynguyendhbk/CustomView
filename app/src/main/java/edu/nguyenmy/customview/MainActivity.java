package edu.nguyenmy.customview;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    private Button mBtnDraw;
    private SimpleDrawView mSimpleDrawView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mSimpleDrawView = (SimpleDrawView)findViewById(R.id.simple_draw);
        mBtnDraw = (Button)findViewById(R.id.btn_draw);
        mBtnDraw.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        mSimpleDrawView.clear();
    }
}
