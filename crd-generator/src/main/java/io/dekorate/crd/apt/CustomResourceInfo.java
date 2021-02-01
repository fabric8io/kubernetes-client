package io.dekorate.crd.apt;

import io.dekorate.crd.config.Scope;
import io.fabric8.kubernetes.api.model.Namespaced;
import io.fabric8.kubernetes.client.utils.Pluralize;
import io.fabric8.kubernetes.model.annotation.Group;
import io.fabric8.kubernetes.model.annotation.Kind;
import io.fabric8.kubernetes.model.annotation.Plural;
import io.fabric8.kubernetes.model.annotation.ShortNames;
import io.fabric8.kubernetes.model.annotation.Singular;
import io.fabric8.kubernetes.model.annotation.Version;
import java.util.Locale;
import java.util.Optional;
import javax.annotation.processing.ProcessingEnvironment;
import javax.lang.model.element.TypeElement;

public class CustomResourceInfo {

  private final TypeElement customResource;
  private final TypeElement spec;
  private final TypeElement status;
  private final String group;
  private final String version;
  private final ProcessingEnvironment env;

  public CustomResourceInfo(
    TypeElement customResource,
    TypeElement spec,
    TypeElement status,
    ProcessingEnvironment env) {
    this.customResource = customResource;
    this.spec = spec;
    this.status = status;
    this.group = customResource.getAnnotation(Group.class).value();
    this.version = customResource.getAnnotation(Version.class).value();
    this.env = env;
  }


  public boolean storage() {
    return customResource.getAnnotation(Version.class).storage();
  }

  public boolean served() {
    return customResource.getAnnotation(Version.class).served();
  }

  public String key() {
    return crdName();
  }

  public Scope scope() {
    return customResource.getInterfaces().stream()
      .filter(t -> t.toString().equals(Namespaced.class.getTypeName()))
      .map(t -> Scope.Namespaced).findFirst().orElse(Scope.Cluster);
  }

  public String crdName() {
    return plural() + "." + group;
  }

  public String[] shortNames() {
    return Optional.ofNullable(customResource.getAnnotation(ShortNames.class))
      .map(ShortNames::value)
      .orElse(new String[]{});
  }

  public String singular() {
    return Optional.ofNullable(customResource.getAnnotation(Singular.class))
      .map(Singular::value)
      .orElse(kind().toLowerCase(Locale.ROOT));
  }

  public String plural() {
    return Optional.ofNullable(customResource.getAnnotation(Plural.class))
      .map(Plural::value)
      .map(s -> s.toLowerCase(Locale.ROOT))
      .orElse(Pluralize.toPlural(singular()));
  }

  public String kind() {
    return Optional.ofNullable(customResource.getAnnotation(Kind.class))
      .map(Kind::value)
      .orElse(customResource.getSimpleName().toString());
  }

  public boolean deprecated() {
    return env.getElementUtils().isDeprecated(customResource);
  }

  public String version() {
    return version;
  }

  public String group() {
    return group;
  }

  public TypeElement status() {
    return status;
  }
}
