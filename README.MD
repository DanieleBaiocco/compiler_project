# Thompson NFA Regular Expression Compiler

## Overview

This project is a small regular-expression compiler and evaluator written in Java. Its goal is to show, in a concrete way, how a regular expression can be parsed and transformed into a **non-deterministic finite automaton (NFA)** using **Thompson's construction**, and then how that automaton can be used to decide whether one or more input strings belong to the language described by the regular expression.

The project follows a simple compiler-like pipeline:

1. A regular expression is read together with one or more strings to test.
2. **ANTLR** tokenizes and parses the input according to the grammar defined in `ReFollowedByList.g4`.
3. A visitor walks the generated parse tree and builds a Thompson NFA.
4. Each input string is evaluated by simulating the NFA, including the required epsilon-closures.
5. The program prints `OK` for every accepted string and `KO` for every rejected string, preserving the original input order.

The project is therefore useful as an educational example of parsing, syntax-directed translation, regular languages, Thompson's construction, epsilon-transitions, and NFA simulation.

## Supported regular-expression syntax

The grammar supports the following constructs:

| Syntax | Meaning | Example |
|---|---|---|
| `a`, `b`, `0`, ... | A single alphanumeric symbol | `a` |
| `epsilon` | The empty-string transition | `epsilon` |
| `r+s` | Union: matches either `r` or `s` | `a+b` |
| `rs` | Concatenation: `r` followed by `s` | `ab` |
| `r*` | Kleene closure: zero or more repetitions of `r` | `a*` |
| `(r)` | Grouping | `(a+b)c` |

Operator precedence is:

1. Kleene closure `*`
2. Concatenation
3. Union `+`

Concatenation and union are left-associative. For example, `ab+c` is interpreted as `(ab)+c`, while `a+bc` is interpreted as `a+(bc)`.

> **Note:** in this grammar, `+` means **union**, not "one or more repetitions" as it does in some modern regular-expression engines.

The supported alphabet is limited to uppercase and lowercase letters and digits. The current grammar does not support features such as `.`, `?`, character classes (`[a-z]`), escaped characters, anchors, or other advanced regular-expression operators.

## Project structure

The most relevant files are:

```text
src/main/java/it/unicam/cs/compilatore_re/
├── ThompsonNFARunner.java
├── ReFollowedByList.g4
├── gen/
│   └── ... ANTLR-generated lexer/parser classes
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

`ThompsonNFARunner` is the command-line entry point. The ANTLR parser recognizes the regular expression and the strings to test, `ThompsonNFAEvalVisitor` translates the parsed regular expression into an automaton, and `ThompsonNFA` implements the automaton operations and the acceptance algorithm.

## Requirements

You need:

- a Java JDK installed and available from the command line;
- an Internet connection on the first Gradle Wrapper execution, if Gradle 8.5 is not already cached locally.

You do **not** need to install Gradle manually because the repository includes the Gradle Wrapper (`gradlew` / `gradlew.bat`).

## Running the project

Open a terminal in the root directory of the project.

### Linux, macOS, or Git Bash

```bash
./gradlew run --args="<regex> <string1> <string2> ..."
```

For example:

```bash
./gradlew run --args="a+bc a b bc ad"
```

### Windows PowerShell or Command Prompt

```powershell
.\gradlew.bat run --args="<regex> <string1> <string2> ..."
```

For example:

```powershell
.\gradlew.bat run --args="a+bc a b bc ad"
```

The first argument is always the regular expression. Every following argument is a string that will be checked against that regular expression.

At least one string to test must be provided.

## Output format

The program prints one result for each tested string:

- `OK` means that the string is accepted by the NFA generated from the regular expression;
- `KO` means that the string is rejected.

Results are separated by commas and appear in the same order as the input strings.

For example:

```text
OK, KO, OK, KO
```

means that the first and third strings were accepted, while the second and fourth were rejected.

## Execution examples

### Example 1 — Union and concatenation

Command:

```bash
./gradlew run --args="a+bc a b bc ad"
```

The regular expression `a+bc` means: accept either `a` or the concatenation `bc`.

Expected output:

```text
OK, KO, OK, KO
```

Explanation:

- `a` → `OK`
- `b` → `KO`
- `bc` → `OK`
- `ad` → `KO`

### Example 2 — Kleene closure

Command:

```bash
./gradlew run --args="ab* a ab abb abbb b"
```

The regular expression `ab*` means: one `a`, followed by zero or more `b` characters.

Expected output:

```text
OK, OK, OK, OK, KO
```

Explanation:

- `a` → `OK`, because `b*` may match zero `b` characters
- `ab` → `OK`
- `abb` → `OK`
- `abbb` → `OK`
- `b` → `KO`

### Example 3 — Parentheses and union

Command:

```bash
./gradlew run --args="(a+b)c ac bc a abc"
```

The regular expression `(a+b)c` means: either `a` or `b`, followed by `c`.

Expected output:

```text
OK, OK, KO, KO
```

Explanation:

- `ac` → `OK`
- `bc` → `OK`
- `a` → `KO`
- `abc` → `KO`

### Example 4 — Epsilon transition

Command:

```bash
./gradlew run --args="a(epsilon+b) a ab b aa"
```

The expression `a(epsilon+b)` means: `a` followed either by `epsilon` or by `b`. In practice, it accepts `a` and `ab`.

Expected output:

```text
OK, OK, KO, KO
```

Explanation:

- `a` → `OK`
- `ab` → `OK`
- `b` → `KO`
- `aa` → `KO`

## Reading input from standard input

The program also keeps compatibility with the original comma-separated input format through standard input.

Example:

```bash
echo "a+bc, a, b, bc, ad" | ./gradlew run
```

Expected output:

```text
OK, KO, OK, KO
```

In this mode, the syntax expected by the ANTLR grammar is:

```text
<regex>, <string1>, <string2>, ...
```

The `--args` mode is generally more convenient for normal command-line usage because `ThompsonNFARunner` automatically converts the positional arguments into this internal comma-separated format.

## Running the tests

To run the test suite:

### Linux, macOS, or Git Bash

```bash
./gradlew test
```

### Windows PowerShell or Command Prompt

```powershell
.\gradlew.bat test
```

The included test verifies, among other things, that the expression `a+bc` correctly produces:

```text
OK, KO, OK, KO
```

for the strings `a`, `b`, `bc`, and `ad`.

## How the acceptance algorithm works

After the regular expression has been translated into a Thompson NFA, the program evaluates each string one character at a time.

It first computes the **epsilon-closure** of the initial state: all states that can be reached without consuming any input character. Then, for each character in the string, it follows the compatible transitions and computes the epsilon-closure again for the newly reached states.

When all characters have been consumed, the string is accepted only if at least one of the current states is a final state.

This is the reason the project does not need to convert the NFA into a DFA before testing strings: the non-deterministic automaton is simulated directly.

## Current limitations

This project intentionally implements a small regular-expression language rather than the full syntax of production regex engines.

In particular:

- input symbols are limited to alphanumeric characters;
- strings to test must be non-empty alphanumeric strings according to the current grammar;
- although `epsilon` is supported inside regular expressions, the current input grammar does not provide a direct way to include the empty string itself in the list of strings to test;
- advanced regex operators and escaping are not implemented;
- repeated Kleene operators such as `a**` are not accepted by the grammar.

These constraints keep the project focused on the core concepts of formal languages, parsing, and Thompson automata.
