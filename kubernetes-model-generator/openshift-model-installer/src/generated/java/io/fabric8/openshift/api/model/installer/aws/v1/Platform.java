
package io.fabric8.openshift.api.model.installer.aws.v1;

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
 * Platform stores all the global configuration that all machinesets use.
 */
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
@Generated("io.fabric8.kubernetes.schema.generator.model.ModelGenerator")
public class Platform implements Editable<PlatformBuilder>, KubernetesResource
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

    /**
     * The field is deprecated. AMIID is the AMI that should be used to boot machines for the cluster. If set, the AMI should belong to the same region as the cluster.
     */
    @JsonProperty("amiID")
    public String getAmiID() {
        return amiID;
    }

    /**
     * The field is deprecated. AMIID is the AMI that should be used to boot machines for the cluster. If set, the AMI should belong to the same region as the cluster.
     */
    @JsonProperty("amiID")
    public void setAmiID(String amiID) {
        this.amiID = amiID;
    }

    /**
     * BestEffortDeleteIgnition is an optional field that can be used to ignore errors from S3 deletion of ignition objects during cluster bootstrap. The default behavior is to fail the installation if ignition objects cannot be deleted. Enable this functionality when there are known reasons disallowing their deletion.
     */
    @JsonProperty("bestEffortDeleteIgnition")
    public Boolean getBestEffortDeleteIgnition() {
        return bestEffortDeleteIgnition;
    }

    /**
     * BestEffortDeleteIgnition is an optional field that can be used to ignore errors from S3 deletion of ignition objects during cluster bootstrap. The default behavior is to fail the installation if ignition objects cannot be deleted. Enable this functionality when there are known reasons disallowing their deletion.
     */
    @JsonProperty("bestEffortDeleteIgnition")
    public void setBestEffortDeleteIgnition(Boolean bestEffortDeleteIgnition) {
        this.bestEffortDeleteIgnition = bestEffortDeleteIgnition;
    }

    /**
     * Platform stores all the global configuration that all machinesets use.
     */
    @JsonProperty("defaultMachinePlatform")
    public MachinePool getDefaultMachinePlatform() {
        return defaultMachinePlatform;
    }

    /**
     * Platform stores all the global configuration that all machinesets use.
     */
    @JsonProperty("defaultMachinePlatform")
    public void setDefaultMachinePlatform(MachinePool defaultMachinePlatform) {
        this.defaultMachinePlatform = defaultMachinePlatform;
    }

    /**
     * The field is deprecated. ExperimentalPropagateUserTags is an experimental flag that directs in-cluster operators to include the specified user tags in the tags of the AWS resources that the operators create.
     */
    @JsonProperty("experimentalPropagateUserTags")
    public Boolean getExperimentalPropagateUserTags() {
        return experimentalPropagateUserTags;
    }

    /**
     * The field is deprecated. ExperimentalPropagateUserTags is an experimental flag that directs in-cluster operators to include the specified user tags in the tags of the AWS resources that the operators create.
     */
    @JsonProperty("experimentalPropagateUserTags")
    public void setExperimentalPropagateUserTags(Boolean experimentalPropagateUserTags) {
        this.experimentalPropagateUserTags = experimentalPropagateUserTags;
    }

    /**
     * HostedZone is the ID of an existing hosted zone into which to add DNS records for the cluster's internal API. An existing hosted zone can only be used when also using existing subnets. The hosted zone must be associated with the VPC containing the subnets. Leave the hosted zone unset to have the installer create the hosted zone on your behalf.
     */
    @JsonProperty("hostedZone")
    public String getHostedZone() {
        return hostedZone;
    }

    /**
     * HostedZone is the ID of an existing hosted zone into which to add DNS records for the cluster's internal API. An existing hosted zone can only be used when also using existing subnets. The hosted zone must be associated with the VPC containing the subnets. Leave the hosted zone unset to have the installer create the hosted zone on your behalf.
     */
    @JsonProperty("hostedZone")
    public void setHostedZone(String hostedZone) {
        this.hostedZone = hostedZone;
    }

    /**
     * HostedZoneRole is the ARN of an IAM role to be assumed when performing operations on the provided HostedZone. HostedZoneRole can be used in a shared VPC scenario when the private hosted zone belongs to a different account than the rest of the cluster resources. If HostedZoneRole is set, HostedZone must also be set.
     */
    @JsonProperty("hostedZoneRole")
    public String getHostedZoneRole() {
        return hostedZoneRole;
    }

    /**
     * HostedZoneRole is the ARN of an IAM role to be assumed when performing operations on the provided HostedZone. HostedZoneRole can be used in a shared VPC scenario when the private hosted zone belongs to a different account than the rest of the cluster resources. If HostedZoneRole is set, HostedZone must also be set.
     */
    @JsonProperty("hostedZoneRole")
    public void setHostedZoneRole(String hostedZoneRole) {
        this.hostedZoneRole = hostedZoneRole;
    }

    /**
     * LBType is an optional field to specify a load balancer type. When this field is specified, all ingresscontrollers (including the default ingresscontroller) will be created using the specified load-balancer type by default.<br><p> <br><p> Following are the accepted values:<br><p> <br><p> &#42; "Classic": A Classic Load Balancer that makes routing decisions at either the transport layer (TCP/SSL) or the application layer (HTTP/HTTPS). See the following for additional details: https://docs.aws.amazon.com/AmazonECS/latest/developerguide/load-balancer-types.html#clb<br><p> <br><p> &#42; "NLB": A Network Load Balancer that makes routing decisions at the transport layer (TCP/SSL). See the following for additional details: https://docs.aws.amazon.com/AmazonECS/latest/developerguide/load-balancer-types.html#nlb<br><p> <br><p> If this field is not set explicitly, it defaults to "Classic".  This default is subject to change over time.
     */
    @JsonProperty("lbType")
    public String getLbType() {
        return lbType;
    }

    /**
     * LBType is an optional field to specify a load balancer type. When this field is specified, all ingresscontrollers (including the default ingresscontroller) will be created using the specified load-balancer type by default.<br><p> <br><p> Following are the accepted values:<br><p> <br><p> &#42; "Classic": A Classic Load Balancer that makes routing decisions at either the transport layer (TCP/SSL) or the application layer (HTTP/HTTPS). See the following for additional details: https://docs.aws.amazon.com/AmazonECS/latest/developerguide/load-balancer-types.html#clb<br><p> <br><p> &#42; "NLB": A Network Load Balancer that makes routing decisions at the transport layer (TCP/SSL). See the following for additional details: https://docs.aws.amazon.com/AmazonECS/latest/developerguide/load-balancer-types.html#nlb<br><p> <br><p> If this field is not set explicitly, it defaults to "Classic".  This default is subject to change over time.
     */
    @JsonProperty("lbType")
    public void setLbType(String lbType) {
        this.lbType = lbType;
    }

    /**
     * PreserveBootstrapIgnition is deprecated. Use bestEffortDeleteIgnition instead.
     */
    @JsonProperty("preserveBootstrapIgnition")
    public Boolean getPreserveBootstrapIgnition() {
        return preserveBootstrapIgnition;
    }

    /**
     * PreserveBootstrapIgnition is deprecated. Use bestEffortDeleteIgnition instead.
     */
    @JsonProperty("preserveBootstrapIgnition")
    public void setPreserveBootstrapIgnition(Boolean preserveBootstrapIgnition) {
        this.preserveBootstrapIgnition = preserveBootstrapIgnition;
    }

    /**
     * PropagateUserTags is a flag that directs in-cluster operators to include the specified user tags in the tags of the AWS resources that the operators create.
     */
    @JsonProperty("propagateUserTags")
    public Boolean getPropagateUserTags() {
        return propagateUserTags;
    }

    /**
     * PropagateUserTags is a flag that directs in-cluster operators to include the specified user tags in the tags of the AWS resources that the operators create.
     */
    @JsonProperty("propagateUserTags")
    public void setPropagateUserTags(Boolean propagateUserTags) {
        this.propagateUserTags = propagateUserTags;
    }

    /**
     * PublicIpv4Pool is an optional field that can be used to tell the installation process to use Public IPv4 address that you bring to your AWS account with BYOIP.
     */
    @JsonProperty("publicIpv4Pool")
    public String getPublicIpv4Pool() {
        return publicIpv4Pool;
    }

    /**
     * PublicIpv4Pool is an optional field that can be used to tell the installation process to use Public IPv4 address that you bring to your AWS account with BYOIP.
     */
    @JsonProperty("publicIpv4Pool")
    public void setPublicIpv4Pool(String publicIpv4Pool) {
        this.publicIpv4Pool = publicIpv4Pool;
    }

    /**
     * Region specifies the AWS region where the cluster will be created.
     */
    @JsonProperty("region")
    public String getRegion() {
        return region;
    }

    /**
     * Region specifies the AWS region where the cluster will be created.
     */
    @JsonProperty("region")
    public void setRegion(String region) {
        this.region = region;
    }

    /**
     * ServiceEndpoints list contains custom endpoints which will override default service endpoint of AWS Services. There must be only one ServiceEndpoint for a service.
     */
    @JsonProperty("serviceEndpoints")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    public List<ServiceEndpoint> getServiceEndpoints() {
        return serviceEndpoints;
    }

    /**
     * ServiceEndpoints list contains custom endpoints which will override default service endpoint of AWS Services. There must be only one ServiceEndpoint for a service.
     */
    @JsonProperty("serviceEndpoints")
    public void setServiceEndpoints(List<ServiceEndpoint> serviceEndpoints) {
        this.serviceEndpoints = serviceEndpoints;
    }

    /**
     * Subnets specifies existing subnets (by ID) where cluster resources will be created.  Leave unset to have the installer create subnets in a new VPC on your behalf.
     */
    @JsonProperty("subnets")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    public List<String> getSubnets() {
        return subnets;
    }

    /**
     * Subnets specifies existing subnets (by ID) where cluster resources will be created.  Leave unset to have the installer create subnets in a new VPC on your behalf.
     */
    @JsonProperty("subnets")
    public void setSubnets(List<String> subnets) {
        this.subnets = subnets;
    }

    /**
     * UserTags additional keys and values that the installer will add as tags to all resources that it creates. Resources created by the cluster itself may not include these tags.
     */
    @JsonProperty("userTags")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    public Map<String, String> getUserTags() {
        return userTags;
    }

    /**
     * UserTags additional keys and values that the installer will add as tags to all resources that it creates. Resources created by the cluster itself may not include these tags.
     */
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
