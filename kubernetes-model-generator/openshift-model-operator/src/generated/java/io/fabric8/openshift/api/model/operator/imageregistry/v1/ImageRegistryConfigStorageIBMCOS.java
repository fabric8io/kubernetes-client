
package io.fabric8.openshift.api.model.operator.imageregistry.v1;

import java.util.LinkedHashMap;
import java.util.Map;
import javax.annotation.Generated;
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
 * ImageRegistryConfigStorageIBMCOS holds the information to configure the registry to use IBM Cloud Object Storage for backend storage.
 */
@JsonDeserialize(using = com.fasterxml.jackson.databind.JsonDeserializer.None.class)
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "bucket",
    "location",
    "resourceGroupName",
    "resourceKeyCRN",
    "serviceInstanceCRN"
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
public class ImageRegistryConfigStorageIBMCOS implements Editable<ImageRegistryConfigStorageIBMCOSBuilder>, KubernetesResource
{

    @JsonProperty("bucket")
    private String bucket;
    @JsonProperty("location")
    private String location;
    @JsonProperty("resourceGroupName")
    private String resourceGroupName;
    @JsonProperty("resourceKeyCRN")
    private String resourceKeyCRN;
    @JsonProperty("serviceInstanceCRN")
    private String serviceInstanceCRN;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new LinkedHashMap<String, Object>();

    /**
     * No args constructor for use in serialization
     */
    public ImageRegistryConfigStorageIBMCOS() {
    }

    public ImageRegistryConfigStorageIBMCOS(String bucket, String location, String resourceGroupName, String resourceKeyCRN, String serviceInstanceCRN) {
        super();
        this.bucket = bucket;
        this.location = location;
        this.resourceGroupName = resourceGroupName;
        this.resourceKeyCRN = resourceKeyCRN;
        this.serviceInstanceCRN = serviceInstanceCRN;
    }

    /**
     * bucket is the bucket name in which you want to store the registry's data. Optional, will be generated if not provided.
     */
    @JsonProperty("bucket")
    public String getBucket() {
        return bucket;
    }

    /**
     * bucket is the bucket name in which you want to store the registry's data. Optional, will be generated if not provided.
     */
    @JsonProperty("bucket")
    public void setBucket(String bucket) {
        this.bucket = bucket;
    }

    /**
     * location is the IBM Cloud location in which your bucket exists. Optional, will be set based on the installed IBM Cloud location.
     */
    @JsonProperty("location")
    public String getLocation() {
        return location;
    }

    /**
     * location is the IBM Cloud location in which your bucket exists. Optional, will be set based on the installed IBM Cloud location.
     */
    @JsonProperty("location")
    public void setLocation(String location) {
        this.location = location;
    }

    /**
     * resourceGroupName is the name of the IBM Cloud resource group that this bucket and its service instance is associated with. Optional, will be set based on the installed IBM Cloud resource group.
     */
    @JsonProperty("resourceGroupName")
    public String getResourceGroupName() {
        return resourceGroupName;
    }

    /**
     * resourceGroupName is the name of the IBM Cloud resource group that this bucket and its service instance is associated with. Optional, will be set based on the installed IBM Cloud resource group.
     */
    @JsonProperty("resourceGroupName")
    public void setResourceGroupName(String resourceGroupName) {
        this.resourceGroupName = resourceGroupName;
    }

    /**
     * resourceKeyCRN is the CRN of the IBM Cloud resource key that is created for the service instance. Commonly referred as a service credential and must contain HMAC type credentials. Optional, will be computed if not provided.
     */
    @JsonProperty("resourceKeyCRN")
    public String getResourceKeyCRN() {
        return resourceKeyCRN;
    }

    /**
     * resourceKeyCRN is the CRN of the IBM Cloud resource key that is created for the service instance. Commonly referred as a service credential and must contain HMAC type credentials. Optional, will be computed if not provided.
     */
    @JsonProperty("resourceKeyCRN")
    public void setResourceKeyCRN(String resourceKeyCRN) {
        this.resourceKeyCRN = resourceKeyCRN;
    }

    /**
     * serviceInstanceCRN is the CRN of the IBM Cloud Object Storage service instance that this bucket is associated with. Optional, will be computed if not provided.
     */
    @JsonProperty("serviceInstanceCRN")
    public String getServiceInstanceCRN() {
        return serviceInstanceCRN;
    }

    /**
     * serviceInstanceCRN is the CRN of the IBM Cloud Object Storage service instance that this bucket is associated with. Optional, will be computed if not provided.
     */
    @JsonProperty("serviceInstanceCRN")
    public void setServiceInstanceCRN(String serviceInstanceCRN) {
        this.serviceInstanceCRN = serviceInstanceCRN;
    }

    @JsonIgnore
    public ImageRegistryConfigStorageIBMCOSBuilder edit() {
        return new ImageRegistryConfigStorageIBMCOSBuilder(this);
    }

    @JsonIgnore
    public ImageRegistryConfigStorageIBMCOSBuilder toBuilder() {
        return edit();
    }

    @JsonAnyGetter
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
