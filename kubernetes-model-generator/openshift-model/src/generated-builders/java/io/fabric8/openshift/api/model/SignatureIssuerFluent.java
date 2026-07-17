package io.fabric8.openshift.api.model;

import io.fabric8.kubernetes.api.builder.BaseFluent;
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
public class SignatureIssuerFluent<A extends io.fabric8.openshift.api.model.SignatureIssuerFluent<A>> extends BaseFluent<A>{

  private Map<String,Object> additionalProperties;
  private String commonName;
  private String organization;

  public SignatureIssuerFluent() {
  }
  
  public SignatureIssuerFluent(SignatureIssuer instance) {
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
  
  protected void copyInstance(SignatureIssuer instance) {
    instance = instance != null ? instance : new SignatureIssuer();
    if (instance != null) {
        this.withCommonName(instance.getCommonName());
        this.withOrganization(instance.getOrganization());
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
    SignatureIssuerFluent that = (SignatureIssuerFluent) o;
    if (!(Objects.equals(commonName, that.commonName))) {
      return false;
    }
    if (!(Objects.equals(organization, that.organization))) {
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
  
  public String getCommonName() {
    return this.commonName;
  }
  
  public String getOrganization() {
    return this.organization;
  }
  
  public boolean hasAdditionalProperties() {
    return this.additionalProperties != null;
  }
  
  public boolean hasCommonName() {
    return this.commonName != null;
  }
  
  public boolean hasOrganization() {
    return this.organization != null;
  }
  
  public int hashCode() {
    return Objects.hash(commonName, organization, additionalProperties);
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
    if (!(commonName == null)) {
        sb.append("commonName:");
        sb.append(commonName);
        sb.append(",");
    }
    if (!(organization == null)) {
        sb.append("organization:");
        sb.append(organization);
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
  
  public A withCommonName(String commonName) {
    this.commonName = commonName;
    return (A) this;
  }
  
  public A withOrganization(String organization) {
    this.organization = organization;
    return (A) this;
  }
  
}