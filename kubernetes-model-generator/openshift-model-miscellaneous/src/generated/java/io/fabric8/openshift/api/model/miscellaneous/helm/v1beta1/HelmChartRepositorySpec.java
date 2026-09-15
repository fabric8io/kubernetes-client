
package io.fabric8.openshift.api.model.miscellaneous.helm.v1beta1;

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

/**
 * Helm chart repository exposed within the cluster
 */
@JsonDeserialize(using = com.fasterxml.jackson.databind.JsonDeserializer.None.class)
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "connectionConfig",
    "description",
    "disabled",
    "name"
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
public class HelmChartRepositorySpec implements Editable<HelmChartRepositorySpecBuilder>, KubernetesResource
{

    @JsonProperty("connectionConfig")
    private ConnectionConfig connectionConfig;
    @JsonProperty("description")
    private String description;
    @JsonProperty("disabled")
    private Boolean disabled;
    @JsonProperty("name")
    private String name;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new LinkedHashMap<String, Object>();

    /**
     * No args constructor for use in serialization
     */
    public HelmChartRepositorySpec() {
    }

    public HelmChartRepositorySpec(ConnectionConfig connectionConfig, String description, Boolean disabled, String name) {
        super();
        this.connectionConfig = connectionConfig;
        this.description = description;
        this.disabled = disabled;
        this.name = name;
    }

    /**
     * Helm chart repository exposed within the cluster
     */
    @JsonProperty("connectionConfig")
    public ConnectionConfig getConnectionConfig() {
        return connectionConfig;
    }

    /**
     * Helm chart repository exposed within the cluster
     */
    @JsonProperty("connectionConfig")
    public void setConnectionConfig(ConnectionConfig connectionConfig) {
        this.connectionConfig = connectionConfig;
    }

    /**
     * Optional human readable repository description, it can be used by UI for displaying purposes
     */
    @JsonProperty("description")
    public String getDescription() {
        return description;
    }

    /**
     * Optional human readable repository description, it can be used by UI for displaying purposes
     */
    @JsonProperty("description")
    public void setDescription(String description) {
        this.description = description;
    }

    /**
     * If set to true, disable the repo usage in the cluster/namespace
     */
    @JsonProperty("disabled")
    public Boolean getDisabled() {
        return disabled;
    }

    /**
     * If set to true, disable the repo usage in the cluster/namespace
     */
    @JsonProperty("disabled")
    public void setDisabled(Boolean disabled) {
        this.disabled = disabled;
    }

    /**
     * Optional associated human readable repository name, it can be used by UI for displaying purposes
     */
    @JsonProperty("name")
    public String getName() {
        return name;
    }

    /**
     * Optional associated human readable repository name, it can be used by UI for displaying purposes
     */
    @JsonProperty("name")
    public void setName(String name) {
        this.name = name;
    }

    @JsonIgnore
    public HelmChartRepositorySpecBuilder edit() {
        return new HelmChartRepositorySpecBuilder(this);
    }

    @JsonIgnore
    public HelmChartRepositorySpecBuilder toBuilder() {
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
        if (!(o instanceof HelmChartRepositorySpec)) {
            return false;
        }
        HelmChartRepositorySpec other = (HelmChartRepositorySpec) o;
        if (!other.canEqual(this)) {
            return false;
        }
        Object this$connectionConfig = this.getConnectionConfig();
        Object other$connectionConfig = other.getConnectionConfig();
        if (this$connectionConfig == null ? other$connectionConfig != null : !this$connectionConfig.equals(other$connectionConfig)) {
            return false;
        }
        Object this$description = this.getDescription();
        Object other$description = other.getDescription();
        if (this$description == null ? other$description != null : !this$description.equals(other$description)) {
            return false;
        }
        Object this$disabled = this.getDisabled();
        Object other$disabled = other.getDisabled();
        if (this$disabled == null ? other$disabled != null : !this$disabled.equals(other$disabled)) {
            return false;
        }
        Object this$name = this.getName();
        Object other$name = other.getName();
        if (this$name == null ? other$name != null : !this$name.equals(other$name)) {
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
        return other instanceof HelmChartRepositorySpec;
    }

    @Override
    public int hashCode() {
        final int prime = 59;
        int result = 1;
        Object $connectionConfig = this.getConnectionConfig();
        result = result * prime + ($connectionConfig == null ? 43 : $connectionConfig.hashCode());
        Object $description = this.getDescription();
        result = result * prime + ($description == null ? 43 : $description.hashCode());
        Object $disabled = this.getDisabled();
        result = result * prime + ($disabled == null ? 43 : $disabled.hashCode());
        Object $name = this.getName();
        result = result * prime + ($name == null ? 43 : $name.hashCode());
        Object $additionalProperties = this.getAdditionalProperties();
        result = result * prime + ($additionalProperties == null ? 43 : $additionalProperties.hashCode());
        return result;
    }

    @Override
    public String toString() {
        return "HelmChartRepositorySpec(" + "connectionConfig=" + this.getConnectionConfig() + ", description=" + this.getDescription() + ", disabled=" + this.getDisabled() + ", name=" + this.getName() + ", additionalProperties=" + this.getAdditionalProperties() + ")";
    }

}
