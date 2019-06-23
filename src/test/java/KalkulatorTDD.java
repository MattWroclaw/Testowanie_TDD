import org.junit.Assert;
import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class KalkulatorTDD {
// metoda doKwadratu()

    @Test
    public void doKwadratu_a4_exp16(){
        double expected = 16;

        double actual = Calculator.doKwadratu(4);

        assertThat(expected).isEqualTo(actual);
    }

    @Test
    public void doPotegiN_dol5_gora2_exp25(){
        double expected = 25;

        double actual = Calculator.doPotegiN(5,2);

        assertThat(expected).isEqualTo(actual);
    }

    @Test
    public void squareRoot_a16_exp4(){
        double expected = 4;

        double actual = Calculator.squareRoot(16);

        assertThat(expected).isEqualTo(actual);
    }

   // spr. czy można z liczby ujemnej
    @Test (expected = IllegalArgumentException.class)
    public void squareRoot_aMinus4_expIllegalArgumentException(){
        Calculator.squareRoot(-4);
    }

    @Test
    public void nRootK(){
        double expected =3;

        double actual = Calculator.nRootK(2, 9);

        assertThat(expected).isEqualTo(actual);
    }

}
