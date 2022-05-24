
package io.fabric8.camelk.v1alpha1;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import io.fabric8.camelk.v1.SourceSpec;
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
    "authorization",
    "definition",
    "dependencies",
    "flow",
    "sources",
    "template",
    "types"
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
public class KameletSpec implements KubernetesResource
{

    @JsonProperty("authorization")
    private AuthorizationSpec authorization;
    @JsonProperty("definition")
    private JSONSchemaProps definition;
    @JsonProperty("dependencies")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private List<java.lang.String> dependencies = new ArrayList<java.lang.String>();
    @JsonProperty("flow")
    private JsonNode flow;
    @JsonProperty("sources")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private List<SourceSpec> sources = new ArrayList<SourceSpec>();
    @JsonProperty("template")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private Map<String, Object> template = new LinkedHashMap<String, Object>();
    @JsonProperty("types")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private Map<String, EventTypeSpec> types = new LinkedHashMap<String, EventTypeSpec>();
    @JsonIgnore
    private Map<java.lang.String, java.lang.Object> additionalProperties = new HashMap<java.lang.String, java.lang.Object>();

    /**
     * No args constructor for use in serialization
     * 
     */
    public KameletSpec() {
    }

    /**
     * 
     * @param authorization
     * @param template
     * @param types
     * @param sources
     * @param definition
     * @param flow
     * @param dependencies
     */
    public KameletSpec(AuthorizationSpec authorization, JSONSchemaProps definition, List<java.lang.String> dependencies, JsonNode flow, List<SourceSpec> sources, Map<String, Object> template, Map<String, EventTypeSpec> types) {
        super();
        this.authorization = authorization;
        this.definition = definition;
        this.dependencies = dependencies;
        this.flow = flow;
        this.sources = sources;
        this.template = template;
        this.types = types;
    }

    @JsonProperty("authorization")
    public AuthorizationSpec getAuthorization() {
        return authorization;
    }

    @JsonProperty("authorization")
    public void setAuthorization(AuthorizationSpec authorization) {
        this.authorization = authorization;
    }

    @JsonProperty("definition")
    public JSONSchemaProps getDefinition() {
        return definition;
    }

    @JsonProperty("definition")
    public void setDefinition(JSONSchemaProps definition) {
        this.definition = definition;
    }

    @JsonProperty("dependencies")
    public List<java.lang.String> getDependencies() {
        return dependencies;
    }

    @JsonProperty("dependencies")
    public void setDependencies(List<java.lang.String> dependencies) {
        this.dependencies = dependencies;
    }

    @JsonProperty("flow")
    public JsonNode getFlow() {
        return flow;
    }

    @JsonProperty("flow")
    public void setFlow(JsonNode flow) {
        this.flow = flow;
    }

    @JsonProperty("sources")
    public List<SourceSpec> getSources() {
        return sources;
    }

    @JsonProperty("sources")
    public void setSources(List<SourceSpec> sources) {
        this.sources = sources;
    }

    @JsonProperty("template")
    public Map<String, Object> getTemplate() {
        return template;
    }

    @JsonProperty("template")
    public void setTemplate(Map<String, Object> template) {
        this.template = template;
    }

    @JsonProperty("types")
    public Map<String, EventTypeSpec> getTypes() {
        return types;
    }

    @JsonProperty("types")
    public void setTypes(Map<String, EventTypeSpec> types) {
        this.types = types;
    }

    @JsonAnyGetter
    public Map<java.lang.String, java.lang.Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    @JsonAnySetter
    public void setAdditionalProperty(java.lang.String name, java.lang.Object value) {
        this.additionalProperties.put(name, value);
    }

}
