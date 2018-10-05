package test;
import static org.junit.Assert.*;

public class TerningespilTest {



    public class UseDiceTest {

        Terning tern = new Terning();

        @org.junit.Test
        public void main() {
            int tæller1 = 0;
            int tæller2 = 0;
            int tæller3 = 0;
            int tæller4 = 0;
            int tæller5 = 0;
            int tæller6 = 0;

            for (int i = 0; i < 60000; i++){
                switch (tern.roll()) {
                    case 1: tæller1++; break;
                    case 2: tæller2++; break;
                    case 3: tæller3++; break;
                    case 4: tæller4++; break;
                    case 5: tæller5++; break;
                    case 6: tæller6++; break;
                }
            }
            System.out.println(tæller1 + " " + tæller2 + " " + tæller3 + " " + tæller4 + " " + tæller5 + " " + tæller6);
            assertEquals(true, tæller1 > 9600 && tæller1 < 10400);
            assertEquals(true, tæller2 > 9600 && tæller2 < 10400);
            assertEquals(true, tæller3 > 9600 && tæller3 < 10400);
            assertEquals(true, tæller4 > 9600 && tæller4 < 10400);
            assertEquals(true, tæller5 > 9600 && tæller5 < 10400);
            assertEquals(true, tæller6 > 9600 && tæller6 < 10400);
        }


}
