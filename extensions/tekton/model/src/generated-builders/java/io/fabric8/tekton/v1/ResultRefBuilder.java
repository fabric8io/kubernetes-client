package io.fabric8.tekton.v1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class ResultRefBuilder extends ResultRefFluent<ResultRefBuilder> implements VisitableBuilder<ResultRef,ResultRefBuilder>{

  ResultRefFluent<?> fluent;

  public ResultRefBuilder() {
    this(new ResultRef());
  }
  
  public ResultRefBuilder(ResultRefFluent<?> fluent) {
    this(fluent, new ResultRef());
  }
  
  public ResultRefBuilder(ResultRef instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public ResultRefBuilder(ResultRefFluent<?> fluent,ResultRef instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public ResultRef build() {
    ResultRef buildable = new ResultRef(fluent.getPipelineTask(), fluent.getProperty(), fluent.getResult(), fluent.getResultsIndex());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}