
package io.fabric8.certmanager.api.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import io.fabric8.certmanager.api.model.acme.v1.ACMEAuthorization;
import io.fabric8.certmanager.api.model.acme.v1.ACMEChallenge;
import io.fabric8.certmanager.api.model.acme.v1.ACMEChallengeSolver;
import io.fabric8.certmanager.api.model.acme.v1.ACMEChallengeSolverDNS01;
import io.fabric8.certmanager.api.model.acme.v1.ACMEChallengeSolverHTTP01;
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
import io.fabric8.certmanager.api.model.v1.CertificateCondition;
import io.fabric8.certmanager.api.model.v1.CertificateKeystores;
import io.fabric8.certmanager.api.model.v1.CertificateList;
import io.fabric8.certmanager.api.model.v1.CertificatePrivateKey;
import io.fabric8.certmanager.api.model.v1.CertificateRequest;
import io.fabric8.certmanager.api.model.v1.CertificateRequestCondition;
import io.fabric8.certmanager.api.model.v1.CertificateRequestList;
import io.fabric8.certmanager.api.model.v1.CertificateRequestSpec;
import io.fabric8.certmanager.api.model.v1.CertificateRequestStatus;
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
    "github_com_jetstack_cert-manager_pkg_apis_acme_v1_ACMEAuthorization",
    "github_com_jetstack_cert-manager_pkg_apis_acme_v1_ACMEChallenge",
    "github_com_jetstack_cert-manager_pkg_apis_acme_v1_ACMEChallengeSolver",
    "github_com_jetstack_cert-manager_pkg_apis_acme_v1_ACMEChallengeSolverDNS01",
    "github_com_jetstack_cert-manager_pkg_apis_acme_v1_ACMEChallengeSolverHTTP01",
    "github_com_jetstack_cert-manager_pkg_apis_acme_v1_ACMEChallengeSolverHTTP01Ingress",
    "github_com_jetstack_cert-manager_pkg_apis_acme_v1_ACMEChallengeSolverHTTP01IngressObjectMeta",
    "github_com_jetstack_cert-manager_pkg_apis_acme_v1_ACMEChallengeSolverHTTP01IngressPodObjectMeta",
    "github_com_jetstack_cert-manager_pkg_apis_acme_v1_ACMEChallengeSolverHTTP01IngressPodSpec",
    "github_com_jetstack_cert-manager_pkg_apis_acme_v1_ACMEChallengeSolverHTTP01IngressPodTemplate",
    "github_com_jetstack_cert-manager_pkg_apis_acme_v1_ACMEChallengeSolverHTTP01IngressTemplate",
    "github_com_jetstack_cert-manager_pkg_apis_acme_v1_ACMEExternalAccountBinding",
    "github_com_jetstack_cert-manager_pkg_apis_acme_v1_ACMEIssuer",
    "github_com_jetstack_cert-manager_pkg_apis_acme_v1_ACMEIssuerDNS01ProviderAcmeDNS",
    "github_com_jetstack_cert-manager_pkg_apis_acme_v1_ACMEIssuerDNS01ProviderAkamai",
    "github_com_jetstack_cert-manager_pkg_apis_acme_v1_ACMEIssuerDNS01ProviderAzureDNS",
    "github_com_jetstack_cert-manager_pkg_apis_acme_v1_ACMEIssuerDNS01ProviderCloudDNS",
    "github_com_jetstack_cert-manager_pkg_apis_acme_v1_ACMEIssuerDNS01ProviderCloudflare",
    "github_com_jetstack_cert-manager_pkg_apis_acme_v1_ACMEIssuerDNS01ProviderDigitalOcean",
    "github_com_jetstack_cert-manager_pkg_apis_acme_v1_ACMEIssuerDNS01ProviderRFC2136",
    "github_com_jetstack_cert-manager_pkg_apis_acme_v1_ACMEIssuerDNS01ProviderRoute53",
    "github_com_jetstack_cert-manager_pkg_apis_acme_v1_ACMEIssuerDNS01ProviderWebhook",
    "github_com_jetstack_cert-manager_pkg_apis_acme_v1_ACMEIssuerStatus",
    "github_com_jetstack_cert-manager_pkg_apis_acme_v1_CertificateDNSNameSelector",
    "github_com_jetstack_cert-manager_pkg_apis_acme_v1_Challenge",
    "github_com_jetstack_cert-manager_pkg_apis_acme_v1_ChallengeList",
    "github_com_jetstack_cert-manager_pkg_apis_acme_v1_ChallengeSpec",
    "github_com_jetstack_cert-manager_pkg_apis_acme_v1_ChallengeStatus",
    "github_com_jetstack_cert-manager_pkg_apis_acme_v1_Order",
    "github_com_jetstack_cert-manager_pkg_apis_acme_v1_OrderList",
    "github_com_jetstack_cert-manager_pkg_apis_acme_v1_OrderSpec",
    "github_com_jetstack_cert-manager_pkg_apis_acme_v1_OrderStatus",
    "github_com_jetstack_cert-manager_pkg_apis_certmanager_v1_CAIssuer",
    "github_com_jetstack_cert-manager_pkg_apis_certmanager_v1_Certificate",
    "github_com_jetstack_cert-manager_pkg_apis_certmanager_v1_CertificateCondition",
    "github_com_jetstack_cert-manager_pkg_apis_certmanager_v1_CertificateKeystores",
    "github_com_jetstack_cert-manager_pkg_apis_certmanager_v1_CertificateList",
    "github_com_jetstack_cert-manager_pkg_apis_certmanager_v1_CertificatePrivateKey",
    "github_com_jetstack_cert-manager_pkg_apis_certmanager_v1_CertificateRequest",
    "github_com_jetstack_cert-manager_pkg_apis_certmanager_v1_CertificateRequestCondition",
    "github_com_jetstack_cert-manager_pkg_apis_certmanager_v1_CertificateRequestList",
    "github_com_jetstack_cert-manager_pkg_apis_certmanager_v1_CertificateRequestSpec",
    "github_com_jetstack_cert-manager_pkg_apis_certmanager_v1_CertificateRequestStatus",
    "github_com_jetstack_cert-manager_pkg_apis_certmanager_v1_CertificateSpec",
    "github_com_jetstack_cert-manager_pkg_apis_certmanager_v1_CertificateStatus",
    "github_com_jetstack_cert-manager_pkg_apis_certmanager_v1_ClusterIssuer",
    "github_com_jetstack_cert-manager_pkg_apis_certmanager_v1_ClusterIssuerList",
    "github_com_jetstack_cert-manager_pkg_apis_certmanager_v1_Issuer",
    "github_com_jetstack_cert-manager_pkg_apis_certmanager_v1_IssuerCondition",
    "github_com_jetstack_cert-manager_pkg_apis_certmanager_v1_IssuerList",
    "github_com_jetstack_cert-manager_pkg_apis_certmanager_v1_IssuerSpec",
    "github_com_jetstack_cert-manager_pkg_apis_certmanager_v1_IssuerStatus",
    "github_com_jetstack_cert-manager_pkg_apis_certmanager_v1_JKSKeystore",
    "github_com_jetstack_cert-manager_pkg_apis_certmanager_v1_PKCS12Keystore",
    "github_com_jetstack_cert-manager_pkg_apis_certmanager_v1_SelfSignedIssuer",
    "github_com_jetstack_cert-manager_pkg_apis_certmanager_v1_VaultAppRole",
    "github_com_jetstack_cert-manager_pkg_apis_certmanager_v1_VaultAuth",
    "github_com_jetstack_cert-manager_pkg_apis_certmanager_v1_VaultIssuer",
    "github_com_jetstack_cert-manager_pkg_apis_certmanager_v1_VaultKubernetesAuth",
    "github_com_jetstack_cert-manager_pkg_apis_certmanager_v1_VenafiCloud",
    "github_com_jetstack_cert-manager_pkg_apis_certmanager_v1_VenafiIssuer",
    "github_com_jetstack_cert-manager_pkg_apis_certmanager_v1_VenafiTPP",
    "github_com_jetstack_cert-manager_pkg_apis_certmanager_v1_X509Subject",
    "github_com_jetstack_cert-manager_pkg_apis_meta_v1_LocalObjectReference",
    "github_com_jetstack_cert-manager_pkg_apis_meta_v1_ObjectReference",
    "github_com_jetstack_cert-manager_pkg_apis_meta_v1_SecretKeySelector"
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
public class CertmanagerSchema {

