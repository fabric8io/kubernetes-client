package io.fabric8.openshift.api.model.operatorhub.v1alpha1;

import io.fabric8.kubernetes.api.builder.BaseFluent;
import java.lang.Boolean;
import java.lang.Integer;
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
public class InstallPlanSpecFluent<A extends io.fabric8.openshift.api.model.operatorhub.v1alpha1.InstallPlanSpecFluent<A>> extends BaseFluent<A>{

  private Map<String,Object> additionalProperties;
  private String approval;
  private Boolean approved;
  private List<String> clusterServiceVersionNames = new ArrayList<String>();
  private Integer generation;
  private String source;
  private String sourceNamespace;

  public InstallPlanSpecFluent() {
  }
  
  public InstallPlanSpecFluent(InstallPlanSpec instance) {
    this.copyInstance(instance);
  }

  public A addAllToClusterServiceVersionNames(Collection<String> items) {
    if (this.clusterServiceVersionNames == null) {
      this.clusterServiceVersionNames = new ArrayList();
    }
    for (String item : items) {
      this.clusterServiceVersionNames.add(item);
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
  
  public A addToClusterServiceVersionNames(String... items) {
    if (this.clusterServiceVersionNames == null) {
      this.clusterServiceVersionNames = new ArrayList();
    }
    for (String item : items) {
      this.clusterServiceVersionNames.add(item);
    }
    return (A) this;
  }
  
  public A addToClusterServiceVersionNames(int index,String item) {
    if (this.clusterServiceVersionNames == null) {
      this.clusterServiceVersionNames = new ArrayList();
    }
    this.clusterServiceVersionNames.add(index, item);
    return (A) this;
  }
  
  protected void copyInstance(InstallPlanSpec instance) {
    instance = instance != null ? instance : new InstallPlanSpec();
    if (instance != null) {
        this.withApproval(instance.getApproval());
        this.withApproved(instance.getApproved());
        this.withClusterServiceVersionNames(instance.getClusterServiceVersionNames());
        this.withGeneration(instance.getGeneration());
        this.withSource(instance.getSource());
        this.withSourceNamespace(instance.getSourceNamespace());
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
    InstallPlanSpecFluent that = (InstallPlanSpecFluent) o;
    if (!(Objects.equals(approval, that.approval))) {
      return false;
    }
    if (!(Objects.equals(approved, that.approved))) {
      return false;
    }
    if (!(Objects.equals(clusterServiceVersionNames, that.clusterServiceVersionNames))) {
      return false;
    }
    if (!(Objects.equals(generation, that.generation))) {
      return false;
    }
    if (!(Objects.equals(source, that.source))) {
      return false;
    }
    if (!(Objects.equals(sourceNamespace, that.sourceNamespace))) {
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
  
  public String getApproval() {
    return this.approval;
  }
  
  public Boolean getApproved() {
    return this.approved;
  }
  
  public String getClusterServiceVersionName(int index) {
    return this.clusterServiceVersionNames.get(index);
  }
  
  public List<String> getClusterServiceVersionNames() {
    return this.clusterServiceVersionNames;
  }
  
  public String getFirstClusterServiceVersionName() {
    return this.clusterServiceVersionNames.get(0);
  }
  
  public Integer getGeneration() {
    return this.generation;
  }
  
  public String getLastClusterServiceVersionName() {
    return this.clusterServiceVersionNames.get(clusterServiceVersionNames.size() - 1);
  }
  
  public String getMatchingClusterServiceVersionName(Predicate<String> predicate) {
      for (String item : clusterServiceVersionNames) {
        if (predicate.test(item)) {
          return item;
        }
      }
      return null;
  }
  
  public String getSource() {
    return this.source;
  }
  
  public String getSourceNamespace() {
    return this.sourceNamespace;
  }
  
  public boolean hasAdditionalProperties() {
    return this.additionalProperties != null;
  }
  
  public boolean hasApproval() {
    return this.approval != null;
  }
  
  public boolean hasApproved() {
    return this.approved != null;
  }
  
  public boolean hasClusterServiceVersionNames() {
    return this.clusterServiceVersionNames != null && !(this.clusterServiceVersionNames.isEmpty());
  }
  
  public boolean hasGeneration() {
    return this.generation != null;
  }
  
  public boolean hasMatchingClusterServiceVersionName(Predicate<String> predicate) {
      for (String item : clusterServiceVersionNames) {
        if (predicate.test(item)) {
          return true;
        }
      }
      return false;
  }
  
  public boolean hasSource() {
    return this.source != null;
  }
  
  public boolean hasSourceNamespace() {
    return this.sourceNamespace != null;
  }
  
  public int hashCode() {
    return Objects.hash(approval, approved, clusterServiceVersionNames, generation, source, sourceNamespace, additionalProperties);
  }
  
  public A removeAllFromClusterServiceVersionNames(Collection<String> items) {
    if (this.clusterServiceVersionNames == null) {
      return (A) this;
    }
    for (String item : items) {
      this.clusterServiceVersionNames.remove(item);
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
  
  public A removeFromClusterServiceVersionNames(String... items) {
    if (this.clusterServiceVersionNames == null) {
      return (A) this;
    }
    for (String item : items) {
      this.clusterServiceVersionNames.remove(item);
    }
    return (A) this;
  }
  
  public A setToClusterServiceVersionNames(int index,String item) {
    if (this.clusterServiceVersionNames == null) {
      this.clusterServiceVersionNames = new ArrayList();
    }
    this.clusterServiceVersionNames.set(index, item);
    return (A) this;
  }
  
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("{");
    if (!(approval == null)) {
        sb.append("approval:");
        sb.append(approval);
        sb.append(",");
    }
    if (!(approved == null)) {
        sb.append("approved:");
        sb.append(approved);
        sb.append(",");
    }
    if (!(clusterServiceVersionNames == null) && !(clusterServiceVersionNames.isEmpty())) {
        sb.append("clusterServiceVersionNames:");
        sb.append(clusterServiceVersionNames);
        sb.append(",");
    }
    if (!(generation == null)) {
        sb.append("generation:");
        sb.append(generation);
        sb.append(",");
    }
    if (!(source == null)) {
        sb.append("source:");
        sb.append(source);
        sb.append(",");
    }
    if (!(sourceNamespace == null)) {
        sb.append("sourceNamespace:");
        sb.append(sourceNamespace);
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
  
  public A withApproval(String approval) {
    this.approval = approval;
    return (A) this;
  }
  
  public A withApproved() {
    return withApproved(true);
  }
  
  public A withApproved(Boolean approved) {
    this.approved = approved;
    return (A) this;
  }
  
  public A withClusterServiceVersionNames(List<String> clusterServiceVersionNames) {
    if (clusterServiceVersionNames != null) {
        this.clusterServiceVersionNames = new ArrayList();
        for (String item : clusterServiceVersionNames) {
          this.addToClusterServiceVersionNames(item);
        }
    } else {
      this.clusterServiceVersionNames = null;
    }
    return (A) this;
  }
  
  public A withClusterServiceVersionNames(String... clusterServiceVersionNames) {
    if (this.clusterServiceVersionNames != null) {
        this.clusterServiceVersionNames.clear();
        _visitables.remove("clusterServiceVersionNames");
    }
    if (clusterServiceVersionNames != null) {
      for (String item : clusterServiceVersionNames) {
        this.addToClusterServiceVersionNames(item);
      }
    }
    return (A) this;
  }
  
  public A withGeneration(Integer generation) {
    this.generation = generation;
    return (A) this;
  }
  
  public A withSource(String source) {
    this.source = source;
    return (A) this;
  }
  
  public A withSourceNamespace(String sourceNamespace) {
    this.sourceNamespace = sourceNamespace;
    return (A) this;
  }
  
}