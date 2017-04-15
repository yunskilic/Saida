import Data.Constant;
import Utils.Constants;

import java.util.ArrayList;
import java.util.Scanner;


/**
 * Created by YUNUS on 15.04.2017.
 */
public class Screen {
    Constants constants;
    public Screen() {
        this.constants=new Constants();
    }

    public void AcceptInputs() {
        String input;
        do {
            Scanner in = new Scanner(System.in);
            input = in.next();
            if (!ValidateInputCount(input)) break;
            String[] inputCommands = input.split(constants.StringDivider);
            if (inputCommands[0].equals(constants.AddAlertCommand)){

            }
            if (inputCommands[0].equals(constants.GenerateCommand)){

            }
        }
        while (input.toLowerCase().equals(constants.ExitCommand.toLowerCase()));
    }

    private boolean ValidateInputCount(String input) {
        return input != null && input.split(constants.StringDivider).length == constants.InputWordCount;
    }

//    private boolean ValidateInputContext(String input){
//        if(!constants.Commands.contains(input.split(constants.StringDivider)[0]))return false;
//        if ()
//    }
}
