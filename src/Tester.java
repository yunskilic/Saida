import Compiler.SaidaLexer;
import Compiler.SaidaParser;
import Compiler.SaidaWalker;
import Core.Helper;
import Data.AlertContract;
import Data.Constant;
import Data.SaidaContract;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.atn.ATNConfigSet;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.tree.ParseTree;
import org.antlr.v4.runtime.tree.ParseTreeWalker;
import org.apache.commons.io.FileUtils;
import org.apache.commons.lang3.StringUtils;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import java.io.File;
import java.io.IOException;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.BitSet;
import java.util.List;


/**
 * Created by YUNUS on 11.02.2017.
 */
public class Tester {
    public static void main(String[] args) throws IOException {
        Screen screen = new Screen();
        screen.AcceptInputs();
    }
}
