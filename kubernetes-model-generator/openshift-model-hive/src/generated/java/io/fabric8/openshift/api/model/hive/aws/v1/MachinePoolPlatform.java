
package io.fabric8.openshift.api.model.hive.aws.v1;

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

/**
 * MachinePoolPlatform stores the configuration for a machine pool installed on AWS.
 */
@JsonDeserialize(using = com.fasterxml.jackson.databind.JsonDeserializer.None.class)
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "additionalSecurityGroupIDs",
    "metadataService",
    "rootVolume",
    "spotMarketOptions",
    "subnets",
    "type",
    "userTags",
    "zones"
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
public class MachinePoolPlatform implements Editable<MachinePoolPlatformBuilder>, KubernetesResource
{

    @JsonProperty("additionalSecurityGroupIDs")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private List<String> additionalSecurityGroupIDs = new ArrayList<>();
    @JsonProperty("metadataService")
    private EC2Metadata metadataService;
    @JsonProperty("rootVolume")
    private EC2RootVolume rootVolume;
    @JsonProperty("spotMarketOptions")
    private SpotMarketOptions spotMarketOptions;
    @JsonProperty("subnets")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private List<String> subnets = new ArrayList<>();
    @JsonProperty("type")
    private String type;
    @JsonProperty("userTags")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private Map<String, String> userTags = new LinkedHashMap<>();
    @JsonProperty("zones")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private List<String> zones = new ArrayList<>();
    @JsonIgnore
    private Map<String, Object> additionalProperties = new LinkedHashMap<String, Object>();

    /**
     * No args constructor for use in serialization
     */
    public MachinePoolPlatform() {
    }

    public MachinePoolPlatform(List<String> additionalSecurityGroupIDs, EC2Metadata metadataService, EC2RootVolume rootVolume, SpotMarketOptions spotMarketOptions, List<String> subnets, String type, Map<String, String> userTags, List<String> zones) {
        super();
        this.additionalSecurityGroupIDs = additionalSecurityGroupIDs;
        this.metadataService = metadataService;
        this.rootVolume = rootVolume;
        this.spotMarketOptions = spotMarketOptions;
        this.subnets = subnets;
        this.type = type;
        this.userTags = userTags;
        this.zones = zones;
    }

    /**
     * AdditionalSecurityGroupIDs contains IDs of additional security groups for machines, where each ID is presented in the format sg-xxxx.
     */
    @JsonProperty("additionalSecurityGroupIDs")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    public List<String> getAdditionalSecurityGroupIDs() {
        return additionalSecurityGroupIDs;
    }

    /**
     * AdditionalSecurityGroupIDs contains IDs of additional security groups for machines, where each ID is presented in the format sg-xxxx.
     */
    @JsonProperty("additionalSecurityGroupIDs")
    public void setAdditionalSecurityGroupIDs(List<String> additionalSecurityGroupIDs) {
        this.additionalSecurityGroupIDs = additionalSecurityGroupIDs;
    }

    /**
     * MachinePoolPlatform stores the configuration for a machine pool installed on AWS.
     */
    @JsonProperty("metadataService")
    public EC2Metadata getMetadataService() {
        return metadataService;
    }

    /**
     * MachinePoolPlatform stores the configuration for a machine pool installed on AWS.
     */
    @JsonProperty("metadataService")
    public void setMetadataService(EC2Metadata metadataService) {
        this.metadataService = metadataService;
    }

    /**
     * MachinePoolPlatform stores the configuration for a machine pool installed on AWS.
     */
    @JsonProperty("rootVolume")
    public EC2RootVolume getRootVolume() {
        return rootVolume;
    }

    /**
     * MachinePoolPlatform stores the configuration for a machine pool installed on AWS.
     */
    @JsonProperty("rootVolume")
    public void setRootVolume(EC2RootVolume rootVolume) {
        this.rootVolume = rootVolume;
    }

