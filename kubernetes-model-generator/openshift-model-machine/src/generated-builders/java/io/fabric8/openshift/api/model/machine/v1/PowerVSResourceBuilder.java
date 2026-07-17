package io.fabric8.openshift.api.model.machine.v1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class PowerVSResourceBuilder extends PowerVSResourceFluent<PowerVSResourceBuilder> implements VisitableBuilder<PowerVSResource,PowerVSResourceBuilder>{

  PowerVSResourceFluent<?> fluent;

  public PowerVSResourceBuilder() {
    this(new PowerVSResource());
  }
  
  public PowerVSResourceBuilder(PowerVSResourceFluent<?> fluent) {
    this(fluent, new PowerVSResource());
  }
  
  public PowerVSResourceBuilder(PowerVSResource instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public PowerVSResourceBuilder(PowerVSResourceFluent<?> fluent,PowerVSResource instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public PowerVSResource build() {
    PowerVSResource buildable = new PowerVSResource(fluent.getId(), fluent.getName(), fluent.getRegex(), fluent.getType());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}