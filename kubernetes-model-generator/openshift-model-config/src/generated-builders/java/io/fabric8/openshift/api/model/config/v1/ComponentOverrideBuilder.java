package io.fabric8.openshift.api.model.config.v1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class ComponentOverrideBuilder extends ComponentOverrideFluent<ComponentOverrideBuilder> implements VisitableBuilder<ComponentOverride,ComponentOverrideBuilder>{

  ComponentOverrideFluent<?> fluent;

  public ComponentOverrideBuilder() {
    this(new ComponentOverride());
  }
  
  public ComponentOverrideBuilder(ComponentOverrideFluent<?> fluent) {
    this(fluent, new ComponentOverride());
  }
  
  public ComponentOverrideBuilder(ComponentOverride instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public ComponentOverrideBuilder(ComponentOverrideFluent<?> fluent,ComponentOverride instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public ComponentOverride build() {
    ComponentOverride buildable = new ComponentOverride(fluent.getGroup(), fluent.getKind(), fluent.getName(), fluent.getNamespace(), fluent.getUnmanaged());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}