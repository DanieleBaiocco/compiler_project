# Compilatore di espressioni regolari con NFA di Thompson

## Panoramica

Questo progetto è un piccolo compilatore e valutatore di espressioni regolari scritto in Java. Il suo obiettivo è mostrare in modo concreto come un'espressione regolare possa essere analizzata e trasformata in un **automa a stati finiti non deterministico (NFA)** tramite la **costruzione di Thompson**, e come tale automa possa poi essere utilizzato per stabilire se una o più stringhe appartengono al linguaggio descritto dall'espressione regolare.

Il progetto segue una semplice pipeline simile a quella di un compilatore:

1. Viene letta un'espressione regolare insieme a una o più stringhe da verificare.
2. **ANTLR** esegue l'analisi lessicale e sintattica dell'input secondo la grammatica definita in `ReFollowedByList.g4`.
3. Un visitor attraversa il parse tree generato e costruisce un NFA di Thompson.
4. Ogni stringa in input viene valutata simulando l'NFA, comprese le necessarie epsilon-closure.
5. Il programma stampa `OK` per ogni stringa accettata e `KO` per ogni stringa rifiutata, mantenendo l'ordine originale degli input.

Il progetto è quindi utile come esempio didattico di parsing, traduzione guidata dalla sintassi, linguaggi regolari, costruzione di Thompson, epsilon-transizioni e simulazione di un NFA.

## Sintassi supportata per le espressioni regolari

La grammatica supporta i seguenti costrutti:

| Sintassi | Significato | Esempio |
|---|---|---|
| `a`, `b`, `0`, ... | Un singolo simbolo alfanumerico | `a` |
| `epsilon` | La transizione sulla stringa vuota | `epsilon` |
| `r+s` | Unione: riconosce `r` oppure `s` | `a+b` |
| `rs` | Concatenazione: `r` seguito da `s` | `ab` |
| `r*` | Chiusura di Kleene: zero o più ripetizioni di `r` | `a*` |
| `(r)` | Raggruppamento | `(a+b)c` |

La precedenza degli operatori è:

1. Chiusura di Kleene `*`
2. Concatenazione
3. Unione `+`

Concatenazione e unione sono associative a sinistra. Per esempio, `ab+c` viene interpretata come `(ab)+c`, mentre `a+bc` viene interpretata come `a+(bc)`.

> **Nota:** in questa grammatica, `+` indica l'**unione**, non "una o più ripetizioni" come avviene in alcuni moderni motori di espressioni regolari.

L'alfabeto supportato è limitato a lettere maiuscole, lettere minuscole e cifre. La grammatica attuale non supporta funzionalità come `.`, `?`, classi di caratteri (`[a-z]`), caratteri di escape, ancore o altri operatori avanzati delle espressioni regolari.

## Struttura del progetto

I file più rilevanti sono:

```text
src/main/java/it/unicam/cs/compilatore_re/
├── ThompsonNFARunner.java
├── ReFollowedByList.g4
├── gen/
│   └── ... classi lexer/parser generate da ANTLR
├── semantic_analysis/
│   ├── ThompsonNFAEvalVisitor.java
│   └── ThompsonNFASynthAttr.java
└── thompsonNFA/
    ├── ThompsonNFA.java
    ├── NFAState.java
    ├── NFATransition.java
    ├── StateEnum.java
    └── StateNameGenerator.java
```

`ThompsonNFARunner` è il punto di ingresso da riga di comando. Il parser ANTLR riconosce l'espressione regolare e le stringhe da verificare, `ThompsonNFAEvalVisitor` traduce l'espressione regolare analizzata in un automa e `ThompsonNFA` implementa le operazioni sull'automa e l'algoritmo di accettazione.

## Requisiti

Sono necessari:

- un JDK Java installato e disponibile da riga di comando;
- una connessione a Internet alla prima esecuzione del Gradle Wrapper, nel caso in cui Gradle 8.5 non sia già presente nella cache locale.

Non è necessario installare Gradle manualmente perché il repository include il Gradle Wrapper (`gradlew` / `gradlew.bat`).

## Esecuzione del progetto

Apri un terminale nella directory principale del progetto.

### Linux, macOS o Git Bash

```bash
./gradlew run --args="<regex> <stringa1> <stringa2> ..."
```

Per esempio:

```bash
./gradlew run --args="a+bc a b bc ad"
```

### Windows PowerShell o Prompt dei comandi

```powershell
.\gradlew.bat run --args="<regex> <stringa1> <stringa2> ..."
```

Per esempio:

```powershell
.\gradlew.bat run --args="a+bc a b bc ad"
```

Il primo argomento è sempre l'espressione regolare. Ogni argomento successivo è una stringa che verrà verificata rispetto a tale espressione regolare.

Deve essere fornita almeno una stringa da verificare.

## Formato dell'output

Il programma stampa un risultato per ogni stringa verificata:

