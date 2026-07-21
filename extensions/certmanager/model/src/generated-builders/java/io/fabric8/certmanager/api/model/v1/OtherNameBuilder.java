package io.fabric8.certmanager.api.model.v1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class OtherNameBuilder extends OtherNameFluent<OtherNameBuilder> implements VisitableBuilder<OtherName,OtherNameBuilder>{

  OtherNameFluent<?> fluent;

  public OtherNameBuilder() {
    this(new OtherName());
  }
  
  public OtherNameBuilder(OtherNameFluent<?> fluent) {
    this(fluent, new OtherName());
  }
  
  public OtherNameBuilder(OtherName instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public OtherNameBuilder(OtherNameFluent<?> fluent,OtherName instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public OtherName build() {
    OtherName buildable = new OtherName(fluent.getOid(), fluent.getUtf8Value());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}