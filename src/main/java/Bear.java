package main.java;

import main.java.Stuffing.stuffing;
import java.util.LinkedList;

public class Bear implements Comparable<Bear>{
    public Casing casing;
    public Stuffing stuff;
    public Embroidery ink; 
    public LinkedList<NoiseMaker> noisemakers; // accessory
    public LinkedList<Clothing> clothing; // accessory
    double price;
    // bear has a shell (requ)
    // bear has stuffing (req)
    // bear has a tattoo/emroider or not (opt)
    // bear has a noisemaker (opt)


    public Bear() {
        this.casing = new Casing();
        this.stuff = new Stuffing(stuffing.BASE);
        noisemakers = new LinkedList<>();
        clothing = new LinkedList<>();
        ink = new Embroidery("");
        price = 0;
    }

    public Bear(stuffing stuff) {
        this.casing = new Casing();
        this.stuff = new Stuffing(stuff);
        noisemakers = new LinkedList<>();
        clothing = new LinkedList<>();
        ink = new Embroidery("");
        if(stuff == stuffing.BASE) {
        	price = 30.00;
        }else if(stuff == stuffing.DOWN) {
        	price = 40.00;
        }else if(stuff == stuffing.FOAM) {
        	price = 50.00;
        }
    }

    public void setPrice(double incomingPrice) {
        this.price = incomingPrice;
    }

    public boolean addNoise(NoiseMaker noise) {
        if (this.noisemakers.size() >= 5) {
            return false;
        } else {
            for (NoiseMaker noisemaker: noisemakers) {
                if (noise.spot == noisemaker.spot) {
                    return false;
                }
            }
            noisemakers.add(noise);
            return true;
        }
    }

    @Override
    public int compareTo(Bear bear) {
        return new Double(this.price).compareTo(bear.price);
    }
}