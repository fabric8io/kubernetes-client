
package io.fabric8.openshift.api.model.console.v1;

import java.util.LinkedHashMap;
import java.util.Map;
import javax.annotation.Generated;
import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import io.fabric8.kubernetes.api.builder.Editable;
import io.fabric8.kubernetes.api.model.Container;
import io.fabric8.kubernetes.api.model.IntOrString;
import io.fabric8.kubernetes.api.model.KubernetesResource;
import io.fabric8.kubernetes.api.model.LabelSelector;
import io.fabric8.kubernetes.api.model.LocalObjectReference;
import io.fabric8.kubernetes.api.model.ObjectMeta;
import io.fabric8.kubernetes.api.model.ObjectReference;
import io.fabric8.kubernetes.api.model.PersistentVolumeClaim;
import io.fabric8.kubernetes.api.model.PodTemplateSpec;
import io.fabric8.kubernetes.api.model.ResourceRequirements;
import io.sundr.builder.annotations.Buildable;
import io.sundr.builder.annotations.BuildableReference;
import lombok.EqualsAndHashCode;
import lombok.ToString;
import lombok.experimental.Accessors;

@JsonDeserialize(using = com.fasterxml.jackson.databind.JsonDeserializer.None.class)
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "alias",
    "authorization",
    "caCertificate",
    "endpoint"
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
    @BuildableReference(PersistentVolumeClaim.class)
})
@Generated("jsonschema2pojo")
public class ConsolePluginSpecProxy implements Editable<ConsolePluginSpecProxyBuilder> , KubernetesResource
{

    @JsonProperty("alias")
    private String alias;
    @JsonProperty("authorization")
    private String authorization;
    @JsonProperty("caCertificate")
    private String caCertificate;
    @JsonProperty("endpoint")
    private ConsolePluginSpecPEndpoint endpoint;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new LinkedHashMap<String, Object>();

    /**
     * No args constructor for use in serialization
     * 
     */
    public ConsolePluginSpecProxy() {
    }

    public ConsolePluginSpecProxy(String alias, String authorization, String caCertificate, ConsolePluginSpecPEndpoint endpoint) {
        super();
        this.alias = alias;
        this.authorization = authorization;
        this.caCertificate = caCertificate;
        this.endpoint = endpoint;
    }

    @JsonProperty("alias")
    public String getAlias() {
        return alias;
    }

    @JsonProperty("alias")
    public void setAlias(String alias) {
        this.alias = alias;
    }

    @JsonProperty("authorization")
    public String getAuthorization() {
        return authorization;
    }

    @JsonProperty("authorization")
    public void setAuthorization(String authorization) {
        this.authorization = authorization;
    }

    @JsonProperty("caCertificate")
    public String getCaCertificate() {
        return caCertificate;
    }

    @JsonProperty("caCertificate")
    public void setCaCertificate(String caCertificate) {
        this.caCertificate = caCertificate;
    }

    @JsonProperty("endpoint")
    public ConsolePluginSpecPEndpoint getEndpoint() {
        return endpoint;
    }

    @JsonProperty("endpoint")
    public void setEndpoint(ConsolePluginSpecPEndpoint endpoint) {
        this.endpoint = endpoint;
    }

    @JsonIgnore
    public ConsolePluginSpecProxyBuilder edit() {
        return new ConsolePluginSpecProxyBuilder(this);
    }

    @JsonIgnore
    public ConsolePluginSpecProxyBuilder toBuilder() {
        return edit();
    }

    @JsonAnyGetter
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
