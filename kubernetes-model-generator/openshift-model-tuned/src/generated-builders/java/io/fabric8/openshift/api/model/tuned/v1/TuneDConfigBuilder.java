package io.fabric8.openshift.api.model.tuned.v1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class TuneDConfigBuilder extends TuneDConfigFluent<TuneDConfigBuilder> implements VisitableBuilder<TuneDConfig,TuneDConfigBuilder>{

  TuneDConfigFluent<?> fluent;

  public TuneDConfigBuilder() {
    this(new TuneDConfig());
  }
  
  public TuneDConfigBuilder(TuneDConfigFluent<?> fluent) {
    this(fluent, new TuneDConfig());
  }
  
  public TuneDConfigBuilder(TuneDConfig instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public TuneDConfigBuilder(TuneDConfigFluent<?> fluent,TuneDConfig instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public TuneDConfig build() {
    TuneDConfig buildable = new TuneDConfig(fluent.getReapplySysctl());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}