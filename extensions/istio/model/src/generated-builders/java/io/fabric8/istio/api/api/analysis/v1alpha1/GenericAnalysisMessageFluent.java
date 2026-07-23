package io.fabric8.istio.api.api.analysis.v1alpha1;

import io.fabric8.kubernetes.api.builder.BaseFluent;
import io.fabric8.kubernetes.api.builder.Nested;
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
public class GenericAnalysisMessageFluent<A extends io.fabric8.istio.api.api.analysis.v1alpha1.GenericAnalysisMessageFluent<A>> extends BaseFluent<A>{

  private Map<String,Object> additionalProperties;
  private Object args;
  private AnalysisMessageBaseBuilder messageBase;
  private List<String> resourcePaths = new ArrayList<String>();

  public GenericAnalysisMessageFluent() {
  }
  
  public GenericAnalysisMessageFluent(GenericAnalysisMessage instance) {
    this.copyInstance(instance);
  }

  public A addAllToResourcePaths(Collection<String> items) {
    if (this.resourcePaths == null) {
      this.resourcePaths = new ArrayList();
    }
    for (String item : items) {
      this.resourcePaths.add(item);
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
  
  public A addToResourcePaths(String... items) {
    if (this.resourcePaths == null) {
      this.resourcePaths = new ArrayList();
    }
    for (String item : items) {
      this.resourcePaths.add(item);
    }
    return (A) this;
  }
  
  public A addToResourcePaths(int index,String item) {
    if (this.resourcePaths == null) {
      this.resourcePaths = new ArrayList();
    }
    this.resourcePaths.add(index, item);
    return (A) this;
  }
  
  public AnalysisMessageBase buildMessageBase() {
    return this.messageBase != null ? this.messageBase.build() : null;
  }
  
  protected void copyInstance(GenericAnalysisMessage instance) {
    instance = instance != null ? instance : new GenericAnalysisMessage();
    if (instance != null) {
        this.withArgs(instance.getArgs());
        this.withMessageBase(instance.getMessageBase());
        this.withResourcePaths(instance.getResourcePaths());
        this.withAdditionalProperties(instance.getAdditionalProperties());
    }
  }
  
  public MessageBaseNested<A> editMessageBase() {
    return this.withNewMessageBaseLike(Optional.ofNullable(this.buildMessageBase()).orElse(null));
  }
  
  public MessageBaseNested<A> editOrNewMessageBase() {
    return this.withNewMessageBaseLike(Optional.ofNullable(this.buildMessageBase()).orElse(new AnalysisMessageBaseBuilder().build()));
  }
  
  public MessageBaseNested<A> editOrNewMessageBaseLike(AnalysisMessageBase item) {
    return this.withNewMessageBaseLike(Optional.ofNullable(this.buildMessageBase()).orElse(item));
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
    GenericAnalysisMessageFluent that = (GenericAnalysisMessageFluent) o;
    if (!(Objects.equals(args, that.args))) {
      return false;
    }
    if (!(Objects.equals(messageBase, that.messageBase))) {
      return false;
    }
    if (!(Objects.equals(resourcePaths, that.resourcePaths))) {
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
  
  public Object getArgs() {
    return this.args;
  }
  
  public String getFirstResourcePath() {
    return this.resourcePaths.get(0);
  }
  
  public String getLastResourcePath() {
    return this.resourcePaths.get(resourcePaths.size() - 1);
  }
  
  public String getMatchingResourcePath(Predicate<String> predicate) {
      for (String item : resourcePaths) {
        if (predicate.test(item)) {
          return item;
        }
      }
      return null;
  }
  
  public String getResourcePath(int index) {
    return this.resourcePaths.get(index);
  }
  
  public List<String> getResourcePaths() {
    return this.resourcePaths;
  }
  
  public boolean hasAdditionalProperties() {
    return this.additionalProperties != null;
  }
  
  public boolean hasArgs() {
    return this.args != null;
  }
  
  public boolean hasMatchingResourcePath(Predicate<String> predicate) {
      for (String item : resourcePaths) {
        if (predicate.test(item)) {
          return true;
        }
      }
      return false;
  }
  
  public boolean hasMessageBase() {
    return this.messageBase != null;
  }
  
  public boolean hasResourcePaths() {
    return this.resourcePaths != null && !(this.resourcePaths.isEmpty());
  }
  
  public int hashCode() {
    return Objects.hash(args, messageBase, resourcePaths, additionalProperties);
  }
  
  public A removeAllFromResourcePaths(Collection<String> items) {
    if (this.resourcePaths == null) {
      return (A) this;
    }
    for (String item : items) {
      this.resourcePaths.remove(item);
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
  
  public A removeFromResourcePaths(String... items) {
    if (this.resourcePaths == null) {
      return (A) this;
    }
    for (String item : items) {
      this.resourcePaths.remove(item);
    }
    return (A) this;
  }
  
  public A setToResourcePaths(int index,String item) {
    if (this.resourcePaths == null) {
      this.resourcePaths = new ArrayList();
    }
    this.resourcePaths.set(index, item);
    return (A) this;
  }
  
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("{");
    if (!(args == null)) {
        sb.append("args:");
        sb.append(args);
        sb.append(",");
    }
    if (!(messageBase == null)) {
        sb.append("messageBase:");
        sb.append(messageBase);
        sb.append(",");
    }
    if (!(resourcePaths == null) && !(resourcePaths.isEmpty())) {
        sb.append("resourcePaths:");
        sb.append(resourcePaths);
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
  
  public A withArgs(Object args) {
    this.args = args;
    return (A) this;
  }
  
  public A withMessageBase(AnalysisMessageBase messageBase) {
    this._visitables.remove("messageBase");
    if (messageBase != null) {
        this.messageBase = new AnalysisMessageBaseBuilder(messageBase);
        this._visitables.get("messageBase").add(this.messageBase);
    } else {
        this.messageBase = null;
        this._visitables.get("messageBase").remove(this.messageBase);
    }
    return (A) this;
  }
  
  public MessageBaseNested<A> withNewMessageBase() {
    return new MessageBaseNested(null);
  }
  
  public MessageBaseNested<A> withNewMessageBaseLike(AnalysisMessageBase item) {
    return new MessageBaseNested(item);
  }
  
  public A withResourcePaths(List<String> resourcePaths) {
    if (resourcePaths != null) {
        this.resourcePaths = new ArrayList();
        for (String item : resourcePaths) {
          this.addToResourcePaths(item);
        }
    } else {
      this.resourcePaths = null;
    }
    return (A) this;
  }
  
  public A withResourcePaths(String... resourcePaths) {
    if (this.resourcePaths != null) {
        this.resourcePaths.clear();
        _visitables.remove("resourcePaths");
    }
    if (resourcePaths != null) {
      for (String item : resourcePaths) {
        this.addToResourcePaths(item);
      }
    }
    return (A) this;
  }
  public class MessageBaseNested<N> extends AnalysisMessageBaseFluent<MessageBaseNested<N>> implements Nested<N>{
  
    AnalysisMessageBaseBuilder builder;
  
    MessageBaseNested(AnalysisMessageBase item) {
      this.builder = new AnalysisMessageBaseBuilder(this, item);
    }
  
    public N and() {
      return (N) GenericAnalysisMessageFluent.this.withMessageBase(builder.build());
    }
    
    public N endMessageBase() {
      return and();
    }
    
  }
}