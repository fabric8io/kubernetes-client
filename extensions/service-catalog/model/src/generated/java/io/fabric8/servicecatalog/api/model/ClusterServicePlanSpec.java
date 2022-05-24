
package io.fabric8.servicecatalog.api.model;

import java.util.HashMap;
import java.util.LinkedHashMap;
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
    "clusterServiceBrokerName",
    "clusterServiceClassRef",
    "defaultProvisionParameters",
    "description",
    "externalID",
    "externalMetadata",
    "externalName",
    "free",
    "instanceCreateParameterSchema",
    "instanceUpdateParameterSchema",
    "serviceBindingCreateParameterSchema",
    "serviceBindingCreateResponseSchema"
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
public class ClusterServicePlanSpec implements KubernetesResource
{

    @JsonProperty("bindable")
    private Boolean bindable;
    @JsonProperty("clusterServiceBrokerName")
    private java.lang.String clusterServiceBrokerName;
    @JsonProperty("clusterServiceClassRef")
    private ClusterObjectReference clusterServiceClassRef;
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
    @JsonProperty("free")
    private java.lang.Boolean free;
    @JsonProperty("instanceCreateParameterSchema")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private Map<String, Object> instanceCreateParameterSchema = new LinkedHashMap<String, Object>();
    @JsonProperty("instanceUpdateParameterSchema")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private Map<String, Object> instanceUpdateParameterSchema = new LinkedHashMap<String, Object>();
    @JsonProperty("serviceBindingCreateParameterSchema")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private Map<String, Object> serviceBindingCreateParameterSchema = new LinkedHashMap<String, Object>();
    @JsonProperty("serviceBindingCreateResponseSchema")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private Map<String, Object> serviceBindingCreateResponseSchema = new LinkedHashMap<String, Object>();
    @JsonIgnore
    private Map<java.lang.String, java.lang.Object> additionalProperties = new HashMap<java.lang.String, java.lang.Object>();

    /**
     * No args constructor for use in serialization
     * 
     */
    public ClusterServicePlanSpec() {
    }

    /**
     * 
     * @param externalMetadata
     * @param description
     * @param externalID
     * @param serviceBindingCreateResponseSchema
     * @param clusterServiceClassRef
     * @param bindable
     * @param externalName
     * @param clusterServiceBrokerName
     * @param instanceUpdateParameterSchema
     * @param free
     * @param defaultProvisionParameters
     * @param instanceCreateParameterSchema
     * @param serviceBindingCreateParameterSchema
     */
    public ClusterServicePlanSpec(Boolean bindable, java.lang.String clusterServiceBrokerName, ClusterObjectReference clusterServiceClassRef, Map<String, Object> defaultProvisionParameters, java.lang.String description, java.lang.String externalID, Map<String, Object> externalMetadata, java.lang.String externalName, java.lang.Boolean free, Map<String, Object> instanceCreateParameterSchema, Map<String, Object> instanceUpdateParameterSchema, Map<String, Object> serviceBindingCreateParameterSchema, Map<String, Object> serviceBindingCreateResponseSchema) {
        super();
        this.bindable = bindable;
        this.clusterServiceBrokerName = clusterServiceBrokerName;
        this.clusterServiceClassRef = clusterServiceClassRef;
        this.defaultProvisionParameters = defaultProvisionParameters;
        this.description = description;
        this.externalID = externalID;
        this.externalMetadata = externalMetadata;
        this.externalName = externalName;
        this.free = free;
        this.instanceCreateParameterSchema = instanceCreateParameterSchema;
        this.instanceUpdateParameterSchema = instanceUpdateParameterSchema;
        this.serviceBindingCreateParameterSchema = serviceBindingCreateParameterSchema;
        this.serviceBindingCreateResponseSchema = serviceBindingCreateResponseSchema;
    }

    @JsonProperty("bindable")
    public Boolean getBindable() {
        return bindable;
    }

    @JsonProperty("bindable")
    public void setBindable(Boolean bindable) {
        this.bindable = bindable;
    }

    @JsonProperty("clusterServiceBrokerName")
    public java.lang.String getClusterServiceBrokerName() {
        return clusterServiceBrokerName;
    }

    @JsonProperty("clusterServiceBrokerName")
    public void setClusterServiceBrokerName(java.lang.String clusterServiceBrokerName) {
        this.clusterServiceBrokerName = clusterServiceBrokerName;
    }

    @JsonProperty("clusterServiceClassRef")
    public ClusterObjectReference getClusterServiceClassRef() {
        return clusterServiceClassRef;
    }

    @JsonProperty("clusterServiceClassRef")
    public void setClusterServiceClassRef(ClusterObjectReference clusterServiceClassRef) {
        this.clusterServiceClassRef = clusterServiceClassRef;
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

    @JsonProperty("free")
    public java.lang.Boolean getFree() {
        return free;
    }

    @JsonProperty("free")
    public void setFree(java.lang.Boolean free) {
        this.free = free;
    }

    @JsonProperty("instanceCreateParameterSchema")
    public Map<String, Object> getInstanceCreateParameterSchema() {
        return instanceCreateParameterSchema;
    }

    @JsonProperty("instanceCreateParameterSchema")
    public void setInstanceCreateParameterSchema(Map<String, Object> instanceCreateParameterSchema) {
        this.instanceCreateParameterSchema = instanceCreateParameterSchema;
    }

    @JsonProperty("instanceUpdateParameterSchema")
    public Map<String, Object> getInstanceUpdateParameterSchema() {
        return instanceUpdateParameterSchema;
    }

    @JsonProperty("instanceUpdateParameterSchema")
    public void setInstanceUpdateParameterSchema(Map<String, Object> instanceUpdateParameterSchema) {
        this.instanceUpdateParameterSchema = instanceUpdateParameterSchema;
    }

    @JsonProperty("serviceBindingCreateParameterSchema")
    public Map<String, Object> getServiceBindingCreateParameterSchema() {
        return serviceBindingCreateParameterSchema;
    }

    @JsonProperty("serviceBindingCreateParameterSchema")
    public void setServiceBindingCreateParameterSchema(Map<String, Object> serviceBindingCreateParameterSchema) {
        this.serviceBindingCreateParameterSchema = serviceBindingCreateParameterSchema;
    }

    @JsonProperty("serviceBindingCreateResponseSchema")
    public Map<String, Object> getServiceBindingCreateResponseSchema() {
        return serviceBindingCreateResponseSchema;
    }

    @JsonProperty("serviceBindingCreateResponseSchema")
    public void setServiceBindingCreateResponseSchema(Map<String, Object> serviceBindingCreateResponseSchema) {
        this.serviceBindingCreateResponseSchema = serviceBindingCreateResponseSchema;
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
