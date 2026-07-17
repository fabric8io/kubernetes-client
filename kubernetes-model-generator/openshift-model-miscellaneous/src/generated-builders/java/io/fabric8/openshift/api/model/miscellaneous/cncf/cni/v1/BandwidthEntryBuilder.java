package io.fabric8.openshift.api.model.miscellaneous.cncf.cni.v1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class BandwidthEntryBuilder extends BandwidthEntryFluent<BandwidthEntryBuilder> implements VisitableBuilder<BandwidthEntry,BandwidthEntryBuilder>{

  BandwidthEntryFluent<?> fluent;

  public BandwidthEntryBuilder() {
    this(new BandwidthEntry());
  }
  
  public BandwidthEntryBuilder(BandwidthEntryFluent<?> fluent) {
    this(fluent, new BandwidthEntry());
  }
  
  public BandwidthEntryBuilder(BandwidthEntry instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public BandwidthEntryBuilder(BandwidthEntryFluent<?> fluent,BandwidthEntry instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public BandwidthEntry build() {
    BandwidthEntry buildable = new BandwidthEntry(fluent.getEgressBurst(), fluent.getEgressRate(), fluent.getIngressBurst(), fluent.getIngressRate());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}