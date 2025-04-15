
package io.fabric8.istio.api.api.analysis.v1alpha1;

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
 * GenericAnalysisMessage is an instance of an AnalysisMessage defined by a schema, whose metaschema is AnalysisMessageWeakSchema. (Names are hard.) Code should be able to perform validation of arguments as needed by using the message type information to look at the AnalysisMessageWeakSchema and examine the list of args at runtime. Developers can also create stronger-typed versions of GenericAnalysisMessage for well-known and stable message types.
 */
@JsonDeserialize(using = com.fasterxml.jackson.databind.JsonDeserializer.None.class)
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "args",
    "messageBase",
    "resourcePaths"
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
public class GenericAnalysisMessage implements Editable<GenericAnalysisMessageBuilder>, KubernetesResource
{

    @JsonProperty("args")
    @JsonDeserialize(using = io.fabric8.kubernetes.internal.KubernetesDeserializer.class)
    private Object args;
    @JsonProperty("messageBase")
    private AnalysisMessageBase messageBase;
    @JsonProperty("resourcePaths")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private List<String> resourcePaths = new ArrayList<>();
    @JsonIgnore
    private Map<String, Object> additionalProperties = new LinkedHashMap<String, Object>();

    /**
     * No args constructor for use in serialization
     */
    public GenericAnalysisMessage() {
    }

    public GenericAnalysisMessage(Object args, AnalysisMessageBase messageBase, List<String> resourcePaths) {
        super();
        this.args = args;
        this.messageBase = messageBase;
        this.resourcePaths = resourcePaths;
    }

    /**
     * GenericAnalysisMessage is an instance of an AnalysisMessage defined by a schema, whose metaschema is AnalysisMessageWeakSchema. (Names are hard.) Code should be able to perform validation of arguments as needed by using the message type information to look at the AnalysisMessageWeakSchema and examine the list of args at runtime. Developers can also create stronger-typed versions of GenericAnalysisMessage for well-known and stable message types.
     */
    @JsonProperty("args")
    public Object getArgs() {
        return args;
    }

    /**
     * GenericAnalysisMessage is an instance of an AnalysisMessage defined by a schema, whose metaschema is AnalysisMessageWeakSchema. (Names are hard.) Code should be able to perform validation of arguments as needed by using the message type information to look at the AnalysisMessageWeakSchema and examine the list of args at runtime. Developers can also create stronger-typed versions of GenericAnalysisMessage for well-known and stable message types.
     */
    @JsonProperty("args")
    @JsonDeserialize(using = io.fabric8.kubernetes.internal.KubernetesDeserializer.class)
    public void setArgs(Object args) {
        this.args = args;
    }

    /**
     * GenericAnalysisMessage is an instance of an AnalysisMessage defined by a schema, whose metaschema is AnalysisMessageWeakSchema. (Names are hard.) Code should be able to perform validation of arguments as needed by using the message type information to look at the AnalysisMessageWeakSchema and examine the list of args at runtime. Developers can also create stronger-typed versions of GenericAnalysisMessage for well-known and stable message types.
     */
    @JsonProperty("messageBase")
    public AnalysisMessageBase getMessageBase() {
        return messageBase;
    }

    /**
     * GenericAnalysisMessage is an instance of an AnalysisMessage defined by a schema, whose metaschema is AnalysisMessageWeakSchema. (Names are hard.) Code should be able to perform validation of arguments as needed by using the message type information to look at the AnalysisMessageWeakSchema and examine the list of args at runtime. Developers can also create stronger-typed versions of GenericAnalysisMessage for well-known and stable message types.
     */
    @JsonProperty("messageBase")
    public void setMessageBase(AnalysisMessageBase messageBase) {
        this.messageBase = messageBase;
    }

    /**
     * A list of strings specifying the resource identifiers that were the cause of message generation. A "path" here is a (NAMESPACE\/)?RESOURCETYPE/NAME tuple that uniquely identifies a particular resource. There doesn't seem to be a single concept for this, but this is intuitively taken from https://kubernetes.io/docs/reference/using-api/api-concepts/#standard-api-terminology At least one is required.
     */
    @JsonProperty("resourcePaths")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    public List<String> getResourcePaths() {
        return resourcePaths;
    }

    /**
     * A list of strings specifying the resource identifiers that were the cause of message generation. A "path" here is a (NAMESPACE\/)?RESOURCETYPE/NAME tuple that uniquely identifies a particular resource. There doesn't seem to be a single concept for this, but this is intuitively taken from https://kubernetes.io/docs/reference/using-api/api-concepts/#standard-api-terminology At least one is required.
     */
    @JsonProperty("resourcePaths")
    public void setResourcePaths(List<String> resourcePaths) {
        this.resourcePaths = resourcePaths;
    }

    @JsonIgnore
    public GenericAnalysisMessageBuilder edit() {
        return new GenericAnalysisMessageBuilder(this);
    }

    @JsonIgnore
    public GenericAnalysisMessageBuilder toBuilder() {
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