    @JsonProperty("github_com_jetstack_cert-manager_pkg_apis_acme_v1_ACMEAuthorization")
    private ACMEAuthorization githubComJetstackCertManagerPkgApisAcmeV1ACMEAuthorization;
    @JsonProperty("github_com_jetstack_cert-manager_pkg_apis_acme_v1_ACMEChallenge")
    private ACMEChallenge githubComJetstackCertManagerPkgApisAcmeV1ACMEChallenge;
    @JsonProperty("github_com_jetstack_cert-manager_pkg_apis_acme_v1_ACMEChallengeSolver")
    private ACMEChallengeSolver githubComJetstackCertManagerPkgApisAcmeV1ACMEChallengeSolver;
    @JsonProperty("github_com_jetstack_cert-manager_pkg_apis_acme_v1_ACMEChallengeSolverDNS01")
    private ACMEChallengeSolverDNS01 githubComJetstackCertManagerPkgApisAcmeV1ACMEChallengeSolverDNS01;
    @JsonProperty("github_com_jetstack_cert-manager_pkg_apis_acme_v1_ACMEChallengeSolverHTTP01")
    private ACMEChallengeSolverHTTP01 githubComJetstackCertManagerPkgApisAcmeV1ACMEChallengeSolverHTTP01;
    @JsonProperty("github_com_jetstack_cert-manager_pkg_apis_acme_v1_ACMEChallengeSolverHTTP01Ingress")
    private ACMEChallengeSolverHTTP01Ingress githubComJetstackCertManagerPkgApisAcmeV1ACMEChallengeSolverHTTP01Ingress;
    @JsonProperty("github_com_jetstack_cert-manager_pkg_apis_acme_v1_ACMEChallengeSolverHTTP01IngressObjectMeta")
    private ACMEChallengeSolverHTTP01IngressObjectMeta githubComJetstackCertManagerPkgApisAcmeV1ACMEChallengeSolverHTTP01IngressObjectMeta;
    @JsonProperty("github_com_jetstack_cert-manager_pkg_apis_acme_v1_ACMEChallengeSolverHTTP01IngressPodObjectMeta")
    private ACMEChallengeSolverHTTP01IngressPodObjectMeta githubComJetstackCertManagerPkgApisAcmeV1ACMEChallengeSolverHTTP01IngressPodObjectMeta;
    @JsonProperty("github_com_jetstack_cert-manager_pkg_apis_acme_v1_ACMEChallengeSolverHTTP01IngressPodSpec")
    private ACMEChallengeSolverHTTP01IngressPodSpec githubComJetstackCertManagerPkgApisAcmeV1ACMEChallengeSolverHTTP01IngressPodSpec;
    @JsonProperty("github_com_jetstack_cert-manager_pkg_apis_acme_v1_ACMEChallengeSolverHTTP01IngressPodTemplate")
    private ACMEChallengeSolverHTTP01IngressPodTemplate githubComJetstackCertManagerPkgApisAcmeV1ACMEChallengeSolverHTTP01IngressPodTemplate;
    @JsonProperty("github_com_jetstack_cert-manager_pkg_apis_acme_v1_ACMEChallengeSolverHTTP01IngressTemplate")
    private ACMEChallengeSolverHTTP01IngressTemplate githubComJetstackCertManagerPkgApisAcmeV1ACMEChallengeSolverHTTP01IngressTemplate;
    @JsonProperty("github_com_jetstack_cert-manager_pkg_apis_acme_v1_ACMEExternalAccountBinding")
    private ACMEExternalAccountBinding githubComJetstackCertManagerPkgApisAcmeV1ACMEExternalAccountBinding;
    @JsonProperty("github_com_jetstack_cert-manager_pkg_apis_acme_v1_ACMEIssuer")
    private ACMEIssuer githubComJetstackCertManagerPkgApisAcmeV1ACMEIssuer;
    @JsonProperty("github_com_jetstack_cert-manager_pkg_apis_acme_v1_ACMEIssuerDNS01ProviderAcmeDNS")
    private ACMEIssuerDNS01ProviderAcmeDNS githubComJetstackCertManagerPkgApisAcmeV1ACMEIssuerDNS01ProviderAcmeDNS;
    @JsonProperty("github_com_jetstack_cert-manager_pkg_apis_acme_v1_ACMEIssuerDNS01ProviderAkamai")
    private ACMEIssuerDNS01ProviderAkamai githubComJetstackCertManagerPkgApisAcmeV1ACMEIssuerDNS01ProviderAkamai;
    @JsonProperty("github_com_jetstack_cert-manager_pkg_apis_acme_v1_ACMEIssuerDNS01ProviderAzureDNS")
    private ACMEIssuerDNS01ProviderAzureDNS githubComJetstackCertManagerPkgApisAcmeV1ACMEIssuerDNS01ProviderAzureDNS;
    @JsonProperty("github_com_jetstack_cert-manager_pkg_apis_acme_v1_ACMEIssuerDNS01ProviderCloudDNS")
    private ACMEIssuerDNS01ProviderCloudDNS githubComJetstackCertManagerPkgApisAcmeV1ACMEIssuerDNS01ProviderCloudDNS;
    @JsonProperty("github_com_jetstack_cert-manager_pkg_apis_acme_v1_ACMEIssuerDNS01ProviderCloudflare")
    private ACMEIssuerDNS01ProviderCloudflare githubComJetstackCertManagerPkgApisAcmeV1ACMEIssuerDNS01ProviderCloudflare;
    @JsonProperty("github_com_jetstack_cert-manager_pkg_apis_acme_v1_ACMEIssuerDNS01ProviderDigitalOcean")
    private ACMEIssuerDNS01ProviderDigitalOcean githubComJetstackCertManagerPkgApisAcmeV1ACMEIssuerDNS01ProviderDigitalOcean;
    @JsonProperty("github_com_jetstack_cert-manager_pkg_apis_acme_v1_ACMEIssuerDNS01ProviderRFC2136")
    private ACMEIssuerDNS01ProviderRFC2136 githubComJetstackCertManagerPkgApisAcmeV1ACMEIssuerDNS01ProviderRFC2136;
    @JsonProperty("github_com_jetstack_cert-manager_pkg_apis_acme_v1_ACMEIssuerDNS01ProviderRoute53")
    private ACMEIssuerDNS01ProviderRoute53 githubComJetstackCertManagerPkgApisAcmeV1ACMEIssuerDNS01ProviderRoute53;
    @JsonProperty("github_com_jetstack_cert-manager_pkg_apis_acme_v1_ACMEIssuerDNS01ProviderWebhook")
    private ACMEIssuerDNS01ProviderWebhook githubComJetstackCertManagerPkgApisAcmeV1ACMEIssuerDNS01ProviderWebhook;
    @JsonProperty("github_com_jetstack_cert-manager_pkg_apis_acme_v1_ACMEIssuerStatus")
    private ACMEIssuerStatus githubComJetstackCertManagerPkgApisAcmeV1ACMEIssuerStatus;
    @JsonProperty("github_com_jetstack_cert-manager_pkg_apis_acme_v1_CertificateDNSNameSelector")
    private CertificateDNSNameSelector githubComJetstackCertManagerPkgApisAcmeV1CertificateDNSNameSelector;
    @JsonProperty("github_com_jetstack_cert-manager_pkg_apis_acme_v1_Challenge")
    private Challenge githubComJetstackCertManagerPkgApisAcmeV1Challenge;
    @JsonProperty("github_com_jetstack_cert-manager_pkg_apis_acme_v1_ChallengeList")
    private ChallengeList githubComJetstackCertManagerPkgApisAcmeV1ChallengeList;
    @JsonProperty("github_com_jetstack_cert-manager_pkg_apis_acme_v1_ChallengeSpec")
    private ChallengeSpec githubComJetstackCertManagerPkgApisAcmeV1ChallengeSpec;
    @JsonProperty("github_com_jetstack_cert-manager_pkg_apis_acme_v1_ChallengeStatus")
    private ChallengeStatus githubComJetstackCertManagerPkgApisAcmeV1ChallengeStatus;
    @JsonProperty("github_com_jetstack_cert-manager_pkg_apis_acme_v1_Order")
    private Order githubComJetstackCertManagerPkgApisAcmeV1Order;
    @JsonProperty("github_com_jetstack_cert-manager_pkg_apis_acme_v1_OrderList")
    private OrderList githubComJetstackCertManagerPkgApisAcmeV1OrderList;
    @JsonProperty("github_com_jetstack_cert-manager_pkg_apis_acme_v1_OrderSpec")
    private OrderSpec githubComJetstackCertManagerPkgApisAcmeV1OrderSpec;
    @JsonProperty("github_com_jetstack_cert-manager_pkg_apis_acme_v1_OrderStatus")
    private OrderStatus githubComJetstackCertManagerPkgApisAcmeV1OrderStatus;
    @JsonProperty("github_com_jetstack_cert-manager_pkg_apis_certmanager_v1_CAIssuer")
    private CAIssuer githubComJetstackCertManagerPkgApisCertmanagerV1CAIssuer;
    @JsonProperty("github_com_jetstack_cert-manager_pkg_apis_certmanager_v1_Certificate")
    private Certificate githubComJetstackCertManagerPkgApisCertmanagerV1Certificate;
    @JsonProperty("github_com_jetstack_cert-manager_pkg_apis_certmanager_v1_CertificateCondition")
    private CertificateCondition githubComJetstackCertManagerPkgApisCertmanagerV1CertificateCondition;
    @JsonProperty("github_com_jetstack_cert-manager_pkg_apis_certmanager_v1_CertificateKeystores")
    private CertificateKeystores githubComJetstackCertManagerPkgApisCertmanagerV1CertificateKeystores;
    @JsonProperty("github_com_jetstack_cert-manager_pkg_apis_certmanager_v1_CertificateList")
    private CertificateList githubComJetstackCertManagerPkgApisCertmanagerV1CertificateList;
    @JsonProperty("github_com_jetstack_cert-manager_pkg_apis_certmanager_v1_CertificatePrivateKey")
    private CertificatePrivateKey githubComJetstackCertManagerPkgApisCertmanagerV1CertificatePrivateKey;
    @JsonProperty("github_com_jetstack_cert-manager_pkg_apis_certmanager_v1_CertificateRequest")
    private CertificateRequest githubComJetstackCertManagerPkgApisCertmanagerV1CertificateRequest;
    @JsonProperty("github_com_jetstack_cert-manager_pkg_apis_certmanager_v1_CertificateRequestCondition")
    private CertificateRequestCondition githubComJetstackCertManagerPkgApisCertmanagerV1CertificateRequestCondition;
    @JsonProperty("github_com_jetstack_cert-manager_pkg_apis_certmanager_v1_CertificateRequestList")
    private CertificateRequestList githubComJetstackCertManagerPkgApisCertmanagerV1CertificateRequestList;
    @JsonProperty("github_com_jetstack_cert-manager_pkg_apis_certmanager_v1_CertificateRequestSpec")
    private CertificateRequestSpec githubComJetstackCertManagerPkgApisCertmanagerV1CertificateRequestSpec;
    @JsonProperty("github_com_jetstack_cert-manager_pkg_apis_certmanager_v1_CertificateRequestStatus")
    private CertificateRequestStatus githubComJetstackCertManagerPkgApisCertmanagerV1CertificateRequestStatus;
    @JsonProperty("github_com_jetstack_cert-manager_pkg_apis_certmanager_v1_CertificateSpec")
    private CertificateSpec githubComJetstackCertManagerPkgApisCertmanagerV1CertificateSpec;
    @JsonProperty("github_com_jetstack_cert-manager_pkg_apis_certmanager_v1_CertificateStatus")
    private CertificateStatus githubComJetstackCertManagerPkgApisCertmanagerV1CertificateStatus;
    @JsonProperty("github_com_jetstack_cert-manager_pkg_apis_certmanager_v1_ClusterIssuer")
    private ClusterIssuer githubComJetstackCertManagerPkgApisCertmanagerV1ClusterIssuer;
    @JsonProperty("github_com_jetstack_cert-manager_pkg_apis_certmanager_v1_ClusterIssuerList")
    private ClusterIssuerList githubComJetstackCertManagerPkgApisCertmanagerV1ClusterIssuerList;
    @JsonProperty("github_com_jetstack_cert-manager_pkg_apis_certmanager_v1_Issuer")
    private Issuer githubComJetstackCertManagerPkgApisCertmanagerV1Issuer;
    @JsonProperty("github_com_jetstack_cert-manager_pkg_apis_certmanager_v1_IssuerCondition")
    private IssuerCondition githubComJetstackCertManagerPkgApisCertmanagerV1IssuerCondition;
    @JsonProperty("github_com_jetstack_cert-manager_pkg_apis_certmanager_v1_IssuerList")
    private IssuerList githubComJetstackCertManagerPkgApisCertmanagerV1IssuerList;
    @JsonProperty("github_com_jetstack_cert-manager_pkg_apis_certmanager_v1_IssuerSpec")
    private IssuerSpec githubComJetstackCertManagerPkgApisCertmanagerV1IssuerSpec;
    @JsonProperty("github_com_jetstack_cert-manager_pkg_apis_certmanager_v1_IssuerStatus")
    private IssuerStatus githubComJetstackCertManagerPkgApisCertmanagerV1IssuerStatus;
    @JsonProperty("github_com_jetstack_cert-manager_pkg_apis_certmanager_v1_JKSKeystore")
    private JKSKeystore githubComJetstackCertManagerPkgApisCertmanagerV1JKSKeystore;
    @JsonProperty("github_com_jetstack_cert-manager_pkg_apis_certmanager_v1_PKCS12Keystore")
    private PKCS12Keystore githubComJetstackCertManagerPkgApisCertmanagerV1PKCS12Keystore;
    @JsonProperty("github_com_jetstack_cert-manager_pkg_apis_certmanager_v1_SelfSignedIssuer")
    private SelfSignedIssuer githubComJetstackCertManagerPkgApisCertmanagerV1SelfSignedIssuer;
    @JsonProperty("github_com_jetstack_cert-manager_pkg_apis_certmanager_v1_VaultAppRole")
    private VaultAppRole githubComJetstackCertManagerPkgApisCertmanagerV1VaultAppRole;
    @JsonProperty("github_com_jetstack_cert-manager_pkg_apis_certmanager_v1_VaultAuth")
    private VaultAuth githubComJetstackCertManagerPkgApisCertmanagerV1VaultAuth;
    @JsonProperty("github_com_jetstack_cert-manager_pkg_apis_certmanager_v1_VaultIssuer")
    private VaultIssuer githubComJetstackCertManagerPkgApisCertmanagerV1VaultIssuer;
    @JsonProperty("github_com_jetstack_cert-manager_pkg_apis_certmanager_v1_VaultKubernetesAuth")
    private VaultKubernetesAuth githubComJetstackCertManagerPkgApisCertmanagerV1VaultKubernetesAuth;
    @JsonProperty("github_com_jetstack_cert-manager_pkg_apis_certmanager_v1_VenafiCloud")
    private VenafiCloud githubComJetstackCertManagerPkgApisCertmanagerV1VenafiCloud;
    @JsonProperty("github_com_jetstack_cert-manager_pkg_apis_certmanager_v1_VenafiIssuer")
    private VenafiIssuer githubComJetstackCertManagerPkgApisCertmanagerV1VenafiIssuer;
    @JsonProperty("github_com_jetstack_cert-manager_pkg_apis_certmanager_v1_VenafiTPP")
    private VenafiTPP githubComJetstackCertManagerPkgApisCertmanagerV1VenafiTPP;
    @JsonProperty("github_com_jetstack_cert-manager_pkg_apis_certmanager_v1_X509Subject")
    private X509Subject githubComJetstackCertManagerPkgApisCertmanagerV1X509Subject;
    @JsonProperty("github_com_jetstack_cert-manager_pkg_apis_meta_v1_LocalObjectReference")
    private io.fabric8.certmanager.api.model.meta.v1.LocalObjectReference githubComJetstackCertManagerPkgApisMetaV1LocalObjectReference;
    @JsonProperty("github_com_jetstack_cert-manager_pkg_apis_meta_v1_ObjectReference")
    private io.fabric8.certmanager.api.model.meta.v1.ObjectReference githubComJetstackCertManagerPkgApisMetaV1ObjectReference;
    @JsonProperty("github_com_jetstack_cert-manager_pkg_apis_meta_v1_SecretKeySelector")
    private SecretKeySelector githubComJetstackCertManagerPkgApisMetaV1SecretKeySelector;

    /**
     * No args constructor for use in serialization
     * 
     */
    public CertmanagerSchema() {
    }

