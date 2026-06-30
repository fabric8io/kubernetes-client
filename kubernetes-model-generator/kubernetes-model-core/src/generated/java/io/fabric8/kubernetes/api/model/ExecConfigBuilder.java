package io.fabric8.kubernetes.api.model;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class ExecConfigBuilder extends ExecConfigFluent<ExecConfigBuilder> implements VisitableBuilder<ExecConfig,ExecConfigBuilder>{

  ExecConfigFluent<?> fluent;

  public ExecConfigBuilder() {
    this(new ExecConfig());
  }
  
  public ExecConfigBuilder(ExecConfigFluent<?> fluent) {
    this(fluent, new ExecConfig());
  }
  
  public ExecConfigBuilder(ExecConfig instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public ExecConfigBuilder(ExecConfigFluent<?> fluent,ExecConfig instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public ExecConfig build() {
    ExecConfig buildable = new ExecConfig(fluent.getApiVersion(), fluent.getArgs(), fluent.getCommand(), fluent.buildEnv(), fluent.getInstallHint(), fluent.getInteractiveMode(), fluent.getProvideClusterInfo());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}