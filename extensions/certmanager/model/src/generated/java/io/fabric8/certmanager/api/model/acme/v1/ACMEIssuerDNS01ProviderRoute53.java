
package io.fabric8.certmanager.api.model.acme.v1;

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
import io.fabric8.certmanager.api.model.meta.v1.SecretKeySelector;
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
 * ACMEIssuerDNS01ProviderRoute53 is a structure containing the Route 53 configuration for AWS
 */
@JsonDeserialize(using = com.fasterxml.jackson.databind.JsonDeserializer.None.class)
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "accessKeyID",
    "accessKeyIDSecretRef",
    "auth",
    "hostedZoneID",
    "region",
    "role",
    "secretAccessKeySecretRef"
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
public class ACMEIssuerDNS01ProviderRoute53 implements Editable<ACMEIssuerDNS01ProviderRoute53Builder>, KubernetesResource
{

    @JsonProperty("accessKeyID")
    private String accessKeyID;
    @JsonProperty("accessKeyIDSecretRef")
    private SecretKeySelector accessKeyIDSecretRef;
    @JsonProperty("auth")
    private Route53Auth auth;
    @JsonProperty("hostedZoneID")
    private String hostedZoneID;
    @JsonProperty("region")
    private String region;
    @JsonProperty("role")
    private String role;
    @JsonProperty("secretAccessKeySecretRef")
    private SecretKeySelector secretAccessKeySecretRef;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new LinkedHashMap<String, Object>();

    /**
     * No args constructor for use in serialization
     */
    public ACMEIssuerDNS01ProviderRoute53() {
    }

    public ACMEIssuerDNS01ProviderRoute53(String accessKeyID, SecretKeySelector accessKeyIDSecretRef, Route53Auth auth, String hostedZoneID, String region, String role, SecretKeySelector secretAccessKeySecretRef) {
        super();
        this.accessKeyID = accessKeyID;
        this.accessKeyIDSecretRef = accessKeyIDSecretRef;
        this.auth = auth;
        this.hostedZoneID = hostedZoneID;
        this.region = region;
        this.role = role;
        this.secretAccessKeySecretRef = secretAccessKeySecretRef;
    }

    /**
     * The AccessKeyID is used for authentication. Cannot be set when SecretAccessKeyID is set. If neither the Access Key nor Key ID are set, we fall-back to using env vars, shared credentials file or AWS Instance metadata, see: https://docs.aws.amazon.com/sdk-for-go/v1/developer-guide/configuring-sdk.html#specifying-credentials
     */
    @JsonProperty("accessKeyID")
    public String getAccessKeyID() {
        return accessKeyID;
    }

    /**
     * The AccessKeyID is used for authentication. Cannot be set when SecretAccessKeyID is set. If neither the Access Key nor Key ID are set, we fall-back to using env vars, shared credentials file or AWS Instance metadata, see: https://docs.aws.amazon.com/sdk-for-go/v1/developer-guide/configuring-sdk.html#specifying-credentials
     */
    @JsonProperty("accessKeyID")
    public void setAccessKeyID(String accessKeyID) {
        this.accessKeyID = accessKeyID;
    }

    /**
     * ACMEIssuerDNS01ProviderRoute53 is a structure containing the Route 53 configuration for AWS
     */
    @JsonProperty("accessKeyIDSecretRef")
    public SecretKeySelector getAccessKeyIDSecretRef() {
        return accessKeyIDSecretRef;
    }

    /**
     * ACMEIssuerDNS01ProviderRoute53 is a structure containing the Route 53 configuration for AWS
     */
    @JsonProperty("accessKeyIDSecretRef")
    public void setAccessKeyIDSecretRef(SecretKeySelector accessKeyIDSecretRef) {
        this.accessKeyIDSecretRef = accessKeyIDSecretRef;
    }

    /**
     * ACMEIssuerDNS01ProviderRoute53 is a structure containing the Route 53 configuration for AWS
     */
    @JsonProperty("auth")
    public Route53Auth getAuth() {
        return auth;
    }

    /**
     * ACMEIssuerDNS01ProviderRoute53 is a structure containing the Route 53 configuration for AWS
     */
    @JsonProperty("auth")
    public void setAuth(Route53Auth auth) {
        this.auth = auth;
    }

    /**
     * If set, the provider will manage only this zone in Route53 and will not do a lookup using the route53:ListHostedZonesByName api call.
     */
    @JsonProperty("hostedZoneID")
    public String getHostedZoneID() {
        return hostedZoneID;
    }

    /**
     * If set, the provider will manage only this zone in Route53 and will not do a lookup using the route53:ListHostedZonesByName api call.
     */
    @JsonProperty("hostedZoneID")
    public void setHostedZoneID(String hostedZoneID) {
        this.hostedZoneID = hostedZoneID;
    }

