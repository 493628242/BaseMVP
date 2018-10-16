package com.gray.basemvp.base;

import android.support.v7.app.AppCompatActivity;

import com.gray.basemvp.utils.SingleToast;

/**
 * @author wjy on 2018/3/27.
 */

public class BaseActivity extends AppCompatActivity implements IClassTAG {
    public final String TAG = this.getClass().getName();

    @Override
    public String getTagName() {
        return TAG;
    }

    public void error(String info) {
        SingleToast.showShortToast(info);
    }
}
