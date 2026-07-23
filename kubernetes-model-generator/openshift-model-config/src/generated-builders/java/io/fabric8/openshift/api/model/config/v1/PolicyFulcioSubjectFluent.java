package io.fabric8.openshift.api.model.config.v1;

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
public class PolicyFulcioSubjectFluent<A extends io.fabric8.openshift.api.model.config.v1.PolicyFulcioSubjectFluent<A>> extends BaseFluent<A>{

  private Map<String,Object> additionalProperties;
  private String oidcIssuer;
  private String signedEmail;

  public PolicyFulcioSubjectFluent() {
  }
  
  public PolicyFulcioSubjectFluent(PolicyFulcioSubject instance) {
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
  
  protected void copyInstance(PolicyFulcioSubject instance) {
    instance = instance != null ? instance : new PolicyFulcioSubject();
    if (instance != null) {
        this.withOidcIssuer(instance.getOidcIssuer());
        this.withSignedEmail(instance.getSignedEmail());
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
    PolicyFulcioSubjectFluent that = (PolicyFulcioSubjectFluent) o;
    if (!(Objects.equals(oidcIssuer, that.oidcIssuer))) {
      return false;
    }
    if (!(Objects.equals(signedEmail, that.signedEmail))) {
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
  
  public String getOidcIssuer() {
    return this.oidcIssuer;
  }
  
  public String getSignedEmail() {
    return this.signedEmail;
  }
  
  public boolean hasAdditionalProperties() {
    return this.additionalProperties != null;
  }
  
  public boolean hasOidcIssuer() {
    return this.oidcIssuer != null;
  }
  
  public boolean hasSignedEmail() {
    return this.signedEmail != null;
  }
  
  public int hashCode() {
    return Objects.hash(oidcIssuer, signedEmail, additionalProperties);
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
    if (!(oidcIssuer == null)) {
        sb.append("oidcIssuer:");
        sb.append(oidcIssuer);
        sb.append(",");
    }
    if (!(signedEmail == null)) {
        sb.append("signedEmail:");
        sb.append(signedEmail);
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
  
  public A withOidcIssuer(String oidcIssuer) {
    this.oidcIssuer = oidcIssuer;
    return (A) this;
  }
  
  public A withSignedEmail(String signedEmail) {
    this.signedEmail = signedEmail;
    return (A) this;
  }
  
}