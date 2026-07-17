package io.fabric8.openshift.api.model.config.v1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class OperatorHubListBuilder extends OperatorHubListFluent<OperatorHubListBuilder> implements VisitableBuilder<OperatorHubList,OperatorHubListBuilder>{

  OperatorHubListFluent<?> fluent;

  public OperatorHubListBuilder() {
    this(new OperatorHubList());
  }
  
  public OperatorHubListBuilder(OperatorHubListFluent<?> fluent) {
    this(fluent, new OperatorHubList());
  }
  
  public OperatorHubListBuilder(OperatorHubList instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public OperatorHubListBuilder(OperatorHubListFluent<?> fluent,OperatorHubList instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public OperatorHubList build() {
    OperatorHubList buildable = new OperatorHubList(fluent.getApiVersion(), fluent.buildItems(), fluent.getKind(), fluent.getMetadata());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}