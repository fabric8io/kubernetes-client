
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
 * ceryExpiry contains the bundle name and the expiry date
 */
@JsonDeserialize(using = com.fasterxml.jackson.databind.JsonDeserializer.None.class)
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "bundle",
    "expiry",
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
public class CertExpiry implements Editable<CertExpiryBuilder>, KubernetesResource
{

    @JsonProperty("bundle")
    private String bundle;
    @JsonProperty("expiry")
    private String expiry;
    @JsonProperty("subject")
    private String subject;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new LinkedHashMap<String, Object>();

    /**
     * No args constructor for use in serialization
     */
    public CertExpiry() {
    }

    public CertExpiry(String bundle, String expiry, String subject) {
        super();
        this.bundle = bundle;
        this.expiry = expiry;
        this.subject = subject;
    }

    /**
     * bundle is the name of the bundle in which the subject certificate resides
     */
    @JsonProperty("bundle")
    public String getBundle() {
        return bundle;
    }

    /**
     * bundle is the name of the bundle in which the subject certificate resides
     */
    @JsonProperty("bundle")
    public void setBundle(String bundle) {
        this.bundle = bundle;
    }

    /**
     * ceryExpiry contains the bundle name and the expiry date
     */
    @JsonProperty("expiry")
    public String getExpiry() {
        return expiry;
    }

    /**
     * ceryExpiry contains the bundle name and the expiry date
     */
    @JsonProperty("expiry")
    public void setExpiry(String expiry) {
        this.expiry = expiry;
    }

    /**
     * subject is the subject of the certificate
     */
    @JsonProperty("subject")
    public String getSubject() {
        return subject;
    }

    /**
     * subject is the subject of the certificate
     */
    @JsonProperty("subject")
    public void setSubject(String subject) {
        this.subject = subject;
    }

    @JsonIgnore
    public CertExpiryBuilder edit() {
        return new CertExpiryBuilder(this);
    }

    @JsonIgnore
    public CertExpiryBuilder toBuilder() {
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
        if (!(o instanceof CertExpiry)) {
            return false;
        }
        CertExpiry other = (CertExpiry) o;
        if (!other.canEqual(this)) {
            return false;
        }
        Object this$bundle = this.getBundle();
        Object other$bundle = other.getBundle();
        if (this$bundle == null ? other$bundle != null : !this$bundle.equals(other$bundle)) {
            return false;
        }
        Object this$expiry = this.getExpiry();
        Object other$expiry = other.getExpiry();
        if (this$expiry == null ? other$expiry != null : !this$expiry.equals(other$expiry)) {
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
        return other instanceof CertExpiry;
    }

    @Override
    public int hashCode() {
        final int prime = 59;
        int result = 1;
        Object $bundle = this.getBundle();
        result = result * prime + ($bundle == null ? 43 : $bundle.hashCode());
        Object $expiry = this.getExpiry();
        result = result * prime + ($expiry == null ? 43 : $expiry.hashCode());
        Object $subject = this.getSubject();
        result = result * prime + ($subject == null ? 43 : $subject.hashCode());
        Object $additionalProperties = this.getAdditionalProperties();
        result = result * prime + ($additionalProperties == null ? 43 : $additionalProperties.hashCode());
        return result;
    }

    @Override
    public String toString() {
        return "CertExpiry(" + "bundle=" + this.getBundle() + ", expiry=" + this.getExpiry() + ", subject=" + this.getSubject() + ", additionalProperties=" + this.getAdditionalProperties() + ")";
    }

}
