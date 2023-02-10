package io.github.javainpolish;

import io.github.javainpolish.compiler.CompilerInfo;
import io.github.javainpolish.compiler.JavaFileCompiler;
import io.github.javainpolish.language.Language;
import io.github.javainpolish.language.impl.FrenchLanguage;
import io.github.javainpolish.language.impl.GreekLanguage;
import io.github.javainpolish.language.impl.PolishLanguage;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public final class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Choose language:");
        String lang = scanner.nextLine();
        Language language = switch (lang.toLowerCase()) {
            case "polish" -> new PolishLanguage();
            case "french" -> new FrenchLanguage();
            case "greek" -> new GreekLanguage();
            default -> null;
        };
        if (language == null) {
            System.out.println("No language found!");
            main(args);
            return;
        }
        System.out.println("Path to .java file:");
        String path = scanner.nextLine();
        File file = new File(path);

        JavaFileCompiler javaFileCompiler = new JavaFileCompiler();

        CompilerInfo info = javaFileCompiler.compile(file);

        if (info == null) return;

        javaFileCompiler.run(info);
    }
}