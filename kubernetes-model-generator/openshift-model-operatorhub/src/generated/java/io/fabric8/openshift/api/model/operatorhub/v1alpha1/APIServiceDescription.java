
package io.fabric8.openshift.api.model.operatorhub.v1alpha1;

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
import lombok.EqualsAndHashCode;
import lombok.ToString;
import lombok.experimental.Accessors;

/**
 * APIServiceDescription provides details to OLM about apis provided via aggregation
 */
@JsonDeserialize(using = com.fasterxml.jackson.databind.JsonDeserializer.None.class)
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "kind",
    "actionDescriptors",
    "containerPort",
    "deploymentName",
    "description",
    "displayName",
    "group",
    "name",
    "resources",
    "specDescriptors",
    "statusDescriptors",
    "version"
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
public class APIServiceDescription implements Editable<APIServiceDescriptionBuilder>, KubernetesResource
{

    @JsonProperty("actionDescriptors")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private List<ActionDescriptor> actionDescriptors = new ArrayList<>();
    @JsonProperty("containerPort")
    private Integer containerPort;
    @JsonProperty("deploymentName")
    private String deploymentName;
    @JsonProperty("description")
    private String description;
    @JsonProperty("displayName")
    private String displayName;
    @JsonProperty("group")
    private String group;
    @JsonProperty("kind")
    private String kind;
    @JsonProperty("name")
    private String name;
    @JsonProperty("resources")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private List<APIResourceReference> resources = new ArrayList<>();
    @JsonProperty("specDescriptors")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private List<SpecDescriptor> specDescriptors = new ArrayList<>();
    @JsonProperty("statusDescriptors")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private List<StatusDescriptor> statusDescriptors = new ArrayList<>();
    @JsonProperty("version")
    private String version;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new LinkedHashMap<String, Object>();

    /**
     * No args constructor for use in serialization
     */
    public APIServiceDescription() {
    }

    public APIServiceDescription(List<ActionDescriptor> actionDescriptors, Integer containerPort, String deploymentName, String description, String displayName, String group, String kind, String name, List<APIResourceReference> resources, List<SpecDescriptor> specDescriptors, List<StatusDescriptor> statusDescriptors, String version) {
        super();
        this.actionDescriptors = actionDescriptors;
        this.containerPort = containerPort;
        this.deploymentName = deploymentName;
        this.description = description;
        this.displayName = displayName;
        this.group = group;
        this.kind = kind;
        this.name = name;
        this.resources = resources;
        this.specDescriptors = specDescriptors;
        this.statusDescriptors = statusDescriptors;
        this.version = version;
    }

    /**
     * APIServiceDescription provides details to OLM about apis provided via aggregation
     */
    @JsonProperty("actionDescriptors")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    public List<ActionDescriptor> getActionDescriptors() {
        return actionDescriptors;
    }

    /**
     * APIServiceDescription provides details to OLM about apis provided via aggregation
     */
    @JsonProperty("actionDescriptors")
    public void setActionDescriptors(List<ActionDescriptor> actionDescriptors) {
        this.actionDescriptors = actionDescriptors;
    }

    /**
     * APIServiceDescription provides details to OLM about apis provided via aggregation
     */
    @JsonProperty("containerPort")
    public Integer getContainerPort() {
        return containerPort;
    }

    /**
     * APIServiceDescription provides details to OLM about apis provided via aggregation
     */
    @JsonProperty("containerPort")
    public void setContainerPort(Integer containerPort) {
        this.containerPort = containerPort;
    }

    /**
     * APIServiceDescription provides details to OLM about apis provided via aggregation
     */
    @JsonProperty("deploymentName")
    public String getDeploymentName() {
        return deploymentName;
    }

    /**
     * APIServiceDescription provides details to OLM about apis provided via aggregation
     */
    @JsonProperty("deploymentName")
    public void setDeploymentName(String deploymentName) {
        this.deploymentName = deploymentName;
    }

    /**
     * APIServiceDescription provides details to OLM about apis provided via aggregation
     */
    @JsonProperty("description")
    public String getDescription() {
        return description;
    }

    /**
     * APIServiceDescription provides details to OLM about apis provided via aggregation
     */
    @JsonProperty("description")
    public void setDescription(String description) {
        this.description = description;
    }

    /**
     * APIServiceDescription provides details to OLM about apis provided via aggregation
     */
    @JsonProperty("displayName")
    public String getDisplayName() {
        return displayName;
    }

    /**
     * APIServiceDescription provides details to OLM about apis provided via aggregation
     */
    @JsonProperty("displayName")
    public void setDisplayName(String displayName) {
        this.displayName = displayName;
    }

    /**
     * APIServiceDescription provides details to OLM about apis provided via aggregation
     */
    @JsonProperty("group")
    public String getGroup() {
        return group;
    }

    /**
     * APIServiceDescription provides details to OLM about apis provided via aggregation
     */
    @JsonProperty("group")
    public void setGroup(String group) {
        this.group = group;
    }

    /**
     * APIServiceDescription provides details to OLM about apis provided via aggregation
     */
    @JsonProperty("kind")
    public String getKind() {
        return kind;
    }

    /**
     * APIServiceDescription provides details to OLM about apis provided via aggregation
     */
    @JsonProperty("kind")
    public void setKind(String kind) {
        this.kind = kind;
    }

    /**
     * APIServiceDescription provides details to OLM about apis provided via aggregation
     */
    @JsonProperty("name")
    public String getName() {
        return name;
    }

    /**
     * APIServiceDescription provides details to OLM about apis provided via aggregation
     */
    @JsonProperty("name")
    public void setName(String name) {
        this.name = name;
    }

    /**
     * APIServiceDescription provides details to OLM about apis provided via aggregation
     */
    @JsonProperty("resources")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    public List<APIResourceReference> getResources() {
        return resources;
    }

    /**
     * APIServiceDescription provides details to OLM about apis provided via aggregation
     */
    @JsonProperty("resources")
    public void setResources(List<APIResourceReference> resources) {
        this.resources = resources;
    }

    /**
     * APIServiceDescription provides details to OLM about apis provided via aggregation
     */
    @JsonProperty("specDescriptors")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    public List<SpecDescriptor> getSpecDescriptors() {
        return specDescriptors;
    }

    /**
     * APIServiceDescription provides details to OLM about apis provided via aggregation
     */
    @JsonProperty("specDescriptors")
    public void setSpecDescriptors(List<SpecDescriptor> specDescriptors) {
        this.specDescriptors = specDescriptors;
    }

    /**
     * APIServiceDescription provides details to OLM about apis provided via aggregation
     */
    @JsonProperty("statusDescriptors")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    public List<StatusDescriptor> getStatusDescriptors() {
        return statusDescriptors;
    }

    /**
     * APIServiceDescription provides details to OLM about apis provided via aggregation
     */
    @JsonProperty("statusDescriptors")
    public void setStatusDescriptors(List<StatusDescriptor> statusDescriptors) {
        this.statusDescriptors = statusDescriptors;
    }

    /**
     * APIServiceDescription provides details to OLM about apis provided via aggregation
     */
    @JsonProperty("version")
    public String getVersion() {
        return version;
    }

    /**
     * APIServiceDescription provides details to OLM about apis provided via aggregation
     */
    @JsonProperty("version")
    public void setVersion(String version) {
        this.version = version;
    }

    @JsonIgnore
    public APIServiceDescriptionBuilder edit() {
        return new APIServiceDescriptionBuilder(this);
    }

    @JsonIgnore
    public APIServiceDescriptionBuilder toBuilder() {
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
