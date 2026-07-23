package io.fabric8.kubernetes.api.model.admissionregistration.v1;

import io.fabric8.kubernetes.api.builder.BaseFluent;
import io.fabric8.kubernetes.api.builder.Nested;
import io.fabric8.kubernetes.api.model.ObjectMeta;
import io.fabric8.kubernetes.api.model.ObjectMetaBuilder;
import io.fabric8.kubernetes.api.model.ObjectMetaFluent;
import java.lang.Object;
import java.lang.RuntimeException;
import java.lang.String;
import java.lang.StringBuilder;
import java.lang.SuppressWarnings;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
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
public class MutatingWebhookConfigurationFluent<A extends io.fabric8.kubernetes.api.model.admissionregistration.v1.MutatingWebhookConfigurationFluent<A>> extends BaseFluent<A>{

  private Map<String,Object> additionalProperties;
  private String apiVersion;
  private String kind;
  private ObjectMetaBuilder metadata;
  private ArrayList<MutatingWebhookBuilder> webhooks = new ArrayList<MutatingWebhookBuilder>();

  public MutatingWebhookConfigurationFluent() {
  }
  
  public MutatingWebhookConfigurationFluent(MutatingWebhookConfiguration instance) {
    this.copyInstance(instance);
  }

  public A addAllToWebhooks(Collection<MutatingWebhook> items) {
    if (this.webhooks == null) {
      this.webhooks = new ArrayList();
    }
    for (MutatingWebhook item : items) {
        MutatingWebhookBuilder builder = new MutatingWebhookBuilder(item);
        _visitables.get("webhooks").add(builder);
        this.webhooks.add(builder);
    }
    return (A) this;
  }
  
  public WebhooksNested<A> addNewWebhook() {
    return new WebhooksNested(-1, null);
  }
  
