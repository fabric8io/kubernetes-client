
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

@JsonDeserialize(using = com.fasterxml.jackson.databind.JsonDeserializer.None.class)
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "amiID",
    "bestEffortDeleteIgnition",
    "defaultMachinePlatform",
    "experimentalPropagateUserTags",
    "hostedZone",
    "hostedZoneRole",
    "lbType",
    "preserveBootstrapIgnition",
    "propagateUserTags",
    "publicIpv4Pool",
    "region",
    "serviceEndpoints",
    "subnets",
    "userTags"
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
@Generated("jsonschema2pojo")
public class Platform implements Editable<PlatformBuilder> , KubernetesResource
{

    @JsonProperty("amiID")
    private String amiID;
    @JsonProperty("bestEffortDeleteIgnition")
    private Boolean bestEffortDeleteIgnition;
    @JsonProperty("defaultMachinePlatform")
    private MachinePool defaultMachinePlatform;
    @JsonProperty("experimentalPropagateUserTags")
    private Boolean experimentalPropagateUserTags;
    @JsonProperty("hostedZone")
    private String hostedZone;
    @JsonProperty("hostedZoneRole")
    private String hostedZoneRole;
    @JsonProperty("lbType")
    private String lbType;
    @JsonProperty("preserveBootstrapIgnition")
    private Boolean preserveBootstrapIgnition;
    @JsonProperty("propagateUserTags")
    private Boolean propagateUserTags;
    @JsonProperty("publicIpv4Pool")
    private String publicIpv4Pool;
    @JsonProperty("region")
    private String region;
    @JsonProperty("serviceEndpoints")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private List<ServiceEndpoint> serviceEndpoints = new ArrayList<>();
    @JsonProperty("subnets")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private List<String> subnets = new ArrayList<>();
    @JsonProperty("userTags")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private Map<String, String> userTags = new LinkedHashMap<>();
    @JsonIgnore
    private Map<String, Object> additionalProperties = new LinkedHashMap<String, Object>();

    /**
     * No args constructor for use in serialization
     * 
     */
    public Platform() {
    }

    public Platform(String amiID, Boolean bestEffortDeleteIgnition, MachinePool defaultMachinePlatform, Boolean experimentalPropagateUserTags, String hostedZone, String hostedZoneRole, String lbType, Boolean preserveBootstrapIgnition, Boolean propagateUserTags, String publicIpv4Pool, String region, List<ServiceEndpoint> serviceEndpoints, List<String> subnets, Map<String, String> userTags) {
        super();
        this.amiID = amiID;
        this.bestEffortDeleteIgnition = bestEffortDeleteIgnition;
        this.defaultMachinePlatform = defaultMachinePlatform;
        this.experimentalPropagateUserTags = experimentalPropagateUserTags;
        this.hostedZone = hostedZone;
        this.hostedZoneRole = hostedZoneRole;
        this.lbType = lbType;
        this.preserveBootstrapIgnition = preserveBootstrapIgnition;
        this.propagateUserTags = propagateUserTags;
        this.publicIpv4Pool = publicIpv4Pool;
        this.region = region;
        this.serviceEndpoints = serviceEndpoints;
        this.subnets = subnets;
        this.userTags = userTags;
    }

    @JsonProperty("amiID")
    public String getAmiID() {
        return amiID;
    }

    @JsonProperty("amiID")
    public void setAmiID(String amiID) {
        this.amiID = amiID;
    }

    @JsonProperty("bestEffortDeleteIgnition")
    public Boolean getBestEffortDeleteIgnition() {
        return bestEffortDeleteIgnition;
    }

    @JsonProperty("bestEffortDeleteIgnition")
    public void setBestEffortDeleteIgnition(Boolean bestEffortDeleteIgnition) {
        this.bestEffortDeleteIgnition = bestEffortDeleteIgnition;
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
    public String getHostedZone() {
        return hostedZone;
    }

    @JsonProperty("hostedZone")
    public void setHostedZone(String hostedZone) {
        this.hostedZone = hostedZone;
    }

    @JsonProperty("hostedZoneRole")
    public String getHostedZoneRole() {
        return hostedZoneRole;
    }

    @JsonProperty("hostedZoneRole")
    public void setHostedZoneRole(String hostedZoneRole) {
        this.hostedZoneRole = hostedZoneRole;
    }

    @JsonProperty("lbType")
    public String getLbType() {
        return lbType;
    }

    @JsonProperty("lbType")
    public void setLbType(String lbType) {
        this.lbType = lbType;
    }

    @JsonProperty("preserveBootstrapIgnition")
    public Boolean getPreserveBootstrapIgnition() {
        return preserveBootstrapIgnition;
    }

    @JsonProperty("preserveBootstrapIgnition")
    public void setPreserveBootstrapIgnition(Boolean preserveBootstrapIgnition) {
        this.preserveBootstrapIgnition = preserveBootstrapIgnition;
    }

    @JsonProperty("propagateUserTags")
    public Boolean getPropagateUserTags() {
        return propagateUserTags;
    }

    @JsonProperty("propagateUserTags")
    public void setPropagateUserTags(Boolean propagateUserTags) {
        this.propagateUserTags = propagateUserTags;
    }

    @JsonProperty("publicIpv4Pool")
    public String getPublicIpv4Pool() {
        return publicIpv4Pool;
    }

    @JsonProperty("publicIpv4Pool")
    public void setPublicIpv4Pool(String publicIpv4Pool) {
        this.publicIpv4Pool = publicIpv4Pool;
    }

    @JsonProperty("region")
    public String getRegion() {
        return region;
    }

    @JsonProperty("region")
    public void setRegion(String region) {
        this.region = region;
    }

    @JsonProperty("serviceEndpoints")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    public List<ServiceEndpoint> getServiceEndpoints() {
        return serviceEndpoints;
    }

    @JsonProperty("serviceEndpoints")
    public void setServiceEndpoints(List<ServiceEndpoint> serviceEndpoints) {
        this.serviceEndpoints = serviceEndpoints;
    }

    @JsonProperty("subnets")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    public List<String> getSubnets() {
        return subnets;
    }

    @JsonProperty("subnets")
    public void setSubnets(List<String> subnets) {
        this.subnets = subnets;
    }

    @JsonProperty("userTags")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    public Map<String, String> getUserTags() {
        return userTags;
    }

    @JsonProperty("userTags")
    public void setUserTags(Map<String, String> userTags) {
        this.userTags = userTags;
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
