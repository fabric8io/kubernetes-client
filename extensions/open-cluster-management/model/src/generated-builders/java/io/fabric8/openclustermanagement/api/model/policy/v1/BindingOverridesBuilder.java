package io.fabric8.openclustermanagement.api.model.policy.v1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class BindingOverridesBuilder extends BindingOverridesFluent<BindingOverridesBuilder> implements VisitableBuilder<BindingOverrides,BindingOverridesBuilder>{

  BindingOverridesFluent<?> fluent;

  public BindingOverridesBuilder() {
    this(new BindingOverrides());
  }
  
  public BindingOverridesBuilder(BindingOverridesFluent<?> fluent) {
    this(fluent, new BindingOverrides());
  }
  
  public BindingOverridesBuilder(BindingOverrides instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public BindingOverridesBuilder(BindingOverridesFluent<?> fluent,BindingOverrides instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public BindingOverrides build() {
    BindingOverrides buildable = new BindingOverrides(fluent.getRemediationAction());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}