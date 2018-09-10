# Infinite Pops
The App for displaying list feed items loaded from the given url. 

My approach
------------------------------------
Applied the new technology Android component architecture with design pattern MVVM. Also I applied Data binding for displaying data on layouts. Moreover, I also used Retrofit 2, RxJava2, Gson libraries for handling api requests. 


Libraries used on the sample project
------------------------------------
* [Android Component Architecture](https://developer.android.com/topic/libraries/architecture/)
* [AppCompat, CardView, RecyclerView an DesignLibrary](http://developer.android.com/intl/es/tools/support-library/index.html)
* [Data binding](https://developer.android.com/topic/libraries/data-binding/)
* [Retrofit 2](http://square.github.io/retrofit/)
* [RxJava2 & RxAndroid](https://github.com/ReactiveX/RxAndroid)
* [Glide] (https://github.com/bumptech/glide)


Limitations
------------------------------------
* There are some fields with undefined data such as stickerPositions, rejamOf, subItems, richContent. Actually, I dont see those fields mentioned in the requirement, I did not use them for displaying on UI. 
* UI is still simple, not pretty.
* Due to limited time, I have not developed the source code more structure with integrating Room for local database and also implement Base class such as BaseActivity, BaseModel, BaseRespository BaseService... These base class will be handled for common methods for sub class use. 
* I have not handled for displaying UI on multiple screen and multiple languages. 
* Also I have not implemented unit test, instrumented test.




