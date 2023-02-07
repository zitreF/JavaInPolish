package io.github.javainpolish.transformers.impl;

import io.github.javainpolish.language.Language;
import io.github.javainpolish.transformers.Transformer;

import java.io.*;
import java.util.Map;
import java.util.function.Function;

public final class StringTransformer implements Transformer<File, String> {

    @Override
    public Function<File, String> apply(Language language) {
        return file -> {
            StringBuilder translatedContent = new StringBuilder();
            try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
                String line;
                while ((line = reader.readLine()) != null) {
                    String translated = language.translateLine(line);
                    translatedContent.append(translated).append("\n");
                }
            } catch (IOException e) {
                e.printStackTrace();
            }

            try (FileWriter writer = new FileWriter(file)) {
                writer.write(translatedContent.toString());
            } catch (IOException e) {
                e.printStackTrace();
            }
            return translatedContent.toString();
        };
    }
}
