package io.fabric8.openshift.api.model.machine.v1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class AlibabaCloudMachineProviderConfigBuilder extends AlibabaCloudMachineProviderConfigFluent<AlibabaCloudMachineProviderConfigBuilder> implements VisitableBuilder<AlibabaCloudMachineProviderConfig,AlibabaCloudMachineProviderConfigBuilder>{

  AlibabaCloudMachineProviderConfigFluent<?> fluent;

  public AlibabaCloudMachineProviderConfigBuilder() {
    this(new AlibabaCloudMachineProviderConfig());
  }
  
  public AlibabaCloudMachineProviderConfigBuilder(AlibabaCloudMachineProviderConfigFluent<?> fluent) {
    this(fluent, new AlibabaCloudMachineProviderConfig());
  }
  
  public AlibabaCloudMachineProviderConfigBuilder(AlibabaCloudMachineProviderConfig instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public AlibabaCloudMachineProviderConfigBuilder(AlibabaCloudMachineProviderConfigFluent<?> fluent,AlibabaCloudMachineProviderConfig instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public AlibabaCloudMachineProviderConfig build() {
    AlibabaCloudMachineProviderConfig buildable = new AlibabaCloudMachineProviderConfig(fluent.getApiVersion(), fluent.buildBandwidth(), fluent.buildCredentialsSecret(), fluent.buildDataDisk(), fluent.getImageId(), fluent.getInstanceType(), fluent.getKind(), fluent.buildMetadata(), fluent.getRamRoleName(), fluent.getRegionId(), fluent.buildResourceGroup(), fluent.buildSecurityGroups(), fluent.buildSystemDisk(), fluent.buildTag(), fluent.getTenancy(), fluent.buildUserDataSecret(), fluent.buildVSwitch(), fluent.getVpcId(), fluent.getZoneId());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}