package io.fabric8.openshift.api.model.installer.ibmcloud.v1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class DedicatedHostBuilder extends DedicatedHostFluent<DedicatedHostBuilder> implements VisitableBuilder<DedicatedHost,DedicatedHostBuilder>{

  DedicatedHostFluent<?> fluent;

  public DedicatedHostBuilder() {
    this(new DedicatedHost());
  }
  
  public DedicatedHostBuilder(DedicatedHostFluent<?> fluent) {
    this(fluent, new DedicatedHost());
  }
  
  public DedicatedHostBuilder(DedicatedHost instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public DedicatedHostBuilder(DedicatedHostFluent<?> fluent,DedicatedHost instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public DedicatedHost build() {
    DedicatedHost buildable = new DedicatedHost(fluent.getName(), fluent.getProfile());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}