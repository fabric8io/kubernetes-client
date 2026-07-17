package io.fabric8.openshift.api.model.miscellaneous.metal3.v1beta1;

import io.fabric8.kubernetes.api.builder.BaseFluent;
import io.fabric8.kubernetes.api.builder.Nested;
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
public class NetworkLinkEthernetMacFluent<A extends io.fabric8.openshift.api.model.miscellaneous.metal3.v1beta1.NetworkLinkEthernetMacFluent<A>> extends BaseFluent<A>{

  private Map<String,Object> additionalProperties;
  private NetworkLinkEthernetMacFromAnnotationBuilder fromAnnotation;
  private String fromHostInterface;
  private String string;

  public NetworkLinkEthernetMacFluent() {
  }
  
  public NetworkLinkEthernetMacFluent(NetworkLinkEthernetMac instance) {
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
  
  public NetworkLinkEthernetMacFromAnnotation buildFromAnnotation() {
    return this.fromAnnotation != null ? this.fromAnnotation.build() : null;
  }
  
  protected void copyInstance(NetworkLinkEthernetMac instance) {
    instance = instance != null ? instance : new NetworkLinkEthernetMac();
    if (instance != null) {
        this.withFromAnnotation(instance.getFromAnnotation());
        this.withFromHostInterface(instance.getFromHostInterface());
        this.withString(instance.getString());
        this.withAdditionalProperties(instance.getAdditionalProperties());
    }
  }
  
  public FromAnnotationNested<A> editFromAnnotation() {
    return this.withNewFromAnnotationLike(Optional.ofNullable(this.buildFromAnnotation()).orElse(null));
  }
  
  public FromAnnotationNested<A> editOrNewFromAnnotation() {
    return this.withNewFromAnnotationLike(Optional.ofNullable(this.buildFromAnnotation()).orElse(new NetworkLinkEthernetMacFromAnnotationBuilder().build()));
  }
  
  public FromAnnotationNested<A> editOrNewFromAnnotationLike(NetworkLinkEthernetMacFromAnnotation item) {
    return this.withNewFromAnnotationLike(Optional.ofNullable(this.buildFromAnnotation()).orElse(item));
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
    NetworkLinkEthernetMacFluent that = (NetworkLinkEthernetMacFluent) o;
    if (!(Objects.equals(fromAnnotation, that.fromAnnotation))) {
      return false;
    }
    if (!(Objects.equals(fromHostInterface, that.fromHostInterface))) {
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
  
  public String getFromHostInterface() {
    return this.fromHostInterface;
  }
  
  public String getString() {
    return this.string;
  }
  
  public boolean hasAdditionalProperties() {
    return this.additionalProperties != null;
  }
  
  public boolean hasFromAnnotation() {
    return this.fromAnnotation != null;
  }
  
  public boolean hasFromHostInterface() {
    return this.fromHostInterface != null;
  }
  
  public boolean hasString() {
    return this.string != null;
  }
  
  public int hashCode() {
    return Objects.hash(fromAnnotation, fromHostInterface, string, additionalProperties);
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
    if (!(fromAnnotation == null)) {
        sb.append("fromAnnotation:");
        sb.append(fromAnnotation);
        sb.append(",");
    }
    if (!(fromHostInterface == null)) {
        sb.append("fromHostInterface:");
        sb.append(fromHostInterface);
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
  
  public A withFromAnnotation(NetworkLinkEthernetMacFromAnnotation fromAnnotation) {
    this._visitables.remove("fromAnnotation");
    if (fromAnnotation != null) {
        this.fromAnnotation = new NetworkLinkEthernetMacFromAnnotationBuilder(fromAnnotation);
        this._visitables.get("fromAnnotation").add(this.fromAnnotation);
    } else {
        this.fromAnnotation = null;
        this._visitables.get("fromAnnotation").remove(this.fromAnnotation);
    }
    return (A) this;
  }
  
  public A withFromHostInterface(String fromHostInterface) {
    this.fromHostInterface = fromHostInterface;
    return (A) this;
  }
  
  public FromAnnotationNested<A> withNewFromAnnotation() {
    return new FromAnnotationNested(null);
  }
  
  public A withNewFromAnnotation(String annotation,String object) {
    return (A) this.withFromAnnotation(new NetworkLinkEthernetMacFromAnnotation(annotation, object));
  }
  
  public FromAnnotationNested<A> withNewFromAnnotationLike(NetworkLinkEthernetMacFromAnnotation item) {
    return new FromAnnotationNested(item);
  }
  
  public A withString(String string) {
    this.string = string;
    return (A) this;
  }
  public class FromAnnotationNested<N> extends NetworkLinkEthernetMacFromAnnotationFluent<FromAnnotationNested<N>> implements Nested<N>{
  
    NetworkLinkEthernetMacFromAnnotationBuilder builder;
  
    FromAnnotationNested(NetworkLinkEthernetMacFromAnnotation item) {
      this.builder = new NetworkLinkEthernetMacFromAnnotationBuilder(this, item);
    }
  
    public N and() {
      return (N) NetworkLinkEthernetMacFluent.this.withFromAnnotation(builder.build());
    }
    
    public N endFromAnnotation() {
      return and();
    }
    
  }
}