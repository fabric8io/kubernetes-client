
package io.fabric8.knative.sources.v1;

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
import io.fabric8.knative.internal.pkg.apis.Condition;
import io.fabric8.knative.internal.pkg.apis.duck.v1.AuthStatus;
import io.fabric8.knative.internal.pkg.apis.duck.v1.CloudEventAttributes;
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
import lombok.Setter;
import lombok.ToString;
import lombok.experimental.Accessors;

@JsonDeserialize(using = com.fasterxml.jackson.databind.JsonDeserializer.None.class)
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "annotations",
    "auth",
    "ceAttributes",
    "conditions",
    "namespaces",
    "observedGeneration",
    "sinkAudience",
    "sinkCACerts",
    "sinkUri"
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
    @BuildableReference(PersistentVolumeClaim.class),
    @BuildableReference(EnvVar.class),
    @BuildableReference(ContainerPort.class),
    @BuildableReference(Volume.class),
    @BuildableReference(VolumeMount.class)
})
@Generated("jsonschema2pojo")
public class ApiServerSourceStatus implements Editable<ApiServerSourceStatusBuilder> , KubernetesResource
{

    @JsonProperty("annotations")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private Map<String, String> annotations = new LinkedHashMap<String, String>();
    @JsonProperty("auth")
    private AuthStatus auth;
    @JsonProperty("ceAttributes")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private List<CloudEventAttributes> ceAttributes = new ArrayList<CloudEventAttributes>();
    @JsonProperty("conditions")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private List<Condition> conditions = new ArrayList<Condition>();
    @JsonProperty("namespaces")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private List<java.lang.String> namespaces = new ArrayList<java.lang.String>();
    @JsonProperty("observedGeneration")
    private Long observedGeneration;
    @JsonProperty("sinkAudience")
    private String sinkAudience;
    @JsonProperty("sinkCACerts")
    private String sinkCACerts;
    @JsonProperty("sinkUri")
    private java.lang.String sinkUri;
    @JsonIgnore
    private Map<java.lang.String, Object> additionalProperties = new LinkedHashMap<java.lang.String, Object>();

    /**
     * No args constructor for use in serialization
     * 
     */
    public ApiServerSourceStatus() {
    }

    public ApiServerSourceStatus(Map<String, String> annotations, AuthStatus auth, List<CloudEventAttributes> ceAttributes, List<Condition> conditions, List<java.lang.String> namespaces, Long observedGeneration, String sinkAudience, String sinkCACerts, java.lang.String sinkUri) {
        super();
        this.annotations = annotations;
        this.auth = auth;
        this.ceAttributes = ceAttributes;
        this.conditions = conditions;
        this.namespaces = namespaces;
        this.observedGeneration = observedGeneration;
        this.sinkAudience = sinkAudience;
        this.sinkCACerts = sinkCACerts;
        this.sinkUri = sinkUri;
    }

    @JsonProperty("annotations")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    public Map<String, String> getAnnotations() {
        return annotations;
    }

    @JsonProperty("annotations")
    public void setAnnotations(Map<String, String> annotations) {
        this.annotations = annotations;
    }

    @JsonProperty("auth")
    public AuthStatus getAuth() {
        return auth;
    }

    @JsonProperty("auth")
    public void setAuth(AuthStatus auth) {
        this.auth = auth;
    }

    @JsonProperty("ceAttributes")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    public List<CloudEventAttributes> getCeAttributes() {
        return ceAttributes;
    }

    @JsonProperty("ceAttributes")
    public void setCeAttributes(List<CloudEventAttributes> ceAttributes) {
        this.ceAttributes = ceAttributes;
    }

    @JsonProperty("conditions")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    public List<Condition> getConditions() {
        return conditions;
    }

    @JsonProperty("conditions")
    public void setConditions(List<Condition> conditions) {
        this.conditions = conditions;
    }

    @JsonProperty("namespaces")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    public List<java.lang.String> getNamespaces() {
        return namespaces;
    }

    @JsonProperty("namespaces")
    public void setNamespaces(List<java.lang.String> namespaces) {
        this.namespaces = namespaces;
    }

    @JsonProperty("observedGeneration")
    public Long getObservedGeneration() {
        return observedGeneration;
    }

    @JsonProperty("observedGeneration")
    public void setObservedGeneration(Long observedGeneration) {
        this.observedGeneration = observedGeneration;
    }

    @JsonProperty("sinkAudience")
    public String getSinkAudience() {
        return sinkAudience;
    }

    @JsonProperty("sinkAudience")
    public void setSinkAudience(String sinkAudience) {
        this.sinkAudience = sinkAudience;
    }

    @JsonProperty("sinkCACerts")
    public String getSinkCACerts() {
        return sinkCACerts;
    }

    @JsonProperty("sinkCACerts")
    public void setSinkCACerts(String sinkCACerts) {
        this.sinkCACerts = sinkCACerts;
    }

    @JsonProperty("sinkUri")
    public java.lang.String getSinkUri() {
        return sinkUri;
    }

    @JsonProperty("sinkUri")
    public void setSinkUri(java.lang.String sinkUri) {
        this.sinkUri = sinkUri;
    }

    @JsonIgnore
    public ApiServerSourceStatusBuilder edit() {
        return new ApiServerSourceStatusBuilder(this);
    }

    @JsonIgnore
    public ApiServerSourceStatusBuilder toBuilder() {
        return edit();
    }

    @JsonAnyGetter
    public Map<java.lang.String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    @JsonAnySetter
    public void setAdditionalProperty(java.lang.String name, Object value) {
        this.additionalProperties.put(name, value);
    }

}
