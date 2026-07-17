package io.fabric8.openshift.api.model;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class RepositoryImportStatusBuilder extends RepositoryImportStatusFluent<RepositoryImportStatusBuilder> implements VisitableBuilder<RepositoryImportStatus,RepositoryImportStatusBuilder>{

  RepositoryImportStatusFluent<?> fluent;

  public RepositoryImportStatusBuilder() {
    this(new RepositoryImportStatus());
  }
  
  public RepositoryImportStatusBuilder(RepositoryImportStatusFluent<?> fluent) {
    this(fluent, new RepositoryImportStatus());
  }
  
  public RepositoryImportStatusBuilder(RepositoryImportStatus instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public RepositoryImportStatusBuilder(RepositoryImportStatusFluent<?> fluent,RepositoryImportStatus instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public RepositoryImportStatus build() {
    RepositoryImportStatus buildable = new RepositoryImportStatus(fluent.getAdditionalTags(), fluent.buildImages(), fluent.getStatus());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}