package io.github.javainpolish;

import io.github.javainpolish.language.impl.PolishLanguage;
import io.github.javainpolish.transformers.Transformer;
import io.github.javainpolish.transformers.impl.StringTransformer;

import java.io.File;
import java.util.Scanner;

public final class Main {
    public static void main(String[] args) {
        PolishLanguage polishLanguage = new PolishLanguage();
        System.out.println("Path to .java file:");
        Scanner scanner = new Scanner(System.in);
        String path = scanner.nextLine();
        File file = new File(path);
        Transformer<File, String> transformer = new StringTransformer();
        transformer.apply(polishLanguage).apply(file);
    }
}