package io.fabric8.kubernetes.api.model;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class NamedExtensionBuilder extends NamedExtensionFluent<NamedExtensionBuilder> implements VisitableBuilder<NamedExtension,NamedExtensionBuilder>{

  NamedExtensionFluent<?> fluent;

  public NamedExtensionBuilder() {
    this(new NamedExtension());
  }
  
  public NamedExtensionBuilder(NamedExtensionFluent<?> fluent) {
    this(fluent, new NamedExtension());
  }
  
  public NamedExtensionBuilder(NamedExtension instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public NamedExtensionBuilder(NamedExtensionFluent<?> fluent,NamedExtension instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public NamedExtension build() {
    NamedExtension buildable = new NamedExtension(fluent.getExtension(), fluent.getName());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}