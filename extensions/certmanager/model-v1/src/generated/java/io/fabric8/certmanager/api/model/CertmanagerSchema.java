
package io.fabric8.certmanager.api.model;

import javax.annotation.Generated;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import io.fabric8.certmanager.api.model.acme.v1.ACMEAuthorization;
import io.fabric8.certmanager.api.model.acme.v1.ACMEChallenge;
import io.fabric8.certmanager.api.model.acme.v1.ACMEChallengeSolver;
import io.fabric8.certmanager.api.model.acme.v1.ACMEChallengeSolverDNS01;
import io.fabric8.certmanager.api.model.acme.v1.ACMEChallengeSolverHTTP01;
import io.fabric8.certmanager.api.model.acme.v1.ACMEChallengeSolverHTTP01GatewayHTTPRoute;
import io.fabric8.certmanager.api.model.acme.v1.ACMEChallengeSolverHTTP01Ingress;
import io.fabric8.certmanager.api.model.acme.v1.ACMEChallengeSolverHTTP01IngressObjectMeta;
import io.fabric8.certmanager.api.model.acme.v1.ACMEChallengeSolverHTTP01IngressPodObjectMeta;
import io.fabric8.certmanager.api.model.acme.v1.ACMEChallengeSolverHTTP01IngressPodSpec;
import io.fabric8.certmanager.api.model.acme.v1.ACMEChallengeSolverHTTP01IngressPodTemplate;
import io.fabric8.certmanager.api.model.acme.v1.ACMEChallengeSolverHTTP01IngressTemplate;
import io.fabric8.certmanager.api.model.acme.v1.ACMEExternalAccountBinding;
import io.fabric8.certmanager.api.model.acme.v1.ACMEIssuer;
import io.fabric8.certmanager.api.model.acme.v1.ACMEIssuerDNS01ProviderAcmeDNS;
import io.fabric8.certmanager.api.model.acme.v1.ACMEIssuerDNS01ProviderAkamai;
import io.fabric8.certmanager.api.model.acme.v1.ACMEIssuerDNS01ProviderAzureDNS;
import io.fabric8.certmanager.api.model.acme.v1.ACMEIssuerDNS01ProviderCloudDNS;
import io.fabric8.certmanager.api.model.acme.v1.ACMEIssuerDNS01ProviderCloudflare;
import io.fabric8.certmanager.api.model.acme.v1.ACMEIssuerDNS01ProviderDigitalOcean;
import io.fabric8.certmanager.api.model.acme.v1.ACMEIssuerDNS01ProviderRFC2136;
import io.fabric8.certmanager.api.model.acme.v1.ACMEIssuerDNS01ProviderRoute53;
import io.fabric8.certmanager.api.model.acme.v1.ACMEIssuerDNS01ProviderWebhook;
import io.fabric8.certmanager.api.model.acme.v1.ACMEIssuerStatus;
import io.fabric8.certmanager.api.model.acme.v1.AzureManagedIdentity;
import io.fabric8.certmanager.api.model.acme.v1.CertificateDNSNameSelector;
import io.fabric8.certmanager.api.model.acme.v1.Challenge;
import io.fabric8.certmanager.api.model.acme.v1.ChallengeList;
import io.fabric8.certmanager.api.model.acme.v1.ChallengeSpec;
import io.fabric8.certmanager.api.model.acme.v1.ChallengeStatus;
import io.fabric8.certmanager.api.model.acme.v1.Order;
import io.fabric8.certmanager.api.model.acme.v1.OrderList;
import io.fabric8.certmanager.api.model.acme.v1.OrderSpec;
import io.fabric8.certmanager.api.model.acme.v1.OrderStatus;
import io.fabric8.certmanager.api.model.meta.v1.SecretKeySelector;
import io.fabric8.certmanager.api.model.v1.CAIssuer;
import io.fabric8.certmanager.api.model.v1.Certificate;
import io.fabric8.certmanager.api.model.v1.CertificateAdditionalOutputFormat;
import io.fabric8.certmanager.api.model.v1.CertificateCondition;
import io.fabric8.certmanager.api.model.v1.CertificateKeystores;
import io.fabric8.certmanager.api.model.v1.CertificateList;
import io.fabric8.certmanager.api.model.v1.CertificatePrivateKey;
import io.fabric8.certmanager.api.model.v1.CertificateRequest;
import io.fabric8.certmanager.api.model.v1.CertificateRequestCondition;
import io.fabric8.certmanager.api.model.v1.CertificateRequestList;
import io.fabric8.certmanager.api.model.v1.CertificateRequestSpec;
import io.fabric8.certmanager.api.model.v1.CertificateRequestStatus;
import io.fabric8.certmanager.api.model.v1.CertificateSecretTemplate;
import io.fabric8.certmanager.api.model.v1.CertificateSpec;
import io.fabric8.certmanager.api.model.v1.CertificateStatus;
import io.fabric8.certmanager.api.model.v1.ClusterIssuer;
import io.fabric8.certmanager.api.model.v1.ClusterIssuerList;
import io.fabric8.certmanager.api.model.v1.Issuer;
import io.fabric8.certmanager.api.model.v1.IssuerCondition;
import io.fabric8.certmanager.api.model.v1.IssuerList;
import io.fabric8.certmanager.api.model.v1.IssuerSpec;
import io.fabric8.certmanager.api.model.v1.IssuerStatus;
import io.fabric8.certmanager.api.model.v1.JKSKeystore;
import io.fabric8.certmanager.api.model.v1.PKCS12Keystore;
import io.fabric8.certmanager.api.model.v1.SelfSignedIssuer;
import io.fabric8.certmanager.api.model.v1.VaultAppRole;
import io.fabric8.certmanager.api.model.v1.VaultAuth;
import io.fabric8.certmanager.api.model.v1.VaultIssuer;
import io.fabric8.certmanager.api.model.v1.VaultKubernetesAuth;
import io.fabric8.certmanager.api.model.v1.VenafiCloud;
import io.fabric8.certmanager.api.model.v1.VenafiIssuer;
import io.fabric8.certmanager.api.model.v1.VenafiTPP;
import io.fabric8.certmanager.api.model.v1.X509Subject;
import io.fabric8.kubernetes.api.model.Container;
import io.fabric8.kubernetes.api.model.ContainerPort;
import io.fabric8.kubernetes.api.model.EnvVar;
import io.fabric8.kubernetes.api.model.IntOrString;
import io.fabric8.kubernetes.api.model.LabelSelector;
import io.fabric8.kubernetes.api.model.ObjectMeta;
import io.fabric8.kubernetes.api.model.PersistentVolumeClaim;
import io.fabric8.kubernetes.api.model.PodTemplateSpec;
import io.fabric8.kubernetes.api.model.ResourceRequirements;
import io.fabric8.kubernetes.api.model.Volume;
import io.fabric8.kubernetes.api.model.VolumeMount;
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
    "github_com_cert-manager_cert-manager_pkg_apis_acme_v1_ACMEAuthorization",
    "github_com_cert-manager_cert-manager_pkg_apis_acme_v1_ACMEChallenge",
    "github_com_cert-manager_cert-manager_pkg_apis_acme_v1_ACMEChallengeSolver",
    "github_com_cert-manager_cert-manager_pkg_apis_acme_v1_ACMEChallengeSolverDNS01",
    "github_com_cert-manager_cert-manager_pkg_apis_acme_v1_ACMEChallengeSolverHTTP01",
    "github_com_cert-manager_cert-manager_pkg_apis_acme_v1_ACMEChallengeSolverHTTP01GatewayHTTPRoute",
    "github_com_cert-manager_cert-manager_pkg_apis_acme_v1_ACMEChallengeSolverHTTP01Ingress",
    "github_com_cert-manager_cert-manager_pkg_apis_acme_v1_ACMEChallengeSolverHTTP01IngressObjectMeta",
    "github_com_cert-manager_cert-manager_pkg_apis_acme_v1_ACMEChallengeSolverHTTP01IngressPodObjectMeta",
    "github_com_cert-manager_cert-manager_pkg_apis_acme_v1_ACMEChallengeSolverHTTP01IngressPodSpec",
    "github_com_cert-manager_cert-manager_pkg_apis_acme_v1_ACMEChallengeSolverHTTP01IngressPodTemplate",
    "github_com_cert-manager_cert-manager_pkg_apis_acme_v1_ACMEChallengeSolverHTTP01IngressTemplate",
    "github_com_cert-manager_cert-manager_pkg_apis_acme_v1_ACMEExternalAccountBinding",
    "github_com_cert-manager_cert-manager_pkg_apis_acme_v1_ACMEIssuer",
    "github_com_cert-manager_cert-manager_pkg_apis_acme_v1_ACMEIssuerDNS01ProviderAcmeDNS",
    "github_com_cert-manager_cert-manager_pkg_apis_acme_v1_ACMEIssuerDNS01ProviderAkamai",
    "github_com_cert-manager_cert-manager_pkg_apis_acme_v1_ACMEIssuerDNS01ProviderAzureDNS",
    "github_com_cert-manager_cert-manager_pkg_apis_acme_v1_ACMEIssuerDNS01ProviderCloudDNS",
    "github_com_cert-manager_cert-manager_pkg_apis_acme_v1_ACMEIssuerDNS01ProviderCloudflare",
    "github_com_cert-manager_cert-manager_pkg_apis_acme_v1_ACMEIssuerDNS01ProviderDigitalOcean",
    "github_com_cert-manager_cert-manager_pkg_apis_acme_v1_ACMEIssuerDNS01ProviderRFC2136",
    "github_com_cert-manager_cert-manager_pkg_apis_acme_v1_ACMEIssuerDNS01ProviderRoute53",
    "github_com_cert-manager_cert-manager_pkg_apis_acme_v1_ACMEIssuerDNS01ProviderWebhook",
    "github_com_cert-manager_cert-manager_pkg_apis_acme_v1_ACMEIssuerStatus",
    "github_com_cert-manager_cert-manager_pkg_apis_acme_v1_AzureManagedIdentity",
    "github_com_cert-manager_cert-manager_pkg_apis_acme_v1_CertificateDNSNameSelector",
    "github_com_cert-manager_cert-manager_pkg_apis_acme_v1_Challenge",
    "github_com_cert-manager_cert-manager_pkg_apis_acme_v1_ChallengeList",
    "github_com_cert-manager_cert-manager_pkg_apis_acme_v1_ChallengeSpec",
    "github_com_cert-manager_cert-manager_pkg_apis_acme_v1_ChallengeStatus",
    "github_com_cert-manager_cert-manager_pkg_apis_acme_v1_Order",
    "github_com_cert-manager_cert-manager_pkg_apis_acme_v1_OrderList",
    "github_com_cert-manager_cert-manager_pkg_apis_acme_v1_OrderSpec",
    "github_com_cert-manager_cert-manager_pkg_apis_acme_v1_OrderStatus",
    "github_com_cert-manager_cert-manager_pkg_apis_certmanager_v1_CAIssuer",
    "github_com_cert-manager_cert-manager_pkg_apis_certmanager_v1_Certificate",
    "github_com_cert-manager_cert-manager_pkg_apis_certmanager_v1_CertificateAdditionalOutputFormat",
    "github_com_cert-manager_cert-manager_pkg_apis_certmanager_v1_CertificateCondition",
    "github_com_cert-manager_cert-manager_pkg_apis_certmanager_v1_CertificateKeystores",
    "github_com_cert-manager_cert-manager_pkg_apis_certmanager_v1_CertificateList",
    "github_com_cert-manager_cert-manager_pkg_apis_certmanager_v1_CertificatePrivateKey",
    "github_com_cert-manager_cert-manager_pkg_apis_certmanager_v1_CertificateRequest",
    "github_com_cert-manager_cert-manager_pkg_apis_certmanager_v1_CertificateRequestCondition",
    "github_com_cert-manager_cert-manager_pkg_apis_certmanager_v1_CertificateRequestList",
    "github_com_cert-manager_cert-manager_pkg_apis_certmanager_v1_CertificateRequestSpec",
    "github_com_cert-manager_cert-manager_pkg_apis_certmanager_v1_CertificateRequestStatus",
    "github_com_cert-manager_cert-manager_pkg_apis_certmanager_v1_CertificateSecretTemplate",
    "github_com_cert-manager_cert-manager_pkg_apis_certmanager_v1_CertificateSpec",
    "github_com_cert-manager_cert-manager_pkg_apis_certmanager_v1_CertificateStatus",
    "github_com_cert-manager_cert-manager_pkg_apis_certmanager_v1_ClusterIssuer",
    "github_com_cert-manager_cert-manager_pkg_apis_certmanager_v1_ClusterIssuerList",
    "github_com_cert-manager_cert-manager_pkg_apis_certmanager_v1_Issuer",
    "github_com_cert-manager_cert-manager_pkg_apis_certmanager_v1_IssuerCondition",
    "github_com_cert-manager_cert-manager_pkg_apis_certmanager_v1_IssuerList",
    "github_com_cert-manager_cert-manager_pkg_apis_certmanager_v1_IssuerSpec",
    "github_com_cert-manager_cert-manager_pkg_apis_certmanager_v1_IssuerStatus",
    "github_com_cert-manager_cert-manager_pkg_apis_certmanager_v1_JKSKeystore",
    "github_com_cert-manager_cert-manager_pkg_apis_certmanager_v1_PKCS12Keystore",
    "github_com_cert-manager_cert-manager_pkg_apis_certmanager_v1_SelfSignedIssuer",
    "github_com_cert-manager_cert-manager_pkg_apis_certmanager_v1_VaultAppRole",
    "github_com_cert-manager_cert-manager_pkg_apis_certmanager_v1_VaultAuth",
    "github_com_cert-manager_cert-manager_pkg_apis_certmanager_v1_VaultIssuer",
    "github_com_cert-manager_cert-manager_pkg_apis_certmanager_v1_VaultKubernetesAuth",
    "github_com_cert-manager_cert-manager_pkg_apis_certmanager_v1_VenafiCloud",
    "github_com_cert-manager_cert-manager_pkg_apis_certmanager_v1_VenafiIssuer",
    "github_com_cert-manager_cert-manager_pkg_apis_certmanager_v1_VenafiTPP",
    "github_com_cert-manager_cert-manager_pkg_apis_certmanager_v1_X509Subject",
    "github_com_cert-manager_cert-manager_pkg_apis_meta_v1_LocalObjectReference",
    "github_com_cert-manager_cert-manager_pkg_apis_meta_v1_ObjectReference",
    "github_com_cert-manager_cert-manager_pkg_apis_meta_v1_SecretKeySelector"
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
    @BuildableReference(io.fabric8.kubernetes.api.model.ObjectReference.class),
    @BuildableReference(io.fabric8.kubernetes.api.model.LocalObjectReference.class),
    @BuildableReference(PersistentVolumeClaim.class),
    @BuildableReference(EnvVar.class),
    @BuildableReference(ContainerPort.class),
    @BuildableReference(Volume.class),
    @BuildableReference(VolumeMount.class)
})
@Generated("jsonschema2pojo")
public class CertmanagerSchema {

