package io.fabric8.kubernetes.api.model.runtime;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class RawExtensionBuilder extends RawExtensionFluent<RawExtensionBuilder> implements VisitableBuilder<RawExtension,RawExtensionBuilder>{

  RawExtensionFluent<?> fluent;

  public RawExtensionBuilder() {
    this(new RawExtension());
  }
  
  public RawExtensionBuilder(RawExtensionFluent<?> fluent) {
    this(fluent, new RawExtension());
  }
  
  public RawExtensionBuilder(RawExtension instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public RawExtensionBuilder(RawExtensionFluent<?> fluent,RawExtension instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public RawExtension build() {
    RawExtension buildable = new RawExtension(fluent.getValue());
    return buildable;
  }
  
}