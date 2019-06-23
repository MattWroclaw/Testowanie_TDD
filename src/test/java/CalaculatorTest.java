
import junitparams.JUnitParamsRunner;
import junitparams.Parameters;
import org.assertj.core.data.Offset;
import org.junit.Assert;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import org.junit.runner.RunWith;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

@RunWith(JUnitParamsRunner.class)

public class CalaculatorTest {
    @Test
    public void sum_a2_b5_7(){
        double expected =7;

        double actual = Calculator.sum(2.00,5.00);

        Assert.assertEquals(expected, actual, 0.00000000001);
    }

    @Test
    public void sum_a5_b6_11(){
         int expected = 11;

         int actual =Calculator.sum(5,6);

         Assert.assertEquals(expected, actual);
    }
    @Test
    public void sum_a0_2b0_1_expected0_3(){
        double expected = 0.3;

        double actual = Calculator.sum(0.1, 0.2);

        Assert.assertEquals(expected, actual, 0.0000000000);
    }

    @Test
    public void substraction_a12_b8_expecd4(){
        double expected =4;

        double actual = Calculator.substraction(12.00, 8.0);

        Assert.assertEquals(expected, actual, 0.1);
    }

    @Test
    public void multiply_a4_b12_expected48(){
        double expected =48;

        double actual = Calculator.multiply(4.000, 12.000);

        Assert.assertEquals(expected,actual, 0.0000000000000001 );
    }

    @Test
    public void devide_a30_b5_exp6(){
        double expected = 6;

        double actual = Calculator.divide(30, 5);

        Assert.assertEquals(expected, actual, 0.00000000001);
    }

    /**
     * ############ WYJĄTKI ################
     */
    @Test  //SPOSÓB 1: przez złapanie w try-catch
    public void divde_a10b0_IllegalArgumentExceptionTryCatch() {
        try {
            Calculator.divide(10, 0);
        } catch (IllegalArgumentException e) {
        Assert.assertTrue(true);
        return;
        }
        Assert.fail("Nie powiodło się rzucanie wyjątku");
    }

    @Test(expected = IllegalArgumentException.class) //SPOSÓB 2: (expected = IllArgExp.class
    public void divide_a10b0_IllegalArgumentExceptionExpected(){
        Calculator.divide(10, 0);
    }

    @Rule // SPOSóB 3: za pomocą Rule
    public ExpectedException rule = ExpectedException.none();
    @Test
    public void  divide_a10b0_IllegalArgumentExceptionRule(){
        rule.expect(IllegalArgumentException.class);
        Calculator.divide(10 , 0);
    }


    // Testowanie logarytmu
    @Test
    public void logarytm_a2x8_exp3(){
        double expected = 3;

        double actual = Calculator.log(2, 8);

        Assert.assertEquals(expected, actual, 0.001);
    }

    @Test (expected = IllegalArgumentException.class)
    public void logarytm_a0x8_IllegalExceptionError(){
        Calculator.log(-4, 8);
    }


    @Test // tutaj test z Rule
    public  void log_a_2x10_IllegalArgumentException(){
        rule.expect(IllegalArgumentException.class);
        Calculator.log(-2, 10);
    }

    @ Test (expected = IllegalArgumentException.class)
    public void log_a8xMinus3_IllegalArgumentException(){
        Calculator.log(8, -3);
    }

    @Test  // z Rule to samo co wyżej
    public void log_a8Minus2_IllegalArgumentException(){
        rule.expect(IllegalArgumentException.class);
        Calculator.log(8, -2);
    }

    @Test (expected = IllegalArgumentException.class)
    public void log_a1X8_IllegalArgumentException(){
        Calculator.log(1, 8);
    }

    @Test // a = 1 z Rule
    public  void log_a1b4_IllegalArgumentException(){
        rule.expect(IllegalArgumentException.class);
        Calculator.log(1, 4);
    }

    // ***************LAMBDA*********
    @Test //wykorzystanie biblioteki AssertJ
    public void log_3minus3B10_IllegalArgumentExceptionMessageBaseOfLogShouldBeGreaterThan0(){

        assertThatThrownBy(
                () ->{Calculator.log(-3,10);
                }).hasMessage("Podstawa logarytmu musi być  > 0");
    }

    @Test //wykorzystanie iblioteki AssertJ
    public void log_a3Bminus9_IllegalArgumetExpectionMessageLogaritmNumberGreaterThan0(){
        assertThatThrownBy(
                () ->{Calculator.log(3, -9);
                }).hasMessage("Liczba logarytmowana musi być  => 0");

    }

    @Test // wykorzystanie AsserJ
    public void log_a1B5_IllegalArgumetExpectionMessageBaseDifferentThan1(){
        assertThatThrownBy(
                () ->{Calculator.log(1, 5);
                }).hasMessage("Podstawa logarytmu musi być różna od 1");

    }

