package io.fabric8.openclustermanagement.api.model.policy.v1beta1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class AutomationDefBuilder extends AutomationDefFluent<AutomationDefBuilder> implements VisitableBuilder<AutomationDef,AutomationDefBuilder>{

  AutomationDefFluent<?> fluent;

  public AutomationDefBuilder() {
    this(new AutomationDef());
  }
  
  public AutomationDefBuilder(AutomationDefFluent<?> fluent) {
    this(fluent, new AutomationDef());
  }
  
  public AutomationDefBuilder(AutomationDef instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public AutomationDefBuilder(AutomationDefFluent<?> fluent,AutomationDef instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public AutomationDef build() {
    AutomationDef buildable = new AutomationDef(fluent.getExtraVars(), fluent.getJobTtl(), fluent.getName(), fluent.getPolicyViolationsLimit(), fluent.getSecret(), fluent.getType());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}