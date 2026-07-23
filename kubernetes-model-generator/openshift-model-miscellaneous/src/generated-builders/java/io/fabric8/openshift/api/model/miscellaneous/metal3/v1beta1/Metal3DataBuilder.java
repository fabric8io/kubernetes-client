package io.fabric8.openshift.api.model.miscellaneous.metal3.v1beta1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class Metal3DataBuilder extends Metal3DataFluent<Metal3DataBuilder> implements VisitableBuilder<Metal3Data,Metal3DataBuilder>{

  Metal3DataFluent<?> fluent;

  public Metal3DataBuilder() {
    this(new Metal3Data());
  }
  
  public Metal3DataBuilder(Metal3DataFluent<?> fluent) {
    this(fluent, new Metal3Data());
  }
  
  public Metal3DataBuilder(Metal3Data instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public Metal3DataBuilder(Metal3DataFluent<?> fluent,Metal3Data instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public Metal3Data build() {
    Metal3Data buildable = new Metal3Data(fluent.getApiVersion(), fluent.getKind(), fluent.buildMetadata(), fluent.buildSpec(), fluent.buildStatus());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}