
package io.fabric8.openshift.api.model.config.v1;

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
import io.fabric8.kubernetes.api.model.Volume;
import io.fabric8.kubernetes.api.model.VolumeMount;
import io.sundr.builder.annotations.Buildable;
import io.sundr.builder.annotations.BuildableReference;

/**
 * PKI defines the root of trust based on Root CA(s) and corresponding intermediate certificates.
 */
@JsonDeserialize(using = com.fasterxml.jackson.databind.JsonDeserializer.None.class)
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "caIntermediatesData",
    "caRootsData",
    "pkiCertificateSubject"
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
public class PKI implements Editable<PKIBuilder>, KubernetesResource
{

    @JsonProperty("caIntermediatesData")
    private String caIntermediatesData;
    @JsonProperty("caRootsData")
    private String caRootsData;
    @JsonProperty("pkiCertificateSubject")
    private PKICertificateSubject pkiCertificateSubject;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new LinkedHashMap<String, Object>();

    /**
     * No args constructor for use in serialization
     */
    public PKI() {
    }

    public PKI(String caIntermediatesData, String caRootsData, PKICertificateSubject pkiCertificateSubject) {
        super();
        this.caIntermediatesData = caIntermediatesData;
        this.caRootsData = caRootsData;
        this.pkiCertificateSubject = pkiCertificateSubject;
    }

    /**
     * caIntermediatesData contains base64-encoded data of a certificate bundle PEM file, which contains one or more intermediate certificates in the PEM format. The total length of the data must not exceed 8192 characters. caIntermediatesData requires caRootsData to be set.
     */
    @JsonProperty("caIntermediatesData")
    public String getCaIntermediatesData() {
        return caIntermediatesData;
    }

    /**
     * caIntermediatesData contains base64-encoded data of a certificate bundle PEM file, which contains one or more intermediate certificates in the PEM format. The total length of the data must not exceed 8192 characters. caIntermediatesData requires caRootsData to be set.
     */
    @JsonProperty("caIntermediatesData")
    public void setCaIntermediatesData(String caIntermediatesData) {
        this.caIntermediatesData = caIntermediatesData;
    }

    /**
     * caRootsData contains base64-encoded data of a certificate bundle PEM file, which contains one or more CA roots in the PEM format. The total length of the data must not exceed 8192 characters.
     */
    @JsonProperty("caRootsData")
    public String getCaRootsData() {
        return caRootsData;
    }

    /**
     * caRootsData contains base64-encoded data of a certificate bundle PEM file, which contains one or more CA roots in the PEM format. The total length of the data must not exceed 8192 characters.
     */
    @JsonProperty("caRootsData")
    public void setCaRootsData(String caRootsData) {
        this.caRootsData = caRootsData;
    }

    /**
     * PKI defines the root of trust based on Root CA(s) and corresponding intermediate certificates.
     */
    @JsonProperty("pkiCertificateSubject")
    public PKICertificateSubject getPkiCertificateSubject() {
        return pkiCertificateSubject;
    }

    /**
     * PKI defines the root of trust based on Root CA(s) and corresponding intermediate certificates.
     */
    @JsonProperty("pkiCertificateSubject")
    public void setPkiCertificateSubject(PKICertificateSubject pkiCertificateSubject) {
        this.pkiCertificateSubject = pkiCertificateSubject;
    }

    @JsonIgnore
    public PKIBuilder edit() {
        return new PKIBuilder(this);
    }

    @JsonIgnore
    public PKIBuilder toBuilder() {
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
        if (!(o instanceof PKI)) {
            return false;
        }
        PKI other = (PKI) o;
        if (!other.canEqual(this)) {
            return false;
        }
        Object this$caIntermediatesData = this.getCaIntermediatesData();
        Object other$caIntermediatesData = other.getCaIntermediatesData();
        if (this$caIntermediatesData == null ? other$caIntermediatesData != null : !this$caIntermediatesData.equals(other$caIntermediatesData)) {
            return false;
        }
        Object this$caRootsData = this.getCaRootsData();
        Object other$caRootsData = other.getCaRootsData();
        if (this$caRootsData == null ? other$caRootsData != null : !this$caRootsData.equals(other$caRootsData)) {
            return false;
        }
        Object this$pkiCertificateSubject = this.getPkiCertificateSubject();
        Object other$pkiCertificateSubject = other.getPkiCertificateSubject();
        if (this$pkiCertificateSubject == null ? other$pkiCertificateSubject != null : !this$pkiCertificateSubject.equals(other$pkiCertificateSubject)) {
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
        return other instanceof PKI;
    }

    @Override
    public int hashCode() {
        final int prime = 59;
        int result = 1;
        Object $caIntermediatesData = this.getCaIntermediatesData();
        result = result * prime + ($caIntermediatesData == null ? 43 : $caIntermediatesData.hashCode());
        Object $caRootsData = this.getCaRootsData();
        result = result * prime + ($caRootsData == null ? 43 : $caRootsData.hashCode());
        Object $pkiCertificateSubject = this.getPkiCertificateSubject();
        result = result * prime + ($pkiCertificateSubject == null ? 43 : $pkiCertificateSubject.hashCode());
        Object $additionalProperties = this.getAdditionalProperties();
        result = result * prime + ($additionalProperties == null ? 43 : $additionalProperties.hashCode());
        return result;
    }

    @Override
    public String toString() {
        return "PKI(" + "caIntermediatesData=" + this.getCaIntermediatesData() + ", caRootsData=" + this.getCaRootsData() + ", pkiCertificateSubject=" + this.getPkiCertificateSubject() + ", additionalProperties=" + this.getAdditionalProperties() + ")";
    }

}
