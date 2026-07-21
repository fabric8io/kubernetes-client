package io.fabric8.openclustermanagement.api.model.cluster.v1beta1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class PrioritizerConfigBuilder extends PrioritizerConfigFluent<PrioritizerConfigBuilder> implements VisitableBuilder<PrioritizerConfig,PrioritizerConfigBuilder>{

  PrioritizerConfigFluent<?> fluent;

  public PrioritizerConfigBuilder() {
    this(new PrioritizerConfig());
  }
  
  public PrioritizerConfigBuilder(PrioritizerConfigFluent<?> fluent) {
    this(fluent, new PrioritizerConfig());
  }
  
  public PrioritizerConfigBuilder(PrioritizerConfig instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public PrioritizerConfigBuilder(PrioritizerConfigFluent<?> fluent,PrioritizerConfig instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public PrioritizerConfig build() {
    PrioritizerConfig buildable = new PrioritizerConfig(fluent.buildScoreCoordinate(), fluent.getWeight());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}