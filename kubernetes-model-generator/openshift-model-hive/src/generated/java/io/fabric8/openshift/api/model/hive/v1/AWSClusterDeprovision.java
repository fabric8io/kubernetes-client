
package io.fabric8.openshift.api.model.hive.v1;

import java.util.LinkedHashMap;
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
import io.fabric8.openshift.api.model.hive.aws.v1.AssumeRole;
import io.sundr.builder.annotations.Buildable;
import io.sundr.builder.annotations.BuildableReference;

/**
 * AWSClusterDeprovision contains AWS-specific configuration for a ClusterDeprovision
 */
@JsonDeserialize(using = com.fasterxml.jackson.databind.JsonDeserializer.None.class)
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "credentialsAssumeRole",
    "credentialsSecretRef",
    "hostedZoneRole",
    "region"
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
public class AWSClusterDeprovision implements Editable<AWSClusterDeprovisionBuilder>, KubernetesResource
{

    @JsonProperty("credentialsAssumeRole")
    private AssumeRole credentialsAssumeRole;
    @JsonProperty("credentialsSecretRef")
    private LocalObjectReference credentialsSecretRef;
    @JsonProperty("hostedZoneRole")
    private String hostedZoneRole;
    @JsonProperty("region")
    private String region;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new LinkedHashMap<String, Object>();

    /**
     * No args constructor for use in serialization
     */
    public AWSClusterDeprovision() {
    }

    public AWSClusterDeprovision(AssumeRole credentialsAssumeRole, LocalObjectReference credentialsSecretRef, String hostedZoneRole, String region) {
        super();
        this.credentialsAssumeRole = credentialsAssumeRole;
        this.credentialsSecretRef = credentialsSecretRef;
        this.hostedZoneRole = hostedZoneRole;
        this.region = region;
    }

    /**
     * AWSClusterDeprovision contains AWS-specific configuration for a ClusterDeprovision
     */
    @JsonProperty("credentialsAssumeRole")
    public AssumeRole getCredentialsAssumeRole() {
        return credentialsAssumeRole;
    }

    /**
     * AWSClusterDeprovision contains AWS-specific configuration for a ClusterDeprovision
     */
    @JsonProperty("credentialsAssumeRole")
    public void setCredentialsAssumeRole(AssumeRole credentialsAssumeRole) {
        this.credentialsAssumeRole = credentialsAssumeRole;
    }

    /**
     * AWSClusterDeprovision contains AWS-specific configuration for a ClusterDeprovision
     */
    @JsonProperty("credentialsSecretRef")
    public LocalObjectReference getCredentialsSecretRef() {
        return credentialsSecretRef;
    }

    /**
     * AWSClusterDeprovision contains AWS-specific configuration for a ClusterDeprovision
     */
    @JsonProperty("credentialsSecretRef")
    public void setCredentialsSecretRef(LocalObjectReference credentialsSecretRef) {
        this.credentialsSecretRef = credentialsSecretRef;
    }

    /**
     * HostedZoneRole is the role to assume when performing operations on a hosted zone owned by another account.
     */
    @JsonProperty("hostedZoneRole")
    public String getHostedZoneRole() {
        return hostedZoneRole;
    }

    /**
     * HostedZoneRole is the role to assume when performing operations on a hosted zone owned by another account.
     */
    @JsonProperty("hostedZoneRole")
    public void setHostedZoneRole(String hostedZoneRole) {
        this.hostedZoneRole = hostedZoneRole;
    }

    /**
     * Region is the AWS region for this deprovisioning
     */
    @JsonProperty("region")
    public String getRegion() {
        return region;
    }

    /**
     * Region is the AWS region for this deprovisioning
     */
    @JsonProperty("region")
    public void setRegion(String region) {
        this.region = region;
    }

    @JsonIgnore
    public AWSClusterDeprovisionBuilder edit() {
        return new AWSClusterDeprovisionBuilder(this);
    }

    @JsonIgnore
    public AWSClusterDeprovisionBuilder toBuilder() {
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
        if (!(o instanceof AWSClusterDeprovision)) {
            return false;
        }
        AWSClusterDeprovision other = (AWSClusterDeprovision) o;
        if (!other.canEqual(this)) {
            return false;
        }
        Object this$credentialsAssumeRole = this.getCredentialsAssumeRole();
        Object other$credentialsAssumeRole = other.getCredentialsAssumeRole();
        if (this$credentialsAssumeRole == null ? other$credentialsAssumeRole != null : !this$credentialsAssumeRole.equals(other$credentialsAssumeRole)) {
            return false;
        }
        Object this$credentialsSecretRef = this.getCredentialsSecretRef();
        Object other$credentialsSecretRef = other.getCredentialsSecretRef();
        if (this$credentialsSecretRef == null ? other$credentialsSecretRef != null : !this$credentialsSecretRef.equals(other$credentialsSecretRef)) {
            return false;
        }
        Object this$hostedZoneRole = this.getHostedZoneRole();
        Object other$hostedZoneRole = other.getHostedZoneRole();
        if (this$hostedZoneRole == null ? other$hostedZoneRole != null : !this$hostedZoneRole.equals(other$hostedZoneRole)) {
            return false;
        }
        Object this$region = this.getRegion();
        Object other$region = other.getRegion();
        if (this$region == null ? other$region != null : !this$region.equals(other$region)) {
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
        return other instanceof AWSClusterDeprovision;
    }

    @Override
    public int hashCode() {
        final int prime = 59;
        int result = 1;
        Object $credentialsAssumeRole = this.getCredentialsAssumeRole();
        result = result * prime + ($credentialsAssumeRole == null ? 43 : $credentialsAssumeRole.hashCode());
        Object $credentialsSecretRef = this.getCredentialsSecretRef();
        result = result * prime + ($credentialsSecretRef == null ? 43 : $credentialsSecretRef.hashCode());
        Object $hostedZoneRole = this.getHostedZoneRole();
        result = result * prime + ($hostedZoneRole == null ? 43 : $hostedZoneRole.hashCode());
        Object $region = this.getRegion();
        result = result * prime + ($region == null ? 43 : $region.hashCode());
        Object $additionalProperties = this.getAdditionalProperties();
        result = result * prime + ($additionalProperties == null ? 43 : $additionalProperties.hashCode());
        return result;
    }

    @Override
    public String toString() {
        return "AWSClusterDeprovision(" + "credentialsAssumeRole=" + this.getCredentialsAssumeRole() + ", credentialsSecretRef=" + this.getCredentialsSecretRef() + ", hostedZoneRole=" + this.getHostedZoneRole() + ", region=" + this.getRegion() + ", additionalProperties=" + this.getAdditionalProperties() + ")";
    }

}
