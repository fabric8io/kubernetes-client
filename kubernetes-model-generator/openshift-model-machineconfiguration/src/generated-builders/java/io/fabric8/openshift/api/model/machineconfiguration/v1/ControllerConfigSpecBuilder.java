package io.fabric8.openshift.api.model.machineconfiguration.v1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class ControllerConfigSpecBuilder extends ControllerConfigSpecFluent<ControllerConfigSpecBuilder> implements VisitableBuilder<ControllerConfigSpec,ControllerConfigSpecBuilder>{

  ControllerConfigSpecFluent<?> fluent;

  public ControllerConfigSpecBuilder() {
    this(new ControllerConfigSpec());
  }
  
  public ControllerConfigSpecBuilder(ControllerConfigSpecFluent<?> fluent) {
    this(fluent, new ControllerConfigSpec());
  }
  
  public ControllerConfigSpecBuilder(ControllerConfigSpec instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public ControllerConfigSpecBuilder(ControllerConfigSpecFluent<?> fluent,ControllerConfigSpec instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public ControllerConfigSpec build() {
    ControllerConfigSpec buildable = new ControllerConfigSpec(fluent.getAdditionalTrustBundle(), fluent.getBaseOSContainerImage(), fluent.getBaseOSExtensionsContainerImage(), fluent.getCloudProviderCAData(), fluent.getCloudProviderConfig(), fluent.getClusterDNSIP(), fluent.getDns(), fluent.getEtcdDiscoveryDomain(), fluent.buildImageRegistryBundleData(), fluent.buildImageRegistryBundleUserData(), fluent.getImages(), fluent.getInfra(), fluent.getInternalRegistryPullSecret(), fluent.getIpFamilies(), fluent.getKubeAPIServerServingCAData(), fluent.buildNetwork(), fluent.getNetworkType(), fluent.getOsImageURL(), fluent.getPlatform(), fluent.getProxy(), fluent.buildPullSecret(), fluent.getReleaseImage(), fluent.getRootCAData());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}