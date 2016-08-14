<h1>Intel Multi-OS Engine Samples</h1>

Visit the <a href="https://software.intel.com/en-us/multi-os-engine" target="_blank">Intel Multi-OS Engine</a> page or the <a href="https://github.com/multi-os-engine/multi-os-engine" target="_blank">Github project</a> for more informations.
<br>Further samples from Intel you can find <a href="https://github.com/moe-java-samples/moe-java-samples" target="_blank">here</a>. 

<br>
For all samples using retrofit add to the proguard.cfg (/Applications/Intel/multi_os_engine/tools/proguard.cfg):

-keepattributes *Annotation*

-keep class retrofit.** { *; }

-keepclasseswithmembers class * {

@retrofit.http.* <methods>; }

-keepattributes Signature

<br>
<h2>Samples:</h2>

<ul>

<li><b>RetrofitSample:</b>
Use the same http communication logic in Android and iOS. Define endpoints, services, requests, models, etc. only once and share it. </li>

</ul>
