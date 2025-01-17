
package io.fabric8.kubernetes.api.model;

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
import io.sundr.builder.annotations.Buildable;
import lombok.EqualsAndHashCode;
import lombok.ToString;
import lombok.experimental.Accessors;

@JsonDeserialize(using = com.fasterxml.jackson.databind.JsonDeserializer.None.class)
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "gid",
    "supplementalGroups",
    "uid"
})
@ToString
@EqualsAndHashCode
@Accessors(prefix = {
    "_",
    ""
})
@Buildable(editableEnabled = false, validationEnabled = false, generateBuilderPackage = false, lazyCollectionInitEnabled = false, builderPackage = "io.fabric8.kubernetes.api.builder")
@Generated("io.fabric8.kubernetes.schema.generator.model.ModelGenerator")
public class LinuxContainerUser implements Editable<LinuxContainerUserBuilder>, KubernetesResource
{

    @JsonProperty("gid")
    private Long gid;
    @JsonProperty("supplementalGroups")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private List<Long> supplementalGroups = new ArrayList<>();
    @JsonProperty("uid")
    private Long uid;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new LinkedHashMap<String, Object>();

    /**
     * No args constructor for use in serialization
     * 
     */
    public LinuxContainerUser() {
    }

    public LinuxContainerUser(Long gid, List<Long> supplementalGroups, Long uid) {
        super();
        this.gid = gid;
        this.supplementalGroups = supplementalGroups;
        this.uid = uid;
    }

    @JsonProperty("gid")
    public Long getGid() {
        return gid;
    }

    @JsonProperty("gid")
    public void setGid(Long gid) {
        this.gid = gid;
    }

    @JsonProperty("supplementalGroups")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    public List<Long> getSupplementalGroups() {
        return supplementalGroups;
    }

    @JsonProperty("supplementalGroups")
    public void setSupplementalGroups(List<Long> supplementalGroups) {
        this.supplementalGroups = supplementalGroups;
    }

    @JsonProperty("uid")
    public Long getUid() {
        return uid;
    }

    @JsonProperty("uid")
    public void setUid(Long uid) {
        this.uid = uid;
    }

    @JsonIgnore
    public LinuxContainerUserBuilder edit() {
        return new LinuxContainerUserBuilder(this);
    }

    @JsonIgnore
    public LinuxContainerUserBuilder toBuilder() {
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
