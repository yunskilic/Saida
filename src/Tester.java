import Compiler.*;
import Data.AlertContract;
import Data.Constant;
import Data.SaidaContract;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.atn.ATNConfigSet;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.tree.ParseTree;
import org.antlr.v4.runtime.tree.ParseTreeWalker;
import org.apache.commons.io.FileUtils;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.apache.commons.lang3.StringUtils;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import java.io.File;
import java.io.IOException;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.BitSet;
import java.util.List;


/**
 * Created by YUNUS on 11.02.2017.
 */
public class Tester
{

    public static void main(String[] args) throws IOException {
        try {
            args = new String[1];
            args[0]="C:\\Users\\YUNUS\\Desktop\\UWF_UNWRITTEN_FIELD.txt";
            String inputPath = args[0];
            SaidaLexer lexer = new SaidaLexer( new ANTLRFileStream(inputPath));
            lexer.removeErrorListeners();
            lexer.addErrorListener(new ANTLRErrorListener() {
                @Override
                public void syntaxError(Recognizer<?, ?> recognizer, Object o, int i, int i1, String s, RecognitionException e) {
                    System.out.print("a");
                    throw e;
                }

                @Override
                public void reportAmbiguity(Parser parser, DFA dfa, int i, int i1, boolean b, BitSet bitSet, ATNConfigSet atnConfigSet) {
                    System.out.print("b");
                }

                @Override
                public void reportAttemptingFullContext(Parser parser, DFA dfa, int i, int i1, BitSet bitSet, ATNConfigSet atnConfigSet) {
                    System.out.print("c");
                }

                @Override
                public void reportContextSensitivity(Parser parser, DFA dfa, int i, int i1, int i2, ATNConfigSet atnConfigSet) {
                    System.out.print("d");
                }
            });
            CommonTokenStream  tokens = new CommonTokenStream( lexer );
            SaidaParser parser = new SaidaParser(tokens);
            ParseTree tree = parser.r();
            ParseTreeWalker walker = new ParseTreeWalker();
            walker.walk( new SaidaWalker(), tree );
            File source = new File(inputPath);
            File dest = new File("AlertBase");
            FileUtils.copyFileToDirectory(source, dest);
            SaidaContract contract = Helper.CreateMopContract(tokens.getTokens());
            String mopFilePath = Helper.CreateMopFile(contract,source,dest);

            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder = factory.newDocumentBuilder();
            Document document = builder.parse(new File("C:\\Users\\YUNUS\\Desktop\\test.xml"));
            NodeList nodeList = document.getElementsByTagName("BugInstance");
            List<AlertContract> alerts = new ArrayList<>();
            for (int i=0;i<nodeList.getLength();i++){
                Node node = nodeList.item(i);
                if (node.getNodeType() == Node.ELEMENT_NODE) {
                    Element element =(Element)node;
                    AlertContract newAlertContract = new AlertContract();
                    newAlertContract.setAlertType(element.getAttributes().getNamedItem("type").getNodeValue());
                    NodeList fieldList = element.getElementsByTagName("Field");
                    for(int j=0;j<fieldList.getLength();j++){
                        Node fieldNode = fieldList.item(j);
                        if (fieldNode.getNodeType()==Node.ELEMENT_NODE){
                            Element fieldElement = (Element) fieldNode;
                            String elementType =StringUtils.substringBeforeLast(StringUtils.substringAfterLast(fieldElement.getAttributes().getNamedItem("signature").getNodeValue(),"/"),";");
                            String elementInfo=String.format("%s %s.%s",elementType,
                                                                        fieldElement.getAttributes().getNamedItem("classname").getNodeValue(),
                                                                        fieldElement.getAttributes().getNamedItem("name").getNodeValue());
                            newAlertContract.addFields(elementInfo);
                        }
                    }
                    //TODO:::METHOD
                    alerts.add(newAlertContract);
                }

            }
            int fieldCount = StringUtils.countMatches(FileUtils.readFileToString(new File(mopFilePath), Charset.defaultCharset()), Constant.FIELDINFO);
            int alertFieldCount = alerts.get(0).getFields().size();
            if (fieldCount == alertFieldCount){
                for (int i=0;i<fieldCount;i++){
                    String newStr = FileUtils.readFileToString(new File(mopFilePath), Charset.defaultCharset()).replaceFirst(Constant.FIELDINFO,alerts.get(0).getFields().get(i));
                    FileUtils.writeStringToFile(new File(mopFilePath),newStr,Charset.defaultCharset());
                }
            }
            else{
                String newStr = FileUtils.readFileToString(new File(mopFilePath), Charset.defaultCharset()).replace(Constant.FIELDINFO,alerts.get(0).getFields().get(0));
                FileUtils.writeStringToFile(new File(mopFilePath),newStr,Charset.defaultCharset());
            }
            int a=3;
        }
        catch (Exception ex){
            System.out.print(ex.getMessage());
        }
    }
}