    @JsonProperty("github_com_cert-manager_cert-manager_pkg_apis_acme_v1_ACMEAuthorization")
    private ACMEAuthorization githubComCertManagerCertManagerPkgApisAcmeV1ACMEAuthorization;
    @JsonProperty("github_com_cert-manager_cert-manager_pkg_apis_acme_v1_ACMEChallenge")
    private ACMEChallenge githubComCertManagerCertManagerPkgApisAcmeV1ACMEChallenge;
    @JsonProperty("github_com_cert-manager_cert-manager_pkg_apis_acme_v1_ACMEChallengeSolver")
    private ACMEChallengeSolver githubComCertManagerCertManagerPkgApisAcmeV1ACMEChallengeSolver;
    @JsonProperty("github_com_cert-manager_cert-manager_pkg_apis_acme_v1_ACMEChallengeSolverDNS01")
    private ACMEChallengeSolverDNS01 githubComCertManagerCertManagerPkgApisAcmeV1ACMEChallengeSolverDNS01;
    @JsonProperty("github_com_cert-manager_cert-manager_pkg_apis_acme_v1_ACMEChallengeSolverHTTP01")
    private ACMEChallengeSolverHTTP01 githubComCertManagerCertManagerPkgApisAcmeV1ACMEChallengeSolverHTTP01;
    @JsonProperty("github_com_cert-manager_cert-manager_pkg_apis_acme_v1_ACMEChallengeSolverHTTP01GatewayHTTPRoute")
    private ACMEChallengeSolverHTTP01GatewayHTTPRoute githubComCertManagerCertManagerPkgApisAcmeV1ACMEChallengeSolverHTTP01GatewayHTTPRoute;
    @JsonProperty("github_com_cert-manager_cert-manager_pkg_apis_acme_v1_ACMEChallengeSolverHTTP01Ingress")
    private ACMEChallengeSolverHTTP01Ingress githubComCertManagerCertManagerPkgApisAcmeV1ACMEChallengeSolverHTTP01Ingress;
    @JsonProperty("github_com_cert-manager_cert-manager_pkg_apis_acme_v1_ACMEChallengeSolverHTTP01IngressObjectMeta")
    private ACMEChallengeSolverHTTP01IngressObjectMeta githubComCertManagerCertManagerPkgApisAcmeV1ACMEChallengeSolverHTTP01IngressObjectMeta;
    @JsonProperty("github_com_cert-manager_cert-manager_pkg_apis_acme_v1_ACMEChallengeSolverHTTP01IngressPodObjectMeta")
    private ACMEChallengeSolverHTTP01IngressPodObjectMeta githubComCertManagerCertManagerPkgApisAcmeV1ACMEChallengeSolverHTTP01IngressPodObjectMeta;
    @JsonProperty("github_com_cert-manager_cert-manager_pkg_apis_acme_v1_ACMEChallengeSolverHTTP01IngressPodSpec")
    private ACMEChallengeSolverHTTP01IngressPodSpec githubComCertManagerCertManagerPkgApisAcmeV1ACMEChallengeSolverHTTP01IngressPodSpec;
    @JsonProperty("github_com_cert-manager_cert-manager_pkg_apis_acme_v1_ACMEChallengeSolverHTTP01IngressPodTemplate")
    private ACMEChallengeSolverHTTP01IngressPodTemplate githubComCertManagerCertManagerPkgApisAcmeV1ACMEChallengeSolverHTTP01IngressPodTemplate;
    @JsonProperty("github_com_cert-manager_cert-manager_pkg_apis_acme_v1_ACMEChallengeSolverHTTP01IngressTemplate")
    private ACMEChallengeSolverHTTP01IngressTemplate githubComCertManagerCertManagerPkgApisAcmeV1ACMEChallengeSolverHTTP01IngressTemplate;
    @JsonProperty("github_com_cert-manager_cert-manager_pkg_apis_acme_v1_ACMEExternalAccountBinding")
    private ACMEExternalAccountBinding githubComCertManagerCertManagerPkgApisAcmeV1ACMEExternalAccountBinding;
    @JsonProperty("github_com_cert-manager_cert-manager_pkg_apis_acme_v1_ACMEIssuer")
    private ACMEIssuer githubComCertManagerCertManagerPkgApisAcmeV1ACMEIssuer;
    @JsonProperty("github_com_cert-manager_cert-manager_pkg_apis_acme_v1_ACMEIssuerDNS01ProviderAcmeDNS")
    private ACMEIssuerDNS01ProviderAcmeDNS githubComCertManagerCertManagerPkgApisAcmeV1ACMEIssuerDNS01ProviderAcmeDNS;
    @JsonProperty("github_com_cert-manager_cert-manager_pkg_apis_acme_v1_ACMEIssuerDNS01ProviderAkamai")
    private ACMEIssuerDNS01ProviderAkamai githubComCertManagerCertManagerPkgApisAcmeV1ACMEIssuerDNS01ProviderAkamai;
    @JsonProperty("github_com_cert-manager_cert-manager_pkg_apis_acme_v1_ACMEIssuerDNS01ProviderAzureDNS")
    private ACMEIssuerDNS01ProviderAzureDNS githubComCertManagerCertManagerPkgApisAcmeV1ACMEIssuerDNS01ProviderAzureDNS;
    @JsonProperty("github_com_cert-manager_cert-manager_pkg_apis_acme_v1_ACMEIssuerDNS01ProviderCloudDNS")
    private ACMEIssuerDNS01ProviderCloudDNS githubComCertManagerCertManagerPkgApisAcmeV1ACMEIssuerDNS01ProviderCloudDNS;
    @JsonProperty("github_com_cert-manager_cert-manager_pkg_apis_acme_v1_ACMEIssuerDNS01ProviderCloudflare")
    private ACMEIssuerDNS01ProviderCloudflare githubComCertManagerCertManagerPkgApisAcmeV1ACMEIssuerDNS01ProviderCloudflare;
    @JsonProperty("github_com_cert-manager_cert-manager_pkg_apis_acme_v1_ACMEIssuerDNS01ProviderDigitalOcean")
    private ACMEIssuerDNS01ProviderDigitalOcean githubComCertManagerCertManagerPkgApisAcmeV1ACMEIssuerDNS01ProviderDigitalOcean;
    @JsonProperty("github_com_cert-manager_cert-manager_pkg_apis_acme_v1_ACMEIssuerDNS01ProviderRFC2136")
    private ACMEIssuerDNS01ProviderRFC2136 githubComCertManagerCertManagerPkgApisAcmeV1ACMEIssuerDNS01ProviderRFC2136;
    @JsonProperty("github_com_cert-manager_cert-manager_pkg_apis_acme_v1_ACMEIssuerDNS01ProviderRoute53")
    private ACMEIssuerDNS01ProviderRoute53 githubComCertManagerCertManagerPkgApisAcmeV1ACMEIssuerDNS01ProviderRoute53;
    @JsonProperty("github_com_cert-manager_cert-manager_pkg_apis_acme_v1_ACMEIssuerDNS01ProviderWebhook")
    private ACMEIssuerDNS01ProviderWebhook githubComCertManagerCertManagerPkgApisAcmeV1ACMEIssuerDNS01ProviderWebhook;
    @JsonProperty("github_com_cert-manager_cert-manager_pkg_apis_acme_v1_ACMEIssuerStatus")
    private ACMEIssuerStatus githubComCertManagerCertManagerPkgApisAcmeV1ACMEIssuerStatus;
    @JsonProperty("github_com_cert-manager_cert-manager_pkg_apis_acme_v1_AzureManagedIdentity")
    private AzureManagedIdentity githubComCertManagerCertManagerPkgApisAcmeV1AzureManagedIdentity;
    @JsonProperty("github_com_cert-manager_cert-manager_pkg_apis_acme_v1_CertificateDNSNameSelector")
    private CertificateDNSNameSelector githubComCertManagerCertManagerPkgApisAcmeV1CertificateDNSNameSelector;
    @JsonProperty("github_com_cert-manager_cert-manager_pkg_apis_acme_v1_Challenge")
    private Challenge githubComCertManagerCertManagerPkgApisAcmeV1Challenge;
    @JsonProperty("github_com_cert-manager_cert-manager_pkg_apis_acme_v1_ChallengeList")
    private ChallengeList githubComCertManagerCertManagerPkgApisAcmeV1ChallengeList;
    @JsonProperty("github_com_cert-manager_cert-manager_pkg_apis_acme_v1_ChallengeSpec")
    private ChallengeSpec githubComCertManagerCertManagerPkgApisAcmeV1ChallengeSpec;
    @JsonProperty("github_com_cert-manager_cert-manager_pkg_apis_acme_v1_ChallengeStatus")
    private ChallengeStatus githubComCertManagerCertManagerPkgApisAcmeV1ChallengeStatus;
    @JsonProperty("github_com_cert-manager_cert-manager_pkg_apis_acme_v1_Order")
    private Order githubComCertManagerCertManagerPkgApisAcmeV1Order;
    @JsonProperty("github_com_cert-manager_cert-manager_pkg_apis_acme_v1_OrderList")
    private OrderList githubComCertManagerCertManagerPkgApisAcmeV1OrderList;
    @JsonProperty("github_com_cert-manager_cert-manager_pkg_apis_acme_v1_OrderSpec")
    private OrderSpec githubComCertManagerCertManagerPkgApisAcmeV1OrderSpec;
    @JsonProperty("github_com_cert-manager_cert-manager_pkg_apis_acme_v1_OrderStatus")
    private OrderStatus githubComCertManagerCertManagerPkgApisAcmeV1OrderStatus;
    @JsonProperty("github_com_cert-manager_cert-manager_pkg_apis_certmanager_v1_CAIssuer")
    private CAIssuer githubComCertManagerCertManagerPkgApisCertmanagerV1CAIssuer;
    @JsonProperty("github_com_cert-manager_cert-manager_pkg_apis_certmanager_v1_Certificate")
    private Certificate githubComCertManagerCertManagerPkgApisCertmanagerV1Certificate;
    @JsonProperty("github_com_cert-manager_cert-manager_pkg_apis_certmanager_v1_CertificateAdditionalOutputFormat")
    private CertificateAdditionalOutputFormat githubComCertManagerCertManagerPkgApisCertmanagerV1CertificateAdditionalOutputFormat;
    @JsonProperty("github_com_cert-manager_cert-manager_pkg_apis_certmanager_v1_CertificateCondition")
    private CertificateCondition githubComCertManagerCertManagerPkgApisCertmanagerV1CertificateCondition;
    @JsonProperty("github_com_cert-manager_cert-manager_pkg_apis_certmanager_v1_CertificateKeystores")
    private CertificateKeystores githubComCertManagerCertManagerPkgApisCertmanagerV1CertificateKeystores;
    @JsonProperty("github_com_cert-manager_cert-manager_pkg_apis_certmanager_v1_CertificateList")
    private CertificateList githubComCertManagerCertManagerPkgApisCertmanagerV1CertificateList;
    @JsonProperty("github_com_cert-manager_cert-manager_pkg_apis_certmanager_v1_CertificatePrivateKey")
    private CertificatePrivateKey githubComCertManagerCertManagerPkgApisCertmanagerV1CertificatePrivateKey;
    @JsonProperty("github_com_cert-manager_cert-manager_pkg_apis_certmanager_v1_CertificateRequest")
    private CertificateRequest githubComCertManagerCertManagerPkgApisCertmanagerV1CertificateRequest;
    @JsonProperty("github_com_cert-manager_cert-manager_pkg_apis_certmanager_v1_CertificateRequestCondition")
    private CertificateRequestCondition githubComCertManagerCertManagerPkgApisCertmanagerV1CertificateRequestCondition;
    @JsonProperty("github_com_cert-manager_cert-manager_pkg_apis_certmanager_v1_CertificateRequestList")
    private CertificateRequestList githubComCertManagerCertManagerPkgApisCertmanagerV1CertificateRequestList;
    @JsonProperty("github_com_cert-manager_cert-manager_pkg_apis_certmanager_v1_CertificateRequestSpec")
    private CertificateRequestSpec githubComCertManagerCertManagerPkgApisCertmanagerV1CertificateRequestSpec;
    @JsonProperty("github_com_cert-manager_cert-manager_pkg_apis_certmanager_v1_CertificateRequestStatus")
    private CertificateRequestStatus githubComCertManagerCertManagerPkgApisCertmanagerV1CertificateRequestStatus;
    @JsonProperty("github_com_cert-manager_cert-manager_pkg_apis_certmanager_v1_CertificateSecretTemplate")
    private CertificateSecretTemplate githubComCertManagerCertManagerPkgApisCertmanagerV1CertificateSecretTemplate;
    @JsonProperty("github_com_cert-manager_cert-manager_pkg_apis_certmanager_v1_CertificateSpec")
    private CertificateSpec githubComCertManagerCertManagerPkgApisCertmanagerV1CertificateSpec;
    @JsonProperty("github_com_cert-manager_cert-manager_pkg_apis_certmanager_v1_CertificateStatus")
    private CertificateStatus githubComCertManagerCertManagerPkgApisCertmanagerV1CertificateStatus;
    @JsonProperty("github_com_cert-manager_cert-manager_pkg_apis_certmanager_v1_ClusterIssuer")
    private ClusterIssuer githubComCertManagerCertManagerPkgApisCertmanagerV1ClusterIssuer;
    @JsonProperty("github_com_cert-manager_cert-manager_pkg_apis_certmanager_v1_ClusterIssuerList")
    private ClusterIssuerList githubComCertManagerCertManagerPkgApisCertmanagerV1ClusterIssuerList;
    @JsonProperty("github_com_cert-manager_cert-manager_pkg_apis_certmanager_v1_Issuer")
    private Issuer githubComCertManagerCertManagerPkgApisCertmanagerV1Issuer;
    @JsonProperty("github_com_cert-manager_cert-manager_pkg_apis_certmanager_v1_IssuerCondition")
    private IssuerCondition githubComCertManagerCertManagerPkgApisCertmanagerV1IssuerCondition;
    @JsonProperty("github_com_cert-manager_cert-manager_pkg_apis_certmanager_v1_IssuerList")
    private IssuerList githubComCertManagerCertManagerPkgApisCertmanagerV1IssuerList;
    @JsonProperty("github_com_cert-manager_cert-manager_pkg_apis_certmanager_v1_IssuerSpec")
    private IssuerSpec githubComCertManagerCertManagerPkgApisCertmanagerV1IssuerSpec;
    @JsonProperty("github_com_cert-manager_cert-manager_pkg_apis_certmanager_v1_IssuerStatus")
    private IssuerStatus githubComCertManagerCertManagerPkgApisCertmanagerV1IssuerStatus;
    @JsonProperty("github_com_cert-manager_cert-manager_pkg_apis_certmanager_v1_JKSKeystore")
    private JKSKeystore githubComCertManagerCertManagerPkgApisCertmanagerV1JKSKeystore;
    @JsonProperty("github_com_cert-manager_cert-manager_pkg_apis_certmanager_v1_PKCS12Keystore")
    private PKCS12Keystore githubComCertManagerCertManagerPkgApisCertmanagerV1PKCS12Keystore;
    @JsonProperty("github_com_cert-manager_cert-manager_pkg_apis_certmanager_v1_SelfSignedIssuer")
    private SelfSignedIssuer githubComCertManagerCertManagerPkgApisCertmanagerV1SelfSignedIssuer;
    @JsonProperty("github_com_cert-manager_cert-manager_pkg_apis_certmanager_v1_VaultAppRole")
    private VaultAppRole githubComCertManagerCertManagerPkgApisCertmanagerV1VaultAppRole;
    @JsonProperty("github_com_cert-manager_cert-manager_pkg_apis_certmanager_v1_VaultAuth")
    private VaultAuth githubComCertManagerCertManagerPkgApisCertmanagerV1VaultAuth;
    @JsonProperty("github_com_cert-manager_cert-manager_pkg_apis_certmanager_v1_VaultIssuer")
    private VaultIssuer githubComCertManagerCertManagerPkgApisCertmanagerV1VaultIssuer;
    @JsonProperty("github_com_cert-manager_cert-manager_pkg_apis_certmanager_v1_VaultKubernetesAuth")
    private VaultKubernetesAuth githubComCertManagerCertManagerPkgApisCertmanagerV1VaultKubernetesAuth;
    @JsonProperty("github_com_cert-manager_cert-manager_pkg_apis_certmanager_v1_VenafiCloud")
    private VenafiCloud githubComCertManagerCertManagerPkgApisCertmanagerV1VenafiCloud;
    @JsonProperty("github_com_cert-manager_cert-manager_pkg_apis_certmanager_v1_VenafiIssuer")
    private VenafiIssuer githubComCertManagerCertManagerPkgApisCertmanagerV1VenafiIssuer;
    @JsonProperty("github_com_cert-manager_cert-manager_pkg_apis_certmanager_v1_VenafiTPP")
    private VenafiTPP githubComCertManagerCertManagerPkgApisCertmanagerV1VenafiTPP;
    @JsonProperty("github_com_cert-manager_cert-manager_pkg_apis_certmanager_v1_X509Subject")
    private X509Subject githubComCertManagerCertManagerPkgApisCertmanagerV1X509Subject;
    @JsonProperty("github_com_cert-manager_cert-manager_pkg_apis_meta_v1_LocalObjectReference")
    private io.fabric8.certmanager.api.model.meta.v1.LocalObjectReference githubComCertManagerCertManagerPkgApisMetaV1LocalObjectReference;
    @JsonProperty("github_com_cert-manager_cert-manager_pkg_apis_meta_v1_ObjectReference")
    private io.fabric8.certmanager.api.model.meta.v1.ObjectReference githubComCertManagerCertManagerPkgApisMetaV1ObjectReference;
    @JsonProperty("github_com_cert-manager_cert-manager_pkg_apis_meta_v1_SecretKeySelector")
    private SecretKeySelector githubComCertManagerCertManagerPkgApisMetaV1SecretKeySelector;

