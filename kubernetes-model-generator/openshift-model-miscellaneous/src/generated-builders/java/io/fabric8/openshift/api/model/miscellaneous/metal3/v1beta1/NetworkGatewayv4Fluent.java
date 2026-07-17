package io.fabric8.openshift.api.model.miscellaneous.metal3.v1beta1;

import io.fabric8.kubernetes.api.builder.BaseFluent;
import io.fabric8.kubernetes.api.builder.Nested;
import io.fabric8.kubernetes.api.model.TypedLocalObjectReference;
import java.lang.Object;
import java.lang.String;
import java.lang.StringBuilder;
import java.lang.SuppressWarnings;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Objects;
import java.util.Optional;

/**
 * Generated
 */
@SuppressWarnings("unchecked")
public class NetworkGatewayv4Fluent<A extends io.fabric8.openshift.api.model.miscellaneous.metal3.v1beta1.NetworkGatewayv4Fluent<A>> extends BaseFluent<A>{

  private Map<String,Object> additionalProperties;
  private String fromIPPool;
  private FromPoolAnnotationBuilder fromPoolAnnotation;
  private TypedLocalObjectReference fromPoolRef;
  private String string;

  public NetworkGatewayv4Fluent() {
  }
  
  public NetworkGatewayv4Fluent(NetworkGatewayv4 instance) {
    this.copyInstance(instance);
  }

  public A addToAdditionalProperties(Map<String,Object> map) {
    if (this.additionalProperties == null && map != null) {
      this.additionalProperties = new LinkedHashMap();
    }
    if (map != null) {
      this.additionalProperties.putAll(map);
    }
    return (A) this;
  }
  
  public A addToAdditionalProperties(String key,Object value) {
    if (this.additionalProperties == null && key != null && value != null) {
      this.additionalProperties = new LinkedHashMap();
    }
    if (key != null && value != null) {
      this.additionalProperties.put(key, value);
    }
    return (A) this;
  }
  
  public FromPoolAnnotation buildFromPoolAnnotation() {
    return this.fromPoolAnnotation != null ? this.fromPoolAnnotation.build() : null;
  }
  
  protected void copyInstance(NetworkGatewayv4 instance) {
    instance = instance != null ? instance : new NetworkGatewayv4();
    if (instance != null) {
        this.withFromIPPool(instance.getFromIPPool());
        this.withFromPoolAnnotation(instance.getFromPoolAnnotation());
        this.withFromPoolRef(instance.getFromPoolRef());
        this.withString(instance.getString());
        this.withAdditionalProperties(instance.getAdditionalProperties());
    }
  }
  
  public FromPoolAnnotationNested<A> editFromPoolAnnotation() {
    return this.withNewFromPoolAnnotationLike(Optional.ofNullable(this.buildFromPoolAnnotation()).orElse(null));
  }
  
  public FromPoolAnnotationNested<A> editOrNewFromPoolAnnotation() {
    return this.withNewFromPoolAnnotationLike(Optional.ofNullable(this.buildFromPoolAnnotation()).orElse(new FromPoolAnnotationBuilder().build()));
  }
  
  public FromPoolAnnotationNested<A> editOrNewFromPoolAnnotationLike(FromPoolAnnotation item) {
    return this.withNewFromPoolAnnotationLike(Optional.ofNullable(this.buildFromPoolAnnotation()).orElse(item));
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
    NetworkGatewayv4Fluent that = (NetworkGatewayv4Fluent) o;
    if (!(Objects.equals(fromIPPool, that.fromIPPool))) {
      return false;
    }
    if (!(Objects.equals(fromPoolAnnotation, that.fromPoolAnnotation))) {
      return false;
    }
    if (!(Objects.equals(fromPoolRef, that.fromPoolRef))) {
      return false;
    }
    if (!(Objects.equals(string, that.string))) {
      return false;
    }
    if (!(Objects.equals(additionalProperties, that.additionalProperties))) {
      return false;
    }
    return true;
  }
  
  public Map<String,Object> getAdditionalProperties() {
    return this.additionalProperties;
  }
  
  public String getFromIPPool() {
    return this.fromIPPool;
  }
  
  public TypedLocalObjectReference getFromPoolRef() {
    return this.fromPoolRef;
  }
  
  public String getString() {
    return this.string;
  }
  
  public boolean hasAdditionalProperties() {
    return this.additionalProperties != null;
  }
  