    /**
     * 
     * @param githubComJetstackCertManagerPkgApisAcmeV1CertificateDNSNameSelector
     * @param githubComJetstackCertManagerPkgApisAcmeV1Challenge
     * @param githubComJetstackCertManagerPkgApisAcmeV1ACMEChallengeSolverHTTP01Ingress
     * @param githubComJetstackCertManagerPkgApisAcmeV1ACMEChallengeSolverHTTP01IngressPodObjectMeta
     * @param githubComJetstackCertManagerPkgApisAcmeV1ACMEChallengeSolverHTTP01IngressObjectMeta
     * @param githubComJetstackCertManagerPkgApisAcmeV1ACMEIssuerDNS01ProviderCloudflare
     * @param githubComJetstackCertManagerPkgApisCertmanagerV1VaultIssuer
     * @param githubComJetstackCertManagerPkgApisCertmanagerV1CertificateSpec
     * @param githubComJetstackCertManagerPkgApisAcmeV1ACMEAuthorization
     * @param githubComJetstackCertManagerPkgApisCertmanagerV1CertificateRequest
     * @param githubComJetstackCertManagerPkgApisCertmanagerV1Certificate
     * @param githubComJetstackCertManagerPkgApisCertmanagerV1PKCS12Keystore
     * @param githubComJetstackCertManagerPkgApisCertmanagerV1VenafiIssuer
     * @param githubComJetstackCertManagerPkgApisCertmanagerV1VaultAuth
     * @param githubComJetstackCertManagerPkgApisAcmeV1OrderList
     * @param githubComJetstackCertManagerPkgApisCertmanagerV1IssuerList
     * @param githubComJetstackCertManagerPkgApisAcmeV1ACMEChallengeSolverHTTP01
     * @param githubComJetstackCertManagerPkgApisCertmanagerV1VaultKubernetesAuth
     * @param githubComJetstackCertManagerPkgApisAcmeV1ACMEIssuerDNS01ProviderDigitalOcean
     * @param githubComJetstackCertManagerPkgApisMetaV1ObjectReference
     * @param githubComJetstackCertManagerPkgApisAcmeV1ChallengeStatus
     * @param githubComJetstackCertManagerPkgApisAcmeV1ACMEIssuerStatus
     * @param githubComJetstackCertManagerPkgApisCertmanagerV1CertificateRequestList
     * @param githubComJetstackCertManagerPkgApisCertmanagerV1ClusterIssuerList
     * @param githubComJetstackCertManagerPkgApisAcmeV1ACMEChallengeSolverHTTP01IngressPodSpec
     * @param githubComJetstackCertManagerPkgApisAcmeV1ACMEIssuerDNS01ProviderRoute53
     * @param githubComJetstackCertManagerPkgApisCertmanagerV1VenafiTPP
     * @param githubComJetstackCertManagerPkgApisMetaV1SecretKeySelector
     * @param githubComJetstackCertManagerPkgApisCertmanagerV1Issuer
     * @param githubComJetstackCertManagerPkgApisAcmeV1ACMEChallengeSolver
     * @param githubComJetstackCertManagerPkgApisAcmeV1ChallengeSpec
     * @param githubComJetstackCertManagerPkgApisAcmeV1ACMEChallengeSolverDNS01
     * @param githubComJetstackCertManagerPkgApisCertmanagerV1VenafiCloud
     * @param githubComJetstackCertManagerPkgApisCertmanagerV1CertificateKeystores
     * @param githubComJetstackCertManagerPkgApisAcmeV1ACMEIssuerDNS01ProviderCloudDNS
     * @param githubComJetstackCertManagerPkgApisCertmanagerV1SelfSignedIssuer
     * @param githubComJetstackCertManagerPkgApisCertmanagerV1CertificateRequestCondition
     * @param githubComJetstackCertManagerPkgApisCertmanagerV1VaultAppRole
     * @param githubComJetstackCertManagerPkgApisCertmanagerV1ClusterIssuer
     * @param githubComJetstackCertManagerPkgApisAcmeV1ACMEIssuerDNS01ProviderAkamai
     * @param githubComJetstackCertManagerPkgApisAcmeV1ACMEIssuerDNS01ProviderRFC2136
     * @param githubComJetstackCertManagerPkgApisAcmeV1ACMEChallenge
     * @param githubComJetstackCertManagerPkgApisAcmeV1OrderSpec
     * @param githubComJetstackCertManagerPkgApisAcmeV1OrderStatus
     * @param githubComJetstackCertManagerPkgApisCertmanagerV1CAIssuer
     * @param githubComJetstackCertManagerPkgApisCertmanagerV1IssuerSpec
     * @param githubComJetstackCertManagerPkgApisCertmanagerV1CertificatePrivateKey
     * @param githubComJetstackCertManagerPkgApisAcmeV1ChallengeList
     * @param githubComJetstackCertManagerPkgApisAcmeV1ACMEChallengeSolverHTTP01IngressPodTemplate
     * @param githubComJetstackCertManagerPkgApisAcmeV1ACMEIssuerDNS01ProviderWebhook
     * @param githubComJetstackCertManagerPkgApisAcmeV1ACMEExternalAccountBinding
     * @param githubComJetstackCertManagerPkgApisCertmanagerV1X509Subject
     * @param githubComJetstackCertManagerPkgApisAcmeV1ACMEIssuerDNS01ProviderAcmeDNS
     * @param githubComJetstackCertManagerPkgApisAcmeV1ACMEIssuer
     * @param githubComJetstackCertManagerPkgApisCertmanagerV1CertificateRequestStatus
     * @param githubComJetstackCertManagerPkgApisCertmanagerV1CertificateRequestSpec
     * @param githubComJetstackCertManagerPkgApisMetaV1LocalObjectReference
     * @param githubComJetstackCertManagerPkgApisCertmanagerV1CertificateCondition
     * @param githubComJetstackCertManagerPkgApisAcmeV1Order
     * @param githubComJetstackCertManagerPkgApisCertmanagerV1CertificateStatus
     * @param githubComJetstackCertManagerPkgApisCertmanagerV1IssuerStatus
     * @param githubComJetstackCertManagerPkgApisAcmeV1ACMEChallengeSolverHTTP01IngressTemplate
     * @param githubComJetstackCertManagerPkgApisCertmanagerV1IssuerCondition
     * @param githubComJetstackCertManagerPkgApisAcmeV1ACMEIssuerDNS01ProviderAzureDNS
     * @param githubComJetstackCertManagerPkgApisCertmanagerV1JKSKeystore
     * @param githubComJetstackCertManagerPkgApisCertmanagerV1CertificateList
     */
    public CertmanagerSchema(ACMEAuthorization githubComJetstackCertManagerPkgApisAcmeV1ACMEAuthorization, ACMEChallenge githubComJetstackCertManagerPkgApisAcmeV1ACMEChallenge, ACMEChallengeSolver githubComJetstackCertManagerPkgApisAcmeV1ACMEChallengeSolver, ACMEChallengeSolverDNS01 githubComJetstackCertManagerPkgApisAcmeV1ACMEChallengeSolverDNS01, ACMEChallengeSolverHTTP01 githubComJetstackCertManagerPkgApisAcmeV1ACMEChallengeSolverHTTP01, ACMEChallengeSolverHTTP01Ingress githubComJetstackCertManagerPkgApisAcmeV1ACMEChallengeSolverHTTP01Ingress, ACMEChallengeSolverHTTP01IngressObjectMeta githubComJetstackCertManagerPkgApisAcmeV1ACMEChallengeSolverHTTP01IngressObjectMeta, ACMEChallengeSolverHTTP01IngressPodObjectMeta githubComJetstackCertManagerPkgApisAcmeV1ACMEChallengeSolverHTTP01IngressPodObjectMeta, ACMEChallengeSolverHTTP01IngressPodSpec githubComJetstackCertManagerPkgApisAcmeV1ACMEChallengeSolverHTTP01IngressPodSpec, ACMEChallengeSolverHTTP01IngressPodTemplate githubComJetstackCertManagerPkgApisAcmeV1ACMEChallengeSolverHTTP01IngressPodTemplate, ACMEChallengeSolverHTTP01IngressTemplate githubComJetstackCertManagerPkgApisAcmeV1ACMEChallengeSolverHTTP01IngressTemplate, ACMEExternalAccountBinding githubComJetstackCertManagerPkgApisAcmeV1ACMEExternalAccountBinding, ACMEIssuer githubComJetstackCertManagerPkgApisAcmeV1ACMEIssuer, ACMEIssuerDNS01ProviderAcmeDNS githubComJetstackCertManagerPkgApisAcmeV1ACMEIssuerDNS01ProviderAcmeDNS, ACMEIssuerDNS01ProviderAkamai githubComJetstackCertManagerPkgApisAcmeV1ACMEIssuerDNS01ProviderAkamai, ACMEIssuerDNS01ProviderAzureDNS githubComJetstackCertManagerPkgApisAcmeV1ACMEIssuerDNS01ProviderAzureDNS, ACMEIssuerDNS01ProviderCloudDNS githubComJetstackCertManagerPkgApisAcmeV1ACMEIssuerDNS01ProviderCloudDNS, ACMEIssuerDNS01ProviderCloudflare githubComJetstackCertManagerPkgApisAcmeV1ACMEIssuerDNS01ProviderCloudflare, ACMEIssuerDNS01ProviderDigitalOcean githubComJetstackCertManagerPkgApisAcmeV1ACMEIssuerDNS01ProviderDigitalOcean, ACMEIssuerDNS01ProviderRFC2136 githubComJetstackCertManagerPkgApisAcmeV1ACMEIssuerDNS01ProviderRFC2136, ACMEIssuerDNS01ProviderRoute53 githubComJetstackCertManagerPkgApisAcmeV1ACMEIssuerDNS01ProviderRoute53, ACMEIssuerDNS01ProviderWebhook githubComJetstackCertManagerPkgApisAcmeV1ACMEIssuerDNS01ProviderWebhook, ACMEIssuerStatus githubComJetstackCertManagerPkgApisAcmeV1ACMEIssuerStatus, CertificateDNSNameSelector githubComJetstackCertManagerPkgApisAcmeV1CertificateDNSNameSelector, Challenge githubComJetstackCertManagerPkgApisAcmeV1Challenge, ChallengeList githubComJetstackCertManagerPkgApisAcmeV1ChallengeList, ChallengeSpec githubComJetstackCertManagerPkgApisAcmeV1ChallengeSpec, ChallengeStatus githubComJetstackCertManagerPkgApisAcmeV1ChallengeStatus, Order githubComJetstackCertManagerPkgApisAcmeV1Order, OrderList githubComJetstackCertManagerPkgApisAcmeV1OrderList, OrderSpec githubComJetstackCertManagerPkgApisAcmeV1OrderSpec, OrderStatus githubComJetstackCertManagerPkgApisAcmeV1OrderStatus, CAIssuer githubComJetstackCertManagerPkgApisCertmanagerV1CAIssuer, Certificate githubComJetstackCertManagerPkgApisCertmanagerV1Certificate, CertificateCondition githubComJetstackCertManagerPkgApisCertmanagerV1CertificateCondition, CertificateKeystores githubComJetstackCertManagerPkgApisCertmanagerV1CertificateKeystores, CertificateList githubComJetstackCertManagerPkgApisCertmanagerV1CertificateList, CertificatePrivateKey githubComJetstackCertManagerPkgApisCertmanagerV1CertificatePrivateKey, CertificateRequest githubComJetstackCertManagerPkgApisCertmanagerV1CertificateRequest, CertificateRequestCondition githubComJetstackCertManagerPkgApisCertmanagerV1CertificateRequestCondition, CertificateRequestList githubComJetstackCertManagerPkgApisCertmanagerV1CertificateRequestList, CertificateRequestSpec githubComJetstackCertManagerPkgApisCertmanagerV1CertificateRequestSpec, CertificateRequestStatus githubComJetstackCertManagerPkgApisCertmanagerV1CertificateRequestStatus, CertificateSpec githubComJetstackCertManagerPkgApisCertmanagerV1CertificateSpec, CertificateStatus githubComJetstackCertManagerPkgApisCertmanagerV1CertificateStatus, ClusterIssuer githubComJetstackCertManagerPkgApisCertmanagerV1ClusterIssuer, ClusterIssuerList githubComJetstackCertManagerPkgApisCertmanagerV1ClusterIssuerList, Issuer githubComJetstackCertManagerPkgApisCertmanagerV1Issuer, IssuerCondition githubComJetstackCertManagerPkgApisCertmanagerV1IssuerCondition, IssuerList githubComJetstackCertManagerPkgApisCertmanagerV1IssuerList, IssuerSpec githubComJetstackCertManagerPkgApisCertmanagerV1IssuerSpec, IssuerStatus githubComJetstackCertManagerPkgApisCertmanagerV1IssuerStatus, JKSKeystore githubComJetstackCertManagerPkgApisCertmanagerV1JKSKeystore, PKCS12Keystore githubComJetstackCertManagerPkgApisCertmanagerV1PKCS12Keystore, SelfSignedIssuer githubComJetstackCertManagerPkgApisCertmanagerV1SelfSignedIssuer, VaultAppRole githubComJetstackCertManagerPkgApisCertmanagerV1VaultAppRole, VaultAuth githubComJetstackCertManagerPkgApisCertmanagerV1VaultAuth, VaultIssuer githubComJetstackCertManagerPkgApisCertmanagerV1VaultIssuer, VaultKubernetesAuth githubComJetstackCertManagerPkgApisCertmanagerV1VaultKubernetesAuth, VenafiCloud githubComJetstackCertManagerPkgApisCertmanagerV1VenafiCloud, VenafiIssuer githubComJetstackCertManagerPkgApisCertmanagerV1VenafiIssuer, VenafiTPP githubComJetstackCertManagerPkgApisCertmanagerV1VenafiTPP, X509Subject githubComJetstackCertManagerPkgApisCertmanagerV1X509Subject, io.fabric8.certmanager.api.model.meta.v1.LocalObjectReference githubComJetstackCertManagerPkgApisMetaV1LocalObjectReference, io.fabric8.certmanager.api.model.meta.v1.ObjectReference githubComJetstackCertManagerPkgApisMetaV1ObjectReference, SecretKeySelector githubComJetstackCertManagerPkgApisMetaV1SecretKeySelector) {
        super();
        this.githubComJetstackCertManagerPkgApisAcmeV1ACMEAuthorization = githubComJetstackCertManagerPkgApisAcmeV1ACMEAuthorization;
        this.githubComJetstackCertManagerPkgApisAcmeV1ACMEChallenge = githubComJetstackCertManagerPkgApisAcmeV1ACMEChallenge;
        this.githubComJetstackCertManagerPkgApisAcmeV1ACMEChallengeSolver = githubComJetstackCertManagerPkgApisAcmeV1ACMEChallengeSolver;
        this.githubComJetstackCertManagerPkgApisAcmeV1ACMEChallengeSolverDNS01 = githubComJetstackCertManagerPkgApisAcmeV1ACMEChallengeSolverDNS01;
        this.githubComJetstackCertManagerPkgApisAcmeV1ACMEChallengeSolverHTTP01 = githubComJetstackCertManagerPkgApisAcmeV1ACMEChallengeSolverHTTP01;
        this.githubComJetstackCertManagerPkgApisAcmeV1ACMEChallengeSolverHTTP01Ingress = githubComJetstackCertManagerPkgApisAcmeV1ACMEChallengeSolverHTTP01Ingress;
        this.githubComJetstackCertManagerPkgApisAcmeV1ACMEChallengeSolverHTTP01IngressObjectMeta = githubComJetstackCertManagerPkgApisAcmeV1ACMEChallengeSolverHTTP01IngressObjectMeta;
        this.githubComJetstackCertManagerPkgApisAcmeV1ACMEChallengeSolverHTTP01IngressPodObjectMeta = githubComJetstackCertManagerPkgApisAcmeV1ACMEChallengeSolverHTTP01IngressPodObjectMeta;
        this.githubComJetstackCertManagerPkgApisAcmeV1ACMEChallengeSolverHTTP01IngressPodSpec = githubComJetstackCertManagerPkgApisAcmeV1ACMEChallengeSolverHTTP01IngressPodSpec;
        this.githubComJetstackCertManagerPkgApisAcmeV1ACMEChallengeSolverHTTP01IngressPodTemplate = githubComJetstackCertManagerPkgApisAcmeV1ACMEChallengeSolverHTTP01IngressPodTemplate;
        this.githubComJetstackCertManagerPkgApisAcmeV1ACMEChallengeSolverHTTP01IngressTemplate = githubComJetstackCertManagerPkgApisAcmeV1ACMEChallengeSolverHTTP01IngressTemplate;
        this.githubComJetstackCertManagerPkgApisAcmeV1ACMEExternalAccountBinding = githubComJetstackCertManagerPkgApisAcmeV1ACMEExternalAccountBinding;
        this.githubComJetstackCertManagerPkgApisAcmeV1ACMEIssuer = githubComJetstackCertManagerPkgApisAcmeV1ACMEIssuer;
        this.githubComJetstackCertManagerPkgApisAcmeV1ACMEIssuerDNS01ProviderAcmeDNS = githubComJetstackCertManagerPkgApisAcmeV1ACMEIssuerDNS01ProviderAcmeDNS;
        this.githubComJetstackCertManagerPkgApisAcmeV1ACMEIssuerDNS01ProviderAkamai = githubComJetstackCertManagerPkgApisAcmeV1ACMEIssuerDNS01ProviderAkamai;
        this.githubComJetstackCertManagerPkgApisAcmeV1ACMEIssuerDNS01ProviderAzureDNS = githubComJetstackCertManagerPkgApisAcmeV1ACMEIssuerDNS01ProviderAzureDNS;
        this.githubComJetstackCertManagerPkgApisAcmeV1ACMEIssuerDNS01ProviderCloudDNS = githubComJetstackCertManagerPkgApisAcmeV1ACMEIssuerDNS01ProviderCloudDNS;
        this.githubComJetstackCertManagerPkgApisAcmeV1ACMEIssuerDNS01ProviderCloudflare = githubComJetstackCertManagerPkgApisAcmeV1ACMEIssuerDNS01ProviderCloudflare;
        this.githubComJetstackCertManagerPkgApisAcmeV1ACMEIssuerDNS01ProviderDigitalOcean = githubComJetstackCertManagerPkgApisAcmeV1ACMEIssuerDNS01ProviderDigitalOcean;
        this.githubComJetstackCertManagerPkgApisAcmeV1ACMEIssuerDNS01ProviderRFC2136 = githubComJetstackCertManagerPkgApisAcmeV1ACMEIssuerDNS01ProviderRFC2136;
        this.githubComJetstackCertManagerPkgApisAcmeV1ACMEIssuerDNS01ProviderRoute53 = githubComJetstackCertManagerPkgApisAcmeV1ACMEIssuerDNS01ProviderRoute53;
        this.githubComJetstackCertManagerPkgApisAcmeV1ACMEIssuerDNS01ProviderWebhook = githubComJetstackCertManagerPkgApisAcmeV1ACMEIssuerDNS01ProviderWebhook;
        this.githubComJetstackCertManagerPkgApisAcmeV1ACMEIssuerStatus = githubComJetstackCertManagerPkgApisAcmeV1ACMEIssuerStatus;
        this.githubComJetstackCertManagerPkgApisAcmeV1CertificateDNSNameSelector = githubComJetstackCertManagerPkgApisAcmeV1CertificateDNSNameSelector;
        this.githubComJetstackCertManagerPkgApisAcmeV1Challenge = githubComJetstackCertManagerPkgApisAcmeV1Challenge;
        this.githubComJetstackCertManagerPkgApisAcmeV1ChallengeList = githubComJetstackCertManagerPkgApisAcmeV1ChallengeList;
        this.githubComJetstackCertManagerPkgApisAcmeV1ChallengeSpec = githubComJetstackCertManagerPkgApisAcmeV1ChallengeSpec;
        this.githubComJetstackCertManagerPkgApisAcmeV1ChallengeStatus = githubComJetstackCertManagerPkgApisAcmeV1ChallengeStatus;
        this.githubComJetstackCertManagerPkgApisAcmeV1Order = githubComJetstackCertManagerPkgApisAcmeV1Order;
        this.githubComJetstackCertManagerPkgApisAcmeV1OrderList = githubComJetstackCertManagerPkgApisAcmeV1OrderList;
        this.githubComJetstackCertManagerPkgApisAcmeV1OrderSpec = githubComJetstackCertManagerPkgApisAcmeV1OrderSpec;
        this.githubComJetstackCertManagerPkgApisAcmeV1OrderStatus = githubComJetstackCertManagerPkgApisAcmeV1OrderStatus;
        this.githubComJetstackCertManagerPkgApisCertmanagerV1CAIssuer = githubComJetstackCertManagerPkgApisCertmanagerV1CAIssuer;
        this.githubComJetstackCertManagerPkgApisCertmanagerV1Certificate = githubComJetstackCertManagerPkgApisCertmanagerV1Certificate;
        this.githubComJetstackCertManagerPkgApisCertmanagerV1CertificateCondition = githubComJetstackCertManagerPkgApisCertmanagerV1CertificateCondition;
        this.githubComJetstackCertManagerPkgApisCertmanagerV1CertificateKeystores = githubComJetstackCertManagerPkgApisCertmanagerV1CertificateKeystores;
        this.githubComJetstackCertManagerPkgApisCertmanagerV1CertificateList = githubComJetstackCertManagerPkgApisCertmanagerV1CertificateList;
        this.githubComJetstackCertManagerPkgApisCertmanagerV1CertificatePrivateKey = githubComJetstackCertManagerPkgApisCertmanagerV1CertificatePrivateKey;
        this.githubComJetstackCertManagerPkgApisCertmanagerV1CertificateRequest = githubComJetstackCertManagerPkgApisCertmanagerV1CertificateRequest;
        this.githubComJetstackCertManagerPkgApisCertmanagerV1CertificateRequestCondition = githubComJetstackCertManagerPkgApisCertmanagerV1CertificateRequestCondition;
        this.githubComJetstackCertManagerPkgApisCertmanagerV1CertificateRequestList = githubComJetstackCertManagerPkgApisCertmanagerV1CertificateRequestList;
        this.githubComJetstackCertManagerPkgApisCertmanagerV1CertificateRequestSpec = githubComJetstackCertManagerPkgApisCertmanagerV1CertificateRequestSpec;
        this.githubComJetstackCertManagerPkgApisCertmanagerV1CertificateRequestStatus = githubComJetstackCertManagerPkgApisCertmanagerV1CertificateRequestStatus;
        this.githubComJetstackCertManagerPkgApisCertmanagerV1CertificateSpec = githubComJetstackCertManagerPkgApisCertmanagerV1CertificateSpec;
        this.githubComJetstackCertManagerPkgApisCertmanagerV1CertificateStatus = githubComJetstackCertManagerPkgApisCertmanagerV1CertificateStatus;
        this.githubComJetstackCertManagerPkgApisCertmanagerV1ClusterIssuer = githubComJetstackCertManagerPkgApisCertmanagerV1ClusterIssuer;
        this.githubComJetstackCertManagerPkgApisCertmanagerV1ClusterIssuerList = githubComJetstackCertManagerPkgApisCertmanagerV1ClusterIssuerList;
        this.githubComJetstackCertManagerPkgApisCertmanagerV1Issuer = githubComJetstackCertManagerPkgApisCertmanagerV1Issuer;
        this.githubComJetstackCertManagerPkgApisCertmanagerV1IssuerCondition = githubComJetstackCertManagerPkgApisCertmanagerV1IssuerCondition;
        this.githubComJetstackCertManagerPkgApisCertmanagerV1IssuerList = githubComJetstackCertManagerPkgApisCertmanagerV1IssuerList;
        this.githubComJetstackCertManagerPkgApisCertmanagerV1IssuerSpec = githubComJetstackCertManagerPkgApisCertmanagerV1IssuerSpec;
        this.githubComJetstackCertManagerPkgApisCertmanagerV1IssuerStatus = githubComJetstackCertManagerPkgApisCertmanagerV1IssuerStatus;
        this.githubComJetstackCertManagerPkgApisCertmanagerV1JKSKeystore = githubComJetstackCertManagerPkgApisCertmanagerV1JKSKeystore;
        this.githubComJetstackCertManagerPkgApisCertmanagerV1PKCS12Keystore = githubComJetstackCertManagerPkgApisCertmanagerV1PKCS12Keystore;
        this.githubComJetstackCertManagerPkgApisCertmanagerV1SelfSignedIssuer = githubComJetstackCertManagerPkgApisCertmanagerV1SelfSignedIssuer;
        this.githubComJetstackCertManagerPkgApisCertmanagerV1VaultAppRole = githubComJetstackCertManagerPkgApisCertmanagerV1VaultAppRole;
        this.githubComJetstackCertManagerPkgApisCertmanagerV1VaultAuth = githubComJetstackCertManagerPkgApisCertmanagerV1VaultAuth;
        this.githubComJetstackCertManagerPkgApisCertmanagerV1VaultIssuer = githubComJetstackCertManagerPkgApisCertmanagerV1VaultIssuer;
        this.githubComJetstackCertManagerPkgApisCertmanagerV1VaultKubernetesAuth = githubComJetstackCertManagerPkgApisCertmanagerV1VaultKubernetesAuth;
        this.githubComJetstackCertManagerPkgApisCertmanagerV1VenafiCloud = githubComJetstackCertManagerPkgApisCertmanagerV1VenafiCloud;
        this.githubComJetstackCertManagerPkgApisCertmanagerV1VenafiIssuer = githubComJetstackCertManagerPkgApisCertmanagerV1VenafiIssuer;
        this.githubComJetstackCertManagerPkgApisCertmanagerV1VenafiTPP = githubComJetstackCertManagerPkgApisCertmanagerV1VenafiTPP;
        this.githubComJetstackCertManagerPkgApisCertmanagerV1X509Subject = githubComJetstackCertManagerPkgApisCertmanagerV1X509Subject;
        this.githubComJetstackCertManagerPkgApisMetaV1LocalObjectReference = githubComJetstackCertManagerPkgApisMetaV1LocalObjectReference;
        this.githubComJetstackCertManagerPkgApisMetaV1ObjectReference = githubComJetstackCertManagerPkgApisMetaV1ObjectReference;
        this.githubComJetstackCertManagerPkgApisMetaV1SecretKeySelector = githubComJetstackCertManagerPkgApisMetaV1SecretKeySelector;
    }