  public WebhooksNested<A> addNewWebhookLike(MutatingWebhook item) {
    return new WebhooksNested(-1, item);
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
  
  public A addToWebhooks(MutatingWebhook... items) {
    if (this.webhooks == null) {
      this.webhooks = new ArrayList();
    }
    for (MutatingWebhook item : items) {
        MutatingWebhookBuilder builder = new MutatingWebhookBuilder(item);
        _visitables.get("webhooks").add(builder);
        this.webhooks.add(builder);
    }
    return (A) this;
  }
  
  public A addToWebhooks(int index,MutatingWebhook item) {
    if (this.webhooks == null) {
      this.webhooks = new ArrayList();
    }
    MutatingWebhookBuilder builder = new MutatingWebhookBuilder(item);
    if (index < 0 || index >= webhooks.size()) {
        _visitables.get("webhooks").add(builder);
        webhooks.add(builder);
    } else {
        _visitables.get("webhooks").add(builder);
        webhooks.add(index, builder);
    }
    return (A) this;
  }
  
  public MutatingWebhook buildFirstWebhook() {
    return this.webhooks.get(0).build();
  }
  
  public MutatingWebhook buildLastWebhook() {
    return this.webhooks.get(webhooks.size() - 1).build();
  }
  
  public MutatingWebhook buildMatchingWebhook(Predicate<MutatingWebhookBuilder> predicate) {
      for (MutatingWebhookBuilder item : webhooks) {
        if (predicate.test(item)) {
          return item.build();
        }
      }
      return null;
  }
  
  public ObjectMeta buildMetadata() {
    return this.metadata != null ? this.metadata.build() : null;
  }
  
  public MutatingWebhook buildWebhook(int index) {
    return this.webhooks.get(index).build();
  }
  
  public List<MutatingWebhook> buildWebhooks() {
    return this.webhooks != null ? build(webhooks) : null;
  }
  
  protected void copyInstance(MutatingWebhookConfiguration instance) {
    instance = instance != null ? instance : new MutatingWebhookConfiguration();
    if (instance != null) {
        this.withApiVersion(instance.getApiVersion());
        this.withKind(instance.getKind());
        this.withMetadata(instance.getMetadata());
        this.withWebhooks(instance.getWebhooks());
        this.withAdditionalProperties(instance.getAdditionalProperties());
    }
  }
  
  public WebhooksNested<A> editFirstWebhook() {
    if (webhooks.size() == 0) {
      throw new RuntimeException(String.format("Can't edit first %s. The list is empty.", "webhooks"));
    }
    return this.setNewWebhookLike(0, this.buildWebhook(0));
  }
  
  public WebhooksNested<A> editLastWebhook() {
    int index = webhooks.size() - 1;
    if (index < 0) {
      throw new RuntimeException(String.format("Can't edit last %s. The list is empty.", "webhooks"));
    }
    return this.setNewWebhookLike(index, this.buildWebhook(index));
  }
  
  public WebhooksNested<A> editMatchingWebhook(Predicate<MutatingWebhookBuilder> predicate) {
    int index = -1;
    for (int i = 0;i < webhooks.size();i++) {
      if (predicate.test(webhooks.get(i))) {
          index = i;
          break;
      }
    }
    if (index < 0) {
      throw new RuntimeException(String.format("Can't edit matching %s. No match found.", "webhooks"));
    }
    return this.setNewWebhookLike(index, this.buildWebhook(index));
  }
  
  public MetadataNested<A> editMetadata() {
    return this.withNewMetadataLike(Optional.ofNullable(this.buildMetadata()).orElse(null));
  }
  
  public MetadataNested<A> editOrNewMetadata() {
    return this.withNewMetadataLike(Optional.ofNullable(this.buildMetadata()).orElse(new ObjectMetaBuilder().build()));
  }
  
  public MetadataNested<A> editOrNewMetadataLike(ObjectMeta item) {
    return this.withNewMetadataLike(Optional.ofNullable(this.buildMetadata()).orElse(item));
  }
  
  public WebhooksNested<A> editWebhook(int index) {
    if (webhooks.size() <= index) {
      throw new RuntimeException(String.format("Can't edit %s. Index exceeds size.", "webhooks"));
    }
    return this.setNewWebhookLike(index, this.buildWebhook(index));
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
    MutatingWebhookConfigurationFluent that = (MutatingWebhookConfigurationFluent) o;
    if (!(Objects.equals(apiVersion, that.apiVersion))) {
      return false;
    }
    if (!(Objects.equals(kind, that.kind))) {
      return false;
    }
    if (!(Objects.equals(metadata, that.metadata))) {
      return false;
    }
    if (!(Objects.equals(webhooks, that.webhooks))) {
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
  
  public String getApiVersion() {
    return this.apiVersion;
  }
  
  public String getKind() {
    return this.kind;
  }
  
  public boolean hasAdditionalProperties() {
    return this.additionalProperties != null;
  }
  
  public boolean hasApiVersion() {
    return this.apiVersion != null;
  }
  
  public boolean hasKind() {
    return this.kind != null;
  }
  
  public boolean hasMatchingWebhook(Predicate<MutatingWebhookBuilder> predicate) {
      for (MutatingWebhookBuilder item : webhooks) {
        if (predicate.test(item)) {
          return true;
        }
      }
      return false;
  }
  
  public boolean hasMetadata() {
    return this.metadata != null;
  }
  
  public boolean hasWebhooks() {
    return this.webhooks != null && !(this.webhooks.isEmpty());
  }
  
  public int hashCode() {
    return Objects.hash(apiVersion, kind, metadata, webhooks, additionalProperties);
  }
  
  public A removeAllFromWebhooks(Collection<MutatingWebhook> items) {
    if (this.webhooks == null) {
      return (A) this;
    }
    for (MutatingWebhook item : items) {
        MutatingWebhookBuilder builder = new MutatingWebhookBuilder(item);
        _visitables.get("webhooks").remove(builder);
        this.webhooks.remove(builder);
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
  
  public A removeFromWebhooks(MutatingWebhook... items) {
    if (this.webhooks == null) {
      return (A) this;
    }
    for (MutatingWebhook item : items) {
        MutatingWebhookBuilder builder = new MutatingWebhookBuilder(item);
        _visitables.get("webhooks").remove(builder);
        this.webhooks.remove(builder);
    }
    return (A) this;
  }
  
  public A removeMatchingFromWebhooks(Predicate<MutatingWebhookBuilder> predicate) {
    if (webhooks == null) {
      return (A) this;
    }
    Iterator<MutatingWebhookBuilder> each = webhooks.iterator();
    List visitables = _visitables.get("webhooks");
    while (each.hasNext()) {
        MutatingWebhookBuilder builder = each.next();
        if (predicate.test(builder)) {
            visitables.remove(builder);
            each.remove();
        }
    }
    return (A) this;
  }
  
  public WebhooksNested<A> setNewWebhookLike(int index,MutatingWebhook item) {
    return new WebhooksNested(index, item);
  }
  
  public A setToWebhooks(int index,MutatingWebhook item) {
    if (this.webhooks == null) {
      this.webhooks = new ArrayList();
    }
    MutatingWebhookBuilder builder = new MutatingWebhookBuilder(item);
    if (index < 0 || index >= webhooks.size()) {
        _visitables.get("webhooks").add(builder);
        webhooks.add(builder);
    } else {
        _visitables.get("webhooks").add(builder);
        webhooks.set(index, builder);
    }
    return (A) this;
  }
  
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("{");
    if (!(apiVersion == null)) {
        sb.append("apiVersion:");
        sb.append(apiVersion);
        sb.append(",");
    }
    if (!(kind == null)) {
        sb.append("kind:");
        sb.append(kind);
        sb.append(",");
    }
    if (!(metadata == null)) {
        sb.append("metadata:");
        sb.append(metadata);
        sb.append(",");
    }
    if (!(webhooks == null) && !(webhooks.isEmpty())) {
        sb.append("webhooks:");
        sb.append(webhooks);
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
  
  public A withApiVersion(String apiVersion) {
    this.apiVersion = apiVersion;
    return (A) this;
  }
  
  public A withKind(String kind) {
    this.kind = kind;
    return (A) this;
  }
  
  public A withMetadata(ObjectMeta metadata) {
    this._visitables.remove("metadata");
    if (metadata != null) {
        this.metadata = new ObjectMetaBuilder(metadata);
        this._visitables.get("metadata").add(this.metadata);
    } else {
        this.metadata = null;
        this._visitables.get("metadata").remove(this.metadata);
    }
    return (A) this;
  }
  
  public MetadataNested<A> withNewMetadata() {
    return new MetadataNested(null);
  }
  
  public MetadataNested<A> withNewMetadataLike(ObjectMeta item) {
    return new MetadataNested(item);
  }
  
  public A withWebhooks(List<MutatingWebhook> webhooks) {
    if (this.webhooks != null) {
      this._visitables.get("webhooks").clear();
    }
    if (webhooks != null) {
        this.webhooks = new ArrayList();
        for (MutatingWebhook item : webhooks) {
          this.addToWebhooks(item);
        }
    } else {
      this.webhooks = null;
    }
    return (A) this;
  }
  
  public A withWebhooks(MutatingWebhook... webhooks) {
    if (this.webhooks != null) {
        this.webhooks.clear();
        _visitables.remove("webhooks");
    }
    if (webhooks != null) {
      for (MutatingWebhook item : webhooks) {
        this.addToWebhooks(item);
      }
    }
    return (A) this;
  }
  public class MetadataNested<N> extends ObjectMetaFluent<MetadataNested<N>> implements Nested<N>{
  
    ObjectMetaBuilder builder;
  
    MetadataNested(ObjectMeta item) {
      this.builder = new ObjectMetaBuilder(this, item);
    }
  
    public N and() {
      return (N) MutatingWebhookConfigurationFluent.this.withMetadata(builder.build());
    }
    
    public N endMetadata() {
      return and();
    }
    
  }
  public class WebhooksNested<N> extends MutatingWebhookFluent<WebhooksNested<N>> implements Nested<N>{
  
    MutatingWebhookBuilder builder;
    int index;
  
    WebhooksNested(int index,MutatingWebhook item) {
      this.index = index;
      this.builder = new MutatingWebhookBuilder(this, item);
    }
  
    public N and() {
      return (N) MutatingWebhookConfigurationFluent.this.setToWebhooks(index, builder.build());
    }
    
    public N endWebhook() {
      return and();
    }
    
  }
}