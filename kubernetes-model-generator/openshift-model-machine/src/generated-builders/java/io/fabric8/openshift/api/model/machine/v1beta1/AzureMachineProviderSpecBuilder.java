package io.fabric8.openshift.api.model.machine.v1beta1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class AzureMachineProviderSpecBuilder extends AzureMachineProviderSpecFluent<AzureMachineProviderSpecBuilder> implements VisitableBuilder<AzureMachineProviderSpec,AzureMachineProviderSpecBuilder>{

  AzureMachineProviderSpecFluent<?> fluent;

  public AzureMachineProviderSpecBuilder() {
    this(new AzureMachineProviderSpec());
  }
  
  public AzureMachineProviderSpecBuilder(AzureMachineProviderSpecFluent<?> fluent) {
    this(fluent, new AzureMachineProviderSpec());
  }
  
  public AzureMachineProviderSpecBuilder(AzureMachineProviderSpec instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public AzureMachineProviderSpecBuilder(AzureMachineProviderSpecFluent<?> fluent,AzureMachineProviderSpec instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public AzureMachineProviderSpec build() {
    AzureMachineProviderSpec buildable = new AzureMachineProviderSpec(fluent.getAcceleratedNetworking(), fluent.getApiVersion(), fluent.getApplicationSecurityGroups(), fluent.getAvailabilitySet(), fluent.getCapacityReservationGroupID(), fluent.getCredentialsSecret(), fluent.buildDataDisks(), fluent.buildDiagnostics(), fluent.buildImage(), fluent.getInternalLoadBalancer(), fluent.getKind(), fluent.getLocation(), fluent.getManagedIdentity(), fluent.buildMetadata(), fluent.getNatRule(), fluent.getNetworkResourceGroup(), fluent.buildOsDisk(), fluent.getPublicIP(), fluent.getPublicLoadBalancer(), fluent.getResourceGroup(), fluent.getSecurityGroup(), fluent.buildSecurityProfile(), fluent.buildSpotVMOptions(), fluent.getSshPublicKey(), fluent.getSubnet(), fluent.getTags(), fluent.getUltraSSDCapability(), fluent.getUserDataSecret(), fluent.getVmSize(), fluent.getVnet(), fluent.getZone());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}