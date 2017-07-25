package com.vitaliyhtc.rxjava2investigation.data.model;

import com.vitaliyhtc.rxjava2investigation.model.Product;
import com.vitaliyhtc.rxjava2investigation.model.Store;

public abstract class ConvertUtils {

    private ConvertUtils() {
        throw new AssertionError();
    }

    public static Store convertStoreModel(com.vitaliyhtc.rxjava2investigation.data.model.response.Store s) {
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

    public static Product convertProductModel(com.vitaliyhtc.rxjava2investigation.data.model.response.Product p) {
        return new Product(
                p.getId(),
                p.isDead(),
                p.getName(),
                p.getTags(),
                p.isDiscontinued(),
                p.getPriceInCents(),
                p.getRegularPriceInCents(),
                p.getLimitedTimeOfferSavingsInCents(),
                p.getLimitedTimeOfferEndsOn(),
                p.getBonusRewardMiles(),
                p.getBonusRewardMilesEndsOn(),
                p.getStockType(),
                p.getPrimaryCategory(),
                p.getSecondaryCategory(),
                p.getOrigin(),
                p.getPackageOfProduct(),
                p.getPackageUnitType(),
                p.getPackageUnitVolumeInMilliliters(),
                p.getTotalPackageUnits(),
                p.getVolumeInMilliliters(),
                p.getAlcoholContent(),
                p.getPricePerLiterOfAlcoholInCents(),
                p.getPricePerLiterInCents(),
                p.getInventoryCount(),
                p.getInventoryVolumeInMilliliters(),
                p.getInventoryPriceInCents(),
                p.getSugarContent(),
                p.getProducerName(),
                p.getReleasedOn(),
                p.isHasValueAddedPromotion(),
                p.isHasLimitedTimeOffer(),
                p.isHasBonusRewardMiles(),
                p.isSeasonal(),
                p.isVqa(),
                p.isOcb(),
                p.isKosher(),
                p.getValueAddedPromotionDescription(),
                p.getDescription(),
                p.getServingSuggestion(),
                p.getTastingNote(),
                p.getUpdatedAt(),
                p.getImageThumbUrl(),
                p.getImageUrl(),
                p.getVarietal(),
                p.getStyle(),
                p.getTertiaryCategory(),
                p.getSugarInGramsPerLiter(),
                p.getClearanceSaleSavingsInCents(),
                p.isHasClearanceSale(),
                p.getProductNo()
        );
    }
}
