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


print
    :   'print' '(' expressionList ')'
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
//    :   literal # literals
//    |   callMethode # methodeCall
//    |   varname # var
//    |   expression '=' expression # assigment
//    |   expression '*' expression # multiply
//    |   expression '/' expression # divide
//    |   expression '+' expression # summ
//    |   expression '-' expression # difference
//    |   expression '(' expression ')' # parenExpression
//    ;


literal
    :   BOOL_LITERAL
    |   NUMBER
    |   floatLiteral
    |   charLiteral
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
    |   'double'
    |   'bool'
    ;


BOOL_LITERAL
    :   'true'
    |   'false'
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



