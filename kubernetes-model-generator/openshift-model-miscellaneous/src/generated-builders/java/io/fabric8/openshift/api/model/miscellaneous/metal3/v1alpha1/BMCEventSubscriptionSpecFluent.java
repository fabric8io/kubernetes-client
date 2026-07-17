package io.fabric8.openshift.api.model.miscellaneous.metal3.v1alpha1;

import io.fabric8.kubernetes.api.builder.BaseFluent;
import io.fabric8.kubernetes.api.model.SecretReference;
import java.lang.Object;
import java.lang.String;
import java.lang.StringBuilder;
import java.lang.SuppressWarnings;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Objects;

/**
 * Generated
 */
@SuppressWarnings("unchecked")
public class BMCEventSubscriptionSpecFluent<A extends io.fabric8.openshift.api.model.miscellaneous.metal3.v1alpha1.BMCEventSubscriptionSpecFluent<A>> extends BaseFluent<A>{

  private Map<String,Object> additionalProperties;
  private String context;
  private String destination;
  private String hostName;
  private SecretReference httpHeadersRef;

  public BMCEventSubscriptionSpecFluent() {
  }
  
  public BMCEventSubscriptionSpecFluent(BMCEventSubscriptionSpec instance) {
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
  
  protected void copyInstance(BMCEventSubscriptionSpec instance) {
    instance = instance != null ? instance : new BMCEventSubscriptionSpec();
    if (instance != null) {
        this.withContext(instance.getContext());
        this.withDestination(instance.getDestination());
        this.withHostName(instance.getHostName());
        this.withHttpHeadersRef(instance.getHttpHeadersRef());
        this.withAdditionalProperties(instance.getAdditionalProperties());
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
    BMCEventSubscriptionSpecFluent that = (BMCEventSubscriptionSpecFluent) o;
    if (!(Objects.equals(context, that.context))) {
      return false;
    }
    if (!(Objects.equals(destination, that.destination))) {
      return false;
    }
    if (!(Objects.equals(hostName, that.hostName))) {
      return false;
    }
    if (!(Objects.equals(httpHeadersRef, that.httpHeadersRef))) {
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
  
  public String getContext() {
    return this.context;
  }
  
  public String getDestination() {
    return this.destination;
  }
  
  public String getHostName() {
    return this.hostName;
  }
  
  public SecretReference getHttpHeadersRef() {
    return this.httpHeadersRef;
  }
  
  public boolean hasAdditionalProperties() {
    return this.additionalProperties != null;
  }
  
  public boolean hasContext() {
    return this.context != null;
  }
  
  public boolean hasDestination() {
    return this.destination != null;
  }
  
  public boolean hasHostName() {
    return this.hostName != null;
  }
  
  public boolean hasHttpHeadersRef() {
    return this.httpHeadersRef != null;
  }
  
  public int hashCode() {
    return Objects.hash(context, destination, hostName, httpHeadersRef, additionalProperties);
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
    if (!(context == null)) {
        sb.append("context:");
        sb.append(context);
        sb.append(",");
    }
    if (!(destination == null)) {
        sb.append("destination:");
        sb.append(destination);
        sb.append(",");
    }
    if (!(hostName == null)) {
        sb.append("hostName:");
        sb.append(hostName);
        sb.append(",");
    }
    if (!(httpHeadersRef == null)) {
        sb.append("httpHeadersRef:");
        sb.append(httpHeadersRef);
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
  
  public A withContext(String context) {
    this.context = context;
    return (A) this;
  }
  
  public A withDestination(String destination) {
    this.destination = destination;
    return (A) this;
  }
  
  public A withHostName(String hostName) {
    this.hostName = hostName;
    return (A) this;
  }
  
  public A withHttpHeadersRef(SecretReference httpHeadersRef) {
    this.httpHeadersRef = httpHeadersRef;
    return (A) this;
  }
  
  public A withNewHttpHeadersRef(String name,String namespace) {
    return (A) this.withHttpHeadersRef(new SecretReference(name, namespace));
  }
  
}