    @JsonProperty("github_com_jetstack_cert-manager_pkg_apis_acme_v1_ACMEAuthorization")
    public ACMEAuthorization getGithubComJetstackCertManagerPkgApisAcmeV1ACMEAuthorization() {
        return githubComJetstackCertManagerPkgApisAcmeV1ACMEAuthorization;
    }

    @JsonProperty("github_com_jetstack_cert-manager_pkg_apis_acme_v1_ACMEAuthorization")
    public void setGithubComJetstackCertManagerPkgApisAcmeV1ACMEAuthorization(ACMEAuthorization githubComJetstackCertManagerPkgApisAcmeV1ACMEAuthorization) {
        this.githubComJetstackCertManagerPkgApisAcmeV1ACMEAuthorization = githubComJetstackCertManagerPkgApisAcmeV1ACMEAuthorization;
    }

    @JsonProperty("github_com_jetstack_cert-manager_pkg_apis_acme_v1_ACMEChallenge")
    public ACMEChallenge getGithubComJetstackCertManagerPkgApisAcmeV1ACMEChallenge() {
        return githubComJetstackCertManagerPkgApisAcmeV1ACMEChallenge;
    }

    @JsonProperty("github_com_jetstack_cert-manager_pkg_apis_acme_v1_ACMEChallenge")
    public void setGithubComJetstackCertManagerPkgApisAcmeV1ACMEChallenge(ACMEChallenge githubComJetstackCertManagerPkgApisAcmeV1ACMEChallenge) {
        this.githubComJetstackCertManagerPkgApisAcmeV1ACMEChallenge = githubComJetstackCertManagerPkgApisAcmeV1ACMEChallenge;
    }

    @JsonProperty("github_com_jetstack_cert-manager_pkg_apis_acme_v1_ACMEChallengeSolver")
    public ACMEChallengeSolver getGithubComJetstackCertManagerPkgApisAcmeV1ACMEChallengeSolver() {
        return githubComJetstackCertManagerPkgApisAcmeV1ACMEChallengeSolver;
    }

    @JsonProperty("github_com_jetstack_cert-manager_pkg_apis_acme_v1_ACMEChallengeSolver")
    public void setGithubComJetstackCertManagerPkgApisAcmeV1ACMEChallengeSolver(ACMEChallengeSolver githubComJetstackCertManagerPkgApisAcmeV1ACMEChallengeSolver) {
        this.githubComJetstackCertManagerPkgApisAcmeV1ACMEChallengeSolver = githubComJetstackCertManagerPkgApisAcmeV1ACMEChallengeSolver;
    }

    @JsonProperty("github_com_jetstack_cert-manager_pkg_apis_acme_v1_ACMEChallengeSolverDNS01")
    public ACMEChallengeSolverDNS01 getGithubComJetstackCertManagerPkgApisAcmeV1ACMEChallengeSolverDNS01() {
        return githubComJetstackCertManagerPkgApisAcmeV1ACMEChallengeSolverDNS01;
    }

    @JsonProperty("github_com_jetstack_cert-manager_pkg_apis_acme_v1_ACMEChallengeSolverDNS01")
    public void setGithubComJetstackCertManagerPkgApisAcmeV1ACMEChallengeSolverDNS01(ACMEChallengeSolverDNS01 githubComJetstackCertManagerPkgApisAcmeV1ACMEChallengeSolverDNS01) {
        this.githubComJetstackCertManagerPkgApisAcmeV1ACMEChallengeSolverDNS01 = githubComJetstackCertManagerPkgApisAcmeV1ACMEChallengeSolverDNS01;
    }

    @JsonProperty("github_com_jetstack_cert-manager_pkg_apis_acme_v1_ACMEChallengeSolverHTTP01")
    public ACMEChallengeSolverHTTP01 getGithubComJetstackCertManagerPkgApisAcmeV1ACMEChallengeSolverHTTP01() {
        return githubComJetstackCertManagerPkgApisAcmeV1ACMEChallengeSolverHTTP01;
    }

