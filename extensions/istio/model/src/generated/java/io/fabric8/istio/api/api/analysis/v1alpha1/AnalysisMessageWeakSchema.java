
package io.fabric8.istio.api.api.analysis.v1alpha1;

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

/**
 * AnalysisMessageWeakSchema is the set of information that's needed to define a weakly-typed schema. The purpose of this proto is to provide a mechanism for validating istio/istio/galley/pkg/config/analysis/msg/messages.yaml to make sure that we don't allow committing underspecified types.
 */
@JsonDeserialize(using = com.fasterxml.jackson.databind.JsonDeserializer.None.class)
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "args",
    "description",
    "messageBase",
    "template"
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
public class AnalysisMessageWeakSchema implements Editable<AnalysisMessageWeakSchemaBuilder>, KubernetesResource
{

    @JsonProperty("args")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private List<AnalysisMessageWeakSchemaArgType> args = new ArrayList<>();
    @JsonProperty("description")
    private String description;
    @JsonProperty("messageBase")
    private AnalysisMessageBase messageBase;
    @JsonProperty("template")
    private String template;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new LinkedHashMap<String, Object>();

    /**
     * No args constructor for use in serialization
     */
    public AnalysisMessageWeakSchema() {
    }

    public AnalysisMessageWeakSchema(List<AnalysisMessageWeakSchemaArgType> args, String description, AnalysisMessageBase messageBase, String template) {
        super();
        this.args = args;
        this.description = description;
        this.messageBase = messageBase;
        this.template = template;
    }

    /**
     * A description of the arguments for a particular message type
     */
    @JsonProperty("args")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    public List<AnalysisMessageWeakSchemaArgType> getArgs() {
        return args;
    }

    /**
     * A description of the arguments for a particular message type
     */
    @JsonProperty("args")
    public void setArgs(List<AnalysisMessageWeakSchemaArgType> args) {
        this.args = args;
    }

    /**
     * A human readable description of what the error means. Required.
     */
    @JsonProperty("description")
    public String getDescription() {
        return description;
    }

    /**
     * A human readable description of what the error means. Required.
     */
    @JsonProperty("description")
    public void setDescription(String description) {
        this.description = description;
    }

    /**
     * AnalysisMessageWeakSchema is the set of information that's needed to define a weakly-typed schema. The purpose of this proto is to provide a mechanism for validating istio/istio/galley/pkg/config/analysis/msg/messages.yaml to make sure that we don't allow committing underspecified types.
     */
    @JsonProperty("messageBase")
    public AnalysisMessageBase getMessageBase() {
        return messageBase;
    }

    /**
     * AnalysisMessageWeakSchema is the set of information that's needed to define a weakly-typed schema. The purpose of this proto is to provide a mechanism for validating istio/istio/galley/pkg/config/analysis/msg/messages.yaml to make sure that we don't allow committing underspecified types.
     */
    @JsonProperty("messageBase")
    public void setMessageBase(AnalysisMessageBase messageBase) {
        this.messageBase = messageBase;
    }

    /**
     * A go-style template string (https://golang.org/pkg/fmt/#hdr-Printing) defining how to combine the args for a  particular message into a log line. Required.
     */
    @JsonProperty("template")
    public String getTemplate() {
        return template;
    }

    /**
     * A go-style template string (https://golang.org/pkg/fmt/#hdr-Printing) defining how to combine the args for a  particular message into a log line. Required.
     */
    @JsonProperty("template")
    public void setTemplate(String template) {
        this.template = template;
    }

    @JsonIgnore
    public AnalysisMessageWeakSchemaBuilder edit() {
        return new AnalysisMessageWeakSchemaBuilder(this);
    }

    @JsonIgnore
    public AnalysisMessageWeakSchemaBuilder toBuilder() {
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
