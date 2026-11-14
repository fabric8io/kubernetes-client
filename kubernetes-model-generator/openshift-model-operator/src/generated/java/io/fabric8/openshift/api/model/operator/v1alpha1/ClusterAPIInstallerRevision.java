
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
import tools.jackson.databind.annotation.JsonDeserialize;

@JsonDeserialize(using = tools.jackson.databind.ValueDeserializer.None.class)
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "components",
    "contentID",
    "manifestSubstitutions",
    "name",
    "revision",
    "unmanagedCustomResourceDefinitions"
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
public class ClusterAPIInstallerRevision implements Editable<ClusterAPIInstallerRevisionBuilder>, KubernetesResource
{

    @JsonProperty("components")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private List<ClusterAPIInstallerComponent> components = new ArrayList<>();
    @JsonProperty("contentID")
    private String contentID;
    @JsonProperty("manifestSubstitutions")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private List<ClusterAPIInstallerRevisionManifestSubstitution> manifestSubstitutions = new ArrayList<>();
    @JsonProperty("name")
    private String name;
    @JsonProperty("revision")
    private Long revision;
    @JsonProperty("unmanagedCustomResourceDefinitions")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private List<String> unmanagedCustomResourceDefinitions = new ArrayList<>();
    @JsonIgnore
    private Map<String, Object> additionalProperties = new LinkedHashMap<String, Object>();

    /**
     * No args constructor for use in serialization
     */
    public ClusterAPIInstallerRevision() {
    }

    public ClusterAPIInstallerRevision(List<ClusterAPIInstallerComponent> components, String contentID, List<ClusterAPIInstallerRevisionManifestSubstitution> manifestSubstitutions, String name, Long revision, List<String> unmanagedCustomResourceDefinitions) {
        super();
        this.components = components;
        this.contentID = contentID;
        this.manifestSubstitutions = manifestSubstitutions;
        this.name = name;
        this.revision = revision;
        this.unmanagedCustomResourceDefinitions = unmanagedCustomResourceDefinitions;
    }

    /**
     * components is a list of components which will be installed by this revision. Components will be installed in the order they are listed. If omitted no components will be installed.<br><p> <br><p> The maximum number of components is 32.
     */
    @JsonProperty("components")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    public List<ClusterAPIInstallerComponent> getComponents() {
        return components;
    }

    /**
     * components is a list of components which will be installed by this revision. Components will be installed in the order they are listed. If omitted no components will be installed.<br><p> <br><p> The maximum number of components is 32.
     */
    @JsonProperty("components")
    public void setComponents(List<ClusterAPIInstallerComponent> components) {
        this.components = components;
    }

    /**
     * contentID uniquely identifies the content of this revision. The contentID must be between 1 and 255 characters long.
     */
    @JsonProperty("contentID")
    public String getContentID() {
        return contentID;
    }

    /**
     * contentID uniquely identifies the content of this revision. The contentID must be between 1 and 255 characters long.
     */
    @JsonProperty("contentID")
    public void setContentID(String contentID) {
        this.contentID = contentID;
    }

    /**
     * manifestSubstitutions is a list of envsubst style substitutions which will be applied to manifests in the revision during rendering. If defined it must not be empty, and may not contain more than 32 items. Each manifest substitution must have a unique key.
     */
    @JsonProperty("manifestSubstitutions")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    public List<ClusterAPIInstallerRevisionManifestSubstitution> getManifestSubstitutions() {
        return manifestSubstitutions;
    }

    /**
     * manifestSubstitutions is a list of envsubst style substitutions which will be applied to manifests in the revision during rendering. If defined it must not be empty, and may not contain more than 32 items. Each manifest substitution must have a unique key.
     */
    @JsonProperty("manifestSubstitutions")
    public void setManifestSubstitutions(List<ClusterAPIInstallerRevisionManifestSubstitution> manifestSubstitutions) {
        this.manifestSubstitutions = manifestSubstitutions;
    }

    /**
     * name is the name of a revision.
     */
    @JsonProperty("name")
    public String getName() {
        return name;
    }

    /**
     * name is the name of a revision.
     */
    @JsonProperty("name")
    public void setName(String name) {
        this.name = name;
    }

    /**
     * revision is a monotonically increasing number that is assigned to a revision.
     */
    @JsonProperty("revision")
    public Long getRevision() {
        return revision;
    }

    /**
     * revision is a monotonically increasing number that is assigned to a revision.
     */
    @JsonProperty("revision")
    public void setRevision(Long revision) {
        this.revision = revision;
    }

    /**
     * unmanagedCustomResourceDefinitions is a list of the names of ClusterResourceDefinition (CRD) objects which are included in this revision, but which should not be installed or updated. If not set, all CRDs in the revision will be managed by the CAPI operator.
     */
    @JsonProperty("unmanagedCustomResourceDefinitions")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    public List<String> getUnmanagedCustomResourceDefinitions() {
        return unmanagedCustomResourceDefinitions;
    }

