package io.fabric8.openshift.api.model.operator.v1alpha1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class BackupJobReferenceBuilder extends BackupJobReferenceFluent<BackupJobReferenceBuilder> implements VisitableBuilder<BackupJobReference,BackupJobReferenceBuilder>{

  BackupJobReferenceFluent<?> fluent;

  public BackupJobReferenceBuilder() {
    this(new BackupJobReference());
  }
  
  public BackupJobReferenceBuilder(BackupJobReferenceFluent<?> fluent) {
    this(fluent, new BackupJobReference());
  }
  
  public BackupJobReferenceBuilder(BackupJobReference instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public BackupJobReferenceBuilder(BackupJobReferenceFluent<?> fluent,BackupJobReference instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public BackupJobReference build() {
    BackupJobReference buildable = new BackupJobReference(fluent.getName(), fluent.getNamespace());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}