/*
 Grammatica di tipo LALR(1) (e quindi anche LR(1)) definita sull'alfabeto A = { a, ..., z, A, ..., Z, 0, ..., 9, epsilon, +, *, (, )}
 che genera stringhe che iniziano con un'espressione regolare, seguita da una virgola e da una o più stringhe
 alfanumeriche  (in caso di più stringhe, queste sono separate le une dalle altre da una virgola).
 La grammatica è non ambigua e gode delle seguenti proprietà:
 - Associatività a sinistra dell'operatore di unione (+)
 - Associatività a sinistra dell'operatore di concatenazione ()
 - Priorità dell'operatore della chiusura di kleene (*) sugli altri operatori; seguono, in ordine decrescente,
  la concatenazione e l'unione.
 - Impossibilità di applicare l'operatore della chiusura di kleene (*) sullo stesso simbolo più volte.
*/

grammar ReFollowedByList;

@header {
   package it.unicam.cs.compilatore_re.gen;
}

s
:
   regularExpr ',' stringsToCheck  # regularExprFollowedByStrings
;

regularExpr
:
    regularExpr '+' term # regularExprPlusTerm
    | term # fromRegularExprToTerm
;

term
:
   term u # termConcatU
   | u # fromTermToU
;

u
:
    w '*' # fromUToWKleen
    | w # fromUToW
;

w :
   ALPHDIGIT # fromWToAlphDigit
   | 'epsilon' # fromWToEpsilon
   | '(' regularExpr ')' # fromWToRegularExpr
   ;

stringsToCheck:
    string ',' stringsToCheck # sequenceFollowedByList
    | string # fromListToSequence
;

string:
   ALPHDIGIT string  # digitFollowedByString
   | ALPHDIGIT  # singleDigit
   ;

ALPHDIGIT :
   [a-zA-Z0-9]
   ;

WS
:
     [ \t\r\n]+ -> skip
;