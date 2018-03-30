package com.gray.basemvp.base;

/**
 * @author wjy on 2018/3/16.
 */

public interface BaseView {
    void error(String msg);

    void load();

    void closeLoad();
}
