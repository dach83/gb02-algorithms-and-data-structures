package ru.geekbrains.lesson5;

public class BagPacker {

    private final int maxWeight;
    private Bag bestPriceBag;

    public BagPacker(int maxWeight) {
        this.maxWeight = maxWeight;
        this.bestPriceBag = new Bag();
    }

    public static Bag pack(int maxWeight, Thing... things) {
        BagPacker bagPacker = new BagPacker(maxWeight);
        Bag bag = new Bag();
        bagPacker.putThingsToBag(0, bag, things);
        return bagPacker.bestPriceBag;
    }

    private void putThingsToBag(int startInd, Bag bag, Thing... things) {
        for (int i = startInd; i < things.length; i++) {
            if (bag.getWeight() + things[i].getWeight() <= maxWeight && bag.put(things[i])) {
                System.out.println(bag);
                putThingsToBag(i + 1, bag, things);
                if (bestPriceBag.getPrice() < bag.getPrice())
                    bestPriceBag = new Bag(bag); // запомним рюкзак с максимальной стоимостью
                bag.remove(things[i]);
            }
        }
    }
}
