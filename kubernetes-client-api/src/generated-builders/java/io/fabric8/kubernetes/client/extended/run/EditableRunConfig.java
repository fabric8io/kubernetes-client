package io.fabric8.kubernetes.client.extended.run;

import io.fabric8.kubernetes.api.builder.Editable;
import io.fabric8.kubernetes.api.model.Quantity;
import java.lang.Object;
import java.lang.String;
import java.lang.SuppressWarnings;
import java.util.List;
import java.util.Map;

/**
 * Generated
 */
public class EditableRunConfig extends RunConfig implements Editable<RunConfigBuilder>{

  
  @SuppressWarnings({"java:S107"})
  public EditableRunConfig(String name,String image,String imagePullPolicy,String command,List<String> args,String restartPolicy,String serviceAccount,Map<String,String> labels,Map<String,String> env,Map<String,Quantity> limits,Map<String,Quantity> requests,int port) {
    super(name, image, imagePullPolicy, command, args, restartPolicy, serviceAccount, labels, env, limits, requests, port);
  }

  public RunConfigBuilder edit() {
    return new RunConfigBuilder(this);
  }
  
}