package io.fabric8.openshift.api.model.operator.ingress.v1;

import io.fabric8.kubernetes.api.builder.BaseFluent;
import java.lang.Long;
import java.lang.Object;
import java.lang.String;
import java.lang.StringBuilder;
import java.lang.SuppressWarnings;
import java.util.ArrayList;
import java.util.Collection;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.function.Predicate;

/**
 * Generated
 */
@SuppressWarnings("unchecked")
public class DNSRecordSpecFluent<A extends io.fabric8.openshift.api.model.operator.ingress.v1.DNSRecordSpecFluent<A>> extends BaseFluent<A>{

  private Map<String,Object> additionalProperties;
  private String dnsManagementPolicy;
  private String dnsName;
  private Long recordTTL;
  private String recordType;
  private List<String> targets = new ArrayList<String>();

  public DNSRecordSpecFluent() {
  }
  
  public DNSRecordSpecFluent(DNSRecordSpec instance) {
    this.copyInstance(instance);
  }

  public A addAllToTargets(Collection<String> items) {
    if (this.targets == null) {
      this.targets = new ArrayList();
    }
    for (String item : items) {
      this.targets.add(item);
    }
    return (A) this;
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
  
  public A addToTargets(String... items) {
    if (this.targets == null) {
      this.targets = new ArrayList();
    }
    for (String item : items) {
      this.targets.add(item);
    }
    return (A) this;
  }
  
  public A addToTargets(int index,String item) {
    if (this.targets == null) {
      this.targets = new ArrayList();
    }
    this.targets.add(index, item);
    return (A) this;
  }
  
  protected void copyInstance(DNSRecordSpec instance) {
    instance = instance != null ? instance : new DNSRecordSpec();
    if (instance != null) {
        this.withDnsManagementPolicy(instance.getDnsManagementPolicy());
        this.withDnsName(instance.getDnsName());
        this.withRecordTTL(instance.getRecordTTL());
        this.withRecordType(instance.getRecordType());
        this.withTargets(instance.getTargets());
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
    DNSRecordSpecFluent that = (DNSRecordSpecFluent) o;
    if (!(Objects.equals(dnsManagementPolicy, that.dnsManagementPolicy))) {
      return false;
    }
    if (!(Objects.equals(dnsName, that.dnsName))) {
      return false;
    }
    if (!(Objects.equals(recordTTL, that.recordTTL))) {
      return false;
    }
    if (!(Objects.equals(recordType, that.recordType))) {
      return false;
    }
    if (!(Objects.equals(targets, that.targets))) {
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
  
  public String getDnsManagementPolicy() {
    return this.dnsManagementPolicy;
  }
  
  public String getDnsName() {
    return this.dnsName;
  }
  
  public String getFirstTarget() {
    return this.targets.get(0);
  }
  
  public String getLastTarget() {
    return this.targets.get(targets.size() - 1);
  }
  
  public String getMatchingTarget(Predicate<String> predicate) {
      for (String item : targets) {
        if (predicate.test(item)) {
          return item;
        }
      }
      return null;
  }
  
  public Long getRecordTTL() {
    return this.recordTTL;
  }
  
  public String getRecordType() {
    return this.recordType;
  }
  
  public String getTarget(int index) {
    return this.targets.get(index);
  }
  
  public List<String> getTargets() {
    return this.targets;
  }
  
  public boolean hasAdditionalProperties() {
    return this.additionalProperties != null;
  }
  
  public boolean hasDnsManagementPolicy() {
    return this.dnsManagementPolicy != null;
  }
  
  public boolean hasDnsName() {
    return this.dnsName != null;
  }
  
  public boolean hasMatchingTarget(Predicate<String> predicate) {
      for (String item : targets) {
        if (predicate.test(item)) {
          return true;
        }
      }
      return false;
  }
  
  public boolean hasRecordTTL() {
    return this.recordTTL != null;
  }
  
  public boolean hasRecordType() {
    return this.recordType != null;
  }
  
  public boolean hasTargets() {
    return this.targets != null && !(this.targets.isEmpty());
  }
  
  public int hashCode() {
    return Objects.hash(dnsManagementPolicy, dnsName, recordTTL, recordType, targets, additionalProperties);
  }
  
  public A removeAllFromTargets(Collection<String> items) {
    if (this.targets == null) {
      return (A) this;
    }
    for (String item : items) {
      this.targets.remove(item);
    }
    return (A) this;
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
  
  public A removeFromTargets(String... items) {
    if (this.targets == null) {
      return (A) this;
    }
    for (String item : items) {
      this.targets.remove(item);
    }
    return (A) this;
  }
  
  public A setToTargets(int index,String item) {
    if (this.targets == null) {
      this.targets = new ArrayList();
    }
    this.targets.set(index, item);
    return (A) this;
  }
  
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("{");
    if (!(dnsManagementPolicy == null)) {
        sb.append("dnsManagementPolicy:");
        sb.append(dnsManagementPolicy);
        sb.append(",");
    }
    if (!(dnsName == null)) {
        sb.append("dnsName:");
        sb.append(dnsName);
        sb.append(",");
    }
    if (!(recordTTL == null)) {
        sb.append("recordTTL:");
        sb.append(recordTTL);
        sb.append(",");
    }
    if (!(recordType == null)) {
        sb.append("recordType:");
        sb.append(recordType);
        sb.append(",");
    }
    if (!(targets == null) && !(targets.isEmpty())) {
        sb.append("targets:");
        sb.append(targets);
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
  
  public A withDnsManagementPolicy(String dnsManagementPolicy) {
    this.dnsManagementPolicy = dnsManagementPolicy;
    return (A) this;
  }
  
  public A withDnsName(String dnsName) {
    this.dnsName = dnsName;
    return (A) this;
  }
  
  public A withRecordTTL(Long recordTTL) {
    this.recordTTL = recordTTL;
    return (A) this;
  }
  
  public A withRecordType(String recordType) {
    this.recordType = recordType;
    return (A) this;
  }
  
  public A withTargets(List<String> targets) {
    if (targets != null) {
        this.targets = new ArrayList();
        for (String item : targets) {
          this.addToTargets(item);
        }
    } else {
      this.targets = null;
    }
    return (A) this;
  }
  
  public A withTargets(String... targets) {
    if (this.targets != null) {
        this.targets.clear();
        _visitables.remove("targets");
    }
    if (targets != null) {
      for (String item : targets) {
        this.addToTargets(item);
      }
    }
    return (A) this;
  }
  
}