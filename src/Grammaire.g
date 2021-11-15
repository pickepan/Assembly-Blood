grammar Grammaire;

options {
	language=Java;
	k=1;
	backtrack=false;
	output=AST;
}
tokens{ 	
	ROOT;
	CLASSE;
	PARAM;
	BLOCK;
	METHOD;
	MESSAGE;
	IF;
	THEN;
	ELSE;
	WHILE;
	DO;
	STRING;
	LIST_PARAM;
	PLUS_UNAIRE;
	MOINS_UNAIRE;
	ATTRIBUT;
	VARIABLE;
	VARIABLE_LOCALE;
	CONDITION;
	VALUE;
	AFFECTATION;
	SELECT;
	IDENTIFICATEUR;
	APPEL_FONCTION;
	CAST;
	GROUP;
	RESULT;
	NEW;
	EXTENDS;
	FONCTION;
	HERITED;
}

prog
	: declaration -> ^(ROOT declaration)
	;

declaration
	: (cls)* bloc
	;

cls
	: 'class' CLASSID '(' (formalParam (',' formalParam)* )?  ')' ('extends' CLASSID)? 'is' blocClass -> ^(CLASSE CLASSID ^(LIST_PARAM formalParam*)? ^(EXTENDS CLASSID)? blocClass)
	;
blocClass
	: '{'! (variable| methoddef)* '}'!
	;

bloc
	: '{' bloc2? '}' /*pas obligaatoire d'avoir d'instruction*/ -> ^(BLOCK bloc2?)
	;

variable
	: 'var' (stat='static')? ID ':' CLASSID ( ':=' expr)? ';' -> ^(ATTRIBUT ID CLASSID ^( VALUE expr)? ($stat)? )
	;

bloc2
	: (id=ID -> ^(VARIABLE $id)) ((':' CLASSID ( ':=' expr)? ';' -> ^(VARIABLE_LOCALE $id CLASSID ^(VALUE expr)?)) (variable_locale* -> $bloc2 ^(VARIABLE_LOCALE variable_locale)*) ('is' instruction+ -> $bloc2 instruction+) |  (message -> $id message)? operator_rule ((':=' expr)-> /*$bloc2*/ ^(AFFECTATION ^(VARIABLE $id) expr))?  ';'  (instruction*-> $bloc2 instruction*))
	| instruction_bloc instruction*
	| (atom_block -> atom_block) ( ':=' expr -> ^(AFFECTATION $bloc2 expr))? ';' (instruction* -> $bloc2 instruction* )
	;

atom_block
	: identificateur_bloc
	| string_with_quote
	;


identificateur_bloc
//	: st=('super'|'this') super_this? -> ^(IDENTIFICATEUR ^(MESSAGE $st super_this?))
	: (st=('super'|'this') -> ^(IDENTIFICATEUR $st)) ((message -> ^(IDENTIFICATEUR ^(MESSAGE $st message)))? | (funcCall -> ^(APPEL_FONCTION $st funcCall)))
//	| 'result' ( '.' ID  message? )? -> ^(IDENTIFICATEUR ^( MESSAGE 'result' ID  message? )?  )
	| ('result' -> ^(IDENTIFICATEUR ^(RESULT 'result')   )) (message -> ^(IDENTIFICATEUR ^( MESSAGE RESULT  message)))?
//	| CLASSID ( '.' ( ID message? -> ^(APPEL_FONCTION ID message? ) ) ) -> ^(SELECT  CLASSID $identificateur_bloc )
	| CLASSID message -> ^(SELECT ^(MESSAGE CLASSID message))
	;

operator_rule
	: (operatorMD^ atom1)*  (operatorPM^ expr3)* (operatorComp^ expr2)*  (operatorLog^ expr1)*
	;

variable_locale
	: ID ':' CLASSID ( ':=' expr)? ';' -> ID CLASSID ^(VALUE expr)?
	;

instruction_bloc
	: bloc
	| 'return' ';' ->
	| ifStatement
	| whileStatement
	;

instruction
	: bloc
	| 'return' ';' ->
	| (e1=expr -> $e1) (':=' e2=expr -> ^(AFFECTATION $e1 $e2))? ';'
	| ifStatement
	| whileStatement
	;


methoddef //factorisation
	: 'def' method -> ^(METHOD method)
	;

method
	: (s='static')? (o='override')? ID '(' (formalParam (',' formalParam)* )?  ')' methodShortLong ->  ID ($s)? ($o)? ^(LIST_PARAM formalParam*)? methodShortLong
	| CLASSID '(' (formalParam (',' formalParam)* )?  ')' ( ':' CLASSID funcCall )? 'is' bloc ->  CLASSID ^(LIST_PARAM formalParam*)? ^(HERITED CLASSID funcCall*)? bloc
	;

