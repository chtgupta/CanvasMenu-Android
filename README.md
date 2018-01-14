# CanvasMenu

> A minimal replacement of Menus, Navigation drawers and Toolsets.

> API 21 (Android Lollipop 5.0)

![](ic_launcher.png)

A simple, lightweight and easy to use Android library with lots of customizations.
Ideal for minimal design, making complex UI easier to maintain.
Give your app a brand new menu, coz drawers are too mainstream.

Read instructions before implementing into your project.
It is the initial build so don't expect any more than what's documented.
More features and flexibility will be added in upcoming builds.

All the options/views shown in the menu are for demonstration purpose only and do not have any relation with the library itself.
CanvasMenu has as may implementations as you can imagine.
Use it as a navigation drawer, toolset or just a menu, choice is yours.

![](screen.gif)

## Installation


### Gradle:

Step 1. Add the JitPack repository to your build file
        Add it in your root build.gradle at the end of repositories

```sh
allprojects {
		repositories {
			...
			maven { url 'https://jitpack.io' }
		}
	}
```

Step 2. Add the dependency

```sh
	dependencies {
	        compile 'com.github.ChahatGupta:CanvasMenu-Android:0.3'
	}
```


### Maven:

Step 1. Add the JitPack repository to your build file

```sh
	<repositories>
		<repository>
		    <id>jitpack.io</id>
		    <url>https://jitpack.io</url>
		</repository>
	</repositories>
```

Step 2. Add the dependency

```sh
	<dependency>
	    <groupId>com.github.ChahatGupta</groupId>
	    <artifactId>CanvasMenu-Android</artifactId>
	    <version>0.3</version>
	</dependency>
```



## Elements

> Don't forget to read the ``Keep in mind`` section before implementations

## 1. Quarter (the menu UI) : 

### Usage

Add this to your XML layout file

```sh
<believe.cht.canvasmenu.Quarter
        android:id="@+id/quarter"
        android:layout_width="400dp"
        android:layout_height="400dp">

        <!-- add your views here -->

    </believe.cht.canvasmenu.Quarter>
```

### Attribules

```sh

        app:canvasColor="@color/yourColor"
        app:canvasOpeningSpeed="400"
        app:canvasClosingSpeed="400"
        app:closeIcon="@drawable/yourDrawable"

```

### Methods/Functions

```sh

showCanvas()                             //void - opens up the menu
hideCanvas()                             //void - closes the menu
setColor(int color)                      //void - changes canvas color (use only 8 digit color codes)
setCloseIcon(@DrawableRes int closeIcon) //void - changes close icon
setCanvasOpeningSpeed(int openingSpeed)  //void - changes canvas opening speed
setCanvasClosingSpeed(int closingSpeed)  //void - changes canvas closing speed
isOpen()                                 //boolean - returns menu state (open or closed) 


```


## 2. CanvasButton (optional but recommended) :

### Usage

Add this to your XML layout file

```sh

<believe.cht.canvasmenu.CanvasButton
        android:id="@+id/canvas_button"
        android:layout_width="wrap_content"
        android:layout_height="wrap_content" />
        
```

And in Java:

```sh

public class MainActivity extends AppCompatActivity {

    Quarter quarter;
    CanvasButton canvasButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        quarter = (Quarter) findViewById(R.id.quarter);
        canvasButton = (CanvasButton) findViewById(R.id.canvas_button);
        
        canvasButton.setCanvas(quarter); //mandatory step if using CanvasButton

    }
}

```

### Attributes

```sh
        app:buttonIcon="@drawable/yourDrawable"
        app:buttonColor="@color/yourColor"
```

### Methods/Functions

```sh

setCanvas(final Quarter quarter)         //void - attaches canvas to the button (mandatory)
setColor(int color)                      //void - changes button color (use only 8 digit color codes)
setIcon(@DrawableRes int icon)           //void - changes the button icon

```

## Keep in mind

* Use a FrameLayout as root for CanvasButton and Quarter widgets so they can overlap other views
* Keep width and height of Quarter same for best perfornamce
* Leave the height and width of CanvasButton at wrap_content until I make serious updates for it
* Always use 8 digit color codes while setting colors programatically
* Don't forget to call the CanvasButton.setCanvas(Quarter quarter) method while using CanvasButton widget
* Don't forget to call the Quarter.hideCanvas() methid in the onCreate
* Remove the ActionBar if possible, looks a lot better
* Support for backwards compatibility will be added in upcoming versions
* This is the initial build and lacks features to alter UI elemet positions, stay tuned, everything will be available soon

Happy compiling!

## Bugs

Found some? Make sure to read the ``Keep in mind`` section first, if you still feel there's something I need to know, feel free to create an issue.

## Release History

* 0.2
    * CHANGE: Fixed errors in test apk
* 0.2
    * CHANGE: Added missing files and attributes to the initial build
* 0.1
    * CHANGE: Initial build

## Meta

Chahat Gupta – [@i_m_cht](https://twitter.com/i_m_cht) – admin@believe-labs.co

Distributed under the Apache 2.0 license. See ``LICENSE`` for more information.

[https://github.com/ChahatGupta/CanvasMenu](https://github.com/ChahatGupta/)
