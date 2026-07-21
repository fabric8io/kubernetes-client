package io.fabric8.istio.api.api.telemetry.v1alpha1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class ProviderRefBuilder extends ProviderRefFluent<ProviderRefBuilder> implements VisitableBuilder<ProviderRef,ProviderRefBuilder>{

  ProviderRefFluent<?> fluent;

  public ProviderRefBuilder() {
    this(new ProviderRef());
  }
  
  public ProviderRefBuilder(ProviderRefFluent<?> fluent) {
    this(fluent, new ProviderRef());
  }
  
  public ProviderRefBuilder(ProviderRef instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public ProviderRefBuilder(ProviderRefFluent<?> fluent,ProviderRef instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public ProviderRef build() {
    ProviderRef buildable = new ProviderRef(fluent.getName());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}