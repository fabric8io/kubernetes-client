package io.fabric8.openshift.api.model.console.v1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class ConsoleSampleGitImportSourceBuilder extends ConsoleSampleGitImportSourceFluent<ConsoleSampleGitImportSourceBuilder> implements VisitableBuilder<ConsoleSampleGitImportSource,ConsoleSampleGitImportSourceBuilder>{

  ConsoleSampleGitImportSourceFluent<?> fluent;

  public ConsoleSampleGitImportSourceBuilder() {
    this(new ConsoleSampleGitImportSource());
  }
  
  public ConsoleSampleGitImportSourceBuilder(ConsoleSampleGitImportSourceFluent<?> fluent) {
    this(fluent, new ConsoleSampleGitImportSource());
  }
  
  public ConsoleSampleGitImportSourceBuilder(ConsoleSampleGitImportSource instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public ConsoleSampleGitImportSourceBuilder(ConsoleSampleGitImportSourceFluent<?> fluent,ConsoleSampleGitImportSource instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public ConsoleSampleGitImportSource build() {
    ConsoleSampleGitImportSource buildable = new ConsoleSampleGitImportSource(fluent.buildRepository(), fluent.buildService());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}