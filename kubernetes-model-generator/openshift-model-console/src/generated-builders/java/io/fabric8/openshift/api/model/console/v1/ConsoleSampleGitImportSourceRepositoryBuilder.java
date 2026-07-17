package io.fabric8.openshift.api.model.console.v1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class ConsoleSampleGitImportSourceRepositoryBuilder extends ConsoleSampleGitImportSourceRepositoryFluent<ConsoleSampleGitImportSourceRepositoryBuilder> implements VisitableBuilder<ConsoleSampleGitImportSourceRepository,ConsoleSampleGitImportSourceRepositoryBuilder>{

  ConsoleSampleGitImportSourceRepositoryFluent<?> fluent;

  public ConsoleSampleGitImportSourceRepositoryBuilder() {
    this(new ConsoleSampleGitImportSourceRepository());
  }
  
  public ConsoleSampleGitImportSourceRepositoryBuilder(ConsoleSampleGitImportSourceRepositoryFluent<?> fluent) {
    this(fluent, new ConsoleSampleGitImportSourceRepository());
  }
  
  public ConsoleSampleGitImportSourceRepositoryBuilder(ConsoleSampleGitImportSourceRepository instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public ConsoleSampleGitImportSourceRepositoryBuilder(ConsoleSampleGitImportSourceRepositoryFluent<?> fluent,ConsoleSampleGitImportSourceRepository instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public ConsoleSampleGitImportSourceRepository build() {
    ConsoleSampleGitImportSourceRepository buildable = new ConsoleSampleGitImportSourceRepository(fluent.getContextDir(), fluent.getRevision(), fluent.getUrl());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}