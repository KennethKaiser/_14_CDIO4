package dtu.dice;

import dtu.dice.RaffleCup;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

class TC1_DiceTest {

    @Test
    void testDice() {
        final int ROLLNUMBER = 30000; //Hvor mange gange terningen rulles
        int value = 0; //Samlet værdi af alle slag
        int die1, die2; //Variabel for de to terninger
        //Mulige terninge øjne
        int two = 0, three = 0, four = 0, five = 0, six = 0, seven = 0, eight = 0, nine = 0, ten =0;
        int elleven = 0, twelve = 0;
        //Forventede værdier
        float expecVal2n12, expecVal2n12Min, expecVal2n12Max;
        float expecVal3n11, expecVal3n11Min, expecVal3n11Max;
        float expecVal4n10, expecVal4n10Min, expecVal4n10Max;
        float expecVal5n9, expecVal5n9Min, expecVal5n9Max;
        float expecVal6n8, expecVal6n8Min, expecVal6n8Max;
        float expecVal7, expecVal7Min, expecVal7Max;
        float expected, expectedMin, expectedMax;

        // Her en for som ruller udfører en handling flere gange
        for(int i=0; i<= ROLLNUMBER; i++) {
            //Terninger og raflebæger oprettes
            RaffleCup dices = new RaffleCup();
            //Terningerne rulles
            dices.roll();
            //De to terningers værdi gemmes
            die1 = Integer.valueOf(dices.getOurRolls()[0]);
            die2 = Integer.valueOf(dices.getOurRolls()[1]);
            //Lægge terningerne sammen oven i tidligere rul
            value += (die1 + die2);
            //Gemmer hvilken værdi der blev slået
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
        expected = (float) (ROLLNUMBER*7);
        expectedMin = (float) (expected-(expected*0.1));
        expectedMax =(float) (expected+(expected*0.1));

        /*Forskellige værdier forventet værdi
        2 & 12 = 1/36
        3 & 11 = 2/36 = 1/18
        4 & 10 = 3/36 = 1/12
        5 & 9 = 4/36 = 1/9
        6 & 8 = 5/36
        7 = 6/36 = 1/6

         */
        expecVal2n12 = (float) (ROLLNUMBER/36);
        expecVal2n12Min = (float) (expecVal2n12-(expecVal2n12*0.1));
        expecVal2n12Max =(float) (expecVal2n12+(expecVal2n12*0.1));
        expecVal3n11 = (float) (ROLLNUMBER/18);
        expecVal3n11Min = (float) (expecVal3n11-(expecVal3n11*0.1));
        expecVal3n11Max =(float) (expecVal3n11+(expecVal3n11*0.1));
        expecVal4n10 = (float) (ROLLNUMBER/12);
        expecVal4n10Min = (float) (expecVal4n10-(expecVal4n10*0.1));
        expecVal4n10Max =(float) (expecVal4n10+(expecVal4n10*0.1));
        expecVal5n9 = (float) (ROLLNUMBER/9);
        expecVal5n9Min = (float) (expecVal5n9-(expecVal5n9*0.1));
        expecVal5n9Max =(float) (expecVal5n9+(expecVal5n9*0.1));
        expecVal6n8 = (float) ((ROLLNUMBER*5)/36);
        expecVal6n8Min = (float) (expecVal6n8-(expecVal6n8*0.1));
        expecVal6n8Max =(float) (expecVal6n8+(expecVal6n8*0.1));
        expecVal7 = (float) (ROLLNUMBER/6);
        expecVal7Min = (float) (expecVal7-(expecVal7*0.1));
        expecVal7Max =(float) (expecVal7+(expecVal7*0.1));

        //Tester middel
        assertTrue((expectedMax > value) && (expectedMin < value), "expected (" + expected + ") should be near collected sum" + value);
        System.out.println("Samlet sum af terningen " + value + ", forventede værdi er " + expected);

        //Tester værdierne
        assertTrue((expecVal2n12Max > two) && (expecVal2n12Min < two), "expected for 2 (" + expecVal2n12 + ") should be near collected sum of 2 " + two);
        System.out.println("Samlet sum af 2 " + two + ", forventede værdi er " + expecVal2n12);
        assertTrue((expecVal3n11Max > three) && (expecVal3n11Min < three), "expected for 3 (" + expecVal3n11 + ") should be near collected sum of 3 " + three);
        System.out.println("Samlet sum af 3 " + three + ", forventede værdi er " + expecVal3n11);
        assertTrue((expecVal4n10Max > four) && (expecVal4n10Min < four), "expected for 4 (" + expecVal4n10 + ") should be near collected sum of 4 " + four);
        System.out.println("Samlet sum af 4 " + four + ", forventede værdi er " + expecVal4n10);
        assertTrue((expecVal5n9Max > five) && (expecVal5n9Min < five), "expected for 5 (" + expecVal5n9 + ") should be near collected sum of 5 " + five);
        System.out.println("Samlet sum af 5 " + five + ", forventede værdi er " + expecVal5n9);
        assertTrue((expecVal6n8Max > six) && (expecVal6n8Min < six), "expected for 6 (" + expecVal6n8 + ") should be near collected sum of 6 " + six);
        System.out.println("Samlet sum af 6 " + six + ", forventede værdi er " + expecVal6n8);
        assertTrue((expecVal7Max > seven) && (expecVal7Min < seven), "expected for 7 (" + expecVal7 + ") should be near collected sum of 7 " + six);
        System.out.println("Samlet sum af 7 " + seven + ", forventede værdi er " + expecVal7);
        assertTrue((expecVal6n8Max > eight) && (expecVal6n8Min < eight), "expected for 8 (" + expecVal6n8 + ") should be near collected sum of 8 " + eight);
        System.out.println("Samlet sum af 8 " + eight + ", forventede værdi er " + expecVal6n8);
        assertTrue((expecVal5n9Max > nine) && (expecVal5n9Min < nine), "expected for 9 (" + expecVal5n9 + ") should be near collected sum of 9 " + nine);
        System.out.println("Samlet sum af 9 " + nine + ", forventede værdi er " + expecVal5n9);
        assertTrue((expecVal4n10Max > ten) && (expecVal4n10Min < ten), "expected for 10 (" + expecVal4n10 + ") should be near collected sum of 10 " + ten);
        System.out.println("Samlet sum af 10 " + ten + ", forventede værdi er " + expecVal4n10);
        assertTrue((expecVal3n11Max > elleven) && (expecVal3n11Min < elleven), "expected for 11 (" + expecVal3n11 + ") should be near collected sum of 11 " + elleven);
        System.out.println("Samlet sum af 11 " + elleven + ", forventede værdi er " + expecVal3n11);
        assertTrue((expecVal2n12Max > twelve) && (expecVal2n12Min < twelve), "expected for 12 (" + expecVal2n12 + ") should be near collected sum of 12 " + twelve);
        System.out.println("Samlet sum af 12 " + twelve + ", forventede værdi er " + expecVal2n12);

    }

    @Test
    void diceRollNullTest(){
        RaffleCup raffleCup = new RaffleCup();
        raffleCup.setOurRolls(null);

        assertFalse(raffleCup.rolledDouble());
    }

}