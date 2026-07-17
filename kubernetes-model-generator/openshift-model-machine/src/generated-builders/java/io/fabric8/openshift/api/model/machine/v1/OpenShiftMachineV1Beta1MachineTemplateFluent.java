package io.fabric8.openshift.api.model.machine.v1;

import io.fabric8.kubernetes.api.builder.BaseFluent;
import io.fabric8.kubernetes.api.builder.Nested;
import io.fabric8.openshift.api.model.machine.v1beta1.MachineSpec;
import io.fabric8.openshift.api.model.machine.v1beta1.MachineSpecBuilder;
import io.fabric8.openshift.api.model.machine.v1beta1.MachineSpecFluent;
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
public class OpenShiftMachineV1Beta1MachineTemplateFluent<A extends io.fabric8.openshift.api.model.machine.v1.OpenShiftMachineV1Beta1MachineTemplateFluent<A>> extends BaseFluent<A>{

  private Map<String,Object> additionalProperties;
  private FailureDomainsBuilder failureDomains;
  private ControlPlaneMachineSetTemplateObjectMetaBuilder metadata;
  private MachineSpecBuilder spec;

  public OpenShiftMachineV1Beta1MachineTemplateFluent() {
  }
  
  public OpenShiftMachineV1Beta1MachineTemplateFluent(OpenShiftMachineV1Beta1MachineTemplate instance) {
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
  
  public FailureDomains buildFailureDomains() {
    return this.failureDomains != null ? this.failureDomains.build() : null;
  }
  
  public ControlPlaneMachineSetTemplateObjectMeta buildMetadata() {
    return this.metadata != null ? this.metadata.build() : null;
  }
  
  public MachineSpec buildSpec() {
    return this.spec != null ? this.spec.build() : null;
  }
  
  protected void copyInstance(OpenShiftMachineV1Beta1MachineTemplate instance) {
    instance = instance != null ? instance : new OpenShiftMachineV1Beta1MachineTemplate();
    if (instance != null) {
        this.withFailureDomains(instance.getFailureDomains());
        this.withMetadata(instance.getMetadata());
        this.withSpec(instance.getSpec());
        this.withAdditionalProperties(instance.getAdditionalProperties());
    }
  }
  
  public FailureDomainsNested<A> editFailureDomains() {
    return this.withNewFailureDomainsLike(Optional.ofNullable(this.buildFailureDomains()).orElse(null));
  }
  
  public MetadataNested<A> editMetadata() {
    return this.withNewMetadataLike(Optional.ofNullable(this.buildMetadata()).orElse(null));
  }
  
  public FailureDomainsNested<A> editOrNewFailureDomains() {
    return this.withNewFailureDomainsLike(Optional.ofNullable(this.buildFailureDomains()).orElse(new FailureDomainsBuilder().build()));
  }
  
  public FailureDomainsNested<A> editOrNewFailureDomainsLike(FailureDomains item) {
    return this.withNewFailureDomainsLike(Optional.ofNullable(this.buildFailureDomains()).orElse(item));
  }
  
  public MetadataNested<A> editOrNewMetadata() {
    return this.withNewMetadataLike(Optional.ofNullable(this.buildMetadata()).orElse(new ControlPlaneMachineSetTemplateObjectMetaBuilder().build()));
  }
  
  public MetadataNested<A> editOrNewMetadataLike(ControlPlaneMachineSetTemplateObjectMeta item) {
    return this.withNewMetadataLike(Optional.ofNullable(this.buildMetadata()).orElse(item));
  }
  
  public SpecNested<A> editOrNewSpec() {
    return this.withNewSpecLike(Optional.ofNullable(this.buildSpec()).orElse(new MachineSpecBuilder().build()));
  }
  
  public SpecNested<A> editOrNewSpecLike(MachineSpec item) {
    return this.withNewSpecLike(Optional.ofNullable(this.buildSpec()).orElse(item));
  }
  
  public SpecNested<A> editSpec() {
    return this.withNewSpecLike(Optional.ofNullable(this.buildSpec()).orElse(null));
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
    OpenShiftMachineV1Beta1MachineTemplateFluent that = (OpenShiftMachineV1Beta1MachineTemplateFluent) o;
    if (!(Objects.equals(failureDomains, that.failureDomains))) {
      return false;
    }
    if (!(Objects.equals(metadata, that.metadata))) {
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
  
  public boolean hasAdditionalProperties() {
    return this.additionalProperties != null;
  }
  
  public boolean hasFailureDomains() {
    return this.failureDomains != null;
  }
  
  public boolean hasMetadata() {
    return this.metadata != null;
  }
  
  public boolean hasSpec() {
    return this.spec != null;
  }
  
  public int hashCode() {
    return Objects.hash(failureDomains, metadata, spec, additionalProperties);
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
    if (!(failureDomains == null)) {
        sb.append("failureDomains:");
        sb.append(failureDomains);
        sb.append(",");
    }
    if (!(metadata == null)) {
        sb.append("metadata:");
        sb.append(metadata);
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
  
  public A withFailureDomains(FailureDomains failureDomains) {
    this._visitables.remove("failureDomains");
    if (failureDomains != null) {
        this.failureDomains = new FailureDomainsBuilder(failureDomains);
        this._visitables.get("failureDomains").add(this.failureDomains);
    } else {
        this.failureDomains = null;
        this._visitables.get("failureDomains").remove(this.failureDomains);
    }
    return (A) this;
  }
  
  public A withMetadata(ControlPlaneMachineSetTemplateObjectMeta metadata) {
    this._visitables.remove("metadata");
    if (metadata != null) {
        this.metadata = new ControlPlaneMachineSetTemplateObjectMetaBuilder(metadata);
        this._visitables.get("metadata").add(this.metadata);
    } else {
        this.metadata = null;
        this._visitables.get("metadata").remove(this.metadata);
    }
    return (A) this;
  }
  
  public FailureDomainsNested<A> withNewFailureDomains() {
    return new FailureDomainsNested(null);
  }
  
  public FailureDomainsNested<A> withNewFailureDomainsLike(FailureDomains item) {
    return new FailureDomainsNested(item);
  }
  
  public MetadataNested<A> withNewMetadata() {
    return new MetadataNested(null);
  }
  
  public MetadataNested<A> withNewMetadataLike(ControlPlaneMachineSetTemplateObjectMeta item) {
    return new MetadataNested(item);
  }
  
  public SpecNested<A> withNewSpec() {
    return new SpecNested(null);
  }
  
  public SpecNested<A> withNewSpecLike(MachineSpec item) {
    return new SpecNested(item);
  }
  
  public A withSpec(MachineSpec spec) {
    this._visitables.remove("spec");
    if (spec != null) {
        this.spec = new MachineSpecBuilder(spec);
        this._visitables.get("spec").add(this.spec);
    } else {
        this.spec = null;
        this._visitables.get("spec").remove(this.spec);
    }
    return (A) this;
  }
  public class FailureDomainsNested<N> extends FailureDomainsFluent<FailureDomainsNested<N>> implements Nested<N>{
  
    FailureDomainsBuilder builder;
  
    FailureDomainsNested(FailureDomains item) {
      this.builder = new FailureDomainsBuilder(this, item);
    }
  
    public N and() {
      return (N) OpenShiftMachineV1Beta1MachineTemplateFluent.this.withFailureDomains(builder.build());
    }
    
    public N endFailureDomains() {
      return and();
    }
    
  }
  public class MetadataNested<N> extends ControlPlaneMachineSetTemplateObjectMetaFluent<MetadataNested<N>> implements Nested<N>{
  
    ControlPlaneMachineSetTemplateObjectMetaBuilder builder;
  
    MetadataNested(ControlPlaneMachineSetTemplateObjectMeta item) {
      this.builder = new ControlPlaneMachineSetTemplateObjectMetaBuilder(this, item);
    }
  
    public N and() {
      return (N) OpenShiftMachineV1Beta1MachineTemplateFluent.this.withMetadata(builder.build());
    }
    
    public N endMetadata() {
      return and();
    }
    
  }
  public class SpecNested<N> extends MachineSpecFluent<SpecNested<N>> implements Nested<N>{
  
    MachineSpecBuilder builder;
  
    SpecNested(MachineSpec item) {
      this.builder = new MachineSpecBuilder(this, item);
    }
  
    public N and() {
      return (N) OpenShiftMachineV1Beta1MachineTemplateFluent.this.withSpec(builder.build());
    }
    
    public N endSpec() {
      return and();
    }
    
  }
}