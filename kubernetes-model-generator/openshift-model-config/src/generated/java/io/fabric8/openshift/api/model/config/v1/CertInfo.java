
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
 * CertInfo relates a certificate with a private key
 */
@JsonDeserialize(using = com.fasterxml.jackson.databind.JsonDeserializer.None.class)
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "certFile",
    "keyFile"
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
public class CertInfo implements Editable<CertInfoBuilder>, KubernetesResource
{

    @JsonProperty("certFile")
    private String certFile;
    @JsonProperty("keyFile")
    private String keyFile;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new LinkedHashMap<String, Object>();

    /**
     * No args constructor for use in serialization
     */
    public CertInfo() {
    }

    public CertInfo(String certFile, String keyFile) {
        super();
        this.certFile = certFile;
        this.keyFile = keyFile;
    }

    /**
     * certFile is a file containing a PEM-encoded certificate
     */
    @JsonProperty("certFile")
    public String getCertFile() {
        return certFile;
    }

    /**
     * certFile is a file containing a PEM-encoded certificate
     */
    @JsonProperty("certFile")
    public void setCertFile(String certFile) {
        this.certFile = certFile;
    }

    /**
     * keyFile is a file containing a PEM-encoded private key for the certificate specified by CertFile
     */
    @JsonProperty("keyFile")
    public String getKeyFile() {
        return keyFile;
    }

    /**
     * keyFile is a file containing a PEM-encoded private key for the certificate specified by CertFile
     */
    @JsonProperty("keyFile")
    public void setKeyFile(String keyFile) {
        this.keyFile = keyFile;
    }

    @JsonIgnore
    public CertInfoBuilder edit() {
        return new CertInfoBuilder(this);
    }

    @JsonIgnore
    public CertInfoBuilder toBuilder() {
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
        if (!(o instanceof CertInfo)) {
            return false;
        }
        CertInfo other = (CertInfo) o;
        if (!other.canEqual(this)) {
            return false;
        }
        Object this$certFile = this.getCertFile();
        Object other$certFile = other.getCertFile();
        if (this$certFile == null ? other$certFile != null : !this$certFile.equals(other$certFile)) {
            return false;
        }
        Object this$keyFile = this.getKeyFile();
        Object other$keyFile = other.getKeyFile();
        if (this$keyFile == null ? other$keyFile != null : !this$keyFile.equals(other$keyFile)) {
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
        return other instanceof CertInfo;
    }

    @Override
    public int hashCode() {
        final int prime = 59;
        int result = 1;
        Object $certFile = this.getCertFile();
        result = result * prime + ($certFile == null ? 43 : $certFile.hashCode());
        Object $keyFile = this.getKeyFile();
        result = result * prime + ($keyFile == null ? 43 : $keyFile.hashCode());
        Object $additionalProperties = this.getAdditionalProperties();
        result = result * prime + ($additionalProperties == null ? 43 : $additionalProperties.hashCode());
        return result;
    }

    @Override
    public String toString() {
        return "CertInfo(" + "certFile=" + this.getCertFile() + ", keyFile=" + this.getKeyFile() + ", additionalProperties=" + this.getAdditionalProperties() + ")";
    }

}