    /**
     * No args constructor for use in serialization
     * 
     */
    public CertmanagerSchema() {
    }

    public CertmanagerSchema(ACMEAuthorization githubComCertManagerCertManagerPkgApisAcmeV1ACMEAuthorization, ACMEChallenge githubComCertManagerCertManagerPkgApisAcmeV1ACMEChallenge, ACMEChallengeSolver githubComCertManagerCertManagerPkgApisAcmeV1ACMEChallengeSolver, ACMEChallengeSolverDNS01 githubComCertManagerCertManagerPkgApisAcmeV1ACMEChallengeSolverDNS01, ACMEChallengeSolverHTTP01 githubComCertManagerCertManagerPkgApisAcmeV1ACMEChallengeSolverHTTP01, ACMEChallengeSolverHTTP01GatewayHTTPRoute githubComCertManagerCertManagerPkgApisAcmeV1ACMEChallengeSolverHTTP01GatewayHTTPRoute, ACMEChallengeSolverHTTP01Ingress githubComCertManagerCertManagerPkgApisAcmeV1ACMEChallengeSolverHTTP01Ingress, ACMEChallengeSolverHTTP01IngressObjectMeta githubComCertManagerCertManagerPkgApisAcmeV1ACMEChallengeSolverHTTP01IngressObjectMeta, ACMEChallengeSolverHTTP01IngressPodObjectMeta githubComCertManagerCertManagerPkgApisAcmeV1ACMEChallengeSolverHTTP01IngressPodObjectMeta, ACMEChallengeSolverHTTP01IngressPodSpec githubComCertManagerCertManagerPkgApisAcmeV1ACMEChallengeSolverHTTP01IngressPodSpec, ACMEChallengeSolverHTTP01IngressPodTemplate githubComCertManagerCertManagerPkgApisAcmeV1ACMEChallengeSolverHTTP01IngressPodTemplate, ACMEChallengeSolverHTTP01IngressTemplate githubComCertManagerCertManagerPkgApisAcmeV1ACMEChallengeSolverHTTP01IngressTemplate, ACMEExternalAccountBinding githubComCertManagerCertManagerPkgApisAcmeV1ACMEExternalAccountBinding, ACMEIssuer githubComCertManagerCertManagerPkgApisAcmeV1ACMEIssuer, ACMEIssuerDNS01ProviderAcmeDNS githubComCertManagerCertManagerPkgApisAcmeV1ACMEIssuerDNS01ProviderAcmeDNS, ACMEIssuerDNS01ProviderAkamai githubComCertManagerCertManagerPkgApisAcmeV1ACMEIssuerDNS01ProviderAkamai, ACMEIssuerDNS01ProviderAzureDNS githubComCertManagerCertManagerPkgApisAcmeV1ACMEIssuerDNS01ProviderAzureDNS, ACMEIssuerDNS01ProviderCloudDNS githubComCertManagerCertManagerPkgApisAcmeV1ACMEIssuerDNS01ProviderCloudDNS, ACMEIssuerDNS01ProviderCloudflare githubComCertManagerCertManagerPkgApisAcmeV1ACMEIssuerDNS01ProviderCloudflare, ACMEIssuerDNS01ProviderDigitalOcean githubComCertManagerCertManagerPkgApisAcmeV1ACMEIssuerDNS01ProviderDigitalOcean, ACMEIssuerDNS01ProviderRFC2136 githubComCertManagerCertManagerPkgApisAcmeV1ACMEIssuerDNS01ProviderRFC2136, ACMEIssuerDNS01ProviderRoute53 githubComCertManagerCertManagerPkgApisAcmeV1ACMEIssuerDNS01ProviderRoute53, ACMEIssuerDNS01ProviderWebhook githubComCertManagerCertManagerPkgApisAcmeV1ACMEIssuerDNS01ProviderWebhook, ACMEIssuerStatus githubComCertManagerCertManagerPkgApisAcmeV1ACMEIssuerStatus, AzureManagedIdentity githubComCertManagerCertManagerPkgApisAcmeV1AzureManagedIdentity, CertificateDNSNameSelector githubComCertManagerCertManagerPkgApisAcmeV1CertificateDNSNameSelector, Challenge githubComCertManagerCertManagerPkgApisAcmeV1Challenge, ChallengeList githubComCertManagerCertManagerPkgApisAcmeV1ChallengeList, ChallengeSpec githubComCertManagerCertManagerPkgApisAcmeV1ChallengeSpec, ChallengeStatus githubComCertManagerCertManagerPkgApisAcmeV1ChallengeStatus, Order githubComCertManagerCertManagerPkgApisAcmeV1Order, OrderList githubComCertManagerCertManagerPkgApisAcmeV1OrderList, OrderSpec githubComCertManagerCertManagerPkgApisAcmeV1OrderSpec, OrderStatus githubComCertManagerCertManagerPkgApisAcmeV1OrderStatus, CAIssuer githubComCertManagerCertManagerPkgApisCertmanagerV1CAIssuer, Certificate githubComCertManagerCertManagerPkgApisCertmanagerV1Certificate, CertificateAdditionalOutputFormat githubComCertManagerCertManagerPkgApisCertmanagerV1CertificateAdditionalOutputFormat, CertificateCondition githubComCertManagerCertManagerPkgApisCertmanagerV1CertificateCondition, CertificateKeystores githubComCertManagerCertManagerPkgApisCertmanagerV1CertificateKeystores, CertificateList githubComCertManagerCertManagerPkgApisCertmanagerV1CertificateList, CertificatePrivateKey githubComCertManagerCertManagerPkgApisCertmanagerV1CertificatePrivateKey, CertificateRequest githubComCertManagerCertManagerPkgApisCertmanagerV1CertificateRequest, CertificateRequestCondition githubComCertManagerCertManagerPkgApisCertmanagerV1CertificateRequestCondition, CertificateRequestList githubComCertManagerCertManagerPkgApisCertmanagerV1CertificateRequestList, CertificateRequestSpec githubComCertManagerCertManagerPkgApisCertmanagerV1CertificateRequestSpec, CertificateRequestStatus githubComCertManagerCertManagerPkgApisCertmanagerV1CertificateRequestStatus, CertificateSecretTemplate githubComCertManagerCertManagerPkgApisCertmanagerV1CertificateSecretTemplate, CertificateSpec githubComCertManagerCertManagerPkgApisCertmanagerV1CertificateSpec, CertificateStatus githubComCertManagerCertManagerPkgApisCertmanagerV1CertificateStatus, ClusterIssuer githubComCertManagerCertManagerPkgApisCertmanagerV1ClusterIssuer, ClusterIssuerList githubComCertManagerCertManagerPkgApisCertmanagerV1ClusterIssuerList, Issuer githubComCertManagerCertManagerPkgApisCertmanagerV1Issuer, IssuerCondition githubComCertManagerCertManagerPkgApisCertmanagerV1IssuerCondition, IssuerList githubComCertManagerCertManagerPkgApisCertmanagerV1IssuerList, IssuerSpec githubComCertManagerCertManagerPkgApisCertmanagerV1IssuerSpec, IssuerStatus githubComCertManagerCertManagerPkgApisCertmanagerV1IssuerStatus, JKSKeystore githubComCertManagerCertManagerPkgApisCertmanagerV1JKSKeystore, PKCS12Keystore githubComCertManagerCertManagerPkgApisCertmanagerV1PKCS12Keystore, SelfSignedIssuer githubComCertManagerCertManagerPkgApisCertmanagerV1SelfSignedIssuer, VaultAppRole githubComCertManagerCertManagerPkgApisCertmanagerV1VaultAppRole, VaultAuth githubComCertManagerCertManagerPkgApisCertmanagerV1VaultAuth, VaultIssuer githubComCertManagerCertManagerPkgApisCertmanagerV1VaultIssuer, VaultKubernetesAuth githubComCertManagerCertManagerPkgApisCertmanagerV1VaultKubernetesAuth, VenafiCloud githubComCertManagerCertManagerPkgApisCertmanagerV1VenafiCloud, VenafiIssuer githubComCertManagerCertManagerPkgApisCertmanagerV1VenafiIssuer, VenafiTPP githubComCertManagerCertManagerPkgApisCertmanagerV1VenafiTPP, X509Subject githubComCertManagerCertManagerPkgApisCertmanagerV1X509Subject, io.fabric8.certmanager.api.model.meta.v1.LocalObjectReference githubComCertManagerCertManagerPkgApisMetaV1LocalObjectReference, io.fabric8.certmanager.api.model.meta.v1.ObjectReference githubComCertManagerCertManagerPkgApisMetaV1ObjectReference, SecretKeySelector githubComCertManagerCertManagerPkgApisMetaV1SecretKeySelector) {
        super();
        this.githubComCertManagerCertManagerPkgApisAcmeV1ACMEAuthorization = githubComCertManagerCertManagerPkgApisAcmeV1ACMEAuthorization;
        this.githubComCertManagerCertManagerPkgApisAcmeV1ACMEChallenge = githubComCertManagerCertManagerPkgApisAcmeV1ACMEChallenge;
        this.githubComCertManagerCertManagerPkgApisAcmeV1ACMEChallengeSolver = githubComCertManagerCertManagerPkgApisAcmeV1ACMEChallengeSolver;
        this.githubComCertManagerCertManagerPkgApisAcmeV1ACMEChallengeSolverDNS01 = githubComCertManagerCertManagerPkgApisAcmeV1ACMEChallengeSolverDNS01;
        this.githubComCertManagerCertManagerPkgApisAcmeV1ACMEChallengeSolverHTTP01 = githubComCertManagerCertManagerPkgApisAcmeV1ACMEChallengeSolverHTTP01;
        this.githubComCertManagerCertManagerPkgApisAcmeV1ACMEChallengeSolverHTTP01GatewayHTTPRoute = githubComCertManagerCertManagerPkgApisAcmeV1ACMEChallengeSolverHTTP01GatewayHTTPRoute;
        this.githubComCertManagerCertManagerPkgApisAcmeV1ACMEChallengeSolverHTTP01Ingress = githubComCertManagerCertManagerPkgApisAcmeV1ACMEChallengeSolverHTTP01Ingress;
        this.githubComCertManagerCertManagerPkgApisAcmeV1ACMEChallengeSolverHTTP01IngressObjectMeta = githubComCertManagerCertManagerPkgApisAcmeV1ACMEChallengeSolverHTTP01IngressObjectMeta;
        this.githubComCertManagerCertManagerPkgApisAcmeV1ACMEChallengeSolverHTTP01IngressPodObjectMeta = githubComCertManagerCertManagerPkgApisAcmeV1ACMEChallengeSolverHTTP01IngressPodObjectMeta;
        this.githubComCertManagerCertManagerPkgApisAcmeV1ACMEChallengeSolverHTTP01IngressPodSpec = githubComCertManagerCertManagerPkgApisAcmeV1ACMEChallengeSolverHTTP01IngressPodSpec;
        this.githubComCertManagerCertManagerPkgApisAcmeV1ACMEChallengeSolverHTTP01IngressPodTemplate = githubComCertManagerCertManagerPkgApisAcmeV1ACMEChallengeSolverHTTP01IngressPodTemplate;
        this.githubComCertManagerCertManagerPkgApisAcmeV1ACMEChallengeSolverHTTP01IngressTemplate = githubComCertManagerCertManagerPkgApisAcmeV1ACMEChallengeSolverHTTP01IngressTemplate;
        this.githubComCertManagerCertManagerPkgApisAcmeV1ACMEExternalAccountBinding = githubComCertManagerCertManagerPkgApisAcmeV1ACMEExternalAccountBinding;
        this.githubComCertManagerCertManagerPkgApisAcmeV1ACMEIssuer = githubComCertManagerCertManagerPkgApisAcmeV1ACMEIssuer;
        this.githubComCertManagerCertManagerPkgApisAcmeV1ACMEIssuerDNS01ProviderAcmeDNS = githubComCertManagerCertManagerPkgApisAcmeV1ACMEIssuerDNS01ProviderAcmeDNS;
        this.githubComCertManagerCertManagerPkgApisAcmeV1ACMEIssuerDNS01ProviderAkamai = githubComCertManagerCertManagerPkgApisAcmeV1ACMEIssuerDNS01ProviderAkamai;
        this.githubComCertManagerCertManagerPkgApisAcmeV1ACMEIssuerDNS01ProviderAzureDNS = githubComCertManagerCertManagerPkgApisAcmeV1ACMEIssuerDNS01ProviderAzureDNS;
        this.githubComCertManagerCertManagerPkgApisAcmeV1ACMEIssuerDNS01ProviderCloudDNS = githubComCertManagerCertManagerPkgApisAcmeV1ACMEIssuerDNS01ProviderCloudDNS;
        this.githubComCertManagerCertManagerPkgApisAcmeV1ACMEIssuerDNS01ProviderCloudflare = githubComCertManagerCertManagerPkgApisAcmeV1ACMEIssuerDNS01ProviderCloudflare;
        this.githubComCertManagerCertManagerPkgApisAcmeV1ACMEIssuerDNS01ProviderDigitalOcean = githubComCertManagerCertManagerPkgApisAcmeV1ACMEIssuerDNS01ProviderDigitalOcean;
        this.githubComCertManagerCertManagerPkgApisAcmeV1ACMEIssuerDNS01ProviderRFC2136 = githubComCertManagerCertManagerPkgApisAcmeV1ACMEIssuerDNS01ProviderRFC2136;
        this.githubComCertManagerCertManagerPkgApisAcmeV1ACMEIssuerDNS01ProviderRoute53 = githubComCertManagerCertManagerPkgApisAcmeV1ACMEIssuerDNS01ProviderRoute53;
        this.githubComCertManagerCertManagerPkgApisAcmeV1ACMEIssuerDNS01ProviderWebhook = githubComCertManagerCertManagerPkgApisAcmeV1ACMEIssuerDNS01ProviderWebhook;
        this.githubComCertManagerCertManagerPkgApisAcmeV1ACMEIssuerStatus = githubComCertManagerCertManagerPkgApisAcmeV1ACMEIssuerStatus;
        this.githubComCertManagerCertManagerPkgApisAcmeV1AzureManagedIdentity = githubComCertManagerCertManagerPkgApisAcmeV1AzureManagedIdentity;
        this.githubComCertManagerCertManagerPkgApisAcmeV1CertificateDNSNameSelector = githubComCertManagerCertManagerPkgApisAcmeV1CertificateDNSNameSelector;
        this.githubComCertManagerCertManagerPkgApisAcmeV1Challenge = githubComCertManagerCertManagerPkgApisAcmeV1Challenge;
        this.githubComCertManagerCertManagerPkgApisAcmeV1ChallengeList = githubComCertManagerCertManagerPkgApisAcmeV1ChallengeList;
        this.githubComCertManagerCertManagerPkgApisAcmeV1ChallengeSpec = githubComCertManagerCertManagerPkgApisAcmeV1ChallengeSpec;
        this.githubComCertManagerCertManagerPkgApisAcmeV1ChallengeStatus = githubComCertManagerCertManagerPkgApisAcmeV1ChallengeStatus;
        this.githubComCertManagerCertManagerPkgApisAcmeV1Order = githubComCertManagerCertManagerPkgApisAcmeV1Order;
        this.githubComCertManagerCertManagerPkgApisAcmeV1OrderList = githubComCertManagerCertManagerPkgApisAcmeV1OrderList;
        this.githubComCertManagerCertManagerPkgApisAcmeV1OrderSpec = githubComCertManagerCertManagerPkgApisAcmeV1OrderSpec;
        this.githubComCertManagerCertManagerPkgApisAcmeV1OrderStatus = githubComCertManagerCertManagerPkgApisAcmeV1OrderStatus;
        this.githubComCertManagerCertManagerPkgApisCertmanagerV1CAIssuer = githubComCertManagerCertManagerPkgApisCertmanagerV1CAIssuer;
        this.githubComCertManagerCertManagerPkgApisCertmanagerV1Certificate = githubComCertManagerCertManagerPkgApisCertmanagerV1Certificate;
        this.githubComCertManagerCertManagerPkgApisCertmanagerV1CertificateAdditionalOutputFormat = githubComCertManagerCertManagerPkgApisCertmanagerV1CertificateAdditionalOutputFormat;
        this.githubComCertManagerCertManagerPkgApisCertmanagerV1CertificateCondition = githubComCertManagerCertManagerPkgApisCertmanagerV1CertificateCondition;
        this.githubComCertManagerCertManagerPkgApisCertmanagerV1CertificateKeystores = githubComCertManagerCertManagerPkgApisCertmanagerV1CertificateKeystores;
        this.githubComCertManagerCertManagerPkgApisCertmanagerV1CertificateList = githubComCertManagerCertManagerPkgApisCertmanagerV1CertificateList;
        this.githubComCertManagerCertManagerPkgApisCertmanagerV1CertificatePrivateKey = githubComCertManagerCertManagerPkgApisCertmanagerV1CertificatePrivateKey;
        this.githubComCertManagerCertManagerPkgApisCertmanagerV1CertificateRequest = githubComCertManagerCertManagerPkgApisCertmanagerV1CertificateRequest;
        this.githubComCertManagerCertManagerPkgApisCertmanagerV1CertificateRequestCondition = githubComCertManagerCertManagerPkgApisCertmanagerV1CertificateRequestCondition;
        this.githubComCertManagerCertManagerPkgApisCertmanagerV1CertificateRequestList = githubComCertManagerCertManagerPkgApisCertmanagerV1CertificateRequestList;
        this.githubComCertManagerCertManagerPkgApisCertmanagerV1CertificateRequestSpec = githubComCertManagerCertManagerPkgApisCertmanagerV1CertificateRequestSpec;
        this.githubComCertManagerCertManagerPkgApisCertmanagerV1CertificateRequestStatus = githubComCertManagerCertManagerPkgApisCertmanagerV1CertificateRequestStatus;
        this.githubComCertManagerCertManagerPkgApisCertmanagerV1CertificateSecretTemplate = githubComCertManagerCertManagerPkgApisCertmanagerV1CertificateSecretTemplate;
        this.githubComCertManagerCertManagerPkgApisCertmanagerV1CertificateSpec = githubComCertManagerCertManagerPkgApisCertmanagerV1CertificateSpec;
        this.githubComCertManagerCertManagerPkgApisCertmanagerV1CertificateStatus = githubComCertManagerCertManagerPkgApisCertmanagerV1CertificateStatus;
        this.githubComCertManagerCertManagerPkgApisCertmanagerV1ClusterIssuer = githubComCertManagerCertManagerPkgApisCertmanagerV1ClusterIssuer;
        this.githubComCertManagerCertManagerPkgApisCertmanagerV1ClusterIssuerList = githubComCertManagerCertManagerPkgApisCertmanagerV1ClusterIssuerList;
        this.githubComCertManagerCertManagerPkgApisCertmanagerV1Issuer = githubComCertManagerCertManagerPkgApisCertmanagerV1Issuer;
        this.githubComCertManagerCertManagerPkgApisCertmanagerV1IssuerCondition = githubComCertManagerCertManagerPkgApisCertmanagerV1IssuerCondition;
        this.githubComCertManagerCertManagerPkgApisCertmanagerV1IssuerList = githubComCertManagerCertManagerPkgApisCertmanagerV1IssuerList;
        this.githubComCertManagerCertManagerPkgApisCertmanagerV1IssuerSpec = githubComCertManagerCertManagerPkgApisCertmanagerV1IssuerSpec;
        this.githubComCertManagerCertManagerPkgApisCertmanagerV1IssuerStatus = githubComCertManagerCertManagerPkgApisCertmanagerV1IssuerStatus;
        this.githubComCertManagerCertManagerPkgApisCertmanagerV1JKSKeystore = githubComCertManagerCertManagerPkgApisCertmanagerV1JKSKeystore;
        this.githubComCertManagerCertManagerPkgApisCertmanagerV1PKCS12Keystore = githubComCertManagerCertManagerPkgApisCertmanagerV1PKCS12Keystore;
        this.githubComCertManagerCertManagerPkgApisCertmanagerV1SelfSignedIssuer = githubComCertManagerCertManagerPkgApisCertmanagerV1SelfSignedIssuer;
        this.githubComCertManagerCertManagerPkgApisCertmanagerV1VaultAppRole = githubComCertManagerCertManagerPkgApisCertmanagerV1VaultAppRole;
        this.githubComCertManagerCertManagerPkgApisCertmanagerV1VaultAuth = githubComCertManagerCertManagerPkgApisCertmanagerV1VaultAuth;
        this.githubComCertManagerCertManagerPkgApisCertmanagerV1VaultIssuer = githubComCertManagerCertManagerPkgApisCertmanagerV1VaultIssuer;
        this.githubComCertManagerCertManagerPkgApisCertmanagerV1VaultKubernetesAuth = githubComCertManagerCertManagerPkgApisCertmanagerV1VaultKubernetesAuth;
        this.githubComCertManagerCertManagerPkgApisCertmanagerV1VenafiCloud = githubComCertManagerCertManagerPkgApisCertmanagerV1VenafiCloud;
        this.githubComCertManagerCertManagerPkgApisCertmanagerV1VenafiIssuer = githubComCertManagerCertManagerPkgApisCertmanagerV1VenafiIssuer;
        this.githubComCertManagerCertManagerPkgApisCertmanagerV1VenafiTPP = githubComCertManagerCertManagerPkgApisCertmanagerV1VenafiTPP;
        this.githubComCertManagerCertManagerPkgApisCertmanagerV1X509Subject = githubComCertManagerCertManagerPkgApisCertmanagerV1X509Subject;
        this.githubComCertManagerCertManagerPkgApisMetaV1LocalObjectReference = githubComCertManagerCertManagerPkgApisMetaV1LocalObjectReference;
        this.githubComCertManagerCertManagerPkgApisMetaV1ObjectReference = githubComCertManagerCertManagerPkgApisMetaV1ObjectReference;
        this.githubComCertManagerCertManagerPkgApisMetaV1SecretKeySelector = githubComCertManagerCertManagerPkgApisMetaV1SecretKeySelector;
    }

