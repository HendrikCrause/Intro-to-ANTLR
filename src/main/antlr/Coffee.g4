grammar Coffee;

/*
 * Parser Rules
 */

order       : size? variant extras? ;
extras      : (separator? quantity? ingredient)+ ;
size        : SHOT | SHORT | TALL | GRANDE | REGULAR | LONG ;
quantity    : SINGLE | DOUBLE | TRIPLE | HALF | ONE | TWO | THREE | EXTRA ;
strength    : quantity SHOT? ;
separator   : COMMA | AND | WITH ;

variant     : (RED | DECAF)? type ;
instant     : ( BLACK | WHITE | INSTANT)? COFFEE? ;
latte       : CAFE? LATTE ;
mocha       : CAFE? MOCHA ;
irish       : IRISH COFFEE? ;
breve       : CAFE? BREVE ;
iced        : ICED COFFEE? ;
flat_white  : FLAT WHITE ;
type        : instant
            | ESPRESSO
            | MACCHIATO
            | AMERICANO
            | latte
            | CAPPUCCINO
            | mocha
            | irish
            | breve
            | iced
            | flat_white ;

sugar_types   : (WHITE | BROWN)? SUGAR ;
pouring_cream : POURING? CREAM ;
water         : (HOT | COLD)? WATER ;
steam_milk    : STEAMED MILK ;
cinnamon      : CINNAMON POWDER? ;
cocoa         : COCOA POWDER? ;
ingredient    : water
              | sugar_types
              | HONEY
              | MILK
              | pouring_cream
              | FOAM
              | steam_milk
              | WHISKEY
              | COFFEE
              | CHOCOLATE
              | cinnamon
              | cocoa ;

/*
 * Lexer Rules
 */

fragment LOWERCASE  : [a-z] ;
fragment UPPERCASE  : [A-Z] ;

fragment A : ('A'|'a') ;
fragment B : ('B'|'b') ;
fragment C : ('C'|'c') ;
fragment D : ('D'|'d') ;
fragment E : ('E'|'e'|'É'|'é') ;
fragment F : ('F'|'f') ;
fragment G : ('G'|'g') ;
fragment H : ('H'|'h') ;
fragment I : ('I'|'i') ;
fragment K : ('K'|'k') ;
fragment L : ('L'|'l') ;
fragment M : ('M'|'m') ;
fragment N : ('N'|'n') ;
fragment O : ('O'|'o') ;
fragment P : ('P'|'p') ;
fragment R : ('R'|'r') ;
fragment S : ('S'|'s') ;
fragment T : ('T'|'t') ;
fragment U : ('U'|'u') ;
fragment V : ('V'|'v') ;
fragment W : ('W'|'w') ;
fragment X : ('X'|'x') ;
fragment Y : ('Y'|'y') ;

ONE         : '1' | (O N E) ;
TWO         : '2' | (T W O) ;
THREE       : '3' | (T H R E E) ;

SHOT        : S H O T ;
TRIPLE      : T R I P L E ;
DOUBLE      : D O U B L E ;
SINGLE      : S I N G L E ;
LONG        : L O N G ;
SHORT       : S H O R T ;
TALL        : T A L L ;
GRANDE      : G R A N D E ;
BLACK       : B L A C K ;
FLAT        : F L A T ;
WHITE       : W H I T E ;
BROWN       : B R O W N ;
HALF        : H A L F ;
COLD        : C O L D ;
HOT         : H O T ;

REGULAR     : R E G U L A R ;
CAFE        : C A F E ;
ESPRESSO    : E S P R E S S O ;
MACCHIATO   : M A C C H I A T O ;
AMERICANO   : A M E R I C A N O ;
LATTE       : L A T T E ;
CAPPUCCINO  : C A P P U C C I N O ;
MOCHA       : M O C H A ;
COFFEE      : C O F F E E ;
INSTANT     : I N S T A N T ;
IRISH       : I R I S H ;
BREVE       : B R E V E ;
RED         : R E D ;
DECAF       : D E C A F (F E I N A T E D)? ;
ICED        : I C E D? ;

WATER       : W A T E R ;
SUGAR       : S U G A R S? ;
HONEY       : H O N E Y ;
MILK        : M I L K ;
CREAM       : C R E A M ;
POURING     : P O U R I N G ;
FOAM        : F O A M ;
STEAMED     : S T E A M E D ;
WHISKEY     : W H I S K E Y ;
CHOCOLATE   : C H O C O L A T E ;
COCOA       : C O C O A ;
CINNAMON    : C I N N A M O N ;
POWDER      : P O W D E R ;
WITH        : W I T H ;
EXTRA       : E X T R A ;
AND         : A N D ;
NO          : N O ;

NUMBER      : [0-9]+ ;
COMMA       : ',' ;
WORD		: (LOWERCASE | UPPERCASE )+ ;
WHITESPACE	: (' ' | '\t')+ -> skip ;
NEWLINE		: ('\r'? '\n' | '\r')+ ;
