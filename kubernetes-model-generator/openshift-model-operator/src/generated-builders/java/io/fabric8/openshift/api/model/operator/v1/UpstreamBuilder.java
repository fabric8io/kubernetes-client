package io.fabric8.openshift.api.model.operator.v1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class UpstreamBuilder extends UpstreamFluent<UpstreamBuilder> implements VisitableBuilder<Upstream,UpstreamBuilder>{

  UpstreamFluent<?> fluent;

  public UpstreamBuilder() {
    this(new Upstream());
  }
  
  public UpstreamBuilder(UpstreamFluent<?> fluent) {
    this(fluent, new Upstream());
  }
  
  public UpstreamBuilder(Upstream instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public UpstreamBuilder(UpstreamFluent<?> fluent,Upstream instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public Upstream build() {
    Upstream buildable = new Upstream(fluent.getAddress(), fluent.getPort(), fluent.getType());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}