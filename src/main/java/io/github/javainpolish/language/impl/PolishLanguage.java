package io.github.javainpolish.language.impl;

import io.github.javainpolish.language.Language;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public final class PolishLanguage implements Language {

    private final Map<String, String> dictionary;

    public PolishLanguage() {
        this.dictionary = new HashMap<>();
        dictionary.put("gdy", "while");
        dictionary.put("jeżeli", "if");
        dictionary.put("prawda", "true");
        dictionary.put("fałsz", "false");
        dictionary.put("publiczna", "public");
        dictionary.put("prywatna", "private");
        dictionary.put("chroniona", "protected");
        dictionary.put("statyczna", "static");
        dictionary.put("próżnia", "void");
        dictionary.put("zniszcz", "break");
        dictionary.put("kontynuuj", "continue");
        dictionary.put("przełącz", "switch");
        dictionary.put("klasa", "class");
        dictionary.put("sieć", "String");
        dictionary.put("finalna", "final");
        dictionary.put("zero", "null");
        dictionary.put("próba", "try");
        dictionary.put("złap", "catch");
        dictionary.put("równaSię", "equals");
        dictionary.put("drukuj", "print");
        dictionary.put("w przeciwnym razie", "else");
    }

    @Override
    public String translate(String context) {
        return dictionary.getOrDefault(context, context);
    }

    @Override
    public String translateLine(String context) {
        String[] parts = context.split("\"");
        for (int i = 0; i < parts.length; i++) {
            if (i % 2 == 0) {
                for (Map.Entry<String, String> entry : dictionary.entrySet()) {
                    parts[i] = parts[i].replaceAll(entry.getKey(), entry.getValue());
                }
            }
        }
        return String.join("\"", parts);
    }
}