methodShortLong
	: ':' CLASSID methodShortLong2 -> CLASSID methodShortLong2
	| 'is' bloc /*long method*/ -> bloc
	;

methodShortLong2
	: 'is' bloc/*long method*/ -> bloc
	| ':=' expr /*short method */ -> expr
	;

ifStatement
	: 'if' expr 'then' inst1=instruction 'else'  inst2=instruction -> ^(IF ^(CONDITION expr) ^(THEN $inst1) ^(ELSE $inst2) )
	;

whileStatement
	: 'while' expr 'do' instruction -> ^(WHILE ^(CONDITION expr) ^(DO instruction)  )
	;


firstExprFact
	: (atom0|string_with_quote)
	;

expr
	: condExpr
	;

condExpr
	: expr1 (operatorLog^ expr1)*
	;
expr1
	: expr2 (operatorComp^ expr2)*
	;
expr2
	: expr3 (operatorPM^ expr3)*
	;

expr3
	: atom1 (operatorMD^ atom1)*;


atom0
	:  INT
	| ('(' atomStartWithParenthesis -> ^(GROUP atomStartWithParenthesis)) (message -> ^(GROUP ^(MESSAGE atomStartWithParenthesis message)))?
	|  'new' CLASSID funcCall -> ^(NEW CLASSID funcCall)
	;

atom1
	: '+' atom2 -> ^(PLUS_UNAIRE atom2)
	| string_with_quote
	| '-' atom2 -> ^(MOINS_UNAIRE atom2)
	| atom2
	;

atom2
	: atom0
	| identificateur_bloc
	//| (id=ID -> ^(VARIABLE $id)) (m=message -> ^(VARIABLE ^(MESSAGE $id $m)))?
	| (id=ID -> ^(VARIABLE $id)) (m=message ->  ^(MESSAGE ^(VARIABLE $id) $m))?
	;

string_with_quote
	: string message_unitaire? -> ^(STRING string message_unitaire?)
	;

atomStartWithParenthesis
	: 'as' CLASSID ':' expr ')' /*( as CLASSID : expr )*/ -> ^(CAST CLASSID expr)
	| expr ')' /*( expr ) */ -> expr
	;


string
	: STR
	;

message
//	: ('.' ID (fc=funcCall)?)+ -> ^(APPEL_FONCTION ID ($fc)?)+ 
//	: (('.' id=ID -> ^(VARIABLE $id)) (fc=funcCall -> ^(APPEL_FONCTION $id $fc))?)+
//	| funcCall ('.'! ID funcCall?)*
	: //message_unitaire+
	//message_unitaire (MESSAGE^ message_unitaire)*
	//(m=message_unitaire -> $m)  (m1=message_unitaire -> ^(MESSAGE ^(VARIABLE $m) $m1) )*
	message_unitaire  message_unitaire*
	//operatorMD^ atom1)*  (operatorPM^ expr3)* (operatorComp^ expr2)*  (operatorLog^ expr1)*
	;
	
message_unitaire
	: (('.' id=ID -> ^(VARIABLE $id)) (fc=funcCall -> ^(APPEL_FONCTION ^(FONCTION $id) $fc))?   )
	;

funcCall
	: '(' (expr ( ',' expr)*)? ')' -> ^(LIST_PARAM (expr(expr)*)?)
	;

formalParam
	: ('var')? ID ':' CLASSID -> ^(PARAM ID CLASSID)
	;

operatorLog
	: '||'
	| '&&'
	| operatorConcat
	;

operatorConcat
	: '&'
	;

operatorComp
	: '='
	| '<>'
	| '<'
	| '>'
	;

operatorPM
	: '+'
	| '-'
	;

operatorMD
	: '*'
	| '/'
	;

CLASSID : ('A'..'Z')('a'..'z'|'A'..'Z'|'0'..'9'|'_')* ; //Class names : must begin with uper case

ID : ('a'..'z')('a'..'z'|'A'..'Z'|'0'..'9'|'_')* ; //Identificateur : must begin with lower case
INT : ('0'..'9')+ ;
STR : '"'((~('"')  )*)'"';
WHITESPACE : ( '\t' | ' ' | '\r' | '\n'| '\u000C' )+  { $channel=HIDDEN;};
COMMENT:   '/*' ( options {greedy=false;} : . )* '*/' {$channel=HIDDEN;};
