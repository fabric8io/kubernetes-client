package io.fabric8.openshift.api.model.miscellaneous.cloudcredential.v1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class NutanixProviderSpecBuilder extends NutanixProviderSpecFluent<NutanixProviderSpecBuilder> implements VisitableBuilder<NutanixProviderSpec,NutanixProviderSpecBuilder>{

  NutanixProviderSpecFluent<?> fluent;

  public NutanixProviderSpecBuilder() {
    this(new NutanixProviderSpec());
  }
  
  public NutanixProviderSpecBuilder(NutanixProviderSpecFluent<?> fluent) {
    this(fluent, new NutanixProviderSpec());
  }
  
  public NutanixProviderSpecBuilder(NutanixProviderSpec instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public NutanixProviderSpecBuilder(NutanixProviderSpecFluent<?> fluent,NutanixProviderSpec instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public NutanixProviderSpec build() {
    NutanixProviderSpec buildable = new NutanixProviderSpec(fluent.getApiVersion(), fluent.getKind());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}