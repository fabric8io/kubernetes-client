
package io.fabric8.servicecatalog.api.model;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
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
import lombok.Setter;
import lombok.ToString;
import lombok.experimental.Accessors;

@JsonDeserialize(using = com.fasterxml.jackson.databind.JsonDeserializer.None.class)
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "apiVersion",
    "kind",
    "metadata",
    "bindable",
    "bindingRetrievable",
    "defaultProvisionParameters",
    "description",
    "externalID",
    "externalMetadata",
    "externalName",
    "planUpdatable",
    "requires",
    "serviceBrokerName",
    "tags"
})
@ToString
@EqualsAndHashCode
@Setter
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
public class ServiceClassSpec implements KubernetesResource
{

    @JsonProperty("bindable")
    private Boolean bindable;
    @JsonProperty("bindingRetrievable")
    private Boolean bindingRetrievable;
    @JsonProperty("defaultProvisionParameters")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private Map<String, Object> defaultProvisionParameters = new LinkedHashMap<String, Object>();
    @JsonProperty("description")
    private java.lang.String description;
    @JsonProperty("externalID")
    private java.lang.String externalID;
    @JsonProperty("externalMetadata")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private Map<String, Object> externalMetadata = new LinkedHashMap<String, Object>();
    @JsonProperty("externalName")
    private java.lang.String externalName;
    @JsonProperty("planUpdatable")
    private Boolean planUpdatable;
    @JsonProperty("requires")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private List<java.lang.String> requires = new ArrayList<java.lang.String>();
    @JsonProperty("serviceBrokerName")
    private java.lang.String serviceBrokerName;
    @JsonProperty("tags")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private List<java.lang.String> tags = new ArrayList<java.lang.String>();
    @JsonIgnore
    private Map<java.lang.String, java.lang.Object> additionalProperties = new HashMap<java.lang.String, java.lang.Object>();

    /**
     * No args constructor for use in serialization
     * 
     */
    public ServiceClassSpec() {
    }

    /**
     * 
     * @param planUpdatable
     * @param bindable
     * @param bindingRetrievable
     * @param externalName
     * @param externalMetadata
     * @param serviceBrokerName
     * @param description
     * @param externalID
     * @param defaultProvisionParameters
     * @param requires
     * @param tags
     */
    public ServiceClassSpec(Boolean bindable, Boolean bindingRetrievable, Map<String, Object> defaultProvisionParameters, java.lang.String description, java.lang.String externalID, Map<String, Object> externalMetadata, java.lang.String externalName, Boolean planUpdatable, List<java.lang.String> requires, java.lang.String serviceBrokerName, List<java.lang.String> tags) {
        super();
        this.bindable = bindable;
        this.bindingRetrievable = bindingRetrievable;
        this.defaultProvisionParameters = defaultProvisionParameters;
        this.description = description;
        this.externalID = externalID;
        this.externalMetadata = externalMetadata;
        this.externalName = externalName;
        this.planUpdatable = planUpdatable;
        this.requires = requires;
        this.serviceBrokerName = serviceBrokerName;
        this.tags = tags;
    }

    @JsonProperty("bindable")
    public Boolean getBindable() {
        return bindable;
    }

    @JsonProperty("bindable")
    public void setBindable(Boolean bindable) {
        this.bindable = bindable;
    }

    @JsonProperty("bindingRetrievable")
    public Boolean getBindingRetrievable() {
        return bindingRetrievable;
    }

    @JsonProperty("bindingRetrievable")
    public void setBindingRetrievable(Boolean bindingRetrievable) {
        this.bindingRetrievable = bindingRetrievable;
    }

    @JsonProperty("defaultProvisionParameters")
    public Map<String, Object> getDefaultProvisionParameters() {
        return defaultProvisionParameters;
    }

    @JsonProperty("defaultProvisionParameters")
    public void setDefaultProvisionParameters(Map<String, Object> defaultProvisionParameters) {
        this.defaultProvisionParameters = defaultProvisionParameters;
    }

    @JsonProperty("description")
    public java.lang.String getDescription() {
        return description;
    }

    @JsonProperty("description")
    public void setDescription(java.lang.String description) {
        this.description = description;
    }

    @JsonProperty("externalID")
    public java.lang.String getExternalID() {
        return externalID;
    }

    @JsonProperty("externalID")
    public void setExternalID(java.lang.String externalID) {
        this.externalID = externalID;
    }

    @JsonProperty("externalMetadata")
    public Map<String, Object> getExternalMetadata() {
        return externalMetadata;
    }

    @JsonProperty("externalMetadata")
    public void setExternalMetadata(Map<String, Object> externalMetadata) {
        this.externalMetadata = externalMetadata;
    }

    @JsonProperty("externalName")
    public java.lang.String getExternalName() {
        return externalName;
    }

    @JsonProperty("externalName")
    public void setExternalName(java.lang.String externalName) {
        this.externalName = externalName;
    }

    @JsonProperty("planUpdatable")
    public Boolean getPlanUpdatable() {
        return planUpdatable;
    }

    @JsonProperty("planUpdatable")
    public void setPlanUpdatable(Boolean planUpdatable) {
        this.planUpdatable = planUpdatable;
    }

    @JsonProperty("requires")
    public List<java.lang.String> getRequires() {
        return requires;
    }

    @JsonProperty("requires")
    public void setRequires(List<java.lang.String> requires) {
        this.requires = requires;
    }

    @JsonProperty("serviceBrokerName")
    public java.lang.String getServiceBrokerName() {
        return serviceBrokerName;
    }

    @JsonProperty("serviceBrokerName")
    public void setServiceBrokerName(java.lang.String serviceBrokerName) {
        this.serviceBrokerName = serviceBrokerName;
    }

    @JsonProperty("tags")
    public List<java.lang.String> getTags() {
        return tags;
    }

    @JsonProperty("tags")
    public void setTags(List<java.lang.String> tags) {
        this.tags = tags;
    }

    @JsonAnyGetter
    public Map<java.lang.String, java.lang.Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    @JsonAnySetter
    public void setAdditionalProperty(java.lang.String name, java.lang.Object value) {
        this.additionalProperties.put(name, value);
    }

}
