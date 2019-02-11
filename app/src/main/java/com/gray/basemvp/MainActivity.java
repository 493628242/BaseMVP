package com.gray.basemvp;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

import com.gray.basemvp.base.BaseMVPActivity;
import com.gray.basemvp.model.activity.Presenter;
import com.gray.basemvp.model.activity.View;
import com.gray.basemvp.utils.LogUtils;

public class MainActivity extends BaseMVPActivity implements View {
    private Presenter presenter;
    TextView id;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        presenter = new Presenter(this);
        presenter.get();
        presenter.getSlow();
        LogUtils.startDebug(true);
        id = findViewById(R.id.text);
        id.setOnClickListener(new android.view.View.OnClickListener() {
            @Override
            public void onClick(android.view.View v) {
                startActivity(new Intent(MainActivity.this, ActivityActivity.class));
            }
        });
    }


    @Override
    protected void onPause() {
        super.onPause();
        presenter.resetAll();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();

    }

    @Override
    public void error(String msg) {
        Toast.makeText(this, msg, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void load() {

    }

    @Override
    public void closeLoad() {

    }

    @Override
    public void success() {
        id.setText("asassa");
    }
}
