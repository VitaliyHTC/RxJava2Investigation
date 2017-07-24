package com.vitaliyhtc.rxjava2investigation;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.Button;
import android.widget.TextView;

import com.vitaliyhtc.rxjava2investigation.domain.model.Product;
import com.vitaliyhtc.rxjava2investigation.domain.model.Store;
import com.vitaliyhtc.rxjava2investigation.presenter.MainPresenter;
import com.vitaliyhtc.rxjava2investigation.presenter.MainPresenterImpl;
import com.vitaliyhtc.rxjava2investigation.view.MainView;

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

    @BindView(R.id.btn_load)
    Button mButtonLoad;
    @BindView(R.id.tv_result)
    TextView mTextViewResult;
    @BindView(R.id.tv_error)
    TextView mTextViewError;

    private List<Store> mStoreList;
    private Map<Integer, List<Product>> mProductsMap;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ButterKnife.bind(this);

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
        mTextViewResult.setText("Result...");
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

    // TODO: 24/07/17 never ever do this again!!! if you have list - display list.
    private void updateStoresAndProductsListUi() {
        StringBuilder sb = new StringBuilder();
        for (Store store : mStoreList) {
            sb.append(store.getName()).append("\r\n");
            if (mProductsMap.containsKey(store.getId())) {
                for (Product product : mProductsMap.get(store.getId())) {
                    sb.append("___").append(product.getName()).append("\r\n");
                }
            }
        }
        mTextViewResult.setText(sb.toString());
        mTextViewError.setText("Error...");
    }

    @Override
    public void onError(Throwable t) {
        Log.e(TAG, "onError: ", t);
        mTextViewError.setText(t.toString());
    }
}
