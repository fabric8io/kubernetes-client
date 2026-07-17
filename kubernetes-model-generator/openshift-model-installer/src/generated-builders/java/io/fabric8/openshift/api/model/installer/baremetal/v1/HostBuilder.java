package io.fabric8.openshift.api.model.installer.baremetal.v1;

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
    Host buildable = new Host(fluent.buildBmc(), fluent.getBootMACAddress(), fluent.getBootMode(), fluent.getHardwareProfile(), fluent.getName(), fluent.getNetworkConfig(), fluent.getRole(), fluent.buildRootDeviceHints());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}