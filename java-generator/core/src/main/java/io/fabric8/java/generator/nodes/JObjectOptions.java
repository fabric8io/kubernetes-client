/**
 * Copyright (C) 2015 Red Hat, Inc.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *         http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package io.fabric8.java.generator.nodes;

public class JObjectOptions {
    private boolean preserveUnknownFields;
    private String prefix;
    private String suffix;

    public boolean isPreserveUnknownFields() {
        return preserveUnknownFields;
    }

    public void setPreserveUnknownFields(boolean preserveUnknownFields) {
        this.preserveUnknownFields = preserveUnknownFields;
    }

    public String getPrefix() {
        return prefix;
    }

    public void setPrefix(String prefix) {
        this.prefix = prefix;
    }

    public String getSuffix() {
        return suffix;
    }

    public void setSuffix(String suffix) {
        this.suffix = suffix;
    }

    public JObjectOptions(boolean preserveUnknownFields, String prefix, String suffix) {
        this.preserveUnknownFields = preserveUnknownFields;
        this.prefix = prefix;
        this.suffix = suffix;
    }
}
