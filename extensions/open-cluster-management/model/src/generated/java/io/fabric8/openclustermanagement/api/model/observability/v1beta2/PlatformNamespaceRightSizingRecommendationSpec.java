
package io.fabric8.openclustermanagement.api.model.observability.v1beta2;

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
import io.sundr.builder.annotations.Buildable;
import io.sundr.builder.annotations.BuildableReference;

@JsonDeserialize(using = com.fasterxml.jackson.databind.JsonDeserializer.None.class)
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "enabled",
    "namespaceBinding"
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
public class PlatformNamespaceRightSizingRecommendationSpec implements Editable<PlatformNamespaceRightSizingRecommendationSpecBuilder>, KubernetesResource
{

    @JsonProperty("enabled")
    private Boolean enabled;
    @JsonProperty("namespaceBinding")
    private String namespaceBinding;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new LinkedHashMap<String, Object>();

    /**
     * No args constructor for use in serialization
     */
    public PlatformNamespaceRightSizingRecommendationSpec() {
    }

    public PlatformNamespaceRightSizingRecommendationSpec(Boolean enabled, String namespaceBinding) {
        super();
        this.enabled = enabled;
        this.namespaceBinding = namespaceBinding;
    }

    /**
     * Enabled defines a flag to enable/disable the namespace right-sizing feature for the Analytics.
     */
    @JsonProperty("enabled")
    public Boolean getEnabled() {
        return enabled;
    }

    /**
     * Enabled defines a flag to enable/disable the namespace right-sizing feature for the Analytics.
     */
    @JsonProperty("enabled")
    public void setEnabled(Boolean enabled) {
        this.enabled = enabled;
    }

    /**
     * NamespaceBinding defines the namespace where all the required resources are created. The default namespace is `open-cluster-management-global-set
     */
    @JsonProperty("namespaceBinding")
    public String getNamespaceBinding() {
        return namespaceBinding;
    }

    /**
     * NamespaceBinding defines the namespace where all the required resources are created. The default namespace is `open-cluster-management-global-set
     */
    @JsonProperty("namespaceBinding")
    public void setNamespaceBinding(String namespaceBinding) {
        this.namespaceBinding = namespaceBinding;
    }

    @JsonIgnore
    public PlatformNamespaceRightSizingRecommendationSpecBuilder edit() {
        return new PlatformNamespaceRightSizingRecommendationSpecBuilder(this);
    }

    @JsonIgnore
    public PlatformNamespaceRightSizingRecommendationSpecBuilder toBuilder() {
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
        if (!(o instanceof PlatformNamespaceRightSizingRecommendationSpec)) {
            return false;
        }
        PlatformNamespaceRightSizingRecommendationSpec other = (PlatformNamespaceRightSizingRecommendationSpec) o;
        if (!other.canEqual(this)) {
            return false;
        }
        Object this$enabled = this.getEnabled();
        Object other$enabled = other.getEnabled();
        if (this$enabled == null ? other$enabled != null : !this$enabled.equals(other$enabled)) {
            return false;
        }
        Object this$namespaceBinding = this.getNamespaceBinding();
        Object other$namespaceBinding = other.getNamespaceBinding();
        if (this$namespaceBinding == null ? other$namespaceBinding != null : !this$namespaceBinding.equals(other$namespaceBinding)) {
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
        return other instanceof PlatformNamespaceRightSizingRecommendationSpec;
    }

    @Override
    public int hashCode() {
        final int prime = 59;
        int result = 1;
        Object $enabled = this.getEnabled();
        result = result * prime + ($enabled == null ? 43 : $enabled.hashCode());
        Object $namespaceBinding = this.getNamespaceBinding();
        result = result * prime + ($namespaceBinding == null ? 43 : $namespaceBinding.hashCode());
        Object $additionalProperties = this.getAdditionalProperties();
        result = result * prime + ($additionalProperties == null ? 43 : $additionalProperties.hashCode());
        return result;
    }

    @Override
    public String toString() {
        return "PlatformNamespaceRightSizingRecommendationSpec(" + "enabled=" + this.getEnabled() + ", namespaceBinding=" + this.getNamespaceBinding() + ", additionalProperties=" + this.getAdditionalProperties() + ")";
    }

}
