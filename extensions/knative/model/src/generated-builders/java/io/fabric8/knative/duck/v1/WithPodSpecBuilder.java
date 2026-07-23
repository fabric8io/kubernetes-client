package io.fabric8.knative.duck.v1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class WithPodSpecBuilder extends WithPodSpecFluent<WithPodSpecBuilder> implements VisitableBuilder<WithPodSpec,WithPodSpecBuilder>{

  WithPodSpecFluent<?> fluent;

  public WithPodSpecBuilder() {
    this(new WithPodSpec());
  }
  
  public WithPodSpecBuilder(WithPodSpecFluent<?> fluent) {
    this(fluent, new WithPodSpec());
  }
  
  public WithPodSpecBuilder(WithPodSpec instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public WithPodSpecBuilder(WithPodSpecFluent<?> fluent,WithPodSpec instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public WithPodSpec build() {
    WithPodSpec buildable = new WithPodSpec(fluent.buildTemplate());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}