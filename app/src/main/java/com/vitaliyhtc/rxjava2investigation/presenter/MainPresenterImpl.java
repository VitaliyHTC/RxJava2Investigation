package com.vitaliyhtc.rxjava2investigation.presenter;

import com.vitaliyhtc.rxjava2investigation.data.ProductRepositoryImpl;
import com.vitaliyhtc.rxjava2investigation.data.RxFilter;
import com.vitaliyhtc.rxjava2investigation.domain.ProductRepository;
import com.vitaliyhtc.rxjava2investigation.domain.Repository;
import com.vitaliyhtc.rxjava2investigation.domain.StoreRepository;
import com.vitaliyhtc.rxjava2investigation.data.StoreRepositoryImpl;
import com.vitaliyhtc.rxjava2investigation.domain.model.Product;
import com.vitaliyhtc.rxjava2investigation.domain.model.Store;
import com.vitaliyhtc.rxjava2investigation.view.MainView;

import java.util.HashSet;
import java.util.Set;

public class MainPresenterImpl implements MainPresenter<MainView>,
        ResultStoresCallback, ResultProductsCallback {

    private static final int COUNT_STORES = 5;
    private static final RxFilter<Store> mStoresFilter =
            store -> store.getName().startsWith("A");

    private static final int COUNT_PRODUCTS_PER_STORE = 20;
    private static final RxFilter<Product> mProductFilter =
            product -> true;

    private MainView mMainView;

    private StoreRepository mStoreRepository;
    private Set<ProductRepository> mProductRepositories;

    public MainPresenterImpl() {
        mStoreRepository = new StoreRepositoryImpl(MainPresenterImpl.this);
        mProductRepositories = new HashSet<>();
    }

    @Override
    public void onAttachView(MainView mainView) {
        mMainView = mainView;
        mStoreRepository.initResources();
    }

    @Override
    public void onDetachView() {
        mMainView = null;
        mStoreRepository.releaseResources();
        for (Repository repository : mProductRepositories) {
            repository.releaseResources();
        }
        //mProductRepositories.forEach(Repository::releaseResources);
    }

    @Override
    public void addStoreToResult(Store store) {
        mMainView.addStoreToResult(store);
        ProductRepository productRepository = new ProductRepositoryImpl(MainPresenterImpl.this);
        productRepository.initResources();
        mProductRepositories.add(productRepository);
        productRepository.loadProducts(store.getId(), COUNT_PRODUCTS_PER_STORE, mProductFilter);
    }

    @Override
    public void addProductToResult(int storeId, Product product) {
        mMainView.addProductToResult(storeId, product);
    }

    @Override
    public void loadStoresError(Throwable t) {
        mMainView.loadStoresError(t);
    }

    @Override
    public void loadProductsError(Throwable t) {
        mMainView.loadProductsError(t);
    }

    @Override
    public void loadData() {
        mStoreRepository.loadStores(COUNT_STORES, mStoresFilter);
    }
}