    @JsonProperty("github_com_jetstack_cert-manager_pkg_apis_acme_v1_ACMEChallengeSolverHTTP01")
    public void setGithubComJetstackCertManagerPkgApisAcmeV1ACMEChallengeSolverHTTP01(ACMEChallengeSolverHTTP01 githubComJetstackCertManagerPkgApisAcmeV1ACMEChallengeSolverHTTP01) {
        this.githubComJetstackCertManagerPkgApisAcmeV1ACMEChallengeSolverHTTP01 = githubComJetstackCertManagerPkgApisAcmeV1ACMEChallengeSolverHTTP01;
    }

    @JsonProperty("github_com_jetstack_cert-manager_pkg_apis_acme_v1_ACMEChallengeSolverHTTP01Ingress")
    public ACMEChallengeSolverHTTP01Ingress getGithubComJetstackCertManagerPkgApisAcmeV1ACMEChallengeSolverHTTP01Ingress() {
        return githubComJetstackCertManagerPkgApisAcmeV1ACMEChallengeSolverHTTP01Ingress;
    }

    @JsonProperty("github_com_jetstack_cert-manager_pkg_apis_acme_v1_ACMEChallengeSolverHTTP01Ingress")
    public void setGithubComJetstackCertManagerPkgApisAcmeV1ACMEChallengeSolverHTTP01Ingress(ACMEChallengeSolverHTTP01Ingress githubComJetstackCertManagerPkgApisAcmeV1ACMEChallengeSolverHTTP01Ingress) {
        this.githubComJetstackCertManagerPkgApisAcmeV1ACMEChallengeSolverHTTP01Ingress = githubComJetstackCertManagerPkgApisAcmeV1ACMEChallengeSolverHTTP01Ingress;
    }

    @JsonProperty("github_com_jetstack_cert-manager_pkg_apis_acme_v1_ACMEChallengeSolverHTTP01IngressObjectMeta")
    public ACMEChallengeSolverHTTP01IngressObjectMeta getGithubComJetstackCertManagerPkgApisAcmeV1ACMEChallengeSolverHTTP01IngressObjectMeta() {
        return githubComJetstackCertManagerPkgApisAcmeV1ACMEChallengeSolverHTTP01IngressObjectMeta;
    }

    @JsonProperty("github_com_jetstack_cert-manager_pkg_apis_acme_v1_ACMEChallengeSolverHTTP01IngressObjectMeta")
    public void setGithubComJetstackCertManagerPkgApisAcmeV1ACMEChallengeSolverHTTP01IngressObjectMeta(ACMEChallengeSolverHTTP01IngressObjectMeta githubComJetstackCertManagerPkgApisAcmeV1ACMEChallengeSolverHTTP01IngressObjectMeta) {
        this.githubComJetstackCertManagerPkgApisAcmeV1ACMEChallengeSolverHTTP01IngressObjectMeta = githubComJetstackCertManagerPkgApisAcmeV1ACMEChallengeSolverHTTP01IngressObjectMeta;
    }

    @JsonProperty("github_com_jetstack_cert-manager_pkg_apis_acme_v1_ACMEChallengeSolverHTTP01IngressPodObjectMeta")
    public ACMEChallengeSolverHTTP01IngressPodObjectMeta getGithubComJetstackCertManagerPkgApisAcmeV1ACMEChallengeSolverHTTP01IngressPodObjectMeta() {
        return githubComJetstackCertManagerPkgApisAcmeV1ACMEChallengeSolverHTTP01IngressPodObjectMeta;
    }

    @JsonProperty("github_com_jetstack_cert-manager_pkg_apis_acme_v1_ACMEChallengeSolverHTTP01IngressPodObjectMeta")
    public void setGithubComJetstackCertManagerPkgApisAcmeV1ACMEChallengeSolverHTTP01IngressPodObjectMeta(ACMEChallengeSolverHTTP01IngressPodObjectMeta githubComJetstackCertManagerPkgApisAcmeV1ACMEChallengeSolverHTTP01IngressPodObjectMeta) {
        this.githubComJetstackCertManagerPkgApisAcmeV1ACMEChallengeSolverHTTP01IngressPodObjectMeta = githubComJetstackCertManagerPkgApisAcmeV1ACMEChallengeSolverHTTP01IngressPodObjectMeta;
    }

    @JsonProperty("github_com_jetstack_cert-manager_pkg_apis_acme_v1_ACMEChallengeSolverHTTP01IngressPodSpec")
    public ACMEChallengeSolverHTTP01IngressPodSpec getGithubComJetstackCertManagerPkgApisAcmeV1ACMEChallengeSolverHTTP01IngressPodSpec() {
        return githubComJetstackCertManagerPkgApisAcmeV1ACMEChallengeSolverHTTP01IngressPodSpec;
    }

    @JsonProperty("github_com_jetstack_cert-manager_pkg_apis_acme_v1_ACMEChallengeSolverHTTP01IngressPodSpec")
    public void setGithubComJetstackCertManagerPkgApisAcmeV1ACMEChallengeSolverHTTP01IngressPodSpec(ACMEChallengeSolverHTTP01IngressPodSpec githubComJetstackCertManagerPkgApisAcmeV1ACMEChallengeSolverHTTP01IngressPodSpec) {
        this.githubComJetstackCertManagerPkgApisAcmeV1ACMEChallengeSolverHTTP01IngressPodSpec = githubComJetstackCertManagerPkgApisAcmeV1ACMEChallengeSolverHTTP01IngressPodSpec;
    }

    @JsonProperty("github_com_jetstack_cert-manager_pkg_apis_acme_v1_ACMEChallengeSolverHTTP01IngressPodTemplate")
    public ACMEChallengeSolverHTTP01IngressPodTemplate getGithubComJetstackCertManagerPkgApisAcmeV1ACMEChallengeSolverHTTP01IngressPodTemplate() {
        return githubComJetstackCertManagerPkgApisAcmeV1ACMEChallengeSolverHTTP01IngressPodTemplate;
    }

    @JsonProperty("github_com_jetstack_cert-manager_pkg_apis_acme_v1_ACMEChallengeSolverHTTP01IngressPodTemplate")
    public void setGithubComJetstackCertManagerPkgApisAcmeV1ACMEChallengeSolverHTTP01IngressPodTemplate(ACMEChallengeSolverHTTP01IngressPodTemplate githubComJetstackCertManagerPkgApisAcmeV1ACMEChallengeSolverHTTP01IngressPodTemplate) {
        this.githubComJetstackCertManagerPkgApisAcmeV1ACMEChallengeSolverHTTP01IngressPodTemplate = githubComJetstackCertManagerPkgApisAcmeV1ACMEChallengeSolverHTTP01IngressPodTemplate;
    }

    @JsonProperty("github_com_jetstack_cert-manager_pkg_apis_acme_v1_ACMEChallengeSolverHTTP01IngressTemplate")
    public ACMEChallengeSolverHTTP01IngressTemplate getGithubComJetstackCertManagerPkgApisAcmeV1ACMEChallengeSolverHTTP01IngressTemplate() {
        return githubComJetstackCertManagerPkgApisAcmeV1ACMEChallengeSolverHTTP01IngressTemplate;
    }

    @JsonProperty("github_com_jetstack_cert-manager_pkg_apis_acme_v1_ACMEChallengeSolverHTTP01IngressTemplate")
    public void setGithubComJetstackCertManagerPkgApisAcmeV1ACMEChallengeSolverHTTP01IngressTemplate(ACMEChallengeSolverHTTP01IngressTemplate githubComJetstackCertManagerPkgApisAcmeV1ACMEChallengeSolverHTTP01IngressTemplate) {
        this.githubComJetstackCertManagerPkgApisAcmeV1ACMEChallengeSolverHTTP01IngressTemplate = githubComJetstackCertManagerPkgApisAcmeV1ACMEChallengeSolverHTTP01IngressTemplate;
    }

    @JsonProperty("github_com_jetstack_cert-manager_pkg_apis_acme_v1_ACMEExternalAccountBinding")
    public ACMEExternalAccountBinding getGithubComJetstackCertManagerPkgApisAcmeV1ACMEExternalAccountBinding() {
        return githubComJetstackCertManagerPkgApisAcmeV1ACMEExternalAccountBinding;
    }

    @JsonProperty("github_com_jetstack_cert-manager_pkg_apis_acme_v1_ACMEExternalAccountBinding")
    public void setGithubComJetstackCertManagerPkgApisAcmeV1ACMEExternalAccountBinding(ACMEExternalAccountBinding githubComJetstackCertManagerPkgApisAcmeV1ACMEExternalAccountBinding) {
        this.githubComJetstackCertManagerPkgApisAcmeV1ACMEExternalAccountBinding = githubComJetstackCertManagerPkgApisAcmeV1ACMEExternalAccountBinding;
    }

    @JsonProperty("github_com_jetstack_cert-manager_pkg_apis_acme_v1_ACMEIssuer")
    public ACMEIssuer getGithubComJetstackCertManagerPkgApisAcmeV1ACMEIssuer() {
        return githubComJetstackCertManagerPkgApisAcmeV1ACMEIssuer;
    }

    @JsonProperty("github_com_jetstack_cert-manager_pkg_apis_acme_v1_ACMEIssuer")
    public void setGithubComJetstackCertManagerPkgApisAcmeV1ACMEIssuer(ACMEIssuer githubComJetstackCertManagerPkgApisAcmeV1ACMEIssuer) {
        this.githubComJetstackCertManagerPkgApisAcmeV1ACMEIssuer = githubComJetstackCertManagerPkgApisAcmeV1ACMEIssuer;
    }

    @JsonProperty("github_com_jetstack_cert-manager_pkg_apis_acme_v1_ACMEIssuerDNS01ProviderAcmeDNS")
    public ACMEIssuerDNS01ProviderAcmeDNS getGithubComJetstackCertManagerPkgApisAcmeV1ACMEIssuerDNS01ProviderAcmeDNS() {
        return githubComJetstackCertManagerPkgApisAcmeV1ACMEIssuerDNS01ProviderAcmeDNS;
    }

    @JsonProperty("github_com_jetstack_cert-manager_pkg_apis_acme_v1_ACMEIssuerDNS01ProviderAcmeDNS")
    public void setGithubComJetstackCertManagerPkgApisAcmeV1ACMEIssuerDNS01ProviderAcmeDNS(ACMEIssuerDNS01ProviderAcmeDNS githubComJetstackCertManagerPkgApisAcmeV1ACMEIssuerDNS01ProviderAcmeDNS) {
        this.githubComJetstackCertManagerPkgApisAcmeV1ACMEIssuerDNS01ProviderAcmeDNS = githubComJetstackCertManagerPkgApisAcmeV1ACMEIssuerDNS01ProviderAcmeDNS;
    }

    @JsonProperty("github_com_jetstack_cert-manager_pkg_apis_acme_v1_ACMEIssuerDNS01ProviderAkamai")
    public ACMEIssuerDNS01ProviderAkamai getGithubComJetstackCertManagerPkgApisAcmeV1ACMEIssuerDNS01ProviderAkamai() {
        return githubComJetstackCertManagerPkgApisAcmeV1ACMEIssuerDNS01ProviderAkamai;
    }

    @JsonProperty("github_com_jetstack_cert-manager_pkg_apis_acme_v1_ACMEIssuerDNS01ProviderAkamai")
    public void setGithubComJetstackCertManagerPkgApisAcmeV1ACMEIssuerDNS01ProviderAkamai(ACMEIssuerDNS01ProviderAkamai githubComJetstackCertManagerPkgApisAcmeV1ACMEIssuerDNS01ProviderAkamai) {
        this.githubComJetstackCertManagerPkgApisAcmeV1ACMEIssuerDNS01ProviderAkamai = githubComJetstackCertManagerPkgApisAcmeV1ACMEIssuerDNS01ProviderAkamai;
    }

    @JsonProperty("github_com_jetstack_cert-manager_pkg_apis_acme_v1_ACMEIssuerDNS01ProviderAzureDNS")
    public ACMEIssuerDNS01ProviderAzureDNS getGithubComJetstackCertManagerPkgApisAcmeV1ACMEIssuerDNS01ProviderAzureDNS() {
        return githubComJetstackCertManagerPkgApisAcmeV1ACMEIssuerDNS01ProviderAzureDNS;
    }

    @JsonProperty("github_com_jetstack_cert-manager_pkg_apis_acme_v1_ACMEIssuerDNS01ProviderAzureDNS")
    public void setGithubComJetstackCertManagerPkgApisAcmeV1ACMEIssuerDNS01ProviderAzureDNS(ACMEIssuerDNS01ProviderAzureDNS githubComJetstackCertManagerPkgApisAcmeV1ACMEIssuerDNS01ProviderAzureDNS) {
        this.githubComJetstackCertManagerPkgApisAcmeV1ACMEIssuerDNS01ProviderAzureDNS = githubComJetstackCertManagerPkgApisAcmeV1ACMEIssuerDNS01ProviderAzureDNS;
    }

    @JsonProperty("github_com_jetstack_cert-manager_pkg_apis_acme_v1_ACMEIssuerDNS01ProviderCloudDNS")
    public ACMEIssuerDNS01ProviderCloudDNS getGithubComJetstackCertManagerPkgApisAcmeV1ACMEIssuerDNS01ProviderCloudDNS() {
        return githubComJetstackCertManagerPkgApisAcmeV1ACMEIssuerDNS01ProviderCloudDNS;
    }

    @JsonProperty("github_com_jetstack_cert-manager_pkg_apis_acme_v1_ACMEIssuerDNS01ProviderCloudDNS")
    public void setGithubComJetstackCertManagerPkgApisAcmeV1ACMEIssuerDNS01ProviderCloudDNS(ACMEIssuerDNS01ProviderCloudDNS githubComJetstackCertManagerPkgApisAcmeV1ACMEIssuerDNS01ProviderCloudDNS) {
        this.githubComJetstackCertManagerPkgApisAcmeV1ACMEIssuerDNS01ProviderCloudDNS = githubComJetstackCertManagerPkgApisAcmeV1ACMEIssuerDNS01ProviderCloudDNS;
    }

