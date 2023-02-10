package io.github.javainpolish.language.impl;

import io.github.javainpolish.language.Language;

import java.util.HashMap;
import java.util.Map;

public final class FrenchLanguage implements Language {

    private final Map<String, String> dictionary;

    public FrenchLanguage() {
        this.dictionary = new HashMap<>();
        dictionary.put("alors que", "while");
        dictionary.put("si", "if");
        dictionary.put("vrai", "true");
        dictionary.put("faux", "false");
        dictionary.put("public", "public");
        dictionary.put("privé", "private");
        dictionary.put("protégé", "protected");
        dictionary.put("statique", "static");
        dictionary.put("annuler", "void");
        dictionary.put("casser", "break");
        dictionary.put("continuer", "continue");
        dictionary.put("changer", "switch");
        dictionary.put("classe", "class");
        dictionary.put("Chaîne", "String");
        dictionary.put("final", "final");
        dictionary.put("nul", "null");
        dictionary.put("essayer", "try");
        dictionary.put("attraper", "catch");
        dictionary.put("équivaut à", "equals");
        dictionary.put("imprimer", "print");
        dictionary.put("autre", "else");
    }

    @Override
    public String translate(String context) {
        return dictionary.getOrDefault(context, context);
    }

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
