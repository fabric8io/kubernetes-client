package io.fabric8.openshift.api.model.config.v1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class VSpherePlatformTopologyBuilder extends VSpherePlatformTopologyFluent<VSpherePlatformTopologyBuilder> implements VisitableBuilder<VSpherePlatformTopology,VSpherePlatformTopologyBuilder>{

  VSpherePlatformTopologyFluent<?> fluent;

  public VSpherePlatformTopologyBuilder() {
    this(new VSpherePlatformTopology());
  }
  
  public VSpherePlatformTopologyBuilder(VSpherePlatformTopologyFluent<?> fluent) {
    this(fluent, new VSpherePlatformTopology());
  }
  
  public VSpherePlatformTopologyBuilder(VSpherePlatformTopology instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public VSpherePlatformTopologyBuilder(VSpherePlatformTopologyFluent<?> fluent,VSpherePlatformTopology instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public VSpherePlatformTopology build() {
    VSpherePlatformTopology buildable = new VSpherePlatformTopology(fluent.getComputeCluster(), fluent.getDatacenter(), fluent.getDatastore(), fluent.getFolder(), fluent.getNetworks(), fluent.getResourcePool(), fluent.getTemplate());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}