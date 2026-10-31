package io.fabric8.openshift.api.model.operator.v1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class BGPManagedConfigBuilder extends BGPManagedConfigFluent<BGPManagedConfigBuilder> implements VisitableBuilder<BGPManagedConfig,BGPManagedConfigBuilder>{

  BGPManagedConfigFluent<?> fluent;

  public BGPManagedConfigBuilder() {
    this(new BGPManagedConfig());
  }
  
  public BGPManagedConfigBuilder(BGPManagedConfigFluent<?> fluent) {
    this(fluent, new BGPManagedConfig());
  }
  
  public BGPManagedConfigBuilder(BGPManagedConfig instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public BGPManagedConfigBuilder(BGPManagedConfigFluent<?> fluent,BGPManagedConfig instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public BGPManagedConfig build() {
    BGPManagedConfig buildable = new BGPManagedConfig(fluent.getAsNumber(), fluent.getBgpTopology());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}