    @JsonProperty("github_com_jetstack_cert-manager_pkg_apis_acme_v1_ACMEIssuerDNS01ProviderCloudflare")
    public ACMEIssuerDNS01ProviderCloudflare getGithubComJetstackCertManagerPkgApisAcmeV1ACMEIssuerDNS01ProviderCloudflare() {
        return githubComJetstackCertManagerPkgApisAcmeV1ACMEIssuerDNS01ProviderCloudflare;
    }

    @JsonProperty("github_com_jetstack_cert-manager_pkg_apis_acme_v1_ACMEIssuerDNS01ProviderCloudflare")
    public void setGithubComJetstackCertManagerPkgApisAcmeV1ACMEIssuerDNS01ProviderCloudflare(ACMEIssuerDNS01ProviderCloudflare githubComJetstackCertManagerPkgApisAcmeV1ACMEIssuerDNS01ProviderCloudflare) {
        this.githubComJetstackCertManagerPkgApisAcmeV1ACMEIssuerDNS01ProviderCloudflare = githubComJetstackCertManagerPkgApisAcmeV1ACMEIssuerDNS01ProviderCloudflare;
    }

    @JsonProperty("github_com_jetstack_cert-manager_pkg_apis_acme_v1_ACMEIssuerDNS01ProviderDigitalOcean")
    public ACMEIssuerDNS01ProviderDigitalOcean getGithubComJetstackCertManagerPkgApisAcmeV1ACMEIssuerDNS01ProviderDigitalOcean() {
        return githubComJetstackCertManagerPkgApisAcmeV1ACMEIssuerDNS01ProviderDigitalOcean;
    }

    @JsonProperty("github_com_jetstack_cert-manager_pkg_apis_acme_v1_ACMEIssuerDNS01ProviderDigitalOcean")
    public void setGithubComJetstackCertManagerPkgApisAcmeV1ACMEIssuerDNS01ProviderDigitalOcean(ACMEIssuerDNS01ProviderDigitalOcean githubComJetstackCertManagerPkgApisAcmeV1ACMEIssuerDNS01ProviderDigitalOcean) {
        this.githubComJetstackCertManagerPkgApisAcmeV1ACMEIssuerDNS01ProviderDigitalOcean = githubComJetstackCertManagerPkgApisAcmeV1ACMEIssuerDNS01ProviderDigitalOcean;
    }

    @JsonProperty("github_com_jetstack_cert-manager_pkg_apis_acme_v1_ACMEIssuerDNS01ProviderRFC2136")
    public ACMEIssuerDNS01ProviderRFC2136 getGithubComJetstackCertManagerPkgApisAcmeV1ACMEIssuerDNS01ProviderRFC2136() {
        return githubComJetstackCertManagerPkgApisAcmeV1ACMEIssuerDNS01ProviderRFC2136;
    }

    @JsonProperty("github_com_jetstack_cert-manager_pkg_apis_acme_v1_ACMEIssuerDNS01ProviderRFC2136")
    public void setGithubComJetstackCertManagerPkgApisAcmeV1ACMEIssuerDNS01ProviderRFC2136(ACMEIssuerDNS01ProviderRFC2136 githubComJetstackCertManagerPkgApisAcmeV1ACMEIssuerDNS01ProviderRFC2136) {
        this.githubComJetstackCertManagerPkgApisAcmeV1ACMEIssuerDNS01ProviderRFC2136 = githubComJetstackCertManagerPkgApisAcmeV1ACMEIssuerDNS01ProviderRFC2136;
    }

    @JsonProperty("github_com_jetstack_cert-manager_pkg_apis_acme_v1_ACMEIssuerDNS01ProviderRoute53")
    public ACMEIssuerDNS01ProviderRoute53 getGithubComJetstackCertManagerPkgApisAcmeV1ACMEIssuerDNS01ProviderRoute53() {
        return githubComJetstackCertManagerPkgApisAcmeV1ACMEIssuerDNS01ProviderRoute53;
    }

    @JsonProperty("github_com_jetstack_cert-manager_pkg_apis_acme_v1_ACMEIssuerDNS01ProviderRoute53")
    public void setGithubComJetstackCertManagerPkgApisAcmeV1ACMEIssuerDNS01ProviderRoute53(ACMEIssuerDNS01ProviderRoute53 githubComJetstackCertManagerPkgApisAcmeV1ACMEIssuerDNS01ProviderRoute53) {
        this.githubComJetstackCertManagerPkgApisAcmeV1ACMEIssuerDNS01ProviderRoute53 = githubComJetstackCertManagerPkgApisAcmeV1ACMEIssuerDNS01ProviderRoute53;
    }

    @JsonProperty("github_com_jetstack_cert-manager_pkg_apis_acme_v1_ACMEIssuerDNS01ProviderWebhook")
    public ACMEIssuerDNS01ProviderWebhook getGithubComJetstackCertManagerPkgApisAcmeV1ACMEIssuerDNS01ProviderWebhook() {
        return githubComJetstackCertManagerPkgApisAcmeV1ACMEIssuerDNS01ProviderWebhook;
    }

    @JsonProperty("github_com_jetstack_cert-manager_pkg_apis_acme_v1_ACMEIssuerDNS01ProviderWebhook")
    public void setGithubComJetstackCertManagerPkgApisAcmeV1ACMEIssuerDNS01ProviderWebhook(ACMEIssuerDNS01ProviderWebhook githubComJetstackCertManagerPkgApisAcmeV1ACMEIssuerDNS01ProviderWebhook) {
        this.githubComJetstackCertManagerPkgApisAcmeV1ACMEIssuerDNS01ProviderWebhook = githubComJetstackCertManagerPkgApisAcmeV1ACMEIssuerDNS01ProviderWebhook;
    }

    @JsonProperty("github_com_jetstack_cert-manager_pkg_apis_acme_v1_ACMEIssuerStatus")
    public ACMEIssuerStatus getGithubComJetstackCertManagerPkgApisAcmeV1ACMEIssuerStatus() {
        return githubComJetstackCertManagerPkgApisAcmeV1ACMEIssuerStatus;
    }

    @JsonProperty("github_com_jetstack_cert-manager_pkg_apis_acme_v1_ACMEIssuerStatus")
    public void setGithubComJetstackCertManagerPkgApisAcmeV1ACMEIssuerStatus(ACMEIssuerStatus githubComJetstackCertManagerPkgApisAcmeV1ACMEIssuerStatus) {
        this.githubComJetstackCertManagerPkgApisAcmeV1ACMEIssuerStatus = githubComJetstackCertManagerPkgApisAcmeV1ACMEIssuerStatus;
    }

    @JsonProperty("github_com_jetstack_cert-manager_pkg_apis_acme_v1_CertificateDNSNameSelector")
    public CertificateDNSNameSelector getGithubComJetstackCertManagerPkgApisAcmeV1CertificateDNSNameSelector() {
        return githubComJetstackCertManagerPkgApisAcmeV1CertificateDNSNameSelector;
    }

    @JsonProperty("github_com_jetstack_cert-manager_pkg_apis_acme_v1_CertificateDNSNameSelector")
    public void setGithubComJetstackCertManagerPkgApisAcmeV1CertificateDNSNameSelector(CertificateDNSNameSelector githubComJetstackCertManagerPkgApisAcmeV1CertificateDNSNameSelector) {
        this.githubComJetstackCertManagerPkgApisAcmeV1CertificateDNSNameSelector = githubComJetstackCertManagerPkgApisAcmeV1CertificateDNSNameSelector;
    }

    @JsonProperty("github_com_jetstack_cert-manager_pkg_apis_acme_v1_Challenge")
    public Challenge getGithubComJetstackCertManagerPkgApisAcmeV1Challenge() {
        return githubComJetstackCertManagerPkgApisAcmeV1Challenge;
    }

    @JsonProperty("github_com_jetstack_cert-manager_pkg_apis_acme_v1_Challenge")
    public void setGithubComJetstackCertManagerPkgApisAcmeV1Challenge(Challenge githubComJetstackCertManagerPkgApisAcmeV1Challenge) {
        this.githubComJetstackCertManagerPkgApisAcmeV1Challenge = githubComJetstackCertManagerPkgApisAcmeV1Challenge;
    }

    @JsonProperty("github_com_jetstack_cert-manager_pkg_apis_acme_v1_ChallengeList")
    public ChallengeList getGithubComJetstackCertManagerPkgApisAcmeV1ChallengeList() {
        return githubComJetstackCertManagerPkgApisAcmeV1ChallengeList;
    }

    @JsonProperty("github_com_jetstack_cert-manager_pkg_apis_acme_v1_ChallengeList")
    public void setGithubComJetstackCertManagerPkgApisAcmeV1ChallengeList(ChallengeList githubComJetstackCertManagerPkgApisAcmeV1ChallengeList) {
        this.githubComJetstackCertManagerPkgApisAcmeV1ChallengeList = githubComJetstackCertManagerPkgApisAcmeV1ChallengeList;
    }

    @JsonProperty("github_com_jetstack_cert-manager_pkg_apis_acme_v1_ChallengeSpec")
    public ChallengeSpec getGithubComJetstackCertManagerPkgApisAcmeV1ChallengeSpec() {
        return githubComJetstackCertManagerPkgApisAcmeV1ChallengeSpec;
    }

    @JsonProperty("github_com_jetstack_cert-manager_pkg_apis_acme_v1_ChallengeSpec")
    public void setGithubComJetstackCertManagerPkgApisAcmeV1ChallengeSpec(ChallengeSpec githubComJetstackCertManagerPkgApisAcmeV1ChallengeSpec) {
        this.githubComJetstackCertManagerPkgApisAcmeV1ChallengeSpec = githubComJetstackCertManagerPkgApisAcmeV1ChallengeSpec;
    }

    @JsonProperty("github_com_jetstack_cert-manager_pkg_apis_acme_v1_ChallengeStatus")
    public ChallengeStatus getGithubComJetstackCertManagerPkgApisAcmeV1ChallengeStatus() {
        return githubComJetstackCertManagerPkgApisAcmeV1ChallengeStatus;
    }

    @JsonProperty("github_com_jetstack_cert-manager_pkg_apis_acme_v1_ChallengeStatus")
    public void setGithubComJetstackCertManagerPkgApisAcmeV1ChallengeStatus(ChallengeStatus githubComJetstackCertManagerPkgApisAcmeV1ChallengeStatus) {
        this.githubComJetstackCertManagerPkgApisAcmeV1ChallengeStatus = githubComJetstackCertManagerPkgApisAcmeV1ChallengeStatus;
    }

    @JsonProperty("github_com_jetstack_cert-manager_pkg_apis_acme_v1_Order")
    public Order getGithubComJetstackCertManagerPkgApisAcmeV1Order() {
        return githubComJetstackCertManagerPkgApisAcmeV1Order;
    }

    @JsonProperty("github_com_jetstack_cert-manager_pkg_apis_acme_v1_Order")
    public void setGithubComJetstackCertManagerPkgApisAcmeV1Order(Order githubComJetstackCertManagerPkgApisAcmeV1Order) {
        this.githubComJetstackCertManagerPkgApisAcmeV1Order = githubComJetstackCertManagerPkgApisAcmeV1Order;
    }

    @JsonProperty("github_com_jetstack_cert-manager_pkg_apis_acme_v1_OrderList")
    public OrderList getGithubComJetstackCertManagerPkgApisAcmeV1OrderList() {
        return githubComJetstackCertManagerPkgApisAcmeV1OrderList;
    }

    @JsonProperty("github_com_jetstack_cert-manager_pkg_apis_acme_v1_OrderList")
    public void setGithubComJetstackCertManagerPkgApisAcmeV1OrderList(OrderList githubComJetstackCertManagerPkgApisAcmeV1OrderList) {
        this.githubComJetstackCertManagerPkgApisAcmeV1OrderList = githubComJetstackCertManagerPkgApisAcmeV1OrderList;
    }

    @JsonProperty("github_com_jetstack_cert-manager_pkg_apis_acme_v1_OrderSpec")
    public OrderSpec getGithubComJetstackCertManagerPkgApisAcmeV1OrderSpec() {
        return githubComJetstackCertManagerPkgApisAcmeV1OrderSpec;
    }

    @JsonProperty("github_com_jetstack_cert-manager_pkg_apis_acme_v1_OrderSpec")
    public void setGithubComJetstackCertManagerPkgApisAcmeV1OrderSpec(OrderSpec githubComJetstackCertManagerPkgApisAcmeV1OrderSpec) {
        this.githubComJetstackCertManagerPkgApisAcmeV1OrderSpec = githubComJetstackCertManagerPkgApisAcmeV1OrderSpec;
    }

    @JsonProperty("github_com_jetstack_cert-manager_pkg_apis_acme_v1_OrderStatus")
    public OrderStatus getGithubComJetstackCertManagerPkgApisAcmeV1OrderStatus() {
        return githubComJetstackCertManagerPkgApisAcmeV1OrderStatus;
    }

    @JsonProperty("github_com_jetstack_cert-manager_pkg_apis_acme_v1_OrderStatus")
    public void setGithubComJetstackCertManagerPkgApisAcmeV1OrderStatus(OrderStatus githubComJetstackCertManagerPkgApisAcmeV1OrderStatus) {
        this.githubComJetstackCertManagerPkgApisAcmeV1OrderStatus = githubComJetstackCertManagerPkgApisAcmeV1OrderStatus;
    }

    @JsonProperty("github_com_jetstack_cert-manager_pkg_apis_certmanager_v1_CAIssuer")
    public CAIssuer getGithubComJetstackCertManagerPkgApisCertmanagerV1CAIssuer() {
        return githubComJetstackCertManagerPkgApisCertmanagerV1CAIssuer;
    }

