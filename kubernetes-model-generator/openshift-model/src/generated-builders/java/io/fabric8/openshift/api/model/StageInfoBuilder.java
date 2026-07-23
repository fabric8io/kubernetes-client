package io.fabric8.openshift.api.model;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class StageInfoBuilder extends StageInfoFluent<StageInfoBuilder> implements VisitableBuilder<StageInfo,StageInfoBuilder>{

  StageInfoFluent<?> fluent;

  public StageInfoBuilder() {
    this(new StageInfo());
  }
  
  public StageInfoBuilder(StageInfoFluent<?> fluent) {
    this(fluent, new StageInfo());
  }
  
  public StageInfoBuilder(StageInfo instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public StageInfoBuilder(StageInfoFluent<?> fluent,StageInfo instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public StageInfo build() {
    StageInfo buildable = new StageInfo(fluent.getDurationMilliseconds(), fluent.getName(), fluent.getStartTime(), fluent.buildSteps());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}