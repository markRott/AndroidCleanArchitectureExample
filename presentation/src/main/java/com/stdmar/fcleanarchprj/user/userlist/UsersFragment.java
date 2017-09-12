package com.stdmar.fcleanarchprj.user.userlist;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.arellomobile.mvp.presenter.InjectPresenter;
import com.stdmar.domain.models.UserDomainModel;
import com.stdmar.fcleanarchprj.R;
import com.stdmar.fcleanarchprj.base.BaseDividerItemDecoration;
import com.stdmar.fcleanarchprj.base.BaseFragment;
import com.stdmar.fcleanarchprj.base.IRecyclerItemTouchListener;
import com.stdmar.fcleanarchprj.di.ComponentsHelper;
import com.stdmar.fcleanarchprj.di.IHasComponent;
import com.stdmar.fcleanarchprj.di.users.list.UsersListComponent;
import com.stdmar.fcleanarchprj.user.userlist.adapter.UsersAdapter;

import java.util.List;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;

import static com.stdmar.fcleanarchprj.base.BaseDividerItemDecoration.VERTICAL_LIST;

/**
 * Created by sma on 09.09.17.
 */

public class UsersFragment extends BaseFragment implements ILoadUsersView, IBackButtonListener,
        IHasComponent<UsersListComponent>, IRecyclerItemTouchListener<UserDomainModel> {

    // Viewvs
    @BindView(R.id.pb_load_users)
    ProgressBar pbLoadUsers;
    @BindView(R.id.rcv_users)
    RecyclerView rcvUsers;
    @BindView(R.id.tv_load_users_error)
    TextView tvLoadUsersError;

    // Objects
    @Inject
    UsersAdapter usersAdapter;
    @InjectPresenter
    UsersPresenter usersPresenter;

    private UsersListComponent usersListComponent;

    public static UsersFragment newInstance() {
        return new UsersFragment();
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        initializeInjector();
    }

    @Nullable
    @Override
    public View onCreateView(
            LayoutInflater inflater,
            @Nullable ViewGroup container,
            @Nullable Bundle savedInstanceState) {

        final View view = inflater.inflate(R.layout.frg_users, container, false);
        ButterKnife.bind(this, view);
        setupRecyclerView();
        return view;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        setDataForPresenter();
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        rcvUsers.setAdapter(null);
    }

    @Override
    public boolean onBackPressed() {
        usersPresenter.onBackPressed();
        return true;
    }

    @Override
    public void showProgressBar() {
        pbLoadUsers.setVisibility(View.VISIBLE);
    }

    @Override
    public void hideProgressBar() {
        pbLoadUsers.setVisibility(View.GONE);
    }

    @Override
    public void renderUsersList(List<UserDomainModel> userDomainModelList) {
        if (userDomainModelList == null || userDomainModelList.isEmpty()) return;
        usersAdapter.setData(userDomainModelList);
        usersAdapter.setItemTouchListener(this);
    }

    @Override
    public void showError(String error) {
        tvLoadUsersError.setText(error);
    }

    @Override
    public UsersListComponent getComponent() {
        return usersListComponent;
    }

    @Override
    public void onTouch(int position, UserDomainModel data) {
        usersPresenter.onOpenDetailScreen(data.getUserId());
    }

    private void setupRecyclerView() {
        rcvUsers.setLayoutManager(new LinearLayoutManager(getContext()));
        rcvUsers.addItemDecoration(new BaseDividerItemDecoration(getContext(), VERTICAL_LIST));
        rcvUsers.setAdapter(usersAdapter);
    }

    private void initializeInjector() {
        if (usersListComponent == null) {
            usersListComponent = ComponentsHelper
                    .initAndGetUsersListComponent(getMyApplicationComponent());

            usersListComponent.injectInUsersFragment(this);
        }
    }

    private void setDataForPresenter() {
        usersPresenter
                .setRouter(usersListComponent.router())
                .setUsersUseCase(usersListComponent.usersUseCase());
    }
}
