package io.fabric8.openshift.api.model.monitoring.v1;

import io.fabric8.kubernetes.api.builder.BaseFluent;
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
import java.util.function.Predicate;

/**
 * Generated
 */
@SuppressWarnings("unchecked")
public class OTLPConfigFluent<A extends io.fabric8.openshift.api.model.monitoring.v1.OTLPConfigFluent<A>> extends BaseFluent<A>{

  private Map<String,Object> additionalProperties;
  private Boolean convertHistogramsToNHCB;
  private List<String> ignoreResourceAttributes = new ArrayList<String>();
  private Boolean keepIdentifyingResourceAttributes;
  private Boolean promoteAllResourceAttributes;
  private List<String> promoteResourceAttributes = new ArrayList<String>();
  private Boolean promoteScopeMetadata;
  private String translationStrategy;

  public OTLPConfigFluent() {
  }
  
  public OTLPConfigFluent(OTLPConfig instance) {
    this.copyInstance(instance);
  }

  public A addAllToIgnoreResourceAttributes(Collection<String> items) {
    if (this.ignoreResourceAttributes == null) {
      this.ignoreResourceAttributes = new ArrayList();
    }
    for (String item : items) {
      this.ignoreResourceAttributes.add(item);
    }
    return (A) this;
  }
  
