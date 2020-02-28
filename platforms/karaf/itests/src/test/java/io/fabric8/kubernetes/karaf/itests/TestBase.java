/**
 * Copyright (C) 2015 Fabric8 Authors.
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
package io.fabric8.kubernetes.karaf.itests;

import org.junit.Assert;

import java.io.File;
import java.net.URISyntaxException;

public class TestBase {

    private static final String FEATURES_XML = "features.xml";

    static File getFeaturesFile() throws URISyntaxException {
        String featuresXml = System.getProperty(FEATURES_XML);
        Assert.assertNotNull(featuresXml);
        File featuresFile = new File(featuresXml);
        Assert.assertNotNull(featuresFile.exists());
        return featuresFile;
    }

}
