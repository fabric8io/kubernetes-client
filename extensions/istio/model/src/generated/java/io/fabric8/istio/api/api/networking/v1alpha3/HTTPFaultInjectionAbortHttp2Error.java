
package io.fabric8.istio.api.api.networking.v1alpha3;

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
 * $hide_from_docs
 */
@JsonDeserialize(using = com.fasterxml.jackson.databind.JsonDeserializer.None.class)
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "http2Error"
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
public class HTTPFaultInjectionAbortHttp2Error implements IsHTTPFaultInjectionAbortErrorType, Editable<HTTPFaultInjectionAbortHttp2ErrorBuilder>, KubernetesResource
{

    @JsonProperty("http2Error")
    private String http2Error;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new LinkedHashMap<String, Object>();

    /**
     * No args constructor for use in serialization
     */
    public HTTPFaultInjectionAbortHttp2Error() {
    }

    public HTTPFaultInjectionAbortHttp2Error(String http2Error) {
        super();
        this.http2Error = http2Error;
    }

    /**
     * $hide_from_docs
     */
    @JsonProperty("http2Error")
    public String getHttp2Error() {
        return http2Error;
    }

    /**
     * $hide_from_docs
     */
    @JsonProperty("http2Error")
    public void setHttp2Error(String http2Error) {
        this.http2Error = http2Error;
    }

    @JsonIgnore
    public HTTPFaultInjectionAbortHttp2ErrorBuilder edit() {
        return new HTTPFaultInjectionAbortHttp2ErrorBuilder(this);
    }

    @JsonIgnore
    public HTTPFaultInjectionAbortHttp2ErrorBuilder toBuilder() {
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
        if (!(o instanceof HTTPFaultInjectionAbortHttp2Error)) {
            return false;
        }
        HTTPFaultInjectionAbortHttp2Error other = (HTTPFaultInjectionAbortHttp2Error) o;
        if (!other.canEqual(this)) {
            return false;
        }
        Object this$http2Error = this.getHttp2Error();
        Object other$http2Error = other.getHttp2Error();
        if (this$http2Error == null ? other$http2Error != null : !this$http2Error.equals(other$http2Error)) {
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
        return other instanceof HTTPFaultInjectionAbortHttp2Error;
    }

    @Override
    public int hashCode() {
        final int prime = 59;
        int result = 1;
        Object $http2Error = this.getHttp2Error();
        result = result * prime + ($http2Error == null ? 43 : $http2Error.hashCode());
        Object $additionalProperties = this.getAdditionalProperties();
        result = result * prime + ($additionalProperties == null ? 43 : $additionalProperties.hashCode());
        return result;
    }

    @Override
    public String toString() {
        return "HTTPFaultInjectionAbortHttp2Error(" + "http2Error=" + this.getHttp2Error() + ", additionalProperties=" + this.getAdditionalProperties() + ")";
    }

}
