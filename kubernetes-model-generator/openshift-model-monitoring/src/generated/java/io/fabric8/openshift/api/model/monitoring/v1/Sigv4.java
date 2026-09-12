
package io.fabric8.openshift.api.model.monitoring.v1;

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
import io.fabric8.kubernetes.api.model.PersistentVolumeClaim;
import io.fabric8.kubernetes.api.model.PodTemplateSpec;
import io.fabric8.kubernetes.api.model.ResourceRequirements;
import io.fabric8.kubernetes.api.model.SecretKeySelector;
import io.fabric8.kubernetes.api.model.Volume;
import io.fabric8.kubernetes.api.model.VolumeMount;
import io.sundr.builder.annotations.Buildable;
import io.sundr.builder.annotations.BuildableReference;

/**
 * Sigv4 defines AWS's Signature Verification 4 signing process to sign requests.
 */
@JsonDeserialize(using = com.fasterxml.jackson.databind.JsonDeserializer.None.class)
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "accessKey",
    "externalId",
    "profile",
    "region",
    "roleArn",
    "secretKey",
    "useFIPSSTSEndpoint"
})
@Buildable(editableEnabled = false, validationEnabled = false, generateBuilderPackage = false, lazyCollectionInitEnabled = false, builderPackage = "io.fabric8.kubernetes.api.builder", refs = {
    @BuildableReference(ObjectMeta.class),
    @BuildableReference(LabelSelector.class),
    @BuildableReference(Container.class),
    @BuildableReference(PodTemplateSpec.class),
    @BuildableReference(ResourceRequirements.class),
    @BuildableReference(IntOrString.class),
    @BuildableReference(io.fabric8.kubernetes.api.model.ObjectReference.class),
    @BuildableReference(LocalObjectReference.class),
    @BuildableReference(PersistentVolumeClaim.class),
    @BuildableReference(EnvVar.class),
    @BuildableReference(ContainerPort.class),
    @BuildableReference(Volume.class),
    @BuildableReference(VolumeMount.class)
})
@Generated("io.fabric8.kubernetes.schema.generator.model.ModelGenerator")
public class Sigv4 implements Editable<Sigv4Builder>, KubernetesResource
{

    @JsonProperty("accessKey")
    private SecretKeySelector accessKey;
    @JsonProperty("externalId")
    private String externalId;
    @JsonProperty("profile")
    private String profile;
    @JsonProperty("region")
    private String region;
    @JsonProperty("roleArn")
    private String roleArn;
    @JsonProperty("secretKey")
    private SecretKeySelector secretKey;
    @JsonProperty("useFIPSSTSEndpoint")
    private Boolean useFIPSSTSEndpoint;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new LinkedHashMap<String, Object>();

    /**
     * No args constructor for use in serialization
     */
    public Sigv4() {
    }

    public Sigv4(SecretKeySelector accessKey, String externalId, String profile, String region, String roleArn, SecretKeySelector secretKey, Boolean useFIPSSTSEndpoint) {
        super();
        this.accessKey = accessKey;
        this.externalId = externalId;
        this.profile = profile;
        this.region = region;
        this.roleArn = roleArn;
        this.secretKey = secretKey;
        this.useFIPSSTSEndpoint = useFIPSSTSEndpoint;
    }

    /**
     * Sigv4 defines AWS's Signature Verification 4 signing process to sign requests.
     */
    @JsonProperty("accessKey")
    public SecretKeySelector getAccessKey() {
        return accessKey;
    }

    /**
     * Sigv4 defines AWS's Signature Verification 4 signing process to sign requests.
     */
    @JsonProperty("accessKey")
    public void setAccessKey(SecretKeySelector accessKey) {
        this.accessKey = accessKey;
    }

    /**
     * externalId defines the external ID used when assuming an AWS role. Can only be used with roleArn. It requires Prometheus &gt;= v3.11.0 or Alertmanager &gt;= v0.33.0. Currently not supported by Thanos.
     */
    @JsonProperty("externalId")
    public String getExternalId() {
        return externalId;
    }

    /**
     * externalId defines the external ID used when assuming an AWS role. Can only be used with roleArn. It requires Prometheus &gt;= v3.11.0 or Alertmanager &gt;= v0.33.0. Currently not supported by Thanos.
     */
    @JsonProperty("externalId")
    public void setExternalId(String externalId) {
        this.externalId = externalId;
    }

    /**
     * profile defines the named AWS profile used to authenticate.
     */
    @JsonProperty("profile")
    public String getProfile() {
        return profile;
    }

    /**
     * profile defines the named AWS profile used to authenticate.
     */
    @JsonProperty("profile")
    public void setProfile(String profile) {
        this.profile = profile;
    }

    /**
     * region defines the AWS region. If blank, the region from the default credentials chain used.
     */
    @JsonProperty("region")
    public String getRegion() {
        return region;
    }

    /**
     * region defines the AWS region. If blank, the region from the default credentials chain used.
     */
    @JsonProperty("region")
    public void setRegion(String region) {
        this.region = region;
    }

    /**
     * roleArn defines the named AWS profile used to authenticate.
     */
    @JsonProperty("roleArn")
    public String getRoleArn() {
        return roleArn;
    }

