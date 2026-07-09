package io.fabric8.kubernetes.api.model.storage.v1beta1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class CSIDriverListBuilder extends CSIDriverListFluent<CSIDriverListBuilder> implements VisitableBuilder<CSIDriverList,CSIDriverListBuilder>{

  CSIDriverListFluent<?> fluent;

  public CSIDriverListBuilder() {
    this(new CSIDriverList());
  }
  
  public CSIDriverListBuilder(CSIDriverListFluent<?> fluent) {
    this(fluent, new CSIDriverList());
  }
  
  public CSIDriverListBuilder(CSIDriverList instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public CSIDriverListBuilder(CSIDriverListFluent<?> fluent,CSIDriverList instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public CSIDriverList build() {
    CSIDriverList buildable = new CSIDriverList(fluent.getApiVersion(), fluent.buildItems(), fluent.getKind(), fluent.getMetadata());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}