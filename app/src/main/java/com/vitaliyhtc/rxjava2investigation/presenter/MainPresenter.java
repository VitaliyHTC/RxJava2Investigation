package com.vitaliyhtc.rxjava2investigation.presenter;

import android.annotation.SuppressLint;

import com.vitaliyhtc.rxjava2investigation.domain.ProductRepository;
import com.vitaliyhtc.rxjava2investigation.domain.RxFilter;
import com.vitaliyhtc.rxjava2investigation.domain.StoreRepository;
import com.vitaliyhtc.rxjava2investigation.presenter.model.Product;
import com.vitaliyhtc.rxjava2investigation.presenter.model.Store;
import com.vitaliyhtc.rxjava2investigation.presenter.model.mapper.ProductMapper;
import com.vitaliyhtc.rxjava2investigation.presenter.model.mapper.StoreMapper;
import com.vitaliyhtc.rxjava2investigation.view.MainView;

import java.util.HashMap;
import java.util.Map;

import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;

public class MainPresenter implements BasePresenter<MainView> {

    private static final int LCBO_FIRST_PAGE_INDEX = 0x01;
    private static final int COUNT_STORES = 5;
    private static final RxFilter<Store> mStoresFilter =
            store -> true;
    //store -> store.getName().startsWith("A");

    private static final int COUNT_PRODUCTS_PER_STORE = 20;
    private static final RxFilter<Product> mProductFilter =
            product -> true;

    private MainView mMainView;

    private StoreRepository mStoreRepository;
    private ProductRepository mProductRepository;

    private CompositeDisposable mCompositeDisposable;

    private int mCountStores;

    private Map<Integer, Integer> mCountProducts;

    @SuppressLint("UseSparseArrays")
    public MainPresenter(StoreRepository storeRepository, ProductRepository productRepository) {
        mStoreRepository = storeRepository;
        mProductRepository = productRepository;
        mCountProducts = new HashMap<>();
    }

    @Override
    public void onAttachView(MainView mainView) {
        mMainView = mainView;
        mCompositeDisposable = new CompositeDisposable();
    }

    @Override
    public void onDetachView() {
        mMainView = null;

        if (mCompositeDisposable != null) {
            mCompositeDisposable.dispose();
        }
    }


    public void loadData() {
        loadStores(COUNT_STORES, mStoresFilter, LCBO_FIRST_PAGE_INDEX);
    }

    private void loadStores(int count, RxFilter<Store> filter, int page) {
        Disposable disposable =
                mStoreRepository.getStoresObservable(page)
                        .subscribeOn(Schedulers.io())
                        .flatMap(Observable::fromIterable)
                        .map(new StoreMapper())
                        .filter(filter::isMeetsCondition)
                        .observeOn(AndroidSchedulers.mainThread())
                        .subscribe(
                                store -> {
                                    if (mCountStores < count) {
                                        addStoreToResult(store);
                                        mCountStores++;
                                    }
                                },
                                this::loadStoresError,
                                () -> {
                                    if (mCountStores < count)
                                        loadStores(count, filter, page + 1);
                                }
                        );
        mCompositeDisposable.add(disposable);
    }

    private void addStoreToResult(Store store) {
        mMainView.addStoreToResult(store);
        mCountProducts.put(store.getId(), 0);
        loadProducts(store.getId(), COUNT_PRODUCTS_PER_STORE, mProductFilter, LCBO_FIRST_PAGE_INDEX);
    }

    private void loadProducts(int storeId, int count, RxFilter<Product> filter, int page) {
        Disposable disposable =
                mProductRepository.getProductsObservable(page, storeId)
                        .subscribeOn(Schedulers.io())
                        .flatMap(Observable::fromIterable)
                        .map(new ProductMapper())
                        .filter(filter::isMeetsCondition)
                        .observeOn(AndroidSchedulers.mainThread())
                        .subscribe(
                                product -> {
                                    if (mCountProducts.get(storeId) < count) {
                                        addProductToResult(storeId, product);
                                        mCountProducts.put(storeId, mCountProducts.get(storeId) + 1);
                                    }
                                },
                                this::loadProductsError,
                                () -> {
                                    if (mCountProducts.get(storeId) < count)
                                        loadProducts(storeId, count, filter, page + 1);
                                }
                        );
        mCompositeDisposable.add(disposable);
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
