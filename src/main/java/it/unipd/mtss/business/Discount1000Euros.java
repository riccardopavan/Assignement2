////////////////////////////////////////////////////////////////////
// Alberto Lazari 1216747
// Riccardo Pavan 1189938
////////////////////////////////////////////////////////////////////
package it.unipd.mtss.business;

class Discount1000Euros {
    double getDiscount(double partialTotal) {
        if (partialTotal < 0) {
            throw new IllegalArgumentException("Total can't be negative!");
        }
        if (partialTotal > 1000d) {
            return partialTotal * 0.10;
        }
        return 0;
    }
}
