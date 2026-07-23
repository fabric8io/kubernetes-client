package io.fabric8.openshift.api.model.machine.v1alpha1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class OpenstackProviderSpecBuilder extends OpenstackProviderSpecFluent<OpenstackProviderSpecBuilder> implements VisitableBuilder<OpenstackProviderSpec,OpenstackProviderSpecBuilder>{

  OpenstackProviderSpecFluent<?> fluent;

  public OpenstackProviderSpecBuilder() {
    this(new OpenstackProviderSpec());
  }
  
  public OpenstackProviderSpecBuilder(OpenstackProviderSpecFluent<?> fluent) {
    this(fluent, new OpenstackProviderSpec());
  }
  
  public OpenstackProviderSpecBuilder(OpenstackProviderSpec instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public OpenstackProviderSpecBuilder(OpenstackProviderSpecFluent<?> fluent,OpenstackProviderSpec instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public OpenstackProviderSpec build() {
    OpenstackProviderSpec buildable = new OpenstackProviderSpec(fluent.buildAdditionalBlockDevices(), fluent.getApiVersion(), fluent.getAvailabilityZone(), fluent.getCloudName(), fluent.getCloudsSecret(), fluent.getConfigDrive(), fluent.getFlavor(), fluent.getFloatingIP(), fluent.getImage(), fluent.getKeyName(), fluent.getKind(), fluent.buildMetadata(), fluent.buildNetworks(), fluent.buildPorts(), fluent.getPrimarySubnet(), fluent.buildRootVolume(), fluent.buildSecurityGroups(), fluent.getServerGroupID(), fluent.getServerGroupName(), fluent.getServerMetadata(), fluent.getSshUserName(), fluent.getTags(), fluent.getTrunk(), fluent.getUserDataSecret());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}