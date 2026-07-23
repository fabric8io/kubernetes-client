package io.fabric8.openshift.api.model.miscellaneous.metal3.v1alpha1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class BareMetalHostBuilder extends BareMetalHostFluent<BareMetalHostBuilder> implements VisitableBuilder<BareMetalHost,BareMetalHostBuilder>{

  BareMetalHostFluent<?> fluent;

  public BareMetalHostBuilder() {
    this(new BareMetalHost());
  }
  
  public BareMetalHostBuilder(BareMetalHostFluent<?> fluent) {
    this(fluent, new BareMetalHost());
  }
  
  public BareMetalHostBuilder(BareMetalHost instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public BareMetalHostBuilder(BareMetalHostFluent<?> fluent,BareMetalHost instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public BareMetalHost build() {
    BareMetalHost buildable = new BareMetalHost(fluent.getApiVersion(), fluent.getKind(), fluent.buildMetadata(), fluent.buildSpec(), fluent.buildStatus());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}