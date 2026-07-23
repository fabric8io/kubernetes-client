package io.fabric8.openshift.api.model.machine.v1beta1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class TrustedLaunchBuilder extends TrustedLaunchFluent<TrustedLaunchBuilder> implements VisitableBuilder<TrustedLaunch,TrustedLaunchBuilder>{

  TrustedLaunchFluent<?> fluent;

  public TrustedLaunchBuilder() {
    this(new TrustedLaunch());
  }
  
  public TrustedLaunchBuilder(TrustedLaunchFluent<?> fluent) {
    this(fluent, new TrustedLaunch());
  }
  
  public TrustedLaunchBuilder(TrustedLaunch instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public TrustedLaunchBuilder(TrustedLaunchFluent<?> fluent,TrustedLaunch instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public TrustedLaunch build() {
    TrustedLaunch buildable = new TrustedLaunch(fluent.buildUefiSettings());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}