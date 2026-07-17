package io.fabric8.openshift.api.model.operatorhub.v1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class OLMConfigListBuilder extends OLMConfigListFluent<OLMConfigListBuilder> implements VisitableBuilder<OLMConfigList,OLMConfigListBuilder>{

  OLMConfigListFluent<?> fluent;

  public OLMConfigListBuilder() {
    this(new OLMConfigList());
  }
  
  public OLMConfigListBuilder(OLMConfigListFluent<?> fluent) {
    this(fluent, new OLMConfigList());
  }
  
  public OLMConfigListBuilder(OLMConfigList instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public OLMConfigListBuilder(OLMConfigListFluent<?> fluent,OLMConfigList instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public OLMConfigList build() {
    OLMConfigList buildable = new OLMConfigList(fluent.getApiVersion(), fluent.buildItems(), fluent.getKind(), fluent.getMetadata());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}