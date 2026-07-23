package io.fabric8.openclustermanagement.api.model.operator.v1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class MultiClusterHubListBuilder extends MultiClusterHubListFluent<MultiClusterHubListBuilder> implements VisitableBuilder<MultiClusterHubList,MultiClusterHubListBuilder>{

  MultiClusterHubListFluent<?> fluent;

  public MultiClusterHubListBuilder() {
    this(new MultiClusterHubList());
  }
  
  public MultiClusterHubListBuilder(MultiClusterHubListFluent<?> fluent) {
    this(fluent, new MultiClusterHubList());
  }
  
  public MultiClusterHubListBuilder(MultiClusterHubList instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public MultiClusterHubListBuilder(MultiClusterHubListFluent<?> fluent,MultiClusterHubList instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public MultiClusterHubList build() {
    MultiClusterHubList buildable = new MultiClusterHubList(fluent.getApiVersion(), fluent.buildItems(), fluent.getKind(), fluent.getMetadata());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}