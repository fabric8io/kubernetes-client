package io.fabric8.knative.internal.networking.v1alpha1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class IngressBackendSplitBuilder extends IngressBackendSplitFluent<IngressBackendSplitBuilder> implements VisitableBuilder<IngressBackendSplit,IngressBackendSplitBuilder>{

  IngressBackendSplitFluent<?> fluent;

  public IngressBackendSplitBuilder() {
    this(new IngressBackendSplit());
  }
  
  public IngressBackendSplitBuilder(IngressBackendSplitFluent<?> fluent) {
    this(fluent, new IngressBackendSplit());
  }
  
  public IngressBackendSplitBuilder(IngressBackendSplit instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public IngressBackendSplitBuilder(IngressBackendSplitFluent<?> fluent,IngressBackendSplit instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public IngressBackendSplit build() {
    IngressBackendSplit buildable = new IngressBackendSplit(fluent.getAppendHeaders(), fluent.getPercent(), fluent.getServiceName(), fluent.getServiceNamespace(), fluent.buildServicePort());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}