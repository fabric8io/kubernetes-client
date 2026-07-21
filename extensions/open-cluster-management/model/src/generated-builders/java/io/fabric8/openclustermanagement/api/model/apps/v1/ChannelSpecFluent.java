package io.fabric8.openclustermanagement.api.model.apps.v1;

import io.fabric8.kubernetes.api.builder.BaseFluent;
import io.fabric8.kubernetes.api.builder.Nested;
import io.fabric8.kubernetes.api.model.ObjectReference;
import io.fabric8.kubernetes.api.model.ObjectReferenceBuilder;
import io.fabric8.kubernetes.api.model.ObjectReferenceFluent;
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
public class ChannelSpecFluent<A extends io.fabric8.openclustermanagement.api.model.apps.v1.ChannelSpecFluent<A>> extends BaseFluent<A>{

  private Map<String,Object> additionalProperties;
  private ObjectReferenceBuilder configMapRef;
  private ChannelGateBuilder gates;
  private Boolean insecureSkipVerify;
  private String pathname;
  private ObjectReferenceBuilder secretRef;
  private List<String> sourceNamespaces = new ArrayList<String>();
  private String type;

  public ChannelSpecFluent() {
  }
  
  public ChannelSpecFluent(ChannelSpec instance) {
    this.copyInstance(instance);
  }

