package io.fabric8.openshift.api.model.miscellaneous.cloudcredential.v1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class OvirtProviderStatusBuilder extends OvirtProviderStatusFluent<OvirtProviderStatusBuilder> implements VisitableBuilder<OvirtProviderStatus,OvirtProviderStatusBuilder>{

  OvirtProviderStatusFluent<?> fluent;

  public OvirtProviderStatusBuilder() {
    this(new OvirtProviderStatus());
  }
  
  public OvirtProviderStatusBuilder(OvirtProviderStatusFluent<?> fluent) {
    this(fluent, new OvirtProviderStatus());
  }
  
  public OvirtProviderStatusBuilder(OvirtProviderStatus instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public OvirtProviderStatusBuilder(OvirtProviderStatusFluent<?> fluent,OvirtProviderStatus instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public OvirtProviderStatus build() {
    OvirtProviderStatus buildable = new OvirtProviderStatus(fluent.getApiVersion(), fluent.getKind());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}