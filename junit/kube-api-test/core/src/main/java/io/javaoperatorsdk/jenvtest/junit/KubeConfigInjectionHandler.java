package io.javaoperatorsdk.jenvtest.junit;

import java.lang.reflect.Field;
import java.util.Arrays;
import java.util.Optional;
import java.util.stream.Collectors;

import org.junit.jupiter.api.extension.ExtensionContext;

import io.javaoperatorsdk.jenvtest.JenvtestException;
import io.javaoperatorsdk.jenvtest.KubeAPIServer;

public class KubeConfigInjectionHandler implements ClientInjectionHandler {

  public boolean isTargetFieldAvailable(ExtensionContext extensionContext,
      boolean staticField) {
    return getFieldForKubeConfigInjection(extensionContext, staticField).isPresent();
  }

  public void inject(ExtensionContext extensionContext,
      boolean staticField, KubeAPIServer kubeApiServer) {
    var field = getFieldForKubeConfigInjection(extensionContext, staticField).orElseThrow();
    setKubeConfigYamlToField(extensionContext, field, kubeApiServer);
  }

  private void setKubeConfigYamlToField(ExtensionContext extensionContext,
      Field kubeConfigField, KubeAPIServer kubeApiServer) {
    try {
      var target = extensionContext.getTestInstance()
          .orElseGet(() -> extensionContext.getTestClass().orElseThrow());
      kubeConfigField.setAccessible(true);
      kubeConfigField.set(target,
          kubeApiServer.getKubeConfigYaml());
    } catch (IllegalAccessException e) {
      throw new JenvtestException(e);
    }
  }

  public Optional<Field> getFieldForKubeConfigInjection(ExtensionContext extensionContext,
      boolean staticField) {
    Class<?> clazz = extensionContext.getTestClass().orElseThrow();
    var kubeConfigFields = Arrays.stream(clazz.getDeclaredFields())
        .filter(f -> f.getAnnotationsByType(KubeConfig.class).length > 0)
        .collect(Collectors.toList());
    if (kubeConfigFields.isEmpty()) {
      return Optional.empty();
    }
    if (kubeConfigFields.size() > 1) {
      throw new JenvtestException(
          "More fields annotation with @" + KubeConfig.class.getSimpleName() + " annotation");
    }
    var field = kubeConfigFields.get(0);
    if (!field.getType().equals(String.class)) {
      throw new JenvtestException(
          "Field annotated with @" + KubeConfig.class.getSimpleName() + " is not a String");
    }

    if (java.lang.reflect.Modifier.isStatic(field.getModifiers()) != staticField) {
      return Optional.empty();
    } else {
      return Optional.of(field);
    }
  }

}
