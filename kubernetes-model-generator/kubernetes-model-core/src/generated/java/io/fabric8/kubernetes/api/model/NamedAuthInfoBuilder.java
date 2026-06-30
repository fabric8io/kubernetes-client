package io.fabric8.kubernetes.api.model;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class NamedAuthInfoBuilder extends NamedAuthInfoFluent<NamedAuthInfoBuilder> implements VisitableBuilder<NamedAuthInfo,NamedAuthInfoBuilder>{

  NamedAuthInfoFluent<?> fluent;

  public NamedAuthInfoBuilder() {
    this(new NamedAuthInfo());
  }
  
  public NamedAuthInfoBuilder(NamedAuthInfoFluent<?> fluent) {
    this(fluent, new NamedAuthInfo());
  }
  
  public NamedAuthInfoBuilder(NamedAuthInfo instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public NamedAuthInfoBuilder(NamedAuthInfoFluent<?> fluent,NamedAuthInfo instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public NamedAuthInfo build() {
    NamedAuthInfo buildable = new NamedAuthInfo(fluent.getName(), fluent.buildUser());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}