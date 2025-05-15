grammar Hello;

r: helloMessage | farewellMessage ;

helloMessage: HELLO ID;

farewellMessage: GOODBYE ID;


ID : [a-z]+ ;
HELLO : 'hello';
GOODBYE : 'goodbye';
WS : [ \t\r\n ]+ -> skip;