    /**
     * MachinePoolPlatform stores the configuration for a machine pool installed on AWS.
     */
    @JsonProperty("spotMarketOptions")
    public SpotMarketOptions getSpotMarketOptions() {
        return spotMarketOptions;
    }

    /**
     * MachinePoolPlatform stores the configuration for a machine pool installed on AWS.
     */
    @JsonProperty("spotMarketOptions")
    public void setSpotMarketOptions(SpotMarketOptions spotMarketOptions) {
        this.spotMarketOptions = spotMarketOptions;
    }

    /**
     * Subnets is the list of IDs of subnets to which to attach the machines. There must be exactly one subnet for each availability zone used. These subnets may be public or private. As a special case, for consistency with install-config, you may specify exactly one private and one public subnet for each availability zone. In this case, the public subnets will be filtered out and only the private subnets will be used. If empty/omitted, we will look for subnets in each availability zone tagged with Name=&lt;clusterID&gt;-private-&lt;az&gt; (legacy terraform) or &lt;clusterID&gt;-subnet-private-&lt;az&gt; (CAPA).
     */
    @JsonProperty("subnets")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    public List<String> getSubnets() {
        return subnets;
    }

    /**
     * Subnets is the list of IDs of subnets to which to attach the machines. There must be exactly one subnet for each availability zone used. These subnets may be public or private. As a special case, for consistency with install-config, you may specify exactly one private and one public subnet for each availability zone. In this case, the public subnets will be filtered out and only the private subnets will be used. If empty/omitted, we will look for subnets in each availability zone tagged with Name=&lt;clusterID&gt;-private-&lt;az&gt; (legacy terraform) or &lt;clusterID&gt;-subnet-private-&lt;az&gt; (CAPA).
     */
    @JsonProperty("subnets")
    public void setSubnets(List<String> subnets) {
        this.subnets = subnets;
    }

    /**
     * InstanceType defines the ec2 instance type. eg. m4-large
     */
    @JsonProperty("type")
    public String getType() {
        return type;
    }

    /**
     * InstanceType defines the ec2 instance type. eg. m4-large
     */
    @JsonProperty("type")
    public void setType(String type) {
        this.type = type;
    }

    /**
     * UserTags contains the user defined tags to be supplied for the ec2 instance. Note that these will be merged with ClusterDeployment.Spec.Platform.AWS.UserTags, with this field taking precedence when keys collide.
     */
    @JsonProperty("userTags")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    public Map<String, String> getUserTags() {
        return userTags;
    }

    /**
     * UserTags contains the user defined tags to be supplied for the ec2 instance. Note that these will be merged with ClusterDeployment.Spec.Platform.AWS.UserTags, with this field taking precedence when keys collide.
     */
    @JsonProperty("userTags")
    public void setUserTags(Map<String, String> userTags) {
        this.userTags = userTags;
    }

    /**
     * Zones is list of availability zones that can be used.
     */
    @JsonProperty("zones")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    public List<String> getZones() {
        return zones;
    }

    /**
     * Zones is list of availability zones that can be used.
     */
    @JsonProperty("zones")
    public void setZones(List<String> zones) {
        this.zones = zones;
    }

    @JsonIgnore
    public MachinePoolPlatformBuilder edit() {
        return new MachinePoolPlatformBuilder(this);
    }

