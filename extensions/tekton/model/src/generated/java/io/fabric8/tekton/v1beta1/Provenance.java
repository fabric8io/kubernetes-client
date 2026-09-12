
package io.fabric8.tekton.v1beta1;

import java.util.LinkedHashMap;
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
import io.fabric8.tekton.pipeline.pkg.apis.config.FeatureFlags;
import io.sundr.builder.annotations.Buildable;
import io.sundr.builder.annotations.BuildableReference;

/**
 * Provenance contains metadata about resources used in the TaskRun/PipelineRun such as the source from where a remote build definition was fetched. This field aims to carry minimum amoumt of metadata in &#42;Run status so that Tekton Chains can capture them in the provenance.
 */
@JsonDeserialize(using = com.fasterxml.jackson.databind.JsonDeserializer.None.class)
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "configSource",
    "featureFlags",
    "refSource"
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
public class Provenance implements Editable<ProvenanceBuilder>, KubernetesResource
{

    @JsonProperty("configSource")
    private ConfigSource configSource;
    @JsonProperty("featureFlags")
    private FeatureFlags featureFlags;
    @JsonProperty("refSource")
    private RefSource refSource;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new LinkedHashMap<String, Object>();

    /**
     * No args constructor for use in serialization
     */
    public Provenance() {
    }

    public Provenance(ConfigSource configSource, FeatureFlags featureFlags, RefSource refSource) {
        super();
        this.configSource = configSource;
        this.featureFlags = featureFlags;
        this.refSource = refSource;
    }

    /**
     * Provenance contains metadata about resources used in the TaskRun/PipelineRun such as the source from where a remote build definition was fetched. This field aims to carry minimum amoumt of metadata in &#42;Run status so that Tekton Chains can capture them in the provenance.
     */
    @JsonProperty("configSource")
    public ConfigSource getConfigSource() {
        return configSource;
    }

    /**
     * Provenance contains metadata about resources used in the TaskRun/PipelineRun such as the source from where a remote build definition was fetched. This field aims to carry minimum amoumt of metadata in &#42;Run status so that Tekton Chains can capture them in the provenance.
     */
    @JsonProperty("configSource")
    public void setConfigSource(ConfigSource configSource) {
        this.configSource = configSource;
    }

    /**
     * Provenance contains metadata about resources used in the TaskRun/PipelineRun such as the source from where a remote build definition was fetched. This field aims to carry minimum amoumt of metadata in &#42;Run status so that Tekton Chains can capture them in the provenance.
     */
    @JsonProperty("featureFlags")
    public FeatureFlags getFeatureFlags() {
        return featureFlags;
    }

    /**
     * Provenance contains metadata about resources used in the TaskRun/PipelineRun such as the source from where a remote build definition was fetched. This field aims to carry minimum amoumt of metadata in &#42;Run status so that Tekton Chains can capture them in the provenance.
     */
    @JsonProperty("featureFlags")
    public void setFeatureFlags(FeatureFlags featureFlags) {
        this.featureFlags = featureFlags;
    }

    /**
     * Provenance contains metadata about resources used in the TaskRun/PipelineRun such as the source from where a remote build definition was fetched. This field aims to carry minimum amoumt of metadata in &#42;Run status so that Tekton Chains can capture them in the provenance.
     */
    @JsonProperty("refSource")
    public RefSource getRefSource() {
        return refSource;
    }

    /**
     * Provenance contains metadata about resources used in the TaskRun/PipelineRun such as the source from where a remote build definition was fetched. This field aims to carry minimum amoumt of metadata in &#42;Run status so that Tekton Chains can capture them in the provenance.
     */
    @JsonProperty("refSource")
    public void setRefSource(RefSource refSource) {
        this.refSource = refSource;
    }

    @JsonIgnore
    public ProvenanceBuilder edit() {
        return new ProvenanceBuilder(this);
    }

    @JsonIgnore
    public ProvenanceBuilder toBuilder() {
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
        if (!(o instanceof Provenance)) {
            return false;
        }
        Provenance other = (Provenance) o;
        if (!other.canEqual(this)) {
            return false;
        }
        Object this$configSource = this.getConfigSource();
        Object other$configSource = other.getConfigSource();
        if (this$configSource == null ? other$configSource != null : !this$configSource.equals(other$configSource)) {
            return false;
        }
        Object this$featureFlags = this.getFeatureFlags();
        Object other$featureFlags = other.getFeatureFlags();
        if (this$featureFlags == null ? other$featureFlags != null : !this$featureFlags.equals(other$featureFlags)) {
            return false;
        }
        Object this$refSource = this.getRefSource();
        Object other$refSource = other.getRefSource();
        if (this$refSource == null ? other$refSource != null : !this$refSource.equals(other$refSource)) {
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
        return other instanceof Provenance;
    }

    @Override
    public int hashCode() {
        final int prime = 59;
        int result = 1;
        Object $configSource = this.getConfigSource();
        result = result * prime + ($configSource == null ? 43 : $configSource.hashCode());
        Object $featureFlags = this.getFeatureFlags();
        result = result * prime + ($featureFlags == null ? 43 : $featureFlags.hashCode());
        Object $refSource = this.getRefSource();
        result = result * prime + ($refSource == null ? 43 : $refSource.hashCode());
        Object $additionalProperties = this.getAdditionalProperties();
        result = result * prime + ($additionalProperties == null ? 43 : $additionalProperties.hashCode());
        return result;
    }

    @Override
    public String toString() {
        return "Provenance(" + "configSource=" + this.getConfigSource() + ", featureFlags=" + this.getFeatureFlags() + ", refSource=" + this.getRefSource() + ", additionalProperties=" + this.getAdditionalProperties() + ")";
    }

}
