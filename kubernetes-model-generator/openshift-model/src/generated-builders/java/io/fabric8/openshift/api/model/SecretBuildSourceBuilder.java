package io.fabric8.openshift.api.model;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class SecretBuildSourceBuilder extends SecretBuildSourceFluent<SecretBuildSourceBuilder> implements VisitableBuilder<SecretBuildSource,SecretBuildSourceBuilder>{

  SecretBuildSourceFluent<?> fluent;

  public SecretBuildSourceBuilder() {
    this(new SecretBuildSource());
  }
  
  public SecretBuildSourceBuilder(SecretBuildSourceFluent<?> fluent) {
    this(fluent, new SecretBuildSource());
  }
  
  public SecretBuildSourceBuilder(SecretBuildSource instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public SecretBuildSourceBuilder(SecretBuildSourceFluent<?> fluent,SecretBuildSource instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public SecretBuildSource build() {
    SecretBuildSource buildable = new SecretBuildSource(fluent.getDestinationDir(), fluent.buildSecret());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}