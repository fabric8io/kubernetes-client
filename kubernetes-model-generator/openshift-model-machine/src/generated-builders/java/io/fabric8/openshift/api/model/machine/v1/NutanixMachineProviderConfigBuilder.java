package io.fabric8.openshift.api.model.machine.v1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class NutanixMachineProviderConfigBuilder extends NutanixMachineProviderConfigFluent<NutanixMachineProviderConfigBuilder> implements VisitableBuilder<NutanixMachineProviderConfig,NutanixMachineProviderConfigBuilder>{

  NutanixMachineProviderConfigFluent<?> fluent;

  public NutanixMachineProviderConfigBuilder() {
    this(new NutanixMachineProviderConfig());
  }
  
  public NutanixMachineProviderConfigBuilder(NutanixMachineProviderConfigFluent<?> fluent) {
    this(fluent, new NutanixMachineProviderConfig());
  }
  
  public NutanixMachineProviderConfigBuilder(NutanixMachineProviderConfig instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public NutanixMachineProviderConfigBuilder(NutanixMachineProviderConfigFluent<?> fluent,NutanixMachineProviderConfig instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public NutanixMachineProviderConfig build() {
    NutanixMachineProviderConfig buildable = new NutanixMachineProviderConfig(fluent.getApiVersion(), fluent.getBootType(), fluent.buildCategories(), fluent.buildCluster(), fluent.buildCredentialsSecret(), fluent.buildDataDisks(), fluent.buildFailureDomain(), fluent.buildGpus(), fluent.buildImage(), fluent.getKind(), fluent.getMemorySize(), fluent.buildMetadata(), fluent.buildProject(), fluent.buildSubnets(), fluent.getSystemDiskSize(), fluent.buildUserDataSecret(), fluent.getVcpuSockets(), fluent.getVcpusPerSocket());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}