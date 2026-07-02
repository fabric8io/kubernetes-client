package io.fabric8.kubernetes.api.model;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class SELinuxOptionsBuilder extends SELinuxOptionsFluent<SELinuxOptionsBuilder> implements VisitableBuilder<SELinuxOptions,SELinuxOptionsBuilder>{

  SELinuxOptionsFluent<?> fluent;

  public SELinuxOptionsBuilder() {
    this(new SELinuxOptions());
  }
  
  public SELinuxOptionsBuilder(SELinuxOptionsFluent<?> fluent) {
    this(fluent, new SELinuxOptions());
  }
  
  public SELinuxOptionsBuilder(SELinuxOptions instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public SELinuxOptionsBuilder(SELinuxOptionsFluent<?> fluent,SELinuxOptions instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public SELinuxOptions build() {
    SELinuxOptions buildable = new SELinuxOptions(fluent.getLevel(), fluent.getRole(), fluent.getType(), fluent.getUser());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}