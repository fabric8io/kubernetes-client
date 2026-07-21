package io.fabric8.openclustermanagement.api.model.policy.v1beta1;

import io.fabric8.kubernetes.api.builder.BaseFluent;
import io.fabric8.kubernetes.api.builder.Nested;
import java.lang.Integer;
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
public class PolicyAutomationSpecFluent<A extends io.fabric8.openclustermanagement.api.model.policy.v1beta1.PolicyAutomationSpecFluent<A>> extends BaseFluent<A>{

  private Map<String,Object> additionalProperties;
  private AutomationDefBuilder automationDef;
  private Integer delayAfterRunSeconds;
  private String eventHook;
  private String mode;
  private String policyRef;
  private String rescanAfter;

  public PolicyAutomationSpecFluent() {
  }
  
  public PolicyAutomationSpecFluent(PolicyAutomationSpec instance) {
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
  
  public AutomationDef buildAutomationDef() {
    return this.automationDef != null ? this.automationDef.build() : null;
  }
  
  protected void copyInstance(PolicyAutomationSpec instance) {
    instance = instance != null ? instance : new PolicyAutomationSpec();
    if (instance != null) {
        this.withAutomationDef(instance.getAutomationDef());
        this.withDelayAfterRunSeconds(instance.getDelayAfterRunSeconds());
        this.withEventHook(instance.getEventHook());
        this.withMode(instance.getMode());
        this.withPolicyRef(instance.getPolicyRef());
        this.withRescanAfter(instance.getRescanAfter());
        this.withAdditionalProperties(instance.getAdditionalProperties());
    }
  }
  
  public AutomationDefNested<A> editAutomationDef() {
    return this.withNewAutomationDefLike(Optional.ofNullable(this.buildAutomationDef()).orElse(null));
  }
  
  public AutomationDefNested<A> editOrNewAutomationDef() {
    return this.withNewAutomationDefLike(Optional.ofNullable(this.buildAutomationDef()).orElse(new AutomationDefBuilder().build()));
  }
  
  public AutomationDefNested<A> editOrNewAutomationDefLike(AutomationDef item) {
    return this.withNewAutomationDefLike(Optional.ofNullable(this.buildAutomationDef()).orElse(item));
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
    PolicyAutomationSpecFluent that = (PolicyAutomationSpecFluent) o;
    if (!(Objects.equals(automationDef, that.automationDef))) {
      return false;
    }
    if (!(Objects.equals(delayAfterRunSeconds, that.delayAfterRunSeconds))) {
      return false;
    }
    if (!(Objects.equals(eventHook, that.eventHook))) {
      return false;
    }
    if (!(Objects.equals(mode, that.mode))) {
      return false;
    }
    if (!(Objects.equals(policyRef, that.policyRef))) {
      return false;
    }
    if (!(Objects.equals(rescanAfter, that.rescanAfter))) {
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
  
  public Integer getDelayAfterRunSeconds() {
    return this.delayAfterRunSeconds;
  }
  
  public String getEventHook() {
    return this.eventHook;
  }
  
  public String getMode() {
    return this.mode;
  }
  
  public String getPolicyRef() {
    return this.policyRef;
  }
  
  public String getRescanAfter() {
    return this.rescanAfter;
  }
  
  public boolean hasAdditionalProperties() {
    return this.additionalProperties != null;
  }
  
  public boolean hasAutomationDef() {
    return this.automationDef != null;
  }
  
  public boolean hasDelayAfterRunSeconds() {
    return this.delayAfterRunSeconds != null;
  }
  
  public boolean hasEventHook() {
    return this.eventHook != null;
  }
  
  public boolean hasMode() {
    return this.mode != null;
  }
  
  public boolean hasPolicyRef() {
    return this.policyRef != null;
  }
  
  public boolean hasRescanAfter() {
    return this.rescanAfter != null;
  }
  
  public int hashCode() {
    return Objects.hash(automationDef, delayAfterRunSeconds, eventHook, mode, policyRef, rescanAfter, additionalProperties);
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
    if (!(automationDef == null)) {
        sb.append("automationDef:");
        sb.append(automationDef);
        sb.append(",");
    }
    if (!(delayAfterRunSeconds == null)) {
        sb.append("delayAfterRunSeconds:");
        sb.append(delayAfterRunSeconds);
        sb.append(",");
    }
    if (!(eventHook == null)) {
        sb.append("eventHook:");
        sb.append(eventHook);
        sb.append(",");
    }
    if (!(mode == null)) {
        sb.append("mode:");
        sb.append(mode);
        sb.append(",");
    }
    if (!(policyRef == null)) {
        sb.append("policyRef:");
        sb.append(policyRef);
        sb.append(",");
    }
    if (!(rescanAfter == null)) {
        sb.append("rescanAfter:");
        sb.append(rescanAfter);
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
  
  public A withAutomationDef(AutomationDef automationDef) {
    this._visitables.remove("automationDef");
    if (automationDef != null) {
        this.automationDef = new AutomationDefBuilder(automationDef);
        this._visitables.get("automationDef").add(this.automationDef);
    } else {
        this.automationDef = null;
        this._visitables.get("automationDef").remove(this.automationDef);
    }
    return (A) this;
  }
  
  public A withDelayAfterRunSeconds(Integer delayAfterRunSeconds) {
    this.delayAfterRunSeconds = delayAfterRunSeconds;
    return (A) this;
  }
  
  public A withEventHook(String eventHook) {
    this.eventHook = eventHook;
    return (A) this;
  }
  
  public A withMode(String mode) {
    this.mode = mode;
    return (A) this;
  }
  
  public AutomationDefNested<A> withNewAutomationDef() {
    return new AutomationDefNested(null);
  }
  
  public AutomationDefNested<A> withNewAutomationDefLike(AutomationDef item) {
    return new AutomationDefNested(item);
  }
  
  public A withPolicyRef(String policyRef) {
    this.policyRef = policyRef;
    return (A) this;
  }
  
  public A withRescanAfter(String rescanAfter) {
    this.rescanAfter = rescanAfter;
    return (A) this;
  }
  public class AutomationDefNested<N> extends AutomationDefFluent<AutomationDefNested<N>> implements Nested<N>{
  
    AutomationDefBuilder builder;
  
    AutomationDefNested(AutomationDef item) {
      this.builder = new AutomationDefBuilder(this, item);
    }
  
    public N and() {
      return (N) PolicyAutomationSpecFluent.this.withAutomationDef(builder.build());
    }
    
    public N endAutomationDef() {
      return and();
    }
    
  }
}