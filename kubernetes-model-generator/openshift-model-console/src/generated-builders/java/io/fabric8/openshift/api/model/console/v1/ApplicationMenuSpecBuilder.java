package io.fabric8.openshift.api.model.console.v1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class ApplicationMenuSpecBuilder extends ApplicationMenuSpecFluent<ApplicationMenuSpecBuilder> implements VisitableBuilder<ApplicationMenuSpec,ApplicationMenuSpecBuilder>{

  ApplicationMenuSpecFluent<?> fluent;

  public ApplicationMenuSpecBuilder() {
    this(new ApplicationMenuSpec());
  }
  
  public ApplicationMenuSpecBuilder(ApplicationMenuSpecFluent<?> fluent) {
    this(fluent, new ApplicationMenuSpec());
  }
  
  public ApplicationMenuSpecBuilder(ApplicationMenuSpec instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public ApplicationMenuSpecBuilder(ApplicationMenuSpecFluent<?> fluent,ApplicationMenuSpec instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public ApplicationMenuSpec build() {
    ApplicationMenuSpec buildable = new ApplicationMenuSpec(fluent.getImageURL(), fluent.getSection());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}