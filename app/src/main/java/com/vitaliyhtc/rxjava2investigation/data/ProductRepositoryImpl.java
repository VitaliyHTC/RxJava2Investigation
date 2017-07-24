package com.vitaliyhtc.rxjava2investigation.data;

import com.vitaliyhtc.rxjava2investigation.domain.ProductRepository;
import com.vitaliyhtc.rxjava2investigation.domain.model.Product;
import com.vitaliyhtc.rxjava2investigation.presenter.ResultProductsCallback;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;

public class ProductRepositoryImpl implements ProductRepository {

    private ResultProductsCallback mResultCallback;
    private ProductDataManager mProductDataManager;

    private Disposable mDisposableProducts;
    private int mCountProducts;

    public ProductRepositoryImpl(ResultProductsCallback callback) {
        mResultCallback = callback;
    }

    @Override
    public void initResources() {
        mProductDataManager = new ProductDataManagerImpl();
        mProductDataManager.initResources();
    }

    @Override
    public void releaseResources() {
        RxUtils.dispose(mDisposableProducts);
        mProductDataManager.releaseResources();
        mProductDataManager = null;
    }

    @Override
    public void loadProducts(int storeId, int count, RxFilter<Product> filter) {
        if(mProductDataManager != null) {
            mCountProducts = 0;
            mDisposableProducts = mProductDataManager.getProductsObservable(storeId)
                    .subscribeOn(Schedulers.io())
                    .map(product -> new com.vitaliyhtc.rxjava2investigation.domain.model.Product(product.getId(), product.getName()))
                    .filter(filter::isMeetsCondition)
                    .take(count)
                    .observeOn(AndroidSchedulers.mainThread())
                    .subscribe(
                            product -> {
                                mResultCallback.addProductToResult(storeId, product);
                                mCountProducts++;
                                if (mCountProducts >= count)
                                    RxUtils.dispose(mDisposableProducts);
                            },
                            throwable -> mResultCallback.loadProductsError(throwable)
                    );
        }
    }

}
