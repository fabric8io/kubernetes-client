
package io.fabric8.istio.api.api.telemetry.v1alpha1;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import javax.annotation.processing.Generated;
import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import io.fabric8.kubernetes.api.builder.Editable;
import io.fabric8.kubernetes.api.model.Container;
import io.fabric8.kubernetes.api.model.ContainerPort;
import io.fabric8.kubernetes.api.model.EnvVar;
import io.fabric8.kubernetes.api.model.IntOrString;
import io.fabric8.kubernetes.api.model.KubernetesResource;
import io.fabric8.kubernetes.api.model.LabelSelector;
import io.fabric8.kubernetes.api.model.LocalObjectReference;
import io.fabric8.kubernetes.api.model.ObjectMeta;
import io.fabric8.kubernetes.api.model.ObjectReference;
import io.fabric8.kubernetes.api.model.PersistentVolumeClaim;
import io.fabric8.kubernetes.api.model.PodTemplateSpec;
import io.fabric8.kubernetes.api.model.ResourceRequirements;
import io.fabric8.kubernetes.api.model.Volume;
import io.fabric8.kubernetes.api.model.VolumeMount;
import io.sundr.builder.annotations.Buildable;
import io.sundr.builder.annotations.BuildableReference;

/**
 * Access logging defines the workload-level overrides for access log generation. It can be used to select provider or enable/disable access log generation for a workload.
 */
@JsonDeserialize(using = com.fasterxml.jackson.databind.JsonDeserializer.None.class)
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "disabled",
    "filter",
    "match",
    "providers"
})
@Buildable(editableEnabled = false, validationEnabled = false, generateBuilderPackage = false, lazyCollectionInitEnabled = false, builderPackage = "io.fabric8.kubernetes.api.builder", refs = {
    @BuildableReference(ObjectMeta.class),
    @BuildableReference(LabelSelector.class),
    @BuildableReference(Container.class),
    @BuildableReference(PodTemplateSpec.class),
    @BuildableReference(ResourceRequirements.class),
    @BuildableReference(IntOrString.class),
    @BuildableReference(ObjectReference.class),
    @BuildableReference(LocalObjectReference.class),
    @BuildableReference(PersistentVolumeClaim.class),
    @BuildableReference(EnvVar.class),
    @BuildableReference(ContainerPort.class),
    @BuildableReference(Volume.class),
    @BuildableReference(VolumeMount.class)
})
@Generated("io.fabric8.kubernetes.schema.generator.model.ModelGenerator")
public class AccessLogging implements Editable<AccessLoggingBuilder>, KubernetesResource
{

    @JsonProperty("disabled")
    private Boolean disabled;
    @JsonProperty("filter")
    private AccessLoggingFilter filter;
    @JsonProperty("match")
    private AccessLoggingLogSelector match;
    @JsonProperty("providers")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private List<ProviderRef> providers = new ArrayList<>();
    @JsonIgnore
    private Map<String, Object> additionalProperties = new LinkedHashMap<String, Object>();

    /**
     * No args constructor for use in serialization
     */
    public AccessLogging() {
    }

    public AccessLogging(Boolean disabled, AccessLoggingFilter filter, AccessLoggingLogSelector match, List<ProviderRef> providers) {
        super();
        this.disabled = disabled;
        this.filter = filter;
        this.match = match;
        this.providers = providers;
    }

    /**
     * Access logging defines the workload-level overrides for access log generation. It can be used to select provider or enable/disable access log generation for a workload.
     */
    @JsonProperty("disabled")
    public Boolean getDisabled() {
        return disabled;
    }

    /**
     * Access logging defines the workload-level overrides for access log generation. It can be used to select provider or enable/disable access log generation for a workload.
     */
    @JsonProperty("disabled")
    public void setDisabled(Boolean disabled) {
        this.disabled = disabled;
    }

    /**
     * Access logging defines the workload-level overrides for access log generation. It can be used to select provider or enable/disable access log generation for a workload.
     */
    @JsonProperty("filter")
    public AccessLoggingFilter getFilter() {
        return filter;
    }

    /**
     * Access logging defines the workload-level overrides for access log generation. It can be used to select provider or enable/disable access log generation for a workload.
     */
    @JsonProperty("filter")
    public void setFilter(AccessLoggingFilter filter) {
        this.filter = filter;
    }

