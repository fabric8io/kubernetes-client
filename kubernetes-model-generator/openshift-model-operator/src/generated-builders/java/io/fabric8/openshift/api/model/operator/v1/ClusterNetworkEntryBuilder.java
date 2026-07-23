package io.fabric8.openshift.api.model.operator.v1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class ClusterNetworkEntryBuilder extends ClusterNetworkEntryFluent<ClusterNetworkEntryBuilder> implements VisitableBuilder<ClusterNetworkEntry,ClusterNetworkEntryBuilder>{

  ClusterNetworkEntryFluent<?> fluent;

  public ClusterNetworkEntryBuilder() {
    this(new ClusterNetworkEntry());
  }
  
  public ClusterNetworkEntryBuilder(ClusterNetworkEntryFluent<?> fluent) {
    this(fluent, new ClusterNetworkEntry());
  }
  
  public ClusterNetworkEntryBuilder(ClusterNetworkEntry instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public ClusterNetworkEntryBuilder(ClusterNetworkEntryFluent<?> fluent,ClusterNetworkEntry instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public ClusterNetworkEntry build() {
    ClusterNetworkEntry buildable = new ClusterNetworkEntry(fluent.getCidr(), fluent.getHostPrefix());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}