    @JsonIgnore
    public MachinePoolPlatformBuilder toBuilder() {
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
    @Override
    public boolean equals(Object o) {
        if (o == this) {
            return true;
        }
        if (!(o instanceof MachinePoolPlatform)) {
            return false;
        }
        MachinePoolPlatform other = (MachinePoolPlatform) o;
        if (!other.canEqual(this)) {
            return false;
        }
        Object this$additionalSecurityGroupIDs = this.getAdditionalSecurityGroupIDs();
        Object other$additionalSecurityGroupIDs = other.getAdditionalSecurityGroupIDs();
        if (this$additionalSecurityGroupIDs == null ? other$additionalSecurityGroupIDs != null : !this$additionalSecurityGroupIDs.equals(other$additionalSecurityGroupIDs)) {
            return false;
        }
        Object this$metadataService = this.getMetadataService();
        Object other$metadataService = other.getMetadataService();
        if (this$metadataService == null ? other$metadataService != null : !this$metadataService.equals(other$metadataService)) {
            return false;
        }
        Object this$rootVolume = this.getRootVolume();
        Object other$rootVolume = other.getRootVolume();
        if (this$rootVolume == null ? other$rootVolume != null : !this$rootVolume.equals(other$rootVolume)) {
            return false;
        }
        Object this$spotMarketOptions = this.getSpotMarketOptions();
        Object other$spotMarketOptions = other.getSpotMarketOptions();
        if (this$spotMarketOptions == null ? other$spotMarketOptions != null : !this$spotMarketOptions.equals(other$spotMarketOptions)) {
            return false;
        }
        Object this$subnets = this.getSubnets();
        Object other$subnets = other.getSubnets();
        if (this$subnets == null ? other$subnets != null : !this$subnets.equals(other$subnets)) {
            return false;
        }
        Object this$type = this.getType();
        Object other$type = other.getType();
        if (this$type == null ? other$type != null : !this$type.equals(other$type)) {
            return false;
        }
        Object this$userTags = this.getUserTags();
        Object other$userTags = other.getUserTags();
        if (this$userTags == null ? other$userTags != null : !this$userTags.equals(other$userTags)) {
            return false;
        }
        Object this$zones = this.getZones();
        Object other$zones = other.getZones();
        if (this$zones == null ? other$zones != null : !this$zones.equals(other$zones)) {
            return false;
        }
        Object this$additionalProperties = this.getAdditionalProperties();
        Object other$additionalProperties = other.getAdditionalProperties();
        if (this$additionalProperties == null ? other$additionalProperties != null : !this$additionalProperties.equals(other$additionalProperties)) {
            return false;
        }
        return true;
    }

    protected boolean canEqual(Object other) {
        return other instanceof MachinePoolPlatform;
    }

    @Override
    public int hashCode() {
        final int prime = 59;
        int result = 1;
        Object $additionalSecurityGroupIDs = this.getAdditionalSecurityGroupIDs();
        result = result * prime + ($additionalSecurityGroupIDs == null ? 43 : $additionalSecurityGroupIDs.hashCode());
        Object $metadataService = this.getMetadataService();
        result = result * prime + ($metadataService == null ? 43 : $metadataService.hashCode());
        Object $rootVolume = this.getRootVolume();
        result = result * prime + ($rootVolume == null ? 43 : $rootVolume.hashCode());
        Object $spotMarketOptions = this.getSpotMarketOptions();
        result = result * prime + ($spotMarketOptions == null ? 43 : $spotMarketOptions.hashCode());
        Object $subnets = this.getSubnets();
        result = result * prime + ($subnets == null ? 43 : $subnets.hashCode());
        Object $type = this.getType();
        result = result * prime + ($type == null ? 43 : $type.hashCode());
        Object $userTags = this.getUserTags();
        result = result * prime + ($userTags == null ? 43 : $userTags.hashCode());
        Object $zones = this.getZones();
        result = result * prime + ($zones == null ? 43 : $zones.hashCode());
        Object $additionalProperties = this.getAdditionalProperties();
        result = result * prime + ($additionalProperties == null ? 43 : $additionalProperties.hashCode());
        return result;
    }

    @Override
    public String toString() {
        return "MachinePoolPlatform(" + "additionalSecurityGroupIDs=" + this.getAdditionalSecurityGroupIDs() + ", metadataService=" + this.getMetadataService() + ", rootVolume=" + this.getRootVolume() + ", spotMarketOptions=" + this.getSpotMarketOptions() + ", subnets=" + this.getSubnets() + ", type=" + this.getType() + ", userTags=" + this.getUserTags() + ", zones=" + this.getZones() + ", additionalProperties=" + this.getAdditionalProperties() + ")";
    }

}