    @JsonProperty("github_com_cert-manager_cert-manager_pkg_apis_acme_v1_ACMEAuthorization")
    public ACMEAuthorization getGithubComCertManagerCertManagerPkgApisAcmeV1ACMEAuthorization() {
        return githubComCertManagerCertManagerPkgApisAcmeV1ACMEAuthorization;
    }

    @JsonProperty("github_com_cert-manager_cert-manager_pkg_apis_acme_v1_ACMEAuthorization")
    public void setGithubComCertManagerCertManagerPkgApisAcmeV1ACMEAuthorization(ACMEAuthorization githubComCertManagerCertManagerPkgApisAcmeV1ACMEAuthorization) {
        this.githubComCertManagerCertManagerPkgApisAcmeV1ACMEAuthorization = githubComCertManagerCertManagerPkgApisAcmeV1ACMEAuthorization;
    }

    @JsonProperty("github_com_cert-manager_cert-manager_pkg_apis_acme_v1_ACMEChallenge")
    public ACMEChallenge getGithubComCertManagerCertManagerPkgApisAcmeV1ACMEChallenge() {
        return githubComCertManagerCertManagerPkgApisAcmeV1ACMEChallenge;
    }

    @JsonProperty("github_com_cert-manager_cert-manager_pkg_apis_acme_v1_ACMEChallenge")
    public void setGithubComCertManagerCertManagerPkgApisAcmeV1ACMEChallenge(ACMEChallenge githubComCertManagerCertManagerPkgApisAcmeV1ACMEChallenge) {
        this.githubComCertManagerCertManagerPkgApisAcmeV1ACMEChallenge = githubComCertManagerCertManagerPkgApisAcmeV1ACMEChallenge;
    }

    @JsonProperty("github_com_cert-manager_cert-manager_pkg_apis_acme_v1_ACMEChallengeSolver")
    public ACMEChallengeSolver getGithubComCertManagerCertManagerPkgApisAcmeV1ACMEChallengeSolver() {
        return githubComCertManagerCertManagerPkgApisAcmeV1ACMEChallengeSolver;
    }

    @JsonProperty("github_com_cert-manager_cert-manager_pkg_apis_acme_v1_ACMEChallengeSolver")
    public void setGithubComCertManagerCertManagerPkgApisAcmeV1ACMEChallengeSolver(ACMEChallengeSolver githubComCertManagerCertManagerPkgApisAcmeV1ACMEChallengeSolver) {
        this.githubComCertManagerCertManagerPkgApisAcmeV1ACMEChallengeSolver = githubComCertManagerCertManagerPkgApisAcmeV1ACMEChallengeSolver;
    }

    @JsonProperty("github_com_cert-manager_cert-manager_pkg_apis_acme_v1_ACMEChallengeSolverDNS01")
    public ACMEChallengeSolverDNS01 getGithubComCertManagerCertManagerPkgApisAcmeV1ACMEChallengeSolverDNS01() {
        return githubComCertManagerCertManagerPkgApisAcmeV1ACMEChallengeSolverDNS01;
    }

    @JsonProperty("github_com_cert-manager_cert-manager_pkg_apis_acme_v1_ACMEChallengeSolverDNS01")
    public void setGithubComCertManagerCertManagerPkgApisAcmeV1ACMEChallengeSolverDNS01(ACMEChallengeSolverDNS01 githubComCertManagerCertManagerPkgApisAcmeV1ACMEChallengeSolverDNS01) {
        this.githubComCertManagerCertManagerPkgApisAcmeV1ACMEChallengeSolverDNS01 = githubComCertManagerCertManagerPkgApisAcmeV1ACMEChallengeSolverDNS01;
    }

    @JsonProperty("github_com_cert-manager_cert-manager_pkg_apis_acme_v1_ACMEChallengeSolverHTTP01")
    public ACMEChallengeSolverHTTP01 getGithubComCertManagerCertManagerPkgApisAcmeV1ACMEChallengeSolverHTTP01() {
        return githubComCertManagerCertManagerPkgApisAcmeV1ACMEChallengeSolverHTTP01;
    }

    @JsonProperty("github_com_cert-manager_cert-manager_pkg_apis_acme_v1_ACMEChallengeSolverHTTP01")
    public void setGithubComCertManagerCertManagerPkgApisAcmeV1ACMEChallengeSolverHTTP01(ACMEChallengeSolverHTTP01 githubComCertManagerCertManagerPkgApisAcmeV1ACMEChallengeSolverHTTP01) {
        this.githubComCertManagerCertManagerPkgApisAcmeV1ACMEChallengeSolverHTTP01 = githubComCertManagerCertManagerPkgApisAcmeV1ACMEChallengeSolverHTTP01;
    }

    @JsonProperty("github_com_cert-manager_cert-manager_pkg_apis_acme_v1_ACMEChallengeSolverHTTP01GatewayHTTPRoute")
    public ACMEChallengeSolverHTTP01GatewayHTTPRoute getGithubComCertManagerCertManagerPkgApisAcmeV1ACMEChallengeSolverHTTP01GatewayHTTPRoute() {
        return githubComCertManagerCertManagerPkgApisAcmeV1ACMEChallengeSolverHTTP01GatewayHTTPRoute;
    }

