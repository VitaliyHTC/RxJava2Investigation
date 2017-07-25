package com.vitaliyhtc.rxjava2investigation.presenter;

import com.vitaliyhtc.rxjava2investigation.data.ProductRepositoryImpl;
import com.vitaliyhtc.rxjava2investigation.domain.RxFilter;
import com.vitaliyhtc.rxjava2investigation.domain.ProductRepository;
import com.vitaliyhtc.rxjava2investigation.domain.RxUtils;
import com.vitaliyhtc.rxjava2investigation.domain.StoreRepository;
import com.vitaliyhtc.rxjava2investigation.data.StoreRepositoryImpl;
import com.vitaliyhtc.rxjava2investigation.domain.model.Product;
import com.vitaliyhtc.rxjava2investigation.domain.model.Store;
import com.vitaliyhtc.rxjava2investigation.view.MainView;

import java.util.HashMap;
import java.util.Map;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;

public class MainPresenterImpl implements MainPresenter<MainView> {

    private static final int COUNT_STORES = 5;
    private static final RxFilter<Store> mStoresFilter =
            store -> store.getName().startsWith("A");

    private static final int COUNT_PRODUCTS_PER_STORE = 20;
    private static final RxFilter<Product> mProductFilter =
            product -> true;

    private MainView mMainView;

    private StoreRepository mStoreRepository;
    private Map<Integer, ProductRepository> mProductRepositories;

    private Disposable mDisposableStores;
    private int mCountStores;

    private Map<Integer, Disposable> mDisposableProducts;
    private Map<Integer, Integer> mCountProducts;

    public MainPresenterImpl() {
        mStoreRepository = new StoreRepositoryImpl();
        mProductRepositories = new HashMap<>();
        mDisposableProducts = new HashMap<>();
        mCountProducts = new HashMap<>();
    }

    @Override
    public void onAttachView(MainView mainView) {
        mMainView = mainView;
        mStoreRepository.initResources();
    }

    @Override
    public void onDetachView() {
        mMainView = null;

        RxUtils.dispose(mDisposableStores);
        for (Map.Entry<Integer, Disposable> entry : mDisposableProducts.entrySet()) {
            RxUtils.dispose(entry.getValue());
        }

        mStoreRepository.releaseResources();
        for (Map.Entry<Integer, ProductRepository> entry : mProductRepositories.entrySet()) {
            entry.getValue().releaseResources();
        }
    }

    @Override
    public void loadData() {
        loadStores(COUNT_STORES, mStoresFilter);
    }

    private void loadStores(int count, RxFilter<Store> filter) {
        mCountStores = 0;
        mDisposableStores = mStoreRepository.getStoresObservable()
                .subscribeOn(Schedulers.io())
                .map(store -> new Store(store.getId(), store.getName()))
                .filter(filter::isMeetsCondition)
                .take(count)
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(
                        store -> {
                            addStoreToResult(store);
                            mCountStores++;
                            if (mCountStores >= COUNT_STORES)
                                RxUtils.dispose(mDisposableStores);
                        },
                        throwable -> loadStoresError(throwable)
                );
    }

    private void addStoreToResult(Store store) {
        mMainView.addStoreToResult(store);
        ProductRepository productRepository = new ProductRepositoryImpl();
        productRepository.initResources();
        mProductRepositories.put(store.getId(), productRepository);
        loadProducts(store.getId(), COUNT_PRODUCTS_PER_STORE, mProductFilter);
    }

    private void loadProducts(int storeId, int count, RxFilter<Product> filter) {
        mCountProducts.put(storeId, 0);
        mDisposableProducts.put(
                storeId,
                mProductRepositories.get(storeId).getProductsObservable(storeId)
                        .subscribeOn(Schedulers.io())
                        .map(product -> new com.vitaliyhtc.rxjava2investigation.domain.model.Product(product.getId(), product.getName()))
                        .filter(filter::isMeetsCondition)
                        .take(count)
                        .observeOn(AndroidSchedulers.mainThread())
                        .subscribe(
                                product -> {
                                    addProductToResult(storeId, product);
                                    mCountProducts.put(storeId, mCountProducts.get(storeId) + 1);
                                    if (mCountProducts.get(storeId) >= count)
                                        RxUtils.dispose(mDisposableProducts.get(storeId));
                                },
                                throwable -> loadProductsError(throwable)
                        )
        );
    }

    private void addProductToResult(int storeId, Product product) {
        mMainView.addProductToResult(storeId, product);
    }

    private void loadStoresError(Throwable t) {
        mMainView.loadStoresError(t);
    }

    private void loadProductsError(Throwable t) {
        mMainView.loadProductsError(t);
    }

}
