
package io.fabric8.openshift.api.model.config.v1;

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
import io.fabric8.kubernetes.api.model.PersistentVolumeClaim;
import io.fabric8.kubernetes.api.model.PodTemplateSpec;
import io.fabric8.kubernetes.api.model.ResourceRequirements;
import io.fabric8.kubernetes.api.model.Volume;
import io.fabric8.kubernetes.api.model.VolumeMount;
import io.sundr.builder.annotations.Buildable;
import io.sundr.builder.annotations.BuildableReference;

/**
 * CustomTLSProfile is a user-defined TLS security profile. Be extremely careful using a custom TLS profile as invalid configurations can be catastrophic.
 */
@JsonDeserialize(using = com.fasterxml.jackson.databind.JsonDeserializer.None.class)
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "ciphers",
    "minTLSVersion"
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
public class CustomTLSProfile implements Editable<CustomTLSProfileBuilder>, KubernetesResource
{

    @JsonProperty("ciphers")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private List<String> ciphers = new ArrayList<>();
    @JsonProperty("minTLSVersion")
    private String minTLSVersion;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new LinkedHashMap<String, Object>();

    /**
     * No args constructor for use in serialization
     */
    public CustomTLSProfile() {
    }

    public CustomTLSProfile(List<String> ciphers, String minTLSVersion) {
        super();
        this.ciphers = ciphers;
        this.minTLSVersion = minTLSVersion;
    }

    /**
     * ciphers is used to specify the cipher algorithms that are negotiated during the TLS handshake.  Operators may remove entries their operands do not support.  For example, to use DES-CBC3-SHA  (yaml):<br><p> <br><p>   ciphers:<br><p>     - DES-CBC3-SHA
     */
    @JsonProperty("ciphers")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    public List<String> getCiphers() {
        return ciphers;
    }

    /**
     * ciphers is used to specify the cipher algorithms that are negotiated during the TLS handshake.  Operators may remove entries their operands do not support.  For example, to use DES-CBC3-SHA  (yaml):<br><p> <br><p>   ciphers:<br><p>     - DES-CBC3-SHA
     */
    @JsonProperty("ciphers")
    public void setCiphers(List<String> ciphers) {
        this.ciphers = ciphers;
    }

    /**
     * minTLSVersion is used to specify the minimal version of the TLS protocol that is negotiated during the TLS handshake. For example, to use TLS versions 1.1, 1.2 and 1.3 (yaml):<br><p> <br><p>   minTLSVersion: VersionTLS11<br><p> <br><p> NOTE: currently the highest minTLSVersion allowed is VersionTLS12
     */
    @JsonProperty("minTLSVersion")
    public String getMinTLSVersion() {
        return minTLSVersion;
    }

    /**
     * minTLSVersion is used to specify the minimal version of the TLS protocol that is negotiated during the TLS handshake. For example, to use TLS versions 1.1, 1.2 and 1.3 (yaml):<br><p> <br><p>   minTLSVersion: VersionTLS11<br><p> <br><p> NOTE: currently the highest minTLSVersion allowed is VersionTLS12
     */
    @JsonProperty("minTLSVersion")
    public void setMinTLSVersion(String minTLSVersion) {
        this.minTLSVersion = minTLSVersion;
    }

    @JsonIgnore
    public CustomTLSProfileBuilder edit() {
        return new CustomTLSProfileBuilder(this);
    }

    @JsonIgnore
    public CustomTLSProfileBuilder toBuilder() {
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
        if (!(o instanceof CustomTLSProfile)) {
            return false;
        }
        CustomTLSProfile other = (CustomTLSProfile) o;
        if (!other.canEqual(this)) {
            return false;
        }
        Object this$ciphers = this.getCiphers();
        Object other$ciphers = other.getCiphers();
        if (this$ciphers == null ? other$ciphers != null : !this$ciphers.equals(other$ciphers)) {
            return false;
        }
        Object this$minTLSVersion = this.getMinTLSVersion();
        Object other$minTLSVersion = other.getMinTLSVersion();
        if (this$minTLSVersion == null ? other$minTLSVersion != null : !this$minTLSVersion.equals(other$minTLSVersion)) {
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
        return other instanceof CustomTLSProfile;
    }

    @Override
    public int hashCode() {
        final int prime = 59;
        int result = 1;
        Object $ciphers = this.getCiphers();
        result = result * prime + ($ciphers == null ? 43 : $ciphers.hashCode());
        Object $minTLSVersion = this.getMinTLSVersion();
        result = result * prime + ($minTLSVersion == null ? 43 : $minTLSVersion.hashCode());
        Object $additionalProperties = this.getAdditionalProperties();
        result = result * prime + ($additionalProperties == null ? 43 : $additionalProperties.hashCode());
        return result;
    }

    @Override
    public String toString() {
        return "CustomTLSProfile(" + "ciphers=" + this.getCiphers() + ", minTLSVersion=" + this.getMinTLSVersion() + ", additionalProperties=" + this.getAdditionalProperties() + ")";
    }

}
