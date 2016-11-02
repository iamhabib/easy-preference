# Easy Preference [ ![Download](https://api.bintray.com/packages/osongae2/maven/easy-preference/images/download.svg) ](https://bintray.com/osongae2/maven/easy-preference/_latestVersion) 
-------------------

Easy way to put and get data and Object for the shared preferences in Android.

##Usage
-----------

Add below line in app ```build.gradle```
 
```gradle
dependencies {
	compile 'com.iamhabib:easy-preference:1.0.1'
}
```

##Code snippets
---------------

### Preference initialize option ###
You can use default preference name by

```groovy

EasyPreference.with(this)
 
```

Use your own preference name

```groovy

EasyPreference.with(this, "YourPrefName")
 
```

### Adding Value ###
You can add boolean, int, String, long, Set<String>, float 
and another is data object.

```groovy
EasyPreference.with(this)
                .addBoolean("KEY", booleanValue)
                .addString("KEY", stringValue)
                .addInt("KEY", intValue)
                .addObject("KEY", objectValue)
                .save();
```

#### Geting Value ###
```groovy
boolean value=EasyPreference.with(this)
                       .getBoolean("KEY", defaultValue);
```

### Geting Data Object ###
```groovy
MyObject object=EasyPreference.with(this)
                        .getObject("KEY", MyObject.class);
```

### Removing Value ###
```groovy
EasyPreference.with(this)
                .remove("KEY")
		.save();;
```

### Clear All Value ###
```groovy
EasyPreference.with(this)
                .clearAll()
		.save();
```

# N.B #
If you use your own preference name by: 

```groovy

EasyPreference.with(this, "YourPrefName")
 
```

You need to add your preference name in every request like this:

```groovy
EasyPreference.with(this, "YourPrefName")
                .addBoolean("KEY", booleanValue)
                .addString("KEY", stringValue)
                .addInt("KEY", intValue)
                .addObject("KEY", objectValue)
                .save();
```
```groovy
boolean value=EasyPreference.with(this, "YourPrefName")
                       .getBoolean("KEY", defaultValue);
```



##License

Copyright 2016 Habibur Rahman

Licensed under the Apache License, Version 2.0 (the "License");
you may not use this file except in compliance with the License.
You may obtain a copy of the License at

    http://www.apache.org/licenses/LICENSE-2.0

Unless required by applicable law or agreed to in writing, software
distributed under the License is distributed on an "AS IS" BASIS,
WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
See the License for the specific language governing permissions and
limitations under the License.
