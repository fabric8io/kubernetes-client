package io.fabric8.openshift.api.model.operator.v1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class NoOverlayConfigBuilder extends NoOverlayConfigFluent<NoOverlayConfigBuilder> implements VisitableBuilder<NoOverlayConfig,NoOverlayConfigBuilder>{

  NoOverlayConfigFluent<?> fluent;

  public NoOverlayConfigBuilder() {
    this(new NoOverlayConfig());
  }
  
  public NoOverlayConfigBuilder(NoOverlayConfigFluent<?> fluent) {
    this(fluent, new NoOverlayConfig());
  }
  
  public NoOverlayConfigBuilder(NoOverlayConfig instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public NoOverlayConfigBuilder(NoOverlayConfigFluent<?> fluent,NoOverlayConfig instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public NoOverlayConfig build() {
    NoOverlayConfig buildable = new NoOverlayConfig(fluent.getOutboundSNAT(), fluent.getRouting());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}