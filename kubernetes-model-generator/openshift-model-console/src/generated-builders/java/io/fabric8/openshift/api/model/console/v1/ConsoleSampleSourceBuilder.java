package io.fabric8.openshift.api.model.console.v1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class ConsoleSampleSourceBuilder extends ConsoleSampleSourceFluent<ConsoleSampleSourceBuilder> implements VisitableBuilder<ConsoleSampleSource,ConsoleSampleSourceBuilder>{

  ConsoleSampleSourceFluent<?> fluent;

  public ConsoleSampleSourceBuilder() {
    this(new ConsoleSampleSource());
  }
  
  public ConsoleSampleSourceBuilder(ConsoleSampleSourceFluent<?> fluent) {
    this(fluent, new ConsoleSampleSource());
  }
  
  public ConsoleSampleSourceBuilder(ConsoleSampleSource instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public ConsoleSampleSourceBuilder(ConsoleSampleSourceFluent<?> fluent,ConsoleSampleSource instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public ConsoleSampleSource build() {
    ConsoleSampleSource buildable = new ConsoleSampleSource(fluent.buildContainerImport(), fluent.buildGitImport(), fluent.getType());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}