package io.fabric8.openshift.api.model;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class SourceStrategyOptionsBuilder extends SourceStrategyOptionsFluent<SourceStrategyOptionsBuilder> implements VisitableBuilder<SourceStrategyOptions,SourceStrategyOptionsBuilder>{

  SourceStrategyOptionsFluent<?> fluent;

  public SourceStrategyOptionsBuilder() {
    this(new SourceStrategyOptions());
  }
  
  public SourceStrategyOptionsBuilder(SourceStrategyOptionsFluent<?> fluent) {
    this(fluent, new SourceStrategyOptions());
  }
  
  public SourceStrategyOptionsBuilder(SourceStrategyOptions instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public SourceStrategyOptionsBuilder(SourceStrategyOptionsFluent<?> fluent,SourceStrategyOptions instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public SourceStrategyOptions build() {
    SourceStrategyOptions buildable = new SourceStrategyOptions(fluent.getIncremental());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}