    @JsonProperty("github_com_cert-manager_cert-manager_pkg_apis_acme_v1_ACMEChallengeSolverHTTP01GatewayHTTPRoute")
    public void setGithubComCertManagerCertManagerPkgApisAcmeV1ACMEChallengeSolverHTTP01GatewayHTTPRoute(ACMEChallengeSolverHTTP01GatewayHTTPRoute githubComCertManagerCertManagerPkgApisAcmeV1ACMEChallengeSolverHTTP01GatewayHTTPRoute) {
        this.githubComCertManagerCertManagerPkgApisAcmeV1ACMEChallengeSolverHTTP01GatewayHTTPRoute = githubComCertManagerCertManagerPkgApisAcmeV1ACMEChallengeSolverHTTP01GatewayHTTPRoute;
    }

    @JsonProperty("github_com_cert-manager_cert-manager_pkg_apis_acme_v1_ACMEChallengeSolverHTTP01Ingress")
    public ACMEChallengeSolverHTTP01Ingress getGithubComCertManagerCertManagerPkgApisAcmeV1ACMEChallengeSolverHTTP01Ingress() {
        return githubComCertManagerCertManagerPkgApisAcmeV1ACMEChallengeSolverHTTP01Ingress;
    }

    @JsonProperty("github_com_cert-manager_cert-manager_pkg_apis_acme_v1_ACMEChallengeSolverHTTP01Ingress")
    public void setGithubComCertManagerCertManagerPkgApisAcmeV1ACMEChallengeSolverHTTP01Ingress(ACMEChallengeSolverHTTP01Ingress githubComCertManagerCertManagerPkgApisAcmeV1ACMEChallengeSolverHTTP01Ingress) {
        this.githubComCertManagerCertManagerPkgApisAcmeV1ACMEChallengeSolverHTTP01Ingress = githubComCertManagerCertManagerPkgApisAcmeV1ACMEChallengeSolverHTTP01Ingress;
    }

    @JsonProperty("github_com_cert-manager_cert-manager_pkg_apis_acme_v1_ACMEChallengeSolverHTTP01IngressObjectMeta")
    public ACMEChallengeSolverHTTP01IngressObjectMeta getGithubComCertManagerCertManagerPkgApisAcmeV1ACMEChallengeSolverHTTP01IngressObjectMeta() {
        return githubComCertManagerCertManagerPkgApisAcmeV1ACMEChallengeSolverHTTP01IngressObjectMeta;
    }

    @JsonProperty("github_com_cert-manager_cert-manager_pkg_apis_acme_v1_ACMEChallengeSolverHTTP01IngressObjectMeta")
    public void setGithubComCertManagerCertManagerPkgApisAcmeV1ACMEChallengeSolverHTTP01IngressObjectMeta(ACMEChallengeSolverHTTP01IngressObjectMeta githubComCertManagerCertManagerPkgApisAcmeV1ACMEChallengeSolverHTTP01IngressObjectMeta) {
        this.githubComCertManagerCertManagerPkgApisAcmeV1ACMEChallengeSolverHTTP01IngressObjectMeta = githubComCertManagerCertManagerPkgApisAcmeV1ACMEChallengeSolverHTTP01IngressObjectMeta;
    }

    @JsonProperty("github_com_cert-manager_cert-manager_pkg_apis_acme_v1_ACMEChallengeSolverHTTP01IngressPodObjectMeta")
    public ACMEChallengeSolverHTTP01IngressPodObjectMeta getGithubComCertManagerCertManagerPkgApisAcmeV1ACMEChallengeSolverHTTP01IngressPodObjectMeta() {
        return githubComCertManagerCertManagerPkgApisAcmeV1ACMEChallengeSolverHTTP01IngressPodObjectMeta;
    }

    @JsonProperty("github_com_cert-manager_cert-manager_pkg_apis_acme_v1_ACMEChallengeSolverHTTP01IngressPodObjectMeta")
    public void setGithubComCertManagerCertManagerPkgApisAcmeV1ACMEChallengeSolverHTTP01IngressPodObjectMeta(ACMEChallengeSolverHTTP01IngressPodObjectMeta githubComCertManagerCertManagerPkgApisAcmeV1ACMEChallengeSolverHTTP01IngressPodObjectMeta) {
        this.githubComCertManagerCertManagerPkgApisAcmeV1ACMEChallengeSolverHTTP01IngressPodObjectMeta = githubComCertManagerCertManagerPkgApisAcmeV1ACMEChallengeSolverHTTP01IngressPodObjectMeta;
    }

    @JsonProperty("github_com_cert-manager_cert-manager_pkg_apis_acme_v1_ACMEChallengeSolverHTTP01IngressPodSpec")
    public ACMEChallengeSolverHTTP01IngressPodSpec getGithubComCertManagerCertManagerPkgApisAcmeV1ACMEChallengeSolverHTTP01IngressPodSpec() {
        return githubComCertManagerCertManagerPkgApisAcmeV1ACMEChallengeSolverHTTP01IngressPodSpec;
    }

    @JsonProperty("github_com_cert-manager_cert-manager_pkg_apis_acme_v1_ACMEChallengeSolverHTTP01IngressPodSpec")
    public void setGithubComCertManagerCertManagerPkgApisAcmeV1ACMEChallengeSolverHTTP01IngressPodSpec(ACMEChallengeSolverHTTP01IngressPodSpec githubComCertManagerCertManagerPkgApisAcmeV1ACMEChallengeSolverHTTP01IngressPodSpec) {
        this.githubComCertManagerCertManagerPkgApisAcmeV1ACMEChallengeSolverHTTP01IngressPodSpec = githubComCertManagerCertManagerPkgApisAcmeV1ACMEChallengeSolverHTTP01IngressPodSpec;
    }

    @JsonProperty("github_com_cert-manager_cert-manager_pkg_apis_acme_v1_ACMEChallengeSolverHTTP01IngressPodTemplate")
    public ACMEChallengeSolverHTTP01IngressPodTemplate getGithubComCertManagerCertManagerPkgApisAcmeV1ACMEChallengeSolverHTTP01IngressPodTemplate() {
        return githubComCertManagerCertManagerPkgApisAcmeV1ACMEChallengeSolverHTTP01IngressPodTemplate;
    }

    @JsonProperty("github_com_cert-manager_cert-manager_pkg_apis_acme_v1_ACMEChallengeSolverHTTP01IngressPodTemplate")
    public void setGithubComCertManagerCertManagerPkgApisAcmeV1ACMEChallengeSolverHTTP01IngressPodTemplate(ACMEChallengeSolverHTTP01IngressPodTemplate githubComCertManagerCertManagerPkgApisAcmeV1ACMEChallengeSolverHTTP01IngressPodTemplate) {
        this.githubComCertManagerCertManagerPkgApisAcmeV1ACMEChallengeSolverHTTP01IngressPodTemplate = githubComCertManagerCertManagerPkgApisAcmeV1ACMEChallengeSolverHTTP01IngressPodTemplate;
    }

    @JsonProperty("github_com_cert-manager_cert-manager_pkg_apis_acme_v1_ACMEChallengeSolverHTTP01IngressTemplate")
    public ACMEChallengeSolverHTTP01IngressTemplate getGithubComCertManagerCertManagerPkgApisAcmeV1ACMEChallengeSolverHTTP01IngressTemplate() {
        return githubComCertManagerCertManagerPkgApisAcmeV1ACMEChallengeSolverHTTP01IngressTemplate;
    }

    @JsonProperty("github_com_cert-manager_cert-manager_pkg_apis_acme_v1_ACMEChallengeSolverHTTP01IngressTemplate")
    public void setGithubComCertManagerCertManagerPkgApisAcmeV1ACMEChallengeSolverHTTP01IngressTemplate(ACMEChallengeSolverHTTP01IngressTemplate githubComCertManagerCertManagerPkgApisAcmeV1ACMEChallengeSolverHTTP01IngressTemplate) {
        this.githubComCertManagerCertManagerPkgApisAcmeV1ACMEChallengeSolverHTTP01IngressTemplate = githubComCertManagerCertManagerPkgApisAcmeV1ACMEChallengeSolverHTTP01IngressTemplate;
    }

    @JsonProperty("github_com_cert-manager_cert-manager_pkg_apis_acme_v1_ACMEExternalAccountBinding")
    public ACMEExternalAccountBinding getGithubComCertManagerCertManagerPkgApisAcmeV1ACMEExternalAccountBinding() {
        return githubComCertManagerCertManagerPkgApisAcmeV1ACMEExternalAccountBinding;
    }

    @JsonProperty("github_com_cert-manager_cert-manager_pkg_apis_acme_v1_ACMEExternalAccountBinding")
    public void setGithubComCertManagerCertManagerPkgApisAcmeV1ACMEExternalAccountBinding(ACMEExternalAccountBinding githubComCertManagerCertManagerPkgApisAcmeV1ACMEExternalAccountBinding) {
        this.githubComCertManagerCertManagerPkgApisAcmeV1ACMEExternalAccountBinding = githubComCertManagerCertManagerPkgApisAcmeV1ACMEExternalAccountBinding;
    }

    @JsonProperty("github_com_cert-manager_cert-manager_pkg_apis_acme_v1_ACMEIssuer")
    public ACMEIssuer getGithubComCertManagerCertManagerPkgApisAcmeV1ACMEIssuer() {
        return githubComCertManagerCertManagerPkgApisAcmeV1ACMEIssuer;
    }

    @JsonProperty("github_com_cert-manager_cert-manager_pkg_apis_acme_v1_ACMEIssuer")
    public void setGithubComCertManagerCertManagerPkgApisAcmeV1ACMEIssuer(ACMEIssuer githubComCertManagerCertManagerPkgApisAcmeV1ACMEIssuer) {
        this.githubComCertManagerCertManagerPkgApisAcmeV1ACMEIssuer = githubComCertManagerCertManagerPkgApisAcmeV1ACMEIssuer;
    }

    @JsonProperty("github_com_cert-manager_cert-manager_pkg_apis_acme_v1_ACMEIssuerDNS01ProviderAcmeDNS")
    public ACMEIssuerDNS01ProviderAcmeDNS getGithubComCertManagerCertManagerPkgApisAcmeV1ACMEIssuerDNS01ProviderAcmeDNS() {
        return githubComCertManagerCertManagerPkgApisAcmeV1ACMEIssuerDNS01ProviderAcmeDNS;
    }

    @JsonProperty("github_com_cert-manager_cert-manager_pkg_apis_acme_v1_ACMEIssuerDNS01ProviderAcmeDNS")
    public void setGithubComCertManagerCertManagerPkgApisAcmeV1ACMEIssuerDNS01ProviderAcmeDNS(ACMEIssuerDNS01ProviderAcmeDNS githubComCertManagerCertManagerPkgApisAcmeV1ACMEIssuerDNS01ProviderAcmeDNS) {
        this.githubComCertManagerCertManagerPkgApisAcmeV1ACMEIssuerDNS01ProviderAcmeDNS = githubComCertManagerCertManagerPkgApisAcmeV1ACMEIssuerDNS01ProviderAcmeDNS;
    }

    @JsonProperty("github_com_cert-manager_cert-manager_pkg_apis_acme_v1_ACMEIssuerDNS01ProviderAkamai")
    public ACMEIssuerDNS01ProviderAkamai getGithubComCertManagerCertManagerPkgApisAcmeV1ACMEIssuerDNS01ProviderAkamai() {
        return githubComCertManagerCertManagerPkgApisAcmeV1ACMEIssuerDNS01ProviderAkamai;
    }

    @JsonProperty("github_com_cert-manager_cert-manager_pkg_apis_acme_v1_ACMEIssuerDNS01ProviderAkamai")
    public void setGithubComCertManagerCertManagerPkgApisAcmeV1ACMEIssuerDNS01ProviderAkamai(ACMEIssuerDNS01ProviderAkamai githubComCertManagerCertManagerPkgApisAcmeV1ACMEIssuerDNS01ProviderAkamai) {
        this.githubComCertManagerCertManagerPkgApisAcmeV1ACMEIssuerDNS01ProviderAkamai = githubComCertManagerCertManagerPkgApisAcmeV1ACMEIssuerDNS01ProviderAkamai;
    }

    @JsonProperty("github_com_cert-manager_cert-manager_pkg_apis_acme_v1_ACMEIssuerDNS01ProviderAzureDNS")
    public ACMEIssuerDNS01ProviderAzureDNS getGithubComCertManagerCertManagerPkgApisAcmeV1ACMEIssuerDNS01ProviderAzureDNS() {
        return githubComCertManagerCertManagerPkgApisAcmeV1ACMEIssuerDNS01ProviderAzureDNS;
    }

    @JsonProperty("github_com_cert-manager_cert-manager_pkg_apis_acme_v1_ACMEIssuerDNS01ProviderAzureDNS")
    public void setGithubComCertManagerCertManagerPkgApisAcmeV1ACMEIssuerDNS01ProviderAzureDNS(ACMEIssuerDNS01ProviderAzureDNS githubComCertManagerCertManagerPkgApisAcmeV1ACMEIssuerDNS01ProviderAzureDNS) {
        this.githubComCertManagerCertManagerPkgApisAcmeV1ACMEIssuerDNS01ProviderAzureDNS = githubComCertManagerCertManagerPkgApisAcmeV1ACMEIssuerDNS01ProviderAzureDNS;
    }

    @JsonProperty("github_com_cert-manager_cert-manager_pkg_apis_acme_v1_ACMEIssuerDNS01ProviderCloudDNS")
    public ACMEIssuerDNS01ProviderCloudDNS getGithubComCertManagerCertManagerPkgApisAcmeV1ACMEIssuerDNS01ProviderCloudDNS() {
        return githubComCertManagerCertManagerPkgApisAcmeV1ACMEIssuerDNS01ProviderCloudDNS;
    }

    @JsonProperty("github_com_cert-manager_cert-manager_pkg_apis_acme_v1_ACMEIssuerDNS01ProviderCloudDNS")
    public void setGithubComCertManagerCertManagerPkgApisAcmeV1ACMEIssuerDNS01ProviderCloudDNS(ACMEIssuerDNS01ProviderCloudDNS githubComCertManagerCertManagerPkgApisAcmeV1ACMEIssuerDNS01ProviderCloudDNS) {
        this.githubComCertManagerCertManagerPkgApisAcmeV1ACMEIssuerDNS01ProviderCloudDNS = githubComCertManagerCertManagerPkgApisAcmeV1ACMEIssuerDNS01ProviderCloudDNS;
    }

    @JsonProperty("github_com_cert-manager_cert-manager_pkg_apis_acme_v1_ACMEIssuerDNS01ProviderCloudflare")
    public ACMEIssuerDNS01ProviderCloudflare getGithubComCertManagerCertManagerPkgApisAcmeV1ACMEIssuerDNS01ProviderCloudflare() {
        return githubComCertManagerCertManagerPkgApisAcmeV1ACMEIssuerDNS01ProviderCloudflare;
    }

