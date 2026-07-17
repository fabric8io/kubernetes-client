package io.fabric8.openshift.api.model.hive.v1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class BackupReferenceBuilder extends BackupReferenceFluent<BackupReferenceBuilder> implements VisitableBuilder<BackupReference,BackupReferenceBuilder>{

  BackupReferenceFluent<?> fluent;

  public BackupReferenceBuilder() {
    this(new BackupReference());
  }
  
  public BackupReferenceBuilder(BackupReferenceFluent<?> fluent) {
    this(fluent, new BackupReference());
  }
  
  public BackupReferenceBuilder(BackupReference instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public BackupReferenceBuilder(BackupReferenceFluent<?> fluent,BackupReference instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public BackupReference build() {
    BackupReference buildable = new BackupReference(fluent.getName(), fluent.getNamespace());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}