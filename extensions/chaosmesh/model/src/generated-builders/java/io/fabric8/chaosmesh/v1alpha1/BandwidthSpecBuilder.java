package io.fabric8.chaosmesh.v1alpha1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class BandwidthSpecBuilder extends BandwidthSpecFluent<BandwidthSpecBuilder> implements VisitableBuilder<BandwidthSpec,BandwidthSpecBuilder>{

  BandwidthSpecFluent<?> fluent;

  public BandwidthSpecBuilder() {
    this(new BandwidthSpec());
  }
  
  public BandwidthSpecBuilder(BandwidthSpecFluent<?> fluent) {
    this(fluent, new BandwidthSpec());
  }
  
  public BandwidthSpecBuilder(BandwidthSpec instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public BandwidthSpecBuilder(BandwidthSpecFluent<?> fluent,BandwidthSpec instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public BandwidthSpec build() {
    BandwidthSpec buildable = new BandwidthSpec(fluent.getBuffer(), fluent.getLimit(), fluent.getMinburst(), fluent.getPeakrate(), fluent.getRate());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}