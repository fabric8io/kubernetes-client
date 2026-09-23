
package io.fabric8.openshift.api.model.operator.v1alpha1;

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
import tools.jackson.databind.annotation.JsonDeserialize;

/**
 * ClusterAPIStatus describes the current state of the capi-operator.
 */
@JsonDeserialize(using = tools.jackson.databind.ValueDeserializer.None.class)
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "currentRevision",
    "desiredRevision",
    "observedRevisionGeneration",
    "revisions"
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
public class ClusterAPIStatus implements Editable<ClusterAPIStatusBuilder>, KubernetesResource
{

    @JsonProperty("currentRevision")
    private String currentRevision;
    @JsonProperty("desiredRevision")
    private String desiredRevision;
    @JsonProperty("observedRevisionGeneration")
    private Long observedRevisionGeneration;
    @JsonProperty("revisions")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private List<ClusterAPIInstallerRevision> revisions = new ArrayList<>();
    @JsonIgnore
    private Map<String, Object> additionalProperties = new LinkedHashMap<String, Object>();

    /**
     * No args constructor for use in serialization
     */
    public ClusterAPIStatus() {
    }

    public ClusterAPIStatus(String currentRevision, String desiredRevision, Long observedRevisionGeneration, List<ClusterAPIInstallerRevision> revisions) {
        super();
        this.currentRevision = currentRevision;
        this.desiredRevision = desiredRevision;
        this.observedRevisionGeneration = observedRevisionGeneration;
        this.revisions = revisions;
    }

    /**
     * currentRevision is the name of the most recently fully applied revision. It is written by the installer controller. If it is absent, it indicates that no revision has been fully applied yet. If set, currentRevision must correspond to an entry in the revisions list.
     */
    @JsonProperty("currentRevision")
    public String getCurrentRevision() {
        return currentRevision;
    }

    /**
     * currentRevision is the name of the most recently fully applied revision. It is written by the installer controller. If it is absent, it indicates that no revision has been fully applied yet. If set, currentRevision must correspond to an entry in the revisions list.
     */
    @JsonProperty("currentRevision")
    public void setCurrentRevision(String currentRevision) {
        this.currentRevision = currentRevision;
    }

    /**
     * desiredRevision is the name of the desired revision. It is written by the revision controller. It must be set to the name of the entry in the revisions list with the highest revision number.
     */
    @JsonProperty("desiredRevision")
    public String getDesiredRevision() {
        return desiredRevision;
    }

    /**
     * desiredRevision is the name of the desired revision. It is written by the revision controller. It must be set to the name of the entry in the revisions list with the highest revision number.
     */
    @JsonProperty("desiredRevision")
    public void setDesiredRevision(String desiredRevision) {
        this.desiredRevision = desiredRevision;
    }

    /**
     * observedRevisionGeneration is the generation of the ClusterAPI object that was last observed by the revision controller. If specified it must be greater than or equal to 1, and less than 2^53. It may not decrease or be unset once set.
     */
    @JsonProperty("observedRevisionGeneration")
    public Long getObservedRevisionGeneration() {
        return observedRevisionGeneration;
    }

    /**
     * observedRevisionGeneration is the generation of the ClusterAPI object that was last observed by the revision controller. If specified it must be greater than or equal to 1, and less than 2^53. It may not decrease or be unset once set.
     */
    @JsonProperty("observedRevisionGeneration")
    public void setObservedRevisionGeneration(Long observedRevisionGeneration) {
        this.observedRevisionGeneration = observedRevisionGeneration;
    }

    /**
     * revisions is a list of all currently active revisions. A revision is active until the installer controller updates currentRevision to a later revision. It is written by the revision controller.<br><p> <br><p> The maximum number of revisions is 16. All revisions must have a unique name. All revisions must have a unique revision number. When adding a revision, the revision number must be greater than the highest revision number in the list. Revisions are immutable, although they can be deleted.
     */
    @JsonProperty("revisions")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    public List<ClusterAPIInstallerRevision> getRevisions() {
        return revisions;
    }

    /**
     * revisions is a list of all currently active revisions. A revision is active until the installer controller updates currentRevision to a later revision. It is written by the revision controller.<br><p> <br><p> The maximum number of revisions is 16. All revisions must have a unique name. All revisions must have a unique revision number. When adding a revision, the revision number must be greater than the highest revision number in the list. Revisions are immutable, although they can be deleted.
     */
    @JsonProperty("revisions")
    public void setRevisions(List<ClusterAPIInstallerRevision> revisions) {
        this.revisions = revisions;
    }

    @JsonIgnore
    public ClusterAPIStatusBuilder edit() {
        return new ClusterAPIStatusBuilder(this);
    }

    @JsonIgnore
    public ClusterAPIStatusBuilder toBuilder() {
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
