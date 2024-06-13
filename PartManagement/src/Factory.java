public class Factory {
    private ReceivingStock stock;
    private Purchasing purchasing;

    public Factory(Purchasing purchasing, ReceivingStock receivingStock) {
        if(purchasing == null || receivingStock == null) throw new NullPointerException();
        this.stock = receivingStock;
        this.purchasing = purchasing;
    }

    public ReceivingStock getStock() {
        return stock;
    }

    public Purchasing getPurchasing() {
        return purchasing;
    }

    public static Part create(PartType partType, String id, String name){
        if(partType == null || id == null || name == null) throw new NullPointerException();
        if(id.isEmpty() || name.isEmpty()) throw new IllegalArgumentException();
        switch(partType){
            case RESOURCE: return new Resource(id, name);
            case COMPONENTS: return new Components(id, name);
            case SINGLE_COMPONENT: return new SingleComponent(id, name);
            default: throw new IllegalArgumentException();
        }
    }
}
