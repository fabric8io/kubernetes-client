
package io.fabric8.chaosmesh.v1alpha1;

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
import io.fabric8.kubernetes.api.model.ObjectReference;
import io.fabric8.kubernetes.api.model.PersistentVolumeClaim;
import io.fabric8.kubernetes.api.model.PodTemplateSpec;
import io.fabric8.kubernetes.api.model.ResourceRequirements;
import io.fabric8.kubernetes.api.model.Volume;
import io.fabric8.kubernetes.api.model.VolumeMount;
import io.sundr.builder.annotations.Buildable;
import io.sundr.builder.annotations.BuildableReference;

/**
 * PodHttpChaosTLS contains the tls config for HTTPChaos
 */
@JsonDeserialize(using = com.fasterxml.jackson.databind.JsonDeserializer.None.class)
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "caName",
    "certName",
    "keyName",
    "secretName",
    "secretNamespace"
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
public class PodHttpChaosTLS implements Editable<PodHttpChaosTLSBuilder>, KubernetesResource
{

    @JsonProperty("caName")
    private String caName;
    @JsonProperty("certName")
    private String certName;
    @JsonProperty("keyName")
    private String keyName;
    @JsonProperty("secretName")
    private String secretName;
    @JsonProperty("secretNamespace")
    private String secretNamespace;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new LinkedHashMap<String, Object>();

    /**
     * No args constructor for use in serialization
     */
    public PodHttpChaosTLS() {
    }

    public PodHttpChaosTLS(String caName, String certName, String keyName, String secretName, String secretNamespace) {
        super();
        this.caName = caName;
        this.certName = certName;
        this.keyName = keyName;
        this.secretName = secretName;
        this.secretNamespace = secretNamespace;
    }

    /**
     * CAName represents the data name of ca file in secret, `ca.crt` for example
     */
    @JsonProperty("caName")
    public String getCaName() {
        return caName;
    }

    /**
     * CAName represents the data name of ca file in secret, `ca.crt` for example
     */
    @JsonProperty("caName")
    public void setCaName(String caName) {
        this.caName = caName;
    }

    /**
     * CertName represents the data name of cert file in secret, `tls.crt` for example
     */
    @JsonProperty("certName")
    public String getCertName() {
        return certName;
    }

    /**
     * CertName represents the data name of cert file in secret, `tls.crt` for example
     */
    @JsonProperty("certName")
    public void setCertName(String certName) {
        this.certName = certName;
    }

    /**
     * KeyName represents the data name of key file in secret, `tls.key` for example
     */
    @JsonProperty("keyName")
    public String getKeyName() {
        return keyName;
    }

    /**
     * KeyName represents the data name of key file in secret, `tls.key` for example
     */
    @JsonProperty("keyName")
    public void setKeyName(String keyName) {
        this.keyName = keyName;
    }

    /**
     * SecretName represents the name of required secret resource
     */
    @JsonProperty("secretName")
    public String getSecretName() {
        return secretName;
    }

    /**
     * SecretName represents the name of required secret resource
     */
    @JsonProperty("secretName")
    public void setSecretName(String secretName) {
        this.secretName = secretName;
    }

    /**
     * SecretNamespace represents the namespace of required secret resource
     */
    @JsonProperty("secretNamespace")
    public String getSecretNamespace() {
        return secretNamespace;
    }

    /**
     * SecretNamespace represents the namespace of required secret resource
     */
    @JsonProperty("secretNamespace")
    public void setSecretNamespace(String secretNamespace) {
        this.secretNamespace = secretNamespace;
    }

    @JsonIgnore
    public PodHttpChaosTLSBuilder edit() {
        return new PodHttpChaosTLSBuilder(this);
    }

    @JsonIgnore
    public PodHttpChaosTLSBuilder toBuilder() {
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
        if (!(o instanceof PodHttpChaosTLS)) {
            return false;
        }
        PodHttpChaosTLS other = (PodHttpChaosTLS) o;
        if (!other.canEqual(this)) {
            return false;
        }
        Object this$caName = this.getCaName();
        Object other$caName = other.getCaName();
        if (this$caName == null ? other$caName != null : !this$caName.equals(other$caName)) {
            return false;
        }
        Object this$certName = this.getCertName();
        Object other$certName = other.getCertName();
        if (this$certName == null ? other$certName != null : !this$certName.equals(other$certName)) {
            return false;
        }
        Object this$keyName = this.getKeyName();
        Object other$keyName = other.getKeyName();
        if (this$keyName == null ? other$keyName != null : !this$keyName.equals(other$keyName)) {
            return false;
        }
        Object this$secretName = this.getSecretName();
        Object other$secretName = other.getSecretName();
        if (this$secretName == null ? other$secretName != null : !this$secretName.equals(other$secretName)) {
            return false;
        }
        Object this$secretNamespace = this.getSecretNamespace();
        Object other$secretNamespace = other.getSecretNamespace();
        if (this$secretNamespace == null ? other$secretNamespace != null : !this$secretNamespace.equals(other$secretNamespace)) {
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
        return other instanceof PodHttpChaosTLS;
    }

    @Override
    public int hashCode() {
        final int prime = 59;
        int result = 1;
        Object $caName = this.getCaName();
        result = result * prime + ($caName == null ? 43 : $caName.hashCode());
        Object $certName = this.getCertName();
        result = result * prime + ($certName == null ? 43 : $certName.hashCode());
        Object $keyName = this.getKeyName();
        result = result * prime + ($keyName == null ? 43 : $keyName.hashCode());
        Object $secretName = this.getSecretName();
        result = result * prime + ($secretName == null ? 43 : $secretName.hashCode());
        Object $secretNamespace = this.getSecretNamespace();
        result = result * prime + ($secretNamespace == null ? 43 : $secretNamespace.hashCode());
        Object $additionalProperties = this.getAdditionalProperties();
        result = result * prime + ($additionalProperties == null ? 43 : $additionalProperties.hashCode());
        return result;
    }

    @Override
    public String toString() {
        return "PodHttpChaosTLS(" + "caName=" + this.getCaName() + ", certName=" + this.getCertName() + ", keyName=" + this.getKeyName() + ", secretName=" + this.getSecretName() + ", secretNamespace=" + this.getSecretNamespace() + ", additionalProperties=" + this.getAdditionalProperties() + ")";
    }

}
