package com.stdmar.fcleanarchprj.detailuser;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.stdmar.fcleanarchprj.R;
import com.stdmar.fcleanarchprj.base.BaseFragment;

import butterknife.ButterKnife;

/**
 * Created by sma on 10.09.17.
 */

public class DetailUserFragment extends BaseFragment {

    public static DetailUserFragment newInstance() {
        return new DetailUserFragment();
    }

    @Override
    protected void inject() {

    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Nullable
    @Override
    public View onCreateView(
            LayoutInflater inflater,
            @Nullable ViewGroup container,
            @Nullable Bundle savedInstanceState) {

        final View view = inflater.inflate(R.layout.frg_detail_user, container, false);
        ButterKnife.bind(this, view);
        return view;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {

        super.onViewCreated(view, savedInstanceState);
    }
}
