
package io.fabric8.openshift.api.model.hive.aws.v1;

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
import io.sundr.builder.annotations.Buildable;
import io.sundr.builder.annotations.BuildableReference;

/**
 * Platform stores all the global configuration that all machinesets use.
 */
@JsonDeserialize(using = com.fasterxml.jackson.databind.JsonDeserializer.None.class)
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "credentialsAssumeRole",
    "credentialsSecretRef",
    "privateLink",
    "region",
    "userTags"
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

    @JsonProperty("credentialsAssumeRole")
    private AssumeRole credentialsAssumeRole;
    @JsonProperty("credentialsSecretRef")
    private LocalObjectReference credentialsSecretRef;
    @JsonProperty("privateLink")
    private PrivateLinkAccess privateLink;
    @JsonProperty("region")
    private String region;
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

    public Platform(AssumeRole credentialsAssumeRole, LocalObjectReference credentialsSecretRef, PrivateLinkAccess privateLink, String region, Map<String, String> userTags) {
        super();
        this.credentialsAssumeRole = credentialsAssumeRole;
        this.credentialsSecretRef = credentialsSecretRef;
        this.privateLink = privateLink;
        this.region = region;
        this.userTags = userTags;
    }

    /**
     * Platform stores all the global configuration that all machinesets use.
     */
    @JsonProperty("credentialsAssumeRole")
    public AssumeRole getCredentialsAssumeRole() {
        return credentialsAssumeRole;
    }

    /**
     * Platform stores all the global configuration that all machinesets use.
     */
    @JsonProperty("credentialsAssumeRole")
    public void setCredentialsAssumeRole(AssumeRole credentialsAssumeRole) {
        this.credentialsAssumeRole = credentialsAssumeRole;
    }

    /**
     * Platform stores all the global configuration that all machinesets use.
     */
    @JsonProperty("credentialsSecretRef")
    public LocalObjectReference getCredentialsSecretRef() {
        return credentialsSecretRef;
    }

    /**
     * Platform stores all the global configuration that all machinesets use.
     */
    @JsonProperty("credentialsSecretRef")
    public void setCredentialsSecretRef(LocalObjectReference credentialsSecretRef) {
        this.credentialsSecretRef = credentialsSecretRef;
    }

    /**
     * Platform stores all the global configuration that all machinesets use.
     */
    @JsonProperty("privateLink")
    public PrivateLinkAccess getPrivateLink() {
        return privateLink;
    }

    /**
     * Platform stores all the global configuration that all machinesets use.
     */
    @JsonProperty("privateLink")
    public void setPrivateLink(PrivateLinkAccess privateLink) {
        this.privateLink = privateLink;
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
     * UserTags specifies additional tags for AWS resources created for the cluster.
     */
    @JsonProperty("userTags")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    public Map<String, String> getUserTags() {
        return userTags;
    }

    /**
     * UserTags specifies additional tags for AWS resources created for the cluster.
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
        Object this$privateLink = this.getPrivateLink();
        Object other$privateLink = other.getPrivateLink();
        if (this$privateLink == null ? other$privateLink != null : !this$privateLink.equals(other$privateLink)) {
            return false;
        }
        Object this$region = this.getRegion();
        Object other$region = other.getRegion();
        if (this$region == null ? other$region != null : !this$region.equals(other$region)) {
            return false;
        }
        Object this$userTags = this.getUserTags();
        Object other$userTags = other.getUserTags();
        if (this$userTags == null ? other$userTags != null : !this$userTags.equals(other$userTags)) {
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
        Object $credentialsAssumeRole = this.getCredentialsAssumeRole();
        result = result * prime + ($credentialsAssumeRole == null ? 43 : $credentialsAssumeRole.hashCode());
        Object $credentialsSecretRef = this.getCredentialsSecretRef();
        result = result * prime + ($credentialsSecretRef == null ? 43 : $credentialsSecretRef.hashCode());
        Object $privateLink = this.getPrivateLink();
        result = result * prime + ($privateLink == null ? 43 : $privateLink.hashCode());
        Object $region = this.getRegion();
        result = result * prime + ($region == null ? 43 : $region.hashCode());
        Object $userTags = this.getUserTags();
        result = result * prime + ($userTags == null ? 43 : $userTags.hashCode());
        Object $additionalProperties = this.getAdditionalProperties();
        result = result * prime + ($additionalProperties == null ? 43 : $additionalProperties.hashCode());
        return result;
    }

    @Override
    public String toString() {
        return "Platform(" + "credentialsAssumeRole=" + this.getCredentialsAssumeRole() + ", credentialsSecretRef=" + this.getCredentialsSecretRef() + ", privateLink=" + this.getPrivateLink() + ", region=" + this.getRegion() + ", userTags=" + this.getUserTags() + ", additionalProperties=" + this.getAdditionalProperties() + ")";
    }

}
