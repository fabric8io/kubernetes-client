package io.fabric8.openshift.api.model.miscellaneous.cloudcredential.v1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class OvirtProviderSpecBuilder extends OvirtProviderSpecFluent<OvirtProviderSpecBuilder> implements VisitableBuilder<OvirtProviderSpec,OvirtProviderSpecBuilder>{

  OvirtProviderSpecFluent<?> fluent;

  public OvirtProviderSpecBuilder() {
    this(new OvirtProviderSpec());
  }
  
  public OvirtProviderSpecBuilder(OvirtProviderSpecFluent<?> fluent) {
    this(fluent, new OvirtProviderSpec());
  }
  
  public OvirtProviderSpecBuilder(OvirtProviderSpec instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public OvirtProviderSpecBuilder(OvirtProviderSpecFluent<?> fluent,OvirtProviderSpec instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public OvirtProviderSpec build() {
    OvirtProviderSpec buildable = new OvirtProviderSpec(fluent.getApiVersion(), fluent.getKind());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}