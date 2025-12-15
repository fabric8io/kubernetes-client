
package io.fabric8.openshift.api.model.miscellaneous.clusterapi.v1beta1;

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
 * InfrastructureNamingStrategy defines the naming strategy for infrastructure objects.
 */
@JsonDeserialize(using = com.fasterxml.jackson.databind.JsonDeserializer.None.class)
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "template"
})
@ToString
@EqualsAndHashCode
@Accessors(prefix = {
    "_",
    ""
})
@Buildable(editableEnabled = false, validationEnabled = false, generateBuilderPackage = false, lazyCollectionInitEnabled = false, builderPackage = "io.fabric8.kubernetes.api.builder", refs = {
    @BuildableReference(io.fabric8.kubernetes.api.model.ObjectMeta.class),
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
public class InfrastructureNamingStrategy implements Editable<InfrastructureNamingStrategyBuilder>, KubernetesResource
{

    @JsonProperty("template")
    private String template;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new LinkedHashMap<String, Object>();

    /**
     * No args constructor for use in serialization
     */
    public InfrastructureNamingStrategy() {
    }

    public InfrastructureNamingStrategy(String template) {
        super();
        this.template = template;
    }

    /**
     * template defines the template to use for generating the name of the Infrastructure object. If not defined, it will fallback to `{{ .cluster.name }}-{{ .random }}`. If the templated string exceeds 63 characters, it will be trimmed to 58 characters and will get concatenated with a random suffix of length 5. The templating mechanism provides the following arguments: &#42; `.cluster.name`: The name of the cluster object. &#42; `.random`: A random alphanumeric string, without vowels, of length 5.
     */
    @JsonProperty("template")
    public String getTemplate() {
        return template;
    }

    /**
     * template defines the template to use for generating the name of the Infrastructure object. If not defined, it will fallback to `{{ .cluster.name }}-{{ .random }}`. If the templated string exceeds 63 characters, it will be trimmed to 58 characters and will get concatenated with a random suffix of length 5. The templating mechanism provides the following arguments: &#42; `.cluster.name`: The name of the cluster object. &#42; `.random`: A random alphanumeric string, without vowels, of length 5.
     */
    @JsonProperty("template")
    public void setTemplate(String template) {
        this.template = template;
    }

    @JsonIgnore
    public InfrastructureNamingStrategyBuilder edit() {
        return new InfrastructureNamingStrategyBuilder(this);
    }

    @JsonIgnore
    public InfrastructureNamingStrategyBuilder toBuilder() {
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
