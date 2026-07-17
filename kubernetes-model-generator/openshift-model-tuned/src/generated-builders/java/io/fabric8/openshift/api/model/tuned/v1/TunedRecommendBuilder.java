package io.fabric8.openshift.api.model.tuned.v1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class TunedRecommendBuilder extends TunedRecommendFluent<TunedRecommendBuilder> implements VisitableBuilder<TunedRecommend,TunedRecommendBuilder>{

  TunedRecommendFluent<?> fluent;

  public TunedRecommendBuilder() {
    this(new TunedRecommend());
  }
  
  public TunedRecommendBuilder(TunedRecommendFluent<?> fluent) {
    this(fluent, new TunedRecommend());
  }
  
  public TunedRecommendBuilder(TunedRecommend instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public TunedRecommendBuilder(TunedRecommendFluent<?> fluent,TunedRecommend instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public TunedRecommend build() {
    TunedRecommend buildable = new TunedRecommend(fluent.getMachineConfigLabels(), fluent.buildMatch(), fluent.buildOperand(), fluent.getPriority(), fluent.getProfile());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}