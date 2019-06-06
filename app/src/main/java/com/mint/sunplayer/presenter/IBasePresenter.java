package com.mint.sunplayer.presenter;

public interface IBasePresenter<T> {
    /**
     * 绑定视图
     * @param t
     */
    void attchView (T t);

    /**
     * 解绑视图
     * @param t
     */
    void detachView(T t);
}
