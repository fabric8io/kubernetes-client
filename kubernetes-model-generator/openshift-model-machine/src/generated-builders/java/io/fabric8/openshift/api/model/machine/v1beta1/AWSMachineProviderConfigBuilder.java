package io.fabric8.openshift.api.model.machine.v1beta1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class AWSMachineProviderConfigBuilder extends AWSMachineProviderConfigFluent<AWSMachineProviderConfigBuilder> implements VisitableBuilder<AWSMachineProviderConfig,AWSMachineProviderConfigBuilder>{

  AWSMachineProviderConfigFluent<?> fluent;

  public AWSMachineProviderConfigBuilder() {
    this(new AWSMachineProviderConfig());
  }
  
  public AWSMachineProviderConfigBuilder(AWSMachineProviderConfigFluent<?> fluent) {
    this(fluent, new AWSMachineProviderConfig());
  }
  
  public AWSMachineProviderConfigBuilder(AWSMachineProviderConfig instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public AWSMachineProviderConfigBuilder(AWSMachineProviderConfigFluent<?> fluent,AWSMachineProviderConfig instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public AWSMachineProviderConfig build() {
    AWSMachineProviderConfig buildable = new AWSMachineProviderConfig(fluent.buildAmi(), fluent.getApiVersion(), fluent.buildBlockDevices(), fluent.getCapacityReservationId(), fluent.buildCredentialsSecret(), fluent.getDeviceIndex(), fluent.buildIamInstanceProfile(), fluent.getInstanceType(), fluent.getKeyName(), fluent.getKind(), fluent.buildLoadBalancers(), fluent.getMarketType(), fluent.buildMetadata(), fluent.buildMetadataServiceOptions(), fluent.getNetworkInterfaceType(), fluent.buildPlacement(), fluent.getPlacementGroupName(), fluent.getPlacementGroupPartition(), fluent.getPublicIp(), fluent.buildSecurityGroups(), fluent.buildSpotMarketOptions(), fluent.buildSubnet(), fluent.buildTags(), fluent.buildUserDataSecret());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}