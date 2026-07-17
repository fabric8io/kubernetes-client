package io.fabric8.openshift.api.model;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class JenkinsPipelineBuildStrategyBuilder extends JenkinsPipelineBuildStrategyFluent<JenkinsPipelineBuildStrategyBuilder> implements VisitableBuilder<JenkinsPipelineBuildStrategy,JenkinsPipelineBuildStrategyBuilder>{

  JenkinsPipelineBuildStrategyFluent<?> fluent;

  public JenkinsPipelineBuildStrategyBuilder() {
    this(new JenkinsPipelineBuildStrategy());
  }
  
  public JenkinsPipelineBuildStrategyBuilder(JenkinsPipelineBuildStrategyFluent<?> fluent) {
    this(fluent, new JenkinsPipelineBuildStrategy());
  }
  
  public JenkinsPipelineBuildStrategyBuilder(JenkinsPipelineBuildStrategy instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public JenkinsPipelineBuildStrategyBuilder(JenkinsPipelineBuildStrategyFluent<?> fluent,JenkinsPipelineBuildStrategy instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public JenkinsPipelineBuildStrategy build() {
    JenkinsPipelineBuildStrategy buildable = new JenkinsPipelineBuildStrategy(fluent.buildEnv(), fluent.getJenkinsfile(), fluent.getJenkinsfilePath());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}