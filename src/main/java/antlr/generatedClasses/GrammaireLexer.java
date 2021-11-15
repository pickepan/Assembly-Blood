package antlr.generatedClasses;

// $ANTLR 3.5.2 Grammaire.g 2021-02-15 13:18:20

import org.antlr.runtime.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;

@SuppressWarnings("all")
public class GrammaireLexer extends Lexer {
	public static final int EOF=-1;
	public static final int T__41=41;
	public static final int T__42=42;
	public static final int T__43=43;
	public static final int T__44=44;
	public static final int T__45=45;
	public static final int T__46=46;
	public static final int T__47=47;
	public static final int T__48=48;
	public static final int T__49=49;
	public static final int T__50=50;
	public static final int T__51=51;
	public static final int T__52=52;
	public static final int T__53=53;
	public static final int T__54=54;
	public static final int T__55=55;
	public static final int T__56=56;
	public static final int T__57=57;
	public static final int T__58=58;
	public static final int T__59=59;
	public static final int T__60=60;
	public static final int T__61=61;
	public static final int T__62=62;
	public static final int T__63=63;
	public static final int T__64=64;
	public static final int T__65=65;
	public static final int T__66=66;
	public static final int T__67=67;
	public static final int T__68=68;
	public static final int T__69=69;
	public static final int T__70=70;
	public static final int T__71=71;
	public static final int T__72=72;
	public static final int T__73=73;
	public static final int T__74=74;
	public static final int T__75=75;
	public static final int T__76=76;
	public static final int T__77=77;
	public static final int T__78=78;
	public static final int AFFECTATION=4;
	public static final int APPEL_FONCTION=5;
	public static final int ATTRIBUT=6;
	public static final int BLOCK=7;
	public static final int CAST=8;
	public static final int CLASSE=9;
	public static final int CLASSID=10;
	public static final int COMMENT=11;
	public static final int CONDITION=12;
	public static final int DO=13;
	public static final int ELSE=14;
	public static final int EXTENDS=15;
	public static final int FONCTION=16;
	public static final int GROUP=17;
	public static final int HERITED=18;
	public static final int ID=19;
	public static final int IDENTIFICATEUR=20;
	public static final int IF=21;
	public static final int INT=22;
	public static final int LIST_PARAM=23;
	public static final int MESSAGE=24;
	public static final int METHOD=25;
	public static final int MOINS_UNAIRE=26;
	public static final int NEW=27;
	public static final int PARAM=28;
	public static final int PLUS_UNAIRE=29;
	public static final int RESULT=30;
	public static final int ROOT=31;
	public static final int SELECT=32;
	public static final int STR=33;
	public static final int STRING=34;
	public static final int THEN=35;
	public static final int VALUE=36;
	public static final int VARIABLE=37;
	public static final int VARIABLE_LOCALE=38;
	public static final int WHILE=39;
	public static final int WHITESPACE=40;

	// delegates
	// delegators
	public Lexer[] getDelegates() {
		return new Lexer[] {};
	}

	public GrammaireLexer() {}
	public GrammaireLexer(CharStream input) {
		this(input, new RecognizerSharedState());
	}
	public GrammaireLexer(CharStream input, RecognizerSharedState state) {
		super(input,state);
	}
	@Override public String getGrammarFileName() { return "Grammaire.g"; }

