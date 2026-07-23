package io.fabric8.openshift.api.model.console.v1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class ConsoleSampleGitImportSourceServiceBuilder extends ConsoleSampleGitImportSourceServiceFluent<ConsoleSampleGitImportSourceServiceBuilder> implements VisitableBuilder<ConsoleSampleGitImportSourceService,ConsoleSampleGitImportSourceServiceBuilder>{

  ConsoleSampleGitImportSourceServiceFluent<?> fluent;

  public ConsoleSampleGitImportSourceServiceBuilder() {
    this(new ConsoleSampleGitImportSourceService());
  }
  
  public ConsoleSampleGitImportSourceServiceBuilder(ConsoleSampleGitImportSourceServiceFluent<?> fluent) {
    this(fluent, new ConsoleSampleGitImportSourceService());
  }
  
  public ConsoleSampleGitImportSourceServiceBuilder(ConsoleSampleGitImportSourceService instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public ConsoleSampleGitImportSourceServiceBuilder(ConsoleSampleGitImportSourceServiceFluent<?> fluent,ConsoleSampleGitImportSourceService instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public ConsoleSampleGitImportSourceService build() {
    ConsoleSampleGitImportSourceService buildable = new ConsoleSampleGitImportSourceService(fluent.getTargetPort());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}