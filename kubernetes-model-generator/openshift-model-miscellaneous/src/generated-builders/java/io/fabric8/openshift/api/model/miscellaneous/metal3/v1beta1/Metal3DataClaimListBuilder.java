package io.fabric8.openshift.api.model.miscellaneous.metal3.v1beta1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class Metal3DataClaimListBuilder extends Metal3DataClaimListFluent<Metal3DataClaimListBuilder> implements VisitableBuilder<Metal3DataClaimList,Metal3DataClaimListBuilder>{

  Metal3DataClaimListFluent<?> fluent;

  public Metal3DataClaimListBuilder() {
    this(new Metal3DataClaimList());
  }
  
  public Metal3DataClaimListBuilder(Metal3DataClaimListFluent<?> fluent) {
    this(fluent, new Metal3DataClaimList());
  }
  
  public Metal3DataClaimListBuilder(Metal3DataClaimList instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public Metal3DataClaimListBuilder(Metal3DataClaimListFluent<?> fluent,Metal3DataClaimList instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public Metal3DataClaimList build() {
    Metal3DataClaimList buildable = new Metal3DataClaimList(fluent.getApiVersion(), fluent.buildItems(), fluent.getKind(), fluent.getMetadata());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}