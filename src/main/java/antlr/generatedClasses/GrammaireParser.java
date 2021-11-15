package antlr.generatedClasses;
// $ANTLR 3.5.2 Grammaire.g 2021-02-15 13:18:20

import org.antlr.runtime.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;

import org.antlr.runtime.tree.*;


@SuppressWarnings("all")
public class GrammaireParser extends Parser {
	public static final String[] tokenNames = new String[] {
			"<invalid>", "<EOR>", "<DOWN>", "<UP>", "AFFECTATION", "APPEL_FONCTION",
			"ATTRIBUT", "BLOCK", "CAST", "CLASSE", "CLASSID", "COMMENT", "CONDITION",
			"DO", "ELSE", "EXTENDS", "FONCTION", "GROUP", "HERITED", "ID", "IDENTIFICATEUR",
			"IF", "INT", "LIST_PARAM", "MESSAGE", "METHOD", "MOINS_UNAIRE", "NEW",
			"PARAM", "PLUS_UNAIRE", "RESULT", "ROOT", "SELECT", "STR", "STRING", "THEN",
			"VALUE", "VARIABLE", "VARIABLE_LOCALE", "WHILE", "WHITESPACE", "'&&'",
			"'&'", "'('", "')'", "'*'", "'+'", "','", "'-'", "'.'", "'/'", "':'",
			"':='", "';'", "'<'", "'<>'", "'='", "'>'", "'as'", "'class'", "'def'",
			"'do'", "'else'", "'extends'", "'if'", "'is'", "'new'", "'override'",
			"'result'", "'return'", "'static'", "'super'", "'then'", "'this'", "'var'",
			"'while'", "'{'", "'||'", "'}'"
	};
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
	public Parser[] getDelegates() {
		return new Parser[] {};
	}

	// delegators


	public GrammaireParser(TokenStream input) {
		this(input, new RecognizerSharedState());
	}
	public GrammaireParser(TokenStream input, RecognizerSharedState state) {
		super(input, state);
	}

	protected TreeAdaptor adaptor = new CommonTreeAdaptor();

	public void setTreeAdaptor(TreeAdaptor adaptor) {
		this.adaptor = adaptor;
	}
	public TreeAdaptor getTreeAdaptor() {
		return adaptor;
	}
	@Override public String[] getTokenNames() { return GrammaireParser.tokenNames; }
	@Override public String getGrammarFileName() { return "Grammaire.g"; }


	public static class prog_return extends ParserRuleReturnScope {
		Object tree;
		@Override
		public Object getTree() { return tree; }
	};


