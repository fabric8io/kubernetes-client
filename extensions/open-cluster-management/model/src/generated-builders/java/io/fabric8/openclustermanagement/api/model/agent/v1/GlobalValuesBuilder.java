package io.fabric8.openclustermanagement.api.model.agent.v1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class GlobalValuesBuilder extends GlobalValuesFluent<GlobalValuesBuilder> implements VisitableBuilder<GlobalValues,GlobalValuesBuilder>{

  GlobalValuesFluent<?> fluent;

  public GlobalValuesBuilder() {
    this(new GlobalValues());
  }
  
  public GlobalValuesBuilder(GlobalValuesFluent<?> fluent) {
    this(fluent, new GlobalValues());
  }
  
  public GlobalValuesBuilder(GlobalValues instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public GlobalValuesBuilder(GlobalValuesFluent<?> fluent,GlobalValues instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public GlobalValues build() {
    GlobalValues buildable = new GlobalValues(fluent.getImageOverrides(), fluent.getImagePullPolicy(), fluent.getImagePullSecret(), fluent.getNodeSelector(), fluent.getProxyConfig());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}