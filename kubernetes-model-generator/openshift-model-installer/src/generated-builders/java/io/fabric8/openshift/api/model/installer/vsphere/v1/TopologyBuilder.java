package io.fabric8.openshift.api.model.installer.vsphere.v1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class TopologyBuilder extends TopologyFluent<TopologyBuilder> implements VisitableBuilder<Topology,TopologyBuilder>{

  TopologyFluent<?> fluent;

  public TopologyBuilder() {
    this(new Topology());
  }
  
  public TopologyBuilder(TopologyFluent<?> fluent) {
    this(fluent, new Topology());
  }
  
  public TopologyBuilder(Topology instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public TopologyBuilder(TopologyFluent<?> fluent,Topology instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public Topology build() {
    Topology buildable = new Topology(fluent.getComputeCluster(), fluent.getDatacenter(), fluent.getDatastore(), fluent.getFolder(), fluent.getHostGroup(), fluent.getNetworks(), fluent.getResourcePool(), fluent.getTagIDs(), fluent.getTemplate());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}