  public A addAllToSourceNamespaces(Collection<String> items) {
    if (this.sourceNamespaces == null) {
      this.sourceNamespaces = new ArrayList();
    }
    for (String item : items) {
      this.sourceNamespaces.add(item);
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
  
  public A addToSourceNamespaces(String... items) {
    if (this.sourceNamespaces == null) {
      this.sourceNamespaces = new ArrayList();
    }
    for (String item : items) {
      this.sourceNamespaces.add(item);
    }
    return (A) this;
  }
  
  public A addToSourceNamespaces(int index,String item) {
    if (this.sourceNamespaces == null) {
      this.sourceNamespaces = new ArrayList();
    }
    this.sourceNamespaces.add(index, item);
    return (A) this;
  }
  
  public ObjectReference buildConfigMapRef() {
    return this.configMapRef != null ? this.configMapRef.build() : null;
  }
  
  public ChannelGate buildGates() {
    return this.gates != null ? this.gates.build() : null;
  }
  
  public ObjectReference buildSecretRef() {
    return this.secretRef != null ? this.secretRef.build() : null;
  }
  
  protected void copyInstance(ChannelSpec instance) {
    instance = instance != null ? instance : new ChannelSpec();
    if (instance != null) {
        this.withConfigMapRef(instance.getConfigMapRef());
        this.withGates(instance.getGates());
        this.withInsecureSkipVerify(instance.getInsecureSkipVerify());
        this.withPathname(instance.getPathname());
        this.withSecretRef(instance.getSecretRef());
        this.withSourceNamespaces(instance.getSourceNamespaces());
        this.withType(instance.getType());
        this.withAdditionalProperties(instance.getAdditionalProperties());
    }
  }
  
  public ConfigMapRefNested<A> editConfigMapRef() {
    return this.withNewConfigMapRefLike(Optional.ofNullable(this.buildConfigMapRef()).orElse(null));
  }
  
  public GatesNested<A> editGates() {
    return this.withNewGatesLike(Optional.ofNullable(this.buildGates()).orElse(null));
  }
  
  public ConfigMapRefNested<A> editOrNewConfigMapRef() {
    return this.withNewConfigMapRefLike(Optional.ofNullable(this.buildConfigMapRef()).orElse(new ObjectReferenceBuilder().build()));
  }
  
  public ConfigMapRefNested<A> editOrNewConfigMapRefLike(ObjectReference item) {
    return this.withNewConfigMapRefLike(Optional.ofNullable(this.buildConfigMapRef()).orElse(item));
  }
  
  public GatesNested<A> editOrNewGates() {
    return this.withNewGatesLike(Optional.ofNullable(this.buildGates()).orElse(new ChannelGateBuilder().build()));
  }
  
  public GatesNested<A> editOrNewGatesLike(ChannelGate item) {
    return this.withNewGatesLike(Optional.ofNullable(this.buildGates()).orElse(item));
  }
  
  public SecretRefNested<A> editOrNewSecretRef() {
    return this.withNewSecretRefLike(Optional.ofNullable(this.buildSecretRef()).orElse(new ObjectReferenceBuilder().build()));
  }
  
  public SecretRefNested<A> editOrNewSecretRefLike(ObjectReference item) {
    return this.withNewSecretRefLike(Optional.ofNullable(this.buildSecretRef()).orElse(item));
  }
  
  public SecretRefNested<A> editSecretRef() {
    return this.withNewSecretRefLike(Optional.ofNullable(this.buildSecretRef()).orElse(null));
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
    ChannelSpecFluent that = (ChannelSpecFluent) o;
    if (!(Objects.equals(configMapRef, that.configMapRef))) {
      return false;
    }
    if (!(Objects.equals(gates, that.gates))) {
      return false;
    }
    if (!(Objects.equals(insecureSkipVerify, that.insecureSkipVerify))) {
      return false;
    }
    if (!(Objects.equals(pathname, that.pathname))) {
      return false;
    }
    if (!(Objects.equals(secretRef, that.secretRef))) {
      return false;
    }
    if (!(Objects.equals(sourceNamespaces, that.sourceNamespaces))) {
      return false;
    }
    if (!(Objects.equals(type, that.type))) {
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
  
  public String getFirstSourceNamespace() {
    return this.sourceNamespaces.get(0);
  }
  
  public Boolean getInsecureSkipVerify() {
    return this.insecureSkipVerify;
  }
  
  public String getLastSourceNamespace() {
    return this.sourceNamespaces.get(sourceNamespaces.size() - 1);
  }
  
  public String getMatchingSourceNamespace(Predicate<String> predicate) {
      for (String item : sourceNamespaces) {
        if (predicate.test(item)) {
          return item;
        }
      }
      return null;
  }
  
  public String getPathname() {
    return this.pathname;
  }
  
  public String getSourceNamespace(int index) {
    return this.sourceNamespaces.get(index);
  }
  
  public List<String> getSourceNamespaces() {
    return this.sourceNamespaces;
  }
  
  public String getType() {
    return this.type;
  }
  
  public boolean hasAdditionalProperties() {
    return this.additionalProperties != null;
  }
  
  public boolean hasConfigMapRef() {
    return this.configMapRef != null;
  }
  
  public boolean hasGates() {
    return this.gates != null;
  }
  
  public boolean hasInsecureSkipVerify() {
    return this.insecureSkipVerify != null;
  }
  
  public boolean hasMatchingSourceNamespace(Predicate<String> predicate) {
      for (String item : sourceNamespaces) {
        if (predicate.test(item)) {
          return true;
        }
      }
      return false;
  }
  
  public boolean hasPathname() {
    return this.pathname != null;
  }
  
  public boolean hasSecretRef() {
    return this.secretRef != null;
  }
  
  public boolean hasSourceNamespaces() {
    return this.sourceNamespaces != null && !(this.sourceNamespaces.isEmpty());
  }
  
  public boolean hasType() {
    return this.type != null;
  }
  
  public int hashCode() {
    return Objects.hash(configMapRef, gates, insecureSkipVerify, pathname, secretRef, sourceNamespaces, type, additionalProperties);
  }
  
  public A removeAllFromSourceNamespaces(Collection<String> items) {
    if (this.sourceNamespaces == null) {
      return (A) this;
    }
    for (String item : items) {
      this.sourceNamespaces.remove(item);
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
  
  public A removeFromSourceNamespaces(String... items) {
    if (this.sourceNamespaces == null) {
      return (A) this;
    }
    for (String item : items) {
      this.sourceNamespaces.remove(item);
    }
    return (A) this;
  }
  
  public A setToSourceNamespaces(int index,String item) {
    if (this.sourceNamespaces == null) {
      this.sourceNamespaces = new ArrayList();
    }
    this.sourceNamespaces.set(index, item);
    return (A) this;
  }
  
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("{");
    if (!(configMapRef == null)) {
        sb.append("configMapRef:");
        sb.append(configMapRef);
        sb.append(",");
    }
    if (!(gates == null)) {
        sb.append("gates:");
        sb.append(gates);
        sb.append(",");
    }
    if (!(insecureSkipVerify == null)) {
        sb.append("insecureSkipVerify:");
        sb.append(insecureSkipVerify);
        sb.append(",");
    }
    if (!(pathname == null)) {
        sb.append("pathname:");
        sb.append(pathname);
        sb.append(",");
    }
    if (!(secretRef == null)) {
        sb.append("secretRef:");
        sb.append(secretRef);
        sb.append(",");
    }
    if (!(sourceNamespaces == null) && !(sourceNamespaces.isEmpty())) {
        sb.append("sourceNamespaces:");
        sb.append(sourceNamespaces);
        sb.append(",");
    }
    if (!(type == null)) {
        sb.append("type:");
        sb.append(type);
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
  
  public A withConfigMapRef(ObjectReference configMapRef) {
    this._visitables.remove("configMapRef");
    if (configMapRef != null) {
        this.configMapRef = new ObjectReferenceBuilder(configMapRef);
        this._visitables.get("configMapRef").add(this.configMapRef);
    } else {
        this.configMapRef = null;
        this._visitables.get("configMapRef").remove(this.configMapRef);
    }
    return (A) this;
  }
  
  public A withGates(ChannelGate gates) {
    this._visitables.remove("gates");
    if (gates != null) {
        this.gates = new ChannelGateBuilder(gates);
        this._visitables.get("gates").add(this.gates);
    } else {
        this.gates = null;
        this._visitables.get("gates").remove(this.gates);
    }
    return (A) this;
  }
  
  public A withInsecureSkipVerify() {
    return withInsecureSkipVerify(true);
  }
  
  public A withInsecureSkipVerify(Boolean insecureSkipVerify) {
    this.insecureSkipVerify = insecureSkipVerify;
    return (A) this;
  }
  
  public ConfigMapRefNested<A> withNewConfigMapRef() {
    return new ConfigMapRefNested(null);
  }
  
  public ConfigMapRefNested<A> withNewConfigMapRefLike(ObjectReference item) {
    return new ConfigMapRefNested(item);
  }
  
  public GatesNested<A> withNewGates() {
    return new GatesNested(null);
  }
  
  public GatesNested<A> withNewGatesLike(ChannelGate item) {
    return new GatesNested(item);
  }
  
  public SecretRefNested<A> withNewSecretRef() {
    return new SecretRefNested(null);
  }
  
  public SecretRefNested<A> withNewSecretRefLike(ObjectReference item) {
    return new SecretRefNested(item);
  }
  
  public A withPathname(String pathname) {
    this.pathname = pathname;
    return (A) this;
  }
  
  public A withSecretRef(ObjectReference secretRef) {
    this._visitables.remove("secretRef");
    if (secretRef != null) {
        this.secretRef = new ObjectReferenceBuilder(secretRef);
        this._visitables.get("secretRef").add(this.secretRef);
    } else {
        this.secretRef = null;
        this._visitables.get("secretRef").remove(this.secretRef);
    }
    return (A) this;
  }
  
  public A withSourceNamespaces(List<String> sourceNamespaces) {
    if (sourceNamespaces != null) {
        this.sourceNamespaces = new ArrayList();
        for (String item : sourceNamespaces) {
          this.addToSourceNamespaces(item);
        }
    } else {
      this.sourceNamespaces = null;
    }
    return (A) this;
  }
  
  public A withSourceNamespaces(String... sourceNamespaces) {
    if (this.sourceNamespaces != null) {
        this.sourceNamespaces.clear();
        _visitables.remove("sourceNamespaces");
    }
    if (sourceNamespaces != null) {
      for (String item : sourceNamespaces) {
        this.addToSourceNamespaces(item);
      }
    }
    return (A) this;
  }
  
  public A withType(String type) {
    this.type = type;
    return (A) this;
  }
  public class ConfigMapRefNested<N> extends ObjectReferenceFluent<ConfigMapRefNested<N>> implements Nested<N>{
  
    ObjectReferenceBuilder builder;
  
    ConfigMapRefNested(ObjectReference item) {
      this.builder = new ObjectReferenceBuilder(this, item);
    }
  
    public N and() {
      return (N) ChannelSpecFluent.this.withConfigMapRef(builder.build());
    }
    
    public N endConfigMapRef() {
      return and();
    }
    
  }
  public class GatesNested<N> extends ChannelGateFluent<GatesNested<N>> implements Nested<N>{
  
    ChannelGateBuilder builder;
  
    GatesNested(ChannelGate item) {
      this.builder = new ChannelGateBuilder(this, item);
    }
  
    public N and() {
      return (N) ChannelSpecFluent.this.withGates(builder.build());
    }
    
    public N endGates() {
      return and();
    }
    
  }
  public class SecretRefNested<N> extends ObjectReferenceFluent<SecretRefNested<N>> implements Nested<N>{
  
    ObjectReferenceBuilder builder;
  
    SecretRefNested(ObjectReference item) {
      this.builder = new ObjectReferenceBuilder(this, item);
    }
  
    public N and() {
      return (N) ChannelSpecFluent.this.withSecretRef(builder.build());
    }
    
    public N endSecretRef() {
      return and();
    }
    
  }
}