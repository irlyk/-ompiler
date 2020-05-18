grammar MLL;


compilationUnit
    :   consts? functions? mainProg
;


functions
    :   'def' varname '(' parameterList ')' block ('def' varname '(' parameterList ')' block)*
    ;


block
    :   '{' (statment)* '}'
    ;


consts
   :    'const' varDeclaration ';' ('const' varDeclaration ';')*
   ;


callMethode
    :   varname '(' expressionList ')'
    ;


mainProg
    : 'main()' block
    ;


statment
    :   varDeclaration ';'
    |   callMethode ';'
    |   expression ';'
    |   print ';'
    |   ifStatment
    |   assigment
    |   whileStatment
    |   forStatment
    ;




print
    :   'print' '(' expressionList ')'
    ;


ifStatment
    :   'if' '(' conclusionList ')' block ('else' block)?
    ;


conclusionList
    :   conclusion (pob=('and' | 'or') conclusion)*
    ;


forStatment
    :   'for' '(' forInside ')' block
    ;

forInside
    :   forInit ';' conclusionList ';' expression
    ;

forInit
    :  (varDeclaration | expression) (',' (varDeclaration | expression))*
    ;

whileStatment
    :   'while' '(' conclusionList ')' block
    ;

conclusion
    :   expression
    |   callMethode
    |   expression '==' expression
    |   expression '>' expression
    |   expression '<' expression
    |   expression '>=' expression
    |   expression '<=' expression
    |   expression '!=' expression
    ;


varDeclaration
    :   type varname ('=' expression)?
    ;


assigment
    :   varname '=' expression
    ;

expressionList
    :   (expression (',' expression)*)?
    ;

parameterList
    :   (varDeclaration (',' varDeclaration)*)?
    ;


expression
    :   assigment # AssigmentExpression
    |   callMethode # CallMethodeExpression
    |   expression op = ('*' | '/' | '%') expression # MultipliesExpression
    |   expression  op = ( '+' | '-' ) expression # SummExpression
    |   varname # VarNameExpression
    |   literal # LiteralExpression
    |   '(' expression ')' # ParenExpression
    ;


literal
    :   boolLiteral
    |   intLiteral
    |   floatLiteral
    |   charLiteral
    ;

intLiteral
    :   NUMBER
    ;

boolLiteral
    :   'true'
    |   'false'
    ;

charLiteral
    :   '\'' LETTERS '\''
    ;


floatLiteral
    :   NUMBER '.' NUMBER
    ;


type
    :   'int'
    |   'char'
    |   'float'
    |   'bool'
    ;





varname
   : LETTERS (LETTERS | NUMBER )*
   ;


LETTERS
   : ('a' .. 'z' | 'A' .. 'Z') +
   ;


NUMBER
    :   [0-9] ([0-9])*
    ;



// Whitespace and comments
WS:                 [ \t\r\n\u000C]+ -> channel(HIDDEN);
COMMENT:            '/*' .*? '*/'    -> channel(HIDDEN);
LINE_COMMENT:       '//' ~[\r\n]*    -> channel(HIDDEN);



