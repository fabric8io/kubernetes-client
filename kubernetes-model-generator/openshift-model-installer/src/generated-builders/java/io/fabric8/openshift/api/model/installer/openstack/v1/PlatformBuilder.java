package io.fabric8.openshift.api.model.installer.openstack.v1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class PlatformBuilder extends PlatformFluent<PlatformBuilder> implements VisitableBuilder<Platform,PlatformBuilder>{

  PlatformFluent<?> fluent;

  public PlatformBuilder() {
    this(new Platform());
  }
  
  public PlatformBuilder(PlatformFluent<?> fluent) {
    this(fluent, new Platform());
  }
  
  public PlatformBuilder(Platform instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public PlatformBuilder(PlatformFluent<?> fluent,Platform instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public Platform build() {
    Platform buildable = new Platform(fluent.getApiFloatingIP(), fluent.getApiVIP(), fluent.getApiVIPs(), fluent.getCloud(), fluent.getClusterOSImage(), fluent.getClusterOSImageProperties(), fluent.getComputeFlavor(), fluent.buildControlPlanePort(), fluent.buildDefaultMachinePlatform(), fluent.getExternalDNS(), fluent.getExternalNetwork(), fluent.getIngressFloatingIP(), fluent.getIngressVIP(), fluent.getIngressVIPs(), fluent.getLbFloatingIP(), fluent.getLoadBalancer(), fluent.getMachinesSubnet(), fluent.getOctaviaSupport(), fluent.getRegion(), fluent.getTrunkSupport());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}