
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
import io.fabric8.kubernetes.api.builder.Editable;
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
import lombok.ToString;
import lombok.experimental.Accessors;

@JsonDeserialize(using = com.fasterxml.jackson.databind.JsonDeserializer.None.class)
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
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
public class Platform implements Editable<PlatformBuilder> , KubernetesResource
{

    @JsonProperty("defaultMachinePlatform")
    private MachinePool defaultMachinePlatform;
    @JsonProperty("privateZoneID")
    private String privateZoneID;
    @JsonProperty("region")
    private String region;
    @JsonProperty("resourceGroupID")
    private String resourceGroupID;
    @JsonProperty("tags")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private Map<String, String> tags = new LinkedHashMap<String, String>();
    @JsonProperty("vpcID")
    private String vpcID;
    @JsonProperty("vswitchIDs")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private List<String> vswitchIDs = new ArrayList<String>();
    @JsonIgnore
    private Map<String, Object> additionalProperties = new LinkedHashMap<String, Object>();

    /**
     * No args constructor for use in serialization
     * 
     */
    public Platform() {
    }

    public Platform(MachinePool defaultMachinePlatform, String privateZoneID, String region, String resourceGroupID, Map<String, String> tags, String vpcID, List<String> vswitchIDs) {
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
    public String getPrivateZoneID() {
        return privateZoneID;
    }

    @JsonProperty("privateZoneID")
    public void setPrivateZoneID(String privateZoneID) {
        this.privateZoneID = privateZoneID;
    }

    @JsonProperty("region")
    public String getRegion() {
        return region;
    }

    @JsonProperty("region")
    public void setRegion(String region) {
        this.region = region;
    }

    @JsonProperty("resourceGroupID")
    public String getResourceGroupID() {
        return resourceGroupID;
    }

    @JsonProperty("resourceGroupID")
    public void setResourceGroupID(String resourceGroupID) {
        this.resourceGroupID = resourceGroupID;
    }

    @JsonProperty("tags")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    public Map<String, String> getTags() {
        return tags;
    }

    @JsonProperty("tags")
    public void setTags(Map<String, String> tags) {
        this.tags = tags;
    }

    @JsonProperty("vpcID")
    public String getVpcID() {
        return vpcID;
    }

    @JsonProperty("vpcID")
    public void setVpcID(String vpcID) {
        this.vpcID = vpcID;
    }

    @JsonProperty("vswitchIDs")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    public List<String> getVswitchIDs() {
        return vswitchIDs;
    }

    @JsonProperty("vswitchIDs")
    public void setVswitchIDs(List<String> vswitchIDs) {
        this.vswitchIDs = vswitchIDs;
    }

    @JsonIgnore
    public PlatformBuilder edit() {
        return new PlatformBuilder(this);
    }

    @JsonIgnore
    public PlatformBuilder toBuilder() {
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
