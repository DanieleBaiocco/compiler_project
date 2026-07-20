package it.unicam.cs.compilatore_re;

import it.unicam.cs.compilatore_re.gen.ReFollowedByListLexer;
import it.unicam.cs.compilatore_re.gen.ReFollowedByListParser;
import it.unicam.cs.compilatore_re.semantic_analysis.ThompsonNFAEvalVisitor;
import it.unicam.cs.compilatore_re.semantic_analysis.ThompsonNFASynthAttr;

import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.tree.ParseTree;

import java.io.IOException;
import java.util.Arrays;

public class ThompsonNFARunner {

    public static void main(String[] args) throws IOException {

        CharStream input;

        /*
         * Modalità 1:
         *
         * ./gradlew run --args="a+bc a b bc ad"
         *
         * args[0] = regex
         * args[1...] = stringhe da controllare
         */
        if (args.length > 0) {

            if (args.length < 2) {
                System.err.println(
                        "Uso: <regex> <stringa1> [stringa2] ..."
                );

                System.err.println(
                        "Esempio: ./gradlew run --args=\"a+bc a b bc ad\""
                );

                System.exit(1);
                return;
            }

            String regex = args[0];

            String[] stringsToCheck =
                    Arrays.copyOfRange(args, 1, args.length);

            /*
             * Ricostruiamo il formato che la grammatica
             * ANTLR attuale si aspetta:
             *
             * regex, stringa1, stringa2, ...
             */
            String parserInput =
                    regex + ", " + String.join(", ", stringsToCheck);

            input = CharStreams.fromString(parserInput);

        } else {

            /*
             * Modalità 2:
             * manteniamo compatibilità con il vecchio comportamento.
             *
             * echo "a+bc, a, b, bc, ad" | ./gradlew run
             */
            input = CharStreams.fromStream(System.in);
        }

        ReFollowedByListLexer lexer =
                new ReFollowedByListLexer(input);

        CommonTokenStream tokens =
                new CommonTokenStream(lexer);

        ReFollowedByListParser parser =
                new ReFollowedByListParser(tokens);

        ParseTree parseTree = parser.s();

        ThompsonNFAEvalVisitor visitor =
                new ThompsonNFAEvalVisitor();

        ThompsonNFASynthAttr result =
                visitor.visit(parseTree);

        System.out.println(result.getResult());
    }
}