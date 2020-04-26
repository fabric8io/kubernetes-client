package io.fabric8.kudo.client;

import java.nio.file.Path;

/**
 * @author pangms
 * @date 2020/4/24
 */
public enum PathTypes {
    JSONPatchType("application/json-patch+json"),
    MergePatchType("application/merge-patch+json"),
    StrategicMergePatchType("application/strategic-merge-patch+json"),
    ApplyPatchType("application/apply-patch+yaml")
    ;
    String type;
    PathTypes(String type){
        this.type = type;
    }

    public String getType() {
        return type;
    }
}
