package io.fabric8.openshift.api.model.machine.v1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class PowerVSMachineProviderConfigBuilder extends PowerVSMachineProviderConfigFluent<PowerVSMachineProviderConfigBuilder> implements VisitableBuilder<PowerVSMachineProviderConfig,PowerVSMachineProviderConfigBuilder>{

  PowerVSMachineProviderConfigFluent<?> fluent;

  public PowerVSMachineProviderConfigBuilder() {
    this(new PowerVSMachineProviderConfig());
  }
  
  public PowerVSMachineProviderConfigBuilder(PowerVSMachineProviderConfigFluent<?> fluent) {
    this(fluent, new PowerVSMachineProviderConfig());
  }
  
  public PowerVSMachineProviderConfigBuilder(PowerVSMachineProviderConfig instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public PowerVSMachineProviderConfigBuilder(PowerVSMachineProviderConfigFluent<?> fluent,PowerVSMachineProviderConfig instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public PowerVSMachineProviderConfig build() {
    PowerVSMachineProviderConfig buildable = new PowerVSMachineProviderConfig(fluent.getApiVersion(), fluent.buildCredentialsSecret(), fluent.buildImage(), fluent.getKeyPairName(), fluent.getKind(), fluent.buildLoadBalancers(), fluent.getMemoryGiB(), fluent.buildMetadata(), fluent.buildNetwork(), fluent.getProcessorType(), fluent.buildProcessors(), fluent.buildServiceInstance(), fluent.getSystemType(), fluent.buildUserDataSecret());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}