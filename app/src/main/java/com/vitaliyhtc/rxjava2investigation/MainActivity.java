package com.vitaliyhtc.rxjava2investigation;

import android.annotation.SuppressLint;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.Button;
import android.widget.TextView;

import com.vitaliyhtc.rxjava2investigation.app.App;
import com.vitaliyhtc.rxjava2investigation.domain.ProductRepository;
import com.vitaliyhtc.rxjava2investigation.domain.StoreRepository;
import com.vitaliyhtc.rxjava2investigation.presenter.model.Product;
import com.vitaliyhtc.rxjava2investigation.presenter.model.Store;
import com.vitaliyhtc.rxjava2investigation.presenter.MainPresenter;
import com.vitaliyhtc.rxjava2investigation.view.MainView;
import com.vitaliyhtc.rxjava2investigation.view.adapter.StoreProductAdapter;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class MainActivity extends AppCompatActivity implements MainView {

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

    @Inject
    StoreRepository mStoreRepository;
    @Inject
    ProductRepository mProductRepository;

    private List<Store> mStoreList;
    private Map<Integer, List<Product>> mProductsMap;

    private StoreProductAdapter mAdapter;

    @SuppressLint("UseSparseArrays")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        App.getComponent().inject(this);

        ButterKnife.bind(this);

        mRecyclerView.setLayoutManager(new LinearLayoutManager(MainActivity.this));
        mAdapter = new StoreProductAdapter();
        mRecyclerView.setAdapter(mAdapter);

        mStoreList = new ArrayList<>();
        mProductsMap = new HashMap<>();

        mMainPresenter = new MainPresenter(mStoreRepository, mProductRepository);
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

    @SuppressWarnings("Convert2streamapi")
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
