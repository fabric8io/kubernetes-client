package io.fabric8.knative.duck.v1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class BindingSpecBuilder extends BindingSpecFluent<BindingSpecBuilder> implements VisitableBuilder<BindingSpec,BindingSpecBuilder>{

  BindingSpecFluent<?> fluent;

  public BindingSpecBuilder() {
    this(new BindingSpec());
  }
  
  public BindingSpecBuilder(BindingSpecFluent<?> fluent) {
    this(fluent, new BindingSpec());
  }
  
  public BindingSpecBuilder(BindingSpec instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public BindingSpecBuilder(BindingSpecFluent<?> fluent,BindingSpec instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public BindingSpec build() {
    BindingSpec buildable = new BindingSpec(fluent.buildSubject());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}