package io.fabric8.openshift.api.model.miscellaneous.cloudcredential.v1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class NutanixProviderStatusBuilder extends NutanixProviderStatusFluent<NutanixProviderStatusBuilder> implements VisitableBuilder<NutanixProviderStatus,NutanixProviderStatusBuilder>{

  NutanixProviderStatusFluent<?> fluent;

  public NutanixProviderStatusBuilder() {
    this(new NutanixProviderStatus());
  }
  
  public NutanixProviderStatusBuilder(NutanixProviderStatusFluent<?> fluent) {
    this(fluent, new NutanixProviderStatus());
  }
  
  public NutanixProviderStatusBuilder(NutanixProviderStatus instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public NutanixProviderStatusBuilder(NutanixProviderStatusFluent<?> fluent,NutanixProviderStatus instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public NutanixProviderStatus build() {
    NutanixProviderStatus buildable = new NutanixProviderStatus(fluent.getApiVersion(), fluent.getKind());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}