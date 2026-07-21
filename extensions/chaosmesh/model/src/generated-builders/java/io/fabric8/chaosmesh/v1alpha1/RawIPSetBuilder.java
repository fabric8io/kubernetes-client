package io.fabric8.chaosmesh.v1alpha1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class RawIPSetBuilder extends RawIPSetFluent<RawIPSetBuilder> implements VisitableBuilder<RawIPSet,RawIPSetBuilder>{

  RawIPSetFluent<?> fluent;

  public RawIPSetBuilder() {
    this(new RawIPSet());
  }
  
  public RawIPSetBuilder(RawIPSetFluent<?> fluent) {
    this(fluent, new RawIPSet());
  }
  
  public RawIPSetBuilder(RawIPSet instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public RawIPSetBuilder(RawIPSetFluent<?> fluent,RawIPSet instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public RawIPSet build() {
    RawIPSet buildable = new RawIPSet(fluent.buildCidrAndPorts(), fluent.getCidrs(), fluent.getIpsetType(), fluent.getName(), fluent.getSetNames(), fluent.getSource());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}