package io.fabric8.tekton.triggers.v1beta1;

import io.fabric8.knative.duck.v1.WithPodSpec;
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
public class KubernetesResourceFluent<A extends io.fabric8.tekton.triggers.v1beta1.KubernetesResourceFluent<A>> extends BaseFluent<A>{

  private Map<String,Object> additionalProperties;
  private Integer replicas;
  private String serviceLoadBalancerClass;
  private Integer servicePort;
  private String serviceType;
  private WithPodSpec spec;

  public KubernetesResourceFluent() {
  }
  
  public KubernetesResourceFluent(KubernetesResource instance) {
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
  
  protected void copyInstance(KubernetesResource instance) {
    instance = instance != null ? instance : new KubernetesResource();
    if (instance != null) {
        this.withReplicas(instance.getReplicas());
        this.withServiceLoadBalancerClass(instance.getServiceLoadBalancerClass());
        this.withServicePort(instance.getServicePort());
        this.withServiceType(instance.getServiceType());
        this.withSpec(instance.getSpec());
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
    KubernetesResourceFluent that = (KubernetesResourceFluent) o;
    if (!(Objects.equals(replicas, that.replicas))) {
      return false;
    }
    if (!(Objects.equals(serviceLoadBalancerClass, that.serviceLoadBalancerClass))) {
      return false;
    }
    if (!(Objects.equals(servicePort, that.servicePort))) {
      return false;
    }
    if (!(Objects.equals(serviceType, that.serviceType))) {
      return false;
    }
    if (!(Objects.equals(spec, that.spec))) {
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
  
  public Integer getReplicas() {
    return this.replicas;
  }
  
  public String getServiceLoadBalancerClass() {
    return this.serviceLoadBalancerClass;
  }
  
  public Integer getServicePort() {
    return this.servicePort;
  }
  
  public String getServiceType() {
    return this.serviceType;
  }
  
  public WithPodSpec getSpec() {
    return this.spec;
  }
  
  public boolean hasAdditionalProperties() {
    return this.additionalProperties != null;
  }
  
  public boolean hasReplicas() {
    return this.replicas != null;
  }
  
  public boolean hasServiceLoadBalancerClass() {
    return this.serviceLoadBalancerClass != null;
  }
  
  public boolean hasServicePort() {
    return this.servicePort != null;
  }
  
  public boolean hasServiceType() {
    return this.serviceType != null;
  }
  
  public boolean hasSpec() {
    return this.spec != null;
  }
  
  public int hashCode() {
    return Objects.hash(replicas, serviceLoadBalancerClass, servicePort, serviceType, spec, additionalProperties);
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
    if (!(replicas == null)) {
        sb.append("replicas:");
        sb.append(replicas);
        sb.append(",");
    }
    if (!(serviceLoadBalancerClass == null)) {
        sb.append("serviceLoadBalancerClass:");
        sb.append(serviceLoadBalancerClass);
        sb.append(",");
    }
    if (!(servicePort == null)) {
        sb.append("servicePort:");
        sb.append(servicePort);
        sb.append(",");
    }
    if (!(serviceType == null)) {
        sb.append("serviceType:");
        sb.append(serviceType);
        sb.append(",");
    }
    if (!(spec == null)) {
        sb.append("spec:");
        sb.append(spec);
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
  
  public A withReplicas(Integer replicas) {
    this.replicas = replicas;
    return (A) this;
  }
  
  public A withServiceLoadBalancerClass(String serviceLoadBalancerClass) {
    this.serviceLoadBalancerClass = serviceLoadBalancerClass;
    return (A) this;
  }
  
  public A withServicePort(Integer servicePort) {
    this.servicePort = servicePort;
    return (A) this;
  }
  
  public A withServiceType(String serviceType) {
    this.serviceType = serviceType;
    return (A) this;
  }
  
  public A withSpec(WithPodSpec spec) {
    this.spec = spec;
    return (A) this;
  }
  
}