    /**
     * roleArn defines the named AWS profile used to authenticate.
     */
    @JsonProperty("roleArn")
    public void setRoleArn(String roleArn) {
        this.roleArn = roleArn;
    }

    /**
     * Sigv4 defines AWS's Signature Verification 4 signing process to sign requests.
     */
    @JsonProperty("secretKey")
    public SecretKeySelector getSecretKey() {
        return secretKey;
    }

    /**
     * Sigv4 defines AWS's Signature Verification 4 signing process to sign requests.
     */
    @JsonProperty("secretKey")
    public void setSecretKey(SecretKeySelector secretKey) {
        this.secretKey = secretKey;
    }

    /**
     * useFIPSSTSEndpoint defines the FIPS mode for the AWS STS endpoint. It requires Prometheus &gt;= v2.54.0.
     */
    @JsonProperty("useFIPSSTSEndpoint")
    public Boolean getUseFIPSSTSEndpoint() {
        return useFIPSSTSEndpoint;
    }

    /**
     * useFIPSSTSEndpoint defines the FIPS mode for the AWS STS endpoint. It requires Prometheus &gt;= v2.54.0.
     */
    @JsonProperty("useFIPSSTSEndpoint")
    public void setUseFIPSSTSEndpoint(Boolean useFIPSSTSEndpoint) {
        this.useFIPSSTSEndpoint = useFIPSSTSEndpoint;
    }

    @JsonIgnore
    public Sigv4Builder edit() {
        return new Sigv4Builder(this);
    }

    @JsonIgnore
    public Sigv4Builder toBuilder() {
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
        if (!(o instanceof Sigv4)) {
            return false;
        }
        Sigv4 other = (Sigv4) o;
        if (!other.canEqual(this)) {
            return false;
        }
        Object this$accessKey = this.getAccessKey();
        Object other$accessKey = other.getAccessKey();
        if (this$accessKey == null ? other$accessKey != null : !this$accessKey.equals(other$accessKey)) {
            return false;
        }
        Object this$externalId = this.getExternalId();
        Object other$externalId = other.getExternalId();
        if (this$externalId == null ? other$externalId != null : !this$externalId.equals(other$externalId)) {
            return false;
        }
        Object this$profile = this.getProfile();
        Object other$profile = other.getProfile();
        if (this$profile == null ? other$profile != null : !this$profile.equals(other$profile)) {
            return false;
        }
        Object this$region = this.getRegion();
        Object other$region = other.getRegion();
        if (this$region == null ? other$region != null : !this$region.equals(other$region)) {
            return false;
        }
        Object this$roleArn = this.getRoleArn();
        Object other$roleArn = other.getRoleArn();
        if (this$roleArn == null ? other$roleArn != null : !this$roleArn.equals(other$roleArn)) {
            return false;
        }
        Object this$secretKey = this.getSecretKey();
        Object other$secretKey = other.getSecretKey();
        if (this$secretKey == null ? other$secretKey != null : !this$secretKey.equals(other$secretKey)) {
            return false;
        }
        Object this$useFIPSSTSEndpoint = this.getUseFIPSSTSEndpoint();
        Object other$useFIPSSTSEndpoint = other.getUseFIPSSTSEndpoint();
        if (this$useFIPSSTSEndpoint == null ? other$useFIPSSTSEndpoint != null : !this$useFIPSSTSEndpoint.equals(other$useFIPSSTSEndpoint)) {
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
        return other instanceof Sigv4;
    }

    @Override
    public int hashCode() {
        final int prime = 59;
        int result = 1;
        Object $accessKey = this.getAccessKey();
        result = result * prime + ($accessKey == null ? 43 : $accessKey.hashCode());
        Object $externalId = this.getExternalId();
        result = result * prime + ($externalId == null ? 43 : $externalId.hashCode());
        Object $profile = this.getProfile();
        result = result * prime + ($profile == null ? 43 : $profile.hashCode());
        Object $region = this.getRegion();
        result = result * prime + ($region == null ? 43 : $region.hashCode());
        Object $roleArn = this.getRoleArn();
        result = result * prime + ($roleArn == null ? 43 : $roleArn.hashCode());
        Object $secretKey = this.getSecretKey();
        result = result * prime + ($secretKey == null ? 43 : $secretKey.hashCode());
        Object $useFIPSSTSEndpoint = this.getUseFIPSSTSEndpoint();
        result = result * prime + ($useFIPSSTSEndpoint == null ? 43 : $useFIPSSTSEndpoint.hashCode());
        Object $additionalProperties = this.getAdditionalProperties();
        result = result * prime + ($additionalProperties == null ? 43 : $additionalProperties.hashCode());
        return result;
    }

    @Override
    public String toString() {
        return "Sigv4(" + "accessKey=" + this.getAccessKey() + ", externalId=" + this.getExternalId() + ", profile=" + this.getProfile() + ", region=" + this.getRegion() + ", roleArn=" + this.getRoleArn() + ", secretKey=" + this.getSecretKey() + ", useFIPSSTSEndpoint=" + this.getUseFIPSSTSEndpoint() + ", additionalProperties=" + this.getAdditionalProperties() + ")";
    }

}
