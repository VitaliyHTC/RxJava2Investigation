package com.vitaliyhtc.rxjava2investigation.data.model;

import com.vitaliyhtc.rxjava2investigation.domain.model.Store;

import io.reactivex.annotations.NonNull;
import io.reactivex.functions.Function;

public class StoreMapper implements Function<com.vitaliyhtc.rxjava2investigation.data.model.response.Store, Store> {

    @Override
    public Store apply(@NonNull com.vitaliyhtc.rxjava2investigation.data.model.response.Store s) throws Exception {
        return new Store(
                s.getId(),
                s.isDead(),
                s.getName(),
                s.getTags(),
                s.getAddressLine1(),
                s.getAddressLine2(),
                s.getCity(),
                s.getPostalCode(),
                s.getTelephone(),
                s.getFax(),
                s.getLatitude(),
                s.getLongitude(),
                s.getProductsCount(),
                s.getInventoryCount(),
                s.getInventoryPriceInCents(),
                s.getInventoryVolumeInMilliliters(),
                s.isHasWheelchairAccessability(),
                s.isHasBilingualServices(),
                s.isHasProductConsultant(),
                s.isHasTastingBar(),
                s.isHasBeerColdRoom(),
                s.isHasSpecialOccasionPermits(),
                s.isHasVintagesCorner(),
                s.isHasParking(),
                s.isHasTransitAccess(),
                s.getSundayOpen(),
                s.getSundayClose(),
                s.getMondayOpen(),
                s.getMondayClose(),
                s.getTuesdayOpen(),
                s.getTuesdayClose(),
                s.getWednesdayOpen(),
                s.getWednesdayClose(),
                s.getThursdayOpen(),
                s.getThursdayClose(),
                s.getFridayOpen(),
                s.getFridayClose(),
                s.getSaturdayOpen(),
                s.getSaturdayClose(),
                s.getUpdatedAt(),
                s.getStoreNo()
        );
    }
}
