package gems;

import gems.controller.Jeweller;

public class Main {

    public static void main(String[] args) {
        Jeweller jeweller = new Jeweller();
        jeweller.shop();
        for (int i = 0; i < 5; i++) {
            jeweller.addGem();
        }
    }
}
