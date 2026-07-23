package io.fabric8.openshift.api.model.console.v1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class ConsoleSampleBuilder extends ConsoleSampleFluent<ConsoleSampleBuilder> implements VisitableBuilder<ConsoleSample,ConsoleSampleBuilder>{

  ConsoleSampleFluent<?> fluent;

  public ConsoleSampleBuilder() {
    this(new ConsoleSample());
  }
  
  public ConsoleSampleBuilder(ConsoleSampleFluent<?> fluent) {
    this(fluent, new ConsoleSample());
  }
  
  public ConsoleSampleBuilder(ConsoleSample instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public ConsoleSampleBuilder(ConsoleSampleFluent<?> fluent,ConsoleSample instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public ConsoleSample build() {
    ConsoleSample buildable = new ConsoleSample(fluent.getApiVersion(), fluent.getKind(), fluent.buildMetadata(), fluent.buildSpec());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}