	// $ANTLR start "T__41"
	public final void mT__41() throws RecognitionException {
		try {
			int _type = T__41;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// Grammaire.g:7:7: ( '&&' )
			// Grammaire.g:7:9: '&&'
			{
				match("&&");

			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "T__41"

	// $ANTLR start "T__42"
	public final void mT__42() throws RecognitionException {
		try {
			int _type = T__42;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// Grammaire.g:8:7: ( '&' )
			// Grammaire.g:8:9: '&'
			{
				match('&');
			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "T__42"

	// $ANTLR start "T__43"
	public final void mT__43() throws RecognitionException {
		try {
			int _type = T__43;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// Grammaire.g:9:7: ( '(' )
			// Grammaire.g:9:9: '('
			{
				match('(');
			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "T__43"

	// $ANTLR start "T__44"
	public final void mT__44() throws RecognitionException {
		try {
			int _type = T__44;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// Grammaire.g:10:7: ( ')' )
			// Grammaire.g:10:9: ')'
			{
				match(')');
			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "T__44"

	// $ANTLR start "T__45"
	public final void mT__45() throws RecognitionException {
		try {
			int _type = T__45;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// Grammaire.g:11:7: ( '*' )
			// Grammaire.g:11:9: '*'
			{
				match('*');
			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "T__45"

	// $ANTLR start "T__46"
	public final void mT__46() throws RecognitionException {
		try {
			int _type = T__46;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// Grammaire.g:12:7: ( '+' )
			// Grammaire.g:12:9: '+'
			{
				match('+');
			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "T__46"

	// $ANTLR start "T__47"
	public final void mT__47() throws RecognitionException {
		try {
			int _type = T__47;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// Grammaire.g:13:7: ( ',' )
			// Grammaire.g:13:9: ','
			{
				match(',');
			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "T__47"

	// $ANTLR start "T__48"
	public final void mT__48() throws RecognitionException {
		try {
			int _type = T__48;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// Grammaire.g:14:7: ( '-' )
			// Grammaire.g:14:9: '-'
			{
				match('-');
			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "T__48"

	// $ANTLR start "T__49"
	public final void mT__49() throws RecognitionException {
		try {
			int _type = T__49;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// Grammaire.g:15:7: ( '.' )
			// Grammaire.g:15:9: '.'
			{
				match('.');
			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "T__49"

	// $ANTLR start "T__50"
	public final void mT__50() throws RecognitionException {
		try {
			int _type = T__50;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// Grammaire.g:16:7: ( '/' )
			// Grammaire.g:16:9: '/'
			{
				match('/');
			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "T__50"

	// $ANTLR start "T__51"
	public final void mT__51() throws RecognitionException {
		try {
			int _type = T__51;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// Grammaire.g:17:7: ( ':' )
			// Grammaire.g:17:9: ':'
			{
				match(':');
			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "T__51"

	// $ANTLR start "T__52"
	public final void mT__52() throws RecognitionException {
		try {
			int _type = T__52;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// Grammaire.g:18:7: ( ':=' )
			// Grammaire.g:18:9: ':='
			{
				match(":=");

			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "T__52"

	// $ANTLR start "T__53"
	public final void mT__53() throws RecognitionException {
		try {
			int _type = T__53;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// Grammaire.g:19:7: ( ';' )
			// Grammaire.g:19:9: ';'
			{
				match(';');
			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "T__53"

	// $ANTLR start "T__54"
	public final void mT__54() throws RecognitionException {
		try {
			int _type = T__54;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// Grammaire.g:20:7: ( '<' )
			// Grammaire.g:20:9: '<'
			{
				match('<');
			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "T__54"

	// $ANTLR start "T__55"
	public final void mT__55() throws RecognitionException {
		try {
			int _type = T__55;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// Grammaire.g:21:7: ( '<>' )
			// Grammaire.g:21:9: '<>'
			{
				match("<>");

			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "T__55"

	// $ANTLR start "T__56"
	public final void mT__56() throws RecognitionException {
		try {
			int _type = T__56;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// Grammaire.g:22:7: ( '=' )
			// Grammaire.g:22:9: '='
			{
				match('=');
			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "T__56"

	// $ANTLR start "T__57"
	public final void mT__57() throws RecognitionException {
		try {
			int _type = T__57;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// Grammaire.g:23:7: ( '>' )
			// Grammaire.g:23:9: '>'
			{
				match('>');
			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "T__57"

	// $ANTLR start "T__58"
	public final void mT__58() throws RecognitionException {
		try {
			int _type = T__58;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// Grammaire.g:24:7: ( 'as' )
			// Grammaire.g:24:9: 'as'
			{
				match("as");

			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "T__58"

	// $ANTLR start "T__59"
	public final void mT__59() throws RecognitionException {
		try {
			int _type = T__59;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// Grammaire.g:25:7: ( 'class' )
			// Grammaire.g:25:9: 'class'
			{
				match("class");

			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "T__59"

	// $ANTLR start "T__60"
	public final void mT__60() throws RecognitionException {
		try {
			int _type = T__60;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// Grammaire.g:26:7: ( 'def' )
			// Grammaire.g:26:9: 'def'
			{
				match("def");

			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "T__60"

	// $ANTLR start "T__61"
	public final void mT__61() throws RecognitionException {
		try {
			int _type = T__61;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// Grammaire.g:27:7: ( 'do' )
			// Grammaire.g:27:9: 'do'
			{
				match("do");

			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "T__61"

	// $ANTLR start "T__62"
	public final void mT__62() throws RecognitionException {
		try {
			int _type = T__62;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// Grammaire.g:28:7: ( 'else' )
			// Grammaire.g:28:9: 'else'
			{
				match("else");

			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "T__62"

	// $ANTLR start "T__63"
	public final void mT__63() throws RecognitionException {
		try {
			int _type = T__63;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// Grammaire.g:29:7: ( 'extends' )
			// Grammaire.g:29:9: 'extends'
			{
				match("extends");

			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "T__63"

	// $ANTLR start "T__64"
	public final void mT__64() throws RecognitionException {
		try {
			int _type = T__64;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// Grammaire.g:30:7: ( 'if' )
			// Grammaire.g:30:9: 'if'
			{
				match("if");

			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "T__64"

	// $ANTLR start "T__65"
	public final void mT__65() throws RecognitionException {
		try {
			int _type = T__65;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// Grammaire.g:31:7: ( 'is' )
			// Grammaire.g:31:9: 'is'
			{
				match("is");

			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "T__65"

	// $ANTLR start "T__66"
	public final void mT__66() throws RecognitionException {
		try {
			int _type = T__66;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// Grammaire.g:32:7: ( 'new' )
			// Grammaire.g:32:9: 'new'
			{
				match("new");

			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "T__66"

	// $ANTLR start "T__67"
	public final void mT__67() throws RecognitionException {
		try {
			int _type = T__67;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// Grammaire.g:33:7: ( 'override' )
			// Grammaire.g:33:9: 'override'
			{
				match("override");

			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "T__67"

	// $ANTLR start "T__68"
	public final void mT__68() throws RecognitionException {
		try {
			int _type = T__68;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// Grammaire.g:34:7: ( 'result' )
			// Grammaire.g:34:9: 'result'
			{
				match("result");

			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "T__68"

	// $ANTLR start "T__69"
	public final void mT__69() throws RecognitionException {
		try {
			int _type = T__69;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// Grammaire.g:35:7: ( 'return' )
			// Grammaire.g:35:9: 'return'
			{
				match("return");

			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "T__69"

	// $ANTLR start "T__70"
	public final void mT__70() throws RecognitionException {
		try {
			int _type = T__70;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// Grammaire.g:36:7: ( 'static' )
			// Grammaire.g:36:9: 'static'
			{
				match("static");

			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "T__70"

	// $ANTLR start "T__71"
	public final void mT__71() throws RecognitionException {
		try {
			int _type = T__71;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// Grammaire.g:37:7: ( 'super' )
			// Grammaire.g:37:9: 'super'
			{
				match("super");

			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "T__71"

	// $ANTLR start "T__72"
	public final void mT__72() throws RecognitionException {
		try {
			int _type = T__72;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// Grammaire.g:38:7: ( 'then' )
			// Grammaire.g:38:9: 'then'
			{
				match("then");

			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "T__72"

	// $ANTLR start "T__73"
	public final void mT__73() throws RecognitionException {
		try {
			int _type = T__73;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// Grammaire.g:39:7: ( 'this' )
			// Grammaire.g:39:9: 'this'
			{
				match("this");

			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "T__73"

	// $ANTLR start "T__74"
	public final void mT__74() throws RecognitionException {
		try {
			int _type = T__74;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// Grammaire.g:40:7: ( 'var' )
			// Grammaire.g:40:9: 'var'
			{
				match("var");

			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "T__74"

	// $ANTLR start "T__75"
	public final void mT__75() throws RecognitionException {
		try {
			int _type = T__75;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// Grammaire.g:41:7: ( 'while' )
			// Grammaire.g:41:9: 'while'
			{
				match("while");

			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "T__75"

	// $ANTLR start "T__76"
	public final void mT__76() throws RecognitionException {
		try {
			int _type = T__76;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// Grammaire.g:42:7: ( '{' )
			// Grammaire.g:42:9: '{'
			{
				match('{');
			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "T__76"

	// $ANTLR start "T__77"
	public final void mT__77() throws RecognitionException {
		try {
			int _type = T__77;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// Grammaire.g:43:7: ( '||' )
			// Grammaire.g:43:9: '||'
			{
				match("||");

			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "T__77"

	// $ANTLR start "T__78"
	public final void mT__78() throws RecognitionException {
		try {
			int _type = T__78;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// Grammaire.g:44:7: ( '}' )
			// Grammaire.g:44:9: '}'
			{
				match('}');
			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "T__78"

	// $ANTLR start "CLASSID"
	public final void mCLASSID() throws RecognitionException {
		try {
			int _type = CLASSID;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// Grammaire.g:245:9: ( ( 'A' .. 'Z' ) ( 'a' .. 'z' | 'A' .. 'Z' | '0' .. '9' | '_' )* )
			// Grammaire.g:245:11: ( 'A' .. 'Z' ) ( 'a' .. 'z' | 'A' .. 'Z' | '0' .. '9' | '_' )*
			{
				if ( (input.LA(1) >= 'A' && input.LA(1) <= 'Z') ) {
					input.consume();
				}
				else {
					MismatchedSetException mse = new MismatchedSetException(null,input);
					recover(mse);
					throw mse;
				}
				// Grammaire.g:245:21: ( 'a' .. 'z' | 'A' .. 'Z' | '0' .. '9' | '_' )*
				loop1:
				while (true) {
					int alt1=2;
					int LA1_0 = input.LA(1);
					if ( ((LA1_0 >= '0' && LA1_0 <= '9')||(LA1_0 >= 'A' && LA1_0 <= 'Z')||LA1_0=='_'||(LA1_0 >= 'a' && LA1_0 <= 'z')) ) {
						alt1=1;
					}

					switch (alt1) {
						case 1 :
							// Grammaire.g:
						{
							if ( (input.LA(1) >= '0' && input.LA(1) <= '9')||(input.LA(1) >= 'A' && input.LA(1) <= 'Z')||input.LA(1)=='_'||(input.LA(1) >= 'a' && input.LA(1) <= 'z') ) {
								input.consume();
							}
							else {
								MismatchedSetException mse = new MismatchedSetException(null,input);
								recover(mse);
								throw mse;
							}
						}
						break;

						default :
							break loop1;
					}
				}

			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "CLASSID"

	// $ANTLR start "ID"
	public final void mID() throws RecognitionException {
		try {
			int _type = ID;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// Grammaire.g:247:4: ( ( 'a' .. 'z' ) ( 'a' .. 'z' | 'A' .. 'Z' | '0' .. '9' | '_' )* )
			// Grammaire.g:247:6: ( 'a' .. 'z' ) ( 'a' .. 'z' | 'A' .. 'Z' | '0' .. '9' | '_' )*
			{
				if ( (input.LA(1) >= 'a' && input.LA(1) <= 'z') ) {
					input.consume();
				}
				else {
					MismatchedSetException mse = new MismatchedSetException(null,input);
					recover(mse);
					throw mse;
				}
				// Grammaire.g:247:16: ( 'a' .. 'z' | 'A' .. 'Z' | '0' .. '9' | '_' )*
				loop2:
				while (true) {
					int alt2=2;
					int LA2_0 = input.LA(1);
					if ( ((LA2_0 >= '0' && LA2_0 <= '9')||(LA2_0 >= 'A' && LA2_0 <= 'Z')||LA2_0=='_'||(LA2_0 >= 'a' && LA2_0 <= 'z')) ) {
						alt2=1;
					}

					switch (alt2) {
						case 1 :
							// Grammaire.g:
						{
							if ( (input.LA(1) >= '0' && input.LA(1) <= '9')||(input.LA(1) >= 'A' && input.LA(1) <= 'Z')||input.LA(1)=='_'||(input.LA(1) >= 'a' && input.LA(1) <= 'z') ) {
								input.consume();
							}
							else {
								MismatchedSetException mse = new MismatchedSetException(null,input);
								recover(mse);
								throw mse;
							}
						}
						break;

						default :
							break loop2;
					}
				}

			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "ID"

	// $ANTLR start "INT"
	public final void mINT() throws RecognitionException {
		try {
			int _type = INT;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// Grammaire.g:248:5: ( ( '0' .. '9' )+ )
			// Grammaire.g:248:7: ( '0' .. '9' )+
			{
				// Grammaire.g:248:7: ( '0' .. '9' )+
				int cnt3=0;
				loop3:
				while (true) {
					int alt3=2;
					int LA3_0 = input.LA(1);
					if ( ((LA3_0 >= '0' && LA3_0 <= '9')) ) {
						alt3=1;
					}

					switch (alt3) {
						case 1 :
							// Grammaire.g:
						{
							if ( (input.LA(1) >= '0' && input.LA(1) <= '9') ) {
								input.consume();
							}
							else {
								MismatchedSetException mse = new MismatchedSetException(null,input);
								recover(mse);
								throw mse;
							}
						}
						break;

						default :
							if ( cnt3 >= 1 ) break loop3;
							EarlyExitException eee = new EarlyExitException(3, input);
							throw eee;
					}
					cnt3++;
				}

			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "INT"

	// $ANTLR start "STR"
	public final void mSTR() throws RecognitionException {
		try {
			int _type = STR;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// Grammaire.g:249:5: ( '\"' ( (~ ( '\"' ) )* ) '\"' )
			// Grammaire.g:249:7: '\"' ( (~ ( '\"' ) )* ) '\"'
			{
				match('\"');
				// Grammaire.g:249:10: ( (~ ( '\"' ) )* )
				// Grammaire.g:249:11: (~ ( '\"' ) )*
				{
					// Grammaire.g:249:11: (~ ( '\"' ) )*
					loop4:
					while (true) {
						int alt4=2;
						int LA4_0 = input.LA(1);
						if ( ((LA4_0 >= '\u0000' && LA4_0 <= '!')||(LA4_0 >= '#' && LA4_0 <= '\uFFFF')) ) {
							alt4=1;
						}

						switch (alt4) {
							case 1 :
								// Grammaire.g:
							{
								if ( (input.LA(1) >= '\u0000' && input.LA(1) <= '!')||(input.LA(1) >= '#' && input.LA(1) <= '\uFFFF') ) {
									input.consume();
								}
								else {
									MismatchedSetException mse = new MismatchedSetException(null,input);
									recover(mse);
									throw mse;
								}
							}
							break;

							default :
								break loop4;
						}
					}

				}

				match('\"');
			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "STR"

	// $ANTLR start "WHITESPACE"
	public final void mWHITESPACE() throws RecognitionException {
		try {
			int _type = WHITESPACE;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// Grammaire.g:250:12: ( ( '\\t' | ' ' | '\\r' | '\\n' | '\\u000C' )+ )
			// Grammaire.g:250:14: ( '\\t' | ' ' | '\\r' | '\\n' | '\\u000C' )+
			{
				// Grammaire.g:250:14: ( '\\t' | ' ' | '\\r' | '\\n' | '\\u000C' )+
				int cnt5=0;
				loop5:
				while (true) {
					int alt5=2;
					int LA5_0 = input.LA(1);
					if ( ((LA5_0 >= '\t' && LA5_0 <= '\n')||(LA5_0 >= '\f' && LA5_0 <= '\r')||LA5_0==' ') ) {
						alt5=1;
					}

					switch (alt5) {
						case 1 :
							// Grammaire.g:
						{
							if ( (input.LA(1) >= '\t' && input.LA(1) <= '\n')||(input.LA(1) >= '\f' && input.LA(1) <= '\r')||input.LA(1)==' ' ) {
								input.consume();
							}
							else {
								MismatchedSetException mse = new MismatchedSetException(null,input);
								recover(mse);
								throw mse;
							}
						}
						break;

						default :
							if ( cnt5 >= 1 ) break loop5;
							EarlyExitException eee = new EarlyExitException(5, input);
							throw eee;
					}
					cnt5++;
				}

				_channel=HIDDEN;
			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "WHITESPACE"

	// $ANTLR start "COMMENT"
	public final void mCOMMENT() throws RecognitionException {
		try {
			int _type = COMMENT;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// Grammaire.g:251:8: ( '/*' ( options {greedy=false; } : . )* '*/' )
			// Grammaire.g:251:12: '/*' ( options {greedy=false; } : . )* '*/'
			{
				match("/*");

				// Grammaire.g:251:17: ( options {greedy=false; } : . )*
				loop6:
				while (true) {
					int alt6=2;
					int LA6_0 = input.LA(1);
					if ( (LA6_0=='*') ) {
						int LA6_1 = input.LA(2);
						if ( (LA6_1=='/') ) {
							alt6=2;
						}
						else if ( ((LA6_1 >= '\u0000' && LA6_1 <= '.')||(LA6_1 >= '0' && LA6_1 <= '\uFFFF')) ) {
							alt6=1;
						}

					}
					else if ( ((LA6_0 >= '\u0000' && LA6_0 <= ')')||(LA6_0 >= '+' && LA6_0 <= '\uFFFF')) ) {
						alt6=1;
					}

					switch (alt6) {
						case 1 :
							// Grammaire.g:251:45: .
						{
							matchAny();
						}
						break;

						default :
							break loop6;
					}
				}

				match("*/");

				_channel=HIDDEN;
			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "COMMENT"

	@Override
	public void mTokens() throws RecognitionException {
		// Grammaire.g:1:8: ( T__41 | T__42 | T__43 | T__44 | T__45 | T__46 | T__47 | T__48 | T__49 | T__50 | T__51 | T__52 | T__53 | T__54 | T__55 | T__56 | T__57 | T__58 | T__59 | T__60 | T__61 | T__62 | T__63 | T__64 | T__65 | T__66 | T__67 | T__68 | T__69 | T__70 | T__71 | T__72 | T__73 | T__74 | T__75 | T__76 | T__77 | T__78 | CLASSID | ID | INT | STR | WHITESPACE | COMMENT )
		int alt7=44;
		alt7 = dfa7.predict(input);
		switch (alt7) {
			case 1 :
				// Grammaire.g:1:10: T__41
			{
				mT__41();

			}
			break;
			case 2 :
				// Grammaire.g:1:16: T__42
			{
				mT__42();

			}
			break;
			case 3 :
				// Grammaire.g:1:22: T__43
			{
				mT__43();

			}
			break;
			case 4 :
				// Grammaire.g:1:28: T__44
			{
				mT__44();

			}
			break;
			case 5 :
				// Grammaire.g:1:34: T__45
			{
				mT__45();

			}
			break;
			case 6 :
				// Grammaire.g:1:40: T__46
			{
				mT__46();

			}
			break;
			case 7 :
				// Grammaire.g:1:46: T__47
			{
				mT__47();

			}
			break;
			case 8 :
				// Grammaire.g:1:52: T__48
			{
				mT__48();

			}
			break;
			case 9 :
				// Grammaire.g:1:58: T__49
			{
				mT__49();

			}
			break;
			case 10 :
				// Grammaire.g:1:64: T__50
			{
				mT__50();

			}
			break;
			case 11 :
				// Grammaire.g:1:70: T__51
			{
				mT__51();

			}
			break;
			case 12 :
				// Grammaire.g:1:76: T__52
			{
				mT__52();

			}
			break;
			case 13 :
				// Grammaire.g:1:82: T__53
			{
				mT__53();

			}
			break;
			case 14 :
				// Grammaire.g:1:88: T__54
			{
				mT__54();

			}
			break;
			case 15 :
				// Grammaire.g:1:94: T__55
			{
				mT__55();

			}
			break;
			case 16 :
				// Grammaire.g:1:100: T__56
			{
				mT__56();

			}
			break;
			case 17 :
				// Grammaire.g:1:106: T__57
			{
				mT__57();

			}
			break;
			case 18 :
				// Grammaire.g:1:112: T__58
			{
				mT__58();

			}
			break;
			case 19 :
				// Grammaire.g:1:118: T__59
			{
				mT__59();

			}
			break;
			case 20 :
				// Grammaire.g:1:124: T__60
			{
				mT__60();

			}
			break;
			case 21 :
				// Grammaire.g:1:130: T__61
			{
				mT__61();

			}
			break;
			case 22 :
				// Grammaire.g:1:136: T__62
			{
				mT__62();

			}
			break;
			case 23 :
				// Grammaire.g:1:142: T__63
			{
				mT__63();

			}
			break;
			case 24 :
				// Grammaire.g:1:148: T__64
			{
				mT__64();

			}
			break;
			case 25 :
				// Grammaire.g:1:154: T__65
			{
				mT__65();

			}
			break;
			case 26 :
				// Grammaire.g:1:160: T__66
			{
				mT__66();

			}
			break;
			case 27 :
				// Grammaire.g:1:166: T__67
			{
				mT__67();

			}
			break;
			case 28 :
				// Grammaire.g:1:172: T__68
			{
				mT__68();

			}
			break;
			case 29 :
				// Grammaire.g:1:178: T__69
			{
				mT__69();

			}
			break;
			case 30 :
				// Grammaire.g:1:184: T__70
			{
				mT__70();

			}
			break;
			case 31 :
				// Grammaire.g:1:190: T__71
			{
				mT__71();

			}
			break;
			case 32 :
				// Grammaire.g:1:196: T__72
			{
				mT__72();

			}
			break;
			case 33 :
				// Grammaire.g:1:202: T__73
			{
				mT__73();

			}
			break;
			case 34 :
				// Grammaire.g:1:208: T__74
			{
				mT__74();

			}
			break;
			case 35 :
				// Grammaire.g:1:214: T__75
			{
				mT__75();

			}
			break;
			case 36 :
				// Grammaire.g:1:220: T__76
			{
				mT__76();

			}
			break;
			case 37 :
				// Grammaire.g:1:226: T__77
			{
				mT__77();

			}
			break;
			case 38 :
				// Grammaire.g:1:232: T__78
			{
				mT__78();

			}
			break;
			case 39 :
				// Grammaire.g:1:238: CLASSID
			{
				mCLASSID();

			}
			break;
			case 40 :
				// Grammaire.g:1:246: ID
			{
				mID();

			}
			break;
			case 41 :
				// Grammaire.g:1:249: INT
			{
				mINT();

			}
			break;
			case 42 :
				// Grammaire.g:1:253: STR
			{
				mSTR();

			}
			break;
			case 43 :
				// Grammaire.g:1:257: WHITESPACE
			{
				mWHITESPACE();

			}
			break;
			case 44 :
				// Grammaire.g:1:268: COMMENT
			{
				mCOMMENT();

			}
			break;

		}
	}


	protected DFA7 dfa7 = new DFA7(this);
	static final String DFA7_eotS =
			"\1\uffff\1\44\7\uffff\1\46\1\50\1\uffff\1\52\2\uffff\14\37\20\uffff\1"+
					"\73\2\37\1\76\2\37\1\101\1\102\10\37\1\uffff\1\37\1\116\1\uffff\2\37\2"+
					"\uffff\1\121\7\37\1\131\2\37\1\uffff\1\134\1\37\1\uffff\5\37\1\143\1\144"+
					"\1\uffff\1\37\1\146\1\uffff\5\37\1\154\2\uffff\1\155\1\uffff\2\37\1\160"+
					"\1\161\1\162\2\uffff\1\163\1\37\4\uffff\1\165\1\uffff";
	static final String DFA7_eofS =
			"\166\uffff";
	static final String DFA7_minS =
			"\1\11\1\46\7\uffff\1\52\1\75\1\uffff\1\76\2\uffff\1\163\1\154\1\145\1"+
					"\154\1\146\1\145\1\166\1\145\1\164\1\150\1\141\1\150\20\uffff\1\60\1\141"+
					"\1\146\1\60\1\163\1\164\2\60\1\167\1\145\1\163\1\141\1\160\1\145\1\162"+
					"\1\151\1\uffff\1\163\1\60\1\uffff\2\145\2\uffff\1\60\1\162\2\165\1\164"+
					"\1\145\1\156\1\163\1\60\1\154\1\163\1\uffff\1\60\1\156\1\uffff\1\162\1"+
					"\154\1\162\1\151\1\162\2\60\1\uffff\1\145\1\60\1\uffff\1\144\1\151\1\164"+
					"\1\156\1\143\1\60\2\uffff\1\60\1\uffff\1\163\1\144\3\60\2\uffff\1\60\1"+
					"\145\4\uffff\1\60\1\uffff";
	static final String DFA7_maxS =
			"\1\175\1\46\7\uffff\1\52\1\75\1\uffff\1\76\2\uffff\1\163\1\154\1\157\1"+
					"\170\1\163\1\145\1\166\1\145\1\165\1\150\1\141\1\150\20\uffff\1\172\1"+
					"\141\1\146\1\172\1\163\1\164\2\172\1\167\1\145\1\164\1\141\1\160\1\151"+
					"\1\162\1\151\1\uffff\1\163\1\172\1\uffff\2\145\2\uffff\1\172\1\162\2\165"+
					"\1\164\1\145\1\156\1\163\1\172\1\154\1\163\1\uffff\1\172\1\156\1\uffff"+
					"\1\162\1\154\1\162\1\151\1\162\2\172\1\uffff\1\145\1\172\1\uffff\1\144"+
					"\1\151\1\164\1\156\1\143\1\172\2\uffff\1\172\1\uffff\1\163\1\144\3\172"+
					"\2\uffff\1\172\1\145\4\uffff\1\172\1\uffff";
	static final String DFA7_acceptS =
			"\2\uffff\1\3\1\4\1\5\1\6\1\7\1\10\1\11\2\uffff\1\15\1\uffff\1\20\1\21"+
					"\14\uffff\1\44\1\45\1\46\1\47\1\50\1\51\1\52\1\53\1\1\1\2\1\54\1\12\1"+
					"\14\1\13\1\17\1\16\20\uffff\1\22\2\uffff\1\25\2\uffff\1\30\1\31\13\uffff"+
					"\1\24\2\uffff\1\32\7\uffff\1\42\2\uffff\1\26\6\uffff\1\40\1\41\1\uffff"+
					"\1\23\5\uffff\1\37\1\43\2\uffff\1\34\1\35\1\36\1\27\1\uffff\1\33";
	static final String DFA7_specialS =
			"\166\uffff}>";
	static final String[] DFA7_transitionS = {
			"\2\42\1\uffff\2\42\22\uffff\1\42\1\uffff\1\41\3\uffff\1\1\1\uffff\1\2"+
					"\1\3\1\4\1\5\1\6\1\7\1\10\1\11\12\40\1\12\1\13\1\14\1\15\1\16\2\uffff"+
					"\32\36\6\uffff\1\17\1\37\1\20\1\21\1\22\3\37\1\23\4\37\1\24\1\25\2\37"+
					"\1\26\1\27\1\30\1\37\1\31\1\32\3\37\1\33\1\34\1\35",
			"\1\43",
			"",
			"",
			"",
			"",
			"",
			"",
			"",
			"\1\45",
			"\1\47",
			"",
			"\1\51",
			"",
			"",
			"\1\53",
			"\1\54",
			"\1\55\11\uffff\1\56",
			"\1\57\13\uffff\1\60",
			"\1\61\14\uffff\1\62",
			"\1\63",
			"\1\64",
			"\1\65",
			"\1\66\1\67",
			"\1\70",
			"\1\71",
			"\1\72",
			"",
			"",
			"",
			"",
			"",
			"",
			"",
			"",
			"",
			"",
			"",
			"",
			"",
			"",
			"",
			"",
			"\12\37\7\uffff\32\37\4\uffff\1\37\1\uffff\32\37",
			"\1\74",
			"\1\75",
			"\12\37\7\uffff\32\37\4\uffff\1\37\1\uffff\32\37",
			"\1\77",
			"\1\100",
			"\12\37\7\uffff\32\37\4\uffff\1\37\1\uffff\32\37",
			"\12\37\7\uffff\32\37\4\uffff\1\37\1\uffff\32\37",
			"\1\103",
			"\1\104",
			"\1\105\1\106",
			"\1\107",
			"\1\110",
			"\1\111\3\uffff\1\112",
			"\1\113",
			"\1\114",
			"",
			"\1\115",
			"\12\37\7\uffff\32\37\4\uffff\1\37\1\uffff\32\37",
			"",
			"\1\117",
			"\1\120",
			"",
			"",
			"\12\37\7\uffff\32\37\4\uffff\1\37\1\uffff\32\37",
			"\1\122",
			"\1\123",
			"\1\124",
			"\1\125",
			"\1\126",
			"\1\127",
			"\1\130",
			"\12\37\7\uffff\32\37\4\uffff\1\37\1\uffff\32\37",
			"\1\132",
			"\1\133",
			"",
			"\12\37\7\uffff\32\37\4\uffff\1\37\1\uffff\32\37",
			"\1\135",
			"",
			"\1\136",
			"\1\137",
			"\1\140",
			"\1\141",
			"\1\142",
			"\12\37\7\uffff\32\37\4\uffff\1\37\1\uffff\32\37",
			"\12\37\7\uffff\32\37\4\uffff\1\37\1\uffff\32\37",
			"",
			"\1\145",
			"\12\37\7\uffff\32\37\4\uffff\1\37\1\uffff\32\37",
			"",
			"\1\147",
			"\1\150",
			"\1\151",
			"\1\152",
			"\1\153",
			"\12\37\7\uffff\32\37\4\uffff\1\37\1\uffff\32\37",
			"",
			"",
			"\12\37\7\uffff\32\37\4\uffff\1\37\1\uffff\32\37",
			"",
			"\1\156",
			"\1\157",
			"\12\37\7\uffff\32\37\4\uffff\1\37\1\uffff\32\37",
			"\12\37\7\uffff\32\37\4\uffff\1\37\1\uffff\32\37",
			"\12\37\7\uffff\32\37\4\uffff\1\37\1\uffff\32\37",
			"",
			"",
			"\12\37\7\uffff\32\37\4\uffff\1\37\1\uffff\32\37",
			"\1\164",
			"",
			"",
			"",
			"",
			"\12\37\7\uffff\32\37\4\uffff\1\37\1\uffff\32\37",
			""
	};

	static final short[] DFA7_eot = DFA.unpackEncodedString(DFA7_eotS);
	static final short[] DFA7_eof = DFA.unpackEncodedString(DFA7_eofS);
	static final char[] DFA7_min = DFA.unpackEncodedStringToUnsignedChars(DFA7_minS);
	static final char[] DFA7_max = DFA.unpackEncodedStringToUnsignedChars(DFA7_maxS);
	static final short[] DFA7_accept = DFA.unpackEncodedString(DFA7_acceptS);
	static final short[] DFA7_special = DFA.unpackEncodedString(DFA7_specialS);
	static final short[][] DFA7_transition;

	static {
		int numStates = DFA7_transitionS.length;
		DFA7_transition = new short[numStates][];
		for (int i=0; i<numStates; i++) {
			DFA7_transition[i] = DFA.unpackEncodedString(DFA7_transitionS[i]);
		}
	}

	protected class DFA7 extends DFA {

		public DFA7(BaseRecognizer recognizer) {
			this.recognizer = recognizer;
			this.decisionNumber = 7;
			this.eot = DFA7_eot;
			this.eof = DFA7_eof;
			this.min = DFA7_min;
			this.max = DFA7_max;
			this.accept = DFA7_accept;
			this.special = DFA7_special;
			this.transition = DFA7_transition;
		}
		@Override
		public String getDescription() {
			return "1:1: Tokens : ( T__41 | T__42 | T__43 | T__44 | T__45 | T__46 | T__47 | T__48 | T__49 | T__50 | T__51 | T__52 | T__53 | T__54 | T__55 | T__56 | T__57 | T__58 | T__59 | T__60 | T__61 | T__62 | T__63 | T__64 | T__65 | T__66 | T__67 | T__68 | T__69 | T__70 | T__71 | T__72 | T__73 | T__74 | T__75 | T__76 | T__77 | T__78 | CLASSID | ID | INT | STR | WHITESPACE | COMMENT );";
		}
	}

}
