
package io.fabric8.istio.api.api.networking.v1alpha3;

import java.util.LinkedHashMap;
import java.util.Map;
import javax.annotation.Generated;
import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.fasterxml.jackson.annotation.JsonUnwrapped;
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

@JsonDeserialize(using = io.fabric8.kubernetes.model.jackson.JsonUnwrappedDeserializer.class)
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "ObjectTypes",
    "context",
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
public class EnvoyFilterEnvoyConfigObjectMatch implements Editable<EnvoyFilterEnvoyConfigObjectMatchBuilder> , KubernetesResource
{

    @JsonProperty("ObjectTypes")
    @JsonUnwrapped
    private IsEnvoyFilterEnvoyConfigObjectMatchObjectTypes objectTypes;
    @JsonProperty("context")
    private EnvoyFilterPatchContext context;
    @JsonProperty("proxy")
    private EnvoyFilterProxyMatch proxy;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new LinkedHashMap<String, Object>();

    /**
     * No args constructor for use in serialization
     * 
     */
    public EnvoyFilterEnvoyConfigObjectMatch() {
    }

    public EnvoyFilterEnvoyConfigObjectMatch(IsEnvoyFilterEnvoyConfigObjectMatchObjectTypes objectTypes, EnvoyFilterPatchContext context, EnvoyFilterProxyMatch proxy) {
        super();
        this.objectTypes = objectTypes;
        this.context = context;
        this.proxy = proxy;
    }

    @JsonProperty("ObjectTypes")
    @JsonUnwrapped
    public IsEnvoyFilterEnvoyConfigObjectMatchObjectTypes getObjectTypes() {
        return objectTypes;
    }

    @JsonProperty("ObjectTypes")
    public void setObjectTypes(IsEnvoyFilterEnvoyConfigObjectMatchObjectTypes objectTypes) {
        this.objectTypes = objectTypes;
    }

    @JsonProperty("context")
    public EnvoyFilterPatchContext getContext() {
        return context;
    }

    @JsonProperty("context")
    public void setContext(EnvoyFilterPatchContext context) {
        this.context = context;
    }

    @JsonProperty("proxy")
    public EnvoyFilterProxyMatch getProxy() {
        return proxy;
    }

    @JsonProperty("proxy")
    public void setProxy(EnvoyFilterProxyMatch proxy) {
        this.proxy = proxy;
    }

    @JsonIgnore
    public EnvoyFilterEnvoyConfigObjectMatchBuilder edit() {
        return new EnvoyFilterEnvoyConfigObjectMatchBuilder(this);
    }

    @JsonIgnore
    public EnvoyFilterEnvoyConfigObjectMatchBuilder toBuilder() {
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
