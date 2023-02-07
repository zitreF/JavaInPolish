package io.github.javainpolish.transformers;

import io.github.javainpolish.language.Language;

import java.util.function.Function;

public interface Transformer<E, T> {

    Function<E, T> apply(Language language);
}
