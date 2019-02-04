package jx.hello.ui;

import android.arch.lifecycle.ViewModelProviders;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.yuyakaido.android.cardstackview.CardStackLayoutManager;

import jx.hello.R;
import jx.hello.adapters.MainAdapter;
import jx.hello.databinding.ActivityMainBinding;
import jx.hello.viewmodel.MainViewModel;

public class MainActivity extends AppCompatActivity {

    private ActivityMainBinding activityBinding;
    private MainViewModel mViewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mViewModel = ViewModelProviders.of(this).get(MainViewModel.class);
        mViewModel.init();
        activityBinding = DataBindingUtil.setContentView(this, R.layout.activity_main);
        activityBinding.setActivity(this);
        activityBinding.setLayoutManager(new CardStackLayoutManager(this));
        activityBinding.setMainAdapter(new MainAdapter(mViewModel));
    }




}
