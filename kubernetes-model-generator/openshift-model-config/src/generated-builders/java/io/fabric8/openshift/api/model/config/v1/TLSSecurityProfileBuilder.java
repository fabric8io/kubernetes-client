package io.fabric8.openshift.api.model.config.v1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class TLSSecurityProfileBuilder extends TLSSecurityProfileFluent<TLSSecurityProfileBuilder> implements VisitableBuilder<TLSSecurityProfile,TLSSecurityProfileBuilder>{

  TLSSecurityProfileFluent<?> fluent;

  public TLSSecurityProfileBuilder() {
    this(new TLSSecurityProfile());
  }
  
  public TLSSecurityProfileBuilder(TLSSecurityProfileFluent<?> fluent) {
    this(fluent, new TLSSecurityProfile());
  }
  
  public TLSSecurityProfileBuilder(TLSSecurityProfile instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public TLSSecurityProfileBuilder(TLSSecurityProfileFluent<?> fluent,TLSSecurityProfile instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public TLSSecurityProfile build() {
    TLSSecurityProfile buildable = new TLSSecurityProfile(fluent.buildCustom(), fluent.buildIntermediate(), fluent.buildModern(), fluent.buildOld(), fluent.getType());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}