    /**
     * unmanagedCustomResourceDefinitions is a list of the names of ClusterResourceDefinition (CRD) objects which are included in this revision, but which should not be installed or updated. If not set, all CRDs in the revision will be managed by the CAPI operator.
     */
    @JsonProperty("unmanagedCustomResourceDefinitions")
    public void setUnmanagedCustomResourceDefinitions(List<String> unmanagedCustomResourceDefinitions) {
        this.unmanagedCustomResourceDefinitions = unmanagedCustomResourceDefinitions;
    }

    @JsonIgnore
    public ClusterAPIInstallerRevisionBuilder edit() {
        return new ClusterAPIInstallerRevisionBuilder(this);
    }

    @JsonIgnore
    public ClusterAPIInstallerRevisionBuilder toBuilder() {
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
    @Override
    public boolean equals(Object o) {
        if (o == this) {
            return true;
        }
        if (!(o instanceof ClusterAPIInstallerRevision)) {
            return false;
        }
        ClusterAPIInstallerRevision other = (ClusterAPIInstallerRevision) o;
        if (!other.canEqual(this)) {
            return false;
        }
        Object this$components = this.getComponents();
        Object other$components = other.getComponents();
        if (this$components == null ? other$components != null : !this$components.equals(other$components)) {
            return false;
        }
        Object this$contentID = this.getContentID();
        Object other$contentID = other.getContentID();
        if (this$contentID == null ? other$contentID != null : !this$contentID.equals(other$contentID)) {
            return false;
        }
        Object this$manifestSubstitutions = this.getManifestSubstitutions();
        Object other$manifestSubstitutions = other.getManifestSubstitutions();
        if (this$manifestSubstitutions == null ? other$manifestSubstitutions != null : !this$manifestSubstitutions.equals(other$manifestSubstitutions)) {
            return false;
        }
        Object this$name = this.getName();
        Object other$name = other.getName();
        if (this$name == null ? other$name != null : !this$name.equals(other$name)) {
            return false;
        }
        Object this$revision = this.getRevision();
        Object other$revision = other.getRevision();
        if (this$revision == null ? other$revision != null : !this$revision.equals(other$revision)) {
            return false;
        }
        Object this$unmanagedCustomResourceDefinitions = this.getUnmanagedCustomResourceDefinitions();
        Object other$unmanagedCustomResourceDefinitions = other.getUnmanagedCustomResourceDefinitions();
        if (this$unmanagedCustomResourceDefinitions == null ? other$unmanagedCustomResourceDefinitions != null : !this$unmanagedCustomResourceDefinitions.equals(other$unmanagedCustomResourceDefinitions)) {
            return false;
        }
        Object this$additionalProperties = this.getAdditionalProperties();
        Object other$additionalProperties = other.getAdditionalProperties();
        if (this$additionalProperties == null ? other$additionalProperties != null : !this$additionalProperties.equals(other$additionalProperties)) {
            return false;
        }
        return true;
    }

    protected boolean canEqual(Object other) {
        return other instanceof ClusterAPIInstallerRevision;
    }

    @Override
    public int hashCode() {
        final int prime = 59;
        int result = 1;
        Object $components = this.getComponents();
        result = result * prime + ($components == null ? 43 : $components.hashCode());
        Object $contentID = this.getContentID();
        result = result * prime + ($contentID == null ? 43 : $contentID.hashCode());
        Object $manifestSubstitutions = this.getManifestSubstitutions();
        result = result * prime + ($manifestSubstitutions == null ? 43 : $manifestSubstitutions.hashCode());
        Object $name = this.getName();
        result = result * prime + ($name == null ? 43 : $name.hashCode());
        Object $revision = this.getRevision();
        result = result * prime + ($revision == null ? 43 : $revision.hashCode());
        Object $unmanagedCustomResourceDefinitions = this.getUnmanagedCustomResourceDefinitions();
        result = result * prime + ($unmanagedCustomResourceDefinitions == null ? 43 : $unmanagedCustomResourceDefinitions.hashCode());
        Object $additionalProperties = this.getAdditionalProperties();
        result = result * prime + ($additionalProperties == null ? 43 : $additionalProperties.hashCode());
        return result;
    }

    @Override
    public String toString() {
        return "ClusterAPIInstallerRevision(" + "components=" + this.getComponents() + ", contentID=" + this.getContentID() + ", manifestSubstitutions=" + this.getManifestSubstitutions() + ", name=" + this.getName() + ", revision=" + this.getRevision() + ", unmanagedCustomResourceDefinitions=" + this.getUnmanagedCustomResourceDefinitions() + ", additionalProperties=" + this.getAdditionalProperties() + ")";
    }

}
