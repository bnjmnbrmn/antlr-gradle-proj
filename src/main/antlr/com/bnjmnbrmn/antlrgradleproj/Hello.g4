grammar Hello;

// Main rule: 'r' can be either a hello message or a farewell message
r : helloMessage
  | farewellMessage
  ;

// Rule for a hello message
helloMessage : HELLO ID ;      // <--- CHANGE THIS FROM 'hello' to HELLO

// Rule for a farewell message
farewellMessage : GOODBYE ID ; // <--- CHANGE THIS FROM 'goodbye' to GOODBYE

// Lexer rules:
HELLO   : 'hello' ;
GOODBYE : 'goodbye' ;
ID      : [a-z]+ ;
WS      : [ \t\r\n]+ -> skip ;
