package io.fabric8.openshift.api.model.operator.v1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class OLMListBuilder extends OLMListFluent<OLMListBuilder> implements VisitableBuilder<OLMList,OLMListBuilder>{

  OLMListFluent<?> fluent;

  public OLMListBuilder() {
    this(new OLMList());
  }
  
  public OLMListBuilder(OLMListFluent<?> fluent) {
    this(fluent, new OLMList());
  }
  
  public OLMListBuilder(OLMList instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public OLMListBuilder(OLMListFluent<?> fluent,OLMList instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public OLMList build() {
    OLMList buildable = new OLMList(fluent.getApiVersion(), fluent.buildItems(), fluent.getKind(), fluent.getMetadata());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}