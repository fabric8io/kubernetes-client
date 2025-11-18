
package io.fabric8.kubernetes.api.model.gatewayapi.v1;

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
import io.fabric8.kubernetes.api.model.ObjectMeta;
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
 * SubjectAltName represents Subject Alternative Name.
 */
@JsonDeserialize(using = com.fasterxml.jackson.databind.JsonDeserializer.None.class)
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "hostname",
    "type",
    "uri"
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
    @BuildableReference(io.fabric8.kubernetes.api.model.ObjectReference.class),
    @BuildableReference(io.fabric8.kubernetes.api.model.LocalObjectReference.class),
    @BuildableReference(PersistentVolumeClaim.class),
    @BuildableReference(EnvVar.class),
    @BuildableReference(ContainerPort.class),
    @BuildableReference(Volume.class),
    @BuildableReference(VolumeMount.class)
})
@Generated("io.fabric8.kubernetes.schema.generator.model.ModelGenerator")
public class SubjectAltName implements Editable<SubjectAltNameBuilder>, KubernetesResource
{

    @JsonProperty("hostname")
    private String hostname;
    @JsonProperty("type")
    private String type;
    @JsonProperty("uri")
    private String uri;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new LinkedHashMap<String, Object>();

    /**
     * No args constructor for use in serialization
     */
    public SubjectAltName() {
    }

    public SubjectAltName(String hostname, String type, String uri) {
        super();
        this.hostname = hostname;
        this.type = type;
        this.uri = uri;
    }

    /**
     * Hostname contains Subject Alternative Name specified in DNS name format. Required when Type is set to Hostname, ignored otherwise.<br><p> <br><p> Support: Core
     */
    @JsonProperty("hostname")
    public String getHostname() {
        return hostname;
    }

    /**
     * Hostname contains Subject Alternative Name specified in DNS name format. Required when Type is set to Hostname, ignored otherwise.<br><p> <br><p> Support: Core
     */
    @JsonProperty("hostname")
    public void setHostname(String hostname) {
        this.hostname = hostname;
    }

    /**
     * Type determines the format of the Subject Alternative Name. Always required.<br><p> <br><p> Support: Core
     */
    @JsonProperty("type")
    public String getType() {
        return type;
    }

    /**
     * Type determines the format of the Subject Alternative Name. Always required.<br><p> <br><p> Support: Core
     */
    @JsonProperty("type")
    public void setType(String type) {
        this.type = type;
    }

    /**
     * URI contains Subject Alternative Name specified in a full URI format. It MUST include both a scheme (e.g., "http" or "ftp") and a scheme-specific-part. Common values include SPIFFE IDs like "spiffe://mycluster.example.com/ns/myns/sa/svc1sa". Required when Type is set to URI, ignored otherwise.<br><p> <br><p> Support: Core
     */
    @JsonProperty("uri")
    public String getUri() {
        return uri;
    }

    /**
     * URI contains Subject Alternative Name specified in a full URI format. It MUST include both a scheme (e.g., "http" or "ftp") and a scheme-specific-part. Common values include SPIFFE IDs like "spiffe://mycluster.example.com/ns/myns/sa/svc1sa". Required when Type is set to URI, ignored otherwise.<br><p> <br><p> Support: Core
     */
    @JsonProperty("uri")
    public void setUri(String uri) {
        this.uri = uri;
    }

    @JsonIgnore
    public SubjectAltNameBuilder edit() {
        return new SubjectAltNameBuilder(this);
    }

    @JsonIgnore
    public SubjectAltNameBuilder toBuilder() {
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
