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

import static io.fabric8.java.generator.nodes.Keywords.ADDITIONAL_PROPERTIES;
import static io.fabric8.java.generator.nodes.Keywords.JAVA_UTIL_MAP;

import com.github.javaparser.ast.CompilationUnit;
import com.github.javaparser.ast.Modifier;
import com.github.javaparser.ast.NodeList;
import com.github.javaparser.ast.body.ClassOrInterfaceDeclaration;
import com.github.javaparser.ast.body.EnumDeclaration;
import com.github.javaparser.ast.body.FieldDeclaration;
import com.github.javaparser.ast.body.VariableDeclarator;
import com.github.javaparser.ast.expr.*;
import com.github.javaparser.ast.type.ClassOrInterfaceType;
import io.fabric8.java.generator.exceptions.JavaGeneratorException;
import io.fabric8.kubernetes.api.model.apiextensions.v1.JSONSchemaProps;
import io.fabric8.kubernetes.client.utils.Utils;
import java.util.*;
import java.util.stream.Collectors;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class JObject extends AbstractJSONSchema2Pojo {

    private static final Logger LOGGER = LoggerFactory.getLogger(JObject.class);
    private static final Set<String> IGNORED_FIELDS = new HashSet<>();

    static {
        IGNORED_FIELDS.add("description");
        IGNORED_FIELDS.add("schema");
        IGNORED_FIELDS.add("example");
        IGNORED_FIELDS.add("examples");
    }

    private final String type;
    private final Map<String, AbstractJSONSchema2Pojo> fields;
    private final Set<String> required;
    private JObjectOptions options;

    public JObject(
        String type,
        Map<String, JSONSchemaProps> fields,
        List<String> required,
        JObjectOptions options) {
        this(type, fields, required, options, null);
    }
    
    public JObject(
            String type,
            Map<String, JSONSchemaProps> fields,
            List<String> required,
            JObjectOptions options,
            String description) {

        super(description);

        this.options = options;
        this.required =
                new HashSet<>(Optional.ofNullable(required).orElse(Collections.emptyList()));
        this.fields = new HashMap<>();

        String nextPrefix = options.getPrefix();
        String nextSuffix = options.getSuffix();

        if (type.toLowerCase(Locale.ROOT).equals("spec")) {
            nextPrefix = "";
            nextSuffix = "Spec";
        }

        this.type =
                AbstractJSONSchema2Pojo.sanitizeString(
                        options.getPrefix()
                                + type.substring(0, 1).toUpperCase()
                                + type.substring(1)
                                + options.getSuffix());

        if (fields == null) {
            // no fields
        } else {
            for (Map.Entry<String, JSONSchemaProps> field : fields.entrySet()) {
                if (!IGNORED_FIELDS.contains(field.getKey()))
                    this.fields.put(
                            field.getKey(),
                            AbstractJSONSchema2Pojo.fromJsonSchema(
                                    field.getKey(), field.getValue(), nextPrefix, nextSuffix));
            }
        }
    }

    @Override
    public String getType() {
        return this.type;
    }

    @Override
    public GeneratorResult generateJava(CompilationUnit cu) {
        ClassOrInterfaceDeclaration clz = cu.getClassByName(this.type).orElse(null);

        if (clz != null) {
            // TODO: investigate a more nested structure for the generated code
            LOGGER.warn(
                    "A class named {} has been already processed, if this class has multiple implementations the resulting code might be incorrect",
                    this.type);
            return new GeneratorResult();
        }

        clz = cu.addClass(this.type);

        clz.addAnnotation(
                new SingleMemberAnnotationExpr(
                        new Name("com.fasterxml.jackson.annotation.JsonInclude"),
                        new NameExpr(
                                "com.fasterxml.jackson.annotation.JsonInclude.Include.NON_NULL")));

        List<String> sortedFields =
                this.fields.keySet().stream().sorted().collect(Collectors.toList());
        StringBuilder sb = new StringBuilder();
        sb.append("{");
        while (!sortedFields.isEmpty()) {
            sb.append("\"" + sortedFields.remove(0) + "\"");
            if (!sortedFields.isEmpty()) {
                sb.append(",");
            }
        }
        sb.append("}");

        clz.addAnnotation(
                new SingleMemberAnnotationExpr(
                        new Name("com.fasterxml.jackson.annotation.JsonPropertyOrder"),
                        new NameExpr(sb.toString())));

        clz.addAnnotation(
                new SingleMemberAnnotationExpr(
                        new Name("com.fasterxml.jackson.databind.annotation.JsonDeserialize"),
                        new NameExpr(
                                "using = com.fasterxml.jackson.databind.JsonDeserializer.None.class")));

        clz.addAnnotation("lombok.ToString");
        clz.addAnnotation("lombok.EqualsAndHashCode");
        clz.addAnnotation("lombok.Setter");

        clz.addAnnotation(
                new SingleMemberAnnotationExpr(
                        new Name("lombok.experimental.Accessors"),
                        new NameExpr("prefix = {\n" + "    \"_\",\n" + "    \"\"\n" + "}")));

        clz.addAnnotation(
                new SingleMemberAnnotationExpr(
                        new Name("io.sundr.builder.annotations.Buildable"),
                        new NameExpr(
                                "editableEnabled = false, validationEnabled = false, generateBuilderPackage = false, builderPackage = \"io.fabric8.kubernetes.api.builder\", refs = {\n"
                                        + "    @io.sundr.builder.annotations.BuildableReference(io.fabric8.kubernetes.api.model.ObjectMeta.class),\n"
                                        + "    @io.sundr.builder.annotations.BuildableReference(io.fabric8.kubernetes.api.model.ObjectReference.class),\n"
                                        + "    @io.sundr.builder.annotations.BuildableReference(io.fabric8.kubernetes.api.model.LabelSelector.class),\n"
                                        + "    @io.sundr.builder.annotations.BuildableReference(io.fabric8.kubernetes.api.model.Container.class),\n"
                                        + "    @io.sundr.builder.annotations.BuildableReference(io.fabric8.kubernetes.api.model.EnvVar.class),\n"
                                        + "    @io.sundr.builder.annotations.BuildableReference(io.fabric8.kubernetes.api.model.ContainerPort.class),\n"
                                        + "    @io.sundr.builder.annotations.BuildableReference(io.fabric8.kubernetes.api.model.Volume.class),\n"
                                        + "    @io.sundr.builder.annotations.BuildableReference(io.fabric8.kubernetes.api.model.VolumeMount.class)\n"
                                        + "}")));

        clz.addImplementedType("io.fabric8.kubernetes.api.model.KubernetesResource");

        if (this.options.isPreserveUnknownFields()) {
            if (!clz.getFieldByName(ADDITIONAL_PROPERTIES).isPresent()) {
                ClassOrInterfaceType mapType =
                        new ClassOrInterfaceType()
                                .setName(JAVA_UTIL_MAP)
                                .setTypeArguments(
                                        new ClassOrInterfaceType().setName("String"),
                                        new ClassOrInterfaceType().setName("Object"));
                FieldDeclaration objField =
                        clz.addField(mapType, ADDITIONAL_PROPERTIES, Modifier.Keyword.PRIVATE);
                objField.setVariables(
                        new NodeList<>(
                                new VariableDeclarator()
                                        .setName(ADDITIONAL_PROPERTIES)
                                        .setType(mapType)
                                        .setInitializer(
                                                "new java.util.HashMap<String, Object>()")));

                objField.addAnnotation("com.fasterxml.jackson.annotation.JsonIgnore");

                objField.createGetter()
                        .addAnnotation("com.fasterxml.jackson.annotation.JsonAnyGetter");
                objField.createSetter()
                        .addAnnotation("com.fasterxml.jackson.annotation.JsonAnySetter");
            } else {
                // Warning ???
            }
        }

        List<String> buffer = new ArrayList<>(this.fields.size() + 1);

        // CU to expand inner Enums
        CompilationUnit supportCU = new CompilationUnit();
        List<String> sortedKeys =
                this.fields.keySet().stream().sorted().collect(Collectors.toList());
        for (String k : sortedKeys) {
            AbstractJSONSchema2Pojo prop = this.fields.get(k);
            boolean isRequired = this.required.contains(k);

            GeneratorResult gr = prop.generateJava(supportCU);

            // For now the inner types are only for enums
            if (!gr.getInnerClasses().isEmpty()) {
                for (String enumName : gr.getInnerClasses()) {
                    Optional<EnumDeclaration> ed = supportCU.getEnumByName(enumName);
                    if (ed.isPresent()) {
                        clz.addMember(ed.get());
                    }
                }
            }

            gr = prop.generateJava(cu);
            buffer.addAll(gr.getTopLevelClasses());

            String originalFieldName = k;
            String fieldName = AbstractJSONSchema2Pojo.sanitizeString(k);
            String fieldType = AbstractJSONSchema2Pojo.sanitizeString(prop.getType());

            if (!clz.getFieldByName(fieldName).isPresent()) {
                try {
                    FieldDeclaration objField =
                            clz.addField(fieldType, fieldName, Modifier.Keyword.PRIVATE);
                    objField.addAnnotation(
                            new SingleMemberAnnotationExpr(
                                    new Name("com.fasterxml.jackson.annotation.JsonProperty"),
                                    new StringLiteralExpr(originalFieldName)));

                    if (isRequired) {
                        objField.addAnnotation("javax.validation.constraints.NotNull");
                    }

                    objField.createGetter();
                    objField.createSetter();

                    if (Utils.isNotNullOrEmpty(prop.getDescription())) {
                      objField.setJavadocComment(prop.getDescription());
                    }
                } catch (Exception cause) {
                    throw new JavaGeneratorException(
                            "Error generating field " + fieldName + " with type " + prop.getType(),
                            cause);
                }
            } else {
                // Warning ???
            }
        }
        buffer.add(this.type);

        return new GeneratorResult(buffer);
    }
}