    @JsonProperty("github_com_cert-manager_cert-manager_pkg_apis_acme_v1_ACMEIssuerDNS01ProviderCloudflare")
    public void setGithubComCertManagerCertManagerPkgApisAcmeV1ACMEIssuerDNS01ProviderCloudflare(ACMEIssuerDNS01ProviderCloudflare githubComCertManagerCertManagerPkgApisAcmeV1ACMEIssuerDNS01ProviderCloudflare) {
        this.githubComCertManagerCertManagerPkgApisAcmeV1ACMEIssuerDNS01ProviderCloudflare = githubComCertManagerCertManagerPkgApisAcmeV1ACMEIssuerDNS01ProviderCloudflare;
    }

    @JsonProperty("github_com_cert-manager_cert-manager_pkg_apis_acme_v1_ACMEIssuerDNS01ProviderDigitalOcean")
    public ACMEIssuerDNS01ProviderDigitalOcean getGithubComCertManagerCertManagerPkgApisAcmeV1ACMEIssuerDNS01ProviderDigitalOcean() {
        return githubComCertManagerCertManagerPkgApisAcmeV1ACMEIssuerDNS01ProviderDigitalOcean;
    }

    @JsonProperty("github_com_cert-manager_cert-manager_pkg_apis_acme_v1_ACMEIssuerDNS01ProviderDigitalOcean")
    public void setGithubComCertManagerCertManagerPkgApisAcmeV1ACMEIssuerDNS01ProviderDigitalOcean(ACMEIssuerDNS01ProviderDigitalOcean githubComCertManagerCertManagerPkgApisAcmeV1ACMEIssuerDNS01ProviderDigitalOcean) {
        this.githubComCertManagerCertManagerPkgApisAcmeV1ACMEIssuerDNS01ProviderDigitalOcean = githubComCertManagerCertManagerPkgApisAcmeV1ACMEIssuerDNS01ProviderDigitalOcean;
    }

    @JsonProperty("github_com_cert-manager_cert-manager_pkg_apis_acme_v1_ACMEIssuerDNS01ProviderRFC2136")
    public ACMEIssuerDNS01ProviderRFC2136 getGithubComCertManagerCertManagerPkgApisAcmeV1ACMEIssuerDNS01ProviderRFC2136() {
        return githubComCertManagerCertManagerPkgApisAcmeV1ACMEIssuerDNS01ProviderRFC2136;
    }

    @JsonProperty("github_com_cert-manager_cert-manager_pkg_apis_acme_v1_ACMEIssuerDNS01ProviderRFC2136")
    public void setGithubComCertManagerCertManagerPkgApisAcmeV1ACMEIssuerDNS01ProviderRFC2136(ACMEIssuerDNS01ProviderRFC2136 githubComCertManagerCertManagerPkgApisAcmeV1ACMEIssuerDNS01ProviderRFC2136) {
        this.githubComCertManagerCertManagerPkgApisAcmeV1ACMEIssuerDNS01ProviderRFC2136 = githubComCertManagerCertManagerPkgApisAcmeV1ACMEIssuerDNS01ProviderRFC2136;
    }

    @JsonProperty("github_com_cert-manager_cert-manager_pkg_apis_acme_v1_ACMEIssuerDNS01ProviderRoute53")
    public ACMEIssuerDNS01ProviderRoute53 getGithubComCertManagerCertManagerPkgApisAcmeV1ACMEIssuerDNS01ProviderRoute53() {
        return githubComCertManagerCertManagerPkgApisAcmeV1ACMEIssuerDNS01ProviderRoute53;
    }

    @JsonProperty("github_com_cert-manager_cert-manager_pkg_apis_acme_v1_ACMEIssuerDNS01ProviderRoute53")
    public void setGithubComCertManagerCertManagerPkgApisAcmeV1ACMEIssuerDNS01ProviderRoute53(ACMEIssuerDNS01ProviderRoute53 githubComCertManagerCertManagerPkgApisAcmeV1ACMEIssuerDNS01ProviderRoute53) {
        this.githubComCertManagerCertManagerPkgApisAcmeV1ACMEIssuerDNS01ProviderRoute53 = githubComCertManagerCertManagerPkgApisAcmeV1ACMEIssuerDNS01ProviderRoute53;
    }

    @JsonProperty("github_com_cert-manager_cert-manager_pkg_apis_acme_v1_ACMEIssuerDNS01ProviderWebhook")
    public ACMEIssuerDNS01ProviderWebhook getGithubComCertManagerCertManagerPkgApisAcmeV1ACMEIssuerDNS01ProviderWebhook() {
        return githubComCertManagerCertManagerPkgApisAcmeV1ACMEIssuerDNS01ProviderWebhook;
    }

    @JsonProperty("github_com_cert-manager_cert-manager_pkg_apis_acme_v1_ACMEIssuerDNS01ProviderWebhook")
    public void setGithubComCertManagerCertManagerPkgApisAcmeV1ACMEIssuerDNS01ProviderWebhook(ACMEIssuerDNS01ProviderWebhook githubComCertManagerCertManagerPkgApisAcmeV1ACMEIssuerDNS01ProviderWebhook) {
        this.githubComCertManagerCertManagerPkgApisAcmeV1ACMEIssuerDNS01ProviderWebhook = githubComCertManagerCertManagerPkgApisAcmeV1ACMEIssuerDNS01ProviderWebhook;
    }

    @JsonProperty("github_com_cert-manager_cert-manager_pkg_apis_acme_v1_ACMEIssuerStatus")
    public ACMEIssuerStatus getGithubComCertManagerCertManagerPkgApisAcmeV1ACMEIssuerStatus() {
        return githubComCertManagerCertManagerPkgApisAcmeV1ACMEIssuerStatus;
    }

    @JsonProperty("github_com_cert-manager_cert-manager_pkg_apis_acme_v1_ACMEIssuerStatus")
    public void setGithubComCertManagerCertManagerPkgApisAcmeV1ACMEIssuerStatus(ACMEIssuerStatus githubComCertManagerCertManagerPkgApisAcmeV1ACMEIssuerStatus) {
        this.githubComCertManagerCertManagerPkgApisAcmeV1ACMEIssuerStatus = githubComCertManagerCertManagerPkgApisAcmeV1ACMEIssuerStatus;
    }

    @JsonProperty("github_com_cert-manager_cert-manager_pkg_apis_acme_v1_AzureManagedIdentity")
    public AzureManagedIdentity getGithubComCertManagerCertManagerPkgApisAcmeV1AzureManagedIdentity() {
        return githubComCertManagerCertManagerPkgApisAcmeV1AzureManagedIdentity;
    }

    @JsonProperty("github_com_cert-manager_cert-manager_pkg_apis_acme_v1_AzureManagedIdentity")
    public void setGithubComCertManagerCertManagerPkgApisAcmeV1AzureManagedIdentity(AzureManagedIdentity githubComCertManagerCertManagerPkgApisAcmeV1AzureManagedIdentity) {
        this.githubComCertManagerCertManagerPkgApisAcmeV1AzureManagedIdentity = githubComCertManagerCertManagerPkgApisAcmeV1AzureManagedIdentity;
    }

    @JsonProperty("github_com_cert-manager_cert-manager_pkg_apis_acme_v1_CertificateDNSNameSelector")
    public CertificateDNSNameSelector getGithubComCertManagerCertManagerPkgApisAcmeV1CertificateDNSNameSelector() {
        return githubComCertManagerCertManagerPkgApisAcmeV1CertificateDNSNameSelector;
    }

    @JsonProperty("github_com_cert-manager_cert-manager_pkg_apis_acme_v1_CertificateDNSNameSelector")
    public void setGithubComCertManagerCertManagerPkgApisAcmeV1CertificateDNSNameSelector(CertificateDNSNameSelector githubComCertManagerCertManagerPkgApisAcmeV1CertificateDNSNameSelector) {
        this.githubComCertManagerCertManagerPkgApisAcmeV1CertificateDNSNameSelector = githubComCertManagerCertManagerPkgApisAcmeV1CertificateDNSNameSelector;
    }

    @JsonProperty("github_com_cert-manager_cert-manager_pkg_apis_acme_v1_Challenge")
    public Challenge getGithubComCertManagerCertManagerPkgApisAcmeV1Challenge() {
        return githubComCertManagerCertManagerPkgApisAcmeV1Challenge;
    }

    @JsonProperty("github_com_cert-manager_cert-manager_pkg_apis_acme_v1_Challenge")
    public void setGithubComCertManagerCertManagerPkgApisAcmeV1Challenge(Challenge githubComCertManagerCertManagerPkgApisAcmeV1Challenge) {
        this.githubComCertManagerCertManagerPkgApisAcmeV1Challenge = githubComCertManagerCertManagerPkgApisAcmeV1Challenge;
    }

    @JsonProperty("github_com_cert-manager_cert-manager_pkg_apis_acme_v1_ChallengeList")
    public ChallengeList getGithubComCertManagerCertManagerPkgApisAcmeV1ChallengeList() {
        return githubComCertManagerCertManagerPkgApisAcmeV1ChallengeList;
    }

    @JsonProperty("github_com_cert-manager_cert-manager_pkg_apis_acme_v1_ChallengeList")
    public void setGithubComCertManagerCertManagerPkgApisAcmeV1ChallengeList(ChallengeList githubComCertManagerCertManagerPkgApisAcmeV1ChallengeList) {
        this.githubComCertManagerCertManagerPkgApisAcmeV1ChallengeList = githubComCertManagerCertManagerPkgApisAcmeV1ChallengeList;
    }

    @JsonProperty("github_com_cert-manager_cert-manager_pkg_apis_acme_v1_ChallengeSpec")
    public ChallengeSpec getGithubComCertManagerCertManagerPkgApisAcmeV1ChallengeSpec() {
        return githubComCertManagerCertManagerPkgApisAcmeV1ChallengeSpec;
    }

    @JsonProperty("github_com_cert-manager_cert-manager_pkg_apis_acme_v1_ChallengeSpec")
    public void setGithubComCertManagerCertManagerPkgApisAcmeV1ChallengeSpec(ChallengeSpec githubComCertManagerCertManagerPkgApisAcmeV1ChallengeSpec) {
        this.githubComCertManagerCertManagerPkgApisAcmeV1ChallengeSpec = githubComCertManagerCertManagerPkgApisAcmeV1ChallengeSpec;
    }

    @JsonProperty("github_com_cert-manager_cert-manager_pkg_apis_acme_v1_ChallengeStatus")
    public ChallengeStatus getGithubComCertManagerCertManagerPkgApisAcmeV1ChallengeStatus() {
        return githubComCertManagerCertManagerPkgApisAcmeV1ChallengeStatus;
    }

    @JsonProperty("github_com_cert-manager_cert-manager_pkg_apis_acme_v1_ChallengeStatus")
    public void setGithubComCertManagerCertManagerPkgApisAcmeV1ChallengeStatus(ChallengeStatus githubComCertManagerCertManagerPkgApisAcmeV1ChallengeStatus) {
        this.githubComCertManagerCertManagerPkgApisAcmeV1ChallengeStatus = githubComCertManagerCertManagerPkgApisAcmeV1ChallengeStatus;
    }

    @JsonProperty("github_com_cert-manager_cert-manager_pkg_apis_acme_v1_Order")
    public Order getGithubComCertManagerCertManagerPkgApisAcmeV1Order() {
        return githubComCertManagerCertManagerPkgApisAcmeV1Order;
    }

    @JsonProperty("github_com_cert-manager_cert-manager_pkg_apis_acme_v1_Order")
    public void setGithubComCertManagerCertManagerPkgApisAcmeV1Order(Order githubComCertManagerCertManagerPkgApisAcmeV1Order) {
        this.githubComCertManagerCertManagerPkgApisAcmeV1Order = githubComCertManagerCertManagerPkgApisAcmeV1Order;
    }

    @JsonProperty("github_com_cert-manager_cert-manager_pkg_apis_acme_v1_OrderList")
    public OrderList getGithubComCertManagerCertManagerPkgApisAcmeV1OrderList() {
        return githubComCertManagerCertManagerPkgApisAcmeV1OrderList;
    }

    @JsonProperty("github_com_cert-manager_cert-manager_pkg_apis_acme_v1_OrderList")
    public void setGithubComCertManagerCertManagerPkgApisAcmeV1OrderList(OrderList githubComCertManagerCertManagerPkgApisAcmeV1OrderList) {
        this.githubComCertManagerCertManagerPkgApisAcmeV1OrderList = githubComCertManagerCertManagerPkgApisAcmeV1OrderList;
    }

    @JsonProperty("github_com_cert-manager_cert-manager_pkg_apis_acme_v1_OrderSpec")
    public OrderSpec getGithubComCertManagerCertManagerPkgApisAcmeV1OrderSpec() {
        return githubComCertManagerCertManagerPkgApisAcmeV1OrderSpec;
    }

    @JsonProperty("github_com_cert-manager_cert-manager_pkg_apis_acme_v1_OrderSpec")
    public void setGithubComCertManagerCertManagerPkgApisAcmeV1OrderSpec(OrderSpec githubComCertManagerCertManagerPkgApisAcmeV1OrderSpec) {
        this.githubComCertManagerCertManagerPkgApisAcmeV1OrderSpec = githubComCertManagerCertManagerPkgApisAcmeV1OrderSpec;
    }

    @JsonProperty("github_com_cert-manager_cert-manager_pkg_apis_acme_v1_OrderStatus")
    public OrderStatus getGithubComCertManagerCertManagerPkgApisAcmeV1OrderStatus() {
        return githubComCertManagerCertManagerPkgApisAcmeV1OrderStatus;
    }

    @JsonProperty("github_com_cert-manager_cert-manager_pkg_apis_acme_v1_OrderStatus")
    public void setGithubComCertManagerCertManagerPkgApisAcmeV1OrderStatus(OrderStatus githubComCertManagerCertManagerPkgApisAcmeV1OrderStatus) {
        this.githubComCertManagerCertManagerPkgApisAcmeV1OrderStatus = githubComCertManagerCertManagerPkgApisAcmeV1OrderStatus;
    }

    @JsonProperty("github_com_cert-manager_cert-manager_pkg_apis_certmanager_v1_CAIssuer")
    public CAIssuer getGithubComCertManagerCertManagerPkgApisCertmanagerV1CAIssuer() {
        return githubComCertManagerCertManagerPkgApisCertmanagerV1CAIssuer;
    }

    @JsonProperty("github_com_cert-manager_cert-manager_pkg_apis_certmanager_v1_CAIssuer")
    public void setGithubComCertManagerCertManagerPkgApisCertmanagerV1CAIssuer(CAIssuer githubComCertManagerCertManagerPkgApisCertmanagerV1CAIssuer) {
        this.githubComCertManagerCertManagerPkgApisCertmanagerV1CAIssuer = githubComCertManagerCertManagerPkgApisCertmanagerV1CAIssuer;
    }

