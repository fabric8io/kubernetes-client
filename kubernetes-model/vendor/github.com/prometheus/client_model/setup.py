#!/usr/bin/python
#
# Copyright (C) 2015 Red Hat, Inc.
#
# Licensed under the Apache License, Version 2.0 (the "License");
# you may not use this file except in compliance with the License.
# You may obtain a copy of the License at
#
#         http://www.apache.org/licenses/LICENSE-2.0
#
# Unless required by applicable law or agreed to in writing, software
# distributed under the License is distributed on an "AS IS" BASIS,
# WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
# See the License for the specific language governing permissions and
# limitations under the License.
#


from setuptools import setup

setup(
    name = 'prometheus_client_model',
    version = '0.0.1',
    author = 'Matt T. Proud',
    author_email = 'matt.proud@gmail.com',
    description = 'Data model artifacts for the Prometheus client.',
    license = 'Apache License 2.0',
    url = 'http://github.com/prometheus/client_model',
    packages = ['prometheus', 'prometheus/client', 'prometheus/client/model'],
    package_dir = {'': 'python'},
    requires = ['protobuf(==2.4.1)'],
    platforms = 'Platform Independent',
    classifiers = ['Development Status :: 3 - Alpha',
                   'Intended Audience :: Developers',
                   'Intended Audience :: System Administrators',
                   'License :: OSI Approved :: Apache Software License',
                   'Operating System :: OS Independent',
                   'Topic :: Software Development :: Testing',
                   'Topic :: System :: Monitoring'])
