package io.fabric8.tekton.v1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class MatrixBuilder extends MatrixFluent<MatrixBuilder> implements VisitableBuilder<Matrix,MatrixBuilder>{

  MatrixFluent<?> fluent;

  public MatrixBuilder() {
    this(new Matrix());
  }
  
  public MatrixBuilder(MatrixFluent<?> fluent) {
    this(fluent, new Matrix());
  }
  
  public MatrixBuilder(Matrix instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public MatrixBuilder(MatrixFluent<?> fluent,Matrix instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public Matrix build() {
    Matrix buildable = new Matrix(fluent.buildInclude(), fluent.buildParams());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}