  public A addAllToPromoteResourceAttributes(Collection<String> items) {
    if (this.promoteResourceAttributes == null) {
      this.promoteResourceAttributes = new ArrayList();
    }
    for (String item : items) {
      this.promoteResourceAttributes.add(item);
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
  
  public A addToIgnoreResourceAttributes(String... items) {
    if (this.ignoreResourceAttributes == null) {
      this.ignoreResourceAttributes = new ArrayList();
    }
    for (String item : items) {
      this.ignoreResourceAttributes.add(item);
    }
    return (A) this;
  }
  
  public A addToIgnoreResourceAttributes(int index,String item) {
    if (this.ignoreResourceAttributes == null) {
      this.ignoreResourceAttributes = new ArrayList();
    }
    this.ignoreResourceAttributes.add(index, item);
    return (A) this;
  }
  
  public A addToPromoteResourceAttributes(String... items) {
    if (this.promoteResourceAttributes == null) {
      this.promoteResourceAttributes = new ArrayList();
    }
    for (String item : items) {
      this.promoteResourceAttributes.add(item);
    }
    return (A) this;
  }
  
  public A addToPromoteResourceAttributes(int index,String item) {
    if (this.promoteResourceAttributes == null) {
      this.promoteResourceAttributes = new ArrayList();
    }
    this.promoteResourceAttributes.add(index, item);
    return (A) this;
  }
  
  protected void copyInstance(OTLPConfig instance) {
    instance = instance != null ? instance : new OTLPConfig();
    if (instance != null) {
        this.withConvertHistogramsToNHCB(instance.getConvertHistogramsToNHCB());
        this.withIgnoreResourceAttributes(instance.getIgnoreResourceAttributes());
        this.withKeepIdentifyingResourceAttributes(instance.getKeepIdentifyingResourceAttributes());
        this.withPromoteAllResourceAttributes(instance.getPromoteAllResourceAttributes());
        this.withPromoteResourceAttributes(instance.getPromoteResourceAttributes());
        this.withPromoteScopeMetadata(instance.getPromoteScopeMetadata());
        this.withTranslationStrategy(instance.getTranslationStrategy());
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
    OTLPConfigFluent that = (OTLPConfigFluent) o;
    if (!(Objects.equals(convertHistogramsToNHCB, that.convertHistogramsToNHCB))) {
      return false;
    }
    if (!(Objects.equals(ignoreResourceAttributes, that.ignoreResourceAttributes))) {
      return false;
    }
    if (!(Objects.equals(keepIdentifyingResourceAttributes, that.keepIdentifyingResourceAttributes))) {
      return false;
    }
    if (!(Objects.equals(promoteAllResourceAttributes, that.promoteAllResourceAttributes))) {
      return false;
    }
    if (!(Objects.equals(promoteResourceAttributes, that.promoteResourceAttributes))) {
      return false;
    }
    if (!(Objects.equals(promoteScopeMetadata, that.promoteScopeMetadata))) {
      return false;
    }
    if (!(Objects.equals(translationStrategy, that.translationStrategy))) {
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
  
  public Boolean getConvertHistogramsToNHCB() {
    return this.convertHistogramsToNHCB;
  }
  
  public String getFirstIgnoreResourceAttribute() {
    return this.ignoreResourceAttributes.get(0);
  }
  
  public String getFirstPromoteResourceAttribute() {
    return this.promoteResourceAttributes.get(0);
  }
  
  public String getIgnoreResourceAttribute(int index) {
    return this.ignoreResourceAttributes.get(index);
  }
  
  public List<String> getIgnoreResourceAttributes() {
    return this.ignoreResourceAttributes;
  }
  
  public Boolean getKeepIdentifyingResourceAttributes() {
    return this.keepIdentifyingResourceAttributes;
  }
  
  public String getLastIgnoreResourceAttribute() {
    return this.ignoreResourceAttributes.get(ignoreResourceAttributes.size() - 1);
  }
  
  public String getLastPromoteResourceAttribute() {
    return this.promoteResourceAttributes.get(promoteResourceAttributes.size() - 1);
  }
  
  public String getMatchingIgnoreResourceAttribute(Predicate<String> predicate) {
      for (String item : ignoreResourceAttributes) {
        if (predicate.test(item)) {
          return item;
        }
      }
      return null;
  }
  
  public String getMatchingPromoteResourceAttribute(Predicate<String> predicate) {
      for (String item : promoteResourceAttributes) {
        if (predicate.test(item)) {
          return item;
        }
      }
      return null;
  }
  
  public Boolean getPromoteAllResourceAttributes() {
    return this.promoteAllResourceAttributes;
  }
  
  public String getPromoteResourceAttribute(int index) {
    return this.promoteResourceAttributes.get(index);
  }
  
  public List<String> getPromoteResourceAttributes() {
    return this.promoteResourceAttributes;
  }
  
  public Boolean getPromoteScopeMetadata() {
    return this.promoteScopeMetadata;
  }
  
  public String getTranslationStrategy() {
    return this.translationStrategy;
  }
  
  public boolean hasAdditionalProperties() {
    return this.additionalProperties != null;
  }
  
  public boolean hasConvertHistogramsToNHCB() {
    return this.convertHistogramsToNHCB != null;
  }
  
  public boolean hasIgnoreResourceAttributes() {
    return this.ignoreResourceAttributes != null && !(this.ignoreResourceAttributes.isEmpty());
  }
  
  public boolean hasKeepIdentifyingResourceAttributes() {
    return this.keepIdentifyingResourceAttributes != null;
  }
  
  public boolean hasMatchingIgnoreResourceAttribute(Predicate<String> predicate) {
      for (String item : ignoreResourceAttributes) {
        if (predicate.test(item)) {
          return true;
        }
      }
      return false;
  }
  
  public boolean hasMatchingPromoteResourceAttribute(Predicate<String> predicate) {
      for (String item : promoteResourceAttributes) {
        if (predicate.test(item)) {
          return true;
        }
      }
      return false;
  }
  
  public boolean hasPromoteAllResourceAttributes() {
    return this.promoteAllResourceAttributes != null;
  }
  
  public boolean hasPromoteResourceAttributes() {
    return this.promoteResourceAttributes != null && !(this.promoteResourceAttributes.isEmpty());
  }
  
  public boolean hasPromoteScopeMetadata() {
    return this.promoteScopeMetadata != null;
  }
  
  public boolean hasTranslationStrategy() {
    return this.translationStrategy != null;
  }
  
  public int hashCode() {
    return Objects.hash(convertHistogramsToNHCB, ignoreResourceAttributes, keepIdentifyingResourceAttributes, promoteAllResourceAttributes, promoteResourceAttributes, promoteScopeMetadata, translationStrategy, additionalProperties);
  }
  
  public A removeAllFromIgnoreResourceAttributes(Collection<String> items) {
    if (this.ignoreResourceAttributes == null) {
      return (A) this;
    }
    for (String item : items) {
      this.ignoreResourceAttributes.remove(item);
    }
    return (A) this;
  }
  
  public A removeAllFromPromoteResourceAttributes(Collection<String> items) {
    if (this.promoteResourceAttributes == null) {
      return (A) this;
    }
    for (String item : items) {
      this.promoteResourceAttributes.remove(item);
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
  
  public A removeFromIgnoreResourceAttributes(String... items) {
    if (this.ignoreResourceAttributes == null) {
      return (A) this;
    }
    for (String item : items) {
      this.ignoreResourceAttributes.remove(item);
    }
    return (A) this;
  }
  
  public A removeFromPromoteResourceAttributes(String... items) {
    if (this.promoteResourceAttributes == null) {
      return (A) this;
    }
    for (String item : items) {
      this.promoteResourceAttributes.remove(item);
    }
    return (A) this;
  }
  
  public A setToIgnoreResourceAttributes(int index,String item) {
    if (this.ignoreResourceAttributes == null) {
      this.ignoreResourceAttributes = new ArrayList();
    }
    this.ignoreResourceAttributes.set(index, item);
    return (A) this;
  }
  
  public A setToPromoteResourceAttributes(int index,String item) {
    if (this.promoteResourceAttributes == null) {
      this.promoteResourceAttributes = new ArrayList();
    }
    this.promoteResourceAttributes.set(index, item);
    return (A) this;
  }
  
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("{");
    if (!(convertHistogramsToNHCB == null)) {
        sb.append("convertHistogramsToNHCB:");
        sb.append(convertHistogramsToNHCB);
        sb.append(",");
    }
    if (!(ignoreResourceAttributes == null) && !(ignoreResourceAttributes.isEmpty())) {
        sb.append("ignoreResourceAttributes:");
        sb.append(ignoreResourceAttributes);
        sb.append(",");
    }
    if (!(keepIdentifyingResourceAttributes == null)) {
        sb.append("keepIdentifyingResourceAttributes:");
        sb.append(keepIdentifyingResourceAttributes);
        sb.append(",");
    }
    if (!(promoteAllResourceAttributes == null)) {
        sb.append("promoteAllResourceAttributes:");
        sb.append(promoteAllResourceAttributes);
        sb.append(",");
    }
    if (!(promoteResourceAttributes == null) && !(promoteResourceAttributes.isEmpty())) {
        sb.append("promoteResourceAttributes:");
        sb.append(promoteResourceAttributes);
        sb.append(",");
    }
    if (!(promoteScopeMetadata == null)) {
        sb.append("promoteScopeMetadata:");
        sb.append(promoteScopeMetadata);
        sb.append(",");
    }
    if (!(translationStrategy == null)) {
        sb.append("translationStrategy:");
        sb.append(translationStrategy);
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
  
  public A withConvertHistogramsToNHCB() {
    return withConvertHistogramsToNHCB(true);
  }
  
  public A withConvertHistogramsToNHCB(Boolean convertHistogramsToNHCB) {
    this.convertHistogramsToNHCB = convertHistogramsToNHCB;
    return (A) this;
  }
  
  public A withIgnoreResourceAttributes(List<String> ignoreResourceAttributes) {
    if (ignoreResourceAttributes != null) {
        this.ignoreResourceAttributes = new ArrayList();
        for (String item : ignoreResourceAttributes) {
          this.addToIgnoreResourceAttributes(item);
        }
    } else {
      this.ignoreResourceAttributes = null;
    }
    return (A) this;
  }
  
  public A withIgnoreResourceAttributes(String... ignoreResourceAttributes) {
    if (this.ignoreResourceAttributes != null) {
        this.ignoreResourceAttributes.clear();
        _visitables.remove("ignoreResourceAttributes");
    }
    if (ignoreResourceAttributes != null) {
      for (String item : ignoreResourceAttributes) {
        this.addToIgnoreResourceAttributes(item);
      }
    }
    return (A) this;
  }
  
  public A withKeepIdentifyingResourceAttributes() {
    return withKeepIdentifyingResourceAttributes(true);
  }
  
  public A withKeepIdentifyingResourceAttributes(Boolean keepIdentifyingResourceAttributes) {
    this.keepIdentifyingResourceAttributes = keepIdentifyingResourceAttributes;
    return (A) this;
  }
  
  public A withPromoteAllResourceAttributes() {
    return withPromoteAllResourceAttributes(true);
  }
  
  public A withPromoteAllResourceAttributes(Boolean promoteAllResourceAttributes) {
    this.promoteAllResourceAttributes = promoteAllResourceAttributes;
    return (A) this;
  }
  
  public A withPromoteResourceAttributes(List<String> promoteResourceAttributes) {
    if (promoteResourceAttributes != null) {
        this.promoteResourceAttributes = new ArrayList();
        for (String item : promoteResourceAttributes) {
          this.addToPromoteResourceAttributes(item);
        }
    } else {
      this.promoteResourceAttributes = null;
    }
    return (A) this;
  }
  
  public A withPromoteResourceAttributes(String... promoteResourceAttributes) {
    if (this.promoteResourceAttributes != null) {
        this.promoteResourceAttributes.clear();
        _visitables.remove("promoteResourceAttributes");
    }
    if (promoteResourceAttributes != null) {
      for (String item : promoteResourceAttributes) {
        this.addToPromoteResourceAttributes(item);
      }
    }
    return (A) this;
  }
  
  public A withPromoteScopeMetadata() {
    return withPromoteScopeMetadata(true);
  }
  
  public A withPromoteScopeMetadata(Boolean promoteScopeMetadata) {
    this.promoteScopeMetadata = promoteScopeMetadata;
    return (A) this;
  }
  
  public A withTranslationStrategy(String translationStrategy) {
    this.translationStrategy = translationStrategy;
    return (A) this;
  }
  
}