package io.fabric8.openshift.api.model.installer.vsphere.v1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class HostBuilder extends HostFluent<HostBuilder> implements VisitableBuilder<Host,HostBuilder>{

  HostFluent<?> fluent;

  public HostBuilder() {
    this(new Host());
  }
  
  public HostBuilder(HostFluent<?> fluent) {
    this(fluent, new Host());
  }
  
  public HostBuilder(Host instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public HostBuilder(HostFluent<?> fluent,Host instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public Host build() {
    Host buildable = new Host(fluent.getFailureDomain(), fluent.buildNetworkDevice(), fluent.getRole());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}