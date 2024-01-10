package io.javaoperatorsdk.jenvtest.junit;

import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import org.junit.jupiter.api.extension.ExtendWith;

import io.javaoperatorsdk.jenvtest.KubeAPIServerConfig;

import static java.lang.annotation.ElementType.*;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

/**
 * For docs of attributes see {@link KubeAPIServerConfig}.
 */
@ExtendWith(KubeAPIServerExtension.class)
@Target({TYPE, METHOD, ANNOTATION_TYPE})
@Retention(RUNTIME)
public @interface EnableKubeAPIServer {

  String NOT_SET = "NOT_SET";

  String kubeAPIVersion() default NOT_SET;

  String[] apiServerFlags() default {};

  boolean updateKubeConfigFile() default false;
}
