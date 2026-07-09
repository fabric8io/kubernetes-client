package io.fabric8.kubernetes.api.model.storage;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class CSINodeBuilder extends CSINodeFluent<CSINodeBuilder> implements VisitableBuilder<CSINode,CSINodeBuilder>{

  CSINodeFluent<?> fluent;

  public CSINodeBuilder() {
    this(new CSINode());
  }
  
  public CSINodeBuilder(CSINodeFluent<?> fluent) {
    this(fluent, new CSINode());
  }
  
  public CSINodeBuilder(CSINode instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public CSINodeBuilder(CSINodeFluent<?> fluent,CSINode instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public CSINode build() {
    CSINode buildable = new CSINode(fluent.getApiVersion(), fluent.getKind(), fluent.buildMetadata(), fluent.buildSpec());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}