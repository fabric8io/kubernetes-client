
package io.fabric8.openshift.api.model.installer.alibabacloud.v1;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
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
    "defaultMachinePlatform",
    "privateZoneID",
    "region",
    "resourceGroupID",
    "tags",
    "vpcID",
    "vswitchIDs"
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
public class Platform implements KubernetesResource
{

    @JsonProperty("defaultMachinePlatform")
    private MachinePool defaultMachinePlatform;
    @JsonProperty("privateZoneID")
    private java.lang.String privateZoneID;
    @JsonProperty("region")
    private java.lang.String region;
    @JsonProperty("resourceGroupID")
    private java.lang.String resourceGroupID;
    @JsonProperty("tags")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private Map<String, String> tags = new LinkedHashMap<String, String>();
    @JsonProperty("vpcID")
    private java.lang.String vpcID;
    @JsonProperty("vswitchIDs")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private List<java.lang.String> vswitchIDs = new ArrayList<java.lang.String>();
    @JsonIgnore
    private Map<java.lang.String, Object> additionalProperties = new LinkedHashMap<java.lang.String, Object>();

    /**
     * No args constructor for use in serialization
     * 
     */
    public Platform() {
    }

    public Platform(MachinePool defaultMachinePlatform, java.lang.String privateZoneID, java.lang.String region, java.lang.String resourceGroupID, Map<String, String> tags, java.lang.String vpcID, List<java.lang.String> vswitchIDs) {
        super();
        this.defaultMachinePlatform = defaultMachinePlatform;
        this.privateZoneID = privateZoneID;
        this.region = region;
        this.resourceGroupID = resourceGroupID;
        this.tags = tags;
        this.vpcID = vpcID;
        this.vswitchIDs = vswitchIDs;
    }

    @JsonProperty("defaultMachinePlatform")
    public MachinePool getDefaultMachinePlatform() {
        return defaultMachinePlatform;
    }

    @JsonProperty("defaultMachinePlatform")
    public void setDefaultMachinePlatform(MachinePool defaultMachinePlatform) {
        this.defaultMachinePlatform = defaultMachinePlatform;
    }

    @JsonProperty("privateZoneID")
    public java.lang.String getPrivateZoneID() {
        return privateZoneID;
    }

    @JsonProperty("privateZoneID")
    public void setPrivateZoneID(java.lang.String privateZoneID) {
        this.privateZoneID = privateZoneID;
    }

    @JsonProperty("region")
    public java.lang.String getRegion() {
        return region;
    }

    @JsonProperty("region")
    public void setRegion(java.lang.String region) {
        this.region = region;
    }

    @JsonProperty("resourceGroupID")
    public java.lang.String getResourceGroupID() {
        return resourceGroupID;
    }

    @JsonProperty("resourceGroupID")
    public void setResourceGroupID(java.lang.String resourceGroupID) {
        this.resourceGroupID = resourceGroupID;
    }

    @JsonProperty("tags")
    public Map<String, String> getTags() {
        return tags;
    }

    @JsonProperty("tags")
    public void setTags(Map<String, String> tags) {
        this.tags = tags;
    }

    @JsonProperty("vpcID")
    public java.lang.String getVpcID() {
        return vpcID;
    }

    @JsonProperty("vpcID")
    public void setVpcID(java.lang.String vpcID) {
        this.vpcID = vpcID;
    }

    @JsonProperty("vswitchIDs")
    public List<java.lang.String> getVswitchIDs() {
        return vswitchIDs;
    }

    @JsonProperty("vswitchIDs")
    public void setVswitchIDs(List<java.lang.String> vswitchIDs) {
        this.vswitchIDs = vswitchIDs;
    }

    @JsonAnyGetter
    public Map<java.lang.String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    @JsonAnySetter
    public void setAdditionalProperty(java.lang.String name, Object value) {
        this.additionalProperties.put(name, value);
    }

}
