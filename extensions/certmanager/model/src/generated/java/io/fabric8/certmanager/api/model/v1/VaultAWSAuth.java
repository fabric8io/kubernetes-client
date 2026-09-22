
package io.fabric8.certmanager.api.model.v1;

import java.util.LinkedHashMap;
import java.util.Map;
import javax.annotation.processing.Generated;
import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
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
import tools.jackson.databind.annotation.JsonDeserialize;

/**
 * VaultAWSAuth authenticates with Vault using AWS IAM authentication. See https://www.vaultproject.io/docs/auth/aws for more details.
 */
@JsonDeserialize(using = tools.jackson.databind.ValueDeserializer.None.class)
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "iamRoleArn",
    "mountPath",
    "region",
    "role",
    "serviceAccountRef",
    "vaultHeaderValue"
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
public class VaultAWSAuth implements Editable<VaultAWSAuthBuilder>, KubernetesResource
{

    @JsonProperty("iamRoleArn")
    private String iamRoleArn;
    @JsonProperty("mountPath")
    private String mountPath;
    @JsonProperty("region")
    private String region;
    @JsonProperty("role")
    private String role;
    @JsonProperty("serviceAccountRef")
    private ServiceAccountRef serviceAccountRef;
    @JsonProperty("vaultHeaderValue")
    private String vaultHeaderValue;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new LinkedHashMap<String, Object>();

    /**
     * No args constructor for use in serialization
     */
    public VaultAWSAuth() {
    }

    public VaultAWSAuth(String iamRoleArn, String mountPath, String region, String role, ServiceAccountRef serviceAccountRef, String vaultHeaderValue) {
        super();
        this.iamRoleArn = iamRoleArn;
        this.mountPath = mountPath;
        this.region = region;
        this.role = role;
        this.serviceAccountRef = serviceAccountRef;
        this.vaultHeaderValue = vaultHeaderValue;
    }

    /**
     * The ARN of the AWS IAM role to assume using the Kubernetes service account token. Required when using IRSA (serviceAccountRef is set). This role must have a trust policy that allows the OIDC provider to assume it.
     */
    @JsonProperty("iamRoleArn")
    public String getIamRoleArn() {
        return iamRoleArn;
    }

    /**
     * The ARN of the AWS IAM role to assume using the Kubernetes service account token. Required when using IRSA (serviceAccountRef is set). This role must have a trust policy that allows the OIDC provider to assume it.
     */
    @JsonProperty("iamRoleArn")
    public void setIamRoleArn(String iamRoleArn) {
        this.iamRoleArn = iamRoleArn;
    }

    /**
     * The Vault mountPath here is the mount path to use when authenticating with Vault. For example, setting a value to `/v1/auth/foo`, will use the path `/v1/auth/foo/login` to authenticate with Vault. If unspecified, the default value "/v1/auth/aws" will be used.
     */
    @JsonProperty("mountPath")
    public String getMountPath() {
        return mountPath;
    }

    /**
     * The Vault mountPath here is the mount path to use when authenticating with Vault. For example, setting a value to `/v1/auth/foo`, will use the path `/v1/auth/foo/login` to authenticate with Vault. If unspecified, the default value "/v1/auth/aws" will be used.
     */
    @JsonProperty("mountPath")
    public void setMountPath(String mountPath) {
        this.mountPath = mountPath;
    }

    /**
     * The AWS region to use for authentication. If not specified, the region will be determined from AWS_REGION or AWS_DEFAULT_REGION environment variables, falling back to "us-east-1" if not set.
     */
    @JsonProperty("region")
    public String getRegion() {
        return region;
    }

    /**
     * The AWS region to use for authentication. If not specified, the region will be determined from AWS_REGION or AWS_DEFAULT_REGION environment variables, falling back to "us-east-1" if not set.
     */
    @JsonProperty("region")
    public void setRegion(String region) {
        this.region = region;
    }

    /**
     * A required field containing the Vault Role to assume when authenticating.
     */
    @JsonProperty("role")
    public String getRole() {
        return role;
    }

    /**
     * A required field containing the Vault Role to assume when authenticating.
     */
    @JsonProperty("role")
    public void setRole(String role) {
        this.role = role;
    }

    /**
     * VaultAWSAuth authenticates with Vault using AWS IAM authentication. See https://www.vaultproject.io/docs/auth/aws for more details.
     */
    @JsonProperty("serviceAccountRef")
    public ServiceAccountRef getServiceAccountRef() {
        return serviceAccountRef;
    }

    /**
     * VaultAWSAuth authenticates with Vault using AWS IAM authentication. See https://www.vaultproject.io/docs/auth/aws for more details.
     */
    @JsonProperty("serviceAccountRef")
    public void setServiceAccountRef(ServiceAccountRef serviceAccountRef) {
        this.serviceAccountRef = serviceAccountRef;
    }

    /**
     * The Vault header value to include in the STS signing request. This is used to prevent replay attacks.
     */
    @JsonProperty("vaultHeaderValue")
    public String getVaultHeaderValue() {
        return vaultHeaderValue;
    }

    /**
     * The Vault header value to include in the STS signing request. This is used to prevent replay attacks.
     */
    @JsonProperty("vaultHeaderValue")
    public void setVaultHeaderValue(String vaultHeaderValue) {
        this.vaultHeaderValue = vaultHeaderValue;
    }

    @JsonIgnore
    public VaultAWSAuthBuilder edit() {
        return new VaultAWSAuthBuilder(this);
    }

    @JsonIgnore
    public VaultAWSAuthBuilder toBuilder() {
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
