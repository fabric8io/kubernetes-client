package io.fabric8.tekton.v1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class StepOutputConfigBuilder extends StepOutputConfigFluent<StepOutputConfigBuilder> implements VisitableBuilder<StepOutputConfig,StepOutputConfigBuilder>{

  StepOutputConfigFluent<?> fluent;

  public StepOutputConfigBuilder() {
    this(new StepOutputConfig());
  }
  
  public StepOutputConfigBuilder(StepOutputConfigFluent<?> fluent) {
    this(fluent, new StepOutputConfig());
  }
  
  public StepOutputConfigBuilder(StepOutputConfig instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public StepOutputConfigBuilder(StepOutputConfigFluent<?> fluent,StepOutputConfig instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public StepOutputConfig build() {
    StepOutputConfig buildable = new StepOutputConfig(fluent.getPath());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}