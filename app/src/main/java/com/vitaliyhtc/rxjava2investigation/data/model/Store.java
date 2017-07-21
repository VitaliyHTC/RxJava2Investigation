package com.vitaliyhtc.rxjava2investigation.data.model;

import com.google.gson.annotations.SerializedName;

@SuppressWarnings("unused")
public class Store {

    @SerializedName("id")
    private int id;

    @SerializedName("is_dead")
    private boolean isDead;
    @SerializedName("name")
    private String name;
    @SerializedName("tags")
    private String tags;
    @SerializedName("address_line_1")
    private String addressLine1;
    @SerializedName("address_line_2")
    private String addressLine2;
    @SerializedName("city")
    private String city;
    @SerializedName("postal_code")
    private String postalCode;
    @SerializedName("telephone")
    private String telephone;
    @SerializedName("fax")
    private String fax;
    @SerializedName("latitude")
    private double latitude;
    @SerializedName("longitude")
    private double longitude;
    @SerializedName("products_count")
    private int productsCount;
    @SerializedName("inventory_count")
    private int inventoryCount;
    @SerializedName("inventory_price_in_cents")
    private long inventoryPriceInCents;
    @SerializedName("inventory_volume_in_milliliters")
    private long inventoryVolumeInMilliliters;

    @SerializedName("has_wheelchair_accessability")
    private boolean hasWheelchairAccessability;
    @SerializedName("has_bilingual_services")
    private boolean hasBilingualServices;
    @SerializedName("has_product_consultant")
    private boolean hasProductConsultant;
    @SerializedName("has_tasting_bar")
    private boolean hasTastingBar;
    @SerializedName("has_beer_cold_room")
    private boolean hasBeerColdRoom;
    @SerializedName("has_special_occasion_permits")
    private boolean hasSpecialOccasionPermits;
    @SerializedName("has_vintages_corner")
    private boolean hasVintagesCorner;
    @SerializedName("has_parking")
    private boolean hasParking;
    @SerializedName("has_transit_access")
    private boolean hasTransitAccess;

    @SerializedName("sunday_open")
    private int sundayOpen;
    @SerializedName("sunday_close")
    private int sundayClose;
    @SerializedName("monday_open")
    private int mondayOpen;
    @SerializedName("monday_close")
    private int mondayClose;
    @SerializedName("tuesday_open")
    private int tuesdayOpen;
    @SerializedName("tuesday_close")
    private int tuesdayClose;
    @SerializedName("wednesday_open")
    private int wednesdayOpen;
    @SerializedName("wednesday_close")
    private int wednesdayClose;
    @SerializedName("thursday_open")
    private int thursdayOpen;
    @SerializedName("thursday_close")
    private int thursdayClose;
    @SerializedName("friday_open")
    private int fridayOpen;
    @SerializedName("friday_close")
    private int fridayClose;
    @SerializedName("saturday_open")
    private int saturdayOpen;
    @SerializedName("saturday_close")
    private int saturdayClose;

    @SerializedName("updated_at")
    private String updatedAt;
    @SerializedName("store_no")
    private int storeNo;


    public Store() {
    }

