
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
import lombok.EqualsAndHashCode;
import lombok.ToString;
import lombok.experimental.Accessors;

/**
 * Project Helm chart repository exposed within a namespace
 */
@JsonDeserialize(using = com.fasterxml.jackson.databind.JsonDeserializer.None.class)
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "connectionConfig",
    "description",
    "disabled",
    "name"
})
@ToString
@EqualsAndHashCode
@Accessors(prefix = {
    "_",
    ""
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
public class ProjectHelmChartRepositorySpec implements Editable<ProjectHelmChartRepositorySpecBuilder>, KubernetesResource
{

    @JsonProperty("connectionConfig")
    private ConnectionConfigNamespaceScoped connectionConfig;
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
    public ProjectHelmChartRepositorySpec() {
    }

    public ProjectHelmChartRepositorySpec(ConnectionConfigNamespaceScoped connectionConfig, String description, Boolean disabled, String name) {
        super();
        this.connectionConfig = connectionConfig;
        this.description = description;
        this.disabled = disabled;
        this.name = name;
    }

    /**
     * Project Helm chart repository exposed within a namespace
     */
    @JsonProperty("connectionConfig")
    public ConnectionConfigNamespaceScoped getConnectionConfig() {
        return connectionConfig;
    }

    /**
     * Project Helm chart repository exposed within a namespace
     */
    @JsonProperty("connectionConfig")
    public void setConnectionConfig(ConnectionConfigNamespaceScoped connectionConfig) {
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
     * If set to true, disable the repo usage in the namespace
     */
    @JsonProperty("disabled")
    public Boolean getDisabled() {
        return disabled;
    }

    /**
     * If set to true, disable the repo usage in the namespace
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
    public ProjectHelmChartRepositorySpecBuilder edit() {
        return new ProjectHelmChartRepositorySpecBuilder(this);
    }

    @JsonIgnore
    public ProjectHelmChartRepositorySpecBuilder toBuilder() {
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

}
