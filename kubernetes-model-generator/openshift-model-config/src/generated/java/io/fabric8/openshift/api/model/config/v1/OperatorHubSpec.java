
package io.fabric8.openshift.api.model.config.v1;

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
import io.fabric8.kubernetes.api.model.PersistentVolumeClaim;
import io.fabric8.kubernetes.api.model.PodTemplateSpec;
import io.fabric8.kubernetes.api.model.ResourceRequirements;
import io.fabric8.kubernetes.api.model.Volume;
import io.fabric8.kubernetes.api.model.VolumeMount;
import io.sundr.builder.annotations.Buildable;
import io.sundr.builder.annotations.BuildableReference;

/**
 * OperatorHubSpec defines the desired state of OperatorHub
 */
@JsonDeserialize(using = com.fasterxml.jackson.databind.JsonDeserializer.None.class)
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "disableAllDefaultSources",
    "sources"
})
@Buildable(editableEnabled = false, validationEnabled = false, generateBuilderPackage = false, lazyCollectionInitEnabled = false, builderPackage = "io.fabric8.kubernetes.api.builder", refs = {
    @BuildableReference(ObjectMeta.class),
    @BuildableReference(LabelSelector.class),
    @BuildableReference(Container.class),
    @BuildableReference(PodTemplateSpec.class),
    @BuildableReference(ResourceRequirements.class),
    @BuildableReference(IntOrString.class),
    @BuildableReference(io.fabric8.kubernetes.api.model.ObjectReference.class),
    @BuildableReference(LocalObjectReference.class),
    @BuildableReference(PersistentVolumeClaim.class),
    @BuildableReference(EnvVar.class),
    @BuildableReference(ContainerPort.class),
    @BuildableReference(Volume.class),
    @BuildableReference(VolumeMount.class)
})
@Generated("io.fabric8.kubernetes.schema.generator.model.ModelGenerator")
public class OperatorHubSpec implements Editable<OperatorHubSpecBuilder>, KubernetesResource
{

    @JsonProperty("disableAllDefaultSources")
    private Boolean disableAllDefaultSources;
    @JsonProperty("sources")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private List<HubSource> sources = new ArrayList<>();
    @JsonIgnore
    private Map<String, Object> additionalProperties = new LinkedHashMap<String, Object>();

    /**
     * No args constructor for use in serialization
     */
    public OperatorHubSpec() {
    }

    public OperatorHubSpec(Boolean disableAllDefaultSources, List<HubSource> sources) {
        super();
        this.disableAllDefaultSources = disableAllDefaultSources;
        this.sources = sources;
    }

    /**
     * disableAllDefaultSources allows you to disable all the default hub sources. If this is true, a specific entry in sources can be used to enable a default source. If this is false, a specific entry in sources can be used to disable or enable a default source.
     */
    @JsonProperty("disableAllDefaultSources")
    public Boolean getDisableAllDefaultSources() {
        return disableAllDefaultSources;
    }

    /**
     * disableAllDefaultSources allows you to disable all the default hub sources. If this is true, a specific entry in sources can be used to enable a default source. If this is false, a specific entry in sources can be used to disable or enable a default source.
     */
    @JsonProperty("disableAllDefaultSources")
    public void setDisableAllDefaultSources(Boolean disableAllDefaultSources) {
        this.disableAllDefaultSources = disableAllDefaultSources;
    }

    /**
     * sources is the list of default hub sources and their configuration. If the list is empty, it implies that the default hub sources are enabled on the cluster unless disableAllDefaultSources is true. If disableAllDefaultSources is true and sources is not empty, the configuration present in sources will take precedence. The list of default hub sources and their current state will always be reflected in the status block.
     */
    @JsonProperty("sources")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    public List<HubSource> getSources() {
        return sources;
    }

    /**
     * sources is the list of default hub sources and their configuration. If the list is empty, it implies that the default hub sources are enabled on the cluster unless disableAllDefaultSources is true. If disableAllDefaultSources is true and sources is not empty, the configuration present in sources will take precedence. The list of default hub sources and their current state will always be reflected in the status block.
     */
    @JsonProperty("sources")
    public void setSources(List<HubSource> sources) {
        this.sources = sources;
    }

    @JsonIgnore
    public OperatorHubSpecBuilder edit() {
        return new OperatorHubSpecBuilder(this);
    }

    @JsonIgnore
    public OperatorHubSpecBuilder toBuilder() {
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
        if (!(o instanceof OperatorHubSpec)) {
            return false;
        }
        OperatorHubSpec other = (OperatorHubSpec) o;
        if (!other.canEqual(this)) {
            return false;
        }
        Object this$disableAllDefaultSources = this.getDisableAllDefaultSources();
        Object other$disableAllDefaultSources = other.getDisableAllDefaultSources();
        if (this$disableAllDefaultSources == null ? other$disableAllDefaultSources != null : !this$disableAllDefaultSources.equals(other$disableAllDefaultSources)) {
            return false;
        }
        Object this$sources = this.getSources();
        Object other$sources = other.getSources();
        if (this$sources == null ? other$sources != null : !this$sources.equals(other$sources)) {
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
        return other instanceof OperatorHubSpec;
    }

    @Override
    public int hashCode() {
        final int prime = 59;
        int result = 1;
        Object $disableAllDefaultSources = this.getDisableAllDefaultSources();
        result = result * prime + ($disableAllDefaultSources == null ? 43 : $disableAllDefaultSources.hashCode());
        Object $sources = this.getSources();
        result = result * prime + ($sources == null ? 43 : $sources.hashCode());
        Object $additionalProperties = this.getAdditionalProperties();
        result = result * prime + ($additionalProperties == null ? 43 : $additionalProperties.hashCode());
        return result;
    }

    @Override
    public String toString() {
        return "OperatorHubSpec(" + "disableAllDefaultSources=" + this.getDisableAllDefaultSources() + ", sources=" + this.getSources() + ", additionalProperties=" + this.getAdditionalProperties() + ")";
    }

}
