package io.fabric8.kubernetes.api.model.kustomize.v1beta1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class HelmGlobalsBuilder extends HelmGlobalsFluent<HelmGlobalsBuilder> implements VisitableBuilder<HelmGlobals,HelmGlobalsBuilder>{

  HelmGlobalsFluent<?> fluent;

  public HelmGlobalsBuilder() {
    this(new HelmGlobals());
  }
  
  public HelmGlobalsBuilder(HelmGlobalsFluent<?> fluent) {
    this(fluent, new HelmGlobals());
  }
  
  public HelmGlobalsBuilder(HelmGlobals instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public HelmGlobalsBuilder(HelmGlobalsFluent<?> fluent,HelmGlobals instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public HelmGlobals build() {
    HelmGlobals buildable = new HelmGlobals(fluent.getChartHome(), fluent.getConfigHome());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}