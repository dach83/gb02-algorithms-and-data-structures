package ru.geekbrains.lesson5;

public class BagPacker {

    private Bag bestBag;

    private BagPacker() {
        bestBag = Bag.EMPTY;
    }

    private void putThingsToBag(Bag bag, Thing... things) {
        if (bestBag.getPrice() < bag.getPrice())
            bestBag = new Bag(bag);
    }

    public static Bag pack(int maxWeight, Thing... things) {
        BagPacker bagPacker = new BagPacker();
        Bag bag = new Bag(maxWeight);
        bagPacker.putThingsToBag(bag, things);
        return bagPacker.bestBag;
    }
}
