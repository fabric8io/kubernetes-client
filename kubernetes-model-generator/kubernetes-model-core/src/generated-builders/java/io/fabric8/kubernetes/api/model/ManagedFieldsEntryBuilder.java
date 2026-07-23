package io.fabric8.kubernetes.api.model;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class ManagedFieldsEntryBuilder extends ManagedFieldsEntryFluent<ManagedFieldsEntryBuilder> implements VisitableBuilder<ManagedFieldsEntry,ManagedFieldsEntryBuilder>{

  ManagedFieldsEntryFluent<?> fluent;

  public ManagedFieldsEntryBuilder() {
    this(new ManagedFieldsEntry());
  }
  
  public ManagedFieldsEntryBuilder(ManagedFieldsEntryFluent<?> fluent) {
    this(fluent, new ManagedFieldsEntry());
  }
  
  public ManagedFieldsEntryBuilder(ManagedFieldsEntry instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public ManagedFieldsEntryBuilder(ManagedFieldsEntryFluent<?> fluent,ManagedFieldsEntry instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public ManagedFieldsEntry build() {
    ManagedFieldsEntry buildable = new ManagedFieldsEntry(fluent.getApiVersion(), fluent.getFieldsType(), fluent.buildFieldsV1(), fluent.getManager(), fluent.getOperation(), fluent.getSubresource(), fluent.getTime());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}