    /**
     * Override the AWS region.<br><p> <br><p> Route53 is a global service and does not have regional endpoints but the region specified here (or via environment variables) is used as a hint to help compute the correct AWS credential scope and partition when it connects to Route53. See: - [Amazon Route 53 endpoints and quotas](https://docs.aws.amazon.com/general/latest/gr/r53.html) - [Global services](https://docs.aws.amazon.com/whitepapers/latest/aws-fault-isolation-boundaries/global-services.html)<br><p> <br><p> If you omit this region field, cert-manager will use the region from AWS_REGION and AWS_DEFAULT_REGION environment variables, if they are set in the cert-manager controller Pod.<br><p> <br><p> The `region` field is not needed if you use [IAM Roles for Service Accounts (IRSA)](https://docs.aws.amazon.com/eks/latest/userguide/iam-roles-for-service-accounts.html). Instead an AWS_REGION environment variable is added to the cert-manager controller Pod by: [Amazon EKS Pod Identity Webhook](https://github.com/aws/amazon-eks-pod-identity-webhook). In this case this `region` field value is ignored.<br><p> <br><p> The `region` field is not needed if you use [EKS Pod Identities](https://docs.aws.amazon.com/eks/latest/userguide/pod-identities.html). Instead an AWS_REGION environment variable is added to the cert-manager controller Pod by: [Amazon EKS Pod Identity Agent](https://github.com/aws/eks-pod-identity-agent), In this case this `region` field value is ignored.
     */
    @JsonProperty("region")
    public String getRegion() {
        return region;
    }

    /**
     * Override the AWS region.<br><p> <br><p> Route53 is a global service and does not have regional endpoints but the region specified here (or via environment variables) is used as a hint to help compute the correct AWS credential scope and partition when it connects to Route53. See: - [Amazon Route 53 endpoints and quotas](https://docs.aws.amazon.com/general/latest/gr/r53.html) - [Global services](https://docs.aws.amazon.com/whitepapers/latest/aws-fault-isolation-boundaries/global-services.html)<br><p> <br><p> If you omit this region field, cert-manager will use the region from AWS_REGION and AWS_DEFAULT_REGION environment variables, if they are set in the cert-manager controller Pod.<br><p> <br><p> The `region` field is not needed if you use [IAM Roles for Service Accounts (IRSA)](https://docs.aws.amazon.com/eks/latest/userguide/iam-roles-for-service-accounts.html). Instead an AWS_REGION environment variable is added to the cert-manager controller Pod by: [Amazon EKS Pod Identity Webhook](https://github.com/aws/amazon-eks-pod-identity-webhook). In this case this `region` field value is ignored.<br><p> <br><p> The `region` field is not needed if you use [EKS Pod Identities](https://docs.aws.amazon.com/eks/latest/userguide/pod-identities.html). Instead an AWS_REGION environment variable is added to the cert-manager controller Pod by: [Amazon EKS Pod Identity Agent](https://github.com/aws/eks-pod-identity-agent), In this case this `region` field value is ignored.
     */
    @JsonProperty("region")
    public void setRegion(String region) {
        this.region = region;
    }

    /**
     * Role is a Role ARN which the Route53 provider will assume using either the explicit credentials AccessKeyID/SecretAccessKey or the inferred credentials from environment variables, shared credentials file or AWS Instance metadata
     */
    @JsonProperty("role")
    public String getRole() {
        return role;
    }

    /**
     * Role is a Role ARN which the Route53 provider will assume using either the explicit credentials AccessKeyID/SecretAccessKey or the inferred credentials from environment variables, shared credentials file or AWS Instance metadata
     */
    @JsonProperty("role")
    public void setRole(String role) {
        this.role = role;
    }

    /**
     * ACMEIssuerDNS01ProviderRoute53 is a structure containing the Route 53 configuration for AWS
     */
    @JsonProperty("secretAccessKeySecretRef")
    public SecretKeySelector getSecretAccessKeySecretRef() {
        return secretAccessKeySecretRef;
    }

    /**
     * ACMEIssuerDNS01ProviderRoute53 is a structure containing the Route 53 configuration for AWS
     */
    @JsonProperty("secretAccessKeySecretRef")
    public void setSecretAccessKeySecretRef(SecretKeySelector secretAccessKeySecretRef) {
        this.secretAccessKeySecretRef = secretAccessKeySecretRef;
    }

    @JsonIgnore
    public ACMEIssuerDNS01ProviderRoute53Builder edit() {
        return new ACMEIssuerDNS01ProviderRoute53Builder(this);
    }

    @JsonIgnore
    public ACMEIssuerDNS01ProviderRoute53Builder toBuilder() {
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
