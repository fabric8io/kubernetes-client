package io.fabric8.openshift.api.model.config.v1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class RegistryLocationBuilder extends RegistryLocationFluent<RegistryLocationBuilder> implements VisitableBuilder<RegistryLocation,RegistryLocationBuilder>{

  RegistryLocationFluent<?> fluent;

  public RegistryLocationBuilder() {
    this(new RegistryLocation());
  }
  
  public RegistryLocationBuilder(RegistryLocationFluent<?> fluent) {
    this(fluent, new RegistryLocation());
  }
  
  public RegistryLocationBuilder(RegistryLocation instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public RegistryLocationBuilder(RegistryLocationFluent<?> fluent,RegistryLocation instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public RegistryLocation build() {
    RegistryLocation buildable = new RegistryLocation(fluent.getDomainName(), fluent.getInsecure());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}