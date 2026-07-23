package io.fabric8.openshift.api.model.miscellaneous.cloudcredential.v1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class OpenStackProviderSpecBuilder extends OpenStackProviderSpecFluent<OpenStackProviderSpecBuilder> implements VisitableBuilder<OpenStackProviderSpec,OpenStackProviderSpecBuilder>{

  OpenStackProviderSpecFluent<?> fluent;

  public OpenStackProviderSpecBuilder() {
    this(new OpenStackProviderSpec());
  }
  
  public OpenStackProviderSpecBuilder(OpenStackProviderSpecFluent<?> fluent) {
    this(fluent, new OpenStackProviderSpec());
  }
  
  public OpenStackProviderSpecBuilder(OpenStackProviderSpec instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public OpenStackProviderSpecBuilder(OpenStackProviderSpecFluent<?> fluent,OpenStackProviderSpec instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public OpenStackProviderSpec build() {
    OpenStackProviderSpec buildable = new OpenStackProviderSpec(fluent.getApiVersion(), fluent.getKind());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}