    @JsonProperty("github_com_jetstack_cert-manager_pkg_apis_certmanager_v1_CAIssuer")
    public void setGithubComJetstackCertManagerPkgApisCertmanagerV1CAIssuer(CAIssuer githubComJetstackCertManagerPkgApisCertmanagerV1CAIssuer) {
        this.githubComJetstackCertManagerPkgApisCertmanagerV1CAIssuer = githubComJetstackCertManagerPkgApisCertmanagerV1CAIssuer;
    }

    @JsonProperty("github_com_jetstack_cert-manager_pkg_apis_certmanager_v1_Certificate")
    public Certificate getGithubComJetstackCertManagerPkgApisCertmanagerV1Certificate() {
        return githubComJetstackCertManagerPkgApisCertmanagerV1Certificate;
    }

    @JsonProperty("github_com_jetstack_cert-manager_pkg_apis_certmanager_v1_Certificate")
    public void setGithubComJetstackCertManagerPkgApisCertmanagerV1Certificate(Certificate githubComJetstackCertManagerPkgApisCertmanagerV1Certificate) {
        this.githubComJetstackCertManagerPkgApisCertmanagerV1Certificate = githubComJetstackCertManagerPkgApisCertmanagerV1Certificate;
    }

    @JsonProperty("github_com_jetstack_cert-manager_pkg_apis_certmanager_v1_CertificateCondition")
    public CertificateCondition getGithubComJetstackCertManagerPkgApisCertmanagerV1CertificateCondition() {
        return githubComJetstackCertManagerPkgApisCertmanagerV1CertificateCondition;
    }

    @JsonProperty("github_com_jetstack_cert-manager_pkg_apis_certmanager_v1_CertificateCondition")
    public void setGithubComJetstackCertManagerPkgApisCertmanagerV1CertificateCondition(CertificateCondition githubComJetstackCertManagerPkgApisCertmanagerV1CertificateCondition) {
        this.githubComJetstackCertManagerPkgApisCertmanagerV1CertificateCondition = githubComJetstackCertManagerPkgApisCertmanagerV1CertificateCondition;
    }

    @JsonProperty("github_com_jetstack_cert-manager_pkg_apis_certmanager_v1_CertificateKeystores")
    public CertificateKeystores getGithubComJetstackCertManagerPkgApisCertmanagerV1CertificateKeystores() {
        return githubComJetstackCertManagerPkgApisCertmanagerV1CertificateKeystores;
    }

    @JsonProperty("github_com_jetstack_cert-manager_pkg_apis_certmanager_v1_CertificateKeystores")
    public void setGithubComJetstackCertManagerPkgApisCertmanagerV1CertificateKeystores(CertificateKeystores githubComJetstackCertManagerPkgApisCertmanagerV1CertificateKeystores) {
        this.githubComJetstackCertManagerPkgApisCertmanagerV1CertificateKeystores = githubComJetstackCertManagerPkgApisCertmanagerV1CertificateKeystores;
    }

    @JsonProperty("github_com_jetstack_cert-manager_pkg_apis_certmanager_v1_CertificateList")
    public CertificateList getGithubComJetstackCertManagerPkgApisCertmanagerV1CertificateList() {
        return githubComJetstackCertManagerPkgApisCertmanagerV1CertificateList;
    }

    @JsonProperty("github_com_jetstack_cert-manager_pkg_apis_certmanager_v1_CertificateList")
    public void setGithubComJetstackCertManagerPkgApisCertmanagerV1CertificateList(CertificateList githubComJetstackCertManagerPkgApisCertmanagerV1CertificateList) {
        this.githubComJetstackCertManagerPkgApisCertmanagerV1CertificateList = githubComJetstackCertManagerPkgApisCertmanagerV1CertificateList;
    }

    @JsonProperty("github_com_jetstack_cert-manager_pkg_apis_certmanager_v1_CertificatePrivateKey")
    public CertificatePrivateKey getGithubComJetstackCertManagerPkgApisCertmanagerV1CertificatePrivateKey() {
        return githubComJetstackCertManagerPkgApisCertmanagerV1CertificatePrivateKey;
    }

    @JsonProperty("github_com_jetstack_cert-manager_pkg_apis_certmanager_v1_CertificatePrivateKey")
    public void setGithubComJetstackCertManagerPkgApisCertmanagerV1CertificatePrivateKey(CertificatePrivateKey githubComJetstackCertManagerPkgApisCertmanagerV1CertificatePrivateKey) {
        this.githubComJetstackCertManagerPkgApisCertmanagerV1CertificatePrivateKey = githubComJetstackCertManagerPkgApisCertmanagerV1CertificatePrivateKey;
    }

    @JsonProperty("github_com_jetstack_cert-manager_pkg_apis_certmanager_v1_CertificateRequest")
    public CertificateRequest getGithubComJetstackCertManagerPkgApisCertmanagerV1CertificateRequest() {
        return githubComJetstackCertManagerPkgApisCertmanagerV1CertificateRequest;
    }

    @JsonProperty("github_com_jetstack_cert-manager_pkg_apis_certmanager_v1_CertificateRequest")
    public void setGithubComJetstackCertManagerPkgApisCertmanagerV1CertificateRequest(CertificateRequest githubComJetstackCertManagerPkgApisCertmanagerV1CertificateRequest) {
        this.githubComJetstackCertManagerPkgApisCertmanagerV1CertificateRequest = githubComJetstackCertManagerPkgApisCertmanagerV1CertificateRequest;
    }

    @JsonProperty("github_com_jetstack_cert-manager_pkg_apis_certmanager_v1_CertificateRequestCondition")
    public CertificateRequestCondition getGithubComJetstackCertManagerPkgApisCertmanagerV1CertificateRequestCondition() {
        return githubComJetstackCertManagerPkgApisCertmanagerV1CertificateRequestCondition;
    }

    @JsonProperty("github_com_jetstack_cert-manager_pkg_apis_certmanager_v1_CertificateRequestCondition")
    public void setGithubComJetstackCertManagerPkgApisCertmanagerV1CertificateRequestCondition(CertificateRequestCondition githubComJetstackCertManagerPkgApisCertmanagerV1CertificateRequestCondition) {
        this.githubComJetstackCertManagerPkgApisCertmanagerV1CertificateRequestCondition = githubComJetstackCertManagerPkgApisCertmanagerV1CertificateRequestCondition;
    }

    @JsonProperty("github_com_jetstack_cert-manager_pkg_apis_certmanager_v1_CertificateRequestList")
    public CertificateRequestList getGithubComJetstackCertManagerPkgApisCertmanagerV1CertificateRequestList() {
        return githubComJetstackCertManagerPkgApisCertmanagerV1CertificateRequestList;
    }

    @JsonProperty("github_com_jetstack_cert-manager_pkg_apis_certmanager_v1_CertificateRequestList")
    public void setGithubComJetstackCertManagerPkgApisCertmanagerV1CertificateRequestList(CertificateRequestList githubComJetstackCertManagerPkgApisCertmanagerV1CertificateRequestList) {
        this.githubComJetstackCertManagerPkgApisCertmanagerV1CertificateRequestList = githubComJetstackCertManagerPkgApisCertmanagerV1CertificateRequestList;
    }

    @JsonProperty("github_com_jetstack_cert-manager_pkg_apis_certmanager_v1_CertificateRequestSpec")
    public CertificateRequestSpec getGithubComJetstackCertManagerPkgApisCertmanagerV1CertificateRequestSpec() {
        return githubComJetstackCertManagerPkgApisCertmanagerV1CertificateRequestSpec;
    }

    @JsonProperty("github_com_jetstack_cert-manager_pkg_apis_certmanager_v1_CertificateRequestSpec")
    public void setGithubComJetstackCertManagerPkgApisCertmanagerV1CertificateRequestSpec(CertificateRequestSpec githubComJetstackCertManagerPkgApisCertmanagerV1CertificateRequestSpec) {
        this.githubComJetstackCertManagerPkgApisCertmanagerV1CertificateRequestSpec = githubComJetstackCertManagerPkgApisCertmanagerV1CertificateRequestSpec;
    }

    @JsonProperty("github_com_jetstack_cert-manager_pkg_apis_certmanager_v1_CertificateRequestStatus")
    public CertificateRequestStatus getGithubComJetstackCertManagerPkgApisCertmanagerV1CertificateRequestStatus() {
        return githubComJetstackCertManagerPkgApisCertmanagerV1CertificateRequestStatus;
    }

    @JsonProperty("github_com_jetstack_cert-manager_pkg_apis_certmanager_v1_CertificateRequestStatus")
    public void setGithubComJetstackCertManagerPkgApisCertmanagerV1CertificateRequestStatus(CertificateRequestStatus githubComJetstackCertManagerPkgApisCertmanagerV1CertificateRequestStatus) {
        this.githubComJetstackCertManagerPkgApisCertmanagerV1CertificateRequestStatus = githubComJetstackCertManagerPkgApisCertmanagerV1CertificateRequestStatus;
    }

    @JsonProperty("github_com_jetstack_cert-manager_pkg_apis_certmanager_v1_CertificateSpec")
    public CertificateSpec getGithubComJetstackCertManagerPkgApisCertmanagerV1CertificateSpec() {
        return githubComJetstackCertManagerPkgApisCertmanagerV1CertificateSpec;
    }

    @JsonProperty("github_com_jetstack_cert-manager_pkg_apis_certmanager_v1_CertificateSpec")
    public void setGithubComJetstackCertManagerPkgApisCertmanagerV1CertificateSpec(CertificateSpec githubComJetstackCertManagerPkgApisCertmanagerV1CertificateSpec) {
        this.githubComJetstackCertManagerPkgApisCertmanagerV1CertificateSpec = githubComJetstackCertManagerPkgApisCertmanagerV1CertificateSpec;
    }

    @JsonProperty("github_com_jetstack_cert-manager_pkg_apis_certmanager_v1_CertificateStatus")
    public CertificateStatus getGithubComJetstackCertManagerPkgApisCertmanagerV1CertificateStatus() {
        return githubComJetstackCertManagerPkgApisCertmanagerV1CertificateStatus;
    }

    @JsonProperty("github_com_jetstack_cert-manager_pkg_apis_certmanager_v1_CertificateStatus")
    public void setGithubComJetstackCertManagerPkgApisCertmanagerV1CertificateStatus(CertificateStatus githubComJetstackCertManagerPkgApisCertmanagerV1CertificateStatus) {
        this.githubComJetstackCertManagerPkgApisCertmanagerV1CertificateStatus = githubComJetstackCertManagerPkgApisCertmanagerV1CertificateStatus;
    }

    @JsonProperty("github_com_jetstack_cert-manager_pkg_apis_certmanager_v1_ClusterIssuer")
    public ClusterIssuer getGithubComJetstackCertManagerPkgApisCertmanagerV1ClusterIssuer() {
        return githubComJetstackCertManagerPkgApisCertmanagerV1ClusterIssuer;
    }

    @JsonProperty("github_com_jetstack_cert-manager_pkg_apis_certmanager_v1_ClusterIssuer")
    public void setGithubComJetstackCertManagerPkgApisCertmanagerV1ClusterIssuer(ClusterIssuer githubComJetstackCertManagerPkgApisCertmanagerV1ClusterIssuer) {
        this.githubComJetstackCertManagerPkgApisCertmanagerV1ClusterIssuer = githubComJetstackCertManagerPkgApisCertmanagerV1ClusterIssuer;
    }

    @JsonProperty("github_com_jetstack_cert-manager_pkg_apis_certmanager_v1_ClusterIssuerList")
    public ClusterIssuerList getGithubComJetstackCertManagerPkgApisCertmanagerV1ClusterIssuerList() {
        return githubComJetstackCertManagerPkgApisCertmanagerV1ClusterIssuerList;
    }

    @JsonProperty("github_com_jetstack_cert-manager_pkg_apis_certmanager_v1_ClusterIssuerList")
    public void setGithubComJetstackCertManagerPkgApisCertmanagerV1ClusterIssuerList(ClusterIssuerList githubComJetstackCertManagerPkgApisCertmanagerV1ClusterIssuerList) {
        this.githubComJetstackCertManagerPkgApisCertmanagerV1ClusterIssuerList = githubComJetstackCertManagerPkgApisCertmanagerV1ClusterIssuerList;
    }

    @JsonProperty("github_com_jetstack_cert-manager_pkg_apis_certmanager_v1_Issuer")
    public Issuer getGithubComJetstackCertManagerPkgApisCertmanagerV1Issuer() {
        return githubComJetstackCertManagerPkgApisCertmanagerV1Issuer;
    }

    @JsonProperty("github_com_jetstack_cert-manager_pkg_apis_certmanager_v1_Issuer")
    public void setGithubComJetstackCertManagerPkgApisCertmanagerV1Issuer(Issuer githubComJetstackCertManagerPkgApisCertmanagerV1Issuer) {
        this.githubComJetstackCertManagerPkgApisCertmanagerV1Issuer = githubComJetstackCertManagerPkgApisCertmanagerV1Issuer;
    }

    @JsonProperty("github_com_jetstack_cert-manager_pkg_apis_certmanager_v1_IssuerCondition")
    public IssuerCondition getGithubComJetstackCertManagerPkgApisCertmanagerV1IssuerCondition() {
        return githubComJetstackCertManagerPkgApisCertmanagerV1IssuerCondition;
    }

    @JsonProperty("github_com_jetstack_cert-manager_pkg_apis_certmanager_v1_IssuerCondition")
    public void setGithubComJetstackCertManagerPkgApisCertmanagerV1IssuerCondition(IssuerCondition githubComJetstackCertManagerPkgApisCertmanagerV1IssuerCondition) {
        this.githubComJetstackCertManagerPkgApisCertmanagerV1IssuerCondition = githubComJetstackCertManagerPkgApisCertmanagerV1IssuerCondition;
    }

    @JsonProperty("github_com_jetstack_cert-manager_pkg_apis_certmanager_v1_IssuerList")
    public IssuerList getGithubComJetstackCertManagerPkgApisCertmanagerV1IssuerList() {
        return githubComJetstackCertManagerPkgApisCertmanagerV1IssuerList;
    }