    // jak działa AssertJ
    @Test
    public void draftAssertJAssert_log(){
        try{
            Calculator.log(-3, 10);
            Assert.fail();
        }catch (Exception e){
            String message = e.getMessage();
            Assert.assertEquals(message,"Podstawa logarytmu musi być  > 0" );
        }
    }

    /**
     *
     *   przykład
     */
    private void complexAssert(Pet p){
        Assert.assertEquals(p.getAge(), 2);
        Assert.assertEquals(p.getWeight(), 10, 0.01);
    }
    @Test
    public void PetTest (){
        Pet p = new Pet();

        p.setAge(2);
        p.setWeight(10);

        complexAssert(p);
    }



    @Test //trzeba statycznie importować metodę assertThat --> 3-ci od góry
    public void log_a2b4_2 (){
        double expected = 2;

        double actual = Calculator.log(2,4);

        assertThat(expected).isEqualTo(actual);
    }

    @Test
    public void log_a2b4_2_Offset (){
        double expected = 2;

        double actual = Calculator.log(2,4);

        assertThat(expected).isEqualTo(actual, Offset.strictOffset(0.01));
    }

    @Test
    public void multiply3_5_Offset(){
        double expected = 15;

        double actual = Calculator.multiply(3, 5);

        assertThat(expected).isEqualTo(actual, Offset.strictOffset(0.00000001));
    }

    @Test
    public void devide_12_3_Offset(){
        double expected = 4;

        double actual = Calculator.divide(12 , 3);

        assertThat(expected).isEqualTo(actual, Offset.strictOffset(0.01));

    }


    // JuNItParams J Unit Params

    @Test
    @Parameters({"1,2,3", "23, 17, 40","1,2,3"})
    public void sum_parametrized(double a, double b, double expected){
        double actual = Calculator.sum(a,b);

        assertThat(expected).isEqualTo(actual, Offset.strictOffset(0.01));
    }


    @Test
    @Parameters({"2,3,6", "4,5,20", "3,5,15"})
    public void multuiply_parametrized(double a, double b, double expected){
        double actual = Calculator.multiply(a,b);

        assertThat(expected).isEqualTo(actual, Offset.strictOffset(0.01));
    }

    @Test
    @Parameters({"8,4,2", "10,2,5", "16,8,2"})
    public void devide_parametirized(double a, double b, double expected){

        double acutal =Calculator.divide(a,b);

        assertThat(expected).isEqualTo(acutal, Offset.strictOffset(0.01));
    }

    @Test
       @Parameters({"0,0","1,1", "2,1","3,2", "4,3", "5,5", "6,8", "7,13", "8,21", "9,34", "10,55"})
    public void fibonaci_parametrized(int n, int expected){

        int actual = Calculator.getFibonaciNumber(n);

        assertThat(expected).isEqualTo(actual);
    }

    @Test
    public void overflow(){
        //n = 90
        int actual  = Calculator.getFibonaciNumber(9);
    }


    @Test
    @Parameters(method = "getFibonacciData")
    public void getFibonacciNumber_parametrizedByMethod(int n , int expected){
        int actual = Calculator.getFibonaciNumber(n);

        assertThat(expected).isEqualTo(actual);

    }
    private Object[] getFibonacciData(){
        return new Object[]{
                new Object[] {0,0},
                new Object[] {1,1},
                new Object[] {2,1},
                new Object[] {3,2},
                new Object[] {4,3},
                new Object[] {5,5},
                new Object[] {6,8},
                new Object[] {7,13},
        };
    }

    @Test
    @Parameters(method = "wynikDodawania")
    public void sum_parametrized2(double a , double b, double expected){
        double actual = Calculator.sum(a, b);

        assertThat(expected).isEqualTo(actual);

    }
    private Object [] wynikDodawania(){
        return new Object[]{
                new Object [] {2,3,5},
                new Object [] {2,6,8},
                new Object [] {3,6,9},
                new Object [] {1,34,35},
                new Object [] {4,3,7},
                new Object [] {8,6,14},

        };
    }

    //tutaj będziemy jako parametr podawać całą klasę
    @Test
    @Parameters(source = DifferenceDataProvide.class) // wklasie DifferenceDataProvide w metodzie musi być słowo privide na początku
    public void substraction_parametrizedByClass(double a , double b , double expected){
        double  actual = Calculator.substraction(a,b);

        assertThat(expected).isEqualTo(actual);
    }


    @Test
    @Parameters (source = MultiplyDataProv.class)
    public void multiply_parameterClass(double a, double b, double expected){
        double actual = Calculator.multiply(a,b);

        assertThat(expected).isEqualTo(actual);
    }
}
