package io.fabric8.openshift.api.model.operator.v1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class HybridOverlayConfigBuilder extends HybridOverlayConfigFluent<HybridOverlayConfigBuilder> implements VisitableBuilder<HybridOverlayConfig,HybridOverlayConfigBuilder>{

  HybridOverlayConfigFluent<?> fluent;

  public HybridOverlayConfigBuilder() {
    this(new HybridOverlayConfig());
  }
  
  public HybridOverlayConfigBuilder(HybridOverlayConfigFluent<?> fluent) {
    this(fluent, new HybridOverlayConfig());
  }
  
  public HybridOverlayConfigBuilder(HybridOverlayConfig instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public HybridOverlayConfigBuilder(HybridOverlayConfigFluent<?> fluent,HybridOverlayConfig instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public HybridOverlayConfig build() {
    HybridOverlayConfig buildable = new HybridOverlayConfig(fluent.buildHybridClusterNetwork(), fluent.getHybridOverlayVXLANPort());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}