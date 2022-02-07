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
package io.fabric8.java.generator.maven.plugin;

import io.fabric8.java.generator.CRGeneratorRunner;
import io.fabric8.java.generator.Config;
import java.io.File;
import org.apache.maven.plugin.AbstractMojo;
import org.apache.maven.plugins.annotations.LifecyclePhase;
import org.apache.maven.plugins.annotations.Mojo;
import org.apache.maven.plugins.annotations.Parameter;
import org.apache.maven.project.MavenProject;

@Mojo(name = "generate", defaultPhase = LifecyclePhase.GENERATE_SOURCES)
public class JavaGeneratorMojo extends AbstractMojo {

    @Parameter(defaultValue = "${project}")
    private MavenProject project;

    // TODO: Modify CRGeneratorRunner to allow passing in a directory too
    @Parameter(property = "fabric8.java-generator.source", required = true)
    File crdFile;

    @Parameter(
            property = "fabric8.java-generator.target",
            defaultValue = "${basedir}/target/generated-sources/java")
    File targetDirectory;

    @Parameter(property = "fabric8.java-generator.enum-uppercase", required = false)
    Boolean enumUppercase = null;

    @Override
    public void execute() {
        final Config config = new Config(enumUppercase);
        final CRGeneratorRunner runner = new CRGeneratorRunner(config);
        runner.run(crdFile, targetDirectory);
        project.addCompileSourceRoot(targetDirectory.getAbsolutePath());
    }
}