    @JsonProperty("github_com_cert-manager_cert-manager_pkg_apis_certmanager_v1_Certificate")
    public Certificate getGithubComCertManagerCertManagerPkgApisCertmanagerV1Certificate() {
        return githubComCertManagerCertManagerPkgApisCertmanagerV1Certificate;
    }

    @JsonProperty("github_com_cert-manager_cert-manager_pkg_apis_certmanager_v1_Certificate")
    public void setGithubComCertManagerCertManagerPkgApisCertmanagerV1Certificate(Certificate githubComCertManagerCertManagerPkgApisCertmanagerV1Certificate) {
        this.githubComCertManagerCertManagerPkgApisCertmanagerV1Certificate = githubComCertManagerCertManagerPkgApisCertmanagerV1Certificate;
    }

    @JsonProperty("github_com_cert-manager_cert-manager_pkg_apis_certmanager_v1_CertificateAdditionalOutputFormat")
    public CertificateAdditionalOutputFormat getGithubComCertManagerCertManagerPkgApisCertmanagerV1CertificateAdditionalOutputFormat() {
        return githubComCertManagerCertManagerPkgApisCertmanagerV1CertificateAdditionalOutputFormat;
    }

    @JsonProperty("github_com_cert-manager_cert-manager_pkg_apis_certmanager_v1_CertificateAdditionalOutputFormat")
    public void setGithubComCertManagerCertManagerPkgApisCertmanagerV1CertificateAdditionalOutputFormat(CertificateAdditionalOutputFormat githubComCertManagerCertManagerPkgApisCertmanagerV1CertificateAdditionalOutputFormat) {
        this.githubComCertManagerCertManagerPkgApisCertmanagerV1CertificateAdditionalOutputFormat = githubComCertManagerCertManagerPkgApisCertmanagerV1CertificateAdditionalOutputFormat;
    }

    @JsonProperty("github_com_cert-manager_cert-manager_pkg_apis_certmanager_v1_CertificateCondition")
    public CertificateCondition getGithubComCertManagerCertManagerPkgApisCertmanagerV1CertificateCondition() {
        return githubComCertManagerCertManagerPkgApisCertmanagerV1CertificateCondition;
    }

    @JsonProperty("github_com_cert-manager_cert-manager_pkg_apis_certmanager_v1_CertificateCondition")
    public void setGithubComCertManagerCertManagerPkgApisCertmanagerV1CertificateCondition(CertificateCondition githubComCertManagerCertManagerPkgApisCertmanagerV1CertificateCondition) {
        this.githubComCertManagerCertManagerPkgApisCertmanagerV1CertificateCondition = githubComCertManagerCertManagerPkgApisCertmanagerV1CertificateCondition;
    }

    @JsonProperty("github_com_cert-manager_cert-manager_pkg_apis_certmanager_v1_CertificateKeystores")
    public CertificateKeystores getGithubComCertManagerCertManagerPkgApisCertmanagerV1CertificateKeystores() {
        return githubComCertManagerCertManagerPkgApisCertmanagerV1CertificateKeystores;
    }

    @JsonProperty("github_com_cert-manager_cert-manager_pkg_apis_certmanager_v1_CertificateKeystores")
    public void setGithubComCertManagerCertManagerPkgApisCertmanagerV1CertificateKeystores(CertificateKeystores githubComCertManagerCertManagerPkgApisCertmanagerV1CertificateKeystores) {
        this.githubComCertManagerCertManagerPkgApisCertmanagerV1CertificateKeystores = githubComCertManagerCertManagerPkgApisCertmanagerV1CertificateKeystores;
    }

    @JsonProperty("github_com_cert-manager_cert-manager_pkg_apis_certmanager_v1_CertificateList")
    public CertificateList getGithubComCertManagerCertManagerPkgApisCertmanagerV1CertificateList() {
        return githubComCertManagerCertManagerPkgApisCertmanagerV1CertificateList;
    }

    @JsonProperty("github_com_cert-manager_cert-manager_pkg_apis_certmanager_v1_CertificateList")
    public void setGithubComCertManagerCertManagerPkgApisCertmanagerV1CertificateList(CertificateList githubComCertManagerCertManagerPkgApisCertmanagerV1CertificateList) {
        this.githubComCertManagerCertManagerPkgApisCertmanagerV1CertificateList = githubComCertManagerCertManagerPkgApisCertmanagerV1CertificateList;
    }

    @JsonProperty("github_com_cert-manager_cert-manager_pkg_apis_certmanager_v1_CertificatePrivateKey")
    public CertificatePrivateKey getGithubComCertManagerCertManagerPkgApisCertmanagerV1CertificatePrivateKey() {
        return githubComCertManagerCertManagerPkgApisCertmanagerV1CertificatePrivateKey;
    }

    @JsonProperty("github_com_cert-manager_cert-manager_pkg_apis_certmanager_v1_CertificatePrivateKey")
    public void setGithubComCertManagerCertManagerPkgApisCertmanagerV1CertificatePrivateKey(CertificatePrivateKey githubComCertManagerCertManagerPkgApisCertmanagerV1CertificatePrivateKey) {
        this.githubComCertManagerCertManagerPkgApisCertmanagerV1CertificatePrivateKey = githubComCertManagerCertManagerPkgApisCertmanagerV1CertificatePrivateKey;
    }

    @JsonProperty("github_com_cert-manager_cert-manager_pkg_apis_certmanager_v1_CertificateRequest")
    public CertificateRequest getGithubComCertManagerCertManagerPkgApisCertmanagerV1CertificateRequest() {
        return githubComCertManagerCertManagerPkgApisCertmanagerV1CertificateRequest;
    }

    @JsonProperty("github_com_cert-manager_cert-manager_pkg_apis_certmanager_v1_CertificateRequest")
    public void setGithubComCertManagerCertManagerPkgApisCertmanagerV1CertificateRequest(CertificateRequest githubComCertManagerCertManagerPkgApisCertmanagerV1CertificateRequest) {
        this.githubComCertManagerCertManagerPkgApisCertmanagerV1CertificateRequest = githubComCertManagerCertManagerPkgApisCertmanagerV1CertificateRequest;
    }

    @JsonProperty("github_com_cert-manager_cert-manager_pkg_apis_certmanager_v1_CertificateRequestCondition")
    public CertificateRequestCondition getGithubComCertManagerCertManagerPkgApisCertmanagerV1CertificateRequestCondition() {
        return githubComCertManagerCertManagerPkgApisCertmanagerV1CertificateRequestCondition;
    }

    @JsonProperty("github_com_cert-manager_cert-manager_pkg_apis_certmanager_v1_CertificateRequestCondition")
    public void setGithubComCertManagerCertManagerPkgApisCertmanagerV1CertificateRequestCondition(CertificateRequestCondition githubComCertManagerCertManagerPkgApisCertmanagerV1CertificateRequestCondition) {
        this.githubComCertManagerCertManagerPkgApisCertmanagerV1CertificateRequestCondition = githubComCertManagerCertManagerPkgApisCertmanagerV1CertificateRequestCondition;
    }

    @JsonProperty("github_com_cert-manager_cert-manager_pkg_apis_certmanager_v1_CertificateRequestList")
    public CertificateRequestList getGithubComCertManagerCertManagerPkgApisCertmanagerV1CertificateRequestList() {
        return githubComCertManagerCertManagerPkgApisCertmanagerV1CertificateRequestList;
    }

    @JsonProperty("github_com_cert-manager_cert-manager_pkg_apis_certmanager_v1_CertificateRequestList")
    public void setGithubComCertManagerCertManagerPkgApisCertmanagerV1CertificateRequestList(CertificateRequestList githubComCertManagerCertManagerPkgApisCertmanagerV1CertificateRequestList) {
        this.githubComCertManagerCertManagerPkgApisCertmanagerV1CertificateRequestList = githubComCertManagerCertManagerPkgApisCertmanagerV1CertificateRequestList;
    }

    @JsonProperty("github_com_cert-manager_cert-manager_pkg_apis_certmanager_v1_CertificateRequestSpec")
    public CertificateRequestSpec getGithubComCertManagerCertManagerPkgApisCertmanagerV1CertificateRequestSpec() {
        return githubComCertManagerCertManagerPkgApisCertmanagerV1CertificateRequestSpec;
    }

    @JsonProperty("github_com_cert-manager_cert-manager_pkg_apis_certmanager_v1_CertificateRequestSpec")
    public void setGithubComCertManagerCertManagerPkgApisCertmanagerV1CertificateRequestSpec(CertificateRequestSpec githubComCertManagerCertManagerPkgApisCertmanagerV1CertificateRequestSpec) {
        this.githubComCertManagerCertManagerPkgApisCertmanagerV1CertificateRequestSpec = githubComCertManagerCertManagerPkgApisCertmanagerV1CertificateRequestSpec;
    }

    @JsonProperty("github_com_cert-manager_cert-manager_pkg_apis_certmanager_v1_CertificateRequestStatus")
    public CertificateRequestStatus getGithubComCertManagerCertManagerPkgApisCertmanagerV1CertificateRequestStatus() {
        return githubComCertManagerCertManagerPkgApisCertmanagerV1CertificateRequestStatus;
    }

    @JsonProperty("github_com_cert-manager_cert-manager_pkg_apis_certmanager_v1_CertificateRequestStatus")
    public void setGithubComCertManagerCertManagerPkgApisCertmanagerV1CertificateRequestStatus(CertificateRequestStatus githubComCertManagerCertManagerPkgApisCertmanagerV1CertificateRequestStatus) {
        this.githubComCertManagerCertManagerPkgApisCertmanagerV1CertificateRequestStatus = githubComCertManagerCertManagerPkgApisCertmanagerV1CertificateRequestStatus;
    }

    @JsonProperty("github_com_cert-manager_cert-manager_pkg_apis_certmanager_v1_CertificateSecretTemplate")
    public CertificateSecretTemplate getGithubComCertManagerCertManagerPkgApisCertmanagerV1CertificateSecretTemplate() {
        return githubComCertManagerCertManagerPkgApisCertmanagerV1CertificateSecretTemplate;
    }

    @JsonProperty("github_com_cert-manager_cert-manager_pkg_apis_certmanager_v1_CertificateSecretTemplate")
    public void setGithubComCertManagerCertManagerPkgApisCertmanagerV1CertificateSecretTemplate(CertificateSecretTemplate githubComCertManagerCertManagerPkgApisCertmanagerV1CertificateSecretTemplate) {
        this.githubComCertManagerCertManagerPkgApisCertmanagerV1CertificateSecretTemplate = githubComCertManagerCertManagerPkgApisCertmanagerV1CertificateSecretTemplate;
    }

    @JsonProperty("github_com_cert-manager_cert-manager_pkg_apis_certmanager_v1_CertificateSpec")
    public CertificateSpec getGithubComCertManagerCertManagerPkgApisCertmanagerV1CertificateSpec() {
        return githubComCertManagerCertManagerPkgApisCertmanagerV1CertificateSpec;
    }

    @JsonProperty("github_com_cert-manager_cert-manager_pkg_apis_certmanager_v1_CertificateSpec")
    public void setGithubComCertManagerCertManagerPkgApisCertmanagerV1CertificateSpec(CertificateSpec githubComCertManagerCertManagerPkgApisCertmanagerV1CertificateSpec) {
        this.githubComCertManagerCertManagerPkgApisCertmanagerV1CertificateSpec = githubComCertManagerCertManagerPkgApisCertmanagerV1CertificateSpec;
    }

    @JsonProperty("github_com_cert-manager_cert-manager_pkg_apis_certmanager_v1_CertificateStatus")
    public CertificateStatus getGithubComCertManagerCertManagerPkgApisCertmanagerV1CertificateStatus() {
        return githubComCertManagerCertManagerPkgApisCertmanagerV1CertificateStatus;
    }

    @JsonProperty("github_com_cert-manager_cert-manager_pkg_apis_certmanager_v1_CertificateStatus")
    public void setGithubComCertManagerCertManagerPkgApisCertmanagerV1CertificateStatus(CertificateStatus githubComCertManagerCertManagerPkgApisCertmanagerV1CertificateStatus) {
        this.githubComCertManagerCertManagerPkgApisCertmanagerV1CertificateStatus = githubComCertManagerCertManagerPkgApisCertmanagerV1CertificateStatus;
    }

    @JsonProperty("github_com_cert-manager_cert-manager_pkg_apis_certmanager_v1_ClusterIssuer")
    public ClusterIssuer getGithubComCertManagerCertManagerPkgApisCertmanagerV1ClusterIssuer() {
        return githubComCertManagerCertManagerPkgApisCertmanagerV1ClusterIssuer;
    }

    @JsonProperty("github_com_cert-manager_cert-manager_pkg_apis_certmanager_v1_ClusterIssuer")
    public void setGithubComCertManagerCertManagerPkgApisCertmanagerV1ClusterIssuer(ClusterIssuer githubComCertManagerCertManagerPkgApisCertmanagerV1ClusterIssuer) {
        this.githubComCertManagerCertManagerPkgApisCertmanagerV1ClusterIssuer = githubComCertManagerCertManagerPkgApisCertmanagerV1ClusterIssuer;
    }

    @JsonProperty("github_com_cert-manager_cert-manager_pkg_apis_certmanager_v1_ClusterIssuerList")
    public ClusterIssuerList getGithubComCertManagerCertManagerPkgApisCertmanagerV1ClusterIssuerList() {
        return githubComCertManagerCertManagerPkgApisCertmanagerV1ClusterIssuerList;
    }

    @JsonProperty("github_com_cert-manager_cert-manager_pkg_apis_certmanager_v1_ClusterIssuerList")
    public void setGithubComCertManagerCertManagerPkgApisCertmanagerV1ClusterIssuerList(ClusterIssuerList githubComCertManagerCertManagerPkgApisCertmanagerV1ClusterIssuerList) {
        this.githubComCertManagerCertManagerPkgApisCertmanagerV1ClusterIssuerList = githubComCertManagerCertManagerPkgApisCertmanagerV1ClusterIssuerList;
    }

    @JsonProperty("github_com_cert-manager_cert-manager_pkg_apis_certmanager_v1_Issuer")
    public Issuer getGithubComCertManagerCertManagerPkgApisCertmanagerV1Issuer() {
        return githubComCertManagerCertManagerPkgApisCertmanagerV1Issuer;
    }

    @JsonProperty("github_com_cert-manager_cert-manager_pkg_apis_certmanager_v1_Issuer")
    public void setGithubComCertManagerCertManagerPkgApisCertmanagerV1Issuer(Issuer githubComCertManagerCertManagerPkgApisCertmanagerV1Issuer) {
        this.githubComCertManagerCertManagerPkgApisCertmanagerV1Issuer = githubComCertManagerCertManagerPkgApisCertmanagerV1Issuer;
    }

    @JsonProperty("github_com_cert-manager_cert-manager_pkg_apis_certmanager_v1_IssuerCondition")
    public IssuerCondition getGithubComCertManagerCertManagerPkgApisCertmanagerV1IssuerCondition() {
        return githubComCertManagerCertManagerPkgApisCertmanagerV1IssuerCondition;
    }

