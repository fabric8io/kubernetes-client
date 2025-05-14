
package io.fabric8.openshift.api.model;

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
 * A BuildPostCommitSpec holds a build post commit hook specification. The hook executes a command in a temporary container running the build output image, immediately after the last layer of the image is committed and before the image is pushed to a registry. The command is executed with the current working directory ($PWD) set to the image's WORKDIR.<br><p> <br><p> The build will be marked as failed if the hook execution fails. It will fail if the script or command return a non-zero exit code, or if there is any other error related to starting the temporary container.<br><p> <br><p> There are five different ways to configure the hook. As an example, all forms below are equivalent and will execute `rake test --verbose`.<br><p> <br><p> 1. Shell script:<br><p> <br><p> 	   "postCommit": {<br><p> 	     "script": "rake test --verbose",<br><p> 	   }<br><p> <br><p> 	The above is a convenient form which is equivalent to:<br><p> <br><p> 	   "postCommit": {<br><p> 	     "command": ["/bin/sh", "-ic"],<br><p> 	     "args":    ["rake test --verbose"]<br><p> 	   }<br><p> <br><p> 2. A command as the image entrypoint:<br><p> <br><p> 	   "postCommit": {<br><p> 	     "commit": ["rake", "test", "--verbose"]<br><p> 	   }<br><p> <br><p> 	Command overrides the image entrypoint in the exec form, as documented in<br><p> 	Docker: https://docs.docker.com/engine/reference/builder/#entrypoint.<br><p> <br><p> 3. Pass arguments to the default entrypoint:<br><p> <br><p> 	       "postCommit": {<br><p> 			      "args": ["rake", "test", "--verbose"]<br><p> 		      }<br><p> <br><p> 	    This form is only useful if the image entrypoint can handle arguments.<br><p> <br><p> 4. Shell script with arguments:<br><p> <br><p> 	   "postCommit": {<br><p> 	     "script": "rake test $1",<br><p> 	     "args":   ["--verbose"]<br><p> 	   }<br><p> <br><p> 	This form is useful if you need to pass arguments that would otherwise be<br><p> 	hard to quote properly in the shell script. In the script, $0 will be<br><p> 	"/bin/sh" and $1, $2, etc, are the positional arguments from Args.<br><p> <br><p> 5. Command with arguments:<br><p> <br><p> 	   "postCommit": {<br><p> 	     "command": ["rake", "test"],<br><p> 	     "args":    ["--verbose"]<br><p> 	   }<br><p> <br><p> 	This form is equivalent to appending the arguments to the Command slice.<br><p> <br><p> It is invalid to provide both Script and Command simultaneously. If none of the fields are specified, the hook is not executed.
 */
@JsonDeserialize(using = com.fasterxml.jackson.databind.JsonDeserializer.None.class)
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "args",
    "command",
    "script"
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
public class BuildPostCommitSpec implements Editable<BuildPostCommitSpecBuilder>, KubernetesResource
{

    @JsonProperty("args")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private List<String> args = new ArrayList<>();
    @JsonProperty("command")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private List<String> command = new ArrayList<>();
    @JsonProperty("script")
    private String script;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new LinkedHashMap<String, Object>();

    /**
     * No args constructor for use in serialization
     */
    public BuildPostCommitSpec() {
    }

    public BuildPostCommitSpec(List<String> args, List<String> command, String script) {
        super();
        this.args = args;
        this.command = command;
        this.script = script;
    }

    /**
     * args is a list of arguments that are provided to either Command, Script or the container image's default entrypoint. The arguments are placed immediately after the command to be run.
     */
    @JsonProperty("args")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    public List<String> getArgs() {
        return args;
    }

    /**
     * args is a list of arguments that are provided to either Command, Script or the container image's default entrypoint. The arguments are placed immediately after the command to be run.
     */
    @JsonProperty("args")
    public void setArgs(List<String> args) {
        this.args = args;
    }

    /**
     * command is the command to run. It may not be specified with Script. This might be needed if the image doesn't have `/bin/sh`, or if you do not want to use a shell. In all other cases, using Script might be more convenient.
     */
    @JsonProperty("command")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    public List<String> getCommand() {
        return command;
    }

    /**
     * command is the command to run. It may not be specified with Script. This might be needed if the image doesn't have `/bin/sh`, or if you do not want to use a shell. In all other cases, using Script might be more convenient.
     */
    @JsonProperty("command")
    public void setCommand(List<String> command) {
        this.command = command;
    }

    /**
     * script is a shell script to be run with `/bin/sh -ic`. It may not be specified with Command. Use Script when a shell script is appropriate to execute the post build hook, for example for running unit tests with `rake test`. If you need control over the image entrypoint, or if the image does not have `/bin/sh`, use Command and/or Args. The `-i` flag is needed to support CentOS and RHEL images that use Software Collections (SCL), in order to have the appropriate collections enabled in the shell. E.g., in the Ruby image, this is necessary to make `ruby`, `bundle` and other binaries available in the PATH.
     */
    @JsonProperty("script")
    public String getScript() {
        return script;
    }

    /**
     * script is a shell script to be run with `/bin/sh -ic`. It may not be specified with Command. Use Script when a shell script is appropriate to execute the post build hook, for example for running unit tests with `rake test`. If you need control over the image entrypoint, or if the image does not have `/bin/sh`, use Command and/or Args. The `-i` flag is needed to support CentOS and RHEL images that use Software Collections (SCL), in order to have the appropriate collections enabled in the shell. E.g., in the Ruby image, this is necessary to make `ruby`, `bundle` and other binaries available in the PATH.
     */
    @JsonProperty("script")
    public void setScript(String script) {
        this.script = script;
    }

    @JsonIgnore
    public BuildPostCommitSpecBuilder edit() {
        return new BuildPostCommitSpecBuilder(this);
    }

    @JsonIgnore
    public BuildPostCommitSpecBuilder toBuilder() {
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
