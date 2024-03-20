package com.sem2.task6.builder;

public class Product {
    private float price;
    private String name;
    private boolean isPopular;
    private boolean isBig;
    private boolean hasGoodQuality;

    private Product(ProductBuilder builder) {
        this.price = builder.price;
        this.name = builder.name;
        this.isPopular = builder.isPopular;
        this.isBig = builder.isBig;
        this.hasGoodQuality = builder.hasGoodQuality;
    }

    public float getPrice() {
        return price;
    }

    public String getName() {
        return name;
    }

    public boolean isPopular() {
        return isPopular;
    }

    public boolean isBig() {
        return isBig;
    }

    public boolean isHasGoodQuality() {
        return hasGoodQuality;
    }

    @Override
    public String toString(){
        return "Name: " + name + " price: " + price + (isPopular?" popular":" not popular")
                + (isBig?" big":" small") + (hasGoodQuality?" has good quality":" has bad quality");
    }

    public static class ProductBuilder{
        private float price;
        private String name;
        private boolean isPopular = false;
        private boolean isBig = false;
        private boolean hasGoodQuality = false;
        public ProductBuilder(float price, String name){
            this.price = price;
            this.name = name;
        }

        public ProductBuilder setPopular(boolean popular) {
            isPopular = popular;
            return this;
        }

        public ProductBuilder setBig(boolean big) {
            isBig = big;
            return this;
        }

        public ProductBuilder setHasGoodQuality(boolean hasGoodQuality) {
            this.hasGoodQuality = hasGoodQuality;
            return this;
        }

        public Product build(){
            return new Product(this);
        }
    }
}
