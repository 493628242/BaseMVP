package com.gray.basemvp.base;

/**
 * @author wjy on 2018/3/16.
 */

public interface BaseMVPView {
    void error(String msg);

    void load();

    void closeLoad();
}
