
package io.fabric8.openshift.api.model.console.v1;

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

@JsonDeserialize(using = com.fasterxml.jackson.databind.JsonDeserializer.None.class)
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "backend",
    "displayName",
    "i18n",
    "proxy"
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
public class ConsolePluginSpec implements Editable<ConsolePluginSpecBuilder> , KubernetesResource
{

    @JsonProperty("backend")
    private ConsolePluginBackend backend;
    @JsonProperty("displayName")
    private String displayName;
    @JsonProperty("i18n")
    private ConsolePluginI18n i18n;
    @JsonProperty("proxy")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private List<ConsolePluginProxy> proxy = new ArrayList<>();
    @JsonIgnore
    private Map<String, Object> additionalProperties = new LinkedHashMap<String, Object>();

    /**
     * No args constructor for use in serialization
     * 
     */
    public ConsolePluginSpec() {
    }

    public ConsolePluginSpec(ConsolePluginBackend backend, String displayName, ConsolePluginI18n i18n, List<ConsolePluginProxy> proxy) {
        super();
        this.backend = backend;
        this.displayName = displayName;
        this.i18n = i18n;
        this.proxy = proxy;
    }

    @JsonProperty("backend")
    public ConsolePluginBackend getBackend() {
        return backend;
    }

    @JsonProperty("backend")
    public void setBackend(ConsolePluginBackend backend) {
        this.backend = backend;
    }

    @JsonProperty("displayName")
    public String getDisplayName() {
        return displayName;
    }

    @JsonProperty("displayName")
    public void setDisplayName(String displayName) {
        this.displayName = displayName;
    }

    @JsonProperty("i18n")
    public ConsolePluginI18n getI18n() {
        return i18n;
    }

    @JsonProperty("i18n")
    public void setI18n(ConsolePluginI18n i18n) {
        this.i18n = i18n;
    }

    @JsonProperty("proxy")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    public List<ConsolePluginProxy> getProxy() {
        return proxy;
    }

    @JsonProperty("proxy")
    public void setProxy(List<ConsolePluginProxy> proxy) {
        this.proxy = proxy;
    }

    @JsonIgnore
    public ConsolePluginSpecBuilder edit() {
        return new ConsolePluginSpecBuilder(this);
    }

    @JsonIgnore
    public ConsolePluginSpecBuilder toBuilder() {
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
