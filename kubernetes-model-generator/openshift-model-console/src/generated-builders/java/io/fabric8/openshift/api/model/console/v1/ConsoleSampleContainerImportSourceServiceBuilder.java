package io.fabric8.openshift.api.model.console.v1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class ConsoleSampleContainerImportSourceServiceBuilder extends ConsoleSampleContainerImportSourceServiceFluent<ConsoleSampleContainerImportSourceServiceBuilder> implements VisitableBuilder<ConsoleSampleContainerImportSourceService,ConsoleSampleContainerImportSourceServiceBuilder>{

  ConsoleSampleContainerImportSourceServiceFluent<?> fluent;

  public ConsoleSampleContainerImportSourceServiceBuilder() {
    this(new ConsoleSampleContainerImportSourceService());
  }
  
  public ConsoleSampleContainerImportSourceServiceBuilder(ConsoleSampleContainerImportSourceServiceFluent<?> fluent) {
    this(fluent, new ConsoleSampleContainerImportSourceService());
  }
  
  public ConsoleSampleContainerImportSourceServiceBuilder(ConsoleSampleContainerImportSourceService instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public ConsoleSampleContainerImportSourceServiceBuilder(ConsoleSampleContainerImportSourceServiceFluent<?> fluent,ConsoleSampleContainerImportSourceService instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public ConsoleSampleContainerImportSourceService build() {
    ConsoleSampleContainerImportSourceService buildable = new ConsoleSampleContainerImportSourceService(fluent.getTargetPort());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}