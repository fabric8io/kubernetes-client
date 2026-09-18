
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

/**
 * Platform stores all the global configuration that all machinesets use.
 */
@JsonDeserialize(using = com.fasterxml.jackson.databind.JsonDeserializer.None.class)
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "amiID",
    "bestEffortDeleteIgnition",
    "defaultMachinePlatform",
    "hostedZone",
    "hostedZoneRole",
    "lbType",
    "preserveBootstrapIgnition",
    "propagateUserTags",
    "publicIpv4Pool",
    "region",
    "serviceEndpoints",
    "subnets",
    "userProvisionedDNS",
    "userTags",
    "vpc"
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
    @JsonProperty("userProvisionedDNS")
    private String userProvisionedDNS;
    @JsonProperty("userTags")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private Map<String, String> userTags = new LinkedHashMap<>();
    @JsonProperty("vpc")
    private VPC vpc;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new LinkedHashMap<String, Object>();

    /**
     * No args constructor for use in serialization
     */
    public Platform() {
    }

    public Platform(String amiID, Boolean bestEffortDeleteIgnition, MachinePool defaultMachinePlatform, String hostedZone, String hostedZoneRole, String lbType, Boolean preserveBootstrapIgnition, Boolean propagateUserTags, String publicIpv4Pool, String region, List<ServiceEndpoint> serviceEndpoints, List<String> subnets, String userProvisionedDNS, Map<String, String> userTags, VPC vpc) {
        super();
        this.amiID = amiID;
        this.bestEffortDeleteIgnition = bestEffortDeleteIgnition;
        this.defaultMachinePlatform = defaultMachinePlatform;
        this.hostedZone = hostedZone;
        this.hostedZoneRole = hostedZoneRole;
        this.lbType = lbType;
        this.preserveBootstrapIgnition = preserveBootstrapIgnition;
        this.propagateUserTags = propagateUserTags;
        this.publicIpv4Pool = publicIpv4Pool;
        this.region = region;
        this.serviceEndpoints = serviceEndpoints;
        this.subnets = subnets;
        this.userProvisionedDNS = userProvisionedDNS;
        this.userTags = userTags;
        this.vpc = vpc;
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
     * Subnets specifies existing subnets (by ID) where cluster resources will be created.  Leave unset to have the installer create subnets in a new VPC on your behalf.<br><p> <br><p> Deprecated: use platform.aws.vpc.subnets
     */
    @JsonProperty("subnets")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    public List<String> getSubnets() {
        return subnets;
    }

    /**
     * Subnets specifies existing subnets (by ID) where cluster resources will be created.  Leave unset to have the installer create subnets in a new VPC on your behalf.<br><p> <br><p> Deprecated: use platform.aws.vpc.subnets
     */
    @JsonProperty("subnets")
    public void setSubnets(List<String> subnets) {
        this.subnets = subnets;
    }

    /**
     * UserProvisionedDNS indicates if the customer is providing their own DNS solution in place of the default provisioned by the Installer.
     */
    @JsonProperty("userProvisionedDNS")
    public String getUserProvisionedDNS() {
        return userProvisionedDNS;
    }

    /**
     * UserProvisionedDNS indicates if the customer is providing their own DNS solution in place of the default provisioned by the Installer.
     */
    @JsonProperty("userProvisionedDNS")
    public void setUserProvisionedDNS(String userProvisionedDNS) {
        this.userProvisionedDNS = userProvisionedDNS;
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

    /**
     * Platform stores all the global configuration that all machinesets use.
     */
    @JsonProperty("vpc")
    public VPC getVpc() {
        return vpc;
    }

    /**
     * Platform stores all the global configuration that all machinesets use.
     */
    @JsonProperty("vpc")
    public void setVpc(VPC vpc) {
        this.vpc = vpc;
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
    @Override
    public boolean equals(Object o) {
        if (o == this) {
            return true;
        }
        if (!(o instanceof Platform)) {
            return false;
        }
        Platform other = (Platform) o;
        if (!other.canEqual(this)) {
            return false;
        }
        Object this$amiID = this.getAmiID();
        Object other$amiID = other.getAmiID();
        if (this$amiID == null ? other$amiID != null : !this$amiID.equals(other$amiID)) {
            return false;
        }
        Object this$bestEffortDeleteIgnition = this.getBestEffortDeleteIgnition();
        Object other$bestEffortDeleteIgnition = other.getBestEffortDeleteIgnition();
        if (this$bestEffortDeleteIgnition == null ? other$bestEffortDeleteIgnition != null : !this$bestEffortDeleteIgnition.equals(other$bestEffortDeleteIgnition)) {
            return false;
        }
        Object this$defaultMachinePlatform = this.getDefaultMachinePlatform();
        Object other$defaultMachinePlatform = other.getDefaultMachinePlatform();
        if (this$defaultMachinePlatform == null ? other$defaultMachinePlatform != null : !this$defaultMachinePlatform.equals(other$defaultMachinePlatform)) {
            return false;
        }
        Object this$hostedZone = this.getHostedZone();
        Object other$hostedZone = other.getHostedZone();
        if (this$hostedZone == null ? other$hostedZone != null : !this$hostedZone.equals(other$hostedZone)) {
            return false;
        }
        Object this$hostedZoneRole = this.getHostedZoneRole();
        Object other$hostedZoneRole = other.getHostedZoneRole();
        if (this$hostedZoneRole == null ? other$hostedZoneRole != null : !this$hostedZoneRole.equals(other$hostedZoneRole)) {
            return false;
        }
        Object this$lbType = this.getLbType();
        Object other$lbType = other.getLbType();
        if (this$lbType == null ? other$lbType != null : !this$lbType.equals(other$lbType)) {
            return false;
        }
        Object this$preserveBootstrapIgnition = this.getPreserveBootstrapIgnition();
        Object other$preserveBootstrapIgnition = other.getPreserveBootstrapIgnition();
        if (this$preserveBootstrapIgnition == null ? other$preserveBootstrapIgnition != null : !this$preserveBootstrapIgnition.equals(other$preserveBootstrapIgnition)) {
            return false;
        }
        Object this$propagateUserTags = this.getPropagateUserTags();
        Object other$propagateUserTags = other.getPropagateUserTags();
        if (this$propagateUserTags == null ? other$propagateUserTags != null : !this$propagateUserTags.equals(other$propagateUserTags)) {
            return false;
        }
        Object this$publicIpv4Pool = this.getPublicIpv4Pool();
        Object other$publicIpv4Pool = other.getPublicIpv4Pool();
        if (this$publicIpv4Pool == null ? other$publicIpv4Pool != null : !this$publicIpv4Pool.equals(other$publicIpv4Pool)) {
            return false;
        }
        Object this$region = this.getRegion();
        Object other$region = other.getRegion();
        if (this$region == null ? other$region != null : !this$region.equals(other$region)) {
            return false;
        }
        Object this$serviceEndpoints = this.getServiceEndpoints();
        Object other$serviceEndpoints = other.getServiceEndpoints();
        if (this$serviceEndpoints == null ? other$serviceEndpoints != null : !this$serviceEndpoints.equals(other$serviceEndpoints)) {
            return false;
        }
        Object this$subnets = this.getSubnets();
        Object other$subnets = other.getSubnets();
        if (this$subnets == null ? other$subnets != null : !this$subnets.equals(other$subnets)) {
            return false;
        }
        Object this$userProvisionedDNS = this.getUserProvisionedDNS();
        Object other$userProvisionedDNS = other.getUserProvisionedDNS();
        if (this$userProvisionedDNS == null ? other$userProvisionedDNS != null : !this$userProvisionedDNS.equals(other$userProvisionedDNS)) {
            return false;
        }
        Object this$userTags = this.getUserTags();
        Object other$userTags = other.getUserTags();
        if (this$userTags == null ? other$userTags != null : !this$userTags.equals(other$userTags)) {
            return false;
        }
        Object this$vpc = this.getVpc();
        Object other$vpc = other.getVpc();
        if (this$vpc == null ? other$vpc != null : !this$vpc.equals(other$vpc)) {
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
        return other instanceof Platform;
    }

    @Override
    public int hashCode() {
        final int prime = 59;
        int result = 1;
        Object $amiID = this.getAmiID();
        result = result * prime + ($amiID == null ? 43 : $amiID.hashCode());
        Object $bestEffortDeleteIgnition = this.getBestEffortDeleteIgnition();
        result = result * prime + ($bestEffortDeleteIgnition == null ? 43 : $bestEffortDeleteIgnition.hashCode());
        Object $defaultMachinePlatform = this.getDefaultMachinePlatform();
        result = result * prime + ($defaultMachinePlatform == null ? 43 : $defaultMachinePlatform.hashCode());
        Object $hostedZone = this.getHostedZone();
        result = result * prime + ($hostedZone == null ? 43 : $hostedZone.hashCode());
        Object $hostedZoneRole = this.getHostedZoneRole();
        result = result * prime + ($hostedZoneRole == null ? 43 : $hostedZoneRole.hashCode());
        Object $lbType = this.getLbType();
        result = result * prime + ($lbType == null ? 43 : $lbType.hashCode());
        Object $preserveBootstrapIgnition = this.getPreserveBootstrapIgnition();
        result = result * prime + ($preserveBootstrapIgnition == null ? 43 : $preserveBootstrapIgnition.hashCode());
        Object $propagateUserTags = this.getPropagateUserTags();
        result = result * prime + ($propagateUserTags == null ? 43 : $propagateUserTags.hashCode());
        Object $publicIpv4Pool = this.getPublicIpv4Pool();
        result = result * prime + ($publicIpv4Pool == null ? 43 : $publicIpv4Pool.hashCode());
        Object $region = this.getRegion();
        result = result * prime + ($region == null ? 43 : $region.hashCode());
        Object $serviceEndpoints = this.getServiceEndpoints();
        result = result * prime + ($serviceEndpoints == null ? 43 : $serviceEndpoints.hashCode());
        Object $subnets = this.getSubnets();
        result = result * prime + ($subnets == null ? 43 : $subnets.hashCode());
        Object $userProvisionedDNS = this.getUserProvisionedDNS();
        result = result * prime + ($userProvisionedDNS == null ? 43 : $userProvisionedDNS.hashCode());
        Object $userTags = this.getUserTags();
        result = result * prime + ($userTags == null ? 43 : $userTags.hashCode());
        Object $vpc = this.getVpc();
        result = result * prime + ($vpc == null ? 43 : $vpc.hashCode());
        Object $additionalProperties = this.getAdditionalProperties();
        result = result * prime + ($additionalProperties == null ? 43 : $additionalProperties.hashCode());
        return result;
    }

    @Override
    public String toString() {
        return "Platform(" + "amiID=" + this.getAmiID() + ", bestEffortDeleteIgnition=" + this.getBestEffortDeleteIgnition() + ", defaultMachinePlatform=" + this.getDefaultMachinePlatform() + ", hostedZone=" + this.getHostedZone() + ", hostedZoneRole=" + this.getHostedZoneRole() + ", lbType=" + this.getLbType() + ", preserveBootstrapIgnition=" + this.getPreserveBootstrapIgnition() + ", propagateUserTags=" + this.getPropagateUserTags() + ", publicIpv4Pool=" + this.getPublicIpv4Pool() + ", region=" + this.getRegion() + ", serviceEndpoints=" + this.getServiceEndpoints() + ", subnets=" + this.getSubnets() + ", userProvisionedDNS=" + this.getUserProvisionedDNS() + ", userTags=" + this.getUserTags() + ", vpc=" + this.getVpc() + ", additionalProperties=" + this.getAdditionalProperties() + ")";
    }

}
