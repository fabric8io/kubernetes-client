package io.javaoperatorsdk.jenvtest.junit;

import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import static java.lang.annotation.ElementType.*;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

/**
 * Used to annotate String field in JUnit test to inject Kube Config yaml.
 */
@Target({FIELD})
@Retention(RUNTIME)
public @interface KubeConfig {

}
