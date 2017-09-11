package com.stdmar.fcleanarchprj.user.detailuser;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.arellomobile.mvp.presenter.InjectPresenter;
import com.stdmar.domain.models.UserDomainModel;
import com.stdmar.fcleanarchprj.Const;
import com.stdmar.fcleanarchprj.R;
import com.stdmar.fcleanarchprj.base.BaseFragment;
import com.stdmar.fcleanarchprj.di.ComponentsHelper;
import com.stdmar.fcleanarchprj.di.IHasComponent;
import com.stdmar.fcleanarchprj.di.users.detail.DetailUserComponent;
import com.stdmar.fcleanarchprj.utils.image.IImageLoader;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by sma on 10.09.17.
 */

public class DetailUserFragment extends BaseFragment
        implements IDetailUserView, IHasComponent<DetailUserComponent> {

    @BindView(R.id.tv_user_full_name)
    TextView tvFullName;
    @BindView(R.id.tv_user_email)
    TextView tvEmail;
    @BindView(R.id.tv_user_followers)
    TextView tvFollower;
    @BindView(R.id.tv_description)
    TextView tvDescription;
    @BindView(R.id.iv_user_avatar)
    ImageView ivAvatar;
    @BindView(R.id.pb_detail_user)
    ProgressBar pbLoadUser;

    @Inject
    IImageLoader imageLoader;
    @InjectPresenter
    DetailUserPresenter detailUserPresenter;

    private int userId;
    private DetailUserComponent detailUserComponent;

    public static DetailUserFragment newInstance(final Object data) {
        final DetailUserFragment frg = new DetailUserFragment();
        final Bundle args = new Bundle();
        final int userId = (Integer) data;
        args.putInt(Const.ArgKey.DETAIL_USER_ID, userId);
        frg.setArguments(args);
        return frg;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        initializeInjector();
        setUserId();

        detailUserPresenter.setDetailUserUseCase(detailUserComponent.detailUserUseCase());
        if (savedInstanceState == null) {
            detailUserPresenter.fetchUserById(userId);
        }
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

    @Override
    public void showProgressBar() {
        pbLoadUser.setVisibility(View.VISIBLE);
    }

    @Override
    public void hideProgressBar() {
        pbLoadUser.setVisibility(View.GONE);
    }

    @Override
    public void renderUser(UserDomainModel userDomainModel) {
        if (userDomainModel == null) return;
        tvFullName.setText(userDomainModel.getFullName());
        tvEmail.setText(userDomainModel.getEmail());
        tvFollower.setText(String.valueOf(userDomainModel.getFollowers()));
        tvDescription.setText(userDomainModel.getDescription());

        imageLoader.loadImage(
                userDomainModel.getCoverUrl(),
                ivAvatar, R.mipmap.ic_launcher,
                R.mipmap.ic_launcher);
    }

    private void setUserId() {
        final Bundle arg = getArguments();
        if (arg == null) return;
        userId = arg.getInt(Const.ArgKey.DETAIL_USER_ID);
    }

    @Override
    public DetailUserComponent getComponent() {
        return detailUserComponent;
    }

    private void initializeInjector() {
        detailUserComponent =
                ComponentsHelper.initAndGetDetailUserComponent(getMyApplicationComponent());

        detailUserComponent.injectInDetailUserFragment(this);
    }
}
