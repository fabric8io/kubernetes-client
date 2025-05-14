
package io.fabric8.kubernetes.api.model.admissionregistration.v1alpha1;

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
 * ParamRef describes how to locate the params to be used as input to expressions of rules applied by a policy binding.
 */
@JsonDeserialize(using = com.fasterxml.jackson.databind.JsonDeserializer.None.class)
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "name",
    "namespace",
    "parameterNotFoundAction",
    "selector"
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
public class ParamRef implements Editable<ParamRefBuilder>, KubernetesResource
{

    @JsonProperty("name")
    private String name;
    @JsonProperty("namespace")
    private String namespace;
    @JsonProperty("parameterNotFoundAction")
    private String parameterNotFoundAction;
    @JsonProperty("selector")
    private LabelSelector selector;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new LinkedHashMap<String, Object>();

    /**
     * No args constructor for use in serialization
     */
    public ParamRef() {
    }

    public ParamRef(String name, String namespace, String parameterNotFoundAction, LabelSelector selector) {
        super();
        this.name = name;
        this.namespace = namespace;
        this.parameterNotFoundAction = parameterNotFoundAction;
        this.selector = selector;
    }

    /**
     * `name` is the name of the resource being referenced.<br><p> <br><p> `name` and `selector` are mutually exclusive properties. If one is set, the other must be unset.
     */
    @JsonProperty("name")
    public String getName() {
        return name;
    }

    /**
     * `name` is the name of the resource being referenced.<br><p> <br><p> `name` and `selector` are mutually exclusive properties. If one is set, the other must be unset.
     */
    @JsonProperty("name")
    public void setName(String name) {
        this.name = name;
    }

    /**
     * namespace is the namespace of the referenced resource. Allows limiting the search for params to a specific namespace. Applies to both `name` and `selector` fields.<br><p> <br><p> A per-namespace parameter may be used by specifying a namespace-scoped `paramKind` in the policy and leaving this field empty.<br><p> <br><p> - If `paramKind` is cluster-scoped, this field MUST be unset. Setting this field results in a configuration error.<br><p> <br><p> - If `paramKind` is namespace-scoped, the namespace of the object being evaluated for admission will be used when this field is left unset. Take care that if this is left empty the binding must not match any cluster-scoped resources, which will result in an error.
     */
    @JsonProperty("namespace")
    public String getNamespace() {
        return namespace;
    }

    /**
     * namespace is the namespace of the referenced resource. Allows limiting the search for params to a specific namespace. Applies to both `name` and `selector` fields.<br><p> <br><p> A per-namespace parameter may be used by specifying a namespace-scoped `paramKind` in the policy and leaving this field empty.<br><p> <br><p> - If `paramKind` is cluster-scoped, this field MUST be unset. Setting this field results in a configuration error.<br><p> <br><p> - If `paramKind` is namespace-scoped, the namespace of the object being evaluated for admission will be used when this field is left unset. Take care that if this is left empty the binding must not match any cluster-scoped resources, which will result in an error.
     */
    @JsonProperty("namespace")
    public void setNamespace(String namespace) {
        this.namespace = namespace;
    }

    /**
     * `parameterNotFoundAction` controls the behavior of the binding when the resource exists, and name or selector is valid, but there are no parameters matched by the binding. If the value is set to `Allow`, then no matched parameters will be treated as successful validation by the binding. If set to `Deny`, then no matched parameters will be subject to the `failurePolicy` of the policy.<br><p> <br><p> Allowed values are `Allow` or `Deny` Default to `Deny`
     */
    @JsonProperty("parameterNotFoundAction")
    public String getParameterNotFoundAction() {
        return parameterNotFoundAction;
    }

    /**
     * `parameterNotFoundAction` controls the behavior of the binding when the resource exists, and name or selector is valid, but there are no parameters matched by the binding. If the value is set to `Allow`, then no matched parameters will be treated as successful validation by the binding. If set to `Deny`, then no matched parameters will be subject to the `failurePolicy` of the policy.<br><p> <br><p> Allowed values are `Allow` or `Deny` Default to `Deny`
     */
    @JsonProperty("parameterNotFoundAction")
    public void setParameterNotFoundAction(String parameterNotFoundAction) {
        this.parameterNotFoundAction = parameterNotFoundAction;
    }

    /**
     * ParamRef describes how to locate the params to be used as input to expressions of rules applied by a policy binding.
     */
    @JsonProperty("selector")
    public LabelSelector getSelector() {
        return selector;
    }

    /**
     * ParamRef describes how to locate the params to be used as input to expressions of rules applied by a policy binding.
     */
    @JsonProperty("selector")
    public void setSelector(LabelSelector selector) {
        this.selector = selector;
    }

    @JsonIgnore
    public ParamRefBuilder edit() {
        return new ParamRefBuilder(this);
    }

    @JsonIgnore
    public ParamRefBuilder toBuilder() {
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
