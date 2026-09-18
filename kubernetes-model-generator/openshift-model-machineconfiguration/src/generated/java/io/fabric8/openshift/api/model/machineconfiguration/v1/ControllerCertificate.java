
package io.fabric8.openshift.api.model.machineconfiguration.v1;

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
 * ControllerCertificate contains info about a specific cert.
 */
@JsonDeserialize(using = com.fasterxml.jackson.databind.JsonDeserializer.None.class)
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "bundleFile",
    "notAfter",
    "notBefore",
    "signer",
    "subject"
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
public class ControllerCertificate implements Editable<ControllerCertificateBuilder>, KubernetesResource
{

    @JsonProperty("bundleFile")
    private String bundleFile;
    @JsonProperty("notAfter")
    private String notAfter;
    @JsonProperty("notBefore")
    private String notBefore;
    @JsonProperty("signer")
    private String signer;
    @JsonProperty("subject")
    private String subject;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new LinkedHashMap<String, Object>();

    /**
     * No args constructor for use in serialization
     */
    public ControllerCertificate() {
    }

    public ControllerCertificate(String bundleFile, String notAfter, String notBefore, String signer, String subject) {
        super();
        this.bundleFile = bundleFile;
        this.notAfter = notAfter;
        this.notBefore = notBefore;
        this.signer = signer;
        this.subject = subject;
    }

    /**
     * bundleFile is the larger bundle a cert comes from
     */
    @JsonProperty("bundleFile")
    public String getBundleFile() {
        return bundleFile;
    }

    /**
     * bundleFile is the larger bundle a cert comes from
     */
    @JsonProperty("bundleFile")
    public void setBundleFile(String bundleFile) {
        this.bundleFile = bundleFile;
    }

    /**
     * ControllerCertificate contains info about a specific cert.
     */
    @JsonProperty("notAfter")
    public String getNotAfter() {
        return notAfter;
    }

    /**
     * ControllerCertificate contains info about a specific cert.
     */
    @JsonProperty("notAfter")
    public void setNotAfter(String notAfter) {
        this.notAfter = notAfter;
    }

    /**
     * ControllerCertificate contains info about a specific cert.
     */
    @JsonProperty("notBefore")
    public String getNotBefore() {
        return notBefore;
    }

    /**
     * ControllerCertificate contains info about a specific cert.
     */
    @JsonProperty("notBefore")
    public void setNotBefore(String notBefore) {
        this.notBefore = notBefore;
    }

    /**
     * signer is the  cert Issuer
     */
    @JsonProperty("signer")
    public String getSigner() {
        return signer;
    }

    /**
     * signer is the  cert Issuer
     */
    @JsonProperty("signer")
    public void setSigner(String signer) {
        this.signer = signer;
    }

    /**
     * subject is the cert subject
     */
    @JsonProperty("subject")
    public String getSubject() {
        return subject;
    }

    /**
     * subject is the cert subject
     */
    @JsonProperty("subject")
    public void setSubject(String subject) {
        this.subject = subject;
    }

    @JsonIgnore
    public ControllerCertificateBuilder edit() {
        return new ControllerCertificateBuilder(this);
    }

    @JsonIgnore
    public ControllerCertificateBuilder toBuilder() {
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
        if (!(o instanceof ControllerCertificate)) {
            return false;
        }
        ControllerCertificate other = (ControllerCertificate) o;
        if (!other.canEqual(this)) {
            return false;
        }
        Object this$bundleFile = this.getBundleFile();
        Object other$bundleFile = other.getBundleFile();
        if (this$bundleFile == null ? other$bundleFile != null : !this$bundleFile.equals(other$bundleFile)) {
            return false;
        }
        Object this$notAfter = this.getNotAfter();
        Object other$notAfter = other.getNotAfter();
        if (this$notAfter == null ? other$notAfter != null : !this$notAfter.equals(other$notAfter)) {
            return false;
        }
        Object this$notBefore = this.getNotBefore();
        Object other$notBefore = other.getNotBefore();
        if (this$notBefore == null ? other$notBefore != null : !this$notBefore.equals(other$notBefore)) {
            return false;
        }
        Object this$signer = this.getSigner();
        Object other$signer = other.getSigner();
        if (this$signer == null ? other$signer != null : !this$signer.equals(other$signer)) {
            return false;
        }
        Object this$subject = this.getSubject();
        Object other$subject = other.getSubject();
        if (this$subject == null ? other$subject != null : !this$subject.equals(other$subject)) {
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
        return other instanceof ControllerCertificate;
    }

    @Override
    public int hashCode() {
        final int prime = 59;
        int result = 1;
        Object $bundleFile = this.getBundleFile();
        result = result * prime + ($bundleFile == null ? 43 : $bundleFile.hashCode());
        Object $notAfter = this.getNotAfter();
        result = result * prime + ($notAfter == null ? 43 : $notAfter.hashCode());
        Object $notBefore = this.getNotBefore();
        result = result * prime + ($notBefore == null ? 43 : $notBefore.hashCode());
        Object $signer = this.getSigner();
        result = result * prime + ($signer == null ? 43 : $signer.hashCode());
        Object $subject = this.getSubject();
        result = result * prime + ($subject == null ? 43 : $subject.hashCode());
        Object $additionalProperties = this.getAdditionalProperties();
        result = result * prime + ($additionalProperties == null ? 43 : $additionalProperties.hashCode());
        return result;
    }

    @Override
    public String toString() {
        return "ControllerCertificate(" + "bundleFile=" + this.getBundleFile() + ", notAfter=" + this.getNotAfter() + ", notBefore=" + this.getNotBefore() + ", signer=" + this.getSigner() + ", subject=" + this.getSubject() + ", additionalProperties=" + this.getAdditionalProperties() + ")";
    }

}
