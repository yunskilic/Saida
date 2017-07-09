import Core.Helper;
import Data.Constant;
import Data.SaidaContract;
import org.antlr.v4.runtime.ANTLRFileStream;
import Compiler.*;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.tree.ParseTree;
import org.antlr.v4.runtime.tree.ParseTreeWalker;
import org.apache.commons.io.FileUtils;

import java.io.File;
import java.io.IOException;

import static Utils.Constants.OutputFolder;

/**
 * Created by YUNUS on 16.04.2017.
 */
public class AddAlert {

    public void Create(String inputCommand) {
        File file = new File(inputCommand);
        if (!file.exists()){
            System.out.println("Given path is not valid");
            return;
        }
        try {
            SaidaLexer lexer = new SaidaLexer(new ANTLRFileStream(inputCommand));
            lexer.removeErrorListeners();
            CommonTokenStream tokens = new CommonTokenStream(lexer);
            SaidaParser parser = new SaidaParser(tokens);
            ParseTree tree = parser.r();
            ParseTreeWalker walker = new ParseTreeWalker();
            walker.walk(new SaidaWalker(), tree);
            File source = new File(inputCommand);
            File dest = new File(OutputFolder);
            FileUtils.copyFileToDirectory(source, dest);
            SaidaContract contract = Helper.CreateMopContract(tokens.getTokens());
            String mopFilePath = Helper.CreateMopFile(contract, source, dest);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
