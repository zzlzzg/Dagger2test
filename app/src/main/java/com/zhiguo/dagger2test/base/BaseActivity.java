package com.zhiguo.dagger2test.base;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.ActionBar;
import android.view.MenuItem;

import dagger.android.AndroidInjection;
import nucleus.view.NucleusAppCompatActivity;

/**
 * Created by TiaoPi on 2017/11/3.
 */

public class BaseActivity<P extends BasePersenter> extends NucleusAppCompatActivity<P> {

    public ActionBar actionBar;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        AndroidInjection.inject(this);
        super.onCreate(savedInstanceState);
        initActionBar();
    }

    public void initActionBar(){
        actionBar = getSupportActionBar();
        actionBar.setTitle("TiaoPi");
        actionBar.setDisplayHomeAsUpEnabled(false);
    }

    public void showBack(){
        actionBar.setDisplayHomeAsUpEnabled(true);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        switch (item.getItemId()) {
            case android.R.id.home:
                this.finish();
                return false;
            default:
                return super.onOptionsItemSelected(item);
        }

    }
}