  public boolean hasFromIPPool() {
    return this.fromIPPool != null;
  }
  
  public boolean hasFromPoolAnnotation() {
    return this.fromPoolAnnotation != null;
  }
  
  public boolean hasFromPoolRef() {
    return this.fromPoolRef != null;
  }
  
  public boolean hasString() {
    return this.string != null;
  }
  
  public int hashCode() {
    return Objects.hash(fromIPPool, fromPoolAnnotation, fromPoolRef, string, additionalProperties);
  }
  
  public A removeFromAdditionalProperties(String key) {
    if (this.additionalProperties == null) {
      return (A) this;
    }
    if (key != null && this.additionalProperties != null) {
      this.additionalProperties.remove(key);
    }
    return (A) this;
  }
  
  public A removeFromAdditionalProperties(Map<String,Object> map) {
    if (this.additionalProperties == null) {
      return (A) this;
    }
    if (map != null) {
      for (Object key : map.keySet()) {
        if (this.additionalProperties != null) {
          this.additionalProperties.remove(key);
        }
      }
    }
    return (A) this;
  }
  
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("{");
    if (!(fromIPPool == null)) {
        sb.append("fromIPPool:");
        sb.append(fromIPPool);
        sb.append(",");
    }
    if (!(fromPoolAnnotation == null)) {
        sb.append("fromPoolAnnotation:");
        sb.append(fromPoolAnnotation);
        sb.append(",");
    }
    if (!(fromPoolRef == null)) {
        sb.append("fromPoolRef:");
        sb.append(fromPoolRef);
        sb.append(",");
    }
    if (!(string == null)) {
        sb.append("string:");
        sb.append(string);
        sb.append(",");
    }
    if (!(additionalProperties == null) && !(additionalProperties.isEmpty())) {
        sb.append("additionalProperties:");
        sb.append(additionalProperties);
    }
    sb.append("}");
    return sb.toString();
  }
  
  public <K,V>A withAdditionalProperties(Map<String,Object> additionalProperties) {
    if (additionalProperties == null) {
      this.additionalProperties = null;
    } else {
      this.additionalProperties = new LinkedHashMap(additionalProperties);
    }
    return (A) this;
  }
  
  public A withFromIPPool(String fromIPPool) {
    this.fromIPPool = fromIPPool;
    return (A) this;
  }
  
  public A withFromPoolAnnotation(FromPoolAnnotation fromPoolAnnotation) {
    this._visitables.remove("fromPoolAnnotation");
    if (fromPoolAnnotation != null) {
        this.fromPoolAnnotation = new FromPoolAnnotationBuilder(fromPoolAnnotation);
        this._visitables.get("fromPoolAnnotation").add(this.fromPoolAnnotation);
    } else {
        this.fromPoolAnnotation = null;
        this._visitables.get("fromPoolAnnotation").remove(this.fromPoolAnnotation);
    }
    return (A) this;
  }
  
  public A withFromPoolRef(TypedLocalObjectReference fromPoolRef) {
    this.fromPoolRef = fromPoolRef;
    return (A) this;
  }
  
  public FromPoolAnnotationNested<A> withNewFromPoolAnnotation() {
    return new FromPoolAnnotationNested(null);
  }
  
  public A withNewFromPoolAnnotation(String annotation,String object) {
    return (A) this.withFromPoolAnnotation(new FromPoolAnnotation(annotation, object));
  }
  
  public FromPoolAnnotationNested<A> withNewFromPoolAnnotationLike(FromPoolAnnotation item) {
    return new FromPoolAnnotationNested(item);
  }
  
  public A withNewFromPoolRef(String apiGroup,String kind,String name) {
    return (A) this.withFromPoolRef(new TypedLocalObjectReference(apiGroup, kind, name));
  }
  
  public A withString(String string) {
    this.string = string;
    return (A) this;
  }
  public class FromPoolAnnotationNested<N> extends FromPoolAnnotationFluent<FromPoolAnnotationNested<N>> implements Nested<N>{
  
    FromPoolAnnotationBuilder builder;
  
    FromPoolAnnotationNested(FromPoolAnnotation item) {
      this.builder = new FromPoolAnnotationBuilder(this, item);
    }
  
    public N and() {
      return (N) NetworkGatewayv4Fluent.this.withFromPoolAnnotation(builder.build());
    }
    
    public N endFromPoolAnnotation() {
      return and();
    }
    
  }
}