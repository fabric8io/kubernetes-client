package io.fabric8.openshift.api.model.console.v1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class ConsoleSampleContainerImportSourceBuilder extends ConsoleSampleContainerImportSourceFluent<ConsoleSampleContainerImportSourceBuilder> implements VisitableBuilder<ConsoleSampleContainerImportSource,ConsoleSampleContainerImportSourceBuilder>{

  ConsoleSampleContainerImportSourceFluent<?> fluent;

  public ConsoleSampleContainerImportSourceBuilder() {
    this(new ConsoleSampleContainerImportSource());
  }
  
  public ConsoleSampleContainerImportSourceBuilder(ConsoleSampleContainerImportSourceFluent<?> fluent) {
    this(fluent, new ConsoleSampleContainerImportSource());
  }
  
  public ConsoleSampleContainerImportSourceBuilder(ConsoleSampleContainerImportSource instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public ConsoleSampleContainerImportSourceBuilder(ConsoleSampleContainerImportSourceFluent<?> fluent,ConsoleSampleContainerImportSource instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public ConsoleSampleContainerImportSource build() {
    ConsoleSampleContainerImportSource buildable = new ConsoleSampleContainerImportSource(fluent.getImage(), fluent.buildService());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}