package io.fabric8.openshift.api.model.hive.aws.v1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class SpotMarketOptionsBuilder extends SpotMarketOptionsFluent<SpotMarketOptionsBuilder> implements VisitableBuilder<SpotMarketOptions,SpotMarketOptionsBuilder>{

  SpotMarketOptionsFluent<?> fluent;

  public SpotMarketOptionsBuilder() {
    this(new SpotMarketOptions());
  }
  
  public SpotMarketOptionsBuilder(SpotMarketOptionsFluent<?> fluent) {
    this(fluent, new SpotMarketOptions());
  }
  
  public SpotMarketOptionsBuilder(SpotMarketOptions instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public SpotMarketOptionsBuilder(SpotMarketOptionsFluent<?> fluent,SpotMarketOptions instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public SpotMarketOptions build() {
    SpotMarketOptions buildable = new SpotMarketOptions(fluent.getMaxPrice());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}