
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
import lombok.EqualsAndHashCode;
import lombok.ToString;
import lombok.experimental.Accessors;

/**
 * IngressControllerHTTPUniqueIdHeaderPolicy describes configuration for a unique id header.
 */
@JsonDeserialize(using = com.fasterxml.jackson.databind.JsonDeserializer.None.class)
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "format",
    "name"
})
@ToString
@EqualsAndHashCode
@Accessors(prefix = {
    "_",
    ""
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
public class IngressControllerHTTPUniqueIdHeaderPolicy implements Editable<IngressControllerHTTPUniqueIdHeaderPolicyBuilder>, KubernetesResource
{

    @JsonProperty("format")
    private String format;
    @JsonProperty("name")
    private String name;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new LinkedHashMap<String, Object>();

    /**
     * No args constructor for use in serialization
     */
    public IngressControllerHTTPUniqueIdHeaderPolicy() {
    }

    public IngressControllerHTTPUniqueIdHeaderPolicy(String format, String name) {
        super();
        this.format = format;
        this.name = name;
    }

    /**
     * format specifies the format for the injected HTTP header's value. This field has no effect unless name is specified.  For the HAProxy-based ingress controller implementation, this format uses the same syntax as the HTTP log format.  If the field is empty, the default value is "%{+X}o\\ %ci:%cp_%fi:%fp_%Ts_%rt:%pid"; see the corresponding HAProxy documentation: http://cbonte.github.io/haproxy-dconv/2.0/configuration.html#8.2.3
     */
    @JsonProperty("format")
    public String getFormat() {
        return format;
    }

    /**
     * format specifies the format for the injected HTTP header's value. This field has no effect unless name is specified.  For the HAProxy-based ingress controller implementation, this format uses the same syntax as the HTTP log format.  If the field is empty, the default value is "%{+X}o\\ %ci:%cp_%fi:%fp_%Ts_%rt:%pid"; see the corresponding HAProxy documentation: http://cbonte.github.io/haproxy-dconv/2.0/configuration.html#8.2.3
     */
    @JsonProperty("format")
    public void setFormat(String format) {
        this.format = format;
    }

    /**
     * name specifies the name of the HTTP header (for example, "unique-id") that the ingress controller should inject into HTTP requests.  The field's value must be a valid HTTP header name as defined in RFC 2616 section 4.2.  If the field is empty, no header is injected.
     */
    @JsonProperty("name")
    public String getName() {
        return name;
    }

    /**
     * name specifies the name of the HTTP header (for example, "unique-id") that the ingress controller should inject into HTTP requests.  The field's value must be a valid HTTP header name as defined in RFC 2616 section 4.2.  If the field is empty, no header is injected.
     */
    @JsonProperty("name")
    public void setName(String name) {
        this.name = name;
    }

    @JsonIgnore
    public IngressControllerHTTPUniqueIdHeaderPolicyBuilder edit() {
        return new IngressControllerHTTPUniqueIdHeaderPolicyBuilder(this);
    }

    @JsonIgnore
    public IngressControllerHTTPUniqueIdHeaderPolicyBuilder toBuilder() {
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

}
