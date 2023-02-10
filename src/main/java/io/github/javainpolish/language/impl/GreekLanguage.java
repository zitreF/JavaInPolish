package io.github.javainpolish.language.impl;

import io.github.javainpolish.language.Language;

import java.util.HashMap;
import java.util.Map;

public final class GreekLanguage implements Language {

    private final Map<String, String> dictionary;

    public GreekLanguage() {
        this.dictionary = new HashMap<>();
        dictionary.put("καθώς", "while");
        dictionary.put("αν", "if");
        dictionary.put("αληθής", "true");
        dictionary.put("ψευδής", "false");
        dictionary.put("δημόσια", "public");
        dictionary.put("ιδιωτικό", "private");
        dictionary.put("προστατευμένο", "protected");
        dictionary.put("στατική", "static");
        dictionary.put("κενό", "void");
        dictionary.put("διακοπή", "break");
        dictionary.put("συνέχισε", "continue");
        dictionary.put("άλλαξε", "switch");
        dictionary.put("τάξη", "class");
        dictionary.put("χόνδρος", "String");
        dictionary.put("τελικός", "final");
        dictionary.put("μηδενικό", "null");
        dictionary.put("δοκίμασε", "try");
        dictionary.put("άρπαξε", "catch");
        dictionary.put("ισοδυναμεί", "equals");
        dictionary.put("αποτύπωσε", "print");
        dictionary.put("αλλιώς", "else");
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
