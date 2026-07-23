package io.fabric8.openshift.api.model.machine.v1beta1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class GCPMachineProviderSpecBuilder extends GCPMachineProviderSpecFluent<GCPMachineProviderSpecBuilder> implements VisitableBuilder<GCPMachineProviderSpec,GCPMachineProviderSpecBuilder>{

  GCPMachineProviderSpecFluent<?> fluent;

  public GCPMachineProviderSpecBuilder() {
    this(new GCPMachineProviderSpec());
  }
  
  public GCPMachineProviderSpecBuilder(GCPMachineProviderSpecFluent<?> fluent) {
    this(fluent, new GCPMachineProviderSpec());
  }
  
  public GCPMachineProviderSpecBuilder(GCPMachineProviderSpec instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public GCPMachineProviderSpecBuilder(GCPMachineProviderSpecFluent<?> fluent,GCPMachineProviderSpec instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public GCPMachineProviderSpec build() {
    GCPMachineProviderSpec buildable = new GCPMachineProviderSpec(fluent.getApiVersion(), fluent.getCanIPForward(), fluent.getConfidentialCompute(), fluent.buildCredentialsSecret(), fluent.getDeletionProtection(), fluent.buildDisks(), fluent.buildGcpMetadata(), fluent.buildGpus(), fluent.getKind(), fluent.getLabels(), fluent.getMachineType(), fluent.buildMetadata(), fluent.buildNetworkInterfaces(), fluent.getOnHostMaintenance(), fluent.getPreemptible(), fluent.getProjectID(), fluent.getRegion(), fluent.buildResourceManagerTags(), fluent.getRestartPolicy(), fluent.buildServiceAccounts(), fluent.buildShieldedInstanceConfig(), fluent.getTags(), fluent.getTargetPools(), fluent.buildUserDataSecret(), fluent.getZone());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}