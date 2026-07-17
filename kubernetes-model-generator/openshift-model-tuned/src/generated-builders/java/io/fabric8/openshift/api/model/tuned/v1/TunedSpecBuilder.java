package io.fabric8.openshift.api.model.tuned.v1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class TunedSpecBuilder extends TunedSpecFluent<TunedSpecBuilder> implements VisitableBuilder<TunedSpec,TunedSpecBuilder>{

  TunedSpecFluent<?> fluent;

  public TunedSpecBuilder() {
    this(new TunedSpec());
  }
  
  public TunedSpecBuilder(TunedSpecFluent<?> fluent) {
    this(fluent, new TunedSpec());
  }
  
  public TunedSpecBuilder(TunedSpec instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public TunedSpecBuilder(TunedSpecFluent<?> fluent,TunedSpec instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public TunedSpec build() {
    TunedSpec buildable = new TunedSpec(fluent.getManagementState(), fluent.buildProfile(), fluent.buildRecommend());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}