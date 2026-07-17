package io.fabric8.openshift.api.model.miscellaneous.metal3.v1alpha1;

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
public class OperationHistoryFluent<A extends io.fabric8.openshift.api.model.miscellaneous.metal3.v1alpha1.OperationHistoryFluent<A>> extends BaseFluent<A>{

  private Map<String,Object> additionalProperties;
  private OperationMetricBuilder deprovision;
  private OperationMetricBuilder inspect;
  private OperationMetricBuilder provision;
  private OperationMetricBuilder register;

  public OperationHistoryFluent() {
  }
  
  public OperationHistoryFluent(OperationHistory instance) {
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
  
  public OperationMetric buildDeprovision() {
    return this.deprovision != null ? this.deprovision.build() : null;
  }
  
  public OperationMetric buildInspect() {
    return this.inspect != null ? this.inspect.build() : null;
  }
  
  public OperationMetric buildProvision() {
    return this.provision != null ? this.provision.build() : null;
  }
  
  public OperationMetric buildRegister() {
    return this.register != null ? this.register.build() : null;
  }
  
  protected void copyInstance(OperationHistory instance) {
    instance = instance != null ? instance : new OperationHistory();
    if (instance != null) {
        this.withDeprovision(instance.getDeprovision());
        this.withInspect(instance.getInspect());
        this.withProvision(instance.getProvision());
        this.withRegister(instance.getRegister());
        this.withAdditionalProperties(instance.getAdditionalProperties());
    }
  }
  
  public DeprovisionNested<A> editDeprovision() {
    return this.withNewDeprovisionLike(Optional.ofNullable(this.buildDeprovision()).orElse(null));
  }
  
  public InspectNested<A> editInspect() {
    return this.withNewInspectLike(Optional.ofNullable(this.buildInspect()).orElse(null));
  }
  
  public DeprovisionNested<A> editOrNewDeprovision() {
    return this.withNewDeprovisionLike(Optional.ofNullable(this.buildDeprovision()).orElse(new OperationMetricBuilder().build()));
  }
  
  public DeprovisionNested<A> editOrNewDeprovisionLike(OperationMetric item) {
    return this.withNewDeprovisionLike(Optional.ofNullable(this.buildDeprovision()).orElse(item));
  }
  
  public InspectNested<A> editOrNewInspect() {
    return this.withNewInspectLike(Optional.ofNullable(this.buildInspect()).orElse(new OperationMetricBuilder().build()));
  }
  
  public InspectNested<A> editOrNewInspectLike(OperationMetric item) {
    return this.withNewInspectLike(Optional.ofNullable(this.buildInspect()).orElse(item));
  }
  
  public ProvisionNested<A> editOrNewProvision() {
    return this.withNewProvisionLike(Optional.ofNullable(this.buildProvision()).orElse(new OperationMetricBuilder().build()));
  }
  
  public ProvisionNested<A> editOrNewProvisionLike(OperationMetric item) {
    return this.withNewProvisionLike(Optional.ofNullable(this.buildProvision()).orElse(item));
  }
  
  public RegisterNested<A> editOrNewRegister() {
    return this.withNewRegisterLike(Optional.ofNullable(this.buildRegister()).orElse(new OperationMetricBuilder().build()));
  }
  
  public RegisterNested<A> editOrNewRegisterLike(OperationMetric item) {
    return this.withNewRegisterLike(Optional.ofNullable(this.buildRegister()).orElse(item));
  }
  
  public ProvisionNested<A> editProvision() {
    return this.withNewProvisionLike(Optional.ofNullable(this.buildProvision()).orElse(null));
  }
  
  public RegisterNested<A> editRegister() {
    return this.withNewRegisterLike(Optional.ofNullable(this.buildRegister()).orElse(null));
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
    OperationHistoryFluent that = (OperationHistoryFluent) o;
    if (!(Objects.equals(deprovision, that.deprovision))) {
      return false;
    }
    if (!(Objects.equals(inspect, that.inspect))) {
      return false;
    }
    if (!(Objects.equals(provision, that.provision))) {
      return false;
    }
    if (!(Objects.equals(register, that.register))) {
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
  
  public boolean hasAdditionalProperties() {
    return this.additionalProperties != null;
  }
  
  public boolean hasDeprovision() {
    return this.deprovision != null;
  }
  
  public boolean hasInspect() {
    return this.inspect != null;
  }
  
  public boolean hasProvision() {
    return this.provision != null;
  }
  
  public boolean hasRegister() {
    return this.register != null;
  }
  
  public int hashCode() {
    return Objects.hash(deprovision, inspect, provision, register, additionalProperties);
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
    if (!(deprovision == null)) {
        sb.append("deprovision:");
        sb.append(deprovision);
        sb.append(",");
    }
    if (!(inspect == null)) {
        sb.append("inspect:");
        sb.append(inspect);
        sb.append(",");
    }
    if (!(provision == null)) {
        sb.append("provision:");
        sb.append(provision);
        sb.append(",");
    }
    if (!(register == null)) {
        sb.append("register:");
        sb.append(register);
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
  
  public A withDeprovision(OperationMetric deprovision) {
    this._visitables.remove("deprovision");
    if (deprovision != null) {
        this.deprovision = new OperationMetricBuilder(deprovision);
        this._visitables.get("deprovision").add(this.deprovision);
    } else {
        this.deprovision = null;
        this._visitables.get("deprovision").remove(this.deprovision);
    }
    return (A) this;
  }
  
  public A withInspect(OperationMetric inspect) {
    this._visitables.remove("inspect");
    if (inspect != null) {
        this.inspect = new OperationMetricBuilder(inspect);
        this._visitables.get("inspect").add(this.inspect);
    } else {
        this.inspect = null;
        this._visitables.get("inspect").remove(this.inspect);
    }
    return (A) this;
  }
  
  public DeprovisionNested<A> withNewDeprovision() {
    return new DeprovisionNested(null);
  }
  
  public A withNewDeprovision(String end,String start) {
    return (A) this.withDeprovision(new OperationMetric(end, start));
  }
  
  public DeprovisionNested<A> withNewDeprovisionLike(OperationMetric item) {
    return new DeprovisionNested(item);
  }
  
  public InspectNested<A> withNewInspect() {
    return new InspectNested(null);
  }
  
  public A withNewInspect(String end,String start) {
    return (A) this.withInspect(new OperationMetric(end, start));
  }
  
  public InspectNested<A> withNewInspectLike(OperationMetric item) {
    return new InspectNested(item);
  }
  
  public ProvisionNested<A> withNewProvision() {
    return new ProvisionNested(null);
  }
  
  public A withNewProvision(String end,String start) {
    return (A) this.withProvision(new OperationMetric(end, start));
  }
  
  public ProvisionNested<A> withNewProvisionLike(OperationMetric item) {
    return new ProvisionNested(item);
  }
  
  public RegisterNested<A> withNewRegister() {
    return new RegisterNested(null);
  }
  
  public A withNewRegister(String end,String start) {
    return (A) this.withRegister(new OperationMetric(end, start));
  }
  
  public RegisterNested<A> withNewRegisterLike(OperationMetric item) {
    return new RegisterNested(item);
  }
  
  public A withProvision(OperationMetric provision) {
    this._visitables.remove("provision");
    if (provision != null) {
        this.provision = new OperationMetricBuilder(provision);
        this._visitables.get("provision").add(this.provision);
    } else {
        this.provision = null;
        this._visitables.get("provision").remove(this.provision);
    }
    return (A) this;
  }
  
  public A withRegister(OperationMetric register) {
    this._visitables.remove("register");
    if (register != null) {
        this.register = new OperationMetricBuilder(register);
        this._visitables.get("register").add(this.register);
    } else {
        this.register = null;
        this._visitables.get("register").remove(this.register);
    }
    return (A) this;
  }
  public class DeprovisionNested<N> extends OperationMetricFluent<DeprovisionNested<N>> implements Nested<N>{
  
    OperationMetricBuilder builder;
  
    DeprovisionNested(OperationMetric item) {
      this.builder = new OperationMetricBuilder(this, item);
    }
  
    public N and() {
      return (N) OperationHistoryFluent.this.withDeprovision(builder.build());
    }
    
    public N endDeprovision() {
      return and();
    }
    
  }
  public class InspectNested<N> extends OperationMetricFluent<InspectNested<N>> implements Nested<N>{
  
    OperationMetricBuilder builder;
  
    InspectNested(OperationMetric item) {
      this.builder = new OperationMetricBuilder(this, item);
    }
  
    public N and() {
      return (N) OperationHistoryFluent.this.withInspect(builder.build());
    }
    
    public N endInspect() {
      return and();
    }
    
  }
  public class ProvisionNested<N> extends OperationMetricFluent<ProvisionNested<N>> implements Nested<N>{
  
    OperationMetricBuilder builder;
  
    ProvisionNested(OperationMetric item) {
      this.builder = new OperationMetricBuilder(this, item);
    }
  
    public N and() {
      return (N) OperationHistoryFluent.this.withProvision(builder.build());
    }
    
    public N endProvision() {
      return and();
    }
    
  }
  public class RegisterNested<N> extends OperationMetricFluent<RegisterNested<N>> implements Nested<N>{
  
    OperationMetricBuilder builder;
  
    RegisterNested(OperationMetric item) {
      this.builder = new OperationMetricBuilder(this, item);
    }
  
    public N and() {
      return (N) OperationHistoryFluent.this.withRegister(builder.build());
    }
    
    public N endRegister() {
      return and();
    }
    
  }
}