    /**
     * Access logging defines the workload-level overrides for access log generation. It can be used to select provider or enable/disable access log generation for a workload.
     */
    @JsonProperty("match")
    public AccessLoggingLogSelector getMatch() {
        return match;
    }

    /**
     * Access logging defines the workload-level overrides for access log generation. It can be used to select provider or enable/disable access log generation for a workload.
     */
    @JsonProperty("match")
    public void setMatch(AccessLoggingLogSelector match) {
        this.match = match;
    }

    /**
     * Optional. Name of providers to which this configuration should apply. If a provider is not specified, the [default logging provider](https://istio.io/docs/reference/config/istio.mesh.v1alpha1/#MeshConfig-DefaultProviders) will be used.
     */
    @JsonProperty("providers")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    public List<ProviderRef> getProviders() {
        return providers;
    }

    /**
     * Optional. Name of providers to which this configuration should apply. If a provider is not specified, the [default logging provider](https://istio.io/docs/reference/config/istio.mesh.v1alpha1/#MeshConfig-DefaultProviders) will be used.
     */
    @JsonProperty("providers")
    public void setProviders(List<ProviderRef> providers) {
        this.providers = providers;
    }

    @JsonIgnore
    public AccessLoggingBuilder edit() {
        return new AccessLoggingBuilder(this);
    }

    @JsonIgnore
    public AccessLoggingBuilder toBuilder() {
        return edit();
    }

    @JsonAnyGetter
    @JsonIgnore
    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    @JsonAnySetter
    public void setAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
    }

    public void setAdditionalProperties(Map<String, Object> additionalProperties) {
        this.additionalProperties = additionalProperties;
    }
    @Override
    public boolean equals(Object o) {
        if (o == this) {
            return true;
        }
        if (!(o instanceof AccessLogging)) {
            return false;
        }
        AccessLogging other = (AccessLogging) o;
        if (!other.canEqual(this)) {
            return false;
        }
        Object this$disabled = this.getDisabled();
        Object other$disabled = other.getDisabled();
        if (this$disabled == null ? other$disabled != null : !this$disabled.equals(other$disabled)) {
            return false;
        }
        Object this$filter = this.getFilter();
        Object other$filter = other.getFilter();
        if (this$filter == null ? other$filter != null : !this$filter.equals(other$filter)) {
            return false;
        }
        Object this$match = this.getMatch();
        Object other$match = other.getMatch();
        if (this$match == null ? other$match != null : !this$match.equals(other$match)) {
            return false;
        }
        Object this$providers = this.getProviders();
        Object other$providers = other.getProviders();
        if (this$providers == null ? other$providers != null : !this$providers.equals(other$providers)) {
            return false;
        }
        Object this$additionalProperties = this.getAdditionalProperties();
        Object other$additionalProperties = other.getAdditionalProperties();
        if (this$additionalProperties == null ? other$additionalProperties != null : !this$additionalProperties.equals(other$additionalProperties)) {
            return false;
        }
        return true;
    }

    protected boolean canEqual(Object other) {
        return other instanceof AccessLogging;
    }

    @Override
    public int hashCode() {
        final int prime = 59;
        int result = 1;
        Object $disabled = this.getDisabled();
        result = result * prime + ($disabled == null ? 43 : $disabled.hashCode());
        Object $filter = this.getFilter();
        result = result * prime + ($filter == null ? 43 : $filter.hashCode());
        Object $match = this.getMatch();
        result = result * prime + ($match == null ? 43 : $match.hashCode());
        Object $providers = this.getProviders();
        result = result * prime + ($providers == null ? 43 : $providers.hashCode());
        Object $additionalProperties = this.getAdditionalProperties();
        result = result * prime + ($additionalProperties == null ? 43 : $additionalProperties.hashCode());
        return result;
    }

    @Override
    public String toString() {
        return "AccessLogging(" + "disabled=" + this.getDisabled() + ", filter=" + this.getFilter() + ", match=" + this.getMatch() + ", providers=" + this.getProviders() + ", additionalProperties=" + this.getAdditionalProperties() + ")";
    }

}
