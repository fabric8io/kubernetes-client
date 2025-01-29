
package io.fabric8.certmanager.api.model.v1;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import javax.annotation.Generated;
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
import lombok.EqualsAndHashCode;
import lombok.ToString;
import lombok.experimental.Accessors;

@JsonDeserialize(using = com.fasterxml.jackson.databind.JsonDeserializer.None.class)
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "crlDistributionPoints",
    "issuingCertificateURLs",
    "ocspServers",
    "secretName"
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
public class CAIssuer implements Editable<CAIssuerBuilder>, KubernetesResource
{

    @JsonProperty("crlDistributionPoints")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private List<String> crlDistributionPoints = new ArrayList<>();
    @JsonProperty("issuingCertificateURLs")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private List<String> issuingCertificateURLs = new ArrayList<>();
    @JsonProperty("ocspServers")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private List<String> ocspServers = new ArrayList<>();
    @JsonProperty("secretName")
    private String secretName;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new LinkedHashMap<String, Object>();

    /**
     * No args constructor for use in serialization
     */
    public CAIssuer() {
    }

    public CAIssuer(List<String> crlDistributionPoints, List<String> issuingCertificateURLs, List<String> ocspServers, String secretName) {
        super();
        this.crlDistributionPoints = crlDistributionPoints;
        this.issuingCertificateURLs = issuingCertificateURLs;
        this.ocspServers = ocspServers;
        this.secretName = secretName;
    }

    /**
     * The CRL distribution points is an X.509 v3 certificate extension which identifies the location of the CRL from which the revocation of this certificate can be checked. If not set, certificates will be issued without distribution points set.
     */
    @JsonProperty("crlDistributionPoints")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    public List<String> getCrlDistributionPoints() {
        return crlDistributionPoints;
    }

    /**
     * The CRL distribution points is an X.509 v3 certificate extension which identifies the location of the CRL from which the revocation of this certificate can be checked. If not set, certificates will be issued without distribution points set.
     */
    @JsonProperty("crlDistributionPoints")
    public void setCrlDistributionPoints(List<String> crlDistributionPoints) {
        this.crlDistributionPoints = crlDistributionPoints;
    }

    /**
     * IssuingCertificateURLs is a list of URLs which this issuer should embed into certificates it creates. See https://www.rfc-editor.org/rfc/rfc5280#section-4.2.2.1 for more details. As an example, such a URL might be "http://ca.domain.com/ca.crt".
     */
    @JsonProperty("issuingCertificateURLs")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    public List<String> getIssuingCertificateURLs() {
        return issuingCertificateURLs;
    }

    /**
     * IssuingCertificateURLs is a list of URLs which this issuer should embed into certificates it creates. See https://www.rfc-editor.org/rfc/rfc5280#section-4.2.2.1 for more details. As an example, such a URL might be "http://ca.domain.com/ca.crt".
     */
    @JsonProperty("issuingCertificateURLs")
    public void setIssuingCertificateURLs(List<String> issuingCertificateURLs) {
        this.issuingCertificateURLs = issuingCertificateURLs;
    }

    /**
     * The OCSP server list is an X.509 v3 extension that defines a list of URLs of OCSP responders. The OCSP responders can be queried for the revocation status of an issued certificate. If not set, the certificate will be issued with no OCSP servers set. For example, an OCSP server URL could be "http://ocsp.int-x3.letsencrypt.org".
     */
    @JsonProperty("ocspServers")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    public List<String> getOcspServers() {
        return ocspServers;
    }

    /**
     * The OCSP server list is an X.509 v3 extension that defines a list of URLs of OCSP responders. The OCSP responders can be queried for the revocation status of an issued certificate. If not set, the certificate will be issued with no OCSP servers set. For example, an OCSP server URL could be "http://ocsp.int-x3.letsencrypt.org".
     */
    @JsonProperty("ocspServers")
    public void setOcspServers(List<String> ocspServers) {
        this.ocspServers = ocspServers;
    }

    /**
     * SecretName is the name of the secret used to sign Certificates issued by this Issuer.
     */
    @JsonProperty("secretName")
    public String getSecretName() {
        return secretName;
    }

    /**
     * SecretName is the name of the secret used to sign Certificates issued by this Issuer.
     */
    @JsonProperty("secretName")
    public void setSecretName(String secretName) {
        this.secretName = secretName;
    }

    @JsonIgnore
    public CAIssuerBuilder edit() {
        return new CAIssuerBuilder(this);
    }

    @JsonIgnore
    public CAIssuerBuilder toBuilder() {
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
