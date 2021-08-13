import java.lang.reflect.InvocationTargetException;
import java.util.Arrays;

public class Tests {

    TestingFunctions testingFunctions;

    public Tests(TestingFunctions testingFunctions){

        this.testingFunctions = testingFunctions;

    }

    public void runAllTests(){
        Arrays.stream(this.getClass().getMethods())
                .filter(method -> method.getName()
                        .startsWith("_test_")).forEach(method -> {
            try {
                method.invoke(this);
            } catch (IllegalAccessException | InvocationTargetException e) {
                e.printStackTrace();
            }
        });
    }

    public void _test_play_same_house(){

        System.out.println("Test Play Same House");

        testingFunctions.pressCell(0);
        testingFunctions.pressCell(0);

        testingFunctions.refresh();

    }

    public void _test_not_continuous_vertical_line(){

        System.out.println("Test not continuous vertical line");

        testingFunctions.pressCell(0);
        testingFunctions.pressCell(1);
        testingFunctions.pressCell(5);
        testingFunctions.pressCell(2);
        testingFunctions.pressCell(6);

        testingFunctions.refresh();

    }

    public void _test_same_icon_both_players(){

        System.out.println("Test same icon for both players");

        testingFunctions.chooseSymbolPlayer1("tessa_r");
        testingFunctions.chooseSymbolPlayer2("tessa_r");

        testingFunctions.refresh();

    }

    public void _test_tessa_blue_icon(){

        System.out.println("Test Tessa blue icon");

        testingFunctions.chooseSymbolPlayer1("tessa_b");

        testingFunctions.refresh();

    }

    public void _test_player_1_counter(){

        System.out.println("Test Player 1 Counter");

        for(int i = 0; i <= 2; i++){
            testingFunctions.pressCell(i);
            testingFunctions.pressCell(i+5);
        }

        testingFunctions.refresh();

    }

    public void _test_player_2_counter(){

        System.out.println("Test Player 2 Counter");

        testingFunctions.pressCell(18);

        for(int i = 0; i <= 2; i++){
            testingFunctions.pressCell(i);
            testingFunctions.pressCell(i+5);
        }

        testingFunctions.refresh();
    }

    public void _test_bottom_right_cell(){

        System.out.println("Test bottom right cell");

        testingFunctions.pressCell(19);
        testingFunctions.refresh();

    }

    public void _test_vertical_winning_condition(){

        System.out.println("Test vertical winning condition");

        testingFunctions.pressCell(0);
        testingFunctions.pressCell(1);
        testingFunctions.pressCell(5);
        testingFunctions.pressCell(6);
        testingFunctions.pressCell(15);

        testingFunctions.refresh();


    }


    public void _test_id_1(){

        System.out.println("Test ID 1");
        for(int i = 0; i <= 19; i++){
            testingFunctions.pressCell(i);
            testingFunctions.refresh();
        }

    }

    public void _test_id_2(){

        System.out.println("Test ID 2");

        testingFunctions.pressCell(0);
        testingFunctions.pressCell(1);
        testingFunctions.pressCell(2);
        testingFunctions.pressCell(6);
        testingFunctions.pressCell(4);
        testingFunctions.pressCell(7);
        testingFunctions.refresh();

    }

    public void _test_id_3(){

        System.out.println("Test ID 3");

        testingFunctions.pressCell(0);
        testingFunctions.pressCell(5);
        testingFunctions.pressCell(1);
        testingFunctions.pressCell(6);
        testingFunctions.pressCell(2);
        testingFunctions.endGame();
        testingFunctions.pressCell(0);
        testingFunctions.pressCell(5);
        testingFunctions.pressCell(1);
        testingFunctions.pressCell(6);
        testingFunctions.pressCell(2);
        testingFunctions.endGame();
        testingFunctions.refresh();
        
    }

    public void _test_id_4(){

        System.out.println("Test ID 4");

        testingFunctions.pressCell(0);
        testingFunctions.pressCell(1);
        testingFunctions.pressCell(5);
        testingFunctions.pressCell(6);
        testingFunctions.pressCell(15);

        testingFunctions.refresh();
    }

    public void _test_id_5(){

        System.out.println("Test ID 5");

        testingFunctions.chooseSymbolPlayer1("x");
        testingFunctions.pressCell(0);
        testingFunctions.chooseSymbolPlayer2("tessa_r");
        testingFunctions.pressCell(1);

        testingFunctions.refresh();

    }

    public void _test_id_6(){

        System.out.println("Test ID 6");

        for(int i = 0; i <= 19; i++){
            testingFunctions.pressCell(i);
            testingFunctions.refresh();
        }

    }

    public void _test_id_7(){

        System.out.println("Test ID 7");

        testingFunctions.pressCell(0);
        testingFunctions.pressCell(1);
        testingFunctions.pressCell(6);
        testingFunctions.pressCell(7);
        testingFunctions.pressCell(2);
        testingFunctions.refresh();

    }

    public void _test_id_8(){

        System.out.println("Test ID 8");

        for(int i = 0; i < 10; i++)
            testingFunctions.pressCell(i);
        for(int i = 19; i >= 10; i--)
            testingFunctions.pressCell(i);
        testingFunctions.refresh();

    }

    public void _test_id_9(){

        System.out.println("Test ID 9");

        for(int i = 2; i < 5; i++) {
            testingFunctions.pressCell(i);
            testingFunctions.pressCell(i+5);
        }

        testingFunctions.refresh();
    }


}
