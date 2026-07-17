package io.fabric8.openshift.api.model.config.v1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class NodeListBuilder extends NodeListFluent<NodeListBuilder> implements VisitableBuilder<NodeList,NodeListBuilder>{

  NodeListFluent<?> fluent;

  public NodeListBuilder() {
    this(new NodeList());
  }
  
  public NodeListBuilder(NodeListFluent<?> fluent) {
    this(fluent, new NodeList());
  }
  
  public NodeListBuilder(NodeList instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public NodeListBuilder(NodeListFluent<?> fluent,NodeList instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public NodeList build() {
    NodeList buildable = new NodeList(fluent.getApiVersion(), fluent.buildItems(), fluent.getKind(), fluent.getMetadata());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}