    @JsonProperty("github_com_jetstack_cert-manager_pkg_apis_certmanager_v1_IssuerList")
    public void setGithubComJetstackCertManagerPkgApisCertmanagerV1IssuerList(IssuerList githubComJetstackCertManagerPkgApisCertmanagerV1IssuerList) {
        this.githubComJetstackCertManagerPkgApisCertmanagerV1IssuerList = githubComJetstackCertManagerPkgApisCertmanagerV1IssuerList;
    }

    @JsonProperty("github_com_jetstack_cert-manager_pkg_apis_certmanager_v1_IssuerSpec")
    public IssuerSpec getGithubComJetstackCertManagerPkgApisCertmanagerV1IssuerSpec() {
        return githubComJetstackCertManagerPkgApisCertmanagerV1IssuerSpec;
    }

    @JsonProperty("github_com_jetstack_cert-manager_pkg_apis_certmanager_v1_IssuerSpec")
    public void setGithubComJetstackCertManagerPkgApisCertmanagerV1IssuerSpec(IssuerSpec githubComJetstackCertManagerPkgApisCertmanagerV1IssuerSpec) {
        this.githubComJetstackCertManagerPkgApisCertmanagerV1IssuerSpec = githubComJetstackCertManagerPkgApisCertmanagerV1IssuerSpec;
    }

    @JsonProperty("github_com_jetstack_cert-manager_pkg_apis_certmanager_v1_IssuerStatus")
    public IssuerStatus getGithubComJetstackCertManagerPkgApisCertmanagerV1IssuerStatus() {
        return githubComJetstackCertManagerPkgApisCertmanagerV1IssuerStatus;
    }

    @JsonProperty("github_com_jetstack_cert-manager_pkg_apis_certmanager_v1_IssuerStatus")
    public void setGithubComJetstackCertManagerPkgApisCertmanagerV1IssuerStatus(IssuerStatus githubComJetstackCertManagerPkgApisCertmanagerV1IssuerStatus) {
        this.githubComJetstackCertManagerPkgApisCertmanagerV1IssuerStatus = githubComJetstackCertManagerPkgApisCertmanagerV1IssuerStatus;
    }

    @JsonProperty("github_com_jetstack_cert-manager_pkg_apis_certmanager_v1_JKSKeystore")
    public JKSKeystore getGithubComJetstackCertManagerPkgApisCertmanagerV1JKSKeystore() {
        return githubComJetstackCertManagerPkgApisCertmanagerV1JKSKeystore;
    }

    @JsonProperty("github_com_jetstack_cert-manager_pkg_apis_certmanager_v1_JKSKeystore")
    public void setGithubComJetstackCertManagerPkgApisCertmanagerV1JKSKeystore(JKSKeystore githubComJetstackCertManagerPkgApisCertmanagerV1JKSKeystore) {
        this.githubComJetstackCertManagerPkgApisCertmanagerV1JKSKeystore = githubComJetstackCertManagerPkgApisCertmanagerV1JKSKeystore;
    }

    @JsonProperty("github_com_jetstack_cert-manager_pkg_apis_certmanager_v1_PKCS12Keystore")
    public PKCS12Keystore getGithubComJetstackCertManagerPkgApisCertmanagerV1PKCS12Keystore() {
        return githubComJetstackCertManagerPkgApisCertmanagerV1PKCS12Keystore;
    }

    @JsonProperty("github_com_jetstack_cert-manager_pkg_apis_certmanager_v1_PKCS12Keystore")
    public void setGithubComJetstackCertManagerPkgApisCertmanagerV1PKCS12Keystore(PKCS12Keystore githubComJetstackCertManagerPkgApisCertmanagerV1PKCS12Keystore) {
        this.githubComJetstackCertManagerPkgApisCertmanagerV1PKCS12Keystore = githubComJetstackCertManagerPkgApisCertmanagerV1PKCS12Keystore;
    }

    @JsonProperty("github_com_jetstack_cert-manager_pkg_apis_certmanager_v1_SelfSignedIssuer")
    public SelfSignedIssuer getGithubComJetstackCertManagerPkgApisCertmanagerV1SelfSignedIssuer() {
        return githubComJetstackCertManagerPkgApisCertmanagerV1SelfSignedIssuer;
    }

    @JsonProperty("github_com_jetstack_cert-manager_pkg_apis_certmanager_v1_SelfSignedIssuer")
    public void setGithubComJetstackCertManagerPkgApisCertmanagerV1SelfSignedIssuer(SelfSignedIssuer githubComJetstackCertManagerPkgApisCertmanagerV1SelfSignedIssuer) {
        this.githubComJetstackCertManagerPkgApisCertmanagerV1SelfSignedIssuer = githubComJetstackCertManagerPkgApisCertmanagerV1SelfSignedIssuer;
    }

    @JsonProperty("github_com_jetstack_cert-manager_pkg_apis_certmanager_v1_VaultAppRole")
    public VaultAppRole getGithubComJetstackCertManagerPkgApisCertmanagerV1VaultAppRole() {
        return githubComJetstackCertManagerPkgApisCertmanagerV1VaultAppRole;
    }

    @JsonProperty("github_com_jetstack_cert-manager_pkg_apis_certmanager_v1_VaultAppRole")
    public void setGithubComJetstackCertManagerPkgApisCertmanagerV1VaultAppRole(VaultAppRole githubComJetstackCertManagerPkgApisCertmanagerV1VaultAppRole) {
        this.githubComJetstackCertManagerPkgApisCertmanagerV1VaultAppRole = githubComJetstackCertManagerPkgApisCertmanagerV1VaultAppRole;
    }

    @JsonProperty("github_com_jetstack_cert-manager_pkg_apis_certmanager_v1_VaultAuth")
    public VaultAuth getGithubComJetstackCertManagerPkgApisCertmanagerV1VaultAuth() {
        return githubComJetstackCertManagerPkgApisCertmanagerV1VaultAuth;
    }

    @JsonProperty("github_com_jetstack_cert-manager_pkg_apis_certmanager_v1_VaultAuth")
    public void setGithubComJetstackCertManagerPkgApisCertmanagerV1VaultAuth(VaultAuth githubComJetstackCertManagerPkgApisCertmanagerV1VaultAuth) {
        this.githubComJetstackCertManagerPkgApisCertmanagerV1VaultAuth = githubComJetstackCertManagerPkgApisCertmanagerV1VaultAuth;
    }

    @JsonProperty("github_com_jetstack_cert-manager_pkg_apis_certmanager_v1_VaultIssuer")
    public VaultIssuer getGithubComJetstackCertManagerPkgApisCertmanagerV1VaultIssuer() {
        return githubComJetstackCertManagerPkgApisCertmanagerV1VaultIssuer;
    }

    @JsonProperty("github_com_jetstack_cert-manager_pkg_apis_certmanager_v1_VaultIssuer")
    public void setGithubComJetstackCertManagerPkgApisCertmanagerV1VaultIssuer(VaultIssuer githubComJetstackCertManagerPkgApisCertmanagerV1VaultIssuer) {
        this.githubComJetstackCertManagerPkgApisCertmanagerV1VaultIssuer = githubComJetstackCertManagerPkgApisCertmanagerV1VaultIssuer;
    }

    @JsonProperty("github_com_jetstack_cert-manager_pkg_apis_certmanager_v1_VaultKubernetesAuth")
    public VaultKubernetesAuth getGithubComJetstackCertManagerPkgApisCertmanagerV1VaultKubernetesAuth() {
        return githubComJetstackCertManagerPkgApisCertmanagerV1VaultKubernetesAuth;
    }

    @JsonProperty("github_com_jetstack_cert-manager_pkg_apis_certmanager_v1_VaultKubernetesAuth")
    public void setGithubComJetstackCertManagerPkgApisCertmanagerV1VaultKubernetesAuth(VaultKubernetesAuth githubComJetstackCertManagerPkgApisCertmanagerV1VaultKubernetesAuth) {
        this.githubComJetstackCertManagerPkgApisCertmanagerV1VaultKubernetesAuth = githubComJetstackCertManagerPkgApisCertmanagerV1VaultKubernetesAuth;
    }

    @JsonProperty("github_com_jetstack_cert-manager_pkg_apis_certmanager_v1_VenafiCloud")
    public VenafiCloud getGithubComJetstackCertManagerPkgApisCertmanagerV1VenafiCloud() {
        return githubComJetstackCertManagerPkgApisCertmanagerV1VenafiCloud;
    }

    @JsonProperty("github_com_jetstack_cert-manager_pkg_apis_certmanager_v1_VenafiCloud")
    public void setGithubComJetstackCertManagerPkgApisCertmanagerV1VenafiCloud(VenafiCloud githubComJetstackCertManagerPkgApisCertmanagerV1VenafiCloud) {
        this.githubComJetstackCertManagerPkgApisCertmanagerV1VenafiCloud = githubComJetstackCertManagerPkgApisCertmanagerV1VenafiCloud;
    }

    @JsonProperty("github_com_jetstack_cert-manager_pkg_apis_certmanager_v1_VenafiIssuer")
    public VenafiIssuer getGithubComJetstackCertManagerPkgApisCertmanagerV1VenafiIssuer() {
        return githubComJetstackCertManagerPkgApisCertmanagerV1VenafiIssuer;
    }

    @JsonProperty("github_com_jetstack_cert-manager_pkg_apis_certmanager_v1_VenafiIssuer")
    public void setGithubComJetstackCertManagerPkgApisCertmanagerV1VenafiIssuer(VenafiIssuer githubComJetstackCertManagerPkgApisCertmanagerV1VenafiIssuer) {
        this.githubComJetstackCertManagerPkgApisCertmanagerV1VenafiIssuer = githubComJetstackCertManagerPkgApisCertmanagerV1VenafiIssuer;
    }

    @JsonProperty("github_com_jetstack_cert-manager_pkg_apis_certmanager_v1_VenafiTPP")
    public VenafiTPP getGithubComJetstackCertManagerPkgApisCertmanagerV1VenafiTPP() {
        return githubComJetstackCertManagerPkgApisCertmanagerV1VenafiTPP;
    }

    @JsonProperty("github_com_jetstack_cert-manager_pkg_apis_certmanager_v1_VenafiTPP")
    public void setGithubComJetstackCertManagerPkgApisCertmanagerV1VenafiTPP(VenafiTPP githubComJetstackCertManagerPkgApisCertmanagerV1VenafiTPP) {
        this.githubComJetstackCertManagerPkgApisCertmanagerV1VenafiTPP = githubComJetstackCertManagerPkgApisCertmanagerV1VenafiTPP;
    }

    @JsonProperty("github_com_jetstack_cert-manager_pkg_apis_certmanager_v1_X509Subject")
    public X509Subject getGithubComJetstackCertManagerPkgApisCertmanagerV1X509Subject() {
        return githubComJetstackCertManagerPkgApisCertmanagerV1X509Subject;
    }

    @JsonProperty("github_com_jetstack_cert-manager_pkg_apis_certmanager_v1_X509Subject")
    public void setGithubComJetstackCertManagerPkgApisCertmanagerV1X509Subject(X509Subject githubComJetstackCertManagerPkgApisCertmanagerV1X509Subject) {
        this.githubComJetstackCertManagerPkgApisCertmanagerV1X509Subject = githubComJetstackCertManagerPkgApisCertmanagerV1X509Subject;
    }

    @JsonProperty("github_com_jetstack_cert-manager_pkg_apis_meta_v1_LocalObjectReference")
    public io.fabric8.certmanager.api.model.meta.v1.LocalObjectReference getGithubComJetstackCertManagerPkgApisMetaV1LocalObjectReference() {
        return githubComJetstackCertManagerPkgApisMetaV1LocalObjectReference;
    }

    @JsonProperty("github_com_jetstack_cert-manager_pkg_apis_meta_v1_LocalObjectReference")
    public void setGithubComJetstackCertManagerPkgApisMetaV1LocalObjectReference(io.fabric8.certmanager.api.model.meta.v1.LocalObjectReference githubComJetstackCertManagerPkgApisMetaV1LocalObjectReference) {
        this.githubComJetstackCertManagerPkgApisMetaV1LocalObjectReference = githubComJetstackCertManagerPkgApisMetaV1LocalObjectReference;
    }

    @JsonProperty("github_com_jetstack_cert-manager_pkg_apis_meta_v1_ObjectReference")
    public io.fabric8.certmanager.api.model.meta.v1.ObjectReference getGithubComJetstackCertManagerPkgApisMetaV1ObjectReference() {
        return githubComJetstackCertManagerPkgApisMetaV1ObjectReference;
    }

    @JsonProperty("github_com_jetstack_cert-manager_pkg_apis_meta_v1_ObjectReference")
    public void setGithubComJetstackCertManagerPkgApisMetaV1ObjectReference(io.fabric8.certmanager.api.model.meta.v1.ObjectReference githubComJetstackCertManagerPkgApisMetaV1ObjectReference) {
        this.githubComJetstackCertManagerPkgApisMetaV1ObjectReference = githubComJetstackCertManagerPkgApisMetaV1ObjectReference;
    }

    @JsonProperty("github_com_jetstack_cert-manager_pkg_apis_meta_v1_SecretKeySelector")
    public SecretKeySelector getGithubComJetstackCertManagerPkgApisMetaV1SecretKeySelector() {
        return githubComJetstackCertManagerPkgApisMetaV1SecretKeySelector;
    }

    @JsonProperty("github_com_jetstack_cert-manager_pkg_apis_meta_v1_SecretKeySelector")
    public void setGithubComJetstackCertManagerPkgApisMetaV1SecretKeySelector(SecretKeySelector githubComJetstackCertManagerPkgApisMetaV1SecretKeySelector) {
        this.githubComJetstackCertManagerPkgApisMetaV1SecretKeySelector = githubComJetstackCertManagerPkgApisMetaV1SecretKeySelector;
    }

}
