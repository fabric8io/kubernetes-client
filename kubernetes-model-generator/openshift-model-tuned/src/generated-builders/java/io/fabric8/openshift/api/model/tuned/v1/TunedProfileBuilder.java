package io.fabric8.openshift.api.model.tuned.v1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class TunedProfileBuilder extends TunedProfileFluent<TunedProfileBuilder> implements VisitableBuilder<TunedProfile,TunedProfileBuilder>{

  TunedProfileFluent<?> fluent;

  public TunedProfileBuilder() {
    this(new TunedProfile());
  }
  
  public TunedProfileBuilder(TunedProfileFluent<?> fluent) {
    this(fluent, new TunedProfile());
  }
  
  public TunedProfileBuilder(TunedProfile instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public TunedProfileBuilder(TunedProfileFluent<?> fluent,TunedProfile instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public TunedProfile build() {
    TunedProfile buildable = new TunedProfile(fluent.getData(), fluent.getName());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}