package com.stdmar.fcleanarchprj.user.userlist;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.stdmar.domain.models.UserDomainModel;
import com.stdmar.fcleanarchprj.R;
import com.stdmar.fcleanarchprj.base.BaseRecyclerAdapter;

/**
 * Created by sma on 10.09.17.
 */

public class UsersAdapter extends BaseRecyclerAdapter<UserDomainModel, UsersAdapter.UsersAdapterHolder> {

    public UsersAdapter(Context context) {
        super(context);
    }

    @Override
    public UsersAdapterHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        final View view = LayoutInflater.from(getContext()).inflate(R.layout.item_user, parent, false);
        return new UsersAdapterHolder(view);
    }

    @Override
    public void onBindViewHolder(UsersAdapterHolder holder, int position) {
        final UserDomainModel item = getItemByPosition(position);

        setupItemTouchListener(holder.rootView, position, item);
        holder.tvUserName.setText(item.getFullName());
    }

    static class UsersAdapterHolder extends RecyclerView.ViewHolder {

        View rootView;
        TextView tvUserName;

        public UsersAdapterHolder(View itemView) {

            super(itemView);
            rootView = itemView;
            tvUserName = rootView.findViewById(R.id.tv_user_name);
        }
    }

}
