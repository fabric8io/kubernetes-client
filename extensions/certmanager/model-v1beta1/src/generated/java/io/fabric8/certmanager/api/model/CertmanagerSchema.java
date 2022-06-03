
package io.fabric8.certmanager.api.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import io.fabric8.certmanager.api.model.acme.v1beta1.ACMEAuthorization;
import io.fabric8.certmanager.api.model.acme.v1beta1.ACMEChallenge;
import io.fabric8.certmanager.api.model.acme.v1beta1.ACMEChallengeSolver;
import io.fabric8.certmanager.api.model.acme.v1beta1.ACMEChallengeSolverDNS01;
import io.fabric8.certmanager.api.model.acme.v1beta1.ACMEChallengeSolverHTTP01;
import io.fabric8.certmanager.api.model.acme.v1beta1.ACMEChallengeSolverHTTP01Ingress;
import io.fabric8.certmanager.api.model.acme.v1beta1.ACMEChallengeSolverHTTP01IngressObjectMeta;
import io.fabric8.certmanager.api.model.acme.v1beta1.ACMEChallengeSolverHTTP01IngressPodObjectMeta;
import io.fabric8.certmanager.api.model.acme.v1beta1.ACMEChallengeSolverHTTP01IngressPodSpec;
import io.fabric8.certmanager.api.model.acme.v1beta1.ACMEChallengeSolverHTTP01IngressPodTemplate;
import io.fabric8.certmanager.api.model.acme.v1beta1.ACMEChallengeSolverHTTP01IngressTemplate;
import io.fabric8.certmanager.api.model.acme.v1beta1.ACMEExternalAccountBinding;
import io.fabric8.certmanager.api.model.acme.v1beta1.ACMEIssuer;
import io.fabric8.certmanager.api.model.acme.v1beta1.ACMEIssuerDNS01ProviderAcmeDNS;
import io.fabric8.certmanager.api.model.acme.v1beta1.ACMEIssuerDNS01ProviderAkamai;
import io.fabric8.certmanager.api.model.acme.v1beta1.ACMEIssuerDNS01ProviderAzureDNS;
import io.fabric8.certmanager.api.model.acme.v1beta1.ACMEIssuerDNS01ProviderCloudDNS;
import io.fabric8.certmanager.api.model.acme.v1beta1.ACMEIssuerDNS01ProviderCloudflare;
import io.fabric8.certmanager.api.model.acme.v1beta1.ACMEIssuerDNS01ProviderDigitalOcean;
import io.fabric8.certmanager.api.model.acme.v1beta1.ACMEIssuerDNS01ProviderRFC2136;
import io.fabric8.certmanager.api.model.acme.v1beta1.ACMEIssuerDNS01ProviderRoute53;
import io.fabric8.certmanager.api.model.acme.v1beta1.ACMEIssuerDNS01ProviderWebhook;
import io.fabric8.certmanager.api.model.acme.v1beta1.ACMEIssuerStatus;
import io.fabric8.certmanager.api.model.acme.v1beta1.CertificateDNSNameSelector;
import io.fabric8.certmanager.api.model.acme.v1beta1.Challenge;
import io.fabric8.certmanager.api.model.acme.v1beta1.ChallengeList;
import io.fabric8.certmanager.api.model.acme.v1beta1.ChallengeSpec;
import io.fabric8.certmanager.api.model.acme.v1beta1.ChallengeStatus;
import io.fabric8.certmanager.api.model.acme.v1beta1.Order;
import io.fabric8.certmanager.api.model.acme.v1beta1.OrderList;
import io.fabric8.certmanager.api.model.acme.v1beta1.OrderSpec;
import io.fabric8.certmanager.api.model.acme.v1beta1.OrderStatus;
import io.fabric8.certmanager.api.model.meta.v1.SecretKeySelector;
import io.fabric8.certmanager.api.model.v1beta1.CAIssuer;
import io.fabric8.certmanager.api.model.v1beta1.Certificate;
import io.fabric8.certmanager.api.model.v1beta1.CertificateCondition;
import io.fabric8.certmanager.api.model.v1beta1.CertificateKeystores;
import io.fabric8.certmanager.api.model.v1beta1.CertificateList;
import io.fabric8.certmanager.api.model.v1beta1.CertificatePrivateKey;
import io.fabric8.certmanager.api.model.v1beta1.CertificateRequest;
import io.fabric8.certmanager.api.model.v1beta1.CertificateRequestCondition;
import io.fabric8.certmanager.api.model.v1beta1.CertificateRequestList;
import io.fabric8.certmanager.api.model.v1beta1.CertificateRequestSpec;
import io.fabric8.certmanager.api.model.v1beta1.CertificateRequestStatus;
import io.fabric8.certmanager.api.model.v1beta1.CertificateSpec;
import io.fabric8.certmanager.api.model.v1beta1.CertificateStatus;
import io.fabric8.certmanager.api.model.v1beta1.ClusterIssuer;
import io.fabric8.certmanager.api.model.v1beta1.ClusterIssuerList;
import io.fabric8.certmanager.api.model.v1beta1.Issuer;
import io.fabric8.certmanager.api.model.v1beta1.IssuerCondition;
import io.fabric8.certmanager.api.model.v1beta1.IssuerList;
import io.fabric8.certmanager.api.model.v1beta1.IssuerSpec;
import io.fabric8.certmanager.api.model.v1beta1.IssuerStatus;
import io.fabric8.certmanager.api.model.v1beta1.JKSKeystore;
import io.fabric8.certmanager.api.model.v1beta1.PKCS12Keystore;
import io.fabric8.certmanager.api.model.v1beta1.SelfSignedIssuer;
import io.fabric8.certmanager.api.model.v1beta1.VaultAppRole;
import io.fabric8.certmanager.api.model.v1beta1.VaultAuth;
import io.fabric8.certmanager.api.model.v1beta1.VaultIssuer;
import io.fabric8.certmanager.api.model.v1beta1.VaultKubernetesAuth;
import io.fabric8.certmanager.api.model.v1beta1.VenafiCloud;
import io.fabric8.certmanager.api.model.v1beta1.VenafiIssuer;
import io.fabric8.certmanager.api.model.v1beta1.VenafiTPP;
import io.fabric8.certmanager.api.model.v1beta1.X509Subject;
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
    "github_com_jetstack_cert-manager_pkg_apis_acme_v1beta1_ACMEAuthorization",
    "github_com_jetstack_cert-manager_pkg_apis_acme_v1beta1_ACMEChallenge",
    "github_com_jetstack_cert-manager_pkg_apis_acme_v1beta1_ACMEChallengeSolver",
    "github_com_jetstack_cert-manager_pkg_apis_acme_v1beta1_ACMEChallengeSolverDNS01",
    "github_com_jetstack_cert-manager_pkg_apis_acme_v1beta1_ACMEChallengeSolverHTTP01",
    "github_com_jetstack_cert-manager_pkg_apis_acme_v1beta1_ACMEChallengeSolverHTTP01Ingress",
    "github_com_jetstack_cert-manager_pkg_apis_acme_v1beta1_ACMEChallengeSolverHTTP01IngressObjectMeta",
    "github_com_jetstack_cert-manager_pkg_apis_acme_v1beta1_ACMEChallengeSolverHTTP01IngressPodObjectMeta",
    "github_com_jetstack_cert-manager_pkg_apis_acme_v1beta1_ACMEChallengeSolverHTTP01IngressPodSpec",
    "github_com_jetstack_cert-manager_pkg_apis_acme_v1beta1_ACMEChallengeSolverHTTP01IngressPodTemplate",
    "github_com_jetstack_cert-manager_pkg_apis_acme_v1beta1_ACMEChallengeSolverHTTP01IngressTemplate",
    "github_com_jetstack_cert-manager_pkg_apis_acme_v1beta1_ACMEExternalAccountBinding",
    "github_com_jetstack_cert-manager_pkg_apis_acme_v1beta1_ACMEIssuer",
    "github_com_jetstack_cert-manager_pkg_apis_acme_v1beta1_ACMEIssuerDNS01ProviderAcmeDNS",
    "github_com_jetstack_cert-manager_pkg_apis_acme_v1beta1_ACMEIssuerDNS01ProviderAkamai",
    "github_com_jetstack_cert-manager_pkg_apis_acme_v1beta1_ACMEIssuerDNS01ProviderAzureDNS",
    "github_com_jetstack_cert-manager_pkg_apis_acme_v1beta1_ACMEIssuerDNS01ProviderCloudDNS",
    "github_com_jetstack_cert-manager_pkg_apis_acme_v1beta1_ACMEIssuerDNS01ProviderCloudflare",
    "github_com_jetstack_cert-manager_pkg_apis_acme_v1beta1_ACMEIssuerDNS01ProviderDigitalOcean",
    "github_com_jetstack_cert-manager_pkg_apis_acme_v1beta1_ACMEIssuerDNS01ProviderRFC2136",
    "github_com_jetstack_cert-manager_pkg_apis_acme_v1beta1_ACMEIssuerDNS01ProviderRoute53",
    "github_com_jetstack_cert-manager_pkg_apis_acme_v1beta1_ACMEIssuerDNS01ProviderWebhook",
    "github_com_jetstack_cert-manager_pkg_apis_acme_v1beta1_ACMEIssuerStatus",
    "github_com_jetstack_cert-manager_pkg_apis_acme_v1beta1_CertificateDNSNameSelector",
    "github_com_jetstack_cert-manager_pkg_apis_acme_v1beta1_Challenge",
    "github_com_jetstack_cert-manager_pkg_apis_acme_v1beta1_ChallengeList",
    "github_com_jetstack_cert-manager_pkg_apis_acme_v1beta1_ChallengeSpec",
    "github_com_jetstack_cert-manager_pkg_apis_acme_v1beta1_ChallengeStatus",
    "github_com_jetstack_cert-manager_pkg_apis_acme_v1beta1_Order",
    "github_com_jetstack_cert-manager_pkg_apis_acme_v1beta1_OrderList",
    "github_com_jetstack_cert-manager_pkg_apis_acme_v1beta1_OrderSpec",
    "github_com_jetstack_cert-manager_pkg_apis_acme_v1beta1_OrderStatus",
    "github_com_jetstack_cert-manager_pkg_apis_certmanager_v1beta1_CAIssuer",
    "github_com_jetstack_cert-manager_pkg_apis_certmanager_v1beta1_Certificate",
    "github_com_jetstack_cert-manager_pkg_apis_certmanager_v1beta1_CertificateCondition",
    "github_com_jetstack_cert-manager_pkg_apis_certmanager_v1beta1_CertificateKeystores",
    "github_com_jetstack_cert-manager_pkg_apis_certmanager_v1beta1_CertificateList",
    "github_com_jetstack_cert-manager_pkg_apis_certmanager_v1beta1_CertificatePrivateKey",
    "github_com_jetstack_cert-manager_pkg_apis_certmanager_v1beta1_CertificateRequest",
    "github_com_jetstack_cert-manager_pkg_apis_certmanager_v1beta1_CertificateRequestCondition",
    "github_com_jetstack_cert-manager_pkg_apis_certmanager_v1beta1_CertificateRequestList",
    "github_com_jetstack_cert-manager_pkg_apis_certmanager_v1beta1_CertificateRequestSpec",
    "github_com_jetstack_cert-manager_pkg_apis_certmanager_v1beta1_CertificateRequestStatus",
    "github_com_jetstack_cert-manager_pkg_apis_certmanager_v1beta1_CertificateSpec",
    "github_com_jetstack_cert-manager_pkg_apis_certmanager_v1beta1_CertificateStatus",
    "github_com_jetstack_cert-manager_pkg_apis_certmanager_v1beta1_ClusterIssuer",
    "github_com_jetstack_cert-manager_pkg_apis_certmanager_v1beta1_ClusterIssuerList",
    "github_com_jetstack_cert-manager_pkg_apis_certmanager_v1beta1_Issuer",
    "github_com_jetstack_cert-manager_pkg_apis_certmanager_v1beta1_IssuerCondition",
    "github_com_jetstack_cert-manager_pkg_apis_certmanager_v1beta1_IssuerList",
    "github_com_jetstack_cert-manager_pkg_apis_certmanager_v1beta1_IssuerSpec",
    "github_com_jetstack_cert-manager_pkg_apis_certmanager_v1beta1_IssuerStatus",
    "github_com_jetstack_cert-manager_pkg_apis_certmanager_v1beta1_JKSKeystore",
    "github_com_jetstack_cert-manager_pkg_apis_certmanager_v1beta1_PKCS12Keystore",
    "github_com_jetstack_cert-manager_pkg_apis_certmanager_v1beta1_SelfSignedIssuer",
    "github_com_jetstack_cert-manager_pkg_apis_certmanager_v1beta1_VaultAppRole",
    "github_com_jetstack_cert-manager_pkg_apis_certmanager_v1beta1_VaultAuth",
    "github_com_jetstack_cert-manager_pkg_apis_certmanager_v1beta1_VaultIssuer",
    "github_com_jetstack_cert-manager_pkg_apis_certmanager_v1beta1_VaultKubernetesAuth",
    "github_com_jetstack_cert-manager_pkg_apis_certmanager_v1beta1_VenafiCloud",
    "github_com_jetstack_cert-manager_pkg_apis_certmanager_v1beta1_VenafiIssuer",
    "github_com_jetstack_cert-manager_pkg_apis_certmanager_v1beta1_VenafiTPP",
    "github_com_jetstack_cert-manager_pkg_apis_certmanager_v1beta1_X509Subject",
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

    @JsonProperty("github_com_jetstack_cert-manager_pkg_apis_acme_v1beta1_ACMEAuthorization")
    private ACMEAuthorization githubComJetstackCertManagerPkgApisAcmeV1beta1ACMEAuthorization;
    @JsonProperty("github_com_jetstack_cert-manager_pkg_apis_acme_v1beta1_ACMEChallenge")
    private ACMEChallenge githubComJetstackCertManagerPkgApisAcmeV1beta1ACMEChallenge;
    @JsonProperty("github_com_jetstack_cert-manager_pkg_apis_acme_v1beta1_ACMEChallengeSolver")
    private ACMEChallengeSolver githubComJetstackCertManagerPkgApisAcmeV1beta1ACMEChallengeSolver;
    @JsonProperty("github_com_jetstack_cert-manager_pkg_apis_acme_v1beta1_ACMEChallengeSolverDNS01")
    private ACMEChallengeSolverDNS01 githubComJetstackCertManagerPkgApisAcmeV1beta1ACMEChallengeSolverDNS01;
    @JsonProperty("github_com_jetstack_cert-manager_pkg_apis_acme_v1beta1_ACMEChallengeSolverHTTP01")
    private ACMEChallengeSolverHTTP01 githubComJetstackCertManagerPkgApisAcmeV1beta1ACMEChallengeSolverHTTP01;
    @JsonProperty("github_com_jetstack_cert-manager_pkg_apis_acme_v1beta1_ACMEChallengeSolverHTTP01Ingress")
    private ACMEChallengeSolverHTTP01Ingress githubComJetstackCertManagerPkgApisAcmeV1beta1ACMEChallengeSolverHTTP01Ingress;
    @JsonProperty("github_com_jetstack_cert-manager_pkg_apis_acme_v1beta1_ACMEChallengeSolverHTTP01IngressObjectMeta")
    private ACMEChallengeSolverHTTP01IngressObjectMeta githubComJetstackCertManagerPkgApisAcmeV1beta1ACMEChallengeSolverHTTP01IngressObjectMeta;
    @JsonProperty("github_com_jetstack_cert-manager_pkg_apis_acme_v1beta1_ACMEChallengeSolverHTTP01IngressPodObjectMeta")
    private ACMEChallengeSolverHTTP01IngressPodObjectMeta githubComJetstackCertManagerPkgApisAcmeV1beta1ACMEChallengeSolverHTTP01IngressPodObjectMeta;
    @JsonProperty("github_com_jetstack_cert-manager_pkg_apis_acme_v1beta1_ACMEChallengeSolverHTTP01IngressPodSpec")
    private ACMEChallengeSolverHTTP01IngressPodSpec githubComJetstackCertManagerPkgApisAcmeV1beta1ACMEChallengeSolverHTTP01IngressPodSpec;
    @JsonProperty("github_com_jetstack_cert-manager_pkg_apis_acme_v1beta1_ACMEChallengeSolverHTTP01IngressPodTemplate")
    private ACMEChallengeSolverHTTP01IngressPodTemplate githubComJetstackCertManagerPkgApisAcmeV1beta1ACMEChallengeSolverHTTP01IngressPodTemplate;
    @JsonProperty("github_com_jetstack_cert-manager_pkg_apis_acme_v1beta1_ACMEChallengeSolverHTTP01IngressTemplate")
    private ACMEChallengeSolverHTTP01IngressTemplate githubComJetstackCertManagerPkgApisAcmeV1beta1ACMEChallengeSolverHTTP01IngressTemplate;
    @JsonProperty("github_com_jetstack_cert-manager_pkg_apis_acme_v1beta1_ACMEExternalAccountBinding")
    private ACMEExternalAccountBinding githubComJetstackCertManagerPkgApisAcmeV1beta1ACMEExternalAccountBinding;
    @JsonProperty("github_com_jetstack_cert-manager_pkg_apis_acme_v1beta1_ACMEIssuer")
    private ACMEIssuer githubComJetstackCertManagerPkgApisAcmeV1beta1ACMEIssuer;
    @JsonProperty("github_com_jetstack_cert-manager_pkg_apis_acme_v1beta1_ACMEIssuerDNS01ProviderAcmeDNS")
    private ACMEIssuerDNS01ProviderAcmeDNS githubComJetstackCertManagerPkgApisAcmeV1beta1ACMEIssuerDNS01ProviderAcmeDNS;
    @JsonProperty("github_com_jetstack_cert-manager_pkg_apis_acme_v1beta1_ACMEIssuerDNS01ProviderAkamai")
    private ACMEIssuerDNS01ProviderAkamai githubComJetstackCertManagerPkgApisAcmeV1beta1ACMEIssuerDNS01ProviderAkamai;
    @JsonProperty("github_com_jetstack_cert-manager_pkg_apis_acme_v1beta1_ACMEIssuerDNS01ProviderAzureDNS")
    private ACMEIssuerDNS01ProviderAzureDNS githubComJetstackCertManagerPkgApisAcmeV1beta1ACMEIssuerDNS01ProviderAzureDNS;
    @JsonProperty("github_com_jetstack_cert-manager_pkg_apis_acme_v1beta1_ACMEIssuerDNS01ProviderCloudDNS")
    private ACMEIssuerDNS01ProviderCloudDNS githubComJetstackCertManagerPkgApisAcmeV1beta1ACMEIssuerDNS01ProviderCloudDNS;
    @JsonProperty("github_com_jetstack_cert-manager_pkg_apis_acme_v1beta1_ACMEIssuerDNS01ProviderCloudflare")
    private ACMEIssuerDNS01ProviderCloudflare githubComJetstackCertManagerPkgApisAcmeV1beta1ACMEIssuerDNS01ProviderCloudflare;
    @JsonProperty("github_com_jetstack_cert-manager_pkg_apis_acme_v1beta1_ACMEIssuerDNS01ProviderDigitalOcean")
    private ACMEIssuerDNS01ProviderDigitalOcean githubComJetstackCertManagerPkgApisAcmeV1beta1ACMEIssuerDNS01ProviderDigitalOcean;
    @JsonProperty("github_com_jetstack_cert-manager_pkg_apis_acme_v1beta1_ACMEIssuerDNS01ProviderRFC2136")
    private ACMEIssuerDNS01ProviderRFC2136 githubComJetstackCertManagerPkgApisAcmeV1beta1ACMEIssuerDNS01ProviderRFC2136;
    @JsonProperty("github_com_jetstack_cert-manager_pkg_apis_acme_v1beta1_ACMEIssuerDNS01ProviderRoute53")
    private ACMEIssuerDNS01ProviderRoute53 githubComJetstackCertManagerPkgApisAcmeV1beta1ACMEIssuerDNS01ProviderRoute53;
    @JsonProperty("github_com_jetstack_cert-manager_pkg_apis_acme_v1beta1_ACMEIssuerDNS01ProviderWebhook")
    private ACMEIssuerDNS01ProviderWebhook githubComJetstackCertManagerPkgApisAcmeV1beta1ACMEIssuerDNS01ProviderWebhook;
    @JsonProperty("github_com_jetstack_cert-manager_pkg_apis_acme_v1beta1_ACMEIssuerStatus")
    private ACMEIssuerStatus githubComJetstackCertManagerPkgApisAcmeV1beta1ACMEIssuerStatus;
    @JsonProperty("github_com_jetstack_cert-manager_pkg_apis_acme_v1beta1_CertificateDNSNameSelector")
    private CertificateDNSNameSelector githubComJetstackCertManagerPkgApisAcmeV1beta1CertificateDNSNameSelector;
    @JsonProperty("github_com_jetstack_cert-manager_pkg_apis_acme_v1beta1_Challenge")
    private Challenge githubComJetstackCertManagerPkgApisAcmeV1beta1Challenge;
    @JsonProperty("github_com_jetstack_cert-manager_pkg_apis_acme_v1beta1_ChallengeList")
    private ChallengeList githubComJetstackCertManagerPkgApisAcmeV1beta1ChallengeList;
    @JsonProperty("github_com_jetstack_cert-manager_pkg_apis_acme_v1beta1_ChallengeSpec")
    private ChallengeSpec githubComJetstackCertManagerPkgApisAcmeV1beta1ChallengeSpec;
    @JsonProperty("github_com_jetstack_cert-manager_pkg_apis_acme_v1beta1_ChallengeStatus")
    private ChallengeStatus githubComJetstackCertManagerPkgApisAcmeV1beta1ChallengeStatus;
    @JsonProperty("github_com_jetstack_cert-manager_pkg_apis_acme_v1beta1_Order")
    private Order githubComJetstackCertManagerPkgApisAcmeV1beta1Order;
    @JsonProperty("github_com_jetstack_cert-manager_pkg_apis_acme_v1beta1_OrderList")
    private OrderList githubComJetstackCertManagerPkgApisAcmeV1beta1OrderList;
    @JsonProperty("github_com_jetstack_cert-manager_pkg_apis_acme_v1beta1_OrderSpec")
    private OrderSpec githubComJetstackCertManagerPkgApisAcmeV1beta1OrderSpec;
    @JsonProperty("github_com_jetstack_cert-manager_pkg_apis_acme_v1beta1_OrderStatus")
    private OrderStatus githubComJetstackCertManagerPkgApisAcmeV1beta1OrderStatus;
    @JsonProperty("github_com_jetstack_cert-manager_pkg_apis_certmanager_v1beta1_CAIssuer")
    private CAIssuer githubComJetstackCertManagerPkgApisCertmanagerV1beta1CAIssuer;
    @JsonProperty("github_com_jetstack_cert-manager_pkg_apis_certmanager_v1beta1_Certificate")
    private Certificate githubComJetstackCertManagerPkgApisCertmanagerV1beta1Certificate;
    @JsonProperty("github_com_jetstack_cert-manager_pkg_apis_certmanager_v1beta1_CertificateCondition")
    private CertificateCondition githubComJetstackCertManagerPkgApisCertmanagerV1beta1CertificateCondition;
    @JsonProperty("github_com_jetstack_cert-manager_pkg_apis_certmanager_v1beta1_CertificateKeystores")
    private CertificateKeystores githubComJetstackCertManagerPkgApisCertmanagerV1beta1CertificateKeystores;
    @JsonProperty("github_com_jetstack_cert-manager_pkg_apis_certmanager_v1beta1_CertificateList")
    private CertificateList githubComJetstackCertManagerPkgApisCertmanagerV1beta1CertificateList;
    @JsonProperty("github_com_jetstack_cert-manager_pkg_apis_certmanager_v1beta1_CertificatePrivateKey")
    private CertificatePrivateKey githubComJetstackCertManagerPkgApisCertmanagerV1beta1CertificatePrivateKey;
    @JsonProperty("github_com_jetstack_cert-manager_pkg_apis_certmanager_v1beta1_CertificateRequest")
    private CertificateRequest githubComJetstackCertManagerPkgApisCertmanagerV1beta1CertificateRequest;
    @JsonProperty("github_com_jetstack_cert-manager_pkg_apis_certmanager_v1beta1_CertificateRequestCondition")
    private CertificateRequestCondition githubComJetstackCertManagerPkgApisCertmanagerV1beta1CertificateRequestCondition;
    @JsonProperty("github_com_jetstack_cert-manager_pkg_apis_certmanager_v1beta1_CertificateRequestList")
    private CertificateRequestList githubComJetstackCertManagerPkgApisCertmanagerV1beta1CertificateRequestList;
    @JsonProperty("github_com_jetstack_cert-manager_pkg_apis_certmanager_v1beta1_CertificateRequestSpec")
    private CertificateRequestSpec githubComJetstackCertManagerPkgApisCertmanagerV1beta1CertificateRequestSpec;
    @JsonProperty("github_com_jetstack_cert-manager_pkg_apis_certmanager_v1beta1_CertificateRequestStatus")
    private CertificateRequestStatus githubComJetstackCertManagerPkgApisCertmanagerV1beta1CertificateRequestStatus;
    @JsonProperty("github_com_jetstack_cert-manager_pkg_apis_certmanager_v1beta1_CertificateSpec")
    private CertificateSpec githubComJetstackCertManagerPkgApisCertmanagerV1beta1CertificateSpec;
    @JsonProperty("github_com_jetstack_cert-manager_pkg_apis_certmanager_v1beta1_CertificateStatus")
    private CertificateStatus githubComJetstackCertManagerPkgApisCertmanagerV1beta1CertificateStatus;
    @JsonProperty("github_com_jetstack_cert-manager_pkg_apis_certmanager_v1beta1_ClusterIssuer")
    private ClusterIssuer githubComJetstackCertManagerPkgApisCertmanagerV1beta1ClusterIssuer;
    @JsonProperty("github_com_jetstack_cert-manager_pkg_apis_certmanager_v1beta1_ClusterIssuerList")
    private ClusterIssuerList githubComJetstackCertManagerPkgApisCertmanagerV1beta1ClusterIssuerList;
    @JsonProperty("github_com_jetstack_cert-manager_pkg_apis_certmanager_v1beta1_Issuer")
    private Issuer githubComJetstackCertManagerPkgApisCertmanagerV1beta1Issuer;
    @JsonProperty("github_com_jetstack_cert-manager_pkg_apis_certmanager_v1beta1_IssuerCondition")
    private IssuerCondition githubComJetstackCertManagerPkgApisCertmanagerV1beta1IssuerCondition;
    @JsonProperty("github_com_jetstack_cert-manager_pkg_apis_certmanager_v1beta1_IssuerList")
    private IssuerList githubComJetstackCertManagerPkgApisCertmanagerV1beta1IssuerList;
    @JsonProperty("github_com_jetstack_cert-manager_pkg_apis_certmanager_v1beta1_IssuerSpec")
    private IssuerSpec githubComJetstackCertManagerPkgApisCertmanagerV1beta1IssuerSpec;
    @JsonProperty("github_com_jetstack_cert-manager_pkg_apis_certmanager_v1beta1_IssuerStatus")
    private IssuerStatus githubComJetstackCertManagerPkgApisCertmanagerV1beta1IssuerStatus;
    @JsonProperty("github_com_jetstack_cert-manager_pkg_apis_certmanager_v1beta1_JKSKeystore")
    private JKSKeystore githubComJetstackCertManagerPkgApisCertmanagerV1beta1JKSKeystore;
    @JsonProperty("github_com_jetstack_cert-manager_pkg_apis_certmanager_v1beta1_PKCS12Keystore")
    private PKCS12Keystore githubComJetstackCertManagerPkgApisCertmanagerV1beta1PKCS12Keystore;
    @JsonProperty("github_com_jetstack_cert-manager_pkg_apis_certmanager_v1beta1_SelfSignedIssuer")
    private SelfSignedIssuer githubComJetstackCertManagerPkgApisCertmanagerV1beta1SelfSignedIssuer;
    @JsonProperty("github_com_jetstack_cert-manager_pkg_apis_certmanager_v1beta1_VaultAppRole")
    private VaultAppRole githubComJetstackCertManagerPkgApisCertmanagerV1beta1VaultAppRole;
    @JsonProperty("github_com_jetstack_cert-manager_pkg_apis_certmanager_v1beta1_VaultAuth")
    private VaultAuth githubComJetstackCertManagerPkgApisCertmanagerV1beta1VaultAuth;
    @JsonProperty("github_com_jetstack_cert-manager_pkg_apis_certmanager_v1beta1_VaultIssuer")
    private VaultIssuer githubComJetstackCertManagerPkgApisCertmanagerV1beta1VaultIssuer;
    @JsonProperty("github_com_jetstack_cert-manager_pkg_apis_certmanager_v1beta1_VaultKubernetesAuth")
    private VaultKubernetesAuth githubComJetstackCertManagerPkgApisCertmanagerV1beta1VaultKubernetesAuth;
    @JsonProperty("github_com_jetstack_cert-manager_pkg_apis_certmanager_v1beta1_VenafiCloud")
    private VenafiCloud githubComJetstackCertManagerPkgApisCertmanagerV1beta1VenafiCloud;
    @JsonProperty("github_com_jetstack_cert-manager_pkg_apis_certmanager_v1beta1_VenafiIssuer")
    private VenafiIssuer githubComJetstackCertManagerPkgApisCertmanagerV1beta1VenafiIssuer;
    @JsonProperty("github_com_jetstack_cert-manager_pkg_apis_certmanager_v1beta1_VenafiTPP")
    private VenafiTPP githubComJetstackCertManagerPkgApisCertmanagerV1beta1VenafiTPP;
    @JsonProperty("github_com_jetstack_cert-manager_pkg_apis_certmanager_v1beta1_X509Subject")
    private X509Subject githubComJetstackCertManagerPkgApisCertmanagerV1beta1X509Subject;
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
     * @param githubComJetstackCertManagerPkgApisCertmanagerV1beta1IssuerCondition
     * @param githubComJetstackCertManagerPkgApisAcmeV1beta1ACMEExternalAccountBinding
     * @param githubComJetstackCertManagerPkgApisAcmeV1beta1ChallengeList
     * @param githubComJetstackCertManagerPkgApisAcmeV1beta1OrderList
     * @param githubComJetstackCertManagerPkgApisCertmanagerV1beta1ClusterIssuer
     * @param githubComJetstackCertManagerPkgApisCertmanagerV1beta1IssuerSpec
     * @param githubComJetstackCertManagerPkgApisAcmeV1beta1ACMEIssuerDNS01ProviderRFC2136
     * @param githubComJetstackCertManagerPkgApisCertmanagerV1beta1CertificateRequestStatus
     * @param githubComJetstackCertManagerPkgApisAcmeV1beta1ACMEChallengeSolverDNS01
     * @param githubComJetstackCertManagerPkgApisAcmeV1beta1ACMEChallengeSolverHTTP01IngressTemplate
     * @param githubComJetstackCertManagerPkgApisAcmeV1beta1ACMEIssuer
     * @param githubComJetstackCertManagerPkgApisAcmeV1beta1ACMEIssuerDNS01ProviderAcmeDNS
     * @param githubComJetstackCertManagerPkgApisAcmeV1beta1ACMEChallengeSolverHTTP01IngressPodSpec
     * @param githubComJetstackCertManagerPkgApisCertmanagerV1beta1SelfSignedIssuer
     * @param githubComJetstackCertManagerPkgApisCertmanagerV1beta1ClusterIssuerList
     * @param githubComJetstackCertManagerPkgApisCertmanagerV1beta1VaultAuth
     * @param githubComJetstackCertManagerPkgApisAcmeV1beta1Challenge
     * @param githubComJetstackCertManagerPkgApisCertmanagerV1beta1CertificateSpec
     * @param githubComJetstackCertManagerPkgApisAcmeV1beta1ACMEIssuerDNS01ProviderAkamai
     * @param githubComJetstackCertManagerPkgApisAcmeV1beta1ACMEIssuerDNS01ProviderAzureDNS
     * @param githubComJetstackCertManagerPkgApisAcmeV1beta1Order
     * @param githubComJetstackCertManagerPkgApisAcmeV1beta1ACMEChallenge
     * @param githubComJetstackCertManagerPkgApisAcmeV1beta1ACMEIssuerStatus
     * @param githubComJetstackCertManagerPkgApisAcmeV1beta1OrderSpec
     * @param githubComJetstackCertManagerPkgApisCertmanagerV1beta1CertificateStatus
     * @param githubComJetstackCertManagerPkgApisMetaV1ObjectReference
     * @param githubComJetstackCertManagerPkgApisCertmanagerV1beta1VaultAppRole
     * @param githubComJetstackCertManagerPkgApisCertmanagerV1beta1VenafiTPP
     * @param githubComJetstackCertManagerPkgApisAcmeV1beta1ChallengeSpec
     * @param githubComJetstackCertManagerPkgApisAcmeV1beta1ChallengeStatus
     * @param githubComJetstackCertManagerPkgApisCertmanagerV1beta1VenafiCloud
     * @param githubComJetstackCertManagerPkgApisCertmanagerV1beta1IssuerList
     * @param githubComJetstackCertManagerPkgApisCertmanagerV1beta1CertificatePrivateKey
     * @param githubComJetstackCertManagerPkgApisMetaV1SecretKeySelector
     * @param githubComJetstackCertManagerPkgApisAcmeV1beta1ACMEIssuerDNS01ProviderCloudflare
     * @param githubComJetstackCertManagerPkgApisAcmeV1beta1ACMEChallengeSolverHTTP01IngressObjectMeta
     * @param githubComJetstackCertManagerPkgApisAcmeV1beta1ACMEIssuerDNS01ProviderWebhook
     * @param githubComJetstackCertManagerPkgApisCertmanagerV1beta1JKSKeystore
     * @param githubComJetstackCertManagerPkgApisCertmanagerV1beta1VaultIssuer
     * @param githubComJetstackCertManagerPkgApisCertmanagerV1beta1CertificateRequestList
     * @param githubComJetstackCertManagerPkgApisCertmanagerV1beta1X509Subject
     * @param githubComJetstackCertManagerPkgApisAcmeV1beta1ACMEChallengeSolverHTTP01IngressPodTemplate
     * @param githubComJetstackCertManagerPkgApisCertmanagerV1beta1PKCS12Keystore
     * @param githubComJetstackCertManagerPkgApisCertmanagerV1beta1IssuerStatus
     * @param githubComJetstackCertManagerPkgApisAcmeV1beta1ACMEIssuerDNS01ProviderDigitalOcean
     * @param githubComJetstackCertManagerPkgApisCertmanagerV1beta1CertificateKeystores
     * @param githubComJetstackCertManagerPkgApisAcmeV1beta1CertificateDNSNameSelector
     * @param githubComJetstackCertManagerPkgApisAcmeV1beta1ACMEAuthorization
     * @param githubComJetstackCertManagerPkgApisAcmeV1beta1ACMEChallengeSolverHTTP01IngressPodObjectMeta
     * @param githubComJetstackCertManagerPkgApisAcmeV1beta1ACMEIssuerDNS01ProviderCloudDNS
     * @param githubComJetstackCertManagerPkgApisCertmanagerV1beta1CertificateRequest
     * @param githubComJetstackCertManagerPkgApisAcmeV1beta1OrderStatus
     * @param githubComJetstackCertManagerPkgApisAcmeV1beta1ACMEChallengeSolver
     * @param githubComJetstackCertManagerPkgApisCertmanagerV1beta1CertificateCondition
     * @param githubComJetstackCertManagerPkgApisCertmanagerV1beta1VaultKubernetesAuth
     * @param githubComJetstackCertManagerPkgApisCertmanagerV1beta1CertificateRequestSpec
     * @param githubComJetstackCertManagerPkgApisMetaV1LocalObjectReference
     * @param githubComJetstackCertManagerPkgApisCertmanagerV1beta1VenafiIssuer
     * @param githubComJetstackCertManagerPkgApisAcmeV1beta1ACMEChallengeSolverHTTP01
     * @param githubComJetstackCertManagerPkgApisAcmeV1beta1ACMEChallengeSolverHTTP01Ingress
     * @param githubComJetstackCertManagerPkgApisAcmeV1beta1ACMEIssuerDNS01ProviderRoute53
     * @param githubComJetstackCertManagerPkgApisCertmanagerV1beta1Issuer
     * @param githubComJetstackCertManagerPkgApisCertmanagerV1beta1CAIssuer
     * @param githubComJetstackCertManagerPkgApisCertmanagerV1beta1CertificateRequestCondition
     * @param githubComJetstackCertManagerPkgApisCertmanagerV1beta1Certificate
     * @param githubComJetstackCertManagerPkgApisCertmanagerV1beta1CertificateList
     */
    public CertmanagerSchema(ACMEAuthorization githubComJetstackCertManagerPkgApisAcmeV1beta1ACMEAuthorization, ACMEChallenge githubComJetstackCertManagerPkgApisAcmeV1beta1ACMEChallenge, ACMEChallengeSolver githubComJetstackCertManagerPkgApisAcmeV1beta1ACMEChallengeSolver, ACMEChallengeSolverDNS01 githubComJetstackCertManagerPkgApisAcmeV1beta1ACMEChallengeSolverDNS01, ACMEChallengeSolverHTTP01 githubComJetstackCertManagerPkgApisAcmeV1beta1ACMEChallengeSolverHTTP01, ACMEChallengeSolverHTTP01Ingress githubComJetstackCertManagerPkgApisAcmeV1beta1ACMEChallengeSolverHTTP01Ingress, ACMEChallengeSolverHTTP01IngressObjectMeta githubComJetstackCertManagerPkgApisAcmeV1beta1ACMEChallengeSolverHTTP01IngressObjectMeta, ACMEChallengeSolverHTTP01IngressPodObjectMeta githubComJetstackCertManagerPkgApisAcmeV1beta1ACMEChallengeSolverHTTP01IngressPodObjectMeta, ACMEChallengeSolverHTTP01IngressPodSpec githubComJetstackCertManagerPkgApisAcmeV1beta1ACMEChallengeSolverHTTP01IngressPodSpec, ACMEChallengeSolverHTTP01IngressPodTemplate githubComJetstackCertManagerPkgApisAcmeV1beta1ACMEChallengeSolverHTTP01IngressPodTemplate, ACMEChallengeSolverHTTP01IngressTemplate githubComJetstackCertManagerPkgApisAcmeV1beta1ACMEChallengeSolverHTTP01IngressTemplate, ACMEExternalAccountBinding githubComJetstackCertManagerPkgApisAcmeV1beta1ACMEExternalAccountBinding, ACMEIssuer githubComJetstackCertManagerPkgApisAcmeV1beta1ACMEIssuer, ACMEIssuerDNS01ProviderAcmeDNS githubComJetstackCertManagerPkgApisAcmeV1beta1ACMEIssuerDNS01ProviderAcmeDNS, ACMEIssuerDNS01ProviderAkamai githubComJetstackCertManagerPkgApisAcmeV1beta1ACMEIssuerDNS01ProviderAkamai, ACMEIssuerDNS01ProviderAzureDNS githubComJetstackCertManagerPkgApisAcmeV1beta1ACMEIssuerDNS01ProviderAzureDNS, ACMEIssuerDNS01ProviderCloudDNS githubComJetstackCertManagerPkgApisAcmeV1beta1ACMEIssuerDNS01ProviderCloudDNS, ACMEIssuerDNS01ProviderCloudflare githubComJetstackCertManagerPkgApisAcmeV1beta1ACMEIssuerDNS01ProviderCloudflare, ACMEIssuerDNS01ProviderDigitalOcean githubComJetstackCertManagerPkgApisAcmeV1beta1ACMEIssuerDNS01ProviderDigitalOcean, ACMEIssuerDNS01ProviderRFC2136 githubComJetstackCertManagerPkgApisAcmeV1beta1ACMEIssuerDNS01ProviderRFC2136, ACMEIssuerDNS01ProviderRoute53 githubComJetstackCertManagerPkgApisAcmeV1beta1ACMEIssuerDNS01ProviderRoute53, ACMEIssuerDNS01ProviderWebhook githubComJetstackCertManagerPkgApisAcmeV1beta1ACMEIssuerDNS01ProviderWebhook, ACMEIssuerStatus githubComJetstackCertManagerPkgApisAcmeV1beta1ACMEIssuerStatus, CertificateDNSNameSelector githubComJetstackCertManagerPkgApisAcmeV1beta1CertificateDNSNameSelector, Challenge githubComJetstackCertManagerPkgApisAcmeV1beta1Challenge, ChallengeList githubComJetstackCertManagerPkgApisAcmeV1beta1ChallengeList, ChallengeSpec githubComJetstackCertManagerPkgApisAcmeV1beta1ChallengeSpec, ChallengeStatus githubComJetstackCertManagerPkgApisAcmeV1beta1ChallengeStatus, Order githubComJetstackCertManagerPkgApisAcmeV1beta1Order, OrderList githubComJetstackCertManagerPkgApisAcmeV1beta1OrderList, OrderSpec githubComJetstackCertManagerPkgApisAcmeV1beta1OrderSpec, OrderStatus githubComJetstackCertManagerPkgApisAcmeV1beta1OrderStatus, CAIssuer githubComJetstackCertManagerPkgApisCertmanagerV1beta1CAIssuer, Certificate githubComJetstackCertManagerPkgApisCertmanagerV1beta1Certificate, CertificateCondition githubComJetstackCertManagerPkgApisCertmanagerV1beta1CertificateCondition, CertificateKeystores githubComJetstackCertManagerPkgApisCertmanagerV1beta1CertificateKeystores, CertificateList githubComJetstackCertManagerPkgApisCertmanagerV1beta1CertificateList, CertificatePrivateKey githubComJetstackCertManagerPkgApisCertmanagerV1beta1CertificatePrivateKey, CertificateRequest githubComJetstackCertManagerPkgApisCertmanagerV1beta1CertificateRequest, CertificateRequestCondition githubComJetstackCertManagerPkgApisCertmanagerV1beta1CertificateRequestCondition, CertificateRequestList githubComJetstackCertManagerPkgApisCertmanagerV1beta1CertificateRequestList, CertificateRequestSpec githubComJetstackCertManagerPkgApisCertmanagerV1beta1CertificateRequestSpec, CertificateRequestStatus githubComJetstackCertManagerPkgApisCertmanagerV1beta1CertificateRequestStatus, CertificateSpec githubComJetstackCertManagerPkgApisCertmanagerV1beta1CertificateSpec, CertificateStatus githubComJetstackCertManagerPkgApisCertmanagerV1beta1CertificateStatus, ClusterIssuer githubComJetstackCertManagerPkgApisCertmanagerV1beta1ClusterIssuer, ClusterIssuerList githubComJetstackCertManagerPkgApisCertmanagerV1beta1ClusterIssuerList, Issuer githubComJetstackCertManagerPkgApisCertmanagerV1beta1Issuer, IssuerCondition githubComJetstackCertManagerPkgApisCertmanagerV1beta1IssuerCondition, IssuerList githubComJetstackCertManagerPkgApisCertmanagerV1beta1IssuerList, IssuerSpec githubComJetstackCertManagerPkgApisCertmanagerV1beta1IssuerSpec, IssuerStatus githubComJetstackCertManagerPkgApisCertmanagerV1beta1IssuerStatus, JKSKeystore githubComJetstackCertManagerPkgApisCertmanagerV1beta1JKSKeystore, PKCS12Keystore githubComJetstackCertManagerPkgApisCertmanagerV1beta1PKCS12Keystore, SelfSignedIssuer githubComJetstackCertManagerPkgApisCertmanagerV1beta1SelfSignedIssuer, VaultAppRole githubComJetstackCertManagerPkgApisCertmanagerV1beta1VaultAppRole, VaultAuth githubComJetstackCertManagerPkgApisCertmanagerV1beta1VaultAuth, VaultIssuer githubComJetstackCertManagerPkgApisCertmanagerV1beta1VaultIssuer, VaultKubernetesAuth githubComJetstackCertManagerPkgApisCertmanagerV1beta1VaultKubernetesAuth, VenafiCloud githubComJetstackCertManagerPkgApisCertmanagerV1beta1VenafiCloud, VenafiIssuer githubComJetstackCertManagerPkgApisCertmanagerV1beta1VenafiIssuer, VenafiTPP githubComJetstackCertManagerPkgApisCertmanagerV1beta1VenafiTPP, X509Subject githubComJetstackCertManagerPkgApisCertmanagerV1beta1X509Subject, io.fabric8.certmanager.api.model.meta.v1.LocalObjectReference githubComJetstackCertManagerPkgApisMetaV1LocalObjectReference, io.fabric8.certmanager.api.model.meta.v1.ObjectReference githubComJetstackCertManagerPkgApisMetaV1ObjectReference, SecretKeySelector githubComJetstackCertManagerPkgApisMetaV1SecretKeySelector) {
        super();
        this.githubComJetstackCertManagerPkgApisAcmeV1beta1ACMEAuthorization = githubComJetstackCertManagerPkgApisAcmeV1beta1ACMEAuthorization;
        this.githubComJetstackCertManagerPkgApisAcmeV1beta1ACMEChallenge = githubComJetstackCertManagerPkgApisAcmeV1beta1ACMEChallenge;
        this.githubComJetstackCertManagerPkgApisAcmeV1beta1ACMEChallengeSolver = githubComJetstackCertManagerPkgApisAcmeV1beta1ACMEChallengeSolver;
        this.githubComJetstackCertManagerPkgApisAcmeV1beta1ACMEChallengeSolverDNS01 = githubComJetstackCertManagerPkgApisAcmeV1beta1ACMEChallengeSolverDNS01;
        this.githubComJetstackCertManagerPkgApisAcmeV1beta1ACMEChallengeSolverHTTP01 = githubComJetstackCertManagerPkgApisAcmeV1beta1ACMEChallengeSolverHTTP01;
        this.githubComJetstackCertManagerPkgApisAcmeV1beta1ACMEChallengeSolverHTTP01Ingress = githubComJetstackCertManagerPkgApisAcmeV1beta1ACMEChallengeSolverHTTP01Ingress;
        this.githubComJetstackCertManagerPkgApisAcmeV1beta1ACMEChallengeSolverHTTP01IngressObjectMeta = githubComJetstackCertManagerPkgApisAcmeV1beta1ACMEChallengeSolverHTTP01IngressObjectMeta;
        this.githubComJetstackCertManagerPkgApisAcmeV1beta1ACMEChallengeSolverHTTP01IngressPodObjectMeta = githubComJetstackCertManagerPkgApisAcmeV1beta1ACMEChallengeSolverHTTP01IngressPodObjectMeta;
        this.githubComJetstackCertManagerPkgApisAcmeV1beta1ACMEChallengeSolverHTTP01IngressPodSpec = githubComJetstackCertManagerPkgApisAcmeV1beta1ACMEChallengeSolverHTTP01IngressPodSpec;
        this.githubComJetstackCertManagerPkgApisAcmeV1beta1ACMEChallengeSolverHTTP01IngressPodTemplate = githubComJetstackCertManagerPkgApisAcmeV1beta1ACMEChallengeSolverHTTP01IngressPodTemplate;
        this.githubComJetstackCertManagerPkgApisAcmeV1beta1ACMEChallengeSolverHTTP01IngressTemplate = githubComJetstackCertManagerPkgApisAcmeV1beta1ACMEChallengeSolverHTTP01IngressTemplate;
        this.githubComJetstackCertManagerPkgApisAcmeV1beta1ACMEExternalAccountBinding = githubComJetstackCertManagerPkgApisAcmeV1beta1ACMEExternalAccountBinding;
        this.githubComJetstackCertManagerPkgApisAcmeV1beta1ACMEIssuer = githubComJetstackCertManagerPkgApisAcmeV1beta1ACMEIssuer;
        this.githubComJetstackCertManagerPkgApisAcmeV1beta1ACMEIssuerDNS01ProviderAcmeDNS = githubComJetstackCertManagerPkgApisAcmeV1beta1ACMEIssuerDNS01ProviderAcmeDNS;
        this.githubComJetstackCertManagerPkgApisAcmeV1beta1ACMEIssuerDNS01ProviderAkamai = githubComJetstackCertManagerPkgApisAcmeV1beta1ACMEIssuerDNS01ProviderAkamai;
        this.githubComJetstackCertManagerPkgApisAcmeV1beta1ACMEIssuerDNS01ProviderAzureDNS = githubComJetstackCertManagerPkgApisAcmeV1beta1ACMEIssuerDNS01ProviderAzureDNS;
        this.githubComJetstackCertManagerPkgApisAcmeV1beta1ACMEIssuerDNS01ProviderCloudDNS = githubComJetstackCertManagerPkgApisAcmeV1beta1ACMEIssuerDNS01ProviderCloudDNS;
        this.githubComJetstackCertManagerPkgApisAcmeV1beta1ACMEIssuerDNS01ProviderCloudflare = githubComJetstackCertManagerPkgApisAcmeV1beta1ACMEIssuerDNS01ProviderCloudflare;
        this.githubComJetstackCertManagerPkgApisAcmeV1beta1ACMEIssuerDNS01ProviderDigitalOcean = githubComJetstackCertManagerPkgApisAcmeV1beta1ACMEIssuerDNS01ProviderDigitalOcean;
        this.githubComJetstackCertManagerPkgApisAcmeV1beta1ACMEIssuerDNS01ProviderRFC2136 = githubComJetstackCertManagerPkgApisAcmeV1beta1ACMEIssuerDNS01ProviderRFC2136;
        this.githubComJetstackCertManagerPkgApisAcmeV1beta1ACMEIssuerDNS01ProviderRoute53 = githubComJetstackCertManagerPkgApisAcmeV1beta1ACMEIssuerDNS01ProviderRoute53;
        this.githubComJetstackCertManagerPkgApisAcmeV1beta1ACMEIssuerDNS01ProviderWebhook = githubComJetstackCertManagerPkgApisAcmeV1beta1ACMEIssuerDNS01ProviderWebhook;
        this.githubComJetstackCertManagerPkgApisAcmeV1beta1ACMEIssuerStatus = githubComJetstackCertManagerPkgApisAcmeV1beta1ACMEIssuerStatus;
        this.githubComJetstackCertManagerPkgApisAcmeV1beta1CertificateDNSNameSelector = githubComJetstackCertManagerPkgApisAcmeV1beta1CertificateDNSNameSelector;
        this.githubComJetstackCertManagerPkgApisAcmeV1beta1Challenge = githubComJetstackCertManagerPkgApisAcmeV1beta1Challenge;
        this.githubComJetstackCertManagerPkgApisAcmeV1beta1ChallengeList = githubComJetstackCertManagerPkgApisAcmeV1beta1ChallengeList;
        this.githubComJetstackCertManagerPkgApisAcmeV1beta1ChallengeSpec = githubComJetstackCertManagerPkgApisAcmeV1beta1ChallengeSpec;
        this.githubComJetstackCertManagerPkgApisAcmeV1beta1ChallengeStatus = githubComJetstackCertManagerPkgApisAcmeV1beta1ChallengeStatus;
        this.githubComJetstackCertManagerPkgApisAcmeV1beta1Order = githubComJetstackCertManagerPkgApisAcmeV1beta1Order;
        this.githubComJetstackCertManagerPkgApisAcmeV1beta1OrderList = githubComJetstackCertManagerPkgApisAcmeV1beta1OrderList;
        this.githubComJetstackCertManagerPkgApisAcmeV1beta1OrderSpec = githubComJetstackCertManagerPkgApisAcmeV1beta1OrderSpec;
        this.githubComJetstackCertManagerPkgApisAcmeV1beta1OrderStatus = githubComJetstackCertManagerPkgApisAcmeV1beta1OrderStatus;
        this.githubComJetstackCertManagerPkgApisCertmanagerV1beta1CAIssuer = githubComJetstackCertManagerPkgApisCertmanagerV1beta1CAIssuer;
        this.githubComJetstackCertManagerPkgApisCertmanagerV1beta1Certificate = githubComJetstackCertManagerPkgApisCertmanagerV1beta1Certificate;
        this.githubComJetstackCertManagerPkgApisCertmanagerV1beta1CertificateCondition = githubComJetstackCertManagerPkgApisCertmanagerV1beta1CertificateCondition;
        this.githubComJetstackCertManagerPkgApisCertmanagerV1beta1CertificateKeystores = githubComJetstackCertManagerPkgApisCertmanagerV1beta1CertificateKeystores;
        this.githubComJetstackCertManagerPkgApisCertmanagerV1beta1CertificateList = githubComJetstackCertManagerPkgApisCertmanagerV1beta1CertificateList;
        this.githubComJetstackCertManagerPkgApisCertmanagerV1beta1CertificatePrivateKey = githubComJetstackCertManagerPkgApisCertmanagerV1beta1CertificatePrivateKey;
        this.githubComJetstackCertManagerPkgApisCertmanagerV1beta1CertificateRequest = githubComJetstackCertManagerPkgApisCertmanagerV1beta1CertificateRequest;
        this.githubComJetstackCertManagerPkgApisCertmanagerV1beta1CertificateRequestCondition = githubComJetstackCertManagerPkgApisCertmanagerV1beta1CertificateRequestCondition;
        this.githubComJetstackCertManagerPkgApisCertmanagerV1beta1CertificateRequestList = githubComJetstackCertManagerPkgApisCertmanagerV1beta1CertificateRequestList;
        this.githubComJetstackCertManagerPkgApisCertmanagerV1beta1CertificateRequestSpec = githubComJetstackCertManagerPkgApisCertmanagerV1beta1CertificateRequestSpec;
        this.githubComJetstackCertManagerPkgApisCertmanagerV1beta1CertificateRequestStatus = githubComJetstackCertManagerPkgApisCertmanagerV1beta1CertificateRequestStatus;
        this.githubComJetstackCertManagerPkgApisCertmanagerV1beta1CertificateSpec = githubComJetstackCertManagerPkgApisCertmanagerV1beta1CertificateSpec;
        this.githubComJetstackCertManagerPkgApisCertmanagerV1beta1CertificateStatus = githubComJetstackCertManagerPkgApisCertmanagerV1beta1CertificateStatus;
        this.githubComJetstackCertManagerPkgApisCertmanagerV1beta1ClusterIssuer = githubComJetstackCertManagerPkgApisCertmanagerV1beta1ClusterIssuer;
        this.githubComJetstackCertManagerPkgApisCertmanagerV1beta1ClusterIssuerList = githubComJetstackCertManagerPkgApisCertmanagerV1beta1ClusterIssuerList;
        this.githubComJetstackCertManagerPkgApisCertmanagerV1beta1Issuer = githubComJetstackCertManagerPkgApisCertmanagerV1beta1Issuer;
        this.githubComJetstackCertManagerPkgApisCertmanagerV1beta1IssuerCondition = githubComJetstackCertManagerPkgApisCertmanagerV1beta1IssuerCondition;
        this.githubComJetstackCertManagerPkgApisCertmanagerV1beta1IssuerList = githubComJetstackCertManagerPkgApisCertmanagerV1beta1IssuerList;
        this.githubComJetstackCertManagerPkgApisCertmanagerV1beta1IssuerSpec = githubComJetstackCertManagerPkgApisCertmanagerV1beta1IssuerSpec;
        this.githubComJetstackCertManagerPkgApisCertmanagerV1beta1IssuerStatus = githubComJetstackCertManagerPkgApisCertmanagerV1beta1IssuerStatus;
        this.githubComJetstackCertManagerPkgApisCertmanagerV1beta1JKSKeystore = githubComJetstackCertManagerPkgApisCertmanagerV1beta1JKSKeystore;
        this.githubComJetstackCertManagerPkgApisCertmanagerV1beta1PKCS12Keystore = githubComJetstackCertManagerPkgApisCertmanagerV1beta1PKCS12Keystore;
        this.githubComJetstackCertManagerPkgApisCertmanagerV1beta1SelfSignedIssuer = githubComJetstackCertManagerPkgApisCertmanagerV1beta1SelfSignedIssuer;
        this.githubComJetstackCertManagerPkgApisCertmanagerV1beta1VaultAppRole = githubComJetstackCertManagerPkgApisCertmanagerV1beta1VaultAppRole;
        this.githubComJetstackCertManagerPkgApisCertmanagerV1beta1VaultAuth = githubComJetstackCertManagerPkgApisCertmanagerV1beta1VaultAuth;
        this.githubComJetstackCertManagerPkgApisCertmanagerV1beta1VaultIssuer = githubComJetstackCertManagerPkgApisCertmanagerV1beta1VaultIssuer;
        this.githubComJetstackCertManagerPkgApisCertmanagerV1beta1VaultKubernetesAuth = githubComJetstackCertManagerPkgApisCertmanagerV1beta1VaultKubernetesAuth;
        this.githubComJetstackCertManagerPkgApisCertmanagerV1beta1VenafiCloud = githubComJetstackCertManagerPkgApisCertmanagerV1beta1VenafiCloud;
        this.githubComJetstackCertManagerPkgApisCertmanagerV1beta1VenafiIssuer = githubComJetstackCertManagerPkgApisCertmanagerV1beta1VenafiIssuer;
        this.githubComJetstackCertManagerPkgApisCertmanagerV1beta1VenafiTPP = githubComJetstackCertManagerPkgApisCertmanagerV1beta1VenafiTPP;
        this.githubComJetstackCertManagerPkgApisCertmanagerV1beta1X509Subject = githubComJetstackCertManagerPkgApisCertmanagerV1beta1X509Subject;
        this.githubComJetstackCertManagerPkgApisMetaV1LocalObjectReference = githubComJetstackCertManagerPkgApisMetaV1LocalObjectReference;
        this.githubComJetstackCertManagerPkgApisMetaV1ObjectReference = githubComJetstackCertManagerPkgApisMetaV1ObjectReference;
        this.githubComJetstackCertManagerPkgApisMetaV1SecretKeySelector = githubComJetstackCertManagerPkgApisMetaV1SecretKeySelector;
    }

    @JsonProperty("github_com_jetstack_cert-manager_pkg_apis_acme_v1beta1_ACMEAuthorization")
    public ACMEAuthorization getGithubComJetstackCertManagerPkgApisAcmeV1beta1ACMEAuthorization() {
        return githubComJetstackCertManagerPkgApisAcmeV1beta1ACMEAuthorization;
    }

    @JsonProperty("github_com_jetstack_cert-manager_pkg_apis_acme_v1beta1_ACMEAuthorization")
    public void setGithubComJetstackCertManagerPkgApisAcmeV1beta1ACMEAuthorization(ACMEAuthorization githubComJetstackCertManagerPkgApisAcmeV1beta1ACMEAuthorization) {
        this.githubComJetstackCertManagerPkgApisAcmeV1beta1ACMEAuthorization = githubComJetstackCertManagerPkgApisAcmeV1beta1ACMEAuthorization;
    }

    @JsonProperty("github_com_jetstack_cert-manager_pkg_apis_acme_v1beta1_ACMEChallenge")
    public ACMEChallenge getGithubComJetstackCertManagerPkgApisAcmeV1beta1ACMEChallenge() {
        return githubComJetstackCertManagerPkgApisAcmeV1beta1ACMEChallenge;
    }

    @JsonProperty("github_com_jetstack_cert-manager_pkg_apis_acme_v1beta1_ACMEChallenge")
    public void setGithubComJetstackCertManagerPkgApisAcmeV1beta1ACMEChallenge(ACMEChallenge githubComJetstackCertManagerPkgApisAcmeV1beta1ACMEChallenge) {
        this.githubComJetstackCertManagerPkgApisAcmeV1beta1ACMEChallenge = githubComJetstackCertManagerPkgApisAcmeV1beta1ACMEChallenge;
    }

    @JsonProperty("github_com_jetstack_cert-manager_pkg_apis_acme_v1beta1_ACMEChallengeSolver")
    public ACMEChallengeSolver getGithubComJetstackCertManagerPkgApisAcmeV1beta1ACMEChallengeSolver() {
        return githubComJetstackCertManagerPkgApisAcmeV1beta1ACMEChallengeSolver;
    }

    @JsonProperty("github_com_jetstack_cert-manager_pkg_apis_acme_v1beta1_ACMEChallengeSolver")
    public void setGithubComJetstackCertManagerPkgApisAcmeV1beta1ACMEChallengeSolver(ACMEChallengeSolver githubComJetstackCertManagerPkgApisAcmeV1beta1ACMEChallengeSolver) {
        this.githubComJetstackCertManagerPkgApisAcmeV1beta1ACMEChallengeSolver = githubComJetstackCertManagerPkgApisAcmeV1beta1ACMEChallengeSolver;
    }

    @JsonProperty("github_com_jetstack_cert-manager_pkg_apis_acme_v1beta1_ACMEChallengeSolverDNS01")
    public ACMEChallengeSolverDNS01 getGithubComJetstackCertManagerPkgApisAcmeV1beta1ACMEChallengeSolverDNS01() {
        return githubComJetstackCertManagerPkgApisAcmeV1beta1ACMEChallengeSolverDNS01;
    }

    @JsonProperty("github_com_jetstack_cert-manager_pkg_apis_acme_v1beta1_ACMEChallengeSolverDNS01")
    public void setGithubComJetstackCertManagerPkgApisAcmeV1beta1ACMEChallengeSolverDNS01(ACMEChallengeSolverDNS01 githubComJetstackCertManagerPkgApisAcmeV1beta1ACMEChallengeSolverDNS01) {
        this.githubComJetstackCertManagerPkgApisAcmeV1beta1ACMEChallengeSolverDNS01 = githubComJetstackCertManagerPkgApisAcmeV1beta1ACMEChallengeSolverDNS01;
    }

    @JsonProperty("github_com_jetstack_cert-manager_pkg_apis_acme_v1beta1_ACMEChallengeSolverHTTP01")
    public ACMEChallengeSolverHTTP01 getGithubComJetstackCertManagerPkgApisAcmeV1beta1ACMEChallengeSolverHTTP01() {
        return githubComJetstackCertManagerPkgApisAcmeV1beta1ACMEChallengeSolverHTTP01;
    }

    @JsonProperty("github_com_jetstack_cert-manager_pkg_apis_acme_v1beta1_ACMEChallengeSolverHTTP01")
    public void setGithubComJetstackCertManagerPkgApisAcmeV1beta1ACMEChallengeSolverHTTP01(ACMEChallengeSolverHTTP01 githubComJetstackCertManagerPkgApisAcmeV1beta1ACMEChallengeSolverHTTP01) {
        this.githubComJetstackCertManagerPkgApisAcmeV1beta1ACMEChallengeSolverHTTP01 = githubComJetstackCertManagerPkgApisAcmeV1beta1ACMEChallengeSolverHTTP01;
    }

    @JsonProperty("github_com_jetstack_cert-manager_pkg_apis_acme_v1beta1_ACMEChallengeSolverHTTP01Ingress")
    public ACMEChallengeSolverHTTP01Ingress getGithubComJetstackCertManagerPkgApisAcmeV1beta1ACMEChallengeSolverHTTP01Ingress() {
        return githubComJetstackCertManagerPkgApisAcmeV1beta1ACMEChallengeSolverHTTP01Ingress;
    }

    @JsonProperty("github_com_jetstack_cert-manager_pkg_apis_acme_v1beta1_ACMEChallengeSolverHTTP01Ingress")
    public void setGithubComJetstackCertManagerPkgApisAcmeV1beta1ACMEChallengeSolverHTTP01Ingress(ACMEChallengeSolverHTTP01Ingress githubComJetstackCertManagerPkgApisAcmeV1beta1ACMEChallengeSolverHTTP01Ingress) {
        this.githubComJetstackCertManagerPkgApisAcmeV1beta1ACMEChallengeSolverHTTP01Ingress = githubComJetstackCertManagerPkgApisAcmeV1beta1ACMEChallengeSolverHTTP01Ingress;
    }

    @JsonProperty("github_com_jetstack_cert-manager_pkg_apis_acme_v1beta1_ACMEChallengeSolverHTTP01IngressObjectMeta")
    public ACMEChallengeSolverHTTP01IngressObjectMeta getGithubComJetstackCertManagerPkgApisAcmeV1beta1ACMEChallengeSolverHTTP01IngressObjectMeta() {
        return githubComJetstackCertManagerPkgApisAcmeV1beta1ACMEChallengeSolverHTTP01IngressObjectMeta;
    }

    @JsonProperty("github_com_jetstack_cert-manager_pkg_apis_acme_v1beta1_ACMEChallengeSolverHTTP01IngressObjectMeta")
    public void setGithubComJetstackCertManagerPkgApisAcmeV1beta1ACMEChallengeSolverHTTP01IngressObjectMeta(ACMEChallengeSolverHTTP01IngressObjectMeta githubComJetstackCertManagerPkgApisAcmeV1beta1ACMEChallengeSolverHTTP01IngressObjectMeta) {
        this.githubComJetstackCertManagerPkgApisAcmeV1beta1ACMEChallengeSolverHTTP01IngressObjectMeta = githubComJetstackCertManagerPkgApisAcmeV1beta1ACMEChallengeSolverHTTP01IngressObjectMeta;
    }

    @JsonProperty("github_com_jetstack_cert-manager_pkg_apis_acme_v1beta1_ACMEChallengeSolverHTTP01IngressPodObjectMeta")
    public ACMEChallengeSolverHTTP01IngressPodObjectMeta getGithubComJetstackCertManagerPkgApisAcmeV1beta1ACMEChallengeSolverHTTP01IngressPodObjectMeta() {
        return githubComJetstackCertManagerPkgApisAcmeV1beta1ACMEChallengeSolverHTTP01IngressPodObjectMeta;
    }

    @JsonProperty("github_com_jetstack_cert-manager_pkg_apis_acme_v1beta1_ACMEChallengeSolverHTTP01IngressPodObjectMeta")
    public void setGithubComJetstackCertManagerPkgApisAcmeV1beta1ACMEChallengeSolverHTTP01IngressPodObjectMeta(ACMEChallengeSolverHTTP01IngressPodObjectMeta githubComJetstackCertManagerPkgApisAcmeV1beta1ACMEChallengeSolverHTTP01IngressPodObjectMeta) {
        this.githubComJetstackCertManagerPkgApisAcmeV1beta1ACMEChallengeSolverHTTP01IngressPodObjectMeta = githubComJetstackCertManagerPkgApisAcmeV1beta1ACMEChallengeSolverHTTP01IngressPodObjectMeta;
    }

    @JsonProperty("github_com_jetstack_cert-manager_pkg_apis_acme_v1beta1_ACMEChallengeSolverHTTP01IngressPodSpec")
    public ACMEChallengeSolverHTTP01IngressPodSpec getGithubComJetstackCertManagerPkgApisAcmeV1beta1ACMEChallengeSolverHTTP01IngressPodSpec() {
        return githubComJetstackCertManagerPkgApisAcmeV1beta1ACMEChallengeSolverHTTP01IngressPodSpec;
    }

    @JsonProperty("github_com_jetstack_cert-manager_pkg_apis_acme_v1beta1_ACMEChallengeSolverHTTP01IngressPodSpec")
    public void setGithubComJetstackCertManagerPkgApisAcmeV1beta1ACMEChallengeSolverHTTP01IngressPodSpec(ACMEChallengeSolverHTTP01IngressPodSpec githubComJetstackCertManagerPkgApisAcmeV1beta1ACMEChallengeSolverHTTP01IngressPodSpec) {
        this.githubComJetstackCertManagerPkgApisAcmeV1beta1ACMEChallengeSolverHTTP01IngressPodSpec = githubComJetstackCertManagerPkgApisAcmeV1beta1ACMEChallengeSolverHTTP01IngressPodSpec;
    }

    @JsonProperty("github_com_jetstack_cert-manager_pkg_apis_acme_v1beta1_ACMEChallengeSolverHTTP01IngressPodTemplate")
    public ACMEChallengeSolverHTTP01IngressPodTemplate getGithubComJetstackCertManagerPkgApisAcmeV1beta1ACMEChallengeSolverHTTP01IngressPodTemplate() {
        return githubComJetstackCertManagerPkgApisAcmeV1beta1ACMEChallengeSolverHTTP01IngressPodTemplate;
    }

    @JsonProperty("github_com_jetstack_cert-manager_pkg_apis_acme_v1beta1_ACMEChallengeSolverHTTP01IngressPodTemplate")
    public void setGithubComJetstackCertManagerPkgApisAcmeV1beta1ACMEChallengeSolverHTTP01IngressPodTemplate(ACMEChallengeSolverHTTP01IngressPodTemplate githubComJetstackCertManagerPkgApisAcmeV1beta1ACMEChallengeSolverHTTP01IngressPodTemplate) {
        this.githubComJetstackCertManagerPkgApisAcmeV1beta1ACMEChallengeSolverHTTP01IngressPodTemplate = githubComJetstackCertManagerPkgApisAcmeV1beta1ACMEChallengeSolverHTTP01IngressPodTemplate;
    }

    @JsonProperty("github_com_jetstack_cert-manager_pkg_apis_acme_v1beta1_ACMEChallengeSolverHTTP01IngressTemplate")
    public ACMEChallengeSolverHTTP01IngressTemplate getGithubComJetstackCertManagerPkgApisAcmeV1beta1ACMEChallengeSolverHTTP01IngressTemplate() {
        return githubComJetstackCertManagerPkgApisAcmeV1beta1ACMEChallengeSolverHTTP01IngressTemplate;
    }

    @JsonProperty("github_com_jetstack_cert-manager_pkg_apis_acme_v1beta1_ACMEChallengeSolverHTTP01IngressTemplate")
    public void setGithubComJetstackCertManagerPkgApisAcmeV1beta1ACMEChallengeSolverHTTP01IngressTemplate(ACMEChallengeSolverHTTP01IngressTemplate githubComJetstackCertManagerPkgApisAcmeV1beta1ACMEChallengeSolverHTTP01IngressTemplate) {
        this.githubComJetstackCertManagerPkgApisAcmeV1beta1ACMEChallengeSolverHTTP01IngressTemplate = githubComJetstackCertManagerPkgApisAcmeV1beta1ACMEChallengeSolverHTTP01IngressTemplate;
    }

    @JsonProperty("github_com_jetstack_cert-manager_pkg_apis_acme_v1beta1_ACMEExternalAccountBinding")
    public ACMEExternalAccountBinding getGithubComJetstackCertManagerPkgApisAcmeV1beta1ACMEExternalAccountBinding() {
        return githubComJetstackCertManagerPkgApisAcmeV1beta1ACMEExternalAccountBinding;
    }

    @JsonProperty("github_com_jetstack_cert-manager_pkg_apis_acme_v1beta1_ACMEExternalAccountBinding")
    public void setGithubComJetstackCertManagerPkgApisAcmeV1beta1ACMEExternalAccountBinding(ACMEExternalAccountBinding githubComJetstackCertManagerPkgApisAcmeV1beta1ACMEExternalAccountBinding) {
        this.githubComJetstackCertManagerPkgApisAcmeV1beta1ACMEExternalAccountBinding = githubComJetstackCertManagerPkgApisAcmeV1beta1ACMEExternalAccountBinding;
    }

    @JsonProperty("github_com_jetstack_cert-manager_pkg_apis_acme_v1beta1_ACMEIssuer")
    public ACMEIssuer getGithubComJetstackCertManagerPkgApisAcmeV1beta1ACMEIssuer() {
        return githubComJetstackCertManagerPkgApisAcmeV1beta1ACMEIssuer;
    }

    @JsonProperty("github_com_jetstack_cert-manager_pkg_apis_acme_v1beta1_ACMEIssuer")
    public void setGithubComJetstackCertManagerPkgApisAcmeV1beta1ACMEIssuer(ACMEIssuer githubComJetstackCertManagerPkgApisAcmeV1beta1ACMEIssuer) {
        this.githubComJetstackCertManagerPkgApisAcmeV1beta1ACMEIssuer = githubComJetstackCertManagerPkgApisAcmeV1beta1ACMEIssuer;
    }

    @JsonProperty("github_com_jetstack_cert-manager_pkg_apis_acme_v1beta1_ACMEIssuerDNS01ProviderAcmeDNS")
    public ACMEIssuerDNS01ProviderAcmeDNS getGithubComJetstackCertManagerPkgApisAcmeV1beta1ACMEIssuerDNS01ProviderAcmeDNS() {
        return githubComJetstackCertManagerPkgApisAcmeV1beta1ACMEIssuerDNS01ProviderAcmeDNS;
    }

    @JsonProperty("github_com_jetstack_cert-manager_pkg_apis_acme_v1beta1_ACMEIssuerDNS01ProviderAcmeDNS")
    public void setGithubComJetstackCertManagerPkgApisAcmeV1beta1ACMEIssuerDNS01ProviderAcmeDNS(ACMEIssuerDNS01ProviderAcmeDNS githubComJetstackCertManagerPkgApisAcmeV1beta1ACMEIssuerDNS01ProviderAcmeDNS) {
        this.githubComJetstackCertManagerPkgApisAcmeV1beta1ACMEIssuerDNS01ProviderAcmeDNS = githubComJetstackCertManagerPkgApisAcmeV1beta1ACMEIssuerDNS01ProviderAcmeDNS;
    }

    @JsonProperty("github_com_jetstack_cert-manager_pkg_apis_acme_v1beta1_ACMEIssuerDNS01ProviderAkamai")
    public ACMEIssuerDNS01ProviderAkamai getGithubComJetstackCertManagerPkgApisAcmeV1beta1ACMEIssuerDNS01ProviderAkamai() {
        return githubComJetstackCertManagerPkgApisAcmeV1beta1ACMEIssuerDNS01ProviderAkamai;
    }

    @JsonProperty("github_com_jetstack_cert-manager_pkg_apis_acme_v1beta1_ACMEIssuerDNS01ProviderAkamai")
    public void setGithubComJetstackCertManagerPkgApisAcmeV1beta1ACMEIssuerDNS01ProviderAkamai(ACMEIssuerDNS01ProviderAkamai githubComJetstackCertManagerPkgApisAcmeV1beta1ACMEIssuerDNS01ProviderAkamai) {
        this.githubComJetstackCertManagerPkgApisAcmeV1beta1ACMEIssuerDNS01ProviderAkamai = githubComJetstackCertManagerPkgApisAcmeV1beta1ACMEIssuerDNS01ProviderAkamai;
    }

    @JsonProperty("github_com_jetstack_cert-manager_pkg_apis_acme_v1beta1_ACMEIssuerDNS01ProviderAzureDNS")
    public ACMEIssuerDNS01ProviderAzureDNS getGithubComJetstackCertManagerPkgApisAcmeV1beta1ACMEIssuerDNS01ProviderAzureDNS() {
        return githubComJetstackCertManagerPkgApisAcmeV1beta1ACMEIssuerDNS01ProviderAzureDNS;
    }

    @JsonProperty("github_com_jetstack_cert-manager_pkg_apis_acme_v1beta1_ACMEIssuerDNS01ProviderAzureDNS")
    public void setGithubComJetstackCertManagerPkgApisAcmeV1beta1ACMEIssuerDNS01ProviderAzureDNS(ACMEIssuerDNS01ProviderAzureDNS githubComJetstackCertManagerPkgApisAcmeV1beta1ACMEIssuerDNS01ProviderAzureDNS) {
        this.githubComJetstackCertManagerPkgApisAcmeV1beta1ACMEIssuerDNS01ProviderAzureDNS = githubComJetstackCertManagerPkgApisAcmeV1beta1ACMEIssuerDNS01ProviderAzureDNS;
    }

    @JsonProperty("github_com_jetstack_cert-manager_pkg_apis_acme_v1beta1_ACMEIssuerDNS01ProviderCloudDNS")
    public ACMEIssuerDNS01ProviderCloudDNS getGithubComJetstackCertManagerPkgApisAcmeV1beta1ACMEIssuerDNS01ProviderCloudDNS() {
        return githubComJetstackCertManagerPkgApisAcmeV1beta1ACMEIssuerDNS01ProviderCloudDNS;
    }

    @JsonProperty("github_com_jetstack_cert-manager_pkg_apis_acme_v1beta1_ACMEIssuerDNS01ProviderCloudDNS")
    public void setGithubComJetstackCertManagerPkgApisAcmeV1beta1ACMEIssuerDNS01ProviderCloudDNS(ACMEIssuerDNS01ProviderCloudDNS githubComJetstackCertManagerPkgApisAcmeV1beta1ACMEIssuerDNS01ProviderCloudDNS) {
        this.githubComJetstackCertManagerPkgApisAcmeV1beta1ACMEIssuerDNS01ProviderCloudDNS = githubComJetstackCertManagerPkgApisAcmeV1beta1ACMEIssuerDNS01ProviderCloudDNS;
    }

    @JsonProperty("github_com_jetstack_cert-manager_pkg_apis_acme_v1beta1_ACMEIssuerDNS01ProviderCloudflare")
    public ACMEIssuerDNS01ProviderCloudflare getGithubComJetstackCertManagerPkgApisAcmeV1beta1ACMEIssuerDNS01ProviderCloudflare() {
        return githubComJetstackCertManagerPkgApisAcmeV1beta1ACMEIssuerDNS01ProviderCloudflare;
    }

    @JsonProperty("github_com_jetstack_cert-manager_pkg_apis_acme_v1beta1_ACMEIssuerDNS01ProviderCloudflare")
    public void setGithubComJetstackCertManagerPkgApisAcmeV1beta1ACMEIssuerDNS01ProviderCloudflare(ACMEIssuerDNS01ProviderCloudflare githubComJetstackCertManagerPkgApisAcmeV1beta1ACMEIssuerDNS01ProviderCloudflare) {
        this.githubComJetstackCertManagerPkgApisAcmeV1beta1ACMEIssuerDNS01ProviderCloudflare = githubComJetstackCertManagerPkgApisAcmeV1beta1ACMEIssuerDNS01ProviderCloudflare;
    }

    @JsonProperty("github_com_jetstack_cert-manager_pkg_apis_acme_v1beta1_ACMEIssuerDNS01ProviderDigitalOcean")
    public ACMEIssuerDNS01ProviderDigitalOcean getGithubComJetstackCertManagerPkgApisAcmeV1beta1ACMEIssuerDNS01ProviderDigitalOcean() {
        return githubComJetstackCertManagerPkgApisAcmeV1beta1ACMEIssuerDNS01ProviderDigitalOcean;
    }

    @JsonProperty("github_com_jetstack_cert-manager_pkg_apis_acme_v1beta1_ACMEIssuerDNS01ProviderDigitalOcean")
    public void setGithubComJetstackCertManagerPkgApisAcmeV1beta1ACMEIssuerDNS01ProviderDigitalOcean(ACMEIssuerDNS01ProviderDigitalOcean githubComJetstackCertManagerPkgApisAcmeV1beta1ACMEIssuerDNS01ProviderDigitalOcean) {
        this.githubComJetstackCertManagerPkgApisAcmeV1beta1ACMEIssuerDNS01ProviderDigitalOcean = githubComJetstackCertManagerPkgApisAcmeV1beta1ACMEIssuerDNS01ProviderDigitalOcean;
    }

    @JsonProperty("github_com_jetstack_cert-manager_pkg_apis_acme_v1beta1_ACMEIssuerDNS01ProviderRFC2136")
    public ACMEIssuerDNS01ProviderRFC2136 getGithubComJetstackCertManagerPkgApisAcmeV1beta1ACMEIssuerDNS01ProviderRFC2136() {
        return githubComJetstackCertManagerPkgApisAcmeV1beta1ACMEIssuerDNS01ProviderRFC2136;
    }

    @JsonProperty("github_com_jetstack_cert-manager_pkg_apis_acme_v1beta1_ACMEIssuerDNS01ProviderRFC2136")
    public void setGithubComJetstackCertManagerPkgApisAcmeV1beta1ACMEIssuerDNS01ProviderRFC2136(ACMEIssuerDNS01ProviderRFC2136 githubComJetstackCertManagerPkgApisAcmeV1beta1ACMEIssuerDNS01ProviderRFC2136) {
        this.githubComJetstackCertManagerPkgApisAcmeV1beta1ACMEIssuerDNS01ProviderRFC2136 = githubComJetstackCertManagerPkgApisAcmeV1beta1ACMEIssuerDNS01ProviderRFC2136;
    }

    @JsonProperty("github_com_jetstack_cert-manager_pkg_apis_acme_v1beta1_ACMEIssuerDNS01ProviderRoute53")
    public ACMEIssuerDNS01ProviderRoute53 getGithubComJetstackCertManagerPkgApisAcmeV1beta1ACMEIssuerDNS01ProviderRoute53() {
        return githubComJetstackCertManagerPkgApisAcmeV1beta1ACMEIssuerDNS01ProviderRoute53;
    }

    @JsonProperty("github_com_jetstack_cert-manager_pkg_apis_acme_v1beta1_ACMEIssuerDNS01ProviderRoute53")
    public void setGithubComJetstackCertManagerPkgApisAcmeV1beta1ACMEIssuerDNS01ProviderRoute53(ACMEIssuerDNS01ProviderRoute53 githubComJetstackCertManagerPkgApisAcmeV1beta1ACMEIssuerDNS01ProviderRoute53) {
        this.githubComJetstackCertManagerPkgApisAcmeV1beta1ACMEIssuerDNS01ProviderRoute53 = githubComJetstackCertManagerPkgApisAcmeV1beta1ACMEIssuerDNS01ProviderRoute53;
    }

    @JsonProperty("github_com_jetstack_cert-manager_pkg_apis_acme_v1beta1_ACMEIssuerDNS01ProviderWebhook")
    public ACMEIssuerDNS01ProviderWebhook getGithubComJetstackCertManagerPkgApisAcmeV1beta1ACMEIssuerDNS01ProviderWebhook() {
        return githubComJetstackCertManagerPkgApisAcmeV1beta1ACMEIssuerDNS01ProviderWebhook;
    }

    @JsonProperty("github_com_jetstack_cert-manager_pkg_apis_acme_v1beta1_ACMEIssuerDNS01ProviderWebhook")
    public void setGithubComJetstackCertManagerPkgApisAcmeV1beta1ACMEIssuerDNS01ProviderWebhook(ACMEIssuerDNS01ProviderWebhook githubComJetstackCertManagerPkgApisAcmeV1beta1ACMEIssuerDNS01ProviderWebhook) {
        this.githubComJetstackCertManagerPkgApisAcmeV1beta1ACMEIssuerDNS01ProviderWebhook = githubComJetstackCertManagerPkgApisAcmeV1beta1ACMEIssuerDNS01ProviderWebhook;
    }

    @JsonProperty("github_com_jetstack_cert-manager_pkg_apis_acme_v1beta1_ACMEIssuerStatus")
    public ACMEIssuerStatus getGithubComJetstackCertManagerPkgApisAcmeV1beta1ACMEIssuerStatus() {
        return githubComJetstackCertManagerPkgApisAcmeV1beta1ACMEIssuerStatus;
    }

    @JsonProperty("github_com_jetstack_cert-manager_pkg_apis_acme_v1beta1_ACMEIssuerStatus")
    public void setGithubComJetstackCertManagerPkgApisAcmeV1beta1ACMEIssuerStatus(ACMEIssuerStatus githubComJetstackCertManagerPkgApisAcmeV1beta1ACMEIssuerStatus) {
        this.githubComJetstackCertManagerPkgApisAcmeV1beta1ACMEIssuerStatus = githubComJetstackCertManagerPkgApisAcmeV1beta1ACMEIssuerStatus;
    }

    @JsonProperty("github_com_jetstack_cert-manager_pkg_apis_acme_v1beta1_CertificateDNSNameSelector")
    public CertificateDNSNameSelector getGithubComJetstackCertManagerPkgApisAcmeV1beta1CertificateDNSNameSelector() {
        return githubComJetstackCertManagerPkgApisAcmeV1beta1CertificateDNSNameSelector;
    }

    @JsonProperty("github_com_jetstack_cert-manager_pkg_apis_acme_v1beta1_CertificateDNSNameSelector")
    public void setGithubComJetstackCertManagerPkgApisAcmeV1beta1CertificateDNSNameSelector(CertificateDNSNameSelector githubComJetstackCertManagerPkgApisAcmeV1beta1CertificateDNSNameSelector) {
        this.githubComJetstackCertManagerPkgApisAcmeV1beta1CertificateDNSNameSelector = githubComJetstackCertManagerPkgApisAcmeV1beta1CertificateDNSNameSelector;
    }

    @JsonProperty("github_com_jetstack_cert-manager_pkg_apis_acme_v1beta1_Challenge")
    public Challenge getGithubComJetstackCertManagerPkgApisAcmeV1beta1Challenge() {
        return githubComJetstackCertManagerPkgApisAcmeV1beta1Challenge;
    }

    @JsonProperty("github_com_jetstack_cert-manager_pkg_apis_acme_v1beta1_Challenge")
    public void setGithubComJetstackCertManagerPkgApisAcmeV1beta1Challenge(Challenge githubComJetstackCertManagerPkgApisAcmeV1beta1Challenge) {
        this.githubComJetstackCertManagerPkgApisAcmeV1beta1Challenge = githubComJetstackCertManagerPkgApisAcmeV1beta1Challenge;
    }

    @JsonProperty("github_com_jetstack_cert-manager_pkg_apis_acme_v1beta1_ChallengeList")
    public ChallengeList getGithubComJetstackCertManagerPkgApisAcmeV1beta1ChallengeList() {
        return githubComJetstackCertManagerPkgApisAcmeV1beta1ChallengeList;
    }

    @JsonProperty("github_com_jetstack_cert-manager_pkg_apis_acme_v1beta1_ChallengeList")
    public void setGithubComJetstackCertManagerPkgApisAcmeV1beta1ChallengeList(ChallengeList githubComJetstackCertManagerPkgApisAcmeV1beta1ChallengeList) {
        this.githubComJetstackCertManagerPkgApisAcmeV1beta1ChallengeList = githubComJetstackCertManagerPkgApisAcmeV1beta1ChallengeList;
    }

    @JsonProperty("github_com_jetstack_cert-manager_pkg_apis_acme_v1beta1_ChallengeSpec")
    public ChallengeSpec getGithubComJetstackCertManagerPkgApisAcmeV1beta1ChallengeSpec() {
        return githubComJetstackCertManagerPkgApisAcmeV1beta1ChallengeSpec;
    }

    @JsonProperty("github_com_jetstack_cert-manager_pkg_apis_acme_v1beta1_ChallengeSpec")
    public void setGithubComJetstackCertManagerPkgApisAcmeV1beta1ChallengeSpec(ChallengeSpec githubComJetstackCertManagerPkgApisAcmeV1beta1ChallengeSpec) {
        this.githubComJetstackCertManagerPkgApisAcmeV1beta1ChallengeSpec = githubComJetstackCertManagerPkgApisAcmeV1beta1ChallengeSpec;
    }

    @JsonProperty("github_com_jetstack_cert-manager_pkg_apis_acme_v1beta1_ChallengeStatus")
    public ChallengeStatus getGithubComJetstackCertManagerPkgApisAcmeV1beta1ChallengeStatus() {
        return githubComJetstackCertManagerPkgApisAcmeV1beta1ChallengeStatus;
    }

    @JsonProperty("github_com_jetstack_cert-manager_pkg_apis_acme_v1beta1_ChallengeStatus")
    public void setGithubComJetstackCertManagerPkgApisAcmeV1beta1ChallengeStatus(ChallengeStatus githubComJetstackCertManagerPkgApisAcmeV1beta1ChallengeStatus) {
        this.githubComJetstackCertManagerPkgApisAcmeV1beta1ChallengeStatus = githubComJetstackCertManagerPkgApisAcmeV1beta1ChallengeStatus;
    }

    @JsonProperty("github_com_jetstack_cert-manager_pkg_apis_acme_v1beta1_Order")
    public Order getGithubComJetstackCertManagerPkgApisAcmeV1beta1Order() {
        return githubComJetstackCertManagerPkgApisAcmeV1beta1Order;
    }

    @JsonProperty("github_com_jetstack_cert-manager_pkg_apis_acme_v1beta1_Order")
    public void setGithubComJetstackCertManagerPkgApisAcmeV1beta1Order(Order githubComJetstackCertManagerPkgApisAcmeV1beta1Order) {
        this.githubComJetstackCertManagerPkgApisAcmeV1beta1Order = githubComJetstackCertManagerPkgApisAcmeV1beta1Order;
    }

    @JsonProperty("github_com_jetstack_cert-manager_pkg_apis_acme_v1beta1_OrderList")
    public OrderList getGithubComJetstackCertManagerPkgApisAcmeV1beta1OrderList() {
        return githubComJetstackCertManagerPkgApisAcmeV1beta1OrderList;
    }

    @JsonProperty("github_com_jetstack_cert-manager_pkg_apis_acme_v1beta1_OrderList")
    public void setGithubComJetstackCertManagerPkgApisAcmeV1beta1OrderList(OrderList githubComJetstackCertManagerPkgApisAcmeV1beta1OrderList) {
        this.githubComJetstackCertManagerPkgApisAcmeV1beta1OrderList = githubComJetstackCertManagerPkgApisAcmeV1beta1OrderList;
    }

    @JsonProperty("github_com_jetstack_cert-manager_pkg_apis_acme_v1beta1_OrderSpec")
    public OrderSpec getGithubComJetstackCertManagerPkgApisAcmeV1beta1OrderSpec() {
        return githubComJetstackCertManagerPkgApisAcmeV1beta1OrderSpec;
    }

    @JsonProperty("github_com_jetstack_cert-manager_pkg_apis_acme_v1beta1_OrderSpec")
    public void setGithubComJetstackCertManagerPkgApisAcmeV1beta1OrderSpec(OrderSpec githubComJetstackCertManagerPkgApisAcmeV1beta1OrderSpec) {
        this.githubComJetstackCertManagerPkgApisAcmeV1beta1OrderSpec = githubComJetstackCertManagerPkgApisAcmeV1beta1OrderSpec;
    }

    @JsonProperty("github_com_jetstack_cert-manager_pkg_apis_acme_v1beta1_OrderStatus")
    public OrderStatus getGithubComJetstackCertManagerPkgApisAcmeV1beta1OrderStatus() {
        return githubComJetstackCertManagerPkgApisAcmeV1beta1OrderStatus;
    }

    @JsonProperty("github_com_jetstack_cert-manager_pkg_apis_acme_v1beta1_OrderStatus")
    public void setGithubComJetstackCertManagerPkgApisAcmeV1beta1OrderStatus(OrderStatus githubComJetstackCertManagerPkgApisAcmeV1beta1OrderStatus) {
        this.githubComJetstackCertManagerPkgApisAcmeV1beta1OrderStatus = githubComJetstackCertManagerPkgApisAcmeV1beta1OrderStatus;
    }

    @JsonProperty("github_com_jetstack_cert-manager_pkg_apis_certmanager_v1beta1_CAIssuer")
    public CAIssuer getGithubComJetstackCertManagerPkgApisCertmanagerV1beta1CAIssuer() {
        return githubComJetstackCertManagerPkgApisCertmanagerV1beta1CAIssuer;
    }

    @JsonProperty("github_com_jetstack_cert-manager_pkg_apis_certmanager_v1beta1_CAIssuer")
    public void setGithubComJetstackCertManagerPkgApisCertmanagerV1beta1CAIssuer(CAIssuer githubComJetstackCertManagerPkgApisCertmanagerV1beta1CAIssuer) {
        this.githubComJetstackCertManagerPkgApisCertmanagerV1beta1CAIssuer = githubComJetstackCertManagerPkgApisCertmanagerV1beta1CAIssuer;
    }

    @JsonProperty("github_com_jetstack_cert-manager_pkg_apis_certmanager_v1beta1_Certificate")
    public Certificate getGithubComJetstackCertManagerPkgApisCertmanagerV1beta1Certificate() {
        return githubComJetstackCertManagerPkgApisCertmanagerV1beta1Certificate;
    }

    @JsonProperty("github_com_jetstack_cert-manager_pkg_apis_certmanager_v1beta1_Certificate")
    public void setGithubComJetstackCertManagerPkgApisCertmanagerV1beta1Certificate(Certificate githubComJetstackCertManagerPkgApisCertmanagerV1beta1Certificate) {
        this.githubComJetstackCertManagerPkgApisCertmanagerV1beta1Certificate = githubComJetstackCertManagerPkgApisCertmanagerV1beta1Certificate;
    }

    @JsonProperty("github_com_jetstack_cert-manager_pkg_apis_certmanager_v1beta1_CertificateCondition")
    public CertificateCondition getGithubComJetstackCertManagerPkgApisCertmanagerV1beta1CertificateCondition() {
        return githubComJetstackCertManagerPkgApisCertmanagerV1beta1CertificateCondition;
    }

    @JsonProperty("github_com_jetstack_cert-manager_pkg_apis_certmanager_v1beta1_CertificateCondition")
    public void setGithubComJetstackCertManagerPkgApisCertmanagerV1beta1CertificateCondition(CertificateCondition githubComJetstackCertManagerPkgApisCertmanagerV1beta1CertificateCondition) {
        this.githubComJetstackCertManagerPkgApisCertmanagerV1beta1CertificateCondition = githubComJetstackCertManagerPkgApisCertmanagerV1beta1CertificateCondition;
    }

    @JsonProperty("github_com_jetstack_cert-manager_pkg_apis_certmanager_v1beta1_CertificateKeystores")
    public CertificateKeystores getGithubComJetstackCertManagerPkgApisCertmanagerV1beta1CertificateKeystores() {
        return githubComJetstackCertManagerPkgApisCertmanagerV1beta1CertificateKeystores;
    }

    @JsonProperty("github_com_jetstack_cert-manager_pkg_apis_certmanager_v1beta1_CertificateKeystores")
    public void setGithubComJetstackCertManagerPkgApisCertmanagerV1beta1CertificateKeystores(CertificateKeystores githubComJetstackCertManagerPkgApisCertmanagerV1beta1CertificateKeystores) {
        this.githubComJetstackCertManagerPkgApisCertmanagerV1beta1CertificateKeystores = githubComJetstackCertManagerPkgApisCertmanagerV1beta1CertificateKeystores;
    }

    @JsonProperty("github_com_jetstack_cert-manager_pkg_apis_certmanager_v1beta1_CertificateList")
    public CertificateList getGithubComJetstackCertManagerPkgApisCertmanagerV1beta1CertificateList() {
        return githubComJetstackCertManagerPkgApisCertmanagerV1beta1CertificateList;
    }

    @JsonProperty("github_com_jetstack_cert-manager_pkg_apis_certmanager_v1beta1_CertificateList")
    public void setGithubComJetstackCertManagerPkgApisCertmanagerV1beta1CertificateList(CertificateList githubComJetstackCertManagerPkgApisCertmanagerV1beta1CertificateList) {
        this.githubComJetstackCertManagerPkgApisCertmanagerV1beta1CertificateList = githubComJetstackCertManagerPkgApisCertmanagerV1beta1CertificateList;
    }

    @JsonProperty("github_com_jetstack_cert-manager_pkg_apis_certmanager_v1beta1_CertificatePrivateKey")
    public CertificatePrivateKey getGithubComJetstackCertManagerPkgApisCertmanagerV1beta1CertificatePrivateKey() {
        return githubComJetstackCertManagerPkgApisCertmanagerV1beta1CertificatePrivateKey;
    }

    @JsonProperty("github_com_jetstack_cert-manager_pkg_apis_certmanager_v1beta1_CertificatePrivateKey")
    public void setGithubComJetstackCertManagerPkgApisCertmanagerV1beta1CertificatePrivateKey(CertificatePrivateKey githubComJetstackCertManagerPkgApisCertmanagerV1beta1CertificatePrivateKey) {
        this.githubComJetstackCertManagerPkgApisCertmanagerV1beta1CertificatePrivateKey = githubComJetstackCertManagerPkgApisCertmanagerV1beta1CertificatePrivateKey;
    }

    @JsonProperty("github_com_jetstack_cert-manager_pkg_apis_certmanager_v1beta1_CertificateRequest")
    public CertificateRequest getGithubComJetstackCertManagerPkgApisCertmanagerV1beta1CertificateRequest() {
        return githubComJetstackCertManagerPkgApisCertmanagerV1beta1CertificateRequest;
    }

    @JsonProperty("github_com_jetstack_cert-manager_pkg_apis_certmanager_v1beta1_CertificateRequest")
    public void setGithubComJetstackCertManagerPkgApisCertmanagerV1beta1CertificateRequest(CertificateRequest githubComJetstackCertManagerPkgApisCertmanagerV1beta1CertificateRequest) {
        this.githubComJetstackCertManagerPkgApisCertmanagerV1beta1CertificateRequest = githubComJetstackCertManagerPkgApisCertmanagerV1beta1CertificateRequest;
    }

    @JsonProperty("github_com_jetstack_cert-manager_pkg_apis_certmanager_v1beta1_CertificateRequestCondition")
    public CertificateRequestCondition getGithubComJetstackCertManagerPkgApisCertmanagerV1beta1CertificateRequestCondition() {
        return githubComJetstackCertManagerPkgApisCertmanagerV1beta1CertificateRequestCondition;
    }

    @JsonProperty("github_com_jetstack_cert-manager_pkg_apis_certmanager_v1beta1_CertificateRequestCondition")
    public void setGithubComJetstackCertManagerPkgApisCertmanagerV1beta1CertificateRequestCondition(CertificateRequestCondition githubComJetstackCertManagerPkgApisCertmanagerV1beta1CertificateRequestCondition) {
        this.githubComJetstackCertManagerPkgApisCertmanagerV1beta1CertificateRequestCondition = githubComJetstackCertManagerPkgApisCertmanagerV1beta1CertificateRequestCondition;
    }

    @JsonProperty("github_com_jetstack_cert-manager_pkg_apis_certmanager_v1beta1_CertificateRequestList")
    public CertificateRequestList getGithubComJetstackCertManagerPkgApisCertmanagerV1beta1CertificateRequestList() {
        return githubComJetstackCertManagerPkgApisCertmanagerV1beta1CertificateRequestList;
    }

    @JsonProperty("github_com_jetstack_cert-manager_pkg_apis_certmanager_v1beta1_CertificateRequestList")
    public void setGithubComJetstackCertManagerPkgApisCertmanagerV1beta1CertificateRequestList(CertificateRequestList githubComJetstackCertManagerPkgApisCertmanagerV1beta1CertificateRequestList) {
        this.githubComJetstackCertManagerPkgApisCertmanagerV1beta1CertificateRequestList = githubComJetstackCertManagerPkgApisCertmanagerV1beta1CertificateRequestList;
    }

    @JsonProperty("github_com_jetstack_cert-manager_pkg_apis_certmanager_v1beta1_CertificateRequestSpec")
    public CertificateRequestSpec getGithubComJetstackCertManagerPkgApisCertmanagerV1beta1CertificateRequestSpec() {
        return githubComJetstackCertManagerPkgApisCertmanagerV1beta1CertificateRequestSpec;
    }

    @JsonProperty("github_com_jetstack_cert-manager_pkg_apis_certmanager_v1beta1_CertificateRequestSpec")
    public void setGithubComJetstackCertManagerPkgApisCertmanagerV1beta1CertificateRequestSpec(CertificateRequestSpec githubComJetstackCertManagerPkgApisCertmanagerV1beta1CertificateRequestSpec) {
        this.githubComJetstackCertManagerPkgApisCertmanagerV1beta1CertificateRequestSpec = githubComJetstackCertManagerPkgApisCertmanagerV1beta1CertificateRequestSpec;
    }

    @JsonProperty("github_com_jetstack_cert-manager_pkg_apis_certmanager_v1beta1_CertificateRequestStatus")
    public CertificateRequestStatus getGithubComJetstackCertManagerPkgApisCertmanagerV1beta1CertificateRequestStatus() {
        return githubComJetstackCertManagerPkgApisCertmanagerV1beta1CertificateRequestStatus;
    }

    @JsonProperty("github_com_jetstack_cert-manager_pkg_apis_certmanager_v1beta1_CertificateRequestStatus")
    public void setGithubComJetstackCertManagerPkgApisCertmanagerV1beta1CertificateRequestStatus(CertificateRequestStatus githubComJetstackCertManagerPkgApisCertmanagerV1beta1CertificateRequestStatus) {
        this.githubComJetstackCertManagerPkgApisCertmanagerV1beta1CertificateRequestStatus = githubComJetstackCertManagerPkgApisCertmanagerV1beta1CertificateRequestStatus;
    }

    @JsonProperty("github_com_jetstack_cert-manager_pkg_apis_certmanager_v1beta1_CertificateSpec")
    public CertificateSpec getGithubComJetstackCertManagerPkgApisCertmanagerV1beta1CertificateSpec() {
        return githubComJetstackCertManagerPkgApisCertmanagerV1beta1CertificateSpec;
    }

    @JsonProperty("github_com_jetstack_cert-manager_pkg_apis_certmanager_v1beta1_CertificateSpec")
    public void setGithubComJetstackCertManagerPkgApisCertmanagerV1beta1CertificateSpec(CertificateSpec githubComJetstackCertManagerPkgApisCertmanagerV1beta1CertificateSpec) {
        this.githubComJetstackCertManagerPkgApisCertmanagerV1beta1CertificateSpec = githubComJetstackCertManagerPkgApisCertmanagerV1beta1CertificateSpec;
    }

    @JsonProperty("github_com_jetstack_cert-manager_pkg_apis_certmanager_v1beta1_CertificateStatus")
    public CertificateStatus getGithubComJetstackCertManagerPkgApisCertmanagerV1beta1CertificateStatus() {
        return githubComJetstackCertManagerPkgApisCertmanagerV1beta1CertificateStatus;
    }

    @JsonProperty("github_com_jetstack_cert-manager_pkg_apis_certmanager_v1beta1_CertificateStatus")
    public void setGithubComJetstackCertManagerPkgApisCertmanagerV1beta1CertificateStatus(CertificateStatus githubComJetstackCertManagerPkgApisCertmanagerV1beta1CertificateStatus) {
        this.githubComJetstackCertManagerPkgApisCertmanagerV1beta1CertificateStatus = githubComJetstackCertManagerPkgApisCertmanagerV1beta1CertificateStatus;
    }

    @JsonProperty("github_com_jetstack_cert-manager_pkg_apis_certmanager_v1beta1_ClusterIssuer")
    public ClusterIssuer getGithubComJetstackCertManagerPkgApisCertmanagerV1beta1ClusterIssuer() {
        return githubComJetstackCertManagerPkgApisCertmanagerV1beta1ClusterIssuer;
    }

    @JsonProperty("github_com_jetstack_cert-manager_pkg_apis_certmanager_v1beta1_ClusterIssuer")
    public void setGithubComJetstackCertManagerPkgApisCertmanagerV1beta1ClusterIssuer(ClusterIssuer githubComJetstackCertManagerPkgApisCertmanagerV1beta1ClusterIssuer) {
        this.githubComJetstackCertManagerPkgApisCertmanagerV1beta1ClusterIssuer = githubComJetstackCertManagerPkgApisCertmanagerV1beta1ClusterIssuer;
    }

    @JsonProperty("github_com_jetstack_cert-manager_pkg_apis_certmanager_v1beta1_ClusterIssuerList")
    public ClusterIssuerList getGithubComJetstackCertManagerPkgApisCertmanagerV1beta1ClusterIssuerList() {
        return githubComJetstackCertManagerPkgApisCertmanagerV1beta1ClusterIssuerList;
    }

    @JsonProperty("github_com_jetstack_cert-manager_pkg_apis_certmanager_v1beta1_ClusterIssuerList")
    public void setGithubComJetstackCertManagerPkgApisCertmanagerV1beta1ClusterIssuerList(ClusterIssuerList githubComJetstackCertManagerPkgApisCertmanagerV1beta1ClusterIssuerList) {
        this.githubComJetstackCertManagerPkgApisCertmanagerV1beta1ClusterIssuerList = githubComJetstackCertManagerPkgApisCertmanagerV1beta1ClusterIssuerList;
    }

    @JsonProperty("github_com_jetstack_cert-manager_pkg_apis_certmanager_v1beta1_Issuer")
    public Issuer getGithubComJetstackCertManagerPkgApisCertmanagerV1beta1Issuer() {
        return githubComJetstackCertManagerPkgApisCertmanagerV1beta1Issuer;
    }

    @JsonProperty("github_com_jetstack_cert-manager_pkg_apis_certmanager_v1beta1_Issuer")
    public void setGithubComJetstackCertManagerPkgApisCertmanagerV1beta1Issuer(Issuer githubComJetstackCertManagerPkgApisCertmanagerV1beta1Issuer) {
        this.githubComJetstackCertManagerPkgApisCertmanagerV1beta1Issuer = githubComJetstackCertManagerPkgApisCertmanagerV1beta1Issuer;
    }

    @JsonProperty("github_com_jetstack_cert-manager_pkg_apis_certmanager_v1beta1_IssuerCondition")
    public IssuerCondition getGithubComJetstackCertManagerPkgApisCertmanagerV1beta1IssuerCondition() {
        return githubComJetstackCertManagerPkgApisCertmanagerV1beta1IssuerCondition;
    }

    @JsonProperty("github_com_jetstack_cert-manager_pkg_apis_certmanager_v1beta1_IssuerCondition")
    public void setGithubComJetstackCertManagerPkgApisCertmanagerV1beta1IssuerCondition(IssuerCondition githubComJetstackCertManagerPkgApisCertmanagerV1beta1IssuerCondition) {
        this.githubComJetstackCertManagerPkgApisCertmanagerV1beta1IssuerCondition = githubComJetstackCertManagerPkgApisCertmanagerV1beta1IssuerCondition;
    }

    @JsonProperty("github_com_jetstack_cert-manager_pkg_apis_certmanager_v1beta1_IssuerList")
    public IssuerList getGithubComJetstackCertManagerPkgApisCertmanagerV1beta1IssuerList() {
        return githubComJetstackCertManagerPkgApisCertmanagerV1beta1IssuerList;
    }

    @JsonProperty("github_com_jetstack_cert-manager_pkg_apis_certmanager_v1beta1_IssuerList")
    public void setGithubComJetstackCertManagerPkgApisCertmanagerV1beta1IssuerList(IssuerList githubComJetstackCertManagerPkgApisCertmanagerV1beta1IssuerList) {
        this.githubComJetstackCertManagerPkgApisCertmanagerV1beta1IssuerList = githubComJetstackCertManagerPkgApisCertmanagerV1beta1IssuerList;
    }

    @JsonProperty("github_com_jetstack_cert-manager_pkg_apis_certmanager_v1beta1_IssuerSpec")
    public IssuerSpec getGithubComJetstackCertManagerPkgApisCertmanagerV1beta1IssuerSpec() {
        return githubComJetstackCertManagerPkgApisCertmanagerV1beta1IssuerSpec;
    }

    @JsonProperty("github_com_jetstack_cert-manager_pkg_apis_certmanager_v1beta1_IssuerSpec")
    public void setGithubComJetstackCertManagerPkgApisCertmanagerV1beta1IssuerSpec(IssuerSpec githubComJetstackCertManagerPkgApisCertmanagerV1beta1IssuerSpec) {
        this.githubComJetstackCertManagerPkgApisCertmanagerV1beta1IssuerSpec = githubComJetstackCertManagerPkgApisCertmanagerV1beta1IssuerSpec;
    }

    @JsonProperty("github_com_jetstack_cert-manager_pkg_apis_certmanager_v1beta1_IssuerStatus")
    public IssuerStatus getGithubComJetstackCertManagerPkgApisCertmanagerV1beta1IssuerStatus() {
        return githubComJetstackCertManagerPkgApisCertmanagerV1beta1IssuerStatus;
    }

    @JsonProperty("github_com_jetstack_cert-manager_pkg_apis_certmanager_v1beta1_IssuerStatus")
    public void setGithubComJetstackCertManagerPkgApisCertmanagerV1beta1IssuerStatus(IssuerStatus githubComJetstackCertManagerPkgApisCertmanagerV1beta1IssuerStatus) {
        this.githubComJetstackCertManagerPkgApisCertmanagerV1beta1IssuerStatus = githubComJetstackCertManagerPkgApisCertmanagerV1beta1IssuerStatus;
    }

    @JsonProperty("github_com_jetstack_cert-manager_pkg_apis_certmanager_v1beta1_JKSKeystore")
    public JKSKeystore getGithubComJetstackCertManagerPkgApisCertmanagerV1beta1JKSKeystore() {
        return githubComJetstackCertManagerPkgApisCertmanagerV1beta1JKSKeystore;
    }

    @JsonProperty("github_com_jetstack_cert-manager_pkg_apis_certmanager_v1beta1_JKSKeystore")
    public void setGithubComJetstackCertManagerPkgApisCertmanagerV1beta1JKSKeystore(JKSKeystore githubComJetstackCertManagerPkgApisCertmanagerV1beta1JKSKeystore) {
        this.githubComJetstackCertManagerPkgApisCertmanagerV1beta1JKSKeystore = githubComJetstackCertManagerPkgApisCertmanagerV1beta1JKSKeystore;
    }

    @JsonProperty("github_com_jetstack_cert-manager_pkg_apis_certmanager_v1beta1_PKCS12Keystore")
    public PKCS12Keystore getGithubComJetstackCertManagerPkgApisCertmanagerV1beta1PKCS12Keystore() {
        return githubComJetstackCertManagerPkgApisCertmanagerV1beta1PKCS12Keystore;
    }

    @JsonProperty("github_com_jetstack_cert-manager_pkg_apis_certmanager_v1beta1_PKCS12Keystore")
    public void setGithubComJetstackCertManagerPkgApisCertmanagerV1beta1PKCS12Keystore(PKCS12Keystore githubComJetstackCertManagerPkgApisCertmanagerV1beta1PKCS12Keystore) {
        this.githubComJetstackCertManagerPkgApisCertmanagerV1beta1PKCS12Keystore = githubComJetstackCertManagerPkgApisCertmanagerV1beta1PKCS12Keystore;
    }

    @JsonProperty("github_com_jetstack_cert-manager_pkg_apis_certmanager_v1beta1_SelfSignedIssuer")
    public SelfSignedIssuer getGithubComJetstackCertManagerPkgApisCertmanagerV1beta1SelfSignedIssuer() {
        return githubComJetstackCertManagerPkgApisCertmanagerV1beta1SelfSignedIssuer;
    }

    @JsonProperty("github_com_jetstack_cert-manager_pkg_apis_certmanager_v1beta1_SelfSignedIssuer")
    public void setGithubComJetstackCertManagerPkgApisCertmanagerV1beta1SelfSignedIssuer(SelfSignedIssuer githubComJetstackCertManagerPkgApisCertmanagerV1beta1SelfSignedIssuer) {
        this.githubComJetstackCertManagerPkgApisCertmanagerV1beta1SelfSignedIssuer = githubComJetstackCertManagerPkgApisCertmanagerV1beta1SelfSignedIssuer;
    }

    @JsonProperty("github_com_jetstack_cert-manager_pkg_apis_certmanager_v1beta1_VaultAppRole")
    public VaultAppRole getGithubComJetstackCertManagerPkgApisCertmanagerV1beta1VaultAppRole() {
        return githubComJetstackCertManagerPkgApisCertmanagerV1beta1VaultAppRole;
    }

    @JsonProperty("github_com_jetstack_cert-manager_pkg_apis_certmanager_v1beta1_VaultAppRole")
    public void setGithubComJetstackCertManagerPkgApisCertmanagerV1beta1VaultAppRole(VaultAppRole githubComJetstackCertManagerPkgApisCertmanagerV1beta1VaultAppRole) {
        this.githubComJetstackCertManagerPkgApisCertmanagerV1beta1VaultAppRole = githubComJetstackCertManagerPkgApisCertmanagerV1beta1VaultAppRole;
    }

    @JsonProperty("github_com_jetstack_cert-manager_pkg_apis_certmanager_v1beta1_VaultAuth")
    public VaultAuth getGithubComJetstackCertManagerPkgApisCertmanagerV1beta1VaultAuth() {
        return githubComJetstackCertManagerPkgApisCertmanagerV1beta1VaultAuth;
    }

    @JsonProperty("github_com_jetstack_cert-manager_pkg_apis_certmanager_v1beta1_VaultAuth")
    public void setGithubComJetstackCertManagerPkgApisCertmanagerV1beta1VaultAuth(VaultAuth githubComJetstackCertManagerPkgApisCertmanagerV1beta1VaultAuth) {
        this.githubComJetstackCertManagerPkgApisCertmanagerV1beta1VaultAuth = githubComJetstackCertManagerPkgApisCertmanagerV1beta1VaultAuth;
    }

    @JsonProperty("github_com_jetstack_cert-manager_pkg_apis_certmanager_v1beta1_VaultIssuer")
    public VaultIssuer getGithubComJetstackCertManagerPkgApisCertmanagerV1beta1VaultIssuer() {
        return githubComJetstackCertManagerPkgApisCertmanagerV1beta1VaultIssuer;
    }

    @JsonProperty("github_com_jetstack_cert-manager_pkg_apis_certmanager_v1beta1_VaultIssuer")
    public void setGithubComJetstackCertManagerPkgApisCertmanagerV1beta1VaultIssuer(VaultIssuer githubComJetstackCertManagerPkgApisCertmanagerV1beta1VaultIssuer) {
        this.githubComJetstackCertManagerPkgApisCertmanagerV1beta1VaultIssuer = githubComJetstackCertManagerPkgApisCertmanagerV1beta1VaultIssuer;
    }

    @JsonProperty("github_com_jetstack_cert-manager_pkg_apis_certmanager_v1beta1_VaultKubernetesAuth")
    public VaultKubernetesAuth getGithubComJetstackCertManagerPkgApisCertmanagerV1beta1VaultKubernetesAuth() {
        return githubComJetstackCertManagerPkgApisCertmanagerV1beta1VaultKubernetesAuth;
    }

    @JsonProperty("github_com_jetstack_cert-manager_pkg_apis_certmanager_v1beta1_VaultKubernetesAuth")
    public void setGithubComJetstackCertManagerPkgApisCertmanagerV1beta1VaultKubernetesAuth(VaultKubernetesAuth githubComJetstackCertManagerPkgApisCertmanagerV1beta1VaultKubernetesAuth) {
        this.githubComJetstackCertManagerPkgApisCertmanagerV1beta1VaultKubernetesAuth = githubComJetstackCertManagerPkgApisCertmanagerV1beta1VaultKubernetesAuth;
    }

    @JsonProperty("github_com_jetstack_cert-manager_pkg_apis_certmanager_v1beta1_VenafiCloud")
    public VenafiCloud getGithubComJetstackCertManagerPkgApisCertmanagerV1beta1VenafiCloud() {
        return githubComJetstackCertManagerPkgApisCertmanagerV1beta1VenafiCloud;
    }

    @JsonProperty("github_com_jetstack_cert-manager_pkg_apis_certmanager_v1beta1_VenafiCloud")
    public void setGithubComJetstackCertManagerPkgApisCertmanagerV1beta1VenafiCloud(VenafiCloud githubComJetstackCertManagerPkgApisCertmanagerV1beta1VenafiCloud) {
        this.githubComJetstackCertManagerPkgApisCertmanagerV1beta1VenafiCloud = githubComJetstackCertManagerPkgApisCertmanagerV1beta1VenafiCloud;
    }

    @JsonProperty("github_com_jetstack_cert-manager_pkg_apis_certmanager_v1beta1_VenafiIssuer")
    public VenafiIssuer getGithubComJetstackCertManagerPkgApisCertmanagerV1beta1VenafiIssuer() {
        return githubComJetstackCertManagerPkgApisCertmanagerV1beta1VenafiIssuer;
    }

    @JsonProperty("github_com_jetstack_cert-manager_pkg_apis_certmanager_v1beta1_VenafiIssuer")
    public void setGithubComJetstackCertManagerPkgApisCertmanagerV1beta1VenafiIssuer(VenafiIssuer githubComJetstackCertManagerPkgApisCertmanagerV1beta1VenafiIssuer) {
        this.githubComJetstackCertManagerPkgApisCertmanagerV1beta1VenafiIssuer = githubComJetstackCertManagerPkgApisCertmanagerV1beta1VenafiIssuer;
    }

    @JsonProperty("github_com_jetstack_cert-manager_pkg_apis_certmanager_v1beta1_VenafiTPP")
    public VenafiTPP getGithubComJetstackCertManagerPkgApisCertmanagerV1beta1VenafiTPP() {
        return githubComJetstackCertManagerPkgApisCertmanagerV1beta1VenafiTPP;
    }

    @JsonProperty("github_com_jetstack_cert-manager_pkg_apis_certmanager_v1beta1_VenafiTPP")
    public void setGithubComJetstackCertManagerPkgApisCertmanagerV1beta1VenafiTPP(VenafiTPP githubComJetstackCertManagerPkgApisCertmanagerV1beta1VenafiTPP) {
        this.githubComJetstackCertManagerPkgApisCertmanagerV1beta1VenafiTPP = githubComJetstackCertManagerPkgApisCertmanagerV1beta1VenafiTPP;
    }

    @JsonProperty("github_com_jetstack_cert-manager_pkg_apis_certmanager_v1beta1_X509Subject")
    public X509Subject getGithubComJetstackCertManagerPkgApisCertmanagerV1beta1X509Subject() {
        return githubComJetstackCertManagerPkgApisCertmanagerV1beta1X509Subject;
    }

    @JsonProperty("github_com_jetstack_cert-manager_pkg_apis_certmanager_v1beta1_X509Subject")
    public void setGithubComJetstackCertManagerPkgApisCertmanagerV1beta1X509Subject(X509Subject githubComJetstackCertManagerPkgApisCertmanagerV1beta1X509Subject) {
        this.githubComJetstackCertManagerPkgApisCertmanagerV1beta1X509Subject = githubComJetstackCertManagerPkgApisCertmanagerV1beta1X509Subject;
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