    public Store(int id, boolean isDead, String name, String tags, String addressLine1, String addressLine2,
                 String city, String postalCode, String telephone, String fax, double latitude, double longitude,
                 int productsCount, int inventoryCount, long inventoryPriceInCents, long inventoryVolumeInMilliliters,
                 boolean hasWheelchairAccessability, boolean hasBilingualServices, boolean hasProductConsultant,
                 boolean hasTastingBar, boolean hasBeerColdRoom, boolean hasSpecialOccasionPermits,
                 boolean hasVintagesCorner, boolean hasParking, boolean hasTransitAccess,
                 int sundayOpen, int sundayClose, int mondayOpen, int mondayClose, int tuesdayOpen,
                 int tuesdayClose, int wednesdayOpen, int wednesdayClose, int thursdayOpen, int thursdayClose,
                 int fridayOpen, int fridayClose, int saturdayOpen, int saturdayClose, String updatedAt, int storeNo) {
        this.id = id;
        this.isDead = isDead;
        this.name = name;
        this.tags = tags;
        this.addressLine1 = addressLine1;
        this.addressLine2 = addressLine2;
        this.city = city;
        this.postalCode = postalCode;
        this.telephone = telephone;
        this.fax = fax;
        this.latitude = latitude;
        this.longitude = longitude;
        this.productsCount = productsCount;
        this.inventoryCount = inventoryCount;
        this.inventoryPriceInCents = inventoryPriceInCents;
        this.inventoryVolumeInMilliliters = inventoryVolumeInMilliliters;
        this.hasWheelchairAccessability = hasWheelchairAccessability;
        this.hasBilingualServices = hasBilingualServices;
        this.hasProductConsultant = hasProductConsultant;
        this.hasTastingBar = hasTastingBar;
        this.hasBeerColdRoom = hasBeerColdRoom;
        this.hasSpecialOccasionPermits = hasSpecialOccasionPermits;
        this.hasVintagesCorner = hasVintagesCorner;
        this.hasParking = hasParking;
        this.hasTransitAccess = hasTransitAccess;
        this.sundayOpen = sundayOpen;
        this.sundayClose = sundayClose;
        this.mondayOpen = mondayOpen;
        this.mondayClose = mondayClose;
        this.tuesdayOpen = tuesdayOpen;
        this.tuesdayClose = tuesdayClose;
        this.wednesdayOpen = wednesdayOpen;
        this.wednesdayClose = wednesdayClose;
        this.thursdayOpen = thursdayOpen;
        this.thursdayClose = thursdayClose;
        this.fridayOpen = fridayOpen;
        this.fridayClose = fridayClose;
        this.saturdayOpen = saturdayOpen;
        this.saturdayClose = saturdayClose;
        this.updatedAt = updatedAt;
        this.storeNo = storeNo;
    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public boolean isDead() {
        return isDead;
    }

    public void setDead(boolean dead) {
        isDead = dead;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTags() {
        return tags;
    }

    public void setTags(String tags) {
        this.tags = tags;
    }

    public String getAddressLine1() {
        return addressLine1;
    }

    public void setAddressLine1(String addressLine1) {
        this.addressLine1 = addressLine1;
    }

    public String getAddressLine2() {
        return addressLine2;
    }

    public void setAddressLine2(String addressLine2) {
        this.addressLine2 = addressLine2;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getPostalCode() {
        return postalCode;
    }

    public void setPostalCode(String postalCode) {
        this.postalCode = postalCode;
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    public String getFax() {
        return fax;
    }

    public void setFax(String fax) {
        this.fax = fax;
    }

    public double getLatitude() {
        return latitude;
    }

    public void setLatitude(double latitude) {
        this.latitude = latitude;
    }

    public double getLongitude() {
        return longitude;
    }

    public void setLongitude(double longitude) {
        this.longitude = longitude;
    }

    public int getProductsCount() {
        return productsCount;
    }

    public void setProductsCount(int productsCount) {
        this.productsCount = productsCount;
    }

    public int getInventoryCount() {
        return inventoryCount;
    }

    public void setInventoryCount(int inventoryCount) {
        this.inventoryCount = inventoryCount;
    }

    public long getInventoryPriceInCents() {
        return inventoryPriceInCents;
    }

    public void setInventoryPriceInCents(long inventoryPriceInCents) {
        this.inventoryPriceInCents = inventoryPriceInCents;
    }

    public long getInventoryVolumeInMilliliters() {
        return inventoryVolumeInMilliliters;
    }

    public void setInventoryVolumeInMilliliters(long inventoryVolumeInMilliliters) {
        this.inventoryVolumeInMilliliters = inventoryVolumeInMilliliters;
    }

    public boolean isHasWheelchairAccessability() {
        return hasWheelchairAccessability;
    }

    public void setHasWheelchairAccessability(boolean hasWheelchairAccessability) {
        this.hasWheelchairAccessability = hasWheelchairAccessability;
    }

    public boolean isHasBilingualServices() {
        return hasBilingualServices;
    }

    public void setHasBilingualServices(boolean hasBilingualServices) {
        this.hasBilingualServices = hasBilingualServices;
    }

    public boolean isHasProductConsultant() {
        return hasProductConsultant;
    }

    public void setHasProductConsultant(boolean hasProductConsultant) {
        this.hasProductConsultant = hasProductConsultant;
    }

    public boolean isHasTastingBar() {
        return hasTastingBar;
    }

    public void setHasTastingBar(boolean hasTastingBar) {
        this.hasTastingBar = hasTastingBar;
    }

    public boolean isHasBeerColdRoom() {
        return hasBeerColdRoom;
    }

    public void setHasBeerColdRoom(boolean hasBeerColdRoom) {
        this.hasBeerColdRoom = hasBeerColdRoom;
    }

    public boolean isHasSpecialOccasionPermits() {
        return hasSpecialOccasionPermits;
    }

    public void setHasSpecialOccasionPermits(boolean hasSpecialOccasionPermits) {
        this.hasSpecialOccasionPermits = hasSpecialOccasionPermits;
    }

    public boolean isHasVintagesCorner() {
        return hasVintagesCorner;
    }

    public void setHasVintagesCorner(boolean hasVintagesCorner) {
        this.hasVintagesCorner = hasVintagesCorner;
    }

    public boolean isHasParking() {
        return hasParking;
    }

    public void setHasParking(boolean hasParking) {
        this.hasParking = hasParking;
    }

    public boolean isHasTransitAccess() {
        return hasTransitAccess;
    }

    public void setHasTransitAccess(boolean hasTransitAccess) {
        this.hasTransitAccess = hasTransitAccess;
    }

    public int getSundayOpen() {
        return sundayOpen;
    }

    public void setSundayOpen(int sundayOpen) {
        this.sundayOpen = sundayOpen;
    }

    public int getSundayClose() {
        return sundayClose;
    }

    public void setSundayClose(int sundayClose) {
        this.sundayClose = sundayClose;
    }

    public int getMondayOpen() {
        return mondayOpen;
    }

    public void setMondayOpen(int mondayOpen) {
        this.mondayOpen = mondayOpen;
    }

    public int getMondayClose() {
        return mondayClose;
    }

    public void setMondayClose(int mondayClose) {
        this.mondayClose = mondayClose;
    }

    public int getTuesdayOpen() {
        return tuesdayOpen;
    }

    public void setTuesdayOpen(int tuesdayOpen) {
        this.tuesdayOpen = tuesdayOpen;
    }

    public int getTuesdayClose() {
        return tuesdayClose;
    }

    public void setTuesdayClose(int tuesdayClose) {
        this.tuesdayClose = tuesdayClose;
    }

    public int getWednesdayOpen() {
        return wednesdayOpen;
    }

    public void setWednesdayOpen(int wednesdayOpen) {
        this.wednesdayOpen = wednesdayOpen;
    }

    public int getWednesdayClose() {
        return wednesdayClose;
    }

    public void setWednesdayClose(int wednesdayClose) {
        this.wednesdayClose = wednesdayClose;
    }

    public int getThursdayOpen() {
        return thursdayOpen;
    }

    public void setThursdayOpen(int thursdayOpen) {
        this.thursdayOpen = thursdayOpen;
    }

    public int getThursdayClose() {
        return thursdayClose;
    }

    public void setThursdayClose(int thursdayClose) {
        this.thursdayClose = thursdayClose;
    }

    public int getFridayOpen() {
        return fridayOpen;
    }

    public void setFridayOpen(int fridayOpen) {
        this.fridayOpen = fridayOpen;
    }

    public int getFridayClose() {
        return fridayClose;
    }

    public void setFridayClose(int fridayClose) {
        this.fridayClose = fridayClose;
    }

    public int getSaturdayOpen() {
        return saturdayOpen;
    }

    public void setSaturdayOpen(int saturdayOpen) {
        this.saturdayOpen = saturdayOpen;
    }

    public int getSaturdayClose() {
        return saturdayClose;
    }

    public void setSaturdayClose(int saturdayClose) {
        this.saturdayClose = saturdayClose;
    }

    public String getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(String updatedAt) {
        this.updatedAt = updatedAt;
    }

    public int getStoreNo() {
        return storeNo;
    }

    public void setStoreNo(int storeNo) {
        this.storeNo = storeNo;
    }
}
