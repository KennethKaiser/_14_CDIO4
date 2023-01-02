import dtu.dice.RaffleCup;
import org.junit.Test;
import static org.testng.Assert.assertTrue;

class TC1_DiceTest {

    @Test
    void testDice() {
        int rollNumber = 10000; //Hvor mange gange terningen rulles
        int value = 0;
        int die1, die2;
        //Mulige terninge øjne
        int two = 0, three = 0, four = 0, five = 0, six = 0, seven = 0, eight = 0, nine = 0, ten =0;
        int elleven = 0, twelve = 0;
        float expecVal, expecValMin, expecValMax;
        float expected, expectedMin, expectedMax;
        for(int i=0; i<= rollNumber; i++) {
            //Terning 1
            RaffleCup dices = new RaffleCup();
            die1 = dices.roll()[0];
            die2 = dices.roll()[1];
            //Lægge terningerne sammen oven i tidligere rul
            value += (die1 + die2);
            //Gem hvilken værdi blev slået
            switch(die1 + die2){
                case 2:
                    two++;
                    break;
                case 3:
                    three++;
                    break;
                case 4:
                    four++;
                    break;
                case 5:
                    five++;
                    break;
                case 6:
                    six++;
                    break;
                case 7:
                    seven++;
                    break;
                case 8:
                    eight++;
                    break;
                case 9:
                    nine++;
                    break;
                case 10:
                    ten++;
                    break;
                case 11:
                    elleven++;
                    break;
                case 12:
                    twelve++;
                    break;
                default:
                    System.out.println("Fejl i terning");
                    break;
            }
        }
        //Middelværdi
        expected = (float) (rollNumber*3.5);
        expectedMin = (float) (expected-(expected*0.05));
        expectedMax =(float) (expected+(expected*0.05));

        //Forskellige værdier
        expecVal = (float) (rollNumber/6);
        expecValMin = (float) (expecVal-(expecVal*0.05));
        expecValMax =(float) (expecVal+(expecVal*0.05));

        //Se om middel er fin
        assertTrue((expectedMax > value) && (expectedMin < value), "expected (" + expected + ") should be near collected sum" + value);
        System.out.println("Samlet sum af terningen " + value + "forventede værdi er " + expected);

        //Se om enkelte øjne er fin
        assertTrue((expecValMax > two) && (expecValMin < two), "expected for 2 (" + expecVal + ") should be near collected sum of 2 " + two);
        System.out.println("Samlet sum af 2 " + two + "forventede værdi er " + expecVal);
        assertTrue((expecValMax > three) && (expecValMin < three), "expected for 3 (" + expecVal + ") should be near collected sum of 3 " + three);
        System.out.println("Samlet sum af 3 " + three + "forventede værdi er " + expecVal);
        assertTrue((expecValMax > four) && (expecValMin < four), "expected for 4 (" + expecVal + ") should be near collected sum of 4 " + four);
        System.out.println("Samlet sum af 4 " + four + "forventede værdi er " + expecVal);
        assertTrue((expecValMax > five) && (expecValMin < five), "expected for 5 (" + expecVal + ") should be near collected sum of 5 " + five);
        System.out.println("Samlet sum af 5 " + five + "forventede værdi er " + expecVal);
        assertTrue((expecValMax > six) && (expecValMin < six), "expected for 6 (" + expecVal + ") should be near collected sum of 6 " + six);
        System.out.println("Samlet sum af 6 " + six + "forventede værdi er " + expecVal);
        assertTrue((expecValMax > seven) && (expecValMin < seven), "expected for 7 (" + expecVal + ") should be near collected sum of 7 " + six);
        System.out.println("Samlet sum af 7 " + seven + "forventede værdi er " + expecVal);
        assertTrue((expecValMax > eight) && (expecValMin < eight), "expected for 8 (" + expecVal + ") should be near collected sum of 8 " + eight);
        System.out.println("Samlet sum af 8 " + eight + "forventede værdi er " + expecVal);
        assertTrue((expecValMax > nine) && (expecValMin < nine), "expected for 9 (" + expecVal + ") should be near collected sum of 9 " + nine);
        System.out.println("Samlet sum af 9 " + nine + "forventede værdi er " + expecVal);
        assertTrue((expecValMax > ten) && (expecValMin < ten), "expected for 10 (" + expecVal + ") should be near collected sum of 10 " + ten);
        System.out.println("Samlet sum af 10 " + ten + "forventede værdi er " + expecVal);
        assertTrue((expecValMax > elleven) && (expecValMin < elleven), "expected for 11 (" + expecVal + ") should be near collected sum of 11 " + elleven);
        System.out.println("Samlet sum af 11 " + elleven + "forventede værdi er " + expecVal);
        assertTrue((expecValMax > twelve) && (expecValMin < twelve), "expected for 12 (" + expecVal + ") should be near collected sum of 12 " + twelve);
        System.out.println("Samlet sum af 12 " + twelve + "forventede værdi er " + expecVal);

    }

}