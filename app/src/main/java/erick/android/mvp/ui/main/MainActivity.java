package erick.android.mvp.ui.main;

import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import erick.android.mvp.R;
import erick.android.mvp.data.model.User;
import erick.android.mvp.ui.base.BaseActivity;

public class MainActivity extends BaseActivity implements MainMvpView {
    @BindView(R.id.rv_users)
    RecyclerView recyclerView;

    private MainMvpPresenter presenter;
    private MainMvpAdapter mMainMvpAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        setUp();
        getUserList();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        presenter.onDestroy();
    }

    @Override
    protected void setUp() {
        setUpRecyclerView();
        presenter = new MainMvpPresenterImp();
        presenter.onCreate(this);
    }

    private void setUpRecyclerView(){
        mMainMvpAdapter = new MainMvpAdapter(getApplicationContext());
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(getApplicationContext()));
        recyclerView.setAdapter(mMainMvpAdapter);
    }

    @Override
    public void getUserList() {
        presenter.getUsers();
    }

    @Override
    public void updateUserList(List<User> userList) {
        mMainMvpAdapter.addItems(userList);
    }
}
