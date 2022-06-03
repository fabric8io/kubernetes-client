
package io.fabric8.tekton.triggers.v1alpha1;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
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
    "bindings",
    "interceptors",
    "name",
    "serviceAccountName",
    "template"
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
public class TriggerSpec implements KubernetesResource
{

    @JsonProperty("bindings")
    private List<TriggerSpecBinding> bindings = new ArrayList<TriggerSpecBinding>();
    @JsonProperty("interceptors")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private List<TriggerInterceptor> interceptors = new ArrayList<TriggerInterceptor>();
    @JsonProperty("name")
    private String name;
    @JsonProperty("serviceAccountName")
    private String serviceAccountName;
    @JsonProperty("template")
    private TriggerSpecTemplate template;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    /**
     * No args constructor for use in serialization
     * 
     */
    public TriggerSpec() {
    }

    /**
     * 
     * @param template
     * @param serviceAccountName
     * @param bindings
     * @param name
     * @param interceptors
     */
    public TriggerSpec(List<TriggerSpecBinding> bindings, List<TriggerInterceptor> interceptors, String name, String serviceAccountName, TriggerSpecTemplate template) {
        super();
        this.bindings = bindings;
        this.interceptors = interceptors;
        this.name = name;
        this.serviceAccountName = serviceAccountName;
        this.template = template;
    }

    @JsonProperty("bindings")
    public List<TriggerSpecBinding> getBindings() {
        return bindings;
    }

    @JsonProperty("bindings")
    public void setBindings(List<TriggerSpecBinding> bindings) {
        this.bindings = bindings;
    }

    @JsonProperty("interceptors")
    public List<TriggerInterceptor> getInterceptors() {
        return interceptors;
    }

    @JsonProperty("interceptors")
    public void setInterceptors(List<TriggerInterceptor> interceptors) {
        this.interceptors = interceptors;
    }

    @JsonProperty("name")
    public String getName() {
        return name;
    }

    @JsonProperty("name")
    public void setName(String name) {
        this.name = name;
    }

    @JsonProperty("serviceAccountName")
    public String getServiceAccountName() {
        return serviceAccountName;
    }

    @JsonProperty("serviceAccountName")
    public void setServiceAccountName(String serviceAccountName) {
        this.serviceAccountName = serviceAccountName;
    }

    @JsonProperty("template")
    public TriggerSpecTemplate getTemplate() {
        return template;
    }

    @JsonProperty("template")
    public void setTemplate(TriggerSpecTemplate template) {
        this.template = template;
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
