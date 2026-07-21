package io.fabric8.knative.duck.v1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class WithPodBuilder extends WithPodFluent<WithPodBuilder> implements VisitableBuilder<WithPod,WithPodBuilder>{

  WithPodFluent<?> fluent;

  public WithPodBuilder() {
    this(new WithPod());
  }
  
  public WithPodBuilder(WithPodFluent<?> fluent) {
    this(fluent, new WithPod());
  }
  
  public WithPodBuilder(WithPod instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public WithPodBuilder(WithPodFluent<?> fluent,WithPod instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public WithPod build() {
    WithPod buildable = new WithPod(fluent.getApiVersion(), fluent.getKind(), fluent.buildMetadata(), fluent.buildSpec());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}