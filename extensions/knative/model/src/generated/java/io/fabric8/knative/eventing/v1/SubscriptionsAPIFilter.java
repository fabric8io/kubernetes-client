
package io.fabric8.knative.eventing.v1;

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
    "apiVersion",
    "kind",
    "metadata",
    "all",
    "any",
    "cesql",
    "exact",
    "not",
    "prefix",
    "suffix"
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
public class SubscriptionsAPIFilter implements KubernetesResource
{

    @JsonProperty("all")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private List<SubscriptionsAPIFilter> all = new ArrayList<SubscriptionsAPIFilter>();
    @JsonProperty("any")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private List<SubscriptionsAPIFilter> any = new ArrayList<SubscriptionsAPIFilter>();
    @JsonProperty("cesql")
    private java.lang.String cesql;
    @JsonProperty("exact")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private Map<String, String> exact = new LinkedHashMap<String, String>();
    @JsonProperty("not")
    private SubscriptionsAPIFilter not;
    @JsonProperty("prefix")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private Map<String, String> prefix = new LinkedHashMap<String, String>();
    @JsonProperty("suffix")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private Map<String, String> suffix = new LinkedHashMap<String, String>();
    @JsonIgnore
    private Map<java.lang.String, Object> additionalProperties = new LinkedHashMap<java.lang.String, Object>();

    /**
     * No args constructor for use in serialization
     * 
     */
    public SubscriptionsAPIFilter() {
    }

    public SubscriptionsAPIFilter(List<SubscriptionsAPIFilter> all, List<SubscriptionsAPIFilter> any, java.lang.String cesql, Map<String, String> exact, SubscriptionsAPIFilter not, Map<String, String> prefix, Map<String, String> suffix) {
        super();
        this.all = all;
        this.any = any;
        this.cesql = cesql;
        this.exact = exact;
        this.not = not;
        this.prefix = prefix;
        this.suffix = suffix;
    }

    @JsonProperty("all")
    public List<SubscriptionsAPIFilter> getAll() {
        return all;
    }

    @JsonProperty("all")
    public void setAll(List<SubscriptionsAPIFilter> all) {
        this.all = all;
    }

    @JsonProperty("any")
    public List<SubscriptionsAPIFilter> getAny() {
        return any;
    }

    @JsonProperty("any")
    public void setAny(List<SubscriptionsAPIFilter> any) {
        this.any = any;
    }

    @JsonProperty("cesql")
    public java.lang.String getCesql() {
        return cesql;
    }

    @JsonProperty("cesql")
    public void setCesql(java.lang.String cesql) {
        this.cesql = cesql;
    }

    @JsonProperty("exact")
    public Map<String, String> getExact() {
        return exact;
    }

    @JsonProperty("exact")
    public void setExact(Map<String, String> exact) {
        this.exact = exact;
    }

    @JsonProperty("not")
    public SubscriptionsAPIFilter getNot() {
        return not;
    }

    @JsonProperty("not")
    public void setNot(SubscriptionsAPIFilter not) {
        this.not = not;
    }

    @JsonProperty("prefix")
    public Map<String, String> getPrefix() {
        return prefix;
    }

    @JsonProperty("prefix")
    public void setPrefix(Map<String, String> prefix) {
        this.prefix = prefix;
    }

    @JsonProperty("suffix")
    public Map<String, String> getSuffix() {
        return suffix;
    }

    @JsonProperty("suffix")
    public void setSuffix(Map<String, String> suffix) {
        this.suffix = suffix;
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