	// $ANTLR start "prog"
	// Grammaire.g:43:1: prog : declaration -> ^( ROOT declaration ) ;
	public final GrammaireParser.prog_return prog() throws RecognitionException {
		GrammaireParser.prog_return retval = new GrammaireParser.prog_return();
		retval.start = input.LT(1);

		Object root_0 = null;

		ParserRuleReturnScope declaration1 =null;

		RewriteRuleSubtreeStream stream_declaration=new RewriteRuleSubtreeStream(adaptor,"rule declaration");

		try {
			// Grammaire.g:44:2: ( declaration -> ^( ROOT declaration ) )
			// Grammaire.g:44:4: declaration
			{
				pushFollow(FOLLOW_declaration_in_prog170);
				declaration1=declaration();
				state._fsp--;

				stream_declaration.add(declaration1.getTree());
				// AST REWRITE
				// elements: declaration
				// token labels:
				// rule labels: retval
				// token list labels:
				// rule list labels:
				// wildcard labels:
				retval.tree = root_0;
				RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.getTree():null);

				root_0 = (Object)adaptor.nil();
				// 44:16: -> ^( ROOT declaration )
				{
					// Grammaire.g:44:19: ^( ROOT declaration )
					{
						Object root_1 = (Object)adaptor.nil();
						root_1 = (Object)adaptor.becomeRoot((Object)adaptor.create(ROOT, "ROOT"), root_1);
						adaptor.addChild(root_1, stream_declaration.nextTree());
						adaptor.addChild(root_0, root_1);
					}

				}


				retval.tree = root_0;

			}

			retval.stop = input.LT(-1);

			retval.tree = (Object)adaptor.rulePostProcessing(root_0);
			adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
			retval.tree = (Object)adaptor.errorNode(input, retval.start, input.LT(-1), re);
		}
		finally {
			// do for sure before leaving
		}
		return retval;
	}
	// $ANTLR end "prog"


	public static class declaration_return extends ParserRuleReturnScope {
		Object tree;
		@Override
		public Object getTree() { return tree; }
	};


	// $ANTLR start "declaration"
	// Grammaire.g:47:1: declaration : ( cls )* bloc ;
	public final GrammaireParser.declaration_return declaration() throws RecognitionException {
		GrammaireParser.declaration_return retval = new GrammaireParser.declaration_return();
		retval.start = input.LT(1);

		Object root_0 = null;

		ParserRuleReturnScope cls2 =null;
		ParserRuleReturnScope bloc3 =null;


		try {
			// Grammaire.g:48:2: ( ( cls )* bloc )
			// Grammaire.g:48:4: ( cls )* bloc
			{
				root_0 = (Object)adaptor.nil();


				// Grammaire.g:48:4: ( cls )*
				loop1:
				while (true) {
					int alt1=2;
					int LA1_0 = input.LA(1);
					if ( (LA1_0==59) ) {
						alt1=1;
					}

					switch (alt1) {
						case 1 :
							// Grammaire.g:48:5: cls
						{
							pushFollow(FOLLOW_cls_in_declaration190);
							cls2=cls();
							state._fsp--;

							adaptor.addChild(root_0, cls2.getTree());

						}
						break;

						default :
							break loop1;
					}
				}

				pushFollow(FOLLOW_bloc_in_declaration194);
				bloc3=bloc();
				state._fsp--;

				adaptor.addChild(root_0, bloc3.getTree());

			}

			retval.stop = input.LT(-1);

			retval.tree = (Object)adaptor.rulePostProcessing(root_0);
			adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
			retval.tree = (Object)adaptor.errorNode(input, retval.start, input.LT(-1), re);
		}
		finally {
			// do for sure before leaving
		}
		return retval;
	}
	// $ANTLR end "declaration"


	public static class cls_return extends ParserRuleReturnScope {
		Object tree;
		@Override
		public Object getTree() { return tree; }
	};


	// $ANTLR start "cls"
	// Grammaire.g:51:1: cls : 'class' CLASSID '(' ( formalParam ( ',' formalParam )* )? ')' ( 'extends' CLASSID )? 'is' blocClass -> ^( CLASSE CLASSID ( ^( LIST_PARAM ( formalParam )* ) )? ( ^( EXTENDS CLASSID ) )? blocClass ) ;
	public final GrammaireParser.cls_return cls() throws RecognitionException {
		GrammaireParser.cls_return retval = new GrammaireParser.cls_return();
		retval.start = input.LT(1);

		Object root_0 = null;

		Token string_literal4=null;
		Token CLASSID5=null;
		Token char_literal6=null;
		Token char_literal8=null;
		Token char_literal10=null;
		Token string_literal11=null;
		Token CLASSID12=null;
		Token string_literal13=null;
		ParserRuleReturnScope formalParam7 =null;
		ParserRuleReturnScope formalParam9 =null;
		ParserRuleReturnScope blocClass14 =null;

		Object string_literal4_tree=null;
		Object CLASSID5_tree=null;
		Object char_literal6_tree=null;
		Object char_literal8_tree=null;
		Object char_literal10_tree=null;
		Object string_literal11_tree=null;
		Object CLASSID12_tree=null;
		Object string_literal13_tree=null;
		RewriteRuleTokenStream stream_44=new RewriteRuleTokenStream(adaptor,"token 44");
		RewriteRuleTokenStream stream_47=new RewriteRuleTokenStream(adaptor,"token 47");
		RewriteRuleTokenStream stream_59=new RewriteRuleTokenStream(adaptor,"token 59");
		RewriteRuleTokenStream stream_63=new RewriteRuleTokenStream(adaptor,"token 63");
		RewriteRuleTokenStream stream_65=new RewriteRuleTokenStream(adaptor,"token 65");
		RewriteRuleTokenStream stream_43=new RewriteRuleTokenStream(adaptor,"token 43");
		RewriteRuleTokenStream stream_CLASSID=new RewriteRuleTokenStream(adaptor,"token CLASSID");
		RewriteRuleSubtreeStream stream_formalParam=new RewriteRuleSubtreeStream(adaptor,"rule formalParam");
		RewriteRuleSubtreeStream stream_blocClass=new RewriteRuleSubtreeStream(adaptor,"rule blocClass");

		try {
			// Grammaire.g:52:2: ( 'class' CLASSID '(' ( formalParam ( ',' formalParam )* )? ')' ( 'extends' CLASSID )? 'is' blocClass -> ^( CLASSE CLASSID ( ^( LIST_PARAM ( formalParam )* ) )? ( ^( EXTENDS CLASSID ) )? blocClass ) )
			// Grammaire.g:52:4: 'class' CLASSID '(' ( formalParam ( ',' formalParam )* )? ')' ( 'extends' CLASSID )? 'is' blocClass
			{
				string_literal4=(Token)match(input,59,FOLLOW_59_in_cls205);
				stream_59.add(string_literal4);

				CLASSID5=(Token)match(input,CLASSID,FOLLOW_CLASSID_in_cls207);
				stream_CLASSID.add(CLASSID5);

				char_literal6=(Token)match(input,43,FOLLOW_43_in_cls209);
				stream_43.add(char_literal6);

				// Grammaire.g:52:24: ( formalParam ( ',' formalParam )* )?
				int alt3=2;
				int LA3_0 = input.LA(1);
				if ( (LA3_0==ID||LA3_0==74) ) {
					alt3=1;
				}
				switch (alt3) {
					case 1 :
						// Grammaire.g:52:25: formalParam ( ',' formalParam )*
					{
						pushFollow(FOLLOW_formalParam_in_cls212);
						formalParam7=formalParam();
						state._fsp--;

						stream_formalParam.add(formalParam7.getTree());
						// Grammaire.g:52:37: ( ',' formalParam )*
						loop2:
						while (true) {
							int alt2=2;
							int LA2_0 = input.LA(1);
							if ( (LA2_0==47) ) {
								alt2=1;
							}

							switch (alt2) {
								case 1 :
									// Grammaire.g:52:38: ',' formalParam
								{
									char_literal8=(Token)match(input,47,FOLLOW_47_in_cls215);
									stream_47.add(char_literal8);

									pushFollow(FOLLOW_formalParam_in_cls217);
									formalParam9=formalParam();
									state._fsp--;

									stream_formalParam.add(formalParam9.getTree());
								}
								break;

								default :
									break loop2;
							}
						}

					}
					break;

				}

				char_literal10=(Token)match(input,44,FOLLOW_44_in_cls225);
				stream_44.add(char_literal10);

				// Grammaire.g:52:64: ( 'extends' CLASSID )?
				int alt4=2;
				int LA4_0 = input.LA(1);
				if ( (LA4_0==63) ) {
					alt4=1;
				}
				switch (alt4) {
					case 1 :
						// Grammaire.g:52:65: 'extends' CLASSID
					{
						string_literal11=(Token)match(input,63,FOLLOW_63_in_cls228);
						stream_63.add(string_literal11);

						CLASSID12=(Token)match(input,CLASSID,FOLLOW_CLASSID_in_cls230);
						stream_CLASSID.add(CLASSID12);

					}
					break;

				}

				string_literal13=(Token)match(input,65,FOLLOW_65_in_cls234);
				stream_65.add(string_literal13);

				pushFollow(FOLLOW_blocClass_in_cls236);
				blocClass14=blocClass();
				state._fsp--;

				stream_blocClass.add(blocClass14.getTree());
				// AST REWRITE
				// elements: blocClass, CLASSID, formalParam, CLASSID
				// token labels:
				// rule labels: retval
				// token list labels:
				// rule list labels:
				// wildcard labels:
				retval.tree = root_0;
				RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.getTree():null);

				root_0 = (Object)adaptor.nil();
				// 52:100: -> ^( CLASSE CLASSID ( ^( LIST_PARAM ( formalParam )* ) )? ( ^( EXTENDS CLASSID ) )? blocClass )
				{
					// Grammaire.g:52:103: ^( CLASSE CLASSID ( ^( LIST_PARAM ( formalParam )* ) )? ( ^( EXTENDS CLASSID ) )? blocClass )
					{
						Object root_1 = (Object)adaptor.nil();
						root_1 = (Object)adaptor.becomeRoot((Object)adaptor.create(CLASSE, "CLASSE"), root_1);
						adaptor.addChild(root_1, stream_CLASSID.nextNode());
						// Grammaire.g:52:120: ( ^( LIST_PARAM ( formalParam )* ) )?
						if ( stream_formalParam.hasNext() ) {
							// Grammaire.g:52:120: ^( LIST_PARAM ( formalParam )* )
							{
								Object root_2 = (Object)adaptor.nil();
								root_2 = (Object)adaptor.becomeRoot((Object)adaptor.create(LIST_PARAM, "LIST_PARAM"), root_2);
								// Grammaire.g:52:133: ( formalParam )*
								while ( stream_formalParam.hasNext() ) {
									adaptor.addChild(root_2, stream_formalParam.nextTree());
								}
								stream_formalParam.reset();

								adaptor.addChild(root_1, root_2);
							}

						}
						stream_formalParam.reset();

						// Grammaire.g:52:148: ( ^( EXTENDS CLASSID ) )?
						if ( stream_CLASSID.hasNext() ) {
							// Grammaire.g:52:148: ^( EXTENDS CLASSID )
							{
								Object root_2 = (Object)adaptor.nil();
								root_2 = (Object)adaptor.becomeRoot((Object)adaptor.create(EXTENDS, "EXTENDS"), root_2);
								adaptor.addChild(root_2, stream_CLASSID.nextNode());
								adaptor.addChild(root_1, root_2);
							}

						}
						stream_CLASSID.reset();

						adaptor.addChild(root_1, stream_blocClass.nextTree());
						adaptor.addChild(root_0, root_1);
					}

				}


				retval.tree = root_0;

			}

			retval.stop = input.LT(-1);

			retval.tree = (Object)adaptor.rulePostProcessing(root_0);
			adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
			retval.tree = (Object)adaptor.errorNode(input, retval.start, input.LT(-1), re);
		}
		finally {
			// do for sure before leaving
		}
		return retval;
	}
	// $ANTLR end "cls"


	public static class blocClass_return extends ParserRuleReturnScope {
		Object tree;
		@Override
		public Object getTree() { return tree; }
	};


	// $ANTLR start "blocClass"
	// Grammaire.g:54:1: blocClass : '{' ! ( variable | methoddef )* '}' !;
	public final GrammaireParser.blocClass_return blocClass() throws RecognitionException {
		GrammaireParser.blocClass_return retval = new GrammaireParser.blocClass_return();
		retval.start = input.LT(1);

		Object root_0 = null;

		Token char_literal15=null;
		Token char_literal18=null;
		ParserRuleReturnScope variable16 =null;
		ParserRuleReturnScope methoddef17 =null;

		Object char_literal15_tree=null;
		Object char_literal18_tree=null;

		try {
			// Grammaire.g:55:2: ( '{' ! ( variable | methoddef )* '}' !)
			// Grammaire.g:55:4: '{' ! ( variable | methoddef )* '}' !
			{
				root_0 = (Object)adaptor.nil();


				char_literal15=(Token)match(input,76,FOLLOW_76_in_blocClass271);
				// Grammaire.g:55:9: ( variable | methoddef )*
				loop5:
				while (true) {
					int alt5=3;
					int LA5_0 = input.LA(1);
					if ( (LA5_0==74) ) {
						alt5=1;
					}
					else if ( (LA5_0==60) ) {
						alt5=2;
					}

					switch (alt5) {
						case 1 :
							// Grammaire.g:55:10: variable
						{
							pushFollow(FOLLOW_variable_in_blocClass275);
							variable16=variable();
							state._fsp--;

							adaptor.addChild(root_0, variable16.getTree());

						}
						break;
						case 2 :
							// Grammaire.g:55:20: methoddef
						{
							pushFollow(FOLLOW_methoddef_in_blocClass278);
							methoddef17=methoddef();
							state._fsp--;

							adaptor.addChild(root_0, methoddef17.getTree());

						}
						break;

						default :
							break loop5;
					}
				}

				char_literal18=(Token)match(input,78,FOLLOW_78_in_blocClass282);
			}

			retval.stop = input.LT(-1);

			retval.tree = (Object)adaptor.rulePostProcessing(root_0);
			adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
			retval.tree = (Object)adaptor.errorNode(input, retval.start, input.LT(-1), re);
		}
		finally {
			// do for sure before leaving
		}
		return retval;
	}
	// $ANTLR end "blocClass"


	public static class bloc_return extends ParserRuleReturnScope {
		Object tree;
		@Override
		public Object getTree() { return tree; }
	};


	// $ANTLR start "bloc"
	// Grammaire.g:58:1: bloc : '{' ( bloc2 )? '}' -> ^( BLOCK ( bloc2 )? ) ;
	public final GrammaireParser.bloc_return bloc() throws RecognitionException {
		GrammaireParser.bloc_return retval = new GrammaireParser.bloc_return();
		retval.start = input.LT(1);

		Object root_0 = null;

		Token char_literal19=null;
		Token char_literal21=null;
		ParserRuleReturnScope bloc220 =null;

		Object char_literal19_tree=null;
		Object char_literal21_tree=null;
		RewriteRuleTokenStream stream_78=new RewriteRuleTokenStream(adaptor,"token 78");
		RewriteRuleTokenStream stream_76=new RewriteRuleTokenStream(adaptor,"token 76");
		RewriteRuleSubtreeStream stream_bloc2=new RewriteRuleSubtreeStream(adaptor,"rule bloc2");

		try {
			// Grammaire.g:59:2: ( '{' ( bloc2 )? '}' -> ^( BLOCK ( bloc2 )? ) )
			// Grammaire.g:59:4: '{' ( bloc2 )? '}'
			{
				char_literal19=(Token)match(input,76,FOLLOW_76_in_bloc294);
				stream_76.add(char_literal19);

				// Grammaire.g:59:8: ( bloc2 )?
				int alt6=2;
				int LA6_0 = input.LA(1);
				if ( (LA6_0==CLASSID||LA6_0==ID||LA6_0==STR||LA6_0==64||(LA6_0 >= 68 && LA6_0 <= 69)||LA6_0==71||LA6_0==73||(LA6_0 >= 75 && LA6_0 <= 76)) ) {
					alt6=1;
				}
				switch (alt6) {
					case 1 :
						// Grammaire.g:59:8: bloc2
					{
						pushFollow(FOLLOW_bloc2_in_bloc296);
						bloc220=bloc2();
						state._fsp--;

						stream_bloc2.add(bloc220.getTree());
					}
					break;

				}

				char_literal21=(Token)match(input,78,FOLLOW_78_in_bloc299);
				stream_78.add(char_literal21);

				// AST REWRITE
				// elements: bloc2
				// token labels:
				// rule labels: retval
				// token list labels:
				// rule list labels:
				// wildcard labels:
				retval.tree = root_0;
				RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.getTree():null);

				root_0 = (Object)adaptor.nil();
				// 59:62: -> ^( BLOCK ( bloc2 )? )
				{
					// Grammaire.g:59:65: ^( BLOCK ( bloc2 )? )
					{
						Object root_1 = (Object)adaptor.nil();
						root_1 = (Object)adaptor.becomeRoot((Object)adaptor.create(BLOCK, "BLOCK"), root_1);
						// Grammaire.g:59:73: ( bloc2 )?
						if ( stream_bloc2.hasNext() ) {
							adaptor.addChild(root_1, stream_bloc2.nextTree());
						}
						stream_bloc2.reset();

						adaptor.addChild(root_0, root_1);
					}

				}


				retval.tree = root_0;

			}

			retval.stop = input.LT(-1);

			retval.tree = (Object)adaptor.rulePostProcessing(root_0);
			adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
			retval.tree = (Object)adaptor.errorNode(input, retval.start, input.LT(-1), re);
		}
		finally {
			// do for sure before leaving
		}
		return retval;
	}
	// $ANTLR end "bloc"


	public static class variable_return extends ParserRuleReturnScope {
		Object tree;
		@Override
		public Object getTree() { return tree; }
	};


	// $ANTLR start "variable"
	// Grammaire.g:62:1: variable : 'var' (stat= 'static' )? ID ':' CLASSID ( ':=' expr )? ';' -> ^( ATTRIBUT ID CLASSID ( ^( VALUE expr ) )? ( $stat)? ) ;
	public final GrammaireParser.variable_return variable() throws RecognitionException {
		GrammaireParser.variable_return retval = new GrammaireParser.variable_return();
		retval.start = input.LT(1);

		Object root_0 = null;

		Token stat=null;
		Token string_literal22=null;
		Token ID23=null;
		Token char_literal24=null;
		Token CLASSID25=null;
		Token string_literal26=null;
		Token char_literal28=null;
		ParserRuleReturnScope expr27 =null;

		Object stat_tree=null;
		Object string_literal22_tree=null;
		Object ID23_tree=null;
		Object char_literal24_tree=null;
		Object CLASSID25_tree=null;
		Object string_literal26_tree=null;
		Object char_literal28_tree=null;
		RewriteRuleTokenStream stream_70=new RewriteRuleTokenStream(adaptor,"token 70");
		RewriteRuleTokenStream stream_ID=new RewriteRuleTokenStream(adaptor,"token ID");
		RewriteRuleTokenStream stream_51=new RewriteRuleTokenStream(adaptor,"token 51");
		RewriteRuleTokenStream stream_74=new RewriteRuleTokenStream(adaptor,"token 74");
		RewriteRuleTokenStream stream_52=new RewriteRuleTokenStream(adaptor,"token 52");
		RewriteRuleTokenStream stream_53=new RewriteRuleTokenStream(adaptor,"token 53");
		RewriteRuleTokenStream stream_CLASSID=new RewriteRuleTokenStream(adaptor,"token CLASSID");
		RewriteRuleSubtreeStream stream_expr=new RewriteRuleSubtreeStream(adaptor,"rule expr");

		try {
			// Grammaire.g:63:2: ( 'var' (stat= 'static' )? ID ':' CLASSID ( ':=' expr )? ';' -> ^( ATTRIBUT ID CLASSID ( ^( VALUE expr ) )? ( $stat)? ) )
			// Grammaire.g:63:4: 'var' (stat= 'static' )? ID ':' CLASSID ( ':=' expr )? ';'
			{
				string_literal22=(Token)match(input,74,FOLLOW_74_in_variable321);
				stream_74.add(string_literal22);

				// Grammaire.g:63:10: (stat= 'static' )?
				int alt7=2;
				int LA7_0 = input.LA(1);
				if ( (LA7_0==70) ) {
					alt7=1;
				}
				switch (alt7) {
					case 1 :
						// Grammaire.g:63:11: stat= 'static'
					{
						stat=(Token)match(input,70,FOLLOW_70_in_variable326);
						stream_70.add(stat);

					}
					break;

				}

				ID23=(Token)match(input,ID,FOLLOW_ID_in_variable330);
				stream_ID.add(ID23);

				char_literal24=(Token)match(input,51,FOLLOW_51_in_variable332);
				stream_51.add(char_literal24);

				CLASSID25=(Token)match(input,CLASSID,FOLLOW_CLASSID_in_variable334);
				stream_CLASSID.add(CLASSID25);

				// Grammaire.g:63:42: ( ':=' expr )?
				int alt8=2;
				int LA8_0 = input.LA(1);
				if ( (LA8_0==52) ) {
					alt8=1;
				}
				switch (alt8) {
					case 1 :
						// Grammaire.g:63:44: ':=' expr
					{
						string_literal26=(Token)match(input,52,FOLLOW_52_in_variable338);
						stream_52.add(string_literal26);

						pushFollow(FOLLOW_expr_in_variable340);
						expr27=expr();
						state._fsp--;

						stream_expr.add(expr27.getTree());
					}
					break;

				}

				char_literal28=(Token)match(input,53,FOLLOW_53_in_variable344);
				stream_53.add(char_literal28);

				// AST REWRITE
				// elements: expr, CLASSID, stat, ID
				// token labels: stat
				// rule labels: retval
				// token list labels:
				// rule list labels:
				// wildcard labels:
				retval.tree = root_0;
				RewriteRuleTokenStream stream_stat=new RewriteRuleTokenStream(adaptor,"token stat",stat);
				RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.getTree():null);

				root_0 = (Object)adaptor.nil();
				// 63:60: -> ^( ATTRIBUT ID CLASSID ( ^( VALUE expr ) )? ( $stat)? )
				{
					// Grammaire.g:63:63: ^( ATTRIBUT ID CLASSID ( ^( VALUE expr ) )? ( $stat)? )
					{
						Object root_1 = (Object)adaptor.nil();
						root_1 = (Object)adaptor.becomeRoot((Object)adaptor.create(ATTRIBUT, "ATTRIBUT"), root_1);
						adaptor.addChild(root_1, stream_ID.nextNode());
						adaptor.addChild(root_1, stream_CLASSID.nextNode());
						// Grammaire.g:63:85: ( ^( VALUE expr ) )?
						if ( stream_expr.hasNext() ) {
							// Grammaire.g:63:85: ^( VALUE expr )
							{
								Object root_2 = (Object)adaptor.nil();
								root_2 = (Object)adaptor.becomeRoot((Object)adaptor.create(VALUE, "VALUE"), root_2);
								adaptor.addChild(root_2, stream_expr.nextTree());
								adaptor.addChild(root_1, root_2);
							}

						}
						stream_expr.reset();

						// Grammaire.g:63:101: ( $stat)?
						if ( stream_stat.hasNext() ) {
							adaptor.addChild(root_1, stream_stat.nextNode());
						}
						stream_stat.reset();

						adaptor.addChild(root_0, root_1);
					}

				}


				retval.tree = root_0;

			}

			retval.stop = input.LT(-1);

			retval.tree = (Object)adaptor.rulePostProcessing(root_0);
			adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
			retval.tree = (Object)adaptor.errorNode(input, retval.start, input.LT(-1), re);
		}
		finally {
			// do for sure before leaving
		}
		return retval;
	}
	// $ANTLR end "variable"


	public static class bloc2_return extends ParserRuleReturnScope {
		Object tree;
		@Override
		public Object getTree() { return tree; }
	};


	// $ANTLR start "bloc2"
	// Grammaire.g:66:1: bloc2 : ( (id= ID -> ^( VARIABLE $id) ) ( ( ':' CLASSID ( ':=' expr )? ';' -> ^( VARIABLE_LOCALE $id CLASSID ( ^( VALUE expr ) )? ) ) ( ( variable_locale )* -> $bloc2 ( ^( VARIABLE_LOCALE variable_locale ) )* ) ( 'is' ( instruction )+ -> $bloc2 ( instruction )+ ) | ( message -> $id message )? operator_rule ( ( ':=' expr ) -> ^( AFFECTATION ^( VARIABLE $id) expr ) )? ';' ( ( instruction )* -> $bloc2 ( instruction )* ) ) | instruction_bloc ( instruction )* | ( atom_block -> atom_block ) ( ':=' expr -> ^( AFFECTATION $bloc2 expr ) )? ';' ( ( instruction )* -> $bloc2 ( instruction )* ) );
	public final GrammaireParser.bloc2_return bloc2() throws RecognitionException {
		GrammaireParser.bloc2_return retval = new GrammaireParser.bloc2_return();
		retval.start = input.LT(1);

		Object root_0 = null;

		Token id=null;
		Token char_literal29=null;
		Token CLASSID30=null;
		Token string_literal31=null;
		Token char_literal33=null;
		Token string_literal35=null;
		Token string_literal39=null;
		Token char_literal41=null;
		Token string_literal46=null;
		Token char_literal48=null;
		ParserRuleReturnScope expr32 =null;
		ParserRuleReturnScope variable_locale34 =null;
		ParserRuleReturnScope instruction36 =null;
		ParserRuleReturnScope message37 =null;
		ParserRuleReturnScope operator_rule38 =null;
		ParserRuleReturnScope expr40 =null;
		ParserRuleReturnScope instruction42 =null;
		ParserRuleReturnScope instruction_bloc43 =null;
		ParserRuleReturnScope instruction44 =null;
		ParserRuleReturnScope atom_block45 =null;
		ParserRuleReturnScope expr47 =null;
		ParserRuleReturnScope instruction49 =null;

		Object id_tree=null;
		Object char_literal29_tree=null;
		Object CLASSID30_tree=null;
		Object string_literal31_tree=null;
		Object char_literal33_tree=null;
		Object string_literal35_tree=null;
		Object string_literal39_tree=null;
		Object char_literal41_tree=null;
		Object string_literal46_tree=null;
		Object char_literal48_tree=null;
		RewriteRuleTokenStream stream_ID=new RewriteRuleTokenStream(adaptor,"token ID");
		RewriteRuleTokenStream stream_51=new RewriteRuleTokenStream(adaptor,"token 51");
		RewriteRuleTokenStream stream_52=new RewriteRuleTokenStream(adaptor,"token 52");
		RewriteRuleTokenStream stream_53=new RewriteRuleTokenStream(adaptor,"token 53");
		RewriteRuleTokenStream stream_65=new RewriteRuleTokenStream(adaptor,"token 65");
		RewriteRuleTokenStream stream_CLASSID=new RewriteRuleTokenStream(adaptor,"token CLASSID");
		RewriteRuleSubtreeStream stream_instruction=new RewriteRuleSubtreeStream(adaptor,"rule instruction");
		RewriteRuleSubtreeStream stream_expr=new RewriteRuleSubtreeStream(adaptor,"rule expr");
		RewriteRuleSubtreeStream stream_atom_block=new RewriteRuleSubtreeStream(adaptor,"rule atom_block");
		RewriteRuleSubtreeStream stream_message=new RewriteRuleSubtreeStream(adaptor,"rule message");
		RewriteRuleSubtreeStream stream_operator_rule=new RewriteRuleSubtreeStream(adaptor,"rule operator_rule");
		RewriteRuleSubtreeStream stream_variable_locale=new RewriteRuleSubtreeStream(adaptor,"rule variable_locale");

		try {
			// Grammaire.g:67:2: ( (id= ID -> ^( VARIABLE $id) ) ( ( ':' CLASSID ( ':=' expr )? ';' -> ^( VARIABLE_LOCALE $id CLASSID ( ^( VALUE expr ) )? ) ) ( ( variable_locale )* -> $bloc2 ( ^( VARIABLE_LOCALE variable_locale ) )* ) ( 'is' ( instruction )+ -> $bloc2 ( instruction )+ ) | ( message -> $id message )? operator_rule ( ( ':=' expr ) -> ^( AFFECTATION ^( VARIABLE $id) expr ) )? ';' ( ( instruction )* -> $bloc2 ( instruction )* ) ) | instruction_bloc ( instruction )* | ( atom_block -> atom_block ) ( ':=' expr -> ^( AFFECTATION $bloc2 expr ) )? ';' ( ( instruction )* -> $bloc2 ( instruction )* ) )
			int alt19=3;
			switch ( input.LA(1) ) {
				case ID:
				{
					alt19=1;
				}
				break;
				case 64:
				case 69:
				case 75:
				case 76:
				{
					alt19=2;
				}
				break;
				case CLASSID:
				case STR:
				case 68:
				case 71:
				case 73:
				{
					alt19=3;
				}
				break;
				default:
					NoViableAltException nvae =
							new NoViableAltException("", 19, 0, input);
					throw nvae;
			}
			switch (alt19) {
				case 1 :
					// Grammaire.g:67:4: (id= ID -> ^( VARIABLE $id) ) ( ( ':' CLASSID ( ':=' expr )? ';' -> ^( VARIABLE_LOCALE $id CLASSID ( ^( VALUE expr ) )? ) ) ( ( variable_locale )* -> $bloc2 ( ^( VARIABLE_LOCALE variable_locale ) )* ) ( 'is' ( instruction )+ -> $bloc2 ( instruction )+ ) | ( message -> $id message )? operator_rule ( ( ':=' expr ) -> ^( AFFECTATION ^( VARIABLE $id) expr ) )? ';' ( ( instruction )* -> $bloc2 ( instruction )* ) )
				{
					// Grammaire.g:67:4: (id= ID -> ^( VARIABLE $id) )
					// Grammaire.g:67:5: id= ID
					{
						id=(Token)match(input,ID,FOLLOW_ID_in_bloc2383);
						stream_ID.add(id);

						// AST REWRITE
						// elements: id
						// token labels: id
						// rule labels: retval
						// token list labels:
						// rule list labels:
						// wildcard labels:
						retval.tree = root_0;
						RewriteRuleTokenStream stream_id=new RewriteRuleTokenStream(adaptor,"token id",id);
						RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.getTree():null);

						root_0 = (Object)adaptor.nil();
						// 67:11: -> ^( VARIABLE $id)
						{
							// Grammaire.g:67:14: ^( VARIABLE $id)
							{
								Object root_1 = (Object)adaptor.nil();
								root_1 = (Object)adaptor.becomeRoot((Object)adaptor.create(VARIABLE, "VARIABLE"), root_1);
								adaptor.addChild(root_1, stream_id.nextNode());
								adaptor.addChild(root_0, root_1);
							}

						}


						retval.tree = root_0;

					}

					// Grammaire.g:67:31: ( ( ':' CLASSID ( ':=' expr )? ';' -> ^( VARIABLE_LOCALE $id CLASSID ( ^( VALUE expr ) )? ) ) ( ( variable_locale )* -> $bloc2 ( ^( VARIABLE_LOCALE variable_locale ) )* ) ( 'is' ( instruction )+ -> $bloc2 ( instruction )+ ) | ( message -> $id message )? operator_rule ( ( ':=' expr ) -> ^( AFFECTATION ^( VARIABLE $id) expr ) )? ';' ( ( instruction )* -> $bloc2 ( instruction )* ) )
					int alt15=2;
					int LA15_0 = input.LA(1);
					if ( (LA15_0==51) ) {
						alt15=1;
					}
					else if ( ((LA15_0 >= 41 && LA15_0 <= 42)||(LA15_0 >= 45 && LA15_0 <= 46)||(LA15_0 >= 48 && LA15_0 <= 50)||(LA15_0 >= 52 && LA15_0 <= 57)||LA15_0==77) ) {
						alt15=2;
					}

					else {
						NoViableAltException nvae =
								new NoViableAltException("", 15, 0, input);
						throw nvae;
					}

					switch (alt15) {
						case 1 :
							// Grammaire.g:67:32: ( ':' CLASSID ( ':=' expr )? ';' -> ^( VARIABLE_LOCALE $id CLASSID ( ^( VALUE expr ) )? ) ) ( ( variable_locale )* -> $bloc2 ( ^( VARIABLE_LOCALE variable_locale ) )* ) ( 'is' ( instruction )+ -> $bloc2 ( instruction )+ )
						{
							// Grammaire.g:67:32: ( ':' CLASSID ( ':=' expr )? ';' -> ^( VARIABLE_LOCALE $id CLASSID ( ^( VALUE expr ) )? ) )
							// Grammaire.g:67:33: ':' CLASSID ( ':=' expr )? ';'
							{
								char_literal29=(Token)match(input,51,FOLLOW_51_in_bloc2397);
								stream_51.add(char_literal29);

								CLASSID30=(Token)match(input,CLASSID,FOLLOW_CLASSID_in_bloc2399);
								stream_CLASSID.add(CLASSID30);

								// Grammaire.g:67:45: ( ':=' expr )?
								int alt9=2;
								int LA9_0 = input.LA(1);
								if ( (LA9_0==52) ) {
									alt9=1;
								}
								switch (alt9) {
									case 1 :
										// Grammaire.g:67:47: ':=' expr
									{
										string_literal31=(Token)match(input,52,FOLLOW_52_in_bloc2403);
										stream_52.add(string_literal31);

										pushFollow(FOLLOW_expr_in_bloc2405);
										expr32=expr();
										state._fsp--;

										stream_expr.add(expr32.getTree());
									}
									break;

								}

								char_literal33=(Token)match(input,53,FOLLOW_53_in_bloc2409);
								stream_53.add(char_literal33);

								// AST REWRITE
								// elements: id, CLASSID, expr
								// token labels: id
								// rule labels: retval
								// token list labels:
								// rule list labels:
								// wildcard labels:
								retval.tree = root_0;
								RewriteRuleTokenStream stream_id=new RewriteRuleTokenStream(adaptor,"token id",id);
								RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.getTree():null);

								root_0 = (Object)adaptor.nil();
								// 67:63: -> ^( VARIABLE_LOCALE $id CLASSID ( ^( VALUE expr ) )? )
								{
									// Grammaire.g:67:66: ^( VARIABLE_LOCALE $id CLASSID ( ^( VALUE expr ) )? )
									{
										Object root_1 = (Object)adaptor.nil();
										root_1 = (Object)adaptor.becomeRoot((Object)adaptor.create(VARIABLE_LOCALE, "VARIABLE_LOCALE"), root_1);
										adaptor.addChild(root_1, stream_id.nextNode());
										adaptor.addChild(root_1, stream_CLASSID.nextNode());
										// Grammaire.g:67:96: ( ^( VALUE expr ) )?
										if ( stream_expr.hasNext() ) {
											// Grammaire.g:67:96: ^( VALUE expr )
											{
												Object root_2 = (Object)adaptor.nil();
												root_2 = (Object)adaptor.becomeRoot((Object)adaptor.create(VALUE, "VALUE"), root_2);
												adaptor.addChild(root_2, stream_expr.nextTree());
												adaptor.addChild(root_1, root_2);
											}

										}
										stream_expr.reset();

										adaptor.addChild(root_0, root_1);
									}

								}


								retval.tree = root_0;

							}

							// Grammaire.g:67:113: ( ( variable_locale )* -> $bloc2 ( ^( VARIABLE_LOCALE variable_locale ) )* )
							// Grammaire.g:67:114: ( variable_locale )*
							{
								// Grammaire.g:67:114: ( variable_locale )*
								loop10:
								while (true) {
									int alt10=2;
									int LA10_0 = input.LA(1);
									if ( (LA10_0==ID) ) {
										alt10=1;
									}

									switch (alt10) {
										case 1 :
											// Grammaire.g:67:114: variable_locale
										{
											pushFollow(FOLLOW_variable_locale_in_bloc2431);
											variable_locale34=variable_locale();
											state._fsp--;

											stream_variable_locale.add(variable_locale34.getTree());
										}
										break;

										default :
											break loop10;
									}
								}

								// AST REWRITE
								// elements: bloc2, variable_locale
								// token labels:
								// rule labels: retval
								// token list labels:
								// rule list labels:
								// wildcard labels:
								retval.tree = root_0;
								RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.getTree():null);

								root_0 = (Object)adaptor.nil();
								// 67:131: -> $bloc2 ( ^( VARIABLE_LOCALE variable_locale ) )*
								{
									adaptor.addChild(root_0, stream_retval.nextTree());
									// Grammaire.g:67:141: ( ^( VARIABLE_LOCALE variable_locale ) )*
									while ( stream_variable_locale.hasNext() ) {
										// Grammaire.g:67:141: ^( VARIABLE_LOCALE variable_locale )
										{
											Object root_1 = (Object)adaptor.nil();
											root_1 = (Object)adaptor.becomeRoot((Object)adaptor.create(VARIABLE_LOCALE, "VARIABLE_LOCALE"), root_1);
											adaptor.addChild(root_1, stream_variable_locale.nextTree());
											adaptor.addChild(root_0, root_1);
										}

									}
									stream_variable_locale.reset();

								}


								retval.tree = root_0;

							}

							// Grammaire.g:67:178: ( 'is' ( instruction )+ -> $bloc2 ( instruction )+ )
							// Grammaire.g:67:179: 'is' ( instruction )+
							{
								string_literal35=(Token)match(input,65,FOLLOW_65_in_bloc2448);
								stream_65.add(string_literal35);

								// Grammaire.g:67:184: ( instruction )+
								int cnt11=0;
								loop11:
								while (true) {
									int alt11=2;
									int LA11_0 = input.LA(1);
									if ( (LA11_0==CLASSID||LA11_0==ID||LA11_0==INT||LA11_0==STR||LA11_0==43||LA11_0==46||LA11_0==48||LA11_0==64||LA11_0==66||(LA11_0 >= 68 && LA11_0 <= 69)||LA11_0==71||LA11_0==73||(LA11_0 >= 75 && LA11_0 <= 76)) ) {
										alt11=1;
									}

									switch (alt11) {
										case 1 :
											// Grammaire.g:67:184: instruction
										{
											pushFollow(FOLLOW_instruction_in_bloc2450);
											instruction36=instruction();
											state._fsp--;

											stream_instruction.add(instruction36.getTree());
										}
										break;

										default :
											if ( cnt11 >= 1 ) break loop11;
											EarlyExitException eee = new EarlyExitException(11, input);
											throw eee;
									}
									cnt11++;
								}

								// AST REWRITE
								// elements: bloc2, instruction
								// token labels:
								// rule labels: retval
								// token list labels:
								// rule list labels:
								// wildcard labels:
								retval.tree = root_0;
								RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.getTree():null);

								root_0 = (Object)adaptor.nil();
								// 67:197: -> $bloc2 ( instruction )+
								{
									adaptor.addChild(root_0, stream_retval.nextTree());
									if ( !(stream_instruction.hasNext()) ) {
										throw new RewriteEarlyExitException();
									}
									while ( stream_instruction.hasNext() ) {
										adaptor.addChild(root_0, stream_instruction.nextTree());
									}
									stream_instruction.reset();

								}


								retval.tree = root_0;

							}

						}
						break;
						case 2 :
							// Grammaire.g:67:224: ( message -> $id message )? operator_rule ( ( ':=' expr ) -> ^( AFFECTATION ^( VARIABLE $id) expr ) )? ';' ( ( instruction )* -> $bloc2 ( instruction )* )
						{
							// Grammaire.g:67:224: ( message -> $id message )?
							int alt12=2;
							int LA12_0 = input.LA(1);
							if ( (LA12_0==49) ) {
								alt12=1;
							}
							switch (alt12) {
								case 1 :
									// Grammaire.g:67:225: message
								{
									pushFollow(FOLLOW_message_in_bloc2466);
									message37=message();
									state._fsp--;

									stream_message.add(message37.getTree());
									// AST REWRITE
									// elements: id, message
									// token labels: id
									// rule labels: retval
									// token list labels:
									// rule list labels:
									// wildcard labels:
									retval.tree = root_0;
									RewriteRuleTokenStream stream_id=new RewriteRuleTokenStream(adaptor,"token id",id);
									RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.getTree():null);

									root_0 = (Object)adaptor.nil();
									// 67:233: -> $id message
									{
										adaptor.addChild(root_0, stream_id.nextNode());
										adaptor.addChild(root_0, stream_message.nextTree());
									}


									retval.tree = root_0;

								}
								break;

							}

							pushFollow(FOLLOW_operator_rule_in_bloc2477);
							operator_rule38=operator_rule();
							state._fsp--;

							stream_operator_rule.add(operator_rule38.getTree());
							// Grammaire.g:67:264: ( ( ':=' expr ) -> ^( AFFECTATION ^( VARIABLE $id) expr ) )?
							int alt13=2;
							int LA13_0 = input.LA(1);
							if ( (LA13_0==52) ) {
								alt13=1;
							}
							switch (alt13) {
								case 1 :
									// Grammaire.g:67:265: ( ':=' expr )
								{
									// Grammaire.g:67:265: ( ':=' expr )
									// Grammaire.g:67:266: ':=' expr
									{
										string_literal39=(Token)match(input,52,FOLLOW_52_in_bloc2481);
										stream_52.add(string_literal39);

										pushFollow(FOLLOW_expr_in_bloc2483);
										expr40=expr();
										state._fsp--;

										stream_expr.add(expr40.getTree());
									}

									// AST REWRITE
									// elements: expr, id
									// token labels: id
									// rule labels: retval
									// token list labels:
									// rule list labels:
									// wildcard labels:
									retval.tree = root_0;
									RewriteRuleTokenStream stream_id=new RewriteRuleTokenStream(adaptor,"token id",id);
									RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.getTree():null);

									root_0 = (Object)adaptor.nil();
									// 67:276: -> ^( AFFECTATION ^( VARIABLE $id) expr )
									{
										// Grammaire.g:67:290: ^( AFFECTATION ^( VARIABLE $id) expr )
										{
											Object root_1 = (Object)adaptor.nil();
											root_1 = (Object)adaptor.becomeRoot((Object)adaptor.create(AFFECTATION, "AFFECTATION"), root_1);
											// Grammaire.g:67:304: ^( VARIABLE $id)
											{
												Object root_2 = (Object)adaptor.nil();
												root_2 = (Object)adaptor.becomeRoot((Object)adaptor.create(VARIABLE, "VARIABLE"), root_2);
												adaptor.addChild(root_2, stream_id.nextNode());
												adaptor.addChild(root_1, root_2);
											}

											adaptor.addChild(root_1, stream_expr.nextTree());
											adaptor.addChild(root_0, root_1);
										}

									}


									retval.tree = root_0;

								}
								break;

							}

							char_literal41=(Token)match(input,53,FOLLOW_53_in_bloc2505);
							stream_53.add(char_literal41);

							// Grammaire.g:67:334: ( ( instruction )* -> $bloc2 ( instruction )* )
							// Grammaire.g:67:335: ( instruction )*
							{
								// Grammaire.g:67:335: ( instruction )*
								loop14:
								while (true) {
									int alt14=2;
									int LA14_0 = input.LA(1);
									if ( (LA14_0==CLASSID||LA14_0==ID||LA14_0==INT||LA14_0==STR||LA14_0==43||LA14_0==46||LA14_0==48||LA14_0==64||LA14_0==66||(LA14_0 >= 68 && LA14_0 <= 69)||LA14_0==71||LA14_0==73||(LA14_0 >= 75 && LA14_0 <= 76)) ) {
										alt14=1;
									}

									switch (alt14) {
										case 1 :
											// Grammaire.g:67:335: instruction
										{
											pushFollow(FOLLOW_instruction_in_bloc2509);
											instruction42=instruction();
											state._fsp--;

											stream_instruction.add(instruction42.getTree());
										}
										break;

										default :
											break loop14;
									}
								}

								// AST REWRITE
								// elements: bloc2, instruction
								// token labels:
								// rule labels: retval
								// token list labels:
								// rule list labels:
								// wildcard labels:
								retval.tree = root_0;
								RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.getTree():null);

								root_0 = (Object)adaptor.nil();
								// 67:347: -> $bloc2 ( instruction )*
								{
									adaptor.addChild(root_0, stream_retval.nextTree());
									// Grammaire.g:67:357: ( instruction )*
									while ( stream_instruction.hasNext() ) {
										adaptor.addChild(root_0, stream_instruction.nextTree());
									}
									stream_instruction.reset();

								}


								retval.tree = root_0;

							}

						}
						break;

					}

				}
				break;
				case 2 :
					// Grammaire.g:68:4: instruction_bloc ( instruction )*
				{
					root_0 = (Object)adaptor.nil();


					pushFollow(FOLLOW_instruction_bloc_in_bloc2524);
					instruction_bloc43=instruction_bloc();
					state._fsp--;

					adaptor.addChild(root_0, instruction_bloc43.getTree());

					// Grammaire.g:68:21: ( instruction )*
					loop16:
					while (true) {
						int alt16=2;
						int LA16_0 = input.LA(1);
						if ( (LA16_0==CLASSID||LA16_0==ID||LA16_0==INT||LA16_0==STR||LA16_0==43||LA16_0==46||LA16_0==48||LA16_0==64||LA16_0==66||(LA16_0 >= 68 && LA16_0 <= 69)||LA16_0==71||LA16_0==73||(LA16_0 >= 75 && LA16_0 <= 76)) ) {
							alt16=1;
						}

						switch (alt16) {
							case 1 :
								// Grammaire.g:68:21: instruction
							{
								pushFollow(FOLLOW_instruction_in_bloc2526);
								instruction44=instruction();
								state._fsp--;

								adaptor.addChild(root_0, instruction44.getTree());

							}
							break;

							default :
								break loop16;
						}
					}

				}
				break;
				case 3 :
					// Grammaire.g:69:4: ( atom_block -> atom_block ) ( ':=' expr -> ^( AFFECTATION $bloc2 expr ) )? ';' ( ( instruction )* -> $bloc2 ( instruction )* )
				{
					// Grammaire.g:69:4: ( atom_block -> atom_block )
					// Grammaire.g:69:5: atom_block
					{
						pushFollow(FOLLOW_atom_block_in_bloc2533);
						atom_block45=atom_block();
						state._fsp--;

						stream_atom_block.add(atom_block45.getTree());
						// AST REWRITE
						// elements: atom_block
						// token labels:
						// rule labels: retval
						// token list labels:
						// rule list labels:
						// wildcard labels:
						retval.tree = root_0;
						RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.getTree():null);

						root_0 = (Object)adaptor.nil();
						// 69:16: -> atom_block
						{
							adaptor.addChild(root_0, stream_atom_block.nextTree());
						}


						retval.tree = root_0;

					}

					// Grammaire.g:69:31: ( ':=' expr -> ^( AFFECTATION $bloc2 expr ) )?
					int alt17=2;
					int LA17_0 = input.LA(1);
					if ( (LA17_0==52) ) {
						alt17=1;
					}
					switch (alt17) {
						case 1 :
							// Grammaire.g:69:33: ':=' expr
						{
							string_literal46=(Token)match(input,52,FOLLOW_52_in_bloc2542);
							stream_52.add(string_literal46);

							pushFollow(FOLLOW_expr_in_bloc2544);
							expr47=expr();
							state._fsp--;

							stream_expr.add(expr47.getTree());
							// AST REWRITE
							// elements: expr, bloc2
							// token labels:
							// rule labels: retval
							// token list labels:
							// rule list labels:
							// wildcard labels:
							retval.tree = root_0;
							RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.getTree():null);

							root_0 = (Object)adaptor.nil();
							// 69:43: -> ^( AFFECTATION $bloc2 expr )
							{
								// Grammaire.g:69:46: ^( AFFECTATION $bloc2 expr )
								{
									Object root_1 = (Object)adaptor.nil();
									root_1 = (Object)adaptor.becomeRoot((Object)adaptor.create(AFFECTATION, "AFFECTATION"), root_1);
									adaptor.addChild(root_1, stream_retval.nextTree());
									adaptor.addChild(root_1, stream_expr.nextTree());
									adaptor.addChild(root_0, root_1);
								}

							}


							retval.tree = root_0;

						}
						break;

					}

					char_literal48=(Token)match(input,53,FOLLOW_53_in_bloc2559);
					stream_53.add(char_literal48);

					// Grammaire.g:69:79: ( ( instruction )* -> $bloc2 ( instruction )* )
					// Grammaire.g:69:80: ( instruction )*
					{
						// Grammaire.g:69:80: ( instruction )*
						loop18:
						while (true) {
							int alt18=2;
							int LA18_0 = input.LA(1);
							if ( (LA18_0==CLASSID||LA18_0==ID||LA18_0==INT||LA18_0==STR||LA18_0==43||LA18_0==46||LA18_0==48||LA18_0==64||LA18_0==66||(LA18_0 >= 68 && LA18_0 <= 69)||LA18_0==71||LA18_0==73||(LA18_0 >= 75 && LA18_0 <= 76)) ) {
								alt18=1;
							}

							switch (alt18) {
								case 1 :
									// Grammaire.g:69:80: instruction
								{
									pushFollow(FOLLOW_instruction_in_bloc2562);
									instruction49=instruction();
									state._fsp--;

									stream_instruction.add(instruction49.getTree());
								}
								break;

								default :
									break loop18;
							}
						}

						// AST REWRITE
						// elements: bloc2, instruction
						// token labels:
						// rule labels: retval
						// token list labels:
						// rule list labels:
						// wildcard labels:
						retval.tree = root_0;
						RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.getTree():null);

						root_0 = (Object)adaptor.nil();
						// 69:93: -> $bloc2 ( instruction )*
						{
							adaptor.addChild(root_0, stream_retval.nextTree());
							// Grammaire.g:69:103: ( instruction )*
							while ( stream_instruction.hasNext() ) {
								adaptor.addChild(root_0, stream_instruction.nextTree());
							}
							stream_instruction.reset();

						}


						retval.tree = root_0;

					}

				}
				break;

			}
			retval.stop = input.LT(-1);

			retval.tree = (Object)adaptor.rulePostProcessing(root_0);
			adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
			retval.tree = (Object)adaptor.errorNode(input, retval.start, input.LT(-1), re);
		}
		finally {
			// do for sure before leaving
		}
		return retval;
	}
	// $ANTLR end "bloc2"


	public static class atom_block_return extends ParserRuleReturnScope {
		Object tree;
		@Override
		public Object getTree() { return tree; }
	};


	// $ANTLR start "atom_block"
	// Grammaire.g:72:1: atom_block : ( identificateur_bloc | string_with_quote );
	public final GrammaireParser.atom_block_return atom_block() throws RecognitionException {
		GrammaireParser.atom_block_return retval = new GrammaireParser.atom_block_return();
		retval.start = input.LT(1);

		Object root_0 = null;

		ParserRuleReturnScope identificateur_bloc50 =null;
		ParserRuleReturnScope string_with_quote51 =null;


		try {
			// Grammaire.g:73:2: ( identificateur_bloc | string_with_quote )
			int alt20=2;
			int LA20_0 = input.LA(1);
			if ( (LA20_0==CLASSID||LA20_0==68||LA20_0==71||LA20_0==73) ) {
				alt20=1;
			}
			else if ( (LA20_0==STR) ) {
				alt20=2;
			}

			else {
				NoViableAltException nvae =
						new NoViableAltException("", 20, 0, input);
				throw nvae;
			}

			switch (alt20) {
				case 1 :
					// Grammaire.g:73:4: identificateur_bloc
				{
					root_0 = (Object)adaptor.nil();


					pushFollow(FOLLOW_identificateur_bloc_in_atom_block584);
					identificateur_bloc50=identificateur_bloc();
					state._fsp--;

					adaptor.addChild(root_0, identificateur_bloc50.getTree());

				}
				break;
				case 2 :
					// Grammaire.g:74:4: string_with_quote
				{
					root_0 = (Object)adaptor.nil();


					pushFollow(FOLLOW_string_with_quote_in_atom_block589);
					string_with_quote51=string_with_quote();
					state._fsp--;

					adaptor.addChild(root_0, string_with_quote51.getTree());

				}
				break;

			}
			retval.stop = input.LT(-1);

			retval.tree = (Object)adaptor.rulePostProcessing(root_0);
			adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
			retval.tree = (Object)adaptor.errorNode(input, retval.start, input.LT(-1), re);
		}
		finally {
			// do for sure before leaving
		}
		return retval;
	}
	// $ANTLR end "atom_block"


	public static class identificateur_bloc_return extends ParserRuleReturnScope {
		Object tree;
		@Override
		public Object getTree() { return tree; }
	};


	// $ANTLR start "identificateur_bloc"
	// Grammaire.g:78:1: identificateur_bloc : ( (st= ( 'super' | 'this' ) -> ^( IDENTIFICATEUR $st) ) ( ( message -> ^( IDENTIFICATEUR ^( MESSAGE $st message ) ) )? | ( funcCall -> ^( APPEL_FONCTION $st funcCall ) ) ) | ( 'result' -> ^( IDENTIFICATEUR ^( RESULT 'result' ) ) ) ( message -> ^( IDENTIFICATEUR ^( MESSAGE RESULT message ) ) )? | CLASSID message -> ^( SELECT ^( MESSAGE CLASSID message ) ) );
	public final GrammaireParser.identificateur_bloc_return identificateur_bloc() throws RecognitionException {
		GrammaireParser.identificateur_bloc_return retval = new GrammaireParser.identificateur_bloc_return();
		retval.start = input.LT(1);

		Object root_0 = null;

		Token st=null;
		Token string_literal54=null;
		Token CLASSID56=null;
		ParserRuleReturnScope message52 =null;
		ParserRuleReturnScope funcCall53 =null;
		ParserRuleReturnScope message55 =null;
		ParserRuleReturnScope message57 =null;

		Object st_tree=null;
		Object string_literal54_tree=null;
		Object CLASSID56_tree=null;
		RewriteRuleTokenStream stream_68=new RewriteRuleTokenStream(adaptor,"token 68");
		RewriteRuleTokenStream stream_71=new RewriteRuleTokenStream(adaptor,"token 71");
		RewriteRuleTokenStream stream_73=new RewriteRuleTokenStream(adaptor,"token 73");
		RewriteRuleTokenStream stream_CLASSID=new RewriteRuleTokenStream(adaptor,"token CLASSID");
		RewriteRuleSubtreeStream stream_funcCall=new RewriteRuleSubtreeStream(adaptor,"rule funcCall");
		RewriteRuleSubtreeStream stream_message=new RewriteRuleSubtreeStream(adaptor,"rule message");

		try {
			// Grammaire.g:80:2: ( (st= ( 'super' | 'this' ) -> ^( IDENTIFICATEUR $st) ) ( ( message -> ^( IDENTIFICATEUR ^( MESSAGE $st message ) ) )? | ( funcCall -> ^( APPEL_FONCTION $st funcCall ) ) ) | ( 'result' -> ^( IDENTIFICATEUR ^( RESULT 'result' ) ) ) ( message -> ^( IDENTIFICATEUR ^( MESSAGE RESULT message ) ) )? | CLASSID message -> ^( SELECT ^( MESSAGE CLASSID message ) ) )
			int alt25=3;
			switch ( input.LA(1) ) {
				case 71:
				case 73:
				{
					alt25=1;
				}
				break;
				case 68:
				{
					alt25=2;
				}
				break;
				case CLASSID:
				{
					alt25=3;
				}
				break;
				default:
					NoViableAltException nvae =
							new NoViableAltException("", 25, 0, input);
					throw nvae;
			}
			switch (alt25) {
				case 1 :
					// Grammaire.g:80:4: (st= ( 'super' | 'this' ) -> ^( IDENTIFICATEUR $st) ) ( ( message -> ^( IDENTIFICATEUR ^( MESSAGE $st message ) ) )? | ( funcCall -> ^( APPEL_FONCTION $st funcCall ) ) )
				{
					// Grammaire.g:80:4: (st= ( 'super' | 'this' ) -> ^( IDENTIFICATEUR $st) )
					// Grammaire.g:80:5: st= ( 'super' | 'this' )
					{
						// Grammaire.g:80:8: ( 'super' | 'this' )
						int alt21=2;
						int LA21_0 = input.LA(1);
						if ( (LA21_0==71) ) {
							alt21=1;
						}
						else if ( (LA21_0==73) ) {
							alt21=2;
						}

						else {
							NoViableAltException nvae =
									new NoViableAltException("", 21, 0, input);
							throw nvae;
						}

						switch (alt21) {
							case 1 :
								// Grammaire.g:80:9: 'super'
							{
								st=(Token)match(input,71,FOLLOW_71_in_identificateur_bloc606);
								stream_71.add(st);

							}
							break;
							case 2 :
								// Grammaire.g:80:17: 'this'
							{
								st=(Token)match(input,73,FOLLOW_73_in_identificateur_bloc608);
								stream_73.add(st);

							}
							break;

						}

						// AST REWRITE
						// elements: st
						// token labels: st
						// rule labels: retval
						// token list labels:
						// rule list labels:
						// wildcard labels:
						retval.tree = root_0;
						RewriteRuleTokenStream stream_st=new RewriteRuleTokenStream(adaptor,"token st",st);
						RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.getTree():null);

						root_0 = (Object)adaptor.nil();
						// 80:25: -> ^( IDENTIFICATEUR $st)
						{
							// Grammaire.g:80:28: ^( IDENTIFICATEUR $st)
							{
								Object root_1 = (Object)adaptor.nil();
								root_1 = (Object)adaptor.becomeRoot((Object)adaptor.create(IDENTIFICATEUR, "IDENTIFICATEUR"), root_1);
								adaptor.addChild(root_1, stream_st.nextNode());
								adaptor.addChild(root_0, root_1);
							}

						}


						retval.tree = root_0;

					}

					// Grammaire.g:80:51: ( ( message -> ^( IDENTIFICATEUR ^( MESSAGE $st message ) ) )? | ( funcCall -> ^( APPEL_FONCTION $st funcCall ) ) )
					int alt23=2;
					int LA23_0 = input.LA(1);
					if ( ((LA23_0 >= 41 && LA23_0 <= 42)||(LA23_0 >= 44 && LA23_0 <= 50)||(LA23_0 >= 52 && LA23_0 <= 57)||(LA23_0 >= 60 && LA23_0 <= 61)||LA23_0==72||LA23_0==74||(LA23_0 >= 77 && LA23_0 <= 78)) ) {
						alt23=1;
					}
					else if ( (LA23_0==43) ) {
						alt23=2;
					}

					else {
						NoViableAltException nvae =
								new NoViableAltException("", 23, 0, input);
						throw nvae;
					}

					switch (alt23) {
						case 1 :
							// Grammaire.g:80:52: ( message -> ^( IDENTIFICATEUR ^( MESSAGE $st message ) ) )?
						{
							// Grammaire.g:80:52: ( message -> ^( IDENTIFICATEUR ^( MESSAGE $st message ) ) )?
							int alt22=2;
							int LA22_0 = input.LA(1);
							if ( (LA22_0==49) ) {
								alt22=1;
							}
							switch (alt22) {
								case 1 :
									// Grammaire.g:80:53: message
								{
									pushFollow(FOLLOW_message_in_identificateur_bloc623);
									message52=message();
									state._fsp--;

									stream_message.add(message52.getTree());
									// AST REWRITE
									// elements: st, message
									// token labels: st
									// rule labels: retval
									// token list labels:
									// rule list labels:
									// wildcard labels:
									retval.tree = root_0;
									RewriteRuleTokenStream stream_st=new RewriteRuleTokenStream(adaptor,"token st",st);
									RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.getTree():null);

									root_0 = (Object)adaptor.nil();
									// 80:61: -> ^( IDENTIFICATEUR ^( MESSAGE $st message ) )
									{
										// Grammaire.g:80:64: ^( IDENTIFICATEUR ^( MESSAGE $st message ) )
										{
											Object root_1 = (Object)adaptor.nil();
											root_1 = (Object)adaptor.becomeRoot((Object)adaptor.create(IDENTIFICATEUR, "IDENTIFICATEUR"), root_1);
											// Grammaire.g:80:81: ^( MESSAGE $st message )
											{
												Object root_2 = (Object)adaptor.nil();
												root_2 = (Object)adaptor.becomeRoot((Object)adaptor.create(MESSAGE, "MESSAGE"), root_2);
												adaptor.addChild(root_2, stream_st.nextNode());
												adaptor.addChild(root_2, stream_message.nextTree());
												adaptor.addChild(root_1, root_2);
											}

											adaptor.addChild(root_0, root_1);
										}

									}


									retval.tree = root_0;

								}
								break;

							}

						}
						break;
						case 2 :
							// Grammaire.g:80:109: ( funcCall -> ^( APPEL_FONCTION $st funcCall ) )
						{
							// Grammaire.g:80:109: ( funcCall -> ^( APPEL_FONCTION $st funcCall ) )
							// Grammaire.g:80:110: funcCall
							{
								pushFollow(FOLLOW_funcCall_in_identificateur_bloc645);
								funcCall53=funcCall();
								state._fsp--;

								stream_funcCall.add(funcCall53.getTree());
								// AST REWRITE
								// elements: st, funcCall
								// token labels: st
								// rule labels: retval
								// token list labels:
								// rule list labels:
								// wildcard labels:
								retval.tree = root_0;
								RewriteRuleTokenStream stream_st=new RewriteRuleTokenStream(adaptor,"token st",st);
								RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.getTree():null);

								root_0 = (Object)adaptor.nil();
								// 80:119: -> ^( APPEL_FONCTION $st funcCall )
								{
									// Grammaire.g:80:122: ^( APPEL_FONCTION $st funcCall )
									{
										Object root_1 = (Object)adaptor.nil();
										root_1 = (Object)adaptor.becomeRoot((Object)adaptor.create(APPEL_FONCTION, "APPEL_FONCTION"), root_1);
										adaptor.addChild(root_1, stream_st.nextNode());
										adaptor.addChild(root_1, stream_funcCall.nextTree());
										adaptor.addChild(root_0, root_1);
									}

								}


								retval.tree = root_0;

							}

						}
						break;

					}

				}
				break;
				case 2 :
					// Grammaire.g:82:4: ( 'result' -> ^( IDENTIFICATEUR ^( RESULT 'result' ) ) ) ( message -> ^( IDENTIFICATEUR ^( MESSAGE RESULT message ) ) )?
				{
					// Grammaire.g:82:4: ( 'result' -> ^( IDENTIFICATEUR ^( RESULT 'result' ) ) )
					// Grammaire.g:82:5: 'result'
					{
						string_literal54=(Token)match(input,68,FOLLOW_68_in_identificateur_bloc665);
						stream_68.add(string_literal54);

						// AST REWRITE
						// elements: 68
						// token labels:
						// rule labels: retval
						// token list labels:
						// rule list labels:
						// wildcard labels:
						retval.tree = root_0;
						RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.getTree():null);

						root_0 = (Object)adaptor.nil();
						// 82:14: -> ^( IDENTIFICATEUR ^( RESULT 'result' ) )
						{
							// Grammaire.g:82:17: ^( IDENTIFICATEUR ^( RESULT 'result' ) )
							{
								Object root_1 = (Object)adaptor.nil();
								root_1 = (Object)adaptor.becomeRoot((Object)adaptor.create(IDENTIFICATEUR, "IDENTIFICATEUR"), root_1);
								// Grammaire.g:82:34: ^( RESULT 'result' )
								{
									Object root_2 = (Object)adaptor.nil();
									root_2 = (Object)adaptor.becomeRoot((Object)adaptor.create(RESULT, "RESULT"), root_2);
									adaptor.addChild(root_2, stream_68.nextNode());
									adaptor.addChild(root_1, root_2);
								}

								adaptor.addChild(root_0, root_1);
							}

						}


						retval.tree = root_0;

					}

					// Grammaire.g:82:58: ( message -> ^( IDENTIFICATEUR ^( MESSAGE RESULT message ) ) )?
					int alt24=2;
					int LA24_0 = input.LA(1);
					if ( (LA24_0==49) ) {
						alt24=1;
					}
					switch (alt24) {
						case 1 :
							// Grammaire.g:82:59: message
						{
							pushFollow(FOLLOW_message_in_identificateur_bloc684);
							message55=message();
							state._fsp--;

							stream_message.add(message55.getTree());
							// AST REWRITE
							// elements: message
							// token labels:
							// rule labels: retval
							// token list labels:
							// rule list labels:
							// wildcard labels:
							retval.tree = root_0;
							RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.getTree():null);

							root_0 = (Object)adaptor.nil();
							// 82:67: -> ^( IDENTIFICATEUR ^( MESSAGE RESULT message ) )
							{
								// Grammaire.g:82:70: ^( IDENTIFICATEUR ^( MESSAGE RESULT message ) )
								{
									Object root_1 = (Object)adaptor.nil();
									root_1 = (Object)adaptor.becomeRoot((Object)adaptor.create(IDENTIFICATEUR, "IDENTIFICATEUR"), root_1);
									// Grammaire.g:82:87: ^( MESSAGE RESULT message )
									{
										Object root_2 = (Object)adaptor.nil();
										root_2 = (Object)adaptor.becomeRoot((Object)adaptor.create(MESSAGE, "MESSAGE"), root_2);
										adaptor.addChild(root_2, (Object)adaptor.create(RESULT, "RESULT"));
										adaptor.addChild(root_2, stream_message.nextTree());
										adaptor.addChild(root_1, root_2);
									}

									adaptor.addChild(root_0, root_1);
								}

							}


							retval.tree = root_0;

						}
						break;

					}

				}
				break;
				case 3 :
					// Grammaire.g:84:4: CLASSID message
				{
					CLASSID56=(Token)match(input,CLASSID,FOLLOW_CLASSID_in_identificateur_bloc708);
					stream_CLASSID.add(CLASSID56);

					pushFollow(FOLLOW_message_in_identificateur_bloc710);
					message57=message();
					state._fsp--;

					stream_message.add(message57.getTree());
					// AST REWRITE
					// elements: message, CLASSID
					// token labels:
					// rule labels: retval
					// token list labels:
					// rule list labels:
					// wildcard labels:
					retval.tree = root_0;
					RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.getTree():null);

					root_0 = (Object)adaptor.nil();
					// 84:20: -> ^( SELECT ^( MESSAGE CLASSID message ) )
					{
						// Grammaire.g:84:23: ^( SELECT ^( MESSAGE CLASSID message ) )
						{
							Object root_1 = (Object)adaptor.nil();
							root_1 = (Object)adaptor.becomeRoot((Object)adaptor.create(SELECT, "SELECT"), root_1);
							// Grammaire.g:84:32: ^( MESSAGE CLASSID message )
							{
								Object root_2 = (Object)adaptor.nil();
								root_2 = (Object)adaptor.becomeRoot((Object)adaptor.create(MESSAGE, "MESSAGE"), root_2);
								adaptor.addChild(root_2, stream_CLASSID.nextNode());
								adaptor.addChild(root_2, stream_message.nextTree());
								adaptor.addChild(root_1, root_2);
							}

							adaptor.addChild(root_0, root_1);
						}

					}


					retval.tree = root_0;

				}
				break;

			}
			retval.stop = input.LT(-1);

			retval.tree = (Object)adaptor.rulePostProcessing(root_0);
			adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
			retval.tree = (Object)adaptor.errorNode(input, retval.start, input.LT(-1), re);
		}
		finally {
			// do for sure before leaving
		}
		return retval;
	}
	// $ANTLR end "identificateur_bloc"


	public static class operator_rule_return extends ParserRuleReturnScope {
		Object tree;
		@Override
		public Object getTree() { return tree; }
	};


	// $ANTLR start "operator_rule"
	// Grammaire.g:87:1: operator_rule : ( operatorMD ^ atom1 )* ( operatorPM ^ expr3 )* ( operatorComp ^ expr2 )* ( operatorLog ^ expr1 )* ;
	public final GrammaireParser.operator_rule_return operator_rule() throws RecognitionException {
		GrammaireParser.operator_rule_return retval = new GrammaireParser.operator_rule_return();
		retval.start = input.LT(1);

		Object root_0 = null;

		ParserRuleReturnScope operatorMD58 =null;
		ParserRuleReturnScope atom159 =null;
		ParserRuleReturnScope operatorPM60 =null;
		ParserRuleReturnScope expr361 =null;
		ParserRuleReturnScope operatorComp62 =null;
		ParserRuleReturnScope expr263 =null;
		ParserRuleReturnScope operatorLog64 =null;
		ParserRuleReturnScope expr165 =null;


		try {
			// Grammaire.g:88:2: ( ( operatorMD ^ atom1 )* ( operatorPM ^ expr3 )* ( operatorComp ^ expr2 )* ( operatorLog ^ expr1 )* )
			// Grammaire.g:88:4: ( operatorMD ^ atom1 )* ( operatorPM ^ expr3 )* ( operatorComp ^ expr2 )* ( operatorLog ^ expr1 )*
			{
				root_0 = (Object)adaptor.nil();


				// Grammaire.g:88:4: ( operatorMD ^ atom1 )*
				loop26:
				while (true) {
					int alt26=2;
					int LA26_0 = input.LA(1);
					if ( (LA26_0==45||LA26_0==50) ) {
						alt26=1;
					}

					switch (alt26) {
						case 1 :
							// Grammaire.g:88:5: operatorMD ^ atom1
						{
							pushFollow(FOLLOW_operatorMD_in_operator_rule736);
							operatorMD58=operatorMD();
							state._fsp--;

							root_0 = (Object)adaptor.becomeRoot(operatorMD58.getTree(), root_0);
							pushFollow(FOLLOW_atom1_in_operator_rule739);
							atom159=atom1();
							state._fsp--;

							adaptor.addChild(root_0, atom159.getTree());

						}
						break;

						default :
							break loop26;
					}
				}

				// Grammaire.g:88:26: ( operatorPM ^ expr3 )*
				loop27:
				while (true) {
					int alt27=2;
					int LA27_0 = input.LA(1);
					if ( (LA27_0==46||LA27_0==48) ) {
						alt27=1;
					}

					switch (alt27) {
						case 1 :
							// Grammaire.g:88:27: operatorPM ^ expr3
						{
							pushFollow(FOLLOW_operatorPM_in_operator_rule745);
							operatorPM60=operatorPM();
							state._fsp--;

							root_0 = (Object)adaptor.becomeRoot(operatorPM60.getTree(), root_0);
							pushFollow(FOLLOW_expr3_in_operator_rule748);
							expr361=expr3();
							state._fsp--;

							adaptor.addChild(root_0, expr361.getTree());

						}
						break;

						default :
							break loop27;
					}
				}

				// Grammaire.g:88:47: ( operatorComp ^ expr2 )*
				loop28:
				while (true) {
					int alt28=2;
					int LA28_0 = input.LA(1);
					if ( ((LA28_0 >= 54 && LA28_0 <= 57)) ) {
						alt28=1;
					}

					switch (alt28) {
						case 1 :
							// Grammaire.g:88:48: operatorComp ^ expr2
						{
							pushFollow(FOLLOW_operatorComp_in_operator_rule753);
							operatorComp62=operatorComp();
							state._fsp--;

							root_0 = (Object)adaptor.becomeRoot(operatorComp62.getTree(), root_0);
							pushFollow(FOLLOW_expr2_in_operator_rule756);
							expr263=expr2();
							state._fsp--;

							adaptor.addChild(root_0, expr263.getTree());

						}
						break;

						default :
							break loop28;
					}
				}

				// Grammaire.g:88:71: ( operatorLog ^ expr1 )*
				loop29:
				while (true) {
					int alt29=2;
					int LA29_0 = input.LA(1);
					if ( ((LA29_0 >= 41 && LA29_0 <= 42)||LA29_0==77) ) {
						alt29=1;
					}

					switch (alt29) {
						case 1 :
							// Grammaire.g:88:72: operatorLog ^ expr1
						{
							pushFollow(FOLLOW_operatorLog_in_operator_rule762);
							operatorLog64=operatorLog();
							state._fsp--;

							root_0 = (Object)adaptor.becomeRoot(operatorLog64.getTree(), root_0);
							pushFollow(FOLLOW_expr1_in_operator_rule765);
							expr165=expr1();
							state._fsp--;

							adaptor.addChild(root_0, expr165.getTree());

						}
						break;

						default :
							break loop29;
					}
				}

			}

			retval.stop = input.LT(-1);

			retval.tree = (Object)adaptor.rulePostProcessing(root_0);
			adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
			retval.tree = (Object)adaptor.errorNode(input, retval.start, input.LT(-1), re);
		}
		finally {
			// do for sure before leaving
		}
		return retval;
	}
	// $ANTLR end "operator_rule"


	public static class variable_locale_return extends ParserRuleReturnScope {
		Object tree;
		@Override
		public Object getTree() { return tree; }
	};


	// $ANTLR start "variable_locale"
	// Grammaire.g:91:1: variable_locale : ID ':' CLASSID ( ':=' expr )? ';' -> ID CLASSID ( ^( VALUE expr ) )? ;
	public final GrammaireParser.variable_locale_return variable_locale() throws RecognitionException {
		GrammaireParser.variable_locale_return retval = new GrammaireParser.variable_locale_return();
		retval.start = input.LT(1);

		Object root_0 = null;

		Token ID66=null;
		Token char_literal67=null;
		Token CLASSID68=null;
		Token string_literal69=null;
		Token char_literal71=null;
		ParserRuleReturnScope expr70 =null;

		Object ID66_tree=null;
		Object char_literal67_tree=null;
		Object CLASSID68_tree=null;
		Object string_literal69_tree=null;
		Object char_literal71_tree=null;
		RewriteRuleTokenStream stream_ID=new RewriteRuleTokenStream(adaptor,"token ID");
		RewriteRuleTokenStream stream_51=new RewriteRuleTokenStream(adaptor,"token 51");
		RewriteRuleTokenStream stream_52=new RewriteRuleTokenStream(adaptor,"token 52");
		RewriteRuleTokenStream stream_53=new RewriteRuleTokenStream(adaptor,"token 53");
		RewriteRuleTokenStream stream_CLASSID=new RewriteRuleTokenStream(adaptor,"token CLASSID");
		RewriteRuleSubtreeStream stream_expr=new RewriteRuleSubtreeStream(adaptor,"rule expr");

		try {
			// Grammaire.g:92:2: ( ID ':' CLASSID ( ':=' expr )? ';' -> ID CLASSID ( ^( VALUE expr ) )? )
			// Grammaire.g:92:4: ID ':' CLASSID ( ':=' expr )? ';'
			{
				ID66=(Token)match(input,ID,FOLLOW_ID_in_variable_locale778);
				stream_ID.add(ID66);

				char_literal67=(Token)match(input,51,FOLLOW_51_in_variable_locale780);
				stream_51.add(char_literal67);

				CLASSID68=(Token)match(input,CLASSID,FOLLOW_CLASSID_in_variable_locale782);
				stream_CLASSID.add(CLASSID68);

				// Grammaire.g:92:19: ( ':=' expr )?
				int alt30=2;
				int LA30_0 = input.LA(1);
				if ( (LA30_0==52) ) {
					alt30=1;
				}
				switch (alt30) {
					case 1 :
						// Grammaire.g:92:21: ':=' expr
					{
						string_literal69=(Token)match(input,52,FOLLOW_52_in_variable_locale786);
						stream_52.add(string_literal69);

						pushFollow(FOLLOW_expr_in_variable_locale788);
						expr70=expr();
						state._fsp--;

						stream_expr.add(expr70.getTree());
					}
					break;

				}

				char_literal71=(Token)match(input,53,FOLLOW_53_in_variable_locale792);
				stream_53.add(char_literal71);

				// AST REWRITE
				// elements: ID, expr, CLASSID
				// token labels:
				// rule labels: retval
				// token list labels:
				// rule list labels:
				// wildcard labels:
				retval.tree = root_0;
				RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.getTree():null);

				root_0 = (Object)adaptor.nil();
				// 92:37: -> ID CLASSID ( ^( VALUE expr ) )?
				{
					adaptor.addChild(root_0, stream_ID.nextNode());
					adaptor.addChild(root_0, stream_CLASSID.nextNode());
					// Grammaire.g:92:51: ( ^( VALUE expr ) )?
					if ( stream_expr.hasNext() ) {
						// Grammaire.g:92:51: ^( VALUE expr )
						{
							Object root_1 = (Object)adaptor.nil();
							root_1 = (Object)adaptor.becomeRoot((Object)adaptor.create(VALUE, "VALUE"), root_1);
							adaptor.addChild(root_1, stream_expr.nextTree());
							adaptor.addChild(root_0, root_1);
						}

					}
					stream_expr.reset();

				}


				retval.tree = root_0;

			}

			retval.stop = input.LT(-1);

			retval.tree = (Object)adaptor.rulePostProcessing(root_0);
			adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
			retval.tree = (Object)adaptor.errorNode(input, retval.start, input.LT(-1), re);
		}
		finally {
			// do for sure before leaving
		}
		return retval;
	}
	// $ANTLR end "variable_locale"


	public static class instruction_bloc_return extends ParserRuleReturnScope {
		Object tree;
		@Override
		public Object getTree() { return tree; }
	};


	// $ANTLR start "instruction_bloc"
	// Grammaire.g:95:1: instruction_bloc : ( bloc | 'return' ';' ->| ifStatement | whileStatement );
	public final GrammaireParser.instruction_bloc_return instruction_bloc() throws RecognitionException {
		GrammaireParser.instruction_bloc_return retval = new GrammaireParser.instruction_bloc_return();
		retval.start = input.LT(1);

		Object root_0 = null;

		Token string_literal73=null;
		Token char_literal74=null;
		ParserRuleReturnScope bloc72 =null;
		ParserRuleReturnScope ifStatement75 =null;
		ParserRuleReturnScope whileStatement76 =null;

		Object string_literal73_tree=null;
		Object char_literal74_tree=null;
		RewriteRuleTokenStream stream_69=new RewriteRuleTokenStream(adaptor,"token 69");
		RewriteRuleTokenStream stream_53=new RewriteRuleTokenStream(adaptor,"token 53");

		try {
			// Grammaire.g:96:2: ( bloc | 'return' ';' ->| ifStatement | whileStatement )
			int alt31=4;
			switch ( input.LA(1) ) {
				case 76:
				{
					alt31=1;
				}
				break;
				case 69:
				{
					alt31=2;
				}
				break;
				case 64:
				{
					alt31=3;
				}
				break;
				case 75:
				{
					alt31=4;
				}
				break;
				default:
					NoViableAltException nvae =
							new NoViableAltException("", 31, 0, input);
					throw nvae;
			}
			switch (alt31) {
				case 1 :
					// Grammaire.g:96:4: bloc
				{
					root_0 = (Object)adaptor.nil();


					pushFollow(FOLLOW_bloc_in_instruction_bloc816);
					bloc72=bloc();
					state._fsp--;

					adaptor.addChild(root_0, bloc72.getTree());

				}
				break;
				case 2 :
					// Grammaire.g:97:4: 'return' ';'
				{
					string_literal73=(Token)match(input,69,FOLLOW_69_in_instruction_bloc821);
					stream_69.add(string_literal73);

					char_literal74=(Token)match(input,53,FOLLOW_53_in_instruction_bloc823);
					stream_53.add(char_literal74);

					// AST REWRITE
					// elements:
					// token labels:
					// rule labels: retval
					// token list labels:
					// rule list labels:
					// wildcard labels:
					retval.tree = root_0;
					RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.getTree():null);

					root_0 = (Object)adaptor.nil();
					// 97:17: ->
					{
						root_0 = null;
					}


					retval.tree = root_0;

				}
				break;
				case 3 :
					// Grammaire.g:98:4: ifStatement
				{
					root_0 = (Object)adaptor.nil();


					pushFollow(FOLLOW_ifStatement_in_instruction_bloc830);
					ifStatement75=ifStatement();
					state._fsp--;

					adaptor.addChild(root_0, ifStatement75.getTree());

				}
				break;
				case 4 :
					// Grammaire.g:99:4: whileStatement
				{
					root_0 = (Object)adaptor.nil();


					pushFollow(FOLLOW_whileStatement_in_instruction_bloc835);
					whileStatement76=whileStatement();
					state._fsp--;

					adaptor.addChild(root_0, whileStatement76.getTree());

				}
				break;

			}
			retval.stop = input.LT(-1);

			retval.tree = (Object)adaptor.rulePostProcessing(root_0);
			adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
			retval.tree = (Object)adaptor.errorNode(input, retval.start, input.LT(-1), re);
		}
		finally {
			// do for sure before leaving
		}
		return retval;
	}
	// $ANTLR end "instruction_bloc"


	public static class instruction_return extends ParserRuleReturnScope {
		Object tree;
		@Override
		public Object getTree() { return tree; }
	};


	// $ANTLR start "instruction"
	// Grammaire.g:102:1: instruction : ( bloc | 'return' ';' ->| (e1= expr -> $e1) ( ':=' e2= expr -> ^( AFFECTATION $e1 $e2) )? ';' | ifStatement | whileStatement );
	public final GrammaireParser.instruction_return instruction() throws RecognitionException {
		GrammaireParser.instruction_return retval = new GrammaireParser.instruction_return();
		retval.start = input.LT(1);

		Object root_0 = null;

		Token string_literal78=null;
		Token char_literal79=null;
		Token string_literal80=null;
		Token char_literal81=null;
		ParserRuleReturnScope e1 =null;
		ParserRuleReturnScope e2 =null;
		ParserRuleReturnScope bloc77 =null;
		ParserRuleReturnScope ifStatement82 =null;
		ParserRuleReturnScope whileStatement83 =null;

		Object string_literal78_tree=null;
		Object char_literal79_tree=null;
		Object string_literal80_tree=null;
		Object char_literal81_tree=null;
		RewriteRuleTokenStream stream_69=new RewriteRuleTokenStream(adaptor,"token 69");
		RewriteRuleTokenStream stream_52=new RewriteRuleTokenStream(adaptor,"token 52");
		RewriteRuleTokenStream stream_53=new RewriteRuleTokenStream(adaptor,"token 53");
		RewriteRuleSubtreeStream stream_expr=new RewriteRuleSubtreeStream(adaptor,"rule expr");

		try {
			// Grammaire.g:103:2: ( bloc | 'return' ';' ->| (e1= expr -> $e1) ( ':=' e2= expr -> ^( AFFECTATION $e1 $e2) )? ';' | ifStatement | whileStatement )
			int alt33=5;
			switch ( input.LA(1) ) {
				case 76:
				{
					alt33=1;
				}
				break;
				case 69:
				{
					alt33=2;
				}
				break;
				case CLASSID:
				case ID:
				case INT:
				case STR:
				case 43:
				case 46:
				case 48:
				case 66:
				case 68:
				case 71:
				case 73:
				{
					alt33=3;
				}
				break;
				case 64:
				{
					alt33=4;
				}
				break;
				case 75:
				{
					alt33=5;
				}
				break;
				default:
					NoViableAltException nvae =
							new NoViableAltException("", 33, 0, input);
					throw nvae;
			}
			switch (alt33) {
				case 1 :
					// Grammaire.g:103:4: bloc
				{
					root_0 = (Object)adaptor.nil();


					pushFollow(FOLLOW_bloc_in_instruction846);
					bloc77=bloc();
					state._fsp--;

					adaptor.addChild(root_0, bloc77.getTree());

				}
				break;
				case 2 :
					// Grammaire.g:104:4: 'return' ';'
				{
					string_literal78=(Token)match(input,69,FOLLOW_69_in_instruction851);
					stream_69.add(string_literal78);

					char_literal79=(Token)match(input,53,FOLLOW_53_in_instruction853);
					stream_53.add(char_literal79);

					// AST REWRITE
					// elements:
					// token labels:
					// rule labels: retval
					// token list labels:
					// rule list labels:
					// wildcard labels:
					retval.tree = root_0;
					RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.getTree():null);

					root_0 = (Object)adaptor.nil();
					// 104:17: ->
					{
						root_0 = null;
					}


					retval.tree = root_0;

				}
				break;
				case 3 :
					// Grammaire.g:105:4: (e1= expr -> $e1) ( ':=' e2= expr -> ^( AFFECTATION $e1 $e2) )? ';'
				{
					// Grammaire.g:105:4: (e1= expr -> $e1)
					// Grammaire.g:105:5: e1= expr
					{
						pushFollow(FOLLOW_expr_in_instruction863);
						e1=expr();
						state._fsp--;

						stream_expr.add(e1.getTree());
						// AST REWRITE
						// elements: e1
						// token labels:
						// rule labels: e1, retval
						// token list labels:
						// rule list labels:
						// wildcard labels:
						retval.tree = root_0;
						RewriteRuleSubtreeStream stream_e1=new RewriteRuleSubtreeStream(adaptor,"rule e1",e1!=null?e1.getTree():null);
						RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.getTree():null);

						root_0 = (Object)adaptor.nil();
						// 105:13: -> $e1
						{
							adaptor.addChild(root_0, stream_e1.nextTree());
						}


						retval.tree = root_0;

					}

					// Grammaire.g:105:21: ( ':=' e2= expr -> ^( AFFECTATION $e1 $e2) )?
					int alt32=2;
					int LA32_0 = input.LA(1);
					if ( (LA32_0==52) ) {
						alt32=1;
					}
					switch (alt32) {
						case 1 :
							// Grammaire.g:105:22: ':=' e2= expr
						{
							string_literal80=(Token)match(input,52,FOLLOW_52_in_instruction872);
							stream_52.add(string_literal80);

							pushFollow(FOLLOW_expr_in_instruction876);
							e2=expr();
							state._fsp--;

							stream_expr.add(e2.getTree());
							// AST REWRITE
							// elements: e1, e2
							// token labels:
							// rule labels: e1, e2, retval
							// token list labels:
							// rule list labels:
							// wildcard labels:
							retval.tree = root_0;
							RewriteRuleSubtreeStream stream_e1=new RewriteRuleSubtreeStream(adaptor,"rule e1",e1!=null?e1.getTree():null);
							RewriteRuleSubtreeStream stream_e2=new RewriteRuleSubtreeStream(adaptor,"rule e2",e2!=null?e2.getTree():null);
							RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.getTree():null);

							root_0 = (Object)adaptor.nil();
							// 105:35: -> ^( AFFECTATION $e1 $e2)
							{
								// Grammaire.g:105:38: ^( AFFECTATION $e1 $e2)
								{
									Object root_1 = (Object)adaptor.nil();
									root_1 = (Object)adaptor.becomeRoot((Object)adaptor.create(AFFECTATION, "AFFECTATION"), root_1);
									adaptor.addChild(root_1, stream_e1.nextTree());
									adaptor.addChild(root_1, stream_e2.nextTree());
									adaptor.addChild(root_0, root_1);
								}

							}


							retval.tree = root_0;

						}
						break;

					}

					char_literal81=(Token)match(input,53,FOLLOW_53_in_instruction892);
					stream_53.add(char_literal81);

				}
				break;
				case 4 :
					// Grammaire.g:106:4: ifStatement
				{
					root_0 = (Object)adaptor.nil();


					pushFollow(FOLLOW_ifStatement_in_instruction897);
					ifStatement82=ifStatement();
					state._fsp--;

					adaptor.addChild(root_0, ifStatement82.getTree());

				}
				break;
				case 5 :
					// Grammaire.g:107:4: whileStatement
				{
					root_0 = (Object)adaptor.nil();


					pushFollow(FOLLOW_whileStatement_in_instruction902);
					whileStatement83=whileStatement();
					state._fsp--;

					adaptor.addChild(root_0, whileStatement83.getTree());

				}
				break;

			}
			retval.stop = input.LT(-1);

			retval.tree = (Object)adaptor.rulePostProcessing(root_0);
			adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
			retval.tree = (Object)adaptor.errorNode(input, retval.start, input.LT(-1), re);
		}
		finally {
			// do for sure before leaving
		}
		return retval;
	}
	// $ANTLR end "instruction"


	public static class methoddef_return extends ParserRuleReturnScope {
		Object tree;
		@Override
		public Object getTree() { return tree; }
	};


	// $ANTLR start "methoddef"
	// Grammaire.g:111:1: methoddef : 'def' method -> ^( METHOD method ) ;
	public final GrammaireParser.methoddef_return methoddef() throws RecognitionException {
		GrammaireParser.methoddef_return retval = new GrammaireParser.methoddef_return();
		retval.start = input.LT(1);

		Object root_0 = null;

		Token string_literal84=null;
		ParserRuleReturnScope method85 =null;

		Object string_literal84_tree=null;
		RewriteRuleTokenStream stream_60=new RewriteRuleTokenStream(adaptor,"token 60");
		RewriteRuleSubtreeStream stream_method=new RewriteRuleSubtreeStream(adaptor,"rule method");

		try {
			// Grammaire.g:112:2: ( 'def' method -> ^( METHOD method ) )
			// Grammaire.g:112:4: 'def' method
			{
				string_literal84=(Token)match(input,60,FOLLOW_60_in_methoddef915);
				stream_60.add(string_literal84);

				pushFollow(FOLLOW_method_in_methoddef917);
				method85=method();
				state._fsp--;

				stream_method.add(method85.getTree());
				// AST REWRITE
				// elements: method
				// token labels:
				// rule labels: retval
				// token list labels:
				// rule list labels:
				// wildcard labels:
				retval.tree = root_0;
				RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.getTree():null);

				root_0 = (Object)adaptor.nil();
				// 112:17: -> ^( METHOD method )
				{
					// Grammaire.g:112:20: ^( METHOD method )
					{
						Object root_1 = (Object)adaptor.nil();
						root_1 = (Object)adaptor.becomeRoot((Object)adaptor.create(METHOD, "METHOD"), root_1);
						adaptor.addChild(root_1, stream_method.nextTree());
						adaptor.addChild(root_0, root_1);
					}

				}


				retval.tree = root_0;

			}

			retval.stop = input.LT(-1);

			retval.tree = (Object)adaptor.rulePostProcessing(root_0);
			adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
			retval.tree = (Object)adaptor.errorNode(input, retval.start, input.LT(-1), re);
		}
		finally {
			// do for sure before leaving
		}
		return retval;
	}
	// $ANTLR end "methoddef"


	public static class method_return extends ParserRuleReturnScope {
		Object tree;
		@Override
		public Object getTree() { return tree; }
	};


	// $ANTLR start "method"
	// Grammaire.g:115:1: method : ( (s= 'static' )? (o= 'override' )? ID '(' ( formalParam ( ',' formalParam )* )? ')' methodShortLong -> ID ( $s)? ( $o)? ( ^( LIST_PARAM ( formalParam )* ) )? methodShortLong | CLASSID '(' ( formalParam ( ',' formalParam )* )? ')' ( ':' CLASSID funcCall )? 'is' bloc -> CLASSID ( ^( LIST_PARAM ( formalParam )* ) )? ( ^( HERITED CLASSID ( funcCall )* ) )? bloc );
	public final GrammaireParser.method_return method() throws RecognitionException {
		GrammaireParser.method_return retval = new GrammaireParser.method_return();
		retval.start = input.LT(1);

		Object root_0 = null;

		Token s=null;
		Token o=null;
		Token ID86=null;
		Token char_literal87=null;
		Token char_literal89=null;
		Token char_literal91=null;
		Token CLASSID93=null;
		Token char_literal94=null;
		Token char_literal96=null;
		Token char_literal98=null;
		Token char_literal99=null;
		Token CLASSID100=null;
		Token string_literal102=null;
		ParserRuleReturnScope formalParam88 =null;
		ParserRuleReturnScope formalParam90 =null;
		ParserRuleReturnScope methodShortLong92 =null;
		ParserRuleReturnScope formalParam95 =null;
		ParserRuleReturnScope formalParam97 =null;
		ParserRuleReturnScope funcCall101 =null;
		ParserRuleReturnScope bloc103 =null;

		Object s_tree=null;
		Object o_tree=null;
		Object ID86_tree=null;
		Object char_literal87_tree=null;
		Object char_literal89_tree=null;
		Object char_literal91_tree=null;
		Object CLASSID93_tree=null;
		Object char_literal94_tree=null;
		Object char_literal96_tree=null;
		Object char_literal98_tree=null;
		Object char_literal99_tree=null;
		Object CLASSID100_tree=null;
		Object string_literal102_tree=null;
		RewriteRuleTokenStream stream_44=new RewriteRuleTokenStream(adaptor,"token 44");
		RewriteRuleTokenStream stream_67=new RewriteRuleTokenStream(adaptor,"token 67");
		RewriteRuleTokenStream stream_47=new RewriteRuleTokenStream(adaptor,"token 47");
		RewriteRuleTokenStream stream_70=new RewriteRuleTokenStream(adaptor,"token 70");
		RewriteRuleTokenStream stream_ID=new RewriteRuleTokenStream(adaptor,"token ID");
		RewriteRuleTokenStream stream_51=new RewriteRuleTokenStream(adaptor,"token 51");
		RewriteRuleTokenStream stream_43=new RewriteRuleTokenStream(adaptor,"token 43");
		RewriteRuleTokenStream stream_65=new RewriteRuleTokenStream(adaptor,"token 65");
		RewriteRuleTokenStream stream_CLASSID=new RewriteRuleTokenStream(adaptor,"token CLASSID");
		RewriteRuleSubtreeStream stream_bloc=new RewriteRuleSubtreeStream(adaptor,"rule bloc");
		RewriteRuleSubtreeStream stream_formalParam=new RewriteRuleSubtreeStream(adaptor,"rule formalParam");
		RewriteRuleSubtreeStream stream_methodShortLong=new RewriteRuleSubtreeStream(adaptor,"rule methodShortLong");
		RewriteRuleSubtreeStream stream_funcCall=new RewriteRuleSubtreeStream(adaptor,"rule funcCall");

		try {
			// Grammaire.g:116:2: ( (s= 'static' )? (o= 'override' )? ID '(' ( formalParam ( ',' formalParam )* )? ')' methodShortLong -> ID ( $s)? ( $o)? ( ^( LIST_PARAM ( formalParam )* ) )? methodShortLong | CLASSID '(' ( formalParam ( ',' formalParam )* )? ')' ( ':' CLASSID funcCall )? 'is' bloc -> CLASSID ( ^( LIST_PARAM ( formalParam )* ) )? ( ^( HERITED CLASSID ( funcCall )* ) )? bloc )
			int alt41=2;
			int LA41_0 = input.LA(1);
			if ( (LA41_0==ID||LA41_0==67||LA41_0==70) ) {
				alt41=1;
			}
			else if ( (LA41_0==CLASSID) ) {
				alt41=2;
			}

			else {
				NoViableAltException nvae =
						new NoViableAltException("", 41, 0, input);
				throw nvae;
			}

			switch (alt41) {
				case 1 :
					// Grammaire.g:116:4: (s= 'static' )? (o= 'override' )? ID '(' ( formalParam ( ',' formalParam )* )? ')' methodShortLong
				{
					// Grammaire.g:116:4: (s= 'static' )?
					int alt34=2;
					int LA34_0 = input.LA(1);
					if ( (LA34_0==70) ) {
						alt34=1;
					}
					switch (alt34) {
						case 1 :
							// Grammaire.g:116:5: s= 'static'
						{
							s=(Token)match(input,70,FOLLOW_70_in_method939);
							stream_70.add(s);

						}
						break;

					}

					// Grammaire.g:116:18: (o= 'override' )?
					int alt35=2;
					int LA35_0 = input.LA(1);
					if ( (LA35_0==67) ) {
						alt35=1;
					}
					switch (alt35) {
						case 1 :
							// Grammaire.g:116:19: o= 'override'
						{
							o=(Token)match(input,67,FOLLOW_67_in_method946);
							stream_67.add(o);

						}
						break;

					}

					ID86=(Token)match(input,ID,FOLLOW_ID_in_method950);
					stream_ID.add(ID86);

					char_literal87=(Token)match(input,43,FOLLOW_43_in_method952);
					stream_43.add(char_literal87);

					// Grammaire.g:116:41: ( formalParam ( ',' formalParam )* )?
					int alt37=2;
					int LA37_0 = input.LA(1);
					if ( (LA37_0==ID||LA37_0==74) ) {
						alt37=1;
					}
					switch (alt37) {
						case 1 :
							// Grammaire.g:116:42: formalParam ( ',' formalParam )*
						{
							pushFollow(FOLLOW_formalParam_in_method955);
							formalParam88=formalParam();
							state._fsp--;

							stream_formalParam.add(formalParam88.getTree());
							// Grammaire.g:116:54: ( ',' formalParam )*
							loop36:
							while (true) {
								int alt36=2;
								int LA36_0 = input.LA(1);
								if ( (LA36_0==47) ) {
									alt36=1;
								}

								switch (alt36) {
									case 1 :
										// Grammaire.g:116:55: ',' formalParam
									{
										char_literal89=(Token)match(input,47,FOLLOW_47_in_method958);
										stream_47.add(char_literal89);

										pushFollow(FOLLOW_formalParam_in_method960);
										formalParam90=formalParam();
										state._fsp--;

										stream_formalParam.add(formalParam90.getTree());
									}
									break;

									default :
										break loop36;
								}
							}

						}
						break;

					}

					char_literal91=(Token)match(input,44,FOLLOW_44_in_method968);
					stream_44.add(char_literal91);

					pushFollow(FOLLOW_methodShortLong_in_method970);
					methodShortLong92=methodShortLong();
					state._fsp--;

					stream_methodShortLong.add(methodShortLong92.getTree());
					// AST REWRITE
					// elements: formalParam, ID, s, o, methodShortLong
					// token labels: s, o
					// rule labels: retval
					// token list labels:
					// rule list labels:
					// wildcard labels:
					retval.tree = root_0;
					RewriteRuleTokenStream stream_s=new RewriteRuleTokenStream(adaptor,"token s",s);
					RewriteRuleTokenStream stream_o=new RewriteRuleTokenStream(adaptor,"token o",o);
					RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.getTree():null);

					root_0 = (Object)adaptor.nil();
					// 116:97: -> ID ( $s)? ( $o)? ( ^( LIST_PARAM ( formalParam )* ) )? methodShortLong
					{
						adaptor.addChild(root_0, stream_ID.nextNode());
						// Grammaire.g:116:104: ( $s)?
						if ( stream_s.hasNext() ) {
							adaptor.addChild(root_0, stream_s.nextNode());
						}
						stream_s.reset();

						// Grammaire.g:116:110: ( $o)?
						if ( stream_o.hasNext() ) {
							adaptor.addChild(root_0, stream_o.nextNode());
						}
						stream_o.reset();

						// Grammaire.g:116:116: ( ^( LIST_PARAM ( formalParam )* ) )?
						if ( stream_formalParam.hasNext() ) {
							// Grammaire.g:116:116: ^( LIST_PARAM ( formalParam )* )
							{
								Object root_1 = (Object)adaptor.nil();
								root_1 = (Object)adaptor.becomeRoot((Object)adaptor.create(LIST_PARAM, "LIST_PARAM"), root_1);
								// Grammaire.g:116:129: ( formalParam )*
								while ( stream_formalParam.hasNext() ) {
									adaptor.addChild(root_1, stream_formalParam.nextTree());
								}
								stream_formalParam.reset();

								adaptor.addChild(root_0, root_1);
							}

						}
						stream_formalParam.reset();

						adaptor.addChild(root_0, stream_methodShortLong.nextTree());
					}


					retval.tree = root_0;

				}
				break;
				case 2 :
					// Grammaire.g:117:4: CLASSID '(' ( formalParam ( ',' formalParam )* )? ')' ( ':' CLASSID funcCall )? 'is' bloc
				{
					CLASSID93=(Token)match(input,CLASSID,FOLLOW_CLASSID_in_method1002);
					stream_CLASSID.add(CLASSID93);

					char_literal94=(Token)match(input,43,FOLLOW_43_in_method1004);
					stream_43.add(char_literal94);

					// Grammaire.g:117:16: ( formalParam ( ',' formalParam )* )?
					int alt39=2;
					int LA39_0 = input.LA(1);
					if ( (LA39_0==ID||LA39_0==74) ) {
						alt39=1;
					}
					switch (alt39) {
						case 1 :
							// Grammaire.g:117:17: formalParam ( ',' formalParam )*
						{
							pushFollow(FOLLOW_formalParam_in_method1007);
							formalParam95=formalParam();
							state._fsp--;

							stream_formalParam.add(formalParam95.getTree());
							// Grammaire.g:117:29: ( ',' formalParam )*
							loop38:
							while (true) {
								int alt38=2;
								int LA38_0 = input.LA(1);
								if ( (LA38_0==47) ) {
									alt38=1;
								}

								switch (alt38) {
									case 1 :
										// Grammaire.g:117:30: ',' formalParam
									{
										char_literal96=(Token)match(input,47,FOLLOW_47_in_method1010);
										stream_47.add(char_literal96);

										pushFollow(FOLLOW_formalParam_in_method1012);
										formalParam97=formalParam();
										state._fsp--;

										stream_formalParam.add(formalParam97.getTree());
									}
									break;

									default :
										break loop38;
								}
							}

						}
						break;

					}

					char_literal98=(Token)match(input,44,FOLLOW_44_in_method1020);
					stream_44.add(char_literal98);

					// Grammaire.g:117:56: ( ':' CLASSID funcCall )?
					int alt40=2;
					int LA40_0 = input.LA(1);
					if ( (LA40_0==51) ) {
						alt40=1;
					}
					switch (alt40) {
						case 1 :
							// Grammaire.g:117:58: ':' CLASSID funcCall
						{
							char_literal99=(Token)match(input,51,FOLLOW_51_in_method1024);
							stream_51.add(char_literal99);

							CLASSID100=(Token)match(input,CLASSID,FOLLOW_CLASSID_in_method1026);
							stream_CLASSID.add(CLASSID100);

							pushFollow(FOLLOW_funcCall_in_method1028);
							funcCall101=funcCall();
							state._fsp--;

							stream_funcCall.add(funcCall101.getTree());
						}
						break;

					}

					string_literal102=(Token)match(input,65,FOLLOW_65_in_method1033);
					stream_65.add(string_literal102);

					pushFollow(FOLLOW_bloc_in_method1035);
					bloc103=bloc();
					state._fsp--;

					stream_bloc.add(bloc103.getTree());
					// AST REWRITE
					// elements: bloc, CLASSID, formalParam, funcCall, CLASSID
					// token labels:
					// rule labels: retval
					// token list labels:
					// rule list labels:
					// wildcard labels:
					retval.tree = root_0;
					RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.getTree():null);

					root_0 = (Object)adaptor.nil();
					// 117:92: -> CLASSID ( ^( LIST_PARAM ( formalParam )* ) )? ( ^( HERITED CLASSID ( funcCall )* ) )? bloc
					{
						adaptor.addChild(root_0, stream_CLASSID.nextNode());
						// Grammaire.g:117:104: ( ^( LIST_PARAM ( formalParam )* ) )?
						if ( stream_formalParam.hasNext() ) {
							// Grammaire.g:117:104: ^( LIST_PARAM ( formalParam )* )
							{
								Object root_1 = (Object)adaptor.nil();
								root_1 = (Object)adaptor.becomeRoot((Object)adaptor.create(LIST_PARAM, "LIST_PARAM"), root_1);
								// Grammaire.g:117:117: ( formalParam )*
								while ( stream_formalParam.hasNext() ) {
									adaptor.addChild(root_1, stream_formalParam.nextTree());
								}
								stream_formalParam.reset();

								adaptor.addChild(root_0, root_1);
							}

						}
						stream_formalParam.reset();

						// Grammaire.g:117:132: ( ^( HERITED CLASSID ( funcCall )* ) )?
						if ( stream_funcCall.hasNext()||stream_CLASSID.hasNext() ) {
							// Grammaire.g:117:132: ^( HERITED CLASSID ( funcCall )* )
							{
								Object root_1 = (Object)adaptor.nil();
								root_1 = (Object)adaptor.becomeRoot((Object)adaptor.create(HERITED, "HERITED"), root_1);
								adaptor.addChild(root_1, stream_CLASSID.nextNode());
								// Grammaire.g:117:150: ( funcCall )*
								while ( stream_funcCall.hasNext() ) {
									adaptor.addChild(root_1, stream_funcCall.nextTree());
								}
								stream_funcCall.reset();

								adaptor.addChild(root_0, root_1);
							}

						}
						stream_funcCall.reset();
						stream_CLASSID.reset();

						adaptor.addChild(root_0, stream_bloc.nextTree());
					}


					retval.tree = root_0;

				}
				break;

			}
			retval.stop = input.LT(-1);

			retval.tree = (Object)adaptor.rulePostProcessing(root_0);
			adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
			retval.tree = (Object)adaptor.errorNode(input, retval.start, input.LT(-1), re);
		}
		finally {
			// do for sure before leaving
		}
		return retval;
	}
	// $ANTLR end "method"


	public static class methodShortLong_return extends ParserRuleReturnScope {
		Object tree;
		@Override
		public Object getTree() { return tree; }
	};


	// $ANTLR start "methodShortLong"
	// Grammaire.g:120:1: methodShortLong : ( ':' CLASSID methodShortLong2 -> CLASSID methodShortLong2 | 'is' bloc -> bloc );
	public final GrammaireParser.methodShortLong_return methodShortLong() throws RecognitionException {
		GrammaireParser.methodShortLong_return retval = new GrammaireParser.methodShortLong_return();
		retval.start = input.LT(1);

		Object root_0 = null;

		Token char_literal104=null;
		Token CLASSID105=null;
		Token string_literal107=null;
		ParserRuleReturnScope methodShortLong2106 =null;
		ParserRuleReturnScope bloc108 =null;

		Object char_literal104_tree=null;
		Object CLASSID105_tree=null;
		Object string_literal107_tree=null;
		RewriteRuleTokenStream stream_51=new RewriteRuleTokenStream(adaptor,"token 51");
		RewriteRuleTokenStream stream_CLASSID=new RewriteRuleTokenStream(adaptor,"token CLASSID");
		RewriteRuleTokenStream stream_65=new RewriteRuleTokenStream(adaptor,"token 65");
		RewriteRuleSubtreeStream stream_bloc=new RewriteRuleSubtreeStream(adaptor,"rule bloc");
		RewriteRuleSubtreeStream stream_methodShortLong2=new RewriteRuleSubtreeStream(adaptor,"rule methodShortLong2");

		try {
			// Grammaire.g:121:2: ( ':' CLASSID methodShortLong2 -> CLASSID methodShortLong2 | 'is' bloc -> bloc )
			int alt42=2;
			int LA42_0 = input.LA(1);
			if ( (LA42_0==51) ) {
				alt42=1;
			}
			else if ( (LA42_0==65) ) {
				alt42=2;
			}

			else {
				NoViableAltException nvae =
						new NoViableAltException("", 42, 0, input);
				throw nvae;
			}

			switch (alt42) {
				case 1 :
					// Grammaire.g:121:4: ':' CLASSID methodShortLong2
				{
					char_literal104=(Token)match(input,51,FOLLOW_51_in_methodShortLong1071);
					stream_51.add(char_literal104);

					CLASSID105=(Token)match(input,CLASSID,FOLLOW_CLASSID_in_methodShortLong1073);
					stream_CLASSID.add(CLASSID105);

					pushFollow(FOLLOW_methodShortLong2_in_methodShortLong1075);
					methodShortLong2106=methodShortLong2();
					state._fsp--;

					stream_methodShortLong2.add(methodShortLong2106.getTree());
					// AST REWRITE
					// elements: methodShortLong2, CLASSID
					// token labels:
					// rule labels: retval
					// token list labels:
					// rule list labels:
					// wildcard labels:
					retval.tree = root_0;
					RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.getTree():null);

					root_0 = (Object)adaptor.nil();
					// 121:33: -> CLASSID methodShortLong2
					{
						adaptor.addChild(root_0, stream_CLASSID.nextNode());
						adaptor.addChild(root_0, stream_methodShortLong2.nextTree());
					}


					retval.tree = root_0;

				}
				break;
				case 2 :
					// Grammaire.g:122:4: 'is' bloc
				{
					string_literal107=(Token)match(input,65,FOLLOW_65_in_methodShortLong1086);
					stream_65.add(string_literal107);

					pushFollow(FOLLOW_bloc_in_methodShortLong1088);
					bloc108=bloc();
					state._fsp--;

					stream_bloc.add(bloc108.getTree());
					// AST REWRITE
					// elements: bloc
					// token labels:
					// rule labels: retval
					// token list labels:
					// rule list labels:
					// wildcard labels:
					retval.tree = root_0;
					RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.getTree():null);

					root_0 = (Object)adaptor.nil();
					// 122:30: -> bloc
					{
						adaptor.addChild(root_0, stream_bloc.nextTree());
					}


					retval.tree = root_0;

				}
				break;

			}
			retval.stop = input.LT(-1);

			retval.tree = (Object)adaptor.rulePostProcessing(root_0);
			adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
			retval.tree = (Object)adaptor.errorNode(input, retval.start, input.LT(-1), re);
		}
		finally {
			// do for sure before leaving
		}
		return retval;
	}
	// $ANTLR end "methodShortLong"


	public static class methodShortLong2_return extends ParserRuleReturnScope {
		Object tree;
		@Override
		public Object getTree() { return tree; }
	};


	// $ANTLR start "methodShortLong2"
	// Grammaire.g:125:1: methodShortLong2 : ( 'is' bloc -> bloc | ':=' expr -> expr );
	public final GrammaireParser.methodShortLong2_return methodShortLong2() throws RecognitionException {
		GrammaireParser.methodShortLong2_return retval = new GrammaireParser.methodShortLong2_return();
		retval.start = input.LT(1);

		Object root_0 = null;

		Token string_literal109=null;
		Token string_literal111=null;
		ParserRuleReturnScope bloc110 =null;
		ParserRuleReturnScope expr112 =null;

		Object string_literal109_tree=null;
		Object string_literal111_tree=null;
		RewriteRuleTokenStream stream_52=new RewriteRuleTokenStream(adaptor,"token 52");
		RewriteRuleTokenStream stream_65=new RewriteRuleTokenStream(adaptor,"token 65");
		RewriteRuleSubtreeStream stream_bloc=new RewriteRuleSubtreeStream(adaptor,"rule bloc");
		RewriteRuleSubtreeStream stream_expr=new RewriteRuleSubtreeStream(adaptor,"rule expr");

		try {
			// Grammaire.g:126:2: ( 'is' bloc -> bloc | ':=' expr -> expr )
			int alt43=2;
			int LA43_0 = input.LA(1);
			if ( (LA43_0==65) ) {
				alt43=1;
			}
			else if ( (LA43_0==52) ) {
				alt43=2;
			}

			else {
				NoViableAltException nvae =
						new NoViableAltException("", 43, 0, input);
				throw nvae;
			}

			switch (alt43) {
				case 1 :
					// Grammaire.g:126:4: 'is' bloc
				{
					string_literal109=(Token)match(input,65,FOLLOW_65_in_methodShortLong21105);
					stream_65.add(string_literal109);

					pushFollow(FOLLOW_bloc_in_methodShortLong21107);
					bloc110=bloc();
					state._fsp--;

					stream_bloc.add(bloc110.getTree());
					// AST REWRITE
					// elements: bloc
					// token labels:
					// rule labels: retval
					// token list labels:
					// rule list labels:
					// wildcard labels:
					retval.tree = root_0;
					RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.getTree():null);

					root_0 = (Object)adaptor.nil();
					// 126:29: -> bloc
					{
						adaptor.addChild(root_0, stream_bloc.nextTree());
					}


					retval.tree = root_0;

				}
				break;
				case 2 :
					// Grammaire.g:127:4: ':=' expr
				{
					string_literal111=(Token)match(input,52,FOLLOW_52_in_methodShortLong21117);
					stream_52.add(string_literal111);

					pushFollow(FOLLOW_expr_in_methodShortLong21119);
					expr112=expr();
					state._fsp--;

					stream_expr.add(expr112.getTree());
					// AST REWRITE
					// elements: expr
					// token labels:
					// rule labels: retval
					// token list labels:
					// rule list labels:
					// wildcard labels:
					retval.tree = root_0;
					RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.getTree():null);

					root_0 = (Object)adaptor.nil();
					// 127:32: -> expr
					{
						adaptor.addChild(root_0, stream_expr.nextTree());
					}


					retval.tree = root_0;

				}
				break;

			}
			retval.stop = input.LT(-1);

			retval.tree = (Object)adaptor.rulePostProcessing(root_0);
			adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
			retval.tree = (Object)adaptor.errorNode(input, retval.start, input.LT(-1), re);
		}
		finally {
			// do for sure before leaving
		}
		return retval;
	}
	// $ANTLR end "methodShortLong2"


	public static class ifStatement_return extends ParserRuleReturnScope {
		Object tree;
		@Override
		public Object getTree() { return tree; }
	};


	// $ANTLR start "ifStatement"
	// Grammaire.g:130:1: ifStatement : 'if' expr 'then' inst1= instruction 'else' inst2= instruction -> ^( IF ^( CONDITION expr ) ^( THEN $inst1) ^( ELSE $inst2) ) ;
	public final GrammaireParser.ifStatement_return ifStatement() throws RecognitionException {
		GrammaireParser.ifStatement_return retval = new GrammaireParser.ifStatement_return();
		retval.start = input.LT(1);

		Object root_0 = null;

		Token string_literal113=null;
		Token string_literal115=null;
		Token string_literal116=null;
		ParserRuleReturnScope inst1 =null;
		ParserRuleReturnScope inst2 =null;
		ParserRuleReturnScope expr114 =null;

		Object string_literal113_tree=null;
		Object string_literal115_tree=null;
		Object string_literal116_tree=null;
		RewriteRuleTokenStream stream_72=new RewriteRuleTokenStream(adaptor,"token 72");
		RewriteRuleTokenStream stream_62=new RewriteRuleTokenStream(adaptor,"token 62");
		RewriteRuleTokenStream stream_64=new RewriteRuleTokenStream(adaptor,"token 64");
		RewriteRuleSubtreeStream stream_instruction=new RewriteRuleSubtreeStream(adaptor,"rule instruction");
		RewriteRuleSubtreeStream stream_expr=new RewriteRuleSubtreeStream(adaptor,"rule expr");

		try {
			// Grammaire.g:131:2: ( 'if' expr 'then' inst1= instruction 'else' inst2= instruction -> ^( IF ^( CONDITION expr ) ^( THEN $inst1) ^( ELSE $inst2) ) )
			// Grammaire.g:131:4: 'if' expr 'then' inst1= instruction 'else' inst2= instruction
			{
				string_literal113=(Token)match(input,64,FOLLOW_64_in_ifStatement1136);
				stream_64.add(string_literal113);

				pushFollow(FOLLOW_expr_in_ifStatement1138);
				expr114=expr();
				state._fsp--;

				stream_expr.add(expr114.getTree());
				string_literal115=(Token)match(input,72,FOLLOW_72_in_ifStatement1140);
				stream_72.add(string_literal115);

				pushFollow(FOLLOW_instruction_in_ifStatement1144);
				inst1=instruction();
				state._fsp--;

				stream_instruction.add(inst1.getTree());
				string_literal116=(Token)match(input,62,FOLLOW_62_in_ifStatement1146);
				stream_62.add(string_literal116);

				pushFollow(FOLLOW_instruction_in_ifStatement1151);
				inst2=instruction();
				state._fsp--;

				stream_instruction.add(inst2.getTree());
				// AST REWRITE
				// elements: inst2, inst1, expr
				// token labels:
				// rule labels: inst1, inst2, retval
				// token list labels:
				// rule list labels:
				// wildcard labels:
				retval.tree = root_0;
				RewriteRuleSubtreeStream stream_inst1=new RewriteRuleSubtreeStream(adaptor,"rule inst1",inst1!=null?inst1.getTree():null);
				RewriteRuleSubtreeStream stream_inst2=new RewriteRuleSubtreeStream(adaptor,"rule inst2",inst2!=null?inst2.getTree():null);
				RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.getTree():null);

				root_0 = (Object)adaptor.nil();
				// 131:65: -> ^( IF ^( CONDITION expr ) ^( THEN $inst1) ^( ELSE $inst2) )
				{
					// Grammaire.g:131:68: ^( IF ^( CONDITION expr ) ^( THEN $inst1) ^( ELSE $inst2) )
					{
						Object root_1 = (Object)adaptor.nil();
						root_1 = (Object)adaptor.becomeRoot((Object)adaptor.create(IF, "IF"), root_1);
						// Grammaire.g:131:73: ^( CONDITION expr )
						{
							Object root_2 = (Object)adaptor.nil();
							root_2 = (Object)adaptor.becomeRoot((Object)adaptor.create(CONDITION, "CONDITION"), root_2);
							adaptor.addChild(root_2, stream_expr.nextTree());
							adaptor.addChild(root_1, root_2);
						}

						// Grammaire.g:131:91: ^( THEN $inst1)
						{
							Object root_2 = (Object)adaptor.nil();
							root_2 = (Object)adaptor.becomeRoot((Object)adaptor.create(THEN, "THEN"), root_2);
							adaptor.addChild(root_2, stream_inst1.nextTree());
							adaptor.addChild(root_1, root_2);
						}

						// Grammaire.g:131:106: ^( ELSE $inst2)
						{
							Object root_2 = (Object)adaptor.nil();
							root_2 = (Object)adaptor.becomeRoot((Object)adaptor.create(ELSE, "ELSE"), root_2);
							adaptor.addChild(root_2, stream_inst2.nextTree());
							adaptor.addChild(root_1, root_2);
						}

						adaptor.addChild(root_0, root_1);
					}

				}


				retval.tree = root_0;

			}

			retval.stop = input.LT(-1);

			retval.tree = (Object)adaptor.rulePostProcessing(root_0);
			adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
			retval.tree = (Object)adaptor.errorNode(input, retval.start, input.LT(-1), re);
		}
		finally {
			// do for sure before leaving
		}
		return retval;
	}
	// $ANTLR end "ifStatement"


	public static class whileStatement_return extends ParserRuleReturnScope {
		Object tree;
		@Override
		public Object getTree() { return tree; }
	};


	// $ANTLR start "whileStatement"
	// Grammaire.g:134:1: whileStatement : 'while' expr 'do' instruction -> ^( WHILE ^( CONDITION expr ) ^( DO instruction ) ) ;
	public final GrammaireParser.whileStatement_return whileStatement() throws RecognitionException {
		GrammaireParser.whileStatement_return retval = new GrammaireParser.whileStatement_return();
		retval.start = input.LT(1);

		Object root_0 = null;

		Token string_literal117=null;
		Token string_literal119=null;
		ParserRuleReturnScope expr118 =null;
		ParserRuleReturnScope instruction120 =null;

		Object string_literal117_tree=null;
		Object string_literal119_tree=null;
		RewriteRuleTokenStream stream_61=new RewriteRuleTokenStream(adaptor,"token 61");
		RewriteRuleTokenStream stream_75=new RewriteRuleTokenStream(adaptor,"token 75");
		RewriteRuleSubtreeStream stream_instruction=new RewriteRuleSubtreeStream(adaptor,"rule instruction");
		RewriteRuleSubtreeStream stream_expr=new RewriteRuleSubtreeStream(adaptor,"rule expr");

		try {
			// Grammaire.g:135:2: ( 'while' expr 'do' instruction -> ^( WHILE ^( CONDITION expr ) ^( DO instruction ) ) )
			// Grammaire.g:135:4: 'while' expr 'do' instruction
			{
				string_literal117=(Token)match(input,75,FOLLOW_75_in_whileStatement1189);
				stream_75.add(string_literal117);

				pushFollow(FOLLOW_expr_in_whileStatement1191);
				expr118=expr();
				state._fsp--;

				stream_expr.add(expr118.getTree());
				string_literal119=(Token)match(input,61,FOLLOW_61_in_whileStatement1193);
				stream_61.add(string_literal119);

				pushFollow(FOLLOW_instruction_in_whileStatement1195);
				instruction120=instruction();
				state._fsp--;

				stream_instruction.add(instruction120.getTree());
				// AST REWRITE
				// elements: expr, instruction
				// token labels:
				// rule labels: retval
				// token list labels:
				// rule list labels:
				// wildcard labels:
				retval.tree = root_0;
				RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.getTree():null);

				root_0 = (Object)adaptor.nil();
				// 135:34: -> ^( WHILE ^( CONDITION expr ) ^( DO instruction ) )
				{
					// Grammaire.g:135:37: ^( WHILE ^( CONDITION expr ) ^( DO instruction ) )
					{
						Object root_1 = (Object)adaptor.nil();
						root_1 = (Object)adaptor.becomeRoot((Object)adaptor.create(WHILE, "WHILE"), root_1);
						// Grammaire.g:135:45: ^( CONDITION expr )
						{
							Object root_2 = (Object)adaptor.nil();
							root_2 = (Object)adaptor.becomeRoot((Object)adaptor.create(CONDITION, "CONDITION"), root_2);
							adaptor.addChild(root_2, stream_expr.nextTree());
							adaptor.addChild(root_1, root_2);
						}

						// Grammaire.g:135:63: ^( DO instruction )
						{
							Object root_2 = (Object)adaptor.nil();
							root_2 = (Object)adaptor.becomeRoot((Object)adaptor.create(DO, "DO"), root_2);
							adaptor.addChild(root_2, stream_instruction.nextTree());
							adaptor.addChild(root_1, root_2);
						}

						adaptor.addChild(root_0, root_1);
					}

				}


				retval.tree = root_0;

			}

			retval.stop = input.LT(-1);

			retval.tree = (Object)adaptor.rulePostProcessing(root_0);
			adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
			retval.tree = (Object)adaptor.errorNode(input, retval.start, input.LT(-1), re);
		}
		finally {
			// do for sure before leaving
		}
		return retval;
	}
	// $ANTLR end "whileStatement"


	public static class firstExprFact_return extends ParserRuleReturnScope {
		Object tree;
		@Override
		public Object getTree() { return tree; }
	};


	// $ANTLR start "firstExprFact"
	// Grammaire.g:139:1: firstExprFact : ( atom0 | string_with_quote ) ;
	public final GrammaireParser.firstExprFact_return firstExprFact() throws RecognitionException {
		GrammaireParser.firstExprFact_return retval = new GrammaireParser.firstExprFact_return();
		retval.start = input.LT(1);

		Object root_0 = null;

		ParserRuleReturnScope atom0121 =null;
		ParserRuleReturnScope string_with_quote122 =null;


		try {
			// Grammaire.g:140:2: ( ( atom0 | string_with_quote ) )
			// Grammaire.g:140:4: ( atom0 | string_with_quote )
			{
				root_0 = (Object)adaptor.nil();


				// Grammaire.g:140:4: ( atom0 | string_with_quote )
				int alt44=2;
				int LA44_0 = input.LA(1);
				if ( (LA44_0==INT||LA44_0==43||LA44_0==66) ) {
					alt44=1;
				}
				else if ( (LA44_0==STR) ) {
					alt44=2;
				}

				else {
					NoViableAltException nvae =
							new NoViableAltException("", 44, 0, input);
					throw nvae;
				}

				switch (alt44) {
					case 1 :
						// Grammaire.g:140:5: atom0
					{
						pushFollow(FOLLOW_atom0_in_firstExprFact1228);
						atom0121=atom0();
						state._fsp--;

						adaptor.addChild(root_0, atom0121.getTree());

					}
					break;
					case 2 :
						// Grammaire.g:140:11: string_with_quote
					{
						pushFollow(FOLLOW_string_with_quote_in_firstExprFact1230);
						string_with_quote122=string_with_quote();
						state._fsp--;

						adaptor.addChild(root_0, string_with_quote122.getTree());

					}
					break;

				}

			}

			retval.stop = input.LT(-1);

			retval.tree = (Object)adaptor.rulePostProcessing(root_0);
			adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
			retval.tree = (Object)adaptor.errorNode(input, retval.start, input.LT(-1), re);
		}
		finally {
			// do for sure before leaving
		}
		return retval;
	}
	// $ANTLR end "firstExprFact"


	public static class expr_return extends ParserRuleReturnScope {
		Object tree;
		@Override
		public Object getTree() { return tree; }
	};


	// $ANTLR start "expr"
	// Grammaire.g:143:1: expr : condExpr ;
	public final GrammaireParser.expr_return expr() throws RecognitionException {
		GrammaireParser.expr_return retval = new GrammaireParser.expr_return();
		retval.start = input.LT(1);

		Object root_0 = null;

		ParserRuleReturnScope condExpr123 =null;


		try {
			// Grammaire.g:144:2: ( condExpr )
			// Grammaire.g:144:4: condExpr
			{
				root_0 = (Object)adaptor.nil();


				pushFollow(FOLLOW_condExpr_in_expr1242);
				condExpr123=condExpr();
				state._fsp--;

				adaptor.addChild(root_0, condExpr123.getTree());

			}

			retval.stop = input.LT(-1);

			retval.tree = (Object)adaptor.rulePostProcessing(root_0);
			adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
			retval.tree = (Object)adaptor.errorNode(input, retval.start, input.LT(-1), re);
		}
		finally {
			// do for sure before leaving
		}
		return retval;
	}
	// $ANTLR end "expr"


	public static class condExpr_return extends ParserRuleReturnScope {
		Object tree;
		@Override
		public Object getTree() { return tree; }
	};


	// $ANTLR start "condExpr"
	// Grammaire.g:147:1: condExpr : expr1 ( operatorLog ^ expr1 )* ;
	public final GrammaireParser.condExpr_return condExpr() throws RecognitionException {
		GrammaireParser.condExpr_return retval = new GrammaireParser.condExpr_return();
		retval.start = input.LT(1);

		Object root_0 = null;

		ParserRuleReturnScope expr1124 =null;
		ParserRuleReturnScope operatorLog125 =null;
		ParserRuleReturnScope expr1126 =null;


		try {
			// Grammaire.g:148:2: ( expr1 ( operatorLog ^ expr1 )* )
			// Grammaire.g:148:4: expr1 ( operatorLog ^ expr1 )*
			{
				root_0 = (Object)adaptor.nil();


				pushFollow(FOLLOW_expr1_in_condExpr1253);
				expr1124=expr1();
				state._fsp--;

				adaptor.addChild(root_0, expr1124.getTree());

				// Grammaire.g:148:10: ( operatorLog ^ expr1 )*
				loop45:
				while (true) {
					int alt45=2;
					int LA45_0 = input.LA(1);
					if ( ((LA45_0 >= 41 && LA45_0 <= 42)||LA45_0==77) ) {
						alt45=1;
					}

					switch (alt45) {
						case 1 :
							// Grammaire.g:148:11: operatorLog ^ expr1
						{
							pushFollow(FOLLOW_operatorLog_in_condExpr1256);
							operatorLog125=operatorLog();
							state._fsp--;

							root_0 = (Object)adaptor.becomeRoot(operatorLog125.getTree(), root_0);
							pushFollow(FOLLOW_expr1_in_condExpr1259);
							expr1126=expr1();
							state._fsp--;

							adaptor.addChild(root_0, expr1126.getTree());

						}
						break;

						default :
							break loop45;
					}
				}

			}

			retval.stop = input.LT(-1);

			retval.tree = (Object)adaptor.rulePostProcessing(root_0);
			adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
			retval.tree = (Object)adaptor.errorNode(input, retval.start, input.LT(-1), re);
		}
		finally {
			// do for sure before leaving
		}
		return retval;
	}
	// $ANTLR end "condExpr"


	public static class expr1_return extends ParserRuleReturnScope {
		Object tree;
		@Override
		public Object getTree() { return tree; }
	};


	// $ANTLR start "expr1"
	// Grammaire.g:150:1: expr1 : expr2 ( operatorComp ^ expr2 )* ;
	public final GrammaireParser.expr1_return expr1() throws RecognitionException {
		GrammaireParser.expr1_return retval = new GrammaireParser.expr1_return();
		retval.start = input.LT(1);

		Object root_0 = null;

		ParserRuleReturnScope expr2127 =null;
		ParserRuleReturnScope operatorComp128 =null;
		ParserRuleReturnScope expr2129 =null;


		try {
			// Grammaire.g:151:2: ( expr2 ( operatorComp ^ expr2 )* )
			// Grammaire.g:151:4: expr2 ( operatorComp ^ expr2 )*
			{
				root_0 = (Object)adaptor.nil();


				pushFollow(FOLLOW_expr2_in_expr11271);
				expr2127=expr2();
				state._fsp--;

				adaptor.addChild(root_0, expr2127.getTree());

				// Grammaire.g:151:10: ( operatorComp ^ expr2 )*
				loop46:
				while (true) {
					int alt46=2;
					int LA46_0 = input.LA(1);
					if ( ((LA46_0 >= 54 && LA46_0 <= 57)) ) {
						alt46=1;
					}

					switch (alt46) {
						case 1 :
							// Grammaire.g:151:11: operatorComp ^ expr2
						{
							pushFollow(FOLLOW_operatorComp_in_expr11274);
							operatorComp128=operatorComp();
							state._fsp--;

							root_0 = (Object)adaptor.becomeRoot(operatorComp128.getTree(), root_0);
							pushFollow(FOLLOW_expr2_in_expr11277);
							expr2129=expr2();
							state._fsp--;

							adaptor.addChild(root_0, expr2129.getTree());

						}
						break;

						default :
							break loop46;
					}
				}

			}

			retval.stop = input.LT(-1);

			retval.tree = (Object)adaptor.rulePostProcessing(root_0);
			adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
			retval.tree = (Object)adaptor.errorNode(input, retval.start, input.LT(-1), re);
		}
		finally {
			// do for sure before leaving
		}
		return retval;
	}
	// $ANTLR end "expr1"


	public static class expr2_return extends ParserRuleReturnScope {
		Object tree;
		@Override
		public Object getTree() { return tree; }
	};


	// $ANTLR start "expr2"
	// Grammaire.g:153:1: expr2 : expr3 ( operatorPM ^ expr3 )* ;
	public final GrammaireParser.expr2_return expr2() throws RecognitionException {
		GrammaireParser.expr2_return retval = new GrammaireParser.expr2_return();
		retval.start = input.LT(1);

		Object root_0 = null;

		ParserRuleReturnScope expr3130 =null;
		ParserRuleReturnScope operatorPM131 =null;
		ParserRuleReturnScope expr3132 =null;


		try {
			// Grammaire.g:154:2: ( expr3 ( operatorPM ^ expr3 )* )
			// Grammaire.g:154:4: expr3 ( operatorPM ^ expr3 )*
			{
				root_0 = (Object)adaptor.nil();


				pushFollow(FOLLOW_expr3_in_expr21289);
				expr3130=expr3();
				state._fsp--;

				adaptor.addChild(root_0, expr3130.getTree());

				// Grammaire.g:154:10: ( operatorPM ^ expr3 )*
				loop47:
				while (true) {
					int alt47=2;
					int LA47_0 = input.LA(1);
					if ( (LA47_0==46||LA47_0==48) ) {
						alt47=1;
					}

					switch (alt47) {
						case 1 :
							// Grammaire.g:154:11: operatorPM ^ expr3
						{
							pushFollow(FOLLOW_operatorPM_in_expr21292);
							operatorPM131=operatorPM();
							state._fsp--;

							root_0 = (Object)adaptor.becomeRoot(operatorPM131.getTree(), root_0);
							pushFollow(FOLLOW_expr3_in_expr21295);
							expr3132=expr3();
							state._fsp--;

							adaptor.addChild(root_0, expr3132.getTree());

						}
						break;

						default :
							break loop47;
					}
				}

			}

			retval.stop = input.LT(-1);

			retval.tree = (Object)adaptor.rulePostProcessing(root_0);
			adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
			retval.tree = (Object)adaptor.errorNode(input, retval.start, input.LT(-1), re);
		}
		finally {
			// do for sure before leaving
		}
		return retval;
	}
	// $ANTLR end "expr2"


	public static class expr3_return extends ParserRuleReturnScope {
		Object tree;
		@Override
		public Object getTree() { return tree; }
	};


	// $ANTLR start "expr3"
	// Grammaire.g:157:1: expr3 : atom1 ( operatorMD ^ atom1 )* ;
	public final GrammaireParser.expr3_return expr3() throws RecognitionException {
		GrammaireParser.expr3_return retval = new GrammaireParser.expr3_return();
		retval.start = input.LT(1);

		Object root_0 = null;

		ParserRuleReturnScope atom1133 =null;
		ParserRuleReturnScope operatorMD134 =null;
		ParserRuleReturnScope atom1135 =null;


		try {
			// Grammaire.g:158:2: ( atom1 ( operatorMD ^ atom1 )* )
			// Grammaire.g:158:4: atom1 ( operatorMD ^ atom1 )*
			{
				root_0 = (Object)adaptor.nil();


				pushFollow(FOLLOW_atom1_in_expr31308);
				atom1133=atom1();
				state._fsp--;

				adaptor.addChild(root_0, atom1133.getTree());

				// Grammaire.g:158:10: ( operatorMD ^ atom1 )*
				loop48:
				while (true) {
					int alt48=2;
					int LA48_0 = input.LA(1);
					if ( (LA48_0==45||LA48_0==50) ) {
						alt48=1;
					}

					switch (alt48) {
						case 1 :
							// Grammaire.g:158:11: operatorMD ^ atom1
						{
							pushFollow(FOLLOW_operatorMD_in_expr31311);
							operatorMD134=operatorMD();
							state._fsp--;

							root_0 = (Object)adaptor.becomeRoot(operatorMD134.getTree(), root_0);
							pushFollow(FOLLOW_atom1_in_expr31314);
							atom1135=atom1();
							state._fsp--;

							adaptor.addChild(root_0, atom1135.getTree());

						}
						break;

						default :
							break loop48;
					}
				}

			}

			retval.stop = input.LT(-1);

			retval.tree = (Object)adaptor.rulePostProcessing(root_0);
			adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
			retval.tree = (Object)adaptor.errorNode(input, retval.start, input.LT(-1), re);
		}
		finally {
			// do for sure before leaving
		}
		return retval;
	}
	// $ANTLR end "expr3"


	public static class atom0_return extends ParserRuleReturnScope {
		Object tree;
		@Override
		public Object getTree() { return tree; }
	};


	// $ANTLR start "atom0"
	// Grammaire.g:161:1: atom0 : ( INT | ( '(' atomStartWithParenthesis -> ^( GROUP atomStartWithParenthesis ) ) ( message -> ^( GROUP ^( MESSAGE atomStartWithParenthesis message ) ) )? | 'new' CLASSID funcCall -> ^( NEW CLASSID funcCall ) );
	public final GrammaireParser.atom0_return atom0() throws RecognitionException {
		GrammaireParser.atom0_return retval = new GrammaireParser.atom0_return();
		retval.start = input.LT(1);

		Object root_0 = null;

		Token INT136=null;
		Token char_literal137=null;
		Token string_literal140=null;
		Token CLASSID141=null;
		ParserRuleReturnScope atomStartWithParenthesis138 =null;
		ParserRuleReturnScope message139 =null;
		ParserRuleReturnScope funcCall142 =null;

		Object INT136_tree=null;
		Object char_literal137_tree=null;
		Object string_literal140_tree=null;
		Object CLASSID141_tree=null;
		RewriteRuleTokenStream stream_66=new RewriteRuleTokenStream(adaptor,"token 66");
		RewriteRuleTokenStream stream_43=new RewriteRuleTokenStream(adaptor,"token 43");
		RewriteRuleTokenStream stream_CLASSID=new RewriteRuleTokenStream(adaptor,"token CLASSID");
		RewriteRuleSubtreeStream stream_atomStartWithParenthesis=new RewriteRuleSubtreeStream(adaptor,"rule atomStartWithParenthesis");
		RewriteRuleSubtreeStream stream_funcCall=new RewriteRuleSubtreeStream(adaptor,"rule funcCall");
		RewriteRuleSubtreeStream stream_message=new RewriteRuleSubtreeStream(adaptor,"rule message");

		try {
			// Grammaire.g:162:2: ( INT | ( '(' atomStartWithParenthesis -> ^( GROUP atomStartWithParenthesis ) ) ( message -> ^( GROUP ^( MESSAGE atomStartWithParenthesis message ) ) )? | 'new' CLASSID funcCall -> ^( NEW CLASSID funcCall ) )
			int alt50=3;
			switch ( input.LA(1) ) {
				case INT:
				{
					alt50=1;
				}
				break;
				case 43:
				{
					alt50=2;
				}
				break;
				case 66:
				{
					alt50=3;
				}
				break;
				default:
					NoViableAltException nvae =
							new NoViableAltException("", 50, 0, input);
					throw nvae;
			}
			switch (alt50) {
				case 1 :
					// Grammaire.g:162:5: INT
				{
					root_0 = (Object)adaptor.nil();


					INT136=(Token)match(input,INT,FOLLOW_INT_in_atom01327);
					INT136_tree = (Object)adaptor.create(INT136);
					adaptor.addChild(root_0, INT136_tree);

				}
				break;
				case 2 :
					// Grammaire.g:163:4: ( '(' atomStartWithParenthesis -> ^( GROUP atomStartWithParenthesis ) ) ( message -> ^( GROUP ^( MESSAGE atomStartWithParenthesis message ) ) )?
				{
					// Grammaire.g:163:4: ( '(' atomStartWithParenthesis -> ^( GROUP atomStartWithParenthesis ) )
					// Grammaire.g:163:5: '(' atomStartWithParenthesis
					{
						char_literal137=(Token)match(input,43,FOLLOW_43_in_atom01333);
						stream_43.add(char_literal137);

						pushFollow(FOLLOW_atomStartWithParenthesis_in_atom01335);
						atomStartWithParenthesis138=atomStartWithParenthesis();
						state._fsp--;

						stream_atomStartWithParenthesis.add(atomStartWithParenthesis138.getTree());
						// AST REWRITE
						// elements: atomStartWithParenthesis
						// token labels:
						// rule labels: retval
						// token list labels:
						// rule list labels:
						// wildcard labels:
						retval.tree = root_0;
						RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.getTree():null);

						root_0 = (Object)adaptor.nil();
						// 163:34: -> ^( GROUP atomStartWithParenthesis )
						{
							// Grammaire.g:163:37: ^( GROUP atomStartWithParenthesis )
							{
								Object root_1 = (Object)adaptor.nil();
								root_1 = (Object)adaptor.becomeRoot((Object)adaptor.create(GROUP, "GROUP"), root_1);
								adaptor.addChild(root_1, stream_atomStartWithParenthesis.nextTree());
								adaptor.addChild(root_0, root_1);
							}

						}


						retval.tree = root_0;

					}

					// Grammaire.g:163:72: ( message -> ^( GROUP ^( MESSAGE atomStartWithParenthesis message ) ) )?
					int alt49=2;
					int LA49_0 = input.LA(1);
					if ( (LA49_0==49) ) {
						alt49=1;
					}
					switch (alt49) {
						case 1 :
							// Grammaire.g:163:73: message
						{
							pushFollow(FOLLOW_message_in_atom01347);
							message139=message();
							state._fsp--;

							stream_message.add(message139.getTree());
							// AST REWRITE
							// elements: message, atomStartWithParenthesis
							// token labels:
							// rule labels: retval
							// token list labels:
							// rule list labels:
							// wildcard labels:
							retval.tree = root_0;
							RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.getTree():null);

							root_0 = (Object)adaptor.nil();
							// 163:81: -> ^( GROUP ^( MESSAGE atomStartWithParenthesis message ) )
							{
								// Grammaire.g:163:84: ^( GROUP ^( MESSAGE atomStartWithParenthesis message ) )
								{
									Object root_1 = (Object)adaptor.nil();
									root_1 = (Object)adaptor.becomeRoot((Object)adaptor.create(GROUP, "GROUP"), root_1);
									// Grammaire.g:163:92: ^( MESSAGE atomStartWithParenthesis message )
									{
										Object root_2 = (Object)adaptor.nil();
										root_2 = (Object)adaptor.becomeRoot((Object)adaptor.create(MESSAGE, "MESSAGE"), root_2);
										adaptor.addChild(root_2, stream_atomStartWithParenthesis.nextTree());
										adaptor.addChild(root_2, stream_message.nextTree());
										adaptor.addChild(root_1, root_2);
									}

									adaptor.addChild(root_0, root_1);
								}

							}


							retval.tree = root_0;

						}
						break;

					}

				}
				break;
				case 3 :
					// Grammaire.g:164:5: 'new' CLASSID funcCall
				{
					string_literal140=(Token)match(input,66,FOLLOW_66_in_atom01369);
					stream_66.add(string_literal140);

					CLASSID141=(Token)match(input,CLASSID,FOLLOW_CLASSID_in_atom01371);
					stream_CLASSID.add(CLASSID141);

					pushFollow(FOLLOW_funcCall_in_atom01373);
					funcCall142=funcCall();
					state._fsp--;

					stream_funcCall.add(funcCall142.getTree());
					// AST REWRITE
					// elements: CLASSID, funcCall
					// token labels:
					// rule labels: retval
					// token list labels:
					// rule list labels:
					// wildcard labels:
					retval.tree = root_0;
					RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.getTree():null);

					root_0 = (Object)adaptor.nil();
					// 164:28: -> ^( NEW CLASSID funcCall )
					{
						// Grammaire.g:164:31: ^( NEW CLASSID funcCall )
						{
							Object root_1 = (Object)adaptor.nil();
							root_1 = (Object)adaptor.becomeRoot((Object)adaptor.create(NEW, "NEW"), root_1);
							adaptor.addChild(root_1, stream_CLASSID.nextNode());
							adaptor.addChild(root_1, stream_funcCall.nextTree());
							adaptor.addChild(root_0, root_1);
						}

					}


					retval.tree = root_0;

				}
				break;

			}
			retval.stop = input.LT(-1);

			retval.tree = (Object)adaptor.rulePostProcessing(root_0);
			adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
			retval.tree = (Object)adaptor.errorNode(input, retval.start, input.LT(-1), re);
		}
		finally {
			// do for sure before leaving
		}
		return retval;
	}
	// $ANTLR end "atom0"


	public static class atom1_return extends ParserRuleReturnScope {
		Object tree;
		@Override
		public Object getTree() { return tree; }
	};


	// $ANTLR start "atom1"
	// Grammaire.g:167:1: atom1 : ( '+' atom2 -> ^( PLUS_UNAIRE atom2 ) | string_with_quote | '-' atom2 -> ^( MOINS_UNAIRE atom2 ) | atom2 );
	public final GrammaireParser.atom1_return atom1() throws RecognitionException {
		GrammaireParser.atom1_return retval = new GrammaireParser.atom1_return();
		retval.start = input.LT(1);

		Object root_0 = null;

		Token char_literal143=null;
		Token char_literal146=null;
		ParserRuleReturnScope atom2144 =null;
		ParserRuleReturnScope string_with_quote145 =null;
		ParserRuleReturnScope atom2147 =null;
		ParserRuleReturnScope atom2148 =null;

		Object char_literal143_tree=null;
		Object char_literal146_tree=null;
		RewriteRuleTokenStream stream_46=new RewriteRuleTokenStream(adaptor,"token 46");
		RewriteRuleTokenStream stream_48=new RewriteRuleTokenStream(adaptor,"token 48");
		RewriteRuleSubtreeStream stream_atom2=new RewriteRuleSubtreeStream(adaptor,"rule atom2");

		try {
			// Grammaire.g:168:2: ( '+' atom2 -> ^( PLUS_UNAIRE atom2 ) | string_with_quote | '-' atom2 -> ^( MOINS_UNAIRE atom2 ) | atom2 )
			int alt51=4;
			switch ( input.LA(1) ) {
				case 46:
				{
					alt51=1;
				}
				break;
				case STR:
				{
					alt51=2;
				}
				break;
				case 48:
				{
					alt51=3;
				}
				break;
				case CLASSID:
				case ID:
				case INT:
				case 43:
				case 66:
				case 68:
				case 71:
				case 73:
				{
					alt51=4;
				}
				break;
				default:
					NoViableAltException nvae =
							new NoViableAltException("", 51, 0, input);
					throw nvae;
			}
			switch (alt51) {
				case 1 :
					// Grammaire.g:168:4: '+' atom2
				{
					char_literal143=(Token)match(input,46,FOLLOW_46_in_atom11394);
					stream_46.add(char_literal143);

					pushFollow(FOLLOW_atom2_in_atom11396);
					atom2144=atom2();
					state._fsp--;

					stream_atom2.add(atom2144.getTree());
					// AST REWRITE
					// elements: atom2
					// token labels:
					// rule labels: retval
					// token list labels:
					// rule list labels:
					// wildcard labels:
					retval.tree = root_0;
					RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.getTree():null);

					root_0 = (Object)adaptor.nil();
					// 168:14: -> ^( PLUS_UNAIRE atom2 )
					{
						// Grammaire.g:168:17: ^( PLUS_UNAIRE atom2 )
						{
							Object root_1 = (Object)adaptor.nil();
							root_1 = (Object)adaptor.becomeRoot((Object)adaptor.create(PLUS_UNAIRE, "PLUS_UNAIRE"), root_1);
							adaptor.addChild(root_1, stream_atom2.nextTree());
							adaptor.addChild(root_0, root_1);
						}

					}


					retval.tree = root_0;

				}
				break;
				case 2 :
					// Grammaire.g:169:4: string_with_quote
				{
					root_0 = (Object)adaptor.nil();


					pushFollow(FOLLOW_string_with_quote_in_atom11409);
					string_with_quote145=string_with_quote();
					state._fsp--;

					adaptor.addChild(root_0, string_with_quote145.getTree());

				}
				break;
				case 3 :
					// Grammaire.g:170:4: '-' atom2
				{
					char_literal146=(Token)match(input,48,FOLLOW_48_in_atom11414);
					stream_48.add(char_literal146);

					pushFollow(FOLLOW_atom2_in_atom11416);
					atom2147=atom2();
					state._fsp--;

					stream_atom2.add(atom2147.getTree());
					// AST REWRITE
					// elements: atom2
					// token labels:
					// rule labels: retval
					// token list labels:
					// rule list labels:
					// wildcard labels:
					retval.tree = root_0;
					RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.getTree():null);

					root_0 = (Object)adaptor.nil();
					// 170:14: -> ^( MOINS_UNAIRE atom2 )
					{
						// Grammaire.g:170:17: ^( MOINS_UNAIRE atom2 )
						{
							Object root_1 = (Object)adaptor.nil();
							root_1 = (Object)adaptor.becomeRoot((Object)adaptor.create(MOINS_UNAIRE, "MOINS_UNAIRE"), root_1);
							adaptor.addChild(root_1, stream_atom2.nextTree());
							adaptor.addChild(root_0, root_1);
						}

					}


					retval.tree = root_0;

				}
				break;
				case 4 :
					// Grammaire.g:171:4: atom2
				{
					root_0 = (Object)adaptor.nil();


					pushFollow(FOLLOW_atom2_in_atom11429);
					atom2148=atom2();
					state._fsp--;

					adaptor.addChild(root_0, atom2148.getTree());

				}
				break;

			}
			retval.stop = input.LT(-1);

			retval.tree = (Object)adaptor.rulePostProcessing(root_0);
			adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
			retval.tree = (Object)adaptor.errorNode(input, retval.start, input.LT(-1), re);
		}
		finally {
			// do for sure before leaving
		}
		return retval;
	}
	// $ANTLR end "atom1"


	public static class atom2_return extends ParserRuleReturnScope {
		Object tree;
		@Override
		public Object getTree() { return tree; }
	};


	// $ANTLR start "atom2"
	// Grammaire.g:174:1: atom2 : ( atom0 | identificateur_bloc | (id= ID -> ^( VARIABLE $id) ) (m= message -> ^( MESSAGE ^( VARIABLE $id) $m) )? );
	public final GrammaireParser.atom2_return atom2() throws RecognitionException {
		GrammaireParser.atom2_return retval = new GrammaireParser.atom2_return();
		retval.start = input.LT(1);

		Object root_0 = null;

		Token id=null;
		ParserRuleReturnScope m =null;
		ParserRuleReturnScope atom0149 =null;
		ParserRuleReturnScope identificateur_bloc150 =null;

		Object id_tree=null;
		RewriteRuleTokenStream stream_ID=new RewriteRuleTokenStream(adaptor,"token ID");
		RewriteRuleSubtreeStream stream_message=new RewriteRuleSubtreeStream(adaptor,"rule message");

		try {
			// Grammaire.g:175:2: ( atom0 | identificateur_bloc | (id= ID -> ^( VARIABLE $id) ) (m= message -> ^( MESSAGE ^( VARIABLE $id) $m) )? )
			int alt53=3;
			switch ( input.LA(1) ) {
				case INT:
				case 43:
				case 66:
				{
					alt53=1;
				}
				break;
				case CLASSID:
				case 68:
				case 71:
				case 73:
				{
					alt53=2;
				}
				break;
				case ID:
				{
					alt53=3;
				}
				break;
				default:
					NoViableAltException nvae =
							new NoViableAltException("", 53, 0, input);
					throw nvae;
			}
			switch (alt53) {
				case 1 :
					// Grammaire.g:175:4: atom0
				{
					root_0 = (Object)adaptor.nil();


					pushFollow(FOLLOW_atom0_in_atom21440);
					atom0149=atom0();
					state._fsp--;

					adaptor.addChild(root_0, atom0149.getTree());

				}
				break;
				case 2 :
					// Grammaire.g:176:4: identificateur_bloc
				{
					root_0 = (Object)adaptor.nil();


					pushFollow(FOLLOW_identificateur_bloc_in_atom21445);
					identificateur_bloc150=identificateur_bloc();
					state._fsp--;

					adaptor.addChild(root_0, identificateur_bloc150.getTree());

				}
				break;
				case 3 :
					// Grammaire.g:178:4: (id= ID -> ^( VARIABLE $id) ) (m= message -> ^( MESSAGE ^( VARIABLE $id) $m) )?
				{
					// Grammaire.g:178:4: (id= ID -> ^( VARIABLE $id) )
					// Grammaire.g:178:5: id= ID
					{
						id=(Token)match(input,ID,FOLLOW_ID_in_atom21455);
						stream_ID.add(id);

						// AST REWRITE
						// elements: id
						// token labels: id
						// rule labels: retval
						// token list labels:
						// rule list labels:
						// wildcard labels:
						retval.tree = root_0;
						RewriteRuleTokenStream stream_id=new RewriteRuleTokenStream(adaptor,"token id",id);
						RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.getTree():null);

						root_0 = (Object)adaptor.nil();
						// 178:11: -> ^( VARIABLE $id)
						{
							// Grammaire.g:178:14: ^( VARIABLE $id)
							{
								Object root_1 = (Object)adaptor.nil();
								root_1 = (Object)adaptor.becomeRoot((Object)adaptor.create(VARIABLE, "VARIABLE"), root_1);
								adaptor.addChild(root_1, stream_id.nextNode());
								adaptor.addChild(root_0, root_1);
							}

						}


						retval.tree = root_0;

					}

					// Grammaire.g:178:31: (m= message -> ^( MESSAGE ^( VARIABLE $id) $m) )?
					int alt52=2;
					int LA52_0 = input.LA(1);
					if ( (LA52_0==49) ) {
						alt52=1;
					}
					switch (alt52) {
						case 1 :
							// Grammaire.g:178:32: m= message
						{
							pushFollow(FOLLOW_message_in_atom21470);
							m=message();
							state._fsp--;

							stream_message.add(m.getTree());
							// AST REWRITE
							// elements: id, m
							// token labels: id
							// rule labels: m, retval
							// token list labels:
							// rule list labels:
							// wildcard labels:
							retval.tree = root_0;
							RewriteRuleTokenStream stream_id=new RewriteRuleTokenStream(adaptor,"token id",id);
							RewriteRuleSubtreeStream stream_m=new RewriteRuleSubtreeStream(adaptor,"rule m",m!=null?m.getTree():null);
							RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.getTree():null);

							root_0 = (Object)adaptor.nil();
							// 178:42: -> ^( MESSAGE ^( VARIABLE $id) $m)
							{
								// Grammaire.g:178:46: ^( MESSAGE ^( VARIABLE $id) $m)
								{
									Object root_1 = (Object)adaptor.nil();
									root_1 = (Object)adaptor.becomeRoot((Object)adaptor.create(MESSAGE, "MESSAGE"), root_1);
									// Grammaire.g:178:56: ^( VARIABLE $id)
									{
										Object root_2 = (Object)adaptor.nil();
										root_2 = (Object)adaptor.becomeRoot((Object)adaptor.create(VARIABLE, "VARIABLE"), root_2);
										adaptor.addChild(root_2, stream_id.nextNode());
										adaptor.addChild(root_1, root_2);
									}

									adaptor.addChild(root_1, stream_m.nextTree());
									adaptor.addChild(root_0, root_1);
								}

							}


							retval.tree = root_0;

						}
						break;

					}

				}
				break;

			}
			retval.stop = input.LT(-1);

			retval.tree = (Object)adaptor.rulePostProcessing(root_0);
			adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
			retval.tree = (Object)adaptor.errorNode(input, retval.start, input.LT(-1), re);
		}
		finally {
			// do for sure before leaving
		}
		return retval;
	}
	// $ANTLR end "atom2"


	public static class string_with_quote_return extends ParserRuleReturnScope {
		Object tree;
		@Override
		public Object getTree() { return tree; }
	};


	// $ANTLR start "string_with_quote"
	// Grammaire.g:181:1: string_with_quote : string ( message_unitaire )? -> ^( STRING string ( message_unitaire )? ) ;
	public final GrammaireParser.string_with_quote_return string_with_quote() throws RecognitionException {
		GrammaireParser.string_with_quote_return retval = new GrammaireParser.string_with_quote_return();
		retval.start = input.LT(1);

		Object root_0 = null;

		ParserRuleReturnScope string151 =null;
		ParserRuleReturnScope message_unitaire152 =null;

		RewriteRuleSubtreeStream stream_string=new RewriteRuleSubtreeStream(adaptor,"rule string");
		RewriteRuleSubtreeStream stream_message_unitaire=new RewriteRuleSubtreeStream(adaptor,"rule message_unitaire");

		try {
			// Grammaire.g:182:2: ( string ( message_unitaire )? -> ^( STRING string ( message_unitaire )? ) )
			// Grammaire.g:182:4: string ( message_unitaire )?
			{
				pushFollow(FOLLOW_string_in_string_with_quote1500);
				string151=string();
				state._fsp--;

				stream_string.add(string151.getTree());
				// Grammaire.g:182:11: ( message_unitaire )?
				int alt54=2;
				int LA54_0 = input.LA(1);
				if ( (LA54_0==49) ) {
					alt54=1;
				}
				switch (alt54) {
					case 1 :
						// Grammaire.g:182:11: message_unitaire
					{
						pushFollow(FOLLOW_message_unitaire_in_string_with_quote1502);
						message_unitaire152=message_unitaire();
						state._fsp--;

						stream_message_unitaire.add(message_unitaire152.getTree());
					}
					break;

				}

				// AST REWRITE
				// elements: string, message_unitaire
				// token labels:
				// rule labels: retval
				// token list labels:
				// rule list labels:
				// wildcard labels:
				retval.tree = root_0;
				RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.getTree():null);

				root_0 = (Object)adaptor.nil();
				// 182:29: -> ^( STRING string ( message_unitaire )? )
				{
					// Grammaire.g:182:32: ^( STRING string ( message_unitaire )? )
					{
						Object root_1 = (Object)adaptor.nil();
						root_1 = (Object)adaptor.becomeRoot((Object)adaptor.create(STRING, "STRING"), root_1);
						adaptor.addChild(root_1, stream_string.nextTree());
						// Grammaire.g:182:48: ( message_unitaire )?
						if ( stream_message_unitaire.hasNext() ) {
							adaptor.addChild(root_1, stream_message_unitaire.nextTree());
						}
						stream_message_unitaire.reset();

						adaptor.addChild(root_0, root_1);
					}

				}


				retval.tree = root_0;

			}

			retval.stop = input.LT(-1);

			retval.tree = (Object)adaptor.rulePostProcessing(root_0);
			adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
			retval.tree = (Object)adaptor.errorNode(input, retval.start, input.LT(-1), re);
		}
		finally {
			// do for sure before leaving
		}
		return retval;
	}
	// $ANTLR end "string_with_quote"


	public static class atomStartWithParenthesis_return extends ParserRuleReturnScope {
		Object tree;
		@Override
		public Object getTree() { return tree; }
	};


	// $ANTLR start "atomStartWithParenthesis"
	// Grammaire.g:185:1: atomStartWithParenthesis : ( 'as' CLASSID ':' expr ')' -> ^( CAST CLASSID expr ) | expr ')' -> expr );
	public final GrammaireParser.atomStartWithParenthesis_return atomStartWithParenthesis() throws RecognitionException {
		GrammaireParser.atomStartWithParenthesis_return retval = new GrammaireParser.atomStartWithParenthesis_return();
		retval.start = input.LT(1);

		Object root_0 = null;

		Token string_literal153=null;
		Token CLASSID154=null;
		Token char_literal155=null;
		Token char_literal157=null;
		Token char_literal159=null;
		ParserRuleReturnScope expr156 =null;
		ParserRuleReturnScope expr158 =null;

		Object string_literal153_tree=null;
		Object CLASSID154_tree=null;
		Object char_literal155_tree=null;
		Object char_literal157_tree=null;
		Object char_literal159_tree=null;
		RewriteRuleTokenStream stream_44=new RewriteRuleTokenStream(adaptor,"token 44");
		RewriteRuleTokenStream stream_58=new RewriteRuleTokenStream(adaptor,"token 58");
		RewriteRuleTokenStream stream_51=new RewriteRuleTokenStream(adaptor,"token 51");
		RewriteRuleTokenStream stream_CLASSID=new RewriteRuleTokenStream(adaptor,"token CLASSID");
		RewriteRuleSubtreeStream stream_expr=new RewriteRuleSubtreeStream(adaptor,"rule expr");

		try {
			// Grammaire.g:186:2: ( 'as' CLASSID ':' expr ')' -> ^( CAST CLASSID expr ) | expr ')' -> expr )
			int alt55=2;
			int LA55_0 = input.LA(1);
			if ( (LA55_0==58) ) {
				alt55=1;
			}
			else if ( (LA55_0==CLASSID||LA55_0==ID||LA55_0==INT||LA55_0==STR||LA55_0==43||LA55_0==46||LA55_0==48||LA55_0==66||LA55_0==68||LA55_0==71||LA55_0==73) ) {
				alt55=2;
			}

			else {
				NoViableAltException nvae =
						new NoViableAltException("", 55, 0, input);
				throw nvae;
			}

			switch (alt55) {
				case 1 :
					// Grammaire.g:186:4: 'as' CLASSID ':' expr ')'
				{
					string_literal153=(Token)match(input,58,FOLLOW_58_in_atomStartWithParenthesis1525);
					stream_58.add(string_literal153);

					CLASSID154=(Token)match(input,CLASSID,FOLLOW_CLASSID_in_atomStartWithParenthesis1527);
					stream_CLASSID.add(CLASSID154);

					char_literal155=(Token)match(input,51,FOLLOW_51_in_atomStartWithParenthesis1529);
					stream_51.add(char_literal155);

					pushFollow(FOLLOW_expr_in_atomStartWithParenthesis1531);
					expr156=expr();
					state._fsp--;

					stream_expr.add(expr156.getTree());
					char_literal157=(Token)match(input,44,FOLLOW_44_in_atomStartWithParenthesis1533);
					stream_44.add(char_literal157);

					// AST REWRITE
					// elements: expr, CLASSID
					// token labels:
					// rule labels: retval
					// token list labels:
					// rule list labels:
					// wildcard labels:
					retval.tree = root_0;
					RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.getTree():null);

					root_0 = (Object)adaptor.nil();
					// 186:56: -> ^( CAST CLASSID expr )
					{
						// Grammaire.g:186:59: ^( CAST CLASSID expr )
						{
							Object root_1 = (Object)adaptor.nil();
							root_1 = (Object)adaptor.becomeRoot((Object)adaptor.create(CAST, "CAST"), root_1);
							adaptor.addChild(root_1, stream_CLASSID.nextNode());
							adaptor.addChild(root_1, stream_expr.nextTree());
							adaptor.addChild(root_0, root_1);
						}

					}


					retval.tree = root_0;

				}
				break;
				case 2 :
					// Grammaire.g:187:4: expr ')'
				{
					pushFollow(FOLLOW_expr_in_atomStartWithParenthesis1550);
					expr158=expr();
					state._fsp--;

					stream_expr.add(expr158.getTree());
					char_literal159=(Token)match(input,44,FOLLOW_44_in_atomStartWithParenthesis1552);
					stream_44.add(char_literal159);

					// AST REWRITE
					// elements: expr
					// token labels:
					// rule labels: retval
					// token list labels:
					// rule list labels:
					// wildcard labels:
					retval.tree = root_0;
					RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.getTree():null);

					root_0 = (Object)adaptor.nil();
					// 187:27: -> expr
					{
						adaptor.addChild(root_0, stream_expr.nextTree());
					}


					retval.tree = root_0;

				}
				break;

			}
			retval.stop = input.LT(-1);

			retval.tree = (Object)adaptor.rulePostProcessing(root_0);
			adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
			retval.tree = (Object)adaptor.errorNode(input, retval.start, input.LT(-1), re);
		}
		finally {
			// do for sure before leaving
		}
		return retval;
	}
	// $ANTLR end "atomStartWithParenthesis"


	public static class string_return extends ParserRuleReturnScope {
		Object tree;
		@Override
		public Object getTree() { return tree; }
	};


	// $ANTLR start "string"
	// Grammaire.g:191:1: string : STR ;
	public final GrammaireParser.string_return string() throws RecognitionException {
		GrammaireParser.string_return retval = new GrammaireParser.string_return();
		retval.start = input.LT(1);

		Object root_0 = null;

		Token STR160=null;

		Object STR160_tree=null;

		try {
			// Grammaire.g:192:2: ( STR )
			// Grammaire.g:192:4: STR
			{
				root_0 = (Object)adaptor.nil();


				STR160=(Token)match(input,STR,FOLLOW_STR_in_string1570);
				STR160_tree = (Object)adaptor.create(STR160);
				adaptor.addChild(root_0, STR160_tree);

			}

			retval.stop = input.LT(-1);

			retval.tree = (Object)adaptor.rulePostProcessing(root_0);
			adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
			retval.tree = (Object)adaptor.errorNode(input, retval.start, input.LT(-1), re);
		}
		finally {
			// do for sure before leaving
		}
		return retval;
	}
	// $ANTLR end "string"


	public static class message_return extends ParserRuleReturnScope {
		Object tree;
		@Override
		public Object getTree() { return tree; }
	};


	// $ANTLR start "message"
	// Grammaire.g:195:1: message : message_unitaire ( message_unitaire )* ;
	public final GrammaireParser.message_return message() throws RecognitionException {
		GrammaireParser.message_return retval = new GrammaireParser.message_return();
		retval.start = input.LT(1);

		Object root_0 = null;

		ParserRuleReturnScope message_unitaire161 =null;
		ParserRuleReturnScope message_unitaire162 =null;


		try {
			// Grammaire.g:199:2: ( message_unitaire ( message_unitaire )* )
			// Grammaire.g:202:2: message_unitaire ( message_unitaire )*
			{
				root_0 = (Object)adaptor.nil();


				pushFollow(FOLLOW_message_unitaire_in_message1590);
				message_unitaire161=message_unitaire();
				state._fsp--;

				adaptor.addChild(root_0, message_unitaire161.getTree());

				// Grammaire.g:202:20: ( message_unitaire )*
				loop56:
				while (true) {
					int alt56=2;
					int LA56_0 = input.LA(1);
					if ( (LA56_0==49) ) {
						alt56=1;
					}

					switch (alt56) {
						case 1 :
							// Grammaire.g:202:20: message_unitaire
						{
							pushFollow(FOLLOW_message_unitaire_in_message1593);
							message_unitaire162=message_unitaire();
							state._fsp--;

							adaptor.addChild(root_0, message_unitaire162.getTree());

						}
						break;

						default :
							break loop56;
					}
				}

			}

			retval.stop = input.LT(-1);

			retval.tree = (Object)adaptor.rulePostProcessing(root_0);
			adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
			retval.tree = (Object)adaptor.errorNode(input, retval.start, input.LT(-1), re);
		}
		finally {
			// do for sure before leaving
		}
		return retval;
	}
	// $ANTLR end "message"


	public static class message_unitaire_return extends ParserRuleReturnScope {
		Object tree;
		@Override
		public Object getTree() { return tree; }
	};


	// $ANTLR start "message_unitaire"
	// Grammaire.g:206:1: message_unitaire : ( ( '.' id= ID -> ^( VARIABLE $id) ) (fc= funcCall -> ^( APPEL_FONCTION ^( FONCTION $id) $fc) )? ) ;
	public final GrammaireParser.message_unitaire_return message_unitaire() throws RecognitionException {
		GrammaireParser.message_unitaire_return retval = new GrammaireParser.message_unitaire_return();
		retval.start = input.LT(1);

		Object root_0 = null;

		Token id=null;
		Token char_literal163=null;
		ParserRuleReturnScope fc =null;

		Object id_tree=null;
		Object char_literal163_tree=null;
		RewriteRuleTokenStream stream_49=new RewriteRuleTokenStream(adaptor,"token 49");
		RewriteRuleTokenStream stream_ID=new RewriteRuleTokenStream(adaptor,"token ID");
		RewriteRuleSubtreeStream stream_funcCall=new RewriteRuleSubtreeStream(adaptor,"rule funcCall");

		try {
			// Grammaire.g:207:2: ( ( ( '.' id= ID -> ^( VARIABLE $id) ) (fc= funcCall -> ^( APPEL_FONCTION ^( FONCTION $id) $fc) )? ) )
			// Grammaire.g:207:4: ( ( '.' id= ID -> ^( VARIABLE $id) ) (fc= funcCall -> ^( APPEL_FONCTION ^( FONCTION $id) $fc) )? )
			{
				// Grammaire.g:207:4: ( ( '.' id= ID -> ^( VARIABLE $id) ) (fc= funcCall -> ^( APPEL_FONCTION ^( FONCTION $id) $fc) )? )
				// Grammaire.g:207:5: ( '.' id= ID -> ^( VARIABLE $id) ) (fc= funcCall -> ^( APPEL_FONCTION ^( FONCTION $id) $fc) )?
				{
					// Grammaire.g:207:5: ( '.' id= ID -> ^( VARIABLE $id) )
					// Grammaire.g:207:6: '.' id= ID
					{
						char_literal163=(Token)match(input,49,FOLLOW_49_in_message_unitaire1610);
						stream_49.add(char_literal163);

						id=(Token)match(input,ID,FOLLOW_ID_in_message_unitaire1614);
						stream_ID.add(id);

						// AST REWRITE
						// elements: id
						// token labels: id
						// rule labels: retval
						// token list labels:
						// rule list labels:
						// wildcard labels:
						retval.tree = root_0;
						RewriteRuleTokenStream stream_id=new RewriteRuleTokenStream(adaptor,"token id",id);
						RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.getTree():null);

						root_0 = (Object)adaptor.nil();
						// 207:16: -> ^( VARIABLE $id)
						{
							// Grammaire.g:207:19: ^( VARIABLE $id)
							{
								Object root_1 = (Object)adaptor.nil();
								root_1 = (Object)adaptor.becomeRoot((Object)adaptor.create(VARIABLE, "VARIABLE"), root_1);
								adaptor.addChild(root_1, stream_id.nextNode());
								adaptor.addChild(root_0, root_1);
							}

						}


						retval.tree = root_0;

					}

					// Grammaire.g:207:36: (fc= funcCall -> ^( APPEL_FONCTION ^( FONCTION $id) $fc) )?
					int alt57=2;
					int LA57_0 = input.LA(1);
					if ( (LA57_0==43) ) {
						alt57=1;
					}
					switch (alt57) {
						case 1 :
							// Grammaire.g:207:37: fc= funcCall
						{
							pushFollow(FOLLOW_funcCall_in_message_unitaire1629);
							fc=funcCall();
							state._fsp--;

							stream_funcCall.add(fc.getTree());
							// AST REWRITE
							// elements: fc, id
							// token labels: id
							// rule labels: fc, retval
							// token list labels:
							// rule list labels:
							// wildcard labels:
							retval.tree = root_0;
							RewriteRuleTokenStream stream_id=new RewriteRuleTokenStream(adaptor,"token id",id);
							RewriteRuleSubtreeStream stream_fc=new RewriteRuleSubtreeStream(adaptor,"rule fc",fc!=null?fc.getTree():null);
							RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.getTree():null);

							root_0 = (Object)adaptor.nil();
							// 207:49: -> ^( APPEL_FONCTION ^( FONCTION $id) $fc)
							{
								// Grammaire.g:207:52: ^( APPEL_FONCTION ^( FONCTION $id) $fc)
								{
									Object root_1 = (Object)adaptor.nil();
									root_1 = (Object)adaptor.becomeRoot((Object)adaptor.create(APPEL_FONCTION, "APPEL_FONCTION"), root_1);
									// Grammaire.g:207:69: ^( FONCTION $id)
									{
										Object root_2 = (Object)adaptor.nil();
										root_2 = (Object)adaptor.becomeRoot((Object)adaptor.create(FONCTION, "FONCTION"), root_2);
										adaptor.addChild(root_2, stream_id.nextNode());
										adaptor.addChild(root_1, root_2);
									}

									adaptor.addChild(root_1, stream_fc.nextTree());
									adaptor.addChild(root_0, root_1);
								}

							}


							retval.tree = root_0;

						}
						break;

					}

				}

			}

			retval.stop = input.LT(-1);

			retval.tree = (Object)adaptor.rulePostProcessing(root_0);
			adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
			retval.tree = (Object)adaptor.errorNode(input, retval.start, input.LT(-1), re);
		}
		finally {
			// do for sure before leaving
		}
		return retval;
	}
	// $ANTLR end "message_unitaire"


	public static class funcCall_return extends ParserRuleReturnScope {
		Object tree;
		@Override
		public Object getTree() { return tree; }
	};


	// $ANTLR start "funcCall"
	// Grammaire.g:210:1: funcCall : '(' ( expr ( ',' expr )* )? ')' -> ^( LIST_PARAM ( expr ( expr )* )? ) ;
	public final GrammaireParser.funcCall_return funcCall() throws RecognitionException {
		GrammaireParser.funcCall_return retval = new GrammaireParser.funcCall_return();
		retval.start = input.LT(1);

		Object root_0 = null;

		Token char_literal164=null;
		Token char_literal166=null;
		Token char_literal168=null;
		ParserRuleReturnScope expr165 =null;
		ParserRuleReturnScope expr167 =null;

		Object char_literal164_tree=null;
		Object char_literal166_tree=null;
		Object char_literal168_tree=null;
		RewriteRuleTokenStream stream_44=new RewriteRuleTokenStream(adaptor,"token 44");
		RewriteRuleTokenStream stream_47=new RewriteRuleTokenStream(adaptor,"token 47");
		RewriteRuleTokenStream stream_43=new RewriteRuleTokenStream(adaptor,"token 43");
		RewriteRuleSubtreeStream stream_expr=new RewriteRuleSubtreeStream(adaptor,"rule expr");

		try {
			// Grammaire.g:211:2: ( '(' ( expr ( ',' expr )* )? ')' -> ^( LIST_PARAM ( expr ( expr )* )? ) )
			// Grammaire.g:211:4: '(' ( expr ( ',' expr )* )? ')'
			{
				char_literal164=(Token)match(input,43,FOLLOW_43_in_funcCall1662);
				stream_43.add(char_literal164);

				// Grammaire.g:211:8: ( expr ( ',' expr )* )?
				int alt59=2;
				int LA59_0 = input.LA(1);
				if ( (LA59_0==CLASSID||LA59_0==ID||LA59_0==INT||LA59_0==STR||LA59_0==43||LA59_0==46||LA59_0==48||LA59_0==66||LA59_0==68||LA59_0==71||LA59_0==73) ) {
					alt59=1;
				}
				switch (alt59) {
					case 1 :
						// Grammaire.g:211:9: expr ( ',' expr )*
					{
						pushFollow(FOLLOW_expr_in_funcCall1665);
						expr165=expr();
						state._fsp--;

						stream_expr.add(expr165.getTree());
						// Grammaire.g:211:14: ( ',' expr )*
						loop58:
						while (true) {
							int alt58=2;
							int LA58_0 = input.LA(1);
							if ( (LA58_0==47) ) {
								alt58=1;
							}

							switch (alt58) {
								case 1 :
									// Grammaire.g:211:16: ',' expr
								{
									char_literal166=(Token)match(input,47,FOLLOW_47_in_funcCall1669);
									stream_47.add(char_literal166);

									pushFollow(FOLLOW_expr_in_funcCall1671);
									expr167=expr();
									state._fsp--;

									stream_expr.add(expr167.getTree());
								}
								break;

								default :
									break loop58;
							}
						}

					}
					break;

				}

				char_literal168=(Token)match(input,44,FOLLOW_44_in_funcCall1677);
				stream_44.add(char_literal168);

				// AST REWRITE
				// elements: expr, expr
				// token labels:
				// rule labels: retval
				// token list labels:
				// rule list labels:
				// wildcard labels:
				retval.tree = root_0;
				RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.getTree():null);

				root_0 = (Object)adaptor.nil();
				// 211:33: -> ^( LIST_PARAM ( expr ( expr )* )? )
				{
					// Grammaire.g:211:36: ^( LIST_PARAM ( expr ( expr )* )? )
					{
						Object root_1 = (Object)adaptor.nil();
						root_1 = (Object)adaptor.becomeRoot((Object)adaptor.create(LIST_PARAM, "LIST_PARAM"), root_1);
						// Grammaire.g:211:49: ( expr ( expr )* )?
						if ( stream_expr.hasNext()||stream_expr.hasNext() ) {
							adaptor.addChild(root_1, stream_expr.nextTree());
							// Grammaire.g:211:54: ( expr )*
							while ( stream_expr.hasNext() ) {
								adaptor.addChild(root_1, stream_expr.nextTree());
							}
							stream_expr.reset();

						}
						stream_expr.reset();
						stream_expr.reset();

						adaptor.addChild(root_0, root_1);
					}

				}


				retval.tree = root_0;

			}

			retval.stop = input.LT(-1);

			retval.tree = (Object)adaptor.rulePostProcessing(root_0);
			adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
			retval.tree = (Object)adaptor.errorNode(input, retval.start, input.LT(-1), re);
		}
		finally {
			// do for sure before leaving
		}
		return retval;
	}
	// $ANTLR end "funcCall"


	public static class formalParam_return extends ParserRuleReturnScope {
		Object tree;
		@Override
		public Object getTree() { return tree; }
	};


	// $ANTLR start "formalParam"
	// Grammaire.g:214:1: formalParam : ( 'var' )? ID ':' CLASSID -> ^( PARAM ID CLASSID ) ;
	public final GrammaireParser.formalParam_return formalParam() throws RecognitionException {
		GrammaireParser.formalParam_return retval = new GrammaireParser.formalParam_return();
		retval.start = input.LT(1);

		Object root_0 = null;

		Token string_literal169=null;
		Token ID170=null;
		Token char_literal171=null;
		Token CLASSID172=null;

		Object string_literal169_tree=null;
		Object ID170_tree=null;
		Object char_literal171_tree=null;
		Object CLASSID172_tree=null;
		RewriteRuleTokenStream stream_ID=new RewriteRuleTokenStream(adaptor,"token ID");
		RewriteRuleTokenStream stream_51=new RewriteRuleTokenStream(adaptor,"token 51");
		RewriteRuleTokenStream stream_74=new RewriteRuleTokenStream(adaptor,"token 74");
		RewriteRuleTokenStream stream_CLASSID=new RewriteRuleTokenStream(adaptor,"token CLASSID");

		try {
			// Grammaire.g:215:2: ( ( 'var' )? ID ':' CLASSID -> ^( PARAM ID CLASSID ) )
			// Grammaire.g:215:4: ( 'var' )? ID ':' CLASSID
			{
				// Grammaire.g:215:4: ( 'var' )?
				int alt60=2;
				int LA60_0 = input.LA(1);
				if ( (LA60_0==74) ) {
					alt60=1;
				}
				switch (alt60) {
					case 1 :
						// Grammaire.g:215:5: 'var'
					{
						string_literal169=(Token)match(input,74,FOLLOW_74_in_formalParam1704);
						stream_74.add(string_literal169);

					}
					break;

				}

				ID170=(Token)match(input,ID,FOLLOW_ID_in_formalParam1708);
				stream_ID.add(ID170);

				char_literal171=(Token)match(input,51,FOLLOW_51_in_formalParam1710);
				stream_51.add(char_literal171);

				CLASSID172=(Token)match(input,CLASSID,FOLLOW_CLASSID_in_formalParam1712);
				stream_CLASSID.add(CLASSID172);

				// AST REWRITE
				// elements: ID, CLASSID
				// token labels:
				// rule labels: retval
				// token list labels:
				// rule list labels:
				// wildcard labels:
				retval.tree = root_0;
				RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.getTree():null);

				root_0 = (Object)adaptor.nil();
				// 215:28: -> ^( PARAM ID CLASSID )
				{
					// Grammaire.g:215:31: ^( PARAM ID CLASSID )
					{
						Object root_1 = (Object)adaptor.nil();
						root_1 = (Object)adaptor.becomeRoot((Object)adaptor.create(PARAM, "PARAM"), root_1);
						adaptor.addChild(root_1, stream_ID.nextNode());
						adaptor.addChild(root_1, stream_CLASSID.nextNode());
						adaptor.addChild(root_0, root_1);
					}

				}


				retval.tree = root_0;

			}

			retval.stop = input.LT(-1);

			retval.tree = (Object)adaptor.rulePostProcessing(root_0);
			adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
			retval.tree = (Object)adaptor.errorNode(input, retval.start, input.LT(-1), re);
		}
		finally {
			// do for sure before leaving
		}
		return retval;
	}
	// $ANTLR end "formalParam"


	public static class operatorLog_return extends ParserRuleReturnScope {
		Object tree;
		@Override
		public Object getTree() { return tree; }
	};


	// $ANTLR start "operatorLog"
	// Grammaire.g:218:1: operatorLog : ( '||' | '&&' | operatorConcat );
	public final GrammaireParser.operatorLog_return operatorLog() throws RecognitionException {
		GrammaireParser.operatorLog_return retval = new GrammaireParser.operatorLog_return();
		retval.start = input.LT(1);

		Object root_0 = null;

		Token string_literal173=null;
		Token string_literal174=null;
		ParserRuleReturnScope operatorConcat175 =null;

		Object string_literal173_tree=null;
		Object string_literal174_tree=null;

		try {
			// Grammaire.g:219:2: ( '||' | '&&' | operatorConcat )
			int alt61=3;
			switch ( input.LA(1) ) {
				case 77:
				{
					alt61=1;
				}
				break;
				case 41:
				{
					alt61=2;
				}
				break;
				case 42:
				{
					alt61=3;
				}
				break;
				default:
					NoViableAltException nvae =
							new NoViableAltException("", 61, 0, input);
					throw nvae;
			}
			switch (alt61) {
				case 1 :
					// Grammaire.g:219:4: '||'
				{
					root_0 = (Object)adaptor.nil();


					string_literal173=(Token)match(input,77,FOLLOW_77_in_operatorLog1733);
					string_literal173_tree = (Object)adaptor.create(string_literal173);
					adaptor.addChild(root_0, string_literal173_tree);

				}
				break;
				case 2 :
					// Grammaire.g:220:4: '&&'
				{
					root_0 = (Object)adaptor.nil();


					string_literal174=(Token)match(input,41,FOLLOW_41_in_operatorLog1738);
					string_literal174_tree = (Object)adaptor.create(string_literal174);
					adaptor.addChild(root_0, string_literal174_tree);

				}
				break;
				case 3 :
					// Grammaire.g:221:4: operatorConcat
				{
					root_0 = (Object)adaptor.nil();


					pushFollow(FOLLOW_operatorConcat_in_operatorLog1743);
					operatorConcat175=operatorConcat();
					state._fsp--;

					adaptor.addChild(root_0, operatorConcat175.getTree());

				}
				break;

			}
			retval.stop = input.LT(-1);

			retval.tree = (Object)adaptor.rulePostProcessing(root_0);
			adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
			retval.tree = (Object)adaptor.errorNode(input, retval.start, input.LT(-1), re);
		}
		finally {
			// do for sure before leaving
		}
		return retval;
	}
	// $ANTLR end "operatorLog"


	public static class operatorConcat_return extends ParserRuleReturnScope {
		Object tree;
		@Override
		public Object getTree() { return tree; }
	};


	// $ANTLR start "operatorConcat"
	// Grammaire.g:224:1: operatorConcat : '&' ;
	public final GrammaireParser.operatorConcat_return operatorConcat() throws RecognitionException {
		GrammaireParser.operatorConcat_return retval = new GrammaireParser.operatorConcat_return();
		retval.start = input.LT(1);

		Object root_0 = null;

		Token char_literal176=null;

		Object char_literal176_tree=null;

		try {
			// Grammaire.g:225:2: ( '&' )
			// Grammaire.g:225:4: '&'
			{
				root_0 = (Object)adaptor.nil();


				char_literal176=(Token)match(input,42,FOLLOW_42_in_operatorConcat1754);
				char_literal176_tree = (Object)adaptor.create(char_literal176);
				adaptor.addChild(root_0, char_literal176_tree);

			}

			retval.stop = input.LT(-1);

			retval.tree = (Object)adaptor.rulePostProcessing(root_0);
			adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
			retval.tree = (Object)adaptor.errorNode(input, retval.start, input.LT(-1), re);
		}
		finally {
			// do for sure before leaving
		}
		return retval;
	}
	// $ANTLR end "operatorConcat"


	public static class operatorComp_return extends ParserRuleReturnScope {
		Object tree;
		@Override
		public Object getTree() { return tree; }
	};


	// $ANTLR start "operatorComp"
	// Grammaire.g:228:1: operatorComp : ( '=' | '<>' | '<' | '>' );
	public final GrammaireParser.operatorComp_return operatorComp() throws RecognitionException {
		GrammaireParser.operatorComp_return retval = new GrammaireParser.operatorComp_return();
		retval.start = input.LT(1);

		Object root_0 = null;

		Token set177=null;

		Object set177_tree=null;

		try {
			// Grammaire.g:229:2: ( '=' | '<>' | '<' | '>' )
			// Grammaire.g:
			{
				root_0 = (Object)adaptor.nil();


				set177=input.LT(1);
				if ( (input.LA(1) >= 54 && input.LA(1) <= 57) ) {
					input.consume();
					adaptor.addChild(root_0, (Object)adaptor.create(set177));
					state.errorRecovery=false;
				}
				else {
					MismatchedSetException mse = new MismatchedSetException(null,input);
					throw mse;
				}
			}

			retval.stop = input.LT(-1);

			retval.tree = (Object)adaptor.rulePostProcessing(root_0);
			adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
			retval.tree = (Object)adaptor.errorNode(input, retval.start, input.LT(-1), re);
		}
		finally {
			// do for sure before leaving
		}
		return retval;
	}
	// $ANTLR end "operatorComp"


	public static class operatorPM_return extends ParserRuleReturnScope {
		Object tree;
		@Override
		public Object getTree() { return tree; }
	};


	// $ANTLR start "operatorPM"
	// Grammaire.g:235:1: operatorPM : ( '+' | '-' );
	public final GrammaireParser.operatorPM_return operatorPM() throws RecognitionException {
		GrammaireParser.operatorPM_return retval = new GrammaireParser.operatorPM_return();
		retval.start = input.LT(1);

		Object root_0 = null;

		Token set178=null;

		Object set178_tree=null;

		try {
			// Grammaire.g:236:2: ( '+' | '-' )
			// Grammaire.g:
			{
				root_0 = (Object)adaptor.nil();


				set178=input.LT(1);
				if ( input.LA(1)==46||input.LA(1)==48 ) {
					input.consume();
					adaptor.addChild(root_0, (Object)adaptor.create(set178));
					state.errorRecovery=false;
				}
				else {
					MismatchedSetException mse = new MismatchedSetException(null,input);
					throw mse;
				}
			}

			retval.stop = input.LT(-1);

			retval.tree = (Object)adaptor.rulePostProcessing(root_0);
			adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
			retval.tree = (Object)adaptor.errorNode(input, retval.start, input.LT(-1), re);
		}
		finally {
			// do for sure before leaving
		}
		return retval;
	}
	// $ANTLR end "operatorPM"


	public static class operatorMD_return extends ParserRuleReturnScope {
		Object tree;
		@Override
		public Object getTree() { return tree; }
	};


	// $ANTLR start "operatorMD"
	// Grammaire.g:240:1: operatorMD : ( '*' | '/' );
	public final GrammaireParser.operatorMD_return operatorMD() throws RecognitionException {
		GrammaireParser.operatorMD_return retval = new GrammaireParser.operatorMD_return();
		retval.start = input.LT(1);

		Object root_0 = null;

		Token set179=null;

		Object set179_tree=null;

		try {
			// Grammaire.g:241:2: ( '*' | '/' )
			// Grammaire.g:
			{
				root_0 = (Object)adaptor.nil();


				set179=input.LT(1);
				if ( input.LA(1)==45||input.LA(1)==50 ) {
					input.consume();
					adaptor.addChild(root_0, (Object)adaptor.create(set179));
					state.errorRecovery=false;
				}
				else {
					MismatchedSetException mse = new MismatchedSetException(null,input);
					throw mse;
				}
			}

			retval.stop = input.LT(-1);

			retval.tree = (Object)adaptor.rulePostProcessing(root_0);
			adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
			retval.tree = (Object)adaptor.errorNode(input, retval.start, input.LT(-1), re);
		}
		finally {
			// do for sure before leaving
		}
		return retval;
	}
	// $ANTLR end "operatorMD"

	// Delegated rules



	public static final BitSet FOLLOW_declaration_in_prog170 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_cls_in_declaration190 = new BitSet(new long[]{0x0800000000000000L,0x0000000000001000L});
	public static final BitSet FOLLOW_bloc_in_declaration194 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_59_in_cls205 = new BitSet(new long[]{0x0000000000000400L});
	public static final BitSet FOLLOW_CLASSID_in_cls207 = new BitSet(new long[]{0x0000080000000000L});
	public static final BitSet FOLLOW_43_in_cls209 = new BitSet(new long[]{0x0000100000080000L,0x0000000000000400L});
	public static final BitSet FOLLOW_formalParam_in_cls212 = new BitSet(new long[]{0x0000900000000000L});
	public static final BitSet FOLLOW_47_in_cls215 = new BitSet(new long[]{0x0000000000080000L,0x0000000000000400L});
	public static final BitSet FOLLOW_formalParam_in_cls217 = new BitSet(new long[]{0x0000900000000000L});
	public static final BitSet FOLLOW_44_in_cls225 = new BitSet(new long[]{0x8000000000000000L,0x0000000000000002L});
	public static final BitSet FOLLOW_63_in_cls228 = new BitSet(new long[]{0x0000000000000400L});
	public static final BitSet FOLLOW_CLASSID_in_cls230 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000002L});
	public static final BitSet FOLLOW_65_in_cls234 = new BitSet(new long[]{0x0000000000000000L,0x0000000000001000L});
	public static final BitSet FOLLOW_blocClass_in_cls236 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_76_in_blocClass271 = new BitSet(new long[]{0x1000000000000000L,0x0000000000004400L});
	public static final BitSet FOLLOW_variable_in_blocClass275 = new BitSet(new long[]{0x1000000000000000L,0x0000000000004400L});
	public static final BitSet FOLLOW_methoddef_in_blocClass278 = new BitSet(new long[]{0x1000000000000000L,0x0000000000004400L});
	public static final BitSet FOLLOW_78_in_blocClass282 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_76_in_bloc294 = new BitSet(new long[]{0x0000000200080400L,0x0000000000005AB1L});
	public static final BitSet FOLLOW_bloc2_in_bloc296 = new BitSet(new long[]{0x0000000000000000L,0x0000000000004000L});
	public static final BitSet FOLLOW_78_in_bloc299 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_74_in_variable321 = new BitSet(new long[]{0x0000000000080000L,0x0000000000000040L});
	public static final BitSet FOLLOW_70_in_variable326 = new BitSet(new long[]{0x0000000000080000L});
	public static final BitSet FOLLOW_ID_in_variable330 = new BitSet(new long[]{0x0008000000000000L});
	public static final BitSet FOLLOW_51_in_variable332 = new BitSet(new long[]{0x0000000000000400L});
	public static final BitSet FOLLOW_CLASSID_in_variable334 = new BitSet(new long[]{0x0030000000000000L});
	public static final BitSet FOLLOW_52_in_variable338 = new BitSet(new long[]{0x0001480200480400L,0x0000000000000294L});
	public static final BitSet FOLLOW_expr_in_variable340 = new BitSet(new long[]{0x0020000000000000L});
	public static final BitSet FOLLOW_53_in_variable344 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_ID_in_bloc2383 = new BitSet(new long[]{0x03FF660000000000L,0x0000000000002000L});
	public static final BitSet FOLLOW_51_in_bloc2397 = new BitSet(new long[]{0x0000000000000400L});
	public static final BitSet FOLLOW_CLASSID_in_bloc2399 = new BitSet(new long[]{0x0030000000000000L});
	public static final BitSet FOLLOW_52_in_bloc2403 = new BitSet(new long[]{0x0001480200480400L,0x0000000000000294L});
	public static final BitSet FOLLOW_expr_in_bloc2405 = new BitSet(new long[]{0x0020000000000000L});
	public static final BitSet FOLLOW_53_in_bloc2409 = new BitSet(new long[]{0x0000000000080000L,0x0000000000000002L});
	public static final BitSet FOLLOW_variable_locale_in_bloc2431 = new BitSet(new long[]{0x0000000000080000L,0x0000000000000002L});
	public static final BitSet FOLLOW_65_in_bloc2448 = new BitSet(new long[]{0x0001480200480400L,0x0000000000001AB5L});
	public static final BitSet FOLLOW_instruction_in_bloc2450 = new BitSet(new long[]{0x0001480200480402L,0x0000000000001AB5L});
	public static final BitSet FOLLOW_message_in_bloc2466 = new BitSet(new long[]{0x03F5660000000000L,0x0000000000002000L});
	public static final BitSet FOLLOW_operator_rule_in_bloc2477 = new BitSet(new long[]{0x0030000000000000L});
	public static final BitSet FOLLOW_52_in_bloc2481 = new BitSet(new long[]{0x0001480200480400L,0x0000000000000294L});
	public static final BitSet FOLLOW_expr_in_bloc2483 = new BitSet(new long[]{0x0020000000000000L});
	public static final BitSet FOLLOW_53_in_bloc2505 = new BitSet(new long[]{0x0001480200480402L,0x0000000000001AB5L});
	public static final BitSet FOLLOW_instruction_in_bloc2509 = new BitSet(new long[]{0x0001480200480402L,0x0000000000001AB5L});
	public static final BitSet FOLLOW_instruction_bloc_in_bloc2524 = new BitSet(new long[]{0x0001480200480402L,0x0000000000001AB5L});
	public static final BitSet FOLLOW_instruction_in_bloc2526 = new BitSet(new long[]{0x0001480200480402L,0x0000000000001AB5L});
	public static final BitSet FOLLOW_atom_block_in_bloc2533 = new BitSet(new long[]{0x0030000000000000L});
	public static final BitSet FOLLOW_52_in_bloc2542 = new BitSet(new long[]{0x0001480200480400L,0x0000000000000294L});
	public static final BitSet FOLLOW_expr_in_bloc2544 = new BitSet(new long[]{0x0020000000000000L});
	public static final BitSet FOLLOW_53_in_bloc2559 = new BitSet(new long[]{0x0001480200480402L,0x0000000000001AB5L});
	public static final BitSet FOLLOW_instruction_in_bloc2562 = new BitSet(new long[]{0x0001480200480402L,0x0000000000001AB5L});
	public static final BitSet FOLLOW_identificateur_bloc_in_atom_block584 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_string_with_quote_in_atom_block589 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_71_in_identificateur_bloc606 = new BitSet(new long[]{0x0002080000000002L});
	public static final BitSet FOLLOW_73_in_identificateur_bloc608 = new BitSet(new long[]{0x0002080000000002L});
	public static final BitSet FOLLOW_message_in_identificateur_bloc623 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_funcCall_in_identificateur_bloc645 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_68_in_identificateur_bloc665 = new BitSet(new long[]{0x0002000000000002L});
	public static final BitSet FOLLOW_message_in_identificateur_bloc684 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_CLASSID_in_identificateur_bloc708 = new BitSet(new long[]{0x0002000000000000L});
	public static final BitSet FOLLOW_message_in_identificateur_bloc710 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_operatorMD_in_operator_rule736 = new BitSet(new long[]{0x0001480200480400L,0x0000000000000294L});
	public static final BitSet FOLLOW_atom1_in_operator_rule739 = new BitSet(new long[]{0x03C5660000000002L,0x0000000000002000L});
	public static final BitSet FOLLOW_operatorPM_in_operator_rule745 = new BitSet(new long[]{0x0001480200480400L,0x0000000000000294L});
	public static final BitSet FOLLOW_expr3_in_operator_rule748 = new BitSet(new long[]{0x03C1460000000002L,0x0000000000002000L});
	public static final BitSet FOLLOW_operatorComp_in_operator_rule753 = new BitSet(new long[]{0x0001480200480400L,0x0000000000000294L});
	public static final BitSet FOLLOW_expr2_in_operator_rule756 = new BitSet(new long[]{0x03C0060000000002L,0x0000000000002000L});
	public static final BitSet FOLLOW_operatorLog_in_operator_rule762 = new BitSet(new long[]{0x0001480200480400L,0x0000000000000294L});
	public static final BitSet FOLLOW_expr1_in_operator_rule765 = new BitSet(new long[]{0x0000060000000002L,0x0000000000002000L});
	public static final BitSet FOLLOW_ID_in_variable_locale778 = new BitSet(new long[]{0x0008000000000000L});
	public static final BitSet FOLLOW_51_in_variable_locale780 = new BitSet(new long[]{0x0000000000000400L});
	public static final BitSet FOLLOW_CLASSID_in_variable_locale782 = new BitSet(new long[]{0x0030000000000000L});
	public static final BitSet FOLLOW_52_in_variable_locale786 = new BitSet(new long[]{0x0001480200480400L,0x0000000000000294L});
	public static final BitSet FOLLOW_expr_in_variable_locale788 = new BitSet(new long[]{0x0020000000000000L});
	public static final BitSet FOLLOW_53_in_variable_locale792 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_bloc_in_instruction_bloc816 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_69_in_instruction_bloc821 = new BitSet(new long[]{0x0020000000000000L});
	public static final BitSet FOLLOW_53_in_instruction_bloc823 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_ifStatement_in_instruction_bloc830 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_whileStatement_in_instruction_bloc835 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_bloc_in_instruction846 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_69_in_instruction851 = new BitSet(new long[]{0x0020000000000000L});
	public static final BitSet FOLLOW_53_in_instruction853 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_expr_in_instruction863 = new BitSet(new long[]{0x0030000000000000L});
	public static final BitSet FOLLOW_52_in_instruction872 = new BitSet(new long[]{0x0001480200480400L,0x0000000000000294L});
	public static final BitSet FOLLOW_expr_in_instruction876 = new BitSet(new long[]{0x0020000000000000L});
	public static final BitSet FOLLOW_53_in_instruction892 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_ifStatement_in_instruction897 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_whileStatement_in_instruction902 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_60_in_methoddef915 = new BitSet(new long[]{0x0000000000080400L,0x0000000000000048L});
	public static final BitSet FOLLOW_method_in_methoddef917 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_70_in_method939 = new BitSet(new long[]{0x0000000000080000L,0x0000000000000008L});
	public static final BitSet FOLLOW_67_in_method946 = new BitSet(new long[]{0x0000000000080000L});
	public static final BitSet FOLLOW_ID_in_method950 = new BitSet(new long[]{0x0000080000000000L});
	public static final BitSet FOLLOW_43_in_method952 = new BitSet(new long[]{0x0000100000080000L,0x0000000000000400L});
	public static final BitSet FOLLOW_formalParam_in_method955 = new BitSet(new long[]{0x0000900000000000L});
	public static final BitSet FOLLOW_47_in_method958 = new BitSet(new long[]{0x0000000000080000L,0x0000000000000400L});
	public static final BitSet FOLLOW_formalParam_in_method960 = new BitSet(new long[]{0x0000900000000000L});
	public static final BitSet FOLLOW_44_in_method968 = new BitSet(new long[]{0x0008000000000000L,0x0000000000000002L});
	public static final BitSet FOLLOW_methodShortLong_in_method970 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_CLASSID_in_method1002 = new BitSet(new long[]{0x0000080000000000L});
	public static final BitSet FOLLOW_43_in_method1004 = new BitSet(new long[]{0x0000100000080000L,0x0000000000000400L});
	public static final BitSet FOLLOW_formalParam_in_method1007 = new BitSet(new long[]{0x0000900000000000L});
	public static final BitSet FOLLOW_47_in_method1010 = new BitSet(new long[]{0x0000000000080000L,0x0000000000000400L});
	public static final BitSet FOLLOW_formalParam_in_method1012 = new BitSet(new long[]{0x0000900000000000L});
	public static final BitSet FOLLOW_44_in_method1020 = new BitSet(new long[]{0x0008000000000000L,0x0000000000000002L});
	public static final BitSet FOLLOW_51_in_method1024 = new BitSet(new long[]{0x0000000000000400L});
	public static final BitSet FOLLOW_CLASSID_in_method1026 = new BitSet(new long[]{0x0000080000000000L});
	public static final BitSet FOLLOW_funcCall_in_method1028 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000002L});
	public static final BitSet FOLLOW_65_in_method1033 = new BitSet(new long[]{0x0000000000000000L,0x0000000000001000L});
	public static final BitSet FOLLOW_bloc_in_method1035 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_51_in_methodShortLong1071 = new BitSet(new long[]{0x0000000000000400L});
	public static final BitSet FOLLOW_CLASSID_in_methodShortLong1073 = new BitSet(new long[]{0x0010000000000000L,0x0000000000000002L});
	public static final BitSet FOLLOW_methodShortLong2_in_methodShortLong1075 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_65_in_methodShortLong1086 = new BitSet(new long[]{0x0000000000000000L,0x0000000000001000L});
	public static final BitSet FOLLOW_bloc_in_methodShortLong1088 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_65_in_methodShortLong21105 = new BitSet(new long[]{0x0000000000000000L,0x0000000000001000L});
	public static final BitSet FOLLOW_bloc_in_methodShortLong21107 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_52_in_methodShortLong21117 = new BitSet(new long[]{0x0001480200480400L,0x0000000000000294L});
	public static final BitSet FOLLOW_expr_in_methodShortLong21119 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_64_in_ifStatement1136 = new BitSet(new long[]{0x0001480200480400L,0x0000000000000294L});
	public static final BitSet FOLLOW_expr_in_ifStatement1138 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000100L});
	public static final BitSet FOLLOW_72_in_ifStatement1140 = new BitSet(new long[]{0x0001480200480400L,0x0000000000001AB5L});
	public static final BitSet FOLLOW_instruction_in_ifStatement1144 = new BitSet(new long[]{0x4000000000000000L});
	public static final BitSet FOLLOW_62_in_ifStatement1146 = new BitSet(new long[]{0x0001480200480400L,0x0000000000001AB5L});
	public static final BitSet FOLLOW_instruction_in_ifStatement1151 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_75_in_whileStatement1189 = new BitSet(new long[]{0x0001480200480400L,0x0000000000000294L});
	public static final BitSet FOLLOW_expr_in_whileStatement1191 = new BitSet(new long[]{0x2000000000000000L});
	public static final BitSet FOLLOW_61_in_whileStatement1193 = new BitSet(new long[]{0x0001480200480400L,0x0000000000001AB5L});
	public static final BitSet FOLLOW_instruction_in_whileStatement1195 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_atom0_in_firstExprFact1228 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_string_with_quote_in_firstExprFact1230 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_condExpr_in_expr1242 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_expr1_in_condExpr1253 = new BitSet(new long[]{0x0000060000000002L,0x0000000000002000L});
	public static final BitSet FOLLOW_operatorLog_in_condExpr1256 = new BitSet(new long[]{0x0001480200480400L,0x0000000000000294L});
	public static final BitSet FOLLOW_expr1_in_condExpr1259 = new BitSet(new long[]{0x0000060000000002L,0x0000000000002000L});
	public static final BitSet FOLLOW_expr2_in_expr11271 = new BitSet(new long[]{0x03C0000000000002L});
	public static final BitSet FOLLOW_operatorComp_in_expr11274 = new BitSet(new long[]{0x0001480200480400L,0x0000000000000294L});
	public static final BitSet FOLLOW_expr2_in_expr11277 = new BitSet(new long[]{0x03C0000000000002L});
	public static final BitSet FOLLOW_expr3_in_expr21289 = new BitSet(new long[]{0x0001400000000002L});
	public static final BitSet FOLLOW_operatorPM_in_expr21292 = new BitSet(new long[]{0x0001480200480400L,0x0000000000000294L});
	public static final BitSet FOLLOW_expr3_in_expr21295 = new BitSet(new long[]{0x0001400000000002L});
	public static final BitSet FOLLOW_atom1_in_expr31308 = new BitSet(new long[]{0x0004200000000002L});
	public static final BitSet FOLLOW_operatorMD_in_expr31311 = new BitSet(new long[]{0x0001480200480400L,0x0000000000000294L});
	public static final BitSet FOLLOW_atom1_in_expr31314 = new BitSet(new long[]{0x0004200000000002L});
	public static final BitSet FOLLOW_INT_in_atom01327 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_43_in_atom01333 = new BitSet(new long[]{0x0401480200480400L,0x0000000000000294L});
	public static final BitSet FOLLOW_atomStartWithParenthesis_in_atom01335 = new BitSet(new long[]{0x0002000000000002L});
	public static final BitSet FOLLOW_message_in_atom01347 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_66_in_atom01369 = new BitSet(new long[]{0x0000000000000400L});
	public static final BitSet FOLLOW_CLASSID_in_atom01371 = new BitSet(new long[]{0x0000080000000000L});
	public static final BitSet FOLLOW_funcCall_in_atom01373 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_46_in_atom11394 = new BitSet(new long[]{0x0000080000480400L,0x0000000000000294L});
	public static final BitSet FOLLOW_atom2_in_atom11396 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_string_with_quote_in_atom11409 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_48_in_atom11414 = new BitSet(new long[]{0x0000080000480400L,0x0000000000000294L});
	public static final BitSet FOLLOW_atom2_in_atom11416 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_atom2_in_atom11429 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_atom0_in_atom21440 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_identificateur_bloc_in_atom21445 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_ID_in_atom21455 = new BitSet(new long[]{0x0002000000000002L});
	public static final BitSet FOLLOW_message_in_atom21470 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_string_in_string_with_quote1500 = new BitSet(new long[]{0x0002000000000002L});
	public static final BitSet FOLLOW_message_unitaire_in_string_with_quote1502 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_58_in_atomStartWithParenthesis1525 = new BitSet(new long[]{0x0000000000000400L});
	public static final BitSet FOLLOW_CLASSID_in_atomStartWithParenthesis1527 = new BitSet(new long[]{0x0008000000000000L});
	public static final BitSet FOLLOW_51_in_atomStartWithParenthesis1529 = new BitSet(new long[]{0x0001480200480400L,0x0000000000000294L});
	public static final BitSet FOLLOW_expr_in_atomStartWithParenthesis1531 = new BitSet(new long[]{0x0000100000000000L});
	public static final BitSet FOLLOW_44_in_atomStartWithParenthesis1533 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_expr_in_atomStartWithParenthesis1550 = new BitSet(new long[]{0x0000100000000000L});
	public static final BitSet FOLLOW_44_in_atomStartWithParenthesis1552 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_STR_in_string1570 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_message_unitaire_in_message1590 = new BitSet(new long[]{0x0002000000000002L});
	public static final BitSet FOLLOW_message_unitaire_in_message1593 = new BitSet(new long[]{0x0002000000000002L});
	public static final BitSet FOLLOW_49_in_message_unitaire1610 = new BitSet(new long[]{0x0000000000080000L});
	public static final BitSet FOLLOW_ID_in_message_unitaire1614 = new BitSet(new long[]{0x0000080000000002L});
	public static final BitSet FOLLOW_funcCall_in_message_unitaire1629 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_43_in_funcCall1662 = new BitSet(new long[]{0x0001580200480400L,0x0000000000000294L});
	public static final BitSet FOLLOW_expr_in_funcCall1665 = new BitSet(new long[]{0x0000900000000000L});
	public static final BitSet FOLLOW_47_in_funcCall1669 = new BitSet(new long[]{0x0001480200480400L,0x0000000000000294L});
	public static final BitSet FOLLOW_expr_in_funcCall1671 = new BitSet(new long[]{0x0000900000000000L});
	public static final BitSet FOLLOW_44_in_funcCall1677 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_74_in_formalParam1704 = new BitSet(new long[]{0x0000000000080000L});
	public static final BitSet FOLLOW_ID_in_formalParam1708 = new BitSet(new long[]{0x0008000000000000L});
	public static final BitSet FOLLOW_51_in_formalParam1710 = new BitSet(new long[]{0x0000000000000400L});
	public static final BitSet FOLLOW_CLASSID_in_formalParam1712 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_77_in_operatorLog1733 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_41_in_operatorLog1738 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_operatorConcat_in_operatorLog1743 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_42_in_operatorConcat1754 = new BitSet(new long[]{0x0000000000000002L});
}
