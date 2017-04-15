grammar Saida;
r  : ViolationResult '.' TemporalOp '.' Event ;
ViolationResult : 'Error' | 'FalsePositive' ;
TemporalOp : 'Never' | 'Always' | 'Eventually' ;
Event : BasicEvent | BasicEvent '.' TemporalOrder '.' BasicEvent ;
BasicEvent : 'FieldGet' | 'FieldSet' | 'MethodCall' | Exception ;
TemporalOrder : 'Before' | 'After' ;
Exception : 'NullPointerException' | 'SecurityException' ;
WS : [ \t\r\n]+ -> skip ; // skip spaces, tabs, newlines