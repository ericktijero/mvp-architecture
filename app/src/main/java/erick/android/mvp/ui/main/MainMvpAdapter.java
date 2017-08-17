package erick.android.mvp.ui.main;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import de.hdodenhof.circleimageview.CircleImageView;
import erick.android.mvp.R;
import erick.android.mvp.data.model.User;

/**
 * Created by erick on 8/8/17.
 */

public class MainMvpAdapter extends RecyclerView.Adapter<MainMvpAdapter.ViewHolder> {
    private Context context;
    private List<User> users;

    public MainMvpAdapter(Context context) {
        this.context = context;
        users = new ArrayList<>();
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view;
        view = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_item_user, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(final ViewHolder holder, final int position) {
        final User user = users.get(position);

        if (user.getPicture() != null) {
            Picasso.with(context)
                    .load(user.getPicture().getThumbnail())
                    .into(holder.ivPicture);
        }

        if (user.getName().getFirst() != null) {
            holder.tvName.setText(user.getName().getFirst());
        }

        if (user.getEmail() != null) {
            holder.tvEmail.setText(user.getEmail());
        }

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
    }

    public void addItems(List<User> userList) {
        users.clear();
        users.addAll(userList);
        notifyDataSetChanged();
    }

    @Override
    public int getItemCount() {
        return users.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        @BindView(R.id.iv_picture)
        CircleImageView ivPicture;
        @BindView(R.id.tv_name)
        TextView tvName;
        @BindView(R.id.tv_email)
        TextView tvEmail;


        public ViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    }
}