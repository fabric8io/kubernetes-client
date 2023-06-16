
package io.fabric8.openshift.api.model.installer.aws.v1;

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
    "amiID",
    "defaultMachinePlatform",
    "experimentalPropagateUserTags",
    "hostedZone",
    "lbType",
    "propagateUserTags",
    "region",
    "serviceEndpoints",
    "subnets",
    "userTags"
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

    @JsonProperty("amiID")
    private java.lang.String amiID;
    @JsonProperty("defaultMachinePlatform")
    private MachinePool defaultMachinePlatform;
    @JsonProperty("experimentalPropagateUserTags")
    private Boolean experimentalPropagateUserTags;
    @JsonProperty("hostedZone")
    private java.lang.String hostedZone;
    @JsonProperty("lbType")
    private java.lang.String lbType;
    @JsonProperty("propagateUserTags")
    private Boolean propagateUserTags;
    @JsonProperty("region")
    private java.lang.String region;
    @JsonProperty("serviceEndpoints")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private List<ServiceEndpoint> serviceEndpoints = new ArrayList<ServiceEndpoint>();
    @JsonProperty("subnets")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private List<java.lang.String> subnets = new ArrayList<java.lang.String>();
    @JsonProperty("userTags")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private Map<String, String> userTags = new LinkedHashMap<String, String>();
    @JsonIgnore
    private Map<java.lang.String, Object> additionalProperties = new LinkedHashMap<java.lang.String, Object>();

    /**
     * No args constructor for use in serialization
     * 
     */
    public Platform() {
    }

    public Platform(java.lang.String amiID, MachinePool defaultMachinePlatform, Boolean experimentalPropagateUserTags, java.lang.String hostedZone, java.lang.String lbType, Boolean propagateUserTags, java.lang.String region, List<ServiceEndpoint> serviceEndpoints, List<java.lang.String> subnets, Map<String, String> userTags) {
        super();
        this.amiID = amiID;
        this.defaultMachinePlatform = defaultMachinePlatform;
        this.experimentalPropagateUserTags = experimentalPropagateUserTags;
        this.hostedZone = hostedZone;
        this.lbType = lbType;
        this.propagateUserTags = propagateUserTags;
        this.region = region;
        this.serviceEndpoints = serviceEndpoints;
        this.subnets = subnets;
        this.userTags = userTags;
    }

    @JsonProperty("amiID")
    public java.lang.String getAmiID() {
        return amiID;
    }

    @JsonProperty("amiID")
    public void setAmiID(java.lang.String amiID) {
        this.amiID = amiID;
    }

    @JsonProperty("defaultMachinePlatform")
    public MachinePool getDefaultMachinePlatform() {
        return defaultMachinePlatform;
    }

    @JsonProperty("defaultMachinePlatform")
    public void setDefaultMachinePlatform(MachinePool defaultMachinePlatform) {
        this.defaultMachinePlatform = defaultMachinePlatform;
    }

    @JsonProperty("experimentalPropagateUserTags")
    public Boolean getExperimentalPropagateUserTags() {
        return experimentalPropagateUserTags;
    }

    @JsonProperty("experimentalPropagateUserTags")
    public void setExperimentalPropagateUserTags(Boolean experimentalPropagateUserTags) {
        this.experimentalPropagateUserTags = experimentalPropagateUserTags;
    }

    @JsonProperty("hostedZone")
    public java.lang.String getHostedZone() {
        return hostedZone;
    }

    @JsonProperty("hostedZone")
    public void setHostedZone(java.lang.String hostedZone) {
        this.hostedZone = hostedZone;
    }

    @JsonProperty("lbType")
    public java.lang.String getLbType() {
        return lbType;
    }

    @JsonProperty("lbType")
    public void setLbType(java.lang.String lbType) {
        this.lbType = lbType;
    }

    @JsonProperty("propagateUserTags")
    public Boolean getPropagateUserTags() {
        return propagateUserTags;
    }

    @JsonProperty("propagateUserTags")
    public void setPropagateUserTags(Boolean propagateUserTags) {
        this.propagateUserTags = propagateUserTags;
    }

    @JsonProperty("region")
    public java.lang.String getRegion() {
        return region;
    }

    @JsonProperty("region")
    public void setRegion(java.lang.String region) {
        this.region = region;
    }

    @JsonProperty("serviceEndpoints")
    public List<ServiceEndpoint> getServiceEndpoints() {
        return serviceEndpoints;
    }

    @JsonProperty("serviceEndpoints")
    public void setServiceEndpoints(List<ServiceEndpoint> serviceEndpoints) {
        this.serviceEndpoints = serviceEndpoints;
    }

    @JsonProperty("subnets")
    public List<java.lang.String> getSubnets() {
        return subnets;
    }

    @JsonProperty("subnets")
    public void setSubnets(List<java.lang.String> subnets) {
        this.subnets = subnets;
    }

    @JsonProperty("userTags")
    public Map<String, String> getUserTags() {
        return userTags;
    }

    @JsonProperty("userTags")
    public void setUserTags(Map<String, String> userTags) {
        this.userTags = userTags;
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
