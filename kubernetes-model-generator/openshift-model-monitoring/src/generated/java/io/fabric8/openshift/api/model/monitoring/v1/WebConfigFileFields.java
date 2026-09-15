
package io.fabric8.openshift.api.model.monitoring.v1;

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
 * WebConfigFileFields defines the file content for --web.config.file flag.
 */
@JsonDeserialize(using = com.fasterxml.jackson.databind.JsonDeserializer.None.class)
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "httpConfig",
    "tlsConfig"
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
public class WebConfigFileFields implements Editable<WebConfigFileFieldsBuilder>, KubernetesResource
{

    @JsonProperty("httpConfig")
    private WebHTTPConfig httpConfig;
    @JsonProperty("tlsConfig")
    private WebTLSConfig tlsConfig;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new LinkedHashMap<String, Object>();

    /**
     * No args constructor for use in serialization
     */
    public WebConfigFileFields() {
    }

    public WebConfigFileFields(WebHTTPConfig httpConfig, WebTLSConfig tlsConfig) {
        super();
        this.httpConfig = httpConfig;
        this.tlsConfig = tlsConfig;
    }

    /**
     * WebConfigFileFields defines the file content for --web.config.file flag.
     */
    @JsonProperty("httpConfig")
    public WebHTTPConfig getHttpConfig() {
        return httpConfig;
    }

    /**
     * WebConfigFileFields defines the file content for --web.config.file flag.
     */
    @JsonProperty("httpConfig")
    public void setHttpConfig(WebHTTPConfig httpConfig) {
        this.httpConfig = httpConfig;
    }

    /**
     * WebConfigFileFields defines the file content for --web.config.file flag.
     */
    @JsonProperty("tlsConfig")
    public WebTLSConfig getTlsConfig() {
        return tlsConfig;
    }

    /**
     * WebConfigFileFields defines the file content for --web.config.file flag.
     */
    @JsonProperty("tlsConfig")
    public void setTlsConfig(WebTLSConfig tlsConfig) {
        this.tlsConfig = tlsConfig;
    }

    @JsonIgnore
    public WebConfigFileFieldsBuilder edit() {
        return new WebConfigFileFieldsBuilder(this);
    }

    @JsonIgnore
    public WebConfigFileFieldsBuilder toBuilder() {
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
        if (!(o instanceof WebConfigFileFields)) {
            return false;
        }
        WebConfigFileFields other = (WebConfigFileFields) o;
        if (!other.canEqual(this)) {
            return false;
        }
        Object this$httpConfig = this.getHttpConfig();
        Object other$httpConfig = other.getHttpConfig();
        if (this$httpConfig == null ? other$httpConfig != null : !this$httpConfig.equals(other$httpConfig)) {
            return false;
        }
        Object this$tlsConfig = this.getTlsConfig();
        Object other$tlsConfig = other.getTlsConfig();
        if (this$tlsConfig == null ? other$tlsConfig != null : !this$tlsConfig.equals(other$tlsConfig)) {
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
        return other instanceof WebConfigFileFields;
    }

    @Override
    public int hashCode() {
        final int prime = 59;
        int result = 1;
        Object $httpConfig = this.getHttpConfig();
        result = result * prime + ($httpConfig == null ? 43 : $httpConfig.hashCode());
        Object $tlsConfig = this.getTlsConfig();
        result = result * prime + ($tlsConfig == null ? 43 : $tlsConfig.hashCode());
        Object $additionalProperties = this.getAdditionalProperties();
        result = result * prime + ($additionalProperties == null ? 43 : $additionalProperties.hashCode());
        return result;
    }

    @Override
    public String toString() {
        return "WebConfigFileFields(" + "httpConfig=" + this.getHttpConfig() + ", tlsConfig=" + this.getTlsConfig() + ", additionalProperties=" + this.getAdditionalProperties() + ")";
    }

}
