package io.fabric8.openshift.api.model.hive.v1;

import io.fabric8.kubernetes.api.builder.BaseFluent;
import io.fabric8.kubernetes.api.builder.Nested;
import java.lang.Boolean;
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
import java.util.Optional;
import java.util.function.Predicate;

/**
 * Generated
 */
@SuppressWarnings("unchecked")
public class FailedProvisionConfigFluent<A extends io.fabric8.openshift.api.model.hive.v1.FailedProvisionConfigFluent<A>> extends BaseFluent<A>{

  private Map<String,Object> additionalProperties;
  private FailedProvisionAWSConfigBuilder aws;
  private List<String> retryReasons = new ArrayList<String>();
  private Boolean skipGatherLogs;

  public FailedProvisionConfigFluent() {
  }
  
  public FailedProvisionConfigFluent(FailedProvisionConfig instance) {
    this.copyInstance(instance);
  }

  public A addAllToRetryReasons(Collection<String> items) {
    if (this.retryReasons == null) {
      this.retryReasons = new ArrayList();
    }
    for (String item : items) {
      this.retryReasons.add(item);
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
  
  public A addToRetryReasons(String... items) {
    if (this.retryReasons == null) {
      this.retryReasons = new ArrayList();
    }
    for (String item : items) {
      this.retryReasons.add(item);
    }
    return (A) this;
  }
  
  public A addToRetryReasons(int index,String item) {
    if (this.retryReasons == null) {
      this.retryReasons = new ArrayList();
    }
    this.retryReasons.add(index, item);
    return (A) this;
  }
  
  public FailedProvisionAWSConfig buildAws() {
    return this.aws != null ? this.aws.build() : null;
  }
  
  protected void copyInstance(FailedProvisionConfig instance) {
    instance = instance != null ? instance : new FailedProvisionConfig();
    if (instance != null) {
        this.withAws(instance.getAws());
        this.withRetryReasons(instance.getRetryReasons());
        this.withSkipGatherLogs(instance.getSkipGatherLogs());
        this.withAdditionalProperties(instance.getAdditionalProperties());
    }
  }
  
  public AwsNested<A> editAws() {
    return this.withNewAwsLike(Optional.ofNullable(this.buildAws()).orElse(null));
  }
  
  public AwsNested<A> editOrNewAws() {
    return this.withNewAwsLike(Optional.ofNullable(this.buildAws()).orElse(new FailedProvisionAWSConfigBuilder().build()));
  }
  
  public AwsNested<A> editOrNewAwsLike(FailedProvisionAWSConfig item) {
    return this.withNewAwsLike(Optional.ofNullable(this.buildAws()).orElse(item));
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
    FailedProvisionConfigFluent that = (FailedProvisionConfigFluent) o;
    if (!(Objects.equals(aws, that.aws))) {
      return false;
    }
    if (!(Objects.equals(retryReasons, that.retryReasons))) {
      return false;
    }
    if (!(Objects.equals(skipGatherLogs, that.skipGatherLogs))) {
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
  
  public String getFirstRetryReason() {
    return this.retryReasons.get(0);
  }
  
  public String getLastRetryReason() {
    return this.retryReasons.get(retryReasons.size() - 1);
  }
  
  public String getMatchingRetryReason(Predicate<String> predicate) {
      for (String item : retryReasons) {
        if (predicate.test(item)) {
          return item;
        }
      }
      return null;
  }
  
  public String getRetryReason(int index) {
    return this.retryReasons.get(index);
  }
  
  public List<String> getRetryReasons() {
    return this.retryReasons;
  }
  
  public Boolean getSkipGatherLogs() {
    return this.skipGatherLogs;
  }
  
  public boolean hasAdditionalProperties() {
    return this.additionalProperties != null;
  }
  
  public boolean hasAws() {
    return this.aws != null;
  }
  
  public boolean hasMatchingRetryReason(Predicate<String> predicate) {
      for (String item : retryReasons) {
        if (predicate.test(item)) {
          return true;
        }
      }
      return false;
  }
  
  public boolean hasRetryReasons() {
    return this.retryReasons != null && !(this.retryReasons.isEmpty());
  }
  
  public boolean hasSkipGatherLogs() {
    return this.skipGatherLogs != null;
  }
  
  public int hashCode() {
    return Objects.hash(aws, retryReasons, skipGatherLogs, additionalProperties);
  }
  
  public A removeAllFromRetryReasons(Collection<String> items) {
    if (this.retryReasons == null) {
      return (A) this;
    }
    for (String item : items) {
      this.retryReasons.remove(item);
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
  
  public A removeFromRetryReasons(String... items) {
    if (this.retryReasons == null) {
      return (A) this;
    }
    for (String item : items) {
      this.retryReasons.remove(item);
    }
    return (A) this;
  }
  
  public A setToRetryReasons(int index,String item) {
    if (this.retryReasons == null) {
      this.retryReasons = new ArrayList();
    }
    this.retryReasons.set(index, item);
    return (A) this;
  }
  
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("{");
    if (!(aws == null)) {
        sb.append("aws:");
        sb.append(aws);
        sb.append(",");
    }
    if (!(retryReasons == null) && !(retryReasons.isEmpty())) {
        sb.append("retryReasons:");
        sb.append(retryReasons);
        sb.append(",");
    }
    if (!(skipGatherLogs == null)) {
        sb.append("skipGatherLogs:");
        sb.append(skipGatherLogs);
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
  
  public A withAws(FailedProvisionAWSConfig aws) {
    this._visitables.remove("aws");
    if (aws != null) {
        this.aws = new FailedProvisionAWSConfigBuilder(aws);
        this._visitables.get("aws").add(this.aws);
    } else {
        this.aws = null;
        this._visitables.get("aws").remove(this.aws);
    }
    return (A) this;
  }
  
  public AwsNested<A> withNewAws() {
    return new AwsNested(null);
  }
  
  public AwsNested<A> withNewAwsLike(FailedProvisionAWSConfig item) {
    return new AwsNested(item);
  }
  
  public A withRetryReasons(List<String> retryReasons) {
    if (retryReasons != null) {
        this.retryReasons = new ArrayList();
        for (String item : retryReasons) {
          this.addToRetryReasons(item);
        }
    } else {
      this.retryReasons = null;
    }
    return (A) this;
  }
  
  public A withRetryReasons(String... retryReasons) {
    if (this.retryReasons != null) {
        this.retryReasons.clear();
        _visitables.remove("retryReasons");
    }
    if (retryReasons != null) {
      for (String item : retryReasons) {
        this.addToRetryReasons(item);
      }
    }
    return (A) this;
  }
  
  public A withSkipGatherLogs() {
    return withSkipGatherLogs(true);
  }
  
  public A withSkipGatherLogs(Boolean skipGatherLogs) {
    this.skipGatherLogs = skipGatherLogs;
    return (A) this;
  }
  public class AwsNested<N> extends FailedProvisionAWSConfigFluent<AwsNested<N>> implements Nested<N>{
  
    FailedProvisionAWSConfigBuilder builder;
  
    AwsNested(FailedProvisionAWSConfig item) {
      this.builder = new FailedProvisionAWSConfigBuilder(this, item);
    }
  
    public N and() {
      return (N) FailedProvisionConfigFluent.this.withAws(builder.build());
    }
    
    public N endAws() {
      return and();
    }
    
  }
}