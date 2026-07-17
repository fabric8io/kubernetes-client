package io.fabric8.openshift.api.model.operatorhub.v1alpha1;

import io.fabric8.kubernetes.api.builder.BaseFluent;
import io.fabric8.kubernetes.api.builder.Nested;
import io.fabric8.kubernetes.api.model.Affinity;
import io.fabric8.kubernetes.api.model.Quantity;
import io.fabric8.kubernetes.api.model.Toleration;
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
import java.util.Optional;
import java.util.function.Predicate;

/**
 * Generated
 */
@SuppressWarnings("unchecked")
public class GrpcPodConfigFluent<A extends io.fabric8.openshift.api.model.operatorhub.v1alpha1.GrpcPodConfigFluent<A>> extends BaseFluent<A>{

  private Map<String,Object> additionalProperties;
  private Affinity affinity;
  private ExtractContentConfigBuilder extractContent;
  private Quantity memoryTarget;
  private Map<String,String> nodeSelector;
  private String priorityClassName;
  private String securityContextConfig;
  private List<Toleration> tolerations = new ArrayList<Toleration>();

  public GrpcPodConfigFluent() {
  }
  
  public GrpcPodConfigFluent(GrpcPodConfig instance) {
    this.copyInstance(instance);
  }

  public A addAllToTolerations(Collection<Toleration> items) {
    if (this.tolerations == null) {
      this.tolerations = new ArrayList();
    }
    for (Toleration item : items) {
      this.tolerations.add(item);
    }
    return (A) this;
  }
  
  public A addNewToleration(String effect,String key,String operator,Long tolerationSeconds,String value) {
    return (A) this.addToTolerations(new Toleration(effect, key, operator, tolerationSeconds, value));
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
  
  public A addToNodeSelector(Map<String,String> map) {
    if (this.nodeSelector == null && map != null) {
      this.nodeSelector = new LinkedHashMap();
    }
    if (map != null) {
      this.nodeSelector.putAll(map);
    }
    return (A) this;
  }
  
  public A addToNodeSelector(String key,String value) {
    if (this.nodeSelector == null && key != null && value != null) {
      this.nodeSelector = new LinkedHashMap();
    }
    if (key != null && value != null) {
      this.nodeSelector.put(key, value);
    }
    return (A) this;
  }
  
  public A addToTolerations(Toleration... items) {
    if (this.tolerations == null) {
      this.tolerations = new ArrayList();
    }
    for (Toleration item : items) {
      this.tolerations.add(item);
    }
    return (A) this;
  }
  
  public A addToTolerations(int index,Toleration item) {
    if (this.tolerations == null) {
      this.tolerations = new ArrayList();
    }
    this.tolerations.add(index, item);
    return (A) this;
  }
  
  public ExtractContentConfig buildExtractContent() {
    return this.extractContent != null ? this.extractContent.build() : null;
  }
  
  protected void copyInstance(GrpcPodConfig instance) {
    instance = instance != null ? instance : new GrpcPodConfig();
    if (instance != null) {
        this.withAffinity(instance.getAffinity());
        this.withExtractContent(instance.getExtractContent());
        this.withMemoryTarget(instance.getMemoryTarget());
        this.withNodeSelector(instance.getNodeSelector());
        this.withPriorityClassName(instance.getPriorityClassName());
        this.withSecurityContextConfig(instance.getSecurityContextConfig());
        this.withTolerations(instance.getTolerations());
        this.withAdditionalProperties(instance.getAdditionalProperties());
    }
  }
  
  public ExtractContentNested<A> editExtractContent() {
    return this.withNewExtractContentLike(Optional.ofNullable(this.buildExtractContent()).orElse(null));
  }
  
  public ExtractContentNested<A> editOrNewExtractContent() {
    return this.withNewExtractContentLike(Optional.ofNullable(this.buildExtractContent()).orElse(new ExtractContentConfigBuilder().build()));
  }
  
  public ExtractContentNested<A> editOrNewExtractContentLike(ExtractContentConfig item) {
    return this.withNewExtractContentLike(Optional.ofNullable(this.buildExtractContent()).orElse(item));
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
    GrpcPodConfigFluent that = (GrpcPodConfigFluent) o;
    if (!(Objects.equals(affinity, that.affinity))) {
      return false;
    }
    if (!(Objects.equals(extractContent, that.extractContent))) {
      return false;
    }
    if (!(Objects.equals(memoryTarget, that.memoryTarget))) {
      return false;
    }
    if (!(Objects.equals(nodeSelector, that.nodeSelector))) {
      return false;
    }
    if (!(Objects.equals(priorityClassName, that.priorityClassName))) {
      return false;
    }
    if (!(Objects.equals(securityContextConfig, that.securityContextConfig))) {
      return false;
    }
    if (!(Objects.equals(tolerations, that.tolerations))) {
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
  
  public Affinity getAffinity() {
    return this.affinity;
  }
  
  public Toleration getFirstToleration() {
    return this.tolerations.get(0);
  }
  
  public Toleration getLastToleration() {
    return this.tolerations.get(tolerations.size() - 1);
  }
  
  public Toleration getMatchingToleration(Predicate<Toleration> predicate) {
      for (Toleration item : tolerations) {
        if (predicate.test(item)) {
          return item;
        }
      }
      return null;
  }
  
  public Quantity getMemoryTarget() {
    return this.memoryTarget;
  }
  
  public Map<String,String> getNodeSelector() {
    return this.nodeSelector;
  }
  
  public String getPriorityClassName() {
    return this.priorityClassName;
  }
  
  public String getSecurityContextConfig() {
    return this.securityContextConfig;
  }
  
  public Toleration getToleration(int index) {
    return this.tolerations.get(index);
  }
  
  public List<Toleration> getTolerations() {
    return this.tolerations;
  }
  
  public boolean hasAdditionalProperties() {
    return this.additionalProperties != null;
  }
  
  public boolean hasAffinity() {
    return this.affinity != null;
  }
  
  public boolean hasExtractContent() {
    return this.extractContent != null;
  }
  
  public boolean hasMatchingToleration(Predicate<Toleration> predicate) {
      for (Toleration item : tolerations) {
        if (predicate.test(item)) {
          return true;
        }
      }
      return false;
  }
  
  public boolean hasMemoryTarget() {
    return this.memoryTarget != null;
  }
  
  public boolean hasNodeSelector() {
    return this.nodeSelector != null;
  }
  
  public boolean hasPriorityClassName() {
    return this.priorityClassName != null;
  }
  
  public boolean hasSecurityContextConfig() {
    return this.securityContextConfig != null;
  }
  
  public boolean hasTolerations() {
    return this.tolerations != null && !(this.tolerations.isEmpty());
  }
  
  public int hashCode() {
    return Objects.hash(affinity, extractContent, memoryTarget, nodeSelector, priorityClassName, securityContextConfig, tolerations, additionalProperties);
  }
  
  public A removeAllFromTolerations(Collection<Toleration> items) {
    if (this.tolerations == null) {
      return (A) this;
    }
    for (Toleration item : items) {
      this.tolerations.remove(item);
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
  
  public A removeFromNodeSelector(String key) {
    if (this.nodeSelector == null) {
      return (A) this;
    }
    if (key != null && this.nodeSelector != null) {
      this.nodeSelector.remove(key);
    }
    return (A) this;
  }
  
  public A removeFromNodeSelector(Map<String,String> map) {
    if (this.nodeSelector == null) {
      return (A) this;
    }
    if (map != null) {
      for (Object key : map.keySet()) {
        if (this.nodeSelector != null) {
          this.nodeSelector.remove(key);
        }
      }
    }
    return (A) this;
  }
  
  public A removeFromTolerations(Toleration... items) {
    if (this.tolerations == null) {
      return (A) this;
    }
    for (Toleration item : items) {
      this.tolerations.remove(item);
    }
    return (A) this;
  }
  
  public A setToTolerations(int index,Toleration item) {
    if (this.tolerations == null) {
      this.tolerations = new ArrayList();
    }
    this.tolerations.set(index, item);
    return (A) this;
  }
  
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("{");
    if (!(affinity == null)) {
        sb.append("affinity:");
        sb.append(affinity);
        sb.append(",");
    }
    if (!(extractContent == null)) {
        sb.append("extractContent:");
        sb.append(extractContent);
        sb.append(",");
    }
    if (!(memoryTarget == null)) {
        sb.append("memoryTarget:");
        sb.append(memoryTarget);
        sb.append(",");
    }
    if (!(nodeSelector == null) && !(nodeSelector.isEmpty())) {
        sb.append("nodeSelector:");
        sb.append(nodeSelector);
        sb.append(",");
    }
    if (!(priorityClassName == null)) {
        sb.append("priorityClassName:");
        sb.append(priorityClassName);
        sb.append(",");
    }
    if (!(securityContextConfig == null)) {
        sb.append("securityContextConfig:");
        sb.append(securityContextConfig);
        sb.append(",");
    }
    if (!(tolerations == null) && !(tolerations.isEmpty())) {
        sb.append("tolerations:");
        sb.append(tolerations);
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
  
  public A withAffinity(Affinity affinity) {
    this.affinity = affinity;
    return (A) this;
  }
  
  public A withExtractContent(ExtractContentConfig extractContent) {
    this._visitables.remove("extractContent");
    if (extractContent != null) {
        this.extractContent = new ExtractContentConfigBuilder(extractContent);
        this._visitables.get("extractContent").add(this.extractContent);
    } else {
        this.extractContent = null;
        this._visitables.get("extractContent").remove(this.extractContent);
    }
    return (A) this;
  }
  
  public A withMemoryTarget(Quantity memoryTarget) {
    this.memoryTarget = memoryTarget;
    return (A) this;
  }
  
  public ExtractContentNested<A> withNewExtractContent() {
    return new ExtractContentNested(null);
  }
  
  public A withNewExtractContent(String cacheDir,String catalogDir) {
    return (A) this.withExtractContent(new ExtractContentConfig(cacheDir, catalogDir));
  }
  
  public ExtractContentNested<A> withNewExtractContentLike(ExtractContentConfig item) {
    return new ExtractContentNested(item);
  }
  
  public A withNewMemoryTarget(String amount) {
    return (A) this.withMemoryTarget(new Quantity(amount));
  }
  
  public A withNewMemoryTarget(String amount,String format) {
    return (A) this.withMemoryTarget(new Quantity(amount, format));
  }
  
  public <K,V>A withNodeSelector(Map<String,String> nodeSelector) {
    if (nodeSelector == null) {
      this.nodeSelector = null;
    } else {
      this.nodeSelector = new LinkedHashMap(nodeSelector);
    }
    return (A) this;
  }
  
  public A withPriorityClassName(String priorityClassName) {
    this.priorityClassName = priorityClassName;
    return (A) this;
  }
  
  public A withSecurityContextConfig(String securityContextConfig) {
    this.securityContextConfig = securityContextConfig;
    return (A) this;
  }
  
  public A withTolerations(List<Toleration> tolerations) {
    if (tolerations != null) {
        this.tolerations = new ArrayList();
        for (Toleration item : tolerations) {
          this.addToTolerations(item);
        }
    } else {
      this.tolerations = null;
    }
    return (A) this;
  }
  
  public A withTolerations(Toleration... tolerations) {
    if (this.tolerations != null) {
        this.tolerations.clear();
        _visitables.remove("tolerations");
    }
    if (tolerations != null) {
      for (Toleration item : tolerations) {
        this.addToTolerations(item);
      }
    }
    return (A) this;
  }
  public class ExtractContentNested<N> extends ExtractContentConfigFluent<ExtractContentNested<N>> implements Nested<N>{
  
    ExtractContentConfigBuilder builder;
  
    ExtractContentNested(ExtractContentConfig item) {
      this.builder = new ExtractContentConfigBuilder(this, item);
    }
  
    public N and() {
      return (N) GrpcPodConfigFluent.this.withExtractContent(builder.build());
    }
    
    public N endExtractContent() {
      return and();
    }
    
  }
}