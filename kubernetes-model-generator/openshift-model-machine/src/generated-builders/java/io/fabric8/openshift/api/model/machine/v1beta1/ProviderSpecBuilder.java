package io.fabric8.openshift.api.model.machine.v1beta1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class ProviderSpecBuilder extends ProviderSpecFluent<ProviderSpecBuilder> implements VisitableBuilder<ProviderSpec,ProviderSpecBuilder>{

  ProviderSpecFluent<?> fluent;

  public ProviderSpecBuilder() {
    this(new ProviderSpec());
  }
  
  public ProviderSpecBuilder(ProviderSpecFluent<?> fluent) {
    this(fluent, new ProviderSpec());
  }
  
  public ProviderSpecBuilder(ProviderSpec instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public ProviderSpecBuilder(ProviderSpecFluent<?> fluent,ProviderSpec instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public ProviderSpec build() {
    ProviderSpec buildable = new ProviderSpec(fluent.getValue());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}