- `OK` significa che la stringa è accettata dall'NFA generato a partire dall'espressione regolare;
- `KO` significa che la stringa viene rifiutata.

I risultati sono separati da virgole e compaiono nello stesso ordine delle stringhe fornite in input.

Per esempio:

```text
OK, KO, OK, KO
```

significa che la prima e la terza stringa sono state accettate, mentre la seconda e la quarta sono state rifiutate.

## Esempi di esecuzione

### Esempio 1 — Unione e concatenazione

Comando:

```bash
./gradlew run --args="a+bc a b bc ad"
```

L'espressione regolare `a+bc` significa: accetta `a` oppure la concatenazione `bc`.

Output atteso:

```text
OK, KO, OK, KO
```

Spiegazione:

- `a` → `OK`
- `b` → `KO`
- `bc` → `OK`
- `ad` → `KO`

### Esempio 2 — Chiusura di Kleene

Comando:

```bash
./gradlew run --args="ab* a ab abb abbb b"
```

L'espressione regolare `ab*` significa: una `a`, seguita da zero o più caratteri `b`.

Output atteso:

```text
OK, OK, OK, OK, KO
```

Spiegazione:

- `a` → `OK`, perché `b*` può riconoscere zero caratteri `b`
- `ab` → `OK`
- `abb` → `OK`
- `abbb` → `OK`
- `b` → `KO`

### Esempio 3 — Parentesi e unione

Comando:

```bash
./gradlew run --args="(a+b)c ac bc a abc"
```

L'espressione regolare `(a+b)c` significa: `a` oppure `b`, seguita da `c`.

Output atteso:

```text
OK, OK, KO, KO
```

Spiegazione:

- `ac` → `OK`
- `bc` → `OK`
- `a` → `KO`
- `abc` → `KO`

### Esempio 4 — Transizione epsilon

Comando:

```bash
./gradlew run --args="a(epsilon+b) a ab b aa"
```

L'espressione `a(epsilon+b)` significa: `a` seguita da `epsilon` oppure da `b`. In pratica, accetta `a` e `ab`.

Output atteso:

```text
OK, OK, KO, KO
```

Spiegazione:

- `a` → `OK`
- `ab` → `OK`
- `b` → `KO`
- `aa` → `KO`

## Lettura dell'input dallo standard input

Il programma mantiene anche la compatibilità con il formato originale separato da virgole tramite lo standard input.

Esempio:

```bash
echo "a+bc, a, b, bc, ad" | ./gradlew run
```

Output atteso:

```text
OK, KO, OK, KO
```

In questa modalità, la sintassi attesa dalla grammatica ANTLR è:

```text
<regex>, <stringa1>, <stringa2>, ...
```

La modalità `--args` è generalmente più comoda per il normale utilizzo da riga di comando, perché `ThompsonNFARunner` converte automaticamente gli argomenti posizionali in questo formato interno separato da virgole.

## Esecuzione dei test

Per eseguire la suite di test:

### Linux, macOS o Git Bash

```bash
./gradlew test
```

### Windows PowerShell o Prompt dei comandi

```powershell
.\gradlew.bat test
```

Il test incluso verifica, tra le altre cose, che l'espressione `a+bc` produca correttamente:

```text
OK, KO, OK, KO
```

per le stringhe `a`, `b`, `bc` e `ad`.

## Come funziona l'algoritmo di accettazione

Dopo che l'espressione regolare è stata tradotta in un NFA di Thompson, il programma valuta ogni stringa un carattere alla volta.

Per prima cosa calcola l'**epsilon-closure** dello stato iniziale, cioè tutti gli stati raggiungibili senza consumare alcun carattere dell'input. Successivamente, per ogni carattere della stringa, segue le transizioni compatibili e calcola nuovamente l'epsilon-closure dei nuovi stati raggiunti.

Quando tutti i caratteri sono stati consumati, la stringa viene accettata soltanto se almeno uno degli stati correnti è uno stato finale.

Per questo motivo il progetto non ha bisogno di convertire l'NFA in un DFA prima di verificare le stringhe: l'automa non deterministico viene simulato direttamente.

## Limitazioni attuali

Questo progetto implementa intenzionalmente un piccolo linguaggio di espressioni regolari, invece della sintassi completa dei motori regex utilizzati in produzione.

In particolare:

- i simboli di input sono limitati a caratteri alfanumerici;
- le stringhe da verificare devono essere stringhe alfanumeriche non vuote secondo la grammatica attuale;
- anche se `epsilon` è supportato all'interno delle espressioni regolari, la grammatica di input attuale non fornisce un modo diretto per inserire la stringa vuota stessa nella lista delle stringhe da verificare;
- gli operatori regex avanzati e i caratteri di escape non sono implementati;
- operatori di Kleene ripetuti come `a**` non sono accettati dalla grammatica.

Questi vincoli mantengono il progetto focalizzato sui concetti fondamentali dei linguaggi formali, del parsing e degli automi di Thompson.
