
package io.fabric8.openshift.api.model;

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
 * DeploymentConfigRollbackSpec represents the options for rollback generation.
 */
@JsonDeserialize(using = com.fasterxml.jackson.databind.JsonDeserializer.None.class)
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "from",
    "includeReplicationMeta",
    "includeStrategy",
    "includeTemplate",
    "includeTriggers",
    "revision"
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
    @BuildableReference(io.fabric8.kubernetes.api.model.LocalObjectReference.class),
    @BuildableReference(PersistentVolumeClaim.class),
    @BuildableReference(EnvVar.class),
    @BuildableReference(ContainerPort.class),
    @BuildableReference(Volume.class),
    @BuildableReference(VolumeMount.class)
})
@Generated("io.fabric8.kubernetes.schema.generator.model.ModelGenerator")
public class DeploymentConfigRollbackSpec implements Editable<DeploymentConfigRollbackSpecBuilder>, KubernetesResource
{

    @JsonProperty("from")
    private ObjectReference from;
    @JsonProperty("includeReplicationMeta")
    private Boolean includeReplicationMeta;
    @JsonProperty("includeStrategy")
    private Boolean includeStrategy;
    @JsonProperty("includeTemplate")
    private Boolean includeTemplate;
    @JsonProperty("includeTriggers")
    private Boolean includeTriggers;
    @JsonProperty("revision")
    private Long revision;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new LinkedHashMap<String, Object>();

    /**
     * No args constructor for use in serialization
     */
    public DeploymentConfigRollbackSpec() {
    }

    public DeploymentConfigRollbackSpec(ObjectReference from, Boolean includeReplicationMeta, Boolean includeStrategy, Boolean includeTemplate, Boolean includeTriggers, Long revision) {
        super();
        this.from = from;
        this.includeReplicationMeta = includeReplicationMeta;
        this.includeStrategy = includeStrategy;
        this.includeTemplate = includeTemplate;
        this.includeTriggers = includeTriggers;
        this.revision = revision;
    }

    /**
     * DeploymentConfigRollbackSpec represents the options for rollback generation.
     */
    @JsonProperty("from")
    public ObjectReference getFrom() {
        return from;
    }

    /**
     * DeploymentConfigRollbackSpec represents the options for rollback generation.
     */
    @JsonProperty("from")
    public void setFrom(ObjectReference from) {
        this.from = from;
    }

    /**
     * IncludeReplicationMeta specifies whether to include the replica count and selector.
     */
    @JsonProperty("includeReplicationMeta")
    public Boolean getIncludeReplicationMeta() {
        return includeReplicationMeta;
    }

    /**
     * IncludeReplicationMeta specifies whether to include the replica count and selector.
     */
    @JsonProperty("includeReplicationMeta")
    public void setIncludeReplicationMeta(Boolean includeReplicationMeta) {
        this.includeReplicationMeta = includeReplicationMeta;
    }

    /**
     * IncludeStrategy specifies whether to include the deployment Strategy.
     */
    @JsonProperty("includeStrategy")
    public Boolean getIncludeStrategy() {
        return includeStrategy;
    }

    /**
     * IncludeStrategy specifies whether to include the deployment Strategy.
     */
    @JsonProperty("includeStrategy")
    public void setIncludeStrategy(Boolean includeStrategy) {
        this.includeStrategy = includeStrategy;
    }

    /**
     * IncludeTemplate specifies whether to include the PodTemplateSpec.
     */
    @JsonProperty("includeTemplate")
    public Boolean getIncludeTemplate() {
        return includeTemplate;
    }

    /**
     * IncludeTemplate specifies whether to include the PodTemplateSpec.
     */
    @JsonProperty("includeTemplate")
    public void setIncludeTemplate(Boolean includeTemplate) {
        this.includeTemplate = includeTemplate;
    }

    /**
     * IncludeTriggers specifies whether to include config Triggers.
     */
    @JsonProperty("includeTriggers")
    public Boolean getIncludeTriggers() {
        return includeTriggers;
    }

    /**
     * IncludeTriggers specifies whether to include config Triggers.
     */
    @JsonProperty("includeTriggers")
    public void setIncludeTriggers(Boolean includeTriggers) {
        this.includeTriggers = includeTriggers;
    }

    /**
     * Revision to rollback to. If set to 0, rollback to the last revision.
     */
    @JsonProperty("revision")
    public Long getRevision() {
        return revision;
    }

    /**
     * Revision to rollback to. If set to 0, rollback to the last revision.
     */
    @JsonProperty("revision")
    public void setRevision(Long revision) {
        this.revision = revision;
    }

    @JsonIgnore
    public DeploymentConfigRollbackSpecBuilder edit() {
        return new DeploymentConfigRollbackSpecBuilder(this);
    }

    @JsonIgnore
    public DeploymentConfigRollbackSpecBuilder toBuilder() {
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
