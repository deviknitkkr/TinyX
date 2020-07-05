grammar TinyX;

program : statement+;

statement : let | show ;

let    :  VAR '=' (INT | VAR) ;
show     : 'show' (INT | VAR) ;

VAR     : [a-z]+ ;
INT : [0-9]+ ;
WS     : [ \n\t]+ -> skip;