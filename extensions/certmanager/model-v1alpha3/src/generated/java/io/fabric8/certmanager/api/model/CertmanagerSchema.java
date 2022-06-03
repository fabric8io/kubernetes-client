
package io.fabric8.certmanager.api.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import io.fabric8.certmanager.api.model.acme.v1alpha3.ACMEAuthorization;
import io.fabric8.certmanager.api.model.acme.v1alpha3.ACMEChallenge;
import io.fabric8.certmanager.api.model.acme.v1alpha3.ACMEChallengeSolver;
import io.fabric8.certmanager.api.model.acme.v1alpha3.ACMEChallengeSolverDNS01;
import io.fabric8.certmanager.api.model.acme.v1alpha3.ACMEChallengeSolverHTTP01;
import io.fabric8.certmanager.api.model.acme.v1alpha3.ACMEChallengeSolverHTTP01Ingress;
import io.fabric8.certmanager.api.model.acme.v1alpha3.ACMEChallengeSolverHTTP01IngressObjectMeta;
import io.fabric8.certmanager.api.model.acme.v1alpha3.ACMEChallengeSolverHTTP01IngressPodObjectMeta;
import io.fabric8.certmanager.api.model.acme.v1alpha3.ACMEChallengeSolverHTTP01IngressPodSpec;
import io.fabric8.certmanager.api.model.acme.v1alpha3.ACMEChallengeSolverHTTP01IngressPodTemplate;
import io.fabric8.certmanager.api.model.acme.v1alpha3.ACMEChallengeSolverHTTP01IngressTemplate;
import io.fabric8.certmanager.api.model.acme.v1alpha3.ACMEExternalAccountBinding;
import io.fabric8.certmanager.api.model.acme.v1alpha3.ACMEIssuer;
import io.fabric8.certmanager.api.model.acme.v1alpha3.ACMEIssuerDNS01ProviderAcmeDNS;
import io.fabric8.certmanager.api.model.acme.v1alpha3.ACMEIssuerDNS01ProviderAkamai;
import io.fabric8.certmanager.api.model.acme.v1alpha3.ACMEIssuerDNS01ProviderAzureDNS;
import io.fabric8.certmanager.api.model.acme.v1alpha3.ACMEIssuerDNS01ProviderCloudDNS;
import io.fabric8.certmanager.api.model.acme.v1alpha3.ACMEIssuerDNS01ProviderCloudflare;
import io.fabric8.certmanager.api.model.acme.v1alpha3.ACMEIssuerDNS01ProviderDigitalOcean;
import io.fabric8.certmanager.api.model.acme.v1alpha3.ACMEIssuerDNS01ProviderRFC2136;
import io.fabric8.certmanager.api.model.acme.v1alpha3.ACMEIssuerDNS01ProviderRoute53;
import io.fabric8.certmanager.api.model.acme.v1alpha3.ACMEIssuerDNS01ProviderWebhook;
import io.fabric8.certmanager.api.model.acme.v1alpha3.ACMEIssuerStatus;
import io.fabric8.certmanager.api.model.acme.v1alpha3.CertificateDNSNameSelector;
import io.fabric8.certmanager.api.model.acme.v1alpha3.Challenge;
import io.fabric8.certmanager.api.model.acme.v1alpha3.ChallengeList;
import io.fabric8.certmanager.api.model.acme.v1alpha3.ChallengeSpec;
import io.fabric8.certmanager.api.model.acme.v1alpha3.ChallengeStatus;
import io.fabric8.certmanager.api.model.acme.v1alpha3.Order;
import io.fabric8.certmanager.api.model.acme.v1alpha3.OrderList;
import io.fabric8.certmanager.api.model.acme.v1alpha3.OrderSpec;
import io.fabric8.certmanager.api.model.acme.v1alpha3.OrderStatus;
import io.fabric8.certmanager.api.model.meta.v1.SecretKeySelector;
import io.fabric8.certmanager.api.model.v1alpha3.CAIssuer;
import io.fabric8.certmanager.api.model.v1alpha3.Certificate;
import io.fabric8.certmanager.api.model.v1alpha3.CertificateCondition;
import io.fabric8.certmanager.api.model.v1alpha3.CertificateKeystores;
import io.fabric8.certmanager.api.model.v1alpha3.CertificateList;
import io.fabric8.certmanager.api.model.v1alpha3.CertificatePrivateKey;
import io.fabric8.certmanager.api.model.v1alpha3.CertificateRequest;
import io.fabric8.certmanager.api.model.v1alpha3.CertificateRequestCondition;
import io.fabric8.certmanager.api.model.v1alpha3.CertificateRequestList;
import io.fabric8.certmanager.api.model.v1alpha3.CertificateRequestSpec;
import io.fabric8.certmanager.api.model.v1alpha3.CertificateRequestStatus;
import io.fabric8.certmanager.api.model.v1alpha3.CertificateSpec;
import io.fabric8.certmanager.api.model.v1alpha3.CertificateStatus;
import io.fabric8.certmanager.api.model.v1alpha3.ClusterIssuer;
import io.fabric8.certmanager.api.model.v1alpha3.ClusterIssuerList;
import io.fabric8.certmanager.api.model.v1alpha3.Issuer;
import io.fabric8.certmanager.api.model.v1alpha3.IssuerCondition;
import io.fabric8.certmanager.api.model.v1alpha3.IssuerList;
import io.fabric8.certmanager.api.model.v1alpha3.IssuerSpec;
import io.fabric8.certmanager.api.model.v1alpha3.IssuerStatus;
import io.fabric8.certmanager.api.model.v1alpha3.JKSKeystore;
import io.fabric8.certmanager.api.model.v1alpha3.PKCS12Keystore;
import io.fabric8.certmanager.api.model.v1alpha3.SelfSignedIssuer;
import io.fabric8.certmanager.api.model.v1alpha3.VaultAppRole;
import io.fabric8.certmanager.api.model.v1alpha3.VaultAuth;
import io.fabric8.certmanager.api.model.v1alpha3.VaultIssuer;
import io.fabric8.certmanager.api.model.v1alpha3.VaultKubernetesAuth;
import io.fabric8.certmanager.api.model.v1alpha3.VenafiCloud;
import io.fabric8.certmanager.api.model.v1alpha3.VenafiIssuer;
import io.fabric8.certmanager.api.model.v1alpha3.VenafiTPP;
import io.fabric8.certmanager.api.model.v1alpha3.X509Subject;
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
    "github_com_jetstack_cert-manager_pkg_apis_acme_v1alpha3_ACMEAuthorization",
    "github_com_jetstack_cert-manager_pkg_apis_acme_v1alpha3_ACMEChallenge",
    "github_com_jetstack_cert-manager_pkg_apis_acme_v1alpha3_ACMEChallengeSolver",
    "github_com_jetstack_cert-manager_pkg_apis_acme_v1alpha3_ACMEChallengeSolverDNS01",
    "github_com_jetstack_cert-manager_pkg_apis_acme_v1alpha3_ACMEChallengeSolverHTTP01",
    "github_com_jetstack_cert-manager_pkg_apis_acme_v1alpha3_ACMEChallengeSolverHTTP01Ingress",
    "github_com_jetstack_cert-manager_pkg_apis_acme_v1alpha3_ACMEChallengeSolverHTTP01IngressObjectMeta",
    "github_com_jetstack_cert-manager_pkg_apis_acme_v1alpha3_ACMEChallengeSolverHTTP01IngressPodObjectMeta",
    "github_com_jetstack_cert-manager_pkg_apis_acme_v1alpha3_ACMEChallengeSolverHTTP01IngressPodSpec",
    "github_com_jetstack_cert-manager_pkg_apis_acme_v1alpha3_ACMEChallengeSolverHTTP01IngressPodTemplate",
    "github_com_jetstack_cert-manager_pkg_apis_acme_v1alpha3_ACMEChallengeSolverHTTP01IngressTemplate",
    "github_com_jetstack_cert-manager_pkg_apis_acme_v1alpha3_ACMEExternalAccountBinding",
    "github_com_jetstack_cert-manager_pkg_apis_acme_v1alpha3_ACMEIssuer",
    "github_com_jetstack_cert-manager_pkg_apis_acme_v1alpha3_ACMEIssuerDNS01ProviderAcmeDNS",
    "github_com_jetstack_cert-manager_pkg_apis_acme_v1alpha3_ACMEIssuerDNS01ProviderAkamai",
    "github_com_jetstack_cert-manager_pkg_apis_acme_v1alpha3_ACMEIssuerDNS01ProviderAzureDNS",
    "github_com_jetstack_cert-manager_pkg_apis_acme_v1alpha3_ACMEIssuerDNS01ProviderCloudDNS",
    "github_com_jetstack_cert-manager_pkg_apis_acme_v1alpha3_ACMEIssuerDNS01ProviderCloudflare",
    "github_com_jetstack_cert-manager_pkg_apis_acme_v1alpha3_ACMEIssuerDNS01ProviderDigitalOcean",
    "github_com_jetstack_cert-manager_pkg_apis_acme_v1alpha3_ACMEIssuerDNS01ProviderRFC2136",
    "github_com_jetstack_cert-manager_pkg_apis_acme_v1alpha3_ACMEIssuerDNS01ProviderRoute53",
    "github_com_jetstack_cert-manager_pkg_apis_acme_v1alpha3_ACMEIssuerDNS01ProviderWebhook",
    "github_com_jetstack_cert-manager_pkg_apis_acme_v1alpha3_ACMEIssuerStatus",
    "github_com_jetstack_cert-manager_pkg_apis_acme_v1alpha3_CertificateDNSNameSelector",
    "github_com_jetstack_cert-manager_pkg_apis_acme_v1alpha3_Challenge",
    "github_com_jetstack_cert-manager_pkg_apis_acme_v1alpha3_ChallengeList",
    "github_com_jetstack_cert-manager_pkg_apis_acme_v1alpha3_ChallengeSpec",
    "github_com_jetstack_cert-manager_pkg_apis_acme_v1alpha3_ChallengeStatus",
    "github_com_jetstack_cert-manager_pkg_apis_acme_v1alpha3_Order",
    "github_com_jetstack_cert-manager_pkg_apis_acme_v1alpha3_OrderList",
    "github_com_jetstack_cert-manager_pkg_apis_acme_v1alpha3_OrderSpec",
    "github_com_jetstack_cert-manager_pkg_apis_acme_v1alpha3_OrderStatus",
    "github_com_jetstack_cert-manager_pkg_apis_certmanager_v1alpha3_CAIssuer",
    "github_com_jetstack_cert-manager_pkg_apis_certmanager_v1alpha3_Certificate",
    "github_com_jetstack_cert-manager_pkg_apis_certmanager_v1alpha3_CertificateCondition",
    "github_com_jetstack_cert-manager_pkg_apis_certmanager_v1alpha3_CertificateKeystores",
    "github_com_jetstack_cert-manager_pkg_apis_certmanager_v1alpha3_CertificateList",
    "github_com_jetstack_cert-manager_pkg_apis_certmanager_v1alpha3_CertificatePrivateKey",
    "github_com_jetstack_cert-manager_pkg_apis_certmanager_v1alpha3_CertificateRequest",
    "github_com_jetstack_cert-manager_pkg_apis_certmanager_v1alpha3_CertificateRequestCondition",
    "github_com_jetstack_cert-manager_pkg_apis_certmanager_v1alpha3_CertificateRequestList",
    "github_com_jetstack_cert-manager_pkg_apis_certmanager_v1alpha3_CertificateRequestSpec",
    "github_com_jetstack_cert-manager_pkg_apis_certmanager_v1alpha3_CertificateRequestStatus",
    "github_com_jetstack_cert-manager_pkg_apis_certmanager_v1alpha3_CertificateSpec",
    "github_com_jetstack_cert-manager_pkg_apis_certmanager_v1alpha3_CertificateStatus",
    "github_com_jetstack_cert-manager_pkg_apis_certmanager_v1alpha3_ClusterIssuer",
    "github_com_jetstack_cert-manager_pkg_apis_certmanager_v1alpha3_ClusterIssuerList",
    "github_com_jetstack_cert-manager_pkg_apis_certmanager_v1alpha3_Issuer",
    "github_com_jetstack_cert-manager_pkg_apis_certmanager_v1alpha3_IssuerCondition",
    "github_com_jetstack_cert-manager_pkg_apis_certmanager_v1alpha3_IssuerList",
    "github_com_jetstack_cert-manager_pkg_apis_certmanager_v1alpha3_IssuerSpec",
    "github_com_jetstack_cert-manager_pkg_apis_certmanager_v1alpha3_IssuerStatus",
    "github_com_jetstack_cert-manager_pkg_apis_certmanager_v1alpha3_JKSKeystore",
    "github_com_jetstack_cert-manager_pkg_apis_certmanager_v1alpha3_PKCS12Keystore",
    "github_com_jetstack_cert-manager_pkg_apis_certmanager_v1alpha3_SelfSignedIssuer",
    "github_com_jetstack_cert-manager_pkg_apis_certmanager_v1alpha3_VaultAppRole",
    "github_com_jetstack_cert-manager_pkg_apis_certmanager_v1alpha3_VaultAuth",
    "github_com_jetstack_cert-manager_pkg_apis_certmanager_v1alpha3_VaultIssuer",
    "github_com_jetstack_cert-manager_pkg_apis_certmanager_v1alpha3_VaultKubernetesAuth",
    "github_com_jetstack_cert-manager_pkg_apis_certmanager_v1alpha3_VenafiCloud",
    "github_com_jetstack_cert-manager_pkg_apis_certmanager_v1alpha3_VenafiIssuer",
    "github_com_jetstack_cert-manager_pkg_apis_certmanager_v1alpha3_VenafiTPP",
    "github_com_jetstack_cert-manager_pkg_apis_certmanager_v1alpha3_X509Subject",
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

    @JsonProperty("github_com_jetstack_cert-manager_pkg_apis_acme_v1alpha3_ACMEAuthorization")
    private ACMEAuthorization githubComJetstackCertManagerPkgApisAcmeV1alpha3ACMEAuthorization;
    @JsonProperty("github_com_jetstack_cert-manager_pkg_apis_acme_v1alpha3_ACMEChallenge")
    private ACMEChallenge githubComJetstackCertManagerPkgApisAcmeV1alpha3ACMEChallenge;
    @JsonProperty("github_com_jetstack_cert-manager_pkg_apis_acme_v1alpha3_ACMEChallengeSolver")
    private ACMEChallengeSolver githubComJetstackCertManagerPkgApisAcmeV1alpha3ACMEChallengeSolver;
    @JsonProperty("github_com_jetstack_cert-manager_pkg_apis_acme_v1alpha3_ACMEChallengeSolverDNS01")
    private ACMEChallengeSolverDNS01 githubComJetstackCertManagerPkgApisAcmeV1alpha3ACMEChallengeSolverDNS01;
    @JsonProperty("github_com_jetstack_cert-manager_pkg_apis_acme_v1alpha3_ACMEChallengeSolverHTTP01")
    private ACMEChallengeSolverHTTP01 githubComJetstackCertManagerPkgApisAcmeV1alpha3ACMEChallengeSolverHTTP01;
    @JsonProperty("github_com_jetstack_cert-manager_pkg_apis_acme_v1alpha3_ACMEChallengeSolverHTTP01Ingress")
    private ACMEChallengeSolverHTTP01Ingress githubComJetstackCertManagerPkgApisAcmeV1alpha3ACMEChallengeSolverHTTP01Ingress;
    @JsonProperty("github_com_jetstack_cert-manager_pkg_apis_acme_v1alpha3_ACMEChallengeSolverHTTP01IngressObjectMeta")
    private ACMEChallengeSolverHTTP01IngressObjectMeta githubComJetstackCertManagerPkgApisAcmeV1alpha3ACMEChallengeSolverHTTP01IngressObjectMeta;
    @JsonProperty("github_com_jetstack_cert-manager_pkg_apis_acme_v1alpha3_ACMEChallengeSolverHTTP01IngressPodObjectMeta")
    private ACMEChallengeSolverHTTP01IngressPodObjectMeta githubComJetstackCertManagerPkgApisAcmeV1alpha3ACMEChallengeSolverHTTP01IngressPodObjectMeta;
    @JsonProperty("github_com_jetstack_cert-manager_pkg_apis_acme_v1alpha3_ACMEChallengeSolverHTTP01IngressPodSpec")
    private ACMEChallengeSolverHTTP01IngressPodSpec githubComJetstackCertManagerPkgApisAcmeV1alpha3ACMEChallengeSolverHTTP01IngressPodSpec;
    @JsonProperty("github_com_jetstack_cert-manager_pkg_apis_acme_v1alpha3_ACMEChallengeSolverHTTP01IngressPodTemplate")
    private ACMEChallengeSolverHTTP01IngressPodTemplate githubComJetstackCertManagerPkgApisAcmeV1alpha3ACMEChallengeSolverHTTP01IngressPodTemplate;
    @JsonProperty("github_com_jetstack_cert-manager_pkg_apis_acme_v1alpha3_ACMEChallengeSolverHTTP01IngressTemplate")
    private ACMEChallengeSolverHTTP01IngressTemplate githubComJetstackCertManagerPkgApisAcmeV1alpha3ACMEChallengeSolverHTTP01IngressTemplate;
    @JsonProperty("github_com_jetstack_cert-manager_pkg_apis_acme_v1alpha3_ACMEExternalAccountBinding")
    private ACMEExternalAccountBinding githubComJetstackCertManagerPkgApisAcmeV1alpha3ACMEExternalAccountBinding;
    @JsonProperty("github_com_jetstack_cert-manager_pkg_apis_acme_v1alpha3_ACMEIssuer")
    private ACMEIssuer githubComJetstackCertManagerPkgApisAcmeV1alpha3ACMEIssuer;
    @JsonProperty("github_com_jetstack_cert-manager_pkg_apis_acme_v1alpha3_ACMEIssuerDNS01ProviderAcmeDNS")
    private ACMEIssuerDNS01ProviderAcmeDNS githubComJetstackCertManagerPkgApisAcmeV1alpha3ACMEIssuerDNS01ProviderAcmeDNS;
    @JsonProperty("github_com_jetstack_cert-manager_pkg_apis_acme_v1alpha3_ACMEIssuerDNS01ProviderAkamai")
    private ACMEIssuerDNS01ProviderAkamai githubComJetstackCertManagerPkgApisAcmeV1alpha3ACMEIssuerDNS01ProviderAkamai;
    @JsonProperty("github_com_jetstack_cert-manager_pkg_apis_acme_v1alpha3_ACMEIssuerDNS01ProviderAzureDNS")
    private ACMEIssuerDNS01ProviderAzureDNS githubComJetstackCertManagerPkgApisAcmeV1alpha3ACMEIssuerDNS01ProviderAzureDNS;
    @JsonProperty("github_com_jetstack_cert-manager_pkg_apis_acme_v1alpha3_ACMEIssuerDNS01ProviderCloudDNS")
    private ACMEIssuerDNS01ProviderCloudDNS githubComJetstackCertManagerPkgApisAcmeV1alpha3ACMEIssuerDNS01ProviderCloudDNS;
    @JsonProperty("github_com_jetstack_cert-manager_pkg_apis_acme_v1alpha3_ACMEIssuerDNS01ProviderCloudflare")
    private ACMEIssuerDNS01ProviderCloudflare githubComJetstackCertManagerPkgApisAcmeV1alpha3ACMEIssuerDNS01ProviderCloudflare;
    @JsonProperty("github_com_jetstack_cert-manager_pkg_apis_acme_v1alpha3_ACMEIssuerDNS01ProviderDigitalOcean")
    private ACMEIssuerDNS01ProviderDigitalOcean githubComJetstackCertManagerPkgApisAcmeV1alpha3ACMEIssuerDNS01ProviderDigitalOcean;
    @JsonProperty("github_com_jetstack_cert-manager_pkg_apis_acme_v1alpha3_ACMEIssuerDNS01ProviderRFC2136")
    private ACMEIssuerDNS01ProviderRFC2136 githubComJetstackCertManagerPkgApisAcmeV1alpha3ACMEIssuerDNS01ProviderRFC2136;
    @JsonProperty("github_com_jetstack_cert-manager_pkg_apis_acme_v1alpha3_ACMEIssuerDNS01ProviderRoute53")
    private ACMEIssuerDNS01ProviderRoute53 githubComJetstackCertManagerPkgApisAcmeV1alpha3ACMEIssuerDNS01ProviderRoute53;
    @JsonProperty("github_com_jetstack_cert-manager_pkg_apis_acme_v1alpha3_ACMEIssuerDNS01ProviderWebhook")
    private ACMEIssuerDNS01ProviderWebhook githubComJetstackCertManagerPkgApisAcmeV1alpha3ACMEIssuerDNS01ProviderWebhook;
    @JsonProperty("github_com_jetstack_cert-manager_pkg_apis_acme_v1alpha3_ACMEIssuerStatus")
    private ACMEIssuerStatus githubComJetstackCertManagerPkgApisAcmeV1alpha3ACMEIssuerStatus;
    @JsonProperty("github_com_jetstack_cert-manager_pkg_apis_acme_v1alpha3_CertificateDNSNameSelector")
    private CertificateDNSNameSelector githubComJetstackCertManagerPkgApisAcmeV1alpha3CertificateDNSNameSelector;
    @JsonProperty("github_com_jetstack_cert-manager_pkg_apis_acme_v1alpha3_Challenge")
    private Challenge githubComJetstackCertManagerPkgApisAcmeV1alpha3Challenge;
    @JsonProperty("github_com_jetstack_cert-manager_pkg_apis_acme_v1alpha3_ChallengeList")
    private ChallengeList githubComJetstackCertManagerPkgApisAcmeV1alpha3ChallengeList;
    @JsonProperty("github_com_jetstack_cert-manager_pkg_apis_acme_v1alpha3_ChallengeSpec")
    private ChallengeSpec githubComJetstackCertManagerPkgApisAcmeV1alpha3ChallengeSpec;
    @JsonProperty("github_com_jetstack_cert-manager_pkg_apis_acme_v1alpha3_ChallengeStatus")
    private ChallengeStatus githubComJetstackCertManagerPkgApisAcmeV1alpha3ChallengeStatus;
    @JsonProperty("github_com_jetstack_cert-manager_pkg_apis_acme_v1alpha3_Order")
    private Order githubComJetstackCertManagerPkgApisAcmeV1alpha3Order;
    @JsonProperty("github_com_jetstack_cert-manager_pkg_apis_acme_v1alpha3_OrderList")
    private OrderList githubComJetstackCertManagerPkgApisAcmeV1alpha3OrderList;
    @JsonProperty("github_com_jetstack_cert-manager_pkg_apis_acme_v1alpha3_OrderSpec")
    private OrderSpec githubComJetstackCertManagerPkgApisAcmeV1alpha3OrderSpec;
    @JsonProperty("github_com_jetstack_cert-manager_pkg_apis_acme_v1alpha3_OrderStatus")
    private OrderStatus githubComJetstackCertManagerPkgApisAcmeV1alpha3OrderStatus;
    @JsonProperty("github_com_jetstack_cert-manager_pkg_apis_certmanager_v1alpha3_CAIssuer")
    private CAIssuer githubComJetstackCertManagerPkgApisCertmanagerV1alpha3CAIssuer;
    @JsonProperty("github_com_jetstack_cert-manager_pkg_apis_certmanager_v1alpha3_Certificate")
    private Certificate githubComJetstackCertManagerPkgApisCertmanagerV1alpha3Certificate;
    @JsonProperty("github_com_jetstack_cert-manager_pkg_apis_certmanager_v1alpha3_CertificateCondition")
    private CertificateCondition githubComJetstackCertManagerPkgApisCertmanagerV1alpha3CertificateCondition;
    @JsonProperty("github_com_jetstack_cert-manager_pkg_apis_certmanager_v1alpha3_CertificateKeystores")
    private CertificateKeystores githubComJetstackCertManagerPkgApisCertmanagerV1alpha3CertificateKeystores;
    @JsonProperty("github_com_jetstack_cert-manager_pkg_apis_certmanager_v1alpha3_CertificateList")
    private CertificateList githubComJetstackCertManagerPkgApisCertmanagerV1alpha3CertificateList;
    @JsonProperty("github_com_jetstack_cert-manager_pkg_apis_certmanager_v1alpha3_CertificatePrivateKey")
    private CertificatePrivateKey githubComJetstackCertManagerPkgApisCertmanagerV1alpha3CertificatePrivateKey;
    @JsonProperty("github_com_jetstack_cert-manager_pkg_apis_certmanager_v1alpha3_CertificateRequest")
    private CertificateRequest githubComJetstackCertManagerPkgApisCertmanagerV1alpha3CertificateRequest;
    @JsonProperty("github_com_jetstack_cert-manager_pkg_apis_certmanager_v1alpha3_CertificateRequestCondition")
    private CertificateRequestCondition githubComJetstackCertManagerPkgApisCertmanagerV1alpha3CertificateRequestCondition;
    @JsonProperty("github_com_jetstack_cert-manager_pkg_apis_certmanager_v1alpha3_CertificateRequestList")
    private CertificateRequestList githubComJetstackCertManagerPkgApisCertmanagerV1alpha3CertificateRequestList;
    @JsonProperty("github_com_jetstack_cert-manager_pkg_apis_certmanager_v1alpha3_CertificateRequestSpec")
    private CertificateRequestSpec githubComJetstackCertManagerPkgApisCertmanagerV1alpha3CertificateRequestSpec;
    @JsonProperty("github_com_jetstack_cert-manager_pkg_apis_certmanager_v1alpha3_CertificateRequestStatus")
    private CertificateRequestStatus githubComJetstackCertManagerPkgApisCertmanagerV1alpha3CertificateRequestStatus;
    @JsonProperty("github_com_jetstack_cert-manager_pkg_apis_certmanager_v1alpha3_CertificateSpec")
    private CertificateSpec githubComJetstackCertManagerPkgApisCertmanagerV1alpha3CertificateSpec;
    @JsonProperty("github_com_jetstack_cert-manager_pkg_apis_certmanager_v1alpha3_CertificateStatus")
    private CertificateStatus githubComJetstackCertManagerPkgApisCertmanagerV1alpha3CertificateStatus;
    @JsonProperty("github_com_jetstack_cert-manager_pkg_apis_certmanager_v1alpha3_ClusterIssuer")
    private ClusterIssuer githubComJetstackCertManagerPkgApisCertmanagerV1alpha3ClusterIssuer;
    @JsonProperty("github_com_jetstack_cert-manager_pkg_apis_certmanager_v1alpha3_ClusterIssuerList")
    private ClusterIssuerList githubComJetstackCertManagerPkgApisCertmanagerV1alpha3ClusterIssuerList;
    @JsonProperty("github_com_jetstack_cert-manager_pkg_apis_certmanager_v1alpha3_Issuer")
    private Issuer githubComJetstackCertManagerPkgApisCertmanagerV1alpha3Issuer;
    @JsonProperty("github_com_jetstack_cert-manager_pkg_apis_certmanager_v1alpha3_IssuerCondition")
    private IssuerCondition githubComJetstackCertManagerPkgApisCertmanagerV1alpha3IssuerCondition;
    @JsonProperty("github_com_jetstack_cert-manager_pkg_apis_certmanager_v1alpha3_IssuerList")
    private IssuerList githubComJetstackCertManagerPkgApisCertmanagerV1alpha3IssuerList;
    @JsonProperty("github_com_jetstack_cert-manager_pkg_apis_certmanager_v1alpha3_IssuerSpec")
    private IssuerSpec githubComJetstackCertManagerPkgApisCertmanagerV1alpha3IssuerSpec;
    @JsonProperty("github_com_jetstack_cert-manager_pkg_apis_certmanager_v1alpha3_IssuerStatus")
    private IssuerStatus githubComJetstackCertManagerPkgApisCertmanagerV1alpha3IssuerStatus;
    @JsonProperty("github_com_jetstack_cert-manager_pkg_apis_certmanager_v1alpha3_JKSKeystore")
    private JKSKeystore githubComJetstackCertManagerPkgApisCertmanagerV1alpha3JKSKeystore;
    @JsonProperty("github_com_jetstack_cert-manager_pkg_apis_certmanager_v1alpha3_PKCS12Keystore")
    private PKCS12Keystore githubComJetstackCertManagerPkgApisCertmanagerV1alpha3PKCS12Keystore;
    @JsonProperty("github_com_jetstack_cert-manager_pkg_apis_certmanager_v1alpha3_SelfSignedIssuer")
    private SelfSignedIssuer githubComJetstackCertManagerPkgApisCertmanagerV1alpha3SelfSignedIssuer;
    @JsonProperty("github_com_jetstack_cert-manager_pkg_apis_certmanager_v1alpha3_VaultAppRole")
    private VaultAppRole githubComJetstackCertManagerPkgApisCertmanagerV1alpha3VaultAppRole;
    @JsonProperty("github_com_jetstack_cert-manager_pkg_apis_certmanager_v1alpha3_VaultAuth")
    private VaultAuth githubComJetstackCertManagerPkgApisCertmanagerV1alpha3VaultAuth;
    @JsonProperty("github_com_jetstack_cert-manager_pkg_apis_certmanager_v1alpha3_VaultIssuer")
    private VaultIssuer githubComJetstackCertManagerPkgApisCertmanagerV1alpha3VaultIssuer;
    @JsonProperty("github_com_jetstack_cert-manager_pkg_apis_certmanager_v1alpha3_VaultKubernetesAuth")
    private VaultKubernetesAuth githubComJetstackCertManagerPkgApisCertmanagerV1alpha3VaultKubernetesAuth;
    @JsonProperty("github_com_jetstack_cert-manager_pkg_apis_certmanager_v1alpha3_VenafiCloud")
    private VenafiCloud githubComJetstackCertManagerPkgApisCertmanagerV1alpha3VenafiCloud;
    @JsonProperty("github_com_jetstack_cert-manager_pkg_apis_certmanager_v1alpha3_VenafiIssuer")
    private VenafiIssuer githubComJetstackCertManagerPkgApisCertmanagerV1alpha3VenafiIssuer;
    @JsonProperty("github_com_jetstack_cert-manager_pkg_apis_certmanager_v1alpha3_VenafiTPP")
    private VenafiTPP githubComJetstackCertManagerPkgApisCertmanagerV1alpha3VenafiTPP;
    @JsonProperty("github_com_jetstack_cert-manager_pkg_apis_certmanager_v1alpha3_X509Subject")
    private X509Subject githubComJetstackCertManagerPkgApisCertmanagerV1alpha3X509Subject;
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
     * @param githubComJetstackCertManagerPkgApisAcmeV1alpha3ACMEIssuerDNS01ProviderAkamai
     * @param githubComJetstackCertManagerPkgApisAcmeV1alpha3ACMEIssuerDNS01ProviderAcmeDNS
     * @param githubComJetstackCertManagerPkgApisAcmeV1alpha3ACMEChallengeSolverHTTP01IngressTemplate
     * @param githubComJetstackCertManagerPkgApisAcmeV1alpha3ACMEChallengeSolverHTTP01IngressObjectMeta
     * @param githubComJetstackCertManagerPkgApisAcmeV1alpha3CertificateDNSNameSelector
     * @param githubComJetstackCertManagerPkgApisCertmanagerV1alpha3CertificateCondition
     * @param githubComJetstackCertManagerPkgApisCertmanagerV1alpha3VaultIssuer
     * @param githubComJetstackCertManagerPkgApisAcmeV1alpha3ACMEIssuerStatus
     * @param githubComJetstackCertManagerPkgApisAcmeV1alpha3ACMEChallengeSolverHTTP01
     * @param githubComJetstackCertManagerPkgApisAcmeV1alpha3ACMEIssuerDNS01ProviderRFC2136
     * @param githubComJetstackCertManagerPkgApisCertmanagerV1alpha3CertificateRequestList
     * @param githubComJetstackCertManagerPkgApisAcmeV1alpha3ChallengeStatus
     * @param githubComJetstackCertManagerPkgApisAcmeV1alpha3ACMEChallengeSolver
     * @param githubComJetstackCertManagerPkgApisAcmeV1alpha3OrderSpec
     * @param githubComJetstackCertManagerPkgApisCertmanagerV1alpha3ClusterIssuer
     * @param githubComJetstackCertManagerPkgApisAcmeV1alpha3ACMEIssuerDNS01ProviderAzureDNS
     * @param githubComJetstackCertManagerPkgApisMetaV1ObjectReference
     * @param githubComJetstackCertManagerPkgApisCertmanagerV1alpha3VenafiCloud
     * @param githubComJetstackCertManagerPkgApisCertmanagerV1alpha3CertificateRequestCondition
     * @param githubComJetstackCertManagerPkgApisCertmanagerV1alpha3CertificatePrivateKey
     * @param githubComJetstackCertManagerPkgApisAcmeV1alpha3ACMEChallengeSolverHTTP01Ingress
     * @param githubComJetstackCertManagerPkgApisAcmeV1alpha3ACMEIssuerDNS01ProviderCloudflare
     * @param githubComJetstackCertManagerPkgApisAcmeV1alpha3ACMEChallengeSolverHTTP01IngressPodTemplate
     * @param githubComJetstackCertManagerPkgApisAcmeV1alpha3ACMEExternalAccountBinding
     * @param githubComJetstackCertManagerPkgApisAcmeV1alpha3ACMEAuthorization
     * @param githubComJetstackCertManagerPkgApisMetaV1SecretKeySelector
     * @param githubComJetstackCertManagerPkgApisAcmeV1alpha3ACMEIssuerDNS01ProviderWebhook
     * @param githubComJetstackCertManagerPkgApisAcmeV1alpha3ACMEIssuerDNS01ProviderDigitalOcean
     * @param githubComJetstackCertManagerPkgApisCertmanagerV1alpha3CertificateRequestSpec
     * @param githubComJetstackCertManagerPkgApisCertmanagerV1alpha3VaultKubernetesAuth
     * @param githubComJetstackCertManagerPkgApisCertmanagerV1alpha3PKCS12Keystore
     * @param githubComJetstackCertManagerPkgApisCertmanagerV1alpha3IssuerCondition
     * @param githubComJetstackCertManagerPkgApisCertmanagerV1alpha3VenafiIssuer
     * @param githubComJetstackCertManagerPkgApisCertmanagerV1alpha3CertificateRequest
     * @param githubComJetstackCertManagerPkgApisCertmanagerV1alpha3IssuerList
     * @param githubComJetstackCertManagerPkgApisCertmanagerV1alpha3IssuerStatus
     * @param githubComJetstackCertManagerPkgApisAcmeV1alpha3ACMEChallengeSolverDNS01
     * @param githubComJetstackCertManagerPkgApisCertmanagerV1alpha3ClusterIssuerList
     * @param githubComJetstackCertManagerPkgApisCertmanagerV1alpha3VenafiTPP
     * @param githubComJetstackCertManagerPkgApisCertmanagerV1alpha3Issuer
     * @param githubComJetstackCertManagerPkgApisCertmanagerV1alpha3CertificateSpec
     * @param githubComJetstackCertManagerPkgApisAcmeV1alpha3OrderList
     * @param githubComJetstackCertManagerPkgApisCertmanagerV1alpha3CertificateKeystores
     * @param githubComJetstackCertManagerPkgApisAcmeV1alpha3Order
     * @param githubComJetstackCertManagerPkgApisCertmanagerV1alpha3VaultAuth
     * @param githubComJetstackCertManagerPkgApisAcmeV1alpha3ACMEIssuerDNS01ProviderCloudDNS
     * @param githubComJetstackCertManagerPkgApisAcmeV1alpha3ChallengeSpec
     * @param githubComJetstackCertManagerPkgApisCertmanagerV1alpha3CertificateList
     * @param githubComJetstackCertManagerPkgApisCertmanagerV1alpha3SelfSignedIssuer
     * @param githubComJetstackCertManagerPkgApisCertmanagerV1alpha3CAIssuer
     * @param githubComJetstackCertManagerPkgApisAcmeV1alpha3ACMEIssuer
     * @param githubComJetstackCertManagerPkgApisCertmanagerV1alpha3IssuerSpec
     * @param githubComJetstackCertManagerPkgApisCertmanagerV1alpha3Certificate
     * @param githubComJetstackCertManagerPkgApisAcmeV1alpha3ACMEIssuerDNS01ProviderRoute53
     * @param githubComJetstackCertManagerPkgApisCertmanagerV1alpha3VaultAppRole
     * @param githubComJetstackCertManagerPkgApisMetaV1LocalObjectReference
     * @param githubComJetstackCertManagerPkgApisCertmanagerV1alpha3X509Subject
     * @param githubComJetstackCertManagerPkgApisAcmeV1alpha3ChallengeList
     * @param githubComJetstackCertManagerPkgApisCertmanagerV1alpha3CertificateStatus
     * @param githubComJetstackCertManagerPkgApisAcmeV1alpha3ACMEChallengeSolverHTTP01IngressPodObjectMeta
     * @param githubComJetstackCertManagerPkgApisAcmeV1alpha3Challenge
     * @param githubComJetstackCertManagerPkgApisCertmanagerV1alpha3CertificateRequestStatus
     * @param githubComJetstackCertManagerPkgApisCertmanagerV1alpha3JKSKeystore
     * @param githubComJetstackCertManagerPkgApisAcmeV1alpha3ACMEChallenge
     * @param githubComJetstackCertManagerPkgApisAcmeV1alpha3ACMEChallengeSolverHTTP01IngressPodSpec
     * @param githubComJetstackCertManagerPkgApisAcmeV1alpha3OrderStatus
     */
    public CertmanagerSchema(ACMEAuthorization githubComJetstackCertManagerPkgApisAcmeV1alpha3ACMEAuthorization, ACMEChallenge githubComJetstackCertManagerPkgApisAcmeV1alpha3ACMEChallenge, ACMEChallengeSolver githubComJetstackCertManagerPkgApisAcmeV1alpha3ACMEChallengeSolver, ACMEChallengeSolverDNS01 githubComJetstackCertManagerPkgApisAcmeV1alpha3ACMEChallengeSolverDNS01, ACMEChallengeSolverHTTP01 githubComJetstackCertManagerPkgApisAcmeV1alpha3ACMEChallengeSolverHTTP01, ACMEChallengeSolverHTTP01Ingress githubComJetstackCertManagerPkgApisAcmeV1alpha3ACMEChallengeSolverHTTP01Ingress, ACMEChallengeSolverHTTP01IngressObjectMeta githubComJetstackCertManagerPkgApisAcmeV1alpha3ACMEChallengeSolverHTTP01IngressObjectMeta, ACMEChallengeSolverHTTP01IngressPodObjectMeta githubComJetstackCertManagerPkgApisAcmeV1alpha3ACMEChallengeSolverHTTP01IngressPodObjectMeta, ACMEChallengeSolverHTTP01IngressPodSpec githubComJetstackCertManagerPkgApisAcmeV1alpha3ACMEChallengeSolverHTTP01IngressPodSpec, ACMEChallengeSolverHTTP01IngressPodTemplate githubComJetstackCertManagerPkgApisAcmeV1alpha3ACMEChallengeSolverHTTP01IngressPodTemplate, ACMEChallengeSolverHTTP01IngressTemplate githubComJetstackCertManagerPkgApisAcmeV1alpha3ACMEChallengeSolverHTTP01IngressTemplate, ACMEExternalAccountBinding githubComJetstackCertManagerPkgApisAcmeV1alpha3ACMEExternalAccountBinding, ACMEIssuer githubComJetstackCertManagerPkgApisAcmeV1alpha3ACMEIssuer, ACMEIssuerDNS01ProviderAcmeDNS githubComJetstackCertManagerPkgApisAcmeV1alpha3ACMEIssuerDNS01ProviderAcmeDNS, ACMEIssuerDNS01ProviderAkamai githubComJetstackCertManagerPkgApisAcmeV1alpha3ACMEIssuerDNS01ProviderAkamai, ACMEIssuerDNS01ProviderAzureDNS githubComJetstackCertManagerPkgApisAcmeV1alpha3ACMEIssuerDNS01ProviderAzureDNS, ACMEIssuerDNS01ProviderCloudDNS githubComJetstackCertManagerPkgApisAcmeV1alpha3ACMEIssuerDNS01ProviderCloudDNS, ACMEIssuerDNS01ProviderCloudflare githubComJetstackCertManagerPkgApisAcmeV1alpha3ACMEIssuerDNS01ProviderCloudflare, ACMEIssuerDNS01ProviderDigitalOcean githubComJetstackCertManagerPkgApisAcmeV1alpha3ACMEIssuerDNS01ProviderDigitalOcean, ACMEIssuerDNS01ProviderRFC2136 githubComJetstackCertManagerPkgApisAcmeV1alpha3ACMEIssuerDNS01ProviderRFC2136, ACMEIssuerDNS01ProviderRoute53 githubComJetstackCertManagerPkgApisAcmeV1alpha3ACMEIssuerDNS01ProviderRoute53, ACMEIssuerDNS01ProviderWebhook githubComJetstackCertManagerPkgApisAcmeV1alpha3ACMEIssuerDNS01ProviderWebhook, ACMEIssuerStatus githubComJetstackCertManagerPkgApisAcmeV1alpha3ACMEIssuerStatus, CertificateDNSNameSelector githubComJetstackCertManagerPkgApisAcmeV1alpha3CertificateDNSNameSelector, Challenge githubComJetstackCertManagerPkgApisAcmeV1alpha3Challenge, ChallengeList githubComJetstackCertManagerPkgApisAcmeV1alpha3ChallengeList, ChallengeSpec githubComJetstackCertManagerPkgApisAcmeV1alpha3ChallengeSpec, ChallengeStatus githubComJetstackCertManagerPkgApisAcmeV1alpha3ChallengeStatus, Order githubComJetstackCertManagerPkgApisAcmeV1alpha3Order, OrderList githubComJetstackCertManagerPkgApisAcmeV1alpha3OrderList, OrderSpec githubComJetstackCertManagerPkgApisAcmeV1alpha3OrderSpec, OrderStatus githubComJetstackCertManagerPkgApisAcmeV1alpha3OrderStatus, CAIssuer githubComJetstackCertManagerPkgApisCertmanagerV1alpha3CAIssuer, Certificate githubComJetstackCertManagerPkgApisCertmanagerV1alpha3Certificate, CertificateCondition githubComJetstackCertManagerPkgApisCertmanagerV1alpha3CertificateCondition, CertificateKeystores githubComJetstackCertManagerPkgApisCertmanagerV1alpha3CertificateKeystores, CertificateList githubComJetstackCertManagerPkgApisCertmanagerV1alpha3CertificateList, CertificatePrivateKey githubComJetstackCertManagerPkgApisCertmanagerV1alpha3CertificatePrivateKey, CertificateRequest githubComJetstackCertManagerPkgApisCertmanagerV1alpha3CertificateRequest, CertificateRequestCondition githubComJetstackCertManagerPkgApisCertmanagerV1alpha3CertificateRequestCondition, CertificateRequestList githubComJetstackCertManagerPkgApisCertmanagerV1alpha3CertificateRequestList, CertificateRequestSpec githubComJetstackCertManagerPkgApisCertmanagerV1alpha3CertificateRequestSpec, CertificateRequestStatus githubComJetstackCertManagerPkgApisCertmanagerV1alpha3CertificateRequestStatus, CertificateSpec githubComJetstackCertManagerPkgApisCertmanagerV1alpha3CertificateSpec, CertificateStatus githubComJetstackCertManagerPkgApisCertmanagerV1alpha3CertificateStatus, ClusterIssuer githubComJetstackCertManagerPkgApisCertmanagerV1alpha3ClusterIssuer, ClusterIssuerList githubComJetstackCertManagerPkgApisCertmanagerV1alpha3ClusterIssuerList, Issuer githubComJetstackCertManagerPkgApisCertmanagerV1alpha3Issuer, IssuerCondition githubComJetstackCertManagerPkgApisCertmanagerV1alpha3IssuerCondition, IssuerList githubComJetstackCertManagerPkgApisCertmanagerV1alpha3IssuerList, IssuerSpec githubComJetstackCertManagerPkgApisCertmanagerV1alpha3IssuerSpec, IssuerStatus githubComJetstackCertManagerPkgApisCertmanagerV1alpha3IssuerStatus, JKSKeystore githubComJetstackCertManagerPkgApisCertmanagerV1alpha3JKSKeystore, PKCS12Keystore githubComJetstackCertManagerPkgApisCertmanagerV1alpha3PKCS12Keystore, SelfSignedIssuer githubComJetstackCertManagerPkgApisCertmanagerV1alpha3SelfSignedIssuer, VaultAppRole githubComJetstackCertManagerPkgApisCertmanagerV1alpha3VaultAppRole, VaultAuth githubComJetstackCertManagerPkgApisCertmanagerV1alpha3VaultAuth, VaultIssuer githubComJetstackCertManagerPkgApisCertmanagerV1alpha3VaultIssuer, VaultKubernetesAuth githubComJetstackCertManagerPkgApisCertmanagerV1alpha3VaultKubernetesAuth, VenafiCloud githubComJetstackCertManagerPkgApisCertmanagerV1alpha3VenafiCloud, VenafiIssuer githubComJetstackCertManagerPkgApisCertmanagerV1alpha3VenafiIssuer, VenafiTPP githubComJetstackCertManagerPkgApisCertmanagerV1alpha3VenafiTPP, X509Subject githubComJetstackCertManagerPkgApisCertmanagerV1alpha3X509Subject, io.fabric8.certmanager.api.model.meta.v1.LocalObjectReference githubComJetstackCertManagerPkgApisMetaV1LocalObjectReference, io.fabric8.certmanager.api.model.meta.v1.ObjectReference githubComJetstackCertManagerPkgApisMetaV1ObjectReference, SecretKeySelector githubComJetstackCertManagerPkgApisMetaV1SecretKeySelector) {
        super();
        this.githubComJetstackCertManagerPkgApisAcmeV1alpha3ACMEAuthorization = githubComJetstackCertManagerPkgApisAcmeV1alpha3ACMEAuthorization;
        this.githubComJetstackCertManagerPkgApisAcmeV1alpha3ACMEChallenge = githubComJetstackCertManagerPkgApisAcmeV1alpha3ACMEChallenge;
        this.githubComJetstackCertManagerPkgApisAcmeV1alpha3ACMEChallengeSolver = githubComJetstackCertManagerPkgApisAcmeV1alpha3ACMEChallengeSolver;
        this.githubComJetstackCertManagerPkgApisAcmeV1alpha3ACMEChallengeSolverDNS01 = githubComJetstackCertManagerPkgApisAcmeV1alpha3ACMEChallengeSolverDNS01;
        this.githubComJetstackCertManagerPkgApisAcmeV1alpha3ACMEChallengeSolverHTTP01 = githubComJetstackCertManagerPkgApisAcmeV1alpha3ACMEChallengeSolverHTTP01;
        this.githubComJetstackCertManagerPkgApisAcmeV1alpha3ACMEChallengeSolverHTTP01Ingress = githubComJetstackCertManagerPkgApisAcmeV1alpha3ACMEChallengeSolverHTTP01Ingress;
        this.githubComJetstackCertManagerPkgApisAcmeV1alpha3ACMEChallengeSolverHTTP01IngressObjectMeta = githubComJetstackCertManagerPkgApisAcmeV1alpha3ACMEChallengeSolverHTTP01IngressObjectMeta;
        this.githubComJetstackCertManagerPkgApisAcmeV1alpha3ACMEChallengeSolverHTTP01IngressPodObjectMeta = githubComJetstackCertManagerPkgApisAcmeV1alpha3ACMEChallengeSolverHTTP01IngressPodObjectMeta;
        this.githubComJetstackCertManagerPkgApisAcmeV1alpha3ACMEChallengeSolverHTTP01IngressPodSpec = githubComJetstackCertManagerPkgApisAcmeV1alpha3ACMEChallengeSolverHTTP01IngressPodSpec;
        this.githubComJetstackCertManagerPkgApisAcmeV1alpha3ACMEChallengeSolverHTTP01IngressPodTemplate = githubComJetstackCertManagerPkgApisAcmeV1alpha3ACMEChallengeSolverHTTP01IngressPodTemplate;
        this.githubComJetstackCertManagerPkgApisAcmeV1alpha3ACMEChallengeSolverHTTP01IngressTemplate = githubComJetstackCertManagerPkgApisAcmeV1alpha3ACMEChallengeSolverHTTP01IngressTemplate;
        this.githubComJetstackCertManagerPkgApisAcmeV1alpha3ACMEExternalAccountBinding = githubComJetstackCertManagerPkgApisAcmeV1alpha3ACMEExternalAccountBinding;
        this.githubComJetstackCertManagerPkgApisAcmeV1alpha3ACMEIssuer = githubComJetstackCertManagerPkgApisAcmeV1alpha3ACMEIssuer;
        this.githubComJetstackCertManagerPkgApisAcmeV1alpha3ACMEIssuerDNS01ProviderAcmeDNS = githubComJetstackCertManagerPkgApisAcmeV1alpha3ACMEIssuerDNS01ProviderAcmeDNS;
        this.githubComJetstackCertManagerPkgApisAcmeV1alpha3ACMEIssuerDNS01ProviderAkamai = githubComJetstackCertManagerPkgApisAcmeV1alpha3ACMEIssuerDNS01ProviderAkamai;
        this.githubComJetstackCertManagerPkgApisAcmeV1alpha3ACMEIssuerDNS01ProviderAzureDNS = githubComJetstackCertManagerPkgApisAcmeV1alpha3ACMEIssuerDNS01ProviderAzureDNS;
        this.githubComJetstackCertManagerPkgApisAcmeV1alpha3ACMEIssuerDNS01ProviderCloudDNS = githubComJetstackCertManagerPkgApisAcmeV1alpha3ACMEIssuerDNS01ProviderCloudDNS;
        this.githubComJetstackCertManagerPkgApisAcmeV1alpha3ACMEIssuerDNS01ProviderCloudflare = githubComJetstackCertManagerPkgApisAcmeV1alpha3ACMEIssuerDNS01ProviderCloudflare;
        this.githubComJetstackCertManagerPkgApisAcmeV1alpha3ACMEIssuerDNS01ProviderDigitalOcean = githubComJetstackCertManagerPkgApisAcmeV1alpha3ACMEIssuerDNS01ProviderDigitalOcean;
        this.githubComJetstackCertManagerPkgApisAcmeV1alpha3ACMEIssuerDNS01ProviderRFC2136 = githubComJetstackCertManagerPkgApisAcmeV1alpha3ACMEIssuerDNS01ProviderRFC2136;
        this.githubComJetstackCertManagerPkgApisAcmeV1alpha3ACMEIssuerDNS01ProviderRoute53 = githubComJetstackCertManagerPkgApisAcmeV1alpha3ACMEIssuerDNS01ProviderRoute53;
        this.githubComJetstackCertManagerPkgApisAcmeV1alpha3ACMEIssuerDNS01ProviderWebhook = githubComJetstackCertManagerPkgApisAcmeV1alpha3ACMEIssuerDNS01ProviderWebhook;
        this.githubComJetstackCertManagerPkgApisAcmeV1alpha3ACMEIssuerStatus = githubComJetstackCertManagerPkgApisAcmeV1alpha3ACMEIssuerStatus;
        this.githubComJetstackCertManagerPkgApisAcmeV1alpha3CertificateDNSNameSelector = githubComJetstackCertManagerPkgApisAcmeV1alpha3CertificateDNSNameSelector;
        this.githubComJetstackCertManagerPkgApisAcmeV1alpha3Challenge = githubComJetstackCertManagerPkgApisAcmeV1alpha3Challenge;
        this.githubComJetstackCertManagerPkgApisAcmeV1alpha3ChallengeList = githubComJetstackCertManagerPkgApisAcmeV1alpha3ChallengeList;
        this.githubComJetstackCertManagerPkgApisAcmeV1alpha3ChallengeSpec = githubComJetstackCertManagerPkgApisAcmeV1alpha3ChallengeSpec;
        this.githubComJetstackCertManagerPkgApisAcmeV1alpha3ChallengeStatus = githubComJetstackCertManagerPkgApisAcmeV1alpha3ChallengeStatus;
        this.githubComJetstackCertManagerPkgApisAcmeV1alpha3Order = githubComJetstackCertManagerPkgApisAcmeV1alpha3Order;
        this.githubComJetstackCertManagerPkgApisAcmeV1alpha3OrderList = githubComJetstackCertManagerPkgApisAcmeV1alpha3OrderList;
        this.githubComJetstackCertManagerPkgApisAcmeV1alpha3OrderSpec = githubComJetstackCertManagerPkgApisAcmeV1alpha3OrderSpec;
        this.githubComJetstackCertManagerPkgApisAcmeV1alpha3OrderStatus = githubComJetstackCertManagerPkgApisAcmeV1alpha3OrderStatus;
        this.githubComJetstackCertManagerPkgApisCertmanagerV1alpha3CAIssuer = githubComJetstackCertManagerPkgApisCertmanagerV1alpha3CAIssuer;
        this.githubComJetstackCertManagerPkgApisCertmanagerV1alpha3Certificate = githubComJetstackCertManagerPkgApisCertmanagerV1alpha3Certificate;
        this.githubComJetstackCertManagerPkgApisCertmanagerV1alpha3CertificateCondition = githubComJetstackCertManagerPkgApisCertmanagerV1alpha3CertificateCondition;
        this.githubComJetstackCertManagerPkgApisCertmanagerV1alpha3CertificateKeystores = githubComJetstackCertManagerPkgApisCertmanagerV1alpha3CertificateKeystores;
        this.githubComJetstackCertManagerPkgApisCertmanagerV1alpha3CertificateList = githubComJetstackCertManagerPkgApisCertmanagerV1alpha3CertificateList;
        this.githubComJetstackCertManagerPkgApisCertmanagerV1alpha3CertificatePrivateKey = githubComJetstackCertManagerPkgApisCertmanagerV1alpha3CertificatePrivateKey;
        this.githubComJetstackCertManagerPkgApisCertmanagerV1alpha3CertificateRequest = githubComJetstackCertManagerPkgApisCertmanagerV1alpha3CertificateRequest;
        this.githubComJetstackCertManagerPkgApisCertmanagerV1alpha3CertificateRequestCondition = githubComJetstackCertManagerPkgApisCertmanagerV1alpha3CertificateRequestCondition;
        this.githubComJetstackCertManagerPkgApisCertmanagerV1alpha3CertificateRequestList = githubComJetstackCertManagerPkgApisCertmanagerV1alpha3CertificateRequestList;
        this.githubComJetstackCertManagerPkgApisCertmanagerV1alpha3CertificateRequestSpec = githubComJetstackCertManagerPkgApisCertmanagerV1alpha3CertificateRequestSpec;
        this.githubComJetstackCertManagerPkgApisCertmanagerV1alpha3CertificateRequestStatus = githubComJetstackCertManagerPkgApisCertmanagerV1alpha3CertificateRequestStatus;
        this.githubComJetstackCertManagerPkgApisCertmanagerV1alpha3CertificateSpec = githubComJetstackCertManagerPkgApisCertmanagerV1alpha3CertificateSpec;
        this.githubComJetstackCertManagerPkgApisCertmanagerV1alpha3CertificateStatus = githubComJetstackCertManagerPkgApisCertmanagerV1alpha3CertificateStatus;
        this.githubComJetstackCertManagerPkgApisCertmanagerV1alpha3ClusterIssuer = githubComJetstackCertManagerPkgApisCertmanagerV1alpha3ClusterIssuer;
        this.githubComJetstackCertManagerPkgApisCertmanagerV1alpha3ClusterIssuerList = githubComJetstackCertManagerPkgApisCertmanagerV1alpha3ClusterIssuerList;
        this.githubComJetstackCertManagerPkgApisCertmanagerV1alpha3Issuer = githubComJetstackCertManagerPkgApisCertmanagerV1alpha3Issuer;
        this.githubComJetstackCertManagerPkgApisCertmanagerV1alpha3IssuerCondition = githubComJetstackCertManagerPkgApisCertmanagerV1alpha3IssuerCondition;
        this.githubComJetstackCertManagerPkgApisCertmanagerV1alpha3IssuerList = githubComJetstackCertManagerPkgApisCertmanagerV1alpha3IssuerList;
        this.githubComJetstackCertManagerPkgApisCertmanagerV1alpha3IssuerSpec = githubComJetstackCertManagerPkgApisCertmanagerV1alpha3IssuerSpec;
        this.githubComJetstackCertManagerPkgApisCertmanagerV1alpha3IssuerStatus = githubComJetstackCertManagerPkgApisCertmanagerV1alpha3IssuerStatus;
        this.githubComJetstackCertManagerPkgApisCertmanagerV1alpha3JKSKeystore = githubComJetstackCertManagerPkgApisCertmanagerV1alpha3JKSKeystore;
        this.githubComJetstackCertManagerPkgApisCertmanagerV1alpha3PKCS12Keystore = githubComJetstackCertManagerPkgApisCertmanagerV1alpha3PKCS12Keystore;
        this.githubComJetstackCertManagerPkgApisCertmanagerV1alpha3SelfSignedIssuer = githubComJetstackCertManagerPkgApisCertmanagerV1alpha3SelfSignedIssuer;
        this.githubComJetstackCertManagerPkgApisCertmanagerV1alpha3VaultAppRole = githubComJetstackCertManagerPkgApisCertmanagerV1alpha3VaultAppRole;
        this.githubComJetstackCertManagerPkgApisCertmanagerV1alpha3VaultAuth = githubComJetstackCertManagerPkgApisCertmanagerV1alpha3VaultAuth;
        this.githubComJetstackCertManagerPkgApisCertmanagerV1alpha3VaultIssuer = githubComJetstackCertManagerPkgApisCertmanagerV1alpha3VaultIssuer;
        this.githubComJetstackCertManagerPkgApisCertmanagerV1alpha3VaultKubernetesAuth = githubComJetstackCertManagerPkgApisCertmanagerV1alpha3VaultKubernetesAuth;
        this.githubComJetstackCertManagerPkgApisCertmanagerV1alpha3VenafiCloud = githubComJetstackCertManagerPkgApisCertmanagerV1alpha3VenafiCloud;
        this.githubComJetstackCertManagerPkgApisCertmanagerV1alpha3VenafiIssuer = githubComJetstackCertManagerPkgApisCertmanagerV1alpha3VenafiIssuer;
        this.githubComJetstackCertManagerPkgApisCertmanagerV1alpha3VenafiTPP = githubComJetstackCertManagerPkgApisCertmanagerV1alpha3VenafiTPP;
        this.githubComJetstackCertManagerPkgApisCertmanagerV1alpha3X509Subject = githubComJetstackCertManagerPkgApisCertmanagerV1alpha3X509Subject;
        this.githubComJetstackCertManagerPkgApisMetaV1LocalObjectReference = githubComJetstackCertManagerPkgApisMetaV1LocalObjectReference;
        this.githubComJetstackCertManagerPkgApisMetaV1ObjectReference = githubComJetstackCertManagerPkgApisMetaV1ObjectReference;
        this.githubComJetstackCertManagerPkgApisMetaV1SecretKeySelector = githubComJetstackCertManagerPkgApisMetaV1SecretKeySelector;
    }

    @JsonProperty("github_com_jetstack_cert-manager_pkg_apis_acme_v1alpha3_ACMEAuthorization")
    public ACMEAuthorization getGithubComJetstackCertManagerPkgApisAcmeV1alpha3ACMEAuthorization() {
        return githubComJetstackCertManagerPkgApisAcmeV1alpha3ACMEAuthorization;
    }

    @JsonProperty("github_com_jetstack_cert-manager_pkg_apis_acme_v1alpha3_ACMEAuthorization")
    public void setGithubComJetstackCertManagerPkgApisAcmeV1alpha3ACMEAuthorization(ACMEAuthorization githubComJetstackCertManagerPkgApisAcmeV1alpha3ACMEAuthorization) {
        this.githubComJetstackCertManagerPkgApisAcmeV1alpha3ACMEAuthorization = githubComJetstackCertManagerPkgApisAcmeV1alpha3ACMEAuthorization;
    }

    @JsonProperty("github_com_jetstack_cert-manager_pkg_apis_acme_v1alpha3_ACMEChallenge")
    public ACMEChallenge getGithubComJetstackCertManagerPkgApisAcmeV1alpha3ACMEChallenge() {
        return githubComJetstackCertManagerPkgApisAcmeV1alpha3ACMEChallenge;
    }

    @JsonProperty("github_com_jetstack_cert-manager_pkg_apis_acme_v1alpha3_ACMEChallenge")
    public void setGithubComJetstackCertManagerPkgApisAcmeV1alpha3ACMEChallenge(ACMEChallenge githubComJetstackCertManagerPkgApisAcmeV1alpha3ACMEChallenge) {
        this.githubComJetstackCertManagerPkgApisAcmeV1alpha3ACMEChallenge = githubComJetstackCertManagerPkgApisAcmeV1alpha3ACMEChallenge;
    }

    @JsonProperty("github_com_jetstack_cert-manager_pkg_apis_acme_v1alpha3_ACMEChallengeSolver")
    public ACMEChallengeSolver getGithubComJetstackCertManagerPkgApisAcmeV1alpha3ACMEChallengeSolver() {
        return githubComJetstackCertManagerPkgApisAcmeV1alpha3ACMEChallengeSolver;
    }

    @JsonProperty("github_com_jetstack_cert-manager_pkg_apis_acme_v1alpha3_ACMEChallengeSolver")
    public void setGithubComJetstackCertManagerPkgApisAcmeV1alpha3ACMEChallengeSolver(ACMEChallengeSolver githubComJetstackCertManagerPkgApisAcmeV1alpha3ACMEChallengeSolver) {
        this.githubComJetstackCertManagerPkgApisAcmeV1alpha3ACMEChallengeSolver = githubComJetstackCertManagerPkgApisAcmeV1alpha3ACMEChallengeSolver;
    }

    @JsonProperty("github_com_jetstack_cert-manager_pkg_apis_acme_v1alpha3_ACMEChallengeSolverDNS01")
    public ACMEChallengeSolverDNS01 getGithubComJetstackCertManagerPkgApisAcmeV1alpha3ACMEChallengeSolverDNS01() {
        return githubComJetstackCertManagerPkgApisAcmeV1alpha3ACMEChallengeSolverDNS01;
    }

    @JsonProperty("github_com_jetstack_cert-manager_pkg_apis_acme_v1alpha3_ACMEChallengeSolverDNS01")
    public void setGithubComJetstackCertManagerPkgApisAcmeV1alpha3ACMEChallengeSolverDNS01(ACMEChallengeSolverDNS01 githubComJetstackCertManagerPkgApisAcmeV1alpha3ACMEChallengeSolverDNS01) {
        this.githubComJetstackCertManagerPkgApisAcmeV1alpha3ACMEChallengeSolverDNS01 = githubComJetstackCertManagerPkgApisAcmeV1alpha3ACMEChallengeSolverDNS01;
    }

    @JsonProperty("github_com_jetstack_cert-manager_pkg_apis_acme_v1alpha3_ACMEChallengeSolverHTTP01")
    public ACMEChallengeSolverHTTP01 getGithubComJetstackCertManagerPkgApisAcmeV1alpha3ACMEChallengeSolverHTTP01() {
        return githubComJetstackCertManagerPkgApisAcmeV1alpha3ACMEChallengeSolverHTTP01;
    }

    @JsonProperty("github_com_jetstack_cert-manager_pkg_apis_acme_v1alpha3_ACMEChallengeSolverHTTP01")
    public void setGithubComJetstackCertManagerPkgApisAcmeV1alpha3ACMEChallengeSolverHTTP01(ACMEChallengeSolverHTTP01 githubComJetstackCertManagerPkgApisAcmeV1alpha3ACMEChallengeSolverHTTP01) {
        this.githubComJetstackCertManagerPkgApisAcmeV1alpha3ACMEChallengeSolverHTTP01 = githubComJetstackCertManagerPkgApisAcmeV1alpha3ACMEChallengeSolverHTTP01;
    }

    @JsonProperty("github_com_jetstack_cert-manager_pkg_apis_acme_v1alpha3_ACMEChallengeSolverHTTP01Ingress")
    public ACMEChallengeSolverHTTP01Ingress getGithubComJetstackCertManagerPkgApisAcmeV1alpha3ACMEChallengeSolverHTTP01Ingress() {
        return githubComJetstackCertManagerPkgApisAcmeV1alpha3ACMEChallengeSolverHTTP01Ingress;
    }

    @JsonProperty("github_com_jetstack_cert-manager_pkg_apis_acme_v1alpha3_ACMEChallengeSolverHTTP01Ingress")
    public void setGithubComJetstackCertManagerPkgApisAcmeV1alpha3ACMEChallengeSolverHTTP01Ingress(ACMEChallengeSolverHTTP01Ingress githubComJetstackCertManagerPkgApisAcmeV1alpha3ACMEChallengeSolverHTTP01Ingress) {
        this.githubComJetstackCertManagerPkgApisAcmeV1alpha3ACMEChallengeSolverHTTP01Ingress = githubComJetstackCertManagerPkgApisAcmeV1alpha3ACMEChallengeSolverHTTP01Ingress;
    }

    @JsonProperty("github_com_jetstack_cert-manager_pkg_apis_acme_v1alpha3_ACMEChallengeSolverHTTP01IngressObjectMeta")
    public ACMEChallengeSolverHTTP01IngressObjectMeta getGithubComJetstackCertManagerPkgApisAcmeV1alpha3ACMEChallengeSolverHTTP01IngressObjectMeta() {
        return githubComJetstackCertManagerPkgApisAcmeV1alpha3ACMEChallengeSolverHTTP01IngressObjectMeta;
    }

    @JsonProperty("github_com_jetstack_cert-manager_pkg_apis_acme_v1alpha3_ACMEChallengeSolverHTTP01IngressObjectMeta")
    public void setGithubComJetstackCertManagerPkgApisAcmeV1alpha3ACMEChallengeSolverHTTP01IngressObjectMeta(ACMEChallengeSolverHTTP01IngressObjectMeta githubComJetstackCertManagerPkgApisAcmeV1alpha3ACMEChallengeSolverHTTP01IngressObjectMeta) {
        this.githubComJetstackCertManagerPkgApisAcmeV1alpha3ACMEChallengeSolverHTTP01IngressObjectMeta = githubComJetstackCertManagerPkgApisAcmeV1alpha3ACMEChallengeSolverHTTP01IngressObjectMeta;
    }

    @JsonProperty("github_com_jetstack_cert-manager_pkg_apis_acme_v1alpha3_ACMEChallengeSolverHTTP01IngressPodObjectMeta")
    public ACMEChallengeSolverHTTP01IngressPodObjectMeta getGithubComJetstackCertManagerPkgApisAcmeV1alpha3ACMEChallengeSolverHTTP01IngressPodObjectMeta() {
        return githubComJetstackCertManagerPkgApisAcmeV1alpha3ACMEChallengeSolverHTTP01IngressPodObjectMeta;
    }

    @JsonProperty("github_com_jetstack_cert-manager_pkg_apis_acme_v1alpha3_ACMEChallengeSolverHTTP01IngressPodObjectMeta")
    public void setGithubComJetstackCertManagerPkgApisAcmeV1alpha3ACMEChallengeSolverHTTP01IngressPodObjectMeta(ACMEChallengeSolverHTTP01IngressPodObjectMeta githubComJetstackCertManagerPkgApisAcmeV1alpha3ACMEChallengeSolverHTTP01IngressPodObjectMeta) {
        this.githubComJetstackCertManagerPkgApisAcmeV1alpha3ACMEChallengeSolverHTTP01IngressPodObjectMeta = githubComJetstackCertManagerPkgApisAcmeV1alpha3ACMEChallengeSolverHTTP01IngressPodObjectMeta;
    }

    @JsonProperty("github_com_jetstack_cert-manager_pkg_apis_acme_v1alpha3_ACMEChallengeSolverHTTP01IngressPodSpec")
    public ACMEChallengeSolverHTTP01IngressPodSpec getGithubComJetstackCertManagerPkgApisAcmeV1alpha3ACMEChallengeSolverHTTP01IngressPodSpec() {
        return githubComJetstackCertManagerPkgApisAcmeV1alpha3ACMEChallengeSolverHTTP01IngressPodSpec;
    }

    @JsonProperty("github_com_jetstack_cert-manager_pkg_apis_acme_v1alpha3_ACMEChallengeSolverHTTP01IngressPodSpec")
    public void setGithubComJetstackCertManagerPkgApisAcmeV1alpha3ACMEChallengeSolverHTTP01IngressPodSpec(ACMEChallengeSolverHTTP01IngressPodSpec githubComJetstackCertManagerPkgApisAcmeV1alpha3ACMEChallengeSolverHTTP01IngressPodSpec) {
        this.githubComJetstackCertManagerPkgApisAcmeV1alpha3ACMEChallengeSolverHTTP01IngressPodSpec = githubComJetstackCertManagerPkgApisAcmeV1alpha3ACMEChallengeSolverHTTP01IngressPodSpec;
    }

    @JsonProperty("github_com_jetstack_cert-manager_pkg_apis_acme_v1alpha3_ACMEChallengeSolverHTTP01IngressPodTemplate")
    public ACMEChallengeSolverHTTP01IngressPodTemplate getGithubComJetstackCertManagerPkgApisAcmeV1alpha3ACMEChallengeSolverHTTP01IngressPodTemplate() {
        return githubComJetstackCertManagerPkgApisAcmeV1alpha3ACMEChallengeSolverHTTP01IngressPodTemplate;
    }

    @JsonProperty("github_com_jetstack_cert-manager_pkg_apis_acme_v1alpha3_ACMEChallengeSolverHTTP01IngressPodTemplate")
    public void setGithubComJetstackCertManagerPkgApisAcmeV1alpha3ACMEChallengeSolverHTTP01IngressPodTemplate(ACMEChallengeSolverHTTP01IngressPodTemplate githubComJetstackCertManagerPkgApisAcmeV1alpha3ACMEChallengeSolverHTTP01IngressPodTemplate) {
        this.githubComJetstackCertManagerPkgApisAcmeV1alpha3ACMEChallengeSolverHTTP01IngressPodTemplate = githubComJetstackCertManagerPkgApisAcmeV1alpha3ACMEChallengeSolverHTTP01IngressPodTemplate;
    }

    @JsonProperty("github_com_jetstack_cert-manager_pkg_apis_acme_v1alpha3_ACMEChallengeSolverHTTP01IngressTemplate")
    public ACMEChallengeSolverHTTP01IngressTemplate getGithubComJetstackCertManagerPkgApisAcmeV1alpha3ACMEChallengeSolverHTTP01IngressTemplate() {
        return githubComJetstackCertManagerPkgApisAcmeV1alpha3ACMEChallengeSolverHTTP01IngressTemplate;
    }

    @JsonProperty("github_com_jetstack_cert-manager_pkg_apis_acme_v1alpha3_ACMEChallengeSolverHTTP01IngressTemplate")
    public void setGithubComJetstackCertManagerPkgApisAcmeV1alpha3ACMEChallengeSolverHTTP01IngressTemplate(ACMEChallengeSolverHTTP01IngressTemplate githubComJetstackCertManagerPkgApisAcmeV1alpha3ACMEChallengeSolverHTTP01IngressTemplate) {
        this.githubComJetstackCertManagerPkgApisAcmeV1alpha3ACMEChallengeSolverHTTP01IngressTemplate = githubComJetstackCertManagerPkgApisAcmeV1alpha3ACMEChallengeSolverHTTP01IngressTemplate;
    }

    @JsonProperty("github_com_jetstack_cert-manager_pkg_apis_acme_v1alpha3_ACMEExternalAccountBinding")
    public ACMEExternalAccountBinding getGithubComJetstackCertManagerPkgApisAcmeV1alpha3ACMEExternalAccountBinding() {
        return githubComJetstackCertManagerPkgApisAcmeV1alpha3ACMEExternalAccountBinding;
    }

    @JsonProperty("github_com_jetstack_cert-manager_pkg_apis_acme_v1alpha3_ACMEExternalAccountBinding")
    public void setGithubComJetstackCertManagerPkgApisAcmeV1alpha3ACMEExternalAccountBinding(ACMEExternalAccountBinding githubComJetstackCertManagerPkgApisAcmeV1alpha3ACMEExternalAccountBinding) {
        this.githubComJetstackCertManagerPkgApisAcmeV1alpha3ACMEExternalAccountBinding = githubComJetstackCertManagerPkgApisAcmeV1alpha3ACMEExternalAccountBinding;
    }

    @JsonProperty("github_com_jetstack_cert-manager_pkg_apis_acme_v1alpha3_ACMEIssuer")
    public ACMEIssuer getGithubComJetstackCertManagerPkgApisAcmeV1alpha3ACMEIssuer() {
        return githubComJetstackCertManagerPkgApisAcmeV1alpha3ACMEIssuer;
    }

    @JsonProperty("github_com_jetstack_cert-manager_pkg_apis_acme_v1alpha3_ACMEIssuer")
    public void setGithubComJetstackCertManagerPkgApisAcmeV1alpha3ACMEIssuer(ACMEIssuer githubComJetstackCertManagerPkgApisAcmeV1alpha3ACMEIssuer) {
        this.githubComJetstackCertManagerPkgApisAcmeV1alpha3ACMEIssuer = githubComJetstackCertManagerPkgApisAcmeV1alpha3ACMEIssuer;
    }

    @JsonProperty("github_com_jetstack_cert-manager_pkg_apis_acme_v1alpha3_ACMEIssuerDNS01ProviderAcmeDNS")
    public ACMEIssuerDNS01ProviderAcmeDNS getGithubComJetstackCertManagerPkgApisAcmeV1alpha3ACMEIssuerDNS01ProviderAcmeDNS() {
        return githubComJetstackCertManagerPkgApisAcmeV1alpha3ACMEIssuerDNS01ProviderAcmeDNS;
    }

    @JsonProperty("github_com_jetstack_cert-manager_pkg_apis_acme_v1alpha3_ACMEIssuerDNS01ProviderAcmeDNS")
    public void setGithubComJetstackCertManagerPkgApisAcmeV1alpha3ACMEIssuerDNS01ProviderAcmeDNS(ACMEIssuerDNS01ProviderAcmeDNS githubComJetstackCertManagerPkgApisAcmeV1alpha3ACMEIssuerDNS01ProviderAcmeDNS) {
        this.githubComJetstackCertManagerPkgApisAcmeV1alpha3ACMEIssuerDNS01ProviderAcmeDNS = githubComJetstackCertManagerPkgApisAcmeV1alpha3ACMEIssuerDNS01ProviderAcmeDNS;
    }

    @JsonProperty("github_com_jetstack_cert-manager_pkg_apis_acme_v1alpha3_ACMEIssuerDNS01ProviderAkamai")
    public ACMEIssuerDNS01ProviderAkamai getGithubComJetstackCertManagerPkgApisAcmeV1alpha3ACMEIssuerDNS01ProviderAkamai() {
        return githubComJetstackCertManagerPkgApisAcmeV1alpha3ACMEIssuerDNS01ProviderAkamai;
    }

    @JsonProperty("github_com_jetstack_cert-manager_pkg_apis_acme_v1alpha3_ACMEIssuerDNS01ProviderAkamai")
    public void setGithubComJetstackCertManagerPkgApisAcmeV1alpha3ACMEIssuerDNS01ProviderAkamai(ACMEIssuerDNS01ProviderAkamai githubComJetstackCertManagerPkgApisAcmeV1alpha3ACMEIssuerDNS01ProviderAkamai) {
        this.githubComJetstackCertManagerPkgApisAcmeV1alpha3ACMEIssuerDNS01ProviderAkamai = githubComJetstackCertManagerPkgApisAcmeV1alpha3ACMEIssuerDNS01ProviderAkamai;
    }

    @JsonProperty("github_com_jetstack_cert-manager_pkg_apis_acme_v1alpha3_ACMEIssuerDNS01ProviderAzureDNS")
    public ACMEIssuerDNS01ProviderAzureDNS getGithubComJetstackCertManagerPkgApisAcmeV1alpha3ACMEIssuerDNS01ProviderAzureDNS() {
        return githubComJetstackCertManagerPkgApisAcmeV1alpha3ACMEIssuerDNS01ProviderAzureDNS;
    }

    @JsonProperty("github_com_jetstack_cert-manager_pkg_apis_acme_v1alpha3_ACMEIssuerDNS01ProviderAzureDNS")
    public void setGithubComJetstackCertManagerPkgApisAcmeV1alpha3ACMEIssuerDNS01ProviderAzureDNS(ACMEIssuerDNS01ProviderAzureDNS githubComJetstackCertManagerPkgApisAcmeV1alpha3ACMEIssuerDNS01ProviderAzureDNS) {
        this.githubComJetstackCertManagerPkgApisAcmeV1alpha3ACMEIssuerDNS01ProviderAzureDNS = githubComJetstackCertManagerPkgApisAcmeV1alpha3ACMEIssuerDNS01ProviderAzureDNS;
    }

    @JsonProperty("github_com_jetstack_cert-manager_pkg_apis_acme_v1alpha3_ACMEIssuerDNS01ProviderCloudDNS")
    public ACMEIssuerDNS01ProviderCloudDNS getGithubComJetstackCertManagerPkgApisAcmeV1alpha3ACMEIssuerDNS01ProviderCloudDNS() {
        return githubComJetstackCertManagerPkgApisAcmeV1alpha3ACMEIssuerDNS01ProviderCloudDNS;
    }

    @JsonProperty("github_com_jetstack_cert-manager_pkg_apis_acme_v1alpha3_ACMEIssuerDNS01ProviderCloudDNS")
    public void setGithubComJetstackCertManagerPkgApisAcmeV1alpha3ACMEIssuerDNS01ProviderCloudDNS(ACMEIssuerDNS01ProviderCloudDNS githubComJetstackCertManagerPkgApisAcmeV1alpha3ACMEIssuerDNS01ProviderCloudDNS) {
        this.githubComJetstackCertManagerPkgApisAcmeV1alpha3ACMEIssuerDNS01ProviderCloudDNS = githubComJetstackCertManagerPkgApisAcmeV1alpha3ACMEIssuerDNS01ProviderCloudDNS;
    }

    @JsonProperty("github_com_jetstack_cert-manager_pkg_apis_acme_v1alpha3_ACMEIssuerDNS01ProviderCloudflare")
    public ACMEIssuerDNS01ProviderCloudflare getGithubComJetstackCertManagerPkgApisAcmeV1alpha3ACMEIssuerDNS01ProviderCloudflare() {
        return githubComJetstackCertManagerPkgApisAcmeV1alpha3ACMEIssuerDNS01ProviderCloudflare;
    }

    @JsonProperty("github_com_jetstack_cert-manager_pkg_apis_acme_v1alpha3_ACMEIssuerDNS01ProviderCloudflare")
    public void setGithubComJetstackCertManagerPkgApisAcmeV1alpha3ACMEIssuerDNS01ProviderCloudflare(ACMEIssuerDNS01ProviderCloudflare githubComJetstackCertManagerPkgApisAcmeV1alpha3ACMEIssuerDNS01ProviderCloudflare) {
        this.githubComJetstackCertManagerPkgApisAcmeV1alpha3ACMEIssuerDNS01ProviderCloudflare = githubComJetstackCertManagerPkgApisAcmeV1alpha3ACMEIssuerDNS01ProviderCloudflare;
    }

    @JsonProperty("github_com_jetstack_cert-manager_pkg_apis_acme_v1alpha3_ACMEIssuerDNS01ProviderDigitalOcean")
    public ACMEIssuerDNS01ProviderDigitalOcean getGithubComJetstackCertManagerPkgApisAcmeV1alpha3ACMEIssuerDNS01ProviderDigitalOcean() {
        return githubComJetstackCertManagerPkgApisAcmeV1alpha3ACMEIssuerDNS01ProviderDigitalOcean;
    }

    @JsonProperty("github_com_jetstack_cert-manager_pkg_apis_acme_v1alpha3_ACMEIssuerDNS01ProviderDigitalOcean")
    public void setGithubComJetstackCertManagerPkgApisAcmeV1alpha3ACMEIssuerDNS01ProviderDigitalOcean(ACMEIssuerDNS01ProviderDigitalOcean githubComJetstackCertManagerPkgApisAcmeV1alpha3ACMEIssuerDNS01ProviderDigitalOcean) {
        this.githubComJetstackCertManagerPkgApisAcmeV1alpha3ACMEIssuerDNS01ProviderDigitalOcean = githubComJetstackCertManagerPkgApisAcmeV1alpha3ACMEIssuerDNS01ProviderDigitalOcean;
    }

    @JsonProperty("github_com_jetstack_cert-manager_pkg_apis_acme_v1alpha3_ACMEIssuerDNS01ProviderRFC2136")
    public ACMEIssuerDNS01ProviderRFC2136 getGithubComJetstackCertManagerPkgApisAcmeV1alpha3ACMEIssuerDNS01ProviderRFC2136() {
        return githubComJetstackCertManagerPkgApisAcmeV1alpha3ACMEIssuerDNS01ProviderRFC2136;
    }

    @JsonProperty("github_com_jetstack_cert-manager_pkg_apis_acme_v1alpha3_ACMEIssuerDNS01ProviderRFC2136")
    public void setGithubComJetstackCertManagerPkgApisAcmeV1alpha3ACMEIssuerDNS01ProviderRFC2136(ACMEIssuerDNS01ProviderRFC2136 githubComJetstackCertManagerPkgApisAcmeV1alpha3ACMEIssuerDNS01ProviderRFC2136) {
        this.githubComJetstackCertManagerPkgApisAcmeV1alpha3ACMEIssuerDNS01ProviderRFC2136 = githubComJetstackCertManagerPkgApisAcmeV1alpha3ACMEIssuerDNS01ProviderRFC2136;
    }

    @JsonProperty("github_com_jetstack_cert-manager_pkg_apis_acme_v1alpha3_ACMEIssuerDNS01ProviderRoute53")
    public ACMEIssuerDNS01ProviderRoute53 getGithubComJetstackCertManagerPkgApisAcmeV1alpha3ACMEIssuerDNS01ProviderRoute53() {
        return githubComJetstackCertManagerPkgApisAcmeV1alpha3ACMEIssuerDNS01ProviderRoute53;
    }

    @JsonProperty("github_com_jetstack_cert-manager_pkg_apis_acme_v1alpha3_ACMEIssuerDNS01ProviderRoute53")
    public void setGithubComJetstackCertManagerPkgApisAcmeV1alpha3ACMEIssuerDNS01ProviderRoute53(ACMEIssuerDNS01ProviderRoute53 githubComJetstackCertManagerPkgApisAcmeV1alpha3ACMEIssuerDNS01ProviderRoute53) {
        this.githubComJetstackCertManagerPkgApisAcmeV1alpha3ACMEIssuerDNS01ProviderRoute53 = githubComJetstackCertManagerPkgApisAcmeV1alpha3ACMEIssuerDNS01ProviderRoute53;
    }

    @JsonProperty("github_com_jetstack_cert-manager_pkg_apis_acme_v1alpha3_ACMEIssuerDNS01ProviderWebhook")
    public ACMEIssuerDNS01ProviderWebhook getGithubComJetstackCertManagerPkgApisAcmeV1alpha3ACMEIssuerDNS01ProviderWebhook() {
        return githubComJetstackCertManagerPkgApisAcmeV1alpha3ACMEIssuerDNS01ProviderWebhook;
    }

    @JsonProperty("github_com_jetstack_cert-manager_pkg_apis_acme_v1alpha3_ACMEIssuerDNS01ProviderWebhook")
    public void setGithubComJetstackCertManagerPkgApisAcmeV1alpha3ACMEIssuerDNS01ProviderWebhook(ACMEIssuerDNS01ProviderWebhook githubComJetstackCertManagerPkgApisAcmeV1alpha3ACMEIssuerDNS01ProviderWebhook) {
        this.githubComJetstackCertManagerPkgApisAcmeV1alpha3ACMEIssuerDNS01ProviderWebhook = githubComJetstackCertManagerPkgApisAcmeV1alpha3ACMEIssuerDNS01ProviderWebhook;
    }

    @JsonProperty("github_com_jetstack_cert-manager_pkg_apis_acme_v1alpha3_ACMEIssuerStatus")
    public ACMEIssuerStatus getGithubComJetstackCertManagerPkgApisAcmeV1alpha3ACMEIssuerStatus() {
        return githubComJetstackCertManagerPkgApisAcmeV1alpha3ACMEIssuerStatus;
    }

    @JsonProperty("github_com_jetstack_cert-manager_pkg_apis_acme_v1alpha3_ACMEIssuerStatus")
    public void setGithubComJetstackCertManagerPkgApisAcmeV1alpha3ACMEIssuerStatus(ACMEIssuerStatus githubComJetstackCertManagerPkgApisAcmeV1alpha3ACMEIssuerStatus) {
        this.githubComJetstackCertManagerPkgApisAcmeV1alpha3ACMEIssuerStatus = githubComJetstackCertManagerPkgApisAcmeV1alpha3ACMEIssuerStatus;
    }

    @JsonProperty("github_com_jetstack_cert-manager_pkg_apis_acme_v1alpha3_CertificateDNSNameSelector")
    public CertificateDNSNameSelector getGithubComJetstackCertManagerPkgApisAcmeV1alpha3CertificateDNSNameSelector() {
        return githubComJetstackCertManagerPkgApisAcmeV1alpha3CertificateDNSNameSelector;
    }

    @JsonProperty("github_com_jetstack_cert-manager_pkg_apis_acme_v1alpha3_CertificateDNSNameSelector")
    public void setGithubComJetstackCertManagerPkgApisAcmeV1alpha3CertificateDNSNameSelector(CertificateDNSNameSelector githubComJetstackCertManagerPkgApisAcmeV1alpha3CertificateDNSNameSelector) {
        this.githubComJetstackCertManagerPkgApisAcmeV1alpha3CertificateDNSNameSelector = githubComJetstackCertManagerPkgApisAcmeV1alpha3CertificateDNSNameSelector;
    }

    @JsonProperty("github_com_jetstack_cert-manager_pkg_apis_acme_v1alpha3_Challenge")
    public Challenge getGithubComJetstackCertManagerPkgApisAcmeV1alpha3Challenge() {
        return githubComJetstackCertManagerPkgApisAcmeV1alpha3Challenge;
    }

    @JsonProperty("github_com_jetstack_cert-manager_pkg_apis_acme_v1alpha3_Challenge")
    public void setGithubComJetstackCertManagerPkgApisAcmeV1alpha3Challenge(Challenge githubComJetstackCertManagerPkgApisAcmeV1alpha3Challenge) {
        this.githubComJetstackCertManagerPkgApisAcmeV1alpha3Challenge = githubComJetstackCertManagerPkgApisAcmeV1alpha3Challenge;
    }

    @JsonProperty("github_com_jetstack_cert-manager_pkg_apis_acme_v1alpha3_ChallengeList")
    public ChallengeList getGithubComJetstackCertManagerPkgApisAcmeV1alpha3ChallengeList() {
        return githubComJetstackCertManagerPkgApisAcmeV1alpha3ChallengeList;
    }

    @JsonProperty("github_com_jetstack_cert-manager_pkg_apis_acme_v1alpha3_ChallengeList")
    public void setGithubComJetstackCertManagerPkgApisAcmeV1alpha3ChallengeList(ChallengeList githubComJetstackCertManagerPkgApisAcmeV1alpha3ChallengeList) {
        this.githubComJetstackCertManagerPkgApisAcmeV1alpha3ChallengeList = githubComJetstackCertManagerPkgApisAcmeV1alpha3ChallengeList;
    }

    @JsonProperty("github_com_jetstack_cert-manager_pkg_apis_acme_v1alpha3_ChallengeSpec")
    public ChallengeSpec getGithubComJetstackCertManagerPkgApisAcmeV1alpha3ChallengeSpec() {
        return githubComJetstackCertManagerPkgApisAcmeV1alpha3ChallengeSpec;
    }

    @JsonProperty("github_com_jetstack_cert-manager_pkg_apis_acme_v1alpha3_ChallengeSpec")
    public void setGithubComJetstackCertManagerPkgApisAcmeV1alpha3ChallengeSpec(ChallengeSpec githubComJetstackCertManagerPkgApisAcmeV1alpha3ChallengeSpec) {
        this.githubComJetstackCertManagerPkgApisAcmeV1alpha3ChallengeSpec = githubComJetstackCertManagerPkgApisAcmeV1alpha3ChallengeSpec;
    }

    @JsonProperty("github_com_jetstack_cert-manager_pkg_apis_acme_v1alpha3_ChallengeStatus")
    public ChallengeStatus getGithubComJetstackCertManagerPkgApisAcmeV1alpha3ChallengeStatus() {
        return githubComJetstackCertManagerPkgApisAcmeV1alpha3ChallengeStatus;
    }

    @JsonProperty("github_com_jetstack_cert-manager_pkg_apis_acme_v1alpha3_ChallengeStatus")
    public void setGithubComJetstackCertManagerPkgApisAcmeV1alpha3ChallengeStatus(ChallengeStatus githubComJetstackCertManagerPkgApisAcmeV1alpha3ChallengeStatus) {
        this.githubComJetstackCertManagerPkgApisAcmeV1alpha3ChallengeStatus = githubComJetstackCertManagerPkgApisAcmeV1alpha3ChallengeStatus;
    }

    @JsonProperty("github_com_jetstack_cert-manager_pkg_apis_acme_v1alpha3_Order")
    public Order getGithubComJetstackCertManagerPkgApisAcmeV1alpha3Order() {
        return githubComJetstackCertManagerPkgApisAcmeV1alpha3Order;
    }

    @JsonProperty("github_com_jetstack_cert-manager_pkg_apis_acme_v1alpha3_Order")
    public void setGithubComJetstackCertManagerPkgApisAcmeV1alpha3Order(Order githubComJetstackCertManagerPkgApisAcmeV1alpha3Order) {
        this.githubComJetstackCertManagerPkgApisAcmeV1alpha3Order = githubComJetstackCertManagerPkgApisAcmeV1alpha3Order;
    }

    @JsonProperty("github_com_jetstack_cert-manager_pkg_apis_acme_v1alpha3_OrderList")
    public OrderList getGithubComJetstackCertManagerPkgApisAcmeV1alpha3OrderList() {
        return githubComJetstackCertManagerPkgApisAcmeV1alpha3OrderList;
    }

    @JsonProperty("github_com_jetstack_cert-manager_pkg_apis_acme_v1alpha3_OrderList")
    public void setGithubComJetstackCertManagerPkgApisAcmeV1alpha3OrderList(OrderList githubComJetstackCertManagerPkgApisAcmeV1alpha3OrderList) {
        this.githubComJetstackCertManagerPkgApisAcmeV1alpha3OrderList = githubComJetstackCertManagerPkgApisAcmeV1alpha3OrderList;
    }

    @JsonProperty("github_com_jetstack_cert-manager_pkg_apis_acme_v1alpha3_OrderSpec")
    public OrderSpec getGithubComJetstackCertManagerPkgApisAcmeV1alpha3OrderSpec() {
        return githubComJetstackCertManagerPkgApisAcmeV1alpha3OrderSpec;
    }

    @JsonProperty("github_com_jetstack_cert-manager_pkg_apis_acme_v1alpha3_OrderSpec")
    public void setGithubComJetstackCertManagerPkgApisAcmeV1alpha3OrderSpec(OrderSpec githubComJetstackCertManagerPkgApisAcmeV1alpha3OrderSpec) {
        this.githubComJetstackCertManagerPkgApisAcmeV1alpha3OrderSpec = githubComJetstackCertManagerPkgApisAcmeV1alpha3OrderSpec;
    }

    @JsonProperty("github_com_jetstack_cert-manager_pkg_apis_acme_v1alpha3_OrderStatus")
    public OrderStatus getGithubComJetstackCertManagerPkgApisAcmeV1alpha3OrderStatus() {
        return githubComJetstackCertManagerPkgApisAcmeV1alpha3OrderStatus;
    }

    @JsonProperty("github_com_jetstack_cert-manager_pkg_apis_acme_v1alpha3_OrderStatus")
    public void setGithubComJetstackCertManagerPkgApisAcmeV1alpha3OrderStatus(OrderStatus githubComJetstackCertManagerPkgApisAcmeV1alpha3OrderStatus) {
        this.githubComJetstackCertManagerPkgApisAcmeV1alpha3OrderStatus = githubComJetstackCertManagerPkgApisAcmeV1alpha3OrderStatus;
    }

    @JsonProperty("github_com_jetstack_cert-manager_pkg_apis_certmanager_v1alpha3_CAIssuer")
    public CAIssuer getGithubComJetstackCertManagerPkgApisCertmanagerV1alpha3CAIssuer() {
        return githubComJetstackCertManagerPkgApisCertmanagerV1alpha3CAIssuer;
    }

    @JsonProperty("github_com_jetstack_cert-manager_pkg_apis_certmanager_v1alpha3_CAIssuer")
    public void setGithubComJetstackCertManagerPkgApisCertmanagerV1alpha3CAIssuer(CAIssuer githubComJetstackCertManagerPkgApisCertmanagerV1alpha3CAIssuer) {
        this.githubComJetstackCertManagerPkgApisCertmanagerV1alpha3CAIssuer = githubComJetstackCertManagerPkgApisCertmanagerV1alpha3CAIssuer;
    }

    @JsonProperty("github_com_jetstack_cert-manager_pkg_apis_certmanager_v1alpha3_Certificate")
    public Certificate getGithubComJetstackCertManagerPkgApisCertmanagerV1alpha3Certificate() {
        return githubComJetstackCertManagerPkgApisCertmanagerV1alpha3Certificate;
    }

    @JsonProperty("github_com_jetstack_cert-manager_pkg_apis_certmanager_v1alpha3_Certificate")
    public void setGithubComJetstackCertManagerPkgApisCertmanagerV1alpha3Certificate(Certificate githubComJetstackCertManagerPkgApisCertmanagerV1alpha3Certificate) {
        this.githubComJetstackCertManagerPkgApisCertmanagerV1alpha3Certificate = githubComJetstackCertManagerPkgApisCertmanagerV1alpha3Certificate;
    }

    @JsonProperty("github_com_jetstack_cert-manager_pkg_apis_certmanager_v1alpha3_CertificateCondition")
    public CertificateCondition getGithubComJetstackCertManagerPkgApisCertmanagerV1alpha3CertificateCondition() {
        return githubComJetstackCertManagerPkgApisCertmanagerV1alpha3CertificateCondition;
    }

    @JsonProperty("github_com_jetstack_cert-manager_pkg_apis_certmanager_v1alpha3_CertificateCondition")
    public void setGithubComJetstackCertManagerPkgApisCertmanagerV1alpha3CertificateCondition(CertificateCondition githubComJetstackCertManagerPkgApisCertmanagerV1alpha3CertificateCondition) {
        this.githubComJetstackCertManagerPkgApisCertmanagerV1alpha3CertificateCondition = githubComJetstackCertManagerPkgApisCertmanagerV1alpha3CertificateCondition;
    }

    @JsonProperty("github_com_jetstack_cert-manager_pkg_apis_certmanager_v1alpha3_CertificateKeystores")
    public CertificateKeystores getGithubComJetstackCertManagerPkgApisCertmanagerV1alpha3CertificateKeystores() {
        return githubComJetstackCertManagerPkgApisCertmanagerV1alpha3CertificateKeystores;
    }

    @JsonProperty("github_com_jetstack_cert-manager_pkg_apis_certmanager_v1alpha3_CertificateKeystores")
    public void setGithubComJetstackCertManagerPkgApisCertmanagerV1alpha3CertificateKeystores(CertificateKeystores githubComJetstackCertManagerPkgApisCertmanagerV1alpha3CertificateKeystores) {
        this.githubComJetstackCertManagerPkgApisCertmanagerV1alpha3CertificateKeystores = githubComJetstackCertManagerPkgApisCertmanagerV1alpha3CertificateKeystores;
    }

    @JsonProperty("github_com_jetstack_cert-manager_pkg_apis_certmanager_v1alpha3_CertificateList")
    public CertificateList getGithubComJetstackCertManagerPkgApisCertmanagerV1alpha3CertificateList() {
        return githubComJetstackCertManagerPkgApisCertmanagerV1alpha3CertificateList;
    }

    @JsonProperty("github_com_jetstack_cert-manager_pkg_apis_certmanager_v1alpha3_CertificateList")
    public void setGithubComJetstackCertManagerPkgApisCertmanagerV1alpha3CertificateList(CertificateList githubComJetstackCertManagerPkgApisCertmanagerV1alpha3CertificateList) {
        this.githubComJetstackCertManagerPkgApisCertmanagerV1alpha3CertificateList = githubComJetstackCertManagerPkgApisCertmanagerV1alpha3CertificateList;
    }

    @JsonProperty("github_com_jetstack_cert-manager_pkg_apis_certmanager_v1alpha3_CertificatePrivateKey")
    public CertificatePrivateKey getGithubComJetstackCertManagerPkgApisCertmanagerV1alpha3CertificatePrivateKey() {
        return githubComJetstackCertManagerPkgApisCertmanagerV1alpha3CertificatePrivateKey;
    }

    @JsonProperty("github_com_jetstack_cert-manager_pkg_apis_certmanager_v1alpha3_CertificatePrivateKey")
    public void setGithubComJetstackCertManagerPkgApisCertmanagerV1alpha3CertificatePrivateKey(CertificatePrivateKey githubComJetstackCertManagerPkgApisCertmanagerV1alpha3CertificatePrivateKey) {
        this.githubComJetstackCertManagerPkgApisCertmanagerV1alpha3CertificatePrivateKey = githubComJetstackCertManagerPkgApisCertmanagerV1alpha3CertificatePrivateKey;
    }

    @JsonProperty("github_com_jetstack_cert-manager_pkg_apis_certmanager_v1alpha3_CertificateRequest")
    public CertificateRequest getGithubComJetstackCertManagerPkgApisCertmanagerV1alpha3CertificateRequest() {
        return githubComJetstackCertManagerPkgApisCertmanagerV1alpha3CertificateRequest;
    }

    @JsonProperty("github_com_jetstack_cert-manager_pkg_apis_certmanager_v1alpha3_CertificateRequest")
    public void setGithubComJetstackCertManagerPkgApisCertmanagerV1alpha3CertificateRequest(CertificateRequest githubComJetstackCertManagerPkgApisCertmanagerV1alpha3CertificateRequest) {
        this.githubComJetstackCertManagerPkgApisCertmanagerV1alpha3CertificateRequest = githubComJetstackCertManagerPkgApisCertmanagerV1alpha3CertificateRequest;
    }

    @JsonProperty("github_com_jetstack_cert-manager_pkg_apis_certmanager_v1alpha3_CertificateRequestCondition")
    public CertificateRequestCondition getGithubComJetstackCertManagerPkgApisCertmanagerV1alpha3CertificateRequestCondition() {
        return githubComJetstackCertManagerPkgApisCertmanagerV1alpha3CertificateRequestCondition;
    }

    @JsonProperty("github_com_jetstack_cert-manager_pkg_apis_certmanager_v1alpha3_CertificateRequestCondition")
    public void setGithubComJetstackCertManagerPkgApisCertmanagerV1alpha3CertificateRequestCondition(CertificateRequestCondition githubComJetstackCertManagerPkgApisCertmanagerV1alpha3CertificateRequestCondition) {
        this.githubComJetstackCertManagerPkgApisCertmanagerV1alpha3CertificateRequestCondition = githubComJetstackCertManagerPkgApisCertmanagerV1alpha3CertificateRequestCondition;
    }

    @JsonProperty("github_com_jetstack_cert-manager_pkg_apis_certmanager_v1alpha3_CertificateRequestList")
    public CertificateRequestList getGithubComJetstackCertManagerPkgApisCertmanagerV1alpha3CertificateRequestList() {
        return githubComJetstackCertManagerPkgApisCertmanagerV1alpha3CertificateRequestList;
    }

    @JsonProperty("github_com_jetstack_cert-manager_pkg_apis_certmanager_v1alpha3_CertificateRequestList")
    public void setGithubComJetstackCertManagerPkgApisCertmanagerV1alpha3CertificateRequestList(CertificateRequestList githubComJetstackCertManagerPkgApisCertmanagerV1alpha3CertificateRequestList) {
        this.githubComJetstackCertManagerPkgApisCertmanagerV1alpha3CertificateRequestList = githubComJetstackCertManagerPkgApisCertmanagerV1alpha3CertificateRequestList;
    }

    @JsonProperty("github_com_jetstack_cert-manager_pkg_apis_certmanager_v1alpha3_CertificateRequestSpec")
    public CertificateRequestSpec getGithubComJetstackCertManagerPkgApisCertmanagerV1alpha3CertificateRequestSpec() {
        return githubComJetstackCertManagerPkgApisCertmanagerV1alpha3CertificateRequestSpec;
    }

    @JsonProperty("github_com_jetstack_cert-manager_pkg_apis_certmanager_v1alpha3_CertificateRequestSpec")
    public void setGithubComJetstackCertManagerPkgApisCertmanagerV1alpha3CertificateRequestSpec(CertificateRequestSpec githubComJetstackCertManagerPkgApisCertmanagerV1alpha3CertificateRequestSpec) {
        this.githubComJetstackCertManagerPkgApisCertmanagerV1alpha3CertificateRequestSpec = githubComJetstackCertManagerPkgApisCertmanagerV1alpha3CertificateRequestSpec;
    }

    @JsonProperty("github_com_jetstack_cert-manager_pkg_apis_certmanager_v1alpha3_CertificateRequestStatus")
    public CertificateRequestStatus getGithubComJetstackCertManagerPkgApisCertmanagerV1alpha3CertificateRequestStatus() {
        return githubComJetstackCertManagerPkgApisCertmanagerV1alpha3CertificateRequestStatus;
    }

    @JsonProperty("github_com_jetstack_cert-manager_pkg_apis_certmanager_v1alpha3_CertificateRequestStatus")
    public void setGithubComJetstackCertManagerPkgApisCertmanagerV1alpha3CertificateRequestStatus(CertificateRequestStatus githubComJetstackCertManagerPkgApisCertmanagerV1alpha3CertificateRequestStatus) {
        this.githubComJetstackCertManagerPkgApisCertmanagerV1alpha3CertificateRequestStatus = githubComJetstackCertManagerPkgApisCertmanagerV1alpha3CertificateRequestStatus;
    }

    @JsonProperty("github_com_jetstack_cert-manager_pkg_apis_certmanager_v1alpha3_CertificateSpec")
    public CertificateSpec getGithubComJetstackCertManagerPkgApisCertmanagerV1alpha3CertificateSpec() {
        return githubComJetstackCertManagerPkgApisCertmanagerV1alpha3CertificateSpec;
    }

    @JsonProperty("github_com_jetstack_cert-manager_pkg_apis_certmanager_v1alpha3_CertificateSpec")
    public void setGithubComJetstackCertManagerPkgApisCertmanagerV1alpha3CertificateSpec(CertificateSpec githubComJetstackCertManagerPkgApisCertmanagerV1alpha3CertificateSpec) {
        this.githubComJetstackCertManagerPkgApisCertmanagerV1alpha3CertificateSpec = githubComJetstackCertManagerPkgApisCertmanagerV1alpha3CertificateSpec;
    }

    @JsonProperty("github_com_jetstack_cert-manager_pkg_apis_certmanager_v1alpha3_CertificateStatus")
    public CertificateStatus getGithubComJetstackCertManagerPkgApisCertmanagerV1alpha3CertificateStatus() {
        return githubComJetstackCertManagerPkgApisCertmanagerV1alpha3CertificateStatus;
    }

    @JsonProperty("github_com_jetstack_cert-manager_pkg_apis_certmanager_v1alpha3_CertificateStatus")
    public void setGithubComJetstackCertManagerPkgApisCertmanagerV1alpha3CertificateStatus(CertificateStatus githubComJetstackCertManagerPkgApisCertmanagerV1alpha3CertificateStatus) {
        this.githubComJetstackCertManagerPkgApisCertmanagerV1alpha3CertificateStatus = githubComJetstackCertManagerPkgApisCertmanagerV1alpha3CertificateStatus;
    }

    @JsonProperty("github_com_jetstack_cert-manager_pkg_apis_certmanager_v1alpha3_ClusterIssuer")
    public ClusterIssuer getGithubComJetstackCertManagerPkgApisCertmanagerV1alpha3ClusterIssuer() {
        return githubComJetstackCertManagerPkgApisCertmanagerV1alpha3ClusterIssuer;
    }

    @JsonProperty("github_com_jetstack_cert-manager_pkg_apis_certmanager_v1alpha3_ClusterIssuer")
    public void setGithubComJetstackCertManagerPkgApisCertmanagerV1alpha3ClusterIssuer(ClusterIssuer githubComJetstackCertManagerPkgApisCertmanagerV1alpha3ClusterIssuer) {
        this.githubComJetstackCertManagerPkgApisCertmanagerV1alpha3ClusterIssuer = githubComJetstackCertManagerPkgApisCertmanagerV1alpha3ClusterIssuer;
    }

    @JsonProperty("github_com_jetstack_cert-manager_pkg_apis_certmanager_v1alpha3_ClusterIssuerList")
    public ClusterIssuerList getGithubComJetstackCertManagerPkgApisCertmanagerV1alpha3ClusterIssuerList() {
        return githubComJetstackCertManagerPkgApisCertmanagerV1alpha3ClusterIssuerList;
    }

    @JsonProperty("github_com_jetstack_cert-manager_pkg_apis_certmanager_v1alpha3_ClusterIssuerList")
    public void setGithubComJetstackCertManagerPkgApisCertmanagerV1alpha3ClusterIssuerList(ClusterIssuerList githubComJetstackCertManagerPkgApisCertmanagerV1alpha3ClusterIssuerList) {
        this.githubComJetstackCertManagerPkgApisCertmanagerV1alpha3ClusterIssuerList = githubComJetstackCertManagerPkgApisCertmanagerV1alpha3ClusterIssuerList;
    }

    @JsonProperty("github_com_jetstack_cert-manager_pkg_apis_certmanager_v1alpha3_Issuer")
    public Issuer getGithubComJetstackCertManagerPkgApisCertmanagerV1alpha3Issuer() {
        return githubComJetstackCertManagerPkgApisCertmanagerV1alpha3Issuer;
    }

    @JsonProperty("github_com_jetstack_cert-manager_pkg_apis_certmanager_v1alpha3_Issuer")
    public void setGithubComJetstackCertManagerPkgApisCertmanagerV1alpha3Issuer(Issuer githubComJetstackCertManagerPkgApisCertmanagerV1alpha3Issuer) {
        this.githubComJetstackCertManagerPkgApisCertmanagerV1alpha3Issuer = githubComJetstackCertManagerPkgApisCertmanagerV1alpha3Issuer;
    }

    @JsonProperty("github_com_jetstack_cert-manager_pkg_apis_certmanager_v1alpha3_IssuerCondition")
    public IssuerCondition getGithubComJetstackCertManagerPkgApisCertmanagerV1alpha3IssuerCondition() {
        return githubComJetstackCertManagerPkgApisCertmanagerV1alpha3IssuerCondition;
    }

    @JsonProperty("github_com_jetstack_cert-manager_pkg_apis_certmanager_v1alpha3_IssuerCondition")
    public void setGithubComJetstackCertManagerPkgApisCertmanagerV1alpha3IssuerCondition(IssuerCondition githubComJetstackCertManagerPkgApisCertmanagerV1alpha3IssuerCondition) {
        this.githubComJetstackCertManagerPkgApisCertmanagerV1alpha3IssuerCondition = githubComJetstackCertManagerPkgApisCertmanagerV1alpha3IssuerCondition;
    }

    @JsonProperty("github_com_jetstack_cert-manager_pkg_apis_certmanager_v1alpha3_IssuerList")
    public IssuerList getGithubComJetstackCertManagerPkgApisCertmanagerV1alpha3IssuerList() {
        return githubComJetstackCertManagerPkgApisCertmanagerV1alpha3IssuerList;
    }

    @JsonProperty("github_com_jetstack_cert-manager_pkg_apis_certmanager_v1alpha3_IssuerList")
    public void setGithubComJetstackCertManagerPkgApisCertmanagerV1alpha3IssuerList(IssuerList githubComJetstackCertManagerPkgApisCertmanagerV1alpha3IssuerList) {
        this.githubComJetstackCertManagerPkgApisCertmanagerV1alpha3IssuerList = githubComJetstackCertManagerPkgApisCertmanagerV1alpha3IssuerList;
    }

    @JsonProperty("github_com_jetstack_cert-manager_pkg_apis_certmanager_v1alpha3_IssuerSpec")
    public IssuerSpec getGithubComJetstackCertManagerPkgApisCertmanagerV1alpha3IssuerSpec() {
        return githubComJetstackCertManagerPkgApisCertmanagerV1alpha3IssuerSpec;
    }

    @JsonProperty("github_com_jetstack_cert-manager_pkg_apis_certmanager_v1alpha3_IssuerSpec")
    public void setGithubComJetstackCertManagerPkgApisCertmanagerV1alpha3IssuerSpec(IssuerSpec githubComJetstackCertManagerPkgApisCertmanagerV1alpha3IssuerSpec) {
        this.githubComJetstackCertManagerPkgApisCertmanagerV1alpha3IssuerSpec = githubComJetstackCertManagerPkgApisCertmanagerV1alpha3IssuerSpec;
    }

    @JsonProperty("github_com_jetstack_cert-manager_pkg_apis_certmanager_v1alpha3_IssuerStatus")
    public IssuerStatus getGithubComJetstackCertManagerPkgApisCertmanagerV1alpha3IssuerStatus() {
        return githubComJetstackCertManagerPkgApisCertmanagerV1alpha3IssuerStatus;
    }

    @JsonProperty("github_com_jetstack_cert-manager_pkg_apis_certmanager_v1alpha3_IssuerStatus")
    public void setGithubComJetstackCertManagerPkgApisCertmanagerV1alpha3IssuerStatus(IssuerStatus githubComJetstackCertManagerPkgApisCertmanagerV1alpha3IssuerStatus) {
        this.githubComJetstackCertManagerPkgApisCertmanagerV1alpha3IssuerStatus = githubComJetstackCertManagerPkgApisCertmanagerV1alpha3IssuerStatus;
    }

    @JsonProperty("github_com_jetstack_cert-manager_pkg_apis_certmanager_v1alpha3_JKSKeystore")
    public JKSKeystore getGithubComJetstackCertManagerPkgApisCertmanagerV1alpha3JKSKeystore() {
        return githubComJetstackCertManagerPkgApisCertmanagerV1alpha3JKSKeystore;
    }

    @JsonProperty("github_com_jetstack_cert-manager_pkg_apis_certmanager_v1alpha3_JKSKeystore")
    public void setGithubComJetstackCertManagerPkgApisCertmanagerV1alpha3JKSKeystore(JKSKeystore githubComJetstackCertManagerPkgApisCertmanagerV1alpha3JKSKeystore) {
        this.githubComJetstackCertManagerPkgApisCertmanagerV1alpha3JKSKeystore = githubComJetstackCertManagerPkgApisCertmanagerV1alpha3JKSKeystore;
    }

    @JsonProperty("github_com_jetstack_cert-manager_pkg_apis_certmanager_v1alpha3_PKCS12Keystore")
    public PKCS12Keystore getGithubComJetstackCertManagerPkgApisCertmanagerV1alpha3PKCS12Keystore() {
        return githubComJetstackCertManagerPkgApisCertmanagerV1alpha3PKCS12Keystore;
    }

    @JsonProperty("github_com_jetstack_cert-manager_pkg_apis_certmanager_v1alpha3_PKCS12Keystore")
    public void setGithubComJetstackCertManagerPkgApisCertmanagerV1alpha3PKCS12Keystore(PKCS12Keystore githubComJetstackCertManagerPkgApisCertmanagerV1alpha3PKCS12Keystore) {
        this.githubComJetstackCertManagerPkgApisCertmanagerV1alpha3PKCS12Keystore = githubComJetstackCertManagerPkgApisCertmanagerV1alpha3PKCS12Keystore;
    }

    @JsonProperty("github_com_jetstack_cert-manager_pkg_apis_certmanager_v1alpha3_SelfSignedIssuer")
    public SelfSignedIssuer getGithubComJetstackCertManagerPkgApisCertmanagerV1alpha3SelfSignedIssuer() {
        return githubComJetstackCertManagerPkgApisCertmanagerV1alpha3SelfSignedIssuer;
    }

    @JsonProperty("github_com_jetstack_cert-manager_pkg_apis_certmanager_v1alpha3_SelfSignedIssuer")
    public void setGithubComJetstackCertManagerPkgApisCertmanagerV1alpha3SelfSignedIssuer(SelfSignedIssuer githubComJetstackCertManagerPkgApisCertmanagerV1alpha3SelfSignedIssuer) {
        this.githubComJetstackCertManagerPkgApisCertmanagerV1alpha3SelfSignedIssuer = githubComJetstackCertManagerPkgApisCertmanagerV1alpha3SelfSignedIssuer;
    }

    @JsonProperty("github_com_jetstack_cert-manager_pkg_apis_certmanager_v1alpha3_VaultAppRole")
    public VaultAppRole getGithubComJetstackCertManagerPkgApisCertmanagerV1alpha3VaultAppRole() {
        return githubComJetstackCertManagerPkgApisCertmanagerV1alpha3VaultAppRole;
    }

    @JsonProperty("github_com_jetstack_cert-manager_pkg_apis_certmanager_v1alpha3_VaultAppRole")
    public void setGithubComJetstackCertManagerPkgApisCertmanagerV1alpha3VaultAppRole(VaultAppRole githubComJetstackCertManagerPkgApisCertmanagerV1alpha3VaultAppRole) {
        this.githubComJetstackCertManagerPkgApisCertmanagerV1alpha3VaultAppRole = githubComJetstackCertManagerPkgApisCertmanagerV1alpha3VaultAppRole;
    }

    @JsonProperty("github_com_jetstack_cert-manager_pkg_apis_certmanager_v1alpha3_VaultAuth")
    public VaultAuth getGithubComJetstackCertManagerPkgApisCertmanagerV1alpha3VaultAuth() {
        return githubComJetstackCertManagerPkgApisCertmanagerV1alpha3VaultAuth;
    }

    @JsonProperty("github_com_jetstack_cert-manager_pkg_apis_certmanager_v1alpha3_VaultAuth")
    public void setGithubComJetstackCertManagerPkgApisCertmanagerV1alpha3VaultAuth(VaultAuth githubComJetstackCertManagerPkgApisCertmanagerV1alpha3VaultAuth) {
        this.githubComJetstackCertManagerPkgApisCertmanagerV1alpha3VaultAuth = githubComJetstackCertManagerPkgApisCertmanagerV1alpha3VaultAuth;
    }

    @JsonProperty("github_com_jetstack_cert-manager_pkg_apis_certmanager_v1alpha3_VaultIssuer")
    public VaultIssuer getGithubComJetstackCertManagerPkgApisCertmanagerV1alpha3VaultIssuer() {
        return githubComJetstackCertManagerPkgApisCertmanagerV1alpha3VaultIssuer;
    }

    @JsonProperty("github_com_jetstack_cert-manager_pkg_apis_certmanager_v1alpha3_VaultIssuer")
    public void setGithubComJetstackCertManagerPkgApisCertmanagerV1alpha3VaultIssuer(VaultIssuer githubComJetstackCertManagerPkgApisCertmanagerV1alpha3VaultIssuer) {
        this.githubComJetstackCertManagerPkgApisCertmanagerV1alpha3VaultIssuer = githubComJetstackCertManagerPkgApisCertmanagerV1alpha3VaultIssuer;
    }

    @JsonProperty("github_com_jetstack_cert-manager_pkg_apis_certmanager_v1alpha3_VaultKubernetesAuth")
    public VaultKubernetesAuth getGithubComJetstackCertManagerPkgApisCertmanagerV1alpha3VaultKubernetesAuth() {
        return githubComJetstackCertManagerPkgApisCertmanagerV1alpha3VaultKubernetesAuth;
    }

    @JsonProperty("github_com_jetstack_cert-manager_pkg_apis_certmanager_v1alpha3_VaultKubernetesAuth")
    public void setGithubComJetstackCertManagerPkgApisCertmanagerV1alpha3VaultKubernetesAuth(VaultKubernetesAuth githubComJetstackCertManagerPkgApisCertmanagerV1alpha3VaultKubernetesAuth) {
        this.githubComJetstackCertManagerPkgApisCertmanagerV1alpha3VaultKubernetesAuth = githubComJetstackCertManagerPkgApisCertmanagerV1alpha3VaultKubernetesAuth;
    }

    @JsonProperty("github_com_jetstack_cert-manager_pkg_apis_certmanager_v1alpha3_VenafiCloud")
    public VenafiCloud getGithubComJetstackCertManagerPkgApisCertmanagerV1alpha3VenafiCloud() {
        return githubComJetstackCertManagerPkgApisCertmanagerV1alpha3VenafiCloud;
    }

    @JsonProperty("github_com_jetstack_cert-manager_pkg_apis_certmanager_v1alpha3_VenafiCloud")
    public void setGithubComJetstackCertManagerPkgApisCertmanagerV1alpha3VenafiCloud(VenafiCloud githubComJetstackCertManagerPkgApisCertmanagerV1alpha3VenafiCloud) {
        this.githubComJetstackCertManagerPkgApisCertmanagerV1alpha3VenafiCloud = githubComJetstackCertManagerPkgApisCertmanagerV1alpha3VenafiCloud;
    }

    @JsonProperty("github_com_jetstack_cert-manager_pkg_apis_certmanager_v1alpha3_VenafiIssuer")
    public VenafiIssuer getGithubComJetstackCertManagerPkgApisCertmanagerV1alpha3VenafiIssuer() {
        return githubComJetstackCertManagerPkgApisCertmanagerV1alpha3VenafiIssuer;
    }

    @JsonProperty("github_com_jetstack_cert-manager_pkg_apis_certmanager_v1alpha3_VenafiIssuer")
    public void setGithubComJetstackCertManagerPkgApisCertmanagerV1alpha3VenafiIssuer(VenafiIssuer githubComJetstackCertManagerPkgApisCertmanagerV1alpha3VenafiIssuer) {
        this.githubComJetstackCertManagerPkgApisCertmanagerV1alpha3VenafiIssuer = githubComJetstackCertManagerPkgApisCertmanagerV1alpha3VenafiIssuer;
    }

    @JsonProperty("github_com_jetstack_cert-manager_pkg_apis_certmanager_v1alpha3_VenafiTPP")
    public VenafiTPP getGithubComJetstackCertManagerPkgApisCertmanagerV1alpha3VenafiTPP() {
        return githubComJetstackCertManagerPkgApisCertmanagerV1alpha3VenafiTPP;
    }

    @JsonProperty("github_com_jetstack_cert-manager_pkg_apis_certmanager_v1alpha3_VenafiTPP")
    public void setGithubComJetstackCertManagerPkgApisCertmanagerV1alpha3VenafiTPP(VenafiTPP githubComJetstackCertManagerPkgApisCertmanagerV1alpha3VenafiTPP) {
        this.githubComJetstackCertManagerPkgApisCertmanagerV1alpha3VenafiTPP = githubComJetstackCertManagerPkgApisCertmanagerV1alpha3VenafiTPP;
    }

    @JsonProperty("github_com_jetstack_cert-manager_pkg_apis_certmanager_v1alpha3_X509Subject")
    public X509Subject getGithubComJetstackCertManagerPkgApisCertmanagerV1alpha3X509Subject() {
        return githubComJetstackCertManagerPkgApisCertmanagerV1alpha3X509Subject;
    }

    @JsonProperty("github_com_jetstack_cert-manager_pkg_apis_certmanager_v1alpha3_X509Subject")
    public void setGithubComJetstackCertManagerPkgApisCertmanagerV1alpha3X509Subject(X509Subject githubComJetstackCertManagerPkgApisCertmanagerV1alpha3X509Subject) {
        this.githubComJetstackCertManagerPkgApisCertmanagerV1alpha3X509Subject = githubComJetstackCertManagerPkgApisCertmanagerV1alpha3X509Subject;
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
