package io.fabric8.openclustermanagement.api.model.operator.v1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class OverridesBuilder extends OverridesFluent<OverridesBuilder> implements VisitableBuilder<Overrides,OverridesBuilder>{

  OverridesFluent<?> fluent;

  public OverridesBuilder() {
    this(new Overrides());
  }
  
  public OverridesBuilder(OverridesFluent<?> fluent) {
    this(fluent, new Overrides());
  }
  
  public OverridesBuilder(Overrides instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public OverridesBuilder(OverridesFluent<?> fluent,Overrides instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public Overrides build() {
    Overrides buildable = new Overrides(fluent.buildComponents(), fluent.getImagePullPolicy());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}