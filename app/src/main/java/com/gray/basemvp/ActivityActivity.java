package com.gray.basemvp;

import android.os.Bundle;

import com.gray.basemvp.base.BaseActivity;
import com.gray.basemvp.model.activity.Presenter;
import com.gray.basemvp.model.activity.View;

public class ActivityActivity extends BaseActivity implements View {

    Presenter presenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_activity);
        presenter = new Presenter(this);
    }

    @Override
    protected void onResume() {
        super.onResume();
        presenter.getSlow();
    }

    @Override
    protected void onPause() {
        super.onPause();
        presenter.resetAll();
    }

    @Override
    public void error(String code) {

    }

    @Override
    public void load() {

    }

    @Override
    public void closeLoad() {

    }

    @Override
    public void success() {

    }
}
