package io.fabric8.kubernetes.api.model.storage.v1beta1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class CSINodeListBuilder extends CSINodeListFluent<CSINodeListBuilder> implements VisitableBuilder<CSINodeList,CSINodeListBuilder>{

  CSINodeListFluent<?> fluent;

  public CSINodeListBuilder() {
    this(new CSINodeList());
  }
  
  public CSINodeListBuilder(CSINodeListFluent<?> fluent) {
    this(fluent, new CSINodeList());
  }
  
  public CSINodeListBuilder(CSINodeList instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public CSINodeListBuilder(CSINodeListFluent<?> fluent,CSINodeList instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public CSINodeList build() {
    CSINodeList buildable = new CSINodeList(fluent.getApiVersion(), fluent.buildItems(), fluent.getKind(), fluent.getMetadata());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}