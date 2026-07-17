package io.fabric8.openshift.api.model;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class RepositoryImportSpecBuilder extends RepositoryImportSpecFluent<RepositoryImportSpecBuilder> implements VisitableBuilder<RepositoryImportSpec,RepositoryImportSpecBuilder>{

  RepositoryImportSpecFluent<?> fluent;

  public RepositoryImportSpecBuilder() {
    this(new RepositoryImportSpec());
  }
  
  public RepositoryImportSpecBuilder(RepositoryImportSpecFluent<?> fluent) {
    this(fluent, new RepositoryImportSpec());
  }
  
  public RepositoryImportSpecBuilder(RepositoryImportSpec instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public RepositoryImportSpecBuilder(RepositoryImportSpecFluent<?> fluent,RepositoryImportSpec instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public RepositoryImportSpec build() {
    RepositoryImportSpec buildable = new RepositoryImportSpec(fluent.buildFrom(), fluent.buildImportPolicy(), fluent.getIncludeManifest(), fluent.buildReferencePolicy());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}