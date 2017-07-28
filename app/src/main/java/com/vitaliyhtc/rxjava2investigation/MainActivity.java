package com.vitaliyhtc.rxjava2investigation;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.Button;
import android.widget.TextView;

import com.vitaliyhtc.rxjava2investigation.presenter.model.Product;
import com.vitaliyhtc.rxjava2investigation.presenter.model.Store;
import com.vitaliyhtc.rxjava2investigation.presenter.MainPresenter;
import com.vitaliyhtc.rxjava2investigation.presenter.MainPresenterImpl;
import com.vitaliyhtc.rxjava2investigation.view.MainView;
import com.vitaliyhtc.rxjava2investigation.view.adapter.StoreProductAdapter;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class MainActivity extends AppCompatActivity implements MainView {
    private static final String TAG = "MainActivity";

    private MainPresenter mMainPresenter;

    private List<String> mResultList = new ArrayList<>();

    @BindView(R.id.btn_load)
    Button mButtonLoad;
    @BindView(R.id.rv_result)
    RecyclerView mRecyclerView;
    @BindView(R.id.tv_stores_error)
    TextView mTextViewStoresError;
    @BindView(R.id.tv_products_error)
    TextView mTextViewProductsError;

    private List<Store> mStoreList;
    private Map<Integer, List<Product>> mProductsMap;

    private StoreProductAdapter mAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ButterKnife.bind(this);

        mRecyclerView.setLayoutManager(new LinearLayoutManager(MainActivity.this));
        mAdapter = new StoreProductAdapter();
        mRecyclerView.setAdapter(mAdapter);

        mStoreList = new ArrayList<>();
        mProductsMap = new HashMap<>();

        mMainPresenter = new MainPresenterImpl();
        mMainPresenter.onAttachView(this);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        mMainPresenter.onDetachView();
    }

    @OnClick(R.id.btn_load)
    void onButtonLoadClick() {
        mMainPresenter.loadData();
    }

    @Override
    public void addStoreToResult(Store store) {
        mStoreList.add(store);
        updateStoresAndProductsListUi();
    }

    @Override
    public void addProductToResult(int storeId, Product product) {
        if (!mProductsMap.containsKey(storeId)) {
            mProductsMap.put(storeId, new ArrayList<>());
        }
        mProductsMap.get(storeId).add(product);
        updateStoresAndProductsListUi();
    }

    private void updateStoresAndProductsListUi() {
        mResultList.clear();
        for (Store store : mStoreList) {
            mResultList.add(store.getName());
            if (mProductsMap.containsKey(store.getId())) {
                for (Product product : mProductsMap.get(store.getId())) {
                    mResultList.add("     " + product.getName());
                }
            }
        }
        mAdapter.setItems(mResultList);
        mAdapter.notifyDataSetChanged();
    }

    @Override
    public void loadStoresError(Throwable t) {
        mTextViewStoresError.setText(t.toString());
    }

    @Override
    public void loadProductsError(Throwable t) {
        mTextViewProductsError.setText(t.toString());
    }
}
