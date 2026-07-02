package io.fabric8.kubernetes.api.model;

import io.fabric8.kubernetes.api.builder.BaseFluent;
import java.lang.Object;
import java.lang.String;
import java.lang.StringBuilder;
import java.lang.SuppressWarnings;
import java.util.Objects;

/**
 * Generated
 */
@SuppressWarnings("unchecked")
public class AnyTypeFluent<A extends io.fabric8.kubernetes.api.model.AnyTypeFluent<A>> extends BaseFluent<A>{

  private Object value;

  public AnyTypeFluent() {
  }
  
  public AnyTypeFluent(AnyType instance) {
    this.copyInstance(instance);
  }

  protected void copyInstance(AnyType instance) {
    instance = instance != null ? instance : new AnyType();
    if (instance != null) {
      this.withValue(instance.getValue());
    }
  }
  
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || this.getClass() != o.getClass()) {
      return false;
    }
    if (!(super.equals(o))) {
      return false;
    }
    AnyTypeFluent that = (AnyTypeFluent) o;
    if (!(Objects.equals(value, that.value))) {
      return false;
    }
    return true;
  }
  
  public Object getValue() {
    return this.value;
  }
  
  public boolean hasValue() {
    return this.value != null;
  }
  
  public int hashCode() {
    return Objects.hash(value);
  }
  
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("{");
    if (!(value == null)) {
        sb.append("value:");
        sb.append(value);
    }
    sb.append("}");
    return sb.toString();
  }
  
  public A withValue(Object value) {
    this.value = value;
    return (A) this;
  }
  
}