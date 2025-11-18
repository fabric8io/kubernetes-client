
package io.fabric8.kubernetes.api.model.gatewayapi.v1;

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
 * HTTPHeaderFilter defines a filter that modifies the headers of an HTTP request or response. Only one action for a given header name is permitted. Filters specifying multiple actions of the same or different type for any one header name are invalid. Configuration to set or add multiple values for a header must use RFC 7230 header value formatting, separating each value with a comma.
 */
@JsonDeserialize(using = com.fasterxml.jackson.databind.JsonDeserializer.None.class)
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "add",
    "remove",
    "set"
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
public class HTTPHeaderFilter implements Editable<HTTPHeaderFilterBuilder>, KubernetesResource
{

    @JsonProperty("add")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private List<HTTPHeader> add = new ArrayList<>();
    @JsonProperty("remove")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private List<String> remove = new ArrayList<>();
    @JsonProperty("set")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private List<HTTPHeader> set = new ArrayList<>();
    @JsonIgnore
    private Map<String, Object> additionalProperties = new LinkedHashMap<String, Object>();

    /**
     * No args constructor for use in serialization
     */
    public HTTPHeaderFilter() {
    }

    public HTTPHeaderFilter(List<HTTPHeader> add, List<String> remove, List<HTTPHeader> set) {
        super();
        this.add = add;
        this.remove = remove;
        this.set = set;
    }

    /**
     * Add adds the given header(s) (name, value) to the request before the action. It appends to any existing values associated with the header name.<br><p> <br><p> Input:<br><p>   GET /foo HTTP/1.1<br><p>   my-header: foo<br><p> <br><p> Config:<br><p>   add:<br><p>   - name: "my-header"<br><p>     value: "bar,baz"<br><p> <br><p> Output:<br><p>   GET /foo HTTP/1.1<br><p>   my-header: foo,bar,baz
     */
    @JsonProperty("add")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    public List<HTTPHeader> getAdd() {
        return add;
    }

    /**
     * Add adds the given header(s) (name, value) to the request before the action. It appends to any existing values associated with the header name.<br><p> <br><p> Input:<br><p>   GET /foo HTTP/1.1<br><p>   my-header: foo<br><p> <br><p> Config:<br><p>   add:<br><p>   - name: "my-header"<br><p>     value: "bar,baz"<br><p> <br><p> Output:<br><p>   GET /foo HTTP/1.1<br><p>   my-header: foo,bar,baz
     */
    @JsonProperty("add")
    public void setAdd(List<HTTPHeader> add) {
        this.add = add;
    }

    /**
     * Remove the given header(s) from the HTTP request before the action. The value of Remove is a list of HTTP header names. Note that the header names are case-insensitive (see https://datatracker.ietf.org/doc/html/rfc2616#section-4.2).<br><p> <br><p> Input:<br><p>   GET /foo HTTP/1.1<br><p>   my-header1: foo<br><p>   my-header2: bar<br><p>   my-header3: baz<br><p> <br><p> Config:<br><p>   remove: ["my-header1", "my-header3"]<br><p> <br><p> Output:<br><p>   GET /foo HTTP/1.1<br><p>   my-header2: bar
     */
    @JsonProperty("remove")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    public List<String> getRemove() {
        return remove;
    }

    /**
     * Remove the given header(s) from the HTTP request before the action. The value of Remove is a list of HTTP header names. Note that the header names are case-insensitive (see https://datatracker.ietf.org/doc/html/rfc2616#section-4.2).<br><p> <br><p> Input:<br><p>   GET /foo HTTP/1.1<br><p>   my-header1: foo<br><p>   my-header2: bar<br><p>   my-header3: baz<br><p> <br><p> Config:<br><p>   remove: ["my-header1", "my-header3"]<br><p> <br><p> Output:<br><p>   GET /foo HTTP/1.1<br><p>   my-header2: bar
     */
    @JsonProperty("remove")
    public void setRemove(List<String> remove) {
        this.remove = remove;
    }

    /**
     * Set overwrites the request with the given header (name, value) before the action.<br><p> <br><p> Input:<br><p>   GET /foo HTTP/1.1<br><p>   my-header: foo<br><p> <br><p> Config:<br><p>   set:<br><p>   - name: "my-header"<br><p>     value: "bar"<br><p> <br><p> Output:<br><p>   GET /foo HTTP/1.1<br><p>   my-header: bar
     */
    @JsonProperty("set")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    public List<HTTPHeader> getSet() {
        return set;
    }

    /**
     * Set overwrites the request with the given header (name, value) before the action.<br><p> <br><p> Input:<br><p>   GET /foo HTTP/1.1<br><p>   my-header: foo<br><p> <br><p> Config:<br><p>   set:<br><p>   - name: "my-header"<br><p>     value: "bar"<br><p> <br><p> Output:<br><p>   GET /foo HTTP/1.1<br><p>   my-header: bar
     */
    @JsonProperty("set")
    public void setSet(List<HTTPHeader> set) {
        this.set = set;
    }

    @JsonIgnore
    public HTTPHeaderFilterBuilder edit() {
        return new HTTPHeaderFilterBuilder(this);
    }

    @JsonIgnore
    public HTTPHeaderFilterBuilder toBuilder() {
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
