package io.fabric8.istio.api.api.networking.v1alpha3;

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
public class WorkloadGroupFluent<A extends io.fabric8.istio.api.api.networking.v1alpha3.WorkloadGroupFluent<A>> extends BaseFluent<A>{

  private Map<String,Object> additionalProperties;
  private WorkloadGroupObjectMetaBuilder metadata;
  private ReadinessProbeBuilder probe;
  private WorkloadEntryBuilder template;

  public WorkloadGroupFluent() {
  }
  
  public WorkloadGroupFluent(WorkloadGroup instance) {
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
  
  public WorkloadGroupObjectMeta buildMetadata() {
    return this.metadata != null ? this.metadata.build() : null;
  }
  
  public ReadinessProbe buildProbe() {
    return this.probe != null ? this.probe.build() : null;
  }
  
  public WorkloadEntry buildTemplate() {
    return this.template != null ? this.template.build() : null;
  }
  
  protected void copyInstance(WorkloadGroup instance) {
    instance = instance != null ? instance : new WorkloadGroup();
    if (instance != null) {
        this.withMetadata(instance.getMetadata());
        this.withProbe(instance.getProbe());
        this.withTemplate(instance.getTemplate());
        this.withAdditionalProperties(instance.getAdditionalProperties());
    }
  }
  
  public MetadataNested<A> editMetadata() {
    return this.withNewMetadataLike(Optional.ofNullable(this.buildMetadata()).orElse(null));
  }
  
  public MetadataNested<A> editOrNewMetadata() {
    return this.withNewMetadataLike(Optional.ofNullable(this.buildMetadata()).orElse(new WorkloadGroupObjectMetaBuilder().build()));
  }
  
  public MetadataNested<A> editOrNewMetadataLike(WorkloadGroupObjectMeta item) {
    return this.withNewMetadataLike(Optional.ofNullable(this.buildMetadata()).orElse(item));
  }
  
  public ProbeNested<A> editOrNewProbe() {
    return this.withNewProbeLike(Optional.ofNullable(this.buildProbe()).orElse(new ReadinessProbeBuilder().build()));
  }
  
  public ProbeNested<A> editOrNewProbeLike(ReadinessProbe item) {
    return this.withNewProbeLike(Optional.ofNullable(this.buildProbe()).orElse(item));
  }
  
  public TemplateNested<A> editOrNewTemplate() {
    return this.withNewTemplateLike(Optional.ofNullable(this.buildTemplate()).orElse(new WorkloadEntryBuilder().build()));
  }
  
  public TemplateNested<A> editOrNewTemplateLike(WorkloadEntry item) {
    return this.withNewTemplateLike(Optional.ofNullable(this.buildTemplate()).orElse(item));
  }
  
  public ProbeNested<A> editProbe() {
    return this.withNewProbeLike(Optional.ofNullable(this.buildProbe()).orElse(null));
  }
  
  public TemplateNested<A> editTemplate() {
    return this.withNewTemplateLike(Optional.ofNullable(this.buildTemplate()).orElse(null));
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
    WorkloadGroupFluent that = (WorkloadGroupFluent) o;
    if (!(Objects.equals(metadata, that.metadata))) {
      return false;
    }
    if (!(Objects.equals(probe, that.probe))) {
      return false;
    }
    if (!(Objects.equals(template, that.template))) {
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
  
  public boolean hasAdditionalProperties() {
    return this.additionalProperties != null;
  }
  
  public boolean hasMetadata() {
    return this.metadata != null;
  }
  
  public boolean hasProbe() {
    return this.probe != null;
  }
  
  public boolean hasTemplate() {
    return this.template != null;
  }
  
  public int hashCode() {
    return Objects.hash(metadata, probe, template, additionalProperties);
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
    if (!(metadata == null)) {
        sb.append("metadata:");
        sb.append(metadata);
        sb.append(",");
    }
    if (!(probe == null)) {
        sb.append("probe:");
        sb.append(probe);
        sb.append(",");
    }
    if (!(template == null)) {
        sb.append("template:");
        sb.append(template);
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
  
  public A withMetadata(WorkloadGroupObjectMeta metadata) {
    this._visitables.remove("metadata");
    if (metadata != null) {
        this.metadata = new WorkloadGroupObjectMetaBuilder(metadata);
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
  
  public MetadataNested<A> withNewMetadataLike(WorkloadGroupObjectMeta item) {
    return new MetadataNested(item);
  }
  
  public ProbeNested<A> withNewProbe() {
    return new ProbeNested(null);
  }
  
  public ProbeNested<A> withNewProbeLike(ReadinessProbe item) {
    return new ProbeNested(item);
  }
  
  public TemplateNested<A> withNewTemplate() {
    return new TemplateNested(null);
  }
  
  public TemplateNested<A> withNewTemplateLike(WorkloadEntry item) {
    return new TemplateNested(item);
  }
  
  public A withProbe(ReadinessProbe probe) {
    this._visitables.remove("probe");
    if (probe != null) {
        this.probe = new ReadinessProbeBuilder(probe);
        this._visitables.get("probe").add(this.probe);
    } else {
        this.probe = null;
        this._visitables.get("probe").remove(this.probe);
    }
    return (A) this;
  }
  
  public A withTemplate(WorkloadEntry template) {
    this._visitables.remove("template");
    if (template != null) {
        this.template = new WorkloadEntryBuilder(template);
        this._visitables.get("template").add(this.template);
    } else {
        this.template = null;
        this._visitables.get("template").remove(this.template);
    }
    return (A) this;
  }
  public class MetadataNested<N> extends WorkloadGroupObjectMetaFluent<MetadataNested<N>> implements Nested<N>{
  
    WorkloadGroupObjectMetaBuilder builder;
  
    MetadataNested(WorkloadGroupObjectMeta item) {
      this.builder = new WorkloadGroupObjectMetaBuilder(this, item);
    }
  
    public N and() {
      return (N) WorkloadGroupFluent.this.withMetadata(builder.build());
    }
    
    public N endMetadata() {
      return and();
    }
    
  }
  public class ProbeNested<N> extends ReadinessProbeFluent<ProbeNested<N>> implements Nested<N>{
  
    ReadinessProbeBuilder builder;
  
    ProbeNested(ReadinessProbe item) {
      this.builder = new ReadinessProbeBuilder(this, item);
    }
  
    public N and() {
      return (N) WorkloadGroupFluent.this.withProbe(builder.build());
    }
    
    public N endProbe() {
      return and();
    }
    
  }
  public class TemplateNested<N> extends WorkloadEntryFluent<TemplateNested<N>> implements Nested<N>{
  
    WorkloadEntryBuilder builder;
  
    TemplateNested(WorkloadEntry item) {
      this.builder = new WorkloadEntryBuilder(this, item);
    }
  
    public N and() {
      return (N) WorkloadGroupFluent.this.withTemplate(builder.build());
    }
    
    public N endTemplate() {
      return and();
    }
    
  }
}