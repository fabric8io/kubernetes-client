package io.fabric8.openshift.api.model.machine.v1beta1;

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
public class AzureBootDiagnosticsFluent<A extends io.fabric8.openshift.api.model.machine.v1beta1.AzureBootDiagnosticsFluent<A>> extends BaseFluent<A>{

  private Map<String,Object> additionalProperties;
  private AzureCustomerManagedBootDiagnosticsBuilder customerManaged;
  private String storageAccountType;

  public AzureBootDiagnosticsFluent() {
  }
  
  public AzureBootDiagnosticsFluent(AzureBootDiagnostics instance) {
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
  
  public AzureCustomerManagedBootDiagnostics buildCustomerManaged() {
    return this.customerManaged != null ? this.customerManaged.build() : null;
  }
  
  protected void copyInstance(AzureBootDiagnostics instance) {
    instance = instance != null ? instance : new AzureBootDiagnostics();
    if (instance != null) {
        this.withCustomerManaged(instance.getCustomerManaged());
        this.withStorageAccountType(instance.getStorageAccountType());
        this.withAdditionalProperties(instance.getAdditionalProperties());
    }
  }
  
  public CustomerManagedNested<A> editCustomerManaged() {
    return this.withNewCustomerManagedLike(Optional.ofNullable(this.buildCustomerManaged()).orElse(null));
  }
  
  public CustomerManagedNested<A> editOrNewCustomerManaged() {
    return this.withNewCustomerManagedLike(Optional.ofNullable(this.buildCustomerManaged()).orElse(new AzureCustomerManagedBootDiagnosticsBuilder().build()));
  }
  
  public CustomerManagedNested<A> editOrNewCustomerManagedLike(AzureCustomerManagedBootDiagnostics item) {
    return this.withNewCustomerManagedLike(Optional.ofNullable(this.buildCustomerManaged()).orElse(item));
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
    AzureBootDiagnosticsFluent that = (AzureBootDiagnosticsFluent) o;
    if (!(Objects.equals(customerManaged, that.customerManaged))) {
      return false;
    }
    if (!(Objects.equals(storageAccountType, that.storageAccountType))) {
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
  
  public String getStorageAccountType() {
    return this.storageAccountType;
  }
  
  public boolean hasAdditionalProperties() {
    return this.additionalProperties != null;
  }
  
  public boolean hasCustomerManaged() {
    return this.customerManaged != null;
  }
  
  public boolean hasStorageAccountType() {
    return this.storageAccountType != null;
  }
  
  public int hashCode() {
    return Objects.hash(customerManaged, storageAccountType, additionalProperties);
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
    if (!(customerManaged == null)) {
        sb.append("customerManaged:");
        sb.append(customerManaged);
        sb.append(",");
    }
    if (!(storageAccountType == null)) {
        sb.append("storageAccountType:");
        sb.append(storageAccountType);
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
  
  public A withCustomerManaged(AzureCustomerManagedBootDiagnostics customerManaged) {
    this._visitables.remove("customerManaged");
    if (customerManaged != null) {
        this.customerManaged = new AzureCustomerManagedBootDiagnosticsBuilder(customerManaged);
        this._visitables.get("customerManaged").add(this.customerManaged);
    } else {
        this.customerManaged = null;
        this._visitables.get("customerManaged").remove(this.customerManaged);
    }
    return (A) this;
  }
  
  public CustomerManagedNested<A> withNewCustomerManaged() {
    return new CustomerManagedNested(null);
  }
  
  public A withNewCustomerManaged(String storageAccountURI) {
    return (A) this.withCustomerManaged(new AzureCustomerManagedBootDiagnostics(storageAccountURI));
  }
  
  public CustomerManagedNested<A> withNewCustomerManagedLike(AzureCustomerManagedBootDiagnostics item) {
    return new CustomerManagedNested(item);
  }
  
  public A withStorageAccountType(String storageAccountType) {
    this.storageAccountType = storageAccountType;
    return (A) this;
  }
  public class CustomerManagedNested<N> extends AzureCustomerManagedBootDiagnosticsFluent<CustomerManagedNested<N>> implements Nested<N>{
  
    AzureCustomerManagedBootDiagnosticsBuilder builder;
  
    CustomerManagedNested(AzureCustomerManagedBootDiagnostics item) {
      this.builder = new AzureCustomerManagedBootDiagnosticsBuilder(this, item);
    }
  
    public N and() {
      return (N) AzureBootDiagnosticsFluent.this.withCustomerManaged(builder.build());
    }
    
    public N endCustomerManaged() {
      return and();
    }
    
  }
}