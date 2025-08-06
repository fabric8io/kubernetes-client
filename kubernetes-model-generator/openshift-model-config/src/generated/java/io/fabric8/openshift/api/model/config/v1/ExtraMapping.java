
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
import lombok.EqualsAndHashCode;
import lombok.ToString;
import lombok.experimental.Accessors;

/**
 * ExtraMapping allows specifying a key and CEL expression to evaluate the keys' value. It is used to create additional mappings and attributes added to a cluster identity from a provided authentication token.
 */
@JsonDeserialize(using = com.fasterxml.jackson.databind.JsonDeserializer.None.class)
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "key",
    "valueExpression"
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
    @BuildableReference(LocalObjectReference.class),
    @BuildableReference(PersistentVolumeClaim.class),
    @BuildableReference(EnvVar.class),
    @BuildableReference(ContainerPort.class),
    @BuildableReference(Volume.class),
    @BuildableReference(VolumeMount.class)
})
@Generated("io.fabric8.kubernetes.schema.generator.model.ModelGenerator")
public class ExtraMapping implements Editable<ExtraMappingBuilder>, KubernetesResource
{

    @JsonProperty("key")
    private String key;
    @JsonProperty("valueExpression")
    private String valueExpression;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new LinkedHashMap<String, Object>();

    /**
     * No args constructor for use in serialization
     */
    public ExtraMapping() {
    }

    public ExtraMapping(String key, String valueExpression) {
        super();
        this.key = key;
        this.valueExpression = valueExpression;
    }

    /**
     * key is a required field that specifies the string to use as the extra attribute key.<br><p> <br><p> key must be a domain-prefix path (e.g 'example.org/foo'). key must not exceed 510 characters in length. key must contain the '/' character, separating the domain and path characters. key must not be empty.<br><p> <br><p> The domain portion of the key (string of characters prior to the '/') must be a valid RFC1123 subdomain. It must not exceed 253 characters in length. It must start and end with an alphanumeric character. It must only contain lower case alphanumeric characters and '-' or '.'. It must not use the reserved domains, or be subdomains of, "kubernetes.io", "k8s.io", and "openshift.io".<br><p> <br><p> The path portion of the key (string of characters after the '/') must not be empty and must consist of at least one alphanumeric character, percent-encoded octets, '-', '.', '_', '~', '!', '$', '&amp;', ''', '(', ')', '&#42;', '+', ',', ';', '=', and ':'. It must not exceed 256 characters in length.
     */
    @JsonProperty("key")
    public String getKey() {
        return key;
    }

    /**
     * key is a required field that specifies the string to use as the extra attribute key.<br><p> <br><p> key must be a domain-prefix path (e.g 'example.org/foo'). key must not exceed 510 characters in length. key must contain the '/' character, separating the domain and path characters. key must not be empty.<br><p> <br><p> The domain portion of the key (string of characters prior to the '/') must be a valid RFC1123 subdomain. It must not exceed 253 characters in length. It must start and end with an alphanumeric character. It must only contain lower case alphanumeric characters and '-' or '.'. It must not use the reserved domains, or be subdomains of, "kubernetes.io", "k8s.io", and "openshift.io".<br><p> <br><p> The path portion of the key (string of characters after the '/') must not be empty and must consist of at least one alphanumeric character, percent-encoded octets, '-', '.', '_', '~', '!', '$', '&amp;', ''', '(', ')', '&#42;', '+', ',', ';', '=', and ':'. It must not exceed 256 characters in length.
     */
    @JsonProperty("key")
    public void setKey(String key) {
        this.key = key;
    }

    /**
     * valueExpression is a required field to specify the CEL expression to extract the extra attribute value from a JWT token's claims. valueExpression must produce a string or string array value. "", [], and null are treated as the extra mapping not being present. Empty string values within an array are filtered out.<br><p> <br><p> CEL expressions have access to the token claims through a CEL variable, 'claims'. 'claims' is a map of claim names to claim values. For example, the 'sub' claim value can be accessed as 'claims.sub'. Nested claims can be accessed using dot notation ('claims.foo.bar').<br><p> <br><p> valueExpression must not exceed 4096 characters in length. valueExpression must not be empty.
     */
    @JsonProperty("valueExpression")
    public String getValueExpression() {
        return valueExpression;
    }

    /**
     * valueExpression is a required field to specify the CEL expression to extract the extra attribute value from a JWT token's claims. valueExpression must produce a string or string array value. "", [], and null are treated as the extra mapping not being present. Empty string values within an array are filtered out.<br><p> <br><p> CEL expressions have access to the token claims through a CEL variable, 'claims'. 'claims' is a map of claim names to claim values. For example, the 'sub' claim value can be accessed as 'claims.sub'. Nested claims can be accessed using dot notation ('claims.foo.bar').<br><p> <br><p> valueExpression must not exceed 4096 characters in length. valueExpression must not be empty.
     */
    @JsonProperty("valueExpression")
    public void setValueExpression(String valueExpression) {
        this.valueExpression = valueExpression;
    }

    @JsonIgnore
    public ExtraMappingBuilder edit() {
        return new ExtraMappingBuilder(this);
    }

    @JsonIgnore
    public ExtraMappingBuilder toBuilder() {
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
