
package io.fabric8.certmanager.api.model.v1;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
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

@JsonDeserialize(using = com.fasterxml.jackson.databind.JsonDeserializer.None.class)
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "crlDistributionPoints",
    "issuingCertificateURLs",
    "ocspServers",
    "secretName"
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
        if (!(o instanceof CAIssuer)) {
            return false;
        }
        CAIssuer other = (CAIssuer) o;
        if (!other.canEqual(this)) {
            return false;
        }
        Object this$crlDistributionPoints = this.getCrlDistributionPoints();
        Object other$crlDistributionPoints = other.getCrlDistributionPoints();
        if (this$crlDistributionPoints == null ? other$crlDistributionPoints != null : !this$crlDistributionPoints.equals(other$crlDistributionPoints)) {
            return false;
        }
        Object this$issuingCertificateURLs = this.getIssuingCertificateURLs();
        Object other$issuingCertificateURLs = other.getIssuingCertificateURLs();
        if (this$issuingCertificateURLs == null ? other$issuingCertificateURLs != null : !this$issuingCertificateURLs.equals(other$issuingCertificateURLs)) {
            return false;
        }
        Object this$ocspServers = this.getOcspServers();
        Object other$ocspServers = other.getOcspServers();
        if (this$ocspServers == null ? other$ocspServers != null : !this$ocspServers.equals(other$ocspServers)) {
            return false;
        }
        Object this$secretName = this.getSecretName();
        Object other$secretName = other.getSecretName();
        if (this$secretName == null ? other$secretName != null : !this$secretName.equals(other$secretName)) {
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
        return other instanceof CAIssuer;
    }

    @Override
    public int hashCode() {
        final int prime = 59;
        int result = 1;
        Object $crlDistributionPoints = this.getCrlDistributionPoints();
        result = result * prime + ($crlDistributionPoints == null ? 43 : $crlDistributionPoints.hashCode());
        Object $issuingCertificateURLs = this.getIssuingCertificateURLs();
        result = result * prime + ($issuingCertificateURLs == null ? 43 : $issuingCertificateURLs.hashCode());
        Object $ocspServers = this.getOcspServers();
        result = result * prime + ($ocspServers == null ? 43 : $ocspServers.hashCode());
        Object $secretName = this.getSecretName();
        result = result * prime + ($secretName == null ? 43 : $secretName.hashCode());
        Object $additionalProperties = this.getAdditionalProperties();
        result = result * prime + ($additionalProperties == null ? 43 : $additionalProperties.hashCode());
        return result;
    }

    @Override
    public String toString() {
        return "CAIssuer(" + "crlDistributionPoints=" + this.getCrlDistributionPoints() + ", issuingCertificateURLs=" + this.getIssuingCertificateURLs() + ", ocspServers=" + this.getOcspServers() + ", secretName=" + this.getSecretName() + ", additionalProperties=" + this.getAdditionalProperties() + ")";
    }

}
