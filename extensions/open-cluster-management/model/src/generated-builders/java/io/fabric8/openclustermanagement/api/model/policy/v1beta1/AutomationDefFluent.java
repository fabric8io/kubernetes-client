package io.fabric8.openclustermanagement.api.model.policy.v1beta1;

import io.fabric8.kubernetes.api.builder.BaseFluent;
import java.lang.Integer;
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
public class AutomationDefFluent<A extends io.fabric8.openclustermanagement.api.model.policy.v1beta1.AutomationDefFluent<A>> extends BaseFluent<A>{

  private Map<String,Object> additionalProperties;
  private Object extraVars;
  private Integer jobTtl;
  private String name;
  private Integer policyViolationsLimit;
  private String secret;
  private String type;

  public AutomationDefFluent() {
  }
  
  public AutomationDefFluent(AutomationDef instance) {
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
  
  protected void copyInstance(AutomationDef instance) {
    instance = instance != null ? instance : new AutomationDef();
    if (instance != null) {
        this.withExtraVars(instance.getExtraVars());
        this.withJobTtl(instance.getJobTtl());
        this.withName(instance.getName());
        this.withPolicyViolationsLimit(instance.getPolicyViolationsLimit());
        this.withSecret(instance.getSecret());
        this.withType(instance.getType());
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
    AutomationDefFluent that = (AutomationDefFluent) o;
    if (!(Objects.equals(extraVars, that.extraVars))) {
      return false;
    }
    if (!(Objects.equals(jobTtl, that.jobTtl))) {
      return false;
    }
    if (!(Objects.equals(name, that.name))) {
      return false;
    }
    if (!(Objects.equals(policyViolationsLimit, that.policyViolationsLimit))) {
      return false;
    }
    if (!(Objects.equals(secret, that.secret))) {
      return false;
    }
    if (!(Objects.equals(type, that.type))) {
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
  
  public Object getExtraVars() {
    return this.extraVars;
  }
  
  public Integer getJobTtl() {
    return this.jobTtl;
  }
  
  public String getName() {
    return this.name;
  }
  
  public Integer getPolicyViolationsLimit() {
    return this.policyViolationsLimit;
  }
  
  public String getSecret() {
    return this.secret;
  }
  
  public String getType() {
    return this.type;
  }
  
  public boolean hasAdditionalProperties() {
    return this.additionalProperties != null;
  }
  
  public boolean hasExtraVars() {
    return this.extraVars != null;
  }
  
  public boolean hasJobTtl() {
    return this.jobTtl != null;
  }
  
  public boolean hasName() {
    return this.name != null;
  }
  
  public boolean hasPolicyViolationsLimit() {
    return this.policyViolationsLimit != null;
  }
  
  public boolean hasSecret() {
    return this.secret != null;
  }
  
  public boolean hasType() {
    return this.type != null;
  }
  
  public int hashCode() {
    return Objects.hash(extraVars, jobTtl, name, policyViolationsLimit, secret, type, additionalProperties);
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
    if (!(extraVars == null)) {
        sb.append("extraVars:");
        sb.append(extraVars);
        sb.append(",");
    }
    if (!(jobTtl == null)) {
        sb.append("jobTtl:");
        sb.append(jobTtl);
        sb.append(",");
    }
    if (!(name == null)) {
        sb.append("name:");
        sb.append(name);
        sb.append(",");
    }
    if (!(policyViolationsLimit == null)) {
        sb.append("policyViolationsLimit:");
        sb.append(policyViolationsLimit);
        sb.append(",");
    }
    if (!(secret == null)) {
        sb.append("secret:");
        sb.append(secret);
        sb.append(",");
    }
    if (!(type == null)) {
        sb.append("type:");
        sb.append(type);
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
  
  public A withExtraVars(Object extraVars) {
    this.extraVars = extraVars;
    return (A) this;
  }
  
  public A withJobTtl(Integer jobTtl) {
    this.jobTtl = jobTtl;
    return (A) this;
  }
  
  public A withName(String name) {
    this.name = name;
    return (A) this;
  }
  
  public A withPolicyViolationsLimit(Integer policyViolationsLimit) {
    this.policyViolationsLimit = policyViolationsLimit;
    return (A) this;
  }
  
  public A withSecret(String secret) {
    this.secret = secret;
    return (A) this;
  }
  
  public A withType(String type) {
    this.type = type;
    return (A) this;
  }
  
}