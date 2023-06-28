
package io.fabric8.kubernetes.api.model.networking.v1beta1;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import javax.annotation.Generated;
import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
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
import lombok.Setter;
import lombok.ToString;
import lombok.experimental.Accessors;

@JsonDeserialize(using = com.fasterxml.jackson.databind.JsonDeserializer.None.class)
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "apiVersion",
    "kind",
    "metadata",
    "backend",
    "ingressClassName",
    "rules",
    "tls"
})
@ToString
@EqualsAndHashCode
@Setter
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
public class IngressSpec implements KubernetesResource
{

    @JsonProperty("backend")
    private IngressBackend backend;
    @JsonProperty("ingressClassName")
    private String ingressClassName;
    @JsonProperty("rules")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private List<IngressRule> rules = new ArrayList<IngressRule>();
    @JsonProperty("tls")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private List<IngressTLS> tls = new ArrayList<IngressTLS>();
    @JsonIgnore
    private Map<String, Object> additionalProperties = new LinkedHashMap<String, Object>();

    /**
     * No args constructor for use in serialization
     * 
     */
    public IngressSpec() {
    }

    public IngressSpec(IngressBackend backend, String ingressClassName, List<IngressRule> rules, List<IngressTLS> tls) {
        super();
        this.backend = backend;
        this.ingressClassName = ingressClassName;
        this.rules = rules;
        this.tls = tls;
    }

    @JsonProperty("backend")
    public IngressBackend getBackend() {
        return backend;
    }

    @JsonProperty("backend")
    public void setBackend(IngressBackend backend) {
        this.backend = backend;
    }

    @JsonProperty("ingressClassName")
    public String getIngressClassName() {
        return ingressClassName;
    }

    @JsonProperty("ingressClassName")
    public void setIngressClassName(String ingressClassName) {
        this.ingressClassName = ingressClassName;
    }

    @JsonProperty("rules")
    public List<IngressRule> getRules() {
        return rules;
    }

    @JsonProperty("rules")
    public void setRules(List<IngressRule> rules) {
        this.rules = rules;
    }

    @JsonProperty("tls")
    public List<IngressTLS> getTls() {
        return tls;
    }

    @JsonProperty("tls")
    public void setTls(List<IngressTLS> tls) {
        this.tls = tls;
    }

    @JsonAnyGetter
    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    @JsonAnySetter
    public void setAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
    }

}
