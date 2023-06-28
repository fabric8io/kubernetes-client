
package io.fabric8.openshift.api.model.miscellaneous.imageregistry.operator.v1;

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
import io.fabric8.kubernetes.api.model.Container;
import io.fabric8.kubernetes.api.model.IntOrString;
import io.fabric8.kubernetes.api.model.KubernetesResource;
import io.fabric8.kubernetes.api.model.LabelSelector;
import io.fabric8.kubernetes.api.model.LocalObjectReference;
import io.fabric8.kubernetes.api.model.ObjectMeta;
import io.fabric8.kubernetes.api.model.ObjectReference;
import io.fabric8.kubernetes.api.model.PersistentVolumeClaim;
import io.fabric8.kubernetes.api.model.PodTemplateSpec;
import io.fabric8.kubernetes.api.model.ResourceRequirements;
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
    "bucket",
    "location",
    "resourceGroupName",
    "resourceKeyCRN",
    "serviceInstanceCRN"
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
    @BuildableReference(PersistentVolumeClaim.class)
})
@Generated("jsonschema2pojo")
public class ImageRegistryConfigStorageIBMCOS implements KubernetesResource
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
     * 
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

    @JsonProperty("bucket")
    public String getBucket() {
        return bucket;
    }

    @JsonProperty("bucket")
    public void setBucket(String bucket) {
        this.bucket = bucket;
    }

    @JsonProperty("location")
    public String getLocation() {
        return location;
    }

    @JsonProperty("location")
    public void setLocation(String location) {
        this.location = location;
    }

    @JsonProperty("resourceGroupName")
    public String getResourceGroupName() {
        return resourceGroupName;
    }

    @JsonProperty("resourceGroupName")
    public void setResourceGroupName(String resourceGroupName) {
        this.resourceGroupName = resourceGroupName;
    }

    @JsonProperty("resourceKeyCRN")
    public String getResourceKeyCRN() {
        return resourceKeyCRN;
    }

    @JsonProperty("resourceKeyCRN")
    public void setResourceKeyCRN(String resourceKeyCRN) {
        this.resourceKeyCRN = resourceKeyCRN;
    }

    @JsonProperty("serviceInstanceCRN")
    public String getServiceInstanceCRN() {
        return serviceInstanceCRN;
    }

    @JsonProperty("serviceInstanceCRN")
    public void setServiceInstanceCRN(String serviceInstanceCRN) {
        this.serviceInstanceCRN = serviceInstanceCRN;
    }

    @JsonAnyGetter
    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    @JsonAnySetter
    public void setAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
    }

}
