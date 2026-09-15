
package io.fabric8.knative.bindings.v1;

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

@JsonDeserialize(using = com.fasterxml.jackson.databind.JsonDeserializer.None.class)
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "caCert",
    "cert",
    "enable",
    "key"
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
public class KafkaTLSSpec implements Editable<KafkaTLSSpecBuilder>, KubernetesResource
{

    @JsonProperty("caCert")
    private SecretValueFromSource caCert;
    @JsonProperty("cert")
    private SecretValueFromSource cert;
    @JsonProperty("enable")
    private Boolean enable;
    @JsonProperty("key")
    private SecretValueFromSource key;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new LinkedHashMap<String, Object>();

    /**
     * No args constructor for use in serialization
     */
    public KafkaTLSSpec() {
    }

    public KafkaTLSSpec(SecretValueFromSource caCert, SecretValueFromSource cert, Boolean enable, SecretValueFromSource key) {
        super();
        this.caCert = caCert;
        this.cert = cert;
        this.enable = enable;
        this.key = key;
    }

    @JsonProperty("caCert")
    public SecretValueFromSource getCaCert() {
        return caCert;
    }

    @JsonProperty("caCert")
    public void setCaCert(SecretValueFromSource caCert) {
        this.caCert = caCert;
    }

    @JsonProperty("cert")
    public SecretValueFromSource getCert() {
        return cert;
    }

    @JsonProperty("cert")
    public void setCert(SecretValueFromSource cert) {
        this.cert = cert;
    }

    @JsonProperty("enable")
    public Boolean getEnable() {
        return enable;
    }

    @JsonProperty("enable")
    public void setEnable(Boolean enable) {
        this.enable = enable;
    }

    @JsonProperty("key")
    public SecretValueFromSource getKey() {
        return key;
    }

    @JsonProperty("key")
    public void setKey(SecretValueFromSource key) {
        this.key = key;
    }

    @JsonIgnore
    public KafkaTLSSpecBuilder edit() {
        return new KafkaTLSSpecBuilder(this);
    }

    @JsonIgnore
    public KafkaTLSSpecBuilder toBuilder() {
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
        if (!(o instanceof KafkaTLSSpec)) {
            return false;
        }
        KafkaTLSSpec other = (KafkaTLSSpec) o;
        if (!other.canEqual(this)) {
            return false;
        }
        Object this$caCert = this.getCaCert();
        Object other$caCert = other.getCaCert();
        if (this$caCert == null ? other$caCert != null : !this$caCert.equals(other$caCert)) {
            return false;
        }
        Object this$cert = this.getCert();
        Object other$cert = other.getCert();
        if (this$cert == null ? other$cert != null : !this$cert.equals(other$cert)) {
            return false;
        }
        Object this$enable = this.getEnable();
        Object other$enable = other.getEnable();
        if (this$enable == null ? other$enable != null : !this$enable.equals(other$enable)) {
            return false;
        }
        Object this$key = this.getKey();
        Object other$key = other.getKey();
        if (this$key == null ? other$key != null : !this$key.equals(other$key)) {
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
        return other instanceof KafkaTLSSpec;
    }

    @Override
    public int hashCode() {
        final int prime = 59;
        int result = 1;
        Object $caCert = this.getCaCert();
        result = result * prime + ($caCert == null ? 43 : $caCert.hashCode());
        Object $cert = this.getCert();
        result = result * prime + ($cert == null ? 43 : $cert.hashCode());
        Object $enable = this.getEnable();
        result = result * prime + ($enable == null ? 43 : $enable.hashCode());
        Object $key = this.getKey();
        result = result * prime + ($key == null ? 43 : $key.hashCode());
        Object $additionalProperties = this.getAdditionalProperties();
        result = result * prime + ($additionalProperties == null ? 43 : $additionalProperties.hashCode());
        return result;
    }

    @Override
    public String toString() {
        return "KafkaTLSSpec(" + "caCert=" + this.getCaCert() + ", cert=" + this.getCert() + ", enable=" + this.getEnable() + ", key=" + this.getKey() + ", additionalProperties=" + this.getAdditionalProperties() + ")";
    }

}
