
package io.fabric8.openshift.api.model.installer.nutanix.v1;

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
import io.fabric8.kubernetes.api.model.Container;
import io.fabric8.kubernetes.api.model.IntOrString;
import io.fabric8.kubernetes.api.model.KubernetesResource;
import io.fabric8.kubernetes.api.model.LabelSelector;
import io.fabric8.kubernetes.api.model.LocalObjectReference;
import io.fabric8.kubernetes.api.model.ObjectMeta;
import io.fabric8.kubernetes.api.model.ObjectReference;
import io.fabric8.kubernetes.api.model.PersistentVolumeClaim;
import io.fabric8.kubernetes.api.model.PodTemplateSpec;
import io.fabric8.kubernetes.api.model.ResourceRequirements;
import io.fabric8.openshift.api.model.machine.v1.NutanixCategory;
import io.fabric8.openshift.api.model.machine.v1.NutanixResourceIdentifier;
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
    "bootType",
    "categories",
    "coresPerSocket",
    "cpus",
    "memoryMiB",
    "osDisk",
    "project"
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
    @BuildableReference(PersistentVolumeClaim.class)
})
@Generated("jsonschema2pojo")
public class MachinePool implements KubernetesResource
{

    @JsonProperty("bootType")
    private String bootType;
    @JsonProperty("categories")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private List<NutanixCategory> categories = new ArrayList<NutanixCategory>();
    @JsonProperty("coresPerSocket")
    private Long coresPerSocket;
    @JsonProperty("cpus")
    private Long cpus;
    @JsonProperty("memoryMiB")
    private Long memoryMiB;
    @JsonProperty("osDisk")
    private OSDisk osDisk;
    @JsonProperty("project")
    private NutanixResourceIdentifier project;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new LinkedHashMap<String, Object>();

    /**
     * No args constructor for use in serialization
     * 
     */
    public MachinePool() {
    }

    public MachinePool(String bootType, List<NutanixCategory> categories, Long coresPerSocket, Long cpus, Long memoryMiB, OSDisk osDisk, NutanixResourceIdentifier project) {
        super();
        this.bootType = bootType;
        this.categories = categories;
        this.coresPerSocket = coresPerSocket;
        this.cpus = cpus;
        this.memoryMiB = memoryMiB;
        this.osDisk = osDisk;
        this.project = project;
    }

    @JsonProperty("bootType")
    public String getBootType() {
        return bootType;
    }

    @JsonProperty("bootType")
    public void setBootType(String bootType) {
        this.bootType = bootType;
    }

    @JsonProperty("categories")
    public List<NutanixCategory> getCategories() {
        return categories;
    }

    @JsonProperty("categories")
    public void setCategories(List<NutanixCategory> categories) {
        this.categories = categories;
    }

    @JsonProperty("coresPerSocket")
    public Long getCoresPerSocket() {
        return coresPerSocket;
    }

    @JsonProperty("coresPerSocket")
    public void setCoresPerSocket(Long coresPerSocket) {
        this.coresPerSocket = coresPerSocket;
    }

    @JsonProperty("cpus")
    public Long getCpus() {
        return cpus;
    }

    @JsonProperty("cpus")
    public void setCpus(Long cpus) {
        this.cpus = cpus;
    }

    @JsonProperty("memoryMiB")
    public Long getMemoryMiB() {
        return memoryMiB;
    }

    @JsonProperty("memoryMiB")
    public void setMemoryMiB(Long memoryMiB) {
        this.memoryMiB = memoryMiB;
    }

    @JsonProperty("osDisk")
    public OSDisk getOsDisk() {
        return osDisk;
    }

    @JsonProperty("osDisk")
    public void setOsDisk(OSDisk osDisk) {
        this.osDisk = osDisk;
    }

    @JsonProperty("project")
    public NutanixResourceIdentifier getProject() {
        return project;
    }

    @JsonProperty("project")
    public void setProject(NutanixResourceIdentifier project) {
        this.project = project;
    }

    @JsonAnyGetter
    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    @JsonAnySetter
    public void setAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
    }

}
