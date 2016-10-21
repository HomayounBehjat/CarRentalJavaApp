public enum ShoppingItems {
    Apple("Apple"),
    Orange("Orange");

    private final String value;

    /**
     * @param value Representing the name of the Shopping Item
     */
    ShoppingItems(final String value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return value;
    }
}