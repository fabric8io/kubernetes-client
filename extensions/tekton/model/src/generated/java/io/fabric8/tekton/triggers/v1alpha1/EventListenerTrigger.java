
package io.fabric8.tekton.triggers.v1alpha1;

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
 * EventListenerTrigger represents a connection between TriggerBinding, Params, and TriggerTemplate; TriggerBinding provides extracted values for TriggerTemplate to then create resources from. TriggerRef can also be provided instead of TriggerBinding, Interceptors and TriggerTemplate
 */
@JsonDeserialize(using = com.fasterxml.jackson.databind.JsonDeserializer.None.class)
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "bindings",
    "interceptors",
    "name",
    "serviceAccountName",
    "template",
    "triggerRef"
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
public class EventListenerTrigger implements Editable<EventListenerTriggerBuilder>, KubernetesResource
{

    @JsonProperty("bindings")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private List<TriggerSpecBinding> bindings = new ArrayList<>();
    @JsonProperty("interceptors")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private List<TriggerInterceptor> interceptors = new ArrayList<>();
    @JsonProperty("name")
    private String name;
    @JsonProperty("serviceAccountName")
    private String serviceAccountName;
    @JsonProperty("template")
    private TriggerSpecTemplate template;
    @JsonProperty("triggerRef")
    private String triggerRef;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new LinkedHashMap<String, Object>();

    /**
     * No args constructor for use in serialization
     */
    public EventListenerTrigger() {
    }

    public EventListenerTrigger(List<TriggerSpecBinding> bindings, List<TriggerInterceptor> interceptors, String name, String serviceAccountName, TriggerSpecTemplate template, String triggerRef) {
        super();
        this.bindings = bindings;
        this.interceptors = interceptors;
        this.name = name;
        this.serviceAccountName = serviceAccountName;
        this.template = template;
        this.triggerRef = triggerRef;
    }

    /**
     * EventListenerTrigger represents a connection between TriggerBinding, Params, and TriggerTemplate; TriggerBinding provides extracted values for TriggerTemplate to then create resources from. TriggerRef can also be provided instead of TriggerBinding, Interceptors and TriggerTemplate
     */
    @JsonProperty("bindings")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    public List<TriggerSpecBinding> getBindings() {
        return bindings;
    }

    /**
     * EventListenerTrigger represents a connection between TriggerBinding, Params, and TriggerTemplate; TriggerBinding provides extracted values for TriggerTemplate to then create resources from. TriggerRef can also be provided instead of TriggerBinding, Interceptors and TriggerTemplate
     */
    @JsonProperty("bindings")
    public void setBindings(List<TriggerSpecBinding> bindings) {
        this.bindings = bindings;
    }

    /**
     * EventListenerTrigger represents a connection between TriggerBinding, Params, and TriggerTemplate; TriggerBinding provides extracted values for TriggerTemplate to then create resources from. TriggerRef can also be provided instead of TriggerBinding, Interceptors and TriggerTemplate
     */
    @JsonProperty("interceptors")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    public List<TriggerInterceptor> getInterceptors() {
        return interceptors;
    }

    /**
     * EventListenerTrigger represents a connection between TriggerBinding, Params, and TriggerTemplate; TriggerBinding provides extracted values for TriggerTemplate to then create resources from. TriggerRef can also be provided instead of TriggerBinding, Interceptors and TriggerTemplate
     */
    @JsonProperty("interceptors")
    public void setInterceptors(List<TriggerInterceptor> interceptors) {
        this.interceptors = interceptors;
    }

    /**
     * EventListenerTrigger represents a connection between TriggerBinding, Params, and TriggerTemplate; TriggerBinding provides extracted values for TriggerTemplate to then create resources from. TriggerRef can also be provided instead of TriggerBinding, Interceptors and TriggerTemplate
     */
    @JsonProperty("name")
    public String getName() {
        return name;
    }

    /**
     * EventListenerTrigger represents a connection between TriggerBinding, Params, and TriggerTemplate; TriggerBinding provides extracted values for TriggerTemplate to then create resources from. TriggerRef can also be provided instead of TriggerBinding, Interceptors and TriggerTemplate
     */
    @JsonProperty("name")
    public void setName(String name) {
        this.name = name;
    }

    /**
     * ServiceAccountName optionally associates credentials with each trigger; more granular authorization for who is allowed to utilize the associated pipeline vs. defaulting to whatever permissions are associated with the entire EventListener and associated sink facilitates multi-tenant model based scenarios
     */
    @JsonProperty("serviceAccountName")
    public String getServiceAccountName() {
        return serviceAccountName;
    }

    /**
     * ServiceAccountName optionally associates credentials with each trigger; more granular authorization for who is allowed to utilize the associated pipeline vs. defaulting to whatever permissions are associated with the entire EventListener and associated sink facilitates multi-tenant model based scenarios
     */
    @JsonProperty("serviceAccountName")
    public void setServiceAccountName(String serviceAccountName) {
        this.serviceAccountName = serviceAccountName;
    }

    /**
     * EventListenerTrigger represents a connection between TriggerBinding, Params, and TriggerTemplate; TriggerBinding provides extracted values for TriggerTemplate to then create resources from. TriggerRef can also be provided instead of TriggerBinding, Interceptors and TriggerTemplate
     */
    @JsonProperty("template")
    public TriggerSpecTemplate getTemplate() {
        return template;
    }

    /**
     * EventListenerTrigger represents a connection between TriggerBinding, Params, and TriggerTemplate; TriggerBinding provides extracted values for TriggerTemplate to then create resources from. TriggerRef can also be provided instead of TriggerBinding, Interceptors and TriggerTemplate
     */
    @JsonProperty("template")
    public void setTemplate(TriggerSpecTemplate template) {
        this.template = template;
    }

    /**
     * EventListenerTrigger represents a connection between TriggerBinding, Params, and TriggerTemplate; TriggerBinding provides extracted values for TriggerTemplate to then create resources from. TriggerRef can also be provided instead of TriggerBinding, Interceptors and TriggerTemplate
     */
    @JsonProperty("triggerRef")
    public String getTriggerRef() {
        return triggerRef;
    }

    /**
     * EventListenerTrigger represents a connection between TriggerBinding, Params, and TriggerTemplate; TriggerBinding provides extracted values for TriggerTemplate to then create resources from. TriggerRef can also be provided instead of TriggerBinding, Interceptors and TriggerTemplate
     */
    @JsonProperty("triggerRef")
    public void setTriggerRef(String triggerRef) {
        this.triggerRef = triggerRef;
    }

    @JsonIgnore
    public EventListenerTriggerBuilder edit() {
        return new EventListenerTriggerBuilder(this);
    }

    @JsonIgnore
    public EventListenerTriggerBuilder toBuilder() {
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
