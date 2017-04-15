package Compiler;// Generated from C:/Users/YUNUS/IdeaProjects/Saida/src\Saida.g4 by ANTLR 4.6

import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.atn.ATN;
import org.antlr.v4.runtime.atn.ATNDeserializer;
import org.antlr.v4.runtime.atn.LexerATNSimulator;
import org.antlr.v4.runtime.atn.PredictionContextCache;
import org.antlr.v4.runtime.dfa.DFA;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class SaidaLexer extends Lexer {
    public static final int
            T__0 = 1, ViolationResult = 2, TemporalOp = 3, Event = 4, BasicEvent = 5, TemporalOrder = 6,
            Exception = 7, WS = 8;
    public static final String[] ruleNames = {
            "T__0", "ViolationResult", "TemporalOp", "Event", "BasicEvent", "TemporalOrder",
            "Exception", "WS"
    };
    /**
     * @deprecated Use {@link #VOCABULARY} instead.
     */
    @Deprecated
    public static final String[] tokenNames;
    public static final String _serializedATN =
            "\3\u0430\ud6d1\u8206\uad2d\u4417\uaef1\u8d80\uaadd\2\n\u00a1\b\1\4\2\t" +
                    "\2\4\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\3\2\3\2\3\3" +
                    "\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\5" +
                    "\3(\n\3\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3" +
                    "\4\3\4\3\4\3\4\3\4\3\4\5\4?\n\4\3\5\3\5\3\5\3\5\3\5\3\5\3\5\5\5H\n\5\3" +
                    "\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6" +
                    "\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\5\6e\n\6\3\7\3\7\3\7\3\7\3\7\3\7" +
                    "\3\7\3\7\3\7\3\7\3\7\5\7r\n\7\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b" +
                    "\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3" +
                    "\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\5\b\u0099\n\b\3\t\6\t\u009c\n\t" +
                    "\r\t\16\t\u009d\3\t\3\t\2\2\n\3\3\5\4\7\5\t\6\13\7\r\b\17\t\21\n\3\2\3" +
                    "\5\2\13\f\17\17\"\"\u00aa\2\3\3\2\2\2\2\5\3\2\2\2\2\7\3\2\2\2\2\t\3\2" +
                    "\2\2\2\13\3\2\2\2\2\r\3\2\2\2\2\17\3\2\2\2\2\21\3\2\2\2\3\23\3\2\2\2\5" +
                    "\'\3\2\2\2\7>\3\2\2\2\tG\3\2\2\2\13d\3\2\2\2\rq\3\2\2\2\17\u0098\3\2\2" +
                    "\2\21\u009b\3\2\2\2\23\24\7\60\2\2\24\4\3\2\2\2\25\26\7G\2\2\26\27\7t" +
                    "\2\2\27\30\7t\2\2\30\31\7q\2\2\31(\7t\2\2\32\33\7H\2\2\33\34\7c\2\2\34" +
                    "\35\7n\2\2\35\36\7u\2\2\36\37\7g\2\2\37 \7R\2\2 !\7q\2\2!\"\7u\2\2\"#" +
                    "\7k\2\2#$\7v\2\2$%\7k\2\2%&\7x\2\2&(\7g\2\2\'\25\3\2\2\2\'\32\3\2\2\2" +
                    "(\6\3\2\2\2)*\7P\2\2*+\7g\2\2+,\7x\2\2,-\7g\2\2-?\7t\2\2./\7C\2\2/\60" +
                    "\7n\2\2\60\61\7y\2\2\61\62\7c\2\2\62\63\7{\2\2\63?\7u\2\2\64\65\7G\2\2" +
                    "\65\66\7x\2\2\66\67\7g\2\2\678\7p\2\289\7v\2\29:\7w\2\2:;\7c\2\2;<\7n" +
                    "\2\2<=\7n\2\2=?\7{\2\2>)\3\2\2\2>.\3\2\2\2>\64\3\2\2\2?\b\3\2\2\2@H\5" +
                    "\13\6\2AB\5\13\6\2BC\7\60\2\2CD\5\r\7\2DE\7\60\2\2EF\5\13\6\2FH\3\2\2" +
                    "\2G@\3\2\2\2GA\3\2\2\2H\n\3\2\2\2IJ\7H\2\2JK\7k\2\2KL\7g\2\2LM\7n\2\2" +
                    "MN\7f\2\2NO\7I\2\2OP\7g\2\2Pe\7v\2\2QR\7H\2\2RS\7k\2\2ST\7g\2\2TU\7n\2" +
                    "\2UV\7f\2\2VW\7U\2\2WX\7g\2\2Xe\7v\2\2YZ\7O\2\2Z[\7g\2\2[\\\7v\2\2\\]" +
                    "\7j\2\2]^\7q\2\2^_\7f\2\2_`\7E\2\2`a\7c\2\2ab\7n\2\2be\7n\2\2ce\5\17\b" +
                    "\2dI\3\2\2\2dQ\3\2\2\2dY\3\2\2\2dc\3\2\2\2e\f\3\2\2\2fg\7D\2\2gh\7g\2" +
                    "\2hi\7h\2\2ij\7q\2\2jk\7t\2\2kr\7g\2\2lm\7C\2\2mn\7h\2\2no\7v\2\2op\7" +
                    "g\2\2pr\7t\2\2qf\3\2\2\2ql\3\2\2\2r\16\3\2\2\2st\7P\2\2tu\7w\2\2uv\7n" +
                    "\2\2vw\7n\2\2wx\7R\2\2xy\7q\2\2yz\7k\2\2z{\7p\2\2{|\7v\2\2|}\7g\2\2}~" +
                    "\7t\2\2~\177\7G\2\2\177\u0080\7z\2\2\u0080\u0081\7e\2\2\u0081\u0082\7" +
                    "g\2\2\u0082\u0083\7r\2\2\u0083\u0084\7v\2\2\u0084\u0085\7k\2\2\u0085\u0086" +
                    "\7q\2\2\u0086\u0099\7p\2\2\u0087\u0088\7U\2\2\u0088\u0089\7g\2\2\u0089" +
                    "\u008a\7e\2\2\u008a\u008b\7w\2\2\u008b\u008c\7t\2\2\u008c\u008d\7k\2\2" +
                    "\u008d\u008e\7v\2\2\u008e\u008f\7{\2\2\u008f\u0090\7G\2\2\u0090\u0091" +
                    "\7z\2\2\u0091\u0092\7e\2\2\u0092\u0093\7g\2\2\u0093\u0094\7r\2\2\u0094" +
                    "\u0095\7v\2\2\u0095\u0096\7k\2\2\u0096\u0097\7q\2\2\u0097\u0099\7p\2\2" +
                    "\u0098s\3\2\2\2\u0098\u0087\3\2\2\2\u0099\20\3\2\2\2\u009a\u009c\t\2\2" +
                    "\2\u009b\u009a\3\2\2\2\u009c\u009d\3\2\2\2\u009d\u009b\3\2\2\2\u009d\u009e" +
                    "\3\2\2\2\u009e\u009f\3\2\2\2\u009f\u00a0\b\t\2\2\u00a0\22\3\2\2\2\n\2" +
                    "\'>Gdq\u0098\u009d\3\b\2\2";
    public static final ATN _ATN =
            new ATNDeserializer().deserialize(_serializedATN.toCharArray());
    protected static final DFA[] _decisionToDFA;
    protected static final PredictionContextCache _sharedContextCache =
            new PredictionContextCache();
    private static final String[] _LITERAL_NAMES = {
            null, "'.'"
    };
    private static final String[] _SYMBOLIC_NAMES = {
            null, null, "ViolationResult", "TemporalOp", "Event", "BasicEvent", "TemporalOrder",
            "Exception", "WS"
    };
    public static final Vocabulary VOCABULARY = new VocabularyImpl(_LITERAL_NAMES, _SYMBOLIC_NAMES);
    public static String[] modeNames = {
            "DEFAULT_MODE"
    };

    static {
        RuntimeMetaData.checkVersion("4.6", RuntimeMetaData.VERSION);
    }

    static {
        tokenNames = new String[_SYMBOLIC_NAMES.length];
        for (int i = 0; i < tokenNames.length; i++) {
            tokenNames[i] = VOCABULARY.getLiteralName(i);
            if (tokenNames[i] == null) {
                tokenNames[i] = VOCABULARY.getSymbolicName(i);
            }

            if (tokenNames[i] == null) {
                tokenNames[i] = "<INVALID>";
            }
        }
    }

    static {
        _decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
        for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
            _decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
        }
    }

    public SaidaLexer(CharStream input) {
        super(input);
        _interp = new LexerATNSimulator(this, _ATN, _decisionToDFA, _sharedContextCache);
    }

    @Override
    @Deprecated
    public String[] getTokenNames() {
        return tokenNames;
    }

    @Override

    public Vocabulary getVocabulary() {
        return VOCABULARY;
    }

    @Override
    public String getGrammarFileName() {
        return "Compiler/Saida.g4";
    }

    @Override
    public String[] getRuleNames() {
        return ruleNames;
    }

    @Override
    public String getSerializedATN() {
        return _serializedATN;
    }

    @Override
    public String[] getModeNames() {
        return modeNames;
    }

    @Override
    public ATN getATN() {
        return _ATN;
    }
}