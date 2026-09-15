
package io.fabric8.openshift.api.model.operator.v1;

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
 * IngressControllerSetHTTPHeader defines the value which needs to be set on an HTTP header.
 */
@JsonDeserialize(using = com.fasterxml.jackson.databind.JsonDeserializer.None.class)
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "value"
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
public class IngressControllerSetHTTPHeader implements Editable<IngressControllerSetHTTPHeaderBuilder>, KubernetesResource
{

    @JsonProperty("value")
    private String value;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new LinkedHashMap<String, Object>();

    /**
     * No args constructor for use in serialization
     */
    public IngressControllerSetHTTPHeader() {
    }

    public IngressControllerSetHTTPHeader(String value) {
        super();
        this.value = value;
    }

    /**
     * value specifies a header value. Dynamic values can be added. The value will be interpreted as an HAProxy format string as defined in http://cbonte.github.io/haproxy-dconv/2.6/configuration.html#8.2.6  and may use HAProxy's %[] syntax and otherwise must be a valid HTTP header value as defined in https://datatracker.ietf.org/doc/html/rfc7230#section-3.2. The value of this field must be no more than 16384 characters in length. Note that the total size of all net added headers &#42;after&#42; interpolating dynamic values must not exceed the value of spec.tuningOptions.headerBufferMaxRewriteBytes on the IngressController.
     */
    @JsonProperty("value")
    public String getValue() {
        return value;
    }

    /**
     * value specifies a header value. Dynamic values can be added. The value will be interpreted as an HAProxy format string as defined in http://cbonte.github.io/haproxy-dconv/2.6/configuration.html#8.2.6  and may use HAProxy's %[] syntax and otherwise must be a valid HTTP header value as defined in https://datatracker.ietf.org/doc/html/rfc7230#section-3.2. The value of this field must be no more than 16384 characters in length. Note that the total size of all net added headers &#42;after&#42; interpolating dynamic values must not exceed the value of spec.tuningOptions.headerBufferMaxRewriteBytes on the IngressController.
     */
    @JsonProperty("value")
    public void setValue(String value) {
        this.value = value;
    }

    @JsonIgnore
    public IngressControllerSetHTTPHeaderBuilder edit() {
        return new IngressControllerSetHTTPHeaderBuilder(this);
    }

    @JsonIgnore
    public IngressControllerSetHTTPHeaderBuilder toBuilder() {
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
        if (!(o instanceof IngressControllerSetHTTPHeader)) {
            return false;
        }
        IngressControllerSetHTTPHeader other = (IngressControllerSetHTTPHeader) o;
        if (!other.canEqual(this)) {
            return false;
        }
        Object this$value = this.getValue();
        Object other$value = other.getValue();
        if (this$value == null ? other$value != null : !this$value.equals(other$value)) {
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
        return other instanceof IngressControllerSetHTTPHeader;
    }

    @Override
    public int hashCode() {
        final int prime = 59;
        int result = 1;
        Object $value = this.getValue();
        result = result * prime + ($value == null ? 43 : $value.hashCode());
        Object $additionalProperties = this.getAdditionalProperties();
        result = result * prime + ($additionalProperties == null ? 43 : $additionalProperties.hashCode());
        return result;
    }

    @Override
    public String toString() {
        return "IngressControllerSetHTTPHeader(" + "value=" + this.getValue() + ", additionalProperties=" + this.getAdditionalProperties() + ")";
    }

}