    @JsonProperty("github_com_cert-manager_cert-manager_pkg_apis_certmanager_v1_IssuerCondition")
    public void setGithubComCertManagerCertManagerPkgApisCertmanagerV1IssuerCondition(IssuerCondition githubComCertManagerCertManagerPkgApisCertmanagerV1IssuerCondition) {
        this.githubComCertManagerCertManagerPkgApisCertmanagerV1IssuerCondition = githubComCertManagerCertManagerPkgApisCertmanagerV1IssuerCondition;
    }

    @JsonProperty("github_com_cert-manager_cert-manager_pkg_apis_certmanager_v1_IssuerList")
    public IssuerList getGithubComCertManagerCertManagerPkgApisCertmanagerV1IssuerList() {
        return githubComCertManagerCertManagerPkgApisCertmanagerV1IssuerList;
    }

    @JsonProperty("github_com_cert-manager_cert-manager_pkg_apis_certmanager_v1_IssuerList")
    public void setGithubComCertManagerCertManagerPkgApisCertmanagerV1IssuerList(IssuerList githubComCertManagerCertManagerPkgApisCertmanagerV1IssuerList) {
        this.githubComCertManagerCertManagerPkgApisCertmanagerV1IssuerList = githubComCertManagerCertManagerPkgApisCertmanagerV1IssuerList;
    }

    @JsonProperty("github_com_cert-manager_cert-manager_pkg_apis_certmanager_v1_IssuerSpec")
    public IssuerSpec getGithubComCertManagerCertManagerPkgApisCertmanagerV1IssuerSpec() {
        return githubComCertManagerCertManagerPkgApisCertmanagerV1IssuerSpec;
    }

    @JsonProperty("github_com_cert-manager_cert-manager_pkg_apis_certmanager_v1_IssuerSpec")
    public void setGithubComCertManagerCertManagerPkgApisCertmanagerV1IssuerSpec(IssuerSpec githubComCertManagerCertManagerPkgApisCertmanagerV1IssuerSpec) {
        this.githubComCertManagerCertManagerPkgApisCertmanagerV1IssuerSpec = githubComCertManagerCertManagerPkgApisCertmanagerV1IssuerSpec;
    }

    @JsonProperty("github_com_cert-manager_cert-manager_pkg_apis_certmanager_v1_IssuerStatus")
    public IssuerStatus getGithubComCertManagerCertManagerPkgApisCertmanagerV1IssuerStatus() {
        return githubComCertManagerCertManagerPkgApisCertmanagerV1IssuerStatus;
    }

    @JsonProperty("github_com_cert-manager_cert-manager_pkg_apis_certmanager_v1_IssuerStatus")
    public void setGithubComCertManagerCertManagerPkgApisCertmanagerV1IssuerStatus(IssuerStatus githubComCertManagerCertManagerPkgApisCertmanagerV1IssuerStatus) {
        this.githubComCertManagerCertManagerPkgApisCertmanagerV1IssuerStatus = githubComCertManagerCertManagerPkgApisCertmanagerV1IssuerStatus;
    }

    @JsonProperty("github_com_cert-manager_cert-manager_pkg_apis_certmanager_v1_JKSKeystore")
    public JKSKeystore getGithubComCertManagerCertManagerPkgApisCertmanagerV1JKSKeystore() {
        return githubComCertManagerCertManagerPkgApisCertmanagerV1JKSKeystore;
    }

    @JsonProperty("github_com_cert-manager_cert-manager_pkg_apis_certmanager_v1_JKSKeystore")
    public void setGithubComCertManagerCertManagerPkgApisCertmanagerV1JKSKeystore(JKSKeystore githubComCertManagerCertManagerPkgApisCertmanagerV1JKSKeystore) {
        this.githubComCertManagerCertManagerPkgApisCertmanagerV1JKSKeystore = githubComCertManagerCertManagerPkgApisCertmanagerV1JKSKeystore;
    }

    @JsonProperty("github_com_cert-manager_cert-manager_pkg_apis_certmanager_v1_PKCS12Keystore")
    public PKCS12Keystore getGithubComCertManagerCertManagerPkgApisCertmanagerV1PKCS12Keystore() {
        return githubComCertManagerCertManagerPkgApisCertmanagerV1PKCS12Keystore;
    }

    @JsonProperty("github_com_cert-manager_cert-manager_pkg_apis_certmanager_v1_PKCS12Keystore")
    public void setGithubComCertManagerCertManagerPkgApisCertmanagerV1PKCS12Keystore(PKCS12Keystore githubComCertManagerCertManagerPkgApisCertmanagerV1PKCS12Keystore) {
        this.githubComCertManagerCertManagerPkgApisCertmanagerV1PKCS12Keystore = githubComCertManagerCertManagerPkgApisCertmanagerV1PKCS12Keystore;
    }

    @JsonProperty("github_com_cert-manager_cert-manager_pkg_apis_certmanager_v1_SelfSignedIssuer")
    public SelfSignedIssuer getGithubComCertManagerCertManagerPkgApisCertmanagerV1SelfSignedIssuer() {
        return githubComCertManagerCertManagerPkgApisCertmanagerV1SelfSignedIssuer;
    }

    @JsonProperty("github_com_cert-manager_cert-manager_pkg_apis_certmanager_v1_SelfSignedIssuer")
    public void setGithubComCertManagerCertManagerPkgApisCertmanagerV1SelfSignedIssuer(SelfSignedIssuer githubComCertManagerCertManagerPkgApisCertmanagerV1SelfSignedIssuer) {
        this.githubComCertManagerCertManagerPkgApisCertmanagerV1SelfSignedIssuer = githubComCertManagerCertManagerPkgApisCertmanagerV1SelfSignedIssuer;
    }

    @JsonProperty("github_com_cert-manager_cert-manager_pkg_apis_certmanager_v1_VaultAppRole")
    public VaultAppRole getGithubComCertManagerCertManagerPkgApisCertmanagerV1VaultAppRole() {
        return githubComCertManagerCertManagerPkgApisCertmanagerV1VaultAppRole;
    }

    @JsonProperty("github_com_cert-manager_cert-manager_pkg_apis_certmanager_v1_VaultAppRole")
    public void setGithubComCertManagerCertManagerPkgApisCertmanagerV1VaultAppRole(VaultAppRole githubComCertManagerCertManagerPkgApisCertmanagerV1VaultAppRole) {
        this.githubComCertManagerCertManagerPkgApisCertmanagerV1VaultAppRole = githubComCertManagerCertManagerPkgApisCertmanagerV1VaultAppRole;
    }

    @JsonProperty("github_com_cert-manager_cert-manager_pkg_apis_certmanager_v1_VaultAuth")
    public VaultAuth getGithubComCertManagerCertManagerPkgApisCertmanagerV1VaultAuth() {
        return githubComCertManagerCertManagerPkgApisCertmanagerV1VaultAuth;
    }

    @JsonProperty("github_com_cert-manager_cert-manager_pkg_apis_certmanager_v1_VaultAuth")
    public void setGithubComCertManagerCertManagerPkgApisCertmanagerV1VaultAuth(VaultAuth githubComCertManagerCertManagerPkgApisCertmanagerV1VaultAuth) {
        this.githubComCertManagerCertManagerPkgApisCertmanagerV1VaultAuth = githubComCertManagerCertManagerPkgApisCertmanagerV1VaultAuth;
    }

    @JsonProperty("github_com_cert-manager_cert-manager_pkg_apis_certmanager_v1_VaultIssuer")
    public VaultIssuer getGithubComCertManagerCertManagerPkgApisCertmanagerV1VaultIssuer() {
        return githubComCertManagerCertManagerPkgApisCertmanagerV1VaultIssuer;
    }

    @JsonProperty("github_com_cert-manager_cert-manager_pkg_apis_certmanager_v1_VaultIssuer")
    public void setGithubComCertManagerCertManagerPkgApisCertmanagerV1VaultIssuer(VaultIssuer githubComCertManagerCertManagerPkgApisCertmanagerV1VaultIssuer) {
        this.githubComCertManagerCertManagerPkgApisCertmanagerV1VaultIssuer = githubComCertManagerCertManagerPkgApisCertmanagerV1VaultIssuer;
    }

    @JsonProperty("github_com_cert-manager_cert-manager_pkg_apis_certmanager_v1_VaultKubernetesAuth")
    public VaultKubernetesAuth getGithubComCertManagerCertManagerPkgApisCertmanagerV1VaultKubernetesAuth() {
        return githubComCertManagerCertManagerPkgApisCertmanagerV1VaultKubernetesAuth;
    }

    @JsonProperty("github_com_cert-manager_cert-manager_pkg_apis_certmanager_v1_VaultKubernetesAuth")
    public void setGithubComCertManagerCertManagerPkgApisCertmanagerV1VaultKubernetesAuth(VaultKubernetesAuth githubComCertManagerCertManagerPkgApisCertmanagerV1VaultKubernetesAuth) {
        this.githubComCertManagerCertManagerPkgApisCertmanagerV1VaultKubernetesAuth = githubComCertManagerCertManagerPkgApisCertmanagerV1VaultKubernetesAuth;
    }

    @JsonProperty("github_com_cert-manager_cert-manager_pkg_apis_certmanager_v1_VenafiCloud")
    public VenafiCloud getGithubComCertManagerCertManagerPkgApisCertmanagerV1VenafiCloud() {
        return githubComCertManagerCertManagerPkgApisCertmanagerV1VenafiCloud;
    }

    @JsonProperty("github_com_cert-manager_cert-manager_pkg_apis_certmanager_v1_VenafiCloud")
    public void setGithubComCertManagerCertManagerPkgApisCertmanagerV1VenafiCloud(VenafiCloud githubComCertManagerCertManagerPkgApisCertmanagerV1VenafiCloud) {
        this.githubComCertManagerCertManagerPkgApisCertmanagerV1VenafiCloud = githubComCertManagerCertManagerPkgApisCertmanagerV1VenafiCloud;
    }

    @JsonProperty("github_com_cert-manager_cert-manager_pkg_apis_certmanager_v1_VenafiIssuer")
    public VenafiIssuer getGithubComCertManagerCertManagerPkgApisCertmanagerV1VenafiIssuer() {
        return githubComCertManagerCertManagerPkgApisCertmanagerV1VenafiIssuer;
    }

    @JsonProperty("github_com_cert-manager_cert-manager_pkg_apis_certmanager_v1_VenafiIssuer")
    public void setGithubComCertManagerCertManagerPkgApisCertmanagerV1VenafiIssuer(VenafiIssuer githubComCertManagerCertManagerPkgApisCertmanagerV1VenafiIssuer) {
        this.githubComCertManagerCertManagerPkgApisCertmanagerV1VenafiIssuer = githubComCertManagerCertManagerPkgApisCertmanagerV1VenafiIssuer;
    }

    @JsonProperty("github_com_cert-manager_cert-manager_pkg_apis_certmanager_v1_VenafiTPP")
    public VenafiTPP getGithubComCertManagerCertManagerPkgApisCertmanagerV1VenafiTPP() {
        return githubComCertManagerCertManagerPkgApisCertmanagerV1VenafiTPP;
    }

    @JsonProperty("github_com_cert-manager_cert-manager_pkg_apis_certmanager_v1_VenafiTPP")
    public void setGithubComCertManagerCertManagerPkgApisCertmanagerV1VenafiTPP(VenafiTPP githubComCertManagerCertManagerPkgApisCertmanagerV1VenafiTPP) {
        this.githubComCertManagerCertManagerPkgApisCertmanagerV1VenafiTPP = githubComCertManagerCertManagerPkgApisCertmanagerV1VenafiTPP;
    }

    @JsonProperty("github_com_cert-manager_cert-manager_pkg_apis_certmanager_v1_X509Subject")
    public X509Subject getGithubComCertManagerCertManagerPkgApisCertmanagerV1X509Subject() {
        return githubComCertManagerCertManagerPkgApisCertmanagerV1X509Subject;
    }

    @JsonProperty("github_com_cert-manager_cert-manager_pkg_apis_certmanager_v1_X509Subject")
    public void setGithubComCertManagerCertManagerPkgApisCertmanagerV1X509Subject(X509Subject githubComCertManagerCertManagerPkgApisCertmanagerV1X509Subject) {
        this.githubComCertManagerCertManagerPkgApisCertmanagerV1X509Subject = githubComCertManagerCertManagerPkgApisCertmanagerV1X509Subject;
    }

    @JsonProperty("github_com_cert-manager_cert-manager_pkg_apis_meta_v1_LocalObjectReference")
    public io.fabric8.certmanager.api.model.meta.v1.LocalObjectReference getGithubComCertManagerCertManagerPkgApisMetaV1LocalObjectReference() {
        return githubComCertManagerCertManagerPkgApisMetaV1LocalObjectReference;
    }

    @JsonProperty("github_com_cert-manager_cert-manager_pkg_apis_meta_v1_LocalObjectReference")
    public void setGithubComCertManagerCertManagerPkgApisMetaV1LocalObjectReference(io.fabric8.certmanager.api.model.meta.v1.LocalObjectReference githubComCertManagerCertManagerPkgApisMetaV1LocalObjectReference) {
        this.githubComCertManagerCertManagerPkgApisMetaV1LocalObjectReference = githubComCertManagerCertManagerPkgApisMetaV1LocalObjectReference;
    }

    @JsonProperty("github_com_cert-manager_cert-manager_pkg_apis_meta_v1_ObjectReference")
    public io.fabric8.certmanager.api.model.meta.v1.ObjectReference getGithubComCertManagerCertManagerPkgApisMetaV1ObjectReference() {
        return githubComCertManagerCertManagerPkgApisMetaV1ObjectReference;
    }

    @JsonProperty("github_com_cert-manager_cert-manager_pkg_apis_meta_v1_ObjectReference")
    public void setGithubComCertManagerCertManagerPkgApisMetaV1ObjectReference(io.fabric8.certmanager.api.model.meta.v1.ObjectReference githubComCertManagerCertManagerPkgApisMetaV1ObjectReference) {
        this.githubComCertManagerCertManagerPkgApisMetaV1ObjectReference = githubComCertManagerCertManagerPkgApisMetaV1ObjectReference;
    }

    @JsonProperty("github_com_cert-manager_cert-manager_pkg_apis_meta_v1_SecretKeySelector")
    public SecretKeySelector getGithubComCertManagerCertManagerPkgApisMetaV1SecretKeySelector() {
        return githubComCertManagerCertManagerPkgApisMetaV1SecretKeySelector;
    }

    @JsonProperty("github_com_cert-manager_cert-manager_pkg_apis_meta_v1_SecretKeySelector")
    public void setGithubComCertManagerCertManagerPkgApisMetaV1SecretKeySelector(SecretKeySelector githubComCertManagerCertManagerPkgApisMetaV1SecretKeySelector) {
        this.githubComCertManagerCertManagerPkgApisMetaV1SecretKeySelector = githubComCertManagerCertManagerPkgApisMetaV1SecretKeySelector;
    }

}
