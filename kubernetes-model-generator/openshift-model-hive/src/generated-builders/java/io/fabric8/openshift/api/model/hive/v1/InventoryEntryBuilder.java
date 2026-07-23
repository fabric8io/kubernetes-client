package io.fabric8.openshift.api.model.hive.v1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class InventoryEntryBuilder extends InventoryEntryFluent<InventoryEntryBuilder> implements VisitableBuilder<InventoryEntry,InventoryEntryBuilder>{

  InventoryEntryFluent<?> fluent;

  public InventoryEntryBuilder() {
    this(new InventoryEntry());
  }
  
  public InventoryEntryBuilder(InventoryEntryFluent<?> fluent) {
    this(fluent, new InventoryEntry());
  }
  
  public InventoryEntryBuilder(InventoryEntry instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public InventoryEntryBuilder(InventoryEntryFluent<?> fluent,InventoryEntry instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public InventoryEntry build() {
    InventoryEntry buildable = new InventoryEntry(fluent.getKind(), fluent.getName());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}