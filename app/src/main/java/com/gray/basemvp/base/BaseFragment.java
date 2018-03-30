package com.gray.basemvp.base;

import android.app.Fragment;

/**
 * @author wjy on 2018/3/27.
 */

public class BaseFragment extends Fragment implements IClassTAG {
    public final String TAG = this.getClass().getName();

    @Override
    public String getTagName() {
        return TAG;
    }
}
