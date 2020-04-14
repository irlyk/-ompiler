grammar MLL;


compilationUnit
    :   consts? functions? mainProg
;


functions
    :   'def' varname '(' expressionList ')' block ('def' varname '(' expressionList ')' block)*
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
//    |   ifStatment
    // 'for' statment
    // 'while' statment
    ;


print
    :   'print' '(' expressionList ')'
    ;

// ifStatment
//     :   'if (' conclusion ')' block ( 'else' block)?
//     ;


varDeclaration
    :   type expression
    ;


expressionList
    :   (expression (',' expression)*)?
    ;


expression
    :   varname
    |   expression '=' expression
    |   expression '*' expression
    |   expression '/' expression
    |   expression '+' expression
    |   expression '-' expression
    |   expression '(' expression ')'
    |   literal
    ;


literal
    :   NUMBER
    |   floatLiteral
    |   CHAR_LITERAL
    |   BOOL_LITERAL
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


varname
   : LETTERS (LETTERS | NUMBER )*
   ;


LETTERS
   : ('a' .. 'z' | 'A' .. 'Z') +
   ;


NUMBER
    :   [0-9] ([0-9])*
    ;


CHAR_LITERAL
    :   LETTERS
    ;


BOOL_LITERAL
    :   'true'
    |   'false'
    ;


// Whitespace and comments
WS:                 [ \t\r\n\u000C]+ -> channel(HIDDEN);
COMMENT:            '/*' .*? '*/'    -> channel(HIDDEN);
LINE_COMMENT:       '//' ~[\r\n]*    -> channel(HIDDEN);



