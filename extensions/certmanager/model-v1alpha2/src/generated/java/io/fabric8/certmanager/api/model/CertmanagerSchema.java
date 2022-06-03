
package io.fabric8.certmanager.api.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import io.fabric8.certmanager.api.model.acme.v1alpha2.ACMEAuthorization;
import io.fabric8.certmanager.api.model.acme.v1alpha2.ACMEChallenge;
import io.fabric8.certmanager.api.model.acme.v1alpha2.ACMEChallengeSolver;
import io.fabric8.certmanager.api.model.acme.v1alpha2.ACMEChallengeSolverDNS01;
import io.fabric8.certmanager.api.model.acme.v1alpha2.ACMEChallengeSolverHTTP01;
import io.fabric8.certmanager.api.model.acme.v1alpha2.ACMEChallengeSolverHTTP01Ingress;
import io.fabric8.certmanager.api.model.acme.v1alpha2.ACMEChallengeSolverHTTP01IngressObjectMeta;
import io.fabric8.certmanager.api.model.acme.v1alpha2.ACMEChallengeSolverHTTP01IngressPodObjectMeta;
import io.fabric8.certmanager.api.model.acme.v1alpha2.ACMEChallengeSolverHTTP01IngressPodSpec;
import io.fabric8.certmanager.api.model.acme.v1alpha2.ACMEChallengeSolverHTTP01IngressPodTemplate;
import io.fabric8.certmanager.api.model.acme.v1alpha2.ACMEChallengeSolverHTTP01IngressTemplate;
import io.fabric8.certmanager.api.model.acme.v1alpha2.ACMEExternalAccountBinding;
import io.fabric8.certmanager.api.model.acme.v1alpha2.ACMEIssuer;
import io.fabric8.certmanager.api.model.acme.v1alpha2.ACMEIssuerDNS01ProviderAcmeDNS;
import io.fabric8.certmanager.api.model.acme.v1alpha2.ACMEIssuerDNS01ProviderAkamai;
import io.fabric8.certmanager.api.model.acme.v1alpha2.ACMEIssuerDNS01ProviderAzureDNS;
import io.fabric8.certmanager.api.model.acme.v1alpha2.ACMEIssuerDNS01ProviderCloudDNS;
import io.fabric8.certmanager.api.model.acme.v1alpha2.ACMEIssuerDNS01ProviderCloudflare;
import io.fabric8.certmanager.api.model.acme.v1alpha2.ACMEIssuerDNS01ProviderDigitalOcean;
import io.fabric8.certmanager.api.model.acme.v1alpha2.ACMEIssuerDNS01ProviderRFC2136;
import io.fabric8.certmanager.api.model.acme.v1alpha2.ACMEIssuerDNS01ProviderRoute53;
import io.fabric8.certmanager.api.model.acme.v1alpha2.ACMEIssuerDNS01ProviderWebhook;
import io.fabric8.certmanager.api.model.acme.v1alpha2.ACMEIssuerStatus;
import io.fabric8.certmanager.api.model.acme.v1alpha2.CertificateDNSNameSelector;
import io.fabric8.certmanager.api.model.acme.v1alpha2.Challenge;
import io.fabric8.certmanager.api.model.acme.v1alpha2.ChallengeList;
import io.fabric8.certmanager.api.model.acme.v1alpha2.ChallengeSpec;
import io.fabric8.certmanager.api.model.acme.v1alpha2.ChallengeStatus;
import io.fabric8.certmanager.api.model.acme.v1alpha2.Order;
import io.fabric8.certmanager.api.model.acme.v1alpha2.OrderList;
import io.fabric8.certmanager.api.model.acme.v1alpha2.OrderSpec;
import io.fabric8.certmanager.api.model.acme.v1alpha2.OrderStatus;
import io.fabric8.certmanager.api.model.meta.v1.SecretKeySelector;
import io.fabric8.certmanager.api.model.v1alpha2.CAIssuer;
import io.fabric8.certmanager.api.model.v1alpha2.Certificate;
import io.fabric8.certmanager.api.model.v1alpha2.CertificateCondition;
import io.fabric8.certmanager.api.model.v1alpha2.CertificateKeystores;
import io.fabric8.certmanager.api.model.v1alpha2.CertificateList;
import io.fabric8.certmanager.api.model.v1alpha2.CertificatePrivateKey;
import io.fabric8.certmanager.api.model.v1alpha2.CertificateRequest;
import io.fabric8.certmanager.api.model.v1alpha2.CertificateRequestCondition;
import io.fabric8.certmanager.api.model.v1alpha2.CertificateRequestList;
import io.fabric8.certmanager.api.model.v1alpha2.CertificateRequestSpec;
import io.fabric8.certmanager.api.model.v1alpha2.CertificateRequestStatus;
import io.fabric8.certmanager.api.model.v1alpha2.CertificateSpec;
import io.fabric8.certmanager.api.model.v1alpha2.CertificateStatus;
import io.fabric8.certmanager.api.model.v1alpha2.ClusterIssuer;
import io.fabric8.certmanager.api.model.v1alpha2.ClusterIssuerList;
import io.fabric8.certmanager.api.model.v1alpha2.Issuer;
import io.fabric8.certmanager.api.model.v1alpha2.IssuerCondition;
import io.fabric8.certmanager.api.model.v1alpha2.IssuerList;
import io.fabric8.certmanager.api.model.v1alpha2.IssuerSpec;
import io.fabric8.certmanager.api.model.v1alpha2.IssuerStatus;
import io.fabric8.certmanager.api.model.v1alpha2.JKSKeystore;
import io.fabric8.certmanager.api.model.v1alpha2.PKCS12Keystore;
import io.fabric8.certmanager.api.model.v1alpha2.SelfSignedIssuer;
import io.fabric8.certmanager.api.model.v1alpha2.VaultAppRole;
import io.fabric8.certmanager.api.model.v1alpha2.VaultAuth;
import io.fabric8.certmanager.api.model.v1alpha2.VaultIssuer;
import io.fabric8.certmanager.api.model.v1alpha2.VaultKubernetesAuth;
import io.fabric8.certmanager.api.model.v1alpha2.VenafiCloud;
import io.fabric8.certmanager.api.model.v1alpha2.VenafiIssuer;
import io.fabric8.certmanager.api.model.v1alpha2.VenafiTPP;
import io.fabric8.certmanager.api.model.v1alpha2.X509Subject;
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
    "github_com_jetstack_cert-manager_pkg_apis_acme_v1alpha2_ACMEAuthorization",
    "github_com_jetstack_cert-manager_pkg_apis_acme_v1alpha2_ACMEChallenge",
    "github_com_jetstack_cert-manager_pkg_apis_acme_v1alpha2_ACMEChallengeSolver",
    "github_com_jetstack_cert-manager_pkg_apis_acme_v1alpha2_ACMEChallengeSolverDNS01",
    "github_com_jetstack_cert-manager_pkg_apis_acme_v1alpha2_ACMEChallengeSolverHTTP01",
    "github_com_jetstack_cert-manager_pkg_apis_acme_v1alpha2_ACMEChallengeSolverHTTP01Ingress",
    "github_com_jetstack_cert-manager_pkg_apis_acme_v1alpha2_ACMEChallengeSolverHTTP01IngressObjectMeta",
    "github_com_jetstack_cert-manager_pkg_apis_acme_v1alpha2_ACMEChallengeSolverHTTP01IngressPodObjectMeta",
    "github_com_jetstack_cert-manager_pkg_apis_acme_v1alpha2_ACMEChallengeSolverHTTP01IngressPodSpec",
    "github_com_jetstack_cert-manager_pkg_apis_acme_v1alpha2_ACMEChallengeSolverHTTP01IngressPodTemplate",
    "github_com_jetstack_cert-manager_pkg_apis_acme_v1alpha2_ACMEChallengeSolverHTTP01IngressTemplate",
    "github_com_jetstack_cert-manager_pkg_apis_acme_v1alpha2_ACMEExternalAccountBinding",
    "github_com_jetstack_cert-manager_pkg_apis_acme_v1alpha2_ACMEIssuer",
    "github_com_jetstack_cert-manager_pkg_apis_acme_v1alpha2_ACMEIssuerDNS01ProviderAcmeDNS",
    "github_com_jetstack_cert-manager_pkg_apis_acme_v1alpha2_ACMEIssuerDNS01ProviderAkamai",
    "github_com_jetstack_cert-manager_pkg_apis_acme_v1alpha2_ACMEIssuerDNS01ProviderAzureDNS",
    "github_com_jetstack_cert-manager_pkg_apis_acme_v1alpha2_ACMEIssuerDNS01ProviderCloudDNS",
    "github_com_jetstack_cert-manager_pkg_apis_acme_v1alpha2_ACMEIssuerDNS01ProviderCloudflare",
    "github_com_jetstack_cert-manager_pkg_apis_acme_v1alpha2_ACMEIssuerDNS01ProviderDigitalOcean",
    "github_com_jetstack_cert-manager_pkg_apis_acme_v1alpha2_ACMEIssuerDNS01ProviderRFC2136",
    "github_com_jetstack_cert-manager_pkg_apis_acme_v1alpha2_ACMEIssuerDNS01ProviderRoute53",
    "github_com_jetstack_cert-manager_pkg_apis_acme_v1alpha2_ACMEIssuerDNS01ProviderWebhook",
    "github_com_jetstack_cert-manager_pkg_apis_acme_v1alpha2_ACMEIssuerStatus",
    "github_com_jetstack_cert-manager_pkg_apis_acme_v1alpha2_CertificateDNSNameSelector",
    "github_com_jetstack_cert-manager_pkg_apis_acme_v1alpha2_Challenge",
    "github_com_jetstack_cert-manager_pkg_apis_acme_v1alpha2_ChallengeList",
    "github_com_jetstack_cert-manager_pkg_apis_acme_v1alpha2_ChallengeSpec",
    "github_com_jetstack_cert-manager_pkg_apis_acme_v1alpha2_ChallengeStatus",
    "github_com_jetstack_cert-manager_pkg_apis_acme_v1alpha2_Order",
    "github_com_jetstack_cert-manager_pkg_apis_acme_v1alpha2_OrderList",
    "github_com_jetstack_cert-manager_pkg_apis_acme_v1alpha2_OrderSpec",
    "github_com_jetstack_cert-manager_pkg_apis_acme_v1alpha2_OrderStatus",
    "github_com_jetstack_cert-manager_pkg_apis_certmanager_v1alpha2_CAIssuer",
    "github_com_jetstack_cert-manager_pkg_apis_certmanager_v1alpha2_Certificate",
    "github_com_jetstack_cert-manager_pkg_apis_certmanager_v1alpha2_CertificateCondition",
    "github_com_jetstack_cert-manager_pkg_apis_certmanager_v1alpha2_CertificateKeystores",
    "github_com_jetstack_cert-manager_pkg_apis_certmanager_v1alpha2_CertificateList",
    "github_com_jetstack_cert-manager_pkg_apis_certmanager_v1alpha2_CertificatePrivateKey",
    "github_com_jetstack_cert-manager_pkg_apis_certmanager_v1alpha2_CertificateRequest",
    "github_com_jetstack_cert-manager_pkg_apis_certmanager_v1alpha2_CertificateRequestCondition",
    "github_com_jetstack_cert-manager_pkg_apis_certmanager_v1alpha2_CertificateRequestList",
    "github_com_jetstack_cert-manager_pkg_apis_certmanager_v1alpha2_CertificateRequestSpec",
    "github_com_jetstack_cert-manager_pkg_apis_certmanager_v1alpha2_CertificateRequestStatus",
    "github_com_jetstack_cert-manager_pkg_apis_certmanager_v1alpha2_CertificateSpec",
    "github_com_jetstack_cert-manager_pkg_apis_certmanager_v1alpha2_CertificateStatus",
    "github_com_jetstack_cert-manager_pkg_apis_certmanager_v1alpha2_ClusterIssuer",
    "github_com_jetstack_cert-manager_pkg_apis_certmanager_v1alpha2_ClusterIssuerList",
    "github_com_jetstack_cert-manager_pkg_apis_certmanager_v1alpha2_Issuer",
    "github_com_jetstack_cert-manager_pkg_apis_certmanager_v1alpha2_IssuerCondition",
    "github_com_jetstack_cert-manager_pkg_apis_certmanager_v1alpha2_IssuerList",
    "github_com_jetstack_cert-manager_pkg_apis_certmanager_v1alpha2_IssuerSpec",
    "github_com_jetstack_cert-manager_pkg_apis_certmanager_v1alpha2_IssuerStatus",
    "github_com_jetstack_cert-manager_pkg_apis_certmanager_v1alpha2_JKSKeystore",
    "github_com_jetstack_cert-manager_pkg_apis_certmanager_v1alpha2_PKCS12Keystore",
    "github_com_jetstack_cert-manager_pkg_apis_certmanager_v1alpha2_SelfSignedIssuer",
    "github_com_jetstack_cert-manager_pkg_apis_certmanager_v1alpha2_VaultAppRole",
    "github_com_jetstack_cert-manager_pkg_apis_certmanager_v1alpha2_VaultAuth",
    "github_com_jetstack_cert-manager_pkg_apis_certmanager_v1alpha2_VaultIssuer",
    "github_com_jetstack_cert-manager_pkg_apis_certmanager_v1alpha2_VaultKubernetesAuth",
    "github_com_jetstack_cert-manager_pkg_apis_certmanager_v1alpha2_VenafiCloud",
    "github_com_jetstack_cert-manager_pkg_apis_certmanager_v1alpha2_VenafiIssuer",
    "github_com_jetstack_cert-manager_pkg_apis_certmanager_v1alpha2_VenafiTPP",
    "github_com_jetstack_cert-manager_pkg_apis_certmanager_v1alpha2_X509Subject",
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

    @JsonProperty("github_com_jetstack_cert-manager_pkg_apis_acme_v1alpha2_ACMEAuthorization")
    private ACMEAuthorization githubComJetstackCertManagerPkgApisAcmeV1alpha2ACMEAuthorization;
    @JsonProperty("github_com_jetstack_cert-manager_pkg_apis_acme_v1alpha2_ACMEChallenge")
    private ACMEChallenge githubComJetstackCertManagerPkgApisAcmeV1alpha2ACMEChallenge;
    @JsonProperty("github_com_jetstack_cert-manager_pkg_apis_acme_v1alpha2_ACMEChallengeSolver")
    private ACMEChallengeSolver githubComJetstackCertManagerPkgApisAcmeV1alpha2ACMEChallengeSolver;
    @JsonProperty("github_com_jetstack_cert-manager_pkg_apis_acme_v1alpha2_ACMEChallengeSolverDNS01")
    private ACMEChallengeSolverDNS01 githubComJetstackCertManagerPkgApisAcmeV1alpha2ACMEChallengeSolverDNS01;
    @JsonProperty("github_com_jetstack_cert-manager_pkg_apis_acme_v1alpha2_ACMEChallengeSolverHTTP01")
    private ACMEChallengeSolverHTTP01 githubComJetstackCertManagerPkgApisAcmeV1alpha2ACMEChallengeSolverHTTP01;
    @JsonProperty("github_com_jetstack_cert-manager_pkg_apis_acme_v1alpha2_ACMEChallengeSolverHTTP01Ingress")
    private ACMEChallengeSolverHTTP01Ingress githubComJetstackCertManagerPkgApisAcmeV1alpha2ACMEChallengeSolverHTTP01Ingress;
    @JsonProperty("github_com_jetstack_cert-manager_pkg_apis_acme_v1alpha2_ACMEChallengeSolverHTTP01IngressObjectMeta")
    private ACMEChallengeSolverHTTP01IngressObjectMeta githubComJetstackCertManagerPkgApisAcmeV1alpha2ACMEChallengeSolverHTTP01IngressObjectMeta;
    @JsonProperty("github_com_jetstack_cert-manager_pkg_apis_acme_v1alpha2_ACMEChallengeSolverHTTP01IngressPodObjectMeta")
    private ACMEChallengeSolverHTTP01IngressPodObjectMeta githubComJetstackCertManagerPkgApisAcmeV1alpha2ACMEChallengeSolverHTTP01IngressPodObjectMeta;
    @JsonProperty("github_com_jetstack_cert-manager_pkg_apis_acme_v1alpha2_ACMEChallengeSolverHTTP01IngressPodSpec")
    private ACMEChallengeSolverHTTP01IngressPodSpec githubComJetstackCertManagerPkgApisAcmeV1alpha2ACMEChallengeSolverHTTP01IngressPodSpec;
    @JsonProperty("github_com_jetstack_cert-manager_pkg_apis_acme_v1alpha2_ACMEChallengeSolverHTTP01IngressPodTemplate")
    private ACMEChallengeSolverHTTP01IngressPodTemplate githubComJetstackCertManagerPkgApisAcmeV1alpha2ACMEChallengeSolverHTTP01IngressPodTemplate;
    @JsonProperty("github_com_jetstack_cert-manager_pkg_apis_acme_v1alpha2_ACMEChallengeSolverHTTP01IngressTemplate")
    private ACMEChallengeSolverHTTP01IngressTemplate githubComJetstackCertManagerPkgApisAcmeV1alpha2ACMEChallengeSolverHTTP01IngressTemplate;
    @JsonProperty("github_com_jetstack_cert-manager_pkg_apis_acme_v1alpha2_ACMEExternalAccountBinding")
    private ACMEExternalAccountBinding githubComJetstackCertManagerPkgApisAcmeV1alpha2ACMEExternalAccountBinding;
    @JsonProperty("github_com_jetstack_cert-manager_pkg_apis_acme_v1alpha2_ACMEIssuer")
    private ACMEIssuer githubComJetstackCertManagerPkgApisAcmeV1alpha2ACMEIssuer;
    @JsonProperty("github_com_jetstack_cert-manager_pkg_apis_acme_v1alpha2_ACMEIssuerDNS01ProviderAcmeDNS")
    private ACMEIssuerDNS01ProviderAcmeDNS githubComJetstackCertManagerPkgApisAcmeV1alpha2ACMEIssuerDNS01ProviderAcmeDNS;
    @JsonProperty("github_com_jetstack_cert-manager_pkg_apis_acme_v1alpha2_ACMEIssuerDNS01ProviderAkamai")
    private ACMEIssuerDNS01ProviderAkamai githubComJetstackCertManagerPkgApisAcmeV1alpha2ACMEIssuerDNS01ProviderAkamai;
    @JsonProperty("github_com_jetstack_cert-manager_pkg_apis_acme_v1alpha2_ACMEIssuerDNS01ProviderAzureDNS")
    private ACMEIssuerDNS01ProviderAzureDNS githubComJetstackCertManagerPkgApisAcmeV1alpha2ACMEIssuerDNS01ProviderAzureDNS;
    @JsonProperty("github_com_jetstack_cert-manager_pkg_apis_acme_v1alpha2_ACMEIssuerDNS01ProviderCloudDNS")
    private ACMEIssuerDNS01ProviderCloudDNS githubComJetstackCertManagerPkgApisAcmeV1alpha2ACMEIssuerDNS01ProviderCloudDNS;
    @JsonProperty("github_com_jetstack_cert-manager_pkg_apis_acme_v1alpha2_ACMEIssuerDNS01ProviderCloudflare")
    private ACMEIssuerDNS01ProviderCloudflare githubComJetstackCertManagerPkgApisAcmeV1alpha2ACMEIssuerDNS01ProviderCloudflare;
    @JsonProperty("github_com_jetstack_cert-manager_pkg_apis_acme_v1alpha2_ACMEIssuerDNS01ProviderDigitalOcean")
    private ACMEIssuerDNS01ProviderDigitalOcean githubComJetstackCertManagerPkgApisAcmeV1alpha2ACMEIssuerDNS01ProviderDigitalOcean;
    @JsonProperty("github_com_jetstack_cert-manager_pkg_apis_acme_v1alpha2_ACMEIssuerDNS01ProviderRFC2136")
    private ACMEIssuerDNS01ProviderRFC2136 githubComJetstackCertManagerPkgApisAcmeV1alpha2ACMEIssuerDNS01ProviderRFC2136;
    @JsonProperty("github_com_jetstack_cert-manager_pkg_apis_acme_v1alpha2_ACMEIssuerDNS01ProviderRoute53")
    private ACMEIssuerDNS01ProviderRoute53 githubComJetstackCertManagerPkgApisAcmeV1alpha2ACMEIssuerDNS01ProviderRoute53;
    @JsonProperty("github_com_jetstack_cert-manager_pkg_apis_acme_v1alpha2_ACMEIssuerDNS01ProviderWebhook")
    private ACMEIssuerDNS01ProviderWebhook githubComJetstackCertManagerPkgApisAcmeV1alpha2ACMEIssuerDNS01ProviderWebhook;
    @JsonProperty("github_com_jetstack_cert-manager_pkg_apis_acme_v1alpha2_ACMEIssuerStatus")
    private ACMEIssuerStatus githubComJetstackCertManagerPkgApisAcmeV1alpha2ACMEIssuerStatus;
    @JsonProperty("github_com_jetstack_cert-manager_pkg_apis_acme_v1alpha2_CertificateDNSNameSelector")
    private CertificateDNSNameSelector githubComJetstackCertManagerPkgApisAcmeV1alpha2CertificateDNSNameSelector;
    @JsonProperty("github_com_jetstack_cert-manager_pkg_apis_acme_v1alpha2_Challenge")
    private Challenge githubComJetstackCertManagerPkgApisAcmeV1alpha2Challenge;
    @JsonProperty("github_com_jetstack_cert-manager_pkg_apis_acme_v1alpha2_ChallengeList")
    private ChallengeList githubComJetstackCertManagerPkgApisAcmeV1alpha2ChallengeList;
    @JsonProperty("github_com_jetstack_cert-manager_pkg_apis_acme_v1alpha2_ChallengeSpec")
    private ChallengeSpec githubComJetstackCertManagerPkgApisAcmeV1alpha2ChallengeSpec;
    @JsonProperty("github_com_jetstack_cert-manager_pkg_apis_acme_v1alpha2_ChallengeStatus")
    private ChallengeStatus githubComJetstackCertManagerPkgApisAcmeV1alpha2ChallengeStatus;
    @JsonProperty("github_com_jetstack_cert-manager_pkg_apis_acme_v1alpha2_Order")
    private Order githubComJetstackCertManagerPkgApisAcmeV1alpha2Order;
    @JsonProperty("github_com_jetstack_cert-manager_pkg_apis_acme_v1alpha2_OrderList")
    private OrderList githubComJetstackCertManagerPkgApisAcmeV1alpha2OrderList;
    @JsonProperty("github_com_jetstack_cert-manager_pkg_apis_acme_v1alpha2_OrderSpec")
    private OrderSpec githubComJetstackCertManagerPkgApisAcmeV1alpha2OrderSpec;
    @JsonProperty("github_com_jetstack_cert-manager_pkg_apis_acme_v1alpha2_OrderStatus")
    private OrderStatus githubComJetstackCertManagerPkgApisAcmeV1alpha2OrderStatus;
    @JsonProperty("github_com_jetstack_cert-manager_pkg_apis_certmanager_v1alpha2_CAIssuer")
    private CAIssuer githubComJetstackCertManagerPkgApisCertmanagerV1alpha2CAIssuer;
    @JsonProperty("github_com_jetstack_cert-manager_pkg_apis_certmanager_v1alpha2_Certificate")
    private Certificate githubComJetstackCertManagerPkgApisCertmanagerV1alpha2Certificate;
    @JsonProperty("github_com_jetstack_cert-manager_pkg_apis_certmanager_v1alpha2_CertificateCondition")
    private CertificateCondition githubComJetstackCertManagerPkgApisCertmanagerV1alpha2CertificateCondition;
    @JsonProperty("github_com_jetstack_cert-manager_pkg_apis_certmanager_v1alpha2_CertificateKeystores")
    private CertificateKeystores githubComJetstackCertManagerPkgApisCertmanagerV1alpha2CertificateKeystores;
    @JsonProperty("github_com_jetstack_cert-manager_pkg_apis_certmanager_v1alpha2_CertificateList")
    private CertificateList githubComJetstackCertManagerPkgApisCertmanagerV1alpha2CertificateList;
    @JsonProperty("github_com_jetstack_cert-manager_pkg_apis_certmanager_v1alpha2_CertificatePrivateKey")
    private CertificatePrivateKey githubComJetstackCertManagerPkgApisCertmanagerV1alpha2CertificatePrivateKey;
    @JsonProperty("github_com_jetstack_cert-manager_pkg_apis_certmanager_v1alpha2_CertificateRequest")
    private CertificateRequest githubComJetstackCertManagerPkgApisCertmanagerV1alpha2CertificateRequest;
    @JsonProperty("github_com_jetstack_cert-manager_pkg_apis_certmanager_v1alpha2_CertificateRequestCondition")
    private CertificateRequestCondition githubComJetstackCertManagerPkgApisCertmanagerV1alpha2CertificateRequestCondition;
    @JsonProperty("github_com_jetstack_cert-manager_pkg_apis_certmanager_v1alpha2_CertificateRequestList")
    private CertificateRequestList githubComJetstackCertManagerPkgApisCertmanagerV1alpha2CertificateRequestList;
    @JsonProperty("github_com_jetstack_cert-manager_pkg_apis_certmanager_v1alpha2_CertificateRequestSpec")
    private CertificateRequestSpec githubComJetstackCertManagerPkgApisCertmanagerV1alpha2CertificateRequestSpec;
    @JsonProperty("github_com_jetstack_cert-manager_pkg_apis_certmanager_v1alpha2_CertificateRequestStatus")
    private CertificateRequestStatus githubComJetstackCertManagerPkgApisCertmanagerV1alpha2CertificateRequestStatus;
    @JsonProperty("github_com_jetstack_cert-manager_pkg_apis_certmanager_v1alpha2_CertificateSpec")
    private CertificateSpec githubComJetstackCertManagerPkgApisCertmanagerV1alpha2CertificateSpec;
    @JsonProperty("github_com_jetstack_cert-manager_pkg_apis_certmanager_v1alpha2_CertificateStatus")
    private CertificateStatus githubComJetstackCertManagerPkgApisCertmanagerV1alpha2CertificateStatus;
    @JsonProperty("github_com_jetstack_cert-manager_pkg_apis_certmanager_v1alpha2_ClusterIssuer")
    private ClusterIssuer githubComJetstackCertManagerPkgApisCertmanagerV1alpha2ClusterIssuer;
    @JsonProperty("github_com_jetstack_cert-manager_pkg_apis_certmanager_v1alpha2_ClusterIssuerList")
    private ClusterIssuerList githubComJetstackCertManagerPkgApisCertmanagerV1alpha2ClusterIssuerList;
    @JsonProperty("github_com_jetstack_cert-manager_pkg_apis_certmanager_v1alpha2_Issuer")
    private Issuer githubComJetstackCertManagerPkgApisCertmanagerV1alpha2Issuer;
    @JsonProperty("github_com_jetstack_cert-manager_pkg_apis_certmanager_v1alpha2_IssuerCondition")
    private IssuerCondition githubComJetstackCertManagerPkgApisCertmanagerV1alpha2IssuerCondition;
    @JsonProperty("github_com_jetstack_cert-manager_pkg_apis_certmanager_v1alpha2_IssuerList")
    private IssuerList githubComJetstackCertManagerPkgApisCertmanagerV1alpha2IssuerList;
    @JsonProperty("github_com_jetstack_cert-manager_pkg_apis_certmanager_v1alpha2_IssuerSpec")
    private IssuerSpec githubComJetstackCertManagerPkgApisCertmanagerV1alpha2IssuerSpec;
    @JsonProperty("github_com_jetstack_cert-manager_pkg_apis_certmanager_v1alpha2_IssuerStatus")
    private IssuerStatus githubComJetstackCertManagerPkgApisCertmanagerV1alpha2IssuerStatus;
    @JsonProperty("github_com_jetstack_cert-manager_pkg_apis_certmanager_v1alpha2_JKSKeystore")
    private JKSKeystore githubComJetstackCertManagerPkgApisCertmanagerV1alpha2JKSKeystore;
    @JsonProperty("github_com_jetstack_cert-manager_pkg_apis_certmanager_v1alpha2_PKCS12Keystore")
    private PKCS12Keystore githubComJetstackCertManagerPkgApisCertmanagerV1alpha2PKCS12Keystore;
    @JsonProperty("github_com_jetstack_cert-manager_pkg_apis_certmanager_v1alpha2_SelfSignedIssuer")
    private SelfSignedIssuer githubComJetstackCertManagerPkgApisCertmanagerV1alpha2SelfSignedIssuer;
    @JsonProperty("github_com_jetstack_cert-manager_pkg_apis_certmanager_v1alpha2_VaultAppRole")
    private VaultAppRole githubComJetstackCertManagerPkgApisCertmanagerV1alpha2VaultAppRole;
    @JsonProperty("github_com_jetstack_cert-manager_pkg_apis_certmanager_v1alpha2_VaultAuth")
    private VaultAuth githubComJetstackCertManagerPkgApisCertmanagerV1alpha2VaultAuth;
    @JsonProperty("github_com_jetstack_cert-manager_pkg_apis_certmanager_v1alpha2_VaultIssuer")
    private VaultIssuer githubComJetstackCertManagerPkgApisCertmanagerV1alpha2VaultIssuer;
    @JsonProperty("github_com_jetstack_cert-manager_pkg_apis_certmanager_v1alpha2_VaultKubernetesAuth")
    private VaultKubernetesAuth githubComJetstackCertManagerPkgApisCertmanagerV1alpha2VaultKubernetesAuth;
    @JsonProperty("github_com_jetstack_cert-manager_pkg_apis_certmanager_v1alpha2_VenafiCloud")
    private VenafiCloud githubComJetstackCertManagerPkgApisCertmanagerV1alpha2VenafiCloud;
    @JsonProperty("github_com_jetstack_cert-manager_pkg_apis_certmanager_v1alpha2_VenafiIssuer")
    private VenafiIssuer githubComJetstackCertManagerPkgApisCertmanagerV1alpha2VenafiIssuer;
    @JsonProperty("github_com_jetstack_cert-manager_pkg_apis_certmanager_v1alpha2_VenafiTPP")
    private VenafiTPP githubComJetstackCertManagerPkgApisCertmanagerV1alpha2VenafiTPP;
    @JsonProperty("github_com_jetstack_cert-manager_pkg_apis_certmanager_v1alpha2_X509Subject")
    private X509Subject githubComJetstackCertManagerPkgApisCertmanagerV1alpha2X509Subject;
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
     * @param githubComJetstackCertManagerPkgApisAcmeV1alpha2ACMEIssuerDNS01ProviderRoute53
     * @param githubComJetstackCertManagerPkgApisAcmeV1alpha2ACMEChallengeSolverHTTP01IngressPodTemplate
     * @param githubComJetstackCertManagerPkgApisCertmanagerV1alpha2IssuerSpec
     * @param githubComJetstackCertManagerPkgApisAcmeV1alpha2ACMEAuthorization
     * @param githubComJetstackCertManagerPkgApisAcmeV1alpha2ACMEIssuer
     * @param githubComJetstackCertManagerPkgApisAcmeV1alpha2ACMEIssuerDNS01ProviderAzureDNS
     * @param githubComJetstackCertManagerPkgApisAcmeV1alpha2ACMEIssuerDNS01ProviderCloudDNS
     * @param githubComJetstackCertManagerPkgApisAcmeV1alpha2ACMEChallengeSolverHTTP01IngressObjectMeta
     * @param githubComJetstackCertManagerPkgApisCertmanagerV1alpha2IssuerCondition
     * @param githubComJetstackCertManagerPkgApisAcmeV1alpha2ACMEIssuerDNS01ProviderWebhook
     * @param githubComJetstackCertManagerPkgApisCertmanagerV1alpha2CertificateRequestSpec
     * @param githubComJetstackCertManagerPkgApisCertmanagerV1alpha2VenafiTPP
     * @param githubComJetstackCertManagerPkgApisAcmeV1alpha2ACMEIssuerDNS01ProviderAkamai
     * @param githubComJetstackCertManagerPkgApisAcmeV1alpha2OrderStatus
     * @param githubComJetstackCertManagerPkgApisAcmeV1alpha2ChallengeSpec
     * @param githubComJetstackCertManagerPkgApisCertmanagerV1alpha2CertificateCondition
     * @param githubComJetstackCertManagerPkgApisCertmanagerV1alpha2Issuer
     * @param githubComJetstackCertManagerPkgApisAcmeV1alpha2ACMEChallengeSolverDNS01
     * @param githubComJetstackCertManagerPkgApisCertmanagerV1alpha2CertificateSpec
     * @param githubComJetstackCertManagerPkgApisCertmanagerV1alpha2SelfSignedIssuer
     * @param githubComJetstackCertManagerPkgApisCertmanagerV1alpha2CertificateRequestCondition
     * @param githubComJetstackCertManagerPkgApisCertmanagerV1alpha2Certificate
     * @param githubComJetstackCertManagerPkgApisCertmanagerV1alpha2IssuerList
     * @param githubComJetstackCertManagerPkgApisAcmeV1alpha2OrderSpec
     * @param githubComJetstackCertManagerPkgApisCertmanagerV1alpha2VaultKubernetesAuth
     * @param githubComJetstackCertManagerPkgApisCertmanagerV1alpha2CertificateStatus
     * @param githubComJetstackCertManagerPkgApisCertmanagerV1alpha2ClusterIssuer
     * @param githubComJetstackCertManagerPkgApisCertmanagerV1alpha2CertificateKeystores
     * @param githubComJetstackCertManagerPkgApisCertmanagerV1alpha2VaultAuth
     * @param githubComJetstackCertManagerPkgApisCertmanagerV1alpha2CAIssuer
     * @param githubComJetstackCertManagerPkgApisAcmeV1alpha2Order
     * @param githubComJetstackCertManagerPkgApisMetaV1ObjectReference
     * @param githubComJetstackCertManagerPkgApisCertmanagerV1alpha2CertificateRequestStatus
     * @param githubComJetstackCertManagerPkgApisCertmanagerV1alpha2CertificateRequestList
     * @param githubComJetstackCertManagerPkgApisAcmeV1alpha2OrderList
     * @param githubComJetstackCertManagerPkgApisMetaV1SecretKeySelector
     * @param githubComJetstackCertManagerPkgApisAcmeV1alpha2ACMEIssuerStatus
     * @param githubComJetstackCertManagerPkgApisAcmeV1alpha2CertificateDNSNameSelector
     * @param githubComJetstackCertManagerPkgApisAcmeV1alpha2ACMEIssuerDNS01ProviderRFC2136
     * @param githubComJetstackCertManagerPkgApisCertmanagerV1alpha2X509Subject
     * @param githubComJetstackCertManagerPkgApisCertmanagerV1alpha2IssuerStatus
     * @param githubComJetstackCertManagerPkgApisCertmanagerV1alpha2VenafiIssuer
     * @param githubComJetstackCertManagerPkgApisCertmanagerV1alpha2CertificatePrivateKey
     * @param githubComJetstackCertManagerPkgApisAcmeV1alpha2ACMEIssuerDNS01ProviderDigitalOcean
     * @param githubComJetstackCertManagerPkgApisCertmanagerV1alpha2ClusterIssuerList
     * @param githubComJetstackCertManagerPkgApisCertmanagerV1alpha2VaultIssuer
     * @param githubComJetstackCertManagerPkgApisCertmanagerV1alpha2VenafiCloud
     * @param githubComJetstackCertManagerPkgApisAcmeV1alpha2ACMEChallengeSolverHTTP01Ingress
     * @param githubComJetstackCertManagerPkgApisAcmeV1alpha2ACMEExternalAccountBinding
     * @param githubComJetstackCertManagerPkgApisCertmanagerV1alpha2PKCS12Keystore
     * @param githubComJetstackCertManagerPkgApisAcmeV1alpha2ACMEChallengeSolverHTTP01
     * @param githubComJetstackCertManagerPkgApisAcmeV1alpha2ACMEChallengeSolver
     * @param githubComJetstackCertManagerPkgApisAcmeV1alpha2ACMEChallengeSolverHTTP01IngressPodObjectMeta
     * @param githubComJetstackCertManagerPkgApisCertmanagerV1alpha2VaultAppRole
     * @param githubComJetstackCertManagerPkgApisCertmanagerV1alpha2CertificateRequest
     * @param githubComJetstackCertManagerPkgApisAcmeV1alpha2ACMEChallengeSolverHTTP01IngressTemplate
     * @param githubComJetstackCertManagerPkgApisAcmeV1alpha2ACMEIssuerDNS01ProviderAcmeDNS
     * @param githubComJetstackCertManagerPkgApisAcmeV1alpha2ChallengeStatus
     * @param githubComJetstackCertManagerPkgApisCertmanagerV1alpha2JKSKeystore
     * @param githubComJetstackCertManagerPkgApisMetaV1LocalObjectReference
     * @param githubComJetstackCertManagerPkgApisAcmeV1alpha2Challenge
     * @param githubComJetstackCertManagerPkgApisAcmeV1alpha2ACMEIssuerDNS01ProviderCloudflare
     * @param githubComJetstackCertManagerPkgApisAcmeV1alpha2ChallengeList
     * @param githubComJetstackCertManagerPkgApisCertmanagerV1alpha2CertificateList
     * @param githubComJetstackCertManagerPkgApisAcmeV1alpha2ACMEChallenge
     * @param githubComJetstackCertManagerPkgApisAcmeV1alpha2ACMEChallengeSolverHTTP01IngressPodSpec
     */
    public CertmanagerSchema(ACMEAuthorization githubComJetstackCertManagerPkgApisAcmeV1alpha2ACMEAuthorization, ACMEChallenge githubComJetstackCertManagerPkgApisAcmeV1alpha2ACMEChallenge, ACMEChallengeSolver githubComJetstackCertManagerPkgApisAcmeV1alpha2ACMEChallengeSolver, ACMEChallengeSolverDNS01 githubComJetstackCertManagerPkgApisAcmeV1alpha2ACMEChallengeSolverDNS01, ACMEChallengeSolverHTTP01 githubComJetstackCertManagerPkgApisAcmeV1alpha2ACMEChallengeSolverHTTP01, ACMEChallengeSolverHTTP01Ingress githubComJetstackCertManagerPkgApisAcmeV1alpha2ACMEChallengeSolverHTTP01Ingress, ACMEChallengeSolverHTTP01IngressObjectMeta githubComJetstackCertManagerPkgApisAcmeV1alpha2ACMEChallengeSolverHTTP01IngressObjectMeta, ACMEChallengeSolverHTTP01IngressPodObjectMeta githubComJetstackCertManagerPkgApisAcmeV1alpha2ACMEChallengeSolverHTTP01IngressPodObjectMeta, ACMEChallengeSolverHTTP01IngressPodSpec githubComJetstackCertManagerPkgApisAcmeV1alpha2ACMEChallengeSolverHTTP01IngressPodSpec, ACMEChallengeSolverHTTP01IngressPodTemplate githubComJetstackCertManagerPkgApisAcmeV1alpha2ACMEChallengeSolverHTTP01IngressPodTemplate, ACMEChallengeSolverHTTP01IngressTemplate githubComJetstackCertManagerPkgApisAcmeV1alpha2ACMEChallengeSolverHTTP01IngressTemplate, ACMEExternalAccountBinding githubComJetstackCertManagerPkgApisAcmeV1alpha2ACMEExternalAccountBinding, ACMEIssuer githubComJetstackCertManagerPkgApisAcmeV1alpha2ACMEIssuer, ACMEIssuerDNS01ProviderAcmeDNS githubComJetstackCertManagerPkgApisAcmeV1alpha2ACMEIssuerDNS01ProviderAcmeDNS, ACMEIssuerDNS01ProviderAkamai githubComJetstackCertManagerPkgApisAcmeV1alpha2ACMEIssuerDNS01ProviderAkamai, ACMEIssuerDNS01ProviderAzureDNS githubComJetstackCertManagerPkgApisAcmeV1alpha2ACMEIssuerDNS01ProviderAzureDNS, ACMEIssuerDNS01ProviderCloudDNS githubComJetstackCertManagerPkgApisAcmeV1alpha2ACMEIssuerDNS01ProviderCloudDNS, ACMEIssuerDNS01ProviderCloudflare githubComJetstackCertManagerPkgApisAcmeV1alpha2ACMEIssuerDNS01ProviderCloudflare, ACMEIssuerDNS01ProviderDigitalOcean githubComJetstackCertManagerPkgApisAcmeV1alpha2ACMEIssuerDNS01ProviderDigitalOcean, ACMEIssuerDNS01ProviderRFC2136 githubComJetstackCertManagerPkgApisAcmeV1alpha2ACMEIssuerDNS01ProviderRFC2136, ACMEIssuerDNS01ProviderRoute53 githubComJetstackCertManagerPkgApisAcmeV1alpha2ACMEIssuerDNS01ProviderRoute53, ACMEIssuerDNS01ProviderWebhook githubComJetstackCertManagerPkgApisAcmeV1alpha2ACMEIssuerDNS01ProviderWebhook, ACMEIssuerStatus githubComJetstackCertManagerPkgApisAcmeV1alpha2ACMEIssuerStatus, CertificateDNSNameSelector githubComJetstackCertManagerPkgApisAcmeV1alpha2CertificateDNSNameSelector, Challenge githubComJetstackCertManagerPkgApisAcmeV1alpha2Challenge, ChallengeList githubComJetstackCertManagerPkgApisAcmeV1alpha2ChallengeList, ChallengeSpec githubComJetstackCertManagerPkgApisAcmeV1alpha2ChallengeSpec, ChallengeStatus githubComJetstackCertManagerPkgApisAcmeV1alpha2ChallengeStatus, Order githubComJetstackCertManagerPkgApisAcmeV1alpha2Order, OrderList githubComJetstackCertManagerPkgApisAcmeV1alpha2OrderList, OrderSpec githubComJetstackCertManagerPkgApisAcmeV1alpha2OrderSpec, OrderStatus githubComJetstackCertManagerPkgApisAcmeV1alpha2OrderStatus, CAIssuer githubComJetstackCertManagerPkgApisCertmanagerV1alpha2CAIssuer, Certificate githubComJetstackCertManagerPkgApisCertmanagerV1alpha2Certificate, CertificateCondition githubComJetstackCertManagerPkgApisCertmanagerV1alpha2CertificateCondition, CertificateKeystores githubComJetstackCertManagerPkgApisCertmanagerV1alpha2CertificateKeystores, CertificateList githubComJetstackCertManagerPkgApisCertmanagerV1alpha2CertificateList, CertificatePrivateKey githubComJetstackCertManagerPkgApisCertmanagerV1alpha2CertificatePrivateKey, CertificateRequest githubComJetstackCertManagerPkgApisCertmanagerV1alpha2CertificateRequest, CertificateRequestCondition githubComJetstackCertManagerPkgApisCertmanagerV1alpha2CertificateRequestCondition, CertificateRequestList githubComJetstackCertManagerPkgApisCertmanagerV1alpha2CertificateRequestList, CertificateRequestSpec githubComJetstackCertManagerPkgApisCertmanagerV1alpha2CertificateRequestSpec, CertificateRequestStatus githubComJetstackCertManagerPkgApisCertmanagerV1alpha2CertificateRequestStatus, CertificateSpec githubComJetstackCertManagerPkgApisCertmanagerV1alpha2CertificateSpec, CertificateStatus githubComJetstackCertManagerPkgApisCertmanagerV1alpha2CertificateStatus, ClusterIssuer githubComJetstackCertManagerPkgApisCertmanagerV1alpha2ClusterIssuer, ClusterIssuerList githubComJetstackCertManagerPkgApisCertmanagerV1alpha2ClusterIssuerList, Issuer githubComJetstackCertManagerPkgApisCertmanagerV1alpha2Issuer, IssuerCondition githubComJetstackCertManagerPkgApisCertmanagerV1alpha2IssuerCondition, IssuerList githubComJetstackCertManagerPkgApisCertmanagerV1alpha2IssuerList, IssuerSpec githubComJetstackCertManagerPkgApisCertmanagerV1alpha2IssuerSpec, IssuerStatus githubComJetstackCertManagerPkgApisCertmanagerV1alpha2IssuerStatus, JKSKeystore githubComJetstackCertManagerPkgApisCertmanagerV1alpha2JKSKeystore, PKCS12Keystore githubComJetstackCertManagerPkgApisCertmanagerV1alpha2PKCS12Keystore, SelfSignedIssuer githubComJetstackCertManagerPkgApisCertmanagerV1alpha2SelfSignedIssuer, VaultAppRole githubComJetstackCertManagerPkgApisCertmanagerV1alpha2VaultAppRole, VaultAuth githubComJetstackCertManagerPkgApisCertmanagerV1alpha2VaultAuth, VaultIssuer githubComJetstackCertManagerPkgApisCertmanagerV1alpha2VaultIssuer, VaultKubernetesAuth githubComJetstackCertManagerPkgApisCertmanagerV1alpha2VaultKubernetesAuth, VenafiCloud githubComJetstackCertManagerPkgApisCertmanagerV1alpha2VenafiCloud, VenafiIssuer githubComJetstackCertManagerPkgApisCertmanagerV1alpha2VenafiIssuer, VenafiTPP githubComJetstackCertManagerPkgApisCertmanagerV1alpha2VenafiTPP, X509Subject githubComJetstackCertManagerPkgApisCertmanagerV1alpha2X509Subject, io.fabric8.certmanager.api.model.meta.v1.LocalObjectReference githubComJetstackCertManagerPkgApisMetaV1LocalObjectReference, io.fabric8.certmanager.api.model.meta.v1.ObjectReference githubComJetstackCertManagerPkgApisMetaV1ObjectReference, SecretKeySelector githubComJetstackCertManagerPkgApisMetaV1SecretKeySelector) {
        super();
        this.githubComJetstackCertManagerPkgApisAcmeV1alpha2ACMEAuthorization = githubComJetstackCertManagerPkgApisAcmeV1alpha2ACMEAuthorization;
        this.githubComJetstackCertManagerPkgApisAcmeV1alpha2ACMEChallenge = githubComJetstackCertManagerPkgApisAcmeV1alpha2ACMEChallenge;
        this.githubComJetstackCertManagerPkgApisAcmeV1alpha2ACMEChallengeSolver = githubComJetstackCertManagerPkgApisAcmeV1alpha2ACMEChallengeSolver;
        this.githubComJetstackCertManagerPkgApisAcmeV1alpha2ACMEChallengeSolverDNS01 = githubComJetstackCertManagerPkgApisAcmeV1alpha2ACMEChallengeSolverDNS01;
        this.githubComJetstackCertManagerPkgApisAcmeV1alpha2ACMEChallengeSolverHTTP01 = githubComJetstackCertManagerPkgApisAcmeV1alpha2ACMEChallengeSolverHTTP01;
        this.githubComJetstackCertManagerPkgApisAcmeV1alpha2ACMEChallengeSolverHTTP01Ingress = githubComJetstackCertManagerPkgApisAcmeV1alpha2ACMEChallengeSolverHTTP01Ingress;
        this.githubComJetstackCertManagerPkgApisAcmeV1alpha2ACMEChallengeSolverHTTP01IngressObjectMeta = githubComJetstackCertManagerPkgApisAcmeV1alpha2ACMEChallengeSolverHTTP01IngressObjectMeta;
        this.githubComJetstackCertManagerPkgApisAcmeV1alpha2ACMEChallengeSolverHTTP01IngressPodObjectMeta = githubComJetstackCertManagerPkgApisAcmeV1alpha2ACMEChallengeSolverHTTP01IngressPodObjectMeta;
        this.githubComJetstackCertManagerPkgApisAcmeV1alpha2ACMEChallengeSolverHTTP01IngressPodSpec = githubComJetstackCertManagerPkgApisAcmeV1alpha2ACMEChallengeSolverHTTP01IngressPodSpec;
        this.githubComJetstackCertManagerPkgApisAcmeV1alpha2ACMEChallengeSolverHTTP01IngressPodTemplate = githubComJetstackCertManagerPkgApisAcmeV1alpha2ACMEChallengeSolverHTTP01IngressPodTemplate;
        this.githubComJetstackCertManagerPkgApisAcmeV1alpha2ACMEChallengeSolverHTTP01IngressTemplate = githubComJetstackCertManagerPkgApisAcmeV1alpha2ACMEChallengeSolverHTTP01IngressTemplate;
        this.githubComJetstackCertManagerPkgApisAcmeV1alpha2ACMEExternalAccountBinding = githubComJetstackCertManagerPkgApisAcmeV1alpha2ACMEExternalAccountBinding;
        this.githubComJetstackCertManagerPkgApisAcmeV1alpha2ACMEIssuer = githubComJetstackCertManagerPkgApisAcmeV1alpha2ACMEIssuer;
        this.githubComJetstackCertManagerPkgApisAcmeV1alpha2ACMEIssuerDNS01ProviderAcmeDNS = githubComJetstackCertManagerPkgApisAcmeV1alpha2ACMEIssuerDNS01ProviderAcmeDNS;
        this.githubComJetstackCertManagerPkgApisAcmeV1alpha2ACMEIssuerDNS01ProviderAkamai = githubComJetstackCertManagerPkgApisAcmeV1alpha2ACMEIssuerDNS01ProviderAkamai;
        this.githubComJetstackCertManagerPkgApisAcmeV1alpha2ACMEIssuerDNS01ProviderAzureDNS = githubComJetstackCertManagerPkgApisAcmeV1alpha2ACMEIssuerDNS01ProviderAzureDNS;
        this.githubComJetstackCertManagerPkgApisAcmeV1alpha2ACMEIssuerDNS01ProviderCloudDNS = githubComJetstackCertManagerPkgApisAcmeV1alpha2ACMEIssuerDNS01ProviderCloudDNS;
        this.githubComJetstackCertManagerPkgApisAcmeV1alpha2ACMEIssuerDNS01ProviderCloudflare = githubComJetstackCertManagerPkgApisAcmeV1alpha2ACMEIssuerDNS01ProviderCloudflare;
        this.githubComJetstackCertManagerPkgApisAcmeV1alpha2ACMEIssuerDNS01ProviderDigitalOcean = githubComJetstackCertManagerPkgApisAcmeV1alpha2ACMEIssuerDNS01ProviderDigitalOcean;
        this.githubComJetstackCertManagerPkgApisAcmeV1alpha2ACMEIssuerDNS01ProviderRFC2136 = githubComJetstackCertManagerPkgApisAcmeV1alpha2ACMEIssuerDNS01ProviderRFC2136;
        this.githubComJetstackCertManagerPkgApisAcmeV1alpha2ACMEIssuerDNS01ProviderRoute53 = githubComJetstackCertManagerPkgApisAcmeV1alpha2ACMEIssuerDNS01ProviderRoute53;
        this.githubComJetstackCertManagerPkgApisAcmeV1alpha2ACMEIssuerDNS01ProviderWebhook = githubComJetstackCertManagerPkgApisAcmeV1alpha2ACMEIssuerDNS01ProviderWebhook;
        this.githubComJetstackCertManagerPkgApisAcmeV1alpha2ACMEIssuerStatus = githubComJetstackCertManagerPkgApisAcmeV1alpha2ACMEIssuerStatus;
        this.githubComJetstackCertManagerPkgApisAcmeV1alpha2CertificateDNSNameSelector = githubComJetstackCertManagerPkgApisAcmeV1alpha2CertificateDNSNameSelector;
        this.githubComJetstackCertManagerPkgApisAcmeV1alpha2Challenge = githubComJetstackCertManagerPkgApisAcmeV1alpha2Challenge;
        this.githubComJetstackCertManagerPkgApisAcmeV1alpha2ChallengeList = githubComJetstackCertManagerPkgApisAcmeV1alpha2ChallengeList;
        this.githubComJetstackCertManagerPkgApisAcmeV1alpha2ChallengeSpec = githubComJetstackCertManagerPkgApisAcmeV1alpha2ChallengeSpec;
        this.githubComJetstackCertManagerPkgApisAcmeV1alpha2ChallengeStatus = githubComJetstackCertManagerPkgApisAcmeV1alpha2ChallengeStatus;
        this.githubComJetstackCertManagerPkgApisAcmeV1alpha2Order = githubComJetstackCertManagerPkgApisAcmeV1alpha2Order;
        this.githubComJetstackCertManagerPkgApisAcmeV1alpha2OrderList = githubComJetstackCertManagerPkgApisAcmeV1alpha2OrderList;
        this.githubComJetstackCertManagerPkgApisAcmeV1alpha2OrderSpec = githubComJetstackCertManagerPkgApisAcmeV1alpha2OrderSpec;
        this.githubComJetstackCertManagerPkgApisAcmeV1alpha2OrderStatus = githubComJetstackCertManagerPkgApisAcmeV1alpha2OrderStatus;
        this.githubComJetstackCertManagerPkgApisCertmanagerV1alpha2CAIssuer = githubComJetstackCertManagerPkgApisCertmanagerV1alpha2CAIssuer;
        this.githubComJetstackCertManagerPkgApisCertmanagerV1alpha2Certificate = githubComJetstackCertManagerPkgApisCertmanagerV1alpha2Certificate;
        this.githubComJetstackCertManagerPkgApisCertmanagerV1alpha2CertificateCondition = githubComJetstackCertManagerPkgApisCertmanagerV1alpha2CertificateCondition;
        this.githubComJetstackCertManagerPkgApisCertmanagerV1alpha2CertificateKeystores = githubComJetstackCertManagerPkgApisCertmanagerV1alpha2CertificateKeystores;
        this.githubComJetstackCertManagerPkgApisCertmanagerV1alpha2CertificateList = githubComJetstackCertManagerPkgApisCertmanagerV1alpha2CertificateList;
        this.githubComJetstackCertManagerPkgApisCertmanagerV1alpha2CertificatePrivateKey = githubComJetstackCertManagerPkgApisCertmanagerV1alpha2CertificatePrivateKey;
        this.githubComJetstackCertManagerPkgApisCertmanagerV1alpha2CertificateRequest = githubComJetstackCertManagerPkgApisCertmanagerV1alpha2CertificateRequest;
        this.githubComJetstackCertManagerPkgApisCertmanagerV1alpha2CertificateRequestCondition = githubComJetstackCertManagerPkgApisCertmanagerV1alpha2CertificateRequestCondition;
        this.githubComJetstackCertManagerPkgApisCertmanagerV1alpha2CertificateRequestList = githubComJetstackCertManagerPkgApisCertmanagerV1alpha2CertificateRequestList;
        this.githubComJetstackCertManagerPkgApisCertmanagerV1alpha2CertificateRequestSpec = githubComJetstackCertManagerPkgApisCertmanagerV1alpha2CertificateRequestSpec;
        this.githubComJetstackCertManagerPkgApisCertmanagerV1alpha2CertificateRequestStatus = githubComJetstackCertManagerPkgApisCertmanagerV1alpha2CertificateRequestStatus;
        this.githubComJetstackCertManagerPkgApisCertmanagerV1alpha2CertificateSpec = githubComJetstackCertManagerPkgApisCertmanagerV1alpha2CertificateSpec;
        this.githubComJetstackCertManagerPkgApisCertmanagerV1alpha2CertificateStatus = githubComJetstackCertManagerPkgApisCertmanagerV1alpha2CertificateStatus;
        this.githubComJetstackCertManagerPkgApisCertmanagerV1alpha2ClusterIssuer = githubComJetstackCertManagerPkgApisCertmanagerV1alpha2ClusterIssuer;
        this.githubComJetstackCertManagerPkgApisCertmanagerV1alpha2ClusterIssuerList = githubComJetstackCertManagerPkgApisCertmanagerV1alpha2ClusterIssuerList;
        this.githubComJetstackCertManagerPkgApisCertmanagerV1alpha2Issuer = githubComJetstackCertManagerPkgApisCertmanagerV1alpha2Issuer;
        this.githubComJetstackCertManagerPkgApisCertmanagerV1alpha2IssuerCondition = githubComJetstackCertManagerPkgApisCertmanagerV1alpha2IssuerCondition;
        this.githubComJetstackCertManagerPkgApisCertmanagerV1alpha2IssuerList = githubComJetstackCertManagerPkgApisCertmanagerV1alpha2IssuerList;
        this.githubComJetstackCertManagerPkgApisCertmanagerV1alpha2IssuerSpec = githubComJetstackCertManagerPkgApisCertmanagerV1alpha2IssuerSpec;
        this.githubComJetstackCertManagerPkgApisCertmanagerV1alpha2IssuerStatus = githubComJetstackCertManagerPkgApisCertmanagerV1alpha2IssuerStatus;
        this.githubComJetstackCertManagerPkgApisCertmanagerV1alpha2JKSKeystore = githubComJetstackCertManagerPkgApisCertmanagerV1alpha2JKSKeystore;
        this.githubComJetstackCertManagerPkgApisCertmanagerV1alpha2PKCS12Keystore = githubComJetstackCertManagerPkgApisCertmanagerV1alpha2PKCS12Keystore;
        this.githubComJetstackCertManagerPkgApisCertmanagerV1alpha2SelfSignedIssuer = githubComJetstackCertManagerPkgApisCertmanagerV1alpha2SelfSignedIssuer;
        this.githubComJetstackCertManagerPkgApisCertmanagerV1alpha2VaultAppRole = githubComJetstackCertManagerPkgApisCertmanagerV1alpha2VaultAppRole;
        this.githubComJetstackCertManagerPkgApisCertmanagerV1alpha2VaultAuth = githubComJetstackCertManagerPkgApisCertmanagerV1alpha2VaultAuth;
        this.githubComJetstackCertManagerPkgApisCertmanagerV1alpha2VaultIssuer = githubComJetstackCertManagerPkgApisCertmanagerV1alpha2VaultIssuer;
        this.githubComJetstackCertManagerPkgApisCertmanagerV1alpha2VaultKubernetesAuth = githubComJetstackCertManagerPkgApisCertmanagerV1alpha2VaultKubernetesAuth;
        this.githubComJetstackCertManagerPkgApisCertmanagerV1alpha2VenafiCloud = githubComJetstackCertManagerPkgApisCertmanagerV1alpha2VenafiCloud;
        this.githubComJetstackCertManagerPkgApisCertmanagerV1alpha2VenafiIssuer = githubComJetstackCertManagerPkgApisCertmanagerV1alpha2VenafiIssuer;
        this.githubComJetstackCertManagerPkgApisCertmanagerV1alpha2VenafiTPP = githubComJetstackCertManagerPkgApisCertmanagerV1alpha2VenafiTPP;
        this.githubComJetstackCertManagerPkgApisCertmanagerV1alpha2X509Subject = githubComJetstackCertManagerPkgApisCertmanagerV1alpha2X509Subject;
        this.githubComJetstackCertManagerPkgApisMetaV1LocalObjectReference = githubComJetstackCertManagerPkgApisMetaV1LocalObjectReference;
        this.githubComJetstackCertManagerPkgApisMetaV1ObjectReference = githubComJetstackCertManagerPkgApisMetaV1ObjectReference;
        this.githubComJetstackCertManagerPkgApisMetaV1SecretKeySelector = githubComJetstackCertManagerPkgApisMetaV1SecretKeySelector;
    }

    @JsonProperty("github_com_jetstack_cert-manager_pkg_apis_acme_v1alpha2_ACMEAuthorization")
    public ACMEAuthorization getGithubComJetstackCertManagerPkgApisAcmeV1alpha2ACMEAuthorization() {
        return githubComJetstackCertManagerPkgApisAcmeV1alpha2ACMEAuthorization;
    }

    @JsonProperty("github_com_jetstack_cert-manager_pkg_apis_acme_v1alpha2_ACMEAuthorization")
    public void setGithubComJetstackCertManagerPkgApisAcmeV1alpha2ACMEAuthorization(ACMEAuthorization githubComJetstackCertManagerPkgApisAcmeV1alpha2ACMEAuthorization) {
        this.githubComJetstackCertManagerPkgApisAcmeV1alpha2ACMEAuthorization = githubComJetstackCertManagerPkgApisAcmeV1alpha2ACMEAuthorization;
    }

    @JsonProperty("github_com_jetstack_cert-manager_pkg_apis_acme_v1alpha2_ACMEChallenge")
    public ACMEChallenge getGithubComJetstackCertManagerPkgApisAcmeV1alpha2ACMEChallenge() {
        return githubComJetstackCertManagerPkgApisAcmeV1alpha2ACMEChallenge;
    }

    @JsonProperty("github_com_jetstack_cert-manager_pkg_apis_acme_v1alpha2_ACMEChallenge")
    public void setGithubComJetstackCertManagerPkgApisAcmeV1alpha2ACMEChallenge(ACMEChallenge githubComJetstackCertManagerPkgApisAcmeV1alpha2ACMEChallenge) {
        this.githubComJetstackCertManagerPkgApisAcmeV1alpha2ACMEChallenge = githubComJetstackCertManagerPkgApisAcmeV1alpha2ACMEChallenge;
    }

    @JsonProperty("github_com_jetstack_cert-manager_pkg_apis_acme_v1alpha2_ACMEChallengeSolver")
    public ACMEChallengeSolver getGithubComJetstackCertManagerPkgApisAcmeV1alpha2ACMEChallengeSolver() {
        return githubComJetstackCertManagerPkgApisAcmeV1alpha2ACMEChallengeSolver;
    }

    @JsonProperty("github_com_jetstack_cert-manager_pkg_apis_acme_v1alpha2_ACMEChallengeSolver")
    public void setGithubComJetstackCertManagerPkgApisAcmeV1alpha2ACMEChallengeSolver(ACMEChallengeSolver githubComJetstackCertManagerPkgApisAcmeV1alpha2ACMEChallengeSolver) {
        this.githubComJetstackCertManagerPkgApisAcmeV1alpha2ACMEChallengeSolver = githubComJetstackCertManagerPkgApisAcmeV1alpha2ACMEChallengeSolver;
    }

    @JsonProperty("github_com_jetstack_cert-manager_pkg_apis_acme_v1alpha2_ACMEChallengeSolverDNS01")
    public ACMEChallengeSolverDNS01 getGithubComJetstackCertManagerPkgApisAcmeV1alpha2ACMEChallengeSolverDNS01() {
        return githubComJetstackCertManagerPkgApisAcmeV1alpha2ACMEChallengeSolverDNS01;
    }

    @JsonProperty("github_com_jetstack_cert-manager_pkg_apis_acme_v1alpha2_ACMEChallengeSolverDNS01")
    public void setGithubComJetstackCertManagerPkgApisAcmeV1alpha2ACMEChallengeSolverDNS01(ACMEChallengeSolverDNS01 githubComJetstackCertManagerPkgApisAcmeV1alpha2ACMEChallengeSolverDNS01) {
        this.githubComJetstackCertManagerPkgApisAcmeV1alpha2ACMEChallengeSolverDNS01 = githubComJetstackCertManagerPkgApisAcmeV1alpha2ACMEChallengeSolverDNS01;
    }

    @JsonProperty("github_com_jetstack_cert-manager_pkg_apis_acme_v1alpha2_ACMEChallengeSolverHTTP01")
    public ACMEChallengeSolverHTTP01 getGithubComJetstackCertManagerPkgApisAcmeV1alpha2ACMEChallengeSolverHTTP01() {
        return githubComJetstackCertManagerPkgApisAcmeV1alpha2ACMEChallengeSolverHTTP01;
    }

    @JsonProperty("github_com_jetstack_cert-manager_pkg_apis_acme_v1alpha2_ACMEChallengeSolverHTTP01")
    public void setGithubComJetstackCertManagerPkgApisAcmeV1alpha2ACMEChallengeSolverHTTP01(ACMEChallengeSolverHTTP01 githubComJetstackCertManagerPkgApisAcmeV1alpha2ACMEChallengeSolverHTTP01) {
        this.githubComJetstackCertManagerPkgApisAcmeV1alpha2ACMEChallengeSolverHTTP01 = githubComJetstackCertManagerPkgApisAcmeV1alpha2ACMEChallengeSolverHTTP01;
    }

    @JsonProperty("github_com_jetstack_cert-manager_pkg_apis_acme_v1alpha2_ACMEChallengeSolverHTTP01Ingress")
    public ACMEChallengeSolverHTTP01Ingress getGithubComJetstackCertManagerPkgApisAcmeV1alpha2ACMEChallengeSolverHTTP01Ingress() {
        return githubComJetstackCertManagerPkgApisAcmeV1alpha2ACMEChallengeSolverHTTP01Ingress;
    }

    @JsonProperty("github_com_jetstack_cert-manager_pkg_apis_acme_v1alpha2_ACMEChallengeSolverHTTP01Ingress")
    public void setGithubComJetstackCertManagerPkgApisAcmeV1alpha2ACMEChallengeSolverHTTP01Ingress(ACMEChallengeSolverHTTP01Ingress githubComJetstackCertManagerPkgApisAcmeV1alpha2ACMEChallengeSolverHTTP01Ingress) {
        this.githubComJetstackCertManagerPkgApisAcmeV1alpha2ACMEChallengeSolverHTTP01Ingress = githubComJetstackCertManagerPkgApisAcmeV1alpha2ACMEChallengeSolverHTTP01Ingress;
    }

    @JsonProperty("github_com_jetstack_cert-manager_pkg_apis_acme_v1alpha2_ACMEChallengeSolverHTTP01IngressObjectMeta")
    public ACMEChallengeSolverHTTP01IngressObjectMeta getGithubComJetstackCertManagerPkgApisAcmeV1alpha2ACMEChallengeSolverHTTP01IngressObjectMeta() {
        return githubComJetstackCertManagerPkgApisAcmeV1alpha2ACMEChallengeSolverHTTP01IngressObjectMeta;
    }

    @JsonProperty("github_com_jetstack_cert-manager_pkg_apis_acme_v1alpha2_ACMEChallengeSolverHTTP01IngressObjectMeta")
    public void setGithubComJetstackCertManagerPkgApisAcmeV1alpha2ACMEChallengeSolverHTTP01IngressObjectMeta(ACMEChallengeSolverHTTP01IngressObjectMeta githubComJetstackCertManagerPkgApisAcmeV1alpha2ACMEChallengeSolverHTTP01IngressObjectMeta) {
        this.githubComJetstackCertManagerPkgApisAcmeV1alpha2ACMEChallengeSolverHTTP01IngressObjectMeta = githubComJetstackCertManagerPkgApisAcmeV1alpha2ACMEChallengeSolverHTTP01IngressObjectMeta;
    }

    @JsonProperty("github_com_jetstack_cert-manager_pkg_apis_acme_v1alpha2_ACMEChallengeSolverHTTP01IngressPodObjectMeta")
    public ACMEChallengeSolverHTTP01IngressPodObjectMeta getGithubComJetstackCertManagerPkgApisAcmeV1alpha2ACMEChallengeSolverHTTP01IngressPodObjectMeta() {
        return githubComJetstackCertManagerPkgApisAcmeV1alpha2ACMEChallengeSolverHTTP01IngressPodObjectMeta;
    }

    @JsonProperty("github_com_jetstack_cert-manager_pkg_apis_acme_v1alpha2_ACMEChallengeSolverHTTP01IngressPodObjectMeta")
    public void setGithubComJetstackCertManagerPkgApisAcmeV1alpha2ACMEChallengeSolverHTTP01IngressPodObjectMeta(ACMEChallengeSolverHTTP01IngressPodObjectMeta githubComJetstackCertManagerPkgApisAcmeV1alpha2ACMEChallengeSolverHTTP01IngressPodObjectMeta) {
        this.githubComJetstackCertManagerPkgApisAcmeV1alpha2ACMEChallengeSolverHTTP01IngressPodObjectMeta = githubComJetstackCertManagerPkgApisAcmeV1alpha2ACMEChallengeSolverHTTP01IngressPodObjectMeta;
    }

    @JsonProperty("github_com_jetstack_cert-manager_pkg_apis_acme_v1alpha2_ACMEChallengeSolverHTTP01IngressPodSpec")
    public ACMEChallengeSolverHTTP01IngressPodSpec getGithubComJetstackCertManagerPkgApisAcmeV1alpha2ACMEChallengeSolverHTTP01IngressPodSpec() {
        return githubComJetstackCertManagerPkgApisAcmeV1alpha2ACMEChallengeSolverHTTP01IngressPodSpec;
    }

    @JsonProperty("github_com_jetstack_cert-manager_pkg_apis_acme_v1alpha2_ACMEChallengeSolverHTTP01IngressPodSpec")
    public void setGithubComJetstackCertManagerPkgApisAcmeV1alpha2ACMEChallengeSolverHTTP01IngressPodSpec(ACMEChallengeSolverHTTP01IngressPodSpec githubComJetstackCertManagerPkgApisAcmeV1alpha2ACMEChallengeSolverHTTP01IngressPodSpec) {
        this.githubComJetstackCertManagerPkgApisAcmeV1alpha2ACMEChallengeSolverHTTP01IngressPodSpec = githubComJetstackCertManagerPkgApisAcmeV1alpha2ACMEChallengeSolverHTTP01IngressPodSpec;
    }

    @JsonProperty("github_com_jetstack_cert-manager_pkg_apis_acme_v1alpha2_ACMEChallengeSolverHTTP01IngressPodTemplate")
    public ACMEChallengeSolverHTTP01IngressPodTemplate getGithubComJetstackCertManagerPkgApisAcmeV1alpha2ACMEChallengeSolverHTTP01IngressPodTemplate() {
        return githubComJetstackCertManagerPkgApisAcmeV1alpha2ACMEChallengeSolverHTTP01IngressPodTemplate;
    }

    @JsonProperty("github_com_jetstack_cert-manager_pkg_apis_acme_v1alpha2_ACMEChallengeSolverHTTP01IngressPodTemplate")
    public void setGithubComJetstackCertManagerPkgApisAcmeV1alpha2ACMEChallengeSolverHTTP01IngressPodTemplate(ACMEChallengeSolverHTTP01IngressPodTemplate githubComJetstackCertManagerPkgApisAcmeV1alpha2ACMEChallengeSolverHTTP01IngressPodTemplate) {
        this.githubComJetstackCertManagerPkgApisAcmeV1alpha2ACMEChallengeSolverHTTP01IngressPodTemplate = githubComJetstackCertManagerPkgApisAcmeV1alpha2ACMEChallengeSolverHTTP01IngressPodTemplate;
    }

    @JsonProperty("github_com_jetstack_cert-manager_pkg_apis_acme_v1alpha2_ACMEChallengeSolverHTTP01IngressTemplate")
    public ACMEChallengeSolverHTTP01IngressTemplate getGithubComJetstackCertManagerPkgApisAcmeV1alpha2ACMEChallengeSolverHTTP01IngressTemplate() {
        return githubComJetstackCertManagerPkgApisAcmeV1alpha2ACMEChallengeSolverHTTP01IngressTemplate;
    }

    @JsonProperty("github_com_jetstack_cert-manager_pkg_apis_acme_v1alpha2_ACMEChallengeSolverHTTP01IngressTemplate")
    public void setGithubComJetstackCertManagerPkgApisAcmeV1alpha2ACMEChallengeSolverHTTP01IngressTemplate(ACMEChallengeSolverHTTP01IngressTemplate githubComJetstackCertManagerPkgApisAcmeV1alpha2ACMEChallengeSolverHTTP01IngressTemplate) {
        this.githubComJetstackCertManagerPkgApisAcmeV1alpha2ACMEChallengeSolverHTTP01IngressTemplate = githubComJetstackCertManagerPkgApisAcmeV1alpha2ACMEChallengeSolverHTTP01IngressTemplate;
    }

    @JsonProperty("github_com_jetstack_cert-manager_pkg_apis_acme_v1alpha2_ACMEExternalAccountBinding")
    public ACMEExternalAccountBinding getGithubComJetstackCertManagerPkgApisAcmeV1alpha2ACMEExternalAccountBinding() {
        return githubComJetstackCertManagerPkgApisAcmeV1alpha2ACMEExternalAccountBinding;
    }

    @JsonProperty("github_com_jetstack_cert-manager_pkg_apis_acme_v1alpha2_ACMEExternalAccountBinding")
    public void setGithubComJetstackCertManagerPkgApisAcmeV1alpha2ACMEExternalAccountBinding(ACMEExternalAccountBinding githubComJetstackCertManagerPkgApisAcmeV1alpha2ACMEExternalAccountBinding) {
        this.githubComJetstackCertManagerPkgApisAcmeV1alpha2ACMEExternalAccountBinding = githubComJetstackCertManagerPkgApisAcmeV1alpha2ACMEExternalAccountBinding;
    }

    @JsonProperty("github_com_jetstack_cert-manager_pkg_apis_acme_v1alpha2_ACMEIssuer")
    public ACMEIssuer getGithubComJetstackCertManagerPkgApisAcmeV1alpha2ACMEIssuer() {
        return githubComJetstackCertManagerPkgApisAcmeV1alpha2ACMEIssuer;
    }

    @JsonProperty("github_com_jetstack_cert-manager_pkg_apis_acme_v1alpha2_ACMEIssuer")
    public void setGithubComJetstackCertManagerPkgApisAcmeV1alpha2ACMEIssuer(ACMEIssuer githubComJetstackCertManagerPkgApisAcmeV1alpha2ACMEIssuer) {
        this.githubComJetstackCertManagerPkgApisAcmeV1alpha2ACMEIssuer = githubComJetstackCertManagerPkgApisAcmeV1alpha2ACMEIssuer;
    }

    @JsonProperty("github_com_jetstack_cert-manager_pkg_apis_acme_v1alpha2_ACMEIssuerDNS01ProviderAcmeDNS")
    public ACMEIssuerDNS01ProviderAcmeDNS getGithubComJetstackCertManagerPkgApisAcmeV1alpha2ACMEIssuerDNS01ProviderAcmeDNS() {
        return githubComJetstackCertManagerPkgApisAcmeV1alpha2ACMEIssuerDNS01ProviderAcmeDNS;
    }

    @JsonProperty("github_com_jetstack_cert-manager_pkg_apis_acme_v1alpha2_ACMEIssuerDNS01ProviderAcmeDNS")
    public void setGithubComJetstackCertManagerPkgApisAcmeV1alpha2ACMEIssuerDNS01ProviderAcmeDNS(ACMEIssuerDNS01ProviderAcmeDNS githubComJetstackCertManagerPkgApisAcmeV1alpha2ACMEIssuerDNS01ProviderAcmeDNS) {
        this.githubComJetstackCertManagerPkgApisAcmeV1alpha2ACMEIssuerDNS01ProviderAcmeDNS = githubComJetstackCertManagerPkgApisAcmeV1alpha2ACMEIssuerDNS01ProviderAcmeDNS;
    }

    @JsonProperty("github_com_jetstack_cert-manager_pkg_apis_acme_v1alpha2_ACMEIssuerDNS01ProviderAkamai")
    public ACMEIssuerDNS01ProviderAkamai getGithubComJetstackCertManagerPkgApisAcmeV1alpha2ACMEIssuerDNS01ProviderAkamai() {
        return githubComJetstackCertManagerPkgApisAcmeV1alpha2ACMEIssuerDNS01ProviderAkamai;
    }

    @JsonProperty("github_com_jetstack_cert-manager_pkg_apis_acme_v1alpha2_ACMEIssuerDNS01ProviderAkamai")
    public void setGithubComJetstackCertManagerPkgApisAcmeV1alpha2ACMEIssuerDNS01ProviderAkamai(ACMEIssuerDNS01ProviderAkamai githubComJetstackCertManagerPkgApisAcmeV1alpha2ACMEIssuerDNS01ProviderAkamai) {
        this.githubComJetstackCertManagerPkgApisAcmeV1alpha2ACMEIssuerDNS01ProviderAkamai = githubComJetstackCertManagerPkgApisAcmeV1alpha2ACMEIssuerDNS01ProviderAkamai;
    }

    @JsonProperty("github_com_jetstack_cert-manager_pkg_apis_acme_v1alpha2_ACMEIssuerDNS01ProviderAzureDNS")
    public ACMEIssuerDNS01ProviderAzureDNS getGithubComJetstackCertManagerPkgApisAcmeV1alpha2ACMEIssuerDNS01ProviderAzureDNS() {
        return githubComJetstackCertManagerPkgApisAcmeV1alpha2ACMEIssuerDNS01ProviderAzureDNS;
    }

    @JsonProperty("github_com_jetstack_cert-manager_pkg_apis_acme_v1alpha2_ACMEIssuerDNS01ProviderAzureDNS")
    public void setGithubComJetstackCertManagerPkgApisAcmeV1alpha2ACMEIssuerDNS01ProviderAzureDNS(ACMEIssuerDNS01ProviderAzureDNS githubComJetstackCertManagerPkgApisAcmeV1alpha2ACMEIssuerDNS01ProviderAzureDNS) {
        this.githubComJetstackCertManagerPkgApisAcmeV1alpha2ACMEIssuerDNS01ProviderAzureDNS = githubComJetstackCertManagerPkgApisAcmeV1alpha2ACMEIssuerDNS01ProviderAzureDNS;
    }

    @JsonProperty("github_com_jetstack_cert-manager_pkg_apis_acme_v1alpha2_ACMEIssuerDNS01ProviderCloudDNS")
    public ACMEIssuerDNS01ProviderCloudDNS getGithubComJetstackCertManagerPkgApisAcmeV1alpha2ACMEIssuerDNS01ProviderCloudDNS() {
        return githubComJetstackCertManagerPkgApisAcmeV1alpha2ACMEIssuerDNS01ProviderCloudDNS;
    }

    @JsonProperty("github_com_jetstack_cert-manager_pkg_apis_acme_v1alpha2_ACMEIssuerDNS01ProviderCloudDNS")
    public void setGithubComJetstackCertManagerPkgApisAcmeV1alpha2ACMEIssuerDNS01ProviderCloudDNS(ACMEIssuerDNS01ProviderCloudDNS githubComJetstackCertManagerPkgApisAcmeV1alpha2ACMEIssuerDNS01ProviderCloudDNS) {
        this.githubComJetstackCertManagerPkgApisAcmeV1alpha2ACMEIssuerDNS01ProviderCloudDNS = githubComJetstackCertManagerPkgApisAcmeV1alpha2ACMEIssuerDNS01ProviderCloudDNS;
    }

    @JsonProperty("github_com_jetstack_cert-manager_pkg_apis_acme_v1alpha2_ACMEIssuerDNS01ProviderCloudflare")
    public ACMEIssuerDNS01ProviderCloudflare getGithubComJetstackCertManagerPkgApisAcmeV1alpha2ACMEIssuerDNS01ProviderCloudflare() {
        return githubComJetstackCertManagerPkgApisAcmeV1alpha2ACMEIssuerDNS01ProviderCloudflare;
    }

    @JsonProperty("github_com_jetstack_cert-manager_pkg_apis_acme_v1alpha2_ACMEIssuerDNS01ProviderCloudflare")
    public void setGithubComJetstackCertManagerPkgApisAcmeV1alpha2ACMEIssuerDNS01ProviderCloudflare(ACMEIssuerDNS01ProviderCloudflare githubComJetstackCertManagerPkgApisAcmeV1alpha2ACMEIssuerDNS01ProviderCloudflare) {
        this.githubComJetstackCertManagerPkgApisAcmeV1alpha2ACMEIssuerDNS01ProviderCloudflare = githubComJetstackCertManagerPkgApisAcmeV1alpha2ACMEIssuerDNS01ProviderCloudflare;
    }

    @JsonProperty("github_com_jetstack_cert-manager_pkg_apis_acme_v1alpha2_ACMEIssuerDNS01ProviderDigitalOcean")
    public ACMEIssuerDNS01ProviderDigitalOcean getGithubComJetstackCertManagerPkgApisAcmeV1alpha2ACMEIssuerDNS01ProviderDigitalOcean() {
        return githubComJetstackCertManagerPkgApisAcmeV1alpha2ACMEIssuerDNS01ProviderDigitalOcean;
    }

    @JsonProperty("github_com_jetstack_cert-manager_pkg_apis_acme_v1alpha2_ACMEIssuerDNS01ProviderDigitalOcean")
    public void setGithubComJetstackCertManagerPkgApisAcmeV1alpha2ACMEIssuerDNS01ProviderDigitalOcean(ACMEIssuerDNS01ProviderDigitalOcean githubComJetstackCertManagerPkgApisAcmeV1alpha2ACMEIssuerDNS01ProviderDigitalOcean) {
        this.githubComJetstackCertManagerPkgApisAcmeV1alpha2ACMEIssuerDNS01ProviderDigitalOcean = githubComJetstackCertManagerPkgApisAcmeV1alpha2ACMEIssuerDNS01ProviderDigitalOcean;
    }

    @JsonProperty("github_com_jetstack_cert-manager_pkg_apis_acme_v1alpha2_ACMEIssuerDNS01ProviderRFC2136")
    public ACMEIssuerDNS01ProviderRFC2136 getGithubComJetstackCertManagerPkgApisAcmeV1alpha2ACMEIssuerDNS01ProviderRFC2136() {
        return githubComJetstackCertManagerPkgApisAcmeV1alpha2ACMEIssuerDNS01ProviderRFC2136;
    }

    @JsonProperty("github_com_jetstack_cert-manager_pkg_apis_acme_v1alpha2_ACMEIssuerDNS01ProviderRFC2136")
    public void setGithubComJetstackCertManagerPkgApisAcmeV1alpha2ACMEIssuerDNS01ProviderRFC2136(ACMEIssuerDNS01ProviderRFC2136 githubComJetstackCertManagerPkgApisAcmeV1alpha2ACMEIssuerDNS01ProviderRFC2136) {
        this.githubComJetstackCertManagerPkgApisAcmeV1alpha2ACMEIssuerDNS01ProviderRFC2136 = githubComJetstackCertManagerPkgApisAcmeV1alpha2ACMEIssuerDNS01ProviderRFC2136;
    }

    @JsonProperty("github_com_jetstack_cert-manager_pkg_apis_acme_v1alpha2_ACMEIssuerDNS01ProviderRoute53")
    public ACMEIssuerDNS01ProviderRoute53 getGithubComJetstackCertManagerPkgApisAcmeV1alpha2ACMEIssuerDNS01ProviderRoute53() {
        return githubComJetstackCertManagerPkgApisAcmeV1alpha2ACMEIssuerDNS01ProviderRoute53;
    }

    @JsonProperty("github_com_jetstack_cert-manager_pkg_apis_acme_v1alpha2_ACMEIssuerDNS01ProviderRoute53")
    public void setGithubComJetstackCertManagerPkgApisAcmeV1alpha2ACMEIssuerDNS01ProviderRoute53(ACMEIssuerDNS01ProviderRoute53 githubComJetstackCertManagerPkgApisAcmeV1alpha2ACMEIssuerDNS01ProviderRoute53) {
        this.githubComJetstackCertManagerPkgApisAcmeV1alpha2ACMEIssuerDNS01ProviderRoute53 = githubComJetstackCertManagerPkgApisAcmeV1alpha2ACMEIssuerDNS01ProviderRoute53;
    }

    @JsonProperty("github_com_jetstack_cert-manager_pkg_apis_acme_v1alpha2_ACMEIssuerDNS01ProviderWebhook")
    public ACMEIssuerDNS01ProviderWebhook getGithubComJetstackCertManagerPkgApisAcmeV1alpha2ACMEIssuerDNS01ProviderWebhook() {
        return githubComJetstackCertManagerPkgApisAcmeV1alpha2ACMEIssuerDNS01ProviderWebhook;
    }

    @JsonProperty("github_com_jetstack_cert-manager_pkg_apis_acme_v1alpha2_ACMEIssuerDNS01ProviderWebhook")
    public void setGithubComJetstackCertManagerPkgApisAcmeV1alpha2ACMEIssuerDNS01ProviderWebhook(ACMEIssuerDNS01ProviderWebhook githubComJetstackCertManagerPkgApisAcmeV1alpha2ACMEIssuerDNS01ProviderWebhook) {
        this.githubComJetstackCertManagerPkgApisAcmeV1alpha2ACMEIssuerDNS01ProviderWebhook = githubComJetstackCertManagerPkgApisAcmeV1alpha2ACMEIssuerDNS01ProviderWebhook;
    }

    @JsonProperty("github_com_jetstack_cert-manager_pkg_apis_acme_v1alpha2_ACMEIssuerStatus")
    public ACMEIssuerStatus getGithubComJetstackCertManagerPkgApisAcmeV1alpha2ACMEIssuerStatus() {
        return githubComJetstackCertManagerPkgApisAcmeV1alpha2ACMEIssuerStatus;
    }

    @JsonProperty("github_com_jetstack_cert-manager_pkg_apis_acme_v1alpha2_ACMEIssuerStatus")
    public void setGithubComJetstackCertManagerPkgApisAcmeV1alpha2ACMEIssuerStatus(ACMEIssuerStatus githubComJetstackCertManagerPkgApisAcmeV1alpha2ACMEIssuerStatus) {
        this.githubComJetstackCertManagerPkgApisAcmeV1alpha2ACMEIssuerStatus = githubComJetstackCertManagerPkgApisAcmeV1alpha2ACMEIssuerStatus;
    }

    @JsonProperty("github_com_jetstack_cert-manager_pkg_apis_acme_v1alpha2_CertificateDNSNameSelector")
    public CertificateDNSNameSelector getGithubComJetstackCertManagerPkgApisAcmeV1alpha2CertificateDNSNameSelector() {
        return githubComJetstackCertManagerPkgApisAcmeV1alpha2CertificateDNSNameSelector;
    }

    @JsonProperty("github_com_jetstack_cert-manager_pkg_apis_acme_v1alpha2_CertificateDNSNameSelector")
    public void setGithubComJetstackCertManagerPkgApisAcmeV1alpha2CertificateDNSNameSelector(CertificateDNSNameSelector githubComJetstackCertManagerPkgApisAcmeV1alpha2CertificateDNSNameSelector) {
        this.githubComJetstackCertManagerPkgApisAcmeV1alpha2CertificateDNSNameSelector = githubComJetstackCertManagerPkgApisAcmeV1alpha2CertificateDNSNameSelector;
    }

    @JsonProperty("github_com_jetstack_cert-manager_pkg_apis_acme_v1alpha2_Challenge")
    public Challenge getGithubComJetstackCertManagerPkgApisAcmeV1alpha2Challenge() {
        return githubComJetstackCertManagerPkgApisAcmeV1alpha2Challenge;
    }

    @JsonProperty("github_com_jetstack_cert-manager_pkg_apis_acme_v1alpha2_Challenge")
    public void setGithubComJetstackCertManagerPkgApisAcmeV1alpha2Challenge(Challenge githubComJetstackCertManagerPkgApisAcmeV1alpha2Challenge) {
        this.githubComJetstackCertManagerPkgApisAcmeV1alpha2Challenge = githubComJetstackCertManagerPkgApisAcmeV1alpha2Challenge;
    }

    @JsonProperty("github_com_jetstack_cert-manager_pkg_apis_acme_v1alpha2_ChallengeList")
    public ChallengeList getGithubComJetstackCertManagerPkgApisAcmeV1alpha2ChallengeList() {
        return githubComJetstackCertManagerPkgApisAcmeV1alpha2ChallengeList;
    }

    @JsonProperty("github_com_jetstack_cert-manager_pkg_apis_acme_v1alpha2_ChallengeList")
    public void setGithubComJetstackCertManagerPkgApisAcmeV1alpha2ChallengeList(ChallengeList githubComJetstackCertManagerPkgApisAcmeV1alpha2ChallengeList) {
        this.githubComJetstackCertManagerPkgApisAcmeV1alpha2ChallengeList = githubComJetstackCertManagerPkgApisAcmeV1alpha2ChallengeList;
    }

    @JsonProperty("github_com_jetstack_cert-manager_pkg_apis_acme_v1alpha2_ChallengeSpec")
    public ChallengeSpec getGithubComJetstackCertManagerPkgApisAcmeV1alpha2ChallengeSpec() {
        return githubComJetstackCertManagerPkgApisAcmeV1alpha2ChallengeSpec;
    }

    @JsonProperty("github_com_jetstack_cert-manager_pkg_apis_acme_v1alpha2_ChallengeSpec")
    public void setGithubComJetstackCertManagerPkgApisAcmeV1alpha2ChallengeSpec(ChallengeSpec githubComJetstackCertManagerPkgApisAcmeV1alpha2ChallengeSpec) {
        this.githubComJetstackCertManagerPkgApisAcmeV1alpha2ChallengeSpec = githubComJetstackCertManagerPkgApisAcmeV1alpha2ChallengeSpec;
    }

    @JsonProperty("github_com_jetstack_cert-manager_pkg_apis_acme_v1alpha2_ChallengeStatus")
    public ChallengeStatus getGithubComJetstackCertManagerPkgApisAcmeV1alpha2ChallengeStatus() {
        return githubComJetstackCertManagerPkgApisAcmeV1alpha2ChallengeStatus;
    }

    @JsonProperty("github_com_jetstack_cert-manager_pkg_apis_acme_v1alpha2_ChallengeStatus")
    public void setGithubComJetstackCertManagerPkgApisAcmeV1alpha2ChallengeStatus(ChallengeStatus githubComJetstackCertManagerPkgApisAcmeV1alpha2ChallengeStatus) {
        this.githubComJetstackCertManagerPkgApisAcmeV1alpha2ChallengeStatus = githubComJetstackCertManagerPkgApisAcmeV1alpha2ChallengeStatus;
    }

    @JsonProperty("github_com_jetstack_cert-manager_pkg_apis_acme_v1alpha2_Order")
    public Order getGithubComJetstackCertManagerPkgApisAcmeV1alpha2Order() {
        return githubComJetstackCertManagerPkgApisAcmeV1alpha2Order;
    }

    @JsonProperty("github_com_jetstack_cert-manager_pkg_apis_acme_v1alpha2_Order")
    public void setGithubComJetstackCertManagerPkgApisAcmeV1alpha2Order(Order githubComJetstackCertManagerPkgApisAcmeV1alpha2Order) {
        this.githubComJetstackCertManagerPkgApisAcmeV1alpha2Order = githubComJetstackCertManagerPkgApisAcmeV1alpha2Order;
    }

    @JsonProperty("github_com_jetstack_cert-manager_pkg_apis_acme_v1alpha2_OrderList")
    public OrderList getGithubComJetstackCertManagerPkgApisAcmeV1alpha2OrderList() {
        return githubComJetstackCertManagerPkgApisAcmeV1alpha2OrderList;
    }

    @JsonProperty("github_com_jetstack_cert-manager_pkg_apis_acme_v1alpha2_OrderList")
    public void setGithubComJetstackCertManagerPkgApisAcmeV1alpha2OrderList(OrderList githubComJetstackCertManagerPkgApisAcmeV1alpha2OrderList) {
        this.githubComJetstackCertManagerPkgApisAcmeV1alpha2OrderList = githubComJetstackCertManagerPkgApisAcmeV1alpha2OrderList;
    }

    @JsonProperty("github_com_jetstack_cert-manager_pkg_apis_acme_v1alpha2_OrderSpec")
    public OrderSpec getGithubComJetstackCertManagerPkgApisAcmeV1alpha2OrderSpec() {
        return githubComJetstackCertManagerPkgApisAcmeV1alpha2OrderSpec;
    }

    @JsonProperty("github_com_jetstack_cert-manager_pkg_apis_acme_v1alpha2_OrderSpec")
    public void setGithubComJetstackCertManagerPkgApisAcmeV1alpha2OrderSpec(OrderSpec githubComJetstackCertManagerPkgApisAcmeV1alpha2OrderSpec) {
        this.githubComJetstackCertManagerPkgApisAcmeV1alpha2OrderSpec = githubComJetstackCertManagerPkgApisAcmeV1alpha2OrderSpec;
    }

    @JsonProperty("github_com_jetstack_cert-manager_pkg_apis_acme_v1alpha2_OrderStatus")
    public OrderStatus getGithubComJetstackCertManagerPkgApisAcmeV1alpha2OrderStatus() {
        return githubComJetstackCertManagerPkgApisAcmeV1alpha2OrderStatus;
    }

    @JsonProperty("github_com_jetstack_cert-manager_pkg_apis_acme_v1alpha2_OrderStatus")
    public void setGithubComJetstackCertManagerPkgApisAcmeV1alpha2OrderStatus(OrderStatus githubComJetstackCertManagerPkgApisAcmeV1alpha2OrderStatus) {
        this.githubComJetstackCertManagerPkgApisAcmeV1alpha2OrderStatus = githubComJetstackCertManagerPkgApisAcmeV1alpha2OrderStatus;
    }

    @JsonProperty("github_com_jetstack_cert-manager_pkg_apis_certmanager_v1alpha2_CAIssuer")
    public CAIssuer getGithubComJetstackCertManagerPkgApisCertmanagerV1alpha2CAIssuer() {
        return githubComJetstackCertManagerPkgApisCertmanagerV1alpha2CAIssuer;
    }

    @JsonProperty("github_com_jetstack_cert-manager_pkg_apis_certmanager_v1alpha2_CAIssuer")
    public void setGithubComJetstackCertManagerPkgApisCertmanagerV1alpha2CAIssuer(CAIssuer githubComJetstackCertManagerPkgApisCertmanagerV1alpha2CAIssuer) {
        this.githubComJetstackCertManagerPkgApisCertmanagerV1alpha2CAIssuer = githubComJetstackCertManagerPkgApisCertmanagerV1alpha2CAIssuer;
    }

    @JsonProperty("github_com_jetstack_cert-manager_pkg_apis_certmanager_v1alpha2_Certificate")
    public Certificate getGithubComJetstackCertManagerPkgApisCertmanagerV1alpha2Certificate() {
        return githubComJetstackCertManagerPkgApisCertmanagerV1alpha2Certificate;
    }

    @JsonProperty("github_com_jetstack_cert-manager_pkg_apis_certmanager_v1alpha2_Certificate")
    public void setGithubComJetstackCertManagerPkgApisCertmanagerV1alpha2Certificate(Certificate githubComJetstackCertManagerPkgApisCertmanagerV1alpha2Certificate) {
        this.githubComJetstackCertManagerPkgApisCertmanagerV1alpha2Certificate = githubComJetstackCertManagerPkgApisCertmanagerV1alpha2Certificate;
    }

    @JsonProperty("github_com_jetstack_cert-manager_pkg_apis_certmanager_v1alpha2_CertificateCondition")
    public CertificateCondition getGithubComJetstackCertManagerPkgApisCertmanagerV1alpha2CertificateCondition() {
        return githubComJetstackCertManagerPkgApisCertmanagerV1alpha2CertificateCondition;
    }

    @JsonProperty("github_com_jetstack_cert-manager_pkg_apis_certmanager_v1alpha2_CertificateCondition")
    public void setGithubComJetstackCertManagerPkgApisCertmanagerV1alpha2CertificateCondition(CertificateCondition githubComJetstackCertManagerPkgApisCertmanagerV1alpha2CertificateCondition) {
        this.githubComJetstackCertManagerPkgApisCertmanagerV1alpha2CertificateCondition = githubComJetstackCertManagerPkgApisCertmanagerV1alpha2CertificateCondition;
    }

    @JsonProperty("github_com_jetstack_cert-manager_pkg_apis_certmanager_v1alpha2_CertificateKeystores")
    public CertificateKeystores getGithubComJetstackCertManagerPkgApisCertmanagerV1alpha2CertificateKeystores() {
        return githubComJetstackCertManagerPkgApisCertmanagerV1alpha2CertificateKeystores;
    }

    @JsonProperty("github_com_jetstack_cert-manager_pkg_apis_certmanager_v1alpha2_CertificateKeystores")
    public void setGithubComJetstackCertManagerPkgApisCertmanagerV1alpha2CertificateKeystores(CertificateKeystores githubComJetstackCertManagerPkgApisCertmanagerV1alpha2CertificateKeystores) {
        this.githubComJetstackCertManagerPkgApisCertmanagerV1alpha2CertificateKeystores = githubComJetstackCertManagerPkgApisCertmanagerV1alpha2CertificateKeystores;
    }

    @JsonProperty("github_com_jetstack_cert-manager_pkg_apis_certmanager_v1alpha2_CertificateList")
    public CertificateList getGithubComJetstackCertManagerPkgApisCertmanagerV1alpha2CertificateList() {
        return githubComJetstackCertManagerPkgApisCertmanagerV1alpha2CertificateList;
    }

    @JsonProperty("github_com_jetstack_cert-manager_pkg_apis_certmanager_v1alpha2_CertificateList")
    public void setGithubComJetstackCertManagerPkgApisCertmanagerV1alpha2CertificateList(CertificateList githubComJetstackCertManagerPkgApisCertmanagerV1alpha2CertificateList) {
        this.githubComJetstackCertManagerPkgApisCertmanagerV1alpha2CertificateList = githubComJetstackCertManagerPkgApisCertmanagerV1alpha2CertificateList;
    }

    @JsonProperty("github_com_jetstack_cert-manager_pkg_apis_certmanager_v1alpha2_CertificatePrivateKey")
    public CertificatePrivateKey getGithubComJetstackCertManagerPkgApisCertmanagerV1alpha2CertificatePrivateKey() {
        return githubComJetstackCertManagerPkgApisCertmanagerV1alpha2CertificatePrivateKey;
    }

    @JsonProperty("github_com_jetstack_cert-manager_pkg_apis_certmanager_v1alpha2_CertificatePrivateKey")
    public void setGithubComJetstackCertManagerPkgApisCertmanagerV1alpha2CertificatePrivateKey(CertificatePrivateKey githubComJetstackCertManagerPkgApisCertmanagerV1alpha2CertificatePrivateKey) {
        this.githubComJetstackCertManagerPkgApisCertmanagerV1alpha2CertificatePrivateKey = githubComJetstackCertManagerPkgApisCertmanagerV1alpha2CertificatePrivateKey;
    }

    @JsonProperty("github_com_jetstack_cert-manager_pkg_apis_certmanager_v1alpha2_CertificateRequest")
    public CertificateRequest getGithubComJetstackCertManagerPkgApisCertmanagerV1alpha2CertificateRequest() {
        return githubComJetstackCertManagerPkgApisCertmanagerV1alpha2CertificateRequest;
    }

    @JsonProperty("github_com_jetstack_cert-manager_pkg_apis_certmanager_v1alpha2_CertificateRequest")
    public void setGithubComJetstackCertManagerPkgApisCertmanagerV1alpha2CertificateRequest(CertificateRequest githubComJetstackCertManagerPkgApisCertmanagerV1alpha2CertificateRequest) {
        this.githubComJetstackCertManagerPkgApisCertmanagerV1alpha2CertificateRequest = githubComJetstackCertManagerPkgApisCertmanagerV1alpha2CertificateRequest;
    }

    @JsonProperty("github_com_jetstack_cert-manager_pkg_apis_certmanager_v1alpha2_CertificateRequestCondition")
    public CertificateRequestCondition getGithubComJetstackCertManagerPkgApisCertmanagerV1alpha2CertificateRequestCondition() {
        return githubComJetstackCertManagerPkgApisCertmanagerV1alpha2CertificateRequestCondition;
    }

    @JsonProperty("github_com_jetstack_cert-manager_pkg_apis_certmanager_v1alpha2_CertificateRequestCondition")
    public void setGithubComJetstackCertManagerPkgApisCertmanagerV1alpha2CertificateRequestCondition(CertificateRequestCondition githubComJetstackCertManagerPkgApisCertmanagerV1alpha2CertificateRequestCondition) {
        this.githubComJetstackCertManagerPkgApisCertmanagerV1alpha2CertificateRequestCondition = githubComJetstackCertManagerPkgApisCertmanagerV1alpha2CertificateRequestCondition;
    }

    @JsonProperty("github_com_jetstack_cert-manager_pkg_apis_certmanager_v1alpha2_CertificateRequestList")
    public CertificateRequestList getGithubComJetstackCertManagerPkgApisCertmanagerV1alpha2CertificateRequestList() {
        return githubComJetstackCertManagerPkgApisCertmanagerV1alpha2CertificateRequestList;
    }

    @JsonProperty("github_com_jetstack_cert-manager_pkg_apis_certmanager_v1alpha2_CertificateRequestList")
    public void setGithubComJetstackCertManagerPkgApisCertmanagerV1alpha2CertificateRequestList(CertificateRequestList githubComJetstackCertManagerPkgApisCertmanagerV1alpha2CertificateRequestList) {
        this.githubComJetstackCertManagerPkgApisCertmanagerV1alpha2CertificateRequestList = githubComJetstackCertManagerPkgApisCertmanagerV1alpha2CertificateRequestList;
    }

    @JsonProperty("github_com_jetstack_cert-manager_pkg_apis_certmanager_v1alpha2_CertificateRequestSpec")
    public CertificateRequestSpec getGithubComJetstackCertManagerPkgApisCertmanagerV1alpha2CertificateRequestSpec() {
        return githubComJetstackCertManagerPkgApisCertmanagerV1alpha2CertificateRequestSpec;
    }

    @JsonProperty("github_com_jetstack_cert-manager_pkg_apis_certmanager_v1alpha2_CertificateRequestSpec")
    public void setGithubComJetstackCertManagerPkgApisCertmanagerV1alpha2CertificateRequestSpec(CertificateRequestSpec githubComJetstackCertManagerPkgApisCertmanagerV1alpha2CertificateRequestSpec) {
        this.githubComJetstackCertManagerPkgApisCertmanagerV1alpha2CertificateRequestSpec = githubComJetstackCertManagerPkgApisCertmanagerV1alpha2CertificateRequestSpec;
    }

    @JsonProperty("github_com_jetstack_cert-manager_pkg_apis_certmanager_v1alpha2_CertificateRequestStatus")
    public CertificateRequestStatus getGithubComJetstackCertManagerPkgApisCertmanagerV1alpha2CertificateRequestStatus() {
        return githubComJetstackCertManagerPkgApisCertmanagerV1alpha2CertificateRequestStatus;
    }

    @JsonProperty("github_com_jetstack_cert-manager_pkg_apis_certmanager_v1alpha2_CertificateRequestStatus")
    public void setGithubComJetstackCertManagerPkgApisCertmanagerV1alpha2CertificateRequestStatus(CertificateRequestStatus githubComJetstackCertManagerPkgApisCertmanagerV1alpha2CertificateRequestStatus) {
        this.githubComJetstackCertManagerPkgApisCertmanagerV1alpha2CertificateRequestStatus = githubComJetstackCertManagerPkgApisCertmanagerV1alpha2CertificateRequestStatus;
    }

    @JsonProperty("github_com_jetstack_cert-manager_pkg_apis_certmanager_v1alpha2_CertificateSpec")
    public CertificateSpec getGithubComJetstackCertManagerPkgApisCertmanagerV1alpha2CertificateSpec() {
        return githubComJetstackCertManagerPkgApisCertmanagerV1alpha2CertificateSpec;
    }

    @JsonProperty("github_com_jetstack_cert-manager_pkg_apis_certmanager_v1alpha2_CertificateSpec")
    public void setGithubComJetstackCertManagerPkgApisCertmanagerV1alpha2CertificateSpec(CertificateSpec githubComJetstackCertManagerPkgApisCertmanagerV1alpha2CertificateSpec) {
        this.githubComJetstackCertManagerPkgApisCertmanagerV1alpha2CertificateSpec = githubComJetstackCertManagerPkgApisCertmanagerV1alpha2CertificateSpec;
    }

    @JsonProperty("github_com_jetstack_cert-manager_pkg_apis_certmanager_v1alpha2_CertificateStatus")
    public CertificateStatus getGithubComJetstackCertManagerPkgApisCertmanagerV1alpha2CertificateStatus() {
        return githubComJetstackCertManagerPkgApisCertmanagerV1alpha2CertificateStatus;
    }

    @JsonProperty("github_com_jetstack_cert-manager_pkg_apis_certmanager_v1alpha2_CertificateStatus")
    public void setGithubComJetstackCertManagerPkgApisCertmanagerV1alpha2CertificateStatus(CertificateStatus githubComJetstackCertManagerPkgApisCertmanagerV1alpha2CertificateStatus) {
        this.githubComJetstackCertManagerPkgApisCertmanagerV1alpha2CertificateStatus = githubComJetstackCertManagerPkgApisCertmanagerV1alpha2CertificateStatus;
    }

    @JsonProperty("github_com_jetstack_cert-manager_pkg_apis_certmanager_v1alpha2_ClusterIssuer")
    public ClusterIssuer getGithubComJetstackCertManagerPkgApisCertmanagerV1alpha2ClusterIssuer() {
        return githubComJetstackCertManagerPkgApisCertmanagerV1alpha2ClusterIssuer;
    }

    @JsonProperty("github_com_jetstack_cert-manager_pkg_apis_certmanager_v1alpha2_ClusterIssuer")
    public void setGithubComJetstackCertManagerPkgApisCertmanagerV1alpha2ClusterIssuer(ClusterIssuer githubComJetstackCertManagerPkgApisCertmanagerV1alpha2ClusterIssuer) {
        this.githubComJetstackCertManagerPkgApisCertmanagerV1alpha2ClusterIssuer = githubComJetstackCertManagerPkgApisCertmanagerV1alpha2ClusterIssuer;
    }

    @JsonProperty("github_com_jetstack_cert-manager_pkg_apis_certmanager_v1alpha2_ClusterIssuerList")
    public ClusterIssuerList getGithubComJetstackCertManagerPkgApisCertmanagerV1alpha2ClusterIssuerList() {
        return githubComJetstackCertManagerPkgApisCertmanagerV1alpha2ClusterIssuerList;
    }

    @JsonProperty("github_com_jetstack_cert-manager_pkg_apis_certmanager_v1alpha2_ClusterIssuerList")
    public void setGithubComJetstackCertManagerPkgApisCertmanagerV1alpha2ClusterIssuerList(ClusterIssuerList githubComJetstackCertManagerPkgApisCertmanagerV1alpha2ClusterIssuerList) {
        this.githubComJetstackCertManagerPkgApisCertmanagerV1alpha2ClusterIssuerList = githubComJetstackCertManagerPkgApisCertmanagerV1alpha2ClusterIssuerList;
    }

    @JsonProperty("github_com_jetstack_cert-manager_pkg_apis_certmanager_v1alpha2_Issuer")
    public Issuer getGithubComJetstackCertManagerPkgApisCertmanagerV1alpha2Issuer() {
        return githubComJetstackCertManagerPkgApisCertmanagerV1alpha2Issuer;
    }

    @JsonProperty("github_com_jetstack_cert-manager_pkg_apis_certmanager_v1alpha2_Issuer")
    public void setGithubComJetstackCertManagerPkgApisCertmanagerV1alpha2Issuer(Issuer githubComJetstackCertManagerPkgApisCertmanagerV1alpha2Issuer) {
        this.githubComJetstackCertManagerPkgApisCertmanagerV1alpha2Issuer = githubComJetstackCertManagerPkgApisCertmanagerV1alpha2Issuer;
    }

    @JsonProperty("github_com_jetstack_cert-manager_pkg_apis_certmanager_v1alpha2_IssuerCondition")
    public IssuerCondition getGithubComJetstackCertManagerPkgApisCertmanagerV1alpha2IssuerCondition() {
        return githubComJetstackCertManagerPkgApisCertmanagerV1alpha2IssuerCondition;
    }

    @JsonProperty("github_com_jetstack_cert-manager_pkg_apis_certmanager_v1alpha2_IssuerCondition")
    public void setGithubComJetstackCertManagerPkgApisCertmanagerV1alpha2IssuerCondition(IssuerCondition githubComJetstackCertManagerPkgApisCertmanagerV1alpha2IssuerCondition) {
        this.githubComJetstackCertManagerPkgApisCertmanagerV1alpha2IssuerCondition = githubComJetstackCertManagerPkgApisCertmanagerV1alpha2IssuerCondition;
    }

    @JsonProperty("github_com_jetstack_cert-manager_pkg_apis_certmanager_v1alpha2_IssuerList")
    public IssuerList getGithubComJetstackCertManagerPkgApisCertmanagerV1alpha2IssuerList() {
        return githubComJetstackCertManagerPkgApisCertmanagerV1alpha2IssuerList;
    }

    @JsonProperty("github_com_jetstack_cert-manager_pkg_apis_certmanager_v1alpha2_IssuerList")
    public void setGithubComJetstackCertManagerPkgApisCertmanagerV1alpha2IssuerList(IssuerList githubComJetstackCertManagerPkgApisCertmanagerV1alpha2IssuerList) {
        this.githubComJetstackCertManagerPkgApisCertmanagerV1alpha2IssuerList = githubComJetstackCertManagerPkgApisCertmanagerV1alpha2IssuerList;
    }

    @JsonProperty("github_com_jetstack_cert-manager_pkg_apis_certmanager_v1alpha2_IssuerSpec")
    public IssuerSpec getGithubComJetstackCertManagerPkgApisCertmanagerV1alpha2IssuerSpec() {
        return githubComJetstackCertManagerPkgApisCertmanagerV1alpha2IssuerSpec;
    }

    @JsonProperty("github_com_jetstack_cert-manager_pkg_apis_certmanager_v1alpha2_IssuerSpec")
    public void setGithubComJetstackCertManagerPkgApisCertmanagerV1alpha2IssuerSpec(IssuerSpec githubComJetstackCertManagerPkgApisCertmanagerV1alpha2IssuerSpec) {
        this.githubComJetstackCertManagerPkgApisCertmanagerV1alpha2IssuerSpec = githubComJetstackCertManagerPkgApisCertmanagerV1alpha2IssuerSpec;
    }

    @JsonProperty("github_com_jetstack_cert-manager_pkg_apis_certmanager_v1alpha2_IssuerStatus")
    public IssuerStatus getGithubComJetstackCertManagerPkgApisCertmanagerV1alpha2IssuerStatus() {
        return githubComJetstackCertManagerPkgApisCertmanagerV1alpha2IssuerStatus;
    }

    @JsonProperty("github_com_jetstack_cert-manager_pkg_apis_certmanager_v1alpha2_IssuerStatus")
    public void setGithubComJetstackCertManagerPkgApisCertmanagerV1alpha2IssuerStatus(IssuerStatus githubComJetstackCertManagerPkgApisCertmanagerV1alpha2IssuerStatus) {
        this.githubComJetstackCertManagerPkgApisCertmanagerV1alpha2IssuerStatus = githubComJetstackCertManagerPkgApisCertmanagerV1alpha2IssuerStatus;
    }

    @JsonProperty("github_com_jetstack_cert-manager_pkg_apis_certmanager_v1alpha2_JKSKeystore")
    public JKSKeystore getGithubComJetstackCertManagerPkgApisCertmanagerV1alpha2JKSKeystore() {
        return githubComJetstackCertManagerPkgApisCertmanagerV1alpha2JKSKeystore;
    }

    @JsonProperty("github_com_jetstack_cert-manager_pkg_apis_certmanager_v1alpha2_JKSKeystore")
    public void setGithubComJetstackCertManagerPkgApisCertmanagerV1alpha2JKSKeystore(JKSKeystore githubComJetstackCertManagerPkgApisCertmanagerV1alpha2JKSKeystore) {
        this.githubComJetstackCertManagerPkgApisCertmanagerV1alpha2JKSKeystore = githubComJetstackCertManagerPkgApisCertmanagerV1alpha2JKSKeystore;
    }

    @JsonProperty("github_com_jetstack_cert-manager_pkg_apis_certmanager_v1alpha2_PKCS12Keystore")
    public PKCS12Keystore getGithubComJetstackCertManagerPkgApisCertmanagerV1alpha2PKCS12Keystore() {
        return githubComJetstackCertManagerPkgApisCertmanagerV1alpha2PKCS12Keystore;
    }

    @JsonProperty("github_com_jetstack_cert-manager_pkg_apis_certmanager_v1alpha2_PKCS12Keystore")
    public void setGithubComJetstackCertManagerPkgApisCertmanagerV1alpha2PKCS12Keystore(PKCS12Keystore githubComJetstackCertManagerPkgApisCertmanagerV1alpha2PKCS12Keystore) {
        this.githubComJetstackCertManagerPkgApisCertmanagerV1alpha2PKCS12Keystore = githubComJetstackCertManagerPkgApisCertmanagerV1alpha2PKCS12Keystore;
    }

    @JsonProperty("github_com_jetstack_cert-manager_pkg_apis_certmanager_v1alpha2_SelfSignedIssuer")
    public SelfSignedIssuer getGithubComJetstackCertManagerPkgApisCertmanagerV1alpha2SelfSignedIssuer() {
        return githubComJetstackCertManagerPkgApisCertmanagerV1alpha2SelfSignedIssuer;
    }

    @JsonProperty("github_com_jetstack_cert-manager_pkg_apis_certmanager_v1alpha2_SelfSignedIssuer")
    public void setGithubComJetstackCertManagerPkgApisCertmanagerV1alpha2SelfSignedIssuer(SelfSignedIssuer githubComJetstackCertManagerPkgApisCertmanagerV1alpha2SelfSignedIssuer) {
        this.githubComJetstackCertManagerPkgApisCertmanagerV1alpha2SelfSignedIssuer = githubComJetstackCertManagerPkgApisCertmanagerV1alpha2SelfSignedIssuer;
    }

    @JsonProperty("github_com_jetstack_cert-manager_pkg_apis_certmanager_v1alpha2_VaultAppRole")
    public VaultAppRole getGithubComJetstackCertManagerPkgApisCertmanagerV1alpha2VaultAppRole() {
        return githubComJetstackCertManagerPkgApisCertmanagerV1alpha2VaultAppRole;
    }

    @JsonProperty("github_com_jetstack_cert-manager_pkg_apis_certmanager_v1alpha2_VaultAppRole")
    public void setGithubComJetstackCertManagerPkgApisCertmanagerV1alpha2VaultAppRole(VaultAppRole githubComJetstackCertManagerPkgApisCertmanagerV1alpha2VaultAppRole) {
        this.githubComJetstackCertManagerPkgApisCertmanagerV1alpha2VaultAppRole = githubComJetstackCertManagerPkgApisCertmanagerV1alpha2VaultAppRole;
    }

    @JsonProperty("github_com_jetstack_cert-manager_pkg_apis_certmanager_v1alpha2_VaultAuth")
    public VaultAuth getGithubComJetstackCertManagerPkgApisCertmanagerV1alpha2VaultAuth() {
        return githubComJetstackCertManagerPkgApisCertmanagerV1alpha2VaultAuth;
    }

    @JsonProperty("github_com_jetstack_cert-manager_pkg_apis_certmanager_v1alpha2_VaultAuth")
    public void setGithubComJetstackCertManagerPkgApisCertmanagerV1alpha2VaultAuth(VaultAuth githubComJetstackCertManagerPkgApisCertmanagerV1alpha2VaultAuth) {
        this.githubComJetstackCertManagerPkgApisCertmanagerV1alpha2VaultAuth = githubComJetstackCertManagerPkgApisCertmanagerV1alpha2VaultAuth;
    }

    @JsonProperty("github_com_jetstack_cert-manager_pkg_apis_certmanager_v1alpha2_VaultIssuer")
    public VaultIssuer getGithubComJetstackCertManagerPkgApisCertmanagerV1alpha2VaultIssuer() {
        return githubComJetstackCertManagerPkgApisCertmanagerV1alpha2VaultIssuer;
    }

    @JsonProperty("github_com_jetstack_cert-manager_pkg_apis_certmanager_v1alpha2_VaultIssuer")
    public void setGithubComJetstackCertManagerPkgApisCertmanagerV1alpha2VaultIssuer(VaultIssuer githubComJetstackCertManagerPkgApisCertmanagerV1alpha2VaultIssuer) {
        this.githubComJetstackCertManagerPkgApisCertmanagerV1alpha2VaultIssuer = githubComJetstackCertManagerPkgApisCertmanagerV1alpha2VaultIssuer;
    }

    @JsonProperty("github_com_jetstack_cert-manager_pkg_apis_certmanager_v1alpha2_VaultKubernetesAuth")
    public VaultKubernetesAuth getGithubComJetstackCertManagerPkgApisCertmanagerV1alpha2VaultKubernetesAuth() {
        return githubComJetstackCertManagerPkgApisCertmanagerV1alpha2VaultKubernetesAuth;
    }

    @JsonProperty("github_com_jetstack_cert-manager_pkg_apis_certmanager_v1alpha2_VaultKubernetesAuth")
    public void setGithubComJetstackCertManagerPkgApisCertmanagerV1alpha2VaultKubernetesAuth(VaultKubernetesAuth githubComJetstackCertManagerPkgApisCertmanagerV1alpha2VaultKubernetesAuth) {
        this.githubComJetstackCertManagerPkgApisCertmanagerV1alpha2VaultKubernetesAuth = githubComJetstackCertManagerPkgApisCertmanagerV1alpha2VaultKubernetesAuth;
    }

    @JsonProperty("github_com_jetstack_cert-manager_pkg_apis_certmanager_v1alpha2_VenafiCloud")
    public VenafiCloud getGithubComJetstackCertManagerPkgApisCertmanagerV1alpha2VenafiCloud() {
        return githubComJetstackCertManagerPkgApisCertmanagerV1alpha2VenafiCloud;
    }

    @JsonProperty("github_com_jetstack_cert-manager_pkg_apis_certmanager_v1alpha2_VenafiCloud")
    public void setGithubComJetstackCertManagerPkgApisCertmanagerV1alpha2VenafiCloud(VenafiCloud githubComJetstackCertManagerPkgApisCertmanagerV1alpha2VenafiCloud) {
        this.githubComJetstackCertManagerPkgApisCertmanagerV1alpha2VenafiCloud = githubComJetstackCertManagerPkgApisCertmanagerV1alpha2VenafiCloud;
    }

    @JsonProperty("github_com_jetstack_cert-manager_pkg_apis_certmanager_v1alpha2_VenafiIssuer")
    public VenafiIssuer getGithubComJetstackCertManagerPkgApisCertmanagerV1alpha2VenafiIssuer() {
        return githubComJetstackCertManagerPkgApisCertmanagerV1alpha2VenafiIssuer;
    }

    @JsonProperty("github_com_jetstack_cert-manager_pkg_apis_certmanager_v1alpha2_VenafiIssuer")
    public void setGithubComJetstackCertManagerPkgApisCertmanagerV1alpha2VenafiIssuer(VenafiIssuer githubComJetstackCertManagerPkgApisCertmanagerV1alpha2VenafiIssuer) {
        this.githubComJetstackCertManagerPkgApisCertmanagerV1alpha2VenafiIssuer = githubComJetstackCertManagerPkgApisCertmanagerV1alpha2VenafiIssuer;
    }

    @JsonProperty("github_com_jetstack_cert-manager_pkg_apis_certmanager_v1alpha2_VenafiTPP")
    public VenafiTPP getGithubComJetstackCertManagerPkgApisCertmanagerV1alpha2VenafiTPP() {
        return githubComJetstackCertManagerPkgApisCertmanagerV1alpha2VenafiTPP;
    }

    @JsonProperty("github_com_jetstack_cert-manager_pkg_apis_certmanager_v1alpha2_VenafiTPP")
    public void setGithubComJetstackCertManagerPkgApisCertmanagerV1alpha2VenafiTPP(VenafiTPP githubComJetstackCertManagerPkgApisCertmanagerV1alpha2VenafiTPP) {
        this.githubComJetstackCertManagerPkgApisCertmanagerV1alpha2VenafiTPP = githubComJetstackCertManagerPkgApisCertmanagerV1alpha2VenafiTPP;
    }

    @JsonProperty("github_com_jetstack_cert-manager_pkg_apis_certmanager_v1alpha2_X509Subject")
    public X509Subject getGithubComJetstackCertManagerPkgApisCertmanagerV1alpha2X509Subject() {
        return githubComJetstackCertManagerPkgApisCertmanagerV1alpha2X509Subject;
    }

    @JsonProperty("github_com_jetstack_cert-manager_pkg_apis_certmanager_v1alpha2_X509Subject")
    public void setGithubComJetstackCertManagerPkgApisCertmanagerV1alpha2X509Subject(X509Subject githubComJetstackCertManagerPkgApisCertmanagerV1alpha2X509Subject) {
        this.githubComJetstackCertManagerPkgApisCertmanagerV1alpha2X509Subject = githubComJetstackCertManagerPkgApisCertmanagerV